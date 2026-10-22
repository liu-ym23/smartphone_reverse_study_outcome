package com.larus.account.saas.security;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.impl.d0;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.security.api.IAccountSecurityPushUiService;
import com.larus.account.saas.security.api.IAccountSecurityService;
import com.larus.account.saas.security.internal.AccountSecurityObservationStore;
import com.larus.account.saas.security.internal.AccountSecurityReporter;
import com.larus.account.saas.security.internal.b;
import com.larus.account.saas.security.internal.d;
import com.larus.account.saas.security.internal.e;
import com.larus.account.saas.security.internal.f;
import com.larus.account.saas.security.internal.h;
import com.larus.account.saas.security.internal.j;
import com.larus.account.saas.security.kickout.KickOutNoticeFrontierMessageHandler;
import com.larus.account.saas.security.model.AccountSecurityEventType;
import com.larus.account.saas.security.risk.g;
import com.larus.account.saas.ui.AccountSaasUiColorToken;
import com.larus.account.saas.ui.IAccountSaasUiResourceResolver;
import e48.c;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/security/AccountSecurityServiceImpl;", "Lcom/larus/account/saas/security/api/IAccountSecurityService;", "<init>", "()V", "a", "account-saas-security_release"}, k = 1, mv = {1, 7, 1})
public final class AccountSecurityServiceImpl implements IAccountSecurityService {
    public final AccountSecurityObservationStore b;
    public final AccountSecurityReporter c;
    public final f d;
    public final d e;
    public final com.larus.account.saas.security.internal.a f;
    public final e g;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    static {
    }

    public AccountSecurityServiceImpl() {
        AccountSecurityObservationStore r0 = new AccountSecurityObservationStore();
        this.b = r0;
        this.c = new AccountSecurityReporter(r0);
        this.d = new f();
        this.e = new d();
        this.f = new com.larus.account.saas.security.internal.a();
        this.g = new e();
        this.h = LazyKt.lazy(AccountSecurityServiceImpl$accountRiskCoordinator$2.INSTANCE);
        this.i = LazyKt.lazy(AccountSecurityServiceImpl$isPushDialogEnabled$2.INSTANCE);
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityService
    public final void a(c r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        this.f.getClass();
        Intrinsics.checkNotNullParameter(r8, "request");
        String r0 = r8.a;
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L13;
        j.a("/passport/doubao/safety_alert/confirm/");
        d0 r4 = d0.c();
        Pair[] r5 = new Pair[2];
        r5[0] = TuplesKt.to("risk_device_id", r0);
        String r9 = r8.b;
        if (r9 != null) goto L11;
        r9 = "";
    L11:
        r5[1] = TuplesKt.to("risk_reason", r9);
        r4.b("/passport/doubao/safety_alert/confirm/", null, MapsKt.mapOf(r5), new b());
        return;
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityService
    public final boolean e(long r8) {
        Intrinsics.checkNotNullParameter("foreground_dialog", "messageId");
        AccountSecurityObservationStore r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter("foreground_dialog", "messageId");
        if (StringsKt.isBlank("foreground_dialog") == true) goto L9;
        long r0 = System.currentTimeMillis();
        if (((d48.f.b) r2.a.getValue()).getLong("account_security_push_foreground_dialog") <= r0) goto L8;
        return true;
    L8:
        ((d48.f.b) r2.a.getValue()).putLong("account_security_push_foreground_dialog", r0 + r8);
    L9:
        return false;
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityService
    public final void g(e48.f r5) {
        this.g.getClass();
        if (r5 == null) goto L14;
        c48.a.a().a();
        if (com.larus.init.task.accountsdk.a.a.isTeenMode() == true) goto L15;
        boolean r0 = IAccountSecurityPushUiService.a.e(r5);
        int r1 = com.larus.account.saas.security.internal.c.a;
        if (r0 == false) goto L11;
        String r2 = "push_ui_handled";
    L12:
        com.larus.account.saas.security.internal.c.a(r2, MapsKt.mapOf(new Pair[]{TuplesKt.to("risk_reason", r5.d), TuplesKt.to("has_open_url", Boolean.valueOf(!StringsKt.isBlank(r5.g)))}));
        return;
    L11:
        r2 = "push_ui_missing";
        goto L12
    L15:
        return;
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityService
    public final void h(final e48.d r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        final AccountSecurityReporter r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "event");
        final long r2 = System.currentTimeMillis();
        if (((Boolean) r1.c.getValue()).booleanValue() == true) goto L6;
        String r0 = "disabled";
    L32:
        if (r0 == null) goto L34;
        AccountSecurityReporter.a(r0, r9, r2, MapsKt.emptyMap());
        return;
    L34:
        r1.b.execute(new h(r1, r9, r2));
        return;
    L6:
        if (FlowAccountSdk.f().getAccountInfo().a == true) goto L9;
        r0 = "no_login";
        goto L32
    L9:
        if (StringsKt.isBlank(r9.b) == false) goto L12;
        r0 = "uid_missing";
        goto L32
    L12:
        if (r9.a == AccountSecurityEventType.WAKE_UP_APP) goto L14;
        e48.e r3 = r1.a.a(r9.b);
        if (r3 != null) goto L20;
    L24:
        r0 = "outside_observation";
        goto L32
    L20:
        if (r3.b == false) goto L24;
        if (r3.d <= System.currentTimeMillis()) goto L24;
        if (r9.a != AccountSecurityEventType.BROWSE_EXCESSIVE_CHAT_HISTORY) goto L29;
    L31:
        r0 = null;
        goto L32
    L29:
        if (r1.a.b(r9, 1000) == false) goto L31;
    L30:
        r0 = "duplicate";
        goto L32
    L14:
        if (r1.a.b(r9, 3000) == false) goto L31;
        goto L31
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityService
    public final void b(final String r5, final String r6) {
        final g r0 = (g) this.h.getValue();
        r0.getClass();
        boolean r1 = true;
        if (r5 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L17;
        if (r6 != null) goto L12;
    L15:
        if (r1 == false) goto L17;
        return;
    L12:
        if (r6.length() == 0) goto L15;
        r1 = false;
    L17:
        r0.c.execute(new com.larus.account.saas.security.risk.e(r0, r6, r5));
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityService
    public final void c(long r4, com.larus.login.impl.riskcontrol.a r6) {
        com.larus.account.saas.runtime.internal.delegate.a.a.d("AccountSecurityServiceImpl", "handle kick out: code = " + r4);
        int r0 = KickOutNoticeFrontierMessageHandler.a;
        KickOutNoticeFrontierMessageHandler.a.a(r4, r6);
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityService
    public final Intent d(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "openUrl");
        this.e.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "openUrl");
        String r8 = UriProtector.getQueryParameter(UriProtector.parse(r7), "link_url");
        Intent r0 = null;
        String r1 = null;
        if (r8 == null) goto L34;
        Uri r9 = UriProtector.parse(r8);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r10 = Result.constructor-impl(UriProtector.getQueryParameter(r9, "status_bar_bg_color"));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r10) == false) goto L13;
        r10 = null;
    L13:
        String r11 = (String) r10;
        boolean r3 = true;
        if (r11 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L26;
        Integer r12 = IAccountSaasUiResourceResolver.d.c(r6, AccountSaasUiColorToken.STATUS_BAR_BACKGROUND);
        if (r12 == null) goto L25;
        int r13 = r12.intValue();
        StringCompanionObject r14 = StringCompanionObject.INSTANCE;
        r1 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(r13)}, 1));
    L25:
        r11 = r1;
    L26:
        r0 = new Intent();
        if (r11 != null) goto L29;
    L32:
        if (r3 == true) goto L34;
        r0.putExtra("status_bar_bg_color", r11);
        goto L34
    L29:
        if (StringsKt.isBlank(r11) == true) goto L32;
        r3 = false;
        goto L32
    L16:
        if (StringsKt.isBlank(r11) == true) goto L19;
        r4 = false;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        return r0;
    }

    @Override // com.larus.account.saas.security.api.IAccountSecurityService
    public final e48.f f(String r21, JSONObject r22) {
        if (((Boolean) this.i.getValue()).booleanValue() == true) goto L5;
        return null;
    L5:
        this.d.getClass();
        if (r21 != null) goto L8;
    L86:
        return null;
    L8:
        if ((!StringsKt.isBlank(r21)) == false) goto L10;
        String r0 = r21;
    L11:
        if (r0 == null) goto L86;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        Object r1 = Result.constructor-impl(UriProtector.parse(r0));     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r1) == false) goto L20;
        r1 = null;
    L20:
        Uri r2 = (Uri) r1;
        if (r2 == null) goto L91;
        String r9 = f.a(new String[]{UriProtector.getQueryParameter(r2, "biz")});
        if (r9 != null) goto L27;
        return null;
    L27:
        if (Intrinsics.areEqual(r9, "account_security_push") == false) goto L93;
        String r6 = f.a(new String[]{UriProtector.getQueryParameter(r2, "risk_device_id")});
        String r7 = "";
        if (r6 != null) goto L32;
        String r11 = "";
    L33:
        String r8 = f.a(new String[]{UriProtector.getQueryParameter(r2, "risk_reason")});
        if (r8 != null) goto L36;
        String r12 = "";
    L37:
        String r10 = f.a(new String[]{UriProtector.getQueryParameter(r2, "open_url")});
        if (r10 != null) goto L40;
        String r15 = "";
    L41:
        String r13 = f.a(new String[]{UriProtector.getQueryParameter(r2, "popup_dismiss_interval")});
        if (r13 != null) goto L44;
        r13 = "300";
    L44:
        String r14 = f.a(new String[]{UriProtector.getQueryParameter(r2, "push_throttle_interval")});
        if (r14 != null) goto L47;
        r14 = "600";
    L47:
        String[] r16 = new String[1];
        if (r22 == null) goto L50;
        String r17 = r22.optString("id");
    L51:
        r16[0] = r17;
        String r19 = f.a(r16);
        if (r19 != null) goto L54;
        r19 = "unknown";
    L54:
        String[] r110 = new String[1];
        if (r22 == null) goto L57;
        String r111 = r22.optString("title");
    L58:
        r110[0] = r111;
        String r112 = f.a(r110);
        if (r112 != null) goto L61;
        r112 = "";
    L61:
        String[] r113 = new String[1];
        if (r22 == null) goto L64;
        String r3 = r22.optString("text");
    L65:
        r113[0] = r3;
        String r4 = f.a(r113);
        if (r4 == null) goto L69;
        r7 = r4;
    L69:
        String[] r20 = new String[2];
        if (r22 == null) goto L72;
        String r114 = r22.optString("popup_content");
    L73:
        r20[0] = r114;
        r20[1] = UriProtector.getQueryParameter(r2, "popup_content");
        String r23 = f.a(r20);
        if (r23 != null) goto L76;
        String r115 = r7;
    L77:
        Long r24 = StringsKt.toLongOrNull(r13);
        if (r24 == null) goto L80;
        long r25 = r24.longValue();
    L81:
        long r116 = r25 * 1000;
        Long r26 = StringsKt.toLongOrNull(r14);
        if (r26 == null) goto L84;
        long r27 = r26.longValue();
    L90:
        return new e48.f(r9, r19, r11, r12, r112, r115, r15, r116, r27 * 1000);
    L84:
        r27 = 600;
        goto L90
    L80:
        r25 = 300;
        goto L81
    L76:
        r115 = r23;
        goto L77
    L72:
        r114 = null;
        goto L73
    L64:
        r3 = null;
        goto L65
    L57:
        r111 = null;
        goto L58
    L50:
        r17 = null;
        goto L51
    L40:
        r15 = r10;
        goto L41
    L36:
        r12 = r8;
        goto L37
    L32:
        r11 = r6;
        goto L33
    L93:
        return null;
    L91:
        return null;
    L15:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L10:
        r0 = null;
        goto L11
    }
}
