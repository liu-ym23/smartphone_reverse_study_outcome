package com.larus.camera.impl.ui.arch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.camera.impl.ui.base.BaseCameraViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tx8.d;
import tx8.e;
import tx8.f;
import tx8.g;
import tx8.h;
import tx8.i;
import tx8.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class b implements d {
    public final int a;
    public final c b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public Lifecycle h;
    public CoroutineScope i;
    public a j;
    public View k;
    public final String l;

    public static final class a {
        public final ViewModel a;

        public final <T extends ViewModel> T a() {
            T r0 = (T) this.a;
            if ((r0 instanceof ViewModel) == true) goto L7;
            return null;
        L7:
            return r0;
        }

        public a(BaseCameraViewModel r2) {
            Intrinsics.checkNotNullParameter(r2, "viewModel");
            this.a = r2;
        }
    }

    public b() {
        this(null, 3);
    }

    public abstract View g(LayoutInflater r1, ViewGroup r2);

    public abstract void m();

    public void n() {
    }

    public final Context getContext() {
        return (Context) this.f.getValue();
    }

    public final Lifecycle i() {
        return (Lifecycle) this.c.getValue();
    }

    public final View j() {
        return (View) this.g.getValue();
    }

    public final CoroutineScope k() {
        return (CoroutineScope) this.d.getValue();
    }

    public final void l() {
        View r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r0 = null;
    L5:
        r0.setVisibility(8);
    }

    public final void o() {
        View r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r0 = null;
    L5:
        r0.setVisibility(0);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    @Override // tx8.d
    public final String getId() {
        return this.l;
    }

    @Override // tx8.d
    public final c getPriority() {
        return this.b;
    }

    public static final a e(b r0) {
        return (a) r0.e.getValue();
    }

    @Override // tx8.d
    public final void a(CameraContainer r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        r4.getClass();
        View r0 = this.k;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r0 = null;
    L5:
        r4.removeView(r0);
        View r2 = this.k;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L9:
        r4.addView(r1);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    @Override // tx8.d
    public final void c(CameraContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        r2.getClass();
        View r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r0 = null;
    L5:
        r2.removeView(r0);
        n();
    }

    public CameraContainer.b f(int r3) {
        CameraContainer.b r0 = new CameraContainer.b(-2, -2);
        ((FrameLayout.LayoutParams) r0).gravity = r3;
        return r0;
    }

    public final <T extends View> T h(int r2) {
        View r0 = this.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r0 = null;
    L6:
        return (T) r0.findViewById(r2);
    }

    public b(int r2, c r3) {
        Intrinsics.checkNotNullParameter(r3, "priority");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new f(this));
        this.d = LazyKt.lazy(new g(this));
        this.e = LazyKt.lazy(new h(this));
        this.f = LazyKt.lazy(new i(this));
        this.g = LazyKt.lazy(new j(this));
        this.l = getClass().getName();
    }

    public b(c r2, int r3) {
        if ((r3 & 1) == 0) goto L5;
        int r0 = 17;
    L7:
        if ((r3 & 2) == 0) goto L9;
        r2 = c.b;
    L9:
        this(r0, r2);
        return;
    L5:
        r0 = 0;
        goto L7
    }

    @Override // tx8.d
    public final void b(BaseCameraViewModel r2, e r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        this.j = new a(r2);
        this.h = r4.getLifecycle();
        this.i = ViewModelKt.getViewModelScope(r2);
        CameraContainer r5 = r3.asView();
        this.k = g(LayoutInflater.from(r5.getContext()), r5);
        CameraContainer.b r6 = f(this.a);
        View r7 = this.k;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r7 = null;
    L5:
        r5.addView(r7, r6);
        m();
    }
}
