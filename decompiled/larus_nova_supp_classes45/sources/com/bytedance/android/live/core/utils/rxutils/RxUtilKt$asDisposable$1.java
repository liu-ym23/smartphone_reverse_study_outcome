package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0001\u0010\u0004*\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "OB", "Lio/reactivex/Observer;", "T", "invoke", "(Lio/reactivex/Observer;)V"}, k = 3, mv = {1, 4, 3})
final class RxUtilKt$asDisposable$1 extends Lambda implements Function1 {
    public static final RxUtilKt$asDisposable$1 INSTANCE = null;

    static {
        INSTANCE = new RxUtilKt$asDisposable$1();
    }

    public RxUtilKt$asDisposable$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Observer) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Observer r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
    }
}
