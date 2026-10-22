package com.larus.uaigc.createpage.component.instruction;

import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$19", f = "CreationEditorComponent.kt", i = {}, l = {3247}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$19 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            ((Number) r5).longValue();
            CreationEditorComponent r7 = this.a;
            int r8 = CreationEditorComponent.g2;
            com.larus.bmhome.actionbar.model.r r9 = r7.i4().getCurrentInstructionConf();
            if (r9 == null) goto L25;
            com.larus.bmhome.actionbar.model.y r10 = r9.i;
            if (r10 == null) goto L25;
            ArrayList r11 = r10.a;
            if (r11 == null) goto L25;
            Iterator r12 = r11.iterator();
            int r1 = 0;
        L10:
            if (r12.hasNext() == false) goto L23;
            com.larus.bmhome.actionbar.model.r r2 = ((com.larus.bmhome.actionbar.model.z0) r12.next()).q;
            if (r2 == null) goto L19;
            Integer r3 = r2.a;
            if (r3 == null) goto L19;
            if (r3.intValue() != 18) goto L19;
            boolean r4 = true;
        L20:
            if (r4 == true) goto L24;
            r1 = r1 + 1;
        L24:
            Integer r13 = Integer.valueOf(r1);
        L26:
            if (r13 == null) goto L28;
            int r14 = r13.intValue();
        L29:
            if (r14 == (-1)) goto L38;
            String r15 = this.a.O3(r14);
            if (r15 == null) goto L35;
            this.a.Q5(r15);
        L35:
            return Unit.INSTANCE;
        L38:
            return Unit.INSTANCE;
        L28:
            r14 = -1;
        L19:
            r4 = false;
            goto L20
        L23:
            r1 = -1;
        L25:
            r13 = null;
            goto L26
        }
    }

    public CreationEditorComponent$observerInstructionEditor$19(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$19> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$19(this.this$0, r3);
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
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        kotlinx.coroutines.flow.i1 r7 = r6.i4().getSelectedVideoStyle();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
