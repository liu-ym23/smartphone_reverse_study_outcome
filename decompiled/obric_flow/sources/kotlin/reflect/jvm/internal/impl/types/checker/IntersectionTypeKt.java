package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension({"SMAP\nIntersectionType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/IntersectionTypeKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,183:1\n1549#2:184\n1620#2,3:185\n1549#2:188\n1620#2,3:189\n1549#2:192\n1620#2,3:193\n*S KotlinDebug\n*F\n+ 1 IntersectionType.kt\norg/jetbrains/kotlin/types/checker/IntersectionTypeKt\n*L\n26#1:184\n26#1:185,3\n38#1:188\n38#1:189,3\n58#1:192\n58#1:193,3\n*E\n"})
public final class IntersectionTypeKt {
    public static final UnwrappedType intersectTypes(List<? extends UnwrappedType> r10) {
        Intrinsics.checkNotNullParameter(r10, "types");
        int r5 = r10.size();
        if (r5 == 0) goto L43;
        if (r5 == 1) goto L41;
        ArrayList r11 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r12 = r10.iterator();
        boolean r13 = false;
        boolean r14 = false;
    L8:
        if (r12.hasNext() == false) goto L28;
        UnwrappedType r15 = (UnwrappedType) r12.next();
        if (r13 == false) goto L12;
    L15:
        r13 = true;
    L17:
        if ((r15 instanceof SimpleType) == false) goto L20;
        SimpleType r16 = (SimpleType) r15;
    L25:
        r11.add(r16);
        goto L8
    L20:
        if ((r15 instanceof FlexibleType) == false) goto L27;
        if (DynamicTypesKt.isDynamic(r15) == true) goto L23;
        r16 = ((FlexibleType) r15).getLowerBound();
        r14 = true;
        goto L25
    L23:
        return r15;
    L27:
        throw new NoWhenBranchMatchedException();
    L12:
        if (KotlinTypeKt.isError(r15) == true) goto L15;
        r13 = false;
        goto L17
    L28:
        if (r13 == true) goto L30;
        if (r14 == false) goto L33;
        ArrayList r17 = new ArrayList(CollectionsKt.h(r10));
        Iterator<T> r18 = r10.iterator();
    L36:
        if (r18.hasNext() == false) goto L38;
        r17.add(FlexibleTypesKt.upperIfFlexible((UnwrappedType) r18.next()));
        goto L36
    L38:
        TypeIntersector r19 = TypeIntersector.INSTANCE;
        return KotlinTypeFactory.flexibleType(r19.intersectTypes$descriptors(r11), r19.intersectTypes$descriptors(r17));
    L33:
        return TypeIntersector.INSTANCE.intersectTypes$descriptors(r11);
    L30:
        return ErrorUtils.createErrorType(ErrorTypeKind.INTERSECTION_OF_ERROR_TYPES, new String[]{r10.toString()});
    L41:
        return (UnwrappedType) CollectionsKt.single(r10);
    L43:
        throw new IllegalStateException("Expected some types");
    }
}
