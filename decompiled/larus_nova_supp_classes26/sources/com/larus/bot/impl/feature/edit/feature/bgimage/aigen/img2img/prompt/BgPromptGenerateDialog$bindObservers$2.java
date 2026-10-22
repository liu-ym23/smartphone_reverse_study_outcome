package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt;

import android.content.Context;
import android.text.Editable;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.bot.impl.databinding.LarusDialogBgPromptGenerateBinding;
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
import kotlinx.coroutines.flow.d1;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.BgPromptGenerateDialog$bindObservers$2", f = "BgPromptGenerateDialog.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
final class BgPromptGenerateDialog$bindObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BgPromptGenerateDialog this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BgPromptGenerateDialog a;

        public a(BgPromptGenerateDialog r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            e r5 = (e) r3;
            if ((r5 instanceof e.a) == false) goto L16;
            LarusDialogBgPromptGenerateBinding r6 = this.a.d;
            if (r6 == null) goto L23;
            AppCompatEditText r7 = r6.b;
            if (r7 == null) goto L23;
            e.a r8 = (e.a) r5;
            if (Intrinsics.areEqual(String.valueOf(r7.getText()), r8.a) == true) goto L23;
            r7.setText(r8.a);
            Editable r9 = r7.getText();
            if (r9 == null) goto L13;
            int r10 = r9.length();
        L14:
            r7.setSelection(r10);
            goto L23
        L13:
            r10 = 0;
        L23:
            return Unit.INSTANCE;
        L16:
            if ((r5 instanceof e.b) == true) goto L23;
            if ((r5 instanceof e.c) == false) goto L21;
            s r11 = s.a;
            Context r0 = this.a.getContext();
            String r12 = ((e.c) r5).a.toString(this.a.getContext());
            r11.getClass();
            s.c(r0, r12);
            goto L23
        L21:
            throw new NoWhenBranchMatchedException();
        }
    }

    public BgPromptGenerateDialog$bindObservers$2(BgPromptGenerateDialog r1, Continuation<? super BgPromptGenerateDialog$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BgPromptGenerateDialog$bindObservers$2(this.this$0, r3);
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
        d1<e> r7 = r6.getUiEvent();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
