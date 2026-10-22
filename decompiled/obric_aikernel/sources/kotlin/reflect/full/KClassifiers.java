package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KClassifierImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KClassifiers")
public final class KClassifiers {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[KVariance.values().length];
            r10[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r10[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r10[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r10;
        }
    }

    private static final SimpleType createKotlinType(TypeAttributes r10, TypeConstructor r11, List<KTypeProjection> r12, boolean r13) {
        List<TypeParameterDescriptor> r14 = r11.getParameters();
        Intrinsics.checkNotNullExpressionValue(r14, "typeConstructor.parameters");
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r16 = r12.iterator();
        int r17 = 0;
    L4:
        if (r16.hasNext() == false) goto L31;
        Object r18 = r16.next();
        int r19 = r17 + 1;
        if (r17 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        KTypeProjection r20 = (KTypeProjection) r18;
        KTypeImpl r21 = (KTypeImpl) r20.getType();
        if (r21 == null) goto L11;
        KotlinType r22 = r21.getType();
    L12:
        KVariance r23 = r20.getVariance();
        if (r23 != null) goto L15;
        int r24 = -1;
    L16:
        if (r24 != (-1)) goto L18;
        TypeParameterDescriptor r25 = r14.get(r17);
        Intrinsics.checkNotNullExpressionValue(r25, "parameters[index]");
        TypeProjectionBase r26 = new StarProjectionImpl(r25);
    L29:
        r15.add(r26);
        r17 = r19;
        goto L4
    L18:
        if (r24 != 1) goto L20;
        Variance r27 = Variance.INVARIANT;
        Intrinsics.checkNotNull(r22);
        r26 = new TypeProjectionImpl(r27, r22);
        goto L29
    L20:
        if (r24 != 2) goto L22;
        Variance r28 = Variance.IN_VARIANCE;
        Intrinsics.checkNotNull(r22);
        r26 = new TypeProjectionImpl(r28, r22);
        goto L29
    L22:
        if (r24 != 3) goto L25;
        Variance r29 = Variance.OUT_VARIANCE;
        Intrinsics.checkNotNull(r22);
        r26 = new TypeProjectionImpl(r29, r22);
        goto L29
    L25:
        throw new NoWhenBranchMatchedException();
    L15:
        r24 = WhenMappings.$EnumSwitchMapping$0[r23.ordinal()];
        goto L16
    L11:
        r22 = null;
        goto L12
    L31:
        return KotlinTypeFactory.simpleType$default(r10, r11, r15, r13, null, 16, null);
    }

    @SinceKotlin(version = "1.1")
    public static final KType createType(KClassifier r10, List<KTypeProjection> r11, boolean r12, List<? extends Annotation> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "arguments");
        Intrinsics.checkNotNullParameter(r13, "annotations");
        if ((r10 instanceof KClassifierImpl) == false) goto L5;
        KClassifierImpl r14 = (KClassifierImpl) r10;
    L6:
        if (r14 == null) goto L16;
        ClassifierDescriptor r15 = r14.getDescriptor();
        if (r15 == null) goto L16;
        TypeConstructor r16 = r15.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(r16, "descriptor.typeConstructor");
        List<TypeParameterDescriptor> r17 = r16.getParameters();
        Intrinsics.checkNotNullExpressionValue(r17, "typeConstructor.parameters");
        if (r17.size() != r11.size()) goto L14;
        r13.isEmpty();
        return new KTypeImpl(createKotlinType(TypeAttributes.Companion.getEmpty(), r16, r11, r12), null, 2, null);
    L14:
        throw new IllegalArgumentException("Class declares " + r17.size() + " type parameters, but " + r11.size() + " were provided.");
    L16:
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + r10 + " (" + r10.getClass() + ')');
    L5:
        r14 = null;
        goto L6
    }

    public static /* synthetic */ KType createType$default(KClassifier r10, List r11, boolean r12, List r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = CollectionsKt.emptyList();
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = CollectionsKt.emptyList();
    L12:
        return createType(r10, r11, r12, r13);
    }

    public static final KType getStarProjectedType(KClassifier r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof KClassifierImpl) == false) goto L5;
        KClassifierImpl r11 = (KClassifierImpl) r10;
    L6:
        if (r11 == null) goto L21;
        ClassifierDescriptor r12 = r11.getDescriptor();
        if (r12 == null) goto L21;
        List<TypeParameterDescriptor> r13 = r12.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(r13, "descriptor.typeConstructor.parameters");
        if (r13.isEmpty() == true) goto L13;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r15 = r13.iterator();
    L16:
        if (r15.hasNext() == false) goto L19;
        TypeParameterDescriptor r16 = (TypeParameterDescriptor) r15.next();
        r14.add(KTypeProjection.Companion.getSTAR());
        goto L16
    L19:
        return createType$default(r10, r14, false, null, 6, null);
    L13:
        return createType$default(r10, null, false, null, 7, null);
    L21:
        return createType$default(r10, null, false, null, 7, null);
    L5:
        r11 = null;
        goto L6
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStarProjectedType$annotations(KClassifier r10) {
    }
}
