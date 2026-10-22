package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSpecialTypes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialTypes.kt\norg/jetbrains/kotlin/types/SpecialTypesKt\n+ 2 IntersectionTypeConstructor.kt\norg/jetbrains/kotlin/types/IntersectionTypeConstructorKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,216:1\n102#2,2:217\n104#2,5:222\n112#2,7:228\n1549#3:219\n1620#3,2:220\n1622#3:227\n*S KotlinDebug\n*F\n+ 1 SpecialTypes.kt\norg/jetbrains/kotlin/types/SpecialTypesKt\n*L\n214#1:217,2\n214#1:222,5\n214#1:228,7\n214#1:219\n214#1:220,2\n214#1:227\n*E\n"})
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        UnwrappedType r10 = r5.unwrap();
        if ((r10 instanceof AbbreviatedType) == true) goto L7;
        return null;
    L7:
        return (AbbreviatedType) r10;
    }

    public static final SimpleType getAbbreviation(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        AbbreviatedType r10 = getAbbreviatedType(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getAbbreviation();
    }

    public static final boolean isDefinitelyNotNullType(KotlinType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.unwrap() instanceof DefinitelyNotNullType;
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DefinitelyNotNullType r12 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, r10, r11, false, 4, null);
        if (r12 != null) goto L10;
        SimpleType r13 = makeIntersectionTypeDefinitelyNotNullOrNotNull(r10);
        if (r13 == null) goto L9;
        return r13;
    L9:
        return r10.makeNullableAsSpecified(false);
    L10:
        return r12;
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = false;
    L6:
        return makeDefinitelyNotNullOrNotNull(r5, r10);
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType r5) {
        TypeConstructor r10 = r5.getConstructor();
        if ((r10 instanceof IntersectionTypeConstructor) == false) goto L5;
        IntersectionTypeConstructor r11 = (IntersectionTypeConstructor) r10;
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        IntersectionTypeConstructor r12 = makeDefinitelyNotNullOrNotNull(r11);
        if (r12 != null) goto L12;
        return null;
    L12:
        return r12.createType();
    L5:
        r11 = null;
        goto L6
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DefinitelyNotNullType r12 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$default(DefinitelyNotNullType.Companion, r10, r11, false, 4, null);
        if (r12 != null) goto L10;
        SimpleType r13 = makeIntersectionTypeDefinitelyNotNullOrNotNull(r10);
        if (r13 == null) goto L8;
        return r13;
    L8:
        return r10.makeNullableAsSpecified(false);
    L10:
        return r12;
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType r5, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = false;
    L6:
        return makeSimpleTypeDefinitelyNotNullOrNotNull(r5, r10);
    }

    public static final SimpleType withAbbreviation(SimpleType r5, SimpleType r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "abbreviatedType");
        if (KotlinTypeKt.isError(r5) == false) goto L6;
        return r5;
    L6:
        return new AbbreviatedType(r5, r10);
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new NewCapturedType(r10.getCaptureStatus(), r10.getConstructor(), r10.getLowerType(), r10.getAttributes(), r10.isMarkedNullable(), true);
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor r10) {
        Collection<KotlinType> r5 = r10.mo1403getSupertypes();
        ArrayList r11 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r12 = r5.iterator();
        boolean r13 = false;
    L3:
        KotlinType r14 = null;
        if (r12.hasNext() == false) goto L9;
        KotlinType r15 = (KotlinType) r12.next();
        if (TypeUtils.isNullableType(r15) == false) goto L8;
        r15 = makeDefinitelyNotNullOrNotNull$default(r15.unwrap(), false, 1, null);
        r13 = true;
    L8:
        r11.add(r15);
        goto L3
    L9:
        if (r13 == false) goto L22;
        KotlinType r16 = r10.getAlternativeType();
        if (r16 == null) goto L18;
        if (TypeUtils.isNullableType(r16) == false) goto L16;
        r16 = makeDefinitelyNotNullOrNotNull$default(r16.unwrap(), false, 1, null);
    L16:
        r14 = r16;
    L18:
        return new IntersectionTypeConstructor(r11).setAlternative(r14);
    L22:
        return null;
    }
}
