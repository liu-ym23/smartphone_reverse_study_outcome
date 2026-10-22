package com.obric.oui.calendar;

import android.R;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f12261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public yq.b f12262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12263c;
    public final int d;
    public final int e;
    public final DecelerateInterpolator f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f12264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CalendarDay f12265i;

    public d0(TextView r5) {
        this.f12262b = yq.b.f23317n1;
        this.f = new DecelerateInterpolator(2.0f);
        this.g = 0;
        this.f12264h = 0;
        this.f12265i = null;
        this.f12261a = r5;
        Resources r10 = r5.getResources();
        this.f12263c = 400;
        this.d = r10.getInteger(R.integer.config_shortAnimTime) / 2;
        this.e = (int) TypedValue.applyDimension(1, 20.0f, r10.getDisplayMetrics());
    }

    public final void a(long r5, CalendarDay r10, boolean r11) {
        TextView r12 = this.f12261a;
        r12.animate().cancel();
        b(r12, 0);
        r12.setAlpha(1.0f);
        this.f12264h = r5;
        CharSequence r13 = this.f12262b.c(r10);
        if (r11 == true) goto L5;
        r12.setText(r13);
    L14:
        this.f12265i = r10;
        return;
    L5:
        CalendarDay r14 = this.f12265i;
        r14.getClass();
        if (r14.f12167a.isBefore(r10.f12167a) == false) goto L8;
        int r15 = 1;
    L9:
        int r16 = this.e * r15;
        ViewPropertyAnimator r17 = r12.animate();
        if (this.g != 1) goto L12;
        r17.translationX(r16 * (-1));
    L13:
        r17.alpha(0.0f).setDuration(this.d).setInterpolator(this.f).setListener(new c0(this, r13, r16)).start();
        goto L14
    L12:
        r17.translationY(r16 * (-1));
        goto L13
    L8:
        r15 = -1;
        goto L9
    }

    public final void b(TextView r5, int r10) {
        if (this.g != 1) goto L5;
        r5.setTranslationX(r10);
        return;
    L5:
        r5.setTranslationY(r10);
    }
}
