package com.larus.avlink.e.model.session_memory;

import com.larus.avlink.model.DoraVisionBizScene;
import com.larus.avlink.n1;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.network.FlowHttpConnection;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SessionMemoryMode {
    public final String a;
    public final String b;
    public final Integer c;
    public final String d;
    public Integer e;
    public final Lazy f;
    public int g;
    public Job h;

    public static final class a {
    }

    static {
    }

    public final void b(int r10) {
        n1.d("SessionMemoryMode", "Starting timer with interval: " + r10 + " ms.");
        this.g = r10;
        this.h = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new SessionMemoryMode$startTimerInternal$1(this, r10, null), 3, null);
    }

    public final void c(int r10) {
        n1.d("SessionMemoryMode", "tryRestartTimer called, new interval: " + r10 + ", last interval: " + this.g + '.');
        int r0 = this.g;
        if (r0 == r10) goto L10;
        if (r0 == 0) goto L11;
        n1.d("SessionMemoryMode", "Stopping timer and cleaning up resources.");
        Job r1 = this.h;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.h = null;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new SessionMemoryMode$tryRestartTimer$1(this, null), 3, null);
        b(r10);
        return;
    L11:
        return;
    }

    public static final Object a(SessionMemoryMode r21, Continuation r22) {
        r21.getClass();
        if ((r22 instanceof SessionMemoryMode$reportSessionMemory$1) == false) goto L7;
        SessionMemoryMode$reportSessionMemory$1 r2 = (SessionMemoryMode$reportSessionMemory$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        SessionMemoryMode$reportSessionMemory$1 r10 = r2;
        Object r1 = r10.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r10.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        b r6 = (b) r10.L$0;
        ResultKt.throwOnFailure(r1);
    L36:
        dm9.a.a r7 = (dm9.a) r1;
        if ((r7 instanceof dm9.a.b) == false) goto L40;
        n1.d("SessionMemoryMode", "Session memory reported successfully with interval " + r21.g + ", request: " + r6);
    L43:
        return Unit.INSTANCE;
    L40:
        if ((r7 instanceof dm9.a.a) == false) goto L45;
        n1.b("SessionMemoryMode", "Failed to report session memory: " + r7.b + ", request: " + r6);
        goto L43
    L45:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r15 = r21.a;
        String r8 = r21.b;
        Integer r17 = Boxing.boxInt(11);
        Integer r9 = r21.e;
        if (r9 == null) goto L17;
        int r11 = r9.intValue();
    L24:
        Integer r18 = Boxing.boxInt(r11);
        DoraVisionBizScene.a r12 = DoraVisionBizScene.Companion;
        Integer r13 = r21.c;
        if (r13 == null) goto L27;
        int r14 = r13.intValue();
    L28:
        r12.getClass();
        DoraVisionBizScene r16 = DoraVisionBizScene.a.a(r14);
        if (r16 == null) goto L31;
        Integer r19 = Boxing.boxInt(r16.getValue());
    L32:
        b r20 = new b(r15, r8, r17, r18, r19, r21.d);
        n1.d("SessionMemoryMode", "Reporting session memory with interval " + r21.g + ", request: " + r20);
        SessionMemoryApi.a r23 = SessionMemoryApi.a;
        SessionMemoryMode$reportSessionMemory$result$1 r24 = new SessionMemoryMode$reportSessionMemory$result$1(r20, null);
        r10.L$0 = r20;
        r10.label = 1;
        r23.getClass();
        FlowHttpConnection r25 = FlowHttpConnection.a;
        Object r26 = FlowHttpConnection.g("Audio", SessionMemoryApi.class, r24, false, null, null, null, r10, 248);
        if (r26 == r4) goto L46;
        r6 = r20;
        r1 = r26;
        goto L36
    L46:
        return r4;
    L31:
        r19 = null;
        goto L32
    L27:
        r14 = 6;
        goto L28
    L17:
        IDoraService r27 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r27 == null) goto L22;
        DeviceService r28 = r27.device();
        if (r28 == null) goto L22;
        Integer r29 = Integer.valueOf(r28.y());
    L23:
        FlowDoraSubBizType.Companion.getClass();
        r11 = FlowDoraSubBizType.a.b(r29);
        r21.e = Integer.valueOf(r11);
    L22:
        r29 = null;
    L7:
        r2 = new SessionMemoryMode$reportSessionMemory$1(r21, r22);
        goto L8
    }

    public SessionMemoryMode(String r1, String r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = null;
        this.f = LazyKt.lazy(new com.larus.avlink.e.model.session_memory.a());
    }
}
