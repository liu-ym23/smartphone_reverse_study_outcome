package com.obric.memorydata.memory.ui.list.contextawareness;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J@\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\f2\u0006\u0010\"\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130%2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/contextawareness/DefaultContextAwarenessTimelinePageRepository;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelinePageRepository;", "screenSourceFactory", "Lkotlin/Function0;", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessScreenPageSource;", "audioSourceFactory", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessAudioPageSource;", "canReadPersonalData", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "queryPage", "", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineRecord;", "dayRange", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;", "cursor", "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineCursor;", "limit", "", "queryPageBefore", "recordedDates", "", "Ljava/time/LocalDate;", "resolveTargetDate", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessTimelineTarget;", "zoneId", "Ljava/time/ZoneId;", "querySelectionMetaInfo", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "screenIds", "", "audioIds", "withSpecifiedRange", "(Lcom/obric/memorydata/memory/ui/list/contextawareness/ContextAwarenessDayRange;Ljava/util/List;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTotalCount", "Lkotlinx/coroutines/flow/Flow;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class y implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<i> f11298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<com.obric.memorydata.memory.ui.list.contextawareness.a> f11299b;
    private final Function0<Boolean> c;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11300a = null;

        static {
            int[] r0 = new int[ContextAwarenessTimelineSource.values().length];
            r0[ContextAwarenessTimelineSource.SCREEN_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContextAwarenessTimelineSource.AMBIENT_AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f11300a = r0;
        }
    }

    public y() {
        this(null, null, null, 7, null);
    }

    public y(Function0<? extends i> r3, Function0<? extends com.obric.memorydata.memory.ui.list.contextawareness.a> r4, Function0<Boolean> r5) {
        Function0<i> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0<com.obric.memorydata.memory.ui.list.contextawareness.a> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "screenSourceFactory");
        Intrinsics.checkNotNullParameter(r7, "audioSourceFactory");
        Intrinsics.checkNotNullParameter(r8, "canReadPersonalData");
        this.f11298a = r6;
        this.f11299b = r7;
        this.c = r8;
    }

    public /* synthetic */ y(Function0 r2, Function0 r3, Function0 r4, int r5, DefaultConstructorMarker r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0 r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = $$Lambda$y$u4d9rr5hLPVPSKgmMtyCX_5klo.INSTANCE;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = $$Lambda$y$pPBMOVYEugF94BQ1YNWZEwRsEks.INSTANCE;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = $$Lambda$y$vOc2a1aF6cogSxkzuWZKP0lJ5c.INSTANCE;
    L11:
        this(r7, r8, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final x b() {
        return new x(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final w c() {
        return new w(null, 1, 0 == true ? 1 : 0);
    }

    private static final boolean d() {
        return g.f11271a.a(UserSettings.INSTANCE.hasAgreePrivacyAndLogin(), UserSettings.INSTANCE.getUserId());
    }

    /* JADX INFO: renamed from: lambda$-vOc2a1aF6cogSxkzuWZKP0lJ5c, reason: not valid java name */
    public static /* synthetic */ boolean m946lambda$vOc2a1aF6cogSxkzuWZKP0lJ5c() {
        return d();
    }

    public static /* synthetic */ w lambda$pPBMOVYEugF94BQ1YNWZEwRsEks() {
        return c();
    }

    /* JADX INFO: renamed from: lambda$u4d9rr5hLPVPSKgmMtyCX_5-klo, reason: not valid java name */
    public static /* synthetic */ x m947lambda$u4d9rr5hLPVPSKgmMtyCX_5klo() {
        return b();
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.q
    public Object a(d r8, List<String> r9, List<String> r10, boolean r11, Continuation<? super List<cu>> r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, DefaultContextAwarenessTimelinePageRepository$querySelectionMetaInfo$1.class) == false) goto L7;
        DefaultContextAwarenessTimelinePageRepository$querySelectionMetaInfo$1 r0 = (DefaultContextAwarenessTimelinePageRepository$querySelectionMetaInfo$1) ZeusTransformUtils.preCheckCast(r15, DefaultContextAwarenessTimelinePageRepository$querySelectionMetaInfo$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        List r7 = (List) ZeusTransformUtils.preCheckCast(r0.L$0, List.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
    L27:
        return CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r17 = r0.Z$0;
        List<String> r18 = (List) ZeusTransformUtils.preCheckCast(r0.L$2, List.class, "com.obric.memorydata.plugin");
        d r19 = (d) ZeusTransformUtils.preCheckCast(r0.L$1, d.class, "com.obric.memorydata.plugin");
        y r110 = (y) ZeusTransformUtils.preCheckCast(r0.L$0, y.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r16);
        r11 = r17;
        y this = r110;
        r14 = r18;
        r8 = r19;
    L21:
        List r20 = (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin");
    L23:
        d r6 = r8;
        y r21 = this;
        r7 = r20;
        com.obric.memorydata.memory.ui.list.contextawareness.a r22 = (com.obric.memorydata.memory.ui.list.contextawareness.a) ZeusTransformUtils.preCheckCast(r21.f11299b.invoke(), com.obric.memorydata.memory.ui.list.contextawareness.a.class, "com.obric.memorydata.plugin");
        r0.L$0 = r7;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        r16 = r22.a(r6, r14, r11, r0);
        if (r16 != r2) goto L27;
        return r2;
    L16:
        ResultKt.throwOnFailure(r16);
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L22;
        i r111 = (i) ZeusTransformUtils.preCheckCast(this.f11298a.invoke(), i.class, "com.obric.memorydata.plugin");
        r0.L$0 = this;
        r0.L$1 = r8;
        r0.L$2 = r14;
        r0.Z$0 = r11;
        r0.label = 1;
        r16 = r111.a(r8, r13, r11, r0);
        if (r16 != r2) goto L21;
        return r2;
    L22:
        r20 = CollectionsKt.emptyList();
    L7:
        r0 = new DefaultContextAwarenessTimelinePageRepository$querySelectionMetaInfo$1(this, r15);
        goto L8
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.q
    public LocalDate a(v r5, ZoneId r6) {
        Intrinsics.checkNotNullParameter(r5, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r6, "zoneId");
        int r0 = a.f11300a[r5.a().ordinal()];
        if (r0 == 1) goto L10;
        if (r0 != 2) goto L8;
        Long r4 = ((com.obric.memorydata.memory.ui.list.contextawareness.a) ZeusTransformUtils.preCheckCast(this.f11299b.invoke(), com.obric.memorydata.memory.ui.list.contextawareness.a.class, "com.obric.memorydata.plugin")).a(r5.b());
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        return s.f11287a.a(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue(), r6);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L12;
        r4 = ((i) ZeusTransformUtils.preCheckCast(this.f11298a.invoke(), i.class, "com.obric.memorydata.plugin")).a(r5.b());
        goto L13
    L12:
        r4 = null;
        goto L13
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.q
    public List<t> a(d r4, p r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "dayRange");
        if (r6 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        k r1 = s.f11287a.a(r5, ContextAwarenessTimelineSource.SCREEN_CONTENT, r4);
        k r7 = s.f11287a.a(r5, ContextAwarenessTimelineSource.AMBIENT_AUDIO, r4);
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L10;
        List<t> r8 = ((i) ZeusTransformUtils.preCheckCast(this.f11298a.invoke(), i.class, "com.obric.memorydata.plugin")).query(r1, r6);
    L11:
        List<t> r3 = ((com.obric.memorydata.memory.ui.list.contextawareness.a) ZeusTransformUtils.preCheckCast(this.f11299b.invoke(), com.obric.memorydata.memory.ui.list.contextawareness.a.class, "com.obric.memorydata.plugin")).query(r7, r6);
        return CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(s.f11287a.a(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin"), r6);
    L10:
        r8 = CollectionsKt.emptyList();
        goto L11
    L14:
        throw new IllegalArgumentException("limit must be positive".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.q
    public Set<LocalDate> a() {
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
        List<String> r0 = ((i) ZeusTransformUtils.preCheckCast(this.f11298a.invoke(), i.class, "com.obric.memorydata.plugin")).a();
    L6:
        List<String> r3 = ((com.obric.memorydata.memory.ui.list.contextawareness.a) ZeusTransformUtils.preCheckCast(this.f11299b.invoke(), com.obric.memorydata.memory.ui.list.contextawareness.a.class, "com.obric.memorydata.plugin")).a();
        return u.a(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")));
    L5:
        r0 = CollectionsKt.emptyList();
        goto L6
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.q
    public kotlinx.coroutines.flow.i<Integer> a(d r4) {
        Intrinsics.checkNotNullParameter(r4, "dayRange");
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
        kotlinx.coroutines.flow.i<Integer> r0 = ((i) ZeusTransformUtils.preCheckCast(this.f11298a.invoke(), i.class, "com.obric.memorydata.plugin")).a(r4);
    L7:
        return kotlinx.coroutines.flow.k.b(r0, ((com.obric.memorydata.memory.ui.list.contextawareness.a) ZeusTransformUtils.preCheckCast(this.f11299b.invoke(), com.obric.memorydata.memory.ui.list.contextawareness.a.class, "com.obric.memorydata.plugin")).a(r4), (Function3) ZeusTransformUtils.preCheckCast(new DefaultContextAwarenessTimelinePageRepository$observeTotalCount$1(null), Function3.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = kotlinx.coroutines.flow.k.a(0);
        goto L7
    }

    @Override // com.obric.memorydata.memory.ui.list.contextawareness.q
    public List<t> b(d r5, p r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "dayRange");
        Intrinsics.checkNotNullParameter(r6, "cursor");
        if (r7 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L10;
        List<t> r1 = ((i) ZeusTransformUtils.preCheckCast(this.f11298a.invoke(), i.class, "com.obric.memorydata.plugin")).a(s.f11287a.b(r6, ContextAwarenessTimelineSource.SCREEN_CONTENT, r5), r7);
    L11:
        List<t> r4 = ((com.obric.memorydata.memory.ui.list.contextawareness.a) ZeusTransformUtils.preCheckCast(this.f11299b.invoke(), com.obric.memorydata.memory.ui.list.contextawareness.a.class, "com.obric.memorydata.plugin")).a(s.f11287a.b(r6, ContextAwarenessTimelineSource.AMBIENT_AUDIO, r5), r7);
        return CollectionsKt.takeLast(s.f11287a.a(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"))), r7);
    L10:
        r1 = CollectionsKt.emptyList();
        goto L11
    L14:
        throw new IllegalArgumentException("limit must be positive".toString());
    L5:
        r0 = false;
        goto L6
    }
}
