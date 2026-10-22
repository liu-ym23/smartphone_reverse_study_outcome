package com.larus.uaigc.image.instruction;

import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.uaigc.instruction.widget.ImageSelectorWithMoreWidgetAdapter;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateWidget$bindObservers$2", f = "ImageListSelectorWithMoreTemplateWidget.kt", i = {}, l = {345}, m = "invokeSuspend", n = {}, s = {})
final class ImageListSelectorWithMoreTemplateWidget$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ImageListSelectorWithMoreTemplateWidget this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ImageListSelectorWithMoreTemplateWidget a;

        public a(ImageListSelectorWithMoreTemplateWidget r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            List<w> r7 = (List) r5;
            if (this.a.isAttachedToWindow() == false) goto L53;
            n r8 = ImageListSelectorWithMoreTemplateWidget.o6(this.a);
            if (r8 == null) goto L8;
            r8.a = r7;
        L8:
            ImageSelectorWithMoreWidgetAdapter r9 = this.a.i;
            boolean r0 = false;
            if (r9 == null) goto L11;
            r9.y2(r7, false);
        L11:
            com.larus.bmhome.view.actionbar.edit.c r10 = this.a.getViewModel();
            if (r10 == null) goto L14;
            r10.setCurImageList(r7);
        L14:
            n r11 = ImageListSelectorWithMoreTemplateWidget.o6(this.a);
            Object r1 = null;
            if (r11 == null) goto L31;
            List r12 = r11.a;
            if (r12 == null) goto L31;
            Iterator<T> r13 = r12.iterator();
        L20:
            if (r13.hasNext() == false) goto L30;
            T r2 = r13.next();
            Integer r3 = ((w) r2).s;
            if (r3 != null) goto L25;
        L27:
            boolean r4 = false;
        L28:
            if (r4 == false) goto L20;
            r1 = r2;
            goto L30
        L25:
            if (r3.intValue() != 1) goto L27;
            r4 = true;
        L30:
            r1 = (w) r1;
        L31:
            u r14 = this.a.getInstructionItem();
            if (r14 == null) goto L39;
            Integer r15 = r14.a;
            if (r15 == null) goto L39;
            if (r15.intValue() != 1) goto L39;
            boolean r16 = true;
        L40:
            if (r16 == false) goto L47;
            com.larus.bmhome.view.actionbar.edit.c r17 = this.a.getViewModel();
            if (r17 == null) goto L47;
            if (r1 == null) goto L45;
            r0 = true;
        L45:
            r17.setImageStyleRadioSelected(r0);
        L47:
            return Unit.INSTANCE;
        L39:
            r16 = false;
            goto L40
        L53:
            return Unit.INSTANCE;
        }
    }

    public ImageListSelectorWithMoreTemplateWidget$bindObservers$2(ImageListSelectorWithMoreTemplateWidget r1, Continuation<? super ImageListSelectorWithMoreTemplateWidget$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageListSelectorWithMoreTemplateWidget$bindObservers$2(this.this$0, r3);
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
        ImageListSelectorWithMoreTemplateWidget r6 = this.this$0;
        int r2 = ImageListSelectorWithMoreTemplateWidget.o;
        com.larus.bmhome.view.actionbar.edit.c r7 = r6.getViewModel();
        if (r7 == null) goto L18;
        d1 r8 = r7.getImageListSelectorWithMoreRefreshFlow();
        if (r8 == null) goto L18;
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
