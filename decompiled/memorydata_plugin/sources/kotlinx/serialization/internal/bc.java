package kotlinx.serialization.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f\u0082\u0001\u0002#$¨\u0006%"}, d2 = {"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", ActivityLifecycle.NAME, "getElementName", "hashCode", "isElementOptional", "toString", "Lkotlinx/serialization/internal/HashMapClassDesc;", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class bc implements kotlinx.serialization.descriptors.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f17738b;
    private final kotlinx.serialization.descriptors.f c;
    private final int d;

    private bc(String r3, kotlinx.serialization.descriptors.f r4, kotlinx.serialization.descriptors.f r5) {
        kotlinx.serialization.descriptors.f r6 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.descriptors.f r7 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        this.f17737a = r3;
        this.f17738b = r6;
        this.c = r7;
        this.d = 2;
    }

    public /* synthetic */ bc(String r2, kotlinx.serialization.descriptors.f r3, kotlinx.serialization.descriptors.f r4, DefaultConstructorMarker r5) {
        this(r2, (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"), (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlinx.serialization.descriptors.f
    public int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        Integer r1 = StringsKt.toIntOrNull(r2);
        if (r1 == null) goto L7;
        return r1.intValue();
    L7:
        throw new IllegalArgumentException(r2 + " is not a valid map index");
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a() {
        return kotlinx.serialization.descriptors.f.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a(int r3) {
        if (r3 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        return CollectionsKt.emptyList();
    L9:
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + f() + " expects only non-negative indices").toString());
    L4:
        r0 = false;
        goto L5
    }

    @Override // kotlinx.serialization.descriptors.f
    public int b() {
        return this.d;
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f b(int r3) {
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L16;
        int r4 = r3 % 2;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L12;
        return this.c;
    L12:
        throw new IllegalStateException("Unreached".toString());
    L14:
        return this.f17738b;
    L16:
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + f() + " expects only non-negative indices").toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // kotlinx.serialization.descriptors.f
    public String c(int r1) {
        return String.valueOf(r1);
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
    public boolean d(int r3) {
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException(("Illegal index " + r3 + ", " + f() + " expects only non-negative indices").toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.j e() {
        return (kotlinx.serialization.descriptors.j) ZeusTransformUtils.preCheckCast(kotlinx.serialization.descriptors.k.c.f17693a, kotlinx.serialization.descriptors.j.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, bc.class) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(f(), ((bc) ZeusTransformUtils.preCheckCast(r7, bc.class, "com.obric.memorydata.plugin")).f()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17738b, ((bc) ZeusTransformUtils.preCheckCast(r7, bc.class, "com.obric.memorydata.plugin")).f17738b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, ((bc) ZeusTransformUtils.preCheckCast(r7, bc.class, "com.obric.memorydata.plugin")).c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f() {
        return this.f17737a;
    }

    public int hashCode() {
        return (((f().hashCode() * 31) + this.f17738b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return f() + '(' + this.f17738b + ", " + this.c + ')';
    }
}
