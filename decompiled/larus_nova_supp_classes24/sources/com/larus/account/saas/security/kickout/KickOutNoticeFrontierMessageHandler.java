package com.larus.account.saas.security.kickout;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.sdk.account.impl.j;
import com.larus.account.saas.coreapi.IAccountFrontierMessageHandler;
import com.larus.account.saas.runtime.depend.ToastType;
import com.larus.account.saas.runtime.internal.delegate.SaasApp;
import com.larus.account.saas.ui.dialog.CommonDialog;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/security/kickout/KickOutNoticeFrontierMessageHandler;", "Lcom/larus/account/saas/coreapi/IAccountFrontierMessageHandler;", "<init>", "()V", "a", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
public final class KickOutNoticeFrontierMessageHandler implements IAccountFrontierMessageHandler {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a(long r6, Function0 r8) {
            SaasApp r0 = SaasApp.a;
            String r1 = r0.c(2131899121);
            if (r6 != 710012056) goto L6;
            String r7 = r0.c(2131899120);
        L15:
            FragmentActivity r9 = r0.currentActivity();
            if ((r9 instanceof FragmentActivity) == false) goto L18;
            FragmentActivity r10 = r9;
        L20:
            if (r10 != null) goto L22;
        L34:
            com.larus.account.saas.runtime.internal.delegate.a.a.f("KickOutNoticeFrontierMessageHandler", "skip kick out dialog because activity is not ready");
            r8.invoke();
            return;
        L22:
            if (r10.isFinishing() == true) goto L34;
            if (r10.isDestroyed() == true) goto L34;
            FragmentManager r3 = r10.getSupportFragmentManager();
            if (r3.findFragmentByTag("account_kick_out_dialog") == null) goto L29;
            com.larus.account.saas.runtime.internal.delegate.a.a.d("KickOutNoticeFrontierMessageHandler", "skip kick out dialog because dialog is showing");
            r8.invoke();
            return;
        L29:
            Integer r2 = Integer.valueOf(ContextCompat.getColor(r10, 2131100120));
            com.larus.account.saas.security.kickout.a r5 = new com.larus.account.saas.security.kickout.a(r8);
            String r11 = r10.getString(2131899113);
            Intrinsics.checkNotNullParameter(r5, "listener");
            CommonDialog r12 = new CommonDialog();
            r12.d = r1;
            r12.e = true;
            r12.f = r7;
            r12.g = r2;
            r12.h = null;
            r12.i = r11;
            r12.j = 0;
            r12.k = true;
            r12.l = r5;
            r12.m = null;
            r12.n = true;
            r12.o = null;
            r12.p = 0;
            r12.q = false;
            r12.r = false;
            r12.s = null;
            r12.t = true;
            r12.u = null;
            r12.v = false;
            r12.w = false;
            Intrinsics.checkNotNullParameter(r3, "fragmentManager");
            FragmentTransaction r13 = r3.beginTransaction();
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "account_kick_out_dialog", 0) == true) goto L33;
            r13 = r13.add(r12, "account_kick_out_dialog");
        L33:
            r13.commitAllowingStateLoss();
            return;
        L18:
            r10 = null;
            goto L20
        L6:
            if (r6 != 710012060) goto L9;
            r7 = r0.c(2131899117);
            goto L15
        L9:
            if (r6 != 710012061) goto L12;
            r7 = r0.c(2131899118);
            goto L15
        L12:
            if (r6 != 710012062) goto L14;
            r7 = r0.c(2131899119);
            goto L15
        L14:
            r7 = "";
            goto L15
        }
    }

    static {
    }

    public KickOutNoticeFrontierMessageHandler() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountFrontierMessageHandler
    public final IAccountFrontierMessageHandler.Priority priority() {
        return IAccountFrontierMessageHandler.Priority.HIGH;
    }

    @Override // com.larus.account.saas.coreapi.IAccountFrontierMessageHandler
    public final boolean a(int r5, final String r6) {
        Intrinsics.checkNotNullParameter(r6, "payload");
        if (r5 == 1001) goto L52;
        return false;
    L52:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L8
        Object r8 = Result.constructor-impl(new JSONObject(r6));     // Catch: Throwable -> L8
    L10:
        Integer r1 = null;
        if (Result.isFailure-impl(r8) == false) goto L13;
        r8 = null;
    L13:
        JSONObject r9 = (JSONObject) r8;
        if (r9 == null) goto L18;
        JSONObject r0 = r9.optJSONObject("biz_extra");
        if (r0 == null) goto L18;
        String r2 = r0.optString("sub_type");
    L19:
        if (r9 == null) goto L21;
        r1 = Integer.valueOf(r9.optInt("protocol_type"));
    L21:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("KickOutNoticeFrontierMessageHandler", "handle kick out: biz_extra.sub_type = " + r2 + ", protocol_type = " + r1);
        if (r2 != null) goto L24;
    L49:
        j.m(SaasApp.a.getApplication()).p(r6);
        return true;
    L24:
        switch(r2.hashCode()) {
            case -1854470143: goto L46;
            case -1480357166: goto L42;
            case -108220795: goto L38;
            case 101761006: goto L34;
            case 323961642: goto L30;
            case 1911637322: goto L27;
            default: goto L49;
        };
    L27:
        if (r2.equals("enterprise_kick_quit") == false) goto L49;
    L32:
        a.a(710012060, new KickOutNoticeFrontierMessageHandler$showKickOutDialogAndContinuePassport$1(this, r6));
        return true;
    L30:
        if (r2.equals("enterprise_kick_resignation") == true) goto L32;
    L34:
        if (r2.equals("enterprise_kick_visibility_removed") == false) goto L49;
        a.a(710012062, new KickOutNoticeFrontierMessageHandler$showKickOutDialogAndContinuePassport$1(this, r6));
        return true;
    L38:
        if (r2.equals("binding") == false) goto L49;
        SaasApp r10 = SaasApp.a;
        r10.f(ToastType.INFO, r10.c(2131899112));
        j.m(r10.getApplication()).p(r6);
        return true;
    L42:
        if (r2.equals("enterprise_kick_freeze") == false) goto L49;
        a.a(710012061, new KickOutNoticeFrontierMessageHandler$showKickOutDialogAndContinuePassport$1(this, r6));
        return true;
    L46:
        if (r2.equals("enterprise_kick_feishu_ban") == false) goto L49;
        a.a(710012056, new KickOutNoticeFrontierMessageHandler$showKickOutDialogAndContinuePassport$1(this, r6));
        return true;
    L18:
        r2 = null;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
