package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import com.google.auto.common.b;
import com.google.auto.common.o0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000æ\u0001\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0014\u0001\u0004\u0007\n\r\u0010\u0013\u0016\u0019\u001c\u001f\"%(+.147:\u001a2\u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\b\b\u0000\u0010>*\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002H>0DH\u0000\u001a\u0014\u0010E\u001a\u00020F*\u00020G2\u0006\u0010H\u001a\u00020FH\u0002\u001a\u0012\u0010I\u001a\b\u0012\u0004\u0012\u00020F0J*\u00020GH\u0002\u001a\u001f\u0010K\u001a\u0004\u0018\u00010L*\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010LH\u0002¢\u0006\u0002\u0010M\u001a\u0012\u0010N\u001a\b\u0012\u0004\u0012\u00020L0J*\u00020GH\u0002\u001a\u001f\u0010O\u001a\u0004\u0018\u00010P*\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010PH\u0002¢\u0006\u0002\u0010Q\u001a\u0012\u0010R\u001a\b\u0012\u0004\u0012\u00020P0J*\u00020GH\u0002\u001a\u001f\u0010S\u001a\u0004\u0018\u00010T*\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010TH\u0002¢\u0006\u0002\u0010U\u001a\u0012\u0010V\u001a\b\u0012\u0004\u0012\u00020T0J*\u00020GH\u0002\u001a-\u0010W\u001a\u0002H>\"\f\b\u0000\u0010>*\u0006\u0012\u0002\b\u00030X*\u00020G2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002H>0DH\u0002¢\u0006\u0002\u0010Z\u001a\u001f\u0010[\u001a\u0004\u0018\u00010\\*\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\\H\u0002¢\u0006\u0002\u0010]\u001a\u0012\u0010^\u001a\b\u0012\u0004\u0012\u00020\\0J*\u00020GH\u0002\u001a\u001f\u0010_\u001a\u0004\u0018\u00010`*\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010`H\u0002¢\u0006\u0002\u0010a\u001a\u0012\u0010b\u001a\b\u0012\u0004\u0012\u00020`0J*\u00020GH\u0002\u001a\u001f\u0010c\u001a\u0004\u0018\u00010d*\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010dH\u0002¢\u0006\u0002\u0010e\u001a\u0012\u0010f\u001a\b\u0012\u0004\u0012\u00020d0J*\u00020GH\u0002\u001a\u001f\u0010g\u001a\u0004\u0018\u00010h*\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010hH\u0002¢\u0006\u0002\u0010i\u001a\u0012\u0010j\u001a\b\u0012\u0004\u0012\u00020h0J*\u00020GH\u0002\u001a\u001a\u0010k\u001a\u0004\u0018\u00010l*\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010lH\u0002\u001a\u0012\u0010m\u001a\b\u0012\u0004\u0012\u00020l0J*\u00020GH\u0002\u001a\u0016\u0010n\u001a\u0004\u0018\u00010o*\u00020G2\u0006\u0010A\u001a\u00020BH\u0002\u001a\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020o0J*\u00020G2\u0006\u0010A\u001a\u00020BH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b\"\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\"\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011\"\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014\"\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017\"\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d\"\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 \"\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#\"\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&\"\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)\"\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,\"\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/\"\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105\"\u0010\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0004\n\u0002\u00108\"\u0010\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0004\n\u0002\u0010;¨\u0006q"}, d2 = {"ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR$1;", "ANNOTATION_VALUE_BYTE_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_BYTE_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_BYTE_ARR_VISITOR$1;", "ANNOTATION_VALUE_CHAR_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_CHAR_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_CHAR_ARR_VISITOR$1;", "ANNOTATION_VALUE_DOUBLE_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_DOUBLE_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_DOUBLE_ARR_VISITOR$1;", "ANNOTATION_VALUE_FLOAT_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_FLOAT_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_FLOAT_ARR_VISITOR$1;", "ANNOTATION_VALUE_INT_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_INT_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_INT_ARR_VISITOR$1;", "ANNOTATION_VALUE_LONG_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_LONG_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_LONG_ARR_VISITOR$1;", "ANNOTATION_VALUE_SHORT_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_SHORT_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_SHORT_ARR_VISITOR$1;", "ANNOTATION_VALUE_STRING_ARR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_STRING_ARR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_STRING_ARR_VISITOR$1;", "ANNOTATION_VALUE_TO_BOOLEAN_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BOOLEAN_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BOOLEAN_VISITOR$1;", "ANNOTATION_VALUE_TO_BYTE_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BYTE_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BYTE_VISITOR$1;", "ANNOTATION_VALUE_TO_CHAR_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_CHAR_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_CHAR_VISITOR$1;", "ANNOTATION_VALUE_TO_DOUBLE_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_DOUBLE_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_DOUBLE_VISITOR$1;", "ANNOTATION_VALUE_TO_FLOAT_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_FLOAT_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_FLOAT_VISITOR$1;", "ANNOTATION_VALUE_TO_INT_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_INT_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_INT_VISITOR$1;", "ANNOTATION_VALUE_TO_LONG_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_LONG_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_LONG_VISITOR$1;", "ANNOTATION_VALUE_TO_SHORT_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_SHORT_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_SHORT_VISITOR$1;", "ANNOTATION_VALUE_TO_STRING_VISITOR", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_STRING_VISITOR$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_STRING_VISITOR$1;", "TO_LIST_OF_TYPES", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$TO_LIST_OF_TYPES$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$TO_LIST_OF_TYPES$1;", "TO_TYPE", "androidx/room/compiler/processing/javac/JavacAnnotationBoxKt$TO_TYPE$1", "Landroidx/room/compiler/processing/javac/JavacAnnotationBoxKt$TO_TYPE$1;", "box", "Landroidx/room/compiler/processing/javac/JavacAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljavax/lang/model/element/AnnotationMirror;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "cl", "Ljava/lang/Class;", "getAsBoolean", "", "Ljavax/lang/model/element/AnnotationValue;", "def", "getAsBooleanList", "", "getAsByte", "", "(Ljavax/lang/model/element/AnnotationValue;Ljava/lang/Byte;)Ljava/lang/Byte;", "getAsByteList", "getAsChar", "", "(Ljavax/lang/model/element/AnnotationValue;Ljava/lang/Character;)Ljava/lang/Character;", "getAsCharList", "getAsDouble", "", "(Ljavax/lang/model/element/AnnotationValue;Ljava/lang/Double;)Ljava/lang/Double;", "getAsDoubleList", "getAsEnum", "", "enumClass", "(Ljavax/lang/model/element/AnnotationValue;Ljava/lang/Class;)Ljava/lang/Enum;", "getAsFloat", "", "(Ljavax/lang/model/element/AnnotationValue;Ljava/lang/Float;)Ljava/lang/Float;", "getAsFloatList", "getAsInt", "", "(Ljavax/lang/model/element/AnnotationValue;Ljava/lang/Integer;)Ljava/lang/Integer;", "getAsIntList", "getAsLong", "", "(Ljavax/lang/model/element/AnnotationValue;Ljava/lang/Long;)Ljava/lang/Long;", "getAsLongList", "getAsShort", "", "(Ljavax/lang/model/element/AnnotationValue;Ljava/lang/Short;)Ljava/lang/Short;", "getAsShortList", "getAsString", "", "getAsStringList", "toClassType", "Landroidx/room/compiler/processing/XType;", "toListOfClassTypes", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JavacAnnotationBoxKt {
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR$1 ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_BYTE_ARR_VISITOR$1 ANNOTATION_VALUE_BYTE_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_CHAR_ARR_VISITOR$1 ANNOTATION_VALUE_CHAR_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_DOUBLE_ARR_VISITOR$1 ANNOTATION_VALUE_DOUBLE_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_FLOAT_ARR_VISITOR$1 ANNOTATION_VALUE_FLOAT_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_INT_ARR_VISITOR$1 ANNOTATION_VALUE_INT_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_LONG_ARR_VISITOR$1 ANNOTATION_VALUE_LONG_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_SHORT_ARR_VISITOR$1 ANNOTATION_VALUE_SHORT_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_STRING_ARR_VISITOR$1 ANNOTATION_VALUE_STRING_ARR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BOOLEAN_VISITOR$1 ANNOTATION_VALUE_TO_BOOLEAN_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BYTE_VISITOR$1 ANNOTATION_VALUE_TO_BYTE_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_CHAR_VISITOR$1 ANNOTATION_VALUE_TO_CHAR_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_DOUBLE_VISITOR$1 ANNOTATION_VALUE_TO_DOUBLE_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_FLOAT_VISITOR$1 ANNOTATION_VALUE_TO_FLOAT_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_INT_VISITOR$1 ANNOTATION_VALUE_TO_INT_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_LONG_VISITOR$1 ANNOTATION_VALUE_TO_LONG_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_SHORT_VISITOR$1 ANNOTATION_VALUE_TO_SHORT_VISITOR = null;
    private static final JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_STRING_VISITOR$1 ANNOTATION_VALUE_TO_STRING_VISITOR = null;
    private static final JavacAnnotationBoxKt$TO_LIST_OF_TYPES$1 TO_LIST_OF_TYPES = null;
    private static final JavacAnnotationBoxKt$TO_TYPE$1 TO_TYPE = null;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_INT_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_DOUBLE_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_INT_ARR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_DOUBLE_ARR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_FLOAT_ARR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_CHAR_ARR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_BYTE_ARR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_SHORT_ARR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_LONG_ARR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v17, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$TO_LIST_OF_TYPES$1] */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$TO_TYPE$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_FLOAT_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_CHAR_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BYTE_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_SHORT_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_LONG_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BOOLEAN_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_STRING_VISITOR$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$ANNOTATION_VALUE_STRING_ARR_VISITOR$1] */
    static {
        ANNOTATION_VALUE_TO_INT_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_INT_VISITOR$1();
        ANNOTATION_VALUE_TO_DOUBLE_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_DOUBLE_VISITOR$1();
        ANNOTATION_VALUE_TO_FLOAT_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_FLOAT_VISITOR$1();
        ANNOTATION_VALUE_TO_CHAR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_CHAR_VISITOR$1();
        ANNOTATION_VALUE_TO_BYTE_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BYTE_VISITOR$1();
        ANNOTATION_VALUE_TO_SHORT_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_SHORT_VISITOR$1();
        ANNOTATION_VALUE_TO_LONG_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_LONG_VISITOR$1();
        ANNOTATION_VALUE_TO_BOOLEAN_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BOOLEAN_VISITOR$1();
        ANNOTATION_VALUE_TO_STRING_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_STRING_VISITOR$1();
        ANNOTATION_VALUE_STRING_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_STRING_ARR_VISITOR$1();
        ANNOTATION_VALUE_INT_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_INT_ARR_VISITOR$1();
        ANNOTATION_VALUE_DOUBLE_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_DOUBLE_ARR_VISITOR$1();
        ANNOTATION_VALUE_FLOAT_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_FLOAT_ARR_VISITOR$1();
        ANNOTATION_VALUE_CHAR_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_CHAR_ARR_VISITOR$1();
        ANNOTATION_VALUE_BYTE_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_BYTE_ARR_VISITOR$1();
        ANNOTATION_VALUE_SHORT_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_SHORT_ARR_VISITOR$1();
        ANNOTATION_VALUE_LONG_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_LONG_ARR_VISITOR$1();
        ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR = new JavacAnnotationBoxKt$ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR$1();
        TO_LIST_OF_TYPES = new JavacAnnotationBoxKt$TO_LIST_OF_TYPES$1();
        TO_TYPE = new JavacAnnotationBoxKt$TO_TYPE$1();
    }

    public static /* synthetic */ Object a(LinkedHashMap r5, Object r10, Method r11, Object[] r12) {
        return box$lambda$1(r5, r10, r11, r12);
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BOOLEAN_VISITOR$1 access$getANNOTATION_VALUE_TO_BOOLEAN_VISITOR$p() {
        return ANNOTATION_VALUE_TO_BOOLEAN_VISITOR;
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_BYTE_VISITOR$1 access$getANNOTATION_VALUE_TO_BYTE_VISITOR$p() {
        return ANNOTATION_VALUE_TO_BYTE_VISITOR;
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_CHAR_VISITOR$1 access$getANNOTATION_VALUE_TO_CHAR_VISITOR$p() {
        return ANNOTATION_VALUE_TO_CHAR_VISITOR;
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_DOUBLE_VISITOR$1 access$getANNOTATION_VALUE_TO_DOUBLE_VISITOR$p() {
        return ANNOTATION_VALUE_TO_DOUBLE_VISITOR;
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_FLOAT_VISITOR$1 access$getANNOTATION_VALUE_TO_FLOAT_VISITOR$p() {
        return ANNOTATION_VALUE_TO_FLOAT_VISITOR;
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_INT_VISITOR$1 access$getANNOTATION_VALUE_TO_INT_VISITOR$p() {
        return ANNOTATION_VALUE_TO_INT_VISITOR;
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_LONG_VISITOR$1 access$getANNOTATION_VALUE_TO_LONG_VISITOR$p() {
        return ANNOTATION_VALUE_TO_LONG_VISITOR;
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_SHORT_VISITOR$1 access$getANNOTATION_VALUE_TO_SHORT_VISITOR$p() {
        return ANNOTATION_VALUE_TO_SHORT_VISITOR;
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$ANNOTATION_VALUE_TO_STRING_VISITOR$1 access$getANNOTATION_VALUE_TO_STRING_VISITOR$p() {
        return ANNOTATION_VALUE_TO_STRING_VISITOR;
    }

    public static final /* synthetic */ Enum access$getAsEnum(AnnotationValue r5, Class r10) {
        return getAsEnum(r5, r10);
    }

    public static final /* synthetic */ JavacAnnotationBoxKt$TO_TYPE$1 access$getTO_TYPE$p() {
        return TO_TYPE;
    }

    public static final <T extends Annotation> JavacAnnotationBox<T> box(AnnotationMirror r10, JavacProcessingEnv r11, Class<T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "env");
        Intrinsics.checkNotNullParameter(r12, "cl");
        if (r12.isAnnotation() == false) goto L90;
        Method[] r5 = r12.getDeclaredMethods();
        LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r5.length), 16));
        int r14 = r5.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L88;
        Method r16 = r5[r15];
        AnnotationValue r17 = b.b(r10, r16.getName());
        Class<?> r18 = r16.getReturnType();
        Object r19 = r16.getDefaultValue();
        if (Intrinsics.areEqual(r18, Integer.TYPE) == false) goto L10;
        Object r20 = getAsInt(r17, (Integer) r19);
    L84:
        Pair r21 = TuplesKt.to(r16.getName(), r20);
        r13.put(r21.getFirst(), r21.getSecond());
        r15 = r15 + 1;
        goto L5
    L10:
        if (Intrinsics.areEqual(r18, Double.TYPE) == false) goto L13;
        r20 = getAsDouble(r17, (Double) r19);
        goto L84
    L13:
        if (Intrinsics.areEqual(r18, Float.TYPE) == false) goto L16;
        r20 = getAsFloat(r17, (Float) r19);
        goto L84
    L16:
        if (Intrinsics.areEqual(r18, Character.TYPE) == false) goto L19;
        r20 = getAsChar(r17, (Character) r19);
        goto L84
    L19:
        if (Intrinsics.areEqual(r18, Byte.TYPE) == false) goto L22;
        r20 = getAsByte(r17, (Byte) r19);
        goto L84
    L22:
        if (Intrinsics.areEqual(r18, Short.TYPE) == false) goto L25;
        r20 = getAsShort(r17, (Short) r19);
        goto L84
    L25:
        if (Intrinsics.areEqual(r18, Long.TYPE) == false) goto L28;
        r20 = getAsLong(r17, (Long) r19);
        goto L84
    L28:
        if (Intrinsics.areEqual(r18, Boolean.TYPE) == false) goto L31;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Boolean");
        r20 = Boolean.valueOf(getAsBoolean(r17, ((Boolean) r19).booleanValue()));
        goto L84
    L31:
        if (Intrinsics.areEqual(r18, String.class) == false) goto L34;
        r20 = getAsString(r17, (String) r19);
        goto L84
    L34:
        if (Intrinsics.areEqual(r18, String[].class) == false) goto L37;
        r20 = getAsStringList(r17).toArray(new String[0]);
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        goto L84
    L37:
        if (Intrinsics.areEqual(r18, new Class[0].getClass()) == false) goto L40;
        r20 = toListOfClassTypes(r17, r11);
        goto L84
    L40:
        if (Intrinsics.areEqual(r18, int[].class) == false) goto L43;
        r20 = CollectionsKt.toIntArray(getAsIntList(r17));
        goto L84
    L43:
        if (Intrinsics.areEqual(r18, double[].class) == false) goto L46;
        r20 = CollectionsKt.toDoubleArray(getAsDoubleList(r17));
        goto L84
    L46:
        if (Intrinsics.areEqual(r18, float[].class) == false) goto L49;
        r20 = CollectionsKt.toFloatArray(getAsFloatList(r17));
        goto L84
    L49:
        if (Intrinsics.areEqual(r18, char[].class) == false) goto L52;
        r20 = CollectionsKt.toCharArray(getAsCharList(r17));
        goto L84
    L52:
        if (Intrinsics.areEqual(r18, byte[].class) == false) goto L55;
        r20 = CollectionsKt.toByteArray(getAsByteList(r17));
        goto L84
    L55:
        if (Intrinsics.areEqual(r18, short[].class) == false) goto L58;
        r20 = CollectionsKt.toShortArray(getAsShortList(r17));
        goto L84
    L58:
        if (Intrinsics.areEqual(r18, long[].class) == false) goto L61;
        r20 = CollectionsKt.toLongArray(getAsLongList(r17));
        goto L84
    L61:
        if (Intrinsics.areEqual(r18, boolean[].class) == false) goto L64;
        r20 = CollectionsKt.toBooleanArray(getAsBooleanList(r17));
        goto L84
    L64:
        if (Intrinsics.areEqual(r18, Class.class) == false) goto L69;
        r20 = toClassType(r17, r11);     // Catch: TypeNotPresentException -> L67
    L67:
        r20 = null;
        goto L84
    L69:
        if (r18.isAnnotation() == false) goto L72;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
        r20 = new AnnotationClassVisitor(r11, r18).visit(r17);
        goto L84
    L72:
        if (r18.isArray() == false) goto L77;
        if (r18.getComponentType().isAnnotation() == false) goto L77;
        Class<?> r22 = r18.getComponentType();
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
        r20 = new AnnotationListVisitor(r11, r22).visit(r17);
    L77:
        if (r18.isArray() == false) goto L82;
        if (r18.getComponentType().isEnum() == false) goto L82;
        Class<?> r23 = r18.getComponentType();
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
        r20 = new EnumListVisitor(r23).visit(r17);
    L82:
        if (r18.isEnum() == false) goto L86;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
        r20 = getAsEnum(r17, r18);
        goto L84
    L86:
        throw new UnsupportedOperationException(r18 + " isn't supported");
    L88:
        return new JavacAnnotationBox(Proxy.newProxyInstance(JavacClassGetter.class.getClassLoader(), new Class[]{r12, JavacClassGetter.class}, new a(r13, 0)));
    L90:
        throw new IllegalArgumentException(r12 + " is not annotation");
    }

    private static final Object box$lambda$1(Map r5, Object r10, Method r11, Object[] r12) {
        Intrinsics.checkNotNullParameter(r5, "$map");
        String r13 = r11.getName();
        if (r13 == null) goto L23;
        switch(r13.hashCode()) {
            case -1163839515: goto L19;
            case -195470016: goto L15;
            case 286902658: goto L12;
            case 1744858836: goto L8;
            default: goto L23;
        };
    L8:
        if (r13.equals("getAsAnnotationBox") == false) goto L23;
        return r5.get(r12[0]);
    L12:
        if (r13.equals("getAsType") == false) goto L23;
        return r5.get(r12[0]);
    L15:
        if (r13.equals("getAsTypeList") == false) goto L23;
        return r5.get(r12[0]);
    L19:
        if (r13.equals("getAsAnnotationBoxArray") == false) goto L23;
        return r5.get(r12[0]);
    L23:
        return r5.get(r11.getName());
    }

    private static final boolean getAsBoolean(AnnotationValue r5, boolean r10) {
        Boolean r11 = (Boolean) ANNOTATION_VALUE_TO_BOOLEAN_VISITOR.visit(r5);
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r11.booleanValue();
    }

    private static final List<Boolean> getAsBooleanList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_BOOLEAN_ARR_VISITOR.visit(r5);
    }

    private static final Byte getAsByte(AnnotationValue r5, Byte r10) {
        Byte r11 = (Byte) ANNOTATION_VALUE_TO_BYTE_VISITOR.visit(r5);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static /* synthetic */ Byte getAsByte$default(AnnotationValue r5, Byte r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return getAsByte(r5, r10);
    }

    private static final List<Byte> getAsByteList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_BYTE_ARR_VISITOR.visit(r5);
    }

    private static final Character getAsChar(AnnotationValue r5, Character r10) {
        Character r11 = (Character) ANNOTATION_VALUE_TO_CHAR_VISITOR.visit(r5);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static /* synthetic */ Character getAsChar$default(AnnotationValue r5, Character r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return getAsChar(r5, r10);
    }

    private static final List<Character> getAsCharList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_CHAR_ARR_VISITOR.visit(r5);
    }

    private static final Double getAsDouble(AnnotationValue r5, Double r10) {
        Double r11 = (Double) ANNOTATION_VALUE_TO_DOUBLE_VISITOR.visit(r5);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static /* synthetic */ Double getAsDouble$default(AnnotationValue r5, Double r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return getAsDouble(r5, r10);
    }

    private static final List<Double> getAsDoubleList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_DOUBLE_ARR_VISITOR.visit(r5);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.room.compiler.processing.javac.JavacAnnotationBoxKt$getAsEnum$1] */
    private static final <T extends Enum<?>> T getAsEnum(AnnotationValue r5, final Class<T> r10) {
        return (T) new AnonymousClass1(r10).visit(r5);
    }

    private static final Float getAsFloat(AnnotationValue r5, Float r10) {
        Float r11 = (Float) ANNOTATION_VALUE_TO_FLOAT_VISITOR.visit(r5);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static /* synthetic */ Float getAsFloat$default(AnnotationValue r5, Float r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return getAsFloat(r5, r10);
    }

    private static final List<Float> getAsFloatList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_FLOAT_ARR_VISITOR.visit(r5);
    }

    private static final Integer getAsInt(AnnotationValue r5, Integer r10) {
        Integer r11 = (Integer) ANNOTATION_VALUE_TO_INT_VISITOR.visit(r5);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static /* synthetic */ Integer getAsInt$default(AnnotationValue r5, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return getAsInt(r5, r10);
    }

    private static final List<Integer> getAsIntList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_INT_ARR_VISITOR.visit(r5);
    }

    private static final Long getAsLong(AnnotationValue r5, Long r10) {
        Long r11 = (Long) ANNOTATION_VALUE_TO_LONG_VISITOR.visit(r5);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static /* synthetic */ Long getAsLong$default(AnnotationValue r5, Long r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return getAsLong(r5, r10);
    }

    private static final List<Long> getAsLongList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_LONG_ARR_VISITOR.visit(r5);
    }

    private static final Short getAsShort(AnnotationValue r5, Short r10) {
        Short r11 = (Short) ANNOTATION_VALUE_TO_SHORT_VISITOR.visit(r5);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static /* synthetic */ Short getAsShort$default(AnnotationValue r5, Short r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return getAsShort(r5, r10);
    }

    private static final List<Short> getAsShortList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_SHORT_ARR_VISITOR.visit(r5);
    }

    private static final String getAsString(AnnotationValue r5, String r10) {
        String r11 = (String) ANNOTATION_VALUE_TO_STRING_VISITOR.visit(r5);
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static /* synthetic */ String getAsString$default(AnnotationValue r5, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return getAsString(r5, r10);
    }

    private static final List<String> getAsStringList(AnnotationValue r5) {
        return (List) ANNOTATION_VALUE_STRING_ARR_VISITOR.visit(r5);
    }

    private static final XType toClassType(AnnotationValue r5, JavacProcessingEnv r10) {
        TypeMirror r11 = (TypeMirror) TO_TYPE.visit(r5);
        if (r11 == null) goto L23;
        XNullability r12 = XNullability.UNKNOWN;
        TypeKind r13 = r11.getKind();
        if (r13 != null) goto L7;
        int r14 = -1;
    L9:
        if (r14 != 1) goto L11;
        if (r12 == null) goto L20;
        JavacArrayType r15 = new JavacArrayType(r10, o0.a(r11), r12, null);
    L22:
        return r15;
    L20:
        r15 = new JavacArrayType(r10, o0.a(r11));
        goto L22
    L11:
        if (r14 == 2) goto L15;
        if (r12 == null) goto L25;
        return new DefaultJavacType(r10, r11, r12);
    L25:
        return new DefaultJavacType(r10, r11);
    L15:
        if (r12 == null) goto L27;
        return new JavacDeclaredType(r10, o0.b(r11), r12);
    L27:
        return new JavacDeclaredType(r10, o0.b(r11));
    L7:
        r14 = JavacProcessingEnv.WhenMappings.$EnumSwitchMapping$0[r13.ordinal()];
        goto L9
    L23:
        return null;
    }

    private static final List<XType> toListOfClassTypes(AnnotationValue r5, JavacProcessingEnv r10) {
        Iterable r11 = (Iterable) TO_LIST_OF_TYPES.visit(r5);
        ArrayList r12 = new ArrayList(CollectionsKt.h(r11));
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L24;
        TypeMirror r14 = (TypeMirror) r13.next();
        XNullability r15 = XNullability.UNKNOWN;
        TypeKind r16 = r14.getKind();
        if (r16 != null) goto L8;
        int r17 = -1;
    L10:
        if (r17 != 1) goto L12;
        if (r15 == null) goto L22;
        XType r18 = new JavacArrayType(r10, o0.a(r14), r15, null);
    L23:
        r12.add(r18);
        goto L4
    L22:
        XType r19 = new JavacArrayType(r10, o0.a(r14));
    L19:
        r18 = r19;
        goto L23
    L12:
        if (r17 == 2) goto L16;
        if (r15 == null) goto L15;
        r18 = new DefaultJavacType(r10, r14, r15);
        goto L23
    L15:
        r18 = new DefaultJavacType(r10, r14);
        goto L23
    L16:
        if (r15 == null) goto L18;
        r18 = new JavacDeclaredType(r10, o0.b(r14), r15);
        goto L23
    L18:
        r19 = new JavacDeclaredType(r10, o0.b(r14));
        goto L19
    L8:
        r17 = JavacProcessingEnv.WhenMappings.$EnumSwitchMapping$0[r16.ordinal()];
        goto L10
    L24:
        return r12;
    }
}
