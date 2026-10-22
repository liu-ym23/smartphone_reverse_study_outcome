package com.bytedance.apm.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f1313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f1314b = null;
    private static boolean c = false;

    /* JADX INFO: renamed from: com.bytedance.apm.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0089a {
    }

    public interface b {
        void a();
    }

    public interface c {
        void a(InterfaceC0089a r1);
    }

    static {
    }

    public static void a() {
        if (c == false) goto L5;
        return;
    L5:
        b r0 = f1314b;
        if (r0 == null) goto L9;
        r0.a();
        c = true;
        return;
    }

    public static void a(InterfaceC0089a r2) {
        InterfaceC0089a r3 = (InterfaceC0089a) ZeusTransformUtils.wrapperContextForParams(r2, InterfaceC0089a.class, "com.obric.memorydata.plugin");
        c r0 = f1313a;
        if (r0 == null) goto L6;
        r0.a(r3);
        return;
    }
}
