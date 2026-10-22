package com.larus.bmhome.floatchat.component;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.larus.audio.IFlowTtsClientService;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
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
@DebugMetadata(c = "com.larus.bmhome.floatchat.component.FloatChatFoldHandlerComponent$observe$3", f = "FloatChatFoldHandlerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FloatChatFoldHandlerComponent$observe$3 extends SuspendLambda implements Function3<Integer, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ FloatChatFoldHandlerComponent this$0;

    public FloatChatFoldHandlerComponent$observe$3(FloatChatFoldHandlerComponent r1, Continuation<? super FloatChatFoldHandlerComponent$observe$3> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Object invoke(int r3, boolean r4, Continuation<? super Unit> r5) {
        FloatChatFoldHandlerComponent$observe$3 r0 = new FloatChatFoldHandlerComponent$observe$3(this.this$0, r5);
        r0.I$0 = r3;
        r0.Z$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Number) r1).intValue(), ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r7);
        int r8 = this.I$0;
        boolean r0 = this.Z$0;
        if (r8 == 0) goto L17;
        if (r8 == 1) goto L13;
        if (r8 != 2) goto L40;
        FloatChatFoldHandlerComponent.Y2(this.this$0, r0);
        Iterator<va8.d> r9 = this.this$0.x.iterator();
    L11:
        if (r9.hasNext() == false) goto L40;
        r9.next().foldStatusChanged();
    L40:
        return Unit.INSTANCE;
    L13:
        FloatChatFoldHandlerComponent.Y2(this.this$0, r0);
        Iterator<va8.d> r10 = this.this$0.x.iterator();
    L15:
        if (r10.hasNext() == false) goto L40;
        r10.next().foldStatusChanged();
        goto L15
    L17:
        final FloatChatFoldHandlerComponent r11 = this.this$0;
        int r3 = FloatChatFoldHandlerComponent.H1;
        r11.m3();
        if (r11.h4() == false) goto L25;
        np8.a r1 = r11.E3();
        if (r1 == null) goto L22;
        r1.La();
    L22:
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().f("FoldFloatChat");
        r11.h3(false);
        IChatMessageShareAbility r12 = (IChatMessageShareAbility) r11.v.getValue();
        if (r12 == null) goto L35;
        r12.j();
    L35:
        Iterator<va8.d> r13 = this.this$0.x.iterator();
    L37:
        if (r13.hasNext() == false) goto L40;
        r13.next().foldStatusChanged();
        goto L37
    L25:
        if (r0 == false) goto L31;
        final int r2 = r11.Q3();
        int[] r4 = new int[2];
        View r5 = r11.A;
        if (r5 == null) goto L29;
        int r6 = r5.getHeight();
    L30:
        r4[0] = r6;
        r4[1] = r2;
        ValueAnimator r14 = ValueAnimator.ofInt(r4).setDuration(r11.D3());
        r14.addUpdateListener(new p(r11, r2));
        Intrinsics.checkNotNull(r14);
        d2a.g.c(r14, new q(r11));
        r14.setInterpolator(new LinearInterpolator());
        r14.start();
    L32:
        IFlowTtsClientService.a.getClass();
        IFlowTtsClientService.a.a().f("FoldFloatChat");
        r11.h3(false);
        IChatMessageShareAbility r15 = (IChatMessageShareAbility) r11.v.getValue();
        if (r15 == null) goto L35;
        r15.j();
        goto L35
    L29:
        r6 = r2;
        goto L30
    L31:
        FloatChatFoldHandlerComponent.z3(r11);
        goto L32
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
