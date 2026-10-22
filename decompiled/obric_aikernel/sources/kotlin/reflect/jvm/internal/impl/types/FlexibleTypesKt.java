package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FlexibleTypesKt {
    public static final FlexibleType asFlexibleType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (FlexibleType) r11;
    }

    public static final boolean isFlexible(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.unwrap() instanceof FlexibleType;
    }

    public static final SimpleType lowerIfFlexible(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof FlexibleType) == false) goto L6;
        return ((FlexibleType) r11).getLowerBound();
    L6:
        if ((r11 instanceof SimpleType) == false) goto L10;
        return (SimpleType) r11;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final SimpleType upperIfFlexible(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof FlexibleType) == false) goto L6;
        return ((FlexibleType) r11).getUpperBound();
    L6:
        if ((r11 instanceof SimpleType) == false) goto L10;
        return (SimpleType) r11;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
