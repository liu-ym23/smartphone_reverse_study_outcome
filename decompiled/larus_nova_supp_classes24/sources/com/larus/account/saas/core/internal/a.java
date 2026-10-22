package com.larus.account.saas.core.internal;

import b48.b;
import b48.j;
import b48.l;
import com.larus.account.saas.runtime.internal.util.GsonHolder;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final a a = null;
    public static final ConcurrentHashMap<String, l> b = null;

    public a() {
    }

    static {
        a = new a();
        b = new ConcurrentHashMap();
    }

    public static d48.f.b c() {
        d48.d r0 = c48.a.a;
        d48.d r1 = c48.a.a;
        if (r1 == null) goto L5;
        r1.f();
        return com.larus.init.task.accountsdk.d.b.a("account_saas_user_info");
    L5:
        d48.f.a.getClass();
        d48.f.a r2 = d48.f.a.a;
        Intrinsics.checkNotNullParameter("account_saas_user_info", "repoName");
        return d48.f.a.b.a;
    }

    public static l a(String r4) {
        if (StringsKt.isBlank(r4) == false) goto L6;
        return null;
    L6:
        ConcurrentHashMap<String, l> r0 = b;
        l r1 = r0.get(r4);
        if (r1 == null) goto L9;
        return r1;
    L9:
        Lazy r2 = GsonHolder.a;
        l r3 = (l) GsonHolder.a(c().getString("account_saas_user_info_" + r4), l.class);
        if (r3 == null) goto L16;
        String r5 = r3.b;
        if (r5 == null) goto L16;
        boolean r6 = true;
        if ((!StringsKt.isBlank(r5)) != true) goto L16;
    L17:
        if (r6 == false) goto L19;
        r0.put(r4, r3);
    L19:
        return r3;
    L16:
        r6 = false;
        goto L17
    }

    private final void update(String r4, l r5) {
        String r1 = null;
        if ((!StringsKt.isBlank(r4)) == true) goto L6;
        r4 = null;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        String r0 = r5.b;
        if (r0 != null) goto L11;
        return;
    L11:
        if ((!StringsKt.isBlank(r0)) == false) goto L13;
        r1 = r0;
    L13:
        if (r1 == null) goto L21;
        b.put(r4, r5);
        String r6 = "account_saas_user_info_".concat(r4);
        String r7 = GsonHolder.c(r5);
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        com.larus.account.saas.runtime.internal.delegate.a.a.d("AccountInfoStore", "update: " + r6);
        c().putString(r6, r7);
        return;
    }

    public final b b(b r12, l r13) {
        Intrinsics.checkNotNullParameter(r12, "baseInfo");
        if (r12.a == true) goto L5;
        return r12;
    L5:
        if (r13 != null) goto L7;
        r13 = a(r12.c);
    L11:
        Object r0 = null;
        if (r13 == null) goto L14;
        String r1 = r13.b;
    L16:
        if (Intrinsics.areEqual(r1, r12.b) == true) goto L18;
        return r12;
    L18:
        String r2 = r13.d;
        if (r2 != null) goto L21;
        r2 = r12.f;
    L21:
        String r8 = r2;
        String r3 = r13.c;
        if (r3 != null) goto L24;
        r3 = r12.g;
    L24:
        String r9 = r3;
        String[] r4 = new String[3];
        j r14 = r13.e;
        if (r14 == null) goto L27;
        String r5 = r14.c;
    L28:
        r4[0] = r5;
        if (r14 == null) goto L31;
        String r6 = r14.b;
    L32:
        r4[1] = r6;
        if (r14 == null) goto L35;
        String r15 = r14.a;
    L36:
        r4[2] = r15;
        Iterator r16 = SequencesKt.sequenceOf(r4).iterator();
    L38:
        if (r16.hasNext() == false) goto L49;
        Object r7 = r16.next();
        String r10 = (String) r7;
        if (r10 != null) goto L42;
    L45:
        boolean r11 = true;
    L47:
        if ((!r11) == false) goto L38;
        r0 = r7;
        goto L49
    L42:
        if (StringsKt.isBlank(r10) == true) goto L45;
        r11 = false;
    L49:
        String r17 = (String) r0;
        if (r17 != null) goto L52;
        String r19 = r12.h;
    L53:
        boolean r20 = r12.a;
        String r21 = r12.b;
        String r22 = r12.c;
        int r23 = r12.d;
        String r24 = r12.e;
        Intrinsics.checkNotNullParameter(r21, "userId");
        Intrinsics.checkNotNullParameter(r22, "secUserId");
        Intrinsics.checkNotNullParameter(r24, "userMobile");
        Intrinsics.checkNotNullParameter(r8, "userName");
        Intrinsics.checkNotNullParameter(r9, "screeName");
        Intrinsics.checkNotNullParameter(r19, "avatarUrl");
        return new b(r20, r21, r22, r23, r24, r8, r9, r19);
    L52:
        r19 = r17;
        goto L53
    L35:
        r15 = null;
        goto L36
    L31:
        r6 = null;
        goto L32
    L27:
        r5 = null;
        goto L28
    L14:
        r1 = null;
        goto L16
    L7:
        if (Intrinsics.areEqual(r13.b, r12.b) == true) goto L9;
        return r12;
    L9:
        update(r12.c, r13);
        goto L11
    }
}
