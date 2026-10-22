package com.obric.memorydata.awareness.impl.collector;

import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012:\u0010\t\u001a6\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000b\u0012$\u0012\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000e\u0018\u00010\f0\n¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J0\u0010\u0015\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000e\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000b\u0012$\u0012\"\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u000e\u0018\u00010\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/collector/AbilityFeatureCollector;", "Lcom/obric/memorydata/awareness/impl/collector/FeatureCollector;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "abilityParams", "Lcom/obric/memorydata/ability/AbilityParams;", "onProcess", "Lkotlin/Function1;", "Lcom/obric/memorydata/ability/data/IStandardData;", "", "onQuery", "Lkotlin/Function2;", "", "Lkotlin/Pair;", "", "", "<init>", "(Lcom/obric/memorydata/ability/AbilityParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "startCollect", "stopCollect", "queryFeatureAndExtra", "featureName", "onDataReceive", "data", "queryData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.memorydata.ability.f f8638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<h, Unit> f8639b;
    private final Function2<h, String, Pair<Object, Map<String, Object>>> c;
    private final com.obric.memorydata.ability.d d;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.collector.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/impl/collector/AbilityFeatureCollector$queryData$2$success$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0437a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f8640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<h> f8641b;
        final /* synthetic */ a c;

        C0437a(AtomicBoolean r3, n<? super h> r4, a r5) {
            n<h> r6 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin");
            this.f8640a = r3;
            this.f8641b = r6;
            this.c = r5;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r4) {
            h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "data");
            a.a(this.f8640a, this.f8641b, this.c, r5, "callback");
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    public a(com.obric.memorydata.ability.f r3, Function1<? super h, Unit> r4, Function2<? super h, ? super String, ? extends Pair<? extends Object, ? extends Map<String, ? extends Object>>> r5) {
        Function1<h, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function2<h, String, Pair<Object, Map<String, Object>>> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "abilityParams");
        Intrinsics.checkNotNullParameter(r6, "onProcess");
        Intrinsics.checkNotNullParameter(r7, "onQuery");
        this.f8638a = r3;
        this.f8639b = r6;
        this.c = r7;
        this.d = new com.obric.memorydata.ability.d();
    }

    public static final /* synthetic */ Object a(a r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super h> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        o r0 = new o(IntrinsicsKt.intercepted(r10), 1);
        r0.e();
        n r2 = (n) ZeusTransformUtils.preCheckCast(r0, n.class, "com.obric.memorydata.plugin");
        AtomicBoolean r3 = new AtomicBoolean(false);
        if (b(this).query(c(this), (k) ZeusTransformUtils.preCheckCast(new C0437a(r3, r2, this), k.class, "com.obric.memorydata.plugin")) == true) goto L5;
        a(r3, r2, this, null, "query_failed");
    L5:
        Object r8 = r0.h();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L8:
        return r8;
    }

    public static final /* synthetic */ Function2 a(a r0) {
        return r0.c;
    }

    public static final /* synthetic */ void a(AtomicBoolean r2, n r3, a r4, h r5, String r6) {
        b(r2, (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.memorydata.plugin"), r4, (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin"), r6);
    }

    public static final /* synthetic */ com.obric.memorydata.ability.d b(a r0) {
        return r0.d;
    }

    private static final void b(AtomicBoolean r6, n<? super h> r7, a r8, h r9, String r10) {
        n r11 = (n) ZeusTransformUtils.wrapperContextForParams(r7, n.class, "com.obric.memorydata.plugin");
        h r12 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
        if (r6.compareAndSet(false, true) == false) goto L5;
        Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
        Result.Companion r14 = Result.Companion;
        r13.resumeWith(Result.m1421constructorimpl(r12));
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Awareness", "ignore repeated ability query completion, dataId=" + r8.f8638a.a() + ", source=" + r10, null, 4, null);
    }

    public static final /* synthetic */ com.obric.memorydata.ability.f c(a r0) {
        return r0.f8638a;
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public Pair<Object, Map<String, Object>> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "featureName");
        return (Pair) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AbilityFeatureCollector$queryFeatureAndExtra$1(this, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Pair.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ability.k
    public void a(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "data");
        this.f8639b.invoke(r4);
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public void b() {
        super.b();
        this.d.a(this.f8638a, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.awareness.impl.collector.e
    public void c() {
        super.c();
        this.d.b(this.f8638a, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return k.a.a(this);
    }
}
