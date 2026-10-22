package androidx.room.compiler.processing.ksp.synthetic;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotated;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XEquality;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.ksp.KSAsMemberOfKt;
import androidx.room.compiler.processing.ksp.KspAnnotated;
import androidx.room.compiler.processing.ksp.KspJvmTypeResolutionScope;
import androidx.room.compiler.processing.ksp.KspMethodElement;
import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import androidx.room.compiler.processing.ksp.KspType;
import androidx.room.compiler.processing.ksp.ResolverExtKt;
import com.squareup.javapoet.e;
import il.d;
import il.p;
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
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J4\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\n\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u001aJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010!\u001a\u00020 2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001e\"\u00020\u000eH\u0096\u0001¢\u0006\u0004\b!\u0010\"J4\u0010!\u001a\u00020 2\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00140\u001e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014H\u0096\u0001¢\u0006\u0004\b!\u0010#J\u001e\u0010!\u001a\u00020 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0$H\u0096\u0001¢\u0006\u0004\b!\u0010%J\u0018\u0010&\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b&\u0010'J \u0010&\u001a\u00020 2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014H\u0096\u0001¢\u0006\u0004\b&\u0010(J\u0018\u0010+\u001a\u00020 2\u0006\u0010*\u001a\u00020)H\u0096\u0001¢\u0006\u0004\b+\u0010,J$\u0010-\u001a\u00020 2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001e\"\u00020\u000eH\u0096\u0001¢\u0006\u0004\b-\u0010\"J4\u0010-\u001a\u00020 2\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00140\u001e\"\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014H\u0096\u0001¢\u0006\u0004\b-\u0010#J\u001e\u0010-\u001a\u00020 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0$H\u0096\u0001¢\u0006\u0004\b-\u0010%J\u0018\u0010.\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001¢\u0006\u0004\b.\u0010\u0011J.\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0001¢\u0006\u0004\b.\u0010\u0017J0\u0010/\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0097\u0001¢\u0006\u0004\b/\u0010\u0017J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020)H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020 H\u0016¢\u0006\u0004\b7\u00108J\u001a\u0010:\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000109H\u0096\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b=\u0010>J\u0019\u0010B\u001a\u00020A2\b\u0010@\u001a\u0004\u0018\u00010?H\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u00103\u001a\u0002022\b\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\b3\u0010FR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010GR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010H\u001a\u0004\bI\u0010JR\u001b\u0010N\u001a\u00020)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u00106R%\u0010R\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001090\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bO\u0010L\u001a\u0004\bP\u0010QR\u001b\u0010V\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010L\u001a\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020W8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bX\u0010L\u001a\u0004\bY\u0010ZR\u0014\u0010]\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u00108R\u0014\u0010_\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u00106R\u0016\u0010a\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u00106¨\u0006b"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticContinuationParameterElement;", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "Landroidx/room/compiler/processing/XEquality;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "enclosingElement", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspMethodElement;)V", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "Landroidx/room/compiler/processing/XType;", "other", "Landroidx/room/compiler/processing/ksp/KspType;", "asMemberOf", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/ksp/KspType;", "kindName", "()Ljava/lang/String;", "validate", "()Z", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lil/d;", "container", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "jvmTypeResolutionScope", "(Lil/d;)Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "Lil/p;", "ksType", "(Lil/p;)Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/ksp/KspMethodElement;", "name$delegate", "Lkotlin/Lazy;", "getName", "name", "equalityItems$delegate", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems", "type$delegate", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer$delegate", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer", "getHasDefaultValue", "hasDefaultValue", "getFallbackLocationText", "fallbackLocationText", "getDocComment", "docComment", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspSyntheticContinuationParameterElement implements XExecutableParameterElement, XEquality, XAnnotated {
    private final /* synthetic */ KspAnnotated $$delegate_0;
    private final Lazy closestMemberContainer$delegate;
    private final KspMethodElement enclosingElement;
    private final KspProcessingEnv env;
    private final Lazy equalityItems$delegate;
    private final Lazy name$delegate;
    private final Lazy type$delegate;

    public KspSyntheticContinuationParameterElement(KspProcessingEnv r5, KspMethodElement r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "enclosingElement");
        this.env = r5;
        this.enclosingElement = r10;
        this.$$delegate_0 = KspAnnotated.Companion.create(r5, null, KspAnnotated.UseSiteFilter.Companion.getNO_USE_SITE());
        this.name$delegate = LazyKt.lazy(new KspSyntheticContinuationParameterElement$name$2(this));
        this.equalityItems$delegate = LazyKt.lazy(new KspSyntheticContinuationParameterElement$equalityItems$2(this));
        this.type$delegate = LazyKt.lazy(new KspSyntheticContinuationParameterElement$type$2(this));
        this.closestMemberContainer$delegate = LazyKt.lazy(new KspSyntheticContinuationParameterElement$closestMemberContainer$2(this));
    }

    public static final /* synthetic */ KspType access$asMemberOf(KspSyntheticContinuationParameterElement r5, p r10) {
        return r5.asMemberOf(r10);
    }

    private final KspJvmTypeResolutionScope jvmTypeResolutionScope(d r5) {
        KspMethodElement r10 = getEnclosingElement();
        int r11 = getEnclosingElement().getParameters().size() - 1;
        getEnclosingElement().getDeclaration();
        return new KspJvmTypeResolutionScope.MethodParameter(r10, r11, null, r5);
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public /* bridge */ /* synthetic */ XType asMemberOf(XType r5) {
        return asMemberOf(r5);
    }

    public boolean equals(Object r5) {
        return XEquality.Companion.equals(this, r5);
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

    @Override // androidx.room.compiler.processing.XElement
    public XMemberContainer getClosestMemberContainer() {
        return (XMemberContainer) this.closestMemberContainer$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getDocComment() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XEquality
    public Object[] getEqualityItems() {
        return (Object[]) this.equalityItems$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getFallbackLocationText() {
        return "return type of " + getEnclosingElement().getFallbackLocationText();
    }

    @Override // androidx.room.compiler.processing.XExecutableParameterElement
    public boolean getHasDefaultValue() {
        return false;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return (String) this.name$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public /* bridge */ /* synthetic */ XType getType() {
        return getType();
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

    public int hashCode() {
        return XEquality.Companion.hashCode(getEqualityItems());
    }

    @Override // androidx.room.compiler.processing.XElement
    public String kindName() {
        return "synthetic continuation parameter";
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

    @Override // androidx.room.compiler.processing.XElement
    public boolean validate() {
        return true;
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public KspType asMemberOf(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        KspType r10 = getEnclosingElement().getEnclosingElement().getType();
        if (r10 == null) goto L13;
        if (r10.isSameType(r5) == true) goto L13;
        if ((r5 instanceof KspType) == false) goto L11;
        ((KspType) r5).getKsType();
        return asMemberOf(null);
    L11:
        throw new IllegalStateException("Check failed.");
    L13:
        return getType();
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

    @Override // androidx.room.compiler.processing.XExecutableParameterElement, androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XExecutableElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public KspType getType() {
        return (KspType) this.type$delegate.getValue();
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

    @Override // androidx.room.compiler.processing.XExecutableParameterElement, androidx.room.compiler.processing.XElement
    public KspMethodElement getEnclosingElement() {
        return this.enclosingElement;
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

    private final KspType asMemberOf(p r5) {
        this.env.getResolver();
        ResolverExtKt.requireContinuationClass(null);
        getEnclosingElement().getDeclaration();
        KSAsMemberOfKt.returnTypeAsMemberOf(null, r5);
        getEnclosingElement().getDeclaration();
        throw null;
    }
}
