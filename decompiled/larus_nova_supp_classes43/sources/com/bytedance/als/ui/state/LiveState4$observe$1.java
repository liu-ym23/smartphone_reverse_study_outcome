package com.bytedance.als.ui.state;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"A", "B", "C", "D", "Lcom/bytedance/als/ui/state/e;", "it", "", "invoke", "(Lcom/bytedance/als/ui/state/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class LiveState4$observe$1 extends Lambda implements Function1<e<Object, Object, Object, Object>, Unit> {
    final /* synthetic */ Function4 $callback;

    public LiveState4$observe$1(Function4 r1) {
        this.$callback = r1;
        super(1);
    }

    public final void invoke(e<Object, Object, Object, Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        Function4 r0 = this.$callback;
        r10.getClass();
        r0.invoke(null, null, null, null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((e) r1);
        return Unit.INSTANCE;
    }
}
