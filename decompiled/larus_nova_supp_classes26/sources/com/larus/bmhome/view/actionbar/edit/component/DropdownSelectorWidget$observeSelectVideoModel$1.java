package com.larus.bmhome.view.actionbar.edit.component;

import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidget$observeSelectVideoModel$1", f = "DropdownSelectorWidget.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
final class DropdownSelectorWidget$observeSelectVideoModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropdownSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DropdownSelectorWidget a;

        public a(DropdownSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            com.larus.bmhome.view.actionbar.edit.p r13 = (com.larus.bmhome.view.actionbar.edit.p) r11;
            com.larus.bmhome.actionbar.model.h r14 = DropdownSelectorWidget.o6(this.a);
            Long r2 = null;
            if (r14 == null) goto L17;
            List r15 = r14.e;
            if (r15 == null) goto L17;
            Iterator<T> r16 = r15.iterator();
            boolean r3 = false;
        L8:
            if (r16.hasNext() == false) goto L18;
            com.larus.bmhome.actionbar.model.w r4 = (com.larus.bmhome.actionbar.model.w) r16.next();
            Long r5 = r4.a;
            if (r13 == null) goto L12;
            Long r6 = Boxing.boxLong(r13.b);
        L14:
            if (Intrinsics.areEqual(r5, r6) == true) goto L15;
            r4.s = Boxing.boxInt(0);
            goto L8
        L15:
            r4.s = Boxing.boxInt(1);
            r3 = true;
            goto L8
        L12:
            r6 = null;
        L18:
            if (r3 == true) goto L33;
            com.larus.bmhome.actionbar.model.h r17 = DropdownSelectorWidget.o6(this.a);
            if (r17 == null) goto L33;
            List r18 = r17.e;
            if (r18 == null) goto L33;
            DropdownSelectorWidget r19 = this.a;
            Iterator<T> r110 = r18.iterator();
        L25:
            if (r110.hasNext() == false) goto L33;
            com.larus.bmhome.actionbar.model.w r7 = (com.larus.bmhome.actionbar.model.w) r110.next();
            Long r8 = r7.a;
            long r9 = r19.n;
            if (r8 == null) goto L32;
            if (r8.longValue() != r9) goto L32;
            r7.s = Boxing.boxInt(1);
        L32:
            r7.s = Boxing.boxInt(0);
        L33:
            if (r3 == false) goto L39;
            xs8.g r111 = DropdownSelectorWidget.n6(this.a);
            if (r111 == null) goto L37;
            r2 = r111.s();
        L37:
            if (r2 == null) goto L39;
            this.a.w7();
            return Unit.INSTANCE;
        L39:
            this.a.w7();
            return Unit.INSTANCE;
        L17:
            r3 = false;
            goto L18
        }
    }

    public DropdownSelectorWidget$observeSelectVideoModel$1(DropdownSelectorWidget r1, Continuation<? super DropdownSelectorWidget$observeSelectVideoModel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropdownSelectorWidget$observeSelectVideoModel$1(this.this$0, r3);
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
        DropdownSelectorWidget r6 = this.this$0;
        u1 r2 = DropdownSelectorWidget.q;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.i1<com.larus.bmhome.view.actionbar.edit.p> r8 = r7.getSelectVideoModelFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
