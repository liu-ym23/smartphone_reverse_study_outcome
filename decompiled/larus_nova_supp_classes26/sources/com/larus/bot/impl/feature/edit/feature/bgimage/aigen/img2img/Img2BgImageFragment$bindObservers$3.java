package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.view.animation.RotateAnimation;
import com.larus.bot.impl.databinding.LarusPageBotBgImageGenerateBinding;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.Img2BgImageFragment$bindObservers$3", f = "Img2BgImageFragment.kt", i = {}, l = {350}, m = "invokeSuspend", n = {}, s = {})
final class Img2BgImageFragment$bindObservers$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Img2BgImageFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Img2BgImageFragment a;

        public a(Img2BgImageFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.f r7 = (com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.f) r5;
            Img2BgImageFragment r8 = this.a;
            LarusPageBotBgImageGenerateBinding r0 = r8.e;
            if (r0 == null) goto L21;
            r0.b.setHint(r7.a.toString(r0.a.getContext()));
            int r1 = r8.k;
            int r2 = r7.c;
            if (r1 == r2) goto L19;
            if (r2 != 0) goto L8;
            PromptInputButtonView r3 = r0.c;
            RotateAnimation r4 = r3.b;
            if (r4 == null) goto L17;
            r4.cancel();
        L17:
            r3.b = null;
            r3.a.b.setImageResource(2131243591);
        L18:
            r8.k = r7.c;
            goto L19
        L8:
            if (r2 != 1) goto L10;
            r0.c.a();
            goto L18
        L10:
            if (r2 != 2) goto L18;
            r0.c.a();
        L19:
            Unit r9 = Unit.INSTANCE;
        L21:
            return Unit.INSTANCE;
        }
    }

    public Img2BgImageFragment$bindObservers$3(Img2BgImageFragment r1, Continuation<? super Img2BgImageFragment$bindObservers$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new Img2BgImageFragment$bindObservers$3(this.this$0, r3);
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
        Img2BgImageFragment r6 = this.this$0;
        int r2 = Img2BgImageFragment.o;
        i1<com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.f> r7 = r6.V90().getPromptGenerateViewModel().getUiState();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
