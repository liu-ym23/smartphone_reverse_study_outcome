package com.google.android.material.textfield;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f5072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f5073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f5074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f5075d;

    public n(m r8) {
        this.f5072a = r8.f5049a;
        this.f5073b = r8;
        this.f5074c = r8.getContext();
        this.f5075d = r8.f5055q;
    }

    public void a() {
    }

    public void b() {
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public View.OnFocusChangeListener e() {
        return null;
    }

    public View.OnClickListener f() {
        return null;
    }

    public View.OnFocusChangeListener g() {
        return null;
    }

    public k0.d h() {
        return null;
    }

    public boolean i(int r8) {
        return true;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return this instanceof l;
    }

    public boolean l() {
        return false;
    }

    public void m(EditText r8) {
    }

    public void n(k0.f r8) {
    }

    public void o(AccessibilityEvent r8) {
    }

    public void p(boolean r8) {
    }

    public final void q() {
        this.f5073b.f(false);
    }

    public void r() {
    }

    public void s() {
    }
}
