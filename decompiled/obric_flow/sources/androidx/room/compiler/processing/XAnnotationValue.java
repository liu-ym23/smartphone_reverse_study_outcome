package androidx.room.compiler.processing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u001f\bf\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u0010H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0010H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0010H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0010H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u0010H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\b\u00101\u001a\u00020\u0013H&J\b\u00102\u001a\u00020\u0013H&J\b\u00103\u001a\u00020\u0013H&J\b\u00104\u001a\u00020\u0013H&J\b\u00105\u001a\u00020\u0013H&J\b\u00106\u001a\u00020\u0013H&J\b\u00107\u001a\u00020\u0013H&J\b\u00108\u001a\u00020\u0013H&J\b\u00109\u001a\u00020\u0013H&J\b\u0010:\u001a\u00020\u0013H&J\b\u0010;\u001a\u00020\u0013H&J\b\u0010<\u001a\u00020\u0013H&J\b\u0010=\u001a\u00020\u0013H&J\b\u0010>\u001a\u00020\u0013H&J\b\u0010?\u001a\u00020\u0013H&J\b\u0010@\u001a\u00020\u0013H&J\b\u0010A\u001a\u00020\u0013H&J\b\u0010B\u001a\u00020\u0013H&J\b\u0010C\u001a\u00020\u0013H&J\b\u0010D\u001a\u00020\u0013H&J\b\u0010E\u001a\u00020\u0013H&J\b\u0010F\u001a\u00020\u0013H&J\b\u0010G\u001a\u00020\u0013H&J\b\u0010H\u001a\u00020\u0013H&J\b\u0010I\u001a\u00020\u0013H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006JÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XAnnotationValue;", "", "name", "", "getName", "()Ljava/lang/String;", "value", "getValue", "()Ljava/lang/Object;", "valueType", "Landroidx/room/compiler/processing/XType;", "getValueType", "()Landroidx/room/compiler/processing/XType;", "asAnnotation", "Landroidx/room/compiler/processing/XAnnotation;", "asAnnotationList", "", "asAnnotationValueList", "asBoolean", "", "asBooleanList", "asByte", "", "asByteList", "asChar", "", "asCharList", "asDouble", "", "asDoubleList", "asEnum", "Landroidx/room/compiler/processing/XEnumEntry;", "asEnumList", "asFloat", "", "asFloatList", "asInt", "", "asIntList", "asLong", "", "asLongList", "asShort", "", "asShortList", "asString", "asStringList", "asType", "asTypeList", "hasAnnotationListValue", "hasAnnotationValue", "hasBooleanListValue", "hasBooleanValue", "hasByteListValue", "hasByteValue", "hasCharListValue", "hasCharValue", "hasDoubleListValue", "hasDoubleValue", "hasEnumListValue", "hasEnumValue", "hasFloatListValue", "hasFloatValue", "hasIntListValue", "hasIntValue", "hasListValue", "hasLongListValue", "hasLongValue", "hasShortListValue", "hasShortValue", "hasStringListValue", "hasStringValue", "hasTypeListValue", "hasTypeValue", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XAnnotationValue {
    default XAnnotation asAnnotation() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.room.compiler.processing.XAnnotation");
        return (XAnnotation) r5;
    }

    default List<XAnnotation> asAnnotationList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((XAnnotationValue) r11.next()).asAnnotation());
        goto L4
    L6:
        return r10;
    }

    default List<XAnnotationValue> asAnnotationValueList() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.collections.List<androidx.room.compiler.processing.XAnnotationValue>");
        return (List) r5;
    }

    default boolean asBoolean() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) r5).booleanValue();
    }

    default List<Boolean> asBooleanList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Boolean.valueOf(((XAnnotationValue) r11.next()).asBoolean()));
        goto L4
    L6:
        return r10;
    }

    default byte asByte() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Byte");
        return ((Byte) r5).byteValue();
    }

    default List<Byte> asByteList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Byte.valueOf(((XAnnotationValue) r11.next()).asByte()));
        goto L4
    L6:
        return r10;
    }

    default char asChar() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Char");
        return ((Character) r5).charValue();
    }

    default List<Character> asCharList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Character.valueOf(((XAnnotationValue) r11.next()).asChar()));
        goto L4
    L6:
        return r10;
    }

    default double asDouble() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) r5).doubleValue();
    }

    default List<Double> asDoubleList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Double.valueOf(((XAnnotationValue) r11.next()).asDouble()));
        goto L4
    L6:
        return r10;
    }

    default XEnumEntry asEnum() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.room.compiler.processing.XEnumEntry");
        return (XEnumEntry) r5;
    }

    default List<XEnumEntry> asEnumList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((XAnnotationValue) r11.next()).asEnum());
        goto L4
    L6:
        return r10;
    }

    default float asFloat() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Float");
        return ((Float) r5).floatValue();
    }

    default List<Float> asFloatList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Object r12 = ((XAnnotationValue) r11.next()).getValue();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Float");
        Float r13 = (Float) r12;
        r13.getClass();
        r10.add(r13);
        goto L4
    L6:
        return r10;
    }

    default int asInt() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) r5).intValue();
    }

    default List<Integer> asIntList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Integer.valueOf(((XAnnotationValue) r11.next()).asInt()));
        goto L4
    L6:
        return r10;
    }

    default long asLong() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) r5).longValue();
    }

    default List<Long> asLongList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Long.valueOf(((XAnnotationValue) r11.next()).asLong()));
        goto L4
    L6:
        return r10;
    }

    default short asShort() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Short");
        return ((Short) r5).shortValue();
    }

    default List<Short> asShortList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(Short.valueOf(((XAnnotationValue) r11.next()).asShort()));
        goto L4
    L6:
        return r10;
    }

    default String asString() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.String");
        return (String) r5;
    }

    default List<String> asStringList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((XAnnotationValue) r11.next()).asString());
        goto L4
    L6:
        return r10;
    }

    default XType asType() {
        Object r5 = getValue();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.room.compiler.processing.XType");
        return (XType) r5;
    }

    default List<XType> asTypeList() {
        List<XAnnotationValue> r5 = asAnnotationValueList();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.add(((XAnnotationValue) r11.next()).asType());
        goto L4
    L6:
        return r10;
    }

    String getName();

    Object getValue();

    XType getValueType();

    boolean hasAnnotationListValue();

    boolean hasAnnotationValue();

    boolean hasBooleanListValue();

    boolean hasBooleanValue();

    boolean hasByteListValue();

    boolean hasByteValue();

    boolean hasCharListValue();

    boolean hasCharValue();

    boolean hasDoubleListValue();

    boolean hasDoubleValue();

    boolean hasEnumListValue();

    boolean hasEnumValue();

    boolean hasFloatListValue();

    boolean hasFloatValue();

    boolean hasIntListValue();

    boolean hasIntValue();

    boolean hasListValue();

    boolean hasLongListValue();

    boolean hasLongValue();

    boolean hasShortListValue();

    boolean hasShortValue();

    boolean hasStringListValue();

    boolean hasStringValue();

    boolean hasTypeListValue();

    boolean hasTypeValue();
}
