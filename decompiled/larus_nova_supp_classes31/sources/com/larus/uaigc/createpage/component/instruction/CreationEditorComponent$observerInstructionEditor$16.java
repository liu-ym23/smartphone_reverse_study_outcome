package com.larus.uaigc.createpage.component.instruction;

import androidx.lifecycle.LiveData;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$16", f = "CreationEditorComponent.kt", i = {}, l = {3154}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$16 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            ry9.j r13 = (ry9.j) r11;
            if ((r13 instanceof ry9.j.c) == false) goto L11;
            CreationEditorComponent r14 = this.a;
            int r15 = CreationEditorComponent.g2;
            com.larus.bmhome.view.actionbar.edit.c.a.b(r14.i4(), true, true, false, null, false, false, 0, 124);
            va8.o r16 = this.a.X3();
            if (r16 == null) goto L7;
            r16.Y4(1.0f);
        L7:
            ICoreInputAbility r17 = this.a.a4();
            if (r17 == null) goto L41;
            final CreationEditorComponent r18 = this.a;
            r17.iN(new y1(r18));
        L41:
            return Unit.INSTANCE;
        L11:
            if (Intrinsics.areEqual(r13, ry9.j.b.b) == false) goto L19;
            CreationEditorComponent r19 = this.a;
            int r110 = CreationEditorComponent.g2;
            com.larus.bmhome.view.actionbar.edit.c.a.b(r19.i4(), false, false, false, null, false, false, 0, 124);
            va8.o r111 = this.a.X3();
            if (r111 == null) goto L15;
            r111.Y4(1.0f);
        L15:
            ICoreInputAbility r112 = this.a.a4();
            if (r112 == null) goto L41;
            final CreationEditorComponent r113 = this.a;
            r112.iN(new z1(r113));
            goto L41
        L19:
            if ((r13 instanceof ry9.j.f) == false) goto L27;
            CreationEditorComponent r114 = this.a;
            int r115 = CreationEditorComponent.g2;
            com.larus.bmhome.view.actionbar.edit.c.a.b(r114.i4(), true, false, true, null, false, false, 0, 120);
            va8.o r116 = this.a.X3();
            if (r116 == null) goto L23;
            r116.Y4(1.0f);
        L23:
            ICoreInputAbility r117 = this.a.a4();
            if (r117 == null) goto L41;
            final CreationEditorComponent r118 = this.a;
            r117.iN(new a2(r118));
            goto L41
        L27:
            if ((r13 instanceof ry9.j.h) == false) goto L30;
            CreationEditorComponent r119 = this.a;
            int r120 = CreationEditorComponent.g2;
            com.larus.bmhome.view.actionbar.edit.c.a.b(r119.i4(), true, false, false, null, false, false, 0, 124);
            goto L41
        L30:
            if ((r13 instanceof ry9.j.d) == true) goto L41;
            if ((r13 instanceof ry9.j.e) == true) goto L41;
            if ((r13 instanceof ry9.j.g) == true) goto L41;
            if ((r13 instanceof ry9.j.a) == true) goto L41;
            throw new NoWhenBranchMatchedException();
        }
    }

    public CreationEditorComponent$observerInstructionEditor$16(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$16> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$16(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.uaigc.createpage.component.instruction.x1] */
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L21:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        if (r6.T4() == false) goto L13;
        uz9.a r7 = this.this$0.r;
        if (r7 == null) goto L23;
        LiveData<Map<String, ry9.k>> r8 = r7.o();
        final CreationEditorComponent r3 = this.this$0;
        r8.observe(s1a.a.c(r3).getViewLifecycleOwner(), new CreationEditorComponent.g(new x1(r3)));
    L23:
        return Unit.INSTANCE;
    L13:
        ry9.g r9 = this.this$0.k4();
        if (r9 == null) goto L23;
        kotlinx.coroutines.flow.i1<ry9.j> r10 = r9.D20();
        if (r10 == null) goto L23;
        a r4 = new a(this.this$0);
        this.label = 1;
        if (r10.collect(r4, this) != r0) goto L21;
        return r0;
    }
}
