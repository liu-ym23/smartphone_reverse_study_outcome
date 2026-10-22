package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.content.res.Resources;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.bot.impl.databinding.LarusLayoutBotEditBgImageBinding;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.larus.utils.w0;
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
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditView$bindObservers$1", f = "BotBgImageEditView.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
final class BotBgImageEditView$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotBgImageEditView this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BotBgImageEditView a;

        public a(BotBgImageEditView r1) {
            this.a = r1;
        }

        public final Object emit(Object r25, Continuation r26) {
            c r0 = (c) r25;
            final BotBgImageEditView r2 = this.a;
            LarusLayoutBotEditBgImageBinding r3 = r2.b;
            e10 r4 = e10.a;
            boolean r5 = true;
            if (e10.B0() == true) goto L5;
            r3.b.setEnabled(true);
        L5:
            int r6 = 8;
            if (r0.f == false) goto L8;
            r3.f.setVisibility(0);
            r3.d.setAlpha(0.3f);
            r3.d.setEnabled(false);
        L9:
            r3.d.setText(r0.d.toString(r2.b.a.getContext()));
            TextView r7 = r3.d;
            Resources r8 = r2.b.a.getContext().getResources();
            if (r0.e == false) goto L12;
            int r9 = 2131103203;
        L13:
            r7.setTextColor(r8.getColor(r9));
            if (r0.c == false) goto L24;
            LarusLayoutBotEditBgImageBinding r10 = r2.b;
            FrameLayout r11 = r10.c;
            ViewGroup.LayoutParams r12 = r11.getLayoutParams();
            if (r12 == null) goto L23;
            int r13 = c7.b(Integer.valueOf(r2.k));
            r12.height = r13;
            r12.width = r13;
            r11.setLayoutParams(r12);
            if (((c) r2.c.getUiState().getValue()).f == false) goto L20;
            w0.e(r10.c, c7.b(80));
            RoundingParams r14 = RoundingParams.fromCornersRadius(0.0f);
            r10.b.getHierarchy().setRoundingParams(r14);
        L21:
            r10.b.getHierarchy().setPlaceholderImage(2131243587);
        L27:
            Uri r15 = r0.a;
            if (r15 == null) goto L38;
            r3.e.setVisibility(8);
            if (r0.c == false) goto L32;
            int r16 = c7.b(Integer.valueOf(r2.k));
        L34:
            if (r0.c == false) goto L36;
            int r1 = r16;
        L37:
            com.larus.bot.impl.common.util.h.a(r3.b, r15, "bot_bg_image_edit_refresh", false, Integer.valueOf(r16), Integer.valueOf(r1), true, new i(r2));
        L48:
            return Unit.INSTANCE;
        L36:
            r1 = c7.b(Integer.valueOf(r2.l));
            goto L37
        L32:
            r16 = c7.b(Integer.valueOf(r2.m));
            goto L34
        L38:
            com.larus.bot.impl.common.util.h.b(r3.b, null, null, false, null, null, null, 124);
            RoundFrameLayout r17 = r3.e;
            if (r0.c == true) goto L41;
        L43:
            r5 = false;
        L44:
            if (r5 == false) goto L46;
            r6 = 0;
        L46:
            r17.setVisibility(r6);
            r3.g.setImageResource(2131243588);
            e1.d(r3.e, new j(r2));
            goto L48
        L41:
            if (e10.B0() == true) goto L43;
        L20:
            FrameLayout r18 = r10.c;
            r18.setOutlineProvider(null);
            r18.setClipToOutline(false);
            RoundingParams r19 = RoundingParams.asCircle();
            r10.b.getHierarchy().setRoundingParams(r19);
            goto L21
        L23:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L24:
            LarusLayoutBotEditBgImageBinding r20 = r2.b;
            FrameLayout r110 = r20.c;
            ViewGroup.LayoutParams r111 = r110.getLayoutParams();
            if (r111 == null) goto L50;
            r111.height = c7.b(Integer.valueOf(r2.l));
            r111.width = c7.b(Integer.valueOf(r2.m));
            r110.setLayoutParams(r111);
            w0.e(r20.c, c7.b(16));
            RoundingParams r21 = RoundingParams.fromCornersRadius(0.0f);
            r20.b.getHierarchy().setRoundingParams(r21);
            r20.b.getHierarchy().setPlaceholderImage(2131103159);
            goto L27
        L50:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L12:
            r9 = 2131103136;
            goto L13
        L8:
            r3.f.setVisibility(8);
            r3.d.setEnabled(true);
            r3.d.setAlpha(1.0f);
            goto L9
        }
    }

    public BotBgImageEditView$bindObservers$1(BotBgImageEditView r1, Continuation<? super BotBgImageEditView$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotBgImageEditView$bindObservers$1(this.this$0, r3);
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
        i1<c> r6 = this.this$0.c.getUiState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
