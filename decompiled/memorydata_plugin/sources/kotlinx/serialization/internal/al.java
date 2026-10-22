package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u00050\u0002B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\u001c\u0010\u000e\u001a\u00020\u000f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J$\u0010\u0010\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J1\u0010\u0013\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lkotlinx/serialization/internal/HashSetSerializer;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/serialization/internal/CollectionSerializer;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "insert", "index", "element", "(Ljava/util/HashSet;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class al<E> extends v<E, Set<? extends E>, HashSet<E>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f17715a;

    public al(kotlinx.serialization.c<E> r3) {
        kotlinx.serialization.c r4 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "eSerializer");
        super(r4);
        this.f17715a = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new ak(r4.a()), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ int a(Object r3) {
        return a((HashSet) ZeusTransformUtils.preCheckCast(r3, HashSet.class, "com.obric.memorydata.plugin"));
    }

    public int a(HashSet<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public HashSet<E> a(Set<? extends E> r3) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (ZeusTransformUtils.instanceOf(r2, HashSet.class) == false) goto L5;
        HashSet<E> r4 = (HashSet) ZeusTransformUtils.preCheckCast(r2, HashSet.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return new HashSet((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
    L5:
        r4 = null;
        goto L6
    }

    @Override // kotlinx.serialization.internal.u, kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return this.f17715a;
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ void a(Object r3, int r4) {
        a((HashSet) ZeusTransformUtils.preCheckCast(r3, HashSet.class, "com.obric.memorydata.plugin"), r4);
    }

    public void a(HashSet<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object b() {
        return c();
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object b(Object r3) {
        return b((HashSet) ZeusTransformUtils.preCheckCast(r3, HashSet.class, "com.obric.memorydata.plugin"));
    }

    public Set<E> b(HashSet<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (Set) ZeusTransformUtils.preCheckCast(r2, Set.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object c(Object r3) {
        return a((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    public HashSet<E> c() {
        return new HashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.u
    public /* synthetic */ void insert(Object r3, int r4, Object r5) {
        insert((HashSet) ZeusTransformUtils.preCheckCast(r3, HashSet.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public void insert(HashSet<E> r1, int r2, E r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.add(r3);
    }
}
