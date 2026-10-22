package com.bytedance.apm;

import com.bytedance.apm6.service.ServiceManager;

/* JADX INFO: loaded from: classes.dex */
public class h {

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f952a = null;

        static {
            f952a = new h(null);
        }

        static /* synthetic */ h a() {
            return f952a;
        }
    }

    private h() {
        ServiceManager.getService(u.f.class);
    }

    /* synthetic */ h(a r10) {
        this();
    }

    public static h a() {
        return b.a();
    }

    public void b() {
        ServiceManager.getService(u.f.class);
    }

    public void c(u.e r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.bytedance.apm.block.l.M(r10.d());
        com.bytedance.apm.block.g.a().e();
        com.bytedance.apm.block.g.a().f(r10.a(), false);
        j.b(r10);
        com.bytedance.apm.block.f.b(r10.g(), r10.d());
    }
}
