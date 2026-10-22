package com.larus.account.saas.ui.security;

import androidx.fragment.app.FragmentActivity;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import com.larus.account.saas.security.api.IAccountSecurityPushUiService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/ui/security/DefaultAccountSecurityPushUiService;", "Lcom/larus/account/saas/security/api/IAccountSecurityPushUiService;", "<init>", "()V", "a", "account-saas-ui-android_release"}, k = 1, mv = {1, 7, 1})
public final class DefaultAccountSecurityPushUiService implements IAccountSecurityPushUiService {
    public static final /* synthetic */ int e = 0;

    public static final class a {
    }

    static {
    }

    @Override // f48.c
    public final void priority() {
    }

    public DefaultAccountSecurityPushUiService() {
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityPushUiService
    public final boolean e(final e48.f r4) {
        Intrinsics.checkNotNullParameter(r4, "pushPayload");
        c48.a.a().a();
        FragmentActivity r0 = com.larus.init.task.accountsdk.a.a.currentActivity();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        final FragmentActivity r1 = r0;
    L6:
        if (r1 != null) goto L9;
        return false;
    L9:
        com.larus.account.saas.runtime.internal.util.b.a.post(new c(this, r1, r4));
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public static final void f(DefaultAccountSecurityPushUiService r3, String r4, String r5) {
        r3.getClass();
        SaasTracking r6 = SaasTracking.a;
        JSONObject r0 = new JSONObject();
        r0.put("popup_type", "account_risk_alert");
        r0.put("risk_reason", r4);
        r0.put("click_from", r5);
        Unit r7 = Unit.INSTANCE;
        r6.reportEvent("popup_click", r0);
    }
}
