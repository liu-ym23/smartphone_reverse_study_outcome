package com.bytedance.als.ui.state;

import com.bytedance.als.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 1})
final class LiveState$observe$lambda$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Observer $observer;

    public LiveState$observe$lambda$1(Observer r1) {
        this.$observer = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m40invoke(r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m40invoke(Object r10) {
        this.$observer.onChanged(r10);
    }
}
