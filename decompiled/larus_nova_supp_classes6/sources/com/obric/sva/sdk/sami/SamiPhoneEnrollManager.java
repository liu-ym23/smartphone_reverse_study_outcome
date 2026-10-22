package com.obric.sva.sdk.sami;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.mammon.audiosdk.SpeechFingerPrintEnrollService;
import com.mammon.audiosdk.enums.SAMICoreTokenType;
import com.mammon.audiosdk.structures.SpeechFingerprintEnrollParameter;
import com.mammon.audiosdk.structures.SpeechFingerprintResult;
import com.obric.assistant.voice.l;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.controller.SvaSdkGlobal;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u000389:B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018H\u0007J\u001c\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0007J \u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0005J\u001a\u0010 \u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u001c2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J \u0010&\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010)\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010\"\u001a\u00020\u0010H\u0002J0\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0002J\"\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0001H\u0002J\u001a\u00107\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/obric/sva/sdk/sami/SamiPhoneEnrollManager;", "", "<init>", "()V", "TAG", "", "SAMI_INTERNAL_URL", "VOICEPRINT_ENGINE_VERSION", "phoneEnrollQueryHandleLock", "Ljava/lang/Object;", "phoneEnrollMigrationLock", "legacyMigrationCompleted", "", "phoneEnrollQueryService", "Lcom/mammon/audiosdk/SpeechFingerPrintEnrollService;", "phoneEnrollQueryHandleKey", "Lcom/obric/sva/sdk/sami/SamiPhoneEnrollManager$PhoneEnrollQueryHandleKey;", "queryPhoneEnrolledFromLocalDb", "context", "Landroid/content/Context;", "cachedUuid", "triggerMigrationAsync", "", "uuidProvider", "Lkotlin/Function0;", "migrateLegacyPhoneEnrollIfNeeded", "", "queryPhoneEnrollStatusFromLocalDb", "Lcom/obric/sva/sdk/sami/SamiPhoneEnrollManager$PhoneEnrollQueryStatus;", "forceReEnrollWakeupSid", "reason", "releasePhoneEnrollHandle", "buildPhoneEnrollQueryHandleKey", "getOrCreatePhoneEnrollQueryServiceLocked", "key", "queryPhoneEnrolledWithService", "service", "releasePhoneEnrollQueryHandleLocked", "releasePhoneEnrollService", "purpose", "Lcom/obric/sva/sdk/sami/SamiPhoneEnrollManager$PhoneEnrollHandlePurpose;", "invalidatePhoneEnrollQueryHandleLocked", "buildPhoneEnrollQueryHandleParam", "Lcom/mammon/audiosdk/structures/SpeechFingerprintEnrollParameter;", "fillPhoneEnrollCommonHandleParam", "param", "sn", "uid", "dbPath", "appId", "setPublicField", "target", "name", "value", "dumpParams", "formatFieldValue", "PhoneEnrollQueryStatus", "PhoneEnrollHandlePurpose", "PhoneEnrollQueryHandleKey", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SamiPhoneEnrollManager {
    public static final SamiPhoneEnrollManager INSTANCE = null;
    private static final String SAMI_INTERNAL_URL = "https://audio.doubao.com/internal";
    private static final String TAG = "SamiPhoneEnrollManager";
    private static final String VOICEPRINT_ENGINE_VERSION = "1.0.0.100";
    private static volatile boolean legacyMigrationCompleted;
    private static final Object phoneEnrollMigrationLock = null;
    private static volatile PhoneEnrollQueryHandleKey phoneEnrollQueryHandleKey;
    private static final Object phoneEnrollQueryHandleLock = null;
    private static volatile SpeechFingerPrintEnrollService phoneEnrollQueryService;

    private SamiPhoneEnrollManager() {
    }

    public static /* synthetic */ CharSequence a(SamiPhoneEnrollManager r0, Object r1, Field r2) {
        return dumpParams$lambda$23$lambda$22(r0, r1, r2);
    }

    public static /* synthetic */ void b(Context r0, Function0 r1) {
        triggerMigrationAsync$lambda$2(r0, r1);
    }

    public final int migrateLegacyPhoneEnrollIfNeeded(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return migrateLegacyPhoneEnrollIfNeeded$default(this, r3, null, 2, null);
    }

    public final PhoneEnrollQueryStatus queryPhoneEnrollStatusFromLocalDb(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return queryPhoneEnrollStatusFromLocalDb$default(this, r3, null, 2, null);
    }

    public final boolean queryPhoneEnrolledFromLocalDb(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        return queryPhoneEnrolledFromLocalDb$default(this, r3, null, 2, null);
    }

    static {
        INSTANCE = new SamiPhoneEnrollManager();
        phoneEnrollQueryHandleLock = new Object();
        phoneEnrollMigrationLock = new Object();
    }

    private final SpeechFingerprintEnrollParameter buildPhoneEnrollQueryHandleParam(PhoneEnrollQueryHandleKey r8) {
        SpeechFingerprintEnrollParameter r6 = new SpeechFingerprintEnrollParameter();
        INSTANCE.fillPhoneEnrollCommonHandleParam(r6, r8.getSn(), r8.getUid(), r8.getDbPath(), r8.getAppId());
        return r6;
    }

    private final String dumpParams(Object r12) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Field[] r2 = r12.getClass().getFields();     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L5
        Object r0 = Result.constructor-impl(ArraysKt.joinToString$default(r2, null, r12.getClass().getSimpleName().concat("("), ")", 0, null, new a(this, r12), 25, null));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L12;
        r0 = r12.getClass().getSimpleName() + "(dump_failed=" + r3.getMessage() + ')';
    L12:
        return (String) r0;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final SpeechFingerPrintEnrollService getOrCreatePhoneEnrollQueryServiceLocked(PhoneEnrollQueryHandleKey r10) {
        SpeechFingerPrintEnrollService r0 = phoneEnrollQueryService;
        if (r0 != null) goto L5;
    L11:
        releasePhoneEnrollQueryHandleLocked("recreate query");
        SpeechFingerPrintEnrollService r1 = new SpeechFingerPrintEnrollService();
        SpeechFingerprintEnrollParameter r4 = buildPhoneEnrollQueryHandleParam(r10);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L14
        Object r6 = Result.constructor-impl(Integer.valueOf(r1.createHandle(r4)));     // Catch: Throwable -> L14
    L16:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L19;
        LogUtils.e(TAG, "phone enroll query createHandle failed: " + r7.getMessage(), new Object[]{r7});
    L19:
        Integer r8 = Integer.valueOf(IWakeupSessionConstant.RC_ERROR);
        if (Result.isFailure-impl(r6) == false) goto L22;
        r6 = r8;
    L22:
        int r9 = ((Number) r6).intValue();
        StringBuilder r11 = new StringBuilder("phone enroll createHandle purpose=");
        PhoneEnrollHandlePurpose r12 = PhoneEnrollHandlePurpose.QUERY_EXISTENCE;
        r11.append(r12.getLogName());
        r11.append(" includeModel=");
        r11.append(r12.getIncludeModel());
        r11.append(" ret=");
        r11.append(r9);
        r11.append(" param=");
        r11.append(dumpParams(r4));
        LogUtils.i(TAG, r11.toString(), new Object[0]);
        if (r9 != 0) goto L34;
        phoneEnrollQueryService = r1;
        phoneEnrollQueryHandleKey = r10;
        return r1;
    L34:
        Object r13 = Result.constructor-impl(Integer.valueOf(r1.releaseHandle()));     // Catch: Throwable -> L26
    L28:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L31;
        LogUtils.e(TAG, "phone enroll query createHandle failed release failed: " + r14.getMessage(), new Object[0]);
    L31:
        return null;
    L26:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (Intrinsics.areEqual(phoneEnrollQueryHandleKey, r10) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        LogUtils.d(TAG, "reuse phone enroll query handle snLen=" + r10.getSn().length() + " dbPath=" + r10.getDbPath(), new Object[0]);
        return r0;
    }

    private final PhoneEnrollQueryStatus queryPhoneEnrolledWithService(SpeechFingerPrintEnrollService r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r8 = Result.constructor-impl(r7.getAudioFeatureOnline());     // Catch: Throwable -> L4
    L6:
        Throwable r1 = Result.exceptionOrNull-impl(r8);
        if (r1 == null) goto L10;
        LogUtils.e(TAG, "queryPhoneEnrolledFromLocalDb getAudioFeatureOnline failed: " + r1.getMessage(), new Object[0]);
    L10:
        if (Result.isFailure-impl(r8) == false) goto L12;
        r8 = null;
    L12:
        SpeechFingerprintResult r9 = (SpeechFingerprintResult) r8;
        if (r9 != null) goto L15;
        return null;
    L15:
        int r2 = r9.exist_primacy_data;
        byte[] r10 = r9.sid_feature;
        if (r10 == null) goto L18;
        int r11 = r10.length;
    L19:
        if (r2 == 0) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L24;
        PhoneEnrollQueryStatus r4 = PhoneEnrollQueryStatus.ENROLLED;
    L25:
        LogUtils.i(TAG, "queryPhoneEnrolledFromLocalDb status=" + r4 + " existPrimacyData=" + r2 + " sidFeatureSize=" + r11, new Object[0]);
        return r4;
    L24:
        r4 = PhoneEnrollQueryStatus.NOT_ENROLLED;
        goto L25
    L21:
        r3 = false;
        goto L22
    L18:
        r11 = 0;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private final void releasePhoneEnrollQueryHandleLocked(String r3) {
        SpeechFingerPrintEnrollService r0 = phoneEnrollQueryService;
        if (r0 != null) goto L5;
        return;
    L5:
        releasePhoneEnrollService(r0, PhoneEnrollHandlePurpose.QUERY_EXISTENCE, r3);
        phoneEnrollQueryService = null;
        phoneEnrollQueryHandleKey = null;
    }

    public final void releasePhoneEnrollHandle(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        Object r0 = phoneEnrollQueryHandleLock;
        monitor-enter(r0);
        INSTANCE.releasePhoneEnrollQueryHandleLocked(r3);     // Catch: Throwable -> L7
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final PhoneEnrollQueryHandleKey buildPhoneEnrollQueryHandleKey(Context r6, String r7) {
        SamiWakeupParamProvider r0 = SamiWakeupParamProvider.INSTANCE;
        WakeupParamSnapshot r8 = r0.ensurePhoneEnrollBaseSnapshot$libs_mainlandRelease(r6, r7);
        String r1 = r8.getSn();
        String r2 = r8.getUid();
        String r3 = r8.getDbPath();
        if (r3.length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L9;
        r3 = r0.buildVoiceprintDbPath$libs_mainlandRelease(r6);
    L9:
        return new PhoneEnrollQueryHandleKey(r1, r2, r3, r8.getAppId());
    L5:
        r4 = false;
        goto L6
    }

    private final String formatFieldValue(String r13, Object r14) {
        if (r14 != null) goto L5;
        return "null";
    L5:
        String r15 = r13.toLowerCase(Locale.ROOT);
        boolean r1 = false;
        if (StringsKt.contains$default(r15, "token", false, 2, null) == false) goto L8;
    L13:
        r1 = true;
    L15:
        if ((r14 instanceof String) == false) goto L23;
        if (Intrinsics.areEqual(r15, "uid") == true) goto L33;
        if (r1 == false) goto L35;
        return "REDACTED(len=" + ((String) r14).length() + ')';
    L35:
        return (String) r14;
    L33:
        return rna.b.l((String) r14);
    L23:
        if ((r14 instanceof int[]) == false) goto L26;
        return ArraysKt.joinToString$default((int[]) r14, null, "[", "]", 0, null, null, 57, null);
    L26:
        if ((r14 instanceof float[]) == false) goto L29;
        return "FloatArray(size=" + ((float[]) r14).length + ')';
    L29:
        if ((r14 instanceof byte[]) == false) goto L32;
        return "ByteArray(size=" + ((byte[]) r14).length + ')';
    L32:
        return r14.toString();
    L8:
        if (StringsKt.contains$default(r15, "header", false, 2, null) == true) goto L13;
        if (StringsKt.contains$default(r15, "enckeyinfo", false, 2, null) == true) goto L13;
        if (StringsKt.contains$default(r15, "key_info", false, 2, null) == false) goto L15;
        goto L13
    }

    private final void invalidatePhoneEnrollQueryHandleLocked(SpeechFingerPrintEnrollService r2, String r3) {
        if (phoneEnrollQueryService == r2) goto L5;
        return;
    L5:
        releasePhoneEnrollQueryHandleLocked(r3);
    }

    @JvmStatic
    public static final void triggerMigrationAsync(Context r2, final Function0<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uuidProvider");
        final Context r4 = r2.getApplicationContext();
        ThreadMethodProxy.start(new PthreadThreadV2(new b(r4, r3), "migrate-legacy-phone-enroll"));
    }

    private static final void triggerMigrationAsync$lambda$2(Context r6, Function0 r7) {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl((String) r7.invoke());     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L22
        if (r5 == null) goto L11;
        LogUtils.e(TAG, "triggerMigrationAsync get uuid failed: " + r5.getMessage(), new Object[0]);     // Catch: Throwable -> L22
    L11:
        if (Result.isFailure-impl(r8) == false) goto L13;
        r8 = "";
    L13:
        String r9 = (String) r8;     // Catch: Throwable -> L22
        if (r9.length() != 0) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L20;
        LogUtils.w(TAG, "triggerMigrationAsync skipped: uuid empty", new Object[0]);     // Catch: Throwable -> L22
        return;
    L20:
        SamiPhoneEnrollManager r3 = INSTANCE;     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L22
        LogUtils.i(TAG, "triggerMigrationAsync ret=" + r3.migrateLegacyPhoneEnrollIfNeeded(r6, r9), new Object[0]);     // Catch: Throwable -> L22
        return;
    L16:
        r2 = false;
        goto L17
    L22:
        th = move-exception;
        LogUtils.e(TAG, "triggerMigrationAsync failed: " + th.getMessage(), new Object[0]);
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L22
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
        goto L7
    }

    public final int migrateLegacyPhoneEnrollIfNeeded(Context r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        int r1 = 0;
        if (legacyMigrationCompleted == false) goto L5;
        return 0;
    L5:
        Object r0 = phoneEnrollMigrationLock;
        monitor-enter(r0);
    L47:
        th = move-exception;
        throw th;
    L8:
        if (legacyMigrationCompleted == true) goto L45;
        String r2 = SvaSdkGlobal.INSTANCE.getPATH_ENROLL_SID();     // Catch: Throwable -> L47
        if (StringsKt.isBlank(r2) == false) goto L13;
        LogUtils.i(TAG, "migrateLegacyPhoneEnrollIfNeeded skipped: legacyDir blank", new Object[0]);     // Catch: Throwable -> L47
        legacyMigrationCompleted = true;     // Catch: Throwable -> L47
        goto L45
    L13:
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);     // Catch: Throwable -> L47
        if (r3.isDirectory() == false) goto L34;
        File[] r4 = r3.listFiles();     // Catch: Throwable -> L47
        if (r4 == null) goto L31;
        int r5 = r4.length;     // Catch: Throwable -> L47
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L28;
        File r7 = r4[r6];     // Catch: Throwable -> L47
        if (r7.isFile() == true) goto L22;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == true) goto L26;
        r6 = r6 + 1;     // Catch: Throwable -> L47
        goto L18
    L26:
        boolean r9 = true;
    L29:
        if (r9 != true) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == false) goto L34;
        boolean r11 = true;
    L35:
        if (r11 == true) goto L37;
        LogUtils.i(TAG, "migrateLegacyPhoneEnrollIfNeeded skipped: legacy dir empty path=" + r2, new Object[0]);     // Catch: Throwable -> L47
        legacyMigrationCompleted = true;     // Catch: Throwable -> L47
        goto L45
    L37:
        SamiPhoneEnrollManager r12 = INSTANCE;     // Catch: Throwable -> L47
        if (r12.queryPhoneEnrollStatusFromLocalDb(r13.getApplicationContext(), r14) != PhoneEnrollQueryStatus.ENROLLED) goto L40;
        LogUtils.i(TAG, "migrateLegacyPhoneEnrollIfNeeded skipped: default voiceprint db exists path=" + r2, new Object[0]);     // Catch: Throwable -> L47
        legacyMigrationCompleted = true;     // Catch: Throwable -> L47
        goto L45
    L40:
        r12.releasePhoneEnrollHandle("before migrate legacy");     // Catch: Throwable -> L47
        int r15 = rna.b.m(r13.getApplicationContext());     // Catch: Throwable -> L47
        if (r15 != 0) goto L43;
        legacyMigrationCompleted = true;     // Catch: Throwable -> L47
    L43:
        LogUtils.i(TAG, "migrateLegacyPhoneEnrollIfNeeded host ret=" + r15 + " path=" + r2, new Object[0]);     // Catch: Throwable -> L47
        r1 = r15;
        goto L45
    L22:
        if (r7.length() <= 0) goto L24;
        r8 = true;
        goto L25
    L28:
        r9 = false;
    L31:
        r10 = false;
    L34:
        r11 = false;
    L45:
        monitor-exit(r0);
        return r1;
    }

    public final PhoneEnrollQueryStatus queryPhoneEnrollStatusFromLocalDb(Context r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Context r9 = r7.getApplicationContext();
        Intrinsics.checkNotNull(r9);
        PhoneEnrollQueryHandleKey r10 = buildPhoneEnrollQueryHandleKey(r9, r8);
        if (StringsKt.isBlank(r10.getSn()) == false) goto L5;
    L28:
        LogUtils.w(TAG, "queryPhoneEnrolledFromLocalDb skipped: snLen=" + r10.getSn().length() + " uid=" + rna.b.l(r10.getUid()) + " dbPathLen=" + r10.getDbPath().length(), new Object[0]);
        return PhoneEnrollQueryStatus.QUERY_FAILED;
    L5:
        if (StringsKt.isBlank(r10.getUid()) == true) goto L28;
        if (StringsKt.isBlank(r10.getDbPath()) == true) goto L28;
        Object r11 = phoneEnrollQueryHandleLock;
        monitor-enter(r11);
        SamiPhoneEnrollManager r2 = INSTANCE;     // Catch: Throwable -> L25
        SpeechFingerPrintEnrollService r3 = r2.getOrCreatePhoneEnrollQueryServiceLocked(r10);     // Catch: Throwable -> L25
        if (r3 != null) goto L14;
        PhoneEnrollQueryStatus r12 = PhoneEnrollQueryStatus.QUERY_FAILED;     // Catch: Throwable -> L25
    L23:
        monitor-exit(r11);
        return r12;
    L14:
        PhoneEnrollQueryStatus r4 = r2.queryPhoneEnrolledWithService(r3);     // Catch: Throwable -> L25
        if (r4 != null) goto L20;
        r2.invalidatePhoneEnrollQueryHandleLocked(r3, "query failed");     // Catch: Throwable -> L25
        SpeechFingerPrintEnrollService r5 = r2.getOrCreatePhoneEnrollQueryServiceLocked(r10);     // Catch: Throwable -> L25
        if (r5 != null) goto L19;
        r12 = PhoneEnrollQueryStatus.QUERY_FAILED;     // Catch: Throwable -> L25
        goto L23
    L19:
        LogUtils.i(TAG, "queryPhoneEnrolledFromLocalDb retry with recreated handle snLen=" + r10.getSn().length(), new Object[0]);     // Catch: Throwable -> L25
        r12 = r2.queryPhoneEnrolledWithService(r5);     // Catch: Throwable -> L25
    L21:
        if (r12 != null) goto L23;
        r12 = PhoneEnrollQueryStatus.QUERY_FAILED;     // Catch: Throwable -> L25
        goto L23
    L20:
        r12 = r4;
    L25:
        th = move-exception;
        throw th;
    }

    public final boolean queryPhoneEnrolledFromLocalDb(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (queryPhoneEnrollStatusFromLocalDb(r2, r3) != PhoneEnrollQueryStatus.ENROLLED) goto L5;
        return true;
    L5:
        return false;
    }

    private static final CharSequence dumpParams$lambda$23$lambda$22(SamiPhoneEnrollManager r2, Object r3, Field r4) {
        String r0 = r4.getName();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(r4.get(r3));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L10;
        r5 = null;
    L10:
        StringBuilder r6 = new StringBuilder();
        r6.append(r0);
        r6.append('=');
        Intrinsics.checkNotNull(r0);
        r6.append(r2.formatFieldValue(r0, r5));
        return r6.toString();
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    private final void releasePhoneEnrollService(SpeechFingerPrintEnrollService r6, PhoneEnrollHandlePurpose r7, String r8) {
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        LogUtils.i(TAG, "release phone enroll handle purpose=" + r7.getLogName() + " reason=" + r8 + " ret=" + r6.releaseHandle(), new Object[0]);     // Catch: Throwable -> L5
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L13;
        LogUtils.e(TAG, "release phone enroll handle failed purpose=" + r7.getLogName() + " reason=" + r8 + " error=" + r10.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final void setPublicField(Object r2, String r3, Object r4) {
        if (r4 != null) goto L12;
        return;
    L12:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        r2.getClass().getField(r3).set(r2, r4);     // Catch: Throwable -> L6
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L14;
        LogUtils.w(TAG, "setPublicField failed name=" + r3 + " error=" + r6.getMessage(), new Object[0]);
        return;
    L14:
        return;
    L6:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final int forceReEnrollWakeupSid(Context r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r7, "reason");
        Context r8 = r5.getApplicationContext();
        String r1 = rna.b.a;
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r7, "reason");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        Bundle r3 = new Bundle();     // Catch: Throwable -> L9
        r3.putString("reason", r7);     // Catch: Throwable -> L9
        Bundle r9 = r8.getContentResolver().call(l.a, "force-reenroll-wakeup-sid", null, r3);     // Catch: Throwable -> L9
        if (r9 == null) goto L6;
        int r10 = r9.getInt("ret", IWakeupSessionConstant.RC_ERROR);     // Catch: Throwable -> L9
    L7:
        Object r11 = Result.constructor-impl(Integer.valueOf(r10));     // Catch: Throwable -> L9
    L11:
        Throwable r0 = Result.exceptionOrNull-impl(r11);
        if (r0 == null) goto L14;
        r0.getMessage();
    L14:
        Integer r12 = Integer.valueOf(IWakeupSessionConstant.RC_ERROR);
        if (Result.isFailure-impl(r11) == false) goto L17;
        r11 = r12;
    L17:
        int r13 = ((Number) r11).intValue();
        if (r13 != 0) goto L20;
        LogUtils.i(TAG, "forceReEnrollWakeupSid host success reason=" + r7, new Object[0]);
    L21:
        return r13;
    L20:
        LogUtils.e(TAG, "forceReEnrollWakeupSid host failed reason=" + r7 + " ret=" + r13, new Object[0]);
        goto L21
    L6:
        r10 = IWakeupSessionConstant.RC_ERROR;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    private final void fillPhoneEnrollCommonHandleParam(SpeechFingerprintEnrollParameter r3, String r4, String r5, String r6, String r7) {
        setPublicField(r3, "url", SAMI_INTERNAL_URL);
        setPublicField(r3, "app_id", r7);
        setPublicField(r3, "token", "");
        setPublicField(r3, "tokenType", SAMICoreTokenType.TOKEN_TO_C_D);
        setPublicField(r3, "header", "");
        setPublicField(r3, "appkey", SvaSdkGlobal.APP_KEY);
        setPublicField(r3, "business", "Pacifical");
        setPublicField(r3, "uid", r5);
        r3.sn = r4;
        setPublicField(r3, "fw_engine_version", VOICEPRINT_ENGINE_VERSION);
        setPublicField(r3, "db_path", r6);
    }

    public static /* synthetic */ int migrateLegacyPhoneEnrollIfNeeded$default(SamiPhoneEnrollManager r0, Context r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.migrateLegacyPhoneEnrollIfNeeded(r1, r2);
    }

    public static /* synthetic */ PhoneEnrollQueryStatus queryPhoneEnrollStatusFromLocalDb$default(SamiPhoneEnrollManager r0, Context r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.queryPhoneEnrollStatusFromLocalDb(r1, r2);
    }

    public static /* synthetic */ boolean queryPhoneEnrolledFromLocalDb$default(SamiPhoneEnrollManager r0, Context r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.queryPhoneEnrolledFromLocalDb(r1, r2);
    }
}
