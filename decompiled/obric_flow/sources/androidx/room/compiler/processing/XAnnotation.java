package androidx.room.compiler.processing;

import com.squareup.javapoet.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\tJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\tJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\tJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\tJ\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010\tJ\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b+\u0010\tJ\u0017\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010.J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010\tJ\u001d\u00101\u001a\b\u0012\u0004\u0012\u0002000\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b1\u0010\tJ\u0017\u00102\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u0010;\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u0002000\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\bD\u0010Eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006GÀ\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XAnnotation;", "", "", "methodName", "Landroidx/room/compiler/processing/XType;", "getAsType", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XType;", "", "getAsTypeList", "(Ljava/lang/String;)Ljava/util/List;", "getAsAnnotation", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XAnnotation;", "getAsAnnotationList", "Landroidx/room/compiler/processing/XEnumEntry;", "getAsEnum", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XEnumEntry;", "getAsEnumList", "", "getAsBoolean", "(Ljava/lang/String;)Z", "getAsBooleanList", "getAsString", "(Ljava/lang/String;)Ljava/lang/String;", "getAsStringList", "", "getAsInt", "(Ljava/lang/String;)I", "getAsIntList", "", "getAsLong", "(Ljava/lang/String;)J", "getAsLongList", "", "getAsShort", "(Ljava/lang/String;)S", "getAsShortList", "", "getAsFloat", "(Ljava/lang/String;)F", "getAsFloatList", "", "getAsDouble", "(Ljava/lang/String;)D", "getAsDoubleList", "", "getAsByte", "(Ljava/lang/String;)B", "getAsByteList", "Landroidx/room/compiler/processing/XAnnotationValue;", "getAsAnnotationValueList", "getAnnotationValue", "(Ljava/lang/String;)Landroidx/room/compiler/processing/XAnnotationValue;", "getName", "()Ljava/lang/String;", "name", "getQualifiedName", "qualifiedName", "getType", "()Landroidx/room/compiler/processing/XType;", "type", "Landroidx/room/compiler/processing/XTypeElement;", "getTypeElement", "()Landroidx/room/compiler/processing/XTypeElement;", "typeElement", "Lcom/squareup/javapoet/e;", "getClassName", "()Lcom/squareup/javapoet/e;", "className", "getAnnotationValues", "()Ljava/util/List;", "annotationValues", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XAnnotation {
    XAnnotationValue getAnnotationValue(String r5);

    List<XAnnotationValue> getAnnotationValues();

    default XAnnotation getAsAnnotation(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asAnnotation();
    }

    default List<XAnnotation> getAsAnnotationList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asAnnotationList();
    }

    default List<XAnnotationValue> getAsAnnotationValueList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asAnnotationValueList();
    }

    default boolean getAsBoolean(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asBoolean();
    }

    default List<Boolean> getAsBooleanList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asBooleanList();
    }

    default byte getAsByte(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asByte();
    }

    default List<Byte> getAsByteList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asByteList();
    }

    default double getAsDouble(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asDouble();
    }

    default List<Double> getAsDoubleList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asDoubleList();
    }

    default XEnumEntry getAsEnum(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asEnum();
    }

    default List<XEnumEntry> getAsEnumList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asEnumList();
    }

    default float getAsFloat(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asFloat();
    }

    default List<Float> getAsFloatList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asFloatList();
    }

    default int getAsInt(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asInt();
    }

    default List<Integer> getAsIntList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asIntList();
    }

    default long getAsLong(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asLong();
    }

    default List<Long> getAsLongList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asLongList();
    }

    default short getAsShort(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asShort();
    }

    default List<Short> getAsShortList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asShortList();
    }

    default String getAsString(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asString();
    }

    default List<String> getAsStringList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asStringList();
    }

    default XType getAsType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asType();
    }

    default List<XType> getAsTypeList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        return getAnnotationValue(r5).asTypeList();
    }

    default e getClassName() {
        return getTypeElement().asClassName().getJava$room_compiler_processing();
    }

    String getName();

    String getQualifiedName();

    XType getType();

    default XTypeElement getTypeElement() {
        XTypeElement r5 = getType().getTypeElement();
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalArgumentException("Required value was null.");
    }
}
