package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements Observer<Long> {
    public final /* synthetic */ NormalGiftCombViewV2 a;
    public final /* synthetic */ NormalGiftMessage b;

    public final void onComplete() {
        Disposable r0 = this.a.J;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        Disposable r3 = this.a.J;
        if (r3 == null) goto L6;
        r3.dispose();
        return;
    }

    public final void onNext(Object r7) {
        long r0 = ((Number) r7).longValue();
        NormalGiftCombViewV2 r8 = this.a;
        NormalGiftMessage r2 = this.b;
        if (r0 == 0) goto L5;
        boolean r1 = true;
    L6:
        int r3 = NormalGiftCombViewV2.W;
        r8.B(r2, r1);
        NormalGiftCombViewV2 r9 = this.a;
        int r4 = r9.I - 1;
        r9.I = r4;
        if (r4 > 0) goto L12;
        Disposable r10 = r9.J;
        if (r10 == null) goto L13;
        r10.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        Disposable r0 = this.a.J;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a.J = r2;
    }

    public f(NormalGiftCombViewV2 r1, NormalGiftMessage r2) {
        this.a = r1;
        this.b = r2;
    }
}
