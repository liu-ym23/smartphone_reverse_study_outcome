package com.larus.bot.impl.feature.edit.feature.firstmet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.StaticLayout;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.appcompat.widget.AppCompatEditText;
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
import t19.s;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/firstmet/FirstMetEditUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.firstmet.BotFirstMetEditView$bindObservers$2", f = "BotFirstMetEditView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotFirstMetEditView$bindObservers$2 extends SuspendLambda implements Function2<m, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ h this$0;

    public BotFirstMetEditView$bindObservers$2(h r1, Continuation<? super BotFirstMetEditView$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotFirstMetEditView$bindObservers$2 r0 = new BotFirstMetEditView$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(m r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((m) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r8);
        m r9 = (m) this.L$0;
        if ((r9 instanceof m.a) == false) goto L8;
        m.a r10 = (m.a) r9;
        this.this$0.h.a(r10.a, r10.b);
    L38:
        return Unit.INSTANCE;
    L8:
        if ((r9 instanceof m.c) == false) goto L11;
        s r0 = s.a;
        Context r1 = this.this$0.f;
        int r11 = ((m.c) r9).a;
        r0.getClass();
        s.s(r1, r11);
        goto L38
    L11:
        if (Intrinsics.areEqual(r9, m.e.a) == false) goto L14;
        this.this$0.h.b.i6("Bot First Meet stop", false);
        goto L38
    L14:
        if ((r9 instanceof m.d) == false) goto L17;
        this.this$0.e.invoke();
        goto L38
    L17:
        if ((r9 instanceof m.b) == false) goto L40;
        final h r2 = this.this$0;
        m.b r12 = (m.b) r9;
        String r3 = r12.a;
        if (r12.b == false) goto L36;
        Context r13 = r2.f;
        if (r13 == null) goto L23;
        int r14 = com.larus.utils.i.d(r13);
    L24:
        StaticLayout r15 = com.larus.bot.impl.common.util.j.b(r2.b.b, r3, r14 - c7.b(64));
        if (r15.getLineCount() <= 2) goto L31;
        AppCompatEditText r4 = r2.b.b;
        ViewGroup.LayoutParams r6 = r4.getLayoutParams();
        if (r6 == null) goto L30;
        r6.height = r2.l;
        r4.setLayoutParams(r6);
        r2.b.b.setText(r3);
        ValueAnimator r16 = ValueAnimator.ofInt(new int[]{r2.l, RangesKt.coerceAtMost(r2.m, r15.getHeight())});
        r16.setDuration(250);
        r16.addUpdateListener(new a(r2));
        Intrinsics.checkNotNull(r16);
        r16.addListener(new i(r2));
        r16.setInterpolator(new AccelerateDecelerateInterpolator());
        r16.start();
        goto L38
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L31:
        r2.b.b.setText(r3);
        AppCompatEditText r17 = r2.b.b;
        ViewGroup.LayoutParams r5 = r17.getLayoutParams();
        if (r5 == null) goto L35;
        r5.height = -2;
        r17.setLayoutParams(r5);
        goto L38
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L23:
        r14 = 0;
        goto L24
    L36:
        r2.b.b.setText(r3);
        goto L38
    L40:
        throw new NoWhenBranchMatchedException();
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
