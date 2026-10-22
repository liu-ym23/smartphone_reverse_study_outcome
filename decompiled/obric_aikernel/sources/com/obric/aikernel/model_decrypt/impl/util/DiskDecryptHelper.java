package com.obric.aikernel.model_decrypt.impl.util;

import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecrypt;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelDecryptKt;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManager;
import com.obric.aikernel.model_decrypt.api.filemeta.IModelFileMetaDataManagerKt;
import com.obric.aikernel.model_decrypt.api.filemeta.ModelFileMetaData;
import com.obric.aikernel.utils.a;
import com.obric.aikernel.utils.e;
import com.obric.aikernel.utils.j;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.p1;
import kotlinx.coroutines.flow.q1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import org.json.JSONObject;
import u7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class DiskDecryptHelper {
    public static final DiskDecryptHelper INSTANCE = null;
    private static final String TAG = "DiskDecryptHelper";
    private static final Map<String, g1<Boolean>> activeDecryptTask = null;

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper$checkAndDecryptFile$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper", f = "DiskDecryptHelper.kt", i = {0, 0, 0, 0}, l = {109}, m = "checkAndDecryptFile", n = {"encryptFile", "metadata", "startTime", "fileSizeKB"}, s = {"L$0", "L$1", "J$0", "J$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DiskDecryptHelper this$0;

        AnonymousClass1(DiskDecryptHelper r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return DiskDecryptHelper.access$checkAndDecryptFile(this.this$0, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper$decryptFile$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper", f = "DiskDecryptHelper.kt", i = {0, 0}, l = {34}, m = "decryptFile", n = {"encryptFile", "decryptFile"}, s = {"L$0", "L$1"})
    static final class C03651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DiskDecryptHelper this$0;

        C03651(DiskDecryptHelper r10, Continuation<? super C03651> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.decryptFile(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper$decryptFile$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper$decryptFile$2", f = "DiskDecryptHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r10) {
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(r11);
            r12.L$0 = r10;
            return r12;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Boolean r10, Continuation<? super Boolean> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean r10, Continuation<? super Boolean> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r10);
            if (((Boolean) this.L$0) == null) goto L7;
            boolean r11 = true;
        L9:
            return Boxing.boxBoolean(r11);
        L7:
            r11 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper$doDecryptFile$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.util.DiskDecryptHelper", f = "DiskDecryptHelper.kt", i = {0, 0, 0, 0}, l = {159}, m = "doDecryptFile", n = {"encryptFile", "decryptFile", "metaFile", "metadata"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C03661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DiskDecryptHelper this$0;

        C03661(DiskDecryptHelper r10, Continuation<? super C03661> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return DiskDecryptHelper.access$doDecryptFile(this.this$0, null, null, null, this);
        }
    }

    static {
        INSTANCE = new DiskDecryptHelper();
        activeDecryptTask = new LinkedHashMap();
    }

    private DiskDecryptHelper() {
    }

    public static final /* synthetic */ Object access$checkAndDecryptFile(DiskDecryptHelper r10, File r11, File r12, File r13, Continuation r14) {
        return r10.checkAndDecryptFile(r11, r12, r13, r14);
    }

    public static final /* synthetic */ Object access$doDecryptFile(DiskDecryptHelper r10, File r11, File r12, File r13, Continuation r14) {
        return r10.doDecryptFile(r11, r12, r13, r14);
    }

    public static final /* synthetic */ void access$notifyDecryptTaskFinish(DiskDecryptHelper r10, String r11, boolean r12) {
        r10.notifyDecryptTaskFinish(r11, r12);
    }

    private final Object checkAndDecryptFile(File r24, File r25, File r26, Continuation<? super Boolean> r27) {
        File r10 = r24;
        if ((r27 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r11 = (AnonymousClass1) r27;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L18;
        if (r15 != 1) goto L17;
        long r16 = r11.J$1;
        long r17 = r11.J$0;
        ModelFileMetaData r18 = (ModelFileMetaData) r11.L$1;
        File r19 = (File) r11.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L14
        ModelFileMetaData r20 = r18;
        r10 = r19;
    L58:
        Object r21 = Result.m32constructorimpl((Pair) r13);     // Catch: Throwable -> L36
    L42:
        if (Result.m39isSuccessimpl(r21) == false) goto L44;
        Pair r22 = (Pair) r21;
        reportDecryptFile$default(INSTANCE, r20.getModelName(), r10, ((Boolean) r22.getFirst()).booleanValue(), SystemClock.elapsedRealtime() - r17, (String) r22.getSecond(), r16, false, r20.isPreset(), 64, null);
    L44:
        Throwable r23 = Result.m35exceptionOrNullimpl(r21);
        if (r23 == null) goto L51;
        AIKLog.INSTANCE.w(TAG, "checkAndDecryptFile failed: " + r23.getMessage(), r23);
        DiskDecryptHelper r110 = INSTANCE;
        String r111 = r20.getModelName();
        long r112 = SystemClock.elapsedRealtime() - r17;
        String r28 = r23.getMessage();
        if (r28 != null) goto L49;
        String r113 = "";
    L50:
        reportDecryptFile$default(r110, r111, r10, false, r112, r113, r16, false, r20.isPreset(), 64, null);
        goto L51
    L49:
        r113 = r28;
    L51:
        Pair r29 = TuplesKt.to(Boxing.boxBoolean(false), "");
        if (Result.m38isFailureimpl(r21) == false) goto L55;
        r21 = r29;
    L55:
        return ((Pair) r21).getFirst();
    L36:
        th = th;
    L40:
        Result.Companion r30 = Result.Companion;
        r21 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L14:
        th = th;
        r20 = r18;
        r10 = r19;
        goto L40
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r13);
        AIKLog.INSTANCE.d(TAG, "checkAndDecryptFile: encryptFile = " + r10 + ", decryptFile = " + r25);
        long r114 = SystemClock.elapsedRealtime();
        Result.Companion r31 = Result.Companion;     // Catch: Throwable -> L21
        Object r32 = Result.m32constructorimpl(Boxing.boxLong(r24.length() / ((long) 1024)));     // Catch: Throwable -> L21
    L23:
        Long r33 = Boxing.boxLong(-1);
        if (Result.m38isFailureimpl(r32) == false) goto L26;
        r32 = r33;
    L26:
        long r115 = ((Number) r32).longValue();
        r20 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r26);
        if (r20 != null) goto L62;
        AIKLog.INSTANCE.w(TAG, "metadata is null, return false");
        reportDecryptFile$default(this, "", r24, false, SystemClock.elapsedRealtime() - r114, "metadata is null", r115, false, false, 192, null);
        return Boxing.boxBoolean(false);
    L62:
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L38
        DiskDecryptHelper r35 = INSTANCE;     // Catch: Throwable -> L38
        r11.L$0 = r10;     // Catch: Throwable -> L38
        r11.L$1 = r20;     // Catch: Throwable -> L38
        r11.J$0 = r114;     // Catch: Throwable -> L38
        r11.J$1 = r115;     // Catch: Throwable -> L38
        r11.label = 1;     // Catch: Throwable -> L38
        r13 = r35.doDecryptFile(r10, r25, r26, r11);     // Catch: Throwable -> L38
        if (r13 != r14) goto L33;
        return r14;
    L33:
        r17 = r114;
        r16 = r115;
    L38:
        th = th;
        r17 = r114;
        r16 = r115;
    L21:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r32 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r11 = new AnonymousClass1(this, r27);
        goto L8
    }

    private final Object doDecryptFile(File r30, File r31, File r32, Continuation<? super Pair<Boolean, String>> r33) {
        File r10 = r30;
        File r11 = r31;
        File r12 = r32;
        if ((r33 instanceof C03661) == false) goto L7;
        C03661 r13 = (C03661) r33;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ModelFileMetaData r18 = (ModelFileMetaData) r13.L$3;
        File r19 = (File) r13.L$2;
        File r20 = (File) r13.L$1;
        File r21 = (File) r13.L$0;
        ResultKt.throwOnFailure(r15);
        ModelFileMetaData r110 = r18;
        r10 = r21;
        r12 = r19;
        r11 = r20;
    L39:
        ModelFileMetaData r22 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r12);
        if (r22 == null) goto L42;
        ModelFileMetaData r23 = ModelFileMetaData.copy$default(r110, null, null, null, false, 0, false, false, null, null, r22.getDecryptKeyInfo(), r22.getDecryptKeyAlias(), null, false, false, 14847, null);
    L44:
        if (r23.getDecryptKeyAlias().length() != 0) goto L46;
        boolean r24 = true;
    L47:
        if (r24 == false) goto L50;
        Boolean r25 = Boxing.boxBoolean(false);
        String r26 = "no keyAlias";
    L18:
        return TuplesKt.to(r25, r26);
    L50:
        if (r23.getDecryptKeyInfo().length() != 0) goto L52;
        boolean r27 = true;
    L53:
        if (r27 == false) goto L55;
        r25 = Boxing.boxBoolean(false);
        r26 = "no keyAlias no keyInfo";
    L55:
        IModelDecrypt r28 = IModelDecryptKt.getModelDecrypt();
        String r29 = r10.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r29, "encryptFile.absolutePath");
        if (r28.checkModelIntegrity(r29) == false) goto L103;
        IModelFileMetaDataManager.DefaultImpls.update$default(IModelFileMetaDataManagerKt.getModelFileMetaDataManager(), r12, false, C03672.INSTANCE, 2, null);
        AIKLog r34 = AIKLog.INSTANCE;
        if (r34.isDebug() == false) goto L60;
        r34.d(TAG, "doDecryptFile: key_info " + r23.getDecryptKeyAlias() + ',' + r23.getDecryptKeyInfo() + " for " + r11.getName() + ' ');
    L60:
        File r35 = new File(r11.getParent(), r11.getName() + ".__de__");
        IModelDecrypt r36 = IModelDecryptKt.getModelDecrypt();
        String r37 = r10.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r37, "encryptFile.absolutePath");
        String r38 = r35.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r38, "tempDecryptFile.absolutePath");
        boolean r39 = r36.decryptModelFileByKeyInfo(r37, r38, r23.getDecryptKeyAlias(), r23.getDecryptKeyInfo());
        if (r39 == true) goto L108;
        IModelFileMetaDataManager.DefaultImpls.update$default(IModelFileMetaDataManagerKt.getModelFileMetaDataManager(), r12, false, AnonymousClass5.INSTANCE, 2, null);
    L104:
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L95
        if (r35.exists() == false) goto L93;
        r35.delete();     // Catch: Throwable -> L95
    L93:
        Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L95
    L97:
        AIKLog.INSTANCE.d(TAG, "decryptModelFile isSucceed = " + r39);
        if (r39 == false) goto L100;
        IModelFileMetaDataManager.DefaultImpls.update$default(IModelFileMetaDataManagerKt.getModelFileMetaDataManager(), r12, false, AnonymousClass7.INSTANCE, 2, null);
        Boolean r41 = Boxing.boxBoolean(true);
        String r42 = "";
    L102:
        return TuplesKt.to(r41, r42);
    L100:
        r41 = Boxing.boxBoolean(false);
        r42 = "decrypt failed";
    L95:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L97
    L108:
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L71
        if (r11.exists() == true) goto L65;
    L68:
        boolean r45 = true;
    L69:
        Object r46 = Result.m32constructorimpl(Boxing.boxBoolean(r45));     // Catch: Throwable -> L71
    L73:
        Boolean r47 = Boxing.boxBoolean(false);
        if (Result.m38isFailureimpl(r46) == false) goto L77;
        r46 = r47;
    L77:
        if (((Boolean) r46).booleanValue() == true) goto L106;
        AIKLog.INSTANCE.w(TAG, "delete decryptFile failed: " + r11 + ", exists = " + e.b(r11));
    L106:
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L81
        Object r49 = Result.m32constructorimpl(Boxing.boxBoolean(r35.renameTo(r11)));     // Catch: Throwable -> L81
    L83:
        Boolean r50 = Boxing.boxBoolean(false);
        if (Result.m38isFailureimpl(r49) == false) goto L87;
        r49 = r50;
    L87:
        if (((Boolean) r49).booleanValue() == true) goto L104;
        AIKLog.INSTANCE.w(TAG, "rename tempDecryptFile failed: " + r35 + ", to = " + r11);
        r39 = false;
    L81:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r49 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L83
    L65:
        if (r11.delete() == true) goto L68;
        r45 = false;
    L71:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r46 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L73
    L103:
        r26 = "checkModelIntegrity failed";
        AIKLog.INSTANCE.w(TAG, "checkModelIntegrity failed");
        r25 = Boxing.boxBoolean(false);
        goto L18
    L52:
        r27 = false;
        goto L53
    L46:
        r24 = false;
        goto L47
    L42:
        r23 = r110;
        goto L44
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        AIKLog r53 = AIKLog.INSTANCE;
        r53.d(TAG, "doDecryptFile: encryptFile = " + r10 + ", decryptFile = " + r11);
        r23 = IModelFileMetaDataManagerKt.getModelFileMetaDataManager().get(r12);
        if (r23 != null) goto L19;
        r53.w(TAG, "metadata is null, return false");
        r25 = Boxing.boxBoolean(false);
        r26 = "metadata is null";
        goto L18
    L19:
        r53.d(TAG, "metadata = " + r23);
        if (r23.isEncryptResource() == true) goto L23;
        r53.d(TAG, "is not encrypt resource, return true");
        r25 = Boxing.boxBoolean(false);
        r26 = "is not encrypt resource";
        goto L18
    L23:
        if (r23.isDecrypted() == false) goto L26;
        r53.w(TAG, "is already decrypt");
    L26:
        if (r23.getDecryptKeyAlias().length() != 0) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == false) goto L31;
    L35:
        r53.d(TAG, "lack decrypt keyAlias or keyInfo, will request server for them");
        KeyInfoRequestHelper r54 = KeyInfoRequestHelper.INSTANCE;
        List<String> r112 = CollectionsKt.listOf(r23.getModelName());
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.L$2 = r12;
        r13.L$3 = r23;
        r13.label = 1;
        if (r54.requestKeyInfo(r112, r13) != r16) goto L38;
        return r16;
    L38:
        r110 = r23;
        goto L39
    L31:
        if (r23.getDecryptKeyInfo().length() != 0) goto L33;
        boolean r113 = true;
    L34:
        if (r113 == false) goto L55;
    L33:
        r113 = false;
        goto L34
    L28:
        r111 = false;
    L7:
        r13 = new C03661(this, r33);
        goto L8
    }

    private final void notifyDecryptTaskFinish(String r10, boolean r11) {
        Map<String, g1<Boolean>> r12 = activeDecryptTask;
        monitor-enter(r12);
        g1<Boolean> r13 = r12.remove(r10);     // Catch: Throwable -> L11
        if (r13 == null) goto L7;
        r13.setValue(Boolean.valueOf(r11));     // Catch: Throwable -> L11
    L8:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r12);
        return;
    L7:
        AIKLog.INSTANCE.w(TAG, "notifyDecryptTaskFinish: task not found, taskId = " + r10);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private final void reportDecryptFile(String r18, File r19, boolean r20, long r21, String r23, long r24, boolean r26, boolean r27) {
        JSONObject r10 = new JSONObject();
        r10.put("modelName", r18);
        r10.put("encryptFile", r19.getName());
        r10.put("isSuccess", r20);
        r10.put("duration", r21);
        r10.put("fileSizeKB", r24);
        r10.put("extractToMemory", r26);
        r10.put("isPreset", r27);
        if (r20 == true) goto L5;
        r10.put("errorMsg", r23);
        r10.put("hasNet", j.f5600a.a());
    L5:
        d.b("model_decrypt_process", r10);
        if (r20 == true) goto L9;
        TrackerApi r11 = TrackerApi.INSTANCE;
        JSONObject r12 = new JSONObject();
        r12.put(WsConstants.KEY_CONNECTION_TYPE, "process");
        AppContext r13 = AppContext.INSTANCE;
        r12.put("isAdminMode", r13.isAdminMode());
        r12.put("isDebug", r13.isDebug());
        r12.put("channel", r13.getChannel());
        r12.put("hasNet", j.f5600a.a());
        r12.put("extractToMemory", r26);
        r12.put("isPreset", r27);
        Unit r14 = Unit.INSTANCE;
        JSONObject r15 = new JSONObject();
        r15.put("duration", r21);
        r15.put("fileSizeKB", r24);
        JSONObject r16 = new JSONObject();
        r16.put("encryptFile", r19.getName());
        r16.put("errorMsg", r23);
        r16.put("modelName", r18);
        r11.monitorEvent("model_decrypt_error", r12, r15, r16);
        return;
    }

    static /* synthetic */ void reportDecryptFile$default(DiskDecryptHelper r14, String r15, File r16, boolean r17, long r18, String r20, long r21, boolean r23, boolean r24, int r25, Object r26) {
        if ((r25 & 64) == 0) goto L5;
        boolean r12 = false;
    L7:
        if ((r25 & 128) == 0) goto L9;
        boolean r13 = false;
    L10:
        r14.reportDecryptFile(r15, r16, r17, r18, r20, r21, r12, r13);
        return;
    L9:
        r13 = r24;
        goto L10
    L5:
        r12 = r23;
        goto L7
    }

    private final p1<Boolean> startOrReturnExistingDecryptTask(File r16, File r17, File r18) {
        final String r10 = r18.getAbsolutePath();
        Map<String, g1<Boolean>> r11 = activeDecryptTask;
        monitor-enter(r11);
        g1<Boolean> r12 = r11.get(r10);     // Catch: Throwable -> L13
        if (r12 == null) goto L10;
        AIKLog.INSTANCE.d(TAG, "startOrReturnExistingDecryptTask: task already exist, taskId = " + r10);     // Catch: Throwable -> L13
        monitor-exit(r11);
        return r12;
    L10:
        g1<Boolean> r13 = q1.a(null);     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r10, "taskId");     // Catch: Throwable -> L13
        r11.put(r10, r13);     // Catch: Throwable -> L13
        h.d(m0.a(z0.b()), null, null, new DiskDecryptHelper$startOrReturnExistingDecryptTask$1$1(r16, r17, r18, r10, null), 3, null).A(new DiskDecryptHelper$startOrReturnExistingDecryptTask$1$2(r10));     // Catch: Throwable -> L13
        monitor-exit(r11);
        return r13;
    L13:
        th = move-exception;
        throw th;
    }

    public final Object decryptFile(File r10, File r11, File r12, Continuation<? super Boolean> r13) {
        if ((r13 instanceof C03651) == false) goto L7;
        C03651 r14 = (C03651) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        r11 = (File) r14.L$1;
        r10 = (File) r14.L$0;
        ResultKt.throwOnFailure(r16);
    L17:
        Boolean r19 = (Boolean) r16;
        AIKLog.INSTANCE.d(TAG, "decryptFile finished: encryptFile = " + r10 + ", decryptFile = " + r11 + ", isSuccess = " + r19);
        return Boxing.boxBoolean(a.b(r19));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        AIKLog.INSTANCE.d(TAG, "decryptFile start encryptFile = " + r10 + ", decryptFile = " + r11 + ", metaFile = " + r12);
        p1<Boolean> r20 = startOrReturnExistingDecryptTask(r10, r11, r12);
        AnonymousClass2 r110 = new AnonymousClass2(null);
        r14.L$0 = r10;
        r14.L$1 = r11;
        r14.label = 1;
        r16 = kotlinx.coroutines.flow.e.q(r20, r110, r14);
        if (r16 != r17) goto L17;
        return r17;
    L7:
        r14 = new C03651(this, r13);
        goto L8
    }
}
