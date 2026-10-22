package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
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
public final class TypeSignatureMappingKt {
    public static final <T> T boxTypeIfNeeded(JvmTypeFactory<T> r10, T r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "possiblyPrimitiveType");
        if (r12 == true) goto L5;
        return r11;
    L5:
        return r10.boxType(r11);
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext r10, KotlinTypeMarker r11, JvmTypeFactory<T> r12, TypeMappingMode r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        Intrinsics.checkNotNullParameter(r12, "typeFactory");
        Intrinsics.checkNotNullParameter(r13, "mode");
        TypeConstructorMarker r14 = r10.typeConstructor(r11);
        if (r10.isClassTypeConstructor(r14) == true) goto L5;
        return null;
    L5:
        PrimitiveType r15 = r10.getPrimitiveType(r14);
        boolean r16 = true;
        if (r15 == null) goto L15;
        T r17 = r12.createPrimitiveType(r15);
        if (r10.isNullableType(r11) == true) goto L14;
        if (TypeEnhancementUtilsKt.hasEnhancedNullability(r10, r11) == true) goto L14;
        r16 = false;
    L14:
        return (T) boxTypeIfNeeded(r12, r17, r16);
    L15:
        PrimitiveType r18 = r10.getPrimitiveArrayType(r14);
        if (r18 == null) goto L20;
        return r12.createFromString('[' + JvmPrimitiveType.get(r18).getDesc());
    L20:
        if (r10.isUnderKotlinPackage(r14) == false) goto L42;
        FqNameUnsafe r19 = r10.getClassFqNameUnsafe(r14);
        if (r19 == null) goto L24;
        ClassId r20 = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(r19);
    L25:
        if (r20 == null) goto L42;
        if (r13.getKotlinCollectionsToJavaCollections() == true) goto L40;
        List<JavaToKotlinClassMap.PlatformMutabilityMapping> r21 = JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
        if ((r21 instanceof Collection) == true) goto L31;
    L33:
        Iterator<T> r22 = r21.iterator();
    L35:
        if (r22.hasNext() == false) goto L32;
        if (Intrinsics.areEqual(((JavaToKotlinClassMap.PlatformMutabilityMapping) r22.next()).getJavaClass(), r20) == false) goto L35;
    L38:
        if (r16 == false) goto L40;
        return null;
    L32:
        r16 = false;
        goto L38
    L31:
        if (r21.isEmpty() == false) goto L33;
    L40:
        String r23 = JvmClassName.byClassId(r20).getInternalName();
        Intrinsics.checkNotNullExpressionValue(r23, "byClassId(classId).internalName");
        return r12.createObjectType(r23);
    L24:
        r20 = null;
    L42:
        return null;
    }
}
