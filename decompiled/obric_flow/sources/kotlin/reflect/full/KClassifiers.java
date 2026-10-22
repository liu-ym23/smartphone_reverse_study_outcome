package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\u001a.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a6\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"starProjectedType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "getStarProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "createKotlinType", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "attributes", "Lkotlin/reflect/jvm/internal/impl/types/TypeAttributes;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "createType", "annotations", "", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@JvmName(name = "KClassifiers")
@SourceDebugExtension({"SMAP\nKClassifiers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KClassifiers.kt\nkotlin/reflect/full/KClassifiers\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n1559#2:98\n1590#2,4:99\n1549#2:103\n1620#2,3:104\n*S KotlinDebug\n*F\n+ 1 KClassifiers.kt\nkotlin/reflect/full/KClassifiers\n*L\n69#1:98\n69#1:99,4\n95#1:103\n95#1:104,3\n*E\n"})
public final class KClassifiers {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[KVariance.values().length];
            r5[KVariance.INVARIANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r5[KVariance.IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r5[KVariance.OUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r5;
        }
    }

    private static final SimpleType createKotlinType(TypeAttributes r10, TypeConstructor r11, List<KTypeProjection> r12, boolean r13) {
        List<TypeParameterDescriptor> r5 = r11.getParameters();
        ArrayList r14 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r15 = r12.iterator();
        int r16 = 0;
    L4:
        if (r15.hasNext() == false) goto L31;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        KTypeProjection r19 = (KTypeProjection) r17;
        KTypeImpl r20 = (KTypeImpl) r19.getType();
        if (r20 == null) goto L11;
        KotlinType r21 = r20.getType();
    L12:
        KVariance r22 = r19.getVariance();
        if (r22 != null) goto L15;
        int r23 = -1;
    L16:
        if (r23 != (-1)) goto L18;
        TypeProjectionBase r24 = new StarProjectionImpl(r5.get(r16));
    L29:
        r14.add(r24);
        r16 = r18;
        goto L4
    L18:
        if (r23 != 1) goto L20;
        Variance r25 = Variance.INVARIANT;
        Intrinsics.checkNotNull(r21);
        r24 = new TypeProjectionImpl(r25, r21);
        goto L29
    L20:
        if (r23 != 2) goto L22;
        Variance r26 = Variance.IN_VARIANCE;
        Intrinsics.checkNotNull(r21);
        r24 = new TypeProjectionImpl(r26, r21);
        goto L29
    L22:
        if (r23 != 3) goto L25;
        Variance r27 = Variance.OUT_VARIANCE;
        Intrinsics.checkNotNull(r21);
        r24 = new TypeProjectionImpl(r27, r21);
        goto L29
    L25:
        throw new NoWhenBranchMatchedException();
    L15:
        r23 = WhenMappings.$EnumSwitchMapping$0[r22.ordinal()];
        goto L16
    L11:
        r21 = null;
        goto L12
    L31:
        return KotlinTypeFactory.simpleType$default(r10, r11, r14, r13, null, 16, null);
    }

    @SinceKotlin(version = "1.1")
    public static final KType createType(KClassifier r5, List<KTypeProjection> r10, boolean r11, List<? extends Annotation> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "arguments");
        Intrinsics.checkNotNullParameter(r12, "annotations");
        if ((r5 instanceof KClassifierImpl) == false) goto L5;
        KClassifierImpl r13 = (KClassifierImpl) r5;
    L6:
        if (r13 == null) goto L20;
        ClassifierDescriptor r14 = r13.getDescriptor();
        if (r14 == null) goto L20;
        TypeConstructor r15 = r14.getTypeConstructor();
        List<TypeParameterDescriptor> r16 = r15.getParameters();
        if (r16.size() != r10.size()) goto L18;
        if (r12.isEmpty() == false) goto L14;
        TypeAttributes r17 = TypeAttributes.Companion.getEmpty();
    L16:
        return new KTypeImpl(createKotlinType(r17, r15, r10, r11), null, 2, null);
    L14:
        r17 = TypeAttributes.Companion.getEmpty();
        goto L16
    L18:
        throw new IllegalArgumentException("Class declares " + r16.size() + " type parameters, but " + r10.size() + " were provided.");
    L20:
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + r5 + " (" + r5.getClass() + ')');
    L5:
        r13 = null;
        goto L6
    }

    public static /* synthetic */ KType createType$default(KClassifier r5, List r10, boolean r11, List r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = CollectionsKt.emptyList();
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = false;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = CollectionsKt.emptyList();
    L12:
        return createType(r5, r10, r11, r12);
    }

    public static final KType getStarProjectedType(KClassifier r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof KClassifierImpl) == false) goto L5;
        KClassifierImpl r5 = (KClassifierImpl) r10;
    L6:
        if (r5 == null) goto L21;
        ClassifierDescriptor r11 = r5.getDescriptor();
        if (r11 == null) goto L21;
        List<TypeParameterDescriptor> r12 = r11.getTypeConstructor().getParameters();
        if (r12.isEmpty() == true) goto L13;
        ArrayList r13 = new ArrayList(CollectionsKt.h(r12));
        Iterator<T> r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L19;
        TypeParameterDescriptor r15 = (TypeParameterDescriptor) r14.next();
        r13.add(KTypeProjection.Companion.getSTAR());
        goto L16
    L19:
        return createType$default(r10, r13, false, null, 6, null);
    L13:
        return createType$default(r10, null, false, null, 7, null);
    L21:
        return createType$default(r10, null, false, null, 7, null);
    L5:
        r5 = null;
        goto L6
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getStarProjectedType$annotations(KClassifier r5) {
    }
}
