package com.byted.cast.render.imp;

import android.content.Context;
import android.os.Build;
import android.view.Surface;
import com.byted.cast.common.CastLogger;
import com.byted.cast.mediacommon.AudioProfile;
import com.byted.cast.mediacommon.MediaMonitor;
import com.byted.cast.mediacommon.render.IAudioFrameListener;
import com.byted.cast.mediacommon.render.ILatencyListener;
import com.byted.cast.mediacommon.render.IVideoFrameListener;
import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.AudioParameter;
import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.mediacommon.render.parameters.VideoParameter;
import com.byted.cast.render.datasource.UrlDataSource;
import com.byted.cast.render.decoder.IMediaDecoder;
import com.byted.cast.render.decoder.MediaCodecDecoder;
import com.byted.cast.render.decoder.NativeVideoDecoder;
import com.byted.cast.render.jitterbuffer.AudioJitterBuffer;
import com.byted.cast.render.jitterbuffer.VideoJitterBuffer;
import com.byted.cast.render.parser.AVParser;
import com.byted.cast.render.render.audio.AudioTrackRender;
import com.byted.cast.render.render.audio.IAudioRender;
import com.byted.cast.render.render.video.IVideoRender;
import com.byted.cast.render.render.video.NativeRender;
import com.byted.cast.render.utils.Dump;
import com.byted.cast.render.utils.LatencyControl;
import com.byted.cast.render.utils.Logger;
import com.byted.cast.render.utils.Utils;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.librarian.a;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class MediaRenderImp {
    private static int instances;
    private final int MaxDumpFrames;
    private String TAG;
    private final HashMap<Integer, IMediaDecoder> audioDecoders;
    private File audioEnableFile;
    private IAudioFrameListener audioFrameListener;
    private AudioJitterBuffer audioJitterBuffer;
    private int audioJitterBufferDelayMs;
    private AudioJitterBuffer.JITTER_MODE audioJitterBufferMode;
    private final LatencyControl audioLatencyControl;
    private final HashMap<Integer, AudioParameter> audioParameters;
    private IAudioRender audioRender;
    AVParser avParser;
    private int bitRate;
    private int bitWidth;
    private int channels;
    private CodecId codecId;
    private int curDumpFrames;
    private final String deviceName;
    private final Dump dumpAudio;
    private File dumpEnableFile;
    private final Dump dumpFrame;
    private final Dump dumpPacket;
    private final Dump dumpPcm;
    private File ffmpegEnableFile;
    private int frameSize;
    private float gain;
    private int height;
    private boolean isOpenDumpAudio;
    private boolean isOpenDumpFrame;
    private boolean isOpenJitterBuffer;
    private boolean isPlayAudio;
    private boolean isUseVideoNativeDecoder;
    private boolean isUseVideoRender;
    private CastLogger mCastLogger;
    private Context mContext;
    private int renderColorFormat;
    private String renderDumpPath;
    private File renderEnableFile;
    private int sampleRate;
    private int sliceHeight;
    private int stride;
    private Surface surface;
    private UrlDataSource urlDataSource;
    private final String userId;
    private int vaildAudioFramesIndex;
    private int vaildVideoFramesIndex;
    private IMediaDecoder videoDecoder;
    private IVideoFrameListener videoFrameListener;
    private VideoJitterBuffer videoJitterBuffer;
    private int videoJitterBufferDelayMs;
    private VideoJitterBuffer.JITTER_MODE videoJitterBufferMode;
    private final LatencyControl videoLatencyControl;
    private VideoParameter videoParameter;
    private IVideoRender videoRender;
    private int width;

    public static /* synthetic */ void access$001(String r0) {
        System.loadLibrary(r0);
    }

    private void initAudioJitterBuffer() {
        AudioJitterBuffer r0 = new AudioJitterBuffer();
        this.audioJitterBuffer = r0;
        r0.setJitterCallback(new AnonymousClass2(this)).setAudioFormat(this.sampleRate, this.channels, this.bitWidth / 8);
        this.audioJitterBuffer.setJitterMode(this.audioJitterBufferMode);
        this.audioJitterBuffer.setJitterPrefetchSize((((((this.audioJitterBufferDelayMs * this.channels) * (this.bitWidth / 8)) * this.sampleRate) / IServerListener.WHAT_BYTELINK_SINK_ERROR) / this.frameSize) + 1);
        this.audioJitterBuffer.setVideoJitterBuffer(this.videoJitterBuffer);
        VideoJitterBuffer r1 = this.videoJitterBuffer;
        if (r1 == null) goto L6;
        r1.setAudioJitterBuffer(this.audioJitterBuffer);
        return;
    }

    private void initVideoDecoder() {
        VideoParameter r0 = this.videoParameter;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.isUseVideoNativeDecoder == false) goto L8;
        this.videoDecoder = new NativeVideoDecoder(this.userId, r0.codecId);
    L10:
        if (this.isUseVideoRender == false) goto L12;
    L14:
        this.videoDecoder.setMediaDecoderListener(new AnonymousClass3(this));
        return;
    L12:
        if (this.isUseVideoNativeDecoder == true) goto L14;
        ((MediaCodecDecoder) this.videoDecoder).setSurface(this.surface);
        goto L14
    L8:
        MediaCodecDecoder r1 = new MediaCodecDecoder(this.userId, r0.codecId).setVideoJitterBuffer(this.videoJitterBuffer);
        VideoParameter r10 = this.videoParameter;
        this.videoDecoder = r1.config_video_parameters(r10.width, r10.height, r10.fps);
        goto L10
    }

    private void initVideoJitterBuffer() {
        Logger.d(this.TAG, "initVideoJitterBuffer audioJitterBuffer = " + this.audioJitterBuffer);
        Logger.d(this.TAG, "initVideoJitterBuffer videoJitterBufferMode = " + this.videoJitterBufferMode);
        VideoJitterBuffer r0 = new VideoJitterBuffer();
        this.videoJitterBuffer = r0;
        r0.setAudioJitterBuffer(this.audioJitterBuffer);
        this.videoJitterBuffer.setJitterMode(this.videoJitterBufferMode);
        this.videoJitterBuffer.setJitterCallback(new AnonymousClass1(this));
        this.videoJitterBuffer.setJitterDelay(this.videoJitterBufferDelayMs);
        AudioJitterBuffer r1 = this.audioJitterBuffer;
        if (r1 == null) goto L6;
        r1.setVideoJitterBuffer(this.videoJitterBuffer);
        return;
    }

    private void startAudioRender() {
        AudioTrackRender r0 = new AudioTrackRender(this.userId);
        this.audioRender = r0;
        r0.config_audio_parameters(this.sampleRate, this.channels, this.bitWidth);
        this.audioRender.start();
    }

    private void startVideoRender() {
        NativeRender r0 = new NativeRender(this.userId, this.deviceName, Build.VERSION.SDK_INT);
        this.videoRender = r0;
        r0.config_video_parameters(this.width, this.height, this.stride, this.sliceHeight, this.renderColorFormat);
        this.videoRender.setSurface(this.surface);
        String r1 = this.renderDumpPath;
        if (r1 == null) goto L5;
        this.videoRender.setDumpPath(r1);
        this.videoRender.isOpenDump(this.isOpenDumpFrame);
    L5:
        this.videoRender.start();
    }

    public void stopUrl() {
        UrlDataSource r0 = this.urlDataSource;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        this.urlDataSource = null;
    }

    public MediaRenderImp(String r10) {
        this.TAG = "MediaRenderImp";
        this.avParser = null;
        this.audioDecoders = new HashMap();
        this.audioJitterBuffer = null;
        this.videoJitterBuffer = null;
        this.audioRender = null;
        this.videoRender = null;
        this.isUseVideoRender = false;
        this.isUseVideoNativeDecoder = false;
        this.surface = null;
        this.channels = 2;
        this.sampleRate = 48000;
        this.bitWidth = 16;
        this.bitRate = 64;
        this.frameSize = 4096;
        this.codecId = CodecId.AACLC;
        this.width = 1920;
        this.height = 1080;
        this.stride = 1920;
        this.sliceHeight = 1080;
        this.renderColorFormat = 19;
        this.audioParameters = new HashMap();
        this.videoFrameListener = null;
        this.audioFrameListener = null;
        this.vaildVideoFramesIndex = 0;
        this.vaildAudioFramesIndex = 0;
        this.isPlayAudio = true;
        this.gain = 1.0f;
        this.isOpenJitterBuffer = true;
        this.videoJitterBufferDelayMs = 100;
        this.audioJitterBufferDelayMs = 150;
        this.videoJitterBufferMode = VideoJitterBuffer.JITTER_MODE.QUALITY_STATIC_MODE;
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.QUALITY_STATIC_MODE;
        this.dumpPacket = new Dump();
        this.dumpFrame = new Dump();
        this.dumpAudio = new Dump();
        this.dumpPcm = new Dump();
        this.dumpEnableFile = null;
        this.ffmpegEnableFile = null;
        this.renderEnableFile = null;
        this.audioEnableFile = null;
        this.isOpenDumpFrame = false;
        this.isOpenDumpAudio = false;
        this.MaxDumpFrames = 50;
        this.curDumpFrames = 0;
        this.mContext = null;
        this.mCastLogger = null;
        this.urlDataSource = null;
        this.userId = r10;
        this.TAG += "/" + r10;
        this.videoLatencyControl = new LatencyControl(r10, "video");
        this.audioLatencyControl = new LatencyControl(r10, "audio");
        String r0 = Utils.getProperty("ro.product.name", "");
        this.deviceName = r0;
        if (instances > 0) goto L5;
    L22:
        Logger.i(this.TAG, "Create MediaRenderImp success, userId: " + r10);
        return;
    L5:
        if (r0.equals("VIDAA_TV") == false) goto L7;
    L16:
        this.isUseVideoRender = true;
    L18:
        if (r0.equals("dredd") == false) goto L20;
    L21:
        this.isUseVideoNativeDecoder = true;
        goto L22
    L20:
        if (r0.equals("HiTV-M1") == false) goto L22;
    L7:
        if (r0.equals("KKHi3751V563") == true) goto L16;
        if (r0.equals("aosp_arbutus") == true) goto L16;
        if (r0.equals("xmen") == true) goto L16;
        if (r0.equals("aosp_pitaya") == true) goto L16;
        if (r0.equals("PD2183") == false) goto L18;
        goto L16
    }

    @JvmStatic
    public static void INVOKESTATIC_com_byted_cast_render_imp_MediaRenderImp_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r10) {
        Intrinsics.checkNotNullParameter(r10, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r10);
        a.c(r10);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r10);
    }

    public static /* synthetic */ IMediaDecoder access$000(MediaRenderImp r0) {
        return r0.videoDecoder;
    }

    public static /* synthetic */ LatencyControl access$100(MediaRenderImp r0) {
        return r0.videoLatencyControl;
    }

    public static /* synthetic */ boolean access$1000(MediaRenderImp r0) {
        return r0.isUseVideoNativeDecoder;
    }

    public static /* synthetic */ IVideoRender access$1100(MediaRenderImp r0) {
        return r0.videoRender;
    }

    public static /* synthetic */ int access$1200(MediaRenderImp r0) {
        return r0.width;
    }

    public static /* synthetic */ int access$1300(MediaRenderImp r0) {
        return r0.height;
    }

    public static /* synthetic */ int access$1400(MediaRenderImp r0) {
        return r0.stride;
    }

    public static /* synthetic */ String access$1600(MediaRenderImp r0) {
        return r0.userId;
    }

    public static /* synthetic */ String access$1800(MediaRenderImp r0) {
        return r0.deviceName;
    }

    public static /* synthetic */ IVideoFrameListener access$1900(MediaRenderImp r0) {
        return r0.videoFrameListener;
    }

    public static /* synthetic */ IAudioRender access$200(MediaRenderImp r0) {
        return r0.audioRender;
    }

    public static /* synthetic */ void access$2000(MediaRenderImp r0) {
        r0.startVideoRender();
    }

    public static /* synthetic */ boolean access$2100(MediaRenderImp r0) {
        return r0.isOpenDumpAudio;
    }

    public static /* synthetic */ Dump access$2200(MediaRenderImp r0) {
        return r0.dumpPcm;
    }

    public static /* synthetic */ AudioJitterBuffer access$2300(MediaRenderImp r0) {
        return r0.audioJitterBuffer;
    }

    public static /* synthetic */ IAudioFrameListener access$2400(MediaRenderImp r0) {
        return r0.audioFrameListener;
    }

    public static /* synthetic */ int access$2500(MediaRenderImp r0) {
        return r0.sampleRate;
    }

    public static /* synthetic */ int access$2600(MediaRenderImp r0) {
        return r0.channels;
    }

    public static /* synthetic */ int access$2700(MediaRenderImp r0) {
        return r0.bitWidth;
    }

    public static /* synthetic */ int access$2800(MediaRenderImp r0) {
        return r0.bitRate;
    }

    public static /* synthetic */ void access$300(MediaRenderImp r0) {
        r0.startAudioRender();
    }

    public static /* synthetic */ LatencyControl access$400(MediaRenderImp r0) {
        return r0.audioLatencyControl;
    }

    public static /* synthetic */ boolean access$500(MediaRenderImp r0) {
        return r0.isOpenDumpFrame;
    }

    public static /* synthetic */ Dump access$600(MediaRenderImp r0) {
        return r0.dumpFrame;
    }

    public static /* synthetic */ int access$700(MediaRenderImp r0) {
        return r0.curDumpFrames;
    }

    public static /* synthetic */ int access$708(MediaRenderImp r10) {
        int r0 = r10.curDumpFrames;
        r10.curDumpFrames = r0 + 1;
        return r0;
    }

    public static /* synthetic */ String access$800(MediaRenderImp r0) {
        return r0.TAG;
    }

    public static /* synthetic */ boolean access$900(MediaRenderImp r0) {
        return r0.isUseVideoRender;
    }

    private IMediaDecoder createAudioDecoder(final int r10) {
        if (this.audioParameters.containsKey(Integer.valueOf(r10)) == true) goto L5;
        return null;
    L5:
        AudioParameter r0 = this.audioParameters.get(Integer.valueOf(r10));
        if (r0 != null) goto L8;
        return null;
    L8:
        MediaCodecDecoder r1 = new MediaCodecDecoder(this.userId + ":" + r10, r0.codecId).config_audio_parameters(r0.sampleRate, r0.channels, r0.bitWidth, r0.frameSize);
        r1.setMediaDecoderListener(new AnonymousClass4(this, r10));
        return r1;
    }

    public MediaRenderState getAudioState(int r10) {
        if (this.audioDecoders.containsKey(Integer.valueOf(r10)) == true) goto L7;
        return MediaRenderState.STATE_UNINITIALIZED;
    L7:
        return this.audioDecoders.get(Integer.valueOf(r10)).getState();
    }

    public Object getParameter(MediaParameter r10) {
        if (r10 != MediaParameter.Audio_Render_BitWidth) goto L7;
        return Integer.valueOf(this.bitWidth);
    L7:
        if (r10 != MediaParameter.Audio_Render_SampleRate) goto L11;
        return Integer.valueOf(this.sampleRate);
    L11:
        if (r10 != MediaParameter.Audio_Render_Channel) goto L15;
        return Integer.valueOf(this.channels);
    L15:
        if (r10 != MediaParameter.Audio_Render_SessionId) goto L21;
        IAudioRender r0 = this.audioRender;
        if (r0 != null) goto L19;
        return null;
    L19:
        return ((AudioTrackRender) r0).getParameter(r10);
    L21:
        if (r10 != MediaParameter.Audio_IsAutoPlay) goto L25;
        return Boolean.valueOf(this.isPlayAudio);
    L25:
        if (r10 != MediaParameter.Video_Decoder_IsSetSurface) goto L33;
        if (this.surface == null) goto L29;
        boolean r11 = true;
    L31:
        return Boolean.valueOf(r11);
    L29:
        r11 = false;
        goto L31
    L33:
        if (r10 != MediaParameter.Audio_Render_volume) goto L37;
        return Float.valueOf(this.gain);
    L37:
        if (r10 != MediaParameter.Audio_Render_max_vol) goto L43;
        IAudioRender r12 = this.audioRender;
        if (r12 != null) goto L41;
        return null;
    L41:
        return Float.valueOf(r12.getMaxVol());
    L43:
        if (r10 != MediaParameter.Audio_Render_min_vol) goto L49;
        IAudioRender r13 = this.audioRender;
        if (r13 != null) goto L47;
        return null;
    L47:
        return Float.valueOf(r13.getMinVol());
    L49:
        if (r10 == MediaParameter.Render_IsUseSoftDecoder) goto L51;
        Logger.e(this.TAG, "setParameter key not found! key: " + r10);
        return null;
    L51:
        return Boolean.valueOf(this.isUseVideoNativeDecoder);
    }

    public MediaRenderState getVideoState(int r1) {
        IMediaDecoder r10 = this.videoDecoder;
        if (r10 != null) goto L7;
        return MediaRenderState.STATE_UNINITIALIZED;
    L7:
        return r10.getState();
    }

    public void sendAVStream(byte[] r10) {
        AVParser r0 = this.avParser;
        if (r0 == null) goto L6;
        r0.sendStream(r10);
        return;
    }

    public void setAudioFrameListener(IAudioFrameListener r1) {
        this.audioFrameListener = r1;
    }

    public void setVideoFrameListener(IVideoFrameListener r1) {
        this.videoFrameListener = r1;
    }

    public boolean startAudioPlayer(int r10) {
        if (this.audioDecoders.containsKey(Integer.valueOf(r10)) == true) goto L11;
        IMediaDecoder r0 = createAudioDecoder(r10);
        if (this.audioDecoders.isEmpty() == true) goto L7;
    L10:
        this.audioDecoders.put(Integer.valueOf(r10), r0);
    L12:
        if (r0 == null) goto L14;
        r0.start();
    L14:
        AudioJitterBuffer r11 = this.audioJitterBuffer;
        if (r11 == null) goto L23;
        r11.start();
    L23:
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L19
        r12.put("userId", this.userId);     // Catch: JSONException -> L19
        r12.put(com.bytedance.android.ec.core.event.a.KEY_RESULT, "succ");     // Catch: JSONException -> L19
        MediaMonitor.onSinkMonitor("MediaRender_StartAudioPlayer", r12.toString());     // Catch: JSONException -> L19
    L21:
        Logger.i(this.TAG, "audioPlayer start success");
        return true;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L7:
        if (this.isOpenJitterBuffer == false) goto L9;
        initAudioJitterBuffer();
    L9:
        startAudioRender();
        goto L10
    L11:
        r0 = this.audioDecoders.get(Integer.valueOf(r10));
        goto L12
    }

    public boolean startVideoPlayer(int r10) {
        if (this.isOpenJitterBuffer == true) goto L5;
    L7:
        initVideoDecoder();
        VideoJitterBuffer r11 = this.videoJitterBuffer;
        if (r11 == null) goto L10;
        r11.start();
    L10:
        IMediaDecoder r12 = this.videoDecoder;
        if (r12 == null) goto L13;
        r12.start();
    L13:
        instances++;
        Logger.i(this.TAG, "videoPlayer start success");
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L16
        r13.put("userId", this.userId);     // Catch: JSONException -> L16
        r13.put(com.bytedance.android.ec.core.event.a.KEY_RESULT, "succ");     // Catch: JSONException -> L16
        MediaMonitor.onSinkMonitor("MediaRender_StartVideoPlayer", r13.toString());     // Catch: JSONException -> L16
    L18:
        return true;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L5:
        if (this.videoJitterBuffer != null) goto L7;
        initVideoJitterBuffer();
        goto L7
    }

    public boolean stopAudioPlayer(int r10) {
        Logger.i(this.TAG, "AudioPlayer stop");
        if (this.audioDecoders.containsKey(Integer.valueOf(r10)) == true) goto L11;
        Logger.e(this.TAG, "AudioPlayer is not exist, id: " + r10);
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L7
        r11.put("userId", this.userId);     // Catch: JSONException -> L7
        r11.put(com.bytedance.android.ec.core.event.a.KEY_RESULT, MessageIndication.STATUS_FAILED);     // Catch: JSONException -> L7
        MediaMonitor.onSinkMonitor("MediaRender_StopAudioPlayer", r11.toString());     // Catch: JSONException -> L7
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    L11:
        IMediaDecoder r0 = this.audioDecoders.get(Integer.valueOf(r10));
        if (r0 == null) goto L14;
        r0.stop();
    L14:
        this.audioDecoders.remove(Integer.valueOf(r10));
        this.audioParameters.remove(Integer.valueOf(r10));
        if (this.audioDecoders.isEmpty() == false) goto L30;
        AudioJitterBuffer r12 = this.audioJitterBuffer;
        if (r12 == null) goto L19;
        r12.stop();
        this.audioJitterBuffer = null;
    L19:
        IAudioRender r13 = this.audioRender;
        if (r13 == null) goto L30;
        r13.stop();
        this.audioRender = null;
    L30:
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L24
        r14.put("userId", this.userId);     // Catch: JSONException -> L24
        r14.put(com.bytedance.android.ec.core.event.a.KEY_RESULT, "succ");     // Catch: JSONException -> L24
        MediaMonitor.onSinkMonitor("MediaRender_StopAudioPlayer", r14.toString());     // Catch: JSONException -> L24
    L26:
        Logger.i(this.TAG, "AudioPlayer stop success");
        return true;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    public boolean stopVideoPlayer(int r10) {
        Logger.i(this.TAG, "VideoPlayer stop");
        IVideoRender r11 = this.videoRender;
        if (r11 == null) goto L5;
        r11.stop();
        this.videoRender = null;
    L5:
        IMediaDecoder r12 = this.videoDecoder;
        if (r12 == null) goto L8;
        r12.stop();
    L8:
        VideoJitterBuffer r13 = this.videoJitterBuffer;
        if (r13 == null) goto L11;
        r13.stop();
    L11:
        this.avParser = null;
        this.videoDecoder = null;
        this.videoJitterBuffer = null;
        this.videoParameter = null;
        instances--;
        Logger.i(this.TAG, "VideoPlayer stop success");
        JSONObject r14 = new JSONObject();     // Catch: JSONException -> L14
        r14.put("userId", this.userId);     // Catch: JSONException -> L14
        r14.put(com.bytedance.android.ec.core.event.a.KEY_RESULT, "succ");     // Catch: JSONException -> L14
        MediaMonitor.onSinkMonitor("MediaRender_StopVideoPlayer", r14.toString());     // Catch: JSONException -> L14
    L16:
        return true;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static /* synthetic */ IVideoRender access$1102(MediaRenderImp r0, IVideoRender r1) {
        r0.videoRender = r1;
        return r1;
    }

    public static /* synthetic */ int access$1202(MediaRenderImp r0, int r1) {
        r0.width = r1;
        return r1;
    }

    public static /* synthetic */ int access$1302(MediaRenderImp r0, int r1) {
        r0.height = r1;
        return r1;
    }

    public static /* synthetic */ int access$1402(MediaRenderImp r0, int r1) {
        r0.stride = r1;
        return r1;
    }

    public static /* synthetic */ int access$1502(MediaRenderImp r0, int r1) {
        r0.sliceHeight = r1;
        return r1;
    }

    public static /* synthetic */ int access$1702(MediaRenderImp r0, int r1) {
        r0.renderColorFormat = r1;
        return r1;
    }

    private void addADTStoPacket(byte[] r10, int r11) {
        int r0 = AudioProfile.getSFI(48000);
        r10[0] = -1;
        r10[1] = -7;
        r10[2] = (byte) ((64 + (r0 << 2)) + 0);
        r10[3] = (byte) (128 + (r11 >> 11));
        r10[4] = (byte) ((r11 & 2047) >> 3);
        r10[5] = (byte) (((r11 & 7) << 5) + 31);
        r10[6] = -4;
    }

    public void setAudioParameter(int r10, AudioParameter r11) {
        if (this.audioParameters.containsKey(Integer.valueOf(r10)) == false) goto L5;
        this.audioParameters.remove(Integer.valueOf(r10));
    L5:
        this.audioParameters.put(Integer.valueOf(r10), r11);
        int r12 = r11.frameSize;
        if (r12 != 0) goto L8;
        r12 = 4096;
    L8:
        this.frameSize = r12;
        this.sampleRate = r11.sampleRate;
        this.channels = r11.channels;
        this.bitWidth = r11.bitWidth;
        this.codecId = r11.codecId;
        Logger.i(this.TAG, "Audio player sampleRate: " + this.sampleRate + ",channels: " + this.channels + ", bitWidth: " + this.bitWidth + ", codecId=" + this.codecId);
    }

    public void setParameter(MediaParameter r14, Object r15) {
        if (r14 != MediaParameter.Audio_Render_routingChangedListener) goto L8;
        IAudioRender r0 = this.audioRender;
        if (r0 == null) goto L100;
        r0.setParameter(r14, r15);
        return;
    L100:
        return;
    L8:
        if (r14 != MediaParameter.Audio_Render_volume) goto L13;
        float r16 = ((Float) r15).floatValue();
        this.gain = r16;
        IAudioRender r17 = this.audioRender;
        if (r17 == null) goto L102;
        r17.setVolume(r16);
        return;
    L102:
        return;
    L13:
        if (r14 != MediaParameter.Audio_IsAutoPlay) goto L16;
        this.isPlayAudio = ((Boolean) r15).booleanValue();
        return;
    L16:
        if (r14 != MediaParameter.Audio_Render_BitWidth) goto L19;
        this.bitWidth = ((Integer) r15).intValue();
        return;
    L19:
        if (r14 != MediaParameter.Audio_Render_SampleRate) goto L22;
        this.sampleRate = ((Integer) r15).intValue();
        return;
    L22:
        if (r14 != MediaParameter.Audio_Render_Channel) goto L25;
        this.channels = ((Integer) r15).intValue();
        return;
    L25:
        if (r14 != MediaParameter.Audio_Render_FrameSize) goto L28;
        this.frameSize = ((Integer) r15).intValue();
        return;
    L28:
        if (r14 != MediaParameter.Audio_Render_BitRate) goto L31;
        this.bitRate = ((Integer) r15).intValue();
        return;
    L31:
        if (r14 != MediaParameter.Video_JitterBuffer_Delay) goto L34;
        this.videoJitterBufferDelayMs = ((Integer) r15).intValue();
        return;
    L34:
        if (r14 != MediaParameter.Audio_JitterBuffer_Delay) goto L37;
        this.audioJitterBufferDelayMs = ((Integer) r15).intValue();
        return;
    L37:
        if (r14 != MediaParameter.Video_JitterBuffer_Mode) goto L47;
        String r18 = this.TAG;
        StringBuilder r1 = new StringBuilder("Video_JitterBuffer_Mode ");
        Integer r19 = (Integer) r15;
        r1.append(r19);
        Logger.d(r18, r1.toString());
        int r110 = r19.intValue();
        if (r110 == 0) goto L45;
        if (r110 == 1) goto L44;
        if (r110 == 2) goto L43;
        Logger.e(this.TAG, "UnSupported videoJitterBuffer Mode");
        return;
    L43:
        this.videoJitterBufferMode = VideoJitterBuffer.JITTER_MODE.QUALITY_STATIC_MODE;
        return;
    L44:
        this.videoJitterBufferMode = VideoJitterBuffer.JITTER_MODE.QUALITY_DYNAMIC_MODE;
        return;
    L45:
        this.videoJitterBufferMode = VideoJitterBuffer.JITTER_MODE.LOW_LATENCY_MODE;
        return;
    L47:
        if (r14 != MediaParameter.Audio_JitterBuffer_Mode) goto L60;
        String r111 = this.TAG;
        StringBuilder r10 = new StringBuilder("Audio_JitterBuffer_Mode ");
        Integer r112 = (Integer) r15;
        r10.append(r112);
        Logger.d(r111, r10.toString());
        int r113 = r112.intValue();
        if (r113 == 0) goto L58;
        if (r113 == 1) goto L57;
        if (r113 != 2) goto L53;
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.QUALITY_STATIC_MODE;
        return;
    L53:
        if (r113 == 3) goto L55;
        Logger.e(this.TAG, "UnSupported audioJitterBuffer Mode");
        return;
    L55:
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.BYPASS_QUEUE_MODE;
        return;
    L57:
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.QUALITY_DYNAMIC_MODE;
        return;
    L58:
        this.audioJitterBufferMode = AudioJitterBuffer.JITTER_MODE.LOW_LATENCY_MODE;
        return;
    L60:
        if (r14 != MediaParameter.Render_IsOpenJitterBuffer) goto L63;
        this.isOpenJitterBuffer = ((Boolean) r15).booleanValue();
        return;
    L63:
        if (r14 != MediaParameter.Render_videoLatencyListener) goto L66;
        this.videoLatencyControl.setLatencyListener((ILatencyListener) r15);
        return;
    L66:
        if (r14 != MediaParameter.Render_audioLatencyListener) goto L69;
        this.audioLatencyControl.setLatencyListener((ILatencyListener) r15);
        return;
    L69:
        if (r14 != MediaParameter.Render_dumpFilePath) goto L79;
        String r114 = (String) r15;
        this.dumpPacket.setFilePath(r114, this.userId + ".h264");
        this.dumpFrame.setFilePath(r114, this.userId + ".yuv");
        this.dumpAudio.setFilePath(r114, this.userId + ".aac");
        this.dumpPcm.setFilePath(r114, this.userId + ".pcm");
        this.renderDumpPath = r114;
        StringBuilder r115 = new StringBuilder();
        r115.append(this.renderDumpPath);
        String r11 = File.separator;
        r115.append(r11);
        r115.append("dump_enable");
        this.dumpEnableFile = new PolarisFileWrapper(r115.toString());
        this.ffmpegEnableFile = new PolarisFileWrapper(this.renderDumpPath + r11 + "ffmpeg_enable");
        this.audioEnableFile = new PolarisFileWrapper(this.renderDumpPath + r11 + "audio_dump");
        if (this.ffmpegEnableFile.exists() == false) goto L73;
        this.isUseVideoNativeDecoder = true;
    L73:
        PolarisFileWrapper r116 = new PolarisFileWrapper(this.renderDumpPath + r11 + "nativeRender_enable");
        this.renderEnableFile = r116;
        if (r116.exists() == true) goto L76;
        return;
    L76:
        if (instances <= 0) goto L125;
        this.isUseVideoRender = true;
        return;
    L125:
        return;
    L79:
        if (r14 != MediaParameter.Render_context) goto L96;
        if ((r15 instanceof Context) == false) goto L93;
        Logger.i(this.TAG, "Render_context: Context");
        Context r117 = (Context) r15;
        this.mContext = r117;
        if (this.dumpEnableFile != null) goto L127;
        String r118 = r117.getExternalFilesDir(null).getPath();
        Logger.i(this.TAG, "W dumpPath:" + r118);
        this.dumpPacket.setFilePath(r118, this.userId + "_" + System.currentTimeMillis() + ".h264");
        this.dumpFrame.setFilePath(r118, this.userId + "_" + System.currentTimeMillis() + ".yuv");
        Dump r119 = this.dumpAudio;
        StringBuilder r12 = new StringBuilder();
        r12.append(this.userId);
        r12.append(".aac");
        r119.setFilePath(r118, r12.toString());
        this.dumpPcm.setFilePath(r118, this.userId + ".pcm");
        this.renderDumpPath = r118;
        StringBuilder r120 = new StringBuilder();
        r120.append(this.renderDumpPath);
        String r13 = File.separator;
        r120.append(r13);
        r120.append("dump_enable");
        this.dumpEnableFile = new PolarisFileWrapper(r120.toString());
        this.ffmpegEnableFile = new PolarisFileWrapper(this.renderDumpPath + r13 + "ffmpeg_enable");
        this.audioEnableFile = new PolarisFileWrapper(this.renderDumpPath + r13 + "audio_dump");
        if (this.ffmpegEnableFile.exists() == false) goto L87;
        this.isUseVideoNativeDecoder = true;
    L87:
        PolarisFileWrapper r121 = new PolarisFileWrapper(this.renderDumpPath + r13 + "nativeRender_enable");
        this.renderEnableFile = r121;
        if (r121.exists() == true) goto L90;
        return;
    L90:
        if (instances <= 0) goto L129;
        this.isUseVideoRender = true;
        return;
    L129:
        return;
    L127:
        return;
    L93:
        if ((r15 instanceof CastLogger) == false) goto L131;
        Logger.i(this.TAG, "Render_context: CastLogger");
        CastLogger r122 = (CastLogger) r15;
        this.mCastLogger = r122;
        r122.d(this.TAG, "CastLogger Ready!");
        Logger.setCastLogger(this.mCastLogger);
        return;
    L131:
        return;
    L96:
        if (r14 != MediaParameter.Render_IsUseSoftDecoder) goto L98;
        this.isUseVideoNativeDecoder = ((Boolean) r15).booleanValue();
        return;
    L98:
        Logger.e(this.TAG, "setParameter key not found! key: " + r14);
    }

    public void setSurface(int r1, Surface r10) {
        this.surface = r10;
    }

    public void setVideoParameter(int r1, VideoParameter r10) {
        this.videoParameter = r10;
    }

    public void startUrl(final int r10, String r11) {
        INVOKESTATIC_com_byted_cast_render_imp_MediaRenderImp_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("MediaRenderJni");     // Catch: Exception -> L4
    L7:
        if (r11.isEmpty() == true) goto L14;
        UrlDataSource r0 = new UrlDataSource();
        this.urlDataSource = r0;
        r0.setDataListener(new AnonymousClass5(this, r10));
        this.urlDataSource.setUrl(r11);
        UrlDataSource r12 = this.urlDataSource;
        if (r12 == null) goto L15;
        r12.start();
        return;
    L15:
        return;
    L14:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static /* synthetic */ void access$2900(MediaRenderImp r0, byte[] r1, int r10) {
        r0.addADTStoPacket(r1, r10);
    }

    public void sendAudioPacket(int r12, byte[] r13, long r14) {
        int r0 = r12 / 10;
        int r15 = r12 % 10;
        String r1 = "";
        boolean r10 = false;
        int r11 = 0;
    L4:
        if (r11 >= 4) goto L6;
        r1 = r1 + String.format("%02x ", new Object[]{Byte.valueOf(r13[r11])});
        r11 = r11 + 1;
        goto L4
    L6:
        Logger.d(this.TAG, "sendAudioPacket type=" + r0 + ", playerId=" + r15 + "aPacket" + r1);
        int r16 = this.vaildAudioFramesIndex + 1;
        this.vaildAudioFramesIndex = r16;
        this.audioLatencyControl.sendDataIn(r15, (long) r16, r14);
        File r17 = this.audioEnableFile;
        if (r17 != null) goto L9;
    L11:
        this.isOpenDumpAudio = r10;
        if (r10 == false) goto L21;
        if (r0 == 0) goto L15;
    L17:
        if (r0 != 1) goto L21;
        if (this.dumpPcm.isReady() == false) goto L21;
        this.dumpPcm.writeData(r13);
        goto L21
    L15:
        if (this.dumpAudio.isReady() == false) goto L17;
        this.dumpAudio.writeData(r13);
    L21:
        IMediaDecoder r18 = this.audioDecoders.get(Integer.valueOf(r15));
        if (r18 == null) goto L37;
        this.audioLatencyControl.decodeIn(r15, r14);
        if (r0 != 0) goto L26;
        r18.sendPacket(r13, r14);
        return;
    L26:
        this.audioLatencyControl.decoded(r15, r14);
        AudioJitterBuffer r19 = this.audioJitterBuffer;
        if (r19 == null) goto L29;
        r19.append(r13, r14);
    L32:
        IAudioFrameListener r20 = this.audioFrameListener;
        if (r20 == null) goto L39;
        r20.onAudioOutput(this.userId, r15, r13, this.sampleRate, this.channels, this.bitWidth, this.bitRate, r14);
        return;
    L39:
        return;
    L29:
        IAudioRender r21 = this.audioRender;
        if (r21 == null) goto L32;
        r21.render(r13, r13.length);
        this.audioLatencyControl.rendered(r15, r14);
        goto L32
    L37:
        return;
    L9:
        if (r17.exists() == false) goto L11;
        r10 = true;
        goto L11
    }

    public void sendVideoPacket(int r10, byte[] r11, long r12) {
        int r0 = this.vaildVideoFramesIndex + 1;
        this.vaildVideoFramesIndex = r0;
        this.videoLatencyControl.sendDataIn(r10, r0, r12);
        File r1 = this.dumpEnableFile;
        if (r1 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        this.isOpenDumpFrame = r13;
        if (this.dumpPacket.isReady() == false) goto L11;
        Logger.i(this.TAG, "sendVideoPacket DUMP H26X");
        this.dumpPacket.writeData(r11);
    L12:
        IVideoRender r14 = this.videoRender;
        if (r14 == null) goto L15;
        r14.isOpenDump(this.isOpenDumpFrame);
    L15:
        VideoJitterBuffer r15 = this.videoJitterBuffer;
        if (r15 == null) goto L26;
        if (this.videoParameter.codecId != CodecId.H264) goto L20;
        int r16 = r11[4] & 31;
    L22:
        if (r16 != 7) goto L24;
        r12 = 0;
    L24:
        r15.append(r11, r12 * 1000);
        return;
    L20:
        r16 = (r11[4] >> 1) & 63;
        goto L22
    L26:
        if (this.videoDecoder == null) goto L28;
        this.videoLatencyControl.decodeIn(r10, r12);
        this.videoDecoder.sendPacket(r11, r12);
        return;
    L28:
        Logger.e(this.TAG, "videoJitterBuffer and videoDecoder is null");
        return;
    L11:
        Logger.i(this.TAG, "sendVideoPacket NO DUMP");
        goto L12
    L5:
        if (r1.exists() == false) goto L7;
        r13 = true;
        goto L8
    }
}
