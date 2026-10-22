package com.larus.bot.impl.feature.edit.feature.firstmet;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bot.impl.databinding.LarusWidgetBotCreateTtsPlayerBinding;
import com.larus.bot.impl.feature.edit.feature.firstmet.sugget.BotSuggestsEditPanel;
import com.larus.bot.impl.feature.edit.feature.firstmet.tts.BotCreateTtsPlayerView;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.firstmet.BotFirstMetEditView$bindObservers$1", f = "BotFirstMetEditView.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
final class BotFirstMetEditView$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ h this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            n r13 = (n) r11;
            h r14 = this.a;
            r14.getClass();
            if (r13.a == true) goto L5;
            r14.b.a.setVisibility(8);
        L52:
            return Unit.INSTANCE;
        L5:
            r14.b.a.setVisibility(0);
            BotCreateTtsPlayerView r0 = r14.b.g;
            if (r13.b == false) goto L8;
            int r3 = 0;
        L9:
            r0.setVisibility(r3);
            int r1 = r13.c;
            if (r1 != 0) goto L12;
            LarusWidgetBotCreateTtsPlayerBinding r2 = r14.b.g.a;
            if (r2 == null) goto L31;
            r2.b.setImageResource(2131243596);
            r2.a.setAlpha(0.3f);
        L31:
            if (r13.g == false) goto L33;
            r14.b.b.setHint("");
            r14.b.b.setEnabled(false);
            r14.b.c.a.setVisibility(0);
            r14.k = com.larus.bot.impl.common.util.j.c(r14.b.c.a);
        L38:
            if (r13.d == false) goto L50;
            ItemTextArrow r4 = r14.b.f;
            Resources r5 = r14.f.getResources();
            if (r13.e == false) goto L42;
            int r9 = 2131901107;
        L43:
            String r6 = r5.getString(r9);
            int r10 = ItemTextArrow.k;
            r4.Z5(r6, null);
            BotSuggestsEditPanel r7 = r14.j;
            if (r7 == null) goto L49;
            r7.X90(r13.h);
            Triple<String, String, String> r15 = r13.f;
            Intrinsics.checkNotNullParameter(r15, "suggests");
            if (Intrinsics.areEqual(r7.T90(), r15) == true) goto L49;
            r7.Y90(r15);
            r7.W90(r15);
        L49:
            r14.b.d.setVisibility(0);
            r14.b.f.setVisibility(0);
            ConstraintLayout r16 = r14.b.a;
            int r17 = r16.getPaddingStart();
            int r8 = r16.getPaddingTop();
            int r18 = r16.getPaddingEnd();
            FLogger.a.i("updatePaddingRelative", "view:" + r16.getClass().getSimpleName() + ",source:,start:" + r17 + ",top:" + r8 + ",end:" + r18 + ",bottom:0");
            r16.setPaddingRelative(r17, r8, r18, 0);
            goto L52
        L42:
            r9 = 2131901106;
            goto L43
        L50:
            r14.b.d.setVisibility(8);
            r14.b.f.setVisibility(8);
            ConstraintLayout r19 = r14.b.a;
            int r110 = c7.b(16);
            int r20 = r19.getPaddingStart();
            int r21 = r19.getPaddingTop();
            int r22 = r19.getPaddingEnd();
            FLogger.a.i("updatePaddingRelative", "view:" + r19.getClass().getSimpleName() + ",source:,start:" + r20 + ",top:" + r21 + ",end:" + r22 + ",bottom:" + r110);
            r19.setPaddingRelative(r20, r21, r22, r110);
            goto L52
        L33:
            r14.b.b.setHint(r14.f.getResources().getString(2131901101));
            r14.b.c.a.setVisibility(8);
            r14.b.b.setEnabled(true);
            ObjectAnimator r23 = r14.k;
            if (r23 == null) goto L36;
            r23.cancel();
        L36:
            r14.k = null;
            goto L38
        L12:
            if (r1 != 1) goto L14;
            LarusWidgetBotCreateTtsPlayerBinding r24 = r14.b.g.a;
            if (r24 == null) goto L31;
            r24.b.setImageResource(2131243596);
            r24.a.setAlpha(1.0f);
            goto L31
        L14:
            if (r1 != 2) goto L16;
            LarusWidgetBotCreateTtsPlayerBinding r25 = r14.b.g.a;
            if (r25 == null) goto L31;
            r25.b.setRepeatMode(1);
            r25.b.setRepeatCount(-1);
            r25.b.setAnimation("lottie/text_msg_voice_loading.json");
            r25.b.playAnimation();
            r25.a.setAlpha(1.0f);
            goto L31
        L16:
            if (r1 != 3) goto L31;
            LarusWidgetBotCreateTtsPlayerBinding r26 = r14.b.g.a;
            if (r26 == null) goto L31;
            r26.b.setRepeatMode(1);
            r26.b.setRepeatCount(-1);
            r26.b.setAnimation("lottie/text_msg_voice_playing.json");
            r26.b.playAnimation();
            r26.a.setAlpha(1.0f);
            goto L31
        L8:
            r3 = 8;
            goto L9
        }
    }

    public BotFirstMetEditView$bindObservers$1(h r1, Continuation<? super BotFirstMetEditView$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotFirstMetEditView$bindObservers$1(this.this$0, r3);
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
        i1<n> r6 = this.this$0.c.getUiState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
