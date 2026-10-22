package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtoTypeTableUtilKt {
    public static final ProtoBuf.Type abbreviatedType(ProtoBuf.Type r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasAbbreviatedType() == false) goto L6;
        return r10.getAbbreviatedType();
    L6:
        if (r10.hasAbbreviatedTypeId() == true) goto L11;
        return null;
    L11:
        return r11.get(r10.getAbbreviatedTypeId());
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Class r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        List<ProtoBuf.Type> r12 = r10.getContextReceiverTypeList();
        if ((!r12.isEmpty()) == true) goto L6;
        r12 = null;
    L6:
        if (r12 != null) goto L11;
        List<Integer> r13 = r10.getContextReceiverTypeIdList();
        Intrinsics.checkNotNullExpressionValue(r13, "contextReceiverTypeIdList");
        r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        Integer r15 = (Integer) r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, "it");
        r12.add(r11.get(r15.intValue()));
    L11:
        return r12;
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Function r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        List<ProtoBuf.Type> r12 = r10.getContextReceiverTypeList();
        if ((!r12.isEmpty()) == true) goto L6;
        r12 = null;
    L6:
        if (r12 != null) goto L11;
        List<Integer> r13 = r10.getContextReceiverTypeIdList();
        Intrinsics.checkNotNullExpressionValue(r13, "contextReceiverTypeIdList");
        r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        Integer r15 = (Integer) r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, "it");
        r12.add(r11.get(r15.intValue()));
    L11:
        return r12;
    }

    public static final List<ProtoBuf.Type> contextReceiverTypes(ProtoBuf.Property r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        List<ProtoBuf.Type> r12 = r10.getContextReceiverTypeList();
        if ((!r12.isEmpty()) == true) goto L6;
        r12 = null;
    L6:
        if (r12 != null) goto L11;
        List<Integer> r13 = r10.getContextReceiverTypeIdList();
        Intrinsics.checkNotNullExpressionValue(r13, "contextReceiverTypeIdList");
        r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        Integer r15 = (Integer) r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, "it");
        r12.add(r11.get(r15.intValue()));
    L11:
        return r12;
    }

    public static final ProtoBuf.Type expandedType(ProtoBuf.TypeAlias r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasExpandedType() == false) goto L6;
        ProtoBuf.Type r12 = r10.getExpandedType();
        Intrinsics.checkNotNullExpressionValue(r12, "expandedType");
        return r12;
    L6:
        if (r10.hasExpandedTypeId() == false) goto L10;
        return r11.get(r10.getExpandedTypeId());
    L10:
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final ProtoBuf.Type flexibleUpperBound(ProtoBuf.Type r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasFlexibleUpperBound() == false) goto L6;
        return r10.getFlexibleUpperBound();
    L6:
        if (r10.hasFlexibleUpperBoundId() == true) goto L11;
        return null;
    L11:
        return r11.get(r10.getFlexibleUpperBoundId());
    }

    public static final boolean hasReceiver(ProtoBuf.Function r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.hasReceiverType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.hasReceiverTypeId() == true) goto L8;
        return false;
    }

    public static final boolean hasReceiver(ProtoBuf.Property r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.hasReceiverType() == false) goto L5;
    L8:
        return true;
    L5:
        if (r10.hasReceiverTypeId() == true) goto L8;
        return false;
    }

    public static final ProtoBuf.Type inlineClassUnderlyingType(ProtoBuf.Class r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasInlineClassUnderlyingType() == false) goto L6;
        return r10.getInlineClassUnderlyingType();
    L6:
        if (r10.hasInlineClassUnderlyingTypeId() == true) goto L11;
        return null;
    L11:
        return r11.get(r10.getInlineClassUnderlyingTypeId());
    }

    public static final ProtoBuf.Type outerType(ProtoBuf.Type r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasOuterType() == false) goto L6;
        return r10.getOuterType();
    L6:
        if (r10.hasOuterTypeId() == true) goto L11;
        return null;
    L11:
        return r11.get(r10.getOuterTypeId());
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Function r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasReceiverType() == false) goto L6;
        return r10.getReceiverType();
    L6:
        if (r10.hasReceiverTypeId() == true) goto L11;
        return null;
    L11:
        return r11.get(r10.getReceiverTypeId());
    }

    public static final ProtoBuf.Type receiverType(ProtoBuf.Property r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasReceiverType() == false) goto L6;
        return r10.getReceiverType();
    L6:
        if (r10.hasReceiverTypeId() == true) goto L11;
        return null;
    L11:
        return r11.get(r10.getReceiverTypeId());
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Function r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasReturnType() == false) goto L6;
        ProtoBuf.Type r12 = r10.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r12, "returnType");
        return r12;
    L6:
        if (r10.hasReturnTypeId() == false) goto L10;
        return r11.get(r10.getReturnTypeId());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final ProtoBuf.Type returnType(ProtoBuf.Property r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasReturnType() == false) goto L6;
        ProtoBuf.Type r12 = r10.getReturnType();
        Intrinsics.checkNotNullExpressionValue(r12, "returnType");
        return r12;
    L6:
        if (r10.hasReturnTypeId() == false) goto L10;
        return r11.get(r10.getReturnTypeId());
    L10:
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final List<ProtoBuf.Type> supertypes(ProtoBuf.Class r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        List<ProtoBuf.Type> r12 = r10.getSupertypeList();
        if ((!r12.isEmpty()) == true) goto L6;
        r12 = null;
    L6:
        if (r12 != null) goto L11;
        List<Integer> r13 = r10.getSupertypeIdList();
        Intrinsics.checkNotNullExpressionValue(r13, "supertypeIdList");
        r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        Integer r15 = (Integer) r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, "it");
        r12.add(r11.get(r15.intValue()));
    L11:
        return r12;
    }

    public static final ProtoBuf.Type type(ProtoBuf.Type.Argument r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasType() == false) goto L6;
        return r10.getType();
    L6:
        if (r10.hasTypeId() == true) goto L11;
        return null;
    L11:
        return r11.get(r10.getTypeId());
    }

    public static final ProtoBuf.Type type(ProtoBuf.ValueParameter r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasType() == false) goto L6;
        ProtoBuf.Type r12 = r10.getType();
        Intrinsics.checkNotNullExpressionValue(r12, WsConstants.KEY_CONNECTION_TYPE);
        return r12;
    L6:
        if (r10.hasTypeId() == false) goto L10;
        return r11.get(r10.getTypeId());
    L10:
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final ProtoBuf.Type underlyingType(ProtoBuf.TypeAlias r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasUnderlyingType() == false) goto L6;
        ProtoBuf.Type r12 = r10.getUnderlyingType();
        Intrinsics.checkNotNullExpressionValue(r12, "underlyingType");
        return r12;
    L6:
        if (r10.hasUnderlyingTypeId() == false) goto L10;
        return r11.get(r10.getUnderlyingTypeId());
    L10:
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<ProtoBuf.Type> upperBounds(ProtoBuf.TypeParameter r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        List<ProtoBuf.Type> r12 = r10.getUpperBoundList();
        if ((!r12.isEmpty()) == true) goto L6;
        r12 = null;
    L6:
        if (r12 != null) goto L11;
        List<Integer> r13 = r10.getUpperBoundIdList();
        Intrinsics.checkNotNullExpressionValue(r13, "upperBoundIdList");
        r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L9:
        if (r14.hasNext() == false) goto L11;
        Integer r15 = (Integer) r14.next();
        Intrinsics.checkNotNullExpressionValue(r15, "it");
        r12.add(r11.get(r15.intValue()));
    L11:
        return r12;
    }

    public static final ProtoBuf.Type varargElementType(ProtoBuf.ValueParameter r10, TypeTable r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "typeTable");
        if (r10.hasVarargElementType() == false) goto L6;
        return r10.getVarargElementType();
    L6:
        if (r10.hasVarargElementTypeId() == true) goto L11;
        return null;
    L11:
        return r11.get(r10.getVarargElementTypeId());
    }
}
