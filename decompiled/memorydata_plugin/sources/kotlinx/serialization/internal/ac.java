package kotlinx.serialization.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lkotlinx/serialization/internal/EnumDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", ActivityLifecycle.NAME, "", "elementsCount", "", "(Ljava/lang/String;I)V", "elementDescriptors", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getElementDescriptors", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementDescriptors$delegate", "Lkotlin/Lazy;", MemoryInfoSectionEditActivity.EXTRA_KIND, "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "equals", "", "other", "", "getElementDescriptor", "index", "hashCode", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ac extends bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.j f17705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f17706b;

    public ac(final String r8, final int r9) {
        Intrinsics.checkNotNullParameter(r8, ActivityLifecycle.NAME);
        super(r8, null, r9, 2, null);
        this.f17705a = (kotlinx.serialization.descriptors.j) ZeusTransformUtils.preCheckCast(kotlinx.serialization.descriptors.j.b.f17690a, kotlinx.serialization.descriptors.j.class, "com.obric.memorydata.plugin");
        this.f17706b = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new EnumDescriptor$elementDescriptors$2(r9, r8, this), Function0.class, "com.obric.memorydata.plugin"));
    }

    private final kotlinx.serialization.descriptors.f[] i() {
        return (kotlinx.serialization.descriptors.f[]) ZeusTransformUtils.preCheckCast(this.f17706b.getValue(), kotlinx.serialization.descriptors.f[].class, "com.obric.memorydata.plugin");
    }

    @Override // kotlinx.serialization.internal.bn, kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.f b(int r1) {
        return i()[r1];
    }

    @Override // kotlinx.serialization.internal.bn, kotlinx.serialization.descriptors.f
    public kotlinx.serialization.descriptors.j e() {
        return this.f17705a;
    }

    @Override // kotlinx.serialization.internal.bn
    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r6, kotlinx.serialization.descriptors.f.class) == true) goto L12;
        return false;
    L12:
        if (((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r6, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).e() == kotlinx.serialization.descriptors.j.b.f17690a) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(f(), ((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r6, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).f()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(bm.a((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")), bm.a((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(r6, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin"))) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // kotlinx.serialization.internal.bn
    public int hashCode() {
        int r0 = f().hashCode();
        Iterator<String> r5 = kotlinx.serialization.descriptors.h.b((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 1;
    L4:
        if (r5.hasNext() == false) goto L11;
        int r2 = r1 * 31;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L9:
        r1 = r2 + r4;
        goto L4
    L8:
        r4 = 0;
        goto L9
    L11:
        return (r0 * 31) + r1;
    }

    @Override // kotlinx.serialization.internal.bn
    public String toString() {
        return CollectionsKt.joinToString$default(kotlinx.serialization.descriptors.h.b((kotlinx.serialization.descriptors.f) ZeusTransformUtils.preCheckCast(this, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(f() + '(', CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null);
    }
}
