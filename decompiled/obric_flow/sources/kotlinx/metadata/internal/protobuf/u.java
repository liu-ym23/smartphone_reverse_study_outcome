package kotlinx.metadata.internal.protobuf;

import java.io.UnsupportedEncodingException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends AbstractList implements v, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p0 f19207b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f19208a;

    static {
        f19207b = new p0(new u());
    }

    public u() {
        this.f19208a = new ArrayList();
    }

    @Override // kotlinx.metadata.internal.protobuf.v
    public final void a(x r5) {
        this.f19208a.add(r5);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r5, Object r10) {
        this.f19208a.add(r5, (String) r10);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection r5) {
        return addAll(this.f19208a.size(), r5);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f19208a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r5) {
        ArrayList r10 = this.f19208a;
        Object r11 = r10.get(r5);
        if ((r11 instanceof String) == false) goto L6;
        return (String) r11;
    L6:
        if ((r11 instanceof e) == false) goto L11;
        e r12 = (e) r11;
        String r13 = r12.p();
        if (r12.i() == false) goto L22;
        r10.set(r5, r13);
    L22:
        return r13;
    L11:
        byte[] r14 = (byte[]) r11;
        byte[] r15 = t.f19206a;
        r13 = new String(r14, "UTF-8");     // Catch: UnsupportedEncodingException -> L17
        if (j0.c(r14, 0, r14.length) != 0) goto L22;
        r10.set(r5, r13);
    L17:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    @Override // kotlinx.metadata.internal.protobuf.v
    public final e getByteString(int r10) {
        ArrayList r5 = this.f19208a;
        Object r11 = r5.get(r10);
        if ((r11 instanceof e) == false) goto L6;
        e r12 = (e) r11;
    L9:
        if (r12 == r11) goto L11;
        r5.set(r10, r12);
    L11:
        return r12;
    L6:
        if ((r11 instanceof String) == false) goto L8;
        r12 = e.d((String) r11);
        goto L9
    L8:
        byte[] r13 = (byte[]) r11;
        int r14 = r13.length;
        byte[] r15 = new byte[r14];
        System.arraycopy(r13, 0, r15, 0, r14);
        r12 = new x(r15);
        goto L9
    }

    @Override // kotlinx.metadata.internal.protobuf.v
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f19208a);
    }

    @Override // kotlinx.metadata.internal.protobuf.v
    public final p0 getUnmodifiableView() {
        return new p0(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int r5) {
        Object r10 = this.f19208a.remove(r5);
        ((AbstractList) this).modCount++;
        if ((r10 instanceof String) == false) goto L6;
        return (String) r10;
    L6:
        if ((r10 instanceof e) == true) goto L18;
        byte[] r11 = (byte[]) r10;
        byte[] r12 = t.f19206a;
        return new String(r11, "UTF-8");
    L12:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    L18:
        return ((e) r10).p();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r5, Object r10) {
        ArrayList r11 = this.f19208a;
        Object r12 = r11.set(r5, (String) r10);
        if ((r12 instanceof String) == false) goto L6;
        return (String) r12;
    L6:
        if ((r12 instanceof e) == true) goto L18;
        byte[] r13 = (byte[]) r12;
        byte[] r14 = t.f19206a;
        return new String(r13, "UTF-8");
    L12:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    L18:
        return ((e) r12).p();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f19208a.size();
    }

    public u(v r5) {
        this.f19208a = new ArrayList(r5.size());
        addAll(r5);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int r5, Collection r10) {
        if ((r10 instanceof v) == false) goto L5;
        r10 = ((v) r10).getUnderlyingElements();
    L5:
        boolean r11 = this.f19208a.addAll(r5, r10);
        ((AbstractList) this).modCount++;
        return r11;
    }
}
