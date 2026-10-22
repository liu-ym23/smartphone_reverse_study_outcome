package com.bytedance.ies.bullet.base.utils.keyboard;

import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f5241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f5242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f5243c;
    public final /* synthetic */ Function1 d;

    public b(Window r5, Ref.BooleanRef r10, Ref.BooleanRef r11, Function1 r12) {
        this.f5241a = r5;
        this.f5242b = r10;
        this.f5243c = r11;
        this.d = r12;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        WindowInsetsCompat r5 = ViewCompat.getRootWindowInsets(this.f5241a.getDecorView());
        if (r5 != null) goto L5;
        return;
    L5:
        boolean r10 = r5.isVisible(WindowInsetsCompat.Type.ime());
        Function1 r11 = this.d;
        Ref.BooleanRef r12 = this.f5242b;
        Ref.BooleanRef r13 = this.f5243c;
        if (r10 == false) goto L14;
        r12.element = true;
        if (r13.element == true) goto L11;
        if (r11 == null) goto L11;
        r11.invoke(Boolean.TRUE);
    L11:
        r13.element = true;
        return;
    L14:
        if (r13.element == true) goto L16;
    L19:
        r13.element = false;
        return;
    L16:
        if (r12.element == false) goto L19;
        if (r11 == null) goto L19;
        r11.invoke(Boolean.FALSE);
        goto L19
    }
}
