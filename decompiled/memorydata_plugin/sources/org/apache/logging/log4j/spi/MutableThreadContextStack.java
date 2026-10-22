package org.apache.logging.log4j.spi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.util.q;

/* JADX INFO: loaded from: classes6.dex */
public class MutableThreadContextStack implements ThreadContextStack, q {
    private static final long serialVersionUID = 50505011;
    private boolean frozen;
    private final List<String> list;

    public MutableThreadContextStack() {
        this(new ArrayList());
    }

    public MutableThreadContextStack(List<String> r3) {
        this.list = new ArrayList((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private MutableThreadContextStack(MutableThreadContextStack r2) {
        this.list = new ArrayList(r2.list);
    }

    private void checkInvariants() {
        if (this.frozen == true) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("context stack has been frozen");
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(String r3) {
        return add2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public boolean add2(String r1) {
        checkInvariants();
        return this.list.add(r1);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends String> r3) {
        Collection<? extends String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        checkInvariants();
        return this.list.addAll(r4);
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public List<String> asList() {
        return this.list;
    }

    @Override // java.util.Collection
    public void clear() {
        checkInvariants();
        this.list.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object r1) {
        return this.list.contains(r1);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.list.containsAll(r4);
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public /* bridge */ /* synthetic */ ThreadContext.ContextStack copy() {
        return copy();
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public ThreadContextStack copy() {
        return new MutableThreadContextStack(this);
    }

    @Override // java.util.Collection
    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if (r3 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r3, ThreadContextStack.class) == true) goto L11;
        return false;
    L11:
        List<String> r4 = ((ThreadContextStack) ZeusTransformUtils.preCheckCast(r3, ThreadContextStack.class, "com.obric.memorydata.plugin")).asList();
        return Objects.equals(this.list, r4);
    }

    @Override // org.apache.logging.log4j.util.q
    public void formatTo(StringBuilder r5) {
        r5.append('[');
        int r0 = 0;
    L4:
        if (r0 >= this.list.size()) goto L8;
        if (r0 <= 0) goto L7;
        r5.append(',').append(' ');
    L7:
        r5.append((String) ZeusTransformUtils.preCheckCast(this.list.get(r0), String.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L4
    L8:
        r5.append(']');
    }

    public void freeze() {
        this.frozen = true;
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public int getDepth() {
        return this.list.size();
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public ThreadContext.ContextStack getImmutableStackOrNull() {
        return copy();
    }

    @Override // java.util.Collection
    public int hashCode() {
        return Objects.hashCode(this.list) + 31;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<String> iterator() {
        return this.list.iterator();
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public String peek() {
        if (this.list.isEmpty() == false) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(this.list.get(this.list.size() - 1), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public String pop() {
        checkInvariants();
        if (this.list.isEmpty() == false) goto L7;
        return null;
    L7:
        return (String) ZeusTransformUtils.preCheckCast(this.list.remove(this.list.size() - 1), String.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public void push(String r1) {
        checkInvariants();
        this.list.add(r1);
    }

    @Override // java.util.Collection
    public boolean remove(Object r1) {
        checkInvariants();
        return this.list.remove(r1);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        checkInvariants();
        return this.list.removeAll(r4);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        checkInvariants();
        return this.list.retainAll(r4);
    }

    @Override // java.util.Collection
    public int size() {
        return this.list.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r1) {
        return (T[]) this.list.toArray(r1);
    }

    public String toString() {
        return String.valueOf(this.list);
    }

    @Override // org.apache.logging.log4j.ThreadContext.ContextStack
    public void trim(int r4) {
        checkInvariants();
        if (r4 < 0) goto L13;
        if (this.list != null) goto L7;
        return;
    L7:
        ArrayList r0 = new ArrayList(this.list.size());
        int r5 = Math.min(r4, this.list.size());
        int r1 = 0;
    L8:
        if (r1 >= r5) goto L10;
        r0.add(this.list.get(r1));
        r1 = r1 + 1;
        goto L8
    L10:
        this.list.clear();
        this.list.addAll(r0);
        return;
    L13:
        throw new IllegalArgumentException("Maximum stack depth cannot be negative");
    }
}
