package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.verify.VerifyListActivity;
import com.ss.android.lark.passport.flow.verify.entity.VerifyListStepInfo;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class s implements syb.a<m> {
    public static final s a = null;
    public static final Set<String> b = null;

    public s() {
    }

    @Override // syb.a
    public final String getName() {
        return "flow_mfa_verify_list_page";
    }

    static {
        a = new s();
        b = SetsKt.setOf(new String[]{"verify_list", "verify_identity_new", "page_verify_identity_new", "show_dialog"});
    }

    @Override // syb.a
    public final void a(String r4, m r5) {
        Intrinsics.checkNotNullParameter(r4, "nextStep");
        Intrinsics.checkNotNullParameter(r5, "context");
        r5.b.y(r5.c);
        int r6 = VerifyListActivity.g;
        Activity r7 = r5.getActivity();
        String r8 = r5.b.a;
        FlowMfaFlowSession r0 = o.a(r8);
        JSONObject r1 = null;
        if (r0 == null) goto L9;
        FlowStep r2 = r0.g();
        if (r2 == null) goto L8;
        r1 = r2.getStepInfo();
    L8:
        r1 = (VerifyListStepInfo) uzb.c.a(r1, VerifyListStepInfo.class);
    L9:
        if (r1 != null) goto L11;
        PassportLog.b("flow_mfa_verify_list_page", "parseStepInfo failed");
        return;
    L11:
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "flowId");
        Intrinsics.checkNotNullParameter(r1, "stepInfo");
        Intent r3 = new Intent(r7, VerifyListActivity.class);
        p.a(r3);
        r7.startActivity(r3.putExtra("flow_mfa_flow_id", r8).putExtra("step_info", r1));
    }

    @Override // syb.a
    public final boolean b(String r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "nextStep");
        Intrinsics.checkNotNullParameter(r3, "context");
        return b.contains(r2);
    }
}
