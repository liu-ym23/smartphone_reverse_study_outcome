package com.byted.cast.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.Surface;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Logger;
import com.byted.cast.common.api.IAudioDataListener;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.ISinkDataListener;
import com.byted.cast.common.api.ISurfaceListener;
import com.byted.cast.engine.VoipEngine;
import com.byted.cast.mediacommon.IMediaRecorder;
import com.byted.cast.mediacommon.MediaSetting;
import com.byted.cast.sdk.core.RTCEngineImpl;
import com.byted.cast.sdk.utils.Utils;
import java.util.TimeZone;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class RTCEngine {
    public static final int INFO_SET_BITRATE_KPS = 400003;
    static boolean isSource;

    public static final enum ConnectState extends Enum<ConnectState> {
        private static final /* synthetic */ ConnectState[] $VALUES = null;
        public static final ConnectState CLOSE = null;
        public static final ConnectState CONNECTED = null;
        public static final ConnectState CONNECTING = null;
        public static final ConnectState CONNECT_FAILED = null;
        public static final ConnectState DISCONNECTED = null;
        public static final ConnectState ERROR = null;
        public static final ConnectState RECONNECTED = null;
        public static final ConnectState RECONNECTING = null;
        public static final ConnectState RECONNECT_FAILED = null;

        static {
            ConnectState r0 = new ConnectState("CLOSE", 0);
            CLOSE = r0;
            ConnectState r1 = new ConnectState("CONNECTING", 1);
            CONNECTING = r1;
            ConnectState r10 = new ConnectState("CONNECTED", 2);
            CONNECTED = r10;
            ConnectState r11 = new ConnectState("CONNECT_FAILED", 3);
            CONNECT_FAILED = r11;
            ConnectState r12 = new ConnectState("DISCONNECTED", 4);
            DISCONNECTED = r12;
            ConnectState r13 = new ConnectState("RECONNECTING", 5);
            RECONNECTING = r13;
            ConnectState r14 = new ConnectState("RECONNECTED", 6);
            RECONNECTED = r14;
            ConnectState r15 = new ConnectState("RECONNECT_FAILED", 7);
            RECONNECT_FAILED = r15;
            ConnectState r16 = new ConnectState("ERROR", 8);
            ERROR = r16;
            $VALUES = new ConnectState[]{r0, r1, r10, r11, r12, r13, r14, r15, r16};
        }

        public static ConnectState[] values() {
            return (ConnectState[]) $VALUES.clone();
        }

        public static ConnectState valueOf(String r1) {
            return (ConnectState) a.a(ConnectState.class, r1);
        }

        private ConnectState(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum ExitReason extends Enum<ExitReason> {
        private static final /* synthetic */ ExitReason[] $VALUES = null;
        public static final ExitReason REASON_DISCONNECT = null;
        public static final ExitReason REASON_FATAL_ERROR = null;
        public static final ExitReason REASON_HEART_BEAT_ERROR = null;
        public static final ExitReason REASON_KICK_OUT = null;
        public static final ExitReason REASON_NETWORK_ERROR = null;
        public static final ExitReason REASON_RECEIVE_SIGNAL_FAILED = null;
        public static final ExitReason REASON_RECONNECT_FAILED = null;
        public static final ExitReason REASON_WIFI_DISCONNECTED = null;

        static {
            ExitReason r0 = new ExitReason("REASON_DISCONNECT", 0);
            REASON_DISCONNECT = r0;
            ExitReason r1 = new ExitReason("REASON_NETWORK_ERROR", 1);
            REASON_NETWORK_ERROR = r1;
            ExitReason r10 = new ExitReason("REASON_KICK_OUT", 2);
            REASON_KICK_OUT = r10;
            ExitReason r11 = new ExitReason("REASON_FATAL_ERROR", 3);
            REASON_FATAL_ERROR = r11;
            ExitReason r12 = new ExitReason("REASON_HEART_BEAT_ERROR", 4);
            REASON_HEART_BEAT_ERROR = r12;
            ExitReason r13 = new ExitReason("REASON_RECONNECT_FAILED", 5);
            REASON_RECONNECT_FAILED = r13;
            ExitReason r14 = new ExitReason("REASON_RECEIVE_SIGNAL_FAILED", 6);
            REASON_RECEIVE_SIGNAL_FAILED = r14;
            ExitReason r15 = new ExitReason("REASON_WIFI_DISCONNECTED", 7);
            REASON_WIFI_DISCONNECTED = r15;
            $VALUES = new ExitReason[]{r0, r1, r10, r11, r12, r13, r14, r15};
        }

        public static ExitReason[] values() {
            return (ExitReason[]) $VALUES.clone();
        }

        public static ExitReason valueOf(String r1) {
            return (ExitReason) a.a(ExitReason.class, r1);
        }

        private ExitReason(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum RuntimeEnv extends Enum<RuntimeEnv> {
        private static final /* synthetic */ RuntimeEnv[] $VALUES = null;
        public static final RuntimeEnv CUSTOM = null;
        public static final RuntimeEnv ONLINE = null;
        public static final RuntimeEnv TESTING = null;

        static {
            RuntimeEnv r0 = new RuntimeEnv("TESTING", 0);
            TESTING = r0;
            RuntimeEnv r1 = new RuntimeEnv("ONLINE", 1);
            ONLINE = r1;
            RuntimeEnv r10 = new RuntimeEnv("CUSTOM", 2);
            CUSTOM = r10;
            $VALUES = new RuntimeEnv[]{r0, r1, r10};
        }

        public static RuntimeEnv[] values() {
            return (RuntimeEnv[]) $VALUES.clone();
        }

        public static RuntimeEnv valueOf(String r1) {
            return (RuntimeEnv) a.a(RuntimeEnv.class, r1);
        }

        private RuntimeEnv(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final enum VideoFormat extends Enum<VideoFormat> {
        private static final /* synthetic */ VideoFormat[] $VALUES = null;
        public static final VideoFormat VIDEO_FORMAT_ABGR = null;
        public static final VideoFormat VIDEO_FORMAT_ARGB = null;
        public static final VideoFormat VIDEO_FORMAT_BGR24 = null;
        public static final VideoFormat VIDEO_FORMAT_BGRA = null;
        public static final VideoFormat VIDEO_FORMAT_ES_H264 = null;
        public static final VideoFormat VIDEO_FORMAT_ES_H265 = null;
        public static final VideoFormat VIDEO_FORMAT_I420 = null;
        public static final VideoFormat VIDEO_FORMAT_NV12 = null;
        public static final VideoFormat VIDEO_FORMAT_NV21 = null;
        public static final VideoFormat VIDEO_FORMAT_RGB24 = null;
        public static final VideoFormat VIDEO_FORMAT_RGB565 = null;
        public static final VideoFormat VIDEO_FORMAT_RGBA = null;
        public static final VideoFormat VIDEO_FORMAT_YUV422P = null;
        public static final VideoFormat VIDEO_FORMAT_YUYV422 = null;
        public static final VideoFormat VIDEO_FORMAT_YVYU422 = null;

        static {
            VideoFormat r0 = new VideoFormat("VIDEO_FORMAT_NV12", 0);
            VIDEO_FORMAT_NV12 = r0;
            VideoFormat r1 = new VideoFormat("VIDEO_FORMAT_NV21", 1);
            VIDEO_FORMAT_NV21 = r1;
            VideoFormat r10 = new VideoFormat("VIDEO_FORMAT_I420", 2);
            VIDEO_FORMAT_I420 = r10;
            VideoFormat r11 = new VideoFormat("VIDEO_FORMAT_YUYV422", 3);
            VIDEO_FORMAT_YUYV422 = r11;
            VideoFormat r12 = new VideoFormat("VIDEO_FORMAT_YVYU422", 4);
            VIDEO_FORMAT_YVYU422 = r12;
            VideoFormat r13 = new VideoFormat("VIDEO_FORMAT_YUV422P", 5);
            VIDEO_FORMAT_YUV422P = r13;
            VideoFormat r14 = new VideoFormat("VIDEO_FORMAT_RGB565", 6);
            VIDEO_FORMAT_RGB565 = r14;
            VideoFormat r15 = new VideoFormat("VIDEO_FORMAT_RGB24", 7);
            VIDEO_FORMAT_RGB24 = r15;
            VideoFormat r16 = new VideoFormat("VIDEO_FORMAT_BGR24", 8);
            VIDEO_FORMAT_BGR24 = r16;
            VideoFormat r17 = new VideoFormat("VIDEO_FORMAT_ARGB", 9);
            VIDEO_FORMAT_ARGB = r17;
            VideoFormat r18 = new VideoFormat("VIDEO_FORMAT_RGBA", 10);
            VIDEO_FORMAT_RGBA = r18;
            VideoFormat r19 = new VideoFormat("VIDEO_FORMAT_ABGR", 11);
            VIDEO_FORMAT_ABGR = r19;
            VideoFormat r20 = new VideoFormat("VIDEO_FORMAT_BGRA", 12);
            VIDEO_FORMAT_BGRA = r20;
            VideoFormat r21 = new VideoFormat("VIDEO_FORMAT_ES_H264", 13);
            VIDEO_FORMAT_ES_H264 = r21;
            VideoFormat r22 = new VideoFormat("VIDEO_FORMAT_ES_H265", 14);
            VIDEO_FORMAT_ES_H265 = r22;
            $VALUES = new VideoFormat[]{r0, r1, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22};
        }

        public static VideoFormat[] values() {
            return (VideoFormat[]) $VALUES.clone();
        }

        public static VideoFormat valueOf(String r1) {
            return (VideoFormat) a.a(VideoFormat.class, r1);
        }

        private VideoFormat(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static String version() {
        return "7.30.1.12";
    }

    public abstract void castCancel();

    public abstract void castRequest();

    public abstract void changeSurfaceFillType(int r1);

    public abstract void connect(String r1, int r10, String r11, String r12);

    public abstract void decodeInput(String r1, long r10);

    public abstract void decodeOutput(String r1, long r10);

    public abstract void destroy();

    public abstract void disconnect();

    public abstract void dumpMediaData(int r1, int r10);

    public abstract void enableSetMaxFps(boolean r1);

    public abstract int getAudioSessionId(String r1);

    public abstract RTCStatistics getStatistics();

    public abstract boolean inputExternalAudioFrame(byte[] r1, int r10);

    public abstract boolean inputExternalScreenFrame(byte[] r1, int r10, int r11, MediaSetting.VideoFormat r12, int r13);

    public abstract boolean inputExternalVideoFrame(byte[] r1, int r10, int r11, MediaSetting.VideoFormat r12, int r13);

    public abstract void kickOutSource(String r1);

    public abstract void onScreenRecordRequestResult(int r1, int r10, Intent r11);

    public abstract void prepareVideoEncoder();

    public abstract void reinit(Context r1, RTCSetting r10, GLSurfaceView r11, IRTCEngineEventListener r12, boolean r13);

    public abstract void removePreviewSurface(Surface r1);

    public abstract void render(String r1, long r10);

    public abstract void requestIDR();

    public abstract void requestIdrFromSource(String r1);

    public abstract void requestScreenRecord(Activity r1, int r10);

    public abstract void sendData(int r1, byte[] r10, long r11, long r12, long r13, long r14);

    public abstract void sendMetaData(String r1);

    public abstract void sendMetaData(String r1, String r10);

    public abstract void setApplication(Application r1);

    public abstract void setAudioDataListener(Boolean r1, IAudioDataListener r10);

    public abstract void setAudioDropPolicyByMs(int r1, int r10);

    public abstract void setAudioEnable(boolean r1);

    public abstract void setAudioMaxDelayByMs(int r1);

    public abstract void setAudioMix(Boolean r1);

    public abstract void setAudioMixScale(int r1);

    public abstract void setAudioProfile(RTCAudioProfile r1);

    public abstract void setAudioVolume(float r1, float r10);

    public abstract void setCallbackToMirror(boolean r1);

    public abstract void setCaptureSource(RTCSetting.VIDEO_SOURCE_TYPE r1);

    public abstract void setCastControl(int r1, int r10);

    public abstract void setCastToken(String r1);

    public abstract void setEncoderWH(int r1, int r10, boolean r11);

    public abstract void setFlashEnable(boolean r1);

    public abstract void setInputPreviewSurface(Surface r1);

    public abstract void setInputSurfaceListener(ISurfaceListener r1);

    public abstract void setJitterMode(int r1);

    public abstract void setMediaProjection(MediaProjection r1);

    public abstract void setPinCode(String r1);

    public abstract void setPlayerVolume(String r1, float r10);

    public abstract void setRandomPortEnabled(boolean r1);

    public abstract void setRecorderNeedResize(boolean r1);

    public abstract void setRestartCapture();

    public abstract void setScreenProfile(RTCScreenProfile r1);

    public abstract void setSendPause(boolean r1);

    public abstract void setSinkDataListener(Boolean r1, Boolean r10, ISinkDataListener r11);

    public abstract void setSinkFeatures(int r1);

    public abstract void setTransType(RTCSetting.TRANS_TYPE r1, RTCSetting.TRANS_TYPE r10);

    public abstract void setVideoCodecID(RTCSetting.VCODEC_ID r1);

    public abstract void setVideoProfile(RTCVideoProfile r1);

    public abstract void setVideoQP(RTCScreenProfile r1, boolean r10);

    public abstract void setVideoQP(RTCVideoProfile r1, boolean r10);

    public abstract void setVideoSourceType(RTCSetting.VIDEO_SOURCE_TYPE r1);

    public abstract void setVideoSurface(String r1, Surface r10);

    public abstract void setVirtualDisplayFlag(int r1);

    public abstract void setVirtualDisplayName(String r1);

    public abstract void setVirtualDisplayWH(int r1, int r10);

    public abstract int sinkInitAndJoinRoom(String r1, String r10, String r11, String r12);

    public abstract int sourceInitAndJoinRoom(String r1, String r10, String r11, String r12);

    public abstract void startScreenRecord();

    public abstract void stopScreenRecord();

    public abstract void switchCamera(String r1);

    public RTCEngine() {
    }

    public static void deinit(ContextManager.CastContext r0) {
        VoipEngine.deinitialize(r0);
    }

    public static ExitReason valueOf(int r0) {
        switch(r0) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L4;
        };
    L4:
        return ExitReason.REASON_FATAL_ERROR;
    L6:
        return ExitReason.REASON_WIFI_DISCONNECTED;
    L8:
        return ExitReason.REASON_RECEIVE_SIGNAL_FAILED;
    L10:
        return ExitReason.REASON_RECONNECT_FAILED;
    L12:
        return ExitReason.REASON_HEART_BEAT_ERROR;
    L14:
        return ExitReason.REASON_FATAL_ERROR;
    L16:
        return ExitReason.REASON_KICK_OUT;
    L18:
        return ExitReason.REASON_NETWORK_ERROR;
    L20:
        return ExitReason.REASON_DISCONNECT;
    }

    public static void setFileLogEnabled(ContextManager.CastContext r0, boolean r1) {
        VoipEngine.setFileLogEnabled(r0, r1);
    }

    public static void setLibraryLoader(ContextManager.CastContext r0, ILibraryLoader r1) {
        VoipEngine.setLibraryLoader(r0, r1);
    }

    public static boolean setLogLevel(ContextManager.CastContext r1, int r10) {
        Logger.setLogLevel(r10);
        ContextManager.getLogger(r1).setLogLevel(r10);
        com.byted.cast.sdk.utils.Logger.setLogLevel(r10);
        if (isSource == false) goto L6;
        IMediaRecorder.-CC.setLogLevel(r10);
    L6:
        return VoipEngine.setLogLevel(r1, r10);
    }

    public static void setLogger(ContextManager.CastContext r1, ILogger r10) {
        Logger.setLogger(r10);
        com.byted.cast.sdk.utils.Logger.setLogger(r10);
        if (isSource == false) goto L5;
        IMediaRecorder.-CC.setLogger(r10);
    L5:
        VoipEngine.setLogger(r1, r10);
    }

    public static void init(Context r10, ContextManager.CastContext r11, boolean r12) {
        isSource = r12;
        init(r10, r11, RuntimeEnv.ONLINE, "", 3230, Utils.getScreenSize(r10).x, Utils.getScreenSize(r10).y, 30, r12);
    }

    public static RTCEngine create(Context r10, ContextManager.CastContext r11, RTCSetting r12, IRTCEngineEventListener r13, boolean r14) {
        return new RTCEngineImpl(r10, r11, r12, r13, r14);
    }

    private static RTCEngine create(Context r10, ContextManager.CastContext r11, RTCSetting r12, GLSurfaceView r13, IRTCEngineEventListener r14, boolean r15) {
        return new RTCEngineImpl(r10, r11, r12, r13, r14, r15);
    }

    public static void init(Context r10, ContextManager.CastContext r11, RuntimeEnv r12, String r13, int r14, int r15, int r16, int r17, boolean r18) {
        init(r10, r11, r12, r13, r14, r15, r16, r17, r18, true);
    }

    public void sendData(int r1, byte[] r10, long r11, long r12, long r13, long r14, int r15, int r16, String r17) {
        sendData(r1, r10, r11, r12, r13, r14);
    }

    public static void init(Context r11, ContextManager.CastContext r12, RuntimeEnv r13, String r14, int r15, int r16, int r17, int r18, boolean r19, boolean r20) {
        init(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, false);
    }

    public static void init(Context r10, ContextManager.CastContext r11, RuntimeEnv r12, String r13, int r14, int r15, int r16, int r17, boolean r18, boolean r19, boolean r20) {
        VoipEngine.DeviceParams r21 = new VoipEngine.DeviceParams();
        r21.deviceId = Utils.getDeviceId(r10);
        r21.sdkVersion = "7.30.1.12";
        r21.app = Utils.getAppName(r10);
        r21.appVersion = Utils.getAppVersion(r10);
        r21.appPackage = Utils.getPackageName(r10);
        r21.os = "Android";
        r21.osVersion = Utils.osVersion();
        r21.deviceModel = Build.MODEL;
        r21.cpuType = Build.CPU_ABI;
        r21.timeZone = TimeZone.getDefault().getID();
        r21.width = r15;
        r21.height = r16;
        r21.fps = r17;
        VoipEngine.initialize(r10, r11, r12, r21, r13, "", r14, r18, r19, r20);
    }
}
