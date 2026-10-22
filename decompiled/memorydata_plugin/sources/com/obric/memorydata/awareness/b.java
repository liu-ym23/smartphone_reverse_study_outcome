package com.obric.memorydata.awareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\rJ\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\n2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/awareness/GeoFenceCallbackClassifier;", "", "cooldownDurationMs", "", "currentTimeMillis", "Lkotlin/Function0;", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "registrations", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/awareness/GeoFenceCallbackClassifier$Registration;", "register", "", "fenceId", "firstBreachSupported", "", "clear", "clearAll", "classify", "Lcom/obric/memorydata/awareness/GeoFenceCallbackPolicy$CallbackType;", "firstBreachProvider", "Registration", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Long> f8538b;
    private final ConcurrentHashMap<String, a> c;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/awareness/GeoFenceCallbackClassifier$Registration;", "", "firstBreachSupported", "", "createdAt", "", "<init>", "(ZJ)V", "getFirstBreachSupported", "()Z", "getCreatedAt", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f8540b;

        public a(boolean r1, long r2) {
            this.f8539a = r1;
            this.f8540b = r2;
        }

        public final boolean a() {
            return this.f8539a;
        }

        public final long b() {
            return this.f8540b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (this.f8539a == r8.f8539a) goto L12;
            return false;
        L12:
            if (this.f8540b == r8.f8540b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f8539a) * 31) + Long.hashCode(this.f8540b);
        }

        public String toString() {
            return "Registration(firstBreachSupported=" + this.f8539a + ", createdAt=" + this.f8540b + ')';
        }
    }

    public b(long r3, Function0<Long> r5) {
        Function0<Long> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "currentTimeMillis");
        this.f8537a = r3;
        this.f8538b = r6;
        this.c = new ConcurrentHashMap();
    }

    public /* synthetic */ b(long r2, Function0 r4, int r5, DefaultConstructorMarker r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r7 = (Function0) ZeusTransformUtils.preCheckCast(GeoFenceCallbackClassifier$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    L5:
        this(r2, r7);
    }

    public final GeoFenceCallbackPolicy.CallbackType a(String r6, Function0<Boolean> r7) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r7, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "fenceId");
        Intrinsics.checkNotNullParameter(r8, "firstBreachProvider");
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.c.get(r6), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return GeoFenceCallbackPolicy.CallbackType.REAL_TRANSITION;
    L7:
        if (r0.a() == false) goto L15;
        if (Intrinsics.areEqual(r8.invoke(), false) == false) goto L11;
    L12:
        this.c.remove(r6, r0);
        return GeoFenceCallbackPolicy.CallbackType.REAL_TRANSITION;
    L11:
        return GeoFenceCallbackPolicy.CallbackType.INITIAL_STATE;
    L15:
        if ((((Number) ZeusTransformUtils.preCheckCast(this.f8538b.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue() - r0.b()) >= this.f8537a) goto L12;
        return GeoFenceCallbackPolicy.CallbackType.INITIAL_STATE;
    }

    public final void a() {
        this.c.clear();
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "fenceId");
        this.c.remove(r2);
    }

    public final void a(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "fenceId");
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(r5, new a(r6, ((Number) ZeusTransformUtils.preCheckCast(this.f8538b.invoke(), Number.class, "com.obric.memorydata.plugin")).longValue()));
    }
}
