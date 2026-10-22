package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.content.Intent;
import com.ss.android.lark.passport.flow.auth_type.AuthTypeActivity;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements syb.a<m> {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // syb.a
    public final String getName() {
        return "flow_mfa_auth_type_page";
    }

    @Override // syb.a
    public final void a(String r4, m r5) {
        Intrinsics.checkNotNullParameter(r4, "nextStep");
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.b.y(r5.c);
        int r6 = AuthTypeActivity.f;
        Activity r7 = r5.getActivity();
        String r0 = r5.b.a;
        FlowStep r8 = r5.c;
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r0, "flowId");
        Intrinsics.checkNotNullParameter(r8, "step");
        Intent r1 = new Intent(r7, AuthTypeActivity.class);
        p.a(r1);
        r7.startActivity(r1.putExtra("flow_mfa_flow_id", r0).putExtra("auth_type_step", r8));
    }

    @Override // syb.a
    public final boolean b(String r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "nextStep");
        Intrinsics.checkNotNullParameter(r3, "context");
        return Intrinsics.areEqual(r2, "auth_type");
    }
}
