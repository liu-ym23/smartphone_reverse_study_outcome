package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.ObjectAnimator;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ i a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ ObjectAnimator c;

    public j(i r1, Ref.IntRef r2, ObjectAnimator r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        Ref.IntRef r4 = this.b;
        int r0 = r4.element + 1;
        r4.element = r0;
        if (r0 <= 2) goto L7;
        Disposable r5 = this.a.r;
        if (r5 == null) goto L9;
        r5.dispose();
        return;
    L9:
        return;
    L7:
        this.c.start();
    }
}
