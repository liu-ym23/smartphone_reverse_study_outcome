package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0001\u0010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "OB", "Lio/reactivex/Observer;", "T", "invoke"}, k = 3, mv = {1, 4, 3})
final class RxUtilKt$asDisposable$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $doOnDispose;
    final /* synthetic */ Observer $this_asDisposable;

    public RxUtilKt$asDisposable$2(Observer r1, Function1 r2) {
        this.$this_asDisposable = r1;
        this.$doOnDispose = r2;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m622invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m622invoke() {
        this.$doOnDispose.invoke(this.$this_asDisposable);
    }
}
