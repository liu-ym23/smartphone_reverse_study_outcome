package com.larus.dora.impl.dynamic.viewholder;

import com.larus.bmhome.view.item.ItemTextToggle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewholder.GeneralGroupHolder$createChildView$1", f = "GeneralGroupHolder.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
final class GeneralGroupHolder$createChildView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemTextToggle $toggleItemView;
    int label;
    final /* synthetic */ GeneralGroupHolder this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ItemTextToggle a;

        public a(ItemTextToggle r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            this.a.getToggleView().setChecked(r3);
            return Unit.INSTANCE;
        }
    }

    public GeneralGroupHolder$createChildView$1(GeneralGroupHolder r1, ItemTextToggle r2, Continuation<? super GeneralGroupHolder$createChildView$1> r3) {
        this.this$0 = r1;
        this.$toggleItemView = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GeneralGroupHolder$createChildView$1(this.this$0, this.$toggleItemView, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        GeneralGroupHolder r6 = this.this$0;
        int r2 = GeneralGroupHolder.e;
        r6.getClass();
        Flow r7 = kotlinx.coroutines.flow.e.w(new c1(new GeneralGroupHolder$getMultiUserModeStateFlow$1(null)), Dispatchers.getIO());
        a r3 = new a(this.$toggleItemView);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
