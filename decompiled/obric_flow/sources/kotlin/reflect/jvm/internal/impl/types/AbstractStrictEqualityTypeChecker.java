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
        boolean r5 = true;
    L11:
        if (r10.asDefinitelyNotNullType(r12) != null) goto L13;
        boolean r13 = true;
    L14:
        if (r5 != r13) goto L36;
        if (r10.areEqualTypeConstructors(r10.typeConstructor(r11), r10.typeConstructor(r12)) == false) goto L36;
        if (r10.identicalArguments(r11, r12) == false) goto L21;
        return true;
    L21:
        int r14 = r10.argumentsCount(r11);
        int r15 = 0;
    L22:
        if (r15 >= r14) goto L35;
        TypeArgumentMarker r16 = r10.getArgument(r11, r15);
        TypeArgumentMarker r17 = r10.getArgument(r12, r15);
        if (r10.isStarProjection(r16) != r10.isStarProjection(r17)) goto L25;
        if (r10.isStarProjection(r16) == true) goto L34;
        if (r10.getVariance(r16) != r10.getVariance(r17)) goto L30;
        if (strictEqualTypesInternal(r10, r10.getType(r16), r10.getType(r17)) == true) goto L34;
        return false;
    L30:
        return false;
    L34:
        r15 = r15 + 1;
        goto L22
    L25:
        return false;
    L35:
        return true;
    L13:
        r13 = false;
        goto L14
    L9:
        r5 = false;
        goto L11
    }

    private final boolean strictEqualTypesInternal(TypeSystemContext r5, KotlinTypeMarker r10, KotlinTypeMarker r11) {
        if (r10 != r11) goto L5;
        return true;
    L5:
        SimpleTypeMarker r12 = r5.asSimpleType(r10);
        SimpleTypeMarker r13 = r5.asSimpleType(r11);
        if (r12 == null) goto L10;
        if (r13 == null) goto L10;
        return strictEqualSimpleTypes(r5, r12, r13);
    L10:
        FlexibleTypeMarker r14 = r5.asFlexibleType(r10);
        FlexibleTypeMarker r15 = r5.asFlexibleType(r11);
        if (r14 == null) goto L20;
        if (r15 == null) goto L20;
        if (strictEqualSimpleTypes(r5, r5.lowerBound(r14), r5.lowerBound(r15)) == false) goto L19;
        if (strictEqualSimpleTypes(r5, r5.upperBound(r14), r5.upperBound(r15)) == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public final boolean strictEqualTypes(TypeSystemContext r5, KotlinTypeMarker r10, KotlinTypeMarker r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "a");
        Intrinsics.checkNotNullParameter(r11, "b");
        return strictEqualTypesInternal(r5, r10, r11);
    }
}
