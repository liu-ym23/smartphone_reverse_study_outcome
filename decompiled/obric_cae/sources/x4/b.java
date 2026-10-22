package x4;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f13378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f13379b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f13380m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f13381n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f13382o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C0192b f13383p;

    public class a extends k5.l<SharedPreferences> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f13384c;

        public a(b r8) {
            this.f13384c = r8;
        }

        @Override // k5.l
        public final SharedPreferences a(Object[] r8) {
            String r10 = k5.a.b(this.f13384c, "ug_install_settings_pref");
            if (TextUtils.equals(r10, "ug_install_settings_pref") == false) goto L6;
            Context r11 = (Context) r8[0];
            return k5.a.f8930a.b(new Object[]{r11});
        L6:
            return ((Context) r8[0]).getSharedPreferences(r10, 0);
        }
    }

    /* JADX INFO: renamed from: x4.b$b, reason: collision with other inner class name */
    public class C0192b extends c4.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f13385c;

        public C0192b(b r8) {
            this.f13385c = r8;
            super(3);
        }

        public final SharedPreferences c(String r8, Object[] r10) {
            k5.a.C0106a r11 = k5.a.f8930a;
            String r12 = k5.a.b(this.f13385c, "ug_install_settings_pref") + "_" + r8;
            if (TextUtils.equals(r12, "ug_install_settings_pref_" + r8) == false) goto L6;
            return ((Context) r10[0]).getSharedPreferences("ug_install_settings_pref_" + r8, 0);
        L6:
            return ((Context) r10[0]).getSharedPreferences(r12, 0);
        }
    }

    public b(m0 r8, boolean r10, boolean r11, boolean r12) {
        this.f13382o = new a(this);
        this.f13383p = new C0192b(this);
        this.f13379b = r8;
        this.f13380m = r10;
        this.f13381n = r11;
        this.f13378a = r12;
    }

    public final SharedPreferences a(j0 r8) {
        if (r8.J == true) goto L33;
        Context r10 = r8.f13465c;
        String r11 = String.valueOf(r8.f13463a);
        C0192b r12 = this.f13383p;
        Object[] r13 = {r10};
        Object r14 = null;
        if (((ConcurrentHashMap) r12.f3326b) != null) goto L8;
        Object r15 = null;
    L9:
        if (r15 != null) goto L30;
        monitor-enter(r12);
    L26:
        th = move-exception;
        throw th;
    L12:
        if (((ConcurrentHashMap) r12.f3326b) == null) goto L15;
        r14 = ((ConcurrentHashMap) r12.f3326b).get(r11);     // Catch: Throwable -> L26
    L15:
        if (r14 != null) goto L23;
        SharedPreferences r16 = r12.c(r11, r13);     // Catch: Throwable -> L26
        if (r16 != null) goto L19;
    L22:
        r15 = r16;
    L24:
        monitor-exit(r12);     // Catch: Throwable -> L26
        goto L30
    L19:
        if (((ConcurrentHashMap) r12.f3326b) != null) goto L21;
        r12.f3326b = new ConcurrentHashMap(4);     // Catch: Throwable -> L26
    L21:
        ((ConcurrentHashMap) r12.f3326b).put(r11, r16);     // Catch: Throwable -> L26
        goto L22
    L23:
        r15 = r14;
    L30:
        return (SharedPreferences) r15;
    L8:
        r15 = ((ConcurrentHashMap) r12.f3326b).get(r11);
        goto L9
    L33:
        return this.f13382o.b(new Object[]{r8.f13465c});
    }

    public final Object clone() {
        return super.clone();
    }

    public final boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == false) goto L18;
        b r10 = (b) r8;
        m0 r11 = r10.f13379b;
        if (this.f13379b.equals(r11) == false) goto L17;
        if (this.f13381n != r10.f13381n) goto L17;
        if (this.f13380m != r10.f13380m) goto L17;
        boolean r12 = r10.f13378a;
        if (this.f13378a != r12) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public final String toString() {
        return "AbsEnv{isChildMode=" + this.f13378a + ", config=" + this.f13379b + ", isI18n=" + this.f13380m + ", isBoe=" + this.f13381n + '}';
    }
}
