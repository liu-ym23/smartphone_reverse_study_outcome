package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmutableClassToInstanceMap<B> extends y<Class<? extends B>, B> implements m<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = null;
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableClassToInstanceMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableMap.a<Class<? extends B>, B> f4442a;

        public a() {
            this.f4442a = ImmutableMap.builder();
        }

        private static <T> T a(Class<T> r0, Object r1) {
            return (T) com.google.common.primitives.d.a(r0).cast(r1);
        }

        public <T extends B> a<B> a(Map<? extends Class<? extends T>, ? extends T> r5) {
            Iterator r6 = ((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Class<? extends B> r2 = (Class) ZeusTransformUtils.preCheckCast(r0.getKey(), Class.class, "com.obric.memorydata.plugin");
            Object r1 = r0.getValue();
            ImmutableMap.a<Class<? extends B>, B> r3 = this.f4442a;
            Object r4 = a(r2, r1);
            r3.b(r2, (B) r4);
            goto L4
        L6:
            return this;
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> r2 = this.f4442a.e();
            if (r2.isEmpty() == false) goto L7;
            return ImmutableClassToInstanceMap.of();
        L7:
            return new ImmutableClassToInstanceMap(r2, null);
        }
    }

    static {
        EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> r1) {
        this.delegate = r1;
    }

    /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static <B> a<B> builder() {
        return new a();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ImmutableClassToInstanceMap.class) == false) goto L7;
        return (ImmutableClassToInstanceMap) ZeusTransformUtils.preCheckCast(r4, ImmutableClassToInstanceMap.class, "com.obric.memorydata.plugin");
    L7:
        return new a().a(r4).a();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> r0, T r1) {
        return new ImmutableClassToInstanceMap(ImmutableMap.of(r0, r1));
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    public <T extends B> T getInstance(Class<T> r1) {
        return this.delegate.get(com.google.common.base.n.a(r1));
    }

    @Deprecated
    public <T extends B> T putInstance(Class<T> r1, T r2) {
        throw new UnsupportedOperationException();
    }

    Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return of();
    }
}
