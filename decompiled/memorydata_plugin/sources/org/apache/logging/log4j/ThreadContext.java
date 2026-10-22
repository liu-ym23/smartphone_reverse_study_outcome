package org.apache.logging.log4j;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.spi.DefaultThreadContextStack;
import org.apache.logging.log4j.spi.ThreadContextStack;
import org.apache.logging.log4j.spi.j;
import org.apache.logging.log4j.spi.m;
import org.apache.logging.log4j.spi.n;
import org.apache.logging.log4j.spi.p;
import org.apache.logging.log4j.util.PropertiesUtil;

/* JADX INFO: loaded from: classes6.dex */
public final class ThreadContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f17881a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadContextStack f17882b = null;
    private static boolean c;
    private static n d;
    private static ThreadContextStack e;
    private static m f;

    /* JADX INFO: renamed from: org.apache.logging.log4j.ThreadContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface ContextStack extends Serializable, Collection<String> {
        List<String> asList();

        ContextStack copy();

        int getDepth();

        ContextStack getImmutableStackOrNull();

        String peek();

        String pop();

        void push(String r1);

        void trim(int r1);
    }

    private static class EmptyThreadContextStack extends AbstractCollection<String> implements ThreadContextStack {
        private static final Iterator<String> EMPTY_ITERATOR = null;
        private static final long serialVersionUID = 1;

        static {
            EMPTY_ITERATOR = new a(null);
        }

        private EmptyThreadContextStack() {
        }

        /* synthetic */ EmptyThreadContextStack(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public /* synthetic */ boolean add(String r3) {
            return add2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
        public boolean add2(String r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends String> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.logging.log4j.ThreadContext.ContextStack
        public List<String> asList() {
            return Collections.emptyList();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            return false;
        }

        @Override // org.apache.logging.log4j.ThreadContext.ContextStack
        public ContextStack copy() {
            return this;
        }

        @Override // java.util.Collection
        public boolean equals(Object r2) {
            if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L5;
        L7:
            return false;
        L5:
            if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
            return true;
        }

        @Override // org.apache.logging.log4j.ThreadContext.ContextStack
        public int getDepth() {
            return 0;
        }

        @Override // org.apache.logging.log4j.ThreadContext.ContextStack
        public ContextStack getImmutableStackOrNull() {
            return this;
        }

        @Override // java.util.Collection
        public int hashCode() {
            return 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<String> iterator() {
            return EMPTY_ITERATOR;
        }

        @Override // org.apache.logging.log4j.ThreadContext.ContextStack
        public String peek() {
            return null;
        }

        @Override // org.apache.logging.log4j.ThreadContext.ContextStack
        public String pop() {
            return null;
        }

        @Override // org.apache.logging.log4j.ThreadContext.ContextStack
        public void push(String r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.logging.log4j.ThreadContext.ContextStack
        public void trim(int r1) {
        }
    }

    private static class a<E> implements Iterator<E> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            throw new NoSuchElementException("This is an empty iterator!");
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    static {
        f17881a = Collections.emptyMap();
        f17882b = new EmptyThreadContextStack(null);
        a();
    }

    static void a() {
        p.a();
        m r0 = null;
        d = null;
        PropertiesUtil r1 = PropertiesUtil.a();
        boolean r2 = r1.a("disableThreadContext");
        boolean r4 = true;
        if (r1.a("disableThreadContextStack") == true) goto L6;
        if (r2 == true) goto L6;
        boolean r3 = true;
    L7:
        c = r3;
        if (r1.a("disableThreadContextMap") == true) goto L11;
        if (r2 == true) goto L11;
    L12:
        e = new DefaultThreadContextStack(c);
        if (r4 == true) goto L15;
        n r5 = new j();
    L16:
        d = r5;
        if (ZeusTransformUtils.instanceOf(d, m.class) == false) goto L19;
        r0 = (m) ZeusTransformUtils.preCheckCast(d, m.class, "com.obric.memorydata.plugin");
    L19:
        f = r0;
        return;
    L15:
        r5 = p.b();
    L11:
        r4 = false;
    L6:
        r3 = false;
        goto L7
    }

    public static Map<String, String> b() {
        Map<String, String> r0 = d.getImmutableMapOrNull();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return f17881a;
    }

    public static Map<String, String> getContext() {
        return d.getCopy();
    }
}
