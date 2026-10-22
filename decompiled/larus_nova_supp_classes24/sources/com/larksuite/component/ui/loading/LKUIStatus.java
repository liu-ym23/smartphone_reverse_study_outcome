package com.larksuite.component.ui.loading;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LKUIStatus {
    public final ViewGroup a;
    public LKUILoadingView b;
    public TextView c;
    public ImageView d;
    public View e;
    public CharSequence f;
    public final CharSequence g;
    public final int h;
    public int i;
    public final float j;
    public final a k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    public class a implements Runnable {
        public final /* synthetic */ LKUIStatus a;

        @Override // java.lang.Runnable
        public final void run() {
            LKUIStatus r0 = this.a;     // Catch: Throwable -> L7
            if (r0.i != 3) goto L10;
            r0.e();     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }

        public a(LKUIStatus r1) {
            this.a = r1;
        }
    }

    public static class b {
        public final ViewGroup a;
        public CharSequence b;
        public CharSequence c;
        public int d;
        public float e;

        public b(ViewGroup r1) {
            this.a = r1;
        }
    }

    public final void a() {
        LottieAnimationView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
        this.b.cancelAnimation();
    L5:
        View r1 = this.e;
        if (r1 == null) goto L10;
        ViewParent r2 = r1.getParent();
        if (r2 == null) goto L10;
        ((ViewGroup) r2).removeView(this.e);
    L10:
        this.i = 1;
        this.a.removeCallbacks(this.k);
    }

    public final void b() {
        LottieAnimationView r0 = this.b;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
        this.b.cancelAnimation();
    L5:
        View r1 = this.e;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        this.i = 6;
        this.a.removeCallbacks(this.k);
    }

    public final void c() {
        if (this.e != null) goto L10;
        View r0 = LayoutInflater.from(this.a.getContext()).inflate(2131563564, null);
        this.e = r0;
        View r1 = r0.findViewById(2131378561);
        this.b = (LKUILoadingView) this.e.findViewById(2131378564);
        this.c = (TextView) this.e.findViewById(2131378563);
        this.d = (ImageView) this.e.findViewById(2131378562);
        ViewGroup r2 = this.a;
        float r3 = this.j;
        if (Boolean.TRUE.equals(null) == false) goto L7;
        long r4 = 250;
    L8:
        r2.postDelayed(new d08.a(r1, r3), r4);
        goto L10
    L7:
        r4 = 0;
    L10:
        if (this.e.getParent() != null) goto L12;
        ViewGroup.LayoutParams r5 = new ViewGroup.LayoutParams(-1, -1);
        this.a.addView(this.e, r5);
    L12:
        this.e.setBackgroundResource(2131100548);
    }

    public final void e() {
        CharSequence r0 = this.f;
        c();
        this.e.setVisibility(0);
        this.b.setVisibility(0);
        this.b.playAnimation();
        this.d.setVisibility(8);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        this.c.setVisibility(8);
    L6:
        this.i = 2;
        return;
    L5:
        this.c.setText(r0);
        this.c.setVisibility(0);
        goto L6
    }

    public LKUIStatus(b r2) {
        this.i = 1;
        this.j = -1.0f;
        this.k = new a(this);
        this.a = r2.a;
        this.f = r2.b;
        this.g = r2.c;
        this.h = r2.d;
        this.j = r2.e;
    }

    public final void d(CharSequence r4, int r5) {
        this.i = 4;
        this.a.removeCallbacks(this.k);
        c();
        this.e.setVisibility(0);
        this.b.setVisibility(8);
        this.b.cancelAnimation();
        this.d.setVisibility(0);
        this.d.setImageResource(r5);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.c.setVisibility(8);
        return;
    L5:
        this.c.setText(r4);
        this.c.setVisibility(0);
    }
}
