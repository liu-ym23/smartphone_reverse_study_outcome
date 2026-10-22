package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class ag extends c<String> implements ah, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final ah f4946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ag f4947b = null;
    private final List<Object> c;

    static {
        ag r0 = new ag(false);
        f4947b = r0;
        f4946a = r0;
    }

    public ag() {
        this(10);
    }

    public ag(int r2) {
        this(new ArrayList(r2));
    }

    private ag(ArrayList<Object> r1) {
        this.c = r1;
    }

    private ag(boolean r1) {
        super(r1);
        this.c = Collections.emptyList();
    }

    private static String a(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r2, ByteString.class) == false) goto L11;
        return ((ByteString) ZeusTransformUtils.preCheckCast(r2, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
    L11:
        return ab.b((byte[]) ZeusTransformUtils.preCheckCast(r2, byte[].class, "com.obric.memorydata.plugin"));
    }

    public ag a(int r2) {
        if (r2 < size()) goto L7;
        ArrayList r0 = new ArrayList(r2);
        r0.addAll(this.c);
        return new ag(r0);
    L7:
        throw new IllegalArgumentException();
    }

    public String a(int r1, String r2) {
        c();
        return a(this.c.set(r1, r2));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ah
    public void a(ByteString r2) {
        c();
        this.c.add(r2);
        this.modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, com.google.crypto.tink.shaded.protobuf.ab.i
    public /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        b(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r1) {
        return super.add(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public boolean addAll(int r3, Collection<? extends String> r4) {
        Collection<? extends Object> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        c();
        if (ZeusTransformUtils.instanceOf(r5, ah.class) == false) goto L5;
        r5 = ((ah) ZeusTransformUtils.preCheckCast(r5, ah.class, "com.obric.memorydata.plugin")).d();
    L5:
        boolean r6 = this.c.addAll(r3, r5);
        this.modCount++;
        return r6;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> r3) {
        Collection<? extends String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return addAll(size(), r4);
    }

    public String b(int r4) {
        Object r0 = this.c.get(r4);
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r0, ByteString.class) == false) goto L12;
        ByteString r1 = (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        String r2 = r1.toStringUtf8();
        if (r1.isValidUtf8() == false) goto L11;
        this.c.set(r4, r2);
    L11:
        return r2;
    L12:
        byte[] r3 = (byte[]) ZeusTransformUtils.preCheckCast(r0, byte[].class, "com.obric.memorydata.plugin");
        String r5 = ab.b(r3);
        if (ab.a(r3) == false) goto L15;
        this.c.set(r4, r5);
    L15:
        return r5;
    }

    public void b(int r2, String r3) {
        c();
        this.c.add(r2, r3);
        this.modCount++;
    }

    public String c(int r2) {
        c();
        Object r3 = this.c.remove(r2);
        this.modCount++;
        return a(r3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        c();
        this.c.clear();
        this.modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ah
    public Object d(int r1) {
        return this.c.get(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ah
    public List<?> d() {
        return Collections.unmodifiableList(this.c);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
    public /* synthetic */ ab.i e(int r1) {
        return a(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ah
    public ah e() {
        if (a() == true) goto L5;
        return this;
    L5:
        return new bw(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* synthetic */ Object get(int r1) {
        return b(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ Object remove(int r1) {
        return c(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object r1) {
        return super.remove(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean removeAll(Collection r3) {
        return super.removeAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean retainAll(Collection r3) {
        return super.retainAll((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return a(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c.size();
    }
}
