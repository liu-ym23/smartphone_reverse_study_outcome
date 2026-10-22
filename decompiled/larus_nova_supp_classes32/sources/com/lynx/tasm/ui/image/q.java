package com.lynx.tasm.ui.image;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class q<T, INFO> implements DeferredReleaser.Releasable {
    public final com.lynx.tasm.ui.image.a a;
    public final Executor b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;
    public boolean f;
    public volatile DataSource<T> g;
    public T h;
    public Drawable i;
    public boolean j;
    public ControllerListener<INFO> k;
    public SettableDraweeHierarchy l;
    public WeakReference<FlattenUIImage> m;
    public String n;
    public String o;
    public Object p;

    public class a implements Runnable {
        public final /* synthetic */ DataSource a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ q c;

        @Override // java.lang.Runnable
        public final void run() {
            DataSource r0 = this.a;     // Catch: Throwable -> L14
            if (r0 == null) goto L5;
            r0.close();     // Catch: Throwable -> L14
        L5:
            Object r1 = this.b;     // Catch: Throwable -> L14
            q r2 = this.c;     // Catch: Throwable -> L14
            if (r1 != r2.h) goto L17;
            Drawable r3 = r2.i;     // Catch: Throwable -> L14
            if (r3 == null) goto L10;
            r2.k(r3);     // Catch: Throwable -> L14
        L10:
            r2.i = null;     // Catch: Throwable -> L14
            T r4 = r2.h;     // Catch: Throwable -> L14
            if (r4 == null) goto L21;
            r2.m(r4);     // Catch: Throwable -> L14
            r2.h = null;     // Catch: Throwable -> L14
            return;
        L21:
            return;
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }

        public a(q r1, DataSource r2, Object r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public static class b<INFO> extends ForwardingControllerListener<INFO> {
        public b() {
        }
    }

    public abstract Drawable c(T r1);

    public abstract DataSource<T> e();

    public abstract INFO g(T r1);

    public abstract void k(Drawable r1);

    public abstract void m(T r1);

    public final ControllerListener<INFO> d() {
        ControllerListener<INFO> r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return BaseControllerListener.getNoOpListener();
    }

    public final void l() {
        boolean r0 = this.d;
        this.d = false;
        this.e = false;
        DataSource<T> r1 = this.g;
        this.g = null;
        UIThreadUtils.runOnUiThreadImmediately(new a(this, r1, this.h));
        if (r0 == false) goto L6;
        d().onRelease(this.o);
        return;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("isAttached", this.c).add("isRequestSubmitted", this.d).add("hasFetchFailed", this.e).add("fetchedImage", f(this.h)).toString();
    }

    public final void release() {
        l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ControllerListener<? super INFO> r3) {
        b r0 = this.k;
        if ((r0 instanceof b) == false) goto L6;
        r0.addListener(r3);
        return;
    L6:
        if (r0 == null) goto L9;
        b r1 = new b();
        r1.addListener(r0);
        r1.addListener(r3);
        this.k = r1;
        return;
    L9:
        this.k = r3;
    }

    public int f(T r1) {
        return System.identityHashCode(r1);
    }

    public final void n(DraweeHierarchy r2) {
        if (this.d == false) goto L6;
        this.a.a.remove(this);
        l();
    L6:
        if (this.l == null) goto L8;
        this.l = null;
    L8:
        if (r2 == null) goto L11;
        Preconditions.checkArgument(r2 instanceof SettableDraweeHierarchy);
        this.l = (SettableDraweeHierarchy) r2;
        return;
    }

    public q(com.lynx.tasm.ui.image.a r2, HandlerExecutorServiceImpl r3) {
        this.j = true;
        this.a = r2;
        this.b = r3;
        h(null, null);
    }

    public final boolean b(DataSource<T> r4, T r5) {
        WeakReference<FlattenUIImage> r0 = this.m;
        if (r0 == null) goto L14;
        FlattenUIImage r1 = r0.get();
        if (r1 != null) goto L7;
        return true;
    L7:
        if (TextUtils.equals(r1.getSource(), this.n) == true) goto L17;
        if (r5 == null) goto L10;
        m(r5);
    L10:
        if (r4 == null) goto L12;
        r4.close();
    L12:
        LLog.i("LynxImage", "image check failed curUrl = " + r1.getSource() + " preUrl = " + this.n);
        return false;
    L17:
        return true;
    L14:
        return true;
    }

    public final void h(String r3, Object r4) {
        if (this.j == true) goto L7;
        com.lynx.tasm.ui.image.a r0 = this.a;
        if (r0 == null) goto L7;
        r0.a.remove(this);
    L7:
        this.c = false;
        l();
        this.f = false;
        this.k = null;
        if (this.l == null) goto L10;
        this.l = null;
    L10:
        this.o = r3;
        this.p = r4;
    }

    public final boolean i(String r3, DataSource<T> r4) {
        if (r4 != null) goto L8;
        if (this.g != null) goto L8;
        return true;
    L8:
        if (r3.equals(this.o) == true) goto L10;
    L14:
        return false;
    L10:
        if (r4 != this.g) goto L14;
        if (this.d == false) goto L14;
        return true;
    }

    public final void j(String r2, DataSource<T> r3, Throwable r4, boolean r5) {
        if (i(r2, r3) == true) goto L7;
        r3.close();
        return;
    L7:
        if (b(r3, null) == true) goto L9;
        return;
    L9:
        if (r5 == false) goto L19;
        this.g = null;
        this.e = true;
        SettableDraweeHierarchy r6 = this.l;
        if (r6 != null) goto L13;
    L18:
        d().onFailure(this.o, r4);
        return;
    L13:
        if (this.f == false) goto L17;
        Drawable r7 = this.i;
        if (r7 == null) goto L17;
        r6.setImage(r7, 1.0f, true);
    L17:
        r6.setFailure(r4);
        goto L18
    L19:
        d().onIntermediateImageFailed(this.o, r4);
    }
}
