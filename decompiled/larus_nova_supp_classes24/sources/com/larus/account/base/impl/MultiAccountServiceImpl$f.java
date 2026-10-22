package com.larus.account.base.impl;

import com.google.gson.Gson;
import com.larus.account.base.api.AccountSwitchReason;
import com.larus.account.base.api.UserAction;
import com.larus.account.base.multi.d;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m38.a;
import tx9.g2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MultiAccountServiceImpl$f extends va7.g {
    public final /* synthetic */ q38.b a;
    public final /* synthetic */ q38.b b;
    public final /* synthetic */ AccountSwitchReason c;
    public final /* synthetic */ n38.k d;

    public final void onSuccess(ua7.b r21) {
        Intrinsics.checkNotNullParameter((xa7.j) r21, "response");
        Gson r0 = d.a;
        q38.b r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "target");
        long r2 = System.currentTimeMillis();
        Object r4 = d.c;
        monitor-enter(r4);
        List r5 = d.d;     // Catch: Throwable -> L46
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));     // Catch: Throwable -> L46
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L46
    L6:
        if (r7.hasNext() == false) goto L14;
        q38.b r8 = (q38.b) r7.next();     // Catch: Throwable -> L46
        if (Intrinsics.areEqual(r8.g(), r1.g()) == false) goto L11;
        r8 = q38.b.a(r8, null, null, null, false, Math.max(r8.e(), r2), true, null, null, true, 831);     // Catch: Throwable -> L46
    L13:
        r6.add(r8);     // Catch: Throwable -> L46
        goto L6
    L11:
        if (r8.k() == false) goto L13;
        r8 = q38.b.a(r8, null, null, null, false, 0, false, null, null, false, 1023);     // Catch: Throwable -> L46
        goto L13
    L14:
        d.d = CollectionsKt.toMutableList(r6);     // Catch: Throwable -> L46
        d.d();     // Catch: Throwable -> L46
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L46
        monitor-exit(r4);
        q38.b r9 = this.b;
        if (r9 == null) goto L21;
        String r10 = r9.g();
        if (r10 == null) goto L21;
        q38.b r11 = d.b(r10);
    L22:
        q38.b r12 = d.b(this.a.g());
        if (r12 != null) goto L25;
        r12 = this.a;
    L25:
        n38.b r13 = new n38.b(r11, r12, true, 0, null, this.c);
        if (this.c.isLogout() == true) goto L41;
        if (r11 != null) goto L29;
        r11 = this.b;
    L29:
        a r14 = a.a;
        UserAction r15 = UserAction.ACCOUNT_SWITCH;
        if (r11 == null) goto L32;
        String r16 = r11.j();
    L33:
        if (r16 != null) goto L35;
        r16 = "";
    L35:
        if (r11 == null) goto L37;
        String r17 = r11.g();
    L38:
        if (r17 != null) goto L40;
        r17 = "";
    L40:
        n38.c r19 = new n38.c(r16, r17);
        r14.getClass();
        a.d("logout_by_account_switch", r15, r19);
        goto L41
    L37:
        r17 = null;
        goto L38
    L32:
        r16 = null;
    L41:
        a r20 = a.a;
        UserAction r22 = UserAction.ACCOUNT_SWITCH;
        r20.getClass();
        a.b("login_by_account_switch", null, r22);
        n38.k r23 = this.d;
        if (r23 == null) goto L44;
        r23.b(r13);
    L44:
        g2.h(this.c.getEnterMethod(), "1", null, null, 121);
        return;
    L21:
        r11 = null;
    L46:
        th = move-exception;
        throw th;
    }

    public final void onError(ua7.b r9, int r10) {
        xa7.j r11 = (xa7.j) r9;
        Intrinsics.checkNotNullParameter(r11, "response");
        String r12 = ((ua7.b) r11).i;
        FLogger.a.e("MultiAccountServiceImpl", "switchAccount by IBDAccountExtraApi fail, code=" + r10 + ", msg=" + r12);
        n38.b r0 = new n38.b(this.b, this.a, false, r10, r12, this.c);
        n38.k r1 = this.d;
        if (r1 == null) goto L5;
        r1.a(r0);
    L5:
        g2.h(this.c.getEnterMethod(), "0", String.valueOf(r10), r12, 97);
    }

    public MultiAccountServiceImpl$f(q38.b r1, q38.b r2, AccountSwitchReason r3, n38.k r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
