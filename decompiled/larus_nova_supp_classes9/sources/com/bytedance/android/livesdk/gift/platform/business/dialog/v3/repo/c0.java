package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c0 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.i b;
    public final i0 c;

    public final void onStart() {
    }

    public final void onStop() {
        this.a.clear();
    }

    public c0(com.bytedance.android.livesdk.gift.platform.core.giftlist.i r2, i0 r3) {
        Intrinsics.checkNotNullParameter(r2, "giftListRepository");
        Intrinsics.checkNotNullParameter(r3, "giftReceiverService");
        this.b = r2;
        this.c = r3;
        this.a = new CompositeDisposable();
    }
}
