package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class SimpleTypeWithAttributes extends DelegatingSimpleTypeImpl {
    private final TypeAttributes attributes;

    public SimpleTypeWithAttributes(SimpleType r10, TypeAttributes r11) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        super(r10);
        this.attributes = r11;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public /* bridge */ /* synthetic */ DelegatingSimpleType replaceDelegate(SimpleType r10) {
        return replaceDelegate(r10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public SimpleTypeWithAttributes replaceDelegate(SimpleType r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        return new SimpleTypeWithAttributes(r10, getAttributes());
    }
}
