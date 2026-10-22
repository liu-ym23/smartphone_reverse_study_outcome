package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f1641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f1642b = null;

    class a implements c {
        a() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.c
        public boolean a(URI r10, f r11) {
            return true;
        }
    }

    class b implements c {
        b() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.c
        public boolean a(URI r10, f r11) {
            return false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.impl.c$c, reason: collision with other inner class name */
    class C0056c implements c {
        C0056c() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.impl.c
        public boolean a(URI r10, f r11) {
            return f.t(r11.y(), r10.getHost());
        }
    }

    static {
        f1641a = new a();
        new b();
        f1642b = new C0056c();
    }

    boolean a(URI r10, f r11);
}
