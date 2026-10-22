package com.larus.uaigc.instruction;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.impl.databinding.LarusDialogInstructionDropFeatureSelectorBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.DropFeatureSelectorWidget$bindObservers$1", f = "DropFeatureSelectorWidget.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
final class DropFeatureSelectorWidget$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DropFeatureSelectorWidget this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.instruction.DropFeatureSelectorWidget$bindObservers$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/view/actionbar/edit/InstructionPhotoTemplateWrapper;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.instruction.DropFeatureSelectorWidget$bindObservers$1$1", f = "DropFeatureSelectorWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.larus.bmhome.view.actionbar.edit.m, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DropFeatureSelectorWidget this$0;

        public AnonymousClass1(DropFeatureSelectorWidget r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.larus.bmhome.view.actionbar.edit.m r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.larus.bmhome.view.actionbar.edit.m) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r12) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L75;
            ResultKt.throwOnFailure(r12);
            com.larus.bmhome.view.actionbar.edit.m r13 = (com.larus.bmhome.view.actionbar.edit.m) this.L$0;
            if (this.this$0.isAttachedToWindow() == false) goto L7;
            TemplateInfo$TemplateInfo r14 = r13.a;
            ArrayList r0 = new ArrayList();
            long r1 = r14.h;
            Ref.IntRef r15 = new Ref.IntRef();
            this.this$0.getClass();
            boolean r3 = false;
            r15.element = 0;
            Ref.IntRef r4 = new Ref.IntRef();
            com.larus.bmhome.actionbar.model.h r5 = this.this$0.getCurrentBindData();
            if (r5 == null) goto L22;
            List r6 = r5.e;
            if (r6 == null) goto L22;
            Iterator r7 = r6.iterator();
        L14:
            if (r7.hasNext() == false) goto L22;
            com.larus.bmhome.actionbar.model.w r8 = (com.larus.bmhome.actionbar.model.w) r7.next();
            r8.s = Boxing.boxInt(0);
            Long r9 = r8.a;
            if (r9 == null) goto L21;
            if (r9.longValue() != r1) goto L21;
            r8.s = Boxing.boxInt(1);
            FLogger.a.d("DropFeatureSelectorFragment", "selectItem:" + r8.b);
            r15.element = r4.element;
        L21:
            r4.element++;
            r0.add(r8);
        L22:
            DropFeatureSelectorFragment r2 = this.this$0.g;
            if (r2 == null) goto L25;
            int r10 = DropFeatureSelectorFragment.l;
            r2.S90(r0, true);
        L25:
            com.larus.bmhome.view.actionbar.edit.c r11 = this.this$0.getViewModel();
            if (r11 == null) goto L28;
            r11.setCurImageList(r0);
        L28:
            com.larus.bmhome.actionbar.model.h r16 = this.this$0.getCurrentBindData();
            com.larus.bmhome.actionbar.model.w r17 = null;
            Object r18 = null;
            r17 = null;
            if (r16 == null) goto L45;
            List r19 = r16.e;
            if (r19 == null) goto L45;
            Iterator r20 = r19.iterator();
        L34:
            if (r20.hasNext() == false) goto L44;
            Object r21 = r20.next();
            Integer r22 = ((com.larus.bmhome.actionbar.model.w) r21).s;
            if (r22 != null) goto L39;
        L41:
            boolean r23 = false;
        L42:
            if (r23 == false) goto L34;
            r18 = r21;
            goto L44
        L39:
            if (r22.intValue() != 1) goto L41;
            r23 = true;
        L44:
            r17 = (com.larus.bmhome.actionbar.model.w) r18;
        L45:
            if (r17 == null) goto L47;
            e1.x(this.this$0.getBinding().f);
            this.this$0.getBinding().f.setText(r17.b);
        L48:
            com.larus.bmhome.actionbar.model.u r24 = this.this$0.getInstructionItem();
            if (r24 == null) goto L56;
            Integer r25 = r24.a;
            if (r25 == null) goto L56;
            if (r25.intValue() != 1) goto L56;
            boolean r26 = true;
        L57:
            if (r26 == false) goto L63;
            com.larus.bmhome.view.actionbar.edit.c r27 = this.this$0.getViewModel();
            if (r27 == null) goto L63;
            if (r17 == null) goto L62;
            r3 = true;
        L62:
            r27.setImageStyleRadioSelected(r3);
        L63:
            DropFeatureSelectorFragment r28 = this.this$0.g;
            if (r28 == null) goto L73;
            int r110 = r15.element;
            LarusDialogInstructionDropFeatureSelectorBinding r29 = r28.d;
            if (r29 == null) goto L73;
            RecyclerView r30 = r29.b;
            if (r30 == null) goto L73;
            RecyclerView.LayoutManager r31 = r30.getLayoutManager();
            if (r31 == null) goto L73;
            r31.scrollToPosition(r110);
        L73:
            return Unit.INSTANCE;
        L56:
            r26 = false;
            goto L57
        L47:
            e1.o(this.this$0.getBinding().f);
            goto L48
        L7:
            return Unit.INSTANCE;
        L75:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DropFeatureSelectorWidget$bindObservers$1(DropFeatureSelectorWidget r1, Continuation<? super DropFeatureSelectorWidget$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DropFeatureSelectorWidget$bindObservers$1(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DropFeatureSelectorWidget r7 = this.this$0;
        int r2 = DropFeatureSelectorWidget.k;
        com.larus.bmhome.view.actionbar.edit.c r8 = r7.getViewModel();
        if (r8 == null) goto L16;
        d1 r9 = r8.getInstructionPhotoTemplatePrompt();
        if (r9 == null) goto L16;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r9, r3, this) != r0) goto L16;
        return r0;
    }
}
