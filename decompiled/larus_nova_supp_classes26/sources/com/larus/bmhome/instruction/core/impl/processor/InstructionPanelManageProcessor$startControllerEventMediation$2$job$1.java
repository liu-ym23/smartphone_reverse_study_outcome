package com.larus.bmhome.instruction.core.impl.processor;

import com.larus.bmhome.instruction.core.impl.base.b;
import com.larus.bmhome.instruction.core.impl.base.e;
import com.larus.im.internal.delegate.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.processor.InstructionPanelManageProcessor$startControllerEventMediation$2$job$1", f = "InstructionPanelManageProcessor.kt", i = {}, l = {504}, m = "invokeSuspend", n = {}, s = {})
final class InstructionPanelManageProcessor$startControllerEventMediation$2$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $abs;
    final /* synthetic */ String $panelId;
    int label;
    final /* synthetic */ InstructionPanelManageProcessor this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ InstructionPanelManageProcessor a;
        public final /* synthetic */ String b;

        public a(InstructionPanelManageProcessor r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r5, Continuation r6) {
            com.larus.bmhome.instruction.core.impl.base.d r7 = (com.larus.bmhome.instruction.core.impl.base.d) r5;
            Collection<e> r8 = this.a.getContext().a(this.b).values();
            ArrayList r0 = new ArrayList();
            Iterator<T> r9 = r8.iterator();
        L4:
            if (r9.hasNext() == false) goto L8;
            T r1 = r9.next();
            if ((!Intrinsics.areEqual(((e) r1).getWidgetId(), r7.a())) == false) goto L4;
            r0.add(r1);
            goto L4
        L8:
            c0.b.i("InstructionPanelManageProcessor", "[startControllerEventMediation] route event from:" + r7.a() + ", targetCount:" + r0.size() + ", event:" + r7.a);
            Iterator r10 = r0.iterator();
        L10:
            if (r10.hasNext() == false) goto L18;
            e r2 = (e) r10.next();
            if ((r2 instanceof b) == false) goto L14;
            b r3 = (b) r2;
        L15:
            if (r3 == null) goto L10;
            r3.onEvent(r7);
            goto L10
        L14:
            r3 = null;
            goto L15
        L18:
            return Unit.INSTANCE;
        }
    }

    public InstructionPanelManageProcessor$startControllerEventMediation$2$job$1(b r1, InstructionPanelManageProcessor r2, String r3, Continuation<? super InstructionPanelManageProcessor$startControllerEventMediation$2$job$1> r4) {
        this.$abs = r1;
        this.this$0 = r2;
        this.$panelId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new InstructionPanelManageProcessor$startControllerEventMediation$2$job$1(this.$abs, this.this$0, this.$panelId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        a1 r7 = this.$abs.l;
        a r2 = new a(this.this$0, this.$panelId);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
