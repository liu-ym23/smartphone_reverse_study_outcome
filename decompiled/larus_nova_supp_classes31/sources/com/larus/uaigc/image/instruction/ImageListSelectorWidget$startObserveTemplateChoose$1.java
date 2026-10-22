package com.larus.uaigc.image.instruction;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.l;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.view.actionbar.edit.m;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.instruction.widget.ImageSelectorWidgetAdapter;
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
@DebugMetadata(c = "com.larus.uaigc.image.instruction.ImageListSelectorWidget$startObserveTemplateChoose$1", f = "ImageListSelectorWidget.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
final class ImageListSelectorWidget$startObserveTemplateChoose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageListSelectorWidget this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.image.instruction.ImageListSelectorWidget$startObserveTemplateChoose$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/view/actionbar/edit/InstructionPhotoTemplateWrapper;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.image.instruction.ImageListSelectorWidget$startObserveTemplateChoose$1$1", f = "ImageListSelectorWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<m, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ImageListSelectorWidget this$0;

        public AnonymousClass1(ImageListSelectorWidget r1, Continuation<? super AnonymousClass1> r2) {
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
            if (this.label != 0) goto L61;
            ResultKt.throwOnFailure(r12);
            TemplateInfo$TemplateInfo r13 = ((m) this.L$0).a;
            ArrayList r0 = new ArrayList();
            long r1 = r13.h;
            Ref.IntRef r14 = new Ref.IntRef();
            Ref.IntRef r3 = new Ref.IntRef();
            l r4 = ImageListSelectorWidget.k6(this.this$0);
            boolean r5 = false;
            if (r4 == null) goto L20;
            List r6 = r4.a;
            if (r6 == null) goto L20;
            Iterator r7 = r6.iterator();
        L10:
            if (r7.hasNext() == false) goto L20;
            w r8 = (w) r7.next();
            r8.s = Boxing.boxInt(0);
            Long r9 = r8.a;
            if (r9 != null) goto L14;
        L16:
            boolean r10 = false;
        L17:
            if (r10 == false) goto L19;
            r8.s = Boxing.boxInt(1);
            r14.element = r3.element;
        L19:
            r3.element++;
            r0.add(r8);
            goto L10
        L14:
            if (r9.longValue() != r1) goto L16;
            r10 = true;
        L20:
            ImageSelectorWidgetAdapter r2 = this.this$0.i;
            if (r2 == null) goto L23;
            r2.submitList(r0);
        L23:
            l r11 = ImageListSelectorWidget.k6(this.this$0);
            Object r15 = null;
            if (r11 == null) goto L40;
            List r16 = r11.a;
            if (r16 == null) goto L40;
            Iterator r17 = r16.iterator();
        L29:
            if (r17.hasNext() == false) goto L39;
            Object r18 = r17.next();
            Integer r19 = ((w) r18).s;
            if (r19 != null) goto L34;
        L36:
            boolean r20 = false;
        L37:
            if (r20 == false) goto L29;
            r15 = r18;
            goto L39
        L34:
            if (r19.intValue() != 1) goto L36;
            r20 = true;
        L39:
            r15 = (w) r15;
        L40:
            u r21 = this.this$0.getInstructionItem();
            if (r21 == null) goto L48;
            Integer r22 = r21.a;
            if (r22 == null) goto L48;
            if (r22.intValue() != 1) goto L48;
            boolean r23 = true;
        L49:
            if (r23 == false) goto L55;
            com.larus.bmhome.view.actionbar.edit.c r24 = this.this$0.getViewModel();
            if (r24 == null) goto L55;
            if (r15 == null) goto L54;
            r5 = true;
        L54:
            r24.setImageStyleRadioSelected(r5);
        L55:
            RecyclerView.LayoutManager r25 = this.this$0.getBinding().c.getLayoutManager();
            if (r25 == null) goto L59;
            r25.scrollToPosition(r14.element);
        L59:
            return Unit.INSTANCE;
        L48:
            r23 = false;
            goto L49
        L61:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ImageListSelectorWidget$startObserveTemplateChoose$1(ImageListSelectorWidget r1, Continuation<? super ImageListSelectorWidget$startObserveTemplateChoose$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageListSelectorWidget$startObserveTemplateChoose$1(this.this$0, r3);
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
        ImageListSelectorWidget r7 = this.this$0;
        int r2 = ImageListSelectorWidget.l;
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
