package kotlin.collections.unsigned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b!¨\u0006\u0018"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "Lkotlin/ULong;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-VKZWuLQ", "(J)Z", "get", "index", "get-s-VKNKU", "(I)J", "indexOf", "indexOf-VKZWuLQ", "(J)I", "isEmpty", "lastIndexOf", "lastIndexOf-VKZWuLQ", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {
    final /* synthetic */ long[] $this_asList;

    UArraysKt___UArraysJvmKt$asList$2(long[] r1) {
        this.$this_asList = r1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final boolean contains(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ULong.class) == true) goto L7;
        return false;
    L7:
        return m1933containsVKZWuLQ(((ULong) ZeusTransformUtils.preCheckCast(r3, ULong.class, "com.obric.memorydata.plugin")).m1647unboximpl());
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m1933containsVKZWuLQ(long r1) {
        return ULongArray.m1651containsVKZWuLQ(this.$this_asList, r1);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* synthetic */ Object get(int r1) {
        return ULong.m1589boximpl(m1934getsVKNKU(r1));
    }

    /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
    public long m1934getsVKNKU(int r1) {
        return ULongArray.m1655getsVKNKU(this.$this_asList, r1);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return ULongArray.m1656getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ULong.class) == true) goto L7;
        return -1;
    L7:
        return m1935indexOfVKZWuLQ(((ULong) ZeusTransformUtils.preCheckCast(r3, ULong.class, "com.obric.memorydata.plugin")).m1647unboximpl());
    }

    /* JADX INFO: renamed from: indexOf-VKZWuLQ, reason: not valid java name */
    public int m1935indexOfVKZWuLQ(long r1) {
        return ArraysKt.indexOf(this.$this_asList, r1);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ULongArray.m1658isEmptyimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ULong.class) == true) goto L7;
        return -1;
    L7:
        return m1936lastIndexOfVKZWuLQ(((ULong) ZeusTransformUtils.preCheckCast(r3, ULong.class, "com.obric.memorydata.plugin")).m1647unboximpl());
    }

    /* JADX INFO: renamed from: lastIndexOf-VKZWuLQ, reason: not valid java name */
    public int m1936lastIndexOfVKZWuLQ(long r1) {
        return ArraysKt.lastIndexOf(this.$this_asList, r1);
    }
}
