package com.ss.android.deviceregister.c;

import android.content.Context;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.service.NUApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f15202b;

    a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.f15202b = new ConcurrentHashMap();
        this.f15201a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.deviceregister.c.b
    public void a(Map<String, String> r2) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        NUApi r3 = BDInstall.newUserMode();
        if (r3 == null) goto L6;
        r3.mapCustomParams(r1);
        return;
    }

    @Override // com.ss.android.deviceregister.c.b
    public boolean a() {
        return BDInstall.isNewUserMode();
    }

    @Override // com.ss.android.deviceregister.c.b
    public boolean b() {
        NUApi r0 = BDInstall.newUserMode();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isAutoMode();
    }

    @Override // com.ss.android.deviceregister.c.b
    public void c() {
    }
}
