package com.larus.account.saas.mfa.assist.handler;

import com.larus.account.saas.coreapi.IAccountFrontierMessageHandler;
import com.larus.account.saas.mfa.assist.MfaAssistManager;
import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import com.larus.account.saas.runtime.internal.util.GsonHolder;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/mfa/assist/handler/MfaFrontierMessageHandler;", "Lcom/larus/account/saas/coreapi/IAccountFrontierMessageHandler;", "<init>", "()V", "a", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaFrontierMessageHandler implements IAccountFrontierMessageHandler {

    public static final class a {
    }

    static {
    }

    public MfaFrontierMessageHandler() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountFrontierMessageHandler
    public final IAccountFrontierMessageHandler.Priority priority() {
        return IAccountFrontierMessageHandler.Priority.DEFAULT;
    }

    @Override // com.larus.account.saas.coreapi.IAccountFrontierMessageHandler
    public final boolean a(int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "payload");
        a48.a r3 = null;
        if (r6 != 1002) goto L5;
        Lazy r8 = GsonHolder.a;
        MfaMessage r9 = (MfaMessage) GsonHolder.a(r7, MfaMessage.class);
        if (r9 != null) goto L28;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("MfaFrontierMessageHandler", "handle mfa token receive frontier message failed, reason = parse_payload_failed");
    L38:
        if (r3 == null) goto L40;
        MfaAssistManager.a.getClass();
        MfaAssistManager.b(r3);
    L40:
        return true;
    L28:
        String r10 = r9.b();
        if (r10 != null) goto L31;
    L37:
        com.larus.account.saas.runtime.internal.delegate.a.a.a("MfaFrontierMessageHandler", "handle mfa token receive frontier message failed, reason = payload_token_empty");
        goto L38
    L31:
        if ((!StringsKt.isBlank(r10)) == true) goto L34;
        r10 = null;
    L34:
        if (r10 == null) goto L37;
        com.larus.account.saas.runtime.internal.delegate.a.a.d("MfaFrontierMessageHandler", "handle mfa token receive frontier message, token = ".concat(r10));
        r3 = new a48.a.b(r10, r9, false);
        goto L38
    L5:
        if (r6 != 1003) goto L42;
        Lazy r11 = GsonHolder.a;
        z38.a r12 = (z38.a) GsonHolder.a(r7, z38.a.class);
        if (r12 != null) goto L10;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("MfaFrontierMessageHandler", "handle mfa token invalid frontier message failed, reason = parse_payload_failed");
    L23:
        if (r3 == null) goto L40;
        MfaAssistManager.a.getClass();
        MfaAssistManager.b(r3);
        goto L40
    L10:
        String r13 = r12.d();
        if (r13 != null) goto L13;
    L22:
        com.larus.account.saas.runtime.internal.delegate.a.a.a("MfaFrontierMessageHandler", "handle mfa token invalid frontier message failed, reason = payload_token_empty");
        goto L23
    L13:
        if ((!StringsKt.isBlank(r13)) == true) goto L16;
        r13 = null;
    L16:
        if (r13 == null) goto L22;
        if (Intrinsics.areEqual(r12.a(), "success") == true) goto L21;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("MfaFrontierMessageHandler", "handle mfa token invalid frontier message failed, reason = check_result_failed");
        goto L23
    L21:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("MfaFrontierMessageHandler", "handle mfa token invalid frontier message, token = ".concat(r13));
        r3 = new a48.a.C0002a(r13, r12);
        goto L23
    L42:
        return false;
    }
}
