package com.larus.dora.impl.alive;

import android.text.format.DateUtils;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.b0;
import com.larus.settings.value.e10;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.alive.DoraKeepAliveBalloon$checkShowState$1", f = "DoraKeepAliveBalloon.kt", i = {3, 3}, l = {152, 164, 174, 178, 184, 190, 198, 202, 208}, m = "invokeSuspend", n = {"device", "recentShownTime"}, s = {"L$0", "L$1"})
final class DoraKeepAliveBalloon$checkShowState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;

    public DoraKeepAliveBalloon$checkShowState$1(Continuation<? super DoraKeepAliveBalloon$checkShowState$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraKeepAliveBalloon$checkShowState$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r5 = false;
        switch(this.label) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L8;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r13);
    L101:
        boolean r14 = ((Boolean) r13).booleanValue();
        g49.d.d("DoraKeepAliveBalloon", "checkShowState: hasQueryFailed = " + r14);
        StateFlowImpl r1 = h.b;
        Boolean r15 = Boxing.boxBoolean(r14);
        this.label = 9;
        r1.setValue(r15);
        if (Unit.INSTANCE != r0) goto L105;
        return r0;
    L105:
        return Unit.INSTANCE;
    L7:
        ResultKt.throwOnFailure(r13);
    L97:
        return Unit.INSTANCE;
    L8:
        ResultKt.throwOnFailure(r13);
        goto L105
    L9:
        ResultKt.throwOnFailure(r13);
    L58:
        return Unit.INSTANCE;
    L10:
        List r2 = (List) this.L$1;
        DoraDevice r6 = (DoraDevice) this.L$0;
        ResultKt.throwOnFailure(r13);
    L53:
        if (((Boolean) r13).booleanValue() == false) goto L59;
        g49.d.d("DoraKeepAliveBalloon", "checkShowState: hasQueryFailed = true");
        StateFlowImpl r16 = h.b;
        Boolean r3 = Boxing.boxBoolean(true);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 5;
        r16.setValue(r3);
        if (Unit.INSTANCE != r0) goto L58;
        return r0;
    L59:
        Lazy r17 = h.d;
        if (a.a((IFlowCompanionDeviceManager) r17.getValue()) == false) goto L79;
        IFlowCompanionDeviceManager r4 = (IFlowCompanionDeviceManager) r17.getValue();
        if (r4 != null) goto L64;
    L66:
        boolean r7 = false;
    L67:
        if (r7 == false) goto L76;
        IFlowCompanionDeviceManager r18 = (IFlowCompanionDeviceManager) r17.getValue();
        if (r18 != null) goto L71;
    L73:
        boolean r110 = false;
    L74:
        if (r110 == false) goto L76;
        r5 = true;
        goto L76
    L71:
        if (r18.m(r6.mac) != true) goto L73;
        r110 = true;
    L76:
        StateFlowImpl r111 = h.b;
        Boolean r8 = Boxing.boxBoolean(!r5);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 6;
        r111.setValue(r8);
        if (Unit.INSTANCE != r0) goto L105;
        return r0;
    L64:
        if (r4.b(r6.mac) != true) goto L66;
        r7 = true;
        goto L67
    L79:
        List r9 = r2;
        if ((r9 instanceof Collection) == true) goto L82;
    L84:
        Iterator r112 = r9.iterator();
        int r10 = 0;
    L86:
        if (r112.hasNext() == false) goto L92;
        if (DateUtils.isToday(((Number) r112.next()).longValue()) == false) goto L86;
        r10 = r10 + 1;
        if (r10 >= 0) goto L86;
        CollectionsKt.throwCountOverflow();
    L92:
        if (r10 < 2) goto L98;
        g49.d.d("DoraKeepAliveBalloon", "checkShowState: today is shown more than 2");
        StateFlowImpl r113 = h.b;
        Boolean r11 = Boxing.boxBoolean(false);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 7;
        r113.setValue(r11);
        if (Unit.INSTANCE != r0) goto L97;
        return r0;
    L98:
        kj4.a r114 = kj4.a.g();
        this.L$0 = null;
        this.L$1 = null;
        this.label = 8;
        r13 = DoraAdapterExtKt.s(r114);
        if (r13 != r0) goto L101;
        return r0;
    L82:
        if (r9.isEmpty() == false) goto L84;
        r10 = 0;
        goto L92
    L11:
        ResultKt.throwOnFailure(r13);
    L48:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r13);
    L110:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r13);
    L35:
        return Unit.INSTANCE;
    L14:
        ResultKt.throwOnFailure(r13);
        e10 r115 = e10.a;
        boolean r116 = e10.N();
        b0.a.getClass();
        if (b0.j().getBoolean("dora_cdm_keep_alive_nova", false) == false) goto L18;
        if (r116 == true) goto L18;
        boolean r12 = true;
    L19:
        int r20 = b0.j().getInt("dora_keep_alive_balloon_close_times", 0);
        int r21 = h.c;
        if (r20 <= r21) goto L22;
        boolean r22 = true;
    L23:
        g49.d.d("DoraKeepAliveBalloon", "closeTimes=" + b0.j().getInt("dora_keep_alive_balloon_close_times", 0) + ", bubbleCounts=" + r21 + ", isCdmKeepAliveNovaClosed=" + r12 + ", isCdmKeepAliveNovaEnabled=" + r116);
        if (r22 == false) goto L29;
        if (r12 == false) goto L29;
        b0.j().storeBoolean("dora_cdm_keep_alive_nova", false);
        int r117 = b0.j().getInt("dora_keep_alive_balloon_close_times", 0);
        if (r117 <= 0) goto L36;
        b0.j().storeInt("dora_keep_alive_balloon_close_times", r117 - 1);
    L36:
        r6 = DoraAdapterExtKt.h(kj4.a.g());
        int r118 = kj4.a.g().getDoraLinkState(r6);
        if (r6 == null) goto L106;
        if (r118 != 2) goto L106;
        r2 = b0.i();
        if (((ArrayList) r2).isEmpty() == true) goto L43;
    L49:
        kj4.a r119 = kj4.a.g();
        this.L$0 = r6;
        this.L$1 = r2;
        this.label = 4;
        r13 = DoraAdapterExtKt.s(r119);
        if (r13 != r0) goto L53;
        return r0;
    L43:
        if (b0.j().getBoolean("dora_keep_alive_page_shown", false) == true) goto L49;
        g49.d.d("DoraKeepAliveBalloon", "checkShowState: first time shown");
        StateFlowImpl r120 = h.b;
        Boolean r23 = Boxing.boxBoolean(true);
        this.label = 3;
        r120.setValue(r23);
        if (Unit.INSTANCE != r0) goto L48;
        return r0;
    L106:
        g49.d.d("DoraKeepAliveBalloon", "checkShowState: device is not connected");
        StateFlowImpl r121 = h.b;
        Boolean r24 = Boxing.boxBoolean(false);
        this.label = 2;
        r121.setValue(r24);
        if (Unit.INSTANCE != r0) goto L110;
        return r0;
    L29:
        b0.j().storeBoolean("dora_cdm_keep_alive_nova", r116);
        if (r22 == false) goto L36;
        g49.d.d("DoraKeepAliveBalloon", "checkShowState: close times more than 3");
        StateFlowImpl r122 = h.b;
        Boolean r25 = Boxing.boxBoolean(false);
        this.label = 1;
        r122.setValue(r25);
        if (Unit.INSTANCE != r0) goto L35;
        return r0;
    L22:
        r22 = false;
    L18:
        r12 = false;
        goto L19
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
