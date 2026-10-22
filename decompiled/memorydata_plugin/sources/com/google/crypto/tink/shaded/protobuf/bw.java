package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class bw extends AbstractList<String> implements ah, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f5003a;

    public bw(ah r3) {
        this.f5003a = (ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ ah a(bw r0) {
        return r0.f5003a;
    }

    public String a(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.f5003a.get(r2), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ah
    public void a(ByteString r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ah
    public Object d(int r1) {
        return this.f5003a.d(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ah
    public List<?> d() {
        return this.f5003a.d();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ah
    public ah e() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* synthetic */ Object get(int r1) {
        return a(r1);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new AnonymousClass2(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(final int r2) {
        return new AnonymousClass1(this, r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f5003a.size();
    }
}
