package com.larus.uaigc.lynx;

import android.net.Uri;
import android.view.View;
import android.view.Window;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.platform.api.e4;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.i1;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.lynx.LotteryLynxWarmer$warmUpLynxView$1", f = "LotteryLynxWarmer.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
final class LotteryLynxWarmer$warmUpLynxView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ LotteryLynxWarmer this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.lynx.LotteryLynxWarmer$warmUpLynxView$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.lynx.LotteryLynxWarmer$warmUpLynxView$1$2", f = "LotteryLynxWarmer.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LotteryLynxWarmer this$0;

        public AnonymousClass2(LotteryLynxWarmer r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            LotteryLynxWarmer r5 = this.this$0;
            int r2 = LotteryLynxWarmer.b;
            r5.d();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            this.label = 1;
            if (DelayKt.delay(300000, this) != r0) goto L11;
            return r0;
        }
    }

    public LotteryLynxWarmer$warmUpLynxView$1(LotteryLynxWarmer r1, Continuation<? super LotteryLynxWarmer$warmUpLynxView$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LotteryLynxWarmer$warmUpLynxView$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static View INVOKEVIRTUAL_com_larus_uaigc_lynx_LotteryLynxWarmer$warmUpLynxView$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        LotteryLynxWarmer r2 = (LotteryLynxWarmer) this.L$0;
        ResultKt.throwOnFailure(r10);
    L48:
        r2.a = (e4) r10;
        this.this$0.getClass();
        this.this$0.getClass();
        e4 r11 = this.this$0.a;
        if (r11 == null) goto L53;
        View r12 = r11.getView();
        if (r12 == null) goto L53;
        r12.setAlpha(0.0f);
    L53:
        this.this$0.getClass();
        this.this$0.getClass();
        BuildersKt.launch$default(null, null, null, new AnonymousClass2(this.this$0, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        if (this.this$0.a == null) goto L12;
        FLogger.a.i("LotteryLynxWarmer", "warmUpLynxView, ivyPluginView is not null");
        return Unit.INSTANCE;
    L12:
        hy9.i r13 = (hy9.i) ((i1) LotteryPollingConfigProvider.f.getValue()).getValue();
        if (r13 == null) goto L15;
        String r14 = r13.d();
    L16:
        int r4 = 0;
        if (r14 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == false) goto L26;
        FLogger.a.e("LotteryLynxWarmer", "warmUpLynxView, warmUrl is empty");
        return Unit.INSTANCE;
    L26:
        FLogger.a.i("LotteryLynxWarmer", "warmUpLynxView, warmUrl: " + r14);
        LotteryLynxWarmer r3 = this.this$0;
        r3.getClass();
        s09.a r6 = PollingConfigService.a.d();
        if (r6 == null) goto L33;
        Map r7 = r6.a;
        if (r7 == null) goto L33;
        String r8 = (String) r7.get("builtin_dg");
        if (r8 == null) goto L33;
        int r9 = l3.e(r8, 0);
    L34:
        if (r6 == null) goto L40;
        Map r15 = r6.a;
        if (r15 == null) goto L40;
        String r16 = (String) r15.get("gecko_dg");
        if (r16 == null) goto L40;
        r4 = l3.e(r16, 0);
    L40:
        Uri r17 = y0.j(r14);
        if (r17 == null) goto L44;
        r14 = y0.l(y0.l(y0.l(y0.l(y0.l(r17, "disable_builtin", String.valueOf(r9)), "disable_gecko", String.valueOf(r4)), "loader_name", "forest"), "forest_newly_builtin", "1"), "enable_lynx_generic_fetcher", "1").toString();
    L44:
        this.L$0 = r3;
        this.label = 1;
        r10 = LotteryLynxWarmer.c(r3, r14, this);
        if (r10 != r0) goto L47;
        return r0;
    L47:
        r2 = r3;
    L33:
        r9 = 0;
        goto L34
    L19:
        if (r14.length() == 0) goto L22;
        r5 = false;
        goto L23
    L15:
        r14 = null;
        goto L16
    }
}
