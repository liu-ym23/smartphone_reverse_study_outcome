package com.larus.bmhome.view.actionbar.edit.component;

import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.DropdownListSelectorWidgetV2$observeDataChange$1", f = "DropdownListSelectorWidgetV2.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
final class DropdownListSelectorWidgetV2$observeDataChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropdownListSelectorWidgetV2 this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DropdownListSelectorWidgetV2 a;

        public a(DropdownListSelectorWidgetV2 r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.bmhome.actionbar.model.t1 r5 = (com.larus.bmhome.actionbar.model.t1) r3;
            FLogger.a.i("DropdownListSelectorWidgetV2", "observeDataChange, paramFilterConf=" + r5);
            xs8.f r6 = DropdownListSelectorWidgetV2.i6(this.a);
            if (r6 == null) goto L5;
            r6.o = false;
        L5:
            List<com.larus.bmhome.actionbar.model.h> r7 = this.a.s6(r5, false);
            DropdownSelectorWidgetAdapterV2 r8 = this.a.g;
            if (r8 == null) goto L8;
            r8.submitList(r7);
        L8:
            com.larus.bmhome.actionbar.model.i r9 = DropdownListSelectorWidgetV2.k6(this.a);
            if (r9 == null) goto L12;
            r9.a = r7;
        L12:
            return Unit.INSTANCE;
        }
    }

    public DropdownListSelectorWidgetV2$observeDataChange$1(DropdownListSelectorWidgetV2 r1, Continuation<? super DropdownListSelectorWidgetV2$observeDataChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropdownListSelectorWidgetV2$observeDataChange$1(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DropdownListSelectorWidgetV2 r6 = this.this$0;
        int r2 = DropdownListSelectorWidgetV2.j;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.d1<com.larus.bmhome.actionbar.model.t1> r8 = r7.getOptionParamFilterConfChanged();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
