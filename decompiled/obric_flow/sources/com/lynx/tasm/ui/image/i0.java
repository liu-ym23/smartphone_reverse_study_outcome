package com.lynx.tasm.ui.image;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i0 implements DeferredReleaser.Releasable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f11054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UiThreadImmediateExecutorService f11055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f11056c;
    public volatile boolean d;
    public volatile boolean e;
    public boolean f;
    public volatile DataSource g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f11057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Drawable f11058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f11059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BaseControllerListener f11060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SettableDraweeHierarchy f11061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WeakReference f11062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f11063n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f11064o;

    public i0(b r5, UiThreadImmediateExecutorService r10) {
        this.f11059j = true;
        this.f11054a = r5;
        this.f11055b = r10;
        this.f11056c = false;
        a();
        this.f = false;
        this.f11060k = null;
        if (this.f11061l == null) goto L5;
        this.f11061l = null;
    L5:
        this.f11064o = null;
    }

    public final void a() {
        boolean r5 = this.d;
        this.d = false;
        this.e = false;
        DataSource r10 = this.g;
        this.g = null;
        com.lynx.tasm.utils.j.f(new v(1, this, r10));
        if (r5 == false) goto L9;
        BaseControllerListener r11 = this.f11060k;
        if (r11 != null) goto L7;
        r11 = BaseControllerListener.f7804a;
    L7:
        r11.a(this.f11064o);
        return;
    }

    public final void b(ControllerListener r5) {
        BaseControllerListener r10 = this.f11060k;
        if ((r10 instanceof h0) == false) goto L12;
        h0 r11 = (h0) r10;
        monitor-enter(r11);
        r11.f7805b.add(r5);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        if (r10 == null) goto L22;
        BaseControllerListener r12 = (BaseControllerListener) r5;
        h0 r13 = new h0();
        monitor-enter(r13);
        r13.f7805b.add(r10);     // Catch: Throwable -> L19
        monitor-exit(r13);     // Catch: Throwable -> L19
        r13.a(r12);
        this.f11060k = r13;
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        this.f11060k = (BaseControllerListener) r5;
    }

    public final void c(String r5, DataSource r10, Throwable r11, boolean r12) {
        if (e(r5, r10) == true) goto L7;
        r10.close();
        return;
    L7:
        if (d(r10, null) == true) goto L9;
        return;
    L9:
        if (r12 == false) goto L27;
        this.g = null;
        this.e = true;
        SettableDraweeHierarchy r13 = this.f11061l;
        if (r13 != null) goto L13;
    L22:
        BaseControllerListener r14 = this.f11060k;
        if (r14 != null) goto L25;
        r14 = BaseControllerListener.f7804a;
    L25:
        r14.b(this.f11064o, r11);
        return;
    L13:
        if (this.f == false) goto L17;
        Drawable r15 = this.f11058i;
        if (r15 == null) goto L17;
        ((GenericDraweeHierarchy) r13).a(r15, 1.0f, true);
    L17:
        GenericDraweeHierarchy r16 = (GenericDraweeHierarchy) r13;
        r16.f.f7846q++;
        r16.a();
        if (r16.f.a(5) == null) goto L20;
        r16.f.c(5);
    L21:
        r16.f.a();
        goto L22
    L20:
        r16.f.c(1);
        goto L21
    L27:
        BaseControllerListener r17 = this.f11060k;
        if (r17 != null) goto L30;
        r17 = BaseControllerListener.f7804a;
    L30:
        r17.a(this.f11064o, r11);
    }

    public final boolean d(DataSource r5, Object r10) {
        WeakReference r11 = this.f11062m;
        if (r11 == null) goto L14;
        FlattenUIImage r12 = (FlattenUIImage) r11.get();
        if (r12 != null) goto L7;
        return true;
    L7:
        if (TextUtils.equals(r12.getSource(), this.f11063n) == true) goto L17;
        if (r10 == null) goto L10;
        f(r10);
    L10:
        if (r5 == null) goto L12;
        r5.close();
    L12:
        StringBuilder r13 = new StringBuilder("image check failed curUrl = ");
        r13.append(r12.getSource());
        r13.append(" preUrl = ");
        com.lynx.tasm.behavior.ui.utils.e.i(r13, this.f11063n, 2, "LynxImage");
        return false;
    L17:
        return true;
    L14:
        return true;
    }

    public final boolean e(String r5, DataSource r10) {
        if (r10 != null) goto L8;
        if (this.g != null) goto L8;
        return true;
    L8:
        if (r5.equals(this.f11064o) == true) goto L10;
        return false;
    L10:
        if (r10 == this.g) goto L12;
        return false;
    L12:
        if (this.d == false) goto L17;
        return true;
    L17:
        return false;
    }

    public abstract void f(Object r5);

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public final void release() {
        a();
    }

    public String toString() {
        Objects.ToStringHelper r5 = new Objects.ToStringHelper(getClass().getSimpleName()).a("isAttached", String.valueOf(this.f11056c)).a("isRequestSubmitted", String.valueOf(this.d)).a("hasFetchFailed", String.valueOf(this.e));
        CloseableReference r10 = (CloseableReference) this.f11057h;
        if (r10 == null) goto L12;
        monitor-enter(r10);
        boolean r11 = r10.f7670a;     // Catch: Throwable -> L9
        monitor-exit(r10);
        if (r11 == true) goto L12;
        int r12 = System.identityHashCode(r10.f7671b.d());
    L14:
        return r5.a("fetchedImage", String.valueOf(r12)).toString();
    L9:
        th = move-exception;
        throw th;
    L12:
        r12 = 0;
        goto L14
    }
}
