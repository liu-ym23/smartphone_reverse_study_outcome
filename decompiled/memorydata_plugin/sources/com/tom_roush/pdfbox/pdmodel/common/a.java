package com.tom_roush.pdfbox.pdmodel.common;

import com.tom_roush.pdfbox.a.j;
import com.tom_roush.pdfbox.a.k;
import com.tom_roush.pdfbox.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes6.dex */
public class a<E> implements List<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.a f16179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<E> f16180b;
    private boolean c;
    private com.tom_roush.pdfbox.a.d d;
    private com.tom_roush.pdfbox.a.i e;

    public a() {
        this.c = false;
        this.f16179a = new com.tom_roush.pdfbox.a.a();
        this.f16180b = new ArrayList();
    }

    public a(E r2, com.tom_roush.pdfbox.a.b r3, com.tom_roush.pdfbox.a.d r4, com.tom_roush.pdfbox.a.i r5) {
        this.c = false;
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        this.f16179a = r0;
        r0.a(r3);
        ArrayList r6 = new ArrayList();
        this.f16180b = r6;
        r6.add(r2);
        this.d = r4;
        this.e = r5;
    }

    public a(List<E> r3, com.tom_roush.pdfbox.a.a r4) {
        List<E> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.c = false;
        this.f16180b = r5;
        this.f16179a = r4;
        if (r5.size() == r4.b()) goto L6;
        this.c = true;
        return;
    }

    public static com.tom_roush.pdfbox.a.a a(List<?> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r6, a.class) == true) goto L48;
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        Iterator<E> r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L49;
        E r1 = r7.next();
        if (ZeusTransformUtils.instanceOf(r1, String.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r1, Integer.class) == true) goto L32;
        if (ZeusTransformUtils.instanceOf(r1, Long.class) == true) goto L32;
        if (ZeusTransformUtils.instanceOf(r1, Float.class) == true) goto L31;
        if (ZeusTransformUtils.instanceOf(r1, Double.class) == true) goto L31;
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L27;
        com.tom_roush.pdfbox.a.b r2 = ((c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin")).e();
    L33:
        r0.a(r2);
        goto L9
    L27:
        if (r1 != null) goto L30;
        r2 = j.f16062b;
        goto L33
    L30:
        throw new IllegalArgumentException("Error: Don't know how to convert type to COSBase '" + r1.getClass().getName() + "'");
    L31:
        com.tom_roush.pdfbox.a.b r3 = new com.tom_roush.pdfbox.a.f(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).floatValue());
    L13:
        r0.a(r3);
    L32:
        r2 = com.tom_roush.pdfbox.a.h.a(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L33
    L12:
        r3 = new o((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"));
        goto L13
    L49:
        return r0;
    L48:
        return ((a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin")).f16179a;
    }

    public static List<Float> a(com.tom_roush.pdfbox.a.a r6) {
        if (r6 == null) goto L17;
        ArrayList r1 = new ArrayList(r6.b());
        int r2 = 0;
    L6:
        if (r2 >= r6.b()) goto L13;
        com.tom_roush.pdfbox.a.b r3 = r6.a(r2);
        if (ZeusTransformUtils.instanceOf(r3, k.class) == false) goto L10;
        r1.add(Float.valueOf(((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.memorydata.plugin")).a()));
    L11:
        r2 = r2 + 1;
        goto L6
    L10:
        r1.add(null);
        goto L11
    L13:
        return new a(r1, r6);
    L17:
        return null;
    }

    private List<com.tom_roush.pdfbox.a.b> a(Collection<?> r5) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        ArrayList r6 = new ArrayList(r4.size());
        Iterator<E> r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        E r1 = r7.next();
        if (ZeusTransformUtils.instanceOf(r1, String.class) == true) goto L7;
        r6.add(((c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin")).e());
        goto L4
    L7:
        r6.add(new o((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin")));
        goto L4
    L9:
        return r6;
    }

    @Override // java.util.List
    public void add(int r4, E r5) {
        if (this.c == true) goto L13;
        com.tom_roush.pdfbox.a.d r0 = this.d;
        if (r0 == null) goto L7;
        r0.a(this.e, this.f16179a);
        this.d = null;
    L7:
        this.f16180b.add(r4, r5);
        boolean r1 = ZeusTransformUtils.instanceOf(r5, String.class);
        com.tom_roush.pdfbox.a.a r3 = this.f16179a;
        if (r1 == false) goto L10;
        r3.a(r4, new o((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")));
        return;
    L10:
        r3.a(r4, ((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin")).e());
        return;
    L13:
        throw new UnsupportedOperationException("Adding an element in a filtered List is not permitted");
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E r5) {
        com.tom_roush.pdfbox.a.d r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(this.e, this.f16179a);
        this.d = null;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L8;
        this.f16179a.a(new o((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")));
    L12:
        return this.f16180b.add(r5);
    L8:
        com.tom_roush.pdfbox.a.a r1 = this.f16179a;
        if (r1 == null) goto L12;
        r1.a(((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin")).e());
        goto L12
    }

    @Override // java.util.List
    public boolean addAll(int r4, Collection<? extends E> r5) {
        Collection<? extends E> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        if (this.c == true) goto L12;
        if (this.d != null) goto L7;
    L9:
        this.f16179a.a(r4, a(r6));
        return this.f16180b.addAll(r4, r6);
    L7:
        if (r6.size() <= 0) goto L9;
        this.d.a(this.e, this.f16179a);
        this.d = null;
        goto L9
    L12:
        throw new UnsupportedOperationException("Inserting to a filtered List is not permitted");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> r4) {
        Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        if (this.c == true) goto L12;
        if (this.d != null) goto L7;
    L9:
        this.f16179a.a(a(r5));
        return this.f16180b.addAll(r5);
    L7:
        if (r5.size() <= 0) goto L9;
        this.d.a(this.e, this.f16179a);
        this.d = null;
        goto L9
    L12:
        throw new UnsupportedOperationException("Adding to a filtered List is not permitted");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        com.tom_roush.pdfbox.a.d r0 = this.d;
        if (r0 == null) goto L5;
        r0.a(this.e, null);
    L5:
        this.f16180b.clear();
        this.f16179a.a();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r1) {
        return this.f16180b.contains(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.f16180b.containsAll(r4);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r1) {
        return this.f16180b.equals(r1);
    }

    @Override // java.util.List
    public E get(int r1) {
        return this.f16180b.get(r1);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f16180b.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r1) {
        return this.f16180b.indexOf(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f16180b.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.f16180b.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r1) {
        return this.f16180b.lastIndexOf(r1);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return this.f16180b.listIterator();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r1) {
        return this.f16180b.listIterator(r1);
    }

    @Override // java.util.List
    public E remove(int r2) {
        if (this.c == true) goto L7;
        this.f16179a.f(r2);
        return this.f16180b.remove(r2);
    L7:
        throw new UnsupportedOperationException("removing entries from a filtered List is not permitted");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r3) {
        if (this.c == true) goto L10;
        int r4 = this.f16180b.indexOf(r3);
        if (r4 < 0) goto L7;
        this.f16180b.remove(r4);
        this.f16179a.f(r4);
        return true;
    L7:
        return false;
    L10:
        throw new UnsupportedOperationException("removing entries from a filtered List is not permitted");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r6) {
        Collection<?> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Iterator<E> r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        com.tom_roush.pdfbox.a.b r2 = ((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin")).e();
        int r3 = this.f16179a.b() - 1;
    L6:
        if (r3 < 0) goto L4;
        if (r2.equals(this.f16179a.a(r3)) == false) goto L10;
        this.f16179a.f(r3);
    L10:
        r3 = r3 - 1;
        goto L6
    L12:
        return this.f16180b.removeAll(r7);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r6) {
        Collection<?> r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Iterator<E> r0 = r7.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        com.tom_roush.pdfbox.a.b r2 = ((c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.memorydata.plugin")).e();
        int r3 = this.f16179a.b() - 1;
    L6:
        if (r3 < 0) goto L4;
        if (r2.equals(this.f16179a.a(r3)) == true) goto L10;
        this.f16179a.f(r3);
    L10:
        r3 = r3 - 1;
        goto L6
    L12:
        return this.f16180b.retainAll(r7);
    }

    @Override // java.util.List
    public E set(int r5, E r6) {
        if (this.c == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L11;
        o r0 = new o((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
        com.tom_roush.pdfbox.a.d r1 = this.d;
        if (r1 == null) goto L10;
        if (r5 != 0) goto L10;
        r1.a(this.e, r0);
    L10:
        this.f16179a.b(r5, r0);
    L17:
        return this.f16180b.set(r5, r6);
    L11:
        com.tom_roush.pdfbox.a.d r2 = this.d;
        if (r2 == null) goto L15;
        if (r5 != 0) goto L15;
        r2.a(this.e, ((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin")).e());
    L15:
        this.f16179a.b(r5, ((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin")).e());
        goto L17
    L19:
        throw new UnsupportedOperationException("Replacing an element in a filtered List is not permitted");
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f16180b.size();
    }

    @Override // java.util.List
    public List<E> subList(int r1, int r2) {
        return this.f16180b.subList(r1, r2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f16180b.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <X> X[] toArray(X[] r1) {
        return (X[]) this.f16180b.toArray(r1);
    }

    public String toString() {
        return "COSArrayList{" + this.f16179a.toString() + "}";
    }
}
