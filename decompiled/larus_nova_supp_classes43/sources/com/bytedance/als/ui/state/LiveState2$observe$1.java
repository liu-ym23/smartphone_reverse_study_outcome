package com.bytedance.als.ui.state;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "A", "B", "it", "Lkotlin/Pair;", "invoke"}, k = 3, mv = {1, 4, 1})
final class LiveState2$observe$1 extends Lambda implements Function1<Pair<Object, Object>, Unit> {
    final /* synthetic */ Function2 $callback;

    public LiveState2$observe$1(Function2 r1) {
        this.$callback = r1;
        super(1);
    }

    public final void invoke(Pair<Object, Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        this.$callback.invoke(r10.getFirst(), r10.getSecond());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Pair) r1);
        return Unit.INSTANCE;
    }
}
