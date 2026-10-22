package com.larus.bmhome.view.actionbar.edit.component;

import com.bytedance.keva.Keva;
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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidget$observeDataChange$2", f = "DropdownSelectorWidget.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
final class DropdownSelectorWidget$observeDataChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropdownSelectorWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DropdownSelectorWidget a;

        public a(DropdownSelectorWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r18, Continuation r19) {
            com.larus.bmhome.view.actionbar.edit.q r1 = (com.larus.bmhome.view.actionbar.edit.q) r18;
            long r2 = r1.b;
            int r3 = r1.a;
            if (r3 == 0) goto L15;
            xs8.g r6 = DropdownSelectorWidget.n6(this.a);
            if (r6 == null) goto L12;
            Integer r7 = r6.g;
            if (r7 == null) goto L12;
            if (r3 != r7.intValue()) goto L12;
            boolean r4 = true;
        L13:
            if (r4 == true) goto L15;
            return Unit.INSTANCE;
        L12:
            r4 = false;
        L15:
            com.larus.bmhome.actionbar.model.h r5 = DropdownSelectorWidget.o6(this.a);
            if (r5 == null) goto L64;
            List r8 = r5.e;
            if (r8 == null) goto L64;
            DropdownSelectorWidget r9 = this.a;
            Iterator<T> r10 = r8.iterator();
            boolean r11 = false;
        L21:
            if (r10.hasNext() == false) goto L65;
            com.larus.bmhome.actionbar.model.w r12 = (com.larus.bmhome.actionbar.model.w) r10.next();
            Long r13 = r12.a;
            if (r13 == null) goto L63;
            if (r13.longValue() != r2) goto L63;
            r12.s = Boxing.boxInt(1);
            com.larus.bmhome.actionbar.model.h r14 = DropdownSelectorWidget.o6(r9);
            if (r14 == null) goto L30;
            boolean r15 = Intrinsics.areEqual(r14.i, Boxing.boxBoolean(true));
        L31:
            if (r15 == false) goto L62;
            Integer r16 = DropdownSelectorWidget.s6(r9);
            long r17 = -1;
            Integer r110 = null;
            if (r16 == null) goto L47;
            if (r16.intValue() != 4) goto L47;
            Keva r20 = DropdownSelectorWidget.u6(r9);
            if (r20 == null) goto L62;
            StringBuilder r111 = new StringBuilder("dropbox_");
            com.larus.bmhome.actionbar.model.h r112 = DropdownSelectorWidget.o6(r9);
            if (r112 == null) goto L42;
            r110 = r112.b;
        L42:
            r111.append(r110);
            String r113 = r111.toString();
            Long r21 = r12.a;
            if (r21 == null) goto L45;
            r17 = r21.longValue();
        L45:
            r20.storeLong(r113, r17);
        L47:
            if (r9.f7() == false) goto L53;
            Long r22 = r12.a;
            if (r22 == null) goto L53;
            if (r22.longValue() == 0) goto L62;
        L53:
            Keva r23 = DropdownSelectorWidget.u6(r9);
            if (r23 == null) goto L62;
            StringBuilder r114 = new StringBuilder("dropbox_");
            r114.append(DropdownSelectorWidget.s6(r9));
            r114.append('_');
            com.larus.bmhome.actionbar.model.h r115 = DropdownSelectorWidget.o6(r9);
            if (r115 == null) goto L58;
            r110 = r115.b;
        L58:
            r114.append(r110);
            String r116 = r114.toString();
            Long r24 = r12.a;
            if (r24 == null) goto L61;
            r17 = r24.longValue();
        L61:
            r23.storeLong(r116, r17);
        L62:
            r11 = true;
            goto L21
        L30:
            r15 = false;
        L63:
            r12.s = Boxing.boxInt(0);
        L65:
            if (r11 == true) goto L80;
            com.larus.bmhome.actionbar.model.h r25 = DropdownSelectorWidget.o6(this.a);
            if (r25 == null) goto L80;
            List r26 = r25.e;
            if (r26 == null) goto L80;
            DropdownSelectorWidget r27 = this.a;
            Iterator<T> r28 = r26.iterator();
        L72:
            if (r28.hasNext() == false) goto L80;
            com.larus.bmhome.actionbar.model.w r29 = (com.larus.bmhome.actionbar.model.w) r28.next();
            Long r30 = r29.a;
            long r31 = r27.n;
            if (r30 == null) goto L79;
            if (r30.longValue() != r31) goto L79;
            r29.s = Boxing.boxInt(1);
        L79:
            r29.s = Boxing.boxInt(0);
        L80:
            this.a.w7();
            return Unit.INSTANCE;
        L64:
            r11 = false;
            goto L65
        }
    }

    public DropdownSelectorWidget$observeDataChange$2(DropdownSelectorWidget r1, Continuation<? super DropdownSelectorWidget$observeDataChange$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropdownSelectorWidget$observeDataChange$2(this.this$0, r3);
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
        kotlinx.coroutines.flow.d1<com.larus.bmhome.view.actionbar.edit.q> r8 = r7.getSelectRatioFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
