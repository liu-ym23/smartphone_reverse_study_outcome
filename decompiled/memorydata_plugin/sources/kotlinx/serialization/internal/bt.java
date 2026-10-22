package kotlinx.serialization.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", ActivityLifecycle.NAME, "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class bt implements kotlinx.serialization.descriptors.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f17753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.e f17754b;

    public bt(String r2, kotlinx.serialization.descriptors.e r3) {
        Intrinsics.checkNotNullParameter(r2, "serialName");
        Intrinsics.checkNotNullParameter(r3, MemoryInfoSectionEditActivity.EXTRA_KIND);
        this.f17753a = r2;
        this.f17754b = r3;
    }

    private final Void h() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // kotlinx.serialization.descriptors.f
    public int a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        h();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a() {
        return kotlinx.serialization.descriptors.f.a.c(this);
    }

    @Override // kotlinx.serialization.descriptors.f
    public List<Annotation> a(int r1) {
        h();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.f
    public int b() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f b(int r1) {
        h();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.f
    public String c(int r1) {
        h();
        throw new KotlinNothingValueException();
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
        h();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.descriptors.f
    public /* synthetic */ kotlinx.serialization.descriptors.j e() {
        return (kotlinx.serialization.descriptors.j) ZeusTransformUtils.preCheckCast(g(), kotlinx.serialization.descriptors.j.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.descriptors.f
    public String f() {
        return this.f17753a;
    }

    public kotlinx.serialization.descriptors.e g() {
        return this.f17754b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + f() + ')';
    }
}
