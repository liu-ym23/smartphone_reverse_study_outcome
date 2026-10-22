package kotlinx.serialization.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\f\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012*\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00030\u0006j\b\u0012\u0004\u0012\u0002H\u0003`\u00070\u0004B!\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014J\u001c\u0010\u0012\u001a\u00020\u0013*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014J$\u0010\u0014\u001a\u00020\u0015*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\u00020\u0015*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u001fJ'\u0010 \u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010!J'\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0014¢\u0006\u0002\u0010#R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlinx/serialization/internal/ReferenceArraySerializer;", "ElementKlass", "", "Element", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "kClass", "Lkotlin/reflect/KClass;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", "", "checkCapacity", "", "size", "collectionIterator", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "collectionSize", "([Ljava/lang/Object;)I", "insert", "index", "element", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "toBuilder", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "toResult", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class bv<ElementKlass, Element extends ElementKlass> extends u<Element, Element[], ArrayList<Element>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClass<ElementKlass> f17756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f17757b;

    public bv(KClass<ElementKlass> r3, kotlinx.serialization.c<Element> r4) {
        KClass<ElementKlass> r5 = (KClass) ZeusTransformUtils.wrapperContextForParams(r3, KClass.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.c r6 = (kotlinx.serialization.c) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "kClass");
        Intrinsics.checkNotNullParameter(r6, "eSerializer");
        super(r6, null);
        this.f17756a = r5;
        this.f17757b = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(new d(r6.a()), kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ int a(Object r3) {
        return a((ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.memorydata.plugin"));
    }

    public int a(ArrayList<Element> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public ArrayList<Element> a(Element[] r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast(ArraysKt.asList(r3), Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.internal.u, kotlinx.serialization.c, kotlinx.serialization.b
    public kotlinx.serialization.descriptors.f a() {
        return this.f17757b;
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ void a(Object r3, int r4) {
        a((ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.memorydata.plugin"), r4);
    }

    public void a(ArrayList<Element> r1, int r2) {
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

    public Element[] b(ArrayList<Element> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (Element[]) bl.a(r2, this.f17756a);
    }

    @Override // kotlinx.serialization.internal.a
    public /* synthetic */ Object c(Object r3) {
        return a((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin"));
    }

    public ArrayList<Element> c() {
        return new ArrayList();
    }

    @Override // kotlinx.serialization.internal.u
    public /* synthetic */ void insert(Object r3, int r4, Object r5) {
        insert((ArrayList) ZeusTransformUtils.preCheckCast(r3, ArrayList.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public void insert(ArrayList<Element> r1, int r2, Element r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.add(r2, r3);
    }
}
