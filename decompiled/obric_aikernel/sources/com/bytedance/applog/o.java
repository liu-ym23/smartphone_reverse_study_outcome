package com.bytedance.applog;

import com.bytedance.bdinstall.Env;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f1240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f1241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Env f1243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, String> f1244e;

    static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f1245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String[] f1246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f1247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f1248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Env f1249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map<String, String> f1250f;

        public b() {
            this.f1250f = null;
        }

        static /* synthetic */ Env a(b r10) {
            return r10.f1249e;
        }

        static /* synthetic */ String[] b(b r10) {
            return r10.f1245a;
        }

        static /* synthetic */ String[] c(b r10) {
            return r10.f1246b;
        }

        static /* synthetic */ String d(b r10) {
            return r10.f1247c;
        }

        static /* synthetic */ String e(b r10) {
            return r10.f1248d;
        }

        static /* synthetic */ Map f(b r10) {
            return r10.f1250f;
        }

        public o g() {
            return new o(this, null);
        }

        public b h(Env r10) {
            this.f1249e = r10;
            return this;
        }

        public b i(String[] r10) {
            this.f1246b = r10;
            return this;
        }

        public b j(String[] r10) {
            this.f1245a = r10;
            return this;
        }

        public b k(String r10) {
            this.f1247c = r10;
            return this;
        }
    }

    private o(b r10) {
        this.f1243d = b.a(r10);
        this.f1240a = b.b(r10);
        this.f1241b = b.c(r10);
        this.f1242c = b.d(r10);
        b.e(r10);
        this.f1244e = b.f(r10);
    }

    /* synthetic */ o(b r10, a r11) {
        this(r10);
    }

    public Map<String, String> a() {
        return this.f1244e;
    }

    public Env b() {
        return this.f1243d;
    }

    public String[] c() {
        return this.f1241b;
    }

    public String[] d() {
        return this.f1240a;
    }

    public String e() {
        return this.f1242c;
    }
}
