package com.obric.sva.sdk.controller;

import android.content.Context;
import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.crypto.nativelib.CryptoManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.config.ConfigManager;
import com.obric.sva.sdk.effectplatform.AuthModelConfig;
import com.obric.sva.sdk.effectplatform.EffectConstant;
import com.obric.sva.sdk.effectplatform.EffectPlatformProvider;
import com.obric.sva.sdk.effectplatform.EffectSchedule;
import com.obric.sva.sdk.effectplatform.EffectUtils;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.ohr.OhrHandStateBridge;
import com.obric.sva.sdk.sami.SamiPhoneEnrollManager;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import com.obric.sva.sdk.utils.ThreadUtil;
import com.obric.sva.sdk.utils.Utils;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import rna.b;
import sna.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\nJ\u000e\u00106\u001a\u0002042\u0006\u00105\u001a\u00020\nJ\u0010\u00107\u001a\u0002042\u0006\u00105\u001a\u00020\nH\u0002J\b\u00108\u001a\u000204H\u0002J\u000e\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005J$\u0010;\u001a\u0002042\u0006\u00105\u001a\u00020\n2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002040=H\u0002J\b\u0010>\u001a\u0004\u0018\u000100J\u0006\u0010?\u001a\u000204J\u000e\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020\u0005J\u0010\u0010B\u001a\u0002042\u0006\u0010A\u001a\u00020\u0005H\u0002J\u0006\u0010C\u001a\u00020DR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u001e\u0010!\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0010R \u0010#\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0010R \u0010%\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0010R \u0010'\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0010R \u0010)\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0010R\u001e\u0010+\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0010R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/obric/sva/sdk/controller/SvaSdkGlobal;", "", "<init>", "()V", "TAG", "", "APP_KEY", "initialized", "", "value", "Landroid/content/Context;", "appContext", "getAppContext", "()Landroid/content/Context;", "PATH_ROOT", "getPATH_ROOT", "()Ljava/lang/String;", "PATH_ENROLL", "getPATH_ENROLL", "PATH_ENROLL_RECORD", "getPATH_ENROLL_RECORD", "PATH_ENROLL_SID", "getPATH_ENROLL_SID", "PATH_SPEECH_KWS_MODEL_DOUBAO", "getPATH_SPEECH_KWS_MODEL_DOUBAO", "PATH_SPEECH_SM_MODEL_CPU", "getPATH_SPEECH_SM_MODEL_CPU", "MD5_SPEECH_KWS_MODEL_DOUBAO", "getMD5_SPEECH_KWS_MODEL_DOUBAO", "setMD5_SPEECH_KWS_MODEL_DOUBAO", "(Ljava/lang/String;)V", "PATH_SPEECH_VOICE_PRINT_SID_MODEL", "getPATH_SPEECH_VOICE_PRINT_SID_MODEL", "PATH_SPEECH_SILENCE_AUDIO_FILE", "getPATH_SPEECH_SILENCE_AUDIO_FILE", "PATH_KEY_INFO_KWS_SECOND_MODEL", "getPATH_KEY_INFO_KWS_SECOND_MODEL", "PATH_KEY_INFO_KWS_SID_MODEL", "getPATH_KEY_INFO_KWS_SID_MODEL", "PATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL", "getPATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL", "PATH_KEY_INFO_KWS_SID_AUTH_MODEL", "getPATH_KEY_INFO_KWS_SID_AUTH_MODEL", "MD5_SPEECH_VOICE_PRINT_MODEL", "getMD5_SPEECH_VOICE_PRINT_MODEL", "effectPlatformProvider", "Lcom/obric/sva/sdk/effectplatform/EffectPlatformProvider;", "scheduler", "Lcom/obric/sva/sdk/effectplatform/EffectSchedule;", "pendingAuthModelDownload", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", "", "context", "reload", "loadConfig", "loadEachPath", "getKeyInfoKwsModel", "filePath", "initEffectPlatformProvider", "asyncBlock", "Lkotlin/Function1;", "getScheduler", "triggerDownload", "triggerAuthModelDownload", "reason", "flushPendingAuthModelDownload", "getModelStartDownloadTime", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SvaSdkGlobal {
    public static final String APP_KEY = "NTIQXNbrFj";
    public static final SvaSdkGlobal INSTANCE = null;
    private static String MD5_SPEECH_KWS_MODEL_DOUBAO = null;
    private static String MD5_SPEECH_VOICE_PRINT_MODEL = null;
    private static String PATH_ENROLL = null;
    private static String PATH_ENROLL_RECORD = null;
    private static String PATH_ENROLL_SID = null;
    private static String PATH_KEY_INFO_KWS_SECOND_MODEL = null;
    private static String PATH_KEY_INFO_KWS_SID_AUTH_MODEL = null;
    private static String PATH_KEY_INFO_KWS_SID_MODEL = null;
    private static String PATH_ROOT = null;
    private static String PATH_SPEECH_KWS_MODEL_DOUBAO = null;
    private static String PATH_SPEECH_SILENCE_AUDIO_FILE = null;
    private static String PATH_SPEECH_SM_MODEL_CPU = null;
    private static String PATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL = null;
    private static String PATH_SPEECH_VOICE_PRINT_SID_MODEL = null;
    public static final String TAG = "SvaSdkGlobal";
    private static Context appContext;
    private static EffectPlatformProvider effectPlatformProvider;
    private static volatile boolean initialized;
    private static final AtomicBoolean pendingAuthModelDownload = null;
    private static EffectSchedule scheduler;

    /* JADX INFO: renamed from: com.obric.sva.sdk.controller.SvaSdkGlobal$initEffectPlatformProvider$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.controller.SvaSdkGlobal$initEffectPlatformProvider$1", f = "SvaSdkGlobal.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $asyncBlock;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super String, Unit> r1, Continuation<? super AnonymousClass1> r2) {
            this.$asyncBlock = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$asyncBlock, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            EffectPlatformProvider r3 = SvaSdkGlobal.access$getEffectPlatformProvider$p();
            if (r3 == null) goto L7;
            r3.fetchIPCAsync();
        L7:
            this.$asyncBlock.invoke("init");
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private SvaSdkGlobal() {
    }

    public static /* synthetic */ String a(Context r0) {
        return init$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ void b(Context r0, Function1 r1) {
        initEffectPlatformProvider$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit c(Function1 r0, CompletableDeferred r1, String r2) {
        return init$lambda$6$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(String r0) {
        return init$lambda$6$lambda$3(r0);
    }

    static {
        INSTANCE = new SvaSdkGlobal();
        PATH_ROOT = "";
        PATH_ENROLL = "";
        PATH_ENROLL_RECORD = "";
        PATH_ENROLL_SID = "";
        PATH_SPEECH_KWS_MODEL_DOUBAO = "";
        PATH_SPEECH_SM_MODEL_CPU = "";
        MD5_SPEECH_KWS_MODEL_DOUBAO = "";
        PATH_SPEECH_VOICE_PRINT_SID_MODEL = "";
        PATH_SPEECH_SILENCE_AUDIO_FILE = "";
        PATH_KEY_INFO_KWS_SECOND_MODEL = "";
        PATH_KEY_INFO_KWS_SID_MODEL = "";
        PATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL = "";
        PATH_KEY_INFO_KWS_SID_AUTH_MODEL = "";
        MD5_SPEECH_VOICE_PRINT_MODEL = "";
        pendingAuthModelDownload = new AtomicBoolean(false);
    }

    private final void loadEachPath() {
        PATH_ENROLL = PATH_ROOT + "/enroll";
        PATH_ENROLL_RECORD = PATH_ENROLL + "/recording";
        PATH_ENROLL_SID = PATH_ENROLL + "/wakeup_sid";
        StringBuilder r0 = new StringBuilder();
        r0.append(PATH_ROOT);
        String r1 = File.separator;
        r0.append(r1);
        r0.append("kws_silence_5s_use.wav");
        PATH_SPEECH_SILENCE_AUDIO_FILE = r0.toString();
        StringBuilder r2 = new StringBuilder();
        r2.append(PATH_ROOT);
        r2.append(r1);
        ConfigManager r3 = ConfigManager.INSTANCE;
        r2.append(r3.getStage2Config().getKwsfile());
        PATH_SPEECH_KWS_MODEL_DOUBAO = r2.toString();
        PATH_SPEECH_VOICE_PRINT_SID_MODEL = PATH_ROOT + r1 + r3.getStage2Config().getVoiceprint_file();
        PATH_KEY_INFO_KWS_SECOND_MODEL = PATH_ROOT + r1 + r3.getStage2Config().getKws_key();
        PATH_KEY_INFO_KWS_SID_MODEL = PATH_ROOT + r1 + r3.getStage2Config().getVoiceprint_key();
        PATH_SPEECH_SM_MODEL_CPU = PATH_ROOT + r1 + "lp_engine_res_cpu.bin";
        LogUtils.d(TAG, " 【模型路径】------> PATH_SPEECH_KWS_MODEL_DOUBAO = " + getPATH_SPEECH_KWS_MODEL_DOUBAO() + " PATH_KEY_INFO_KWS_SECOND_MODEL = " + getPATH_KEY_INFO_KWS_SECOND_MODEL() + " PATH_SPEECH_VOICE_PRINT_SID_MODEL =" + getPATH_SPEECH_VOICE_PRINT_SID_MODEL() + " PATH_KEY_INFO_KWS_SID_MODEL = " + getPATH_KEY_INFO_KWS_SID_MODEL() + " PATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL = " + getPATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL() + " PATH_KEY_INFO_KWS_SID_AUTH_MODEL = " + getPATH_KEY_INFO_KWS_SID_AUTH_MODEL(), new Object[0]);
        String r4 = r3.getStage2Config().getKwsmd5();
        String r5 = "";
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        MD5_SPEECH_KWS_MODEL_DOUBAO = r4;
        String r6 = r3.getStage2Config().getVoiceprint_md5();
        if (r6 == null) goto L9;
        r5 = r6;
    L9:
        MD5_SPEECH_VOICE_PRINT_MODEL = r5;
    }

    public final Context getAppContext() {
        Context r0 = appContext;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final long getModelStartDownloadTime() {
        EffectPlatformProvider r0 = effectPlatformProvider;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getStartDownloadTime();
    }

    public final String getPATH_KEY_INFO_KWS_SECOND_MODEL() {
        LogUtils.d(TAG, "someone is getting kws key " + PATH_KEY_INFO_KWS_SECOND_MODEL, new Object[0]);
        return PATH_KEY_INFO_KWS_SECOND_MODEL;
    }

    public final String getPATH_KEY_INFO_KWS_SID_AUTH_MODEL() {
        String r0 = AuthModelConfig.INSTANCE.getAuthKeyInfoPath();
        LogUtils.d(TAG, "someone is getting sid auth key " + r0, new Object[0]);
        return r0;
    }

    public final String getPATH_KEY_INFO_KWS_SID_MODEL() {
        LogUtils.d(TAG, "someone is getting sid key " + PATH_KEY_INFO_KWS_SID_MODEL, new Object[0]);
        return PATH_KEY_INFO_KWS_SID_MODEL;
    }

    public final String getPATH_SPEECH_KWS_MODEL_DOUBAO() {
        LogUtils.d(TAG, "someone is getting kws path " + PATH_SPEECH_KWS_MODEL_DOUBAO, new Object[0]);
        return PATH_SPEECH_KWS_MODEL_DOUBAO;
    }

    public final String getPATH_SPEECH_VOICE_PRINT_SID_AUTH_MODEL() {
        String r0 = AuthModelConfig.INSTANCE.getAuthModelPath();
        LogUtils.d(TAG, "someone is getting sid auth path " + r0, new Object[0]);
        return r0;
    }

    public final String getPATH_SPEECH_VOICE_PRINT_SID_MODEL() {
        LogUtils.d(TAG, "someone is getting sid path " + PATH_SPEECH_VOICE_PRINT_SID_MODEL, new Object[0]);
        return PATH_SPEECH_VOICE_PRINT_SID_MODEL;
    }

    public final void triggerDownload() {
        LogUtils.d(TAG, "triggerDownload !! " + effectPlatformProvider, new Object[0]);
        EffectPlatformProvider r0 = effectPlatformProvider;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEngineInited() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        r0.downloadAsync();
        return;
    }

    public static final /* synthetic */ EffectPlatformProvider access$getEffectPlatformProvider$p() {
        return effectPlatformProvider;
    }

    public final String getMD5_SPEECH_KWS_MODEL_DOUBAO() {
        return MD5_SPEECH_KWS_MODEL_DOUBAO;
    }

    public final String getMD5_SPEECH_VOICE_PRINT_MODEL() {
        return MD5_SPEECH_VOICE_PRINT_MODEL;
    }

    public final String getPATH_ENROLL() {
        return PATH_ENROLL;
    }

    public final String getPATH_ENROLL_RECORD() {
        return PATH_ENROLL_RECORD;
    }

    public final String getPATH_ENROLL_SID() {
        return PATH_ENROLL_SID;
    }

    public final String getPATH_ROOT() {
        return PATH_ROOT;
    }

    public final String getPATH_SPEECH_SILENCE_AUDIO_FILE() {
        return PATH_SPEECH_SILENCE_AUDIO_FILE;
    }

    public final String getPATH_SPEECH_SM_MODEL_CPU() {
        return PATH_SPEECH_SM_MODEL_CPU;
    }

    public final EffectSchedule getScheduler() {
        return scheduler;
    }

    private final void flushPendingAuthModelDownload(String r4) {
        if (pendingAuthModelDownload.get() == true) goto L5;
        return;
    L5:
        LogUtils.i(TAG, "flushPendingAuthModelDownload reason=" + r4, new Object[0]);
        triggerAuthModelDownload("pending_" + r4);
    }

    private static final Unit init$lambda$6$lambda$3(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        EffectPlatformProvider r0 = effectPlatformProvider;
        if (r0 != null) goto L5;
        LogUtils.d(TAG, "SvaSdkGlobal init done ✅ " + ConfigManager.INSTANCE.getStage2Config() + " !", new Object[0]);
    L20:
        return Unit.INSTANCE;
    L5:
        if (r0 == null) goto L7;
        r0.initAlgorithmResourceManager();
    L7:
        LogUtils.d(TAG, "SvaSdkGlobal init done ✅ " + ConfigManager.INSTANCE.getStage2Config() + " try to download in 3 secs", new Object[0]);
        SvaSdkGlobal r1 = INSTANCE;
        EffectSchedule r2 = r1.getScheduler();
        if (r2 == null) goto L10;
        r2.resetTriggerTime();
    L10:
        EffectPlatformProvider r3 = effectPlatformProvider;
        if (r3 != null) goto L13;
    L18:
        r1.flushPendingAuthModelDownload(r4);
        goto L20
    L13:
        if (r3.isEngineInited() == true) goto L16;
        r3 = null;
    L16:
        if (r3 == null) goto L18;
        r3.downloadAsync();
        goto L18
    }

    private static final String init$lambda$6$lambda$5(Context r0) {
        Intrinsics.checkNotNull(r0);
        return b.i(r0);
    }

    private final void loadConfig(Context r7) {
        ConfigManager r0 = ConfigManager.INSTANCE;
        r0.readDefaultConfig(r7);
        if (r0.getModelConfig().isAlternative() == true) goto L5;
        return;
    L5:
        if (r0.getModelConfig().isConfigExist() == true) goto L8;
        LogUtils.d(TAG, "loadAlternativeConfig of alternative but config file is not exist , so just restore default", new Object[0]);
        EffectUtils.INSTANCE.restoreDefaultConfig();
        return;
    L8:
        LogUtils.d(TAG, "loadAlternativeConfig of alternative", new Object[0]);
        boolean r8 = r0.readAlternativeConfig();
        LogUtils.d(TAG, "loadAlternativeConfig success " + r8, new Object[0]);
        if (r8 == true) goto L11;
    L15:
        EffectPlatformProvider r9 = effectPlatformProvider;
        if (r9 == null) goto L20;
        boolean r4 = true;
        if (r9.canRollback() != true) goto L20;
    L21:
        LogUtils.d(TAG, "loadAlternativeConfig failed due to not success or bad digest or version not bigger , can we rollback ? " + r4, new Object[0]);
        if (r4 == false) goto L33;
        LogUtils.d(TAG, "loadAlternativeConfig failed, now roll back ", new Object[0]);
        EffectPlatformProvider r10 = effectPlatformProvider;
        if (r10 == null) goto L26;
        r10.rollback();
    L26:
        boolean r11 = r0.readAlternativeConfig();
        LogUtils.d(TAG, "loadAlternativeConfig reloadSuccess " + r11, new Object[0]);
        if (r11 == true) goto L29;
        return;
    L29:
        if (EffectUtils.INSTANCE.checkDigest(EffectConstant.INSTANCE.getLatestRoot(), r0.getModelConfig().getManifest()) == true) goto L31;
        return;
    L31:
        if (r0.canOverwriteByManifest() == false) goto L39;
        r0.overwriteByManifest();
        LogUtils.d(ConfigManager.TAG, "after reload overwriteByManifest " + r0.getStage2Config(), new Object[0]);
        return;
    L39:
        return;
    L33:
        LogUtils.d(ConfigManager.TAG, "Unfortunately!!  we have to use the default config and model", new Object[0]);
        return;
    L20:
        r4 = false;
        goto L21
    L11:
        if (EffectUtils.INSTANCE.checkDigest(EffectConstant.INSTANCE.getLatestRoot(), r0.getModelConfig().getManifest()) == false) goto L15;
        if (r0.canOverwriteByManifest() == false) goto L15;
        r0.overwriteByManifest();
        LogUtils.d(ConfigManager.TAG, "after overwriteByManifest " + r0.getStage2Config(), new Object[0]);
    }

    public final String getKeyInfoKwsModel(String r9) {
        Intrinsics.checkNotNullParameter(r9, "filePath");
        JSONObject r6 = new JSONObject(FilesKt.readText$default(new PolarisFileWrapper(r9), null, 1, null));     // Catch: Exception -> L13
        String r3 = t9a.b.a().d();     // Catch: Exception -> L13
        LogUtils.d(TAG, "productName = " + r3, new Object[0]);     // Catch: Exception -> L13
        JSONObject r2 = r6.optJSONObject(r3);     // Catch: Exception -> L13
        if (r2 == null) goto L18;
        String r10 = r2.toString();     // Catch: Exception -> L13
        if (r10 != null) goto L20;
        return "";
    L20:
        return r10;
    L18:
        return "";
    L13:
        e = move-exception;
        LogUtils.e(TAG, "解析keyinfo密钥信息JSON失败，路径：" + r9, new Object[]{e});
        return "";
    L10:
        e = move-exception;
        LogUtils.e(TAG, "读取keyinfo密钥信息文件失败，路径：" + r9, new Object[]{e});     // Catch: Exception -> L13
        return "";
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [com.obric.sva.sdk.controller.x] */
    public final void init(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        boolean r0 = KtUtils.INSTANCE.isWakeupProcess(r9);
        boolean r3 = false;
        LogUtils.d(TAG, "SvaSdkGlobal init wakeupProcess? " + r0, new Object[0]);
        if (initialized == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (initialized == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        final Context r1 = r9.getApplicationContext();     // Catch: Throwable -> L22
        appContext = r1;     // Catch: Throwable -> L22
        EffectConstant r2 = EffectConstant.INSTANCE;     // Catch: Throwable -> L22
        r2.setBaseRoot(Utils.rootFilePath(r9).getAbsolutePath());     // Catch: Throwable -> L22
        r2.setAuthBaseRoot(new PolarisFileWrapper(r1.getFilesDir(), "obric_auth_model").getAbsolutePath());     // Catch: Throwable -> L22
        r2.setSdkCacheRoot(new PolarisFileWrapper(r1.getFilesDir(), "obric_sdk_cache").getAbsolutePath());     // Catch: Throwable -> L22
        final ?? r4 = new x();     // Catch: Throwable -> L22
        final CompletableDeferred r5 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);     // Catch: Throwable -> L22
        if (r0 == false) goto L13;
        SvaSdkGlobal r6 = INSTANCE;     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L22
        r6.initEffectPlatformProvider(r1, new y(r4, r5));     // Catch: Throwable -> L22
        scheduler = EffectSchedule.Companion.getInstance(r1);     // Catch: Throwable -> L22
        r3 = true;
    L13:
        CryptoManager.getInstance().init(r1);     // Catch: Throwable -> L22
        LocalDataCrypto.getInstance().init(r1);     // Catch: Throwable -> L22
        PATH_ROOT = r2.getBaseRoot();     // Catch: Throwable -> L22
        AuthModelConfig r7 = AuthModelConfig.INSTANCE;     // Catch: Throwable -> L22
        r7.cleanupDeprecatedAuthModels();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L22
        r7.loadFromLatestIfExists(r1);     // Catch: Throwable -> L22
        ConfigManager.INSTANCE.init(PATH_ROOT);     // Catch: Throwable -> L22
        SvaSdkGlobal r8 = INSTANCE;     // Catch: Throwable -> L22
        r8.loadConfig(r9);     // Catch: Throwable -> L22
        r8.loadEachPath();     // Catch: Throwable -> L22
        r5.complete(1);     // Catch: Throwable -> L22
        if (r0 == false) goto L16;
        SamiPhoneEnrollManager.triggerMigrationAsync(r1, new z(r1));     // Catch: Throwable -> L22
        OhrHandStateBridge.INSTANCE.switchStateAsync(r1, i.a(), "sva_global_init");     // Catch: Throwable -> L22
    L16:
        initialized = true;     // Catch: Throwable -> L22
        if (r3 == true) goto L19;
        r4.invoke("init");     // Catch: Throwable -> L22
    L19:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
    }

    public final void reload(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ConfigManager.INSTANCE.reLoadCurrentJson(PATH_ROOT);
        loadConfig(r3);
        loadEachPath();
    }

    public final void setMD5_SPEECH_KWS_MODEL_DOUBAO(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        MD5_SPEECH_KWS_MODEL_DOUBAO = r2;
    }

    public final void triggerAuthModelDownload(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        LogUtils.i(TAG, "triggerAuthModelDownload reason=" + r6 + " provider=" + effectPlatformProvider, new Object[0]);
        EffectPlatformProvider r0 = effectPlatformProvider;
        if (r0 != null) goto L7;
        pendingAuthModelDownload.set(true);
        LogUtils.i(TAG, "triggerAuthModelDownload pending: provider null", new Object[0]);
        return;
    L7:
        if (r0.isEngineInited() == true) goto L12;
        pendingAuthModelDownload.set(true);
        r0.initAlgorithmResourceManager();
        if (r0.isEngineInited() == true) goto L12;
        LogUtils.i(TAG, "triggerAuthModelDownload pending: engine not ready", new Object[0]);
        return;
    L12:
        pendingAuthModelDownload.set(false);
        r0.triggerAuthModelDownload(r6);
    }

    private final void initEffectPlatformProvider(Context r8, Function1<? super String, Unit> r9) {
        effectPlatformProvider = new EffectPlatformProvider(r8);     // Catch: Exception -> L4
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r9, null), 3, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LogUtils.w(TAG, "EffectPlatformProvider init failed due to provider not ready, retry after 3s, error: " + e.getMessage(), new Object[0]);
        ThreadUtil.postDelayedOnWorkThread(new a0(r8, r9), InteractorReportInitializer.REPORT_EVENT_DELAY_MS);
    }

    private static final void initEffectPlatformProvider$lambda$7(Context r3, Function1 r4) {
        effectPlatformProvider = new EffectPlatformProvider(r3);     // Catch: Exception -> L5
        r4.invoke("retry_init");     // Catch: Exception -> L5
        LogUtils.i(TAG, "EffectPlatformProvider retry init succeeded", new Object[0]);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        LogUtils.e(TAG, "EffectPlatformProvider retry init failed: " + e.getMessage(), new Object[0]);
    }

    private static final Unit init$lambda$6$lambda$4(Function1 r7, CompletableDeferred r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "tag");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SvaSdkGlobal$init$1$1$1(r7, r9, r8, null), 3, null);
        return Unit.INSTANCE;
    }
}
