package com.ss.android.lark.integrator.im.feed_shared.dependency;

import com.ss.android.lark.framework.assembly.larksetting.LarkSettingModuleDependency;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements peb.b.b {
    public b() {
    }

    public final void a() {
    }

    public final void c() {
    }

    public final lpb.a b(com.ss.android.lark.feed.shared.data.appconfig.d r4) {
        opb.e r0 = opb.e.a.a;
        opb.b r1 = r0.d;
        jpb.a r2 = (jpb.a) ((ConcurrentHashMap) r0.b()).get(LarkSettingModuleDependency.CONFIG_KEY);
        r1.getClass();
        String r3 = LarkSettingModuleDependency.CONFIG_KEY.concat("_v1");
        if (r2 != null) goto L5;
    L8:
        String r5 = spb.a.b().getString(r3, "");
    L10:
        return r4.a(r5);
    L5:
        if (r2.a == true) goto L8;
        r5 = spb.a.a().getString(r3, "");
        goto L10
    }
}
