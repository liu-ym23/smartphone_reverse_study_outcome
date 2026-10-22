package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ExpandedTypeUtilsKt {
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext r5, KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "inlineClassType");
        return computeExpandedTypeInner(r5, r10, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext r5, KotlinTypeMarker r10, HashSet<TypeConstructorMarker> r11) {
        TypeConstructorMarker r12 = r5.typeConstructor(r10);
        if (r11.add(r12) == true) goto L5;
        return null;
    L5:
        TypeParameterMarker r13 = r5.getTypeParameterClassifier(r12);
        if (r13 == null) goto L35;
        KotlinTypeMarker r14 = r5.getRepresentativeUpperBound(r13);
        KotlinTypeMarker r15 = computeExpandedTypeInner(r5, r14, r11);
        if (r15 == null) goto L56;
        if (r5.isInlineClass(r5.typeConstructor(r14)) == false) goto L12;
    L17:
        boolean r16 = true;
    L19:
        if ((r15 instanceof SimpleTypeMarker) == false) goto L28;
        if (r5.isPrimitiveType((SimpleTypeMarker) r15) == false) goto L28;
        if (r5.isNullableType(r10) == false) goto L28;
        if (r16 == false) goto L28;
        KotlinTypeMarker r17 = r5.makeNullable(r14);
    L55:
        return r17;
    L28:
        if (r5.isNullableType(r15) == true) goto L58;
        if (r5.isMarkedNullable(r10) == false) goto L58;
        r17 = r5.makeNullable(r15);
    L58:
        return r15;
    L12:
        if ((r14 instanceof SimpleTypeMarker) == true) goto L14;
    L16:
        r16 = false;
        goto L19
    L14:
        if (r5.isPrimitiveType((SimpleTypeMarker) r14) == false) goto L16;
    L56:
        return null;
    L35:
        if (r5.isInlineClass(r12) == false) goto L57;
        KotlinTypeMarker r18 = r5.getUnsubstitutedUnderlyingType(r10);
        if (r18 != null) goto L39;
        return null;
    L39:
        r15 = computeExpandedTypeInner(r5, r18, r11);
        if (r15 != null) goto L43;
        return null;
    L43:
        if (r5.isNullableType(r10) == false) goto L58;
        if (r5.isNullableType(r15) == false) goto L49;
        return r10;
    L49:
        if ((r15 instanceof SimpleTypeMarker) == false) goto L54;
        if (r5.isPrimitiveType((SimpleTypeMarker) r15) == false) goto L54;
        return r10;
    L54:
        return r5.makeNullable(r15);
    L57:
        return r10;
    }
}
