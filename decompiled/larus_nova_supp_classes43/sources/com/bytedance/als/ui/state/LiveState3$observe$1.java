package com.bytedance.als.ui.state;

import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "A", "B", "C", "it", "Lkotlin/Triple;", "invoke"}, k = 3, mv = {1, 4, 1})
final class LiveState3$observe$1 extends Lambda implements Function1<Triple<Object, Object, Object>, Unit> {
    final /* synthetic */ Function3 $callback;

    public LiveState3$observe$1(Function3 r1) {
        this.$callback = r1;
        super(1);
    }

    public final void invoke(Triple<Object, Object, Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        this.$callback.invoke(r10.getFirst(), r10.getSecond(), r10.getThird());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Triple) r1);
        return Unit.INSTANCE;
    }
}
