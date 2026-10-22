package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "getJvmErasure", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KTypesJvm {
    public static /* synthetic */ void getJvmErasure$annotations(KType r0) {
    }

    public static final KClass<?> getJvmErasure(KClassifier r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KClass) == false) goto L6;
        return (KClass) r5;
    L6:
        if ((r5 instanceof KTypeParameter) == false) goto L31;
        List r6 = ((KTypeParameter) r5).getUpperBounds();
        Iterator r0 = r6.iterator();
    L8:
        Object r2 = null;
        ClassDescriptor r3 = null;
        if (r0.hasNext() == false) goto L22;
        Object r1 = r0.next();
        KTypeImpl r4 = (KType) r1;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        ClassDescriptor r7 = r4.getType().getConstructor().getDeclarationDescriptor();
        if ((r7 instanceof ClassDescriptor) == false) goto L13;
        r3 = r7;
    L13:
        if (r3 != null) goto L15;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == false) goto L8;
        r2 = r1;
        goto L22
    L15:
        if (r3.getKind() == ClassKind.INTERFACE) goto L19;
        if (r3.getKind() == ClassKind.ANNOTATION_CLASS) goto L19;
        r8 = true;
    L22:
        KType r9 = (KType) r2;
        if (r9 != null) goto L25;
        r9 = (KType) CollectionsKt.firstOrNull(r6);
    L25:
        if (r9 == null) goto L29;
        KClass<?> r10 = getJvmErasure(r9);
        if (r10 == null) goto L29;
        return r10;
    L29:
        return Reflection.getOrCreateKotlinClass(Object.class);
    L31:
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + r5);
    }

    public static final KClass<?> getJvmErasure(KType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        KClassifier r0 = r3.getClassifier();
        if (r0 == null) goto L8;
        KClass<?> r1 = getJvmErasure(r0);
        if (r1 == null) goto L8;
        return r1;
    L8:
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + r3);
    }
}
