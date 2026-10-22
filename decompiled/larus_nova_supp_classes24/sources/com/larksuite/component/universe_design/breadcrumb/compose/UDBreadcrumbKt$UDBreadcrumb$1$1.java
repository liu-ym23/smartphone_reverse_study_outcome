package com.larksuite.component.universe_design.breadcrumb.compose;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.universe_design.breadcrumb.compose.UDBreadcrumbKt$UDBreadcrumb$1$1", f = "UDBreadcrumb.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class UDBreadcrumbKt$UDBreadcrumb$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $itemSnapshot;
    final /* synthetic */ MutableState<List<String>> $previousItems$delegate;
    final /* synthetic */ LazyListState $state;
    int label;

    public UDBreadcrumbKt$UDBreadcrumb$1$1(List<String> r1, LazyListState r2, MutableState<List<String>> r3, Continuation<? super UDBreadcrumbKt$UDBreadcrumb$1$1> r4) {
        this.$itemSnapshot = r1;
        this.$state = r2;
        this.$previousItems$delegate = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UDBreadcrumbKt$UDBreadcrumb$1$1(this.$itemSnapshot, this.$state, this.$previousItems$delegate, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L18:
        this.$previousItems$delegate.setValue(this.$itemSnapshot);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        if (this.$itemSnapshot.size() > ((List) this.$previousItems$delegate.getValue()).size()) goto L11;
    L13:
        boolean r11 = false;
    L14:
        if (r11 == false) goto L18;
        LazyListState r3 = this.$state;
        int r4 = CollectionsKt.getLastIndex(this.$itemSnapshot);
        this.label = 1;
        if (LazyListState.scrollToItem$default(r3, r4, 0, this, 2, null) != r0) goto L18;
        return r0;
    L11:
        if (Intrinsics.areEqual(CollectionsKt.take(this.$itemSnapshot, ((List) this.$previousItems$delegate.getValue()).size()), (List) this.$previousItems$delegate.getValue()) == false) goto L13;
        r11 = true;
        goto L14
    }
}
