package com.larus.bmhome.chat.model.repo;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.platform.api.m4;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class MainBotModelStore {
    public static final Lazy<String> i = null;
    public final Object a;
    public CoroutineScope b;
    public final BotServiceImpl c;
    public String d;
    public long e;
    public BotModel f;
    public CompletableDeferred g;
    public z1 h;

    public static final class a {
    }

    public static final class b implements com.larus.platform.api.b {
        public final /* synthetic */ MainBotModelStore a;

        public b(MainBotModelStore r1) {
            this.a = r1;
        }

        public final void a(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            MainBotModelStore.a(this.a, "account_online");
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            MainBotModelStore.a(this.a, "account_offline");
        }
    }

    public static final class c implements m4 {
        public final /* synthetic */ MainBotModelStore a;

        public final void S1() {
            MainBotModelStore.a(this.a, "minor_mode_on");
        }

        public final void b1() {
            MainBotModelStore.a(this.a, "minor_mode_off");
        }

        public c(MainBotModelStore r1) {
            this.a = r1;
        }
    }

    static {
        i = LazyKt.lazy(new y1());
    }

    public MainBotModelStore() {
        this.a = new Object();
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.c = com.larus.im.d.a();
        b r0 = new b(this);
        c r1 = new c(this);
        AccountService r2 = AccountService.a;
        r2.E(r0);
        r2.H(r1);
    }

    public static final void a(MainBotModelStore r6, String r7) {
        Object r1 = r6.a;
        monitor-enter(r1);
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L20
        StringBuilder r4 = new StringBuilder("clear, reason=");     // Catch: Throwable -> L20
        r4.append(r7);     // Catch: Throwable -> L20
        r4.append(", cached=");     // Catch: Throwable -> L20
        boolean r0 = false;
        if (r6.f == null) goto L7;
        boolean r8 = true;
    L8:
        r4.append(r8);     // Catch: Throwable -> L20
        r4.append(", pending=");     // Catch: Throwable -> L20
        if (r6.g == null) goto L11;
        r0 = true;
    L11:
        r4.append(r0);     // Catch: Throwable -> L20
        r2.i("MainBotModelStore", r4.toString());     // Catch: Throwable -> L20
        String r9 = r6.d;     // Catch: Throwable -> L20
        if (r9 == null) goto L16;
        z1 r3 = r6.h;     // Catch: Throwable -> L20
        if (r3 == null) goto L16;
        r6.c.unregisterBotChangeListener(r9, r3);     // Catch: Throwable -> L20
    L16:
        r6.f = null;     // Catch: Throwable -> L20
        r6.g = null;     // Catch: Throwable -> L20
        r6.d = null;     // Catch: Throwable -> L20
        r6.h = null;     // Catch: Throwable -> L20
        CoroutineScope r5 = r6.b;     // Catch: Throwable -> L20
        r6.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));     // Catch: Throwable -> L20
        monitor-exit(r1);
        CoroutineScopeKt.cancel$default(r5, null, 1, null);
        return;
    L7:
        r8 = false;
    L20:
        th = move-exception;
        throw th;
    }

    public static final void b(MainBotModelStore r8, CoroutineScope r9, long r10, CompletableDeferred r12, BotModel r13) {
        Object r2 = r8.a;
        monitor-enter(r2);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (r9 == r8.b) goto L7;
    L29:
        FLogger.a.d("MainBotModelStore", "ignore stale result, request=" + r12.hashCode());     // Catch: Throwable -> L32
        monitor-exit(r2);
        return;
    L7:
        if (r12.isActive() == false) goto L29;
        String r1 = null;
        if (r8.g != r12) goto L12;
        r8.g = null;     // Catch: Throwable -> L32
    L12:
        boolean r11 = true;
        if (r10 != r8.e) goto L19;
        if (r13 == null) goto L17;
        r1 = r13.getBotId();     // Catch: Throwable -> L32
    L17:
        if (Intrinsics.areEqual(r1, r8.d) == false) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L22;
        r8.f = r13;     // Catch: Throwable -> L32
        r8.e++;     // Catch: Throwable -> L32
    L22:
        FLogger r15 = FLogger.a;     // Catch: Throwable -> L32
        StringBuilder r3 = new StringBuilder("sdk read end, request=");     // Catch: Throwable -> L32
        r3.append(r12.hashCode());     // Catch: Throwable -> L32
        r3.append(", success=");     // Catch: Throwable -> L32
        if (r13 != null) goto L26;
        r11 = false;
    L26:
        r3.append(r11);     // Catch: Throwable -> L32
        r3.append(", cacheUpdated=");     // Catch: Throwable -> L32
        r3.append(r14);     // Catch: Throwable -> L32
        r15.i("MainBotModelStore", r3.toString());     // Catch: Throwable -> L32
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L32
        monitor-exit(r2);
        r12.complete(r13);
        return;
    L19:
        r14 = false;
        goto L20
    }

    public final Object c(String r17, boolean r18, String r19, boolean r20, Continuation<? super BotModel> r21) {
        if ((r21 instanceof MainBotModelStore$findBot$1) == false) goto L7;
        MainBotModelStore$findBot$1 r5 = (MainBotModelStore$findBot$1) r21;
        int r6 = r5.label;
        if ((r6 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r6 - Integer.MIN_VALUE;
    L8:
        MainBotModelStore$findBot$1 r8 = r5;
        Object r1 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r8.label;
        boolean r10 = false;
        BotModel r12 = null;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        int r0 = r8.I$0;
        Ref.ObjectRef r2 = (Ref.ObjectRef) r8.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: CancellationException -> L14
    L39:
        BotModel r3 = (BotModel) r1;     // Catch: CancellationException -> L14
        Object r4 = this.a;
        monitor-enter(r4);
    L51:
        th = move-exception;
        throw th;
    L43:
        if (r2.element != this.b) goto L49;
        if (r0 == 0) goto L48;
        r12 = this.f;     // Catch: Throwable -> L51
        goto L49
    L48:
        r12 = r3;
    L49:
        monitor-exit(r4);
        return r12;
    L14:
        e = e;
        Ref.ObjectRef r14 = r2;
    L56:
        JobKt.ensureActive(r8.getContext());
        Object r11 = this.a;
        monitor-enter(r11);
        if (r14.element == this.b) goto L61;
        r10 = true;
    L61:
        monitor-exit(r11);
        if (r10 == false) goto L64;
        return null;
    L64:
        throw e;
    L65:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r1);
        int r13 = !r18 ? 1 : 0;
        r14 = new Ref.ObjectRef();
        Object r15 = this.a;
        monitor-enter(r15);
        r14.element = this.b;     // Catch: Throwable -> L68
        if (r13 == 0) goto L30;
        BotModel r16 = this.f;     // Catch: Throwable -> L68
        if (r16 == null) goto L27;
        FLogger.a.d("MainBotModelStore", "cache hit, botId=" + r17 + ", scene=" + r19);     // Catch: Throwable -> L68
        monitor-exit(r15);
        return r16;
    L27:
        CompletableDeferred r22 = this.g;     // Catch: Throwable -> L68
        if (r22 == null) goto L30;
        FLogger.a.d("MainBotModelStore", "reuse pending, botId=" + r17 + ", request=" + r22.hashCode() + ", scene=" + r19);     // Catch: Throwable -> L68
    L34:
        monitor-exit(r15);
        r8.L$0 = r14;     // Catch: CancellationException -> L55
        r8.I$0 = r13;     // Catch: CancellationException -> L55
        r8.label = 1;     // Catch: CancellationException -> L55
        r1 = r22.await(r8);     // Catch: CancellationException -> L55
        if (r1 != r9) goto L38;
        return r9;
    L38:
        r0 = r13;
        r2 = r14;
    L55:
        e = e;
    L30:
        if (r13 == 0) goto L32;
        boolean r23 = true;
    L33:
        r22 = d(r17, r18, r19, r20, r23);     // Catch: Throwable -> L68
        goto L34
    L32:
        r23 = false;
    L68:
        th = move-exception;
        throw th;
    L7:
        r5 = new MainBotModelStore$findBot$1(this, r21);
        goto L8
    }

    public final CompletableDeferred d(String r19, boolean r20, String r21, boolean r22, boolean r23) {
        CoroutineScope r13 = this.b;
        if (this.h != null) goto L5;
        this.d = r19;
        z1 r0 = new z1(this, r19, r13);
        this.c.registerBotChangeListener(r19, r0);
        this.h = r0;
    L5:
        long r9 = this.e;
        CompletableDeferred r14 = CompletableDeferredKt.CompletableDeferred(r13.getCoroutineContext().get(Job.Key));
        if (r23 == false) goto L8;
        this.g = r14;
    L8:
        BuildersKt.launch$default(r13, null, null, new MainBotModelStore$load$3(r14, r19, r20, r22, r23, r21, this, r13, r9, null), 3, null);
        return r14;
    }
}
