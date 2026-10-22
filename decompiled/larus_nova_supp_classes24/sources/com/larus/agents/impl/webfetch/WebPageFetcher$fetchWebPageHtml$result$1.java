package com.larus.agents.impl.webfetch;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/api/WebPageFetchResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.agents.impl.webfetch.WebPageFetcher$fetchWebPageHtml$result$1", f = "WebPageFetcher.kt", i = {0}, l = {234}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
public final class WebPageFetcher$fetchWebPageHtml$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super k48.a>, Object> {
    final /* synthetic */ AtomicInteger $httpStatus;
    final /* synthetic */ String $logCommandId;
    final /* synthetic */ int $maxBytes;
    final /* synthetic */ int $maxRedirect;
    final /* synthetic */ boolean $sendCookie;
    final /* synthetic */ AtomicReference<String> $stage;
    final /* synthetic */ long $startedAtNanos;
    final /* synthetic */ String $url;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    final /* synthetic */ WebPageFetcher this$0;

    public static final class a implements Function1<Throwable, Unit> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ AtomicReference<String> b;
        public final /* synthetic */ AtomicInteger c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ AtomicBoolean f;
        public final /* synthetic */ AtomicReference<t> g;
        public final /* synthetic */ CoroutineScope h;

        public a(AtomicBoolean r1, AtomicReference<String> r2, AtomicInteger r3, String r4, long r5, AtomicBoolean r7, AtomicReference<t> r8, CoroutineScope r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }

        public final Object invoke(Object r5) {
            Throwable r6 = (Throwable) r5;
            this.a.set(true);
            WebPageFetcher.d(this.d, this.e, "cancel_received stage=" + this.b.get() + " status=" + this.c.get());
            WebPageFetcher$fetchWebPageHtml$result$1.access$invokeSuspend$lambda$2$stop(this.f, this.g, this.h);
            return Unit.INSTANCE;
        }
    }

    public WebPageFetcher$fetchWebPageHtml$result$1(AtomicReference<String> r1, AtomicInteger r2, String r3, long r4, int r6, int r7, String r8, WebPageFetcher r9, boolean r10, Continuation<? super WebPageFetcher$fetchWebPageHtml$result$1> r11) {
        this.$stage = r1;
        this.$httpStatus = r2;
        this.$logCommandId = r3;
        this.$startedAtNanos = r4;
        this.$maxRedirect = r6;
        this.$maxBytes = r7;
        this.$url = r8;
        this.this$0 = r9;
        this.$sendCookie = r10;
        super(2, r11);
    }

    public static final /* synthetic */ void access$invokeSuspend$lambda$2$stop(AtomicBoolean r0, AtomicReference r1, CoroutineScope r2) {
        a(r0, r1);
    }

    public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
        WebPageFetcher$fetchWebPageHtml$result$1 r12 = new WebPageFetcher$fetchWebPageHtml$result$1(this.$stage, this.$httpStatus, this.$logCommandId, this.$startedAtNanos, this.$maxRedirect, this.$maxBytes, this.$url, this.this$0, this.$sendCookie, r15);
        r12.L$0 = r14;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super k48.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r29) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        WebPageFetcher r3 = (WebPageFetcher) this.L$5;
        String r4 = (String) this.L$4;
        String r5 = (String) this.L$3;
        AtomicInteger r6 = (AtomicInteger) this.L$2;
        AtomicReference r7 = (AtomicReference) this.L$1;
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r29);
        return r29;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r29);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        AtomicReference<String> r14 = this.$stage;
        AtomicInteger r15 = this.$httpStatus;
        String r13 = this.$logCommandId;
        long r11 = this.$startedAtNanos;
        int r10 = this.$maxRedirect;
        int r12 = this.$maxBytes;
        String r16 = this.$url;
        WebPageFetcher r17 = this.this$0;
        boolean r19 = this.$sendCookie;
        this.L$0 = r9;
        this.L$1 = r14;
        this.L$2 = r15;
        this.L$3 = r13;
        this.L$4 = r16;
        this.L$5 = r17;
        this.J$0 = r11;
        this.I$0 = r10;
        this.I$1 = r12;
        this.Z$0 = r19;
        this.label = 1;
        kotlinx.coroutines.j r20 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r20.C();
        AtomicBoolean r21 = new AtomicBoolean(false);
        AtomicBoolean r0 = new AtomicBoolean(false);
        AtomicReference r110 = new AtomicReference();
        r20.i(new a(r21, r14, r15, r13, r11, r0, r110, r9));
        Dispatchers.getIO().dispatch(r20.getContext(), new WebPageFetcher$fetchWebPageHtml$result$1$1$2(r10, r12, r16, r17, r14, r15, r19, r110, r9, r20, r13, r11, r0, r21));
        Object r22 = r20.B();
        if (r22 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        DebugProbesKt.probeCoroutineSuspended(this);
    L12:
        if (r22 != r1) goto L15;
        return r1;
    L15:
        return r22;
    }

    public static final void a(AtomicBoolean r1, AtomicReference r2) {
        r1.set(true);
        t r3 = (t) r2.getAndSet(null);
        if (r3 == null) goto L12;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L6
        r3.cancel();     // Catch: Throwable -> L6
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Result.box-impl(r5);
        return;
    L6:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final void access$invokeSuspend$lambda$2$finish(AtomicBoolean r1, kotlinx.coroutines.i r2, AtomicBoolean r3, AtomicReference r4, CoroutineScope r5, k48.a r6) {
        if (r1.compareAndSet(false, true) == false) goto L6;
        a(r3, r4);
        r2.resumeWith(Result.constructor-impl(r6));
        return;
    }
}
