package kotlinx.serialization.descriptors;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001f\u001a\u00020\fH\u0097\u0001J\u0011\u0010 \u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\fH\u0097\u0001J\u0011\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0018H\u0097\u0001J\u0011\u0010#\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\fH\u0097\u0001J\b\u0010$\u001a\u00020\fH\u0016J\u0011\u0010%\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\fH\u0097\u0001J\b\u0010&\u001a\u00020\u0018H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00108VX\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "kClass", "Lkotlin/reflect/KClass;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "elementsCount", "", "getElementsCount", "()I", "isInline", "", "()Z", "isNullable", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "equals", "other", "", "getElementAnnotations", "index", "getElementDescriptor", "getElementIndex", ActivityLifecycle.NAME, "getElementName", "hashCode", "isElementOptional", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<?> f17668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f17669b;
    private final String c;

    public c(f r3, KClass<?> r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        KClass<?> r6 = (KClass) ZeusTransformUtils.wrapperContextForParams(r4, KClass.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "original");
        Intrinsics.checkNotNullParameter(r6, "kClass");
        this.f17669b = r5;
        this.f17668a = r6;
        this.c = r5.f() + Typography.less + r6.getSimpleName() + Typography.greater;
    }

    @Override // kotlinx.serialization.descriptors.f
    public int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        return this.f17669b.a(r2);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a() {
        return this.f17669b.a();
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a(int r1) {
        return this.f17669b.a(r1);
    }

    @Override // kotlinx.serialization.descriptors.f
    public int b() {
        return this.f17669b.b();
    }

    @Override // kotlinx.serialization.descriptors.f
    public f b(int r1) {
        return this.f17669b.b(r1);
    }

    @Override // kotlinx.serialization.descriptors.f
    public String c(int r1) {
        return this.f17669b.c(r1);
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean c() {
        return this.f17669b.c();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean d() {
        return this.f17669b.d();
    }

    @Override // kotlinx.serialization.descriptors.f
    public boolean d(int r1) {
        return this.f17669b.d(r1);
    }

    @Override // kotlinx.serialization.descriptors.f
    public j e() {
        return this.f17669b.e();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, c.class) == false) goto L5;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin");
    L7:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f17669b, r5.f17669b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r5.f17668a, this.f17668a) == false) goto L16;
        return true;
    L16:
        return false;
    L5:
        r5 = null;
        goto L7
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f() {
        return this.c;
    }

    public int hashCode() {
        return (this.f17668a.hashCode() * 31) + f().hashCode();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.f17668a + ", original: " + this.f17669b + ')';
    }
}
