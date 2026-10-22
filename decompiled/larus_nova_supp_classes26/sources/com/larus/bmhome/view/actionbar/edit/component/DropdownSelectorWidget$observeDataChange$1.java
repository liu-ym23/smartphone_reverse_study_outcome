package com.larus.bmhome.view.actionbar.edit.component;

import com.bytedance.keva.Keva;
import com.skydoves.balloon.Balloon;
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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidget$observeDataChange$1", f = "DropdownSelectorWidget.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
final class DropdownSelectorWidget$observeDataChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropdownSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DropdownSelectorWidget a;

        public a(DropdownSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            boolean r11 = ((Boolean) r9).booleanValue();
            Balloon r12 = this.a.g;
            if (r12 == null) goto L5;
            r12.h();
        L5:
            if (r11 == true) goto L83;
            com.larus.bmhome.actionbar.model.h r13 = DropdownSelectorWidget.o6(this.a);
            Integer r1 = null;
            long r2 = -1;
            if (r13 == null) goto L28;
            List r14 = r13.e;
            if (r14 == null) goto L28;
            Iterator<T> r15 = r14.iterator();
        L12:
            if (r15.hasNext() == false) goto L22;
            T r4 = r15.next();
            Integer r5 = ((com.larus.bmhome.actionbar.model.w) r4).s;
            if (r5 != null) goto L17;
        L19:
            boolean r6 = false;
        L20:
            if (r6 == false) goto L12;
        L23:
            com.larus.bmhome.actionbar.model.w r7 = (com.larus.bmhome.actionbar.model.w) r4;
            if (r7 == null) goto L28;
            Long r16 = r7.a;
            if (r16 == null) goto L28;
            long r8 = r16.longValue();
        L30:
            if (r8 == (-1)) goto L32;
            DropdownSelectorWidget.N6(this.a, r8);
            this.a.i = true;
        L69:
            com.larus.bmhome.actionbar.model.h r17 = DropdownSelectorWidget.o6(this.a);
            if (r17 == null) goto L83;
            List r18 = r17.e;
            if (r18 == null) goto L83;
            DropdownSelectorWidget r3 = this.a;
            Iterator<T> r19 = r18.iterator();
        L75:
            if (r19.hasNext() == false) goto L83;
            com.larus.bmhome.actionbar.model.w r20 = (com.larus.bmhome.actionbar.model.w) r19.next();
            Long r21 = r20.a;
            long r22 = r3.n;
            if (r21 == null) goto L82;
            if (r21.longValue() != r22) goto L82;
            r20.s = Boxing.boxInt(1);
        L82:
            r20.s = Boxing.boxInt(0);
            goto L75
        L32:
            com.larus.bmhome.actionbar.model.h r23 = DropdownSelectorWidget.o6(this.a);
            if (r23 == null) goto L35;
            boolean r24 = Intrinsics.areEqual(r23.h, Boxing.boxBoolean(true));
        L36:
            if (r24 == false) goto L38;
            DropdownSelectorWidget.N6(this.a, -1);
            this.a.i = true;
            goto L69
        L38:
            DropdownSelectorWidget r25 = this.a;
            if (r25.n != (-1)) goto L69;
            if (r25.i == true) goto L69;
            xs8.g r26 = DropdownSelectorWidget.n6(r25);
            if (r26 != null) goto L45;
        L68:
            this.a.i = true;
            goto L69
        L45:
            if (r26.t() == false) goto L52;
            com.larus.bmhome.actionbar.model.h r27 = r26.l;
            if (r27 == null) goto L49;
            boolean r28 = Intrinsics.areEqual(r27.h, Boolean.TRUE);
        L50:
            if (r28 == false) goto L52;
        L67:
            DropdownSelectorWidget.N6(this.a, r2);
            goto L68
        L49:
            r28 = false;
        L52:
            com.larus.bmhome.actionbar.model.h r29 = r26.l;
            if (r29 == null) goto L55;
            boolean r30 = Intrinsics.areEqual(r29.i, Boolean.TRUE);
        L56:
            if (r30 == false) goto L67;
            if (r26.n != 4) goto L63;
            Keva r31 = r26.m;
            StringBuilder r32 = new StringBuilder("dropbox_");
            com.larus.bmhome.actionbar.model.h r33 = r26.l;
            if (r33 == null) goto L62;
            r1 = r33.b;
        L62:
            r32.append(r1);
            r2 = r31.getLong(r32.toString(), -1);
            goto L67
        L63:
            Keva r34 = r26.m;
            StringBuilder r35 = new StringBuilder("dropbox_");
            r35.append(r26.n);
            r35.append('_');
            com.larus.bmhome.actionbar.model.h r36 = r26.l;
            if (r36 == null) goto L66;
            r1 = r36.b;
        L66:
            r35.append(r1);
            r2 = r34.getLong(r35.toString(), -1);
            goto L67
        L55:
            r30 = false;
            goto L56
        L35:
            r24 = false;
            goto L36
        L17:
            if (r5.intValue() != 1) goto L19;
            r6 = true;
            goto L20
        L22:
            r4 = null;
        L28:
            r8 = -1;
        L83:
            this.a.w7();
            return Unit.INSTANCE;
        }
    }

    public DropdownSelectorWidget$observeDataChange$1(DropdownSelectorWidget r1, Continuation<? super DropdownSelectorWidget$observeDataChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropdownSelectorWidget$observeDataChange$1(this.this$0, r3);
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
        kotlinx.coroutines.flow.i1<Boolean> r8 = r7.getEnableOriginalRatioFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
