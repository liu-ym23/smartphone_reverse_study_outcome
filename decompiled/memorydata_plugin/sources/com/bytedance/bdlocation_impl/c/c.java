package com.bytedance.bdlocation_impl.c;

import android.content.Context;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f1942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseLocate f1943b;

    public c() {
        this.f1943b = BDLocationExtrasService.getLocate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 3);
    }

    public static c a() {
        if (f1942a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1942a != null) goto L9;
        f1942a = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f1942a;
    }

    private BaseLocate b(int r2) {
        if (r2 == 3) goto L5;
        return null;
    L5:
        return this.f1943b;
    }

    public BaseLocate a(int r3) {
        if (BDLocationConfig.isMockEnable() == true) goto L5;
        BaseLocate r2 = b(r3);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return BDLocationExtrasService.getLocate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3);
    L5:
        return BDLocationExtrasService.getLocate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 4);
    }
}
