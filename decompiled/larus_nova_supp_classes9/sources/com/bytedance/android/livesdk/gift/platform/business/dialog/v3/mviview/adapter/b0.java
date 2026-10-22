package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ LazyMVIViewPagerAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ViewPager c;
    public final /* synthetic */ Function1 d;

    public b0(LazyMVIViewPagerAdapter r1, int r2, GiftViewPager r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        int r3 = this.a.getCount();     // Catch: Throwable -> L20
        int r4 = this.b;     // Catch: Throwable -> L20
        if (r4 < r3) goto L8;
        return;
    L8:
        if (r4 == this.c.getCurrentItem()) goto L11;
        jy0.b.a("GiftLazyViewPager", "检测页不是当前页，无需检测  position:" + this.b);     // Catch: Throwable -> L20
        return;
    L11:
        LazyMVIViewPagerAdapter r1 = this.a;     // Catch: Throwable -> L20
        int r5 = this.b;     // Catch: Throwable -> L20
        int r6 = LazyMVIViewPagerAdapter.m;     // Catch: Throwable -> L20
        if (r1.i.contains(Integer.valueOf(r5)) == true) goto L16;
        jy0.b.a("GiftLazyViewPager", "检测页不是占位页 " + this.b + "，无需检测 position:" + this.b);     // Catch: Throwable -> L20
        return;
    L16:
        if (this.a.g.containsKey(Integer.valueOf(this.b)) == true) goto L18;
        this.d.invoke(Integer.valueOf(this.b));     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(Boolean.valueOf(this.a.i.remove(Integer.valueOf(this.b))));     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
