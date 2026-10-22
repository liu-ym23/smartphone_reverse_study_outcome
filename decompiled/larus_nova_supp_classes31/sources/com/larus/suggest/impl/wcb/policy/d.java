package com.larus.suggest.impl.wcb.policy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final u a(com.larus.suggest.impl.wcb.request.f r4, hx9.l r5, com.larus.suggest.impl.wcb.request.a r6) {
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "inputStateTracker");
        String r7 = r4.f.d;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "reqSrc");
        int r0 = r7.hashCode();
        if (r0 == (-818885537)) goto L19;
        if (r0 == (-812728331)) goto L16;
        if (r0 == 54220321) goto L10;
    L39:
        String r8 = "";
    L40:
        r6.d = null;
        if (r8.length() <= 0) goto L43;
        boolean r9 = true;
    L44:
        if (r9 == false) goto L48;
        return new u.b(r8);
    L48:
        if (r5.j() == false) goto L52;
        return new u.b("z lottery guide intercept show");
    L52:
        return u.a.a;
    L43:
        r9 = false;
        goto L44
    L10:
        if (r7.equals("app_foreground") == false) goto L39;
        if (r6.b.b() == false) goto L39;
    L24:
        if (r6.a.f() == false) goto L27;
        r8 = "ime is showing";
        goto L40
    L27:
        if (r6.a.k() == false) goto L30;
        r8 = "user is speaking";
        goto L40
    L30:
        if (r6.a.l() == false) goto L33;
        r8 = "bottom menu showing";
        goto L40
    L33:
        if (r6.d == null) goto L39;
        StringBuilder r10 = new StringBuilder("input triggered ");
        fx9.b r1 = r6.d;
        if (r1 == null) goto L37;
        String r2 = r1.a;
    L38:
        r10.append(r2);
        r8 = r10.toString();
        goto L40
    L37:
        r2 = null;
        goto L38
    L16:
        if (r7.equals("enter_chat_cvs_changed") == false) goto L39;
    L21:
        if (r6.b.a() == true) goto L24;
    L19:
        if (r7.equals("enter_chat") == false) goto L39;
        goto L39
    }
}
