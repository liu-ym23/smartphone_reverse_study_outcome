package androidx.room.compiler.processing.javac;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.InternalXAnnotated;
import androidx.room.compiler.processing.InternalXAnnotationKt;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEquality;
import com.google.auto.common.d0;
import com.google.auto.common.u0;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J>\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0 0\u001d\"\b\b\u0000\u0010!*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$2\u0010\u0010%\u001a\f\u0012\u0006\b\u0001\u0012\u00020\"\u0018\u00010$H\u0016J*\u0010&\u001a\u00020\u001a2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0$2\u0010\u0010%\u001a\f\u0012\u0006\b\u0001\u0012\u00020\"\u0018\u00010$H\u0016J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\u001aH\u0016R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R%\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00150\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Landroidx/room/compiler/processing/javac/JavacElement;", "Landroidx/room/compiler/processing/XElement;", "Landroidx/room/compiler/processing/XEquality;", "Landroidx/room/compiler/processing/InternalXAnnotated;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Ljavax/lang/model/element/Element;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/Element;)V", "docComment", "", "getDocComment", "()Ljava/lang/String;", "docComment$delegate", "Lkotlin/Lazy;", "getElement", "()Ljavax/lang/model/element/Element;", "getEnv$room_compiler_processing", "()Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "equalityItems", "", "", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems$delegate", "equals", "", "other", "getAllAnnotations", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAnnotations", "Landroidx/room/compiler/processing/XAnnotationBox;", ExifInterface.GPS_DIRECTION_TRUE, "", "annotation", "Lkotlin/reflect/KClass;", "containerAnnotation", "hasAnnotation", "hasAnnotationWithPackage", "pkg", "hashCode", "", "kindName", "toString", "validate", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavacElement implements XElement, XEquality, InternalXAnnotated {
    private final Lazy docComment$delegate;
    private final Element element;
    private final JavacProcessingEnv env;
    private final Lazy equalityItems$delegate;

    public JavacElement(JavacProcessingEnv r5, Element r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        this.env = r5;
        this.element = r10;
        this.equalityItems$delegate = LazyKt.lazy(new JavacElement$equalityItems$2(this));
        this.docComment$delegate = LazyKt.lazy(new JavacElement$docComment$2(this));
    }

    public boolean equals(Object r5) {
        return XEquality.Companion.equals(this, r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAllAnnotations() {
        List r5 = getElement().getAnnotationMirrors();
        ArrayList r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        AnnotationMirror r12 = (AnnotationMirror) r11.next();
        r10.add(new JavacAnnotation(this.env, r12));
        goto L4
    L6:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r10.iterator();
    L8:
        if (r14.hasNext() == false) goto L13;
        JavacAnnotation r15 = (JavacAnnotation) r14.next();
        List<XAnnotation> r16 = InternalXAnnotationKt.unwrapRepeatedAnnotationsFromContainer(r15);
        if (r16 != null) goto L12;
        r16 = CollectionsKt.listOf(r15);
    L12:
        CollectionsKt.a(r13, r16);
        goto L8
    L13:
        return r13;
    }

    @Override // androidx.room.compiler.processing.InternalXAnnotated
    public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5, KClass<? extends Annotation> r10) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        if (r10 == null) goto L10;
        AnnotationMirror r11 = (AnnotationMirror) d0.c(getElement(), JvmClassMappingKt.getJavaClass(r10)).orNull();
        if (r11 == null) goto L10;
        JavacAnnotationBox r12 = JavacAnnotationBoxKt.box(r11, this.env, JvmClassMappingKt.getJavaClass(r10));
        if (r12 == null) goto L10;
        return ArraysKt.toList(r12.getAsAnnotationBoxArray("value"));
    L10:
        AnnotationMirror r13 = (AnnotationMirror) d0.c(getElement(), JvmClassMappingKt.getJavaClass(r5)).orNull();
        if (r13 == null) goto L18;
        JavacAnnotationBox r14 = JavacAnnotationBoxKt.box(r13, this.env, JvmClassMappingKt.getJavaClass(r5));
        if (r14 == null) goto L18;
        List<XAnnotationBox<T>> r15 = CollectionsKt.listOf(r14);
        if (r15 == null) goto L18;
        return r15;
    L18:
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getDocComment() {
        return (String) this.docComment$delegate.getValue();
    }

    public Element getElement() {
        return this.element;
    }

    public final JavacProcessingEnv getEnv$room_compiler_processing() {
        return this.env;
    }

    @Override // androidx.room.compiler.processing.XEquality
    public final Object[] getEqualityItems() {
        return (Object[]) this.equalityItems$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.InternalXAnnotated
    public boolean hasAnnotation(KClass<? extends Annotation> r5, KClass<? extends Annotation> r10) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        if (d0.c(getElement(), JvmClassMappingKt.getJavaClass(r5)).isPresent() == true) goto L9;
        if (r10 != null) goto L6;
    L8:
        return false;
    L6:
        if (d0.c(getElement(), JvmClassMappingKt.getJavaClass(r10)).isPresent() == false) goto L8;
    L9:
        return true;
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotationWithPackage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pkg");
        List r10 = getElement().getAnnotationMirrors();
        if (r10 != null) goto L5;
    L7:
        Iterator r11 = r10.iterator();
    L9:
        if (r11.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(d0.d(((AnnotationMirror) r11.next()).getAnnotationType().asElement()).toString(), r5) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r10.isEmpty() == false) goto L7;
        return false;
    }

    public int hashCode() {
        return XEquality.Companion.hashCode(getEqualityItems());
    }

    @Override // androidx.room.compiler.processing.XElement
    public String kindName() {
        return getElement().getKind().name().toLowerCase(Locale.US);
    }

    public String toString() {
        return getElement().toString();
    }

    @Override // androidx.room.compiler.processing.XElement
    public boolean validate() {
        return u0.a(getElement());
    }
}
