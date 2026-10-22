package com.bytedance.apm.battery;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a() {
        if (com.bytedance.apm.util.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
        b.a().j();
    L5:
        new c().j();
    }

    public static void a(boolean r1) {
        a.a().a(r1);
    }

    public static void b() {
        if (com.bytedance.apm.util.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L6;
        f.a().j();
        return;
    }

    public static void b(boolean r3) {
        if (com.bytedance.apm.util.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L6;
        d.a().a(r3);
        return;
    }
}
