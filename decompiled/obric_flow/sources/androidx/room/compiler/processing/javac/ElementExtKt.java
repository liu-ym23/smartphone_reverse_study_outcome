package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XNullability;
import com.google.auto.common.d0;
import com.google.auto.common.o0;
import com.squareup.javapoet.e;
import com.squareup.javapoet.v;
import com.squareup.javapoet.x;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Types;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\u001a\u001f\u0010\u0017\u001a\u00020\u000b*\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0014*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0000\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"NONNULL_ANNOTATIONS", "", "", "[Ljava/lang/String;", "NULLABLE_ANNOTATIONS", "nullability", "Landroidx/room/compiler/processing/XNullability;", "Ljavax/lang/model/element/Element;", "getNullability", "(Ljavax/lang/model/element/Element;)Landroidx/room/compiler/processing/XNullability;", "suspendOverrides", "", "overrider", "Ljavax/lang/model/element/ExecutableElement;", "overridden", "owner", "Ljavax/lang/model/element/TypeElement;", "typeUtils", "Ljavax/lang/model/util/Types;", "enclosingType", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "hasAnyOf", "annotations", "(Ljavax/lang/model/element/Element;[Ljava/lang/String;)Z", "requireEnclosingType", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ElementExtKt {
    private static final String[] NONNULL_ANNOTATIONS = null;
    private static final String[] NULLABLE_ANNOTATIONS = null;

    static {
        NONNULL_ANNOTATIONS = new String[]{"androidx.annotation.NonNull", "org.jetbrains.annotations.NotNull"};
        NULLABLE_ANNOTATIONS = new String[]{"androidx.annotation.Nullable", "org.jetbrains.annotations.Nullable"};
    }

    public static final JavacTypeElement enclosingType(Element r5, JavacProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        if (d0.e(r5.getEnclosingElement()) == true) goto L7;
        return null;
    L7:
        return r10.wrapTypeElement(d0.b(r5.getEnclosingElement()));
    }

    public static final XNullability getNullability(Element r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.asType().getKind().isPrimitive() == true) goto L12;
        if (hasAnyOf(r5, NONNULL_ANNOTATIONS) == true) goto L12;
        if (hasAnyOf(r5, NULLABLE_ANNOTATIONS) == false) goto L14;
        return XNullability.NULLABLE;
    L14:
        return XNullability.UNKNOWN;
    L12:
        return XNullability.NONNULL;
    }

    private static final boolean hasAnyOf(Element r10, String[] r11) {
        List r12 = r10.getAnnotationMirrors();
        if (r12 != null) goto L5;
    L7:
        Iterator r13 = r12.iterator();
    L9:
        if (r13.hasNext() == false) goto L23;
        TypeElement r5 = d0.b(((AnnotationMirror) r13.next()).getAnnotationType().asElement());
        int r14 = r11.length;
        int r15 = 0;
    L11:
        if (r15 >= r14) goto L9;
        if (r5.getQualifiedName().contentEquals(r11[r15]) == true) goto L14;
        r15 = r15 + 1;
        goto L11
    L14:
        return true;
    L23:
        return false;
    L5:
        if (r12.isEmpty() == false) goto L7;
        return false;
    }

    public static final JavacTypeElement requireEnclosingType(Element r5, JavacProcessingEnv r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "env");
        JavacTypeElement r11 = enclosingType(r5, r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException(("Cannot find required enclosing type for " + r5).toString());
    }

    public static final boolean suspendOverrides(ExecutableElement r10, ExecutableElement r11, TypeElement r12, Types r13) {
        Intrinsics.checkNotNullParameter(r10, "overrider");
        Intrinsics.checkNotNullParameter(r11, "overridden");
        Intrinsics.checkNotNullParameter(r12, "owner");
        Intrinsics.checkNotNullParameter(r13, "typeUtils");
        if (Intrinsics.areEqual(r10.getSimpleName(), r11.getSimpleName()) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10.getEnclosingElement(), r11.getEnclosingElement()) == false) goto L9;
        return false;
    L9:
        if (r11.getModifiers().contains(Modifier.STATIC) == false) goto L12;
        return false;
    L12:
        if (r11.getModifiers().contains(Modifier.PRIVATE) == false) goto L14;
        return false;
    L14:
        TypeElement r14 = r11.getEnclosingElement();
        e r5 = null;
        if ((r14 instanceof TypeElement) == false) goto L17;
        TypeElement r15 = r14;
    L18:
        if (r15 != null) goto L21;
        return false;
    L21:
        if (r13.isSubtype(r13.erasure(r12.asType()), r13.erasure(r15.asType())) == true) goto L23;
        return false;
    L23:
        DeclaredType r16 = o0.b(r12.asType());
        Element r17 = (Element) r10;
        ExecutableType r18 = o0.d(r13.asMemberOf(r16, r17));
        ExecutableType r19 = o0.d(r13.asMemberOf(r16, r17));
        if (r18.getParameterTypes().size() == r19.getParameterTypes().size()) goto L26;
        return false;
    L26:
        x r20 = x.e(Continuation.class);
        x r21 = x.g((TypeMirror) CollectionsKt.last(r18.getParameterTypes()));
        if ((r21 instanceof v) == false) goto L29;
        v r22 = (v) r21;
    L30:
        if (r22 == null) goto L32;
        e r23 = r22.f15021x;
    L34:
        if (Intrinsics.areEqual(r23, r20) == false) goto L58;
        x r24 = x.g((TypeMirror) CollectionsKt.last(r19.getParameterTypes()));
        if ((r24 instanceof v) == false) goto L38;
        v r25 = (v) r24;
    L39:
        if (r25 == null) goto L42;
        r5 = r25.f15021x;
    L42:
        if (Intrinsics.areEqual(r5, r20) == false) goto L56;
        if (r13.isSameType(r13.erasure(TypeMirrorExtKt.extendsBound((TypeMirror) CollectionsKt.single(o0.b((TypeMirror) CollectionsKt.last(r18.getParameterTypes())).getTypeArguments()))), r13.erasure(TypeMirrorExtKt.extendsBound((TypeMirror) CollectionsKt.single(o0.b((TypeMirror) CollectionsKt.last(r18.getParameterTypes())).getTypeArguments())))) == true) goto L47;
        return false;
    L47:
        if (r19.getParameterTypes().size() < 2) goto L54;
        Iterator r26 = CollectionsKt.dropLast(CollectionsKt.zip(r18.getParameterTypes(), r19.getParameterTypes()), 1).iterator();
    L50:
        if (r26.hasNext() == false) goto L54;
        Pair r27 = (Pair) r26.next();
        if (r13.isSameType(r13.erasure((TypeMirror) r27.component1()), r13.erasure((TypeMirror) r27.component2())) == true) goto L50;
        return false;
    L54:
        return true;
    L56:
        throw new IllegalStateException(("Expected " + r5 + " to be " + r20).toString());
    L38:
        r25 = null;
        goto L39
    L58:
        throw new IllegalStateException(("Expected " + r23 + " to be " + r20).toString());
    L32:
        r23 = null;
        goto L34
    L29:
        r22 = null;
        goto L30
    L17:
        r15 = null;
        goto L18
    }
}
