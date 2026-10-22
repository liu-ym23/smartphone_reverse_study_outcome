package com.larus.uaigc.instruction;

import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.utils.e1;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.AvatarTemplateWidget$observeReplicaInfoIfInitialNull$1", f = "AvatarTemplateWidget.kt", i = {}, l = {412}, m = "invokeSuspend", n = {}, s = {})
final class AvatarTemplateWidget$observeReplicaInfoIfInitialNull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AvatarTemplateWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ AvatarTemplateWidget a;

        public a(AvatarTemplateWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            if (((com.larus.uaigc.api.a) r3) != null) goto L5;
            e1.o(this.a);
        L24:
            return Unit.INSTANCE;
        L5:
            boolean r5 = false;
            if (this.a.getVisibility() != 0) goto L8;
            boolean r6 = true;
        L9:
            if (r6 == true) goto L25;
            AvatarTemplateWidget r7 = this.a;
            int[] r1 = AvatarTemplateWidget.k;
            com.larus.bmhome.view.actionbar.edit.c r8 = r7.getViewModel();
            if (r8 == null) goto L18;
            i1 r9 = r8.getChosenAvatarInstructionStatus();
            if (r9 == null) goto L18;
            if (((Boolean) r9.getValue()).booleanValue() != true) goto L18;
            r5 = true;
        L18:
            if (r5 == false) goto L22;
            com.larus.bmhome.view.actionbar.edit.c r10 = this.a.getViewModel();
            if (r10 == null) goto L22;
            r10.onAvatarInstructionClicked(null);
        L22:
            e1.x(this.a);
            goto L24
        L25:
            return Unit.INSTANCE;
        L8:
            r6 = false;
            goto L9
        }
    }

    public AvatarTemplateWidget$observeReplicaInfoIfInitialNull$1(AvatarTemplateWidget r1, Continuation<? super AvatarTemplateWidget$observeReplicaInfoIfInitialNull$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AvatarTemplateWidget$observeReplicaInfoIfInitialNull$1(this.this$0, r3);
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
        DigitalAvatarInfoManager.a.getClass();
        StateFlowImpl r6 = DigitalAvatarInfoManager.k;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
