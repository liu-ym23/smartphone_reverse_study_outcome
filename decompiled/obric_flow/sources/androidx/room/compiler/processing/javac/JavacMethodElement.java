package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XMethodElement;
import androidx.room.compiler.processing.XMethodType;
import androidx.room.compiler.processing.XProcessingEnv;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeParameterElement;
import androidx.room.compiler.processing.javac.kotlin.KmExecutable;
import androidx.room.compiler.processing.javac.kotlin.KmFunction;
import com.google.auto.common.o0;
import com.google.auto.common.q0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\b\u00107\u001a\u000205H\u0016J\b\u00108\u001a\u000205H\u0016J\u0018\u00109\u001a\u0002052\u0006\u00102\u001a\u00020\u00022\u0006\u0010:\u001a\u00020;H\u0016R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\r\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b\u001f\u0010\u0011R!\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b)\u0010*R!\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\r\u001a\u0004\b.\u0010%¨\u0006<"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacMethodElement;", "Landroidx/room/compiler/processing/javac/JavacExecutableElement;", "Landroidx/room/compiler/processing/XMethodElement;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Ljavax/lang/model/element/ExecutableElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/ExecutableElement;)V", "executableType", "Landroidx/room/compiler/processing/javac/JavacMethodType;", "getExecutableType", "()Landroidx/room/compiler/processing/javac/JavacMethodType;", "executableType$delegate", "Lkotlin/Lazy;", "jvmName", "", "getJvmName", "()Ljava/lang/String;", "kotlinDefaultImplClass", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "getKotlinDefaultImplClass$annotations", "()V", "getKotlinDefaultImplClass", "()Landroidx/room/compiler/processing/javac/JavacTypeElement;", "kotlinDefaultImplClass$delegate", "kotlinMetadata", "Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "getKotlinMetadata", "()Landroidx/room/compiler/processing/javac/kotlin/KmFunction;", "kotlinMetadata$delegate", "name", "getName", "name$delegate", "parameters", "", "Landroidx/room/compiler/processing/javac/JavacMethodParameter;", "getParameters", "()Ljava/util/List;", "parameters$delegate", "returnType", "Landroidx/room/compiler/processing/javac/JavacType;", "getReturnType", "()Landroidx/room/compiler/processing/javac/JavacType;", "returnType$delegate", "typeParameters", "Landroidx/room/compiler/processing/XTypeParameterElement;", "getTypeParameters", "typeParameters$delegate", "asMemberOf", "Landroidx/room/compiler/processing/XMethodType;", "other", "Landroidx/room/compiler/processing/XType;", "hasKotlinDefaultImpl", "", "isExtensionFunction", "isJavaDefault", "isSuspendFunction", "overrides", "owner", "Landroidx/room/compiler/processing/XTypeElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacMethodElement extends JavacExecutableElement implements XMethodElement {
    private final Lazy executableType$delegate;
    private final Lazy kotlinDefaultImplClass$delegate;
    private final Lazy kotlinMetadata$delegate;
    private final Lazy name$delegate;
    private final Lazy parameters$delegate;
    private final Lazy returnType$delegate;
    private final Lazy typeParameters$delegate;

    public JavacMethodElement(final JavacProcessingEnv r5, final ExecutableElement r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        super(r5, r10);
        if (r10.getKind() != ElementKind.METHOD) goto L7;
        this.name$delegate = LazyKt.lazy(new JavacMethodElement$name$2(this));
        this.typeParameters$delegate = LazyKt.lazy(new JavacMethodElement$typeParameters$2(r10, this, r5));
        this.parameters$delegate = LazyKt.lazy(new JavacMethodElement$parameters$2(r10, r5, this));
        this.kotlinMetadata$delegate = LazyKt.lazy(new JavacMethodElement$kotlinMetadata$2(this, r10));
        this.executableType$delegate = LazyKt.lazy(new JavacMethodElement$executableType$2(r5, this, r10));
        this.returnType$delegate = LazyKt.lazy(new JavacMethodElement$returnType$2(r5, r10, this));
        this.kotlinDefaultImplClass$delegate = LazyKt.lazy(new JavacMethodElement$kotlinDefaultImplClass$2(r10, r5));
        return;
    L7:
        throw new IllegalStateException(("Method element is constructed with invalid type: " + r10).toString());
    }

    private final JavacTypeElement getKotlinDefaultImplClass() {
        return (JavacTypeElement) this.kotlinDefaultImplClass$delegate.getValue();
    }

    private static /* synthetic */ void getKotlinDefaultImplClass$annotations() {
    }

    private static final boolean hasKotlinDefaultImpl$paramsMatch(JavacMethodElement r10, List<JavacMethodParameter> r11, List<JavacMethodParameter> r12) {
        if (r11.size() == (r12.size() - 1)) goto L5;
        return false;
    L5:
        Iterable r5 = CollectionsKt.getIndices(r11);
        if ((r5 instanceof Collection) == true) goto L8;
    L10:
        Iterator r13 = r5.iterator();
    L12:
        if (r13.hasNext() == false) goto L39;
        int r14 = ((IntIterator) r13).nextInt();
        TypeVariable r15 = r12.get(r14 + 1).m59getElement().asType();
        TypeVariable r16 = r11.get(r14).m59getElement().asType();
        if (r10.getEnv$room_compiler_processing().getTypeUtils().isSameType(r16, r15) == true) goto L12;
        TypeVariable r17 = null;
        if ((r16 instanceof TypeVariable) == false) goto L19;
        TypeVariable r18 = r16;
    L21:
        if ((r15 instanceof TypeVariable) == false) goto L23;
        r17 = r15;
    L23:
        if (r18 == null) goto L29;
        if (r17 == null) goto L29;
        if (r10.getEnv$room_compiler_processing().getTypeUtils().isSameType(r18.getLowerBound(), r17.getLowerBound()) == true) goto L12;
    L29:
        return false;
    L19:
        r18 = null;
        goto L21
    L39:
        return true;
    L8:
        if (((Collection) r5).isEmpty() == false) goto L10;
        return true;
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType asMemberOf(XType r5) {
        return asMemberOf(r5);
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType getExecutableType() {
        return getExecutableType();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public String getJvmName() {
        return m56getElement().getSimpleName().toString();
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableElement
    public /* bridge */ /* synthetic */ KmExecutable getKotlinMetadata() {
        return getKotlinMetadata();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return (String) this.name$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableElement, androidx.room.compiler.processing.XExecutableElement
    public List<JavacMethodParameter> getParameters() {
        return (List) this.parameters$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public /* bridge */ /* synthetic */ XType getReturnType() {
        return getReturnType();
    }

    @Override // androidx.room.compiler.processing.XParameterizable
    public List<XTypeParameterElement> getTypeParameters() {
        return (List) this.typeParameters$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean hasKotlinDefaultImpl() {
        JavacTypeElement r5 = getKotlinDefaultImplClass();
        if (r5 == null) goto L24;
        List<JavacMethodElement> r10 = r5.getDeclaredMethods();
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.isEmpty() == true) goto L26;
        Iterator<T> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L27;
        JavacMethodElement r12 = (JavacMethodElement) r11.next();
        if (Intrinsics.areEqual(r12.getJvmName(), getJvmName()) == false) goto L11;
        if (hasKotlinDefaultImpl$paramsMatch(this, getParameters(), r12.getParameters()) == false) goto L11;
        return true;
    L27:
        return false;
    L26:
        return false;
    L24:
        return false;
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean isExtensionFunction() {
        KmFunction r5 = getKotlinMetadata();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isExtension() == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean isJavaDefault() {
        return m56getElement().getModifiers().contains(Modifier.DEFAULT);
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean isSuspendFunction() {
        KmFunction r5 = getKotlinMetadata();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isSuspend() == true) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public boolean overrides(XMethodElement r5, XTypeElement r10) {
        Intrinsics.checkNotNullParameter(r5, "other");
        Intrinsics.checkNotNullParameter(r10, "owner");
        if ((r5 instanceof JavacMethodElement) == false) goto L19;
        if ((r10 instanceof JavacTypeElement) == false) goto L17;
        if (getEnv$room_compiler_processing().getBackend() == XProcessingEnv.Backend.JAVAC) goto L9;
    L14:
        ExecutableElement r11 = m56getElement();
        ExecutableElement r12 = ((JavacMethodElement) r5).m56getElement();
        TypeElement r13 = ((JavacTypeElement) r10).m57getElement();
        return new q0(getEnv$room_compiler_processing().getTypeUtils()).w(r11, r12, r13);
    L9:
        if (isSuspendFunction() == false) goto L14;
        if (r5.isSuspendFunction() == false) goto L14;
        return ElementExtKt.suspendOverrides(m56getElement(), ((JavacMethodElement) r5).m56getElement(), ((JavacTypeElement) r10).m57getElement(), getEnv$room_compiler_processing().getTypeUtils());
    L17:
        throw new IllegalStateException("Check failed.");
    L19:
        throw new IllegalStateException("Check failed.");
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public XMethodType asMemberOf(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof JavacDeclaredType) == false) goto L9;
        if (getEnclosingElement().getType().isSameType(r5) == true) goto L9;
        TypeMirror r10 = getEnv$room_compiler_processing().getTypeUtils().asMemberOf(((JavacDeclaredType) r5).getTypeMirror(), m56getElement());
        return JavacMethodType.Companion.create(getEnv$room_compiler_processing(), this, o0.d(r10));
    L9:
        return getExecutableType();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XMethodType getExecutableType() {
        return getExecutableType();
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableElement
    public KmFunction getKotlinMetadata() {
        return (KmFunction) this.kotlinMetadata$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XMethodElement
    public JavacType getReturnType() {
        return (JavacType) this.returnType$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public JavacMethodType getExecutableType() {
        return (JavacMethodType) this.executableType$delegate.getValue();
    }
}
