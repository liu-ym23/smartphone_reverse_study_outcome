package androidx.room.compiler.processing.compat;

import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationValue;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XFiler;
import androidx.room.compiler.processing.XMessager;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XRoundEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XVariableElement;
import androidx.room.compiler.processing.javac.DefaultJavacType;
import androidx.room.compiler.processing.javac.JavacAnnotation;
import androidx.room.compiler.processing.javac.JavacAnnotationValue;
import androidx.room.compiler.processing.javac.JavacArrayType;
import androidx.room.compiler.processing.javac.JavacDeclaredType;
import androidx.room.compiler.processing.javac.JavacElement;
import androidx.room.compiler.processing.javac.JavacExecutableElement;
import androidx.room.compiler.processing.javac.JavacExecutableType;
import androidx.room.compiler.processing.javac.JavacFiler;
import androidx.room.compiler.processing.javac.JavacProcessingEnv;
import androidx.room.compiler.processing.javac.JavacProcessingEnvMessager;
import androidx.room.compiler.processing.javac.JavacRoundEnv;
import androidx.room.compiler.processing.javac.JavacType;
import androidx.room.compiler.processing.javac.JavacTypeElement;
import androidx.room.compiler.processing.javac.JavacVariableElement;
import androidx.room.compiler.processing.ksp.KspAnnotation;
import androidx.room.compiler.processing.ksp.KspAnnotationValue;
import androidx.room.compiler.processing.ksp.KspElement;
import androidx.room.compiler.processing.ksp.KspExecutableElement;
import androidx.room.compiler.processing.ksp.KspExecutableParameterElement;
import androidx.room.compiler.processing.ksp.KspExecutableType;
import androidx.room.compiler.processing.ksp.KspFieldElement;
import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import androidx.room.compiler.processing.ksp.KspType;
import androidx.room.compiler.processing.ksp.KspTypeElement;
import androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement;
import com.google.auto.common.o0;
import il.a;
import il.b;
import il.c;
import il.g;
import il.j;
import il.l;
import il.p;
import il.t;
import il.u;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0006\u001a\u00020\t*\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\nJ\u0013\u0010\u0006\u001a\u00020\f*\u00020\u000bH\u0007¢\u0006\u0004\b\u0006\u0010\rJ\u0013\u0010\u0006\u001a\u00020\u000f*\u00020\u000eH\u0007¢\u0006\u0004\b\u0006\u0010\u0010J\u0013\u0010\u0006\u001a\u00020\u0012*\u00020\u0011H\u0007¢\u0006\u0004\b\u0006\u0010\u0013J\u0013\u0010\u0006\u001a\u00020\u0015*\u00020\u0014H\u0007¢\u0006\u0004\b\u0006\u0010\u0016J\u0013\u0010\u0006\u001a\u00020\u0018*\u00020\u0017H\u0007¢\u0006\u0004\b\u0006\u0010\u0019J\u0013\u0010\u0006\u001a\u00020\u001b*\u00020\u001aH\u0007¢\u0006\u0004\b\u0006\u0010\u001cJ\u0013\u0010\u0006\u001a\u00020\u001e*\u00020\u001dH\u0007¢\u0006\u0004\b\u0006\u0010\u001fJ\u0013\u0010\u0006\u001a\u00020!*\u00020 H\u0007¢\u0006\u0004\b\u0006\u0010\"J\u0013\u0010\u0006\u001a\u00020$*\u00020#H\u0007¢\u0006\u0004\b\u0006\u0010%J\u0013\u0010\u0006\u001a\u00020'*\u00020&H\u0007¢\u0006\u0004\b\u0006\u0010(J\u001b\u0010*\u001a\u00020\u0011*\u00020\u00122\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010+J\u001b\u0010*\u001a\u00020\u0014*\u00020\u00152\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010,J\u001b\u0010*\u001a\u00020\u0017*\u00020\u00182\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010-J\u001b\u0010*\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010.J\u001b\u0010*\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010/J#\u0010*\u001a\u00020 *\u00020!2\u0006\u00100\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u00101J\u001b\u0010*\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u00102J\u0013\u0010*\u001a\u00020\u000b*\u00020\fH\u0007¢\u0006\u0004\b*\u00103J\u001b\u0010*\u001a\u00020#*\u00020$2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u00104J\u0013\u00106\u001a\u000205*\u00020\u0014H\u0007¢\u0006\u0004\b6\u00107J\u0013\u00106\u001a\u000208*\u00020\u0017H\u0007¢\u0006\u0004\b6\u00109J\u0013\u00106\u001a\u00020;*\u00020:H\u0007¢\u0006\u0004\b6\u0010<J\u0013\u00106\u001a\u00020>*\u00020=H\u0007¢\u0006\u0004\b6\u0010?J\u0013\u00106\u001a\u00020@*\u00020\u001dH\u0007¢\u0006\u0004\b6\u0010AJ\u0013\u00106\u001a\u00020B*\u00020 H\u0007¢\u0006\u0004\b6\u0010CJ\u0013\u00106\u001a\u00020D*\u00020#H\u0007¢\u0006\u0004\b6\u0010EJ\u001b\u0010*\u001a\u00020\u0014*\u0002052\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010FJ\u001b\u0010*\u001a\u00020\u0017*\u0002082\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010GJ\u001b\u0010*\u001a\u00020\u001a*\u00020>2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010HJ\u001b\u0010*\u001a\u00020\u001a*\u00020;2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010IJ\u001b\u0010*\u001a\u00020\u001d*\u00020@2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010JJ\u001b\u0010*\u001a\u00020 *\u00020B2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010KJ\u001b\u0010*\u001a\u00020#*\u00020D2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010LJ\u0013\u0010M\u001a\u00020\u0004*\u00020#H\u0007¢\u0006\u0004\bM\u0010NJ\u0013\u0010M\u001a\u00020\u0004*\u00020\u0011H\u0007¢\u0006\u0004\bM\u0010OJ\u0013\u0010M\u001a\u00020\u0004*\u00020\u001dH\u0007¢\u0006\u0004\bM\u0010PJ\u0013\u0010M\u001a\u00020\u0004*\u00020 H\u0007¢\u0006\u0004\bM\u0010QJ\u0013\u0010M\u001a\u00020\u0004*\u00020&H\u0007¢\u0006\u0004\bM\u0010R¨\u0006S"}, d2 = {"Landroidx/room/compiler/processing/compat/XConverters;", "", "<init>", "()V", "Landroidx/room/compiler/processing/XProcessingEnv;", "Ljavax/annotation/processing/ProcessingEnvironment;", "toJavac", "(Landroidx/room/compiler/processing/XProcessingEnv;)Ljavax/annotation/processing/ProcessingEnvironment;", "Landroidx/room/compiler/processing/XRoundEnv;", "Ljavax/annotation/processing/RoundEnvironment;", "(Landroidx/room/compiler/processing/XRoundEnv;)Ljavax/annotation/processing/RoundEnvironment;", "Landroidx/room/compiler/processing/XMessager;", "Ljavax/annotation/processing/Messager;", "(Landroidx/room/compiler/processing/XMessager;)Ljavax/annotation/processing/Messager;", "Landroidx/room/compiler/processing/XFiler;", "Ljavax/annotation/processing/Filer;", "(Landroidx/room/compiler/processing/XFiler;)Ljavax/annotation/processing/Filer;", "Landroidx/room/compiler/processing/XElement;", "Ljavax/lang/model/element/Element;", "(Landroidx/room/compiler/processing/XElement;)Ljavax/lang/model/element/Element;", "Landroidx/room/compiler/processing/XTypeElement;", "Ljavax/lang/model/element/TypeElement;", "(Landroidx/room/compiler/processing/XTypeElement;)Ljavax/lang/model/element/TypeElement;", "Landroidx/room/compiler/processing/XExecutableElement;", "Ljavax/lang/model/element/ExecutableElement;", "(Landroidx/room/compiler/processing/XExecutableElement;)Ljavax/lang/model/element/ExecutableElement;", "Landroidx/room/compiler/processing/XVariableElement;", "Ljavax/lang/model/element/VariableElement;", "(Landroidx/room/compiler/processing/XVariableElement;)Ljavax/lang/model/element/VariableElement;", "Landroidx/room/compiler/processing/XAnnotation;", "Ljavax/lang/model/element/AnnotationMirror;", "(Landroidx/room/compiler/processing/XAnnotation;)Ljavax/lang/model/element/AnnotationMirror;", "Landroidx/room/compiler/processing/XAnnotationValue;", "Ljavax/lang/model/element/AnnotationValue;", "(Landroidx/room/compiler/processing/XAnnotationValue;)Ljavax/lang/model/element/AnnotationValue;", "Landroidx/room/compiler/processing/XType;", "Ljavax/lang/model/type/TypeMirror;", "(Landroidx/room/compiler/processing/XType;)Ljavax/lang/model/type/TypeMirror;", "Landroidx/room/compiler/processing/XExecutableType;", "Ljavax/lang/model/type/ExecutableType;", "(Landroidx/room/compiler/processing/XExecutableType;)Ljavax/lang/model/type/ExecutableType;", "env", "toXProcessing", "(Ljavax/lang/model/element/Element;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XElement;", "(Ljavax/lang/model/element/TypeElement;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XTypeElement;", "(Ljavax/lang/model/element/ExecutableElement;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XExecutableElement;", "(Ljavax/lang/model/element/VariableElement;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XVariableElement;", "(Ljavax/lang/model/element/AnnotationMirror;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XAnnotation;", "method", "(Ljavax/lang/model/element/AnnotationValue;Ljavax/lang/model/element/ExecutableElement;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XAnnotationValue;", "(Ljavax/annotation/processing/Filer;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XFiler;", "(Ljavax/annotation/processing/Messager;)Landroidx/room/compiler/processing/XMessager;", "(Ljavax/lang/model/type/TypeMirror;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XType;", "Lil/c;", "toKS", "(Landroidx/room/compiler/processing/XTypeElement;)Lil/c;", "Lil/g;", "(Landroidx/room/compiler/processing/XExecutableElement;)Lil/g;", "Landroidx/room/compiler/processing/XFieldElement;", "Lil/l;", "(Landroidx/room/compiler/processing/XFieldElement;)Lil/l;", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "Lil/u;", "(Landroidx/room/compiler/processing/XExecutableParameterElement;)Lil/u;", "Lil/b;", "(Landroidx/room/compiler/processing/XAnnotation;)Lil/b;", "Lil/t;", "(Landroidx/room/compiler/processing/XAnnotationValue;)Lil/t;", "Lil/p;", "(Landroidx/room/compiler/processing/XType;)Lil/p;", "(Lil/c;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XTypeElement;", "(Lil/g;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XExecutableElement;", "(Lil/u;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XVariableElement;", "(Lil/l;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XVariableElement;", "(Lil/b;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XAnnotation;", "(Lil/t;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XAnnotationValue;", "(Lil/p;Landroidx/room/compiler/processing/XProcessingEnv;)Landroidx/room/compiler/processing/XType;", "getProcessingEnv", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/XProcessingEnv;", "(Landroidx/room/compiler/processing/XElement;)Landroidx/room/compiler/processing/XProcessingEnv;", "(Landroidx/room/compiler/processing/XAnnotation;)Landroidx/room/compiler/processing/XProcessingEnv;", "(Landroidx/room/compiler/processing/XAnnotationValue;)Landroidx/room/compiler/processing/XProcessingEnv;", "(Landroidx/room/compiler/processing/XExecutableType;)Landroidx/room/compiler/processing/XProcessingEnv;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class XConverters {
    public static final XConverters INSTANCE = null;

    static {
        INSTANCE = new XConverters();
    }

    private XConverters() {
    }

    @Deprecated(message = "This will be removed in a future version of XProcessing.")
    @JvmStatic
    public static final XProcessingEnv getProcessingEnv(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof JavacType) == false) goto L6;
        return ((JavacType) r5).getEnv$room_compiler_processing();
    L6:
        if ((r5 instanceof KspType) == false) goto L10;
        return ((KspType) r5).getEnv();
    L10:
        throw new IllegalStateException(("Unexpected type: " + r5).toString());
    }

    @JvmStatic
    public static final ProcessingEnvironment toJavac(XProcessingEnv r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacProcessingEnv) r5).getDelegate();
    }

    @JvmStatic
    public static final c toKS(XTypeElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ((KspTypeElement) r5).getDeclaration();
        return null;
    }

    @JvmStatic
    public static final XElement toXProcessing(Element r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        if ((r5 instanceof TypeElement) == false) goto L6;
        return toXProcessing((TypeElement) r5, r10);
    L6:
        if ((r5 instanceof ExecutableElement) == false) goto L9;
        return toXProcessing((ExecutableElement) r5, r10);
    L9:
        if ((r5 instanceof VariableElement) == false) goto L13;
        return toXProcessing((VariableElement) r5, r10);
    L13:
        throw new IllegalStateException(("Don't know how to convert element of type '" + Reflection.getOrCreateKotlinClass(r5.getClass()) + "' to a XElement").toString());
    }

    @JvmStatic
    public static final RoundEnvironment toJavac(XRoundEnv r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacRoundEnv) r5).getDelegate();
    }

    @JvmStatic
    public static final g toKS(XExecutableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof KspExecutableElement) == false) goto L7;
        ((KspExecutableElement) r5).getDeclaration();
        return null;
    L7:
        if ((r5 instanceof KspSyntheticPropertyMethodElement) == false) goto L11;
        throw new IllegalStateException("Kotlin properties don't have getters/setters in KSP");
    L11:
        throw new IllegalStateException(("Don't know how to convert element of type '" + Reflection.getOrCreateKotlinClass(r5.getClass()) + "' to KSP").toString());
    }

    @JvmStatic
    public static final Messager toJavac(XMessager r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacProcessingEnvMessager) r5).getDelegate();
    }

    @Deprecated(message = "This will be removed in a future version of XProcessing.")
    @JvmStatic
    public static final XProcessingEnv getProcessingEnv(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof JavacElement) == false) goto L6;
        return ((JavacElement) r5).getEnv$room_compiler_processing();
    L6:
        if ((r5 instanceof KspElement) == false) goto L10;
        return ((KspElement) r5).getEnv$room_compiler_processing();
    L10:
        throw new IllegalStateException(("Unexpected element: " + r5).toString());
    }

    @JvmStatic
    public static final Filer toJavac(XFiler r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacFiler) r5).getDelegate();
    }

    @JvmStatic
    public static final Element toJavac(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacElement) r5).getElement();
    }

    @JvmStatic
    public static final TypeElement toJavac(XTypeElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacTypeElement) r5).m57getElement();
    }

    @JvmStatic
    public static final XTypeElement toXProcessing(TypeElement r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return ((JavacProcessingEnv) r10).wrapTypeElement(r5);
    }

    @Deprecated(message = "This will be removed in a future version of XProcessing.")
    @JvmStatic
    public static final XProcessingEnv getProcessingEnv(XAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof JavacAnnotation) == false) goto L6;
        return ((JavacAnnotation) r5).getEnv();
    L6:
        if ((r5 instanceof KspAnnotation) == false) goto L10;
        return ((KspAnnotation) r5).getEnv();
    L10:
        throw new IllegalStateException(("Unexpected annotation type: " + r5).toString());
    }

    @JvmStatic
    public static final ExecutableElement toJavac(XExecutableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacExecutableElement) r5).m56getElement();
    }

    @JvmStatic
    public static final l toKS(XFieldElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ((KspFieldElement) r5).getDeclaration();
        return null;
    }

    @JvmStatic
    public static final XExecutableElement toXProcessing(ExecutableElement r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return ((JavacProcessingEnv) r10).wrapExecutableElement(r5);
    }

    @JvmStatic
    public static final VariableElement toJavac(XVariableElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacVariableElement) r5).m59getElement();
    }

    @JvmStatic
    public static final u toKS(XExecutableParameterElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        a r10 = ((KspExecutableParameterElement) r5).getDeclaration();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.google.devtools.ksp.symbol.KSValueParameter");
        if (r10 != null) goto L7;
        return null;
    L7:
        throw new ClassCastException();
    }

    @JvmStatic
    public static final XVariableElement toXProcessing(VariableElement r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return ((JavacProcessingEnv) r10).wrapVariableElement(r5);
    }

    @JvmStatic
    public static final AnnotationMirror toJavac(XAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacAnnotation) r5).getMirror();
    }

    @JvmStatic
    public static final b toKS(XAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ((KspAnnotation) r5).getKsAnnotated();
        return null;
    }

    @JvmStatic
    public static final XAnnotation toXProcessing(AnnotationMirror r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return new JavacAnnotation((JavacProcessingEnv) r10, r5);
    }

    @Deprecated(message = "This will be removed in a future version of XProcessing.")
    @JvmStatic
    public static final XProcessingEnv getProcessingEnv(XAnnotationValue r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof JavacAnnotationValue) == false) goto L6;
        return ((JavacAnnotationValue) r5).getEnv();
    L6:
        if ((r5 instanceof KspAnnotationValue) == false) goto L10;
        return ((KspAnnotationValue) r5).getEnv();
    L10:
        throw new IllegalStateException(("Unexpected annotation value: " + r5).toString());
    }

    @JvmStatic
    public static final AnnotationValue toJavac(XAnnotationValue r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacAnnotationValue) r5).getAnnotationValue();
    }

    @JvmStatic
    public static final t toKS(XAnnotationValue r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ((KspAnnotationValue) r5).getValueArgument();
        return null;
    }

    @JvmStatic
    public static final XAnnotationValue toXProcessing(AnnotationValue r10, ExecutableElement r11, XProcessingEnv r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "method");
        Intrinsics.checkNotNullParameter(r12, "env");
        XExecutableElement r13 = toXProcessing(r11, r12);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.room.compiler.processing.XMethodElement");
        return new JavacAnnotationValue((JavacProcessingEnv) r12, (XMethodElement) r13, r10, null, null, 24, null);
    }

    @JvmStatic
    public static final TypeMirror toJavac(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacType) r5).mo55getTypeMirror();
    }

    @JvmStatic
    public static final p toKS(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ((KspType) r5).getKsType();
        return null;
    }

    @JvmStatic
    public static final ExecutableType toJavac(XExecutableType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ((JavacExecutableType) r5).getExecutableType();
    }

    @Deprecated(message = "This will be removed in a future version of XProcessing.")
    @JvmStatic
    public static final XProcessingEnv getProcessingEnv(XExecutableType r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof JavacExecutableType) == false) goto L6;
        return ((JavacExecutableType) r5).getEnv();
    L6:
        if ((r5 instanceof KspExecutableType) == false) goto L10;
        return ((KspExecutableType) r5).getEnv();
    L10:
        throw new IllegalStateException(("Unexpected executable type: " + r5).toString());
    }

    @JvmStatic
    public static final XFiler toXProcessing(Filer r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return new JavacFiler((JavacProcessingEnv) r10, r5);
    }

    @JvmStatic
    public static final XMessager toXProcessing(Messager r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new JavacProcessingEnvMessager(r5);
    }

    @JvmStatic
    public static final XType toXProcessing(TypeMirror r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        JavacProcessingEnv r11 = (JavacProcessingEnv) r10;
        TypeKind r12 = r5.getKind();
        if (r12 != null) goto L5;
        int r13 = -1;
    L7:
        if (r13 == 1) goto L13;
        if (r13 == 2) goto L15;
        return new DefaultJavacType(r11, r5);
    L15:
        return new JavacDeclaredType(r11, o0.b(r5));
    L13:
        return new JavacArrayType(r11, o0.a(r5));
    L5:
        r13 = JavacProcessingEnv.WhenMappings.$EnumSwitchMapping$0[r12.ordinal()];
        goto L7
    }

    @JvmStatic
    public static final XTypeElement toXProcessing(c r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return ((KspProcessingEnv) r10).wrapClassDeclaration(r5);
    }

    @JvmStatic
    public static final XExecutableElement toXProcessing(g r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return KspExecutableElement.Companion.create((KspProcessingEnv) r10, r5);
    }

    @JvmStatic
    public static final XVariableElement toXProcessing(u r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return KspExecutableParameterElement.Companion.create((KspProcessingEnv) r10, r5);
    }

    @JvmStatic
    public static final XVariableElement toXProcessing(l r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return KspFieldElement.Companion.create((KspProcessingEnv) r10, r5);
    }

    @JvmStatic
    public static final XAnnotation toXProcessing(b r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return new KspAnnotation((KspProcessingEnv) r10, r5);
    }

    @JvmStatic
    public static final XAnnotationValue toXProcessing(t r10, XProcessingEnv r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "env");
        j r5 = r10.getParent();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.google.devtools.ksp.symbol.KSAnnotation");
        if (r5 != null) goto L7;
        XAnnotation r12 = toXProcessing(null, r11);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.room.compiler.processing.ksp.KspAnnotation");
        KspAnnotation r13 = (KspAnnotation) r12;
        return new KspAnnotationValue((KspProcessingEnv) r11, r13, r13.getType(), r10, null, 16, null);
    L7:
        throw new ClassCastException();
    }

    @JvmStatic
    public static final XType toXProcessing(p r5, XProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        return ((KspProcessingEnv) r10).wrap(r5, true);
    }
}
