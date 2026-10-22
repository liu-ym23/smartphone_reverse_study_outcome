package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.deserialization;

import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0007\u001a\n\u0010\f\u001a\u00020\r*\u00020\b\u001a\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u001c"}, d2 = {"abbreviatedType", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type;", "typeTable", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/deserialization/TypeTable;", "contextReceiverTypes", "", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Class;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Function;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Property;", "expandedType", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeAlias;", "flexibleUpperBound", "hasReceiver", "", "inlineClassUnderlyingType", "isInstanceType", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Expression;", "outerType", "receiverType", "returnType", "supertypes", "type", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$Type$Argument;", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$ValueParameter;", "underlyingType", "upperBounds", "Landroidx/room/jarjarred/kotlinx/metadata/internal/metadata/ProtoBuf$TypeParameter;", "varargElementType", "metadata"}, k = 2, mv = {1, 7, 1}, xi = 48)
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
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf$Type>] */
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

    public static final ProtoBuf.Type isInstanceType(ProtoBuf.Expression r5, TypeTable r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "typeTable");
        if (r5.hasIsInstanceType() == false) goto L6;
        return r5.getIsInstanceType();
    L6:
        if (r5.hasIsInstanceTypeId() == true) goto L11;
        return null;
    L11:
        return r10.get(r5.getIsInstanceTypeId());
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
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf$Type>] */
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
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf$Type>] */
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
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf$Type>] */
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
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf$Type>] */
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
