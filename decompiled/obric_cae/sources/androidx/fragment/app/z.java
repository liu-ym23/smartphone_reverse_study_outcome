package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<a> f2067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f2075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f2076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f2077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2078l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f2079m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList<String> f2080n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList<String> f2081o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2082p;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Fragment f2084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2086d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2087e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2088f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public androidx.lifecycle.h.b f2089g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public androidx.lifecycle.h.b f2090h;

        public a() {
        }

        public a(Fragment r8, int r10) {
            this.f2083a = r10;
            this.f2084b = r8;
            androidx.lifecycle.h.b r11 = androidx.lifecycle.h.b.f2161o;
            this.f2089g = r11;
            this.f2090h = r11;
        }
    }

    public z() {
        this.f2067a = new ArrayList();
        this.f2074h = true;
        this.f2082p = false;
    }

    public final void b(a r8) {
        this.f2067a.add(r8);
        r8.f2085c = this.f2068b;
        r8.f2086d = this.f2069c;
        r8.f2087e = this.f2070d;
        r8.f2088f = this.f2071e;
    }
}
