package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayUtilsKt$completableDeferUntilMeasured$1 implements CompletableOnSubscribe {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ View b;

    public XplayUtilsKt$completableDeferUntilMeasured$1(Function0 r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(final CompletableEmitter r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        final CompositeDisposable r0 = new CompositeDisposable();
        r4.setDisposable(r0);
        a r1 = new a(new XplayUtilsKt$completableDeferUntilMeasured$1$runnable$1(this, r0, r4));
        RxUtilKt.c(r1, r0);
        this.b.post(r1);
    }
}
