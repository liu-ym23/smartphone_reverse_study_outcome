package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.util.q;
import org.apache.logging.log4j.util.r;
import org.apache.logging.log4j.util.s;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultThreadContextStack implements ThreadContextStack, q {
    private static final Object[] EMPTY_OBJECT_ARRAY = null;
    private static final ThreadLocal<MutableThreadContextStack> STACK = null;
    private static final long serialVersionUID = 5050501;
    private final boolean useStack;

    static {
        EMPTY_OBJECT_ARRAY = new Object[0];
        STACK = new ThreadLocal();
    }

    public DefaultThreadContextStack(boolean r1) {
        this.useStack = r1;
    }

    private MutableThreadContextStack getNonNullStackCopy() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        ThreadContextStack r3 = new MutableThreadContextStack();
    L7:
        return (MutableThreadContextStack) ZeusTransformUtils.preCheckCast((MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r3, MutableThreadContextStack.class, "com.obric.memorydata.plugin"), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
    L5:
        r3 = r2.copy();
        goto L7
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(String r3) {
        return add2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public boolean add2(String r2) {
        if (this.useStack == true) goto L6;
        return false;
    L6:
        MutableThreadContextStack r1 = getNonNullStackCopy();
        r1.add2(r2);
        r1.freeze();
        STACK.set(r1);
        return true;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends String> r3) {
        Collection<? extends String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (this.useStack == true) goto L5;
        return false;
    L5:
        if (r4.isEmpty() == true) goto L11;
        MutableThreadContextStack r2 = getNonNullStackCopy();
        r2.addAll(r4);
        r2.freeze();
        STACK.set(r2);
        return true;
    L11:
        return false;
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public List<String> asList() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return Collections.emptyList();
    L7:
        return r2.asList();
    }

    @Override // java.util.Collection
    public void clear() {
        STACK.remove();
    }

    @Override // java.util.Collection
    public boolean contains(Object r3) {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.contains(r3) == false) goto L7;
        return true;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r4) {
        Collection<?> r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r3.isEmpty() == false) goto L5;
        return true;
    L5:
        MutableThreadContextStack r5 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
    L10:
        return false;
    L8:
        if (r5.containsAll(r3) == false) goto L10;
        return true;
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public /* bridge */ /* synthetic */ ThreadContext.ContextStack copy() {
        return copy();
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public ThreadContextStack copy() {
        if (this.useStack == false) goto L10;
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L10;
        return r2.copy();
    L10:
        return new MutableThreadContextStack();
    }

    @Override // java.util.Collection
    public boolean equals(Object r5) {
        if (this != r5) goto L7;
        return true;
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (ZeusTransformUtils.instanceOf(r5, DefaultThreadContextStack.class) == false) goto L15;
        DefaultThreadContextStack r0 = (DefaultThreadContextStack) ZeusTransformUtils.preCheckCast(r5, DefaultThreadContextStack.class, "com.obric.memorydata.plugin");
        if (this.useStack == r0.useStack) goto L15;
        return false;
    L15:
        if (ZeusTransformUtils.instanceOf(r5, ThreadContextStack.class) == true) goto L17;
        return false;
    L17:
        ThreadContextStack r4 = (ThreadContextStack) ZeusTransformUtils.preCheckCast(r5, ThreadContextStack.class, "com.obric.memorydata.plugin");
        MutableThreadContextStack r6 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L21;
        return false;
    L21:
        return r6.equals(r4);
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r3) {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        r3.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return;
    L5:
        r.b(r3, r2);
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public int getDepth() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.getDepth();
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public ThreadContext.ContextStack getImmutableStackOrNull() {
        return (ThreadContext.ContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), ThreadContext.ContextStack.class, "com.obric.memorydata.plugin");
    }

    @Override // java.util.Collection
    public int hashCode() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return 31 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        return true;
    L5:
        if (r2.isEmpty() == true) goto L8;
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<String> iterator() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return Collections.emptyList().iterator();
    L7:
        return r2.iterator();
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public String peek() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return "";
    L5:
        if (r2.isEmpty() == false) goto L8;
        return "";
    L8:
        return r2.peek();
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public String pop() {
        if (this.useStack == true) goto L5;
        return "";
    L5:
        ThreadLocal<MutableThreadContextStack> r4 = STACK;
        MutableThreadContextStack r1 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r4.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
    L12:
        return "";
    L8:
        if (r1.isEmpty() == true) goto L12;
        MutableThreadContextStack r0 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r1.copy(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        String r2 = r0.pop();
        r0.freeze();
        r4.set(r0);
        return r2;
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public void push(String r2) {
        if (this.useStack == true) goto L5;
        return;
    L5:
        add2(r2);
    }

    @Override // java.util.Collection
    public boolean remove(Object r5) {
        if (this.useStack == true) goto L5;
        return false;
    L5:
        ThreadLocal<MutableThreadContextStack> r4 = STACK;
        MutableThreadContextStack r1 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r4.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
    L12:
        return false;
    L8:
        if (r1.isEmpty() == true) goto L12;
        MutableThreadContextStack r0 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r1.copy(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        boolean r6 = r0.remove(r5);
        r0.freeze();
        r4.set(r0);
        return r6;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r5) {
        Collection<?> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (this.useStack == true) goto L5;
    L14:
        return false;
    L5:
        if (r6.isEmpty() == true) goto L14;
        ThreadLocal<MutableThreadContextStack> r4 = STACK;
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r4.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        if (r2.isEmpty() == true) goto L14;
        MutableThreadContextStack r0 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r2.copy(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        boolean r7 = r0.removeAll(r6);
        r0.freeze();
        r4.set(r0);
        return r7;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r5) {
        Collection<?> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (this.useStack == true) goto L5;
    L14:
        return false;
    L5:
        if (r6.isEmpty() == true) goto L14;
        ThreadLocal<MutableThreadContextStack> r4 = STACK;
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r4.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        if (r2.isEmpty() == true) goto L14;
        MutableThreadContextStack r0 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r2.copy(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        boolean r7 = r0.retainAll(r6);
        r0.freeze();
        r4.set(r0);
        return r7;
    }

    @Override // java.util.Collection
    public int size() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return s.f17940a;
    L7:
        return r2.toArray(EMPTY_OBJECT_ARRAY);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r3) {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        if (r3.length <= 0) goto L7;
        r3[0] = null;
    L7:
        return r3;
    L9:
        return (T[]) r2.toArray(r3);
    }

    public String toString() {
        MutableThreadContextStack r2 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(STACK.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L6:
        return r2.toString();
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public void trim(int r4) {
        if (r4 < 0) goto L9;
        ThreadLocal<MutableThreadContextStack> r3 = STACK;
        MutableThreadContextStack r0 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r3.get(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        MutableThreadContextStack r1 = (MutableThreadContextStack) ZeusTransformUtils.preCheckCast(r0.copy(), MutableThreadContextStack.class, "com.obric.memorydata.plugin");
        r1.trim(r4);
        r1.freeze();
        r3.set(r1);
        return;
    L9:
        throw new IllegalArgumentException("Maximum stack depth cannot be negative");
    }
}
