package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ntypeSignatureMapping.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/TypeSignatureMappingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,103:1\n1#2:104\n1747#3,3:105\n*S KotlinDebug\n*F\n+ 1 typeSignatureMapping.kt\norg/jetbrains/kotlin/load/kotlin/TypeSignatureMappingKt\n*L\n55#1:105,3\n*E\n"})
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> r5, T r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "possiblyPrimitiveType");
        if (r11 == true) goto L5;
        return r10;
    L5:
        return r5.boxType(r10);
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext r5, KotlinTypeMarker r10, JvmTypeFactory<T> r11, TypeMappingMode r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "typeFactory");
        Intrinsics.checkNotNullParameter(r12, "mode");
        TypeConstructorMarker r13 = r5.typeConstructor(r10);
        if (r5.isClassTypeConstructor(r13) == true) goto L5;
        return null;
    L5:
        PrimitiveType r14 = r5.getPrimitiveType(r13);
        if (r14 == null) goto L16;
        T r15 = r11.createPrimitiveType(r14);
        if (r5.isNullableType(r10) == false) goto L10;
    L13:
        boolean r16 = true;
    L15:
        return (T) boxTypeIfNeeded(r11, r15, r16);
    L10:
        if (TypeEnhancementUtilsKt.hasEnhancedNullability(r5, r10) == true) goto L13;
        r16 = false;
        goto L15
    L16:
        PrimitiveType r17 = r5.getPrimitiveArrayType(r13);
        if (r17 == null) goto L21;
        return r11.createFromString("[" + JvmPrimitiveType.get(r17).getDesc());
    L21:
        if (r5.isUnderKotlinPackage(r13) == false) goto L42;
        FqNameUnsafe r18 = r5.getClassFqNameUnsafe(r13);
        if (r18 == null) goto L25;
        ClassId r19 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r18);
    L26:
        if (r19 == null) goto L42;
        if (r12.getKotlinCollectionsToJavaCollections() == true) goto L41;
        List<JavaToKotlinClassMap.PlatformMutabilityMapping> r20 = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
        if (r20 != null) goto L32;
    L34:
        Iterator<T> r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L41;
        if (Intrinsics.areEqual(((JavaToKotlinClassMap.PlatformMutabilityMapping) r21.next()).getJavaClass(), r19) == false) goto L36;
        return null;
    L32:
        if (r20.isEmpty() == false) goto L34;
    L41:
        return r11.createObjectType(JvmClassName.byClassId(r19).getInternalName());
    L25:
        r19 = null;
    L42:
        return null;
    }
}
