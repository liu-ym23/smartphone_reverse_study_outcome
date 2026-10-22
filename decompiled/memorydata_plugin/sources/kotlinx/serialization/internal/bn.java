package kotlinx.serialization.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u000208J\u0014\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0!H\u0002J\u0013\u0010:\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010<H\u0096\u0002J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010?\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0004H\u0016J\u0010\u0010A\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\bH\u0016J\b\u0010B\u001a\u00020\bH\u0016J\u0010\u0010C\u001a\u0002082\u0006\u0010>\u001a\u00020\bH\u0016J\u000e\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020\u0012J\u000e\u0010F\u001a\u0002052\u0006\u0010G\u001a\u00020\u0012J\b\u0010H\u001a\u00020\u0004H\u0016R\u001b\u0010\n\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u001e\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001c0\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u00168@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b1\u00102¨\u0006I"}, d2 = {"Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "serialName", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", "", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "_hashCode", "get_hashCode", "()I", "_hashCode$delegate", "Lkotlin/Lazy;", "added", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "classAnnotations", "", "getElementsCount", "elementsOptionality", "", "indices", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "names", "[Ljava/lang/String;", "propertiesAnnotations", "[Ljava/util/List;", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "typeParameterDescriptors", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "addElement", "", ActivityLifecycle.NAME, "isOptional", "", "buildIndices", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", "getElementName", "hashCode", "isElementOptional", "pushAnnotation", "annotation", "pushClassAnnotation", "a", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class bn implements kotlinx.serialization.descriptors.f, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah<?> f17749b;
    private final int c;
    private int d;
    private final String[] e;
    private final List<Annotation>[] f;
    private List<Annotation> g;
    private final boolean[] h;
    private Map<String, Integer> i;
    private final Lazy j;
    private final Lazy k;
    private final Lazy l;

    public bn(String r3, ah<?> r4, int r5) {
        ah<?> r6 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "serialName");
        this.f17748a = r3;
        this.f17749b = r6;
        this.c = r5;
        this.d = -1;
        String[] r7 = new String[r5];
        int r8 = 0;
    L3:
        if (r8 >= r5) goto L5;
        r7[r8] = "[UNINITIALIZED]";
        r8 = r8 + 1;
        goto L3
    L5:
        this.e = r7;
        int r9 = this.c;
        this.f = new List[r9];
        this.h = new boolean[r9];
        this.i = MapsKt.emptyMap();
        this.j = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) ZeusTransformUtils.preCheckCast(new PluginGeneratedSerialDescriptor$childSerializers$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.k = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) ZeusTransformUtils.preCheckCast(new PluginGeneratedSerialDescriptor$typeParameterDescriptors$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.l = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) ZeusTransformUtils.preCheckCast(new PluginGeneratedSerialDescriptor$_hashCode$2(this), Function0.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ bn(String r2, ah r3, int r4, int r5, DefaultConstructorMarker r6) {
        ah r7 = (ah) ZeusTransformUtils.wrapperContextForParams(r3, ah.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r2, r7, r4);
    }

    public static final /* synthetic */ ah a(bn r0) {
        return r0.f17749b;
    }

    public static /* synthetic */ void a(bn r0, String r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        r0.a(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
    }

    private final kotlinx.serialization.c<?>[] i() {
        return (kotlinx.serialization.c[]) ZeusTransformUtils.preCheckCast(this.j.getValue(), kotlinx.serialization.c[].class, "com.obric.memorydata.plugin");
    }

    private final int j() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.l.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private final Map<String, Integer> k() {
        HashMap r0 = new HashMap();
        int r1 = this.e.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L7;
        Integer r4 = Integer.valueOf(r2);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(this.e[r2], r4);
        r2 = r2 + 1;
        goto L4
    L7:
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.descriptors.f
    public int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(this.i.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return -3;
    L7:
        return r1.intValue();
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a() {
        List<Annotation> r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a(int r1) {
        List<Annotation> r0 = this.f[r1];
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }

    public final void a(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        String[] r0 = this.e;
        int r1 = this.d + 1;
        this.d = r1;
        r0[r1] = r3;
        this.h[r1] = r4;
        this.f[r1] = null;
        if (r1 != (this.c - 1)) goto L6;
        this.i = k();
        return;
    }

    @Override // kotlinx.serialization.descriptors.f
    public final int b() {
        return this.c;
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f b(int r1) {
        return i()[r1].a();
    }

    @Override // kotlinx.serialization.descriptors.f
    public String c(int r1) {
        return this.e[r1];
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean c() {
        return kotlinx.serialization.descriptors.f.a.b(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean d() {
        return kotlinx.serialization.descriptors.f.a.a(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean d(int r1) {
        return this.h[r1];
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.j e() {
        return (kotlinx.serialization.descriptors.j) ZeusTransformUtils.preCheckCast(kotlinx.serialization.descriptors.k.a.f17691a, kotlinx.serialization.descriptors.j.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r8) {
        kotlinx.serialization.descriptors.f r1 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        if (r1 != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, bn.class) == true) goto L9;
    L26:
        return false;
    L9:
        if (Intrinsics.areEqual(r1.f(), ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).f()) == false) goto L26;
        if (Arrays.equals(h(), ((bn) ZeusTransformUtils.preCheckCast(r8, bn.class, "com.obric.memorydata.plugin")).h()) == false) goto L26;
        if (r1.b() != ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).b()) goto L26;
        int r7 = r1.b();
        int r0 = 0;
    L18:
        if (r0 >= r7) goto L31;
        if (Intrinsics.areEqual(r1.b(r0).f(), ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).b(r0).f()) == false) goto L26;
        if (Intrinsics.areEqual(r1.b(r0).e(), ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r8, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).b(r0).e()) == false) goto L26;
        r0 = r0 + 1;
        goto L18
    L31:
        return true;
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f() {
        return this.f17748a;
    }

    @Override // kotlinx.serialization.internal.n
    public Set<String> g() {
        return this.i.keySet();
    }

    public final kotlinx.serialization.descriptors.f[] h() {
        return (kotlinx.serialization.descriptors.f[]) ZeusTransformUtils.preCheckCast(this.k.getValue(), kotlinx.serialization.descriptors.f[].class, "com.obric.memorydata.plugin");
    }

    public int hashCode() {
        return j();
    }

    public String toString() {
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(RangesKt.until(0, this.c), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(f() + '(', CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, (Function1) ZeusTransformUtils.preCheckCast(new PluginGeneratedSerialDescriptor$toString$1(this), Function1.class, "com.obric.memorydata.plugin"), 24, null);
    }
}
