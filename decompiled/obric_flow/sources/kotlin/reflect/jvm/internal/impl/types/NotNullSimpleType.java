package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class NotNullSimpleType extends DelegatingSimpleTypeImpl {
    public NotNullSimpleType(SimpleType r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        super(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r5) {
        return replaceDelegate(r5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public NotNullSimpleType replaceDelegate(SimpleType r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        return new NotNullSimpleType(r5);
    }
}
