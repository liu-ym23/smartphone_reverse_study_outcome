package kotlinx.serialization.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0013\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010$\u001a\u00020\u000bH\u0097\u0001J\u0011\u0010%\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u000bH\u0097\u0001J\u0011\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0019H\u0097\u0001J\u0011\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u000bH\u0097\u0001J\b\u0010)\u001a\u00020\u000bH\u0016J\u0011\u0010*\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000bH\u0097\u0001J\b\u0010+\u001a\u00020\u0019H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00138\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006,"}, d2 = {"Lkotlinx/serialization/internal/SerialDescriptorForNullable;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Lkotlinx/serialization/internal/CachedNames;", "original", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isInline", "", "()Z", "isNullable", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getOriginal$kotlinx_serialization_core", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "serialNames", "", "getSerialNames", "()Ljava/util/Set;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", ActivityLifecycle.NAME, "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class bw implements kotlinx.serialization.descriptors.f, n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f17758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f17759b;
    private final Set<String> c;

    public bw(kotlinx.serialization.descriptors.f r3) {
        kotlinx.serialization.descriptors.f r4 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "original");
        this.f17758a = r4;
        this.f17759b = r4.f() + '?';
        this.c = bm.a(r4);
    }

    @Override // kotlinx.serialization.descriptors.f
    public int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return this.f17758a.a(r2);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a() {
        return this.f17758a.a();
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a(int r1) {
        return this.f17758a.a(r1);
    }

    @Override // kotlinx.serialization.descriptors.f
    public int b() {
        return this.f17758a.b();
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f b(int r1) {
        return this.f17758a.b(r1);
    }

    @Override // kotlinx.serialization.descriptors.f
    public String c(int r1) {
        return this.f17758a.c(r1);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean c() {
        return this.f17758a.c();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean d() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean d(int r1) {
        return this.f17758a.d(r1);
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.j e() {
        return this.f17758a.e();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, bw.class) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f17758a, ((bw) ZeusTransformUtils.preCheckCast(r5, bw.class, "com.obric.memorydata.plugin")).f17758a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f() {
        return this.f17759b;
    }

    @Override // kotlinx.serialization.internal.n
    public Set<String> g() {
        return this.c;
    }

    public final kotlinx.serialization.descriptors.f h() {
        return this.f17758a;
    }

    public int hashCode() {
        return this.f17758a.hashCode() * 31;
    }

    public String toString() {
        return new StringBuilder().append(this.f17758a).append('?').toString();
    }
}
