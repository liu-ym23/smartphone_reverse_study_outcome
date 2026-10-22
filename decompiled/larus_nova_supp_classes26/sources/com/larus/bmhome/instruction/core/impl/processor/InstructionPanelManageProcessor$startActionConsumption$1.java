package com.larus.bmhome.instruction.core.impl.processor;

import com.larus.bmhome.instruction.core.impl.base.b;
import com.larus.bmhome.instruction.core.impl.base.e;
import com.larus.im.internal.delegate.c0;
import cq8.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.processor.InstructionPanelManageProcessor$startActionConsumption$1", f = "InstructionPanelManageProcessor.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, s = {})
final class InstructionPanelManageProcessor$startActionConsumption$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InstructionPanelManageProcessor this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionPanelManageProcessor a;

        public a(InstructionPanelManageProcessor r1) {
            this.a = r1;
        }

        public final Object emit(Object r10, Continuation r11) {
            y r12 = (y) r10;
            c0.b.i("InstructionPanelManageProcessor", "[_actionChannel] collect action:" + r12.a + ", widgetId:" + r12.a());
            List r13 = CollectionsKt.toList(this.a.getContext().c.values());
            InstructionPanelManageProcessor r0 = this.a;
            Iterator<T> r14 = r13.iterator();
            Object r3 = null;
        L4:
            if (r14.hasNext() == false) goto L36;
            Map r4 = (Map) r14.next();
            if (r3 != null) goto L4;
            Iterator r5 = r4.entrySet().iterator();
        L9:
            if (r5.hasNext() == false) goto L4;
            Map.Entry r6 = (Map.Entry) r5.next();
            if (Intrinsics.areEqual(r6.getKey(), r12.a()) == true) goto L12;
            e r7 = (e) r6.getValue();
            String r8 = r12.a();
            int r9 = InstructionPanelManageProcessor.k;
            r0.getClass();
            if ((r7 instanceof b) == false) goto L16;
            b r15 = (b) r7;
        L17:
            if (r15 == null) goto L33;
            List<e> r16 = r15.f;
            if (r16 == null) goto L33;
            Iterator r17 = ((ArrayList) r16).iterator();
        L23:
            if (r17.hasNext() == false) goto L31;
            Object r18 = r17.next();
            e r19 = (e) r18;
            if (r19 == null) goto L27;
            String r20 = r19.getWidgetId();
        L29:
            if (Intrinsics.areEqual(r20, r8) == false) goto L23;
        L32:
            e r21 = (e) r18;
        L34:
            if (r21 == null) goto L9;
            r3 = r21;
            goto L9
        L27:
            r20 = null;
            goto L29
        L31:
            r18 = null;
        L33:
            r21 = null;
            goto L34
        L16:
            r15 = null;
            goto L17
        L12:
            r3 = r6.getValue();
            goto L9
        L36:
            if (r3 != null) goto L38;
            c0.b.w("InstructionPanelManageProcessor", "[_actionChannel] target controller not found, widgetId:" + r12.a() + ", panelCount:" + CollectionsKt.toList(this.a.getContext().c.values()).size());
            return Unit.INSTANCE;
        L38:
            c0 r110 = c0.b;
            StringBuilder r1 = new StringBuilder("[_actionChannel] dispatch to widgetId:");
            e r22 = (e) r3;
            r1.append(r22.getWidgetId());
            r1.append(", action:");
            r1.append(r12.a);
            r110.i("InstructionPanelManageProcessor", r1.toString());
            r22.m(r12);
            return Unit.INSTANCE;
        }
    }

    public InstructionPanelManageProcessor$startActionConsumption$1(InstructionPanelManageProcessor r1, Continuation<? super InstructionPanelManageProcessor$startActionConsumption$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new InstructionPanelManageProcessor$startActionConsumption$1(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        InstructionPanelManageProcessor r6 = this.this$0;
        MutableSharedFlow r2 = r6.f;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
