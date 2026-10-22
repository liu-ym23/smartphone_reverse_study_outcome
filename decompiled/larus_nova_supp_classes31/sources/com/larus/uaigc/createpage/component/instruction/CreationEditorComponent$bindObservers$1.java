package com.larus.uaigc.createpage.component.instruction;

import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.instruction.CreationEditorComponent$bindObservers$1", f = "CreationEditorComponent.kt", i = {}, l = {2821}, m = "invokeSuspend", n = {}, s = {})
final class CreationEditorComponent$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationEditorComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CreationEditorComponent a;

        public a(CreationEditorComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r10, Continuation r11) {
            boolean r12 = ((Boolean) r10).booleanValue();
            CreationEditorComponent r13 = this.a;
            boolean r0 = !r12;
            int r1 = CreationEditorComponent.g2;
            boolean r2 = r13.T4();
            FLogger r3 = FLogger.a;
            r3.i("CreationEditorComponent", "updateInstructionPanelVisibility, visible: " + r0 + ", isImageVideoMixSkill: " + r2);
            if (r0 == false) goto L22;
            LinearLayout r4 = r13.C;
            if (r4 == null) goto L7;
            com.larus.utils.e1.x(r4);
        L7:
            r13.y1.setValue(Boolean.TRUE);
            va8.o r5 = r13.X3();
            if (r5 == null) goto L10;
            r5.G60(v19.c.b(2130970688, r13.getContext(), 2131239146));
        L10:
            int r6 = ContextCompat.getColor(r13.getContext(), v19.c.b(2130970531, r13.getContext(), 2131102535));
            if (r2 == true) goto L54;
            Intrinsics.checkNotNullParameter(r13, "<this>");
            View r7 = com.larus.ui.arch.component.internal.attach.a.b(r13, r13).getView();
            if (r7 == null) goto L15;
            r7.setBackgroundColor(r6);
        L15:
            Intrinsics.checkNotNullParameter(r13, "<this>");
            FragmentActivity r14 = com.larus.ui.arch.component.internal.attach.a.b(r13, r13).getActivity();
            if (r14 == null) goto L54;
            Window r15 = r14.getWindow();
            if (r15 == null) goto L54;
            View r16 = CreationEditorComponent.Y2(r15);
            if (r16 == null) goto L54;
            r16.setBackgroundColor(r6);
        L54:
            CreationEditorComponent r17 = this.a;
            ny9.s r8 = r17.W3();
            int r9 = 0;
            boolean r18 = true;
            if (r8 != null) goto L57;
        L59:
            boolean r19 = false;
        L60:
            if (r19 == true) goto L71;
            ny9.s r20 = r17.W3();
            if (r20 == null) goto L69;
            Integer r21 = r20.l();
            if (r21 == null) goto L69;
            if (r21.intValue() != 18) goto L69;
        L70:
            if (r18 == true) goto L71;
        L83:
            if (r12 == false) goto L88;
            ny9.u r110 = this.a.d4();
            if (r110 == null) goto L88;
            r110.s(null);
        L88:
            return Unit.INSTANCE;
        L69:
            r18 = false;
        L71:
            r3.i("CreationEditorComponent", "updateRefImageAddItemVisibility, visible: " + r12);
            ConstraintLayout r22 = (ConstraintLayout) r17.V1.getValue();
            if (r22 == null) goto L77;
            if (r12 == false) goto L75;
            int r23 = 0;
        L76:
            r22.setVisibility(r23);
            goto L77
        L75:
            r23 = 8;
        L77:
            ConstraintLayout r111 = r17.D;
            if (r111 == null) goto L83;
            if (r12 == true) goto L82;
            r9 = 8;
        L82:
            r111.setVisibility(r9);
            goto L83
        L57:
            if (r8.B() != true) goto L59;
            r19 = true;
            goto L60
        L22:
            View r24 = r13.F;
            if (r24 == null) goto L25;
            com.larus.utils.e1.o(r24);
        L25:
            LinearLayout r25 = r13.C;
            if (r25 == null) goto L28;
            com.larus.utils.e1.o(r25);
        L28:
            r13.y1.setValue(Boolean.FALSE);
            va8.o r26 = r13.X3();
            if (r26 == null) goto L31;
            r26.G60(v19.c.b(2130970685, r13.getContext(), 2131239137));
        L31:
            int r27 = ContextCompat.getColor(r13.getContext(), v19.c.b(2130970529, r13.getContext(), 2131102529));
            Intrinsics.checkNotNullParameter(r13, "<this>");
            View r28 = com.larus.ui.arch.component.internal.attach.a.b(r13, r13).getView();
            if (r28 == null) goto L34;
            r28.setBackgroundColor(r27);
        L34:
            Intrinsics.checkNotNullParameter(r13, "<this>");
            FragmentActivity r29 = com.larus.ui.arch.component.internal.attach.a.b(r13, r13).getActivity();
            if (r29 == null) goto L41;
            Window r30 = r29.getWindow();
            if (r30 == null) goto L41;
            View r31 = CreationEditorComponent.Y2(r30);
            if (r31 == null) goto L41;
            r31.setBackgroundColor(r27);
        L41:
            com.larus.bmhome.actionbar.model.r r32 = r13.i4().getCurrentInstructionConf();
            if (r32 == null) goto L44;
            Integer r33 = r32.a;
        L45:
            com.larus.bmhome.actionbar.model.r r34 = r13.s;
            if (r34 == null) goto L48;
            Integer r35 = r34.a;
        L50:
            if (Intrinsics.areEqual(r33, r35) == true) goto L54;
            r13.y5();
            vp8.i r112 = r13.G;
            if (r112 == null) goto L54;
            r112.e();
            goto L54
        L48:
            r35 = null;
            goto L50
        L44:
            r33 = null;
            goto L45
        }
    }

    public CreationEditorComponent$bindObservers$1(CreationEditorComponent r1, Continuation<? super CreationEditorComponent$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationEditorComponent$bindObservers$1(this.this$0, r3);
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
        CreationEditorComponent r6 = this.this$0;
        int r2 = CreationEditorComponent.g2;
        uy9.a r7 = r6.q4();
        if (r7 == null) goto L18;
        kotlinx.coroutines.flow.b1 r8 = r7.gT();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
