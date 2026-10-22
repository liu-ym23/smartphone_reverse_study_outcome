package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;

/* JADX INFO: loaded from: classes3.dex */
@JvmName(name = "KTypesJvm")
public final class KTypesJvm {
    public static final KClass<?> getJvmErasure(KClassifier r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof KClass) == false) goto L6;
        return (KClass) r10;
    L6:
        if ((r10 instanceof KTypeParameter) == false) goto L31;
        List<KType> r11 = ((KTypeParameter) r10).getUpperBounds();
        Iterator<T> r12 = r11.iterator();
    L8:
        Object r13 = null;
        ClassDescriptor r14 = null;
        if (r12.hasNext() == false) goto L22;
        Object r15 = r12.next();
        KType r16 = (KType) r15;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        ClassifierDescriptor r17 = ((KTypeImpl) r16).getType().getConstructor().mo1323getDeclarationDescriptor();
        if ((r17 instanceof ClassDescriptor) == false) goto L13;
        r14 = (ClassDescriptor) r17;
    L13:
        if (r14 != null) goto L15;
    L19:
        boolean r18 = false;
    L20:
        if (r18 == false) goto L8;
        r13 = r15;
        goto L22
    L15:
        if (r14.getKind() == ClassKind.INTERFACE) goto L19;
        if (r14.getKind() == ClassKind.ANNOTATION_CLASS) goto L19;
        r18 = true;
    L22:
        KType r19 = (KType) r13;
        if (r19 != null) goto L25;
        r19 = (KType) CollectionsKt.firstOrNull(r11);
    L25:
        if (r19 == null) goto L29;
        KClass<?> r20 = getJvmErasure(r19);
        if (r20 == null) goto L29;
        return r20;
    L29:
        return Reflection.getOrCreateKotlinClass(Object.class);
    L31:
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + r10);
    }

    public static final KClass<?> getJvmErasure(KType r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        KClassifier r11 = r10.getClassifier();
        if (r11 == null) goto L8;
        KClass<?> r12 = getJvmErasure(r11);
        if (r12 == null) goto L8;
        return r12;
    L8:
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + r10);
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getJvmErasure$annotations(KType r10) {
    }
}
