package com.bytedance.android.ec.core.imagex.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 128)
public final class ListenersManagerKt$withEachType$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1 $block;

    public ListenersManagerKt$withEachType$1(Function1 r1) {
        this.$block = r1;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m1293invoke(r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1293invoke(Object r10) {
        Intrinsics.reifiedOperationMarker(3, "T");
        if ((r10 instanceof Object) == false) goto L6;
        this.$block.invoke(r10);
        return;
    }
}
