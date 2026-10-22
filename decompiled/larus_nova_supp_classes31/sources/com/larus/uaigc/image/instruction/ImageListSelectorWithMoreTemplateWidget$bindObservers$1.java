package com.larus.uaigc.image.instruction;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.view.actionbar.edit.m;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.instruction.widget.ImageSelectorWithMoreWidgetAdapter;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.d1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget$bindObservers$1", f = "ImageListSelectorWithMoreTemplateWidget.kt", i = {}, l = {304}, m = "invokeSuspend", n = {}, s = {})
final class ImageListSelectorWithMoreTemplateWidget$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageListSelectorWithMoreTemplateWidget this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget$bindObservers$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/view/actionbar/edit/InstructionPhotoTemplateWrapper;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget$bindObservers$1$1", f = "ImageListSelectorWithMoreTemplateWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<m, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ImageListSelectorWithMoreTemplateWidget this$0;

        public AnonymousClass1(ImageListSelectorWithMoreTemplateWidget r1, Continuation<? super AnonymousClass1> r2) {
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
            if (this.label != 0) goto L82;
            ResultKt.throwOnFailure(r12);
            TemplateInfo$TemplateInfo r13 = ((m) this.L$0).a;
            if (this.this$0.isAttachedToWindow() == false) goto L7;
            ArrayList r0 = new ArrayList();
            long r1 = r13.h;
            Ref.IntRef r14 = new Ref.IntRef();
            int r4 = 0;
            if (this.this$0.k == false) goto L11;
            int r3 = -1;
        L12:
            r14.element = r3;
            Ref.IntRef r5 = new Ref.IntRef();
            n r6 = ImageListSelectorWithMoreTemplateWidget.o6(this.this$0);
            if (r6 == null) goto L28;
            List r7 = r6.a;
            if (r7 == null) goto L28;
            Iterator r8 = r7.iterator();
        L18:
            if (r8.hasNext() == false) goto L28;
            w r9 = (w) r8.next();
            r9.s = Boxing.boxInt(0);
            Long r10 = r9.a;
            if (r10 != null) goto L22;
        L24:
            boolean r11 = false;
        L25:
            if (r11 == false) goto L27;
            r9.s = Boxing.boxInt(1);
            FLogger.a.d("ImageListSelectorWithMoreTemplateWidget", "selectItem:" + r9.b);
            r14.element = r5.element;
        L27:
            r5.element++;
            r0.add(r9);
            goto L18
        L22:
            if (r10.longValue() != r1) goto L24;
            r11 = true;
        L28:
            ImageSelectorWithMoreWidgetAdapter r2 = this.this$0.i;
            if (r2 == null) goto L31;
            Lazy<JSONObject> r15 = ImageSelectorWithMoreWidgetAdapter.e;
            r2.y2(r0, true);
        L31:
            com.larus.bmhome.view.actionbar.edit.c r16 = this.this$0.getViewModel();
            if (r16 == null) goto L34;
            r16.setCurImageList(r0);
        L34:
            n r17 = ImageListSelectorWithMoreTemplateWidget.o6(this.this$0);
            Object r18 = null;
            if (r17 == null) goto L51;
            List r19 = r17.a;
            if (r19 == null) goto L51;
            Iterator r20 = r19.iterator();
        L40:
            if (r20.hasNext() == false) goto L50;
            Object r21 = r20.next();
            Integer r22 = ((w) r21).s;
            if (r22 != null) goto L45;
        L47:
            boolean r23 = false;
        L48:
            if (r23 == false) goto L40;
            r18 = r21;
            goto L50
        L45:
            if (r22.intValue() != 1) goto L47;
            r23 = true;
        L50:
            r18 = (w) r18;
        L51:
            u r24 = this.this$0.getInstructionItem();
            if (r24 == null) goto L59;
            Integer r25 = r24.a;
            if (r25 == null) goto L59;
            if (r25.intValue() != 1) goto L59;
            boolean r26 = true;
        L60:
            if (r26 == false) goto L67;
            com.larus.bmhome.view.actionbar.edit.c r27 = this.this$0.getViewModel();
            if (r27 == null) goto L67;
            if (r18 == null) goto L65;
            boolean r28 = true;
        L66:
            r27.setImageStyleRadioSelected(r28);
            goto L67
        L65:
            r28 = false;
        L67:
            n r29 = ImageListSelectorWithMoreTemplateWidget.o6(this.this$0);
            if (r29 == null) goto L76;
            List r30 = r29.d;
            if (r30 == null) goto L76;
            w r31 = (w) CollectionsKt.firstOrNull(r30);
            if (r31 == null) goto L76;
            if (r31.j != true) goto L76;
            r4 = 1;
        L76:
            RecyclerView.LayoutManager r32 = this.this$0.getBinding().c.getLayoutManager();
            if (r32 == null) goto L80;
            r32.scrollToPosition(r14.element + r4);
        L80:
            return Unit.INSTANCE;
        L59:
            r26 = false;
            goto L60
        L11:
            r3 = 0;
            goto L12
        L7:
            return Unit.INSTANCE;
        L82:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ImageListSelectorWithMoreTemplateWidget$bindObservers$1(ImageListSelectorWithMoreTemplateWidget r1, Continuation<? super ImageListSelectorWithMoreTemplateWidget$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageListSelectorWithMoreTemplateWidget$bindObservers$1(this.this$0, r3);
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
        ImageListSelectorWithMoreTemplateWidget r7 = this.this$0;
        int r2 = ImageListSelectorWithMoreTemplateWidget.o;
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
