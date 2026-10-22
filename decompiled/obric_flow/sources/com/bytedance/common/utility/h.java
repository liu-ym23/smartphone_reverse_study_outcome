package com.bytedance.common.utility;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3967c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public h(View r5, int r10, int r11, int r12, int r13) {
        this.f3965a = r5;
        this.f3966b = r10;
        this.f3967c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Rect r5 = new Rect();
        View r10 = this.f3965a;
        r10.getHitRect(r5);
        r5.top += this.f3966b;
        r5.bottom += this.f3967c;
        r5.left += this.d;
        r5.right += this.e;
        TouchDelegate r11 = new TouchDelegate(r5, r10);
        if (View.class.isInstance(r10.getParent()) == false) goto L6;
        ((View) r10.getParent()).setTouchDelegate(r11);
        return;
    }
}
