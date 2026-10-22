package com.byted.cast.sdk.render.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.sdk.IRTCEngineEventListener;
import com.byted.cast.sdk.RTCSetting;
import com.byted.cast.sdk.utils.Utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class VideoPlayer implements VideoJitterBufferCallback {
    private static final String TAG = "VideoPlayer";
    private boolean bInited;
    private ContextManager.CastContext mCastContext;
    private RTCSetting.VCODEC_ID mCodecId;
    private long mFrameIndexIn;
    private FrameMap mFrameMap;
    private golomb mGolomb;
    private int mHeight;
    private IRTCEngineEventListener mListener;
    private CastLogger mLogger;
    private MediaCodec mMediaCodec;
    private String mUserId;
    private IVideoFrameListener mVideoFrameListener;
    private boolean mWaitNextIDR;
    private int mWidth;

    public void startPlay() {
        this.mLogger.i(TAG, "startPlay...");
    }

    public void stopPlay() {
        this.mLogger.i(TAG, "stopPlay...");
        VideoJitterBuffer.getInstance().stop();
        MediaCodec r0 = this.mMediaCodec;
        if (r0 == null) goto L5;
        r0.release();
        this.mMediaCodec = null;
    L5:
        this.bInited = false;
    }

    public boolean isInit() {
        return this.bInited;
    }

    @Override // com.byted.cast.sdk.render.video.VideoJitterBufferCallback
    public void onOutputFrame(long r10) {
        this.mLogger.i(TAG, "onOutputFrame, pts:" + r10);
        if (this.mVideoFrameListener == null) goto L10;
        long r0 = this.mFrameMap.findOnly(r10);
        if (r0 >= 0) goto L8;
        this.mLogger.e(TAG, "onOutputFrame, Ignore output buffer because unknown frameIndex. pts=" + r10);
        return;
    L8:
        this.mVideoFrameListener.onDecoded(this.mUserId, r0);
        return;
    }

    @Override // com.byted.cast.sdk.render.video.VideoJitterBufferCallback
    public void onRenderFrame(long r10) {
        this.mLogger.i(TAG, "onRenderFrame, pts:" + r10);
        if (this.mVideoFrameListener == null) goto L10;
        long r0 = this.mFrameMap.find(r10);
        if (r0 >= 0) goto L8;
        this.mLogger.e(TAG, "onRenderFrame, Ignore output buffer because unknown frameIndex. pts=" + r10);
        return;
    L8:
        this.mVideoFrameListener.onRendered(this.mUserId, r0);
        return;
    }

    public void setVideoFrameListener(IVideoFrameListener r1) {
        this.mVideoFrameListener = r1;
    }

    private void pushInputBuffer(long r10, long r11) {
        IVideoFrameListener r0 = this.mVideoFrameListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r10 <= 0) goto L9;
        r0.onDecodeIn(this.mUserId, r11);
        this.mFrameMap.put(r10, r11);
        return;
    }

    @Override // com.byted.cast.sdk.render.video.VideoJitterBufferCallback
    public void onVideoSize(int r10, int r11) {
        this.mLogger.i(TAG, "onVideoSize, w=" + r10 + " h=" + r11);
    }

    public void queueBuffer(byte[] r10, long r11) {
        SPS r0 = this.mGolomb.Parse(r10, this.mCodecId);
        if (r0.bVaild == false) goto L10;
        int r1 = this.mWidth;
        int r12 = r0.width;
        if (r1 == r12) goto L7;
    L8:
        this.mWidth = r12;
        int r13 = r0.height;
        this.mHeight = r13;
        this.mListener.OnVideoSizeChanged(this.mUserId, r12, r13, 0);
        goto L10
    L7:
        if (this.mHeight != r0.height) goto L8;
    L10:
        if (this.mMediaCodec != null) goto L13;
        this.mLogger.e(TAG, "dequeueInputBuffer, but mMediaCodec is null");
        return;
    L13:
        this.mLogger.v(TAG, "VideoJitterBuffer queueBuffer...dataLen=" + r10.length + " pts=" + r11 + " sps.bVaild=" + r0.bVaild);
        long r14 = r11 * 1000;
        VideoJitterBuffer.getInstance().append(r10, r14, r0.bVaild);
        if (this.mVideoFrameListener == null) goto L29;
        NAL r15 = new NAL(r10, r10.length, this.mCodecId);
        NAL.detectNALType(r15);
        int r16 = r15.type;
        if (r16 != 7) goto L19;
        this.mWaitNextIDR = false;
        this.mLogger.i(TAG, "Feed codec config. Size=" + r15.length + ", last FrameIndex=" + this.mFrameIndexIn);
        pushInputBuffer(0, this.mFrameIndexIn);
        return;
    L19:
        if (r16 != 6) goto L22;
        this.mLogger.i(TAG, "Feed SEI data. Size=" + r15.length + ", last FrameIndex=" + this.mFrameIndexIn);
        pushInputBuffer(0, this.mFrameIndexIn);
        return;
    L22:
        if (r16 != 5) goto L25;
        this.mFrameIndexIn++;
        this.mLogger.i(TAG, "Feed IDR-Frame. Size=" + r15.length + ", PresentationTimeUs=" + r14 + ", frameIndex=" + this.mFrameIndexIn);
        pushInputBuffer(r14, this.mFrameIndexIn);
        return;
    L25:
        if (this.mWaitNextIDR == false) goto L27;
        this.mLogger.i(TAG, "Ignoring P-Frame, last frameIndex=" + this.mFrameIndexIn);
        return;
    L27:
        this.mFrameIndexIn++;
        this.mLogger.i(TAG, "Feed P-Frame. Size=" + r15.length + ", PresentationTimeUs=" + r14 + ", frameIndex=" + this.mFrameIndexIn);
        pushInputBuffer(r14, this.mFrameIndexIn);
        return;
    }

    public VideoPlayer(String r10, ContextManager.CastContext r11, IRTCEngineEventListener r12) {
        this.mMediaCodec = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.bInited = false;
        this.mFrameIndexIn = 0;
        this.mWaitNextIDR = false;
        this.mCastContext = r11;
        CastLogger r13 = ContextManager.getLogger(r11);
        this.mLogger = r13;
        r13.i(TAG, "VideoPlayer ctor:" + r10);
        this.mUserId = r10;
        this.mListener = r12;
        this.mFrameMap = new FrameMap();
        this.mGolomb = new golomb(this.mCastContext);
    }

    public void init(Surface r10, RTCSetting.VCODEC_ID r11, byte[] r12) {
        this.mLogger.i(TAG, "init...");
        SPS r13 = this.mGolomb.Parse(r12, r11);
        if (r13.bVaild == false) goto L9;
        int r0 = this.mWidth;
        int r14 = r13.width;
        if (r0 == r14) goto L7;
    L8:
        this.mWidth = r14;
        int r15 = r13.height;
        this.mHeight = r15;
        this.mListener.OnVideoSizeChanged(this.mUserId, r14, r15, 0);
        goto L9
    L7:
        if (this.mHeight != r13.height) goto L8;
    L9:
        this.mCodecId = r11;
        if (r11 != RTCSetting.VCODEC_ID.H264) goto L12;
        String r16 = "video/avc";
    L13:
        this.mLogger.i(TAG, "init  width=" + this.mWidth + " height=" + this.mHeight + " codec is " + r16);
        MediaFormat r17 = MediaFormat.createVideoFormat(r16, this.mWidth, this.mHeight);
        if (Utils.getProperty("ro.product.name", "", this.mCastContext).equalsIgnoreCase("darwin") == false) goto L23;
        r17.setFloat("operating-rate", 480.0f);
        r17.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        r17.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
        this.mLogger.i(TAG, "mMediaCodec.configure, enable darwin lowlatency");
    L23:
        MediaCodec r18 = MediaCodec.createDecoderByType(r16);     // Catch: Exception -> L20
        this.mMediaCodec = r18;     // Catch: Exception -> L20
        r18.configure(r17, r10, null, 0);     // Catch: Exception -> L20
        this.mMediaCodec.start();     // Catch: Exception -> L20
        VideoJitterBuffer.getInstance().setMediaCodec(this.mMediaCodec, new MediaCodec.BufferInfo()).setJitterCallback(this);
        VideoJitterBuffer.getInstance().start();
        this.bInited = true;
        this.mLogger.i(TAG, "init bInited:" + this.bInited);
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        this.mMediaCodec = null;
        this.mLogger.e(TAG, "mMediaCodec.configure error" + e.toString());
        return;
    L12:
        r16 = "video/hevc";
        goto L13
    }
}
