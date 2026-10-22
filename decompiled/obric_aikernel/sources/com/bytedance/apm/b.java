package com.bytedance.apm;

import android.content.Context;
import com.bytedance.apm.internal.ApmDelegate;

/* JADX INFO: loaded from: classes.dex */
public class b {

    class a implements Runnable {
        a(b r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.c.t("Apm#init", "Apm init");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.b$b, reason: collision with other inner class name */
    class RunnableC0031b implements Runnable {
        RunnableC0031b(b r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.c.t("Apm#start", "Apm start");
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f742a = null;

        static {
            f742a = new b(null);
        }

        static /* synthetic */ b a() {
            return f742a;
        }
    }

    private b() {
    }

    /* synthetic */ b(com.bytedance.apm.a r10) {
        this();
    }

    public static b a() {
        return c.a();
    }

    public void b(Context r10, u.b r11) {
        ApmDelegate.j().n(r10, r11);
        if (d.G() == false) goto L6;
        q0.c.a().b(new a(this));
        return;
    }

    public void c(u.c r10) {
        ApmDelegate.j().z(r10);
        if (d.G() == false) goto L6;
        q0.c.a().b(new RunnableC0031b(this));
        return;
    }
}
