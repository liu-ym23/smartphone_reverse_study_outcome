package com.obric.aikernel.model_decrypt.impl.decrypt;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.modeldist.ModelDistConst;
import com.bytedance.crypto.modeldist.ModelInitResult;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.store.IStoreManager;
import com.obric.aikernel.middleware.api.store.StoreManager;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.model_decrypt.api.decrypt.IModelCert;
import com.obric.aikernel.model_decrypt.impl.util.String_extKt;
import com.obric.aikernel.utils.j;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;
import t7.a;
import u7.d;

/* JADX INFO: loaded from: classes2.dex */
public final class ModelCertImpl implements IModelCert {
    public static final ModelCertImpl INSTANCE = null;
    private static final String TAG = "ModelCertImpl";
    private static final a keyAliasStore = null;

    /* JADX INFO: renamed from: com.obric.aikernel.model_decrypt.impl.decrypt.ModelCertImpl$fetchAttestCertChain$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.decrypt.ModelCertImpl", f = "ModelCertImpl.kt", i = {0, 0}, l = {68}, m = "fetchAttestCertChain", n = {"startTime", "maxRepeatTime"}, s = {"J$0", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ModelCertImpl this$0;

        AnonymousClass1(ModelCertImpl r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.fetchAttestCertChain(this);
        }
    }

    static {
        INSTANCE = new ModelCertImpl();
        keyAliasStore = IStoreManager.a.a(StoreManager.INSTANCE, "AIKernel_all_decrypt_key_alias", 0, 2, null);
    }

    private ModelCertImpl() {
    }

    private final void addKeyAlias(String r10) {
        keyAliasStore.c(r10, true);
    }

    private final String createKeyAlias() {
        String r10 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r10, "randomUUID().toString()");
        return r10;
    }

    @JvmStatic
    public static final ModelCertImpl getInst() {
        return INSTANCE;
    }

    private final void removeKeyAlias(String r10) {
        keyAliasStore.f(new String[]{r10});
    }

    private final void reportDeleteKey(String r10, boolean r11, long r12, int r13, String r14) {
        JSONObject r15 = new JSONObject();
        r15.put("isSuccess", r11);
        r15.put("duration", r12);
        if (r11 == true) goto L5;
        r15.put("errorCode", r13);
        r15.put("errorMsg", r14);
        r15.put("hasNet", j.f5600a.a());
    L5:
        d.b("model_decrypt_delete_key", r15);
        if (r11 == true) goto L9;
        TrackerApi r16 = TrackerApi.INSTANCE;
        JSONObject r17 = new JSONObject();
        r17.put(WsConstants.KEY_CONNECTION_TYPE, "delete_key");
        r17.put("errorCode", r13);
        AppContext r18 = AppContext.INSTANCE;
        r17.put("isAdminMode", r18.isAdminMode());
        r17.put("isDebug", r18.isDebug());
        r17.put("channel", r18.getChannel());
        r17.put("hasNet", j.f5600a.a());
        Unit r19 = Unit.INSTANCE;
        JSONObject r110 = new JSONObject();
        r110.put("duration", r12);
        JSONObject r20 = new JSONObject();
        r20.put("keyAlias", r10);
        r20.put("errorMsg", r14);
        r16.monitorEvent("model_decrypt_error", r17, r110, r20);
        return;
    }

    static /* synthetic */ void reportDeleteKey$default(ModelCertImpl r10, String r11, boolean r12, long r13, int r14, String r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        r15 = null;
    L5:
        r10.reportDeleteKey(r11, r12, r13, r14, r15);
    }

    private final void reportFetchCertChain(boolean r10, long r11, int r12, String r13, int r14) {
        JSONObject r15 = new JSONObject();
        r15.put("isSuccess", r10);
        r15.put("duration", r11);
        r15.put("exeCount", r14);
        if (r10 == true) goto L5;
        r15.put("errorCode", r12);
        r15.put("errorMsg", r13);
        r15.put("hasNet", j.f5600a.a());
        r15.put("FINGERPRINT", Build.FINGERPRINT);
    L5:
        d.b("model_decrypt_fetch_cert", r15);
        if (r10 == true) goto L9;
        TrackerApi r16 = TrackerApi.INSTANCE;
        JSONObject r17 = new JSONObject();
        r17.put(WsConstants.KEY_CONNECTION_TYPE, "fetch_cert");
        r17.put("errorCode", r12);
        AppContext r18 = AppContext.INSTANCE;
        r17.put("isAdminMode", r18.isAdminMode());
        r17.put("isDebug", r18.isDebug());
        r17.put("channel", r18.getChannel());
        r17.put("hasNet", j.f5600a.a());
        r17.put("FINGERPRINT", Build.FINGERPRINT);
        Unit r19 = Unit.INSTANCE;
        JSONObject r110 = new JSONObject();
        r110.put("duration", r11);
        JSONObject r111 = new JSONObject();
        r111.put("errorMsg", r13);
        r111.put("exeCount", r14);
        r16.monitorEvent("model_decrypt_error", r17, r110, r111);
        return;
    }

    static /* synthetic */ void reportFetchCertChain$default(ModelCertImpl r10, boolean r11, long r12, int r13, String r14, int r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        r10.reportFetchCertChain(r11, r12, r13, r14, r15);
    }

    private final void reportReEncryptFEK(String r10, boolean r11, boolean r12, long r13, int r14, String r15) {
        JSONObject r16 = new JSONObject();
        r16.put("isSuccess", r12);
        r16.put("duration", r13);
        r16.put("isPreset", r11);
        r16.put("tag", String_extKt.shortFilePath(r10));
        if (r12 == true) goto L5;
        r16.put("errorCode", r14);
        r16.put("errorMsg", r15);
        r16.put("hasNet", j.f5600a.a());
    L5:
        d.b("model_decrypt_reEncryptFEK", r16);
        if (r12 == true) goto L9;
        TrackerApi r17 = TrackerApi.INSTANCE;
        JSONObject r18 = new JSONObject();
        r18.put(WsConstants.KEY_CONNECTION_TYPE, "reEncryptFEK");
        r18.put("errorCode", r14);
        AppContext r19 = AppContext.INSTANCE;
        r18.put("isAdminMode", r19.isAdminMode());
        r18.put("isDebug", r19.isDebug());
        r18.put("channel", r19.getChannel());
        r18.put("hasNet", j.f5600a.a());
        r18.put("isPreset", r11);
        Unit r110 = Unit.INSTANCE;
        JSONObject r111 = new JSONObject();
        r111.put("duration", r13);
        JSONObject r112 = new JSONObject();
        r112.put("errorMsg", r15);
        r112.put("tag", r10);
        r17.monitorEvent("model_decrypt_error", r18, r111, r112);
        return;
    }

    static /* synthetic */ void reportReEncryptFEK$default(ModelCertImpl r10, String r11, boolean r12, boolean r13, long r14, int r15, String r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L5;
        String r19 = null;
    L6:
        r10.reportReEncryptFEK(r11, r12, r13, r14, r15, r19);
        return;
    L5:
        r19 = r16;
        goto L6
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelCert
    public String[] allKeyAlias() {
        return keyAliasStore.e();
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelCert
    public boolean deleteAttestKey(String r14) {
        Intrinsics.checkNotNullParameter(r14, "keyAlias");
        AIKLog.INSTANCE.d(TAG, "deleteAttestKey: keyAlias = " + r14);
        long r10 = SystemClock.elapsedRealtime();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(Integer.valueOf(DecryptSdkWrapper.INSTANCE.deleteAttestKey(AppContext.INSTANCE.getContext(), r14)));     // Catch: Throwable -> L5
    L8:
        if (Result.m39isSuccessimpl(r12) == false) goto L14;
        int r13 = ((Number) r12).intValue();
        AIKLog.INSTANCE.w(TAG, "deleteAttestKey keyAlias = " + r14 + ", ret = " + r13);
        ModelCertImpl r15 = INSTANCE;
        r15.removeKeyAlias(r14);
        if (r13 != 0) goto L12;
        boolean r16 = true;
    L13:
        r15.reportDeleteKey(r14, r16, SystemClock.elapsedRealtime() - r10, r13, null);
        goto L14
    L12:
        r16 = false;
    L14:
        Throwable r17 = Result.m35exceptionOrNullimpl(r12);
        if (r17 == null) goto L21;
        AIKLog.INSTANCE.w(TAG, "deleteAttestKey failed: " + r17.getMessage() + ", keyAlias = " + r14, r17);
        ModelCertImpl r18 = INSTANCE;
        long r19 = SystemClock.elapsedRealtime() - r10;
        String r20 = r17.getMessage();
        if (r20 != null) goto L19;
        r20 = "";
    L19:
        r18.reportDeleteKey(r14, false, r19, -1000, r20);
    L21:
        if (Result.m38isFailureimpl(r12) == false) goto L24;
        r12 = -1000;
    L24:
        if (((Number) r12).intValue() != 0) goto L27;
        return true;
    L27:
        return false;
    L5:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0139 -> B:50:0x013c). Please report as a decompilation issue!!! */
    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelCert
    public Object fetchAttestCertChain(Continuation<? super Pair<String, String>> r21) {
        if ((r21 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r21;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        int r15 = r10.I$1;
        int r16 = r10.I$0;
        long r17 = r10.J$0;
        ResultKt.throwOnFailure(r12);
    L50:
        r15 = r15 + 1;
    L16:
        if (r15 >= r16) goto L80;
        int r18 = r15 + 1;
        String r19 = INSTANCE.createKeyAlias();
        AIKLog.INSTANCE.d(TAG, "keyAlias = " + r19 + ", exeCount = " + r18);
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L20
        DecryptSdkWrapper r22 = DecryptSdkWrapper.INSTANCE;     // Catch: Throwable -> L20
        Context r110 = AppContext.INSTANCE.getContext();     // Catch: Throwable -> L20
        Bundle r111 = new Bundle();     // Catch: Throwable -> L20
        r111.putInt(ModelDistConst.KEY_ATTEST_STRATEGY, 2);     // Catch: Throwable -> L20
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L20
        Object r24 = Result.m32constructorimpl(r22.initModelRequest(r110, r19, r111));     // Catch: Throwable -> L20
    L23:
        if (Result.m39isSuccessimpl(r24) == false) goto L29;
        ModelInitResult r25 = (ModelInitResult) r24;
        ModelCertImpl r112 = INSTANCE;
        if (r25.getErrorCode() != 0) goto L27;
        boolean r113 = true;
    L28:
        int r26 = r18;
        r112.reportFetchCertChain(r113, SystemClock.elapsedRealtime() - r17, r25.getErrorCode(), "", r26);
    L30:
        Throwable r27 = Result.m35exceptionOrNullimpl(r24);
        if (r27 == null) goto L37;
        AIKLog.INSTANCE.w(TAG, "fetchAttestCertChain failed: " + r27.getMessage(), r27);
        ModelCertImpl r114 = INSTANCE;
        long r115 = SystemClock.elapsedRealtime() - r17;
        String r28 = r27.getMessage();
        if (r28 != null) goto L35;
        String r116 = "";
    L36:
        r114.reportFetchCertChain(false, r115, -1000, r116, r26);
        goto L37
    L35:
        r116 = r28;
    L37:
        String r117 = null;
        if (Result.m38isFailureimpl(r24) == false) goto L40;
        r24 = null;
    L40:
        ModelInitResult r29 = (ModelInitResult) r24;
        if (r29 != null) goto L43;
    L45:
        boolean r30 = false;
    L46:
        if (r30 == false) goto L51;
        AIKLog.INSTANCE.w(TAG, "keyAlias already exist, retry");
        r10.J$0 = r17;
        r10.I$0 = r16;
        r10.I$1 = r15;
        r10.label = 1;
        if (DelayKt.b(100, r10) != r13) goto L50;
        return r13;
    L51:
        if (r29 == null) goto L53;
        String r31 = r29.getAttestCertChain();
    L54:
        if (r31 != null) goto L56;
        r31 = "";
    L56:
        if (r29 != null) goto L58;
    L60:
        boolean r32 = false;
    L61:
        if (r32 == true) goto L63;
    L69:
        AIKLog r33 = AIKLog.INSTANCE;
        StringBuilder r34 = new StringBuilder();
        r34.append("fetchAttestCertChain failed, exeCount = ");
        r34.append(r26);
        r34.append(", errorCode = ");
        if (r29 == null) goto L72;
        Integer r35 = Boxing.boxInt(r29.getErrorCode());
    L73:
        r34.append(r35);
        r34.append(", attestCertChain = ");
        if (r29 == null) goto L76;
        r117 = r29.getAttestCertChain();
    L76:
        if (r117 != null) goto L78;
        r117 = "";
    L78:
        r34.append(r117);
        r33.w(TAG, r34.toString());
        return TuplesKt.to("", "");
    L72:
        r35 = null;
        goto L73
    L63:
        if (r31.length() <= 0) goto L65;
        boolean r36 = true;
    L66:
        if (r36 == false) goto L69;
        AIKLog.INSTANCE.d(TAG, "fetchAttestCertChain: success. keyAlias = " + r19);
        INSTANCE.addKeyAlias(r19);
        return TuplesKt.to(r19, r31);
    L65:
        r36 = false;
        goto L66
    L58:
        if (r29.getErrorCode() != 0) goto L60;
        r32 = true;
        goto L61
    L53:
        r31 = null;
        goto L54
    L43:
        if (r29.getErrorCode() != (-13)) goto L45;
        r30 = true;
        goto L46
    L27:
        r113 = false;
        goto L28
    L29:
        r26 = r18;
    L20:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r24 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L23
    L80:
        AIKLog.INSTANCE.w(TAG, "fetchAttestCertChain failed");
        return TuplesKt.to("", "");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r17 = SystemClock.elapsedRealtime();
        r15 = 0;
        r16 = 5;
    L7:
        r10 = new AnonymousClass1(this, r21);
        goto L8
    }

    @Override // com.obric.aikernel.model_decrypt.api.decrypt.IModelCert
    public String reEncryptFEK(String r17, String r18, String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r17, "tag");
        Intrinsics.checkNotNullParameter(r18, "keyAlias");
        Intrinsics.checkNotNullParameter(r19, "keyInfo");
        long r12 = SystemClock.elapsedRealtime();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L9
        Object r11 = Result.m32constructorimpl(DecryptSdkWrapper.INSTANCE.reEncryptFEK(AppContext.INSTANCE.getContext(), r18, r19, r20));     // Catch: Throwable -> L7
    L13:
        if (Result.m39isSuccessimpl(r11) == true) goto L15;
    L19:
        Throwable r13 = Result.m35exceptionOrNullimpl(r11);
        if (r13 == null) goto L27;
        AIKLog.INSTANCE.w(TAG, "reEncryptFEK failed: " + r13.getMessage(), r13);
        ModelCertImpl r14 = INSTANCE;
        long r15 = SystemClock.elapsedRealtime() - r12;
        String r16 = r13.getMessage();
        if (r16 != null) goto L24;
        String r110 = "";
    L25:
        r14.reportReEncryptFEK(r17, r20, false, r15, -1000, r110);
        goto L27
    L24:
        r110 = r16;
    L27:
        if (Result.m38isFailureimpl(r11) == false) goto L30;
        r11 = "";
    L30:
        return (String) r11;
    L15:
        if (((String) r11).length() <= 0) goto L17;
        boolean r21 = true;
    L18:
        boolean r22 = r21;
        AIKLog.INSTANCE.d(TAG, "reEncryptFEK success. isSuccess = " + r22);
        INSTANCE.reportReEncryptFEK(r17, r20, r22, SystemClock.elapsedRealtime() - r12, -1000, "empty result");
        goto L19
    L17:
        r21 = false;
    L7:
        th = th;
    L11:
        Result.Companion r23 = Result.Companion;
        r11 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L9:
        th = th;
        goto L11
    }
}
