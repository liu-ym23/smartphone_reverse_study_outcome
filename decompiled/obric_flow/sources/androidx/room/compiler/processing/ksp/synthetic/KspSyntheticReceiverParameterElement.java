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
import androidx.room.compiler.processing.ksp.KspAnnotated;
import androidx.room.compiler.processing.ksp.KspJvmTypeResolutionScope;
import androidx.room.compiler.processing.ksp.KspMethodElement;
import androidx.room.compiler.processing.ksp.KspProcessingEnv;
import androidx.room.compiler.processing.ksp.KspType;
import com.squareup.javapoet.e;
import il.d;
import il.p;
import il.s;
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
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J0\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018\"\b\b\u0000\u0010\u0015*\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0019J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ4\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00180\f\"\b\b\u0000\u0010\u0015*\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001cJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ$\u0010#\u001a\u00020\"2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100 \"\u00020\u0010H\u0096\u0001¢\u0006\u0004\b#\u0010$J4\u0010#\u001a\u00020\"2\"\u0010!\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00160 \"\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0016H\u0096\u0001¢\u0006\u0004\b#\u0010%J\u001e\u0010#\u001a\u00020\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100&H\u0096\u0001¢\u0006\u0004\b#\u0010'J\u0018\u0010(\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b(\u0010)J \u0010(\u001a\u00020\"2\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0016H\u0096\u0001¢\u0006\u0004\b(\u0010*J\u0018\u0010-\u001a\u00020\"2\u0006\u0010,\u001a\u00020+H\u0096\u0001¢\u0006\u0004\b-\u0010.J$\u0010/\u001a\u00020\"2\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100 \"\u00020\u0010H\u0096\u0001¢\u0006\u0004\b/\u0010$J4\u0010/\u001a\u00020\"2\"\u0010!\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00160 \"\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0016H\u0096\u0001¢\u0006\u0004\b/\u0010%J\u001e\u0010/\u001a\u00020\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100&H\u0096\u0001¢\u0006\u0004\b/\u0010'J\u0018\u00100\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096\u0001¢\u0006\u0004\b0\u0010\u0013J.\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\"\b\b\u0000\u0010\u0015*\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0001¢\u0006\u0004\b0\u0010\u0019J0\u00101\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018\"\b\b\u0000\u0010\u0015*\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0097\u0001¢\u0006\u0004\b1\u0010\u0019J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020+H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\"H\u0016¢\u0006\u0004\b9\u0010:J\u001a\u0010<\u001a\u00020\"2\b\u00103\u001a\u0004\u0018\u00010;H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0019\u0010D\u001a\u00020C2\b\u0010B\u001a\u0004\u0018\u00010AH\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u00105\u001a\u0002042\b\u0010G\u001a\u0004\u0018\u00010FH\u0002¢\u0006\u0004\b5\u0010HR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010I\u001a\u0004\bJ\u0010KR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010L\u001a\u0004\bM\u0010NR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010O\u001a\u0004\bP\u0010QR\u001b\u0010U\u001a\u00020+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u00108R%\u0010Y\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010;0 8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bV\u0010S\u001a\u0004\bW\u0010XR\u001b\u0010]\u001a\u0002048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010S\u001a\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020^8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b_\u0010S\u001a\u0004\b`\u0010aR\u0014\u0010d\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010:R\u0014\u0010f\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\be\u00108R\u0016\u0010h\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u00108¨\u0006i"}, d2 = {"Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticReceiverParameterElement;", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "Landroidx/room/compiler/processing/XEquality;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "enclosingElement", "Lil/s;", "receiverType", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspMethodElement;Lil/s;)V", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "Landroidx/room/compiler/processing/XType;", "other", "Landroidx/room/compiler/processing/ksp/KspType;", "asMemberOf", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/ksp/KspType;", "kindName", "()Ljava/lang/String;", "validate", "()Z", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lil/d;", "container", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "jvmTypeResolutionScope", "(Lil/d;)Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "Lil/p;", "ksType", "(Lil/p;)Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getEnv", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Landroidx/room/compiler/processing/ksp/KspMethodElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/ksp/KspMethodElement;", "Lil/s;", "getReceiverType", "()Lil/s;", "name$delegate", "Lkotlin/Lazy;", "getName", "name", "equalityItems$delegate", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems", "type$delegate", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer$delegate", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer", "getHasDefaultValue", "hasDefaultValue", "getFallbackLocationText", "fallbackLocationText", "getDocComment", "docComment", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspSyntheticReceiverParameterElement implements XExecutableParameterElement, XEquality, XAnnotated {
    private final /* synthetic */ KspAnnotated $$delegate_0;
    private final Lazy closestMemberContainer$delegate;
    private final KspMethodElement enclosingElement;
    private final KspProcessingEnv env;
    private final Lazy equalityItems$delegate;
    private final Lazy name$delegate;
    private final s receiverType;
    private final Lazy type$delegate;

    public KspSyntheticReceiverParameterElement(KspProcessingEnv r5, KspMethodElement r10, s r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "enclosingElement");
        Intrinsics.checkNotNullParameter(r11, "receiverType");
        this.env = r5;
        this.enclosingElement = r10;
        this.receiverType = r11;
        this.$$delegate_0 = KspAnnotated.Companion.create(r5, null, KspAnnotated.UseSiteFilter.Companion.getNO_USE_SITE());
        this.name$delegate = LazyKt.lazy(new KspSyntheticReceiverParameterElement$name$2(this));
        this.equalityItems$delegate = LazyKt.lazy(new KspSyntheticReceiverParameterElement$equalityItems$2(this));
        this.type$delegate = LazyKt.lazy(new KspSyntheticReceiverParameterElement$type$2(this));
        this.closestMemberContainer$delegate = LazyKt.lazy(new KspSyntheticReceiverParameterElement$closestMemberContainer$2(this));
    }

    public static final /* synthetic */ KspType access$asMemberOf(KspSyntheticReceiverParameterElement r5, p r10) {
        return r5.asMemberOf(r10);
    }

    private final KspJvmTypeResolutionScope jvmTypeResolutionScope(d r5) {
        KspMethodElement r10 = getEnclosingElement();
        getEnclosingElement().getDeclaration();
        return new KspJvmTypeResolutionScope.MethodParameter(r10, 0, null, r5);
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

    public final KspProcessingEnv getEnv() {
        return this.env;
    }

    @Override // androidx.room.compiler.processing.XEquality
    public Object[] getEqualityItems() {
        return (Object[]) this.equalityItems$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getFallbackLocationText() {
        return "receiver parameter of " + getEnclosingElement().getFallbackLocationText();
    }

    @Override // androidx.room.compiler.processing.XExecutableParameterElement
    public boolean getHasDefaultValue() {
        return false;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return (String) this.name$delegate.getValue();
    }

    public final s getReceiverType() {
        return this.receiverType;
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
        return "synthetic receiver parameter";
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
        XType r10 = getClosestMemberContainer().getType();
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
        this.receiverType.resolve();
        if (r5 != null) goto L9;
        KspType r10 = this.env.wrap(this.receiverType, null);
        if (r5 == null) goto L8;
        r5.getDeclaration();
    L8:
        return r10.withJvmTypeResolver(jvmTypeResolutionScope(null));
    L9:
        throw null;
    }
}
