package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* JADX INFO: loaded from: classes3.dex */
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        UnwrappedType r11 = r10.unwrap();
        if ((r11 instanceof AbbreviatedType) == true) goto L7;
        return null;
    L7:
        return (AbbreviatedType) r11;
    }

    public static final SimpleType getAbbreviation(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        AbbreviatedType r11 = getAbbreviatedType(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.getAbbreviation();
    }

    public static final boolean isDefinitelyNotNullType(KotlinType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.unwrap() instanceof DefinitelyNotNullType;
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor r10) {
        Collection<KotlinType> r11 = r10.mo1324getSupertypes();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
        boolean r14 = false;
    L3:
        KotlinType r15 = null;
        if (r13.hasNext() == false) goto L9;
        KotlinType r16 = (KotlinType) r13.next();
        if (TypeUtils.isNullableType(r16) == false) goto L8;
        r16 = makeDefinitelyNotNullOrNotNull$default(r16.unwrap(), false, 1, null);
        r14 = true;
    L8:
        r12.add(r16);
        goto L3
    L9:
        if (r14 == false) goto L22;
        KotlinType r17 = r10.getAlternativeType();
        if (r17 == null) goto L18;
        if (TypeUtils.isNullableType(r17) == false) goto L16;
        r17 = makeDefinitelyNotNullOrNotNull$default(r17.unwrap(), false, 1, null);
    L16:
        r15 = r17;
    L18:
        return new IntersectionTypeConstructor(r12).setAlternative(r15);
    L22:
        return null;
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DefinitelyNotNullType r12 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull(r10, r11);
        if (r12 != null) goto L10;
        SimpleType r13 = makeIntersectionTypeDefinitelyNotNullOrNotNull(r10);
        if (r13 == null) goto L9;
        return r13;
    L9:
        return r10.makeNullableAsSpecified(false);
    L10:
        return r12;
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        return makeDefinitelyNotNullOrNotNull(r10, r11);
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType r10) {
        TypeConstructor r11 = r10.getConstructor();
        if ((r11 instanceof IntersectionTypeConstructor) == false) goto L5;
        IntersectionTypeConstructor r12 = (IntersectionTypeConstructor) r11;
    L6:
        if (r12 != null) goto L8;
        return null;
    L8:
        IntersectionTypeConstructor r13 = makeDefinitelyNotNullOrNotNull(r12);
        if (r13 != null) goto L12;
        return null;
    L12:
        return r13.createType();
    L5:
        r12 = null;
        goto L6
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        DefinitelyNotNullType r12 = DefinitelyNotNullType.Companion.makeDefinitelyNotNull(r10, r11);
        if (r12 != null) goto L10;
        SimpleType r13 = makeIntersectionTypeDefinitelyNotNullOrNotNull(r10);
        if (r13 == null) goto L8;
        return r13;
    L8:
        return r10.makeNullableAsSpecified(false);
    L10:
        return r12;
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        return makeSimpleTypeDefinitelyNotNullOrNotNull(r10, r11);
    }

    public static final SimpleType withAbbreviation(SimpleType r10, SimpleType r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "abbreviatedType");
        if (KotlinTypeKt.isError(r10) == false) goto L6;
        return r10;
    L6:
        return new AbbreviatedType(r10, r11);
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new NewCapturedType(r10.getCaptureStatus(), r10.getConstructor(), r10.getLowerType(), r10.getAttributes(), r10.isMarkedNullable(), true);
    }
}
