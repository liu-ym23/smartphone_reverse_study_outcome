package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static z1.k f1323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Integer, h> f1324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f1325c;

    private static class a implements c.InterfaceC0045c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f1326a;

        a(Application r10) {
            this.f1326a = r10;
        }

        @Override // com.bytedance.common.wschannel.c.InterfaceC0045c
        public void onEnterToBackground() {
            k.a(true);
            if (k.b().get() == false) goto L6;
            k.c().b(this.f1326a);
            return;
        }

        @Override // com.bytedance.common.wschannel.c.InterfaceC0045c
        public void onEnterToForeground() {
            k.a(false);
            if (k.b().get() == false) goto L6;
            k.c().c(this.f1326a);
            return;
        }
    }

    static {
        f1323a = new z1.m();
        f1324b = new ConcurrentHashMap();
        f1325c = new AtomicBoolean(false);
    }

    static /* synthetic */ boolean a(boolean r10) {
        return r10;
    }

    static /* synthetic */ AtomicBoolean b() {
        return f1325c;
    }

    static /* synthetic */ z1.k c() {
        return f1323a;
    }

    static h d(int r10) {
        return f1324b.get(Integer.valueOf(r10));
    }

    static void e(Context r10) {
        Application r11 = (Application) r10.getApplicationContext();
        c r12 = new c();
        r12.d(new a(r11));
        r11.registerActivityLifecycleCallbacks(r12);
    }

    static void f(int r10) {
        f1324b.remove(Integer.valueOf(r10));
    }
}
