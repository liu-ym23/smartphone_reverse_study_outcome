package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class IntersectionTypeKt {
    public static final UnwrappedType intersectTypes(List<? extends UnwrappedType> r10) {
        Intrinsics.checkNotNullParameter(r10, "types");
        int r11 = r10.size();
        if (r11 == 0) goto L43;
        if (r11 == 1) goto L41;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r13 = r10.iterator();
        boolean r14 = false;
        boolean r15 = false;
    L8:
        if (r13.hasNext() == false) goto L28;
        UnwrappedType r16 = (UnwrappedType) r13.next();
        if (r14 == false) goto L12;
    L15:
        r14 = true;
    L17:
        if ((r16 instanceof SimpleType) == false) goto L20;
        SimpleType r17 = (SimpleType) r16;
    L25:
        r12.add(r17);
        goto L8
    L20:
        if ((r16 instanceof FlexibleType) == false) goto L27;
        if (DynamicTypesKt.isDynamic(r16) == true) goto L23;
        r17 = ((FlexibleType) r16).getLowerBound();
        r15 = true;
        goto L25
    L23:
        return r16;
    L27:
        throw new NoWhenBranchMatchedException();
    L12:
        if (KotlinTypeKt.isError(r16) == true) goto L15;
        r14 = false;
        goto L17
    L28:
        if (r14 == true) goto L30;
        if (r15 == false) goto L33;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r19 = r10.iterator();
    L36:
        if (r19.hasNext() == false) goto L38;
        r18.add(FlexibleTypesKt.upperIfFlexible((UnwrappedType) r19.next()));
        goto L36
    L38:
        TypeIntersector r20 = TypeIntersector.INSTANCE;
        return KotlinTypeFactory.flexibleType(r20.intersectTypes$descriptors(r12), r20.intersectTypes$descriptors(r18));
    L33:
        return TypeIntersector.INSTANCE.intersectTypes$descriptors(r12);
    L30:
        return ErrorUtils.createErrorType(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, new String[]{r10.toString()});
    L41:
        return (UnwrappedType) CollectionsKt.single(r10);
    L43:
        throw new IllegalStateException("Expected some types".toString());
    }
}
