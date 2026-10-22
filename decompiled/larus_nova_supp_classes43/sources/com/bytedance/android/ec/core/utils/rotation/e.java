package com.bytedance.android.ec.core.utils.rotation;

import android.animation.Animator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class e<T> {
    public List<? extends T> a;
    public long b;
    public long c;
    public boolean d;
    public Animator e;
    public Animator f;
    public final Handler g;
    public int h;
    public int i;

    public abstract Animator b(View r1);

    public abstract Animator c(View r1);

    public abstract View f(int r1);

    public void g() {
    }

    public abstract void i(int r1, T r10);

    public void a() {
        this.g.removeCallbacksAndMessages(null);
        Animator r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Animator r1 = this.f;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        if (this.a.isEmpty() == false) goto L6;
        return;
    L6:
        if ((this instanceof com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.b) == false) goto L8;
        this.h = -1;
        this.i = -1;
        f(0).setVisibility(8);
        f(1).setVisibility(8);
    L9:
        long r0 = this.b;
        b r10 = new b(this);
        this.g.postDelayed(r10, r0);
        return;
    L8:
        this.h = 0;
        this.i = 0;
        f(0).setVisibility(0);
        f(1).setVisibility(8);
        i(0, ListProtector.get(this.a, 0));
        goto L9
    }

    public e() {
        this.a = new ArrayList();
        this.g = new Handler(Looper.getMainLooper());
    }

    public long e() {
        return this.c;
    }

    public static void h(View r1) {
        Intrinsics.checkNotNullParameter(r1, "layout");
        r1.setAlpha(1.0f);
        r1.setTranslationX(0.0f);
        r1.setTranslationY(0.0f);
    }

    public int d(int r10) {
        int r11 = r10 + 1;
        if (r11 >= this.a.size()) goto L5;
        return r11;
    L5:
        if (this.d == true) goto L7;
        return -1;
    L7:
        return r11 % this.a.size();
    }
}
