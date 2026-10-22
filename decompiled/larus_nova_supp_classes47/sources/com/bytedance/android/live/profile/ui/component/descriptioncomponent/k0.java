package com.bytedance.android.live.profile.ui.component.descriptioncomponent;

import com.bytedance.android.live.room.api.view.SimpleIndicatorTextSwitcher;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0<T> implements Consumer {
    public final /* synthetic */ l0.a a;

    public k0(l0.a r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        SimpleIndicatorTextSwitcher r4 = this.a.a.e;
        if (r4 == null) goto L5;
        r4.showNext();
    L5:
        Disposable r5 = this.a.a.k;
        if (r5 != null) goto L8;
        return;
    L8:
        if ((!r5.isDisposed()) == true) goto L11;
        r5 = null;
    L11:
        if (r5 == null) goto L15;
        r5.dispose();
        return;
    }
}
