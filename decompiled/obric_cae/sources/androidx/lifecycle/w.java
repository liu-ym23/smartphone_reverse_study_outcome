package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import com.qualcomm.qti.qesdk.QesdkUtils;

/* JADX INFO: loaded from: classes.dex */
public final class w implements m {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final w f2195r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2197b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2198m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2199n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Handler f2200o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final n f2201p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.activity.j f2202q;

    public static final class a {
        public static final void a(Activity r8, Application.ActivityLifecycleCallbacks r10) {
            he.i.f(r8, "activity");
            he.i.f(r10, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
            r8.registerActivityLifecycleCallbacks(r10);
        }
    }

    public static final class b implements y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f2203a;

        public b(w r8) {
            this.f2203a = r8;
        }

        @Override // androidx.lifecycle.y.a
        public final void a() {
        }

        @Override // androidx.lifecycle.y.a
        public final void b() {
            w r8 = this.f2203a;
            int r10 = r8.f2196a + 1;
            r8.f2196a = r10;
            if (r10 == 1) goto L5;
            return;
        L5:
            if (r8.f2199n == false) goto L9;
            r8.f2201p.f(h.a.ON_START);
            r8.f2199n = false;
            return;
        }

        @Override // androidx.lifecycle.y.a
        public final void onResume() {
            this.f2203a.a();
        }
    }

    static {
        f2195r = new w();
    }

    public w() {
        this.f2198m = true;
        this.f2199n = true;
        this.f2201p = new n(this);
        this.f2202q = new androidx.activity.j(this, 4);
        new b(this);
    }

    public final void a() {
        int r8 = this.f2197b + 1;
        this.f2197b = r8;
        if (r8 == 1) goto L5;
        return;
    L5:
        if (this.f2198m == false) goto L7;
        this.f2201p.f(h.a.ON_RESUME);
        this.f2198m = false;
        return;
    L7:
        Handler r10 = this.f2200o;
        he.i.c(r10);
        r10.removeCallbacks(this.f2202q);
    }

    @Override // androidx.lifecycle.m
    public final h getLifecycle() {
        return this.f2201p;
    }
}
