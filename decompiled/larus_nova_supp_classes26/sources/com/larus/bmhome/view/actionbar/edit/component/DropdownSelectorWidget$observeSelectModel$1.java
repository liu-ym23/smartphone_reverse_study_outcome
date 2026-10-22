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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidget$observeSelectModel$1", f = "DropdownSelectorWidget.kt", i = {}, l = {885}, m = "invokeSuspend", n = {}, s = {})
final class DropdownSelectorWidget$observeSelectModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropdownSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DropdownSelectorWidget a;

        public a(DropdownSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            com.larus.bmhome.view.actionbar.edit.p r11 = (com.larus.bmhome.view.actionbar.edit.p) r9;
            Integer r12 = null;
            if (r11 == null) goto L5;
            Long r0 = Boxing.boxLong(r11.b);
        L6:
            if (r11 == null) goto L8;
            Integer r13 = Boxing.boxInt(r11.a);
        L9:
            if (r13 != null) goto L12;
        L13:
            xs8.g r1 = DropdownSelectorWidget.n6(this.a);
            if (r1 == null) goto L17;
            r12 = r1.g;
        L17:
            if (Intrinsics.areEqual(r13, r12) == false) goto L61;
        L19:
            com.larus.bmhome.actionbar.model.h r14 = DropdownSelectorWidget.o6(this.a);
            if (r14 == null) goto L30;
            List r15 = r14.e;
            if (r15 == null) goto L30;
            Iterator<T> r16 = r15.iterator();
            boolean r2 = false;
        L25:
            if (r16.hasNext() == false) goto L31;
            com.larus.bmhome.actionbar.model.w r3 = (com.larus.bmhome.actionbar.model.w) r16.next();
            if (Intrinsics.areEqual(r3.a, r0) == true) goto L28;
            r3.s = Boxing.boxInt(0);
            goto L25
        L28:
            r3.s = Boxing.boxInt(1);
            r2 = true;
        L31:
            if (r2 == true) goto L46;
            com.larus.bmhome.actionbar.model.h r17 = DropdownSelectorWidget.o6(this.a);
            if (r17 == null) goto L46;
            List r18 = r17.e;
            if (r18 == null) goto L46;
            DropdownSelectorWidget r4 = this.a;
            Iterator<T> r19 = r18.iterator();
        L38:
            if (r19.hasNext() == false) goto L46;
            com.larus.bmhome.actionbar.model.w r5 = (com.larus.bmhome.actionbar.model.w) r19.next();
            Long r6 = r5.a;
            long r7 = r4.n;
            if (r6 == null) goto L45;
            if (r6.longValue() != r7) goto L45;
            r5.s = Boxing.boxInt(1);
        L45:
            r5.s = Boxing.boxInt(0);
        L46:
            this.a.w7();
            return Unit.INSTANCE;
        L30:
            r2 = false;
            goto L31
        L61:
            return Unit.INSTANCE;
        L12:
            if (r13.intValue() == 0) goto L19;
        L8:
            r13 = null;
            goto L9
        L5:
            r0 = null;
            goto L6
        }
    }

    public DropdownSelectorWidget$observeSelectModel$1(DropdownSelectorWidget r1, Continuation<? super DropdownSelectorWidget$observeSelectModel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropdownSelectorWidget$observeSelectModel$1(this.this$0, r3);
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
        kotlinx.coroutines.flow.i1<com.larus.bmhome.view.actionbar.edit.p> r8 = r7.getSelectModelFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
