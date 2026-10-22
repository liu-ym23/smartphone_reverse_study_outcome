package com.larus.bot.impl.feature.edit.feature.bio;

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
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/bio/BioEditUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bio.BotBioEditView$bindObservers$2", f = "BotBioEditView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotBioEditView$bindObservers$2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ f this$0;

    public BotBioEditView$bindObservers$2(f r1, Continuation<? super BotBioEditView$bindObservers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotBioEditView$bindObservers$2 r0 = new BotBioEditView$bindObservers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(b r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((b) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r8);
        b r9 = (b) this.L$0;
        if ((r9 instanceof b.a) == false) goto L28;
        final f r0 = this.this$0;
        b.a r10 = (b.a) r9;
        String r1 = r10.a;
        if (r10.b == false) goto L24;
        Context r11 = r0.c;
        if (r11 == null) goto L11;
        int r12 = com.larus.utils.i.d(r11);
    L12:
        StaticLayout r13 = com.larus.bot.impl.common.util.j.b(r0.a.b, r1, r12 - c7.b(64));
        if (r13.getLineCount() <= 2) goto L19;
        AppCompatEditText r3 = r0.a.b;
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
        if (r6 == null) goto L18;
        r6.height = r0.f;
        r3.setLayoutParams(r6);
        r0.a.b.setText(r1);
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{r0.f, RangesKt.coerceAtMost(r0.g, r13.getHeight())});
        r14.setDuration(250);
        r14.addUpdateListener(new d(r0));
        Intrinsics.checkNotNull(r14);
        r14.addListener(new g(r0));
        r14.setInterpolator(new AccelerateDecelerateInterpolator());
        r14.start();
    L26:
        return Unit.INSTANCE;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L19:
        r0.a.b.setText(r1);
        AppCompatEditText r15 = r0.a.b;
        ViewGroup.LayoutParams r2 = r15.getLayoutParams();
        if (r2 == null) goto L23;
        r2.height = -2;
        r15.setLayoutParams(r2);
        goto L26
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L11:
        r12 = 0;
        goto L12
    L24:
        r0.a.b.setText(r1);
        goto L26
    L28:
        throw new NoWhenBranchMatchedException();
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
