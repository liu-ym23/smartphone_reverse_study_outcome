package com.bytedance.privacy.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3006a = "b";
    private static volatile b c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.privacy.a.b f3007b;

    static {
    }

    public b() {
    }

    public static b a() {
        if (c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public void a(com.bytedance.privacy.a.b r3) {
        com.bytedance.privacy.a.b r4 = (com.bytedance.privacy.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.privacy.a.b.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "IEnvBridge envBridge cannot be null");
        this.f3007b = r4;
    }

    public boolean b() {
        com.bytedance.privacy.a.b r0 = this.f3007b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }
}
