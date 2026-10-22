package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeEnhancementUtilsKt {
    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers r10, Collection<JavaTypeQualifiers> r11, boolean r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "superQualifiers");
        ArrayList r15 = new ArrayList();
        Iterator<T> r16 = r11.iterator();
    L4:
        if (r16.hasNext() == false) goto L8;
        NullabilityQualifier r17 = getNullabilityForErrors((JavaTypeQualifiers) r16.next());
        if (r17 == null) goto L4;
        r15.add(r17);
        goto L4
    L8:
        NullabilityQualifier r18 = select(CollectionsKt.toSet(r15), getNullabilityForErrors(r10), r12);
        if (r18 != null) goto L17;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r11.iterator();
    L12:
        if (r20.hasNext() == false) goto L16;
        NullabilityQualifier r21 = ((JavaTypeQualifiers) r20.next()).getNullability();
        if (r21 == null) goto L12;
        r19.add(r21);
        goto L12
    L16:
        NullabilityQualifier r22 = select(CollectionsKt.toSet(r19), r10.getNullability(), r12);
    L18:
        ArrayList r23 = new ArrayList();
        Iterator<T> r24 = r11.iterator();
    L20:
        if (r24.hasNext() == false) goto L24;
        MutabilityQualifier r25 = ((JavaTypeQualifiers) r24.next()).getMutability();
        if (r25 == null) goto L20;
        r23.add(r25);
        goto L20
    L24:
        MutabilityQualifier r26 = (MutabilityQualifier) select(CollectionsKt.toSet(r23), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, r10.getMutability(), r12);
        NullabilityQualifier r27 = null;
        boolean r28 = true;
        if (r22 == null) goto L36;
        if (r14 == true) goto L32;
        if (r13 == true) goto L29;
    L31:
        boolean r29 = false;
    L33:
        if (r29 == true) goto L36;
        r27 = r22;
        goto L36
    L29:
        if (r22 != NullabilityQualifier.NULLABLE) goto L31;
    L32:
        r29 = true;
    L36:
        if (r27 == NullabilityQualifier.NOT_NULL) goto L38;
    L50:
        boolean r30 = false;
    L51:
        if (r27 == null) goto L54;
        if (r18 == r22) goto L54;
    L56:
        return new JavaTypeQualifiers(r27, r26, r30, r28);
    L54:
        r28 = false;
        goto L56
    L38:
        if (r10.getDefinitelyNotNull() == false) goto L40;
    L49:
        r30 = true;
        goto L51
    L40:
        if (r11.isEmpty() == false) goto L42;
    L41:
        boolean r31 = false;
    L48:
        if (r31 == false) goto L50;
    L42:
        Iterator<T> r32 = r11.iterator();
    L44:
        if (r32.hasNext() == false) goto L41;
        if (((JavaTypeQualifiers) r32.next()).getDefinitelyNotNull() == false) goto L44;
        r31 = true;
        goto L48
    L17:
        r22 = r18;
        goto L18
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers r10) {
        if (r10.isNullabilityQualifierForWarning() == false) goto L6;
        return null;
    L6:
        return r10.getNullability();
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext r10, KotlinTypeMarker r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
        FqName r12 = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(r12, "ENHANCED_NULLABILITY_ANNOTATION");
        return r10.hasAnnotation(r11, r12);
    }

    private static final <T> T select(Set<? extends T> r10, T r11, T r12, T r13, boolean r14) {
        if (r14 == true) goto L4;
        if (r13 == null) goto L24;
        Set<? extends T> r15 = CollectionsKt.toSet(SetsKt.plus(r10, r13));
        if (r15 == null) goto L24;
        r10 = r15;
    L24:
        return (T) CollectionsKt.singleOrNull(r10);
    L4:
        if (r10.contains(r11) == false) goto L7;
        T r16 = r11;
    L11:
        if (Intrinsics.areEqual(r16, r11) == true) goto L13;
    L15:
        if (r13 == null) goto L17;
        return r13;
    L17:
        return r16;
    L13:
        if (Intrinsics.areEqual(r13, r12) == false) goto L15;
        return null;
    L7:
        if (r10.contains(r12) == false) goto L9;
        r16 = r12;
        goto L11
    L9:
        r16 = null;
        goto L11
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> r10, NullabilityQualifier r11, boolean r12) {
        NullabilityQualifier r13 = NullabilityQualifier.FORCE_FLEXIBILITY;
        if (r11 != r13) goto L6;
        return r13;
    L6:
        return (NullabilityQualifier) select(r10, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, r11, r12);
    }
}
