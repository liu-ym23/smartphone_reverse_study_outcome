package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ n a;

    public r(n r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        n r7 = this.a;
        boolean r1 = true;
        r7.c++;
        h1 r0 = r7.a;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.gift.model.l r2 = r0.getComboHint();
    L6:
        if (r2 == null) goto L13;
        int r3 = (r2.curLeftGiftCount - r7.c) + 1;
        Iterator<com.bytedance.android.livesdk.gift.model.m> r4 = r2.dataList.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if (r3 != r4.next().leftGiftCount) goto L9;
    L20:
        if (r1 == false) goto L35;
        Disposable r8 = this.a.e;
        if (r8 == null) goto L24;
        r8.dispose();
    L24:
        Disposable r9 = this.a.d;
        if (r9 == null) goto L27;
        r9.dispose();
    L27:
        this.a.e = Observable.timer(1400, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new o(this), p.a, q.a);
        return;
    L35:
        return;
    L13:
        Iterator<com.bytedance.android.livesdk.gift.platform.core.model.e> r10 = GiftManagerKt.s().iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        if (r7.c != r10.next().comboCount) goto L15;
    L19:
        r1 = false;
        goto L20
    L5:
        r2 = null;
        goto L6
    }
}
