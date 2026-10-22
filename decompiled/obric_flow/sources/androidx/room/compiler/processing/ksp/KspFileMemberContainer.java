package androidx.room.compiler.processing.ksp;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.processing.XAnnotated;
import androidx.room.compiler.processing.XAnnotation;
import androidx.room.compiler.processing.XAnnotationBox;
import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.e;
import il.d;
import il.f;
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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J4\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\t\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0019J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001a2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010 \u001a\u00020\u001f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001d\"\u00020\rH\u0096\u0001¢\u0006\u0004\b \u0010!J4\u0010 \u001a\u00020\u001f2\"\u0010\u001e\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00130\u001d\"\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013H\u0096\u0001¢\u0006\u0004\b \u0010\"J\u001e\u0010 \u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0#H\u0096\u0001¢\u0006\u0004\b \u0010$J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b%\u0010&J \u0010%\u001a\u00020\u001f2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013H\u0096\u0001¢\u0006\u0004\b%\u0010'J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020(H\u0096\u0001¢\u0006\u0004\b*\u0010+J$\u0010,\u001a\u00020\u001f2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u001d\"\u00020\rH\u0096\u0001¢\u0006\u0004\b,\u0010!J4\u0010,\u001a\u00020\u001f2\"\u0010\u001e\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00130\u001d\"\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0013H\u0096\u0001¢\u0006\u0004\b,\u0010\"J\u001e\u0010,\u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0#H\u0096\u0001¢\u0006\u0004\b,\u0010$J\u0018\u0010-\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b-\u0010\u0010J.\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0096\u0001¢\u0006\u0004\b-\u0010\u0016J0\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\"\b\b\u0000\u0010\u0012*\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0097\u0001¢\u0006\u0004\b.\u0010\u0016J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020(H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u001fH\u0016¢\u0006\u0004\b4\u00105R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u00106R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00107R\u001b\u0010<\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u00101R\u001a\u0010@\u001a\u00020(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u00103R\u0016\u0010F\u001a\u0004\u0018\u00010C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0016\u0010J\u001a\u0004\u0018\u00010G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0016\u0010L\u001a\u0004\u0018\u00010(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u00103R\u0016\u0010P\u001a\u0004\u0018\u00010M8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspFileMemberContainer;", "Landroidx/room/compiler/processing/ksp/KspMemberContainer;", "Landroidx/room/compiler/processing/XAnnotated;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/f;", "ksFile", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/f;)V", "", "Landroidx/room/compiler/processing/XAnnotation;", "getAllAnnotations", "()Ljava/util/List;", "Lcom/squareup/javapoet/e;", "annotationName", "getAnnotation", "(Lcom/squareup/javapoet/e;)Landroidx/room/compiler/processing/XAnnotation;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "annotation", "Landroidx/room/compiler/processing/XAnnotationBox;", "(Lkotlin/reflect/KClass;)Landroidx/room/compiler/processing/XAnnotationBox;", "getAnnotations", "(Lcom/squareup/javapoet/e;)Ljava/util/List;", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "", "getAnnotationsAnnotatedWith", "(Lcom/squareup/javapoet/e;)Ljava/util/Set;", "", "annotations", "", "hasAllAnnotations", "([Lcom/squareup/javapoet/e;)Z", "([Lkotlin/reflect/KClass;)Z", "", "(Ljava/util/Collection;)Z", "hasAnnotation", "(Lcom/squareup/javapoet/e;)Z", "(Lkotlin/reflect/KClass;)Z", "", "pkg", "hasAnnotationWithPackage", "(Ljava/lang/String;)Z", "hasAnyAnnotation", "requireAnnotation", "toAnnotationBox", "Landroidx/room/compiler/codegen/XClassName;", "asClassName", "()Landroidx/room/compiler/codegen/XClassName;", "kindName", "()Ljava/lang/String;", "validate", "()Z", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Lil/f;", "className$delegate", "Lkotlin/Lazy;", "getClassName", "()Lcom/squareup/javapoet/e;", "className", "xClassName$delegate", "getXClassName", "xClassName", "fallbackLocationText", "Ljava/lang/String;", "getFallbackLocationText", "Landroidx/room/compiler/processing/ksp/KspType;", "getType", "()Landroidx/room/compiler/processing/ksp/KspType;", "type", "Lil/d;", "getDeclaration", "()Lil/d;", "declaration", "getDocComment", "docComment", "Landroidx/room/compiler/processing/XElement;", "getEnclosingElement", "()Landroidx/room/compiler/processing/XElement;", "enclosingElement", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/ksp/KspFileMemberContainer;", "closestMemberContainer", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspFileMemberContainer implements KspMemberContainer, XAnnotated {
    public static final Companion Companion = null;
    private final /* synthetic */ KspAnnotated $$delegate_0;
    private final Lazy className$delegate;
    private final KspProcessingEnv env;
    private final String fallbackLocationText;
    private final f ksFile;
    private final Lazy xClassName$delegate;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspFileMemberContainer$Companion;", "", "<init>", "()V", "Lil/f;", "", "findClassName", "(Lil/f;)Ljava/lang/String;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        public static final /* synthetic */ String access$findClassName(Companion r5, f r10) {
            return r5.findClassName(r10);
        }

        private final String findClassName(f r5) {
            Iterator r10 = r5.getAnnotations().iterator();
            if (r10.hasNext() == true) goto L7;
            return StringsKt.F(r5.e(), ".kt", "Kt");
        L7:
            throw androidx.constraintlayout.motion.widget.a.g(r10);
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public KspFileMemberContainer(KspProcessingEnv r5, f r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "ksFile");
        this.env = r5;
        this.$$delegate_0 = KspAnnotated.Companion.create(r5, r10, KspAnnotated.UseSiteFilter.Companion.getFILE());
        this.className$delegate = LazyKt.lazy(new KspFileMemberContainer$className$2(this));
        this.xClassName$delegate = LazyKt.lazy(new KspFileMemberContainer$xClassName$2(this));
        throw null;
    }

    public static final /* synthetic */ f access$getKsFile$p(KspFileMemberContainer r5) {
        r5.getClass();
        return null;
    }

    public static final /* synthetic */ XClassName access$getXClassName(KspFileMemberContainer r5) {
        return r5.getXClassName();
    }

    private final XClassName getXClassName() {
        return (XClassName) this.xClassName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XMemberContainer
    public XClassName asClassName() {
        return getXClassName();
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

    @Override // androidx.room.compiler.processing.XMemberContainer
    public e getClassName() {
        return (e) this.className$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public KspFileMemberContainer getClosestMemberContainer() {
        return this;
    }

    @Override // androidx.room.compiler.processing.ksp.KspMemberContainer
    public d getDeclaration() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getDocComment() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public XElement getEnclosingElement() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getFallbackLocationText() {
        return this.fallbackLocationText;
    }

    @Override // androidx.room.compiler.processing.ksp.KspMemberContainer, androidx.room.compiler.processing.XMemberContainer
    public KspType getType() {
        return null;
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

    @Override // androidx.room.compiler.processing.XElement
    public String kindName() {
        return "file";
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
        return com.google.devtools.ksp.a.d(null);
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
    public /* bridge */ /* synthetic */ XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
    }

    @Override // androidx.room.compiler.processing.XMemberContainer
    public /* bridge */ /* synthetic */ XType getType() {
        return getType();
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
