package com.obric.sva.sdk.sami;

import android.content.Context;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.mammon.audiosdk.SpeechWakeupService;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.config.ConfigManager;
import com.obric.sva.sdk.controller.SvaSdkGlobal;
import com.obric.sva.sdk.upload.WakeupUploadManager;
import com.obric.sva.sdk.utils.LogUtils;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rJ\u0015\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0015J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001c\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0005J!\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0002\b!J.\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010-J\u000e\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020*J\u0006\u00100\u001a\u00020*J\u0016\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0018J\u000e\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/obric/sva/sdk/sami/SamiWakeupParamProvider;", "", "<init>", "()V", "TAG", "", "VOICEPRINT_DB_DIR_NAME", "VOICEPRINT_DB_FILE_NAME", "snapshotRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/sva/sdk/sami/WakeupParamSnapshot;", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "voiceBusinessType", "baseSnapshotLock", "Ljava/lang/Object;", "init", "", "context", "resolveVoiceBusinessType", "resolveVoiceBusinessType$libs_mainlandRelease", "currentBusinessType", "type", "Lcom/obric/sva/sdk/sami/WakeupBusinessType;", "buildVoiceBusinessType", "buildChannel", "refreshBaseSnapshot", "cachedUuid", "prepareBaseSnapshot", "ensurePhoneEnrollBaseSnapshot", "ensurePhoneEnrollBaseSnapshot$libs_mainlandRelease", "buildVoiceprintDbPath", "buildVoiceprintDbPath$libs_mainlandRelease", "updateBeforeWakeup", "engineVersion", "groupId", "aecState", "", "sidVolume", "", "screenOff", "", "updateSidThresholds", "sidThresholds", "", "updateBypassAdaptiveSid", "bypassAdaptiveSid", "isBypassAdaptiveSid", "register", "service", "Lcom/mammon/audiosdk/SpeechWakeupService;", "businessType", "triggerBreathFeedbackUpload", "reason", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SamiWakeupParamProvider {
    public static final SamiWakeupParamProvider INSTANCE = null;
    private static final String TAG = "SamiWakeupParamProvider";
    private static final String VOICEPRINT_DB_DIR_NAME = "voiceprint_db";
    private static final String VOICEPRINT_DB_FILE_NAME = "voice_print.db";
    private static volatile Context appContext;
    private static final Object baseSnapshotLock = null;
    private static final AtomicReference<WakeupParamSnapshot> snapshotRef = null;
    private static volatile String voiceBusinessType;

    private SamiWakeupParamProvider() {
    }

    public static /* synthetic */ void a(WakeupBusinessType r0, String r1, byte[] r2) {
        register$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ String b(String r0, WakeupBusinessType r1, String r2, int r3) {
        return register$lambda$10(r0, r1, r2, r3);
    }

    static {
        SamiWakeupParamProvider r0 = new SamiWakeupParamProvider();
        INSTANCE = r0;
        snapshotRef = new AtomicReference(new WakeupParamSnapshot(null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, null, false, 16777215, null));
        voiceBusinessType = r0.buildVoiceBusinessType("debug");
        baseSnapshotLock = new Object();
    }

    public final boolean isBypassAdaptiveSid() {
        return snapshotRef.get().getBypassAdaptiveSid();
    }

    private final String buildVoiceBusinessType(String r3) {
        return "Obric-" + Build.MODEL + '-' + r3;
    }

    private final String currentBusinessType(WakeupBusinessType r2) {
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L8;
        return "PureBreathWakeup";
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return voiceBusinessType;
    }

    public final String buildVoiceprintDbPath$libs_mainlandRelease(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        File r5 = r4.getFilesDir();
        if (r5 == null) goto L20;
        File r6 = r5.getParentFile();
        if (r6 == null) goto L24;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6, VOICEPRINT_DB_DIR_NAME);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        if (r0.exists() == true) goto L11;
        r0.mkdirs();     // Catch: Throwable -> L13
    L11:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L19;
        LogUtils.e(TAG, "create voiceprint db dir failed: " + r9.getMessage(), new Object[0]);
    L19:
        return new PolarisFileWrapper(r0, VOICEPRINT_DB_FILE_NAME).getAbsolutePath();
    L13:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L24:
        return "";
    L20:
        return "";
    }

    public final void init(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Context r4 = r3.getApplicationContext();
        appContext = r4;
        Intrinsics.checkNotNull(r4);
        voiceBusinessType = buildVoiceBusinessType(rna.b.f(r4));
        refreshBaseSnapshot$default(this, r4, null, 2, null);
    }

    public final String resolveVoiceBusinessType$libs_mainlandRelease(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r3 = buildVoiceBusinessType(rna.b.f(r2.getApplicationContext()));
        voiceBusinessType = r3;
        return r3;
    }

    public final void triggerBreathFeedbackUpload(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        WakeupUploadManager.INSTANCE.onFeedbackSubmit();
        LogUtils.i(TAG, "triggerBreathFeedbackUpload handled in interactor reason=" + r3, new Object[0]);
    }

    public final void updateBypassAdaptiveSid(boolean r29) {
        AtomicReference<WakeupParamSnapshot> r15 = snapshotRef;
        WakeupParamSnapshot r24 = r15.get();
        if (r24.getBypassAdaptiveSid() != r29) goto L5;
        return;
    L5:
        r15.set(WakeupParamSnapshot.copy$default(r24, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, null, r29, 8388607, null));
        LogUtils.i(TAG, "updateBypassAdaptiveSid bypassAdaptiveSid=" + r29, new Object[0]);
    }

    public final void updateSidThresholds(float[] r31) {
        AtomicReference<WakeupParamSnapshot> r1 = snapshotRef;
        WakeupParamSnapshot r3 = r1.get();
        String r2 = null;
        if (r31 == null) goto L5;
        float[] r0 = Arrays.copyOf(r31, r31.length);
    L6:
        r1.set(WakeupParamSnapshot.copy$default(r3, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, r0, false, 12582911, null));
        StringBuilder r4 = new StringBuilder("updateSidThresholds sidThresholds=");
        if (r0 == null) goto L9;
        r2 = Arrays.toString(r0);
    L9:
        r4.append(r2);
        LogUtils.d(TAG, r4.toString(), new Object[0]);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private final WakeupParamSnapshot refreshBaseSnapshot(Context r39, String r40) {
        Context r1 = r39.getApplicationContext();
        Object r2 = baseSnapshotLock;
        monitor-enter(r2);
        AtomicReference<WakeupParamSnapshot> r3 = snapshotRef;     // Catch: Throwable -> L100
        WakeupParamSnapshot r5 = r3.get();     // Catch: Throwable -> L100
        if (r40 != null) goto L7;
        String r4 = "";
    L8:
        String r6 = StringsKt.substringAfter(r4, '-', "");     // Catch: Throwable -> L100
        if (r4.length() <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == true) goto L14;
    L19:
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L100
        String[] r9 = rna.b.j(r1);     // Catch: Throwable -> L100
    L20:
        String r10 = (String) ArraysKt.getOrNull(r9, 0);     // Catch: Throwable -> L100
        if (r10 != null) goto L23;
        r10 = "";
    L23:
        String r11 = (String) ArraysKt.getOrNull(r9, 1);     // Catch: Throwable -> L100
        if (r11 != null) goto L27;
        r11 = "";
    L27:
        if (r4.length() <= 0) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == false) goto L38;
        if (r6.length() <= 0) goto L34;
        boolean r7 = true;
    L35:
        if (r7 == false) goto L38;
        String r13 = r4;
    L51:
        if (r11.length() != 0) goto L53;
        boolean r14 = true;
    L54:
        if (r14 == false) goto L56;
        String r32 = r13;
    L57:
        SamiWakeupParamProvider r15 = INSTANCE;     // Catch: Throwable -> L100
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L100
        String r16 = r15.buildVoiceprintDbPath$libs_mainlandRelease(r1);     // Catch: Throwable -> L100
        String r17 = r5.getAppId();     // Catch: Throwable -> L100
        if (r17.length() != 0) goto L60;
        boolean r18 = true;
    L61:
        if (r18 == false) goto L63;
        r17 = rna.b.d(r1);     // Catch: Throwable -> L100
    L63:
        String r33 = r17;
        String r19 = r5.getAppVersion();     // Catch: Throwable -> L100
        if (r19.length() != 0) goto L66;
        boolean r110 = true;
    L67:
        if (r110 == false) goto L69;
        r19 = rna.b.e(r1);     // Catch: Throwable -> L100
    L69:
        String r34 = r19;
        if (r10.length() != 0) goto L72;
        boolean r20 = true;
    L73:
        if (r20 == false) goto L81;
        String r21 = r5.getDoubaoUid();     // Catch: Throwable -> L100
        if (r21.length() != 0) goto L77;
        boolean r22 = true;
    L78:
        if (r22 == false) goto L80;
        r21 = StringsKt.substringBefore(r13, '-', "");     // Catch: Throwable -> L100
    L80:
        r10 = r21;
        goto L81
    L77:
        r22 = false;
    L81:
        String r35 = r10;
        String r23 = rna.b.g(r1);     // Catch: Throwable -> L100
        if (r23.length() != 0) goto L84;
        boolean r24 = true;
    L85:
        if (r24 == false) goto L87;
        r23 = r5.getDoubaoDid();     // Catch: Throwable -> L100
    L87:
        ConfigManager r25 = ConfigManager.INSTANCE;     // Catch: Throwable -> L100
        String r26 = r25.getStage2Config().getKws_rawfile_md5();     // Catch: Throwable -> L100
        if (r26 != null) goto L90;
        r26 = "";
    L90:
        String r111 = r26;
        SvaSdkGlobal r27 = SvaSdkGlobal.INSTANCE;     // Catch: Throwable -> L100
        String r112 = r27.getPATH_SPEECH_KWS_MODEL_DOUBAO();     // Catch: Throwable -> L100
        String r28 = r27.getKeyInfoKwsModel(r27.getPATH_KEY_INFO_KWS_SECOND_MODEL());     // Catch: Throwable -> L100
        String r29 = r25.getStage2Config().getVoiceprint_rawfile_md5();     // Catch: Throwable -> L100
        if (r29 != null) goto L93;
        r29 = "";
    L93:
        WakeupParamSnapshot r30 = WakeupParamSnapshot.copy$default(r5, r32, r32, r13, r35, r23, r16, 0, r34, null, null, null, r33, r111, r112, r28, r29, r27.getPATH_SPEECH_VOICE_PRINT_SID_MODEL(), r27.getKeyInfoKwsModel(r27.getPATH_KEY_INFO_KWS_SID_MODEL()), null, 0, 0, 0.0f, null, false, 16516928, null);     // Catch: Throwable -> L100
        r3.set(r30);     // Catch: Throwable -> L100
        StringBuilder r31 = new StringBuilder("refreshBaseSnapshot voiceprint db uid=");     // Catch: Throwable -> L100
        r31.append(rna.b.l(r13));     // Catch: Throwable -> L100
        r31.append(" snLen=");     // Catch: Throwable -> L100
        r31.append(r32.length());     // Catch: Throwable -> L100
        r31.append(" dbPath=");     // Catch: Throwable -> L100
        r31.append(r16);     // Catch: Throwable -> L100
        r31.append(" doubaoUidLen=");     // Catch: Throwable -> L100
        r31.append(r35.length());     // Catch: Throwable -> L100
        r31.append(" doubaoDidLen=");     // Catch: Throwable -> L100
        r31.append(r23.length());     // Catch: Throwable -> L100
        r31.append(" appIdLen=");     // Catch: Throwable -> L100
        r31.append(r33.length());     // Catch: Throwable -> L100
        r31.append(" appVersionLen=");     // Catch: Throwable -> L100
        r31.append(r34.length());     // Catch: Throwable -> L100
        r31.append(" fromCachedUuid=");     // Catch: Throwable -> L100
        if (r4.length() <= 0) goto L96;
        boolean r113 = true;
    L97:
        r31.append(r113);     // Catch: Throwable -> L100
        LogUtils.i(TAG, r31.toString(), new Object[0]);     // Catch: Throwable -> L100
        monitor-exit(r2);
        return r30;
    L96:
        r113 = false;
        goto L97
    L84:
        r24 = false;
        goto L85
    L72:
        r20 = false;
        goto L73
    L66:
        r110 = false;
        goto L67
    L60:
        r18 = false;
        goto L61
    L56:
        r32 = r11;
        goto L57
    L53:
        r14 = false;
        goto L54
    L34:
        r7 = false;
    L38:
        if (r10.length() <= 0) goto L40;
        boolean r36 = true;
    L41:
        if (r36 == true) goto L43;
    L48:
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L100
        String r37 = rna.b.i(r1);     // Catch: Throwable -> L100
    L49:
        r13 = r37;
        goto L51
    L43:
        if (r11.length() <= 0) goto L45;
        boolean r38 = true;
    L46:
        if (r38 == false) goto L48;
        r37 = r10 + '-' + r11;     // Catch: Throwable -> L100
        goto L49
    L45:
        r38 = false;
        goto L46
    L40:
        r36 = false;
        goto L41
    L29:
        r12 = false;
        goto L30
    L14:
        if (r6.length() <= 0) goto L16;
        boolean r41 = true;
    L17:
        if (r41 == false) goto L19;
        r9 = new String[]{StringsKt.substringBefore$default(r4, '-', null, 2, null), r6};     // Catch: Throwable -> L100
        goto L20
    L16:
        r41 = false;
        goto L17
    L11:
        r8 = false;
        goto L12
    L7:
        r4 = r40;
    L100:
        th = move-exception;
        throw th;
    }

    public final WakeupParamSnapshot ensurePhoneEnrollBaseSnapshot$libs_mainlandRelease(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        WakeupParamSnapshot r0 = snapshotRef.get();
        if (r7 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        boolean r2 = true ^ r3;
        if (StringsKt.isBlank(r0.getSn()) == false) goto L12;
    L19:
        LogUtils.i(TAG, "ensurePhoneEnrollBaseSnapshot refresh empty base snapshot: snLen=" + r0.getSn().length() + " uid=" + rna.b.l(r0.getUid()) + " appIdLen=" + r0.getAppId().length() + " dbPathLen=" + r0.getDbPath().length() + " hasCachedUuid=" + r2, new Object[0]);
        return refreshBaseSnapshot(r6, r7);
    L12:
        if (StringsKt.isBlank(r0.getUid()) == true) goto L19;
        if (StringsKt.isBlank(r0.getAppId()) == true) goto L19;
        if (StringsKt.isBlank(r0.getDbPath()) == true) goto L19;
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r3 = false;
        goto L9
    }

    public final void prepareBaseSnapshot(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "cachedUuid");
        if (StringsKt.isBlank(r3) == false) goto L6;
        LogUtils.w(TAG, "prepareBaseSnapshot ignored: cachedUuid is blank", new Object[0]);
        return;
    L6:
        refreshBaseSnapshot(r2.getApplicationContext(), r3);
    }

    public final void register(SpeechWakeupService r3, WakeupBusinessType r4) {
        Intrinsics.checkNotNullParameter(r3, "service");
        Intrinsics.checkNotNullParameter(r4, "businessType");
        String r0 = currentBusinessType(r4);
        r3.registerWakeupParamRequestCallback(new f(r0, r4));
        r3.registerWakeupUploadTaskCallback(new g(r4, r0));
        LogUtils.i(TAG, "register callbacks done business=" + r0, new Object[0]);
    }

    private static final void register$lambda$11(WakeupBusinessType r3, String r4, byte[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = StringsKt.substringBefore(snapshotRef.get().getUid(), '-', "");
        int r6 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r6 != 1) goto L7;
        WakeupUploadManager.INSTANCE.onVoiceUploadTask(r5, r0);
    L12:
        LogUtils.i(TAG, "onWakeupUploadTask business=" + r4 + " size=" + r5.length, new Object[0]);
        return;
    L7:
        if (r6 != 2) goto L10;
        WakeupUploadManager.INSTANCE.onBreathUploadTask(r5, r0);
        goto L12
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private static final String register$lambda$10(String r2, WakeupBusinessType r3, String r4, int r5) {
        WakeupParamSnapshot r6 = snapshotRef.get();
        String r7 = r6.toJson(r2, r3.getIncludeModelInfo());
        LogUtils.i(TAG, "onWakeupParamRequest business=" + r2 + " includeModelInfo=" + r3.getIncludeModelInfo() + " snLen=" + r6.getSn().length() + " uid=" + rna.b.l(r6.getUid()) + " appIdLen=" + r6.getAppId().length() + " dbPath=" + r6.getDbPath() + " modelMd5Len=" + r6.getModelMd5().length() + " modelPath=" + r6.getModelPath() + " sidModelMd5Len=" + r6.getSidModelMd5().length() + " sidModelPath=" + r6.getSidModelPath() + "appVersion=" + r6.getAppVersion(), new Object[0]);
        return r7;
    }

    public static /* synthetic */ WakeupParamSnapshot ensurePhoneEnrollBaseSnapshot$libs_mainlandRelease$default(SamiWakeupParamProvider r0, Context r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.ensurePhoneEnrollBaseSnapshot$libs_mainlandRelease(r1, r2);
    }

    public static /* synthetic */ WakeupParamSnapshot refreshBaseSnapshot$default(SamiWakeupParamProvider r0, Context r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.refreshBaseSnapshot(r1, r2);
    }

    public final void updateBeforeWakeup(String r31, String r32, int r33, float r34, boolean r35) {
        Intrinsics.checkNotNullParameter(r31, "engineVersion");
        Intrinsics.checkNotNullParameter(r32, "groupId");
        AtomicReference<WakeupParamSnapshot> r14 = snapshotRef;
        WakeupParamSnapshot r0 = r14.get();
        Context r1 = appContext;
        String r2 = r0.getDoubaoDid();
        if (r2.length() != 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L11;
        if (r1 == null) goto L10;
        r2 = rna.b.g(r1);
        goto L11
    L10:
        r2 = "";
    L11:
        String r27 = r2;
        ConfigManager r4 = ConfigManager.INSTANCE;
        String r5 = r4.getStage2Config().getKws_rawfile_md5();
        if (r5 != null) goto L14;
        String r16 = "";
    L15:
        SvaSdkGlobal r6 = SvaSdkGlobal.INSTANCE;
        String r21 = r6.getPATH_SPEECH_KWS_MODEL_DOUBAO();
        String r22 = r6.getKeyInfoKwsModel(r6.getPATH_KEY_INFO_KWS_SECOND_MODEL());
        String r7 = r4.getStage2Config().getVoiceprint_rawfile_md5();
        if (r7 != null) goto L18;
        String r28 = "";
    L19:
        String r17 = r6.getPATH_SPEECH_VOICE_PRINT_SID_MODEL();
        String r18 = r6.getKeyInfoKwsModel(r6.getPATH_KEY_INFO_KWS_SID_MODEL());
        WakeupParamSnapshot r8 = WakeupParamSnapshot.copy$default(r0, null, null, null, null, r27, null, r35 ? 1 : 0, null, r32, r31, null, null, r16, r21, r22, r28, r17, r18, null, 0, r33, r34, null, false, 13372591, null);
        r14.set(r8);
        LogUtils.d(TAG, "updateBeforeWakeup engineVersion=" + r31 + " appStatus=" + r8.getAppStatus() + " groupIdLen=" + r8.getGroupId().length() + " aecState=" + r33 + " sidVolume=" + r34 + " doubaoUidLen=" + r8.getDoubaoUid().length() + " doubaoDidLen=" + r27.length() + " modelMd5Len=" + r8.getModelMd5().length() + " sidModelMd5Len=" + r8.getSidModelMd5().length(), new Object[0]);
        return;
    L18:
        r28 = r7;
        goto L19
    L14:
        r16 = r5;
        goto L15
    L5:
        r3 = false;
        goto L7
    }
}
