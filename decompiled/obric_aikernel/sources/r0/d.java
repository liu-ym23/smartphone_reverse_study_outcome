package r0;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class d implements t4.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12525c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f12527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Runnable f12528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Handler f12529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f12530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f12531l;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f12532c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Integer f12533g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f12534h;

        a(d r10, WeakReference r11, Integer r12) {
            this.f12534h = r10;
            this.f12532c = r11;
            this.f12533g = r12;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f12532c.get() != null) goto L5;
            return;
        L5:
            View r10 = ((View) this.f12532c.get()).findViewById(this.f12533g.intValue());
            if (r10 != null) goto L8;
            return;
        L8:
            if (r10.getVisibility() == 0) goto L10;
            return;
        L10:
            if (r10.getWidth() <= 0) goto L29;
            ViewTreeObserver r11 = ((View) this.f12532c.get()).getViewTreeObserver();
            if (r11.isAlive() == false) goto L17;
            if (d.a(this.f12534h) == null) goto L17;
            r11.removeOnGlobalLayoutListener(d.a(this.f12534h));
        L17:
            if (d.c(this.f12534h) == null) goto L19;
            d.e(this.f12534h).removeCallbacks(d.c(this.f12534h));
            d.d(this.f12534h, null);
        L19:
            d.b(this.f12534h, null);
            if (d.f(this.f12534h) <= 0) goto L30;
            long r12 = System.currentTimeMillis();
            long r13 = r12 - d.f(this.f12534h);
            d.g(this.f12534h, 0);
            if (r13 < d.h(this.f12534h)) goto L24;
            return;
        L24:
            if (r13 <= 0) goto L32;
            AutoPageTraceHelper.c(r12, d.i(this.f12534h));
            f.a.d(d.i(this.f12534h), "activityOnCreateToViewShow", r13);
            return;
        L32:
            return;
        L30:
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f12535c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f12536g;

        b(d r10, WeakReference r11) {
            this.f12536g = r10;
            this.f12535c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a(this.f12536g) != null) goto L5;
            return;
        L5:
            if (this.f12535c.get() == null) goto L9;
            ((View) this.f12535c.get()).getViewTreeObserver().removeOnGlobalLayoutListener(d.a(this.f12536g));
            return;
        }
    }

    public d() {
        this.f12525c = -1;
        this.f12529j = new Handler(Looper.getMainLooper());
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a(d r10) {
        return r10.f12527h;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener b(d r10, ViewTreeObserver.OnGlobalLayoutListener r11) {
        r10.f12527h = r11;
        return r11;
    }

    static /* synthetic */ Runnable c(d r10) {
        return r10.f12528i;
    }

    static /* synthetic */ Runnable d(d r10, Runnable r11) {
        r10.f12528i = r11;
        return r11;
    }

    static /* synthetic */ Handler e(d r10) {
        return r10.f12529j;
    }

    static /* synthetic */ long f(d r10) {
        return r10.f12525c;
    }

    static /* synthetic */ long g(d r10, long r11) {
        r10.f12525c = r11;
        return r11;
    }

    static /* synthetic */ long h(d r10) {
        return r10.f12530k;
    }

    static /* synthetic */ String i(d r10) {
        return r10.f12526g;
    }

    @TargetApi(16)
    private void j(Activity r10) {
        this.f12525c = System.currentTimeMillis();
        String r11 = r10.getClass().getCanonicalName();
        this.f12526g = r11;
        Integer r12 = t0.a.c(r11);
        if (r12 != null) goto L5;
        return;
    L5:
        WeakReference r13 = new WeakReference(r10.getWindow().getDecorView());
        this.f12527h = new a(this, r13, r12);
        ((View) r13.get()).getViewTreeObserver().addOnGlobalLayoutListener(this.f12527h);
        b r14 = new b(this, r13);
        this.f12528i = r14;
        this.f12529j.postDelayed(r14, this.f12530k);
    }

    public void k(long r10, boolean r11) {
        this.f12530k = r10;
        this.f12531l = r11;
        ActivityLifeObserver.getInstance().register(this);
    }

    @Override // t4.d
    public void onActivityCreated(Activity r10, Bundle r11) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return;
    L5:
        if (this.f12531l == false) goto L13;
        j(r10);     // Catch: Exception -> L9
        return;
    L14:
        return;
    }

    @Override // t4.d
    @TargetApi(16)
    public void onActivityPause(Activity r10) {
        this.f12525c = 0;
        if (this.f12527h == null) goto L6;
        r10.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f12527h);     // Catch: Exception -> L10
        this.f12527h = null;     // Catch: Exception -> L10
    L6:
        Runnable r11 = this.f12528i;     // Catch: Exception -> L10
        if (r11 == null) goto L13;
        this.f12529j.removeCallbacks(r11);     // Catch: Exception -> L10
        this.f12528i = null;     // Catch: Exception -> L10
        return;
    L13:
        return;
    }

    @Override // t4.d
    public void onActivityResume(Activity r10) {
    }

    @Override // t4.d
    public void onActivityStarted(Activity r10) {
    }

    @Override // t4.d
    public void onBackground(Activity r10) {
    }

    @Override // t4.d
    public void onChange(Activity r10, Fragment r11) {
    }

    @Override // t4.d
    public void onFront(Activity r10) {
    }
}
