package com.larus.uaigc.createpage.component.instruction;

import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$observerInstructionEditor$4", f = "CreationEditorComponent.kt", i = {}, l = {2862}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$observerInstructionEditor$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            String r7 = (String) r5;
            CreationEditorComponent r8 = this.a;
            int r9 = CreationEditorComponent.g2;
            int r10 = ((Number) r8.i4().getInstructionSelectMenuPosition().getValue()).intValue();
            if (((Boolean) this.a.i4().getChosenAvatarInstructionStatus().getValue()).booleanValue() == false) goto L14;
            DigitalAvatarInfoManager.a.getClass();
            if (DigitalAvatarInfoManager.h() == false) goto L10;
            FLogger r11 = FLogger.a;
            StringBuilder r1 = new StringBuilder("replica has created, whiteTUrl = ");
            StateFlowImpl r2 = DigitalAvatarInfoManager.b;
            r1.append((String) r2.getValue());
            r11.d("CreationEditorComponent", r1.toString());
            ry9.h r12 = this.a.l4();
            if (r12 == null) goto L24;
            r12.JZ((String) r2.getValue());
        L24:
            com.larus.bmhome.view.actionbar.edit.c r13 = this.a.i4();
            uz9.a r0 = this.a.r;
            if (r0 == null) goto L29;
            Integer r3 = r0.j();
            if (r3 == null) goto L29;
            int r4 = r3.intValue();
        L30:
            String r14 = r13.getHintStr(r10, r4);
            if (r14 == null) goto L34;
            this.a.Q5(r14);
        L34:
            return Unit.INSTANCE;
        L29:
            r4 = 0;
            goto L30
        L10:
            if (DigitalAvatarInfoManager.i() == false) goto L24;
            FLogger.a.d("CreationEditorComponent", "replica is creating");
            ry9.h r15 = this.a.l4();
            if (r15 == null) goto L24;
            r15.JZ(DigitalAvatarInfoManager.e());
            goto L24
        L14:
            DigitalAvatarInfoManager.a.getClass();
            if (DigitalAvatarInfoManager.g() == false) goto L24;
            ry9.h r16 = this.a.l4();
            if (r16 == null) goto L24;
            ry9.h r17 = this.a.l4();
            if (r17 == null) goto L22;
            String r18 = r17.yC();
            if (r18 == null) goto L22;
        L23:
            r16.lu(r18);
        L22:
            r18 = "";
            goto L23
        }
    }

    public CreationEditorComponent$observerInstructionEditor$4(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$observerInstructionEditor$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$observerInstructionEditor$4(this.this$0, r3);
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
        kotlinx.coroutines.flow.d1 r7 = r6.i4().getChosenAvatarInstructionFlow();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
