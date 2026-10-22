package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class av {

    /* JADX INFO: renamed from: com.google.common.collect.av$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Field f4665a;

        private a(Field r1) {
            this.f4665a = r1;
            r1.setAccessible(true);
        }

        /* synthetic */ a(Field r1, AnonymousClass1 r2) {
            this(r1);
        }

        void a(T r1, int r2) {
            this.f4665a.set(r1, Integer.valueOf(r2));     // Catch: IllegalAccessException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        void a(T r1, Object r2) {
            this.f4665a.set(r1, r2);     // Catch: IllegalAccessException -> L4
            return;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    static int a(ObjectInputStream r0) {
        return r0.readInt();
    }

    static <T> a<T> a(Class<T> r1, String r2) {
        return new a(r1.getDeclaredField(r2), null);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    static <K, V> void a(am<K, V> r2, ObjectInputStream r3) {
        a((am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin"), r3, r3.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void a(am<K, V> r6, ObjectInputStream r7, int r8) {
        am r9 = (am) ZeusTransformUtils.wrapperContextForParams(r6, am.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        Collection r2 = r9.get(r7.readObject());
        int r3 = r7.readInt();
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r2.add(r7.readObject());
        r4 = r4 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    }

    static <K, V> void a(am<K, V> r4, ObjectOutputStream r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r4, am.class, "com.obric.memorydata.plugin");
        r5.writeInt(r6.asMap().size());
        Iterator<Map.Entry<K, Collection<V>>> r7 = r6.asMap().entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r5.writeObject(r0.getKey());
        r5.writeInt(((Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin")).size());
        Iterator r1 = ((Collection) ZeusTransformUtils.preCheckCast(r0.getValue(), Collection.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        r5.writeObject(r1.next());
        goto L7
    }

    static <E> void a(an<E> r2, ObjectInputStream r3) {
        a((an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin"), r3, r3.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> void a(an<E> r3, ObjectInputStream r4, int r5) {
        an r6 = (an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r6.add(r4.readObject(), r4.readInt());
        r0 = r0 + 1;
        goto L3
    }

    static <E> void a(an<E> r3, ObjectOutputStream r4) {
        an r5 = (an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin");
        r4.writeInt(r5.entrySet().size());
        Iterator<an.a<E>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        an.a r0 = (an.a) ZeusTransformUtils.preCheckCast(r6.next(), an.a.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getElement());
        r4.writeInt(r0.getCount());
        goto L4
    }

    static <K, V> void a(Map<K, V> r2, ObjectInputStream r3) {
        a((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), r3, r3.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> void a(Map<K, V> r3, ObjectInputStream r4, int r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        if (r0 >= r5) goto L5;
        r6.put(r4.readObject(), r4.readObject());
        r0 = r0 + 1;
        goto L3
    }

    static <K, V> void a(Map<K, V> r3, ObjectOutputStream r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        r4.writeInt(r5.size());
        Iterator<Map.Entry<K, V>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.writeObject(r0.getKey());
        r4.writeObject(r0.getValue());
        goto L4
    }
}
