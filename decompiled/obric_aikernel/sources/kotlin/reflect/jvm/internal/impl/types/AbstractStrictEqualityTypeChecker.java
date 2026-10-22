package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* JADX INFO: loaded from: classes3.dex */
public final class AbstractStrictEqualityTypeChecker {
    public static final AbstractStrictEqualityTypeChecker INSTANCE = null;

    static {
        INSTANCE = new AbstractStrictEqualityTypeChecker();
    }

    private AbstractStrictEqualityTypeChecker() {
    }

    private final boolean strictEqualSimpleTypes(TypeSystemContext r10, SimpleTypeMarker r11, SimpleTypeMarker r12) {
        if (r10.argumentsCount(r11) == r10.argumentsCount(r12)) goto L5;
    L36:
        return false;
    L5:
        if (r10.isMarkedNullable(r11) != r10.isMarkedNullable(r12)) goto L36;
        if (r10.asDefinitelyNotNullType(r11) != null) goto L9;
        boolean r13 = true;
    L11:
        if (r10.asDefinitelyNotNullType(r12) != null) goto L13;
        boolean r14 = true;
    L14:
        if (r13 != r14) goto L36;
        if (r10.areEqualTypeConstructors(r10.typeConstructor(r11), r10.typeConstructor(r12)) == false) goto L36;
        if (r10.identicalArguments(r11, r12) == false) goto L21;
        return true;
    L21:
        int r15 = r10.argumentsCount(r11);
        int r16 = 0;
    L22:
        if (r16 >= r15) goto L35;
        TypeArgumentMarker r17 = r10.getArgument(r11, r16);
        TypeArgumentMarker r18 = r10.getArgument(r12, r16);
        if (r10.isStarProjection(r17) != r10.isStarProjection(r18)) goto L25;
        if (r10.isStarProjection(r17) == true) goto L34;
        if (r10.getVariance(r17) != r10.getVariance(r18)) goto L30;
        if (strictEqualTypesInternal(r10, r10.getType(r17), r10.getType(r18)) == true) goto L34;
        return false;
    L30:
        return false;
    L34:
        r16 = r16 + 1;
        goto L22
    L25:
        return false;
    L35:
        return true;
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
        goto L11
    }

    private final boolean strictEqualTypesInternal(TypeSystemContext r10, KotlinTypeMarker r11, KotlinTypeMarker r12) {
        if (r11 != r12) goto L5;
        return true;
    L5:
        SimpleTypeMarker r13 = r10.asSimpleType(r11);
        SimpleTypeMarker r14 = r10.asSimpleType(r12);
        if (r13 == null) goto L10;
        if (r14 == null) goto L10;
        return strictEqualSimpleTypes(r10, r13, r14);
    L10:
        FlexibleTypeMarker r15 = r10.asFlexibleType(r11);
        FlexibleTypeMarker r16 = r10.asFlexibleType(r12);
        if (r15 == null) goto L20;
        if (r16 == null) goto L20;
        if (strictEqualSimpleTypes(r10, r10.lowerBound(r15), r10.lowerBound(r16)) == false) goto L19;
        if (strictEqualSimpleTypes(r10, r10.upperBound(r15), r10.upperBound(r16)) == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public final boolean strictEqualTypes(TypeSystemContext r10, KotlinTypeMarker r11, KotlinTypeMarker r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "a");
        Intrinsics.checkNotNullParameter(r12, "b");
        return strictEqualTypesInternal(r10, r11, r12);
    }
}
