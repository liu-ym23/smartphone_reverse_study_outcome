package com.bytedance.apm;

import com.bytedance.apm.block.l;
import com.bytedance.apm6.service.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: com.bytedance.apm.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f1304a = null;

        static {
            f1304a = new e(null);
        }

        static /* synthetic */ e a() {
            return f1304a;
        }
    }

    private e() {
        ServiceManager.getService(com.bytedance.apm.config.f.class);
    }

    /* synthetic */ e(AnonymousClass1 r1) {
        this();
    }

    public static e a() {
        return a.a();
    }

    public void a(com.bytedance.apm.config.e r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        l.a(r3.g());
        com.bytedance.apm.block.g.a().c();
        com.bytedance.apm.block.g.a().a(r3.c(), false);
        g.a(r3);
        com.bytedance.apm.block.f.a(r3.i(), r3.g());
    }

    public void b() {
        ServiceManager.getService(com.bytedance.apm.config.f.class);
    }
}
