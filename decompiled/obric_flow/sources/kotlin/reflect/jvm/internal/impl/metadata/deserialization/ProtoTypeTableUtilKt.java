package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nprotoTypeTableUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 protoTypeTableUtil.kt\norg/jetbrains/kotlin/metadata/deserialization/ProtoTypeTableUtilKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,125:1\n1#2:126\n1549#3:127\n1620#3,3:128\n1549#3:131\n1620#3,3:132\n1549#3:135\n1620#3,3:136\n1549#3:139\n1620#3,3:140\n1549#3:143\n1620#3,3:144\n*S KotlinDebug\n*F\n+ 1 protoTypeTableUtil.kt\norg/jetbrains/kotlin/metadata/deserialization/ProtoTypeTableUtilKt\n*L\n24#1:127\n24#1:128,3\n45#1:131\n45#1:132,3\n118#1:135\n118#1:136,3\n121#1:139\n121#1:140,3\n124#1:143\n124#1:144,3\n*E\n"})
public final class ProtoTypeTableUtilKt {
    public static final ProtoBuf.Type abbreviatedType(ProtoBuf.Type r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasAbbreviatedType() == false) goto L6;
        return r5.getAbbreviatedType();
    L6:
        if (r5.hasAbbreviatedTypeId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getAbbreviatedTypeId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Class r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        List<ProtoBuf.Type> r11 = r5.getContextReceiverTypeList();
        boolean r12 = r11.isEmpty();
        ?? r13 = r11;
        if (r12 == false) goto L6;
        r13 = 0;
    L6:
        if (r13 != 0) goto L11;
        List<Integer> r14 = r5.getContextReceiverTypeIdList();
        r13 = new ArrayList(CollectionsKt.h(r14));
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        r13.add(r10.get(((Integer) r15.next()).intValue()));
    L11:
        return r13;
    }

    public static final ProtoBuf.Type expandedType(ProtoBuf.TypeAlias r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasExpandedType() == false) goto L6;
        return r5.getExpandedType();
    L6:
        if (r5.hasExpandedTypeId() == false) goto L10;
        return r10.get(r5.getExpandedTypeId());
    L10:
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias");
    }

    public static final ProtoBuf.Type flexibleUpperBound(ProtoBuf.Type r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasFlexibleUpperBound() == false) goto L6;
        return r5.getFlexibleUpperBound();
    L6:
        if (r5.hasFlexibleUpperBoundId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getFlexibleUpperBoundId());
    }

    public static final boolean hasReceiver(ProtoBuf.Function r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.hasReceiverType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.hasReceiverTypeId() == true) goto L8;
        return false;
    }

    public static final ProtoBuf.Type inlineClassUnderlyingType(ProtoBuf.Class r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasInlineClassUnderlyingType() == false) goto L6;
        return r5.getInlineClassUnderlyingType();
    L6:
        if (r5.hasInlineClassUnderlyingTypeId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getInlineClassUnderlyingTypeId());
    }

    public static final ProtoBuf.Type outerType(ProtoBuf.Type r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasOuterType() == false) goto L6;
        return r5.getOuterType();
    L6:
        if (r5.hasOuterTypeId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getOuterTypeId());
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Function r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasReceiverType() == false) goto L6;
        return r5.getReceiverType();
    L6:
        if (r5.hasReceiverTypeId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getReceiverTypeId());
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Function r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasReturnType() == false) goto L6;
        return r5.getReturnType();
    L6:
        if (r5.hasReturnTypeId() == false) goto L10;
        return r10.get(r5.getReturnTypeId());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Function");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static final List<ProtoBuf.Type> supertypes(ProtoBuf.Class r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        List<ProtoBuf.Type> r11 = r5.getSupertypeList();
        boolean r12 = r11.isEmpty();
        ?? r13 = r11;
        if (r12 == false) goto L6;
        r13 = 0;
    L6:
        if (r13 != 0) goto L11;
        List<Integer> r14 = r5.getSupertypeIdList();
        r13 = new ArrayList(CollectionsKt.h(r14));
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        r13.add(r10.get(((Integer) r15.next()).intValue()));
    L11:
        return r13;
    }

    public static final ProtoBuf.Type type(ProtoBuf.Type.Argument r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasType() == false) goto L6;
        return r5.getType();
    L6:
        if (r5.hasTypeId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getTypeId());
    }

    public static final ProtoBuf.Type underlyingType(ProtoBuf.TypeAlias r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasUnderlyingType() == false) goto L6;
        return r5.getUnderlyingType();
    L6:
        if (r5.hasUnderlyingTypeId() == false) goto L10;
        return r10.get(r5.getUnderlyingTypeId());
    L10:
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static final List<ProtoBuf.Type> upperBounds(ProtoBuf.TypeParameter r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        List<ProtoBuf.Type> r11 = r5.getUpperBoundList();
        boolean r12 = r11.isEmpty();
        ?? r13 = r11;
        if (r12 == false) goto L6;
        r13 = 0;
    L6:
        if (r13 != 0) goto L11;
        List<Integer> r14 = r5.getUpperBoundIdList();
        r13 = new ArrayList(CollectionsKt.h(r14));
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        r13.add(r10.get(((Integer) r15.next()).intValue()));
    L11:
        return r13;
    }

    public static final ProtoBuf.Type varargElementType(ProtoBuf.ValueParameter r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasVarargElementType() == false) goto L6;
        return r5.getVarargElementType();
    L6:
        if (r5.hasVarargElementTypeId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getVarargElementTypeId());
    }

    public static final boolean hasReceiver(ProtoBuf.Property r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.hasReceiverType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r5.hasReceiverTypeId() == true) goto L8;
        return false;
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Property r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasReceiverType() == false) goto L6;
        return r5.getReceiverType();
    L6:
        if (r5.hasReceiverTypeId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getReceiverTypeId());
    }

    public static final ProtoBuf.Type type(ProtoBuf.ValueParameter r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasType() == false) goto L6;
        return r5.getType();
    L6:
        if (r5.hasTypeId() == false) goto L10;
        return r10.get(r5.getTypeId());
    L10:
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter");
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Property r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasReturnType() == false) goto L6;
        return r5.getReturnType();
    L6:
        if (r5.hasReturnTypeId() == false) goto L10;
        return r10.get(r5.getReturnTypeId());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Property");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Function r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        List<ProtoBuf.Type> r11 = r5.getContextReceiverTypeList();
        boolean r12 = r11.isEmpty();
        ?? r13 = r11;
        if (r12 == false) goto L6;
        r13 = 0;
    L6:
        if (r13 != 0) goto L11;
        List<Integer> r14 = r5.getContextReceiverTypeIdList();
        r13 = new ArrayList(CollectionsKt.h(r14));
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        r13.add(r10.get(((Integer) r15.next()).intValue()));
    L11:
        return r13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type>] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Property r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        List<ProtoBuf.Type> r11 = r5.getContextReceiverTypeList();
        boolean r12 = r11.isEmpty();
        ?? r13 = r11;
        if (r12 == false) goto L6;
        r13 = 0;
    L6:
        if (r13 != 0) goto L11;
        List<Integer> r14 = r5.getContextReceiverTypeIdList();
        r13 = new ArrayList(CollectionsKt.h(r14));
        Iterator r15 = r14.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        r13.add(r10.get(((Integer) r15.next()).intValue()));
    L11:
        return r13;
    }
}
