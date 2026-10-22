package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ae extends af {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final at f4941b;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.ae$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class a<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map.Entry<K, ae> f4942a;

        private a(Map.Entry<K, ae> r3) {
            this.f4942a = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ a(Map.Entry r2, AnonymousClass1 r3) {
            this((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        public ae a() {
            return (ae) ZeusTransformUtils.preCheckCast(this.f4942a.getValue(), ae.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4942a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            ae r2 = (ae) ZeusTransformUtils.preCheckCast(this.f4942a.getValue(), ae.class, "com.obric.memorydata.plugin");
            if (r2 != null) goto L7;
            return null;
        L7:
            return r2.a();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, at.class) == false) goto L7;
            return ((ae) ZeusTransformUtils.preCheckCast(this.f4942a.getValue(), ae.class, "com.obric.memorydata.plugin")).b((at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.memorydata.plugin"));
        L7:
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f4943a;

        public b(Iterator<Map.Entry<K, Object>> r3) {
            this.f4943a = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        }

        public Map.Entry<K, Object> a() {
            Map.Entry<K, Object> r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.f4943a.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r2.getValue(), ae.class) == true) goto L5;
            return r2;
        L5:
            return new a(r2, null);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4943a.hasNext();
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f4943a.remove();
        }
    }

    public at a() {
        return a(this.f4941b);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.af
    public boolean equals(Object r1) {
        return a().equals(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.af
    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
