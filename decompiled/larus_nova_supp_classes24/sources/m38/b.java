package m38;

import com.larus.account.base.api.UserAction;
import com.larus.account.base.impl.LoginServiceImpl$e;
import com.larus.account.base.model.LoginPlatform;
import com.larus.login.api.AccountTrackService;
import kotlin.jvm.internal.Intrinsics;
import n38.h;
import ua7.a;
import ua7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends a<c> {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ h b;
    public final /* synthetic */ LoginPlatform c;
    public final /* synthetic */ String d;
    public final /* synthetic */ q38.a e;

    public final void onResponse(ua7.b r19) {
        c r1 = (c) r19;
        if (r1 == null) goto L49;
        boolean r3 = this.a;
        h r4 = this.b;
        LoginPlatform r2 = this.c;
        String r14 = this.d;
        q38.a r5 = this.e;
        if (((ua7.b) r1).c == true) goto L24;
        if (r3 == true) goto L24;
        if (r4 == null) goto L10;
        h.a.a(r4, r2, ((ua7.b) r1).h, ((ua7.b) r1).i, r14, null, null, null, null, 480);
    L10:
        AccountTrackService r9 = AccountTrackService.a;
        if (r2 == null) goto L16;
        String r6 = r2.name();
        if (r6 == null) goto L16;
        String r7 = r6;
    L17:
        if (r14 != null) goto L19;
        String r8 = "unknown";
    L20:
        r9.g(r3, 0, r7, r8, Integer.valueOf(((ua7.b) r1).h), ((ua7.b) r1).i);
        String r10 = String.valueOf(((ua7.b) r1).h);
        String r11 = ((ua7.b) r1).i;
        if (r14 != null) goto L23;
        r14 = "normal";
    L23:
        r9.n(0, r10, r11, r14);
        return;
    L19:
        r8 = r14;
    L16:
        r7 = "unknown";
    L24:
        if (r4 == null) goto L26;
        r4.b(r2, r14, Boolean.FALSE);
    L26:
        a r12 = a.a;
        if (r14 != null) goto L29;
        String r13 = "";
    L30:
        r12.getClass();
        if (Intrinsics.areEqual(r14, "logout_by_account_switch") == false) goto L33;
        UserAction r15 = UserAction.ACCOUNT_SWITCH;
    L34:
        a.d(r13, r15, new n38.c(r5.c, r5.d));
        AccountTrackService r16 = AccountTrackService.a;
        if (r2 == null) goto L40;
        String r17 = r2.name();
        if (r17 == null) goto L40;
        String r20 = r17;
    L41:
        if (r14 != null) goto L43;
        String r21 = "unknown";
    L44:
        r16.g(r3, 1, r20, r21, null, null);
        if (r14 != null) goto L47;
        r14 = "normal";
    L47:
        r16.n(1, null, null, r14);
        return;
    L43:
        r21 = r14;
    L40:
        r20 = "unknown";
        goto L41
    L33:
        r15 = UserAction.USER_LOGOUT;
        goto L34
    L29:
        r13 = r14;
        goto L30
    }

    public b(boolean r1, LoginServiceImpl$e r2, LoginPlatform r3, String r4, q38.a r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
