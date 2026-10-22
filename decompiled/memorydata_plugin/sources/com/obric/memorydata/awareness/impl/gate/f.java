package com.obric.memorydata.awareness.impl.gate;

import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001aH\u0016J*\u0010\u001b\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J?\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u0002H!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H!0\u0007H\u0002¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\bH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/KevaFeatureSwitchValueProvider;", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProvider;", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "readFailureReporter", "Lkotlin/Function0;", "", "storeFactory", "Lkotlin/Function1;", "", "Lcom/obric/memorydata/middleware/api/store/IStore;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "lock", "", "stores", "", "observedKeys", "", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;", "onChanged", "getBoolean", "", "repo", "key", "defaultValue", "getInt", "", "replaceObservedKeys", "keys", "onKeyChanged", "repoName", "release", "readOrDefault", ExifInterface.GPS_DIRECTION_TRUE, "reader", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "logReadFailureSafely", "storeFor", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f implements d, com.obric.memorydata.middleware.api.store.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0<Unit> f8686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<String, IStore> f8687b;
    private final Object c;
    private final Map<String, IStore> d;
    private volatile Set<c> e;
    private volatile Function1<? super c, Unit> f;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public f(Function0<Unit> r3, Function1<? super String, ? extends IStore> r4) {
        Function0<Unit> r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function1<String, IStore> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "readFailureReporter");
        Intrinsics.checkNotNullParameter(r6, "storeFactory");
        this.f8686a = r5;
        this.f8687b = r6;
        this.c = new Object();
        this.d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.e = SetsKt.emptySet();
        this.f = $$Lambda$f$LFKycDnJEUwjo70JuqfhicRuFKk.INSTANCE;
    }

    public /* synthetic */ f(Function0 r2, Function1 r3, int r4, DefaultConstructorMarker r5) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = $$Lambda$f$mIgNq1s4Bw8U7iCPJXMmtfTdNcw.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = $$Lambda$f$3vtfwX27CwiLTLBcmuwAAxES5dI.INSTANCE;
    L8:
        this(r6, r7);
    }

    private static final int a(String r2, int r3, IStore r4) {
        IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r4, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "store");
        return r5.getInt(r2, r3);
    }

    private final IStore a(String r5) {
        Object r0 = this.c;
        monitor-enter(r0);
        Map<String, IStore> r1 = this.d;     // Catch: Throwable -> L10
        IStore r2 = r1.get(r5);     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = (IStore) ZeusTransformUtils.preCheckCast(this.f8687b.invoke(r5), IStore.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        r1.put(r5, r2);     // Catch: Throwable -> L10
    L7:
        IStore r4 = (IStore) ZeusTransformUtils.preCheckCast(r2, IStore.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    private final <T> T a(String r2, String r3, T r4, Function1<? super IStore, ? extends T> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        return (T) r6.invoke(a(r2));
    L5:
        a();
        return r4;
    }

    private static final Unit a(c r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return Unit.INSTANCE;
    }

    private final void a() {
        this.f8686a.invoke();     // Catch: Exception -> L4
        return;
    }

    private static final boolean a(String r2, boolean r3, IStore r4) {
        IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r4, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "store");
        return r5.getBoolean(r2, r3);
    }

    private static final IStore b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), r4, 0, 2, null);
    }

    private static final Unit b() {
        o r0 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r7 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        com.obric.memorydata.middleware.api.logging.g r1 = new com.obric.memorydata.middleware.api.logging.g();
        r1.a("provider", "keva");
        r0.a("feature_switch_read_failed", "Feature 开关读取失败，已使用默认值", r7, r1.a());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ IStore lambda$3vtfwX27CwiLTLBcmuwAAxES5dI(String r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$LFKycDnJEUwjo70JuqfhicRuFKk(c r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$PbU28QYCeq-jppELQWv_Gfrcdog, reason: not valid java name */
    public static /* synthetic */ int m514lambda$PbU28QYCeqjppELQWv_Gfrcdog(String r0, int r1, IStore r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ boolean lambda$X6q9WvIqKoIAemmBune33Chq6_E(String r0, boolean r1, IStore r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$mIgNq1s4Bw8U7iCPJXMmtfTdNcw() {
        return b();
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public int a(String r3, final String r4, final int r5) {
        Intrinsics.checkNotNullParameter(r3, "repo");
        Intrinsics.checkNotNullParameter(r4, "key");
        return ((Number) ZeusTransformUtils.preCheckCast(a(r3, r4, Integer.valueOf(r5), new $$Lambda$f$PbU28QYCeqjppELQWv_Gfrcdog(r4, r5)), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public void a(Set<c> r7, Function1<? super c, Unit> r8) {
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Function1<? super c, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "keys");
        Intrinsics.checkNotNullParameter(r10, "onChanged");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.memorydata.plugin")).a());
        goto L4
    L6:
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.memorydata.plugin");
        Object r4 = this.c;
        monitor-enter(r4);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(this.d.keySet(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L21
    L10:
        if (r5.hasNext() == false) goto L14;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        IStore r11 = (IStore) ZeusTransformUtils.preCheckCast(this.d.remove(r6), IStore.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r11 == null) goto L10;
        r11.unregisterChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        goto L10
    L14:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(this.d.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L21
    L16:
        if (r12.hasNext() == false) goto L18;
        a((String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin")).registerChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        goto L16
    L18:
        this.e = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L21
        this.f = r10;     // Catch: Throwable -> L21
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r4);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.awareness.impl.gate.d
    public boolean a(String r3, final String r4, final boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "repo");
        Intrinsics.checkNotNullParameter(r4, "key");
        return ((Boolean) ZeusTransformUtils.preCheckCast(a(r3, r4, Boolean.valueOf(r5), new $$Lambda$f$X6q9WvIqKoIAemmBune33Chq6_E(r4, r5)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    @Override // com.obric.memorydata.middleware.api.store.b
    public void onKeyChanged(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "repoName");
        Intrinsics.checkNotNullParameter(r3, "key");
        c r0 = new c(r2, r3);
        if (this.e.contains(r0) == false) goto L6;
        this.f.invoke(r0);
        return;
    }
}
