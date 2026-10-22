package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import android.text.Editable;
import android.view.animation.RotateAnimation;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.bot.impl.databinding.LarusDialogBgPromptGenerateBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.PromptInputButtonView;
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
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.BgPromptGenerateDialog$bindObservers$1", f = "BgPromptGenerateDialog.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
final class BgPromptGenerateDialog$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BgPromptGenerateDialog this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BgPromptGenerateDialog a;

        public a(BgPromptGenerateDialog r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            f r8 = (f) r6;
            BgPromptGenerateDialog r9 = this.a;
            LarusDialogBgPromptGenerateBinding r0 = r9.d;
            if (r0 == null) goto L29;
            r0.b.setHint(r8.a.toString(r0.a.getContext()));
            if (r9.f == false) goto L13;
            r0.b.setFocusable(!r8.b);
            r0.b.setFocusableInTouchMode(!r8.b);
            int r3 = 0;
            if (r8.b == false) goto L9;
            r0.b.setInputType(0);
            goto L13
        L9:
            r0.b.setInputType(131072);
            r0.b.setSingleLine(false);
            AppCompatEditText r1 = r0.b;
            Editable r4 = r1.getText();
            if (r4 == null) goto L12;
            r3 = r4.length();
        L12:
            r1.setSelection(r3);
        L13:
            int r2 = r9.i;
            int r5 = r8.c;
            if (r2 == r5) goto L27;
            if (r5 == 0) goto L22;
            if (r5 != 1) goto L18;
            r0.c.a();
        L26:
            r9.i = r8.c;
            goto L27
        L18:
            if (r5 != 2) goto L26;
            r0.c.a();
            goto L26
        L22:
            PromptInputButtonView r10 = r0.c;
            RotateAnimation r11 = r10.b;
            if (r11 == null) goto L25;
            r11.cancel();
        L25:
            r10.b = null;
            r10.a.b.setImageResource(2131243591);
        L27:
            Unit r12 = Unit.INSTANCE;
        L29:
            return Unit.INSTANCE;
        }
    }

    public BgPromptGenerateDialog$bindObservers$1(BgPromptGenerateDialog r1, Continuation<? super BgPromptGenerateDialog$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BgPromptGenerateDialog$bindObservers$1(this.this$0, r3);
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
        i r6 = this.this$0.h;
        if (r6 == null) goto L18;
        i1<f> r7 = r6.getUiState();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
