package com.facebook.drawee.view;

import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaserConcurrentImpl;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes2.dex */
public class DraweeHolder<DH extends DraweeHierarchy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7938c;
    public DraweeHierarchy d;
    public DraweeController e;
    public final DraweeEventTracker f;

    public DraweeHolder(DraweeHierarchy r5) {
        this.f7936a = false;
        this.f7937b = false;
        this.f7938c = true;
        this.e = null;
        if (DraweeEventTracker.f7755c == false) goto L5;
        DraweeEventTracker r10 = new DraweeEventTracker();
    L6:
        this.f = r10;
        if (r5 == null) goto L10;
        a(r5);
        return;
    L10:
        return;
    L5:
        r10 = DraweeEventTracker.f7754b;
        goto L6
    }

    public final void a(DraweeController r5) {
        boolean r10 = this.f7936a;
        if (r10 == false) goto L6;
        c();
    L6:
        if (e() == false) goto L8;
        this.f.a(DraweeEventTracker.Event.d);
        ((PipelineDraweeController) this.e).a(null);
    L8:
        this.e = r5;
        if (r5 == null) goto L11;
        this.f.a(DraweeEventTracker.Event.f7759c);
        DraweeController r11 = this.e;
        PipelineDraweeController r12 = (PipelineDraweeController) r11;
        r12.a(this.d);
    L12:
        if (r10 == false) goto L15;
        a();
        return;
    L15:
        return;
    L11:
        this.f.a(DraweeEventTracker.Event.e);
        goto L12
    }

    public final void b() {
        if (this.f7937b == true) goto L5;
    L8:
        c();
        return;
    L5:
        if (this.f7938c == false) goto L8;
        a();
    }

    public final void c() {
        if (this.f7936a == false) goto L35;
        DraweeEventTracker r5 = this.f;
        DraweeEventTracker.Event r10 = DraweeEventTracker.Event.f7760h;
        r5.a(r10);
        boolean r11 = false;
        this.f7936a = false;
        if (e() == false) goto L31;
        AbstractDraweeController r12 = (AbstractDraweeController) this.e;
        r12.getClass();
        FrescoSystrace.a().getClass();
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L10;
        FLog.a(AbstractDraweeController.f7774v, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(r12)), r12.f7778h);
    L10:
        r12.f7775a.a(r10);
        r12.f7780j = false;
        DeferredReleaserConcurrentImpl r13 = r12.f7776b;
        r13.getClass();
        if (DeferredReleaser.a() == true) goto L13;
        r12.release();
    L27:
        FrescoSystrace.a().getClass();
        return;
    L13:
        Object r14 = r13.f7751b;
        monitor-enter(r14);
    L19:
        th = move-exception;
        throw th;
    L16:
        if (r13.d.contains(r12) == false) goto L21;
        monitor-exit(r14);     // Catch: Throwable -> L19
    L32:
        goto L27
    L21:
        r13.d.add(r12);     // Catch: Throwable -> L19
        if (r13.d.size() != 1) goto L24;
        r11 = true;
    L24:
        monitor-exit(r14);     // Catch: Throwable -> L19
        if (r11 == false) goto L32;
        r13.f7752c.post(r13.f);
        goto L32
    L31:
        return;
    }

    public Drawable d() {
        DraweeHierarchy r5 = this.d;
        if (r5 != null) goto L7;
        return null;
    L7:
        return ((GenericDraweeHierarchy) r5).e;
    }

    public final boolean e() {
        DraweeController r5 = this.e;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (((AbstractDraweeController) r5).f != this.d) goto L10;
        return true;
    L10:
        return false;
    }

    public void f() {
        this.f.a(DraweeEventTracker.Event.f7767o);
        this.f7937b = true;
        b();
    }

    public void g() {
        this.f.a(DraweeEventTracker.Event.f7768p);
        this.f7937b = false;
        b();
    }

    public final String toString() {
        return new Objects.ToStringHelper(getClass().getSimpleName()).a("controllerAttached", String.valueOf(this.f7936a)).a("holderAttached", String.valueOf(this.f7937b)).a("drawableVisible", String.valueOf(this.f7938c)).a("events", this.f.f7756a.toString()).toString();
    }

    public final void a(DraweeHierarchy r5) {
        this.f.a(DraweeEventTracker.Event.f7757a);
        boolean r10 = e();
        Object r11 = d();
        if ((r11 instanceof VisibilityAwareDrawable) == false) goto L5;
        ((RootDrawable) ((VisibilityAwareDrawable) r11)).e = null;
    L5:
        r5.getClass();
        this.d = r5;
        RootDrawable r12 = ((GenericDraweeHierarchy) r5).e;
        if (r12 != null) goto L8;
    L11:
        boolean r13 = true;
    L13:
        if (this.f7938c == r13) goto L20;
        DraweeEventTracker r14 = this.f;
        if (r13 == false) goto L18;
        DraweeEventTracker.Event r15 = DraweeEventTracker.Event.f7769q;
    L19:
        r14.a(r15);
        this.f7938c = r13;
        b();
        goto L20
    L18:
        r15 = DraweeEventTracker.Event.f7770r;
    L20:
        Object r16 = d();
        if ((r16 instanceof VisibilityAwareDrawable) == false) goto L23;
        ((RootDrawable) ((VisibilityAwareDrawable) r16)).e = this;
    L23:
        if (r10 == false) goto L26;
        ((PipelineDraweeController) this.e).a(r5);
        return;
    L26:
        return;
    L8:
        if (r12.isVisible() == true) goto L11;
        r13 = false;
        goto L13
    }

    public final void a() {
        if (this.f7936a == true) goto L23;
        DraweeEventTracker r5 = this.f;
        DraweeEventTracker.Event r10 = DraweeEventTracker.Event.g;
        r5.a(r10);
        this.f7936a = true;
        DraweeController r11 = this.e;
        if (r11 == null) goto L21;
        AbstractDraweeController r12 = (AbstractDraweeController) r11;
        if (r12.f == null) goto L22;
        FrescoSystrace.a().getClass();
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L16;
        Class r13 = AbstractDraweeController.f7774v;
        Integer r14 = Integer.valueOf(System.identityHashCode(r12));
        String r15 = r12.f7778h;
        if (r12.f7781k == false) goto L14;
        String r16 = "request already submitted";
    L15:
        FLog.a(r13, "controller %x %s: onAttach: %s", r14, r15, r16);
        goto L16
    L14:
        r16 = "request needs submit";
    L16:
        r12.f7775a.a(r10);
        r12.f.getClass();
        r12.f7776b.a(r12);
        r12.f7780j = true;
        if (r12.f7781k == true) goto L19;
        r12.e();
    L19:
        FrescoSystrace.a().getClass();
        return;
    L22:
        return;
    L21:
        return;
    }
}
