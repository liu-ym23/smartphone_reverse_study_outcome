package com.larus.business.floatchat.impl.component;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.larus.audio.IFlowTtsClientService;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "status", "", "needAnim", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.component.AIFloatChatFoldHandlerComponent$observe$3", f = "AIFloatChatFoldHandlerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIFloatChatFoldHandlerComponent$observe$3 extends SuspendLambda implements Function3<Integer, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ AIFloatChatFoldHandlerComponent this$0;

    public AIFloatChatFoldHandlerComponent$observe$3(AIFloatChatFoldHandlerComponent r1, Continuation<? super AIFloatChatFoldHandlerComponent$observe$3> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Object invoke(int r3, boolean r4, Continuation<? super Unit> r5) {
        AIFloatChatFoldHandlerComponent$observe$3 r0 = new AIFloatChatFoldHandlerComponent$observe$3(this.this$0, r5);
        r0.I$0 = r3;
        r0.Z$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Number) r1).intValue(), ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r6);
        int r7 = this.I$0;
        boolean r0 = this.Z$0;
        if (r7 == 0) goto L17;
        if (r7 == 1) goto L13;
        if (r7 != 2) goto L30;
        AIFloatChatFoldHandlerComponent.Y2(this.this$0, r0);
        Iterator<va8.d> r8 = this.this$0.v.iterator();
    L11:
        if (r8.hasNext() == false) goto L30;
        r8.next().foldStatusChanged();
    L30:
        return Unit.INSTANCE;
    L13:
        AIFloatChatFoldHandlerComponent.Y2(this.this$0, r0);
        Iterator<va8.d> r9 = this.this$0.v.iterator();
    L15:
        if (r9.hasNext() == false) goto L30;
        r9.next().foldStatusChanged();
        goto L15
    L17:
        final AIFloatChatFoldHandlerComponent r10 = this.this$0;
        int r3 = AIFloatChatFoldHandlerComponent.S;
        if (r0 == false) goto L24;
        final int r1 = ((Number) r10.H.getValue()).intValue();
        int[] r2 = new int[2];
        View r4 = r10.y;
        if (r4 == null) goto L22;
        int r5 = r4.getHeight();
    L23:
        r2[0] = r5;
        r2[1] = r1;
        ValueAnimator r11 = ValueAnimator.ofInt(r2).setDuration(150);
        r11.addUpdateListener(new r(r10, r1));
        Intrinsics.checkNotNull(r11);
        d2a.g.c(r11, new t(r10));
        r11.setInterpolator(new LinearInterpolator());
        r11.start();
    L25:
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().f("FoldFloatChat");
        Iterator<va8.d> r12 = this.this$0.v.iterator();
    L27:
        if (r12.hasNext() == false) goto L30;
        r12.next().foldStatusChanged();
        goto L27
    L22:
        r5 = r1;
        goto L23
    L24:
        r10.getClass();
        AIFloatChatFoldHandlerComponent.h3(r10);
        goto L25
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
