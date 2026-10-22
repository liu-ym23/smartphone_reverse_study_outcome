package com.larus.bmhome.chat.banner;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.banner.ActiveSwitchBannerFeature$requestRemote$1$1", f = "ActiveSwitchBannerFeature.kt", i = {0}, l = {119, 145}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ActiveSwitchBannerFeature$requestRemote$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ k $request;
    final /* synthetic */ String $requestCacheKey;
    final /* synthetic */ String $source;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ActiveSwitchBannerFeature this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.banner.ActiveSwitchBannerFeature$requestRemote$1$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.banner.ActiveSwitchBannerFeature$requestRemote$1$1$3", f = "ActiveSwitchBannerFeature.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ActiveSwitchBannerFeature this$0;

        public AnonymousClass3(ActiveSwitchBannerFeature r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            di8.c r3 = d.a(this.this$0).getAbility(di8.c.class);
            if (r3 == null) goto L8;
            r3.O8();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ActiveSwitchBannerFeature$requestRemote$1$1(String r1, ActiveSwitchBannerFeature r2, String r3, String r4, k r5, Continuation<? super ActiveSwitchBannerFeature$requestRemote$1$1> r6) {
        this.$source = r1;
        this.this$0 = r2;
        this.$requestCacheKey = r3;
        this.$conversationId = r4;
        this.$request = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        ActiveSwitchBannerFeature$requestRemote$1$1 r7 = new ActiveSwitchBannerFeature$requestRemote$1$1(this.$source, this.this$0, this.$requestCacheKey, this.$conversationId, this.$request, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
    L66:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L18
        Object r2 = r18;
    L16:
        Object r3 = Result.constructor-impl((a) r2);     // Catch: Throwable -> L18
    L20:
        String r4 = this.$source;
        Throwable r5 = Result.exceptionOrNull-impl(r3);
        if (r5 != null) goto L67;
        y r6 = (a) r3;
        if ((r6 instanceof y) == false) goto L25;
        y r7 = r6;
    L26:
        if (r7 == null) goto L28;
        c r8 = (c) ((a) r7).b;
    L29:
        if (r8 != null) goto L32;
        FLogger.a.w("ActiveSwitchBanner", "request returned no data, source=" + this.$source + ", result=" + r6);
        return Unit.INSTANCE;
    L32:
        com.larus.bmhome.chat.component.cvs.y r9 = (com.larus.bmhome.chat.component.cvs.y) this.this$0.i.getValue();
        if (r9 == null) goto L37;
        wc9.e r10 = r9.h();
        if (r10 == null) goto L37;
        String r11 = r10.a;
    L39:
        if (Intrinsics.areEqual(AccountService.a.getUserId() + '_' + r11, this.$requestCacheKey) == true) goto L42;
        FLogger.a.i("ActiveSwitchBanner", "ignore stale response, source=" + this.$source + ", conversationId=" + this.$conversationId);
        return Unit.INSTANCE;
    L42:
        ActiveSwitchBannerFeature.p.put(this.$requestCacheKey, r8);
        ActiveSwitchBannerFeature.o.storeString(this.$requestCacheKey, ActiveSwitchBannerFeature.n.toJson(r8));     // Catch: Throwable -> L45
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
    L47:
        String r13 = this.$requestCacheKey;
        Throwable r15 = Result.exceptionOrNull-impl(r12);
        if (r15 == null) goto L50;
        FLogger.a.w("ActiveSwitchBanner", "store cache failed, key=" + r13 + ", error=" + r15.getMessage());
    L50:
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("refresh success, source=");
        r17.append(this.$source);
        r17.append(", bannerSize=");
        List<i> r19 = r8.a();
        if (r19 == null) goto L53;
        int r20 = r19.size();
    L54:
        r17.append(r20);
        r17.append(", first text:");
        List<i> r21 = r8.a();
        if (r21 == null) goto L61;
        i r22 = (i) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L61;
        m r23 = r22.g();
        if (r23 == null) goto L61;
        String r24 = r23.c();
    L62:
        r17.append(r24);
        r16.i("ActiveSwitchBanner", r17.toString());
        MainCoroutineDispatcher r25 = Dispatchers.getMain();
        AnonymousClass3 r26 = new AnonymousClass3(this.this$0, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r25, r26, this) != r14) goto L66;
        return r14;
    L61:
        r24 = null;
        goto L62
    L53:
        r20 = 0;
    L45:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L37:
        r11 = null;
        goto L39
    L28:
        r8 = null;
        goto L29
    L25:
        r7 = null;
        goto L26
    L67:
        FLogger.a.e("ActiveSwitchBanner", "request failed, source=" + r4, r5);
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r28 = (CoroutineScope) this.L$0;
        k r29 = this.$request;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L18
        JSONObject r31 = new JSONObject(ActiveSwitchBannerFeature.n.toJson(r29));     // Catch: Throwable -> L18
        this.L$0 = r28;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r2 = HttpExtKt.k("MainBot", c.class, "/alice/bot/action_bar_v3/active_switch_banner", r31, null, null, false, null, null, null, this, 1008);     // Catch: Throwable -> L18
        if (r2 != r14) goto L16;
        return r14;
    L18:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
