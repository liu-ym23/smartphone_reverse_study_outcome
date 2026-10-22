package com.obric.flow.cardlistpage.apm;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.ControllerState;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.u;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f11446a;

    public c(d r5) {
        this.f11446a = r5;
    }

    public final Object b(boolean r10, Continuation r11) {
        if ((r11 instanceof FeedPerformanceMonitor$observeOverlayAnimation$3$2$emit$1) == false) goto L7;
        FeedPerformanceMonitor$observeOverlayAnimation$3$2$emit$1 r5 = (FeedPerformanceMonitor$observeOverlayAnimation$3$2$emit$1) r11;
        int r12 = r5.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        c this = (c) r5.L$0;
        ResultKt.throwOnFailure(r13);
    L20:
        if (((u) this.f11446a.f11447a.b()).d() != ControllerState.HIDDEN) goto L23;
        com.lynx.animax.player.e r16 = this.f11446a.f11449c;
        r16.getClass();
        Intrinsics.checkNotNullParameter("Panel_Closed_Idle", "scene");
        z r17 = Dispatchers.getIO();
        ResourceMonitor$reportFullMemory$1 r18 = new ResourceMonitor$reportFullMemory$1("Panel_Closed_Idle", null);
        BuildersKt.launch$default((kotlinx.coroutines.internal.c) r16.f9667c, r17, null, r18, 2, null);
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (r10 == false) goto L23;
        r5.L$0 = this;
        r5.label = 1;
        if (DelayKt.delay(WsConstants.EXIT_DELAY_TIME, r5) != r14) goto L20;
        return r14;
    L7:
        r5 = new FeedPerformanceMonitor$observeOverlayAnimation$3$2$emit$1(this, r11);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.h
    public final /* bridge */ /* synthetic */ Object emit(Object r5, Continuation r10) {
        return b(((Boolean) r5).booleanValue(), r10);
    }
}
