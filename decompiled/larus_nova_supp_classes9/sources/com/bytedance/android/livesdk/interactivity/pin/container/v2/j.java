package com.bytedance.android.livesdk.interactivity.pin.container.v2;

import com.bytedance.android.livesdk.interactivity.pin.ui.HighlightViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements Runnable {
    public final /* synthetic */ PinWidget a;
    public final /* synthetic */ HighlightViewPager b;

    public j(PinWidget r1, HighlightViewPager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        PinWidget.AnonymousClass1 r0 = this.a.g;
        if (r0 == null) goto L5;
        r0.onPageSelected(this.b.getCurrentItem());
    L5:
        this.b.setBackground(this.a.f);
        o92.b r1 = this.a.h;
        if (r1 == null) goto L12;
        Disposable r2 = r1.a;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        r1.a = null;
        r1.a = Observable.interval(r1.c, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new o92.a(r1));
        return;
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
