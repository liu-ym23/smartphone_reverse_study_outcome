package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.larus.bot.impl.databinding.LarusPageBotBgImageGenerateBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.BgPromptGenerateDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.Img2BgImageFragment$bindObservers$4", f = "Img2BgImageFragment.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
final class Img2BgImageFragment$bindObservers$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Img2BgImageFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Img2BgImageFragment a;

        public a(Img2BgImageFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e r6 = (com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e) r4;
            if ((r6 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e.a) == false) goto L10;
            LarusPageBotBgImageGenerateBinding r7 = this.a.e;
            if (r7 == null) goto L22;
            TextView r8 = r7.b;
            if (r8 == null) goto L22;
            r8.setText(((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e.a) r6).a);
        L22:
            return Unit.INSTANCE;
        L10:
            if ((r6 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e.b) == false) goto L17;
            Img2BgImageFragment r9 = this.a;
            String r10 = ((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e.b) r6).a;
            int r0 = Img2BgImageFragment.o;
            r9.getClass();
            BgPromptGenerateDialog r1 = new BgPromptGenerateDialog();
            com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.i r2 = r9.V90().getPromptGenerateViewModel();
            Intrinsics.checkNotNullParameter(r2, "vm");
            r1.h = r2;
            Intrinsics.checkNotNullParameter(r10, "prompt");
            r1.j = r10;
            FragmentManager r11 = r9.getParentFragmentManager();
            LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "AIGenBgImageChooseDialog", r12);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r1, r12) == true) goto L22;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
        L15:
            r1.show(r11, "AIGenBgImageChooseDialog");
            goto L22
        L17:
            if ((r6 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e.c) == false) goto L24;
            if (this.a.getViewLifecycleOwner().getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L22;
            t19.s r13 = t19.s.a;
            Context r3 = this.a.getContext();
            String r14 = ((com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e.c) r6).a.toString(this.a.getContext());
            r13.getClass();
            t19.s.c(r3, r14);
            goto L22
        L24:
            throw new NoWhenBranchMatchedException();
        }
    }

    public Img2BgImageFragment$bindObservers$4(Img2BgImageFragment r1, Continuation<? super Img2BgImageFragment$bindObservers$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new Img2BgImageFragment$bindObservers$4(this.this$0, r3);
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
        d1<com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.prompt.e> r7 = r6.V90().getPromptGenerateViewModel().getUiEvent();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
