package kotlinx.serialization;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends kotlinx.serialization.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass f19245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f19246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f19247c;

    public e(KClass r5) {
        Intrinsics.checkNotNullParameter(r5, "baseClass");
        this.f19245a = r5;
        this.f19246b = CollectionsKt.emptyList();
        this.f19247c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new PolymorphicSerializer$descriptor$2(this));
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return (kotlinx.serialization.descriptors.g) this.f19247c.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.f19245a + ')';
    }
}
