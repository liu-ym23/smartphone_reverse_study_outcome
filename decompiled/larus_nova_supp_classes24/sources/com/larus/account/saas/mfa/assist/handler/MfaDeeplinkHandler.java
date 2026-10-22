package com.larus.account.saas.mfa.assist.handler;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.saas.coreapi.IAccountDeeplinkHandler;
import com.larus.account.saas.mfa.assist.MfaAssistManager;
import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/mfa/assist/handler/MfaDeeplinkHandler;", "Lcom/larus/account/saas/coreapi/IAccountDeeplinkHandler;", "<init>", "()V", "a", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaDeeplinkHandler implements IAccountDeeplinkHandler {

    public static final class a {
    }

    static {
    }

    public MfaDeeplinkHandler() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountDeeplinkHandler
    public final boolean a(Uri r6) {
        Intrinsics.checkNotNullParameter(r6, "uri");
        if (StringsKt.equals(r6.getHost(), "doubaoaccountsdk", true) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        String r1 = b(r6, "user_code");
        a48.a.b r2 = null;
        if (r1 != null) goto L13;
    L19:
        com.larus.account.saas.runtime.internal.delegate.a.a.a("MfaDeeplinkHandler", "handle mfa deeplink failed, reason = payload_token_empty");
    L20:
        if (r2 == null) goto L22;
        MfaAssistManager.a.getClass();
        MfaAssistManager.b(r2);
    L22:
        return true;
    L13:
        if ((!StringsKt.isBlank(r1)) == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L19;
        com.larus.account.saas.runtime.internal.delegate.a.a.d("MfaDeeplinkHandler", "handle mfa push code deeplink, token = ".concat(r1));
        r2 = new a48.a.b(r1, new MfaMessage(b(r6, "scene"), r1), true);
        goto L20
    L5:
        if (Intrinsics.areEqual(r6.getPath(), "/mfa_push_code") == false) goto L7;
        r0 = true;
        goto L8
    }

    public static String b(Uri r1, String r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(UriProtector.getQueryParameter(r1, r2));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        return (String) r3;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
