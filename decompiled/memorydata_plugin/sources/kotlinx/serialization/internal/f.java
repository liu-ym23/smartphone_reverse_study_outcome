package kotlinx.serialization.internal;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u00050\u0002B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J\u001c\u0010\u000e\u001a\u00020\u000f*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014J$\u0010\u0010\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J1\u0010\u0013\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014J\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0014R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkotlinx/serialization/internal/ArrayListSerializer;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/serialization/internal/CollectionSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "element", "Lkotlinx/serialization/KSerializer;", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "insert", "index", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "toBuilder", "toResult", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f<E> extends v<E, List<? extends E>, ArrayList<E>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f17794a;

    public f(kotlinx.serialization.c<E> r3) {
        kotlinx.serialization.c r4 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "element");
        super(r4);
        this.f17794a = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new e(r4.a()), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ int a(Object r3) {
        return a((ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.memorydata.plugin"));
    }

    public int a(ArrayList<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public ArrayList<E> a(List<? extends E> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (ZeusTransformUtils.instanceOf(r2, ArrayList.class) == false) goto L5;
        ArrayList<E> r4 = (ArrayList) ZeusTransformUtils.preCheckCast(r2, ArrayList.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 == null) goto L8;
        return r4;
    L8:
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
    L5:
        r4 = null;
        goto L6
    }

    @Override // kotlinx.serialization.internal.u, kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return this.f17794a;
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ void a(Object r3, int r4) {
        a((ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.memorydata.plugin"), r4);
    }

    public void a(ArrayList<E> r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.ensureCapacity(r2);
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object b() {
        return c();
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object b(Object r3) {
        return b((ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.memorydata.plugin"));
    }

    public List<E> b(ArrayList<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object c(Object r3) {
        return a((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"));
    }

    public ArrayList<E> c() {
        return new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.u
    public /* synthetic */ void insert(Object r3, int r4, Object r5) {
        insert((ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public void insert(ArrayList<E> r1, int r2, E r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.add(r2, r3);
    }
}
