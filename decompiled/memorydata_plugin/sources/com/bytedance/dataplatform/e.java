package com.bytedance.dataplatform;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f2262a;

    public interface a {
        void a(Application r1, k r2, j r3, c r4);
    }

    static {
    }

    static void a(Application r2, k r3, j r4, c r5) {
        Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        k r7 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
        j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
        a r0 = f2262a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r6, r7, r8, r5);
    }
}
