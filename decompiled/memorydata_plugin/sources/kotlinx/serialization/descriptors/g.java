package kotlinx.serialization.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.internal.bm;
import kotlinx.serialization.internal.n;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0096\u0002J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0004H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u00101\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\bH\u0016J\u0010\u00107\u001a\u00020-2\u0006\u00101\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020\u0004H\u0016R\u001b\u0010\u000e\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\n0\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040(X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00069"}, d2 = {"Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "elementsCount", "", "typeParameters", "", "builder", "Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "annotations", "", "getAnnotations", "()Ljava/util/List;", "elementAnnotations", "", "[Ljava/util/List;", "elementDescriptors", "[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementNames", "[Ljava/lang/String;", "elementOptionality", "", "getElementsCount", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "name2Index", "", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "typeParametersDescriptors", "equals", "", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", ActivityLifecycle.NAME, "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g implements f, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f17682b;
    private final int c;
    private final List<Annotation> d;
    private final Set<String> e;
    private final String[] f;
    private final f[] g;
    private final List<Annotation>[] h;
    private final boolean[] i;
    private final Map<String, Integer> j;
    private final f[] k;
    private final Lazy l;

    public g(String r4, j r5, int r6, List<? extends f> r7, a r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "serialName");
        Intrinsics.checkNotNullParameter(r5, MemoryInfoSectionEditActivity.EXTRA_KIND);
        Intrinsics.checkNotNullParameter(r9, "typeParameters");
        Intrinsics.checkNotNullParameter(r8, "builder");
        this.f17681a = r4;
        this.f17682b = r5;
        this.c = r6;
        this.d = r8.a();
        this.e = (Set) ZeusTransformUtils.preCheckCast(CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast(r8.b(), Iterable.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
        Object[] r10 = ((Collection) ZeusTransformUtils.preCheckCast(r8.b(), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] r11 = (String[]) ZeusTransformUtils.preCheckCast(r10, String[].class, "com.obric.memorydata.plugin");
        this.f = r11;
        this.g = bm.a(r8.c());
        Object[] r12 = ((Collection) ZeusTransformUtils.preCheckCast(r8.d(), Collection.class, "com.obric.memorydata.plugin")).toArray(new List[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.h = (List[]) ZeusTransformUtils.preCheckCast(r12, List[].class, "com.obric.memorydata.plugin");
        this.i = CollectionsKt.toBooleanArray((Collection) ZeusTransformUtils.preCheckCast(r8.e(), Collection.class, "com.obric.memorydata.plugin"));
        Iterable r13 = ArraysKt.withIndex(r11);
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        IndexedValue r16 = (IndexedValue) ZeusTransformUtils.preCheckCast(r15.next(), IndexedValue.class, "com.obric.memorydata.plugin");
        r14.add(TuplesKt.to(r16.getValue(), Integer.valueOf(r16.getIndex())));
        goto L4
    L6:
        this.j = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        this.k = bm.a(r9);
        this.l = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new SerialDescriptorImpl$_hashCode$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ f[] a(g r0) {
        return r0.k;
    }

    private final int h() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.l.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    @Override // kotlinx.serialization.descriptors.f
    public int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.j.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return -3;
    L7:
        return r1.intValue();
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a() {
        return this.d;
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a(int r1) {
        return this.h[r1];
    }

    @Override // kotlinx.serialization.descriptors.f
    public int b() {
        return this.c;
    }

    @Override // kotlinx.serialization.descriptors.f
    public f b(int r1) {
        return this.g[r1];
    }

    @Override // kotlinx.serialization.descriptors.f
    public String c(int r1) {
        return this.f[r1];
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean c() {
        return f.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean d() {
        return f.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean d(int r1) {
        return this.i[r1];
    }

    @Override // kotlinx.serialization.descriptors.f
    public j e() {
        return this.f17682b;
    }

    public boolean equals(Object r8) {
        f r1 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");
        if (r1 != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, g.class) == true) goto L9;
    L26:
        return false;
    L9:
        if (Intrinsics.areEqual(r1.f(), ((f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.memorydata.plugin")).f()) == false) goto L26;
        if (Arrays.equals(this.k, ((g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.memorydata.plugin")).k) == false) goto L26;
        if (r1.b() != ((f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.memorydata.plugin")).b()) goto L26;
        int r7 = r1.b();
        int r0 = 0;
    L18:
        if (r0 >= r7) goto L31;
        if (Intrinsics.areEqual(r1.b(r0).f(), ((f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.memorydata.plugin")).b(r0).f()) == false) goto L26;
        if (Intrinsics.areEqual(r1.b(r0).e(), ((f) ZeusTransformUtils.preCheckCast(r8, f.class, "com.obric.memorydata.plugin")).b(r0).e()) == false) goto L26;
        r0 = r0 + 1;
        goto L18
    L31:
        return true;
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f() {
        return this.f17681a;
    }

    @Override // kotlinx.serialization.internal.n
    public Set<String> g() {
        return this.e;
    }

    public int hashCode() {
        return h();
    }

    public String toString() {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, b()), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(f() + '(', CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(new SerialDescriptorImpl$toString$1(this), Function1.class, "com.obric.memorydata.plugin"), 24, null);
    }
}
