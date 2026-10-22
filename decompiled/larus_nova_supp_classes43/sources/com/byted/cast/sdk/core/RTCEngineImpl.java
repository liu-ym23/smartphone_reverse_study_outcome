package com.byted.cast.sdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.view.Surface;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.StringUtil;
import com.byted.cast.common.api.CodecType;
import com.byted.cast.common.api.IAudioDataListener;
import com.byted.cast.common.api.ISinkDataListener;
import com.byted.cast.common.api.ISurfaceListener;
import com.byted.cast.engine.VoipEngine;
import com.byted.cast.mediacommon.IMediaRecorder;
import com.byted.cast.mediacommon.IMediaRecorderCallback;
import com.byted.cast.mediacommon.MediaSetting;
import com.byted.cast.mediacommon.VideoProfile;
import com.byted.cast.mediacommon.render.IMediaRender;
import com.byted.cast.mediacommon.render.MediaRenderState;
import com.byted.cast.mediacommon.render.parameters.CodecId;
import com.byted.cast.mediacommon.render.parameters.MediaParameter;
import com.byted.cast.mediacommon.render.parameters.VideoParameter;
import com.byted.cast.mediacommon.utils.Logger;
import com.byted.cast.sdk.IRTCEngineEventListener;
import com.byted.cast.sdk.RTCAudioProfile;
import com.byted.cast.sdk.RTCEngine;
import com.byted.cast.sdk.RTCMediaKind;
import com.byted.cast.sdk.RTCScreenProfile;
import com.byted.cast.sdk.RTCSetting;
import com.byted.cast.sdk.RTCStatistics;
import com.byted.cast.sdk.RTCVideoProfile;
import com.byted.cast.sdk.core.rtc.IRemoteMirrorCallback;
import com.byted.cast.sdk.core.rtc.IRemoteMirrorConnector;
import com.byted.cast.sdk.render.audio.AudioActivePlayer;
import com.byted.cast.sdk.render.audio.AudioPassivePlayer;
import com.byted.cast.sdk.render.audio.IAudioListener;
import com.byted.cast.sdk.render.video.NAL;
import com.byted.cast.sdk.render.video.SPS;
import com.byted.cast.sdk.render.video.VideoPlayer;
import com.byted.cast.sdk.render.video.golomb;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RTCEngineImpl extends RTCEngine implements VoipEngine.OnVoipEngineListener, AudioActivePlayer.IAudioFrameReader, IAudioListener {
    private static final String CMD_AUDIO_FOCUS = "audioFocus";
    private static final String CMD_CHANGE_AUDIO_SOURCE = "changeAudioSrc";
    private static final String CMD_CHANGE_BITRATE_LEVEL = "changeBitrateLevel";
    private static final String CMD_CHANGE_BITRATE_MODE = "changeBitrateMode";
    private static final String CMD_CHANGE_BITRATE_QP = "changeBitrateQP";
    private static final String CMD_CHANGE_BITRATE_VALUE = "changeBitrateValue";
    private static final String CMD_CHANGE_ENCODE_MODE = "changeEncodeMode";
    private static final String CMD_CHANGE_FPS = "changeFps";
    private static final String CMD_CHANGE_RESOLUTION = "changeResolution";
    private static final String CMD_JITTER_MODE = "jitterMode";
    private static final String CMD_KEY = "cmd";
    private static final String CMD_REQUEST_IDR = "requestIDR";
    private static final String CMD_STREAM_INFO = "streamInfo";
    private static final int FEATURE_AUDIO_DUP = 1;
    private static final String RTC_USER_ID = "bytelink-remote-mirror";
    private static final String TAG = "RTCEngineImpl";
    private String activeIp;
    private int jamLevel;
    private AudioActivePlayer mAudioActivePlayer;
    private IAudioDataListener mAudioDataListener;
    private Map<String, AudioPassivePlayer> mAudioPassivePlayers;
    private boolean mAutoPlayAudio;
    private Boolean mCallbackDataToUser;
    private boolean mCallbackToMirror;
    private ContextManager.CastContext mCastContext;
    private final Object mCastStateLock;
    private Context mContext;
    private RtpAudioPacket mCurAudioData;
    private boolean mDupAudio;
    private int mDupAudioSeq;
    private Boolean mEnablePlaying;
    private golomb mGolomb;
    private Map<String, Boolean> mIsCastingMap;
    private Map<String, Boolean> mIsFirstFrameMap;
    private boolean mIsMediaRender;
    private int mJitterMode;
    private CastLogger mLogger;
    private IMediaRecorder mMediaRecorder;
    private Map<String, IMediaRender> mMediaRenders;
    private MediaSetting mMediaSetting;
    private CastMonitor mMonitor;
    private RtpAudioPacket mPreAudioData;
    private RtpAudioPacket mPrePreAudioData;
    private Surface mPreviewSurface;
    private RTCEventNotifier mRTCEventNotifier;
    private final IRemoteMirrorCallback mRemoteMirrorCallback;
    IRemoteMirrorConnector mRemoteMirrorConnector;
    private boolean mRemoteMirrorJoined;
    private boolean mRoleSource;
    private volatile boolean mSendPause;
    private RTCSetting mSetting;
    private ISinkDataListener mSinkDataListener;
    private Map<String, VideoInfo> mSinkVideoInfos;
    private Map<String, Surface> mSurfaces;
    private int mTopBitrate;
    private int mTopFps;
    private int mTopHeight;
    private int mTopWidth;
    private int mVaildVideoFramesIndex;
    private RTCSetting.VCODEC_ID mVideoCodecId;
    private byte[] mVideoCodecInfo;
    private Map<String, VideoPlayer> mVideoPlayers;
    private VoipEngine mVoipEngine;
    private IMediaRecorderCallback recorderCallback;
    private ExecutorService singleExecutor;
    private ISurfaceListener surfaceListener;

    /* JADX INFO: renamed from: com.byted.cast.sdk.core.RTCEngineImpl$7, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID = null;

        static {
            int[] r0 = new int[RTCSetting.VCODEC_ID.values().length];
            $SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID = r0;
            r0[RTCSetting.VCODEC_ID.AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID[RTCSetting.VCODEC_ID.H264.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID[RTCSetting.VCODEC_ID.H265.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID[RTCSetting.VCODEC_ID.LOSSLESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public class RtpAudioPacket {
        public byte[] mData;
        public long mRtpTimeStamp;
        public int mSeq;
        public int mSize;
        final /* synthetic */ RTCEngineImpl this$0;

        public RtpAudioPacket(RTCEngineImpl r1, byte[] r10, int r11, int r12) {
            this.this$0 = r1;
            this.mData = r10;
            this.mSeq = r11;
            this.mSize = r12;
            this.mRtpTimeStamp = r11 * 1024;
        }
    }

    public class VideoInfo {
        int height;
        final /* synthetic */ RTCEngineImpl this$0;
        int width;

        private VideoInfo(RTCEngineImpl r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ VideoInfo(RTCEngineImpl r1, AnonymousClass1 r10) {
            this(r1);
        }
    }

    public static /* synthetic */ void a(RTCEngineImpl r0, String r1) {
        r0.lambda$onCastRequest$0(r1);
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static /* synthetic */ void b(RTCEngineImpl r0, String r1, int r10, byte[] r11, RTCSetting.VCODEC_ID r12, long r13) {
        r0.lambda$playVideo$1(r1, r10, r11, r12, r13);
    }

    private void registerServices(Context r1) {
    }

    private void unregisterServices() {
    }

    public void onVideoFrame(String r1, RTCMediaKind r10, int r11, int r12, int r13, boolean r14) {
    }

    private void callRequestIDR() {
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.requestIDR();
        return;
    }

    private boolean createConnector() {
        if (this.mSetting != null) goto L12;
        this.mLogger.w(TAG, "createConnector: mSetting is null");
        return false;
    L12:
        IRemoteMirrorConnector r0 = (IRemoteMirrorConnector) INVOKESTATIC_com_byted_cast_sdk_core_RTCEngineImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.rtc.ByteRtcConnector").newInstance();     // Catch: Exception -> L9
        this.mRemoteMirrorConnector = r0;     // Catch: Exception -> L9
        r0.setRTCCallback(this.mRemoteMirrorCallback);     // Catch: Exception -> L9
        this.mRemoteMirrorConnector.init(this.mContext, this.mSetting.getScreenProfile().getWidth(), this.mSetting.getScreenProfile().getHeight(), this.mSetting.getScreenProfile().getFps(), this.mSetting.getScreenProfile().getMaxBitrate());     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        this.mLogger.w(TAG, "can't find class ByteRTC:" + e);
        this.mRemoteMirrorConnector = null;
        return false;
    }

    private void createMediaRecorderCallback() {
        this.mLogger.i(TAG, "createMediaRecorderCallback");
        this.recorderCallback = new AnonymousClass1(this);
    }

    private int getDynamicFps() {
        int r0 = this.mTopFps;
        switch(this.jamLevel) {
            case 0: goto L15;
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            default: goto L15;
        };
    L15:
        return r0;
    L6:
        if (r0 < 20) goto L16;
        return 20;
    L16:
        return r0;
    L9:
        if (r0 < 25) goto L18;
        return 25;
    L18:
        return r0;
    L12:
        if (r0 < 30) goto L20;
        return 30;
    L20:
        return r0;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void castCancel() {
        this.mLogger.i(TAG, "castCancel+");
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mMediaRecorder == null) goto L8;
        IMediaRecorder.-CC.removeLoggerCallback(this.mLogger);     // Catch: Throwable -> L16
        IMediaRecorder.-CC.removeMonitorCallback(this.mMonitor);     // Catch: Throwable -> L16
        this.mMediaRecorder.removeMediaRecorderCallback(this.recorderCallback);     // Catch: Throwable -> L16
        this.mMediaRecorder.stop();     // Catch: Throwable -> L16
        this.mDupAudioSeq = 0;     // Catch: Throwable -> L16
        this.mCurAudioData = null;     // Catch: Throwable -> L16
        this.mPreAudioData = null;     // Catch: Throwable -> L16
        this.mPrePreAudioData = null;     // Catch: Throwable -> L16
    L8:
        if (this.mRemoteMirrorJoined == false) goto L10;
        this.mRTCEventNotifier.onCancelSuccess();     // Catch: Throwable -> L16
        disconnect();     // Catch: Throwable -> L16
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.mLogger.i(TAG, "castCancel-");
        return;
    L10:
        this.mVoipEngine.castCancel();     // Catch: Throwable -> L16
        goto L11
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void castRequest() {
        this.mLogger.i(TAG, "castRequest");
        if (this.mRemoteMirrorJoined == false) goto L5;
        this.mRTCEventNotifier.onCastSuccess();
        return;
    L5:
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        this.mVoipEngine.castRequest();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void destroy() {
        this.mLogger.i(TAG, "destroy +");
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        unregisterServices();     // Catch: Throwable -> L34
        this.mVoipEngine.setOnVoipEngineListener(null);     // Catch: Exception -> L29 Throwable -> L34
        if (this.mRemoteMirrorJoined == false) goto L8;
    L10:
        AudioActivePlayer r1 = this.mAudioActivePlayer;     // Catch: Exception -> L29 Throwable -> L34
        if (r1 == null) goto L13;
        r1.stop();     // Catch: Exception -> L29 Throwable -> L34
    L20:
        Iterator<String> r10 = this.mVideoPlayers.keySet().iterator();     // Catch: Exception -> L29 Throwable -> L34
    L22:
        if (r10.hasNext() == false) goto L27;
        String r11 = r10.next();     // Catch: Exception -> L29 Throwable -> L34
        if (TextUtils.equals(r11, RTC_USER_ID) == true) goto L22;
        this.mVideoPlayers.get(r11).stopPlay();     // Catch: Exception -> L29 Throwable -> L34
        this.mVideoPlayers.remove(r11);     // Catch: Exception -> L29 Throwable -> L34
        goto L22
    L27:
        this.mVoipEngine.destroy();     // Catch: Exception -> L29 Throwable -> L34
        this.mRTCEventNotifier.remove();     // Catch: Exception -> L29 Throwable -> L34
        this.mSetting = null;     // Catch: Exception -> L29 Throwable -> L34
        this.mContext = null;     // Catch: Exception -> L29 Throwable -> L34
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L34
        this.mLogger.i(TAG, "destroy -");
        return;
    L13:
        Iterator<String> r12 = this.mAudioPassivePlayers.keySet().iterator();     // Catch: Exception -> L29 Throwable -> L34
    L15:
        if (r12.hasNext() == false) goto L20;
        String r13 = r12.next();     // Catch: Exception -> L29 Throwable -> L34
        if (TextUtils.equals(r13, RTC_USER_ID) == true) goto L15;
        this.mAudioPassivePlayers.get(r13).stopPlay();     // Catch: Exception -> L29 Throwable -> L34
        this.mAudioPassivePlayers.remove(r13);     // Catch: Exception -> L29 Throwable -> L34
        goto L15
    L8:
        if (this.mMediaRecorder == null) goto L10;
        IMediaRecorder.-CC.removeLoggerCallback(this.mLogger);     // Catch: Exception -> L29 Throwable -> L34
        IMediaRecorder.-CC.removeMonitorCallback(this.mMonitor);     // Catch: Exception -> L29 Throwable -> L34
        this.mMediaRecorder.removeMediaRecorderCallback(this.recorderCallback);     // Catch: Exception -> L29 Throwable -> L34
        this.mMediaRecorder.stop();     // Catch: Exception -> L29 Throwable -> L34
    L29:
        e = move-exception;
        this.mLogger.w(TAG, "Failed destroy:" + e);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void disconnect() {
        this.mLogger.i(TAG, "disconnect");
        if (this.mRemoteMirrorJoined == false) goto L8;
        this.mLogger.i(TAG, "disconnect RTC");
        IRemoteMirrorConnector r0 = this.mRemoteMirrorConnector;
        if (r0 == null) goto L7;
        r0.leaveRoom();
    L7:
        this.mRTCEventNotifier.onMonitorEvent("rtclink_source_leave_room", "");
        this.mRemoteMirrorJoined = false;
        this.mRTCEventNotifier.onDisconnect(RTCEngine.ExitReason.REASON_KICK_OUT, "rtc_active");
        return;
    L8:
        Object r1 = this.mCastStateLock;
        monitor-enter(r1);
        this.mLogger.i(TAG, "disconnect Bytelink");     // Catch: Throwable -> L13
        this.mVoipEngine.disconnect();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public RTCStatistics getStatistics() {
        RTCStatistics r0 = RTCStatistics.fromJson(this.mVoipEngine.getStatistics());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new RTCStatistics();
    }

    public void onCancelSuccess() {
        this.mLogger.i(TAG, "onCancelSuccess: Source +");
        this.mRTCEventNotifier.onCancelSuccess();
        this.mLogger.i(TAG, "onCancelSuccess: Source -");
    }

    public void onCastSuccess() {
        this.mLogger.i(TAG, "onCastSuccess: Source+");
        this.mDupAudioSeq = 0;
        this.mCurAudioData = null;
        this.mPreAudioData = null;
        this.mPrePreAudioData = null;
        this.mRTCEventNotifier.onCastSuccess();
        this.mLogger.i(TAG, "onCastSuccess: Source-");
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void prepareVideoEncoder() {
        this.mLogger.i(TAG, "prepareVideoEncoder");
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.prepareVideoEncoder();
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void requestIDR() {
        this.mLogger.i(TAG, "requestIDR ++++ mCallbackToMirror=" + this.mCallbackToMirror);
        callRequestIDR();
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setRestartCapture() {
        this.mLogger.i(TAG, "setRestartCapture");
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.reStart();
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void startScreenRecord() {
        this.mLogger.i(TAG, "startScreenRecord:" + this.mMediaSetting.getVideoProfile().getSourceType());
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.addMediaRecorderCallback(this.recorderCallback);
        this.mMediaSetting.getVideoProfile().getSourceType();
        MediaSetting.VIDEO_SOURCE_TYPE r1 = MediaSetting.VIDEO_SOURCE_TYPE.SCREEN;
        this.mMediaRecorder.start();
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void stopScreenRecord() {
        this.mLogger.i(TAG, "stopScreenRecord");
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mMediaRecorder == null) goto L7;
        IMediaRecorder.-CC.removeLoggerCallback(this.mLogger);     // Catch: Throwable -> L9
        IMediaRecorder.-CC.removeMonitorCallback(this.mMonitor);     // Catch: Throwable -> L9
        this.mMediaRecorder.removeMediaRecorderCallback(this.recorderCallback);     // Catch: Throwable -> L9
        this.mMediaRecorder.stop();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_byted_cast_sdk_core_RTCEngineImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r11 = access$001(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class r12 = access$001(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    public static /* synthetic */ RTCEventNotifier access$000(RTCEngineImpl r0) {
        return r0.mRTCEventNotifier;
    }

    public static /* synthetic */ CastLogger access$100(RTCEngineImpl r0) {
        return r0.mLogger;
    }

    public static /* synthetic */ RtpAudioPacket access$1000(RTCEngineImpl r0) {
        return r0.mCurAudioData;
    }

    public static /* synthetic */ int access$1104(RTCEngineImpl r1) {
        int r0 = r1.mDupAudioSeq + 1;
        r1.mDupAudioSeq = r0;
        return r0;
    }

    public static /* synthetic */ VoipEngine access$1400(RTCEngineImpl r0) {
        return r0.mVoipEngine;
    }

    public static /* synthetic */ Boolean access$1600(RTCEngineImpl r0) {
        return r0.mCallbackDataToUser;
    }

    public static /* synthetic */ Boolean access$1700(RTCEngineImpl r0) {
        return r0.mEnablePlaying;
    }

    public static /* synthetic */ boolean access$1800(RTCEngineImpl r0) {
        return r0.mIsMediaRender;
    }

    public static /* synthetic */ Map access$1900(RTCEngineImpl r0) {
        return r0.mMediaRenders;
    }

    public static /* synthetic */ boolean access$200(RTCEngineImpl r0) {
        return r0.mSendPause;
    }

    public static /* synthetic */ Map access$2000(RTCEngineImpl r0) {
        return r0.mSurfaces;
    }

    public static /* synthetic */ golomb access$2100(RTCEngineImpl r0) {
        return r0.mGolomb;
    }

    public static /* synthetic */ Map access$2200(RTCEngineImpl r0) {
        return r0.mVideoPlayers;
    }

    public static /* synthetic */ Map access$2300(RTCEngineImpl r0) {
        return r0.mAudioPassivePlayers;
    }

    public static /* synthetic */ boolean access$2400(RTCEngineImpl r0) {
        return r0.mRoleSource;
    }

    public static /* synthetic */ RTCSetting access$2500(RTCEngineImpl r0) {
        return r0.mSetting;
    }

    public static /* synthetic */ Object access$2600(RTCEngineImpl r0) {
        return r0.mCastStateLock;
    }

    public static /* synthetic */ IMediaRecorder access$2700(RTCEngineImpl r0) {
        return r0.mMediaRecorder;
    }

    public static /* synthetic */ CastMonitor access$2800(RTCEngineImpl r0) {
        return r0.mMonitor;
    }

    public static /* synthetic */ IMediaRecorderCallback access$2900(RTCEngineImpl r0) {
        return r0.recorderCallback;
    }

    public static /* synthetic */ byte[] access$300(RTCEngineImpl r0) {
        return r0.mVideoCodecInfo;
    }

    public static /* synthetic */ Context access$3200(RTCEngineImpl r0) {
        return r0.mContext;
    }

    public static /* synthetic */ ContextManager.CastContext access$3300(RTCEngineImpl r0) {
        return r0.mCastContext;
    }

    public static /* synthetic */ void access$3600(RTCEngineImpl r0) {
        r0.callRequestIDR();
    }

    public static /* synthetic */ boolean access$400(RTCEngineImpl r0) {
        return r0.mRemoteMirrorJoined;
    }

    public static /* synthetic */ boolean access$700(RTCEngineImpl r0) {
        return r0.mDupAudio;
    }

    public static /* synthetic */ RtpAudioPacket access$800(RTCEngineImpl r0) {
        return r0.mPrePreAudioData;
    }

    public static /* synthetic */ RtpAudioPacket access$900(RTCEngineImpl r0) {
        return r0.mPreAudioData;
    }

    private void callSetBitrateKps(int r10) {
        if (this.mCallbackToMirror == false) goto L7;
        this.mLogger.i(TAG, "callSetBitrateKps: dispatch to onInfo(INFO_SET_BITRATE_KPS) bitrate=" + r10);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L11;
        r0.onInfo(RTCEngine.INFO_SET_BITRATE_KPS, r10, null);
        return;
    L11:
        return;
    L7:
        IMediaRecorder r1 = this.mMediaRecorder;
        if (r1 == null) goto L13;
        r1.setBitrateKps(r10);
        return;
    }

    private void callSetFps(int r10) {
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setFps(r10);
        return;
    }

    private int getDynamicBitrate(int r10) {
        int r0 = this.mTopBitrate;
        int r1 = this.jamLevel;
        switch(r1) {
            case 0: goto L15;
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            default: goto L15;
        };
    L5:
        int r11 = (r0 * 5) / 10;
        int r12 = ((((this.mTopWidth * this.mTopHeight) * r10) * 8) / 100) / 1024;
        if (r11 > r12) goto L14;
        return r11;
    L14:
        return r12;
    L8:
        int r13 = (r0 * 5) / 10;
        r12 = ((((this.mTopWidth * this.mTopHeight) * r10) * 15) / 100) / 1024;
        if (r13 > r12) goto L14;
        return r13;
    L11:
        int r14 = (r0 * (10 - r1)) / 10;
        r12 = ((((this.mTopWidth * this.mTopHeight) * r10) * 20) / 100) / 1024;
        if (r14 > r12) goto L14;
        return r14;
    L15:
        return r0;
    }

    private /* synthetic */ void lambda$onCastRequest$0(String r10) {
        setVideoSurface(r10, null);
    }

    private void removeSurface(String r10) {
        Surface r0 = this.mSurfaces.get(r10);
        this.mLogger.i(TAG, "removeSurface:" + r10 + ", surface:" + r0);
        if (r0 == null) goto L6;
        this.mSurfaces.remove(r10);
        return;
    }

    private void startAudioPlayback(String r10) {
        this.mLogger.i(TAG, "startAudioPlayback end !!!" + r10);
    }

    private void stopAudioPlayback(String r10) {
        this.mLogger.i(TAG, "stopAudioPlayback userId=" + r10);
        if (this.mIsMediaRender == false) goto L7;
        IMediaRender r11 = this.mMediaRenders.get(r10);
        if (r11 == null) goto L14;
        r11.stopAudioPlayer(0);
        return;
    L14:
        return;
    L7:
        AudioActivePlayer r0 = this.mAudioActivePlayer;
        if (r0 == null) goto L10;
        r0.stop();
        return;
    L10:
        AudioPassivePlayer r1 = this.mAudioPassivePlayers.get(r10);
        if (r1 == null) goto L17;
        this.mAudioPassivePlayers.remove(r10);
        r1.stopPlay();
        return;
    }

    private void stopVideoPlayback(String r10) {
        this.mLogger.i(TAG, "stopVideoPlayback userId=" + r10);
        if (this.mIsMediaRender == false) goto L7;
        IMediaRender r0 = this.mMediaRenders.get(r10);
        if (r0 == null) goto L10;
        r0.stopVideoPlayer(0);
    L10:
        removeSurface(r10);
        return;
    L7:
        VideoPlayer r1 = this.mVideoPlayers.get(r10);
        if (r1 == null) goto L10;
        this.mVideoPlayers.remove(r10);
        r1.stopPlay();
        goto L10
    }

    private void stopVideoPlaybackWithSurface(String r10) {
        this.mLogger.i(TAG, "stopVideoPlaybackWithSurface userId=" + r10);
        if (this.mIsMediaRender == false) goto L7;
        IMediaRender r11 = this.mMediaRenders.get(r10);
        if (r11 == null) goto L11;
        r11.stopVideoPlayer(0);
        return;
    L11:
        return;
    L7:
        VideoPlayer r0 = this.mVideoPlayers.get(r10);
        if (r0 == null) goto L13;
        this.mVideoPlayers.remove(r10);
        r0.stopPlay();
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void changeSurfaceFillType(int r10) {
        this.mLogger.i(TAG, "changeSurfaceFillType: type=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.changeSurfaceFillType(MediaSetting.FILL_TYPE.values()[r10]);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void enableSetMaxFps(boolean r10) {
        this.mLogger.i(TAG, "enableSetMaxFps: enabled=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.enableSetMaxFps(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public int getAudioSessionId(String r10) {
        Iterator<String> r0 = this.mAudioPassivePlayers.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        if (TextUtils.equals(r10, r1) == false) goto L4;
        AudioPassivePlayer r11 = this.mAudioPassivePlayers.get(r1);
    L9:
        if (r11 != null) goto L11;
        return -1;
    L11:
        return r11.getAudioSessionId();
    L8:
        r11 = null;
        goto L9
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void kickOutSource(String r10) {
        this.mLogger.i(TAG, "kickOutSource: userId=" + r10);
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        stopAudioPlayback(r10);     // Catch: Throwable -> L18
        stopVideoPlayback(r10);     // Catch: Throwable -> L18
        if (this.mIsMediaRender == false) goto L10;
        if (this.mMediaRenders.get(r10) == null) goto L10;
        this.mMediaRenders.remove(r10);     // Catch: Throwable -> L18
    L10:
        if (RTC_USER_ID.equals(r10) == false) goto L15;
        IRemoteMirrorConnector r11 = this.mRemoteMirrorConnector;     // Catch: Throwable -> L18
        if (r11 == null) goto L14;
        r11.leaveRoom();     // Catch: Throwable -> L18
    L14:
        this.mRTCEventNotifier.onMonitorEvent("rtclink_sink_leave_room", "");     // Catch: Throwable -> L18
        this.mRemoteMirrorJoined = false;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L15:
        this.mVoipEngine.kickOutSource(r10);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public void onCancelRequest(String r10) {
        this.mLogger.i(TAG, "onCancelRequest: userId=" + r10);
        Map<String, Boolean> r0 = this.mIsFirstFrameMap;
        Boolean r1 = Boolean.FALSE;
        r0.put(r10, r1);
        this.mIsCastingMap.put(r10, r1);
        this.mRTCEventNotifier.onCancelRequest(r10);
        stopAudioPlayback(r10);
        stopVideoPlayback(r10);
        if (this.mIsMediaRender == true) goto L5;
        return;
    L5:
        if (this.mMediaRenders.get(r10) == null) goto L9;
        this.mMediaRenders.remove(r10);
        return;
    }

    public void onCastPause(RTCMediaKind r10) {
        this.mLogger.i(TAG, "onCastPause: " + r10.toString());
        IMediaRecorder r11 = this.mMediaRecorder;
        if (r11 == null) goto L6;
        r11.pause();
        return;
    }

    public void onCastResume(RTCMediaKind r10) {
        this.mLogger.i(TAG, "onCastResume: " + r10.toString());
        IMediaRecorder r11 = this.mMediaRecorder;
        if (r11 == null) goto L6;
        r11.resume();
        return;
    }

    public void onConnectStateChanged(RTCEngine.ConnectState r10) {
        this.mRTCEventNotifier.onConnectStateChanged(r10);
    }

    public void onIdrRequest(RTCMediaKind r10) {
        this.mLogger.i(TAG, "onIdrRequest: " + r10.toString());
        callRequestIDR();
    }

    public void onRecvMetaData(String r17) {
        if (this.mSendPause == false) goto L64;
        this.mLogger.i(TAG, "ignore: onRecvMetaData from sink! " + r17);
        return;
    L64:
        JSONObject r11 = new JSONObject(r17);     // Catch: JSONException -> L60
        String r13 = JSONObjectProtectorUtils.getString(r11, CMD_KEY);     // Catch: JSONException -> L60
        if (TextUtils.equals(r13, CMD_REQUEST_IDR) == false) goto L11;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_REQUEST_IDR from sink!");     // Catch: JSONException -> L60
        onIdrRequest(RTCMediaKind.SCREEN);     // Catch: JSONException -> L60
    L63:
    L61:
        this.mRTCEventNotifier.onRecvMetaData(r17);
        return;
    L11:
        if (TextUtils.equals(r13, CMD_JITTER_MODE) == false) goto L18;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_JITTER_MODE from sink!");     // Catch: JSONException -> L60
        int r10 = JSONObjectProtectorUtils.getInt(r11, "mode");     // Catch: JSONException -> L60
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_JITTER_MODE from sink! mode=" + r10);     // Catch: JSONException -> L60
        if (r10 == this.mJitterMode) goto L63;
        if (r10 != 0) goto L16;
        this.mJitterMode = 0;     // Catch: JSONException -> L60
        goto L63
    L16:
        this.mJitterMode = 1;     // Catch: JSONException -> L60
        callSetFps(this.mTopFps);     // Catch: JSONException -> L60
        callSetBitrateKps(this.mTopBitrate);     // Catch: JSONException -> L60
        goto L63
    L18:
        if (TextUtils.equals(r13, CMD_CHANGE_RESOLUTION) == false) goto L25;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_RESOLUTION from sink!");     // Catch: JSONException -> L60
        int r12 = JSONObjectProtectorUtils.getInt(r11, "width");     // Catch: JSONException -> L60
        int r14 = JSONObjectProtectorUtils.getInt(r11, "height");     // Catch: JSONException -> L60
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_RESOLUTION from sink! width=" + r12 + " height=" + r14);     // Catch: JSONException -> L60
        IMediaRecorder r15 = this.mMediaRecorder;     // Catch: JSONException -> L60
        if (r15 == null) goto L63;
        if (r12 <= 0) goto L63;
        if (r14 <= 0) goto L63;
        r15.setDisplay(r12, r14, 0, 0);     // Catch: JSONException -> L60
        this.mMediaRecorder.reStart();     // Catch: JSONException -> L60
        goto L63
    L25:
        if (TextUtils.equals(r13, CMD_CHANGE_FPS) == false) goto L32;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_FPS from sink!");     // Catch: JSONException -> L60
        int r1 = JSONObjectProtectorUtils.getInt(r11, "fps");     // Catch: JSONException -> L60
        if (r1 <= 0) goto L63;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_FPS from sink! fps=" + r1);     // Catch: JSONException -> L60
        callSetFps(r1);     // Catch: JSONException -> L60
        IMediaRecorder r16 = this.mMediaRecorder;     // Catch: JSONException -> L60
        if (r16 == null) goto L63;
        r16.reStart();     // Catch: JSONException -> L60
        goto L63
    L32:
        if (TextUtils.equals(r13, CMD_CHANGE_AUDIO_SOURCE) == false) goto L40;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_AUDIO_SOURCE from sink!");     // Catch: JSONException -> L60
        int r18 = JSONObjectProtectorUtils.getInt(r11, "scale");     // Catch: JSONException -> L60
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_AUDIO_SOURCE from sink! scale=" + r18);     // Catch: JSONException -> L60
        IMediaRecorder r19 = this.mMediaRecorder;     // Catch: JSONException -> L60
        if (r19 == null) goto L63;
        if (r18 < 0) goto L63;
        if (r18 > 100) goto L63;
        r19.setAudioEnable(true);     // Catch: JSONException -> L60
        this.mMediaRecorder.enableAudioMix(true);     // Catch: JSONException -> L60
        this.mMediaRecorder.setAudioSource(8);     // Catch: JSONException -> L60
        this.mMediaRecorder.setAudioMixScale(r18);     // Catch: JSONException -> L60
        this.mMediaRecorder.setSeparateAudio(false);     // Catch: JSONException -> L60
        goto L63
    L40:
        if (TextUtils.equals(r13, CMD_CHANGE_BITRATE_MODE) == false) goto L44;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_BITRATE_MODE from sink!");     // Catch: JSONException -> L60
        int r20 = JSONObjectProtectorUtils.getInt(r11, "mode");     // Catch: JSONException -> L60
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_BITRATE_MODE from sink! mode=" + r20);     // Catch: JSONException -> L60
        callSetBitrateKps(r20);     // Catch: JSONException -> L60
        goto L63
    L44:
        if (TextUtils.equals(r13, CMD_CHANGE_BITRATE_QP) == false) goto L49;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_BITRATE_QP from sink!");     // Catch: JSONException -> L60
        int r21 = JSONObjectProtectorUtils.getInt(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);     // Catch: JSONException -> L60
        if (this.mMediaRecorder == null) goto L63;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_BITRATE_QP from sink! qp=" + r21);     // Catch: JSONException -> L60
        this.mMediaRecorder.setVirtualDisplayFlag(r21);     // Catch: JSONException -> L60
        this.mMediaRecorder.reStart();     // Catch: JSONException -> L60
        goto L63
    L49:
        if (TextUtils.equals(r13, CMD_CHANGE_BITRATE_LEVEL) == false) goto L52;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_BITRATE_LEVEL from sink!");     // Catch: JSONException -> L60
        int r22 = JSONObjectProtectorUtils.getInt(r11, "level");     // Catch: JSONException -> L60
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_BITRATE_LEVEL from sink! level=" + r22);     // Catch: JSONException -> L60
        callSetBitrateKps(r22);     // Catch: JSONException -> L60
        goto L63
    L52:
        if (TextUtils.equals(r13, CMD_CHANGE_BITRATE_VALUE) == false) goto L57;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_BITRATE_VALUE from sink!");     // Catch: JSONException -> L60
        int r23 = JSONObjectProtectorUtils.getInt(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);     // Catch: JSONException -> L60
        if (r23 <= 0) goto L63;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_BITRATE_VALUE from sink! value(kbps)=" + r23);     // Catch: JSONException -> L60
        callSetBitrateKps(r23);     // Catch: JSONException -> L60
        goto L63
    L57:
        if (TextUtils.equals(r13, CMD_CHANGE_ENCODE_MODE) == false) goto L63;
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_ENCODE_MODE from sink!");     // Catch: JSONException -> L60
        int r24 = JSONObjectProtectorUtils.getInt(r11, "mode");     // Catch: JSONException -> L60
        this.mLogger.i(TAG, "onRecvMetaData: receive CMD_CHANGE_ENCODE_MODE from sink! mode=" + r24);     // Catch: JSONException -> L60
        callSetBitrateKps(r24);     // Catch: JSONException -> L60
    L60:
        this.mLogger.i(TAG, "onRecvMetaData: No cmd field");
        goto L61
    }

    public void onServerStart(int r10) {
        Objects.toString(this.mRTCEventNotifier);
        this.mLogger.i(TAG, "onServerStart: port=" + r10);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onServerStart(r10);
        return;
    }

    public void onServerStop(int r10) {
        Objects.toString(this.mRTCEventNotifier);
        this.mLogger.i(TAG, "onServerStop: port=" + r10);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onServerStop(r10);
        return;
    }

    public void onStat(String r10) {
        this.mLogger.d(TAG, "onStat:" + r10);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onStat(r10);
        return;
    }

    public void onStuckStat(String r10) {
        this.mLogger.d(TAG, "onStuckStat:" + r10);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onStuckStat(r10);
        return;
    }

    public void onUpdateRtt(int r10) {
        this.mLogger.i(TAG, "onUpdateRtt: rtt=" + r10 + " jamLevel=" + this.jamLevel + " mJitterMode=" + this.mJitterMode + " mTopFps=" + this.mTopFps + " mTopBitrate=" + this.mTopBitrate + " mTopWidth=" + this.mTopWidth + " mTopHeight=" + this.mTopHeight);
        if (this.mJitterMode == 0) goto L6;
        return;
    L6:
        if (this.jamLevel != r10) goto L8;
        return;
    L8:
        if (r10 >= 0) goto L10;
        return;
    L10:
        if (r10 > 10) goto L26;
        this.jamLevel = r10;
        int r11 = getDynamicFps();
        int r0 = getDynamicBitrate(r11);
        this.mLogger.i(TAG, "onUpdateRtt: fps=" + r11 + " bitrate=" + r0);
        if (r11 > 0) goto L22;
    L17:
        if (r0 <= 0) goto L25;
        callSetBitrateKps(r0);     // Catch: IllegalStateException -> L15
        return;
    L15:
        e = move-exception;
        this.mLogger.w(TAG, "setBitrate in wrong state:" + e);
        return;
    L25:
        return;
    L22:
        callSetFps(r11);     // Catch: IllegalStateException -> L15
        goto L17
    }

    @Override // com.byted.cast.sdk.render.audio.AudioActivePlayer.IAudioFrameReader
    public int readAudioFrame(byte[] r10) {
        RTCSetting r0 = this.mSetting;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return this.mVoipEngine.readRemoteAudioFrame(r10, r10.length, r0.getAudioProfile().getPlaySampleRate());
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void removePreviewSurface(Surface r10) {
        this.mLogger.i(TAG, "removePreviewSurface: surface=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.removeSurface(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void requestIdrFromSource(String r10) {
        this.mLogger.i(TAG, "requestIdrFromSource: userId=" + r10);
        JSONObject r0 = new JSONObject();
        r0.put(CMD_KEY, CMD_REQUEST_IDR);     // Catch: JSONException -> L5
        sendMetaData(r10, r0.toString());     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void sendMetaData(String r10) {
        this.mLogger.i(TAG, "sendMetaData: json=" + r10);
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        this.mVoipEngine.sendMetaData(r10);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mLogger.i(TAG, "sendMetaData-");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setApplication(Application r10) {
        this.mLogger.i(TAG, "setApplication: app=" + r10);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setAudioEnable(boolean r10) {
        this.mLogger.i(TAG, "setAudioEnable: enabled=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setAudioEnable(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setAudioMaxDelayByMs(int r10) {
        this.mVoipEngine.setAudioMaxDelayByMs(r10);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setAudioMix(Boolean r10) {
        this.mLogger.i(TAG, "setAudioMix: enable=" + r10);
        MediaSetting r0 = this.mMediaSetting;
        if (r0 == null) goto L5;
        r0.getAudioProfile().setEnableAudioMix(r10.booleanValue());
    L5:
        IMediaRecorder r1 = this.mMediaRecorder;
        if (r1 == null) goto L9;
        r1.enableAudioMix(r10.booleanValue());
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setAudioMixScale(int r10) {
        this.mLogger.i(TAG, "setAudioMixScale: factor=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setAudioMixScale(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setAudioProfile(RTCAudioProfile r10) {
        this.mLogger.i(TAG, "setAudioProfile: profile=" + r10.toString());
        if (this.mSetting != null) goto L6;
        this.mLogger.w(TAG, "setAudioProfile: mSetting is null, engine might be destroyed.");
        return;
    L6:
        this.mVoipEngine.setAudioProfile(r10);
        if (this.mSetting.isExternalAudioSource() == true) goto L10;
        this.mSetting.setAudioProfile(r10);
        this.mMediaSetting.getAudioProfile().setAudioSource(r10.getAudioSource());
        this.mMediaSetting.getAudioProfile().setBitwidth(r10.getBitwidth());
        this.mMediaSetting.getAudioProfile().setBitrate(r10.getBitrate(), r10.getMaxBitrate());
        this.mMediaSetting.getAudioProfile().setSampleRate(r10.getRecordSampleRate());
        this.mMediaSetting.getAudioProfile().setEnabled(r10.isEnabled());
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setCallbackToMirror(boolean r10) {
        this.mLogger.i(TAG, "setCallbackToMirror: " + r10);
        this.mCallbackToMirror = r10;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setCaptureSource(RTCSetting.VIDEO_SOURCE_TYPE r10) {
        this.mLogger.i(TAG, "setCaptureSource: type=" + r10);
        this.mMediaSetting.getVideoProfile().setSourceType(MediaSetting.VIDEO_SOURCE_TYPE.values()[r10.ordinal()]);
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        IMediaRecorder r1 = this.mMediaRecorder;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.setCaptureSource(MediaSetting.VIDEO_SOURCE_TYPE.values()[r10.ordinal()]);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setCastToken(String r10) {
        this.mLogger.i(TAG, "setCastToken+");
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        this.mVoipEngine.setCastToken(r10);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mLogger.i(TAG, "setCastToken-");
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setFlashEnable(boolean r10) {
        this.mLogger.i(TAG, "setFlashEnable: enabled=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setFlashEnable(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setInputPreviewSurface(Surface r10) {
        this.mLogger.i(TAG, "setInputPreviewSurface: surface=" + r10);
        this.mPreviewSurface = r10;
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setPreviewSurface(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setInputSurfaceListener(ISurfaceListener r10) {
        this.mLogger.i(TAG, "setInputSurfaceListener:" + r10);
        this.surfaceListener = r10;
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setInputSurfaceListener(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setJitterMode(int r10) {
        this.mLogger.i(TAG, "setJitterMode: mode=" + r10);
        this.mJitterMode = r10;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setMediaProjection(MediaProjection r10) {
        this.mLogger.i(TAG, "setMediaProjection" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setMediaProjection(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setPinCode(String r10) {
        this.mLogger.i(TAG, "setPinCode: pin=" + r10);
        this.mVoipEngine.setPinCode(r10);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setRandomPortEnabled(boolean r10) {
        this.mLogger.i(TAG, "setRandomPortEnabled:" + r10);
        this.mVoipEngine.setRandomPortEnabled(r10);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setRecorderNeedResize(boolean r10) {
        this.mLogger.i(TAG, "setRecorderNeedResize: enabled=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setResizeScreen(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setScreenProfile(RTCScreenProfile r10) {
        this.mLogger.i(TAG, "setScreenProfile: profile=" + r10.toString());
        if (this.mSetting != null) goto L6;
        this.mLogger.w(TAG, "setScreenProfile: mSetting is null, engine might be destroyed.");
        return;
    L6:
        this.mTopFps = r10.getFps();
        this.mTopBitrate = r10.getBitrate();
        this.mTopWidth = r10.getWidth();
        this.mTopHeight = r10.getHeight();
        this.mLogger.i(TAG, "setScreenProfile: mTopFps=" + this.mTopFps + " mTopBitrate=" + this.mTopBitrate + " mTopWidth=" + this.mTopWidth + " mTopHeight=" + this.mTopHeight);
        this.mVoipEngine.setScreenProfile(r10);
        if (this.mSetting.isExternalScreenSource() == true) goto L15;
        this.mSetting.setScreenProfile(r10);
        this.mMediaSetting.getVideoProfile().setMinQP(r10.getMinQP());
        this.mMediaSetting.getVideoProfile().setMaxQP(r10.getMaxQP());
        this.mMediaSetting.getVideoProfile().setMinQPP(r10.getMinQPP());
        this.mMediaSetting.getVideoProfile().setMaxQPP(r10.getMaxQPP());
        this.mMediaSetting.getVideoProfile().setMinQPB(r10.getMinQPB());
        this.mMediaSetting.getVideoProfile().setMaxQPB(r10.getMaxQPB());
        this.mMediaSetting.getVideoProfile().setInitialQP(r10.getInitialQP());
        this.mMediaSetting.getVideoProfile().setInitialQPI(r10.getInitialQPI());
        this.mMediaSetting.getVideoProfile().setInitialQPP(r10.getInitialQPP());
        this.mMediaSetting.getVideoProfile().setInitialQPB(r10.getInitialQPB());
        this.mMediaSetting.getVideoProfile().setQp(r10.getQp());
        this.mMediaSetting.getVideoProfile().setBitrateBps(r10.getBitrateBps());
        if (r10.getBitrateMode() == null) goto L11;
        this.mMediaSetting.getVideoProfile().setBitrateModeStr(r10.getBitrateMode().name());
    L11:
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L16;
        r0.setDisplay(r10.getWidth(), r10.getHeight(), r10.getBitrate(), r10.getFps());
        this.mMediaRecorder.setVideoCodecID(MediaSetting.VCODEC_ID.values()[r10.getCodecId().ordinal()]);
        this.mLogger.i(TAG, "setScreenProfile: VirtualDisplayFlag=" + r10.getVirtualDisplayFlag());
        this.mMediaRecorder.setVirtualDisplayFlag(r10.getVirtualDisplayFlag());
        return;
    L16:
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setSendPause(boolean r10) {
        this.mLogger.i(TAG, "setSendPause: sendPause=" + r10);
        this.mSendPause = r10;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setSinkFeatures(int r10) {
        this.mLogger.i(TAG, "setSinkFeatures: features=" + r10);
        if ((r10 & 1) == 0) goto L6;
        this.mLogger.i(TAG, "setSinkFeatures: enable FEATURE_AUDIO_DUP");
        this.mDupAudio = true;
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVideoCodecID(RTCSetting.VCODEC_ID r10) {
        this.mLogger.i(TAG, "setVideoCodecID: vcodecId=" + r10);
        if (this.mMediaRecorder == null) goto L18;
        MediaSetting.VCODEC_ID r0 = MediaSetting.VCODEC_ID.H264;
        int r11 = AnonymousClass7.$SwitchMap$com$byted$cast$sdk$RTCSetting$VCODEC_ID[r10.ordinal()];
        if (r11 != 1) goto L7;
        r0 = MediaSetting.VCODEC_ID.AUTO;
    L16:
        this.mMediaRecorder.setVideoCodecID(r0);
        return;
    L7:
        if (r11 == 2) goto L16;
        if (r11 != 3) goto L11;
        r0 = MediaSetting.VCODEC_ID.H265;
        goto L16
    L11:
        if (r11 != 4) goto L16;
        r0 = MediaSetting.VCODEC_ID.LOSSLESS;
        goto L16
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVideoProfile(RTCVideoProfile r10) {
        this.mLogger.i(TAG, "setVideoProfile: profile=" + r10);
        if (this.mSetting != null) goto L6;
        this.mLogger.w(TAG, "setVideoProfile: mSetting is null, engine might be destroyed.");
        return;
    L6:
        this.mTopFps = r10.getCameraPreviewFps();
        this.mTopBitrate = r10.getBitrate();
        this.mTopWidth = r10.getCodecWidth();
        this.mTopHeight = r10.getCodecHeight();
        this.mLogger.i(TAG, "setVideoProfile: mTopFps=" + this.mTopFps + " mTopBitrate=" + this.mTopBitrate + " mTopWidth=" + this.mTopWidth + " mTopHeight=" + this.mTopHeight);
        this.mVoipEngine.setVideoProfile(r10);
        if (this.mSetting.isExternalScreenSource() == true) goto L19;
        this.mSetting.setVideoProfile(r10);
        this.mMediaSetting.getVideoProfile().setCameraInfo(r10.getCameraId().ordinal());
        this.mMediaSetting.getVideoProfile().setMinQP(r10.getMinQP());
        this.mMediaSetting.getVideoProfile().setMaxQP(r10.getMaxQP());
        this.mMediaSetting.getVideoProfile().setMinQPP(r10.getMinQPP());
        this.mMediaSetting.getVideoProfile().setMaxQPP(r10.getMaxQPP());
        this.mMediaSetting.getVideoProfile().setMinQPB(r10.getMinQPB());
        this.mMediaSetting.getVideoProfile().setMaxQPB(r10.getMaxQPB());
        this.mMediaSetting.getVideoProfile().setInitialQP(r10.getInitialQP());
        this.mMediaSetting.getVideoProfile().setInitialQPI(r10.getInitialQPI());
        this.mMediaSetting.getVideoProfile().setInitialQPP(r10.getInitialQPP());
        this.mMediaSetting.getVideoProfile().setInitialQPB(r10.getInitialQPB());
        this.mMediaSetting.getVideoProfile().setQp(r10.getQp());
        this.mMediaSetting.getVideoProfile().setBitrateBps(r10.getBitrateBps());
        if (r10.getBitrateMode() == null) goto L11;
        this.mMediaSetting.getVideoProfile().setBitrateModeStr(r10.getBitrateMode().name());
    L11:
        this.mLogger.i(TAG, "setVideoProfile: cameraId=" + r10.getCameraId());
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 != null) goto L14;
        return;
    L14:
        if (r10.getCameraId().ordinal() != 0) goto L16;
        String r11 = "0";
    L17:
        r0.switchCamera(r11);
        return;
    L16:
        r11 = "1";
        goto L17
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVideoSourceType(RTCSetting.VIDEO_SOURCE_TYPE r10) {
        this.mLogger.i(TAG, "setVideoSourceType: videoSourceType=" + r10);
        RTCSetting r0 = this.mSetting;
        if (r0 != null) goto L7;
        this.mLogger.w(TAG, "setVideoSourceType: mSetting is null, engine might be destroyed.");
        return;
    L7:
        if (r0.isExternalScreenSource() == true) goto L10;
        this.mSetting.setVideoSourceType(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVirtualDisplayFlag(int r10) {
        this.mLogger.i(TAG, "setVirtualDisplayFlag: flag=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setVirtualDisplayFlag(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVirtualDisplayName(String r10) {
        this.mLogger.i(TAG, "setVirtualDisplayName: displayName=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setVirtualDisplayName(r10);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void switchCamera(String r10) {
        this.mLogger.i(TAG, "switchCamera: cameraId=" + r10);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.switchCamera(r10);
        return;
    }

    public static /* synthetic */ RtpAudioPacket access$1002(RTCEngineImpl r0, RtpAudioPacket r1) {
        r0.mCurAudioData = r1;
        return r1;
    }

    public static /* synthetic */ int access$1102(RTCEngineImpl r0, int r1) {
        r0.mDupAudioSeq = r1;
        return r1;
    }

    public static /* synthetic */ void access$3000(RTCEngineImpl r0, String r1) {
        r0.stopAudioPlayback(r1);
    }

    public static /* synthetic */ byte[] access$302(RTCEngineImpl r0, byte[] r1) {
        r0.mVideoCodecInfo = r1;
        return r1;
    }

    public static /* synthetic */ void access$3100(RTCEngineImpl r0, String r1) {
        r0.stopVideoPlayback(r1);
    }

    public static /* synthetic */ void access$3400(RTCEngineImpl r0, String r1) {
        r0.startAudioPlayback(r1);
    }

    public static /* synthetic */ boolean access$402(RTCEngineImpl r0, boolean r1) {
        r0.mRemoteMirrorJoined = r1;
        return r1;
    }

    public static /* synthetic */ RtpAudioPacket access$802(RTCEngineImpl r0, RtpAudioPacket r1) {
        r0.mPrePreAudioData = r1;
        return r1;
    }

    public static /* synthetic */ RtpAudioPacket access$902(RTCEngineImpl r0, RtpAudioPacket r1) {
        r0.mPreAudioData = r1;
        return r1;
    }

    private void startVideoPlayback(String r10, boolean r11) {
        this.mLogger.i(TAG, "startVideoPlayback userId=" + r10);
        if (this.mIsMediaRender == false) goto L5;
        return;
    L5:
        Iterator<String> r0 = this.mVideoPlayers.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        String r1 = r0.next();
        if (TextUtils.equals(r10, r1) == false) goto L7;
        VideoPlayer r12 = this.mVideoPlayers.get(r1);
    L12:
        if (r12 != null) goto L18;
        VideoPlayer r13 = new VideoPlayer(r10, this.mCastContext, this.mRTCEventNotifier);
        if (r11 == true) goto L16;
        r13.setVideoFrameListener(this.mVoipEngine);
    L16:
        r13.startPlay();
        this.mVideoPlayers.put(r10, r13);
    L18:
        if (this.mVideoPlayers.size() <= 5) goto L24;
        this.mLogger.e(TAG, "There are already 5 AudioPlayers !");
        this.mVideoPlayers.remove(r10);
        return;
    L24:
        return;
    L11:
        r12 = null;
        goto L12
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void decodeInput(String r10, long r11) {
        this.mVoipEngine.onDecodeIn(r10, r11);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void decodeOutput(String r10, long r11) {
        this.mVoipEngine.onDecoded(r10, r11);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void dumpMediaData(int r10, int r11) {
        this.mVoipEngine.dumpMediaData(r10, r11);
        callRequestIDR();
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public boolean inputExternalAudioFrame(byte[] r10, int r11) {
        RTCSetting r0 = this.mSetting;
        if (r0 != null) goto L5;
    L9:
        this.mLogger.w(TAG, "inputExternalAudioFrame: Not enabled or mSetting is null");
        return false;
    L5:
        if (r0.isExternalAudioSource() == false) goto L9;
        doInputAudioFrame(r10, r11, MediaSetting.ACODEC_ID.AUTO, 0);
        return true;
    }

    public void onCastControl(int r10, int r11) {
        this.mRTCEventNotifier.onCastControl(r10, r11);
    }

    public boolean onCastRequest(final String r10, String r11) {
        if (this.mSetting != null) goto L6;
        this.mLogger.w(TAG, "onCastRequest: mSetting is null");
        return false;
    L6:
        this.mLogger.i(TAG, "onCastRequest: nativeDecode=" + this.mSetting.isEnableVideoNativeDecode() + " userId=" + r10 + "mEnablePlaying" + this.mEnablePlaying);
        if (this.mEnablePlaying.booleanValue() == true) goto L10;
        ThreadMethodProxy.start(new PthreadThreadV2(new b(this, r10), "RTCEngine-SurfaceClear"));
    L10:
        if (this.mIsMediaRender == true) goto L12;
    L17:
        startAudioPlayback(r10);
        if (this.mSetting.isEnableVideoNativeDecode() == true) goto L20;
        startVideoPlayback(r10, false);
    L20:
        Map<String, Boolean> r0 = this.mIsFirstFrameMap;
        Boolean r12 = Boolean.TRUE;
        r0.put(r10, r12);
        this.mIsCastingMap.put(r10, r12);
        this.mVaildVideoFramesIndex = 0;
        this.mLogger.i(TAG, "onCastRequest: mRTCEventNotifier");
        return this.mRTCEventNotifier.onCastRequest(r10, r11);
    L12:
        if (this.mMediaRenders.containsKey(r10) == true) goto L17;
        IMediaRender r1 = (IMediaRender) INVOKESTATIC_com_byted_cast_sdk_core_RTCEngineImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.render.MediaRender").newInstance();     // Catch: Throwable -> L15
        r1.init(r10);     // Catch: Throwable -> L15
        r1.setVideoFrameListener(new AnonymousClass2(this));     // Catch: Throwable -> L15
        MediaParameter r13 = MediaParameter.Render_context;     // Catch: Throwable -> L15
        r1.setParameter(r13, this.mContext);     // Catch: Throwable -> L15
        r1.setParameter(r13, this.mLogger);     // Catch: Throwable -> L15
        r1.setParameter(MediaParameter.Render_IsOpenJitterBuffer, Boolean.TRUE);     // Catch: Throwable -> L15
        r1.setParameter(MediaParameter.Video_JitterBuffer_Mode, 0);     // Catch: Throwable -> L15
        r1.setParameter(MediaParameter.Render_videoLatencyListener, new AnonymousClass3(this));     // Catch: Throwable -> L15
        this.mMediaRenders.put(r10, r1);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.mLogger.e(TAG, "onCastRequest: Create MediaRender FAIL " + th.toString());
        th.printStackTrace();
        goto L17
    }

    public void onConnect(String r10, String r11) {
        this.mLogger.i(TAG, "onConnect userId=" + r10 + " name=" + r11);
        if (this.mRoleSource == true) goto L5;
        Map<String, Boolean> r0 = this.mIsFirstFrameMap;
        Boolean r1 = Boolean.FALSE;
        r0.put(r10, r1);
        this.mIsCastingMap.put(r10, r1);
    L5:
        this.mRTCEventNotifier.onConnect(r10, r11);
    }

    public void onDisconnect(RTCEngine.ExitReason r10, String r11) {
        this.mLogger.i(TAG, "onDisconnect: reason=" + r10 + " message=" + r11);
        if (this.mMediaRecorder == null) goto L5;
        IMediaRecorder.-CC.removeLoggerCallback(this.mLogger);
        IMediaRecorder.-CC.removeMonitorCallback(this.mMonitor);
        this.mMediaRecorder.removeMediaRecorderCallback(this.recorderCallback);
        this.mMediaRecorder.stop();
    L5:
        this.mRTCEventNotifier.onDisconnect(r10, r11);
    }

    public void onError(int r10, String r11) {
        this.mLogger.e(TAG, r10 + " " + r11);
        Iterator<String> r0 = this.mIsFirstFrameMap.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        this.mIsFirstFrameMap.put(r0.next(), Boolean.FALSE);
        goto L4
    L6:
        this.mRTCEventNotifier.onError(r10, r11);
    }

    public void onLogMonitor(String r10, String[][] r11) {
        this.mRTCEventNotifier.onLogMonitor(r10, r11);
    }

    public void onMonitorEvent(String r10, String r11) {
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onMonitorEvent(r10, r11);
        return;
    }

    public void onRecvMetaData(String r10, String r11) {
        this.mLogger.i(TAG, "onRecvMetaData: userId=" + r10 + ", json=" + r11);
        this.mRTCEventNotifier.onRecvMetaData(r10, r11);
    }

    public void onSetbitrateRequest(RTCMediaKind r10, int r11) {
        this.mLogger.i(TAG, "onSetbitrateRequest: " + r10.toString());
        if (r11 <= 0) goto L6;
        callSetBitrateKps(r11);
        return;
    }

    public void onSinkLatencyStat(String r10, String r11) {
        this.mLogger.d(TAG, "onSinkLatencyStat: stat=" + r11 + " ip=" + r10);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onSinkLatencyStat(r10, r11);
        return;
    }

    public void onSinkStuckStat(String r10, String r11) {
        this.mLogger.d(TAG, "onSinkStuckStat: stat=" + r11 + " ip=" + r10);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onSinkStuckStat(r10, r11);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void render(String r10, long r11) {
        this.mVoipEngine.onRendered(r10, r11);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void requestScreenRecord(Activity r10, int r11) {
        this.mLogger.i(TAG, "requestScreenRecord: requestCode=" + r11);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void sendMetaData(String r10, String r11) {
        this.mLogger.d(TAG, "sendMetaData: userId=" + r10 + " json=" + r11);
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        this.mVoipEngine.sendMetaData(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setAudioDataListener(Boolean r10, IAudioDataListener r11) {
        this.mLogger.i(TAG, "setAudioDataListener, autoPlayAudio:" + r10 + ", listener:" + r11);
        this.mAudioDataListener = r11;
        this.mAutoPlayAudio = r10.booleanValue();
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setAudioDropPolicyByMs(int r10, int r11) {
        this.mVoipEngine.setAudioDropPolicyByMs(r10, r11);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setAudioVolume(float r10, float r11) {
        this.mLogger.i(TAG, "setAudioVolume: ratio=" + r10 + " volume=" + r11);
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        this.mVoipEngine.setAudioVolume(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setCastControl(int r10, int r11) {
        this.mLogger.i(TAG, "setCastControl: bitrate=" + r11 + " fps=" + r10);
        if (r10 <= 0) goto L5;
        this.mTopFps = r10;
    L5:
        if (r11 <= 0) goto L7;
        this.mTopBitrate = r11;
    L7:
        this.mLogger.i(TAG, "setCastControl: mTopFps=" + this.mTopFps + " mTopBitrate=" + this.mTopBitrate);
        if (r10 > 0) goto L19;
    L12:
        if (r11 <= 0) goto L21;
        IMediaRecorder r12 = this.mMediaRecorder;     // Catch: IllegalStateException -> L10
        if (r12 == null) goto L22;
        r12.setBitrateKps(r11);     // Catch: IllegalStateException -> L10
        return;
    L10:
        e = move-exception;
        this.mLogger.w(TAG, "setCastControl: [IllegalStateException] " + e);
        return;
    L22:
        return;
    L21:
        return;
    L19:
        callSetFps(r10);     // Catch: IllegalStateException -> L10
        goto L12
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setPlayerVolume(String r10, float r11) {
        if (this.mIsMediaRender == false) goto L7;
        IMediaRender r12 = this.mMediaRenders.get(r10);
        if (r12 == null) goto L20;
        float r0 = ((Float) r12.getParameter(MediaParameter.Audio_Render_max_vol)).floatValue();
        float r1 = ((Float) r12.getParameter(MediaParameter.Audio_Render_min_vol)).floatValue();
        float r13 = Math.max(Math.min(r11, r0), r1);
        r12.setParameter(MediaParameter.Audio_Render_volume, Float.valueOf(r13));
        return;
    L20:
        return;
    L7:
        Iterator<String> r14 = this.mAudioPassivePlayers.keySet().iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        String r15 = r14.next();
        if (TextUtils.equals(r10, r15) == false) goto L9;
        AudioPassivePlayer r16 = this.mAudioPassivePlayers.get(r15);
    L14:
        if (r16 == null) goto L22;
        r16.setVolume(r11);
        return;
    L22:
        return;
    L13:
        r16 = null;
        goto L14
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setTransType(RTCSetting.TRANS_TYPE r10, RTCSetting.TRANS_TYPE r11) {
        this.mLogger.i(TAG, "setTransType: audio=" + r10.toString() + " video=" + r11.toString());
        this.mVoipEngine.setTransType(r10, r11);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVideoQP(RTCScreenProfile r10, boolean r11) {
        this.mLogger.i(TAG, "setVideoQP (screen): profile=" + r10);
        if (this.mMediaRecorder == null) goto L12;
        if (r10 == null) goto L13;
        VideoProfile r0 = new VideoProfile();
        r0.setMinQP(r10.getMinQP());
        r0.setMaxQP(r10.getMaxQP());
        r0.setMinQPP(r10.getMinQPP());
        r0.setMaxQPP(r10.getMaxQPP());
        r0.setMinQPB(r10.getMinQPB());
        r0.setMaxQPB(r10.getMaxQPB());
        r0.setInitialQP(r10.getInitialQP());
        r0.setInitialQPI(r10.getInitialQPI());
        r0.setInitialQPP(r10.getInitialQPP());
        r0.setInitialQPB(r10.getInitialQPB());
        r0.setQp(r10.getQp());
        r0.setBitrateBps(r10.getBitrateBps());
        if (r10.getBitrateMode() == null) goto L8;
        r0.setBitrateModeStr(r10.getBitrateMode().name());
    L8:
        this.mMediaRecorder.setVideoQP(r0);
        if (r11 == false) goto L14;
        this.mMediaRecorder.reStart();
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVideoSurface(String r10, Surface r11) {
        this.mLogger.i(TAG, "setVideoSurface: userId=" + r10 + ", surface=" + r11);
        stopVideoPlayback(r10);
        this.mSurfaces.put(r10, r11);
        if (this.mSurfaces.size() <= 5) goto L5;
        this.mLogger.e(TAG, "There are already 5 Surfaces !");
        this.mSurfaces.remove(r10);
    L5:
        this.mVoipEngine.setVideoSurface(r10, r11);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVirtualDisplayWH(int r10, int r11) {
        this.mLogger.i(TAG, "setVirtualDisplayWH: w=" + r10 + " h=" + r11);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L6;
        r0.setVirtualDisplayWH(r10, r11);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setVideoQP(RTCVideoProfile r10, boolean r11) {
        this.mLogger.i(TAG, "setVideoQP: profile=" + r10);
        if (this.mMediaRecorder == null) goto L12;
        if (r10 == null) goto L13;
        VideoProfile r0 = new VideoProfile();
        r0.setMinQP(r10.getMinQP());
        r0.setMaxQP(r10.getMaxQP());
        r0.setMinQPP(r10.getMinQPP());
        r0.setMaxQPP(r10.getMaxQPP());
        r0.setMinQPB(r10.getMinQPB());
        r0.setMaxQPB(r10.getMaxQPB());
        r0.setInitialQP(r10.getInitialQP());
        r0.setInitialQPI(r10.getInitialQPI());
        r0.setInitialQPP(r10.getInitialQPP());
        r0.setInitialQPB(r10.getInitialQPB());
        r0.setQp(r10.getQp());
        r0.setBitrateBps(r10.getBitrateBps());
        if (r10.getBitrateMode() == null) goto L8;
        r0.setBitrateModeStr(r10.getBitrateMode().name());
    L8:
        this.mMediaRecorder.setVideoQP(r0);
        if (r11 == false) goto L14;
        this.mMediaRecorder.reStart();
        return;
    L14:
        return;
    L13:
        return;
    }

    public static /* synthetic */ void access$3500(RTCEngineImpl r0, String r1, boolean r10) {
        r0.startVideoPlayback(r1, r10);
    }

    public void onAudioPcm(String r10, byte[] r11, long r12) {
        this.mLogger.v(TAG, "onAudioPcm: length=" + r11.length + " timestamp=" + r12 + " userId=" + r10);
        AudioPassivePlayer r13 = this.mAudioPassivePlayers.get(r10);
        if (r13 != null) goto L5;
        return;
    L5:
        r13.addPcm(r11, r12);
    }

    public void onAudioSetVolume(String r10, float r11, float r12) {
        this.mLogger.i(TAG, "onAudioSetVolume: Sink");
        this.mRTCEventNotifier.onAudioSetVolume(r10, r11, r12);
    }

    public void onConnectSuccess(int r10, int r11, int r12) {
        this.mLogger.i(TAG, "onConnectSuccess: Source+");
        this.mRTCEventNotifier.onConnectSuccess(r10, r11, r12);
        this.mLogger.i(TAG, "onConnectSuccess: Source-");
    }

    public void onDisconnect(String r10, RTCEngine.ExitReason r11, String r12) {
        this.mLogger.i(TAG, "onDisconnect userId=" + r10 + " reason=" + r11 + " message=" + r12 + " mRoleSource=" + this.mRoleSource);
        if (this.mRoleSource == true) goto L9;
        Map<String, Boolean> r0 = this.mIsFirstFrameMap;
        Boolean r1 = Boolean.FALSE;
        r0.put(r10, r1);
        this.mIsCastingMap.put(r10, r1);
        stopAudioPlayback(r10);
        stopVideoPlayback(r10);
        if (this.mIsMediaRender == false) goto L9;
        if (this.mMediaRenders.get(r10) == null) goto L9;
        this.mMediaRenders.remove(r10);
    L9:
        this.mRTCEventNotifier.onDisconnect(r10, r11, r12);
    }

    public void onNotifyLatency(String r10, Long r11, HashMap<String, Long> r12) {
        this.mLogger.d(TAG, "onNotifyLatency: ip=" + r10);
        ISinkDataListener r0 = this.mSinkDataListener;
        if (r0 == null) goto L6;
        r0.onNotifyLatency(r10, r11, r12);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void onScreenRecordRequestResult(int r10, int r11, Intent r12) {
        this.mLogger.i(TAG, "onScreenRecordRequestResult: requestCode=" + r10 + " resultCode=" + r11);
    }

    public void onVideoSizeChanged(String r10, int r11, int r12) {
        this.mLogger.i(TAG, "onVideoSizeChanged: width=" + r11 + " height=" + r12 + " userId=" + r10);
        if (r11 >= r12) goto L5;
        this.mRTCEventNotifier.OnVideoSizeChanged(r10, r11, r12, 0);
        return;
    L5:
        this.mRTCEventNotifier.OnVideoSizeChanged(r10, r11, r12, 1);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setEncoderWH(int r10, int r11, boolean r12) {
        this.mLogger.i(TAG, "setEncoderWH: w=" + r10 + " h=" + r11 + "restart=" + r12);
        IMediaRecorder r0 = this.mMediaRecorder;
        if (r0 == null) goto L8;
        r0.setDisplay(r10, r11, 0, 0);
        if (r12 == false) goto L9;
        this.mMediaRecorder.reStart();
        return;
    L9:
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void setSinkDataListener(Boolean r10, Boolean r11, ISinkDataListener r12) {
        this.mLogger.i(TAG, "setSinkDataListener, ISinkDataListener:" + r12 + ", callbackToUser:" + r10 + ", enablePlaying:" + r11);
        this.mCallbackDataToUser = r10;
        this.mEnablePlaying = r11;
        this.mSinkDataListener = r12;
    }

    private void doInputAudioFrame(byte[] r10, int r11, MediaSetting.ACODEC_ID r12, long r13) {
        if (this.mSendPause == false) goto L5;
        return;
    L5:
        this.mVoipEngine.inputAudioFrame(r10, r11, r12, r13);
    }

    private void playAudio(String r10, RTCSetting.ACODEC_ID r11, byte[] r12, long r13) {
        if (this.mIsMediaRender == false) goto L9;
        IMediaRender r14 = this.mMediaRenders.get(r10);
        if (r14 != null) goto L7;
        return;
    L7:
        if (r14.getAudioState(0) != MediaRenderState.STATE_EXECUTING) goto L15;
        r14.sendAudioPacket(0, r12, r13);
        return;
    L15:
        return;
    L9:
        AudioPassivePlayer r15 = this.mAudioPassivePlayers.get(r10);
        if (r15 != null) goto L12;
        return;
    L12:
        r15.addFrame(r12, r13);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void connect(String r10, int r11, String r12, String r13) {
        this.mLogger.i(TAG, "connect: " + r10 + ":" + r11);
        if (StringUtil.isEmpty(r12) == false) goto L6;
        r12 = "DummyName";
    L6:
        if (StringUtil.isEmpty(r13) == false) goto L8;
        r13 = "DummyPin";
    L8:
        this.mLogger.i(TAG, "connect: name=" + r12 + " pin=" + r13);
        Object r0 = this.mCastStateLock;
        monitor-enter(r0);
        if (r10 != null) goto L21;
    L15:
        this.mLogger.e(TAG, "connect failed, userId must be set !");     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L21:
        if ("".equals(r10) == true) goto L15;
        this.mVoipEngine.connect(r10, r11, r12, r13);     // Catch: Throwable -> L18
        goto L16
    }

    public void onAudioFrame(String r16, RTCSetting.ACODEC_ID r17, byte[] r18, long r19) {
        this.mLogger.d(TAG, "onAudioFrame: length=" + r18.length + " timestamp=" + r19 + " userId=" + r16);
        if (this.mSetting != null) goto L6;
        return;
    L6:
        if (this.mCallbackDataToUser.booleanValue() == true) goto L8;
        playAudio(r16, r17, r18, r19);
        return;
    L8:
        CodecType.valueOfAudio(r17.ordinal());
        if (r18.length > 6) goto L11;
    L17:
        CodecType.ACODEC_ID r1 = CodecType.ACODEC_ID.OPUS;
    L18:
        CodecType.ACODEC_ID r10 = r1;
        ISinkDataListener r11 = this.mSinkDataListener;
        if (r11 == null) goto L22;
        r11.onAudioOutput(r16, r10, r18, this.mSetting.getAudioProfile().getRecordSampleRate(), this.mSetting.getAudioProfile().getNumberOfChannels(), this.mSetting.getAudioProfile().getBitwidth(), this.mSetting.getAudioProfile().getBitrate(), r19);
    L22:
        if (this.mEnablePlaying.booleanValue() == false) goto L26;
        playAudio(r16, r17, r18, r19);
        return;
    L26:
        return;
    L11:
        if (r18[0] != (-1)) goto L17;
        if (r18[1] != (-7)) goto L17;
        if (r18[6] != (-4)) goto L17;
        r1 = CodecType.ACODEC_ID.AAC;
        goto L18
    }

    public void onCastPortSet(int r10, int r11, int r12, int r13) {
        Objects.toString(this.mRTCEventNotifier);
        this.mLogger.i(TAG, "onCastPortSet: videoChan=" + r10 + " videoPort=" + r11 + " audioChan=" + r12 + " audioPort=" + r13);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onCastPortSet(r10, r11, r12, r13);
        return;
    }

    public void onCastPortUnSet(int r10, int r11, int r12, int r13) {
        Objects.toString(this.mRTCEventNotifier);
        this.mLogger.i(TAG, "onCastPortUnSet: videoChan=" + r10 + " videoPort=" + r11 + " audioChan=" + r12 + " audioPort=" + r13);
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L6;
        r0.onCastPortUnSet(r10, r11, r12, r13);
        return;
    }

    public void onVideoFrame(String r19, RTCSetting.VCODEC_ID r20, byte[] r21, long r22) {
        this.mLogger.d(TAG, "onVideoFrame: timestamp=" + r22 + " userId:" + r19);
        if (this.mIsFirstFrameMap.get(r19).booleanValue() == false) goto L5;
        this.mIsFirstFrameMap.put(r19, Boolean.FALSE);
        this.mLogger.i(TAG, "onVideoFrame: callback first video frame! userId=" + r19);
        this.mRTCEventNotifier.onFirstVideoFrame(r19);
    L5:
        int r14 = NAL.detectNALType(new NAL(r21, r21.length, r20));
        this.mLogger.i(TAG, "onVideoFrame: nalType=" + r14 + " length=" + r21.length);
        if (r14 != 7) goto L9;
        this.mLogger.i(TAG, "onVideoFrame: activeIp=" + this.activeIp);
        this.activeIp = r19;
    L9:
        if (this.mCallbackDataToUser.booleanValue() == true) goto L12;
        playVideo(r19, r20, r21, r22, r14);
        return;
    L12:
        if (this.mSinkVideoInfos.containsKey(r19) == false) goto L16;
        if (r14 == 7) goto L16;
        VideoInfo r0 = this.mSinkVideoInfos.get(r19);
    L24:
        CodecType.VCODEC_ID r10 = CodecType.valueOfVideo(r20.ordinal());
        if (this.mSinkDataListener != null) goto L27;
    L36:
        int r17 = r14;
    L38:
        if (this.mEnablePlaying.booleanValue() == false) goto L40;
        playVideo(r19, r20, r21, r22, r17);
        return;
    L40:
        int r1 = this.mVaildVideoFramesIndex + 1;
        this.mVaildVideoFramesIndex = r1;
        this.mVoipEngine.onDecodeIn(r19, r1);
        this.mVoipEngine.onDecoded(r19, this.mVaildVideoFramesIndex);
        this.mVoipEngine.onRendered(r19, this.mVaildVideoFramesIndex);
        return;
    L27:
        if (this.activeIp.equals(r19) == false) goto L36;
        ISinkDataListener r11 = this.mSinkDataListener;
        if (r0 != null) goto L31;
        int r12 = 0;
    L32:
        if (r0 != null) goto L34;
        int r13 = 0;
    L35:
        r17 = r14;
        r11.onVideoOutput(r19, r10, r21, r12, r13, r22, r17);
        goto L38
    L34:
        r13 = r0.height;
        goto L35
    L31:
        r12 = r0.width;
    L16:
        SPS r15 = this.mGolomb.Parse(r21, r20);
        AnonymousClass1 r16 = null;
        if (r15.bVaild == false) goto L23;
        VideoInfo r18 = new VideoInfo(this, r16);
        r18.width = r15.width;
        r18.height = r15.height;
        this.mSinkVideoInfos.put(r19, r18);
        this.mLogger.i(TAG, "onVideoFrame: [Force] nalType=" + r14 + " width=" + r15.width + " height=" + r15.height + " userId=" + r19);
        if (r20 != RTCSetting.VCODEC_ID.H264) goto L21;
        String r23 = "{\"cmd\":\"realResolution\",\"width\":" + r15.width + ",\"height\":" + r15.height + ",\"codecId\":264}";
    L22:
        this.mRTCEventNotifier.onRecvMetaData(r23);
        r0 = r18;
        goto L24
    L21:
        r23 = "{\"cmd\":\"realResolution\",\"width\":" + r15.width + ",\"height\":" + r15.height + ",\"codecId\":265}";
        goto L22
    L23:
        r0 = null;
        goto L24
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public int sinkInitAndJoinRoom(String r10, String r11, String r12, String r13) {
        if (this.mRemoteMirrorConnector == null) goto L5;
    L8:
        this.mLogger.i(TAG, "RTC: sinkInitAndJoinRoom: impl=".concat(this.mRemoteMirrorConnector.getClass().getName()));
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L12;
        r0.onMonitorEvent("rtclink_sink_join_room", "");
    L12:
        return this.mRemoteMirrorConnector.sinkInitAndJoinRoom(r10, r11, r12, r13);
    L5:
        if (createConnector() == true) goto L8;
        this.mLogger.e(TAG, "RTC: sinkInitAndJoinRoom: [ERROR] No RTC Impl");
        return -1;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public int sourceInitAndJoinRoom(String r10, String r11, String r12, String r13) {
        if (this.mRemoteMirrorConnector == null) goto L5;
    L8:
        this.mLogger.i(TAG, "RTC: sourceInitAndJoinRoom: impl=".concat(this.mRemoteMirrorConnector.getClass().getName()));
        RTCEventNotifier r0 = this.mRTCEventNotifier;
        if (r0 == null) goto L12;
        r0.onMonitorEvent("rtclink_source_join_room", "");
    L12:
        return this.mRemoteMirrorConnector.sourceInitAndJoinRoom(r10, r11, r12, r13);
    L5:
        if (createConnector() == true) goto L8;
        this.mLogger.e(TAG, "RTC: sourceInitAndJoinRoom: [ERROR] No RTC Impl");
        return -1;
    }

    public RTCEngineImpl(Context r10, ContextManager.CastContext r11, RTCSetting r12, IRTCEngineEventListener r13, boolean r14) {
        this(r10, r11, r12, null, r13, r14);
    }

    public static /* synthetic */ void access$1200(RTCEngineImpl r0, byte[] r1, int r10, MediaSetting.ACODEC_ID r11, long r12) {
        r0.doInputAudioFrame(r1, r10, r11, r12);
    }

    private /* synthetic */ void lambda$playVideo$1(String r10, int r11, byte[] r12, RTCSetting.VCODEC_ID r13, long r14) {
        if (this.mIsMediaRender == false) goto L29;
        IMediaRender r0 = this.mMediaRenders.get(r10);
        if (r0 != null) goto L9;
        this.mLogger.w(TAG, "playVideo: no mediaRender");
        return;
    L9:
        if (this.mSurfaces.containsKey(r10) == true) goto L13;
        this.mLogger.w(TAG, "playVideo: no surface");
        return;
    L13:
        if (r0.getVideoState(0) != MediaRenderState.STATE_UNINITIALIZED) goto L27;
        if (r11 != 7) goto L20;
        this.mLogger.w(TAG, "playVideo: STATE_UNINITIALIZED with SPS");
        SPS r15 = this.mGolomb.Parse(r12, r13);
        VideoParameter r1 = new VideoParameter();
        if (r13 != RTCSetting.VCODEC_ID.H264) goto L18;
        CodecId r16 = CodecId.H264;
    L19:
        r1.codecId = r16;
        r1.width = r15.width;
        r1.height = r15.height;
        r0.setSurface(0, this.mSurfaces.get(r10));
        r0.setVideoParameter(0, r1);
        r0.startVideoPlayer(0);
        goto L27
    L18:
        r16 = CodecId.H265;
        goto L19
    L20:
        this.mLogger.w(TAG, "need sps, this frame is " + r11);
        JSONObject r17 = new JSONObject();
        r17.put(CMD_KEY, CMD_REQUEST_IDR);     // Catch: JSONException -> L23
        sendMetaData(r10, r17.toString());     // Catch: JSONException -> L23
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        return;
    L27:
        if (r0.getVideoState(0) != MediaRenderState.STATE_EXECUTING) goto L45;
        r0.sendVideoPacket(0, r12, r14);
        return;
    L45:
        return;
    L29:
        VideoPlayer r18 = this.mVideoPlayers.get(r10);
        if (r18 != null) goto L32;
        return;
    L32:
        this.mLogger.v(TAG, "onVideoFrame, player.isInit():" + r18.isInit() + ", surface:" + this.mSurfaces.get(r10));
        if (r18.isInit() == true) goto L39;
        if (r11 != 7) goto L39;
        Surface r19 = this.mSurfaces.get(r10);
        this.mLogger.i(TAG, "onVideoFrame, player.isInit():" + r18.isInit() + ", userId:" + r10 + ", surface:" + r19);
        if (r19 == null) goto L47;
        r18.init(r19, r13, r12);
        r18.queueBuffer(r12, r14);
        return;
    L47:
        return;
    L39:
        if (r18.isInit() == false) goto L49;
        r18.queueBuffer(r12, r14);
        return;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public boolean inputExternalScreenFrame(byte[] r12, int r13, int r14, MediaSetting.VideoFormat r15, int r16) {
        RTCSetting r0 = this.mSetting;
        if (r0 != null) goto L5;
    L9:
        this.mLogger.w(TAG, "inputExternalScreenFrame: Not enabled or mSetting is null");
        return false;
    L5:
        if (r0.isExternalScreenSource() == false) goto L9;
        doInputScreenFrame(r12, 0, r13, r14, r15, 0, r16, 0);
        return true;
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public boolean inputExternalVideoFrame(byte[] r10, int r11, int r12, MediaSetting.VideoFormat r13, int r14) {
        RTCSetting r0 = this.mSetting;
        if (r0 != null) goto L5;
    L9:
        this.mLogger.w(TAG, "inputExternalVideoFrame: Not enabled or mSetting is null");
        return false;
    L5:
        if (r0.isExternalVideoSource() == false) goto L9;
        doInputVideoFrame(r10, r11, r12, r13, r14, false);
        return true;
    }

    public void playVideo(final String r12, final RTCSetting.VCODEC_ID r13, final byte[] r14, final long r15, final int r17) {
        RTCSetting.VCODEC_ID r0 = this.mVideoCodecId;
        if (r0 != RTCSetting.VCODEC_ID.AUTO) goto L5;
        this.mLogger.e(TAG, "playVideo: init mVideoCodecId = " + r13);
        this.mVideoCodecId = r13;
    L15:
        this.singleExecutor.execute(new a(this, r12, r17, r14, r13, r15));
        return;
    L5:
        if (r0 == r13) goto L15;
        this.mLogger.e(TAG, "playVideo: changed mVideoCodecId = " + this.mVideoCodecId + " codecId = " + r13);
        stopVideoPlaybackWithSurface(r12);
        if (this.mIsMediaRender == true) goto L9;
    L14:
        this.mVideoCodecId = r13;
        goto L15
    L9:
        if (this.mMediaRenders.containsKey(r12) == true) goto L14;
        IMediaRender r1 = (IMediaRender) INVOKESTATIC_com_byted_cast_sdk_core_RTCEngineImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.render.MediaRender").newInstance();     // Catch: Throwable -> L12
        r1.init(r12);     // Catch: Throwable -> L12
        r1.setVideoFrameListener(new AnonymousClass4(this));     // Catch: Throwable -> L12
        MediaParameter r10 = MediaParameter.Render_context;     // Catch: Throwable -> L12
        r1.setParameter(r10, this.mContext);     // Catch: Throwable -> L12
        r1.setParameter(r10, this.mLogger);     // Catch: Throwable -> L12
        r1.setParameter(MediaParameter.Render_IsOpenJitterBuffer, Boolean.TRUE);     // Catch: Throwable -> L12
        r1.setParameter(MediaParameter.Video_JitterBuffer_Mode, 0);     // Catch: Throwable -> L12
        r1.setParameter(MediaParameter.Render_videoLatencyListener, new AnonymousClass5(this));     // Catch: Throwable -> L12
        this.mMediaRenders.put(r12, r1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mLogger.e(TAG, "playVideo: Create MediaRender FAIL " + th.toString());
        th.printStackTrace();
        goto L14
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void reinit(Context r10, RTCSetting r11, GLSurfaceView r12, IRTCEngineEventListener r13, boolean r14) {
        this.mRTCEventNotifier = new RTCEventNotifier(r13);
        this.mContext = r10;
        this.mRoleSource = r14;
        this.mSetting = r11;
        MediaSetting r15 = new MediaSetting(false, false);
        this.mMediaSetting = r15;
        r15.getAudioProfile().setHwNSEnabled(true);
        this.mMediaSetting.getAudioProfile().setHwAECEnabled(true);
        this.mMediaSetting.getVideoProfile().setSourceType(MediaSetting.VIDEO_SOURCE_TYPE.EXTERNAL_VIDEO);
        this.mMediaSetting.setConfig(ContextManager.getConfigManager(this.mCastContext).getInitConfig());
        if (this.mRoleSource == true) goto L18;
    L11:
        this.mVoipEngine.create(r11);
        this.mVoipEngine.setOnVoipEngineListener(this);
        if (this.mSetting.getAudioProfile().isEnabled() == true) goto L14;
    L16:
        this.mVoipEngine.setVideoProfile(this.mSetting.getVideoProfile());
        this.mVoipEngine.setScreenProfile(this.mSetting.getScreenProfile());
        this.mVoipEngine.setAudioProfile(this.mSetting.getAudioProfile());
        registerServices(this.mContext);
        this.mLogger.i(TAG, "reinit: gitInfo=1.c8f9ae2");
        return;
    L14:
        if (this.mSetting.isbEnableAudioCallback() == true) goto L16;
        this.mAudioActivePlayer = new AudioActivePlayer(this, this.mCastContext);
        goto L16
    L18:
        Class r16 = INVOKESTATIC_com_byted_cast_sdk_core_RTCEngineImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.capture.ByteMediaRecorder");     // Catch: Throwable -> L6
        this.mMediaRecorder = (IMediaRecorder) r16.getMethod("getInstance", new Class[]{Context.class, MediaSetting.class}).invoke(r16, new Object[]{this.mContext, this.mMediaSetting});     // Catch: Throwable -> L6
    L9:
        if (this.mMediaRecorder == null) goto L11;
        IMediaRecorder.-CC.addMonitorCallback(this.mMonitor);
    L6:
        th = move-exception;
        this.mMediaRecorder = null;
        Logger.e(TAG, "reinit: ByteMediaRecorder Not Found! " + th.toString());
        goto L9
    }

    public RTCEngineImpl(Context r10, ContextManager.CastContext r11, RTCSetting r12, GLSurfaceView r13, IRTCEngineEventListener r14, boolean r15) {
        this.mPreviewSurface = null;
        this.mAudioPassivePlayers = new HashMap();
        this.mVideoPlayers = new HashMap();
        this.mSurfaces = new HashMap();
        this.mAudioDataListener = null;
        this.mSinkDataListener = null;
        this.mCallbackDataToUser = Boolean.FALSE;
        this.mEnablePlaying = Boolean.TRUE;
        this.mAutoPlayAudio = true;
        this.singleExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory(TAG));
        this.mIsMediaRender = true;
        this.mMediaRenders = new HashMap();
        this.mDupAudio = false;
        this.mDupAudioSeq = 0;
        this.mCurAudioData = null;
        this.mPreAudioData = null;
        this.mPrePreAudioData = null;
        this.mJitterMode = 1;
        this.mTopFps = 30;
        this.mTopBitrate = 8000;
        this.mTopWidth = 1920;
        this.mTopHeight = 1080;
        this.activeIp = "";
        this.mVaildVideoFramesIndex = 0;
        this.mCallbackToMirror = true;
        this.mSendPause = false;
        this.mIsFirstFrameMap = new HashMap();
        this.mIsCastingMap = new HashMap();
        this.mCastStateLock = new Object();
        this.mSinkVideoInfos = new HashMap();
        this.mGolomb = new golomb(this.mCastContext);
        this.recorderCallback = null;
        this.mVideoCodecId = RTCSetting.VCODEC_ID.AUTO;
        this.jamLevel = 0;
        this.mRemoteMirrorCallback = new AnonymousClass6(this);
        this.mCastContext = r11;
        this.mVoipEngine = new VoipEngine(this.mCastContext);
        this.mLogger = ContextManager.getLogger(this.mCastContext);
        this.mMonitor = ContextManager.getMonitor(this.mCastContext);
        this.mRTCEventNotifier = new RTCEventNotifier(r14);
        this.mContext = r10;
        this.mRoleSource = r15;
        this.mSetting = r12;
        MediaSetting r16 = new MediaSetting(false, false);
        this.mMediaSetting = r16;
        r16.getAudioProfile().setHwNSEnabled(true);
        this.mMediaSetting.getAudioProfile().setHwAECEnabled(true);
        this.mMediaSetting.getAudioProfile().setAudioEnablePause(false);
        this.mLogger.i(TAG, "RTCEngineImpl: isEnableSourceOpengl=" + this.mSetting.isEnableSourceOpengl());
        this.mMediaSetting.getVideoProfile().enableOpenGL(this.mSetting.isEnableSourceOpengl());
        this.mMediaSetting.setConfig(ContextManager.getConfigManager(r11).getInitConfig());
        this.mMediaSetting.getVideoProfile().setFrameInterval(10);
        this.mMediaSetting.getVideoProfile().enableModifyFps(true);
        this.mMediaSetting.getVideoProfile().enableSetMaxFps(false);
        this.mMediaSetting.getVideoProfile().setSourceType(MediaSetting.VIDEO_SOURCE_TYPE.EXTERNAL_VIDEO);
        if (this.mRoleSource == false) goto L12;
        createMediaRecorderCallback();
        Class r17 = INVOKESTATIC_com_byted_cast_sdk_core_RTCEngineImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.byted.cast.capture.ByteMediaRecorder");     // Catch: Throwable -> L7
        this.mMediaRecorder = (IMediaRecorder) r17.getMethod("getInstance", new Class[]{Context.class, MediaSetting.class}).invoke(r17, new Object[]{this.mContext, this.mMediaSetting});     // Catch: Throwable -> L7
        this.mLogger.i(TAG, "RTCEngineImpl: ByteMediaRecorder " + this.mMediaSetting);     // Catch: Throwable -> L7
    L10:
        if (this.mMediaRecorder == null) goto L12;
        IMediaRecorder.-CC.addLoggerCallback(this.mLogger);
    L7:
        th = move-exception;
        this.mMediaRecorder = null;
        Logger.e(TAG, "RTCEngineImpl: ByteMediaRecorder Not Found! " + th.toString());
    L12:
        this.mVoipEngine.create(r12);
        this.mVoipEngine.setOnVoipEngineListener(this);
        if (this.mSetting.getAudioProfile().isEnabled() == true) goto L15;
    L17:
        this.mVoipEngine.setVideoProfile(this.mSetting.getVideoProfile());
        this.mVoipEngine.setScreenProfile(this.mSetting.getScreenProfile());
        this.mVoipEngine.setAudioProfile(this.mSetting.getAudioProfile());
        registerServices(r10);
        this.mLogger.i(TAG, "RTCEngineImpl: gitInfo=1.c8f9ae2");
        return;
    L15:
        if (this.mSetting.isbEnableAudioCallback() == true) goto L17;
        this.mAudioActivePlayer = new AudioActivePlayer(this, this.mCastContext);
        goto L17
    }

    private void doInputVideoFrame(byte[] r10, int r11, int r12, MediaSetting.VideoFormat r13, int r14, boolean r15) {
        if (this.mSendPause == false) goto L5;
        return;
    L5:
        this.mVoipEngine.inputVideoFrame(r10, r11, r12, r13, r14, r15);
    }

    private void inputAudioViaRTC(byte[] r10, int r11, int r12, int r13, int r14, long r15) {
        IRemoteMirrorConnector r0 = this.mRemoteMirrorConnector;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        this.mLogger.d(TAG, "RTC: inputAudioViaRTC: ret=" + r1 + " dateLen=" + r10.length + " sampleRate=" + r11 + " channel=" + r12 + " bitwidth=" + r13 + " bitrates=" + r14 + " timestampUs=" + r15);
        return;
    L5:
        r1 = r0.sendAudioFrame(r10, r11, r12, r13, r14, r15);
        goto L6
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void sendData(int r15, byte[] r16, long r17, long r19, long r21, long r23) {
        sendData(r15, r16, r17, r19, r21, r23, 0, 0, null);
    }

    public static /* synthetic */ void access$1300(RTCEngineImpl r0, byte[] r1, int r10, int r11, int r12, int r13, long r14) {
        r0.inputAudioViaRTC(r1, r10, r11, r12, r13, r14);
    }

    @Override // com.byted.cast.sdk.render.audio.IAudioListener
    public void onAudioOutput(String r11, byte[] r12, int r13, int r14, int r15, int r16, long r17) {
        IAudioDataListener r1 = this.mAudioDataListener;
        if (r1 == null) goto L6;
        r1.onAudioOutput(r11, r12, r13, r14, r15, r16, r17);
        return;
    }

    private void doInputScreenFrame(byte[] r13, int r14, int r15, int r16, MediaSetting.VideoFormat r17, long r18, int r20, int r21) {
        if (this.mSendPause == false) goto L5;
        return;
    L5:
        this.mVoipEngine.inputScreenFrame(r13, r14, r15, r16, r17, r18, r20, r21);
    }

    private void inputVideoViaRTC(byte[] r12, int r13, int r14, int r15, MediaSetting.VideoFormat r16, long r17, int r19, int r20) {
        IRemoteMirrorConnector r1 = this.mRemoteMirrorConnector;
        if (r1 != null) goto L5;
        boolean r10 = false;
    L6:
        this.mLogger.d(TAG, "RTC: inputVideoViaRTC: ret=" + r10 + " dataLen=" + r13 + " width=" + r14 + " height=" + r15 + " timestamp=" + r17 + " rotation=" + r19 + " idr=" + r20);
        return;
    L5:
        r10 = r1.sendVideoFrame(r12, this.mVideoCodecInfo, r13, r14, r15, r17, r19, r20);
        goto L6
    }

    public static /* synthetic */ void access$500(RTCEngineImpl r0, byte[] r1, int r10, int r11, int r12, MediaSetting.VideoFormat r13, long r14, int r15, int r16) {
        r0.inputVideoViaRTC(r1, r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void access$600(RTCEngineImpl r0, byte[] r1, int r10, int r11, int r12, MediaSetting.VideoFormat r13, long r14, int r15, int r16) {
        r0.doInputScreenFrame(r1, r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.byted.cast.sdk.RTCEngine
    public void sendData(int r15, byte[] r16, long r17, long r19, long r21, long r23, int r25, int r26, String r27) {
        CastLogger r10 = this.mLogger;
        StringBuilder r11 = new StringBuilder("sendData... codec=");
        r11.append(r15);
        r11.append(" width=");
        r11.append(r25);
        r11.append(" height=");
        r11.append(r26);
        r11.append(" seiLen=");
        if (r27 != null) goto L5;
        int r12 = 0;
    L6:
        r11.append(r12);
        r10.i(TAG, r11.toString());
        IMediaRecorder r13 = this.mMediaRecorder;
        if (r13 == null) goto L16;
        if (r15 != 0) goto L14;
        if (r27 != null) goto L11;
    L13:
        this.mMediaRecorder.sendVideoFrame(r16, r25, r26, MediaSetting.VideoFormat.VIDEO_FORMAT_I420, r21);
        return;
    L11:
        if (r27.isEmpty() == true) goto L13;
        this.mMediaRecorder.sendVideoFrame(r16, r25, r26, MediaSetting.VideoFormat.VIDEO_FORMAT_I420, r21, r27);
        return;
    L14:
        r13.sendAudioFrame(r16, 0, 0, 0, 0, r21);
        return;
    L16:
        return;
    L5:
        r12 = r27.length();
        goto L6
    }
}
