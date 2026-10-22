package com.larus.bot.impl.feature.edit;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.StaticLayout;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.databinding.LarusPageBotEditBinding;
import com.larus.utils.logger.FLogger;
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
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/BotCreateUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.BotCreateFragment$bindObservers$1", f = "BotCreateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotCreateFragment$bindObservers$1 extends SuspendLambda implements Function2<e0, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotCreateFragment this$0;

    public BotCreateFragment$bindObservers$1(BotCreateFragment r1, Continuation<? super BotCreateFragment$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotCreateFragment$bindObservers$1 r0 = new BotCreateFragment$bindObservers$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(e0 r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((e0) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L101;
        ResultKt.throwOnFailure(r12);
        e0 r13 = (e0) this.L$0;
        if (Intrinsics.areEqual(r13, e0.c.a) == false) goto L9;
        ru8.b r14 = (ru8.b) s1a.a.g(this.this$0).getAbility(ru8.b.class);
        if (r14 == null) goto L97;
        r14.o20();
    L97:
        return Unit.INSTANCE;
    L9:
        boolean r1 = false;
        boolean r2 = true;
        if ((r13 instanceof e0.b) == false) goto L45;
        BotCreateFragment r0 = this.this$0;
        wu8.c r15 = ((e0.b) r13).a;
        LarusPageBotEditBinding r6 = r0.e;
        if (r6 == null) goto L97;
        if ((r15 instanceof wu8.c.d) == false) goto L17;
        r6.z.setText(((wu8.c.d) r15).a);
        goto L97
    L17:
        if ((r15 instanceof wu8.c.C0140c) == false) goto L42;
        final AppCompatEditText r7 = r6.o;
        Context r8 = r0.getContext();
        String r16 = ((wu8.c.C0140c) r15).a;
        int r9 = c7.b(64);
        ru8.c r10 = (ru8.c) s1a.a.g(r0).getAbility(ru8.c.class);
        if (r10 == null) goto L21;
        int r5 = r10.pk();
    L22:
        ru8.c r3 = (ru8.c) s1a.a.g(r0).getAbility(ru8.c.class);
        if (r3 == null) goto L25;
        int r4 = r3.SG();
    L26:
        if (r8 == null) goto L28;
        int r11 = com.larus.utils.i.d(r8);
    L29:
        StaticLayout r17 = com.larus.bot.impl.common.util.j.b(r7, r16, r11 - r9);
        if (r17.getLineCount() <= 4) goto L36;
        ViewGroup.LayoutParams r18 = r7.getLayoutParams();
        if (r18 == null) goto L35;
        r18.height = r5;
        r7.setLayoutParams(r18);
        r7.setText(r16);
        ValueAnimator r19 = ValueAnimator.ofInt(new int[]{r5, RangesKt.coerceAtMost(r4, r17.getHeight())});
        r19.setDuration(250);
        r19.addUpdateListener(new v(r7));
        Intrinsics.checkNotNull(r19);
        r19.addListener(new d0(r7));
        r19.setInterpolator(new AccelerateDecelerateInterpolator());
        r19.start();
        goto L97
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L36:
        r7.setText(r16);
        ViewGroup.LayoutParams r110 = r7.getLayoutParams();
        if (r110 == null) goto L40;
        r110.height = -2;
        r7.setLayoutParams(r110);
        goto L97
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        r11 = 0;
        goto L29
    L25:
        r4 = c7.b(196);
        goto L26
    L21:
        r5 = c7.b(100);
        goto L22
    L42:
        if ((r15 instanceof wu8.c.g) == false) goto L97;
        r0.aa0(((wu8.c.g) r15).a);
        goto L97
    L45:
        if ((r13 instanceof e0.a) == false) goto L99;
        BotCreateFragment r20 = this.this$0;
        e0.a r111 = (e0.a) r13;
        boolean r21 = r111.a;
        ContentType r112 = r111.b;
        int r22 = BotCreateFragment.J;
        r20.getClass();
        int r113 = BotCreateFragment.b.a[r112.ordinal()];
        if (r113 == 1) goto L86;
        if (r113 != 2) goto L50;
        if (r21 == false) goto L77;
        FLogger.a.i("BotCreateFragment", "showDescLoading");
        LarusPageBotEditBinding r114 = r20.e;
        if (r114 == null) goto L97;
        r114.o.clearFocus();
        AppCompatEditText r23 = r114.o;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if (r24 == null) goto L76;
        if (r114.l.getVisibility() == 0) goto L68;
        r2 = false;
    L68:
        if (r2 == true) goto L74;
        ru8.c r25 = (ru8.c) s1a.a.g(r20).getAbility(ru8.c.class);
        if (r25 == null) goto L72;
        int r26 = r25.pk();
    L73:
        r24.height = r26;
        goto L74
    L72:
        r26 = c7.b(100);
    L74:
        r23.setLayoutParams(r24);
        r114.o.setEnabled(false);
        r114.p.a.setVisibility(0);
        r20.j = com.larus.bot.impl.common.util.j.c(r114.p.b);
        r20.k = com.larus.bot.impl.common.util.j.c(r114.p.c);
        goto L97
    L76:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L77:
        FLogger.a.i("BotCreateFragment", "hideDescLoading");
        LarusPageBotEditBinding r115 = r20.e;
        if (r115 == null) goto L97;
        ObjectAnimator r27 = r20.j;
        if (r27 == null) goto L82;
        r27.cancel();
    L82:
        r20.j = null;
        ObjectAnimator r28 = r20.k;
        if (r28 == null) goto L85;
        r28.cancel();
    L85:
        r20.k = null;
        r115.p.a.setVisibility(8);
        r115.o.setEnabled(true);
        goto L97
    L50:
        if (r113 != 3) goto L97;
        if (r21 == false) goto L57;
        FLogger.a.i("BotCreateFragment", "showVoiceItemLoading");
        ItemTextArrow r116 = r20.y;
        if (r116 == null) goto L56;
        r116.c6();
    L56:
        r1 = true;
    L58:
        r20.B = r1;
        goto L97
    L57:
        r20.Y90();
        goto L58
    L86:
        if (r21 == false) goto L90;
        FLogger.a.i("BotCreateFragment", "showNameLoading");
        LarusPageBotEditBinding r117 = r20.e;
        if (r117 == null) goto L97;
        r117.z.clearFocus();
        r117.E.setVisibility(0);
        r117.B.setVisibility(8);
        r20.i = com.larus.bot.impl.common.util.j.c(r117.D);
        com.larus.utils.e1.x(r117.C);
        goto L97
    L90:
        FLogger.a.i("BotCreateFragment", "hideNameLoading");
        LarusPageBotEditBinding r118 = r20.e;
        if (r118 == null) goto L97;
        ObjectAnimator r29 = r20.i;
        if (r29 == null) goto L95;
        r29.cancel();
    L95:
        r20.i = null;
        r118.E.setVisibility(8);
        com.larus.utils.e1.o(r118.C);
        goto L97
    L99:
        throw new NoWhenBranchMatchedException();
    L101:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
