package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.presenter;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import yz0.h;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiPkLaunchPresenter extends q46.b<a> {
    public final l b;
    public final CompositeDisposable c;

    public interface a extends q46.a {
    }

    public final void detachView() {
        ((q46.b) this).a = null;
        this.c.clear();
    }

    public MultiPkLaunchPresenter() {
        this.b = (l) f.d(j.C0.a(), l.class);
        this.c = new CompositeDisposable();
    }

    public final void c0(a r4) {
        ((q46.b) this).a = r4;
        l r5 = this.b;
        if (r5 == null) goto L10;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r6 = h.a.a(r5, com.bytedance.android.live.revenue.common.message.b.b, false, 6);
        if (r6 == null) goto L11;
        final MultiPkLaunchPresenter$attachView$1 r0 = new MultiPkLaunchPresenter$attachView$1(this);
        Disposable r7 = r6.subscribe(new b(r0));
        if (r7 == null) goto L12;
        RxUtilKt.c(r7, this.c);
        return;
    L12:
        return;
    L11:
        return;
    }
}
