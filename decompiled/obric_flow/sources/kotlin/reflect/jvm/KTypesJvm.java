package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {1, 8, 0}, xi = 48)
@JvmName(name = "KTypesJvm")
@SourceDebugExtension({"SMAP\nKTypesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KTypesJvm.kt\nkotlin/reflect/jvm/KTypesJvm\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n288#2,2:53\n*S KotlinDebug\n*F\n+ 1 KTypesJvm.kt\nkotlin/reflect/jvm/KTypesJvm\n*L\n44#1:53,2\n*E\n"})
public final class KTypesJvm {
    public static final KClass<?> getJvmErasure(KType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        KClassifier r10 = r5.getClassifier();
        if (r10 == null) goto L8;
        KClass<?> r11 = getJvmErasure(r10);
        if (r11 == null) goto L8;
        return r11;
    L8:
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + r5);
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getJvmErasure$annotations(KType r5) {
    }

    public static final KClass<?> getJvmErasure(KClassifier r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KClass) == false) goto L6;
        return (KClass) r5;
    L6:
        if ((r5 instanceof KTypeParameter) == false) goto L28;
        List<KType> r10 = ((KTypeParameter) r5).getUpperBounds();
        Iterator<T> r11 = r10.iterator();
    L8:
        Object r12 = null;
        ClassDescriptor r13 = null;
        if (r11.hasNext() == false) goto L19;
        Object r14 = r11.next();
        KType r15 = (KType) r14;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        ClassifierDescriptor r16 = ((KTypeImpl) r15).getType().getConstructor().mo1402getDeclarationDescriptor();
        if ((r16 instanceof ClassDescriptor) == false) goto L13;
        r13 = (ClassDescriptor) r16;
    L13:
        if (r13 == null) goto L8;
        if (r13.getKind() == ClassKind.INTERFACE) goto L8;
        if (r13.getKind() == ClassKind.ANNOTATION_CLASS) goto L8;
        r12 = r14;
    L19:
        KType r17 = (KType) r12;
        if (r17 != null) goto L22;
        r17 = (KType) CollectionsKt.firstOrNull(r10);
    L22:
        if (r17 == null) goto L26;
        KClass<?> r18 = getJvmErasure(r17);
        if (r18 == null) goto L26;
        return r18;
    L26:
        return Reflection.getOrCreateKotlinClass(Object.class);
    L28:
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + r5);
    }
}
