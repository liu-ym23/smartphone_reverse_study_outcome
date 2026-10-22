package com.obric.aikernel.model_decrypt.impl.decrypt;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.modeldist.ModelInitResult;
import com.bytedance.crypto.platform.ExternalPlatKeyManager;
import com.obric.aikernel.api.b;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.middleware.api.traker.TrackerApi;
import com.obric.aikernel.utils.j;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class DecryptSdkWrapper {
    public static final DecryptSdkWrapper INSTANCE = null;
    private static final String TAG = "DecryptSdkWrapper";
    private static boolean isInited;
    private static final boolean isObricType = false;
    private static final l0 myCoroutineScope = null;

    static {
        DecryptSdkWrapper r10 = new DecryptSdkWrapper();
        INSTANCE = r10;
        isObricType = b.f4431a.e().a();
        myCoroutineScope = m0.a(z0.b());
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        r10.initPresetPlatKeyInfo(AppContext.INSTANCE.getContext(), r10.getPlatKey());     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m39isSuccessimpl(r12) == false) goto L10;
        Unit r13 = (Unit) r12;
        isInited = true;
        AIKLog.INSTANCE.d(TAG, "init success");
    L10:
        Throwable r14 = Result.m35exceptionOrNullimpl(r12);
        if (r14 == null) goto L16;
        AIKLog.INSTANCE.w(TAG, "init failed: " + r14.getMessage(), r14);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private DecryptSdkWrapper() {
    }

    public static final /* synthetic */ void access$reportSdkTimeout(DecryptSdkWrapper r10, String r11, long r12) {
        r10.reportSdkTimeout(r11, r12);
    }

    private final String getPlatKey() {
        return "{\"dataKeyCipher\":\"E6sTqwEMqRrRtloJIXg_eFXCpt6e73rWV7_8w3B_WpItlAhdF8jQKtdNg7T2sQTwDUHn7wUTdqAS07QmgeEx2715\",\"ephemeralPubKey\":\"\",\"platformBusinessPubKey\":\"-----BEGIN PUBLIC KEY-----\\nMFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAETHTwxvjNk35d1lOJqcnKBkmJHnhk\\nrVEMRW7GPZ295pvuPiv90WFh2u3dF2jHPrCJ4jBbqcpFdc3+1DqS7RBeKw==\\n-----END PUBLIC KEY-----\\n\"}";
    }

    private final <R> R monitorTimeout(String r10, Function0<? extends R> r11) {
        v1 r12 = h.d(myCoroutineScope, null, null, new DecryptSdkWrapper$monitorTimeout$monitorTimeoutJob$1(r10, null), 3, null);
        R r13 = r11.invoke();     // Catch: Throwable -> L6
        v1.a.a(r12, null, 1, null);
        return r13;
    L6:
        th = move-exception;
        v1.a.a(r12, null, 1, null);
        throw th;
    }

    private final void reportSdkTimeout(String r10, long r11) {
        TrackerApi r12 = TrackerApi.INSTANCE;
        JSONObject r13 = new JSONObject();
        r13.put(WsConstants.KEY_CONNECTION_TYPE, "sdk_timeout");
        r13.put("actionName", r10);
        AppContext r14 = AppContext.INSTANCE;
        r13.put("isAdminMode", r14.isAdminMode());
        r13.put("isDebug", r14.isDebug());
        r13.put("channel", r14.getChannel());
        r13.put("hasNet", j.f5600a.a());
        Unit r15 = Unit.INSTANCE;
        JSONObject r16 = new JSONObject();
        r16.put("duration", r11);
        r12.monitorEvent("model_decrypt_error", r13, r16, null);
    }

    public final int checkModelIntegrity(final InputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "inputStream");
        if (isObricType == false) goto L5;
        b.f4431a.b().e();
        Function0<Integer> r11 = new AnonymousClass1(r10);
    L7:
        return ((Number) monitorTimeout("checkModelIntegrity", r11)).intValue();
    L5:
        r11 = new AnonymousClass2(r10);
        goto L7
    }

    public final int decryptModelFileByFEKCipher(final Context r10, final InputStream r11, final OutputStream r12, final String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "inputStream");
        Intrinsics.checkNotNullParameter(r12, "out");
        Intrinsics.checkNotNullParameter(r13, "FEKCipher");
        if (isObricType == false) goto L7;
        b.f4431a.b().e();
        return ((Number) monitorTimeout("decryptModelFileByFEKCipher", new C03551(r10, r11, r12, r13))).intValue();
    L7:
        if (r14 == false) goto L9;
        Function0<Integer> r15 = new C03562(r10, r11, r12, r13);
    L11:
        return ((Number) monitorTimeout("decryptModelFileWithFEKCipher", r15)).intValue();
    L9:
        r15 = new AnonymousClass3(r10, r11, r12, r13);
        goto L11
    }

    public final int decryptModelFileByKeyInfo(final Context r10, final InputStream r11, final OutputStream r12, final String r13, final String r14) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "inputStream");
        Intrinsics.checkNotNullParameter(r12, "out");
        Intrinsics.checkNotNullParameter(r13, "keyAlias");
        Intrinsics.checkNotNullParameter(r14, "keyInfo");
        if (isObricType == false) goto L6;
        b.f4431a.b().e();
        return ((Number) monitorTimeout("decryptModelFileWitKeyInfo", new C03571(r10, r11, r12, r13, r14))).intValue();
    L6:
        AIKLog.INSTANCE.w(TAG, "not support decryptModelFileByKeyInfo");
        return -1000;
    }

    public final int deleteAttestKey(final Context r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "keyAlias");
        if (isObricType == false) goto L5;
        b.f4431a.b().e();
        Function0<Integer> r12 = new C03581(r10, r11);
    L7:
        return ((Number) monitorTimeout("deleteAttestKey", r12)).intValue();
    L5:
        r12 = new C03592(r10, r11);
        goto L7
    }

    public final ModelInitResult initModelRequest(final Context r10, final String r11, final Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "keyAlias");
        Intrinsics.checkNotNullParameter(r12, "extras");
        if (isObricType == false) goto L5;
        b.f4431a.b().e();
        Function0<ModelInitResult> r13 = new C03601(r10, r11, r12);
    L6:
        Object r14 = monitorTimeout("initModelRequest", r13);
        Intrinsics.checkNotNullExpressionValue(r14, "ctx: Context, keyAlias: …)\n            }\n        }");
        return (ModelInitResult) r14;
    L5:
        r13 = new C03612(r10, r11, r12);
        goto L6
    }

    public final void initPresetPlatKeyInfo(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "keyInfo");
        AIKLog r12 = AIKLog.INSTANCE;
        StringBuilder r13 = new StringBuilder();
        r13.append("initPresetPlatKeyInfo isObricType=");
        boolean r14 = isObricType;
        r13.append(r14);
        r12.d(TAG, r13.toString());
        if (r14 == false) goto L5;
        r12.d(TAG, "obric no need call initPresetPlatKeyInfo");
        return;
    L5:
        ExternalPlatKeyManager.getInstance().init(r10, r11);
    }

    public final String reEncryptFEK(final Context r10, final String r11, final String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Intrinsics.checkNotNullParameter(r11, "keyAlias");
        Intrinsics.checkNotNullParameter(r12, "keyInfo");
        if (isObricType == false) goto L6;
        Object r14 = monitorTimeout("reEncryptFEK", new C03621(r10, r12));
        Intrinsics.checkNotNullExpressionValue(r14, "ctx: Context, keyAlias: …)\n            }\n        }");
    L9:
        return (String) r14;
    L6:
        if (r13 == false) goto L8;
        r14 = monitorTimeout("reEncryptPresetFEK", new C03632(r10, r12));
        goto L9
    L8:
        r14 = monitorTimeout("reEncryptFEK", new C03643(r10, r11, r12));
        goto L9
    }
}
