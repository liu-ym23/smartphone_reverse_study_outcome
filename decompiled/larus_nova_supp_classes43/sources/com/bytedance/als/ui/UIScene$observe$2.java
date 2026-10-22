package com.bytedance.als.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "STATE", "", "ACTION", "it", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 4, 1})
final class UIScene$observe$2 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1 $observer;

    public UIScene$observe$2(Function1 r1) {
        this.$observer = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m33invoke(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        this.$observer.invoke(r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m33invoke(r1);
        return Unit.INSTANCE;
    }
}
