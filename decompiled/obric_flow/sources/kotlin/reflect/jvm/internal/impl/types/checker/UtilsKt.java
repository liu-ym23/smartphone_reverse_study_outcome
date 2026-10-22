package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/types/checker/UtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n1747#2,3:109\n*S KotlinDebug\n*F\n+ 1 utils.kt\norg/jetbrains/kotlin/types/checker/UtilsKt\n*L\n51#1:109,3\n*E\n"})
public final class UtilsKt {
    private static final KotlinType approximate(KotlinType r5) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(r5).getUpper();
    }

    private static final String debugInfo(TypeConstructor r5) {
        StringBuilder r10 = new StringBuilder();
        debugInfo$lambda$1$unaryPlus("type: " + r5, r10);
        debugInfo$lambda$1$unaryPlus("hashCode: " + r5.hashCode(), r10);
        debugInfo$lambda$1$unaryPlus("javaClass: " + r5.getClass().getCanonicalName(), r10);
        DeclarationDescriptor r11 = r5.mo1402getDeclarationDescriptor();
    L3:
        if (r11 == null) goto L6;
        debugInfo$lambda$1$unaryPlus("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(r11), r10);
        debugInfo$lambda$1$unaryPlus("javaClass: " + r11.getClass().getCanonicalName(), r10);
        r11 = r11.getContainingDeclaration();
        goto L3
    L6:
        return r10.toString();
    }

    private static final StringBuilder debugInfo$lambda$1$unaryPlus(String r5, StringBuilder r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r10.append(r5);
        r10.append('\n');
        return r10;
    }

    public static final KotlinType findCorrespondingSupertype(KotlinType r10, KotlinType r11, TypeCheckingProcedureCallbacks r12) {
        Intrinsics.checkNotNullParameter(r10, "subtype");
        Intrinsics.checkNotNullParameter(r11, "supertype");
        Intrinsics.checkNotNullParameter(r12, "typeCheckingProcedureCallbacks");
        ArrayDeque r5 = new ArrayDeque();
        r5.add(new SubtypePathNode(r10, null));
        TypeConstructor r13 = r11.getConstructor();
    L4:
        if (r5.isEmpty() == true) goto L38;
        SubtypePathNode r14 = (SubtypePathNode) r5.poll();
        KotlinType r15 = r14.getType();
        TypeConstructor r16 = r15.getConstructor();
        if (r12.assertEqualTypeConstructors(r16, r13) == true) goto L7;
        Iterator<KotlinType> r17 = r16.mo1403getSupertypes().iterator();
    L36:
        if (r17.hasNext() == false) goto L4;
        r5.add(new SubtypePathNode(r17.next(), r14));
        goto L36
    L7:
        boolean r18 = r15.isMarkedNullable();
        SubtypePathNode r19 = r14.getPrevious();
    L8:
        if (r19 == null) goto L28;
        KotlinType r20 = r19.getType();
        List<TypeProjection> r21 = r20.getArguments();
        if (r21 != null) goto L12;
    L14:
        Iterator<T> r22 = r21.iterator();
    L16:
        if (r22.hasNext() == false) goto L20;
        Variance r23 = ((TypeProjection) r22.next()).getProjectionKind();
        Variance r24 = Variance.INVARIANT;
        if (r23 == r24) goto L16;
        r15 = approximate(CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(r20), false, 1, null).buildSubstitutor().safeSubstitute(r15, r24));
    L21:
        if (r18 == false) goto L23;
    L26:
        r18 = true;
    L27:
        r19 = r19.getPrevious();
        goto L8
    L23:
        if (r20.isMarkedNullable() == true) goto L26;
        r18 = false;
    L20:
        r15 = TypeConstructorSubstitution.Companion.create(r20).buildSubstitutor().safeSubstitute(r15, Variance.INVARIANT);
        goto L21
    L12:
        if (r21.isEmpty() == false) goto L14;
    L28:
        TypeConstructor r110 = r15.getConstructor();
        if (r12.assertEqualTypeConstructors(r110, r13) == false) goto L33;
        return TypeUtils.makeNullableAsSpecified(r15, r18);
    L33:
        throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + debugInfo(r110) + ", \n\nsupertype: " + debugInfo(r13) + " \n" + r12.assertEqualTypeConstructors(r110, r13));
    L38:
        return null;
    }
}
