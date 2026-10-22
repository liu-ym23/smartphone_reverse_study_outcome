package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public final class MutableClassToInstanceMap<B> extends y<Class<? extends B>, B> implements m<B>, Serializable {
    private final Map<Class<? extends B>, B> delegate;

    /* JADX INFO: renamed from: com.google.common.collect.MutableClassToInstanceMap$2, reason: invalid class name */
    class AnonymousClass2 extends ae<Map.Entry<Class<? extends B>, B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MutableClassToInstanceMap f4575a;

        AnonymousClass2(MutableClassToInstanceMap r1) {
            this.f4575a = r1;
        }

        private static /* synthetic */ Map.Entry a(Map.Entry r2) {
            return MutableClassToInstanceMap.access$100((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: lambda$c_7-NMBT0JkXLJIfNikNzUfjmkw, reason: not valid java name */
        public static /* synthetic */ Map.Entry m129lambda$c_7NMBT0JkXLJIfNikNzUfjmkw(Map.Entry r0) {
            return a(r0);
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return this.f4575a.delegate().entrySet();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            final Iterator<Map.Entry<Class<? extends B>, B>> r1 = delegate().iterator();
            return new AnonymousClass1(this, r1);
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<Map.Entry<Class<? extends B>, B>> spliterator() {
            return p.a(delegate().spliterator(), $$Lambda$MutableClassToInstanceMap$2$c_7NMBT0JkXLJIfNikNzUfjmkw.INSTANCE);
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r1) {
            return (T[]) standardToArray(r1);
        }
    }

    private static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        SerializedForm(Map<Class<? extends B>, B> r3) {
            this.backingMap = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        }

        Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> r3) {
        this.delegate = (Map) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Object access$000(Class r0, Object r1) {
        return cast(r0, r1);
    }

    static /* synthetic */ Map.Entry access$100(Map.Entry r2) {
        return checkedEntry((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin"));
    }

    private static <T> T cast(Class<T> r0, Object r1) {
        return (T) com.google.common.primitives.d.a(r0).cast(r1);
    }

    private static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> r2) {
        final Map.Entry r3 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r3);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap(new HashMap());
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> r2) {
        return new MutableClassToInstanceMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.y, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new AnonymousClass2(this);
    }

    public <T extends B> T getInstance(Class<T> r1) {
        return (T) cast(r1, get(r1));
    }

    public B put(Class<? extends B> r1, B r2) {
        cast(r1, r2);
        return (B) super.put(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.y, java.util.Map
    public /* synthetic */ Object put(Object r3, Object r4) {
        return put((Class) ZeusTransformUtils.preCheckCast(r3, Class.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.y, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> r6) {
        LinkedHashMap r0 = new LinkedHashMap((Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        Iterator r7 = r0.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        cast((Class) ZeusTransformUtils.preCheckCast(r2.getKey(), Class.class, "com.obric.memorydata.plugin"), r2.getValue());
        goto L4
    L6:
        super.putAll(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> r1, T r2) {
        return (T) cast(r1, put(r1, r2));
    }
}
