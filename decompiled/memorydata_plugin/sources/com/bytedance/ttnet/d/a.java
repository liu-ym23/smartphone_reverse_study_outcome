package com.bytedance.ttnet.d;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.frameworks.baselib.network.http.ok3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f3280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICronetAppProvider f3281b;
    private d c;

    private a() {
    }

    public static a f() {
        if (f3280a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3280a != null) goto L9;
        f3280a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f3280a;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public int a() {
        d r0 = this.c;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.h();
    }

    public void a(ICronetAppProvider r3) {
        this.f3281b = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r3, ICronetAppProvider.class, "com.obric.memorydata.plugin");
    }

    public void a(d r3) {
        this.c = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public String b() {
        d r2 = this.c;
        if (r2 != null) goto L5;
        return null;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r2.i().get(TTNetInit.DOMAIN_HTTPDNS_KEY), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public String[] c() {
        if (ZeusTransformUtils.instanceOf(this.c, com.bytedance.ttnet.a.class) == true) goto L5;
        return null;
    L5:
        return ((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(this.c, com.bytedance.ttnet.a.class, "com.obric.memorydata.plugin")).c();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public String[] d() {
        if (ZeusTransformUtils.instanceOf(this.c, com.bytedance.ttnet.a.class) == true) goto L5;
        return null;
    L5:
        return ((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(this.c, com.bytedance.ttnet.a.class, "com.obric.memorydata.plugin")).b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public List<String> e() {
        ICronetAppProvider r0 = this.f3281b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAbSdkVersion();
    }
}
