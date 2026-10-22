package com.ss.android.lark.conditional.access.auth.v2.service;

import com.bytedance.lark.policy.decision.PolicyDecision;
import com.ss.android.lark.conditional.access.auth.v2.n;
import com.ss.android.lark.conditional.access.auth.v2.y;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import i8b.q;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DeviceControlService extends i8b.a {
    public static final Map<String, Integer> e = null;
    public String b;
    public DeviceConfig c;
    public CompositeDisposable d;

    public static final class a {
    }

    static {
        e = MapsKt.mapOf(new Pair[]{TuplesKt.to("DEVICE_CREDIBILITY", 1), TuplesKt.to("DEVICE_OWNERSHIP", 2), TuplesKt.to("DEVICE_OS", 4), TuplesKt.to("DEVICE_TERMINAL", 8), TuplesKt.to("DEVICE_MDM_STATUS", 22)});
    }

    @Override // i8b.a
    public final void a() {
        this.d.clear();
    }

    public DeviceControlService(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        super(r2);
        this.b = BuildConfig.FLAVOR;
        this.c = new DeviceConfig(new HashMap());
        this.d = new CompositeDisposable();
    }

    @Override // i8b.a
    public final void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r14) {
        Intrinsics.checkNotNullParameter(r14, "event");
        if ((r14 instanceof i8b.k) == true) goto L5;
        return;
    L5:
        if (idb.f.a().isEnable("lark.security.file_protection_policy_device") == false) goto L17;
        ScsLogger.d("SecurityPolicy_DeviceControlService", "handleEvent() DeviceConfigCheckEvent, lark.security.file_protection_policy_device FG is enable");
        List<PolicyModel> r15 = ((i8b.b) ((com.ss.android.lark.security.compliance.api.model.filepolicy.k) ((i8b.k) r14)).a).b;
        final String r7 = qqb.a.d();
        final long r8 = System.currentTimeMillis();
        Iterator<T> r10 = e.keySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L18;
        final String r2 = (String) r10.next();
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<T> r0 = r15.iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        PolicyModel r1 = (PolicyModel) r0.next();
        r11.put(com.ss.android.lark.security.compliance.api.model.filepolicy.h.i(r1), new com.bytedance.lark.policy.model.b("PC:CLIENT:android:" + r1.getPointKey(), new JSONObject(com.ss.android.lark.security.compliance.infra.util.f.c(r1.getEntity())), CollectionsKt.listOf(r2)));
        goto L11
    L13:
        final String r5 = this.b;
        Function1<Map<String, ? extends Boolean>, Unit> r12 = new DeviceControlService$updateDeviceConfig$1$2(r7, r2, r8, r5, this);
        ke6.d r3 = ke6.d.a;
        Intrinsics.checkNotNullParameter(r11, "requestMap");
        Intrinsics.checkNotNullParameter(r12, "callback");
        PolicyDecision.d(r11, r12);
        goto L8
    L18:
        return;
    }

    @Override // i8b.a
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "tenantId");
        this.b = r2;
        com.ss.android.lark.storage.kv.repo.a r4 = y.a;
        Function1<DeviceConfig, Unit> r5 = new DeviceControlService$onUserInfoUpdate$1(this);
        Intrinsics.checkNotNullParameter(r5, "onResult");
        y.g.execute(new n(r5));
        this.d = new CompositeDisposable();
    }
}
