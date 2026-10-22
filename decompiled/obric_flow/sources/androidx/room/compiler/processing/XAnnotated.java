package androidx.room.compiler.processing;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.javapoet.e;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u0004\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&¢\u0006\u0004\b\u0006\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\nH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u00020\u00102\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0018\"\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001a\u001a\u00020\u00102\"\u0010\u0019\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\n0\u0018\"\n\u0012\u0006\b\u0001\u0012\u00020\b0\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001cJ\u001d\u0010\u001a\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0016¢\u0006\u0004\b\u001a\u0010\u001eJ#\u0010\u001f\u001a\u00020\u00102\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0018\"\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ3\u0010\u001f\u001a\u00020\u00102\"\u0010\u0019\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\n0\u0018\"\n\u0012\u0006\b\u0001\u0012\u00020\b0\nH\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ/\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0017¢\u0006\u0004\b \u0010!J/\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\"\u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050$2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010#J-\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b'\u0010!ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006(À\u0006\u0001"}, d2 = {"Landroidx/room/compiler/processing/XAnnotated;", "", "Lcom/squareup/javapoet/e;", "annotationName", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "getAllAnnotations", "()Ljava/util/List;", "", "hasAnnotation", "(Lkotlin/reflect/KClass;)Z", "(Lcom/squareup/javapoet/e;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "", "annotations", "hasAnyAnnotation", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAllAnnotations", "toAnnotationBox", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "requireAnnotation", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface XAnnotated {
    List<XAnnotation> getAllAnnotations();

    default <T extends Annotation> XAnnotationBox<T> getAnnotation(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return (XAnnotationBox) CollectionsKt.firstOrNull(getAnnotations(r5));
    }

    default List<XAnnotation> getAnnotations(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        List<XAnnotation> r10 = getAllAnnotations();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(r5.A, ((XAnnotation) r13).getQualifiedName()) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5);

    default Set<XAnnotation> getAnnotationsAnnotatedWith(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        List<XAnnotation> r10 = getAllAnnotations();
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        XTypeElement r14 = ((XAnnotation) r13).getType().getTypeElement();
        if (r14 == null) goto L8;
        boolean r15 = r14.hasAnnotation(r5);
    L9:
        if (r15 == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        r15 = false;
        goto L9
    L12:
        return CollectionsKt.toSet(r11);
    }

    default boolean hasAllAnnotations(Collection<e> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Collection<e> r10 = r5;
        if (r10.isEmpty() == true) goto L15;
        Iterator<T> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        if (hasAnnotation((e) r11.next()) == true) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    default boolean hasAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return !getAnnotations(r5).isEmpty();
    }

    boolean hasAnnotation(KClass<? extends Annotation> r5);

    boolean hasAnnotationWithPackage(String r5);

    default boolean hasAnyAnnotation(Collection<e> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        Collection<e> r10 = r5;
        if (r10.isEmpty() == true) goto L15;
        Iterator<T> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        if (hasAnnotation((e) r11.next()) == false) goto L7;
        return true;
    L16:
        return false;
    L15:
        return false;
    }

    default XAnnotation requireAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        XAnnotation r10 = getAnnotation(r5);
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    @Deprecated(message = "Use getAnnotation(not repeatable) or getAnnotations (repeatable)", replaceWith = @ReplaceWith(expression = "getAnnotation(annotation)", imports = {}))
    default <T extends Annotation> XAnnotationBox<T> toAnnotationBox(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return getAnnotation(r5);
    }

    default XAnnotation getAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return (XAnnotation) CollectionsKt.firstOrNull(getAnnotations(r5));
    }

    default <T extends Annotation> XAnnotationBox<T> requireAnnotation(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        XAnnotationBox<T> r10 = getAnnotation(r5);
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException(("Cannot find required annotation " + r5).toString());
    }

    default boolean hasAllAnnotations(e... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (hasAnnotation(r5[r11]) == false) goto L12;
        r11 = r11 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    default boolean hasAnyAnnotation(e... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        if (hasAnnotation(r5[r11]) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    default boolean hasAllAnnotations(KClass<? extends Annotation>... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (hasAnnotation(r5[r11]) == false) goto L12;
        r11 = r11 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    default boolean hasAnyAnnotation(KClass<? extends Annotation>... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L11;
        if (hasAnnotation(r5[r11]) == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }
}
