package fd;

import android.content.Context;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f7411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f7416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f7419m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f7420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f7424e;

        public a(Context r8) {
            this.f7422c = true;
            this.f7423d = true;
            this.f7424e = false;
            if (r8 == null) goto L10;
            Context r10 = r8.getApplicationContext();
            if (r10 == null) goto L7;
            r8 = r10;
        L7:
            this.f7420a = r8;
            return;
        L10:
            throw new RuntimeException(BDLocationExceptionMessage.CONTEXT_ERROR_NULL);
        }
    }

    public final boolean a() {
        return this.f7419m;
    }

    public final String b() {
        return this.f7411e;
    }

    public final Context c() {
        return this.f7407a;
    }

    public final int d() {
        return this.f7415i;
    }

    public final String e() {
        return this.f7412f;
    }

    public final int f() {
        return this.f7408b;
    }

    public final int g() {
        return this.f7409c;
    }

    public final int h() {
        return this.f7410d;
    }

    public final String i() {
        return this.f7416j;
    }

    public final boolean j() {
        return this.f7413g;
    }

    public final boolean k() {
        return this.f7414h;
    }

    public final boolean l() {
        return this.f7417k;
    }

    public final boolean m() {
        return this.f7418l;
    }
}
