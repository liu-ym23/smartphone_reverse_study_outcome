package kotlin.reflect.jvm.internal.impl.types;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ExpandedTypeUtilsKt {
    public static final KotlinTypeMarker computeExpandedTypeForInlineClass(TypeSystemCommonBackendContext r10, KotlinTypeMarker r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "inlineClassType");
        return computeExpandedTypeInner(r10, r11, new HashSet());
    }

    private static final KotlinTypeMarker computeExpandedTypeInner(TypeSystemCommonBackendContext r10, KotlinTypeMarker r11, HashSet<TypeConstructorMarker> r12) {
        TypeConstructorMarker r13 = r10.typeConstructor(r11);
        if (r12.add(r13) == true) goto L5;
        return null;
    L5:
        TypeParameterMarker r14 = r10.getTypeParameterClassifier(r13);
        if (r14 == null) goto L35;
        KotlinTypeMarker r15 = r10.getRepresentativeUpperBound(r14);
        KotlinTypeMarker r16 = computeExpandedTypeInner(r10, r15, r12);
        if (r16 == null) goto L56;
        if (r10.isInlineClass(r10.typeConstructor(r15)) == false) goto L12;
    L17:
        boolean r17 = true;
    L19:
        if ((r16 instanceof SimpleTypeMarker) == false) goto L27;
        if (r10.isPrimitiveType((SimpleTypeMarker) r16) == false) goto L27;
        if (r10.isNullableType(r11) == false) goto L27;
        if (r17 == false) goto L27;
        KotlinTypeMarker r18 = r10.makeNullable(r15);
    L55:
        return r18;
    L27:
        if (r10.isNullableType(r16) == true) goto L58;
        if (r10.isMarkedNullable(r11) == false) goto L58;
        r18 = r10.makeNullable(r16);
    L58:
        return r16;
    L12:
        if ((r15 instanceof SimpleTypeMarker) == true) goto L14;
    L16:
        r17 = false;
        goto L19
    L14:
        if (r10.isPrimitiveType((SimpleTypeMarker) r15) == false) goto L16;
    L56:
        return null;
    L35:
        if (r10.isInlineClass(r13) == false) goto L57;
        KotlinTypeMarker r19 = r10.getUnsubstitutedUnderlyingType(r11);
        if (r19 != null) goto L39;
        return null;
    L39:
        r16 = computeExpandedTypeInner(r10, r19, r12);
        if (r16 != null) goto L43;
        return null;
    L43:
        if (r10.isNullableType(r11) == false) goto L58;
        if (r10.isNullableType(r16) == false) goto L49;
        return r11;
    L49:
        if ((r16 instanceof SimpleTypeMarker) == false) goto L54;
        if (r10.isPrimitiveType((SimpleTypeMarker) r16) == false) goto L54;
        return r11;
    L54:
        return r10.makeNullable(r16);
    L57:
        return r11;
    }
}
