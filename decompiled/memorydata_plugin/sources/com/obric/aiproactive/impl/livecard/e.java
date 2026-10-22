package com.obric.aiproactive.impl.livecard;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenSyncManager;", "", "repository", "Lcom/obric/aiproactive/impl/aidb/AiProactiveDbRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onSync", "Lkotlin/Function1;", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenSyncPayload;", "", "<init>", "(Lcom/obric/aiproactive/impl/aidb/AiProactiveDbRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "startStopLock", "Lkotlinx/coroutines/sync/Mutex;", "observeJob", "Lkotlinx/coroutines/Job;", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "stopAndJoin", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aiproactive.impl.aidb.d f6464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f6465b;
    private final Function1<g, Unit> c;
    private final kotlinx.coroutines.sync.a d;
    private bx e;

    public e() {
        this(null, null, null, 7, null);
    }

    public e(com.obric.aiproactive.impl.aidb.d r3, al r4, Function1<? super g, Unit> r5) {
        al r6 = (al) ZeusTransformUtils.wrapperContextForParams(r4, al.class, "com.obric.memorydata.plugin");
        Function1<g, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "repository");
        Intrinsics.checkNotNullParameter(r6, "scope");
        Intrinsics.checkNotNullParameter(r7, "onSync");
        this.f6464a = r3;
        this.f6465b = r6;
        this.c = r7;
        this.d = kotlinx.coroutines.sync.c.a(false, 1, null);
    }

    public /* synthetic */ e(com.obric.aiproactive.impl.aidb.d r10, al r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        al r15 = (al) ZeusTransformUtils.wrapperContextForParams(r11, al.class, "com.obric.memorydata.plugin");
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L6;
        r10 = new com.obric.aiproactive.impl.aidb.d(null, null, null, null, null, 31, null);
    L6:
        if ((r13 & 2) == 0) goto L9;
        r15 = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    L9:
        if ((r13 & 4) == 0) goto L11;
        r16 = (Function1) ZeusTransformUtils.preCheckCast(AiProactiveLockScreenSyncManager$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L11:
        this(r10, r15, r16);
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a a(e r0) {
        return r0.d;
    }

    public static final /* synthetic */ void a(e r2, bx r3) {
        r2.e = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ bx b(e r0) {
        return r0.e;
    }

    public static final /* synthetic */ al c(e r0) {
        return r0.f6465b;
    }

    public static final /* synthetic */ com.obric.aiproactive.impl.aidb.d d(e r0) {
        return r0.f6464a;
    }

    public static final /* synthetic */ Function1 e(e r0) {
        return r0.c;
    }

    public final Object a(Continuation<? super Unit> r18) {
        e r0 = this;
        Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, AiProactiveLockScreenSyncManager$stopAndJoin$1.class) == false) goto L7;
        AiProactiveLockScreenSyncManager$stopAndJoin$1 r3 = (AiProactiveLockScreenSyncManager$stopAndJoin$1) ZeusTransformUtils.preCheckCast(r1, AiProactiveLockScreenSyncManager$stopAndJoin$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r3.L$2, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        w r7 = (w) ZeusTransformUtils.preCheckCast(r3.L$1, w.class, "com.obric.memorydata.plugin");
        e r8 = (e) ZeusTransformUtils.preCheckCast(r3.L$0, e.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r2);
        kotlinx.coroutines.sync.a r9 = r6;
        r0 = r8;
    L31:
        bx r10 = r0.e;     // Catch: Throwable -> L28
        r0.e = null;     // Catch: Throwable -> L28
        if (r10 == null) goto L22;
        bx.a.a(r10, null, 1, null);     // Catch: Throwable -> L28
    L22:
        r0.c.invoke(new g(CollectionsKt.emptyList(), null, null, null, null, 30, null));     // Catch: Throwable -> L28
        r7.a(Unit.INSTANCE);     // Catch: Throwable -> L28
        r9.b(null);
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.label = 2;
        if (r7.a(r3) != r4) goto L27;
        return r4;
    L28:
        th = move-exception;
        r9.b(null);
        throw th;
    L16:
        ResultKt.throwOnFailure(r2);
        r7 = y.a(null, 1, null);
        r9 = r0.d;
        r3.L$0 = r0;
        r3.L$1 = r7;
        r3.L$2 = r9;
        r3.label = 1;
        if (r9.a(null, r3) != r4) goto L31;
        return r4;
    L7:
        r3 = new AiProactiveLockScreenSyncManager$stopAndJoin$1(r0, r1);
        goto L8
    }

    public final void a() {
        kotlinx.coroutines.i.a(this.f6465b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveLockScreenSyncManager$start$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void b() {
        kotlinx.coroutines.i.a(this.f6465b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveLockScreenSyncManager$stop$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
