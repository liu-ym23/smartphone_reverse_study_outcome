package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
final /* synthetic */ class StateStore$awaitState$2 extends AdaptedFunctionReference implements Function1<l, Unit> {
    public StateStore$awaitState$2(Object r8) {
        super(1, r8, CompletableDeferred.class, "complete", "complete(Ljava/lang/Object;)Z", 8);
    }

    public final void invoke(l r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        ((CompletableDeferred) ((AdaptedFunctionReference) this).receiver).complete(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((l) r1);
        return Unit.INSTANCE;
    }
}
