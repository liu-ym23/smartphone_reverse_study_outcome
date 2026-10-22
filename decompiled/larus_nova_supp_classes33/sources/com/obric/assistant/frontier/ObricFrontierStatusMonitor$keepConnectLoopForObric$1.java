package com.obric.assistant.frontier;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.larus.im.f;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.capabilitykit.common.ErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.frontier.ObricFrontierStatusMonitor$keepConnectLoopForObric$1", f = "ObricFrontierStatusMonitor.kt", i = {0}, l = {ErrorCode.PRIVACY_STATEMENT_NOT_AGREE_ERROR}, m = "invokeSuspend", n = {"reconnectFailedCount"}, s = {"I$0"})
final class ObricFrontierStatusMonitor$keepConnectLoopForObric$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $keepAliveInterval;
    int I$0;
    int label;

    public ObricFrontierStatusMonitor$keepConnectLoopForObric$1(int r1, Continuation<? super ObricFrontierStatusMonitor$keepConnectLoopForObric$1> r2) {
        this.$keepAliveInterval = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricFrontierStatusMonitor$keepConnectLoopForObric$1(this.$keepAliveInterval, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004a -> B:16:0x004d). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r11);
        ObricFrontierStatusMonitor$keepConnectLoopForObric$1 r12 = this;
    L16:
        Lazy r4 = d.a;
        if (d.b() == true) goto L19;
        f r5 = d.c();
        if (r5 == null) goto L23;
        Integer r6 = Boxing.boxInt(r5.c());
    L24:
        FLogger r7 = FLogger.a;
        r7.d("ObricFrontierStatusMonitor", "keepConnectLoopForObric, loop, currentState: " + r6 + ", failedCount: " + r2);
        if (r6 != null) goto L28;
    L30:
        if (r6 != null) goto L33;
    L10:
        if (d.d == true) goto L12;
        long r8 = r12.$keepAliveInterval;
    L13:
        long r9 = (r8 * RangesKt.coerceAtMost(1 << RangesKt.coerceIn(r2 - 5, 0, 16), 8)) * 1000;
        r12.I$0 = r2;
        r12.label = 1;
        if (DelayKt.delay(r9, r12) != r0) goto L16;
        return r0;
    L12:
        r8 = 60;
        goto L13
    L33:
        if (r6.intValue() != 0) goto L10;
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L37;
        r2 = r2 + 1;
        r7.i("ObricFrontierStatusMonitor", "keepConnectLoopForObric, skip connect: network unavailable, failedCount: " + r2);
        goto L10
    L37:
        r2 = r2 + 1;
        IObricNetworkService r10 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r10 == null) goto L40;
        r10.f(false);
    L40:
        f r13 = d.c();
        if (r13 == null) goto L10;
        r13.l(null, "keepConnectLoopForObric");
        goto L10
    L28:
        if (r6.intValue() != 1) goto L30;
        r2 = 0;
        goto L10
    L23:
        r6 = null;
        goto L24
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        r2 = 0;
        r12 = this;
        goto L10
    }
}
