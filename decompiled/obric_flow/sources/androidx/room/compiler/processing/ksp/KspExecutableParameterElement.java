package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.processing.XAnnotated;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.e;
import il.d;
import il.j;
import il.p;
import il.u;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001]B'\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J0\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a\"\b\b\u0000\u0010\u0017*\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ4\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a0\u000e\"\b\b\u0000\u0010\u0017*\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096\u0001¢\u0006\u0004\b\u001c\u0010\u001eJ\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b \u0010!J$\u0010%\u001a\u00020$2\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\"\"\u00020\u0012H\u0096\u0001¢\u0006\u0004\b%\u0010&J4\u0010%\u001a\u00020$2\"\u0010#\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00180\"\"\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0018H\u0096\u0001¢\u0006\u0004\b%\u0010'J\u001e\u0010%\u001a\u00020$2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120(H\u0096\u0001¢\u0006\u0004\b%\u0010)J\u0018\u0010*\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b*\u0010+J \u0010*\u001a\u00020$2\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0018H\u0096\u0001¢\u0006\u0004\b*\u0010,J\u0018\u0010/\u001a\u00020$2\u0006\u0010.\u001a\u00020-H\u0096\u0001¢\u0006\u0004\b/\u00100J$\u00101\u001a\u00020$2\u0012\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\"\"\u00020\u0012H\u0096\u0001¢\u0006\u0004\b1\u0010&J4\u00101\u001a\u00020$2\"\u0010#\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00180\"\"\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0018H\u0096\u0001¢\u0006\u0004\b1\u0010'J\u001e\u00101\u001a\u00020$2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120(H\u0096\u0001¢\u0006\u0004\b1\u0010)J\u0018\u00102\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0096\u0001¢\u0006\u0004\b2\u0010\u0015J.\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\b\b\u0000\u0010\u0017*\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096\u0001¢\u0006\u0004\b2\u0010\u001bJ0\u00103\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001a\"\b\b\u0000\u0010\u0017*\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0097\u0001¢\u0006\u0004\b3\u0010\u001bJ\u0017\u00107\u001a\u0002062\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020-H\u0016¢\u0006\u0004\b9\u0010:J\u0019\u0010>\u001a\u00020=2\b\u0010<\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0004\b>\u0010?J\u0019\u00107\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0004\b7\u0010BR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010P\u001a\u0002068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u0010M\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010:R\u0014\u0010Z\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b[\u0010:¨\u0006^"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspExecutableParameterElement;", "Landroidx/room/compiler/processing/ksp/KspElement;", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "enclosingElement", "Lil/u;", "parameter", "", "parameterIndex", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Landroidx/room/compiler/processing/ksp/KspExecutableElement;Lil/u;I)V", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "Landroidx/room/compiler/processing/XType;", "other", "Landroidx/room/compiler/processing/ksp/KspType;", "asMemberOf", "(Landroidx/room/compiler/processing/XType;)Landroidx/room/compiler/processing/ksp/KspType;", "kindName", "()Ljava/lang/String;", "Lil/d;", "container", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "jvmTypeResolver", "(Lil/d;)Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "Lil/p;", "ksType", "(Lil/p;)Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/ksp/KspExecutableElement;", "Lil/u;", "getParameter", "()Lil/u;", "I", "getParameterIndex", "()I", "type$delegate", "Lkotlin/Lazy;", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer$delegate", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer", "getName", "name", "getHasDefaultValue", "()Z", "hasDefaultValue", "getFallbackLocationText", "fallbackLocationText", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspExecutableParameterElement extends KspElement implements XExecutableParameterElement, XAnnotated {
    public static final Companion Companion = null;
    private final /* synthetic */ KspAnnotated $$delegate_0;
    private final Lazy closestMemberContainer$delegate;
    private final KspExecutableElement enclosingElement;
    private final u parameter;
    private final int parameterIndex;
    private final Lazy type$delegate;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspExecutableParameterElement$Companion;", "", "<init>", "()V", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/u;", "parameter", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "create", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/u;)Landroidx/room/compiler/processing/XExecutableParameterElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public final XExecutableParameterElement create(KspProcessingEnv r5, u r10) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "parameter");
            j r11 = r10.getParent();
            if (r11 == null) goto L7;
            throw new IllegalStateException(("Don't know how to create a parameter element whose parent is a '" + Reflection.getOrCreateKotlinClass(r11.getClass()) + '\'').toString());
        L7:
            throw new IllegalStateException(("Expected value parameter '" + r10 + "' to contain a parent node.").toString());
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KspExecutableParameterElement(KspProcessingEnv r5, KspExecutableElement r10, u r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "enclosingElement");
        Intrinsics.checkNotNullParameter(r11, "parameter");
        super(r5, r11);
        this.enclosingElement = r10;
        this.parameterIndex = r12;
        this.$$delegate_0 = KspAnnotated.Companion.create(r5, r11, KspAnnotated.UseSiteFilter.Companion.getNO_USE_SITE_OR_METHOD_PARAMETER());
        this.type$delegate = LazyKt.lazy(new KspExecutableParameterElement$type$2(this));
        this.closestMemberContainer$delegate = LazyKt.lazy(new KspExecutableParameterElement$closestMemberContainer$2(this));
    }

    public static final /* synthetic */ KspType access$asMemberOf(KspExecutableParameterElement r5, p r10) {
        return r5.asMemberOf(r10);
    }

    private final KspJvmTypeResolutionScope jvmTypeResolver(d r5) {
        getEnclosingElement();
        throw null;
    }

    @Override // androidx.room.compiler.processing.XVariableElement
    public /* bridge */ /* synthetic */ XType asMemberOf(XType r5) {
        return asMemberOf(r5);
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
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getFallbackLocationText() {
        return getName() + " in " + getEnclosingElement().getFallbackLocationText();
    }

    @Override // androidx.room.compiler.processing.XExecutableParameterElement
    public boolean getHasDefaultValue() {
        throw null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        throw null;
    }

    public final u getParameter() {
        return null;
    }

    public final int getParameterIndex() {
        return this.parameterIndex;
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

    @Override // androidx.room.compiler.processing.ksp.KspElement, androidx.room.compiler.processing.XElement
    public String kindName() {
        return "function parameter";
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

    @Override // androidx.room.compiler.processing.XElement
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

    @Override // androidx.room.compiler.processing.XElement
    public KspExecutableElement getEnclosingElement() {
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
        getEnv$room_compiler_processing();
        throw null;
    }
}
