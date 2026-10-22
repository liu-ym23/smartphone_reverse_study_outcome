package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.decision.PolicyDecision;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.o;
import i8b.q;
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
public final class j extends i8b.a {
    public String b;
    public String c;

    public static final class a {
    }

    static {
    }

    @Override // i8b.a
    public final void a() {
    }

    public j(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        super(r2);
        this.b = BuildConfig.FLAVOR;
        this.c = BuildConfig.FLAVOR;
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if ((r10 instanceof o) == false) goto L19;
        List r11 = CollectionsKt.toMutableList(((i8b.b) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((o) r10)).a).b);
        if (idb.f.a().isEnable("lark.security.file_ip_disconnect_deny") == true) goto L16;
    L10:
        List r12 = CollectionsKt.toList(r11);
        final List r3 = w4c.c.a().t0();
        final long r4 = System.currentTimeMillis();
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        PolicyModel r1 = (PolicyModel) r13.next();
        r0.put(com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r1), new com.bytedance.lark.policy.model.b("PC:CLIENT:android:" + r1.getPointKey(), new JSONObject(com.ss.android.lark.security.compliance.infra.util.f.c(r1.getEntity())), r3));
        goto L12
    L14:
        final String r6 = this.b;
        final String r2 = qqb.a.d();
        Function1<Map<String, ? extends Boolean>, Unit> r14 = new IPControlService$updateIpConfig$2(r2, r3, r4, r6, this);
        ke6.d r5 = ke6.d.a;
        Intrinsics.checkNotNullParameter(r0, "requestMap");
        Intrinsics.checkNotNullParameter(r14, "callback");
        PolicyDecision.d(r0, r14);
        return;
    L16:
        r11.add(com.ss.android.lark.security.compliance.api.model.filepolicy.h.a(CastLongProtector.parseLong(this.b), CastLongProtector.parseLong(this.c)));     // Catch: NumberFormatException -> L8
    L8:
        e = move-exception;
        Log.e("SecurityPolicy_IPControlService", "handleEvent build im file download policy model " + e);
        goto L10
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
        this.b = r2;
        this.c = r3;
    }
}
