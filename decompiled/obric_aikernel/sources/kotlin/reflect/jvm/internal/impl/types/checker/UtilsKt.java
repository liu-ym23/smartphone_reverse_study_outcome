package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
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
public final class UtilsKt {
    private static final KotlinType approximate(KotlinType r10) {
        return CapturedTypeApproximationKt.approximateCapturedTypes(r10).getUpper();
    }

    private static final String debugInfo(TypeConstructor r10) {
        StringBuilder r11 = new StringBuilder();
        debugInfo$lambda$1$unaryPlus("type: " + r10, r11);
        debugInfo$lambda$1$unaryPlus("hashCode: " + r10.hashCode(), r11);
        debugInfo$lambda$1$unaryPlus("javaClass: " + r10.getClass().getCanonicalName(), r11);
        DeclarationDescriptor r12 = r10.mo1323getDeclarationDescriptor();
    L3:
        if (r12 == null) goto L5;
        debugInfo$lambda$1$unaryPlus("fqName: " + DescriptorRenderer.FQ_NAMES_IN_TYPES.render(r12), r11);
        debugInfo$lambda$1$unaryPlus("javaClass: " + r12.getClass().getCanonicalName(), r11);
        r12 = r12.getContainingDeclaration();
        goto L3
    L5:
        String r13 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r13, "StringBuilder().apply(builderAction).toString()");
        return r13;
    }

    private static final StringBuilder debugInfo$lambda$1$unaryPlus(String r10, StringBuilder r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r11.append(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "append(value)");
        r11.append('\n');
        Intrinsics.checkNotNullExpressionValue(r11, "append('\\n')");
        return r11;
    }

    public static final KotlinType findCorrespondingSupertype(KotlinType r10, KotlinType r11, TypeCheckingProcedureCallbacks r12) {
        Intrinsics.checkNotNullParameter(r10, "subtype");
        Intrinsics.checkNotNullParameter(r11, "supertype");
        Intrinsics.checkNotNullParameter(r12, "typeCheckingProcedureCallbacks");
        ArrayDeque r13 = new ArrayDeque();
        r13.add(new SubtypePathNode(r10, null));
        TypeConstructor r14 = r11.getConstructor();
    L4:
        if (r13.isEmpty() == true) goto L43;
        SubtypePathNode r15 = (SubtypePathNode) r13.poll();
        KotlinType r16 = r15.getType();
        TypeConstructor r17 = r16.getConstructor();
        if (r12.assertEqualTypeConstructors(r17, r14) == true) goto L7;
        Iterator<KotlinType> r18 = r17.mo1324getSupertypes().iterator();
    L41:
        if (r18.hasNext() == false) goto L4;
        KotlinType r19 = r18.next();
        Intrinsics.checkNotNullExpressionValue(r19, "immediateSupertype");
        r13.add(new SubtypePathNode(r19, r15));
        goto L41
    L7:
        boolean r20 = r16.isMarkedNullable();
    L8:
        r15 = r15.getPrevious();
        if (r15 == null) goto L33;
        KotlinType r21 = r15.getType();
        List<TypeProjection> r22 = r21.getArguments();
        if ((r22 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r23 = r22.iterator();
    L17:
        if (r23.hasNext() == false) goto L14;
        if (((TypeProjection) r23.next()).getProjectionKind() == Variance.INVARIANT) goto L21;
        boolean r24 = true;
    L22:
        if (r24 == false) goto L17;
        boolean r25 = true;
    L24:
        if (r25 == false) goto L26;
        KotlinType r26 = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create(r21), false, 1, null).buildSubstitutor().safeSubstitute(r16, Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(r26, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
        r16 = approximate(r26);
    L27:
        if (r20 == true) goto L32;
        if (r21.isMarkedNullable() == true) goto L32;
        r20 = false;
    L32:
        r20 = true;
        goto L8
    L26:
        r16 = TypeConstructorSubstitution.Companion.create(r21).buildSubstitutor().safeSubstitute(r16, Variance.INVARIANT);
        Intrinsics.checkNotNullExpressionValue(r16, "{\n                    Ty…ARIANT)\n                }");
        goto L27
    L21:
        r24 = false;
    L14:
        r25 = false;
        goto L24
    L13:
        if (r22.isEmpty() == false) goto L15;
    L33:
        TypeConstructor r110 = r16.getConstructor();
        if (r12.assertEqualTypeConstructors(r110, r14) == false) goto L38;
        return TypeUtils.makeNullableAsSpecified(r16, r20);
    L38:
        throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + debugInfo(r110) + ", \n\nsupertype: " + debugInfo(r14) + " \n" + r12.assertEqualTypeConstructors(r110, r14));
    L43:
        return null;
    }
}
