package com.larus.bot.impl.feature.health;

import android.app.Application;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.setting.api.u;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragment$reportUserHaveAgree$1", f = "ChatHealthTipFragment.kt", i = {1}, l = {151, 153, 162, 176}, m = "invokeSuspend", n = {"response"}, s = {"L$0"})
final class ChatHealthTipFragment$reportUserHaveAgree$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ChatHealthTipFragment this$0;

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.health.ChatHealthTipFragment$reportUserHaveAgree$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragment$reportUserHaveAgree$1$1", f = "ChatHealthTipFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatHealthTipFragment this$0;

        public AnonymousClass1(ChatHealthTipFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            ChatHealthTipFragment.S90(this.this$0);
            s r4 = s.a;
            Application r0 = AppHost.a.getApplication();
            r4.getClass();
            s.b(r0, 2131907052, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.health.ChatHealthTipFragment$reportUserHaveAgree$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.health.ChatHealthTipFragment$reportUserHaveAgree$1$3", f = "ChatHealthTipFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatHealthTipFragment this$0;

        public AnonymousClass3(ChatHealthTipFragment r1, Continuation<? super AnonymousClass3> r2) {
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

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            ChatHealthTipFragment.S90(this.this$0);
            s r4 = s.a;
            Application r0 = AppHost.a.getApplication();
            r4.getClass();
            s.b(r0, 2131907052, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatHealthTipFragment$reportUserHaveAgree$1(ChatHealthTipFragment r1, Continuation<? super ChatHealthTipFragment$reportUserHaveAgree$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatHealthTipFragment$reportUserHaveAgree$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        Continuation r14 = null;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L43;
        if (r0 != 4) goto L10;
        ResultKt.throwOnFailure(r19);
    L42:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L43:
        ResultKt.throwOnFailure(r19);     // Catch: Exception -> L13
    L13:
        r14 = r14;
    L38:
        MainCoroutineDispatcher r1 = Dispatchers.getMain();
        AnonymousClass3 r2 = new AnonymousClass3(this.this$0, r14);
        this.L$0 = r14;
        this.label = 4;
        if (BuildersKt.withContext(r1, r2, this) != r13) goto L42;
        return r13;
    L14:
        com.larus.network.http.a r3 = (com.larus.network.http.a) this.L$0;
        ResultKt.throwOnFailure(r19);
        r14 = r14;
    L25:
        if ((r3 instanceof y) == false) goto L42;
        zs9.g r4 = (zs9.g) ((com.larus.network.http.a) ((y) r3)).b;     // Catch: Exception -> L37
        if (r4 == null) goto L29;
        Continuation r10 = r4.a();     // Catch: Exception -> L37
    L30:
        if (r10 != null) goto L32;
        r10 = "";
    L32:
        UpdateSafetyStateResponse r5 = (UpdateSafetyStateResponse) new Gson().fromJson(r10, UpdateSafetyStateResponse.class);     // Catch: Exception -> L37
        if (r5 == null) goto L42;
        ChatHealthTipFragment r6 = this.this$0;     // Catch: Exception -> L37
        MainCoroutineDispatcher r7 = Dispatchers.getMain();     // Catch: Exception -> L37
        ChatHealthTipFragment$reportUserHaveAgree$1$2$1 r8 = new ChatHealthTipFragment$reportUserHaveAgree$1$2$1(r6, r5, r14);     // Catch: Exception -> L37
        this.L$0 = r14;     // Catch: Exception -> L37
        this.label = 3;     // Catch: Exception -> L37
        if (BuildersKt.withContext(r7, r8, this) != r13) goto L42;
        return r13;
    L29:
        r10 = r14;
        goto L30
    L15:
        ResultKt.throwOnFailure(r19);
        Object r9 = r19;
        int r15 = 2;
    L19:
        r3 = (com.larus.network.http.a) r9;
        if ((r3 instanceof com.larus.network.http.f) == false) goto L25;
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r12 = new AnonymousClass1(this.this$0, r14);
        this.L$0 = r3;
        this.label = r15;
        if (BuildersKt.withContext(r11, r12, this) != r13) goto L25;
        return r13;
    L16:
        ResultKt.throwOnFailure(r19);
        g r16 = g.a;
        this.label = 1;
        r15 = 2;
        r9 = HttpExtKt.k("Basic", zs9.g.class, u.g, g.b(r16, "update_safety_state"), null, null, false, null, null, null, this, 1008);
        if (r9 != r13) goto L19;
        return r13;
    }
}
