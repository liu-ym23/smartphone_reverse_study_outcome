package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotated;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XHasModifiers;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement;
import com.squareup.javapoet.e;
import il.l;
import il.p;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\\B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\rJ\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ0\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 \"\b\b\u0000\u0010\u001d*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096\u0001¢\u0006\u0004\b\u001a\u0010!J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b\"\u0010#J4\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000 0\u0014\"\b\b\u0000\u0010\u001d*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096\u0001¢\u0006\u0004\b\"\u0010$J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150%2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b&\u0010'J$\u0010*\u001a\u00020\u000b2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180(\"\u00020\u0018H\u0096\u0001¢\u0006\u0004\b*\u0010+J4\u0010*\u001a\u00020\u000b2\"\u0010)\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001e0(\"\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001eH\u0096\u0001¢\u0006\u0004\b*\u0010,J\u001e\u0010*\u001a\u00020\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180-H\u0096\u0001¢\u0006\u0004\b*\u0010.J\u0018\u0010/\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b/\u00100J \u0010/\u001a\u00020\u000b2\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001eH\u0096\u0001¢\u0006\u0004\b/\u00101J\u0018\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u000202H\u0096\u0001¢\u0006\u0004\b4\u00105J$\u00106\u001a\u00020\u000b2\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180(\"\u00020\u0018H\u0096\u0001¢\u0006\u0004\b6\u0010+J4\u00106\u001a\u00020\u000b2\"\u0010)\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001e0(\"\n\u0012\u0006\b\u0001\u0012\u00020\u001c0\u001eH\u0096\u0001¢\u0006\u0004\b6\u0010,J\u001e\u00106\u001a\u00020\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180-H\u0096\u0001¢\u0006\u0004\b6\u0010.J\u0018\u00107\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0096\u0001¢\u0006\u0004\b7\u0010\u001bJ.\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\b\b\u0000\u0010\u001d*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096\u0001¢\u0006\u0004\b7\u0010!J0\u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 \"\b\b\u0000\u0010\u001d*\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0097\u0001¢\u0006\u0004\b8\u0010!J\u0017\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b<\u0010=J\u0019\u0010<\u001a\u00020;2\b\u0010?\u001a\u0004\u0018\u00010>H\u0002¢\u0006\u0004\b<\u0010@R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020D8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010L\u001a\u00020D8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010HR\u001b\u0010P\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010F\u001a\u0004\bN\u0010OR\u001b\u0010T\u001a\u00020;8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010F\u001a\u0004\bR\u0010SR!\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010F\u001a\u0004\bW\u0010\u0017R\u0013\u0010[\u001a\u0004\u0018\u00010U8F¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspFieldElement;", "Landroidx/room/compiler/processing/ksp/KspElement;", "Landroidx/room/compiler/processing/XFieldElement;", "Landroidx/room/compiler/processing/XHasModifiers;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/l;", "declaration", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/l;)V", "", "isAbstract", "()Z", "isFinal", "isPrivate", "isProtected", "isPublic", "isStatic", "isTransient", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "Landroidx/room/compiler/processing/XType;", "other", "Landroidx/room/compiler/processing/ksp/KspType;", "asMemberOf", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/ksp/KspType;", "Lil/p;", "ksType", "(Lil/p;)Landroidx/room/compiler/processing/ksp/KspType;", "Lil/l;", "getDeclaration", "()Lil/l;", "Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "enclosingElement$delegate", "Lkotlin/Lazy;", "getEnclosingElement", "()Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "enclosingElement", "closestMemberContainer$delegate", "getClosestMemberContainer", "closestMemberContainer", "name$delegate", "getName", "()Ljava/lang/String;", "name", "type$delegate", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "syntheticAccessors$delegate", "getSyntheticAccessors", "syntheticAccessors", "getSyntheticSetter", "()Landroidx/room/compiler/processing/ksp/synthetic/KspSyntheticPropertyMethodElement;", "syntheticSetter", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspFieldElement extends KspElement implements XFieldElement, XHasModifiers, XAnnotated {
    public static final Companion Companion = null;
    private final /* synthetic */ XHasModifiers $$delegate_0;
    private final /* synthetic */ KspAnnotated $$delegate_1;
    private final Lazy closestMemberContainer$delegate;
    private final l declaration;
    private final Lazy enclosingElement$delegate;
    private final Lazy name$delegate;
    private final Lazy syntheticAccessors$delegate;
    private final Lazy type$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspFieldElement$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/l;", "declaration", "Landroidx/room/compiler/processing/ksp/KspFieldElement;", "create", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/l;)Landroidx/room/compiler/processing/ksp/KspFieldElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final KspFieldElement create(KspProcessingEnv r5, l r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "declaration");
            return new KspFieldElement(r5, r10);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KspFieldElement(final KspProcessingEnv r5, l r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "declaration");
        super(r5, r10);
        this.$$delegate_0 = KspHasModifiers.Companion.create(r10);
        this.$$delegate_1 = KspAnnotated.Companion.create(r5, r10, KspAnnotated.UseSiteFilter.Companion.getNO_USE_SITE_OR_FIELD());
        this.enclosingElement$delegate = LazyKt.lazy(new KspFieldElement$enclosingElement$2(this, r5));
        this.closestMemberContainer$delegate = LazyKt.lazy(new KspFieldElement$closestMemberContainer$2(this));
        this.name$delegate = LazyKt.lazy(new KspFieldElement$name$2(this));
        this.type$delegate = LazyKt.lazy(new KspFieldElement$type$2(this));
        this.syntheticAccessors$delegate = LazyKt.lazy(new KspFieldElement$syntheticAccessors$2(this, r5));
    }

    public static final /* synthetic */ KspType access$asMemberOf(KspFieldElement r5, p r10) {
        return r5.asMemberOf(r10);
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public /* bridge */ /* synthetic */ XType asMemberOf(XType r5) {
        return asMemberOf(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAllAnnotations() {
        return this.$$delegate_1.getAllAnnotations();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public XAnnotation getAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.getAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public List<XAnnotation> getAnnotations(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.getAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public Set<XAnnotation> getAnnotationsAnnotatedWith(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.getAnnotationsAnnotatedWith(r5);
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
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
    public String getName() {
        return (String) this.name$delegate.getValue();
    }

    public final List<KspSyntheticPropertyMethodElement> getSyntheticAccessors() {
        return (List) this.syntheticAccessors$delegate.getValue();
    }

    public final KspSyntheticPropertyMethodElement getSyntheticSetter() {
        Iterator<T> r5 = getSyntheticAccessors().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r10 = r5.next();
        if (((KspSyntheticPropertyMethodElement) r10).getParameters().size() != 1) goto L4;
    L10:
        return (KspSyntheticPropertyMethodElement) r10;
    L8:
        r10 = null;
        goto L10
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public /* bridge */ /* synthetic */ XType getType() {
        return getType();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(Collection<e> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.hasAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotationWithPackage(String r5) {
        Intrinsics.checkNotNullParameter(r5, "pkg");
        return this.$$delegate_1.hasAnnotationWithPackage(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(Collection<e> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAnyAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isAbstract() {
        return this.$$delegate_0.isAbstract();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isFinal() {
        return this.$$delegate_0.isFinal();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPrivate() {
        return this.$$delegate_0.isPrivate();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isProtected() {
        return this.$$delegate_0.isProtected();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPublic() {
        return this.$$delegate_0.isPublic();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isStatic() {
        return this.$$delegate_0.isStatic();
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isTransient() {
        return this.$$delegate_0.isTransient();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public XAnnotation requireAnnotation(e r5) {
        Intrinsics.checkNotNullParameter(r5, "annotationName");
        return this.$$delegate_1.requireAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    @Deprecated(message = "Use getAnnotation(not repeatable) or getAnnotations (repeatable)", replaceWith = @ReplaceWith(expression = "getAnnotation(annotation)", imports = {}))
    public <T extends Annotation> XAnnotationBox<T> toAnnotationBox(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.toAnnotationBox(r5);
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public KspType asMemberOf(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        KspType r10 = getEnclosingElement().getType();
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
        return this.$$delegate_1.getAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> List<XAnnotationBox<T>> getAnnotations(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.getAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XElement
    public KspMemberContainer getClosestMemberContainer() {
        return (KspMemberContainer) this.closestMemberContainer$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.ksp.KspElement
    public l getDeclaration() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public KspType getType() {
        return (KspType) this.type$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(e... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnnotation(KClass<? extends Annotation> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.hasAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(e... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAnyAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public <T extends Annotation> XAnnotationBox<T> requireAnnotation(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        return this.$$delegate_1.requireAnnotation(r5);
    }

    @Override // androidx.room.compiler.processing.XElement
    public KspMemberContainer getEnclosingElement() {
        return (KspMemberContainer) this.enclosingElement$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAllAnnotations(KClass<? extends Annotation>... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAllAnnotations(r5);
    }

    @Override // androidx.room.compiler.processing.XAnnotated
    public boolean hasAnyAnnotation(KClass<? extends Annotation>... r5) {
        Intrinsics.checkNotNullParameter(r5, "annotations");
        return this.$$delegate_1.hasAnyAnnotation(r5);
    }

    private final KspType asMemberOf(p r5) {
        getEnv$room_compiler_processing();
        getDeclaration();
        throw null;
    }
}
