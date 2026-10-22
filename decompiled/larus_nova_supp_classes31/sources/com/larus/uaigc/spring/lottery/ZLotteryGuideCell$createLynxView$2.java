package com.larus.uaigc.spring.lottery;

import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common.apphost.AppHost;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.c1;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.spring.lottery.ZLotteryGuideCell$createLynxView$2", f = "ZLotteryGuideCell.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
final class ZLotteryGuideCell$createLynxView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FrameLayout $container;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ ZLotteryGuideCell this$0;

    public ZLotteryGuideCell$createLynxView$2(ZLotteryGuideCell r1, FrameLayout r2, Message r3, Continuation<? super ZLotteryGuideCell$createLynxView$2> r4) {
        this.this$0 = r1;
        this.$container = r2;
        this.$message = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ZLotteryGuideCell$createLynxView$2(this.this$0, this.$container, this.$message, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L61:
        this.this$0.g = false;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        ZLotteryGuideCell r4 = this.this$0;
        Context r5 = this.$container.getContext();
        Message r6 = this.$message;
        this.label = 1;
        StateFlowImpl r7 = ZLotteryGuideCell.m;
        r4.getClass();
        Map r8 = r6.getExt();
        if (r8 == null) goto L58;
        String r9 = (String) r8.get("lottery_guide_url");
        if (r9 == null) goto L58;
        c1 r10 = c1.a;
        if (r10.d() == true) goto L16;
        r10.f();
    L16:
        CompletableDeferred r11 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Job r12 = r4.l;
        if (r12 == null) goto L19;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L19:
        r4.l = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new ZLotteryGuideCell$delayReportPocketMessageCardShowTimeout$1(r4, null), 3, null);
        s09.a r13 = PollingConfigService.a.d();
        if (r13 == null) goto L26;
        Map r14 = r13.a;
        if (r14 == null) goto L26;
        String r15 = (String) r14.get("builtin_dg_c");
        if (r15 == null) goto L26;
        int r16 = l3.e(r15, 0);
    L27:
        if (r13 == null) goto L33;
        Map r17 = r13.a;
        if (r17 == null) goto L33;
        String r19 = (String) r17.get("gecko_dg");
        if (r19 == null) goto L33;
        int r20 = l3.e(r19, 0);
    L34:
        Uri r110 = y0.j(r9);
        if (r110 == null) goto L54;
        Uri r21 = y0.l(y0.l(y0.l(y0.l(y0.l(r110, "disable_builtin", String.valueOf(r16)), "disable_gecko", String.valueOf(r20)), "loader_name", "forest"), "forest_newly_builtin", "1"), "enable_lynx_generic_fetcher", "1");
        if (AppHost.a.isTestChannel() == false) goto L53;
        IFlowSdkDepend r22 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r22 == null) goto L46;
        FlowAppletServiceImpl r23 = r22.g0();
        if (r23 == null) goto L46;
        if (r23.e() != true) goto L46;
    L47:
        if (r3 == false) goto L53;
        IFlowSdkDepend r24 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r24 == null) goto L53;
        FlowAppletServiceImpl r25 = r24.g0();
        if (r25 == null) goto L53;
        r21 = y0.a(r21, r25.f());
    L46:
        r3 = false;
    L53:
        r9 = r21.toString();
    L54:
        r4.f = r10.g(r5, r9, "", new d(r4, r11));
        Object r26 = r11.await(this);
        if (r26 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
        r26 = Unit.INSTANCE;
    L59:
        if (r26 != r1) goto L61;
        return r1;
    L33:
        r20 = 0;
    L26:
        r16 = 0;
    L58:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new ZLotteryGuideCell$reportPocketMessageCardError$1(r4, 301, null, null), 3, null);
        r26 = Unit.INSTANCE;
        goto L59
    }
}
