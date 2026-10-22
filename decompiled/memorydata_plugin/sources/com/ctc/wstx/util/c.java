package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f3689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Long f3690b = null;

    private static final class a implements Iterator<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Iterator<?> f3691a = null;

        static {
            f3691a = new a();
        }

        private a() {
        }

        public static <T> Iterator<T> a() {
            return (Iterator<T>) f3691a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    static {
        f3689a = new char[0];
        f3690b = Long.MAX_VALUE;
    }

    public static Object a(Object r2, int r3) {
        if (r2 == null) goto L10;
        int r0 = Array.getLength(r2);
        int r1 = ((r0 + 1) >> 1) + r0;
        if (r1 > r3) goto L7;
        r3 = r1;
    L7:
        Object r4 = Array.newInstance(r2.getClass().getComponentType(), r3);
        System.arraycopy(r2, 0, r4, 0, r0);
        return r4;
    L10:
        throw new IllegalArgumentException("Illegal to pass null; can not determine component type");
    }

    public static <T> Iterator<T> a(T r0) {
        return org.codehaus.stax2.b.a.a(r0);
    }

    public static <T> boolean a(Collection<T> r3, Collection<T> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r5.size() <= r6.size()) goto L5;
        r6 = r5;
        r5 = r6;
    L5:
        Iterator r7 = r5.iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        if (r6.contains(r7.next()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static char[] a() {
        return f3689a;
    }

    public static int[] a(int[] r1, int r2) {
        if (r1 != null) goto L6;
        return new int[r2];
    L6:
        return Arrays.copyOf(r1, r1.length + r2);
    }

    public static Object b(Object r3) {
        if (r3 == null) goto L6;
        int r0 = Array.getLength(r3);
        Object r1 = Array.newInstance(r3.getClass().getComponentType(), (r0 >> 1) + r0);
        System.arraycopy(r3, 0, r1, 0, r0);
        return r1;
    L6:
        throw new IllegalArgumentException("Illegal to pass null; can not determine component type");
    }

    public static <T> Iterator<T> b() {
        return a.a();
    }
}
