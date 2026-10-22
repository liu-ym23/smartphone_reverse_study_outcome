package androidx.appcompat.app;

import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s.a f648a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f649b = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static f0.e f650m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static f0.e f651n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Boolean f652o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f653p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final n.d<WeakReference<h>> f654q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Object f655r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Object f656s = null;

    public static class a {
        public static LocaleList a(String r8) {
            return LocaleList.forLanguageTags(r8);
        }
    }

    public static class b {
        public static LocaleList a(Object r8) {
            return ((LocaleManager) r8).getApplicationLocales();
        }

        public static void b(Object r8, LocaleList r10) {
            ((LocaleManager) r8).setApplicationLocales(r10);
        }
    }

    static {
        f648a = new s.a(new s.b());
        f649b = -100;
        f650m = null;
        f651n = null;
        f652o = null;
        f653p = false;
        f654q = new n.d();
        f655r = new Object();
        f656s = new Object();
    }

    public h() {
    }

    public static boolean m(Context r8) {
        if (f652o != null) goto L10;
        int r10 = q.f674a;     // Catch: PackageManager.NameNotFoundException -> L8
        int r11 = q.a.a() | 128;     // Catch: PackageManager.NameNotFoundException -> L8
        Bundle r12 = r8.getPackageManager().getServiceInfo(new ComponentName(r8, q.class), r11).metaData;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r12 == null) goto L10;
        f652o = Boolean.valueOf(r12.getBoolean("autoStoreLocales"));     // Catch: PackageManager.NameNotFoundException -> L8
    L8:
        Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
        f652o = Boolean.FALSE;
    L10:
        return f652o.booleanValue();
    }

    public static void v(h r8) {
        Object r10 = f655r;
        monitor-enter(r10);
        Iterator<WeakReference<h>> r11 = f654q.iterator();     // Catch: Throwable -> L13
    L6:
        if (r11.hasNext() == false) goto L11;
        h r12 = r11.next().get();     // Catch: Throwable -> L13
        if (r12 == r8) goto L10;
        if (r12 != null) goto L6;
    L10:
        r11.remove();     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public abstract void A(Toolbar r8);

    public void B(int r8) {
    }

    public abstract void C(CharSequence r8);

    public abstract g.b D(g.b.a r8);

    public abstract void c(View r8, ViewGroup.LayoutParams r10);

    public Context d(Context r8) {
        return r8;
    }

    public abstract <T extends View> T e(int r8);

    public Context f() {
        return null;
    }

    public abstract AppCompatDelegateImpl.b g();

    public int h() {
        return -100;
    }

    public abstract MenuInflater i();

    public abstract androidx.appcompat.app.a j();

    public abstract void k();

    public abstract void l();

    public abstract void n(Configuration r8);

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract void u();

    public abstract boolean w(int r8);

    public abstract void x(int r8);

    public abstract void y(View r8);

    public abstract void z(View r8, ViewGroup.LayoutParams r10);
}
