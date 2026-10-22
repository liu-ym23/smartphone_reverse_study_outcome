package com.lynx.canvas.recorder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import android.os.Build;
import android.text.TextUtils;
import android.util.Range;
import android.view.Surface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonMediaRecorder;
import com.lynx.canvas.camera.CameraSize;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f06.b;
import f06.d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class KryptonDefaultMediaRecorder implements KryptonMediaRecorder {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final String[] ENCODER_BLACK_LIST = null;
    private static final long MIN_INTERVAL = 8000;
    public static final String TAG = "KryptonMediaRecorder";
    public static final String VIDEO_MIME_TYPE = "video/avc";
    private int mAllTrackCount;
    private int mAudioBPS;
    private MediaCodec.BufferInfo mAudioBufferInfo;
    private int mAudioChannelCount;
    private MediaCodec mAudioMediaCodecEncoder;
    private long mAudioPresentationTimeUs;
    private int mAudioSampleRate;
    private long mAudioSamples;
    private int mAudioTrackIndex;
    private int mBPS;
    private ArrayList<String> mCachedPaths;
    private long[] mClipTimeArray;
    private final Delegate mDelegate;
    private int mFPS;
    private int mHeight;
    private final Invoker mInvoker;
    private long mLastPauseTime;
    private long mLastVideoTime;
    private KryptonMediaRecorder.Listener mListener;
    private int mMaxDuration;
    private MediaMuxer mMediaMuxer;
    private String mMimeType;
    private boolean mMuxerStarted;
    private boolean mPaused;
    private long mPausedTime;
    private boolean mRunning;
    private long mStartTime;
    private boolean mToAdjustVideoConfig;
    private int mTrackCount;
    private boolean mUseAudio;
    private MediaCodec.BufferInfo mVideoBufferInfo;
    private Surface mVideoInputSurface;
    private MediaCodec mVideoMediaCodecEncoder;
    private String mVideoOutputPath;
    private String mVideoOutputUrl;
    private String mVideoRangeLogString;
    private int mVideoTrackIndex;
    private int mWidth;

    /* JADX INFO: renamed from: com.lynx.canvas.recorder.KryptonDefaultMediaRecorder$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy = null;

        static {
            int[] r0 = new int[VideoFileManagementPolicy.values().length];
            $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy = r0;
            r0[VideoFileManagementPolicy.FORCE_DELETE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy[VideoFileManagementPolicy.FORCE_KEEP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class ClipVideoTimeRanges {
        public Item[] itemArray;
        final /* synthetic */ KryptonDefaultMediaRecorder this$0;

        public class Item {
            public long end;
            public long offset;
            public long start;
            final /* synthetic */ ClipVideoTimeRanges this$1;

            public Item(ClipVideoTimeRanges r1) {
                this.this$1 = r1;
            }
        }

        public boolean valid() {
            Item[] r0 = this.itemArray;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.length == 0) goto L7;
            return true;
        }

        public ClipVideoTimeRanges(KryptonDefaultMediaRecorder r4, long[] r5) {
            this.this$0 = r4;
            if (r5 == null) goto L10;
            int r0 = 1;
            if (r5.length <= 1) goto L12;
            this.itemArray = new Item[r5.length / 2];
        L8:
            if (r0 >= r5.length) goto L13;
            Item r6 = new Item(this);
            r6.start = r5[r0 - 1];
            r6.end = r5[r0];
            r6.offset = -1;
            this.itemArray[r0 / 2] = r6;
            r0 = r0 + 1;
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public interface Delegate {
        String getVideoDirectory(String r1, boolean r2);

        VideoFileManagementPolicy getVideoFileManagementPolicy();

        VideoPathInfo getVideoPathInfo(String r1, boolean r2);
    }

    public interface Invoker {
        String extractMetadata(MediaMetadataRetriever r1, int r2);
    }

    public static final enum VideoFileManagementPolicy extends Enum<VideoFileManagementPolicy> {
        private static final /* synthetic */ VideoFileManagementPolicy[] $VALUES = null;
        public static final VideoFileManagementPolicy FORCE_DELETE = null;
        public static final VideoFileManagementPolicy FORCE_KEEP = null;
        public static final VideoFileManagementPolicy USER_DEFINED = null;

        static {
            VideoFileManagementPolicy r0 = new VideoFileManagementPolicy("USER_DEFINED", 0);
            USER_DEFINED = r0;
            VideoFileManagementPolicy r1 = new VideoFileManagementPolicy("FORCE_DELETE", 1);
            FORCE_DELETE = r1;
            VideoFileManagementPolicy r3 = new VideoFileManagementPolicy("FORCE_KEEP", 2);
            FORCE_KEEP = r3;
            $VALUES = new VideoFileManagementPolicy[]{r0, r1, r3};
        }

        public static VideoFileManagementPolicy[] values() {
            return (VideoFileManagementPolicy[]) $VALUES.clone();
        }

        public static VideoFileManagementPolicy valueOf(String r1) {
            return (VideoFileManagementPolicy) a.a(VideoFileManagementPolicy.class, r1);
        }

        private VideoFileManagementPolicy(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class VideoPathInfo {
        public String path;
        public String url;

        public VideoPathInfo() {
        }
    }

    private synchronized long getPresentationTimeUs() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mUseAudio == false) goto L11;
        if (this.mAudioSamples == 0) goto L11;
        long r0 = this.mAudioPresentationTimeUs;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r0;
    L11:
        long r1 = (currentTimeUs() - this.mStartTime) - this.mPausedTime;
        monitor-exit(this);
        return r1;
    }

    private void initMediaMuxer() throws Exception {
        releaseMediaMuxer(true);
        VideoPathInfo r1 = getOrCreateVideoPathInfo(false);
        this.mVideoOutputPath = r1.path;
        this.mVideoOutputUrl = r1.url;
        this.mMediaMuxer = new MediaMuxer(this.mVideoOutputPath, 0);
    }

    private synchronized boolean isRunning() {
        monitor-enter(this);
        boolean r0 = this.mRunning;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized long lastPresentationTime() {
        monitor-enter(this);
        long r0 = this.mLastVideoTime;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void pauseRecord() {
        monitor-enter(this);
        this.mLastPauseTime = currentTimeUs();     // Catch: Throwable -> L6
        this.mPaused = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void resumeRecord() {
        monitor-enter(this);
        this.mPausedTime += currentTimeUs() - this.mLastPauseTime;     // Catch: Throwable -> L6
        this.mPaused = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void stopRecord() {
        monitor-enter(this);
        this.mPaused = false;     // Catch: Throwable -> L9
        if (this.mRunning == false) goto L7;
        this.mRunning = false;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        ENCODER_BLACK_LIST = new String[]{"c2.android.avc.encoder"};
    }

    private void adjustVideoConfig() {
        MediaCodecInfo.CodecCapabilities r0 = this.mVideoMediaCodecEncoder.getCodecInfo().getCapabilitiesForType(this.mMimeType);
        int r1 = 4;
        if (r0 == null) goto L14;
        MediaCodecInfo.VideoCapabilities r2 = r0.getVideoCapabilities();
        if (r2 == null) goto L14;
        if (r2.getWidthAlignment() <= 4) goto L9;
        int r3 = r2.getWidthAlignment();
    L11:
        if (r2.getHeightAlignment() <= 4) goto L13;
        r1 = r2.getHeightAlignment();
    L13:
        Range<Integer> r4 = r2.getSupportedFrameRates();
        Range<Integer> r5 = r2.getBitrateRange();
        Range<Integer> r6 = r2.getSupportedWidths();
        Range<Integer> r7 = r2.getSupportedHeights();
        int r8 = ((Integer) r6.getLower()).intValue();
        int r9 = ((Integer) r6.getUpper()).intValue();
        int r10 = ((Integer) r7.getLower()).intValue();
        int r11 = ((Integer) r7.getUpper()).intValue();
        this.mVideoRangeLogString = "widthRange(" + r8 + "," + r9 + "),heightRange(" + r10 + "," + r11 + "),frameRateRange(" + r4.getLower() + "," + r4.getUpper() + "),bitRateRange(" + r5.getLower() + "," + r5.getUpper() + ")";
        int r14 = r3;
        int r12 = r1;
        r1 = r14;
    L15:
        int r13 = this.mWidth;
        int r15 = this.mHeight;
        if (r13 >= r15) goto L18;
        int r16 = r10;
        r10 = r8;
        r8 = r16;
    L19:
        if (r13 > r11) goto L21;
        if (r15 > r9) goto L21;
    L32:
        if ((r13 % r1) == 0) goto L35;
        r13 = (r13 / r1) * r1;
    L35:
        if ((r15 % r12) == 0) goto L37;
        r15 = (r15 / r12) * r12;
    L37:
        int r17 = valueInRange(r13, null, r8, r11);
        int r18 = valueInRange(r15, null, r10, r9);
        int r19 = valueInRange(this.mFPS, r4, 0, 960);
        int r20 = valueInRange(this.mBPS, r5, 280000, 30000000);
        if (this.mWidth == r17) goto L40;
    L45:
        KryptonLLog.i("KryptonMediaRecorder", "adjust video config to width: " + r17 + ", height: " + r18 + ", bps: " + r20 + ", fps: " + r19 + " from original width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS + ", range:" + this.mVideoRangeLogString);
        this.mWidth = r17;
        this.mHeight = r18;
        this.mFPS = r19;
        this.mBPS = r20;
        return;
    L40:
        if (this.mHeight != r18) goto L45;
        if (this.mFPS != r19) goto L45;
        if (this.mBPS != r20) goto L45;
        return;
    L21:
        int r110 = r13 * r9;
        int r111 = r15 * r11;
        if (r110 <= r111) goto L27;
        if (r13 > 0) goto L26;
        r13 = 1;
    L26:
        r15 = r111 / r13;
        r13 = r11;
        goto L32
    L27:
        if (r15 > 0) goto L30;
        r15 = 1;
    L30:
        r13 = r110 / r15;
        r15 = r9;
        goto L32
    L18:
        int r112 = r9;
        r9 = r11;
        r11 = r112;
        goto L19
    L9:
        r3 = 4;
    L14:
        r8 = 176;
        r9 = 1920;
        r10 = 144;
        r11 = 1080;
        r4 = null;
        r5 = null;
        r12 = 4;
        goto L15
    }

    private void autoAdjustVideoConfig() throws Exception {
        if (this.mToAdjustVideoConfig == true) goto L5;
        return;
    L5:
        this.mVideoMediaCodecEncoder = findEncoderForFormat(MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, CameraSize.mediumHeight, CameraSize.mediumWidth));
        adjustVideoConfig();
        if (isResolutionSupported(this.mVideoMediaCodecEncoder, this.mWidth, this.mHeight, VIDEO_MIME_TYPE) == true) goto L8;
        KryptonLLog.i("KryptonMediaRecorder", "release encoder which do not supported size (" + this.mWidth + ", " + this.mHeight + ")");
        releaseVideoMediaCodecEncoder(true);
    L8:
        this.mToAdjustVideoConfig = false;
    }

    private void clipThreadRun() {
        ClipVideoTimeRanges r10 = new ClipVideoTimeRanges(this, this.mClipTimeArray);
        if (r10.valid() == true) goto L6;
        notifyClipStopWithError(null, "clip error: no clip time array");
        return;
    L6:
        KryptonLLog.i("KryptonMediaRecorder", "start clip with ranges");
        VideoPathInfo r1 = getOrCreateVideoPathInfo(true);
        String r12 = r1.path;
        String r13 = r1.url;
        if (r12 != null) goto L10;
        notifyClipStopWithError(null, "clip error: create file exception");
        return;
    L10:
        MediaExtractor r14 = new MediaExtractor();
        r14.setDataSource(this.mVideoOutputPath);     // Catch: Exception -> L71
        int r2 = 0;
        MediaMuxer r15 = new MediaMuxer(r12, 0);     // Catch: Exception -> L71
        int r3 = 0;
        int r4 = -1;
        int r5 = -1;
        int r8 = -1;
        int r16 = -1;
    L80:
    L32:
        e = e;
    L33:
        r2 = r4;
    L34:
        notifyClipStopWithError(r12, "clip error: " + e.toString());
        int r7 = r2;
    L35:
        int r0 = r5;
        if (r7 != (-1)) goto L82;
        notifyClipStopWithError(r12, "clip error: no video track found");
        return;
    L82:
        r15.start();     // Catch: Exception -> L68
        ByteBuffer r17 = ByteBuffer.allocate(r3);     // Catch: Exception -> L68
        if (clipTrack(r14, r15, r10, false, r17, r7, r8) == true) goto L43;
        notifyClipStopWithError(r12, "clip error: no video track filled");     // Catch: Exception -> L68
        return;
    L43:
        if (r0 < 0) goto L45;
        clipTrack(r14, r15, r10, true, r17, r0, r16);     // Catch: Exception -> L68
    L45:
        r15.stop();     // Catch: Exception -> L68
        r15.release();     // Catch: Exception -> L68
        r14.release();     // Catch: Exception -> L68
        PolarisFileWrapper r6 = new PolarisFileWrapper(r12);
        if (r6.exists() == true) goto L49;
    L66:
        notifyClipStopWithError(r12, "create video file failed.");
        return;
    L49:
        if (r6.isFile() == false) goto L66;
        MediaMetadataRetriever r9 = new MediaMetadataRetriever();
        r9.setDataSource(r12);     // Catch: Throwable -> L64
        long r11 = r6.length();
        Invoker r18 = this.mInvoker;
        if (r18 == null) goto L56;
        String r19 = r18.extractMetadata(r9, 9);
    L57:
        if (r19 == null) goto L59;
        float r20 = CastFloatProtector.parseFloat(r19);
    L60:
        this.mCachedPaths.add(r12);
        KryptonLLog.i("KryptonMediaRecorder", "clip stop with data: path: " + r12 + ",duration = " + r20 + ", size = " + r11);
        KryptonMediaRecorder.Listener r21 = this.mListener;
        if (r21 == null) goto L91;
        r21.onClipVideoEnd(this, r12, r13, r20 / 1000.0f, r11);
        return;
    L91:
        return;
    L59:
        r20 = 0.0f;
        goto L60
    L56:
        r19 = com_lynx_canvas_recorder_KryptonDefaultMediaRecorder_android_media_MediaMetadataRetriever_extractMetadata(r9, 9);
    L64:
        notifyClipStopWithError(r12, "video file is empty");
        return;
    L68:
        e = move-exception;
        notifyClipStopWithError(r12, "clip error: clip video data exception " + e.toString());
        return;
    L14:
        if (r2 >= r14.getTrackCount()) goto L31;
        MediaFormat r22 = r14.getTrackFormat(r2);     // Catch: Exception -> L32
        if (r22.getString("mime").startsWith("video/") == true) goto L76;
        if (r22.getString("mime").startsWith("audio/") == false) goto L30;
        r16 = r15.addTrack(r22);     // Catch: Exception -> L28
        r5 = r2;
    L28:
        e = e;
        r5 = r2;
    L30:
        r2 = r2 + 1;
        goto L80
    L76:
        int r23 = r22.getInteger("max-input-size");     // Catch: Exception -> L22
        r8 = r15.addTrack(r22);     // Catch: Exception -> L20
        r4 = r2;
        r3 = r23;
    L20:
        e = e;
        r3 = r23;
    L22:
        e = e;
        goto L34
    L31:
        r7 = r4;
    L71:
        e = move-exception;
        notifyClipStopWithError(r12, "clip error: MediaExtractor exception " + e.toString());
    }

    private void drainAudioEncoder() {
        MediaCodec r0 = this.mAudioMediaCodecEncoder;
        if (r0 != null) goto L5;
        return;
    L5:
        ByteBuffer[] r1 = r0.getOutputBuffers();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = this.mAudioMediaCodecEncoder.dequeueOutputBuffer(this.mAudioBufferInfo, 0);
        if (r2 >= 0) goto L21;
        if (r2 >= 0) goto L21;
        if (r2 == (-1)) goto L13;
        if (r2 == (-3)) goto L16;
        if (r2 == (-2)) goto L19;
        KryptonLLog.i("KryptonMediaRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + r2);
        goto L8
    L19:
        resetOutputFormat(true);
        goto L8
    L16:
        r1 = this.mAudioMediaCodecEncoder.getOutputBuffers();
        goto L8
    L13:
        return;
    L21:
        ByteBuffer r3 = r1[r2];
        if (r3 == null) goto L33;
        MediaCodec.BufferInfo r4 = this.mAudioBufferInfo;
        if ((r4.flags & 2) == 0) goto L27;
        r4.size = 0;
    L27:
        if (this.mMuxerStarted == true) goto L29;
    L31:
        this.mAudioMediaCodecEncoder.releaseOutputBuffer(r2, false);
        goto L8
    L29:
        if (r4.size == 0) goto L31;
        r3.position(r4.offset);
        MediaCodec.BufferInfo r5 = this.mAudioBufferInfo;
        r3.limit(r5.offset + r5.size);
        this.mMediaMuxer.writeSampleData(this.mAudioTrackIndex, r3, this.mAudioBufferInfo);
        goto L31
    L33:
        throw new RuntimeException("encoderOutputBuffer " + r2 + " was null");
    }

    private void notifyFlushRecord() {
        KryptonMediaRecorder.Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onRecordFlush(this);
        return;
    }

    private void prepareAudioEncoder() throws Exception {
        this.mAudioBufferInfo = new MediaCodec.BufferInfo();
        MediaFormat r0 = new MediaFormat();
        r0.setString("mime", AUDIO_MIME_TYPE);
        r0.setInteger("aac-profile", 2);
        r0.setInteger("sample-rate", this.mAudioSampleRate);
        r0.setInteger("channel-count", this.mAudioChannelCount);
        r0.setInteger("bitrate", this.mAudioBPS);
        r0.setInteger("max-input-size", 32768);
        releaseAudioMediaCodecEncoder(true);
        MediaCodec r2 = findEncoderForFormat(r0);
        this.mAudioMediaCodecEncoder = r2;
        r2.configure(r0, null, null, 1);
        this.mAudioMediaCodecEncoder.start();
    }

    private void prepareVideoEncoder() throws Exception {
        this.mVideoBufferInfo = new MediaCodec.BufferInfo();
        releaseVideoMediaCodecEncoder(true);
        autoAdjustVideoConfig();
        MediaFormat r1 = MediaFormat.createVideoFormat(VIDEO_MIME_TYPE, this.mWidth, this.mHeight);
        r1.setInteger("color-format", 2130708361);
        r1.setInteger("bitrate", this.mBPS);
        r1.setInteger("frame-rate", this.mFPS);
        r1.setInteger("i-frame-interval", 1);
        KryptonLLog.i("KryptonMediaRecorder", "create format width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS);
        if (this.mVideoMediaCodecEncoder != null) goto L5;
        this.mVideoMediaCodecEncoder = findEncoderForFormat(r1);
        KryptonLLog.i("KryptonMediaRecorder", " find encoder for size (" + this.mWidth + ", " + this.mHeight + ")");
    L6:
        this.mVideoMediaCodecEncoder.configure(r1, null, null, 1);
        this.mVideoInputSurface = this.mVideoMediaCodecEncoder.createInputSurface();
        this.mVideoMediaCodecEncoder.start();
        return;
    L5:
        KryptonLLog.i("KryptonMediaRecorder", " reuse the encoder found with dummy format for size (" + this.mWidth + ", " + this.mHeight + ")");
        goto L6
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized Surface startRecord() {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (this.mWidth > 0) goto L7;
    L33:
        notifyStartError("init param error");     // Catch: Throwable -> L36
        monitor-exit(this);
        return null;
    L7:
        if (this.mHeight <= 0) goto L33;
        this.mPausedTime = 0;     // Catch: Throwable -> L36
        this.mLastPauseTime = 0;     // Catch: Throwable -> L36
        this.mMuxerStarted = false;     // Catch: Throwable -> L36
        this.mLastVideoTime = 0;     // Catch: Throwable -> L36
        this.mAudioTrackIndex = -1;     // Catch: Throwable -> L36
        this.mVideoTrackIndex = -1;     // Catch: Throwable -> L36
        this.mTrackCount = 0;     // Catch: Throwable -> L36
        this.mPaused = false;     // Catch: Throwable -> L36
        this.mAudioPresentationTimeUs = 0;     // Catch: Throwable -> L36
        this.mAudioSamples = 0;     // Catch: Throwable -> L36
        prepareVideoEncoder();     // Catch: Exception -> L29 Throwable -> L36
    L13:
        if (this.mUseAudio == true) goto L41;
        this.mAllTrackCount = 1;     // Catch: Throwable -> L36
    L39:
        initMediaMuxer();     // Catch: Exception -> L25 Throwable -> L36
        this.mRunning = true;     // Catch: Throwable -> L36
        final String r1 = "MediaRecorder";
        ThreadMethodProxy.start(new AnonymousClass1(this, r1));     // Catch: Throwable -> L36
        Surface r0 = this.mVideoInputSurface;     // Catch: Throwable -> L36
        monitor-exit(this);
        return r0;
    L25:
        e = move-exception;
        String r2 = "initMediaMuxer " + e.toString();     // Catch: Throwable -> L36
        KryptonLLog.e("KryptonMediaRecorder", r2);     // Catch: Throwable -> L36
        notifyStartError(r2);     // Catch: Throwable -> L36
        return null;
    L41:
        prepareAudioEncoder();     // Catch: Exception -> L16 Throwable -> L36
        this.mAllTrackCount = 2;     // Catch: Exception -> L16 Throwable -> L36
    L16:
        e = move-exception;
        String r3 = "prepareAudioEncoder " + e.toString();     // Catch: Throwable -> L36
        KryptonLLog.e("KryptonMediaRecorder", r3);     // Catch: Throwable -> L36
        notifyStartError(r3);     // Catch: Throwable -> L36
        return null;
    L29:
        e = move-exception;
        String r4 = "prepareVideoEncoder " + e.toString() + "model:" + Build.MODEL + " width:" + this.mWidth + " height:" + this.mHeight + " bps:" + this.mBPS + "ranges: " + this.mVideoRangeLogString;     // Catch: Throwable -> L36
        KryptonLLog.e("KryptonMediaRecorder", r4);     // Catch: Throwable -> L36
        notifyStartError(r4);     // Catch: Throwable -> L36
        return null;
    }

    private long currentTimeUs() {
        long r0 = System.nanoTime();
        return (System.currentTimeMillis() * 1000) + ((r0 - ((r0 / 1000000) * 1000000)) / 1000);
    }

    private void recorderThreadRun() {
        this.mStartTime = currentTimeUs();     // Catch: Exception -> L35
    L4:
        if (isRunning() == false) goto L10;
        notifyFlushRecord();     // Catch: Exception -> L35
        drainVideoEncoder(false);     // Catch: Exception -> L35
        drainAudioEncoder();     // Catch: Exception -> L35
        int r0 = this.mMaxDuration;     // Catch: Exception -> L35
        if (r0 <= 0) goto L4;
        if (this.mLastVideoTime < (((double) r0) * 1000000.0d)) goto L4;
        this.mRunning = false;     // Catch: Exception -> L35
        this.mPaused = false;     // Catch: Exception -> L35
        goto L4
    L10:
        this.mVideoMediaCodecEncoder.signalEndOfInputStream();     // Catch: Exception -> L35
        drainVideoEncoder(true);     // Catch: Exception -> L35
        drainAudioEncoder();     // Catch: Exception -> L35
        releaseVideoMediaCodecEncoder(false);     // Catch: Exception -> L32
        releaseAudioMediaCodecEncoder(false);     // Catch: Exception -> L32
        releaseMediaMuxer(false);     // Catch: Exception -> L32
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.mVideoOutputPath);
        if (r1.exists() == true) goto L15;
    L30:
        notifyStopWithError("create video file failed.");
        return;
    L15:
        if (r1.isFile() == false) goto L30;
        long r2 = r1.length();
        MediaMetadataRetriever r3 = new MediaMetadataRetriever();
        r3.setDataSource(this.mVideoOutputPath);     // Catch: Throwable -> L28
        Invoker r4 = this.mInvoker;
        if (r4 == null) goto L22;
        String r5 = r4.extractMetadata(r3, 9);
    L23:
        if (r5 == null) goto L25;
        float r6 = CastFloatProtector.parseFloat(r5);
    L26:
        this.mCachedPaths.add(this.mVideoOutputPath);
        notifyStopWithData(r6 / 1000.0f, r2);
        return;
    L25:
        r6 = 0.0f;
        goto L26
    L22:
        r5 = com_lynx_canvas_recorder_KryptonDefaultMediaRecorder_android_media_MediaMetadataRetriever_extractMetadata(r3, 9);
    L28:
        notifyStopWithError("result video file is empty");
        return;
    L32:
        e = move-exception;
        notifyStopWithError("release Encoder error." + e.toString());
        return;
    L35:
        e = move-exception;
        notifyStopWithError("encode error " + e.toString());
    }

    public static /* synthetic */ void access$000(KryptonDefaultMediaRecorder r0) {
        r0.recorderThreadRun();
    }

    public static /* synthetic */ void access$100(KryptonDefaultMediaRecorder r0) {
        r0.clipThreadRun();
    }

    private String createTempVideoFileInDirectory(String r5) {
        if (r5 != null) goto L13;
        return null;
    L13:
        File r6 = File.createTempFile("krypton", ".mp4", new PolarisFileWrapper(r5));     // Catch: Exception -> L10
        if (r6.exists() == false) goto L8;
        r6.delete();     // Catch: Exception -> L10
    L8:
        return r6.getPath();
    L10:
        e = move-exception;
        KryptonLLog.w("KryptonMediaRecorder", e.getLocalizedMessage());
        return null;
    }

    private boolean deleteFileWithPath(String r5) {
        PolarisFileWrapper r2 = new PolarisFileWrapper(r5);     // Catch: Throwable -> L14
        if (r2.exists() == true) goto L6;
    L12:
        KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + r5 + ", file not exists");     // Catch: Throwable -> L14
    L18:
        return false;
    L6:
        if (r2.isFile() == false) goto L12;
        if (r2.delete() == false) goto L11;
        return true;
    L11:
        KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + r5);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        KryptonLLog.e("KryptonMediaRecorder", "delete file error for " + r5 + " exception " + th.toString());
        return false;
    }

    private void drainVideoEncoder(boolean r12) {
        MediaCodec r0 = this.mVideoMediaCodecEncoder;
        if (r0 != null) goto L5;
        return;
    L5:
        ByteBuffer[] r1 = r0.getOutputBuffers();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = this.mVideoMediaCodecEncoder.dequeueOutputBuffer(this.mVideoBufferInfo, 0);
        if (r2 < 0) goto L11;
        ByteBuffer r4 = r1[r2];
        if (r4 == null) goto L43;
        MediaCodec.BufferInfo r5 = this.mVideoBufferInfo;
        if ((r5.flags & 2) == 0) goto L27;
        r5.size = 0;
    L27:
        if (this.mMuxerStarted == true) goto L29;
    L37:
        this.mVideoMediaCodecEncoder.releaseOutputBuffer(r2, false);
        if ((this.mVideoBufferInfo.flags & 4) == 0) goto L8;
        if (r12 == true) goto L61;
        KryptonLLog.w("KryptonMediaRecorder", "reached end of stream unexpectedly");
        return;
    L61:
        return;
    L29:
        if (r5.size <= 0) goto L37;
        r4.position(r5.offset);
        MediaCodec.BufferInfo r6 = this.mVideoBufferInfo;
        r4.limit(r6.offset + r6.size);
        this.mVideoBufferInfo.presentationTimeUs = getPresentationTimeUs();
        if (this.mPaused == true) goto L37;
        MediaCodec.BufferInfo r7 = this.mVideoBufferInfo;
        long r8 = r7.presentationTimeUs;
        long r9 = this.mLastVideoTime;
        if (r8 > r9) goto L36;
        r7.presentationTimeUs = r9 + MIN_INTERVAL;
    L36:
        this.mLastVideoTime = r7.presentationTimeUs;
        this.mMediaMuxer.writeSampleData(this.mVideoTrackIndex, r4, r7);
        goto L37
    L43:
        throw new RuntimeException("encoderOutputBuffer " + r2 + " was null");
    L11:
        if (r2 != (-3)) goto L13;
        r1 = this.mVideoMediaCodecEncoder.getOutputBuffers();
        KryptonLLog.i("KryptonMediaRecorder", "encoder output buffer length:" + r1.length);
        goto L8
    L13:
        if (r2 != (-2)) goto L15;
        resetOutputFormat(false);
        goto L8
    L15:
        if (r2 != (-1)) goto L16;
        if (r12 == true) goto L8;
        return;
    L16:
        KryptonLLog.w("KryptonMediaRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + r2);
        goto L8
    }

    private MediaCodec findEncoderForFormat(MediaFormat r5) throws IOException {
        if (Build.VERSION.SDK_INT <= 21) goto L13;
        String r0 = new MediaCodecList(0).findEncoderForFormat(r5);
        if (TextUtils.isEmpty(r0) == true) goto L13;
        if (isInefficientEncoder(r0) == true) goto L13;
        return MediaCodec.createByCodecName(r0);
    L10:
        e = move-exception;
        KryptonLLog.w("KryptonMediaRecorder", "createByCodecName " + r0 + " exception " + e.getMessage());
    L13:
        return MediaCodec.createEncoderByType(r5.getString("mime"));
    }

    private VideoPathInfo getOrCreateVideoPathInfo(boolean r5) {
        VideoPathInfo r0 = this.mDelegate.getVideoPathInfo(this.mMimeType, r5);
        if (r0 != null) goto L25;
        r0 = new VideoPathInfo();
    L25:
    L17:
        e = move-exception;
        KryptonLLog.w("KryptonMediaRecorder", e.getLocalizedMessage());
        r0.path = null;
    L20:
        if (r0.url != null) goto L24;
        String r6 = r0.path;
        if (r6 == null) goto L24;
        r0.url = "file://".concat(r6);
    L24:
        return r0;
    L6:
        if (r0.path == null) goto L8;
        PolarisFileWrapper r7 = new PolarisFileWrapper(r0.path);     // Catch: Exception -> L17
    L12:
        if (r7.exists() == false) goto L14;
        r7.delete();     // Catch: Exception -> L17
    L14:
        r0.path = r7.getPath();     // Catch: Exception -> L17
        goto L20
    L8:
        String r8 = this.mDelegate.getVideoDirectory(this.mMimeType, r5);     // Catch: Exception -> L17
        if (r8 == null) goto L16;
        r7 = File.createTempFile("krypton", ".mp4", new PolarisFileWrapper(r8));     // Catch: Exception -> L17
        goto L12
    L16:
        throw new Exception("Should specify a video directory with getVideoDirectory method.");     // Catch: Exception -> L17
    }

    private boolean isInefficientEncoder(String r6) {
        String[] r0 = ENCODER_BLACK_LIST;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        if (TextUtils.equals(r0[r3], r6) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private void notifyStartError(String r2) {
        KryptonMediaRecorder.Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onRecordStartError(this, r2);
        return;
    }

    private void notifyStopWithError(String r2) {
        tryToDeleteFileWithPath(this.mVideoOutputPath);
        KryptonMediaRecorder.Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onRecordStopWithError(this, r2);
        return;
    }

    private void releaseAudioMediaCodecEncoder(boolean r6) {
        MediaCodec r1 = this.mAudioMediaCodecEncoder;
        if (r1 != null) goto L18;
        return;
    L18:
        r1.stop();     // Catch: Throwable -> L8 RuntimeException -> L10
        this.mAudioMediaCodecEncoder.release();     // Catch: Throwable -> L8 RuntimeException -> L10
    L7:
        this.mAudioMediaCodecEncoder = null;
        return;
    L10:
        e = move-exception;
        KryptonLLog.e("KryptonMediaRecorder", "releaseAudioMediaCodecEncoder exception " + e.toString());     // Catch: Throwable -> L8
        if (r6 == true) goto L7;
        throw e;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mAudioMediaCodecEncoder = null;
        throw th;
    }

    private void releaseMediaMuxer(boolean r6) {
        MediaMuxer r1 = this.mMediaMuxer;
        if (r1 != null) goto L18;
        return;
    L18:
        r1.stop();     // Catch: Throwable -> L8 IllegalStateException -> L10
        this.mMediaMuxer.release();     // Catch: Throwable -> L8 IllegalStateException -> L10
    L7:
        this.mMediaMuxer = null;
        return;
    L8:
        th = move-exception;
        this.mMediaMuxer = null;
        throw th;
    L10:
        e = move-exception;
        KryptonLLog.e("KryptonMediaRecorder", "releaseMediaMuxer exception " + e.toString());     // Catch: Throwable -> L8
        if (r6 == true) goto L7;
        throw e;     // Catch: Throwable -> L8
    }

    private void releaseVideoMediaCodecEncoder(boolean r6) {
        MediaCodec r1 = this.mVideoMediaCodecEncoder;
        if (r1 != null) goto L18;
        return;
    L18:
        r1.stop();     // Catch: Throwable -> L8 RuntimeException -> L10
        this.mVideoMediaCodecEncoder.release();     // Catch: Throwable -> L8 RuntimeException -> L10
    L7:
        this.mVideoMediaCodecEncoder = null;
        return;
    L10:
        e = move-exception;
        KryptonLLog.e("KryptonMediaRecorder", "releaseVideoMediaCodecEncoder exception " + e.toString());     // Catch: Throwable -> L8
        if (r6 == true) goto L7;
        throw e;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mVideoMediaCodecEncoder = null;
        throw th;
    }

    private void resetOutputFormat(boolean r3) {
        if (this.mMuxerStarted == true) goto L12;
        if (r3 == false) goto L6;
        this.mAudioTrackIndex = this.mMediaMuxer.addTrack(this.mAudioMediaCodecEncoder.getOutputFormat());
    L7:
        int r4 = this.mTrackCount + 1;
        this.mTrackCount = r4;
        if (r4 != this.mAllTrackCount) goto L13;
        this.mMediaMuxer.start();
        this.mMuxerStarted = true;
        return;
    L13:
        return;
    L6:
        this.mVideoTrackIndex = this.mMediaMuxer.addTrack(this.mVideoMediaCodecEncoder.getOutputFormat());
        goto L7
    L12:
        throw new IllegalStateException("output format already changed!");
    }

    private synchronized void tryToDeleteFileWithPath(String r1) {
        monitor-enter(this);
        if (r1 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        deleteFileWithPath(r1);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public boolean clipVideo(long[] r2) {
        this.mClipTimeArray = r2;
        final String r0 = "MediaRecorderClop";
        ThreadMethodProxy.start(new AnonymousClass2(this, r0));
        return true;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void destroy(boolean r3) {
        monitor-enter(this);
        stopRecord();     // Catch: Throwable -> L20
        if (this.mDelegate.getVideoFileManagementPolicy() == null) goto L12;
        int r0 = AnonymousClass3.$SwitchMap$com$lynx$canvas$recorder$KryptonDefaultMediaRecorder$VideoFileManagementPolicy[this.mDelegate.getVideoFileManagementPolicy().ordinal()];     // Catch: Throwable -> L20
        if (r0 != 1) goto L8;
        r3 = true;
        goto L12
    L8:
        if (r0 != 2) goto L12;
        r3 = false;
    L12:
        if (r3 == false) goto L17;
        KryptonLLog.i("KryptonMediaRecorder", "Media recorder destroy with video files deleted");     // Catch: Throwable -> L20
        Iterator<String> r4 = this.mCachedPaths.iterator();     // Catch: Throwable -> L20
    L15:
        if (r4.hasNext() == false) goto L18;
        deleteFileWithPath(r4.next());     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L17:
        KryptonLLog.i("KryptonMediaRecorder", "Media recorder destroy with 1 video files not deleted");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void setListener(KryptonMediaRecorder.Listener r1) {
        monitor-enter(this);
        this.mListener = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public KryptonDefaultMediaRecorder(Delegate r3, Invoker r4) {
        this.mVideoRangeLogString = NameKeys.UnloadStrategy_No_Strategy;
        this.mRunning = false;
        this.mUseAudio = false;
        this.mLastPauseTime = 0;
        this.mPausedTime = 0;
        this.mLastVideoTime = 0;
        this.mStartTime = 0;
        this.mClipTimeArray = null;
        this.mCachedPaths = new ArrayList();
        if (r3 == null) goto L7;
        this.mDelegate = r3;
        this.mInvoker = r4;
        return;
    L7:
        throw new IllegalArgumentException("KryptonDefaultMediaRecorder delegate must be set.");
    }

    private static String com_lynx_canvas_recorder_KryptonDefaultMediaRecorder_android_media_MediaMetadataRetriever_extractMetadata(MediaMetadataRetriever r18, int r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {Integer.valueOf(r19)};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r18, r1, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (String) r4.b;
    L21:
        return r18.extractMetadata(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private void notifyClipStopWithError(String r1, String r2) {
        tryToDeleteFileWithPath(r1);
        KryptonMediaRecorder.Listener r3 = this.mListener;
        if (r3 == null) goto L6;
        r3.onClipVideoEndWithError(this, r2);
        return;
    }

    private void notifyStopWithData(float r8, long r9) {
        KryptonMediaRecorder.Listener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onRecordStop(this, this.mVideoOutputPath, this.mVideoOutputUrl, r8, r9);
        return;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public void onAudioSample(ByteBuffer r12, int r13) {
        MediaCodec r1 = this.mAudioMediaCodecEncoder;
        if (r1 != null) goto L15;
        return;
    L15:
        int r5 = r1.dequeueInputBuffer(0);     // Catch: Exception -> L12
        if (r5 >= 0) goto L10;
        KryptonLLog.w("KryptonMediaRecorder", "no input buffer, audio data dropped");     // Catch: Exception -> L12
        return;
    L10:
        ByteBuffer r2 = this.mAudioMediaCodecEncoder.getInputBuffers()[r5];     // Catch: Exception -> L12
        r2.clear();     // Catch: Exception -> L12
        r12.position(0).limit(r13);     // Catch: Exception -> L12
        r2.put(r12);     // Catch: Exception -> L12
        long r3 = this.mAudioSamples;     // Catch: Exception -> L12
        long r8 = (1000000 * r3) / ((long) this.mAudioSampleRate);     // Catch: Exception -> L12
        this.mAudioPresentationTimeUs = r8;     // Catch: Exception -> L12
        this.mAudioSamples = r3 + ((long) (r13 >> 2));     // Catch: Exception -> L12
        this.mAudioMediaCodecEncoder.queueInputBuffer(r5, 0, r13, r8, 0);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        KryptonLLog.w("KryptonMediaRecorder", "onAudioSample exception " + e.toString());
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void configAudio(int r1, int r2, int r3) {
        monitor-enter(this);
        if (r1 < 0) goto L5;
        this.mAudioChannelCount = r1;     // Catch: Throwable -> L11
        this.mAudioBPS = r2;     // Catch: Throwable -> L11
        this.mAudioSampleRate = r3;     // Catch: Throwable -> L11
        this.mUseAudio = true;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L5:
        this.mUseAudio = false;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean isResolutionSupported(MediaCodec r2, int r3, int r4, String r5) {
        if (r2 != null) goto L5;
        return false;
    L5:
        MediaCodecInfo.CodecCapabilities r6 = r2.getCodecInfo().getCapabilitiesForType(r5);
        if (r6 != null) goto L8;
        return false;
    L8:
        MediaCodecInfo.VideoCapabilities r7 = r6.getVideoCapabilities();
        if (r7 != null) goto L12;
        return false;
    L12:
        return r7.isSizeSupported(r3, r4);
    }

    private int valueInRange(int r1, Range<Integer> r2, int r3, int r4) {
        if (r2 != null) goto L4;
        if (r1 <= r4) goto L13;
        return r4;
    L13:
        if (r1 >= r3) goto L15;
        return r3;
    L15:
        return r1;
    L4:
        if (r1 <= ((Integer) r2.getUpper()).intValue()) goto L8;
        return ((Integer) r2.getUpper()).intValue();
    L8:
        if (r1 >= ((Integer) r2.getLower()).intValue()) goto L15;
        return ((Integer) r2.getLower()).intValue();
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder
    public synchronized void configVideo(String r2, int r3, int r4, int r5, int r6, int r7) {
        monitor-enter(this);
        this.mMimeType = r2;     // Catch: Throwable -> L7
        this.mMaxDuration = r3;     // Catch: Throwable -> L7
        this.mWidth = r4;     // Catch: Throwable -> L7
        this.mHeight = r5;     // Catch: Throwable -> L7
        this.mBPS = r6;     // Catch: Throwable -> L7
        this.mFPS = r7;     // Catch: Throwable -> L7
        this.mToAdjustVideoConfig = true;     // Catch: Throwable -> L7
        KryptonLLog.i("KryptonMediaRecorder", "configVideo for " + Build.MODEL + ", width: " + this.mWidth + ", height: " + this.mHeight + ", bps: " + this.mBPS + ", fps: " + this.mFPS);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean clipTrack(MediaExtractor r26, MediaMuxer r27, ClipVideoTimeRanges r28, boolean r29, ByteBuffer r30, int r31, int r32) {
        r26.selectTrack(r31);
        MediaCodec.BufferInfo r3 = new MediaCodec.BufferInfo();
        int r4 = 0;
        long r5 = 0;
        long r7 = 0;
        int r10 = 0;
        boolean r11 = false;
    L3:
        ClipVideoTimeRanges.Item[] r12 = r28.itemArray;
        if (r10 >= r12.length) goto L29;
        ClipVideoTimeRanges.Item r13 = r12[r10];
        KryptonLLog.i("KryptonMediaRecorder", "start time " + r13.start + ", end time" + r13.end);
        long r15 = r7;
        r26.seekTo(r13.start, r4);
        long r17 = -1;
    L6:
        int r14 = r26.readSampleData(r30, r4);
        if (r14 < 0) goto L8;
        r5 = r5;
        long r6 = r26.getSampleTime();
        int r8 = r26.getSampleFlags();
        if (r6 > r13.end) goto L12;
        if (r13.offset != (-1)) goto L21;
        r13.start = r6;
        r13.offset = r5;
    L21:
        long r9 = r13.start;
        if (r6 < r9) goto L23;
        long r16 = (r6 - r9) + r13.offset;
        if (r16 < r15) goto L26;
        r4 = 0;
        r3.offset = 0;
        r3.size = r14;
        r3.flags = r8;
        r3.presentationTimeUs = r16;
        r27.writeSampleData(r32, r30, r3);
        r26.advance();
        r11 = true;
        r15 = r16;
        r17 = r6;
        goto L6
    L26:
        r26.advance();
    L27:
        r4 = 0;
        goto L6
    L23:
        r26.advance();
        goto L27
    L12:
        KryptonLLog.i("KryptonMediaRecorder", "presentationTimeUs > endTime " + r6 + " > " + r13.end);
    L14:
        if (r17 == (-1)) goto L16;
        r5 = r5 + (r17 - r13.start);
    L17:
        r10 = r10 + 1;
        r7 = r15;
        r4 = 0;
        goto L3
    L16:
        r13.start = r13.end;
        r5 = r5;
        goto L17
    L8:
        r26.unselectTrack(r31);
        r5 = r5;
        goto L14
    L29:
        return r11;
    }
}
