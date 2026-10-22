package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotated;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeParameterElement;
import com.squareup.javapoet.a0;
import com.squareup.javapoet.e;
import il.r;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J4\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\n\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u001aJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010!\u001a\u00020 2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001e\"\u00020\u000eH\u0096\u0001¢\u0006\u0004\b!\u0010\"J4\u0010!\u001a\u00020 2\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00140\u001e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014H\u0096\u0001¢\u0006\u0004\b!\u0010#J\u001e\u0010!\u001a\u00020 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0$H\u0096\u0001¢\u0006\u0004\b!\u0010%J\u0018\u0010&\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b&\u0010'J \u0010&\u001a\u00020 2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014H\u0096\u0001¢\u0006\u0004\b&\u0010(J\u0018\u0010+\u001a\u00020 2\u0006\u0010*\u001a\u00020)H\u0096\u0001¢\u0006\u0004\b+\u0010,J$\u0010-\u001a\u00020 2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001e\"\u00020\u000eH\u0096\u0001¢\u0006\u0004\b-\u0010\"J4\u0010-\u001a\u00020 2\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00140\u001e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014H\u0096\u0001¢\u0006\u0004\b-\u0010#J\u001e\u0010-\u001a\u00020 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0$H\u0096\u0001¢\u0006\u0004\b-\u0010%J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b.\u0010\u0011J.\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0001¢\u0006\u0004\b.\u0010\u0017J0\u0010/\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0097\u0001¢\u0006\u0004\b/\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R!\u0010A\u001a\b\u0012\u0004\u0012\u00020>0\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u00105\u001a\u0004\b@\u0010\rR\u0014\u0010D\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010CR\u0014\u0010J\u001a\u00020G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006K"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspTypeParameterElement;", "Landroidx/room/compiler/processing/ksp/KspElement;", "Landroidx/room/compiler/processing/XTypeParameterElement;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/r;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/r;)V", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "Lil/r;", "getDeclaration", "()Lil/r;", "Lcom/squareup/javapoet/a0;", "typeVariableName$delegate", "Lkotlin/Lazy;", "getTypeVariableName", "()Lcom/squareup/javapoet/a0;", "typeVariableName", "Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "enclosingElement$delegate", "getEnclosingElement", "()Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "enclosingElement", "Landroidx/room/compiler/processing/XType;", "bounds$delegate", "getBounds", "bounds", "getName", "()Ljava/lang/String;", "name", "getFallbackLocationText", "fallbackLocationText", "Landroidx/room/compiler/processing/XMemberContainer;", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspTypeParameterElement extends KspElement implements XTypeParameterElement, XAnnotated {
    private final /* synthetic */ KspAnnotated $$delegate_0;
    private final Lazy bounds$delegate;
    private final r declaration;
    private final Lazy enclosingElement$delegate;
    private final Lazy typeVariableName$delegate;

    public KspTypeParameterElement(final KspProcessingEnv r5, r r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "declaration");
        super(r5, r10);
        this.$$delegate_0 = KspAnnotated.Companion.create(r5, r10, KspAnnotated.UseSiteFilter.Companion.getNO_USE_SITE_OR_FIELD());
        this.typeVariableName$delegate = LazyKt.lazy(new KspTypeParameterElement$typeVariableName$2(this));
        this.enclosingElement$delegate = LazyKt.lazy(new KspTypeParameterElement$enclosingElement$2(this, r5));
        this.bounds$delegate = LazyKt.lazy(new KspTypeParameterElement$bounds$2(this, r5));
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAllAnnotations() {
        return this.$$delegate_0.getAllAnnotations();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public XAnnotation getAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_0.getAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAnnotations(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_0.getAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public Set<XAnnotation> getAnnotationsAnnotatedWith(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_0.getAnnotationsAnnotatedWith(r5);
    }

    @Override // androidx.room.compiler.processing.XTypeParameterElement
    public List<XType> getBounds() {
        return (List) this.bounds$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public XMemberContainer getClosestMemberContainer() {
        return getEnclosingElement().getClosestMemberContainer();
    }

    @Override // androidx.room.compiler.processing.ksp.KspElement
    public /* bridge */ /* synthetic */ il.a getDeclaration() {
        getDeclaration();
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getFallbackLocationText() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        getDeclaration();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XTypeParameterElement
    public a0 getTypeVariableName() {
        return (a0) this.typeVariableName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(Collection<e> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_0.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_0.hasAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotationWithPackage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pkg");
        return this.$$delegate_0.hasAnnotationWithPackage(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(Collection<e> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_0.hasAnyAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public XAnnotation requireAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_0.requireAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    @Deprecated(message = "Use getAnnotation(not repeatable) or getAnnotations (repeatable)", replaceWith = @ReplaceWith(expression = "getAnnotation(annotation)", imports = {}))
    public <T extends Annotation> XAnnotationBox<T> toAnnotationBox(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_0.toAnnotationBox(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> XAnnotationBox<T> getAnnotation(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_0.getAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_0.getAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.ksp.KspElement
    public r getDeclaration() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public KspMemberContainer getEnclosingElement() {
        return (KspMemberContainer) this.enclosingElement$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(e... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_0.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotation(KClass<? extends Annotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_0.hasAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(e... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_0.hasAnyAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> XAnnotationBox<T> requireAnnotation(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_0.requireAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(KClass<? extends Annotation>... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_0.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(KClass<? extends Annotation>... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_0.hasAnyAnnotation(r5);
    }
}
