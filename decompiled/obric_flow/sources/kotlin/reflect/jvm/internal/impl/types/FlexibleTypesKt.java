package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nflexibleTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,185:1\n288#2:186\n1726#2,3:187\n289#2:190\n1549#2:191\n1620#2,3:192\n1549#2:195\n1620#2,3:196\n*S KotlinDebug\n*F\n+ 1 flexibleTypes.kt\norg/jetbrains/kotlin/types/FlexibleTypesKt\n*L\n50#1:186\n51#1:187,3\n50#1:190\n62#1:191\n62#1:192,3\n65#1:195\n65#1:196,3\n*E\n"})
public final class FlexibleTypesKt {
    public static final FlexibleType asFlexibleType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UnwrappedType r10 = r5.unwrap();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (FlexibleType) r10;
    }

    public static final boolean isFlexible(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.unwrap() instanceof FlexibleType;
    }

    public static final SimpleType lowerIfFlexible(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UnwrappedType r10 = r5.unwrap();
        if ((r10 instanceof FlexibleType) == false) goto L6;
        return ((FlexibleType) r10).getLowerBound();
    L6:
        if ((r10 instanceof SimpleType) == false) goto L10;
        return (SimpleType) r10;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final SimpleType upperIfFlexible(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UnwrappedType r10 = r5.unwrap();
        if ((r10 instanceof FlexibleType) == false) goto L6;
        return ((FlexibleType) r10).getUpperBound();
    L6:
        if ((r10 instanceof SimpleType) == false) goto L10;
        return (SimpleType) r10;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
