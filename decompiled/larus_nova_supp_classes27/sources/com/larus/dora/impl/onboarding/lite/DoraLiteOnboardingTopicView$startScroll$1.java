package com.larus.dora.impl.onboarding.lite;

import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingTopicView$startScroll$1", f = "DoraLiteOnboardingTopicView.kt", i = {0}, l = {171}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DoraLiteOnboardingTopicView$startScroll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DoraLiteOnboardingTopicView this$0;

    public DoraLiteOnboardingTopicView$startScroll$1(DoraLiteOnboardingTopicView r1, Continuation<? super DoraLiteOnboardingTopicView$startScroll$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraLiteOnboardingTopicView$startScroll$1 r0 = new DoraLiteOnboardingTopicView$startScroll$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0036 -> B:14:0x0039). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        ?? r4 = 1;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r23);
        DoraLiteOnboardingTopicView$startScroll$1 r6 = this;
    L14:
        final DoraLiteOnboardingTopicView r15 = r6.this$0;
        final FrameLayout r14 = r15.l;
        if (r15.h == true) goto L18;
        r15.h = r4;
        final View r13 = r14.getChildAt(r15.g);
        final int r12 = (r15.g + r4) % r14.getChildCount();
        View r7 = r14.getChildAt(r12);
        final int r11 = r15.k.getWidth();
        final int r10 = r15.k.getHeight();
        float r8 = r7.getWidth() * r15.c;
        final float r16 = r8 - r11;
        final float r17 = (r7.getHeight() * r15.c) - r10;
        g49.d.a("DoraOnboardingTopicView", "scrollToNext() called ####y=" + r7.getY() + ", height=" + ((r13.getHeight() * r15.c) + r15.d));
        float r9 = (((float) 0) - r7.getY()) - ((((float) r7.getHeight()) * (((float) r4) - r15.c)) / ((float) 2));
        final float r18 = ((((float) r7.getHeight()) + (((float) r13.getHeight()) * r15.c)) + ((float) r15.d)) - (((float) r7.getHeight()) * r15.c);
        final List r20 = SequencesKt.toList(SequencesKt.map(ViewGroupKt.getChildren(r14), new u()));
        r7.animate().scaleX(r15.c).scaleY(r15.c).setDuration(360).translationYBy(r9).setUpdateListener(new v(r15, r14, r20, r13, r12, r18, r11, r16, r10, r17)).withEndAction(new w(r15, r14, r13, r12)).start();
    L18:
        r6 = r6;
        r5 = r5;
        r1 = r1;
        r3 = true;
    L10:
        if (CoroutineScopeKt.isActive(r5) == false) goto L20;
        r6.L$0 = r5;
        r6.label = r3 ? 1 : 0;
        r4 = r3;
        if (DelayKt.delay(4000, r6) != r1) goto L14;
        return r1;
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        r5 = (CoroutineScope) this.L$0;
        r6 = this;
        goto L10
    }
}
