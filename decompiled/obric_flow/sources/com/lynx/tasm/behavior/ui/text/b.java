package com.lynx.tasm.behavior.ui.text;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f10704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AndroidText f10706c;

    public b(AndroidText r5, float r10, float r11) {
        this.f10706c = r5;
        this.f10704a = r10;
        this.f10705b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AndroidText r5 = this.f10706c;
        AndroidText.access$002(r5, true);
        PointF r10 = AndroidText.access$100(r5);
        float r11 = this.f10704a;
        float r12 = this.f10705b;
        r10.set(r11, r12);
        AndroidText.access$200(r5).set(r11, r12);
        AndroidText.access$302(r5, AndroidText.access$402(r5, AndroidText.access$500(r5, r11, r12)));
        AndroidText.access$602(r5, true);
        r5.requestDisallowInterceptTouchEvent(true);
        AndroidText.access$702(r5, null);
    }
}
