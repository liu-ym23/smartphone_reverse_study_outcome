package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedDispatcher;

/* JADX INFO: loaded from: classes.dex */
public class l extends Dialog implements androidx.lifecycle.m, w, z0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public androidx.lifecycle.n f491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0.b f492b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OnBackPressedDispatcher f493m;

    public l(Context r8, int r10) {
        he.i.f(r8, "context");
        super(r8, r10);
        this.f492b = z0.b.a.a(this);
        this.f493m = new OnBackPressedDispatcher(new k(this, 0));
    }

    public static void a(l r8) {
        he.i.f(r8, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.lifecycle.m
    public final androidx.lifecycle.h getLifecycle() {
        androidx.lifecycle.n r8 = this.f491a;
        if (r8 != null) goto L6;
        androidx.lifecycle.n r10 = new androidx.lifecycle.n(this);
        this.f491a = r10;
        return r10;
    L6:
        return r8;
    }

    @Override // androidx.activity.w
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f493m;
    }

    @Override // z0.c
    public final androidx.savedstate.a getSavedStateRegistry() {
        return this.f492b.f14170b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f493m.b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        OnBackInvokedDispatcher r10 = getOnBackInvokedDispatcher();
        he.i.e(r10, "onBackInvokedDispatcher");
        OnBackPressedDispatcher r11 = this.f493m;
        r11.getClass();
        r11.f454f = r10;
        r11.c(r11.f456h);
    L5:
        this.f492b.b(r8);
        androidx.lifecycle.n r12 = this.f491a;
        if (r12 != null) goto L8;
        r12 = new androidx.lifecycle.n(this);
        this.f491a = r12;
    L8:
        r12.f(androidx.lifecycle.h.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle r8 = super.onSaveInstanceState();
        he.i.e(r8, "super.onSaveInstanceState()");
        this.f492b.c(r8);
        return r8;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        androidx.lifecycle.n r8 = this.f491a;
        if (r8 != null) goto L5;
        r8 = new androidx.lifecycle.n(this);
        this.f491a = r8;
    L5:
        r8.f(androidx.lifecycle.h.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        androidx.lifecycle.n r8 = this.f491a;
        if (r8 != null) goto L5;
        r8 = new androidx.lifecycle.n(this);
        this.f491a = r8;
    L5:
        r8.f(androidx.lifecycle.h.a.ON_DESTROY);
        this.f491a = null;
        super.onStop();
    }
}
