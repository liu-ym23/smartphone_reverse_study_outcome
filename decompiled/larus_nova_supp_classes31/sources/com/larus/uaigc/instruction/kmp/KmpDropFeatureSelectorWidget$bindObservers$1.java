package com.larus.uaigc.instruction.kmp;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.view.actionbar.edit.m;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.impl.databinding.LarusDialogInstructionDropFeatureSelectorBinding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;
import com.larus.uaigc.instruction.DropFeatureSelectorFragment;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.kmp.KmpDropFeatureSelectorWidget$bindObservers$1", f = "KmpDropFeatureSelectorWidget.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {})
final class KmpDropFeatureSelectorWidget$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KmpDropFeatureSelectorWidget this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.instruction.kmp.KmpDropFeatureSelectorWidget$bindObservers$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/view/actionbar/edit/InstructionPhotoTemplateWrapper;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.instruction.kmp.KmpDropFeatureSelectorWidget$bindObservers$1$1", f = "KmpDropFeatureSelectorWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<m, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ KmpDropFeatureSelectorWidget this$0;

        public AnonymousClass1(KmpDropFeatureSelectorWidget r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(m r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((m) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r12) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L86;
            ResultKt.throwOnFailure(r12);
            m r13 = (m) this.L$0;
            if (this.this$0.isAttachedToWindow() == false) goto L7;
            TemplateInfo$TemplateInfo r14 = r13.a;
            ArrayList r0 = new ArrayList();
            long r1 = r14.h;
            Ref.IntRef r15 = new Ref.IntRef();
            Ref.IntRef r3 = new Ref.IntRef();
            com.larus.bmhome.actionbar.model.h r4 = KmpDropFeatureSelectorWidget.Y5(this.this$0);
            boolean r5 = false;
            if (r4 == null) goto L22;
            List r6 = r4.e;
            if (r6 == null) goto L22;
            Iterator r7 = r6.iterator();
        L14:
            if (r7.hasNext() == false) goto L22;
            w r8 = (w) r7.next();
            r8.s = Boxing.boxInt(0);
            Long r9 = r8.a;
            if (r9 == null) goto L21;
            if (r9.longValue() != r1) goto L21;
            r8.s = Boxing.boxInt(1);
            FLogger.a.d("DropFeatureSelectorFragment", "selectItem:" + r8.b);
            r15.element = r3.element;
        L21:
            r3.element++;
            r0.add(r8);
        L22:
            DropFeatureSelectorFragment r2 = this.this$0.g;
            if (r2 == null) goto L25;
            int r10 = DropFeatureSelectorFragment.l;
            r2.S90(r0, true);
        L25:
            com.larus.bmhome.view.actionbar.edit.c r11 = this.this$0.j;
            if (r11 == null) goto L28;
            r11.setCurImageList(r0);
        L28:
            com.larus.bmhome.actionbar.model.h r16 = KmpDropFeatureSelectorWidget.Y5(this.this$0);
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r17 = null;
            if (r16 == null) goto L46;
            List r18 = r16.e;
            if (r18 == null) goto L46;
            Iterator r19 = r18.iterator();
        L34:
            if (r19.hasNext() == false) goto L44;
            Object r20 = r19.next();
            Integer r21 = ((w) r20).s;
            if (r21 != null) goto L39;
        L41:
            boolean r22 = false;
        L42:
            if (r22 == false) goto L34;
        L45:
            w r23 = (w) r20;
        L48:
            if (r23 == null) goto L57;
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r24 = this.this$0.f;
            if (r24 != null) goto L52;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r24 = null;
        L52:
            e1.x(r24.f);
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r25 = this.this$0.f;
            if (r25 != null) goto L55;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L56:
            r17.f.setText(r23.b);
        L62:
            KmpDropFeatureSelectorWidget r26 = this.this$0;
            cq8.k r27 = r26.h;
            if (r27 != null) goto L65;
        L67:
            boolean r28 = false;
        L68:
            if (r28 == false) goto L74;
            com.larus.bmhome.view.actionbar.edit.c r29 = r26.j;
            if (r29 == null) goto L74;
            if (r23 == null) goto L73;
            r5 = true;
        L73:
            r29.setImageStyleRadioSelected(r5);
        L74:
            DropFeatureSelectorFragment r30 = this.this$0.g;
            if (r30 == null) goto L83;
            int r110 = r15.element;
            LarusDialogInstructionDropFeatureSelectorBinding r31 = r30.d;
            if (r31 == null) goto L83;
            RecyclerView r32 = r31.b;
            if (r32 == null) goto L83;
            RecyclerView.LayoutManager r33 = r32.getLayoutManager();
            if (r33 == null) goto L83;
            r33.scrollToPosition(r110);
        L83:
            this.this$0.Z5();
            return Unit.INSTANCE;
        L65:
            if (r27.h != true) goto L67;
            r28 = true;
            goto L68
        L55:
            r17 = r25;
            goto L56
        L57:
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r34 = this.this$0.f;
            if (r34 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L61:
            e1.o(r17.f);
            goto L62
        L60:
            r17 = r34;
            goto L61
        L39:
            if (r21.intValue() != 1) goto L41;
            r22 = true;
            goto L42
        L44:
            r20 = null;
        L46:
            r23 = null;
            goto L48
        L7:
            return Unit.INSTANCE;
        L86:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public KmpDropFeatureSelectorWidget$bindObservers$1(KmpDropFeatureSelectorWidget r1, Continuation<? super KmpDropFeatureSelectorWidget$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new KmpDropFeatureSelectorWidget$bindObservers$1(this.this$0, r3);
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
        com.larus.bmhome.view.actionbar.edit.c r7 = this.this$0.j;
        if (r7 == null) goto L16;
        d1 r8 = r7.getInstructionPhotoTemplatePrompt();
        if (r8 == null) goto L16;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r2, this) != r0) goto L16;
        return r0;
    }
}
