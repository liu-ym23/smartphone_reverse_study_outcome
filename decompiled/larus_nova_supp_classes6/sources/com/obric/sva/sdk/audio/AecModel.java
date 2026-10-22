package com.obric.sva.sdk.audio;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICoreIdentify;
import com.mammon.audiosdk.structures.SAMICoreAudioBin;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAecContextParameter;
import com.mammon.audiosdk.structures.SAMICoreVoiceAssistantAudioData;
import com.obric.assistant.common.spi.IObricSamiService;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0005\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0010H\u0002J\u0006\u0010 \u001a\u00020\u0018J\u0006\u0010\u000f\u001a\u00020\u0018J\u0006\u0010!\u001a\u00020\u0010R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/sva/sdk/audio/AecModel;", "", "<init>", "()V", "audioPlayConfig", "com/obric/sva/sdk/audio/AecModel$audioPlayConfig$1", "Lcom/obric/sva/sdk/audio/AecModel$audioPlayConfig$1;", "audioRecordConfig", "com/obric/sva/sdk/audio/AecModel$audioRecordConfig$1", "Lcom/obric/sva/sdk/audio/AecModel$audioRecordConfig$1;", "samiCore", "Lcom/mammon/audiosdk/SAMICore;", "TAG", "", "lock", "destroy", "", "hasInit", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "aecRootPath", "init", "", "context", "Landroid/content/Context;", "processAndGet", "", "data", "Lcom/mammon/audiosdk/structures/SAMICoreVoiceAssistantAudioData;", "initSamiCoreLocked", "reset", "isModelInit", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AecModel {
    public static final String AEC_MODEL_ASSET = "aec_p_micro5_bin_20k_260901_multich_v4.0.model";
    public static final Companion Companion = null;
    private final String TAG;
    private String aecRootPath;
    private final AecModel$audioPlayConfig$1 audioPlayConfig;
    private final AecModel$audioRecordConfig$1 audioRecordConfig;
    private volatile boolean destroy;
    private volatile Handler handler;
    private volatile HandlerThread handlerThread;
    private volatile boolean hasInit;
    private final Object lock;
    private final SAMICore samiCore;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/audio/AecModel$Companion;", "", "<init>", "()V", "AEC_MODEL_ASSET", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(AecModel r0) {
        destroy$lambda$5(r0);
    }

    private final boolean initSamiCoreLocked() {
        SAMICoreVoiceAssistantAecContextParameter r0 = new SAMICoreVoiceAssistantAecContextParameter();
        boolean r3 = false;
        LogUtils.d(this.TAG, "AEC initSamiCore model path: " + this.aecRootPath, new Object[0]);
        r0.modelPath = this.aecRootPath;
        r0.refSampleRate = this.audioPlayConfig.getSampleRate();
        r0.refNumberChannel = 1;
        r0.srcSampleRate = this.audioRecordConfig.getSampleRate();
        r0.srcNumberChannel = 1;
        r0.enableFluteEngine = 0;
        this.samiCore.setEnableSyncInterface(true);
        int r1 = this.samiCore.SAMICoreCreateHandleByIdentify(SAMICoreIdentify.SAMICoreIdentify_RealtimeCall_Aec, r0);
        LogUtils.i(this.TAG, "AEC initSamiCore ret: " + r1, new Object[0]);
        if (r1 != 0) goto L5;
        r3 = true;
    L5:
        this.hasInit = r3;
        return r3;
    }

    public final void destroy() {
        Object r0 = this.lock;
        monitor-enter(r0);
        LogUtils.i(this.TAG, "AEC destroy SamiCore", new Object[0]);     // Catch: Throwable -> L21
        this.destroy = true;     // Catch: Throwable -> L21
        this.hasInit = false;     // Catch: Throwable -> L21
        Handler r1 = this.handler;     // Catch: Throwable -> L21
        HandlerThread r2 = this.handlerThread;     // Catch: Throwable -> L21
        Boolean r3 = null;
        this.handler = null;     // Catch: Throwable -> L21
        this.handlerThread = null;     // Catch: Throwable -> L21
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        if (r1 == null) goto L28;
        r1.post(new a(this));
    L26:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L18
        if (r2 == null) goto L16;
        r3 = Boolean.valueOf(r2.quitSafely());     // Catch: Throwable -> L18
    L16:
        Result.constructor-impl(r3);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L28:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L10
        Object r8 = Result.constructor-impl(Integer.valueOf(this.samiCore.SAMICoreDestroyHandle()));     // Catch: Throwable -> L10
    L12:
        Result.box-impl(r8);
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        throw th;
    }

    public final void reset() {
        LogUtils.i(this.TAG, "AEC reset SamiCore", new Object[0]);
        IObricSamiService r0 = (IObricSamiService) ServiceManager.get().getService(IObricSamiService.class);
        if (r0 == null) goto L6;
        r0.d(this.samiCore);
        return;
    }

    public AecModel() {
        this.audioPlayConfig = new AecModel$audioPlayConfig$1();
        this.audioRecordConfig = new AecModel$audioRecordConfig$1();
        this.samiCore = new SAMICore();
        this.TAG = "SVA-AecModel";
        this.lock = new Object();
        this.aecRootPath = "";
    }

    public final boolean isModelInit() {
        return this.hasInit;
    }

    private static final void destroy$lambda$5(AecModel r1) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Result.constructor-impl(Integer.valueOf(r1.samiCore.SAMICoreDestroyHandle()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void init(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r0 = this.lock;
        monitor-enter(r0);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInit == false) goto L9;
        LogUtils.i(this.TAG, "[init] return", new Object[0]);     // Catch: Throwable -> L27
        monitor-exit(r0);
        return;
    L9:
        this.destroy = false;     // Catch: Throwable -> L27
        this.aecRootPath = r5.getFilesDir().getAbsolutePath() + File.separator + AEC_MODEL_ASSET;     // Catch: Throwable -> L27
        PthreadHandlerThreadV2 r6 = this.handlerThread;     // Catch: Throwable -> L27
        if (r6 != null) goto L12;
    L14:
        r6 = null;
    L15:
        if (r6 != null) goto L17;
        r6 = new PthreadHandlerThreadV2("background_aec");     // Catch: Throwable -> L27
        ThreadMethodProxy.start(r6);     // Catch: Throwable -> L27
        this.handlerThread = r6;     // Catch: Throwable -> L27
    L17:
        this.handler = new Handler(r6.getLooper());     // Catch: Throwable -> L27
        if (initSamiCoreLocked() == false) goto L30;
    L24:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r0);
        return;
    L30:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        Result.constructor-impl(Boolean.valueOf(r6.quitSafely()));     // Catch: Throwable -> L21
    L23:
        this.handlerThread = null;     // Catch: Throwable -> L27
        this.handler = null;     // Catch: Throwable -> L27
        goto L24
    L21:
        th = move-exception;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L27
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L27
        goto L23
    L12:
        if (ThreadMethodProxy.isAlive(r6) == false) goto L14;
        goto L14
    }

    public final byte[] processAndGet(SAMICoreVoiceAssistantAudioData r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        if (this.destroy == false) goto L5;
    L23:
        return null;
    L5:
        if (this.hasInit == false) goto L23;
        SAMICoreBlock r0 = new SAMICoreBlock();
        r0.dataType = SAMICoreDataType.SAMICoreDataType_Voice_Assistant_Audio_data;
        boolean r2 = true;
        r0.audioData = new SAMICoreVoiceAssistantAudioData[]{r6};
        r0.numberAudioData = 1;
        SAMICoreBlock r7 = new SAMICoreBlock();
        int r1 = this.samiCore.SAMICoreProcess(r0, r7);
        if (r1 == 0) goto L14;
        if (r1 == 150009) goto L14;
        LogUtils.i(this.TAG, "processAndGet fail ret=" + r1, new Object[0]);
        return null;
    L14:
        if (r7.dataType != SAMICoreDataType.SAMICoreDataType_AudioBin) goto L23;
        Object[] r8 = r7.audioData;
        if (r8 == null) goto L23;
        Object r9 = r8[0];
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.mammon.audiosdk.structures.SAMICoreAudioBin");
        SAMICoreAudioBin r10 = (SAMICoreAudioBin) r9;
        String r3 = this.TAG;
        StringBuilder r4 = new StringBuilder("processAndGet success, null data? ");
        if (r10.audioData == null) goto L21;
        r2 = false;
    L21:
        r4.append(r2);
        r4.append(", data size: ");
        r4.append(r10.audioData.length);
        LogUtils.i(r3, r4.toString(), new Object[0]);
        return r10.audioData;
    }
}
