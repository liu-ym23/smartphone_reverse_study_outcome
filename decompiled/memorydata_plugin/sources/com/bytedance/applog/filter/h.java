package com.bytedance.applog.filter;

import android.content.Context;
import com.bytedance.applog.log.p;
import com.bytedance.applog.monitor.MonitorKey;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.sampling.c f1597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.e.c f1598b;
    private volatile com.bytedance.applog.sampling.b c;

    public h(final com.bytedance.applog.e.c r2, final com.bytedance.applog.sampling.c r3) {
        this.c = null;
        this.f1598b = r2;
        this.f1597a = r3;
        if (p.a() == true) goto L6;
        p.a("sampling_config", new AnonymousClass1(this, r2, r3));
        return;
    }

    static /* synthetic */ com.bytedance.applog.e.c a(h r0) {
        return r0.f1598b;
    }

    public static h a(com.bytedance.applog.e.c r4, String r5) {
        return new h(r4, com.bytedance.applog.sampling.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5));
    }

    public static h a(com.bytedance.applog.e.c r4, JSONObject r5, h r6, String r7) {
        if (r5 != null) goto L5;
        return r6;
    L5:
        if (r6 != null) goto L9;
        return new h(r4, com.bytedance.applog.sampling.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7, r5, null));
    L9:
        return new h(r4, com.bytedance.applog.sampling.d.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7, r5, r6.b()));
    }

    private com.bytedance.applog.sampling.b c() {
        if (this.c != null) goto L5;
        this.c = new AnonymousClass2(this);
        return this.c;
    L5:
        return this.c;
    }

    @Override // com.bytedance.applog.filter.e
    public boolean a() {
        return !this.f1597a.e();
    }

    @Override // com.bytedance.applog.filter.e
    public boolean a(MonitorKey r2, String r3, String r4) {
        if (MonitorKey.event_v3.equals(r2) == true) goto L9;
        if (MonitorKey.log_data.equals(r2) == true) goto L9;
        return false;
    L9:
        return this.f1597a.a(c(), r3, r4);
    }

    public boolean a(String r2, JSONObject r3) {
        return this.f1597a.a(c(), r2, r3);
    }

    public com.bytedance.applog.sampling.c b() {
        return this.f1597a;
    }
}
