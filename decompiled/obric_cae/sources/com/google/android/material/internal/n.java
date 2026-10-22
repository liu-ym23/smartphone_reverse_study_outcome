package com.google.android.material.internal;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import j0.h0;
import j0.n0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f4889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4890b;

    public /* synthetic */ n(View r8) {
        this.f4889a = r8;
        this.f4890b = false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r8 = this.f4890b;
        View r10 = this.f4889a;
        if (r8 == false) goto L12;
        WeakHashMap<View, h0> r11 = w.f8437a;
        n0 r12 = w.n.b(r10);
        if (r12 == null) goto L12;
        n0.a r13 = r12.f8429a;
        Window r14 = r13.f8431b;
        if (r14 != null) goto L9;
    L11:
        r13.f8430a.show(8);
        return;
    L9:
        if (Build.VERSION.SDK_INT >= 32) goto L11;
        ((InputMethodManager) r14.getContext().getSystemService("input_method")).isActive();
    L12:
        Context r15 = r10.getContext();
        Object r16 = androidx.core.content.a.f1674a;
        ((InputMethodManager) androidx.core.content.a.c.b(r15, InputMethodManager.class)).showSoftInput(r10, 1);
    }
}
