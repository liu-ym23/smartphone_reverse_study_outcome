package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class NullableSimpleType extends DelegatingSimpleTypeImpl {
    public NullableSimpleType(SimpleType r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        super(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r10) {
        return replaceDelegate(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NullableSimpleType replaceDelegate(SimpleType r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        return new NullableSimpleType(r10);
    }
}
