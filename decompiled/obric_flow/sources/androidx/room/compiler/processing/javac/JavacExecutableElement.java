package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XHasModifiers;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.javac.kotlin.KmExecutable;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b \u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010%\u001a\u00020&H\u0096\u0001J\t\u0010'\u001a\u00020&H\u0096\u0001J\t\u0010(\u001a\u00020&H\u0096\u0001J\t\u0010)\u001a\u00020&H\u0096\u0001J\t\u0010*\u001a\u00020&H\u0096\u0001J\t\u0010+\u001a\u00020&H\u0096\u0001J\t\u0010,\u001a\u00020&H\u0096\u0001J\b\u0010-\u001a\u00020&H\u0016R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0016\u0010\fR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b#\u0010 ¨\u0006/"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacExecutableElement;", "Landroidx/room/compiler/processing/javac/JavacElement;", "Landroidx/room/compiler/processing/XExecutableElement;", "Landroidx/room/compiler/processing/XHasModifiers;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Ljavax/lang/model/element/ExecutableElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/ExecutableElement;)V", "closestMemberContainer", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/javac/JavacTypeElement;", "descriptor", "", "getDescriptor", "()Ljava/lang/String;", "descriptor$delegate", "Lkotlin/Lazy;", "getElement", "()Ljavax/lang/model/element/ExecutableElement;", "enclosingElement", "getEnclosingElement", "enclosingElement$delegate", "kotlinMetadata", "Landroidx/room/compiler/processing/javac/kotlin/KmExecutable;", "getKotlinMetadata", "()Landroidx/room/compiler/processing/javac/kotlin/KmExecutable;", "parameters", "", "Landroidx/room/compiler/processing/javac/JavacMethodParameter;", "getParameters", "()Ljava/util/List;", "thrownTypes", "Landroidx/room/compiler/processing/javac/JavacType;", "getThrownTypes", "thrownTypes$delegate", "isAbstract", "", "isFinal", "isPrivate", "isProtected", "isPublic", "isStatic", "isTransient", "isVarArgs", "Companion", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavacExecutableElement extends JavacElement implements XExecutableElement, XHasModifiers {
    public static final Companion Companion = null;
    public static final String DEFAULT_IMPLS_CLASS_NAME = "DefaultImpls";
    private final /* synthetic */ JavacHasModifiers $$delegate_0;
    private final Lazy descriptor$delegate;
    private final ExecutableElement element;
    private final Lazy enclosingElement$delegate;
    private final Lazy thrownTypes$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacExecutableElement$Companion;", "", "()V", "DEFAULT_IMPLS_CLASS_NAME", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public JavacExecutableElement(final JavacProcessingEnv r5, ExecutableElement r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        Element r11 = (Element) r10;
        super(r5, r11);
        this.element = r10;
        this.$$delegate_0 = new JavacHasModifiers(r11);
        this.descriptor$delegate = LazyKt.lazy(new JavacExecutableElement$descriptor$2(this));
        this.enclosingElement$delegate = LazyKt.lazy(new JavacExecutableElement$enclosingElement$2(this, r5));
        this.thrownTypes$delegate = LazyKt.lazy(new JavacExecutableElement$thrownTypes$2(this, r5));
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
    }

    public final String getDescriptor() {
        return (String) this.descriptor$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.javac.JavacElement
    public /* bridge */ /* synthetic */ Element getElement() {
        return m56getElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    public abstract KmExecutable getKotlinMetadata();

    public abstract List<JavacMethodParameter> getParameters();

    @Override // androidx.room.compiler.processing.XExecutableElement
    public List<JavacType> getThrownTypes() {
        return (List) this.thrownTypes$delegate.getValue();
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

    @Override // androidx.room.compiler.processing.XExecutableElement
    public boolean isVarArgs() {
        return m56getElement().isVarArgs();
    }

    @Override // androidx.room.compiler.processing.XElement
    public JavacTypeElement getClosestMemberContainer() {
        return getEnclosingElement();
    }

    /* JADX INFO: renamed from: getElement, reason: collision with other method in class */
    public ExecutableElement m56getElement() {
        return this.element;
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public JavacTypeElement getEnclosingElement() {
        return (JavacTypeElement) this.enclosingElement$delegate.getValue();
    }
}
