package com.bytedance.android.live.revlink.impl.multianchor.network;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public IBattleConfigSetting a;
    public final CompositeDisposable b;
    public a c;
    public yz0.l d;

    public f() {
        this.b = new CompositeDisposable();
    }

    public final void a(j21.k r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.c = r4;
        yz0.l r5 = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.d = r5;
        if (r5 == null) goto L10;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        Observable r6 = yz0.h.a.a(r5, com.bytedance.android.live.revenue.common.message.b.b, false, 6);
        if (r6 == null) goto L11;
        final MultiAnchorPkPanelIMWatcher$attach$1 r0 = new MultiAnchorPkPanelIMWatcher$attach$1(this);
        Disposable r7 = r6.subscribe(new e(r0));
        if (r7 == null) goto L12;
        RxUtilKt.c(r7, this.b);
        return;
    L12:
        return;
    L11:
        return;
    }
}
