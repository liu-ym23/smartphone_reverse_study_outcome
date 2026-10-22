package com.ss.android.lark.passport.flow.mfa;

import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements syb.a<m> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // syb.a
    public final String getName() {
        return "flow_mfa_completed";
    }

    @Override // syb.a
    public final void a(String r8, m r9) {
        Intrinsics.checkNotNullParameter(r8, "nextStep");
        Intrinsics.checkNotNullParameter(r9, "context");
        r9.b.y(r9.c);
        FlowMfaFlowSession r10 = r9.b;
        FlowStep r0 = r9.c;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r0, "step");
        List<String> r1 = r.a;
        JSONObject r2 = r0.getStepInfo();
        Intrinsics.checkNotNullParameter(r2, "stepInfo");
        r2.getString("scope");
        Iterator<T> r3 = r.a.iterator();
    L3:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L13;
        String r5 = r2.getString((String) r3.next());
        if (r5 != null) goto L8;
    L10:
        r5 = null;
    L11:
        if (r5 == null) goto L3;
    L14:
        Iterator<T> r6 = r.b.iterator();
    L16:
        if (r6.hasNext() == false) goto L25;
        String r7 = r2.getString((String) r6.next());
        if (r7 != null) goto L20;
    L22:
        r7 = null;
    L23:
        if (r7 == null) goto L16;
    L20:
        if ((!StringsKt.isBlank(r7)) == false) goto L22;
    L25:
        if (r2.getBoolean("use_local_storage") != null) goto L28;
        r2.getBoolean("useLocalStorage");
    L28:
        if (r5 != null) goto L30;
    L32:
        r5 = null;
    L34:
        if (r5 != null) goto L36;
    L39:
        boolean r11 = true;
    L40:
        if (r11 == false) goto L42;
        r10.h(g.b("MFA completed without mfa_token", null));
        r4 = false;
    L45:
        if (r4 == false) goto L58;
        int r12 = FlowMfaTransparentActivity.d;
        FlowMfaTransparentActivity.a.a(r9.getActivity(), r9.b.a);
        return;
    L58:
        return;
    L42:
        q r13 = new q(r5);
        if (r10.g.compareAndSet(false, true) == false) goto L45;
        r10.t.set(null);
        r10.e.complete(r13);
        goto L45
    L36:
        if (StringsKt.isBlank(r5) == true) goto L39;
        r11 = false;
        goto L40
    L30:
        if ((!StringsKt.isBlank(r5)) == false) goto L32;
    L8:
        if ((!StringsKt.isBlank(r5)) == false) goto L10;
    L13:
        r5 = null;
        goto L14
    }

    @Override // syb.a
    public final boolean b(String r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "nextStep");
        Intrinsics.checkNotNullParameter(r3, "context");
        return Intrinsics.areEqual(r2, "verification_completed");
    }
}
