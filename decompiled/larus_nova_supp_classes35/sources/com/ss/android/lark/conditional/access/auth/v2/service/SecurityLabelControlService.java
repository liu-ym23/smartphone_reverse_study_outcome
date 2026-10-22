package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.decision.PolicyDecision;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.q;
import i8b.u;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SecurityLabelControlService extends i8b.a {
    public String b;
    public SecurityLabelConfig c;

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
    }

    public SecurityLabelControlService(q r3) {
        Intrinsics.checkNotNullParameter(r3, "mManager");
        super(r3);
        this.b = BuildConfig.FLAVOR;
        this.c = new SecurityLabelConfig(null, 1, null);
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if ((r10 instanceof u) == true) goto L5;
        return;
    L5:
        if (w4c.c.a().W() == false) goto L14;
        ScsLogger.d("SecurityPolicy_SecurityLabelControlService", "handleEvent() SecurityLabelConfigCheckEvent, enableSecurityLabelControlCheck is enable");
        List<PolicyModel> r11 = ((i8b.b) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((u) r10)).a).b;
        final long r2 = System.currentTimeMillis();
        final String r1 = qqb.a.d();
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<T> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        PolicyModel r0 = (PolicyModel) r12.next();
        r6.put(com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r0), new com.bytedance.lark.policy.model.b("PC:CLIENT:android:" + r0.getPointKey(), new JSONObject(com.ss.android.lark.security.compliance.infra.util.f.c(r0.getEntity())), CollectionsKt.listOf("SECURITY_LABEL")));
        goto L8
    L10:
        final String r4 = this.b;
        Function1<Map<String, ? extends Boolean>, Unit> r13 = new SecurityLabelControlService$updateConfig$2(r1, r2, r4, this);
        ke6.d r3 = ke6.d.a;
        Intrinsics.checkNotNullParameter(r6, "requestMap");
        Intrinsics.checkNotNullParameter(r13, "callback");
        PolicyDecision.d(r6, r13);
        return;
    }

    public final boolean e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
        if (w4c.c.a().W() == true) goto L5;
        return false;
    L5:
        Boolean r4 = this.c.getConfigInfo().get(r3);
        if (r4 != null) goto L8;
        return false;
    L8:
        return r4.booleanValue();
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
        this.b = r2;
        com.ss.android.lark.storage.kv.repo.a r4 = y.a;
        Function1<SecurityLabelConfig, Unit> r5 = new SecurityLabelControlService$onUserInfoUpdate$1(this);
        Intrinsics.checkNotNullParameter(r5, "onResult");
        y.g.execute(new com.ss.android.lark.conditional.access.auth.v2.q(r5));
    }
}
