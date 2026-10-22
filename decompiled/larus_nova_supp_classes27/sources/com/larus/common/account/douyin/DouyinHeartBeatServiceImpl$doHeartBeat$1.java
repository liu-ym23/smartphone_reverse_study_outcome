package com.larus.common.account.douyin;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import n38.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinHeartBeatServiceImpl$doHeartBeat$1", f = "DouyinHeartBeatServiceImpl.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
final class DouyinHeartBeatServiceImpl$doHeartBeat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n38.f $callback;
    final /* synthetic */ e $douYinTokenResult;
    final /* synthetic */ boolean $immediate;
    final /* synthetic */ boolean $isAuto;
    int label;
    final /* synthetic */ DouyinHeartBeatServiceImpl this$0;

    public DouyinHeartBeatServiceImpl$doHeartBeat$1(DouyinHeartBeatServiceImpl r1, e r2, boolean r3, boolean r4, n38.f r5, Continuation<? super DouyinHeartBeatServiceImpl$doHeartBeat$1> r6) {
        this.this$0 = r1;
        this.$douYinTokenResult = r2;
        this.$immediate = r3;
        this.$isAuto = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DouyinHeartBeatServiceImpl$doHeartBeat$1(this.this$0, this.$douYinTokenResult, this.$immediate, this.$isAuto, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r17);
    L26:
        n38.f r1 = this.$callback;
        if (r1 == null) goto L30;
        e r2 = this.$douYinTokenResult;
        r1.onResult(r2.a, r2.b, r2.c);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        long r3 = System.currentTimeMillis();
        String r4 = this.this$0.a.getString("latest_open_id", "");
        long r10 = this.this$0.a.getLong("latest_request_time", 0);
        String r5 = this.this$0.a.getString("cache_access_token", "");
        FLogger r8 = FLogger.a;
        r8.i("DouyinHeartBeatServiceImpl", "tryHeartBeatRequest, latestOpenId:" + r4 + ";cacheToken:" + r5 + ",latestTime:" + r10);
        if (Intrinsics.areEqual(r4, this.$douYinTokenResult.b) == false) goto L20;
        Intrinsics.checkNotNull(r5);
        if (StringsKt.isBlank(r5) == true) goto L20;
        if ((r3 - r10) >= 21600000) goto L20;
        if (this.$immediate == true) goto L20;
        n38.f r6 = this.$callback;
        if (r6 == null) goto L30;
        r6.onResult(null, null, null);
    L20:
        e r9 = this.$douYinTokenResult;
        if (StringsKt.isBlank(r5) == false) goto L23;
        r5 = r9.a;
    L23:
        this.this$0.a.storeString("latest_open_id", this.$douYinTokenResult.b);
        this.this$0.a.storeLong("latest_request_time", r3);
        r8.i("DouyinHeartBeatServiceImpl", "doHeartBeatRequest: " + this.$douYinTokenResult + ", finalToken:" + r5);
        DouyinHeartBeatServiceImpl r11 = this.this$0;
        e r12 = this.$douYinTokenResult;
        String r13 = r12.b;
        String r14 = r12.c;
        boolean r15 = this.$isAuto;
        this.label = 1;
        if (DouyinHeartBeatServiceImpl.f(r11, r5, r13, r14, r15, this) != r7) goto L26;
        return r7;
    }
}
