package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ntypeEnhancementUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancementUtils.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,61:1\n1#2:62\n1#2:73\n1#2:86\n1#2:99\n1603#3,9:63\n1855#3:72\n1856#3:74\n1612#3:75\n1603#3,9:76\n1855#3:85\n1856#3:87\n1612#3:88\n1603#3,9:89\n1855#3:98\n1856#3:100\n1612#3:101\n1747#3,3:102\n*S KotlinDebug\n*F\n+ 1 typeEnhancementUtils.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/TypeEnhancementUtilsKt\n*L\n41#1:73\n43#1:86\n45#1:99\n41#1:63,9\n41#1:72\n41#1:74\n41#1:75\n43#1:76,9\n43#1:85\n43#1:87\n43#1:88\n45#1:89,9\n45#1:98\n45#1:100\n45#1:101\n54#1:102,3\n*E\n"})
public final class TypeEnhancementUtilsKt {
    public static final JavaTypeQualifiers computeQualifiersForOverride(JavaTypeQualifiers r10, Collection<JavaTypeQualifiers> r11, boolean r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "superQualifiers");
        Collection<JavaTypeQualifiers> r15 = r11;
        ArrayList r5 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L8;
        NullabilityQualifier r17 = getNullabilityForErrors((JavaTypeQualifiers) r16.next());
        if (r17 == null) goto L4;
        r5.add(r17);
        goto L4
    L8:
        NullabilityQualifier r18 = select(CollectionsKt.toSet(r5), getNullabilityForErrors(r10), r12);
        if (r18 != null) goto L17;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r15.iterator();
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
        Iterator<T> r24 = r15.iterator();
    L20:
        if (r24.hasNext() == false) goto L24;
        MutabilityQualifier r25 = ((JavaTypeQualifiers) r24.next()).getMutability();
        if (r25 == null) goto L20;
        r23.add(r25);
        goto L20
    L24:
        MutabilityQualifier r26 = (MutabilityQualifier) select(CollectionsKt.toSet(r23), MutabilityQualifier.MUTABLE, MutabilityQualifier.READ_ONLY, r10.getMutability(), r12);
        NullabilityQualifier r27 = null;
        if (r22 == null) goto L32;
        if (r14 == true) goto L32;
        if (r13 == true) goto L29;
    L31:
        r27 = r22;
        goto L32
    L29:
        if (r22 != NullabilityQualifier.NULLABLE) goto L31;
    L32:
        boolean r110 = false;
        if (r27 == NullabilityQualifier.NOT_NULL) goto L35;
    L45:
        boolean r28 = false;
    L46:
        if (r27 == null) goto L50;
        if (r18 == r22) goto L50;
        r110 = true;
    L50:
        return new JavaTypeQualifiers(r27, r26, r28, r110);
    L35:
        if (r10.getDefinitelyNotNull() == false) goto L37;
    L44:
        r28 = true;
        goto L46
    L37:
        if (r15.isEmpty() == true) goto L45;
        Iterator<T> r29 = r15.iterator();
    L41:
        if (r29.hasNext() == false) goto L45;
        if (((JavaTypeQualifiers) r29.next()).getDefinitelyNotNull() == false) goto L41;
    L17:
        r22 = r18;
        goto L18
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers r5) {
        if (r5.isNullabilityQualifierForWarning() == false) goto L6;
        return null;
    L6:
        return r5.getNullability();
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext r5, KotlinTypeMarker r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "type");
        return r5.hasAnnotation(r10, JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION);
    }

    private static final <T> T select(Set<? extends T> r5, T r10, T r11, T r12, boolean r13) {
        if (r13 == true) goto L4;
        if (r12 == null) goto L24;
        Set<? extends T> r14 = CollectionsKt.toSet(SetsKt.plus(r5, r12));
        if (r14 == null) goto L24;
        r5 = r14;
    L24:
        return (T) CollectionsKt.singleOrNull(r5);
    L4:
        if (r5.contains(r10) == false) goto L7;
        T r15 = r10;
    L11:
        if (Intrinsics.areEqual(r15, r10) == true) goto L13;
    L15:
        if (r12 == null) goto L17;
        return r12;
    L17:
        return r15;
    L13:
        if (Intrinsics.areEqual(r12, r11) == false) goto L15;
        return null;
    L7:
        if (r5.contains(r11) == false) goto L9;
        r15 = r11;
        goto L11
    L9:
        r15 = null;
        goto L11
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> r5, NullabilityQualifier r10, boolean r11) {
        NullabilityQualifier r12 = NullabilityQualifier.FORCE_FLEXIBILITY;
        if (r10 != r12) goto L6;
        return r12;
    L6:
        return (NullabilityQualifier) select(r5, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, r10, r11);
    }
}
