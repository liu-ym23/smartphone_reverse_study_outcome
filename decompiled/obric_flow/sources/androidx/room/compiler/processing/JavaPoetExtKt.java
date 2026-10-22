package androidx.room.compiler.processing;

import com.squareup.javapoet.a;
import com.squareup.javapoet.b;
import com.squareup.javapoet.e;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import com.squareup.javapoet.y;
import java.util.Arrays;
import java.util.Iterator;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0019\u0010\u0016\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\u0010H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u00020\u0010*\u00020\u0010H\u0000¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u0013\u0010\u001b\u001a\u00020\u0010*\u00020\u0010H\u0000¢\u0006\u0004\b\u001b\u0010\u0019\"\u001e\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/room/compiler/processing/XAnnotation;", "Lcom/squareup/javapoet/b;", "toAnnotationSpec", "(Landroidx/room/compiler/processing/XAnnotation;)Lcom/squareup/javapoet/b;", "Lcom/squareup/javapoet/a;", "Landroidx/room/compiler/processing/XAnnotationValue;", "annotationValue", "", "addAnnotationValue", "(Lcom/squareup/javapoet/a;Landroidx/room/compiler/processing/XAnnotationValue;)V", "", "c", "", "characterLiteralWithoutSingleQuotes", "(C)Ljava/lang/String;", "Ljavax/lang/model/type/TypeMirror;", "Lcom/squareup/javapoet/x;", "safeTypeName", "(Ljavax/lang/model/type/TypeMirror;)Lcom/squareup/javapoet/x;", "Lcom/squareup/javapoet/y;", "Landroidx/room/compiler/processing/XElement;", "element", "addOriginatingElement", "(Lcom/squareup/javapoet/y;Landroidx/room/compiler/processing/XElement;)Lcom/squareup/javapoet/y;", "rawTypeName", "(Lcom/squareup/javapoet/x;)Lcom/squareup/javapoet/x;", "tryUnbox", "tryBox", "Lcom/squareup/javapoet/e;", "Lcom/squareup/kotlinpoet/javapoet/JClassName;", "JAVA_NONE_TYPE_NAME", "Lcom/squareup/javapoet/e;", "getJAVA_NONE_TYPE_NAME", "()Lcom/squareup/javapoet/e;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class JavaPoetExtKt {
    private static final e JAVA_NONE_TYPE_NAME = null;

    static {
        JAVA_NONE_TYPE_NAME = e.o("androidx.room.compiler.processing.error", "NotAType", new String[0]);
    }

    private static final void addAnnotationValue(a r5, XAnnotationValue r10) {
        if (r10.getValue() == null) goto L35;
        if (SourceVersion.isName(r10.getName()) == false) goto L33;
        if (r10.hasListValue() == false) goto L13;
        Iterator<T> r11 = r10.asAnnotationValueList().iterator();
    L10:
        if (r11.hasNext() == false) goto L43;
        addAnnotationValue(r5, (XAnnotationValue) r11.next());
        goto L10
    L43:
        return;
    L13:
        if (r10.hasAnnotationValue() == false) goto L16;
        r5.a(r10.getName(), "$L", new Object[]{toAnnotationSpec(r10.asAnnotation())});
        return;
    L16:
        if (r10.hasEnumValue() == false) goto L19;
        r5.a(r10.getName(), "$T.$L", new Object[]{r10.asEnum().getEnclosingElement().asClassName().getJava$room_compiler_processing(), r10.asEnum().getName()});
        return;
    L19:
        if (r10.hasTypeValue() == false) goto L22;
        r5.a(r10.getName(), "$T.class", new Object[]{r10.asType().asTypeName().getJava$room_compiler_processing()});
        return;
    L22:
        if (r10.hasStringValue() == false) goto L25;
        r5.a(r10.getName(), "$S", new Object[]{r10.asString()});
        return;
    L25:
        if (r10.hasFloatValue() == false) goto L28;
        r5.a(r10.getName(), "$Lf", new Object[]{Float.valueOf(r10.asFloat())});
        return;
    L28:
        if (r10.hasCharValue() == false) goto L30;
        r5.a(r10.getName(), "'$L'", new Object[]{characterLiteralWithoutSingleQuotes(r10.asChar())});
        return;
    L30:
        r5.a(r10.getName(), "$L", new Object[]{r10.getValue()});
        return;
    L33:
        throw new IllegalArgumentException(("not a valid name: " + r10.getName()).toString());
    L35:
        throw new IllegalArgumentException(("value == null, constant non-null value expected for " + r10.getName()).toString());
    }

    public static final y addOriginatingElement(y r5, XElement r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "element");
        Element r11 = XElementKt.originatingElementForPoet(r10);
        if (r11 == null) goto L5;
        r5.f15051p.add(r11);
    L5:
        return r5;
    }

    private static final String characterLiteralWithoutSingleQuotes(char r5) {
        if (r5 != '\b') goto L6;
        return "\\b";
    L6:
        if (r5 != '\t') goto L9;
        return "\\t";
    L9:
        if (r5 != '\n') goto L12;
        return "\\n";
    L12:
        if (r5 != '\f') goto L15;
        return "\\u000c";
    L15:
        if (r5 != '\r') goto L18;
        return "\\r";
    L18:
        if (r5 != '\"') goto L21;
        return "\"";
    L21:
        if (r5 != '\'') goto L24;
        return "\\'";
    L24:
        if (r5 != '\\') goto L27;
        return "\\\\";
    L27:
        if (Character.isISOControl(r5) == false) goto L30;
        StringCompanionObject r10 = StringCompanionObject.INSTANCE;
        return String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(r5)}, 1));
    L30:
        return Character.toString(r5);
    }

    public static final e getJAVA_NONE_TYPE_NAME() {
        return JAVA_NONE_TYPE_NAME;
    }

    public static final x rawTypeName(x r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof v) == true) goto L5;
        return r5;
    L5:
        return ((v) r5).f15021x;
    }

    public static final x safeTypeName(TypeMirror r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getKind() != TypeKind.NONE) goto L6;
        return JAVA_NONE_TYPE_NAME;
    L6:
        return x.g(r5);
    }

    public static final b toAnnotationSpec(XAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        a r10 = b.a(r5.getClassName());
        Iterator<T> r11 = r5.getAnnotationValues().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        addAnnotationValue(r10, (XAnnotationValue) r11.next());
        goto L4
    L7:
        return r10.b();
    }

    public static final x tryBox(x r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.b();
    L8:
        return r5;
    }

    public static final x tryUnbox(x r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.j() == true) goto L5;
        return r5;
    L5:
        return r5.m();
    }
}
