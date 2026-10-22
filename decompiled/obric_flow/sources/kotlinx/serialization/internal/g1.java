package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass f19286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f19287c;

    public g1(KClass r5, kotlinx.serialization.c r10) {
        Intrinsics.checkNotNullParameter(r5, "kClass");
        Intrinsics.checkNotNullParameter(r10, "eSerializer");
        super(r10);
        this.f19286b = r5;
        kotlinx.serialization.descriptors.g r11 = r10.getDescriptor();
        Intrinsics.checkNotNullParameter(r11, "elementDesc");
        this.f19287c = new c(r11, 0);
    }

    @Override // kotlinx.serialization.internal.a
    public final Object b() {
        return new ArrayList();
    }

    @Override // kotlinx.serialization.internal.a
    public final int c(Object r5) {
        ArrayList r10 = (ArrayList) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.size();
    }

    @Override // kotlinx.serialization.internal.a
    public final Object f(Object r5) {
        Intrinsics.checkNotNullParameter(null, "<this>");
        return new ArrayList(ArraysKt.asList(null));
    }

    @Override // kotlinx.serialization.internal.a
    public final Object g(Object r5) {
        ArrayList r10 = (ArrayList) r5;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KClass r11 = this.f19286b;
        Intrinsics.checkNotNullParameter(r11, "eClass");
        Object r12 = Array.newInstance(JvmClassMappingKt.getJavaClass(r11), r10.size());
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        return r10.toArray((Object[]) r12);
    }

    @Override // kotlinx.serialization.b
    public final kotlinx.serialization.descriptors.g getDescriptor() {
        return this.f19287c;
    }

    @Override // kotlinx.serialization.internal.r
    public final void h(int r5, Object r10, Object r11) {
        ArrayList r12 = (ArrayList) r10;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        r12.add(r5, r11);
    }
}
