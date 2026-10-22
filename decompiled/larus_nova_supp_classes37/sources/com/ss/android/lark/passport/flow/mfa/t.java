package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class t implements syb.a<m> {
    public static final t a = null;
    public static final Set<String> b = null;

    public t() {
    }

    @Override // syb.a
    public final String getName() {
        return "flow_mfa_web_url";
    }

    static {
        a = new t();
        b = SetsKt.setOf(new String[]{"risk", "sec_risk", "slider", "captcha", "turing", "bd_turing"});
    }

    @Override // syb.a
    public final void a(String r12, m r13) {
        Intrinsics.checkNotNullParameter(r12, "nextStep");
        Intrinsics.checkNotNullParameter(r13, "context");
        String r0 = n.a(r13.c.getStepInfo());
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        r13.b.h(g.e(r12));
        return;
    L11:
        r13.b.y(r13.c);
        r13.b.s(r13.c);
        Activity r5 = r13.getActivity();
        if (StringsKt.startsWith(r0, "https://", true) == false) goto L14;
    L21:
        String r6 = r0;
        e.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter("FlowMfaWebUrlAction", "source");
        if (e.b(r5, r6, "FlowMfaWebUrlAction", null, null, FlowMfaBidpWebActivityType.INTERNAL_AUTH) == true) goto L26;
        r13.b.h(g.e(r12));
        return;
    L26:
        return;
    L14:
        if (StringsKt.startsWith(r0, "http://", true) == true) goto L21;
        int r4 = com.ss.android.lark.passport.flow.core.network.a.a;
        String r1 = StringsKt.trimEnd(com.ss.android.lark.passport.flow.core.network.a.a((gpb.a) ApiUtils.getApi(gpb.a.class)), new char[]{'/'});
        if (StringsKt.startsWith$default(r0, "/", false, 2, null) == true) goto L20;
        r0 = "/" + r0;
    L20:
        r0 = r1 + r0;
        goto L21
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // syb.a
    public final boolean b(String r3, m r4) {
        Intrinsics.checkNotNullParameter(r3, "nextStep");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (Intrinsics.areEqual(r3, "web_url") == false) goto L5;
        return true;
    L5:
        if (b.contains(r3) == false) goto L15;
        String r5 = n.a(r4.c.getStepInfo());
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
        return true;
    L9:
        if (StringsKt.isBlank(r5) == true) goto L12;
        r6 = false;
    L15:
        return false;
    }
}
