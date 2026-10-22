package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XConstructorElement;
import androidx.room.compiler.processing.XConstructorType;
import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.compiler.processing.XTypeParameterElement;
import androidx.room.compiler.processing.javac.kotlin.KmConstructor;
import androidx.room.compiler.processing.javac.kotlin.KmExecutable;
import com.google.auto.common.o0;
import java.util.List;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeMirror;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#H\u0016R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b\u001f\u0010\u001b¨\u0006$"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacConstructorElement;", "Landroidx/room/compiler/processing/javac/JavacExecutableElement;", "Landroidx/room/compiler/processing/XConstructorElement;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Ljavax/lang/model/element/ExecutableElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/ExecutableElement;)V", "executableType", "Landroidx/room/compiler/processing/XConstructorType;", "getExecutableType", "()Landroidx/room/compiler/processing/XConstructorType;", "executableType$delegate", "Lkotlin/Lazy;", "kotlinMetadata", "Landroidx/room/compiler/processing/javac/kotlin/KmConstructor;", "getKotlinMetadata", "()Landroidx/room/compiler/processing/javac/kotlin/KmConstructor;", "kotlinMetadata$delegate", "name", "", "getName", "()Ljava/lang/String;", "parameters", "", "Landroidx/room/compiler/processing/javac/JavacMethodParameter;", "getParameters", "()Ljava/util/List;", "parameters$delegate", "typeParameters", "Landroidx/room/compiler/processing/XTypeParameterElement;", "getTypeParameters", "typeParameters$delegate", "asMemberOf", "other", "Landroidx/room/compiler/processing/XType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacConstructorElement extends JavacExecutableElement implements XConstructorElement {
    private final Lazy executableType$delegate;
    private final Lazy kotlinMetadata$delegate;
    private final Lazy parameters$delegate;
    private final Lazy typeParameters$delegate;

    public JavacConstructorElement(final JavacProcessingEnv r5, final ExecutableElement r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        super(r5, r10);
        if (r10.getKind() != ElementKind.CONSTRUCTOR) goto L7;
        this.typeParameters$delegate = LazyKt.lazy(new JavacConstructorElement$typeParameters$2(r10, r5, this));
        this.parameters$delegate = LazyKt.lazy(new JavacConstructorElement$parameters$2(r10, r5, this));
        this.executableType$delegate = LazyKt.lazy(new JavacConstructorElement$executableType$2(r5, this, r10));
        this.kotlinMetadata$delegate = LazyKt.lazy(new JavacConstructorElement$kotlinMetadata$2(this, r10));
        return;
    L7:
        throw new IllegalStateException(("Constructor element is constructed with invalid type: " + r10).toString());
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType asMemberOf(XType r5) {
        return asMemberOf(r5);
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableElement, androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XTypeElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public /* bridge */ /* synthetic */ XExecutableType getExecutableType() {
        return getExecutableType();
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableElement
    public /* bridge */ /* synthetic */ KmExecutable getKotlinMetadata() {
        return getKotlinMetadata();
    }

    @Override // androidx.room.compiler.processing.XElement
    public String getName() {
        return "<init>";
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableElement, androidx.room.compiler.processing.XExecutableElement
    public List<JavacMethodParameter> getParameters() {
        return (List) this.parameters$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XParameterizable
    public List<XTypeParameterElement> getTypeParameters() {
        return (List) this.typeParameters$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public XConstructorType asMemberOf(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof JavacDeclaredType) == false) goto L9;
        if (getEnclosingElement().getType().isSameType(r5) == true) goto L9;
        TypeMirror r10 = getEnv$room_compiler_processing().getTypeUtils().asMemberOf(((JavacDeclaredType) r5).getTypeMirror(), m56getElement());
        return new JavacConstructorType(getEnv$room_compiler_processing(), this, o0.d(r10));
    L9:
        return getExecutableType();
    }

    @Override // androidx.room.compiler.processing.XExecutableElement
    public XConstructorType getExecutableType() {
        return (XConstructorType) this.executableType$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableElement
    public KmConstructor getKotlinMetadata() {
        return (KmConstructor) this.kotlinMetadata$delegate.getValue();
    }
}
