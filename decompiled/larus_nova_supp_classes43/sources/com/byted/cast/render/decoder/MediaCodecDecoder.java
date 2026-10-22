package com.byted.cast.render.decoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.byted.cast.mediacommon.MediaMonitor;
import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.byted.cast.mediacommon.render.parameters.MediaRenderErrorCode;
import com.byted.cast.render.jitterbuffer.VideoJitterBuffer;
import com.byted.cast.render.parser.SPS;
import com.byted.cast.render.parser.golomb;
import com.byted.cast.render.utils.Logger;
import com.byted.cast.render.utils.Utils;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.event.a;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class MediaCodecDecoder implements IMediaDecoder {
    private static int instanceNum;
    private String TAG;
    private int audioProfile;
    private int channels;
    private final CodecId codecId;
    private long decodeFrames;
    private final Object decodeLock;
    private long decodeLogTime;
    private DecodeThread decodeThread;
    private final Map<Long, Long> decodeTimeMaps;
    private String decoderName;
    private int decodingFrames;
    private int fps;
    private int height;
    private boolean inputWait;
    private int isADTS;
    private boolean isInit;
    private boolean isNeedCodec;
    private boolean isNeedResetDeocder;
    private boolean isSendIdr;
    private boolean isVideo;
    private long lastRecvTime;
    private IMediaDecoderListener listener;
    private SortedSet<Long> mPtsSet;
    private MediaCodec mediaCodec;
    private String mime;
    private boolean outputWait;
    private final ConcurrentSkipListMap<Long, byte[]> packets;
    private long recvFrames;
    private long recvLogTime;
    private final Object renderLock;
    private RenderThread renderThread;
    private int samplePerFrame;
    private int sampleRate;
    private long sendFirstIFrameTime;
    MediaRenderState state;
    private long sumDecodeTimes;
    private long sumRecvTimes;
    private Surface surface;
    private final String userId;
    VideoJitterBuffer videoJitterBuffer;
    private int width;

    /* JADX INFO: renamed from: com.byted.cast.render.decoder.MediaCodecDecoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class DecodeThread extends PthreadThreadV2 {
        private int errorNumbers;
        private boolean isRunning;
        final /* synthetic */ MediaCodecDecoder this$0;
        private int waitTimes;

        public void run() {
            com_byted_cast_render_decoder_MediaCodecDecoder$DecodeThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public synchronized void stopThread() {
            monitor-enter(this);
            this.isRunning = false;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void com_byted_cast_render_decoder_MediaCodecDecoder$DecodeThread__run$___twin___() {
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "DecodeThread start");
        L4:
            if (this.isRunning == false) goto L45;
        L43:
            e = move-exception;
            e.printStackTrace();
            MediaCodecDecoder.access$1000(this.this$0).OnError(MediaRenderErrorCode.MEDIARENDER_DECODE_ERROR, "processThread error");
            goto L45
        L6:
            if (MediaCodecDecoder.access$300(this.this$0).isEmpty() == true) goto L7;
            if (MediaCodecDecoder.access$600(this.this$0) == false) goto L4;
            if (MediaCodecDecoder.access$700(this.this$0) == null) goto L4;
            this.waitTimes = 0;     // Catch: Exception -> L43
            int r10 = MediaCodecDecoder.access$700(this.this$0).dequeueInputBuffer(100000);     // Catch: Exception -> L43
            if (r10 >= 0) goto L25;
            int r0 = this.errorNumbers + 1;     // Catch: Exception -> L43
            this.errorNumbers = r0;     // Catch: Exception -> L43
            if (r0 <= 100) goto L4;
            Logger.w(MediaCodecDecoder.access$200(this.this$0), "cannot send pkt to mediacodec");     // Catch: Exception -> L43
            this.errorNumbers = 0;     // Catch: Exception -> L43
            goto L4
        L25:
            ByteBuffer r1 = MediaCodecDecoder.access$700(this.this$0).getInputBuffer(r10);     // Catch: Exception -> L43
            Object r11 = MediaCodecDecoder.access$400(this.this$0);     // Catch: Exception -> L43
            monitor-enter(r11);     // Catch: Exception -> L43
            long r12 = ((Long) MediaCodecDecoder.access$300(this.this$0).firstKey()).longValue();     // Catch: Throwable -> L36
            Map.Entry r13 = MediaCodecDecoder.access$300(this.this$0).pollFirstEntry();     // Catch: Throwable -> L36
            Objects.requireNonNull(r13);     // Catch: Throwable -> L36
            byte[] r14 = (byte[]) r13.getValue();     // Catch: Throwable -> L36
            MediaCodecDecoder.access$800(this.this$0).put(Long.valueOf(r12), Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L36
            int r15 = r14.length;     // Catch: Throwable -> L36
            if (r1 == null) goto L32;
            r15 = Math.min(r15, r1.capacity());     // Catch: Throwable -> L36
            if (r15 <= 0) goto L32;
            r1.put(r14, 0, r15);     // Catch: Throwable -> L36
        L32:
            MediaCodec r16 = MediaCodecDecoder.access$700(this.this$0);     // Catch: Throwable -> L36
            r16.queueInputBuffer(r10, 0, r15, r12, 0);     // Catch: Throwable -> L36
            monitor-exit(r11);     // Catch: Throwable -> L36
            MediaCodecDecoder.access$908(this.this$0);     // Catch: Exception -> L43
            this.errorNumbers = 0;     // Catch: Exception -> L43
            goto L4
        L36:
            th = move-exception;
            throw th;     // Catch: Exception -> L43
        L7:
            Object r17 = MediaCodecDecoder.access$400(this.this$0);     // Catch: Exception -> L43
            monitor-enter(r17);     // Catch: Exception -> L43
            MediaCodecDecoder.access$502(this.this$0, true);     // Catch: Throwable -> L15
            MediaCodecDecoder.access$400(this.this$0).wait(500);     // Catch: Throwable -> L15
            int r18 = this.waitTimes + 1;     // Catch: Throwable -> L15
            this.waitTimes = r18;     // Catch: Throwable -> L15
            if (r18 <= 10) goto L12;
            Logger.w(MediaCodecDecoder.access$200(this.this$0), "long time no input data");     // Catch: Throwable -> L15
            this.waitTimes = 0;     // Catch: Throwable -> L15
        L12:
            MediaCodecDecoder.access$502(this.this$0, false);     // Catch: Throwable -> L15
            monitor-exit(r17);     // Catch: Throwable -> L15
            goto L4
        L15:
            th = move-exception;
            throw th;     // Catch: Exception -> L43
        L45:
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "DecoderThread stop");
        }

        private DecodeThread(MediaCodecDecoder r1) {
            this.this$0 = r1;
            super("MediaCodecDecoder$DecodeThread");
            this.isRunning = true;
            this.errorNumbers = 0;
            this.waitTimes = 0;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_byted_cast_render_decoder_MediaCodecDecoder$DecodeThread_com_larus_apm_impl_protector_RunnableLancet_run(DecodeThread r1) {
            r1.com_byted_cast_render_decoder_MediaCodecDecoder$DecodeThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ DecodeThread(MediaCodecDecoder r1, AnonymousClass1 r10) {
            this(r1);
        }
    }

    public class RenderThread extends PthreadThreadV2 {
        private int errorNumber;
        private boolean isFirstFrame;
        private boolean isRunning;
        final /* synthetic */ MediaCodecDecoder this$0;

        public void run() {
            com_byted_cast_render_decoder_MediaCodecDecoder$RenderThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public synchronized void stopThread() {
            monitor-enter(this);
            this.isRunning = false;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void com_byted_cast_render_decoder_MediaCodecDecoder$RenderThread__run$___twin___() {
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "RenderThread start");
            MediaCodec.BufferInfo r0 = new MediaCodec.BufferInfo();
        L4:
            if (this.isRunning == false) goto L104;
        L102:
            e = move-exception;
            e.printStackTrace();
            MediaCodecDecoder.access$1000(this.this$0).OnError(MediaRenderErrorCode.MEDIARENDER_DECODE_ERROR, "renderThread error");
            goto L104
        L6:
            if (MediaCodecDecoder.access$600(this.this$0) == false) goto L7;
            if (MediaCodecDecoder.access$700(this.this$0) == null) goto L17;
            int r10 = MediaCodecDecoder.access$700(this.this$0).dequeueOutputBuffer(r0, 1000000 / MediaCodecDecoder.access$1300(this.this$0));     // Catch: Exception -> L102
            Logger.v(MediaCodecDecoder.access$200(this.this$0), "dequeueOutputBuffer outputBufferId=" + r10 + ", info.presentationTimeUs=" + r0.presentationTimeUs);     // Catch: Exception -> L102
            if (r10 >= 0) goto L20;
            if (r10 == (-2)) goto L56;
            if (r10 != (-1)) goto L4;
            int r11 = this.errorNumber + 1;     // Catch: Exception -> L102
            this.errorNumber = r11;     // Catch: Exception -> L102
            if (r11 <= 200) goto L4;
            Logger.w(MediaCodecDecoder.access$200(this.this$0), MediaCodecDecoder.access$2200(this.this$0) + ": always no outFrame");     // Catch: Exception -> L102
            this.errorNumber = 0;     // Catch: Exception -> L102
            goto L4
        L56:
            MediaFormat r12 = MediaCodecDecoder.access$700(this.this$0).getOutputFormat();     // Catch: Exception -> L102
            if (r12.containsKey("width") == false) goto L90;
            if (r12.containsKey("height") == false) goto L90;
            int r13 = MediaCodecDecoder.access$2000(this.this$0);     // Catch: Exception -> L102
            int r14 = MediaCodecDecoder.access$2100(this.this$0);     // Catch: Exception -> L102
            if (Build.VERSION.SDK_INT >= 23) goto L63;
        L67:
            int r15 = r13;
            int r16 = r14;
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "mediacodec videoSizeChanged format: width: " + r12.getInteger("width") + ", height: " + r12.getInteger("height") + ", colorFormat: 0x" + Integer.toHexString(r12.getInteger("color-format")) + ", stride: " + r15 + ", sliceHeight: " + r16);     // Catch: Exception -> L102
            if (r12.containsKey("color-format") == false) goto L70;
            int r17 = r12.getInteger("color-format");     // Catch: Exception -> L102
        L72:
            if (r17 != 2135033992) goto L74;
        L87:
            int r18 = 1;
        L88:
            MediaCodecDecoder.access$1000(this.this$0).OnVideoSizeChanged(MediaCodecDecoder.access$2000(this.this$0), MediaCodecDecoder.access$2100(this.this$0), r15, r16, r18);     // Catch: Exception -> L102
            goto L90
        L74:
            if (r17 == 17) goto L87;
            if (r17 == 18) goto L87;
            if (r17 == 19) goto L87;
            if (r17 == 20) goto L87;
            if (r17 == 21) goto L87;
            if (r17 == 39) goto L87;
            r18 = 2;
            goto L88
        L70:
            r17 = 2;
            goto L72
        L63:
            if (r12.containsKey("stride") == false) goto L67;
            if (r12.containsKey("slice-height") == false) goto L67;
            r13 = r12.getInteger("stride");     // Catch: Exception -> L102
            r14 = r12.getInteger("slice-height");     // Catch: Exception -> L102
        L90:
            if (r12.containsKey("channel-count") == false) goto L4;
            if (r12.containsKey("sample-rate") == false) goto L4;
            if (r12.containsKey("bit-width") == false) goto L4;
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "mediacodec audioSizeChanged sampleRate: " + r12.getInteger("sample-rate") + ", channels: " + r12.getInteger("channel-count") + ", bitwidth: " + r12.getInteger("bit-width"));     // Catch: Exception -> L102
            goto L4
        L20:
            ByteBuffer r19 = MediaCodecDecoder.access$700(this.this$0).getOutputBuffer(r10);     // Catch: Exception -> L102
            long r20 = System.currentTimeMillis();     // Catch: Exception -> L102
            if (this.isFirstFrame == false) goto L24;
            long r21 = r20 - MediaCodecDecoder.access$1400(this.this$0);     // Catch: Exception -> L102
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "firstFrameDecodeTime: " + r21 + ", mediacodec frameQueue size: " + MediaCodecDecoder.access$900(this.this$0));     // Catch: Exception -> L102
            JSONObject r22 = new JSONObject();     // Catch: Exception -> L102
            r22.put("userId", MediaCodecDecoder.access$1500(this.this$0));     // Catch: Exception -> L102
            r22.put("firstFrameDecodeTime", r21);     // Catch: Exception -> L102
            MediaMonitor.onSinkMonitor("MediaRender_FirstDecodedFrame", r22.toString());     // Catch: Exception -> L102
            this.isFirstFrame = false;     // Catch: Exception -> L102
        L24:
            if (MediaCodecDecoder.access$1600(this.this$0) != null) goto L29;
            if (r19 == null) goto L29;
            int r23 = r0.size;     // Catch: Exception -> L102
            if (r23 <= 0) goto L29;
            byte[] r24 = new byte[r23];     // Catch: Exception -> L102
            r19.get(r24, 0, r23);     // Catch: Exception -> L102
            r19.clear();     // Catch: Exception -> L102
            MediaCodecDecoder.access$1000(this.this$0).OnAVFrameAvailable(r24, r0.presentationTimeUs);     // Catch: Exception -> L102
        L30:
            VideoJitterBuffer r25 = this.this$0.videoJitterBuffer;     // Catch: Exception -> L102
            if (r25 != null) goto L33;
        L35:
            long r110 = 0;
        L36:
            MediaCodecDecoder.access$910(this.this$0);     // Catch: Exception -> L102
            Long r26 = (Long) MediaCodecDecoder.access$800(this.this$0).get(Long.valueOf(r0.presentationTimeUs));     // Catch: Exception -> L102
            if (r26 == null) goto L45;
            long r111 = r20 - r26.longValue();     // Catch: Exception -> L102
            MediaCodecDecoder.access$1708(this.this$0);     // Catch: Exception -> L102
            MediaCodecDecoder r27 = this.this$0;     // Catch: Exception -> L102
            MediaCodecDecoder.access$1802(r27, r111 + MediaCodecDecoder.access$1800(r27));     // Catch: Exception -> L102
            if ((MediaCodecDecoder.access$1800(this.this$0) / MediaCodecDecoder.access$1700(this.this$0)) > 200) goto L41;
        L43:
            MediaCodecDecoder.access$800(this.this$0).remove(Long.valueOf(r0.presentationTimeUs));     // Catch: Exception -> L102
            goto L45
        L41:
            if ((r20 - MediaCodecDecoder.access$1900(this.this$0)) <= 5000) goto L43;
            long r112 = MediaCodecDecoder.access$1800(this.this$0) / MediaCodecDecoder.access$1700(this.this$0);     // Catch: Exception -> L102
            Logger.w(MediaCodecDecoder.access$200(this.this$0), "decode too slow, 5s average decodeTime is " + r112 + "ms, decode frames is " + MediaCodecDecoder.access$1700(this.this$0) + ", mediacodec save frames: " + MediaCodecDecoder.access$900(this.this$0) + ", wait decode packet is " + MediaCodecDecoder.access$300(this.this$0).size());     // Catch: Exception -> L102
            JSONObject r28 = new JSONObject();     // Catch: Exception -> L102
            r28.put("userId", MediaCodecDecoder.access$1500(this.this$0));     // Catch: Exception -> L102
            r28.put("averDecodeTime", r112);     // Catch: Exception -> L102
            r28.put("decodeFrames", MediaCodecDecoder.access$1700(this.this$0));     // Catch: Exception -> L102
            r28.put("mediacodecSaveFrames", MediaCodecDecoder.access$900(this.this$0));     // Catch: Exception -> L102
            r28.put("waitDecodePackets", MediaCodecDecoder.access$300(this.this$0).size());     // Catch: Exception -> L102
            MediaMonitor.onSinkMonitor("MediaRender_DecodeTime", r28.toString());     // Catch: Exception -> L102
            MediaCodecDecoder.access$1902(this.this$0, r20);     // Catch: Exception -> L102
            MediaCodecDecoder.access$1702(this.this$0, 0);     // Catch: Exception -> L102
            MediaCodecDecoder.access$1802(this.this$0, 0);     // Catch: Exception -> L102
        L45:
            if (MediaCodecDecoder.access$1600(this.this$0) != null) goto L47;
        L49:
            this.errorNumber = 0;     // Catch: Exception -> L102
            if (MediaCodecDecoder.access$700(this.this$0) == null) goto L4;
            MediaCodecDecoder.access$700(this.this$0).releaseOutputBuffer(r10, r110);     // Catch: Exception -> L102
            if (MediaCodecDecoder.access$1000(this.this$0) == null) goto L4;
            MediaCodecDecoder.access$1000(this.this$0).OnAVFrameRendered(null, r0.presentationTimeUs);     // Catch: Exception -> L102
            goto L4
        L47:
            if (MediaCodecDecoder.access$1600(this.this$0).isValid() == true) goto L49;
            Logger.e(MediaCodecDecoder.access$200(this.this$0), "surface is inValid!!!");     // Catch: Exception -> L102
            MediaCodecDecoder.access$1000(this.this$0).OnError(MediaRenderErrorCode.MEDIARENDER_SURFACE_ERROR, "renderThread surface is inValid");     // Catch: Exception -> L102
            goto L49
        L33:
            if (this.isRunning == false) goto L35;
            r110 = r25.doRender(r0.presentationTimeUs * 1000);     // Catch: Exception -> L102
        L29:
            MediaCodecDecoder.access$1000(this.this$0).OnAVFrameAvailable(null, r0.presentationTimeUs);     // Catch: Exception -> L102
            goto L30
        L17:
            Logger.e(MediaCodecDecoder.access$200(this.this$0), "dequeueOutputBuffer failed, mediacodec is null");     // Catch: Exception -> L102
            MediaCodecDecoder.access$1000(this.this$0).OnError(MediaRenderErrorCode.MEDIARENDER_DECODE_ERROR, "mediacodec is null");     // Catch: Exception -> L102
            goto L104
        L7:
            Object r29 = MediaCodecDecoder.access$1100(this.this$0);     // Catch: Exception -> L102
            monitor-enter(r29);     // Catch: Exception -> L102
            MediaCodecDecoder.access$1202(this.this$0, true);     // Catch: Throwable -> L12
            MediaCodecDecoder.access$1100(this.this$0).wait();     // Catch: Throwable -> L12
            MediaCodecDecoder.access$1202(this.this$0, false);     // Catch: Throwable -> L12
            monitor-exit(r29);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Exception -> L102
        L104:
            Logger.i(MediaCodecDecoder.access$200(this.this$0), "RenderThread stop");
        }

        private RenderThread(MediaCodecDecoder r1) {
            this.this$0 = r1;
            super("MediaCodecDecoder$RenderThread");
            this.isRunning = true;
            this.isFirstFrame = true;
            this.errorNumber = 0;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_byted_cast_render_decoder_MediaCodecDecoder$RenderThread_com_larus_apm_impl_protector_RunnableLancet_run(RenderThread r1) {
            r1.com_byted_cast_render_decoder_MediaCodecDecoder$RenderThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ RenderThread(MediaCodecDecoder r1, AnonymousClass1 r10) {
            this(r1);
        }
    }

    private void resetDecoder() {
        this.isInit = false;
        Object r0 = this.decodeLock;
        monitor-enter(r0);
        this.packets.clear();     // Catch: Throwable -> L19
        this.mPtsSet.clear();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        if (this.mediaCodec != null) goto L9;
        return;
    L9:
        if (this.inputWait == false) goto L14;
        if (this.outputWait == false) goto L14;
        this.mediaCodec.reset();     // Catch: Exception -> L16
        return;
    L14:
        Thread.sleep(2);     // Catch: Exception -> L16
    L19:
        th = move-exception;
        throw th;
    }

    private boolean deInit() {
        MediaCodec r1 = this.mediaCodec;     // Catch: Exception -> L7
        if (r1 == null) goto L32;
        r1.flush();     // Catch: Exception -> L7
    L32:
        MediaCodec r10 = this.mediaCodec;     // Catch: Throwable -> L18 Exception -> L20
        if (r10 == null) goto L13;
        r10.stop();     // Catch: Throwable -> L18 Exception -> L20
    L13:
        MediaCodec r11 = this.mediaCodec;
        if (r11 == null) goto L16;
        r11.release();
    L16:
        this.mediaCodec = null;
        this.isInit = false;
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        instanceNum--;
        Logger.i(this.TAG, "deInit: success");
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        Logger.e(this.TAG, "deInit, stop Error");     // Catch: Throwable -> L18
        MediaCodec r12 = this.mediaCodec;
        if (r12 == null) goto L25;
        r12.release();
    L25:
        this.mediaCodec = null;
        this.isInit = false;
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        instanceNum--;
        Logger.i(this.TAG, "deInit: success");
        return false;
    L18:
        th = move-exception;
        MediaCodec r13 = this.mediaCodec;
        if (r13 == null) goto L30;
        r13.release();
    L30:
        this.mediaCodec = null;
        this.isInit = false;
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        instanceNum--;
        Logger.i(this.TAG, "deInit: success");
        throw th;
    L7:
        e = move-exception;
        e.printStackTrace();
        Logger.e(this.TAG, "deInit, flush Error");
        goto L32
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.byted.cast.render.decoder.MediaCodecDecoder$DecodeThread, java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.byted.cast.render.decoder.MediaCodecDecoder$RenderThread, java.lang.Thread] */
    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean start() {
        Logger.i(this.TAG, "start mime: " + this.mime);
        if (this.isNeedCodec == true) goto L5;
        return true;
    L5:
        MediaRenderState r0 = this.state;
        MediaRenderState r10 = MediaRenderState.STATE_EXECUTING;
        if (r0 != r10) goto L9;
        Logger.e(this.TAG, "start failed, reason: isStarted");
        return true;
    L9:
        AnonymousClass1 r11 = null;
        if (this.renderThread != null) goto L13;
        ?? r1 = new RenderThread(this, r11);
        this.renderThread = r1;
        ThreadMethodProxy.setPriority(r1, 10);
        ThreadMethodProxy.start(this.renderThread);
    L13:
        if (this.decodeThread != null) goto L15;
        ?? r12 = new DecodeThread(this, r11);
        this.decodeThread = r12;
        ThreadMethodProxy.start(r12);
    L15:
        this.state = r10;
        if (this.isInit == false) goto L18;
        return true;
    L18:
        if (this.isVideo == false) goto L27;
        if (initDecoder(false) == false) goto L22;
        Logger.d(this.TAG, "hw video decoder init success, resolution: " + this.width + "x" + this.height);
        return true;
    L22:
        Logger.e(this.TAG, "hw video decoder init failure, resolution: " + this.width + "x" + this.height);
        if (initDecoder(true) == false) goto L25;
        Logger.d(this.TAG, "sw video decoder init success, resolution: " + this.width + "x" + this.height);
        return true;
    L25:
        Logger.e(this.TAG, "sw video decoder init failure, resolution: " + this.width + "x" + this.height);
        this.listener.OnError(MediaRenderErrorCode.MEDIARENDER_INIT_ERROR, "init failed");
    L30:
        return false;
    L27:
        if (initDecoder(false) == false) goto L29;
        Logger.i(this.TAG, "hw audio decoder init success");
        return true;
    L29:
        Logger.i(this.TAG, "hw audio decoder init failure");
        goto L30
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean stop() {
        Logger.i(this.TAG, "stop, mime: " + this.mime);
        if (this.isNeedCodec == true) goto L6;
        return true;
    L6:
        if (this.state == MediaRenderState.STATE_EXECUTING) goto L45;
        return true;
    L45:
        DecodeThread r0 = this.decodeThread;     // Catch: InterruptedException -> L30
        if (r0 == null) goto L19;
        r0.stopThread();     // Catch: InterruptedException -> L30
        Object r1 = this.decodeLock;     // Catch: InterruptedException -> L30
        monitor-enter(r1);     // Catch: InterruptedException -> L30
        this.decodeLock.notify();     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        ThreadMethodProxy.join(this.decodeThread, 100);     // Catch: InterruptedException -> L30
        this.decodeThread = null;     // Catch: InterruptedException -> L30
        goto L19
    L16:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L30
    L19:
        RenderThread r10 = this.renderThread;     // Catch: InterruptedException -> L30
        if (r10 == null) goto L32;
        r10.stopThread();     // Catch: InterruptedException -> L30
        Object r11 = this.decodeLock;     // Catch: InterruptedException -> L30
        monitor-enter(r11);     // Catch: InterruptedException -> L30
        this.decodeLock.notify();     // Catch: Throwable -> L27
        monitor-exit(r11);     // Catch: Throwable -> L27
        ThreadMethodProxy.join(this.renderThread, 100);     // Catch: InterruptedException -> L30
        this.renderThread = null;     // Catch: InterruptedException -> L30
        goto L32
    L27:
        th = move-exception;
        throw th;     // Catch: InterruptedException -> L30
    L32:
        this.isSendIdr = false;
        Object r12 = this.decodeLock;
        monitor-enter(r12);
        this.packets.clear();     // Catch: Throwable -> L38
        this.mPtsSet.clear();     // Catch: Throwable -> L38
        monitor-exit(r12);     // Catch: Throwable -> L38
        return deInit();
    L38:
        th = move-exception;
        throw th;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public MediaRenderState getState() {
        return this.state;
    }

    public static /* synthetic */ IMediaDecoderListener access$1000(MediaCodecDecoder r0) {
        return r0.listener;
    }

    public static /* synthetic */ Object access$1100(MediaCodecDecoder r0) {
        return r0.renderLock;
    }

    public static /* synthetic */ int access$1300(MediaCodecDecoder r0) {
        return r0.fps;
    }

    public static /* synthetic */ long access$1400(MediaCodecDecoder r10) {
        return r10.sendFirstIFrameTime;
    }

    public static /* synthetic */ String access$1500(MediaCodecDecoder r0) {
        return r0.userId;
    }

    public static /* synthetic */ Surface access$1600(MediaCodecDecoder r0) {
        return r0.surface;
    }

    public static /* synthetic */ long access$1700(MediaCodecDecoder r10) {
        return r10.decodeFrames;
    }

    public static /* synthetic */ long access$1708(MediaCodecDecoder r10) {
        long r0 = r10.decodeFrames;
        r10.decodeFrames = 1 + r0;
        return r0;
    }

    public static /* synthetic */ long access$1800(MediaCodecDecoder r10) {
        return r10.sumDecodeTimes;
    }

    public static /* synthetic */ long access$1900(MediaCodecDecoder r10) {
        return r10.decodeLogTime;
    }

    public static /* synthetic */ String access$200(MediaCodecDecoder r0) {
        return r0.TAG;
    }

    public static /* synthetic */ int access$2000(MediaCodecDecoder r0) {
        return r0.width;
    }

    public static /* synthetic */ int access$2100(MediaCodecDecoder r0) {
        return r0.height;
    }

    public static /* synthetic */ String access$2200(MediaCodecDecoder r0) {
        return r0.mime;
    }

    public static /* synthetic */ ConcurrentSkipListMap access$300(MediaCodecDecoder r0) {
        return r0.packets;
    }

    public static /* synthetic */ Object access$400(MediaCodecDecoder r0) {
        return r0.decodeLock;
    }

    public static /* synthetic */ boolean access$600(MediaCodecDecoder r0) {
        return r0.isInit;
    }

    public static /* synthetic */ MediaCodec access$700(MediaCodecDecoder r0) {
        return r0.mediaCodec;
    }

    public static /* synthetic */ Map access$800(MediaCodecDecoder r0) {
        return r0.decodeTimeMaps;
    }

    public static /* synthetic */ int access$900(MediaCodecDecoder r0) {
        return r0.decodingFrames;
    }

    public static /* synthetic */ int access$908(MediaCodecDecoder r10) {
        int r0 = r10.decodingFrames;
        r10.decodingFrames = r0 + 1;
        return r0;
    }

    public static /* synthetic */ int access$910(MediaCodecDecoder r10) {
        int r0 = r10.decodingFrames;
        r10.decodingFrames = r0 - 1;
        return r0;
    }

    private boolean checkInputData(byte[] r10) {
        if (this.isVideo == false) goto L63;
        CodecId r0 = this.codecId;
        CodecId r11 = CodecId.H264;
        if (r0 != r11) goto L7;
        int r12 = r10[4] & 31;
    L8:
        if (r12 != 1) goto L14;
        if (this.isSendIdr == true) goto L14;
        Logger.w(this.TAG, "no idr, ignore this P frame");
        return false;
    L14:
        if (r12 != 5) goto L17;
        if (r0 != r11) goto L17;
    L20:
        Logger.i(this.TAG, "Feed I frame");
    L22:
        if (r12 != 7) goto L26;
        if (this.codecId != r11) goto L26;
    L29:
        Logger.i(this.TAG, "Feed SPS frame");
        SPS r13 = new golomb().Parse(r10, this.codecId);
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L32
        r1.put("userId", this.userId);     // Catch: JSONException -> L32
        r1.put("width", r13.width);     // Catch: JSONException -> L32
        r1.put("height", r13.height);     // Catch: JSONException -> L32
        MediaMonitor.onSinkMonitor("MediaRender_FeedSPSFrame", r1.toString());     // Catch: JSONException -> L32
    L34:
        int r14 = r13.width;
        int r15 = this.width;
        if (r14 == r15) goto L37;
    L38:
        if (r14 != 0) goto L40;
    L41:
        r13.width = r15;
        r13.height = this.height;
    L42:
        Logger.i(this.TAG, "videoSizeChanged from " + this.width + "x" + this.height + " to " + r13.width + "x" + r13.height);
        if (this.isNeedResetDeocder == false) goto L45;
        resetDecoder();
    L45:
        config_video_parameters(r13.width, r13.height, this.fps);
    L47:
        if (this.isInit == true) goto L57;
        if (initDecoder(false) == false) goto L52;
        Logger.i(this.TAG, "hw video decoder init success, resolution: " + this.width + "x" + this.height);
        goto L57
    L52:
        if (initDecoder(true) == false) goto L54;
        Logger.e(this.TAG, "sw video decoder init success, resolution: " + this.width + "x" + this.height);
        goto L57
    L54:
        this.listener.OnError(MediaRenderErrorCode.MEDIARENDER_INIT_ERROR, "init failed");
        return false;
    L57:
        if (this.packets.size() <= 30) goto L60;
        this.packets.clear();
    L60:
        if (this.isSendIdr == true) goto L69;
        this.sendFirstIFrameTime = System.currentTimeMillis();
        this.isSendIdr = true;
    L69:
        return true;
    L40:
        if (r13.height != 0) goto L42;
    L37:
        if (r13.height == this.height) goto L47;
    L32:
        e = move-exception;
        e.printStackTrace();
    L26:
        if (r12 != 32) goto L69;
        if (this.codecId != CodecId.H265) goto L69;
    L17:
        if (r12 != 19) goto L22;
        if (r0 != CodecId.H265) goto L22;
    L7:
        r12 = (r10[4] >> 1) & 63;
        goto L8
    L63:
        if (this.packets.size() <= 30) goto L66;
        this.packets.clear();
    L66:
        if (this.isInit == true) goto L69;
        return initDecoder(false);
    }

    private void configAudioFormat(MediaFormat r10) {
        r10.setInteger("channel-count", this.channels);
        r10.setInteger("sample-rate", this.sampleRate);
        r10.setInteger("is-adts", this.isADTS);
        r10.setInteger("aac-profile", this.audioProfile);
        int r0 = 4;
        byte[] r1 = new byte[4];
        CodecId r11 = this.codecId;
        if (r11 != CodecId.AACELD) goto L6;
        r1[0] = -8;
        r1[1] = -24;
        r1[2] = 80;
        r1[3] = 0;
    L8:
        r10.setByteBuffer("csd-0", ByteBuffer.wrap(r1, 0, r0));
        return;
    L6:
        if (r11 != CodecId.AACLC) goto L8;
        r1[0] = 17;
        r1[1] = -112;
        r0 = 2;
        goto L8
    }

    private void configVideoFormat(MediaFormat r10) {
        r10.setInteger("width", this.width);
        r10.setInteger("height", this.height);
        Logger.i(this.TAG, "config video width = " + this.width + ", height = " + this.height);
        r10.setInteger("vendor.qti-ext-dec-picture-order.enable", 1);
        r10.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
        r10.setInteger("vendor.low-latency.enable", 1);
        r10.setInteger("vdec-lowlatency", 1);
        r10.setInteger("need_hwcomposer", 0);
    }

    private synchronized boolean initDecoder(boolean r10) {
        monitor-enter(this);
        Logger.i(this.TAG, "init: mime: " + this.mime);     // Catch: Throwable -> L55
        if (this.mime != null) goto L10;
        Logger.e(this.TAG, "no mime");     // Catch: Throwable -> L55
        monitor-exit(this);
        return false;
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L63;
        MediaCodecInfo.CodecCapabilities r1 = new MediaCodecInfo.CodecCapabilities();     // Catch: Throwable -> L55
        if (instanceNum < r1.getMaxSupportedInstances()) goto L63;
        Logger.e(this.TAG, " max support instances is " + r1.getMaxSupportedInstances());     // Catch: Throwable -> L55
    L63:
    L51:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
        Logger.e(this.TAG, "mediacodec configure failed");     // Catch: Throwable -> L55
        return false;
    L15:
        if ((r10 & this.isVideo) == false) goto L17;
        this.mediaCodec = MediaCodec.createByCodecName("OMX.google.h264.decoder");     // Catch: Exception -> L51 Throwable -> L55
    L18:
        MediaFormat r11 = new MediaFormat();     // Catch: Exception -> L51 Throwable -> L55
        r11.setString("mime", this.mime);     // Catch: Exception -> L51 Throwable -> L55
        if (this.mime.contains("video") == false) goto L22;
        configVideoFormat(r11);     // Catch: Exception -> L51 Throwable -> L55
    L24:
        Surface r0 = this.surface;     // Catch: Exception -> L51 Throwable -> L55
        if (r0 == null) goto L30;
        if (r0.isValid() == true) goto L30;
        Logger.e(this.TAG, "surface is unValid!");     // Catch: Exception -> L51 Throwable -> L55
        this.listener.OnError(MediaRenderErrorCode.MEDIARENDER_SURFACE_ERROR, "surface is unValid");     // Catch: Exception -> L51 Throwable -> L55
        this.surface = null;     // Catch: Exception -> L51 Throwable -> L55
    L30:
        if (CheckFormat(this.mime, r11) == false) goto L48;
        this.mediaCodec.configure(r11, this.surface, null, 0);     // Catch: Exception -> L51 Throwable -> L55
        this.mediaCodec.start();     // Catch: Exception -> L51 Throwable -> L55
        Object r12 = this.renderLock;     // Catch: Throwable -> L55
        monitor-enter(r12);     // Catch: Throwable -> L55
        this.isInit = true;     // Catch: Throwable -> L45
        this.renderLock.notifyAll();     // Catch: Throwable -> L45
        monitor-exit(r12);     // Catch: Throwable -> L45
        instanceNum++;     // Catch: Throwable -> L55
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L40 Throwable -> L55
        r13.put("userId", this.userId);     // Catch: JSONException -> L40 Throwable -> L55
        r13.put("decoderName", this.decoderName);     // Catch: JSONException -> L40 Throwable -> L55
        MediaMonitor.onSinkMonitor("MediaRender_InitDecoder", r13.toString());     // Catch: JSONException -> L40 Throwable -> L55
    L42:
        Logger.i(this.TAG, "init: success!");     // Catch: Throwable -> L55
        monitor-exit(this);
        return true;
    L40:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
        goto L42
    L45:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L48:
        Logger.e(this.TAG, "unsupported format, config failed");     // Catch: Exception -> L51 Throwable -> L55
        monitor-exit(this);
        return false;
    L22:
        if (this.mime.contains("audio") == false) goto L24;
        configAudioFormat(r11);     // Catch: Exception -> L51 Throwable -> L55
        goto L24
    L17:
        this.mediaCodec = MediaCodec.createDecoderByType(this.mime);     // Catch: Exception -> L51 Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public void setMediaDecoderListener(IMediaDecoderListener r1) {
        this.listener = r1;
    }

    public MediaCodecDecoder setSurface(Surface r10) {
        if (r10 != null) goto L4;
    L6:
        Logger.e(this.TAG, "[setSurface]: surface is unValid");
        String r11 = MessageIndication.STATUS_FAILED;
    L12:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L9
        r0.put("userId", this.userId);     // Catch: JSONException -> L9
        r0.put(a.KEY_RESULT, r11);     // Catch: JSONException -> L9
        MediaMonitor.onSinkMonitor("MediaRender_SetSurface", r0.toString());     // Catch: JSONException -> L9
    L11:
        return this;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L4:
        if (r10.isValid() == false) goto L6;
        this.surface = r10;
        r11 = "succ";
        goto L12
    }

    public MediaCodecDecoder setVideoJitterBuffer(VideoJitterBuffer r1) {
        this.videoJitterBuffer = r1;
        return this;
    }

    public MediaCodecDecoder(String r10, CodecId r11) {
        this.TAG = "MediaCodecDecoder";
        this.mediaCodec = null;
        this.surface = null;
        this.width = 1920;
        this.height = 1080;
        this.fps = 30;
        this.channels = 2;
        this.sampleRate = 48000;
        this.samplePerFrame = 1024;
        this.audioProfile = 39;
        this.isADTS = 0;
        this.isNeedCodec = true;
        this.renderThread = null;
        this.decodeThread = null;
        this.isInit = false;
        this.isVideo = true;
        this.renderLock = new Object();
        this.decodeLock = new Object();
        this.state = MediaRenderState.STATE_UNINITIALIZED;
        this.packets = new ConcurrentSkipListMap();
        this.mPtsSet = new ConcurrentSkipListSet();
        this.inputWait = false;
        this.outputWait = false;
        this.isSendIdr = false;
        this.isNeedResetDeocder = false;
        this.lastRecvTime = 0;
        this.decodeTimeMaps = new HashMap();
        this.decodingFrames = 0;
        this.decodeLogTime = 0;
        this.sumDecodeTimes = 0;
        this.decodeFrames = 0;
        this.recvLogTime = 0;
        this.sumRecvTimes = 0;
        this.recvFrames = 0;
        this.sendFirstIFrameTime = 0;
        this.userId = r10;
        this.codecId = r11;
        String r12 = "_" + r10;
        if (r11 != CodecId.H264) goto L6;
        this.mime = "video/avc";
        r12 = r12 + "/video";
        this.isNeedCodec = true;
        this.isVideo = true;
    L17:
        this.TAG += r12;
        if (Utils.getProperty("ro.product.name", "").equals("CHM-TL00") == false) goto L23;
        Logger.i(this.TAG, "device need reset decoder");
        this.isNeedResetDeocder = true;
        return;
    L23:
        return;
    L6:
        if (r11 != CodecId.H265) goto L9;
        this.mime = "video/hevc";
        r12 = r12 + "/video";
        this.isNeedCodec = true;
        this.isVideo = true;
        goto L17
    L9:
        if (r11 != CodecId.AACLC) goto L12;
        this.mime = "audio/mp4a-latm";
        this.audioProfile = 2;
        this.isADTS = 1;
        r12 = r12 + "/audio";
        this.isNeedCodec = true;
        this.isVideo = false;
        goto L17
    L12:
        if (r11 != CodecId.AACELD) goto L15;
        this.mime = "audio/mp4a-latm";
        this.audioProfile = 39;
        r12 = r12 + "/audio";
        this.isNeedCodec = true;
        this.isVideo = false;
        goto L17
    L15:
        if (r11 != CodecId.PCM) goto L21;
        this.mime = "";
        this.isNeedCodec = false;
        this.isVideo = false;
        goto L17
    L21:
        Logger.i(this.TAG, "unsupported CodecId");
    }

    public static /* synthetic */ boolean access$1202(MediaCodecDecoder r0, boolean r1) {
        r0.outputWait = r1;
        return r1;
    }

    public static /* synthetic */ long access$1702(MediaCodecDecoder r0, long r1) {
        r0.decodeFrames = r1;
        return r1;
    }

    public static /* synthetic */ long access$1802(MediaCodecDecoder r0, long r1) {
        r0.sumDecodeTimes = r1;
        return r1;
    }

    public static /* synthetic */ long access$1902(MediaCodecDecoder r0, long r1) {
        r0.decodeLogTime = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$502(MediaCodecDecoder r0, boolean r1) {
        r0.inputWait = r1;
        return r1;
    }

    public boolean CheckFormat(String r13, MediaFormat r14) {
        MediaCodecInfo[] r0 = new MediaCodecList(0).getCodecInfos();
        int r10 = r0.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L24;
        MediaCodecInfo r12 = r0[r11];
        if (r12.isEncoder() == true) goto L23;
        if (Arrays.binarySearch(r12.getSupportedTypes(), r13) < 0) goto L23;
        MediaCodecInfo.CodecCapabilities r15 = r12.getCapabilitiesForType(r13);
        if (r15.isFormatSupported(r14) == true) goto L12;
        if (r13.contains("video") == false) goto L22;
        Logger.w(this.TAG, "Codec: " + r12.getName() + " ,video resolution is not support, setWidth: " + r14.getInteger("width") + " ,setHeight: " + r14.getInteger("height") + " -> maxWidth: " + r15.getVideoCapabilities().getSupportedWidths().getUpper() + " ,maxHeight: " + r15.getVideoCapabilities().getSupportedHeights().getUpper() + " ,minWidth: " + r15.getVideoCapabilities().getSupportedWidths().getLower() + " ,minHeight: " + r15.getVideoCapabilities().getSupportedHeights().getLower());
        goto L23
    L22:
        Logger.w(this.TAG, "audio format is not support, sampleRate: " + r14.getInteger("sample-rate") + " ,channel: " + r14.getInteger("channel-count") + " ,supported sampleRate: " + r15.getAudioCapabilities().getSupportedSampleRates().toString() + " ,channel: " + r15.getAudioCapabilities().getMaxInputChannelCount());
        goto L23
    L12:
        Logger.i(this.TAG, "find Codec: " + r12.getName());
        if (this.isVideo == false) goto L17;
        MediaCodecInfo.VideoCapabilities r16 = r15.getVideoCapabilities();
        if (r16 == null) goto L17;
        Logger.i(this.TAG, "Codec: " + r12.getName() + " ,video resolution format -> maxWidth: " + r16.getSupportedWidths().getUpper() + " ,maxHeight: " + r16.getSupportedHeights().getUpper() + " ,minWidth: " + r16.getSupportedWidths().getLower() + " ,minHeight: " + r16.getSupportedHeights().getLower());
    L17:
        this.decoderName = r12.getName();
        return true;
    L23:
        r11 = r11 + 1;
        goto L3
    L24:
        return false;
    }

    @Override // com.byted.cast.render.decoder.IMediaDecoder
    public boolean sendPacket(byte[] r19, long r20) {
        long r10 = r20;
        if (this.isNeedCodec == true) goto L7;
        this.listener.OnAVFrameAvailable(r19, r10);
        return true;
    L7:
        if (checkInputData(r19) == true) goto L9;
        return false;
    L9:
        Object r11 = this.decodeLock;
        monitor-enter(r11);
    L66:
        th = move-exception;
        throw th;
    L12:
        if (this.isVideo == true) goto L25;
        if (this.mPtsSet.contains(Long.valueOf(r20)) == true) goto L21;
        Logger.v(this.TAG, "addFrame...New...frame.length=" + r19.length + " timestamp=" + r10);     // Catch: Throwable -> L66
        this.mPtsSet.add(Long.valueOf(r20));     // Catch: Throwable -> L66
        if (this.mPtsSet.size() <= 20) goto L27;
        int r0 = 0;
    L19:
        if (r0 >= 10) goto L27;
        SortedSet<Long> r12 = this.mPtsSet;     // Catch: Throwable -> L66
        r12.remove(r12.first());     // Catch: Throwable -> L66
        r0 = r0 + 1;     // Catch: Throwable -> L66
    L27:
        monitor-exit(r11);     // Catch: Throwable -> L66
        if (this.isInit == true) goto L32;
        Logger.w(this.TAG, "decoder is not init");
        return false;
    L32:
        long r13 = System.currentTimeMillis();
        long r14 = this.lastRecvTime;
        long r15 = r13 - r14;
        if (r14 == 0) goto L35;
        this.sumRecvTimes += r15;
        this.recvFrames++;
    L35:
        long r16 = this.recvFrames;
        if (r16 <= 0) goto L38;
        long r17 = this.sumRecvTimes / r16;
    L40:
        if (r17 <= 150) goto L50;
        if ((r13 - this.recvLogTime) <= 2000) goto L50;
        Logger.w(this.TAG, "recvData delay too big, 2s average time is " + r17 + "ms");
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L46
        r1.put("userId", this.userId);     // Catch: JSONException -> L46
        r1.put("log", "averRecvTime: " + r17);     // Catch: JSONException -> L46
        MediaMonitor.onSinkMonitor("MediaRender_RecvTime", r1.toString());     // Catch: JSONException -> L46
    L48:
        this.recvLogTime = r13;
        this.sumRecvTimes = 0;
        this.recvFrames = 0;
    L58:
        this.lastRecvTime = r13;
        Object r18 = this.decodeLock;
        monitor-enter(r18);
        this.packets.put(Long.valueOf(r10), r19);     // Catch: Throwable -> L63
        this.decodeLock.notify();     // Catch: Throwable -> L63
        monitor-exit(r18);     // Catch: Throwable -> L63
        return true;
    L63:
        th = move-exception;
        throw th;
    L46:
        e = move-exception;
        e.printStackTrace();
    L50:
        if (r15 <= 1000) goto L58;
        if (r15 >= 100000) goto L58;
        Logger.w(this.TAG, "recvData delay too big, recvtime is " + r15 + "ms");
        JSONObject r21 = new JSONObject();     // Catch: JSONException -> L56
        r21.put("userId", this.userId);     // Catch: JSONException -> L56
        r21.put("log", "recvTime: " + r15);     // Catch: JSONException -> L56
        MediaMonitor.onSinkMonitor("MediaRender_RecvTime", r21.toString());     // Catch: JSONException -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L38:
        r17 = 0;
        goto L40
    L21:
        Logger.v(this.TAG, "addFrame...Skip...frame.length=" + r19.length + " timestamp=" + r10);     // Catch: Throwable -> L66
        monitor-exit(r11);     // Catch: Throwable -> L66
        return true;
    L25:
        if (this.packets.containsKey(Long.valueOf(r20)) == false) goto L27;
        r10 = r10 + 1;     // Catch: Throwable -> L66
        goto L27
    }

    public MediaCodecDecoder config_video_parameters(int r10, int r11, int r12) {
        Logger.i(this.TAG, "[config_video_parameters]: width = " + r10 + ", height = " + r11 + ", fps = " + r12);
        this.width = r10;
        this.height = r11;
        if (r12 != 0) goto L5;
        r12 = 30;
    L5:
        this.fps = r12;
        return this;
    }

    public MediaCodecDecoder config_audio_parameters(int r10, int r11, int r12, int r13) {
        this.sampleRate = r10;
        this.channels = r11;
        this.samplePerFrame = (r13 / r11) / (r12 / 8);
        Logger.i(this.TAG, "[config_audio_parameters]: sampleRate = " + r10 + ", channels = " + r11 + ", bitwidth = " + r12 + ", frameSize = " + r13 + ", samplePerFrame = " + this.samplePerFrame);
        return this;
    }
}
