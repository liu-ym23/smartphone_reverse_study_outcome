package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d0 implements Observer<Long> {
    public final /* synthetic */ GiftMVIGroupView a;
    public final /* synthetic */ Ref.IntRef b;

    public final void onComplete() {
        this.a.t();
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        this.a.t();
    }

    public final void onNext(Object r4) {
        ((Number) r4).longValue();
        GiftMVIGroupView r5 = this.a;
        int r0 = this.b.element;
        if (r5.u().getAdapter() == null) goto L11;
        RecyclerView.ViewHolder r1 = r5.u().findViewHolderForAdapterPosition(r0);
        if (r1 == null) goto L10;
        View r2 = r1.itemView;
        if (r2 == null) goto L10;
        r5.r.e(r2);
    L10:
        r5.q = false;
        r5.t();
    L11:
        Ref.IntRef r6 = this.b;
        int r3 = r6.element + 1;
        r6.element = r3;
        if (r3 <= 5) goto L15;
        GiftMVIGroupView r7 = this.a;
        r7.q = false;
        r7.t();
        return;
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.p = r2;
    }

    public d0(GiftMVIGroupView r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
