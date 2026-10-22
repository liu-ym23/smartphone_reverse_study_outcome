package qp9;

import android.animation.TimeInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final C0070a j = null;
    public TimeInterpolator a;
    public TimeInterpolator b;
    public TimeInterpolator c;
    public TimeInterpolator d;
    public long e;
    public long f;
    public long g;
    public long h;
    public final C0070a i;

    /* JADX INFO: renamed from: qp9.a$a, reason: collision with other inner class name */
    public static final class C0070a {
        public C0070a() {
        }
    }

    public static final class b {
    }

    static {
        j = new C0070a();
    }

    public a() {
        this.a = new FastOutSlowInInterpolator();
        this.b = new FastOutSlowInInterpolator();
        this.c = new FastOutSlowInInterpolator();
        this.d = new FastOutSlowInInterpolator();
        this.e = 250;
        this.f = 250;
        this.g = 250;
        this.h = 250;
        this.i = j;
    }
}
