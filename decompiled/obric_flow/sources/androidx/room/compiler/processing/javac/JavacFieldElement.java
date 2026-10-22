package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XFieldElement;
import androidx.room.compiler.processing.XHasModifiers;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.javac.kotlin.KmProperty;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001c\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001d\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001bH\u0096\u0001J\t\u0010\u001f\u001a\u00020\u001bH\u0096\u0001J\t\u0010 \u001a\u00020\u001bH\u0096\u0001J\t\u0010!\u001a\u00020\u001bH\u0096\u0001R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Landroidx/room/compiler/processing/javac/JavacFieldElement;", "Landroidx/room/compiler/processing/javac/JavacVariableElement;", "Landroidx/room/compiler/processing/XFieldElement;", "Landroidx/room/compiler/processing/XHasModifiers;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Ljavax/lang/model/element/VariableElement;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/element/VariableElement;)V", "closestMemberContainer", "Landroidx/room/compiler/processing/javac/JavacTypeElement;", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/javac/JavacTypeElement;", "enclosingElement", "getEnclosingElement", "enclosingElement$delegate", "Lkotlin/Lazy;", "kotlinMetadata", "Landroidx/room/compiler/processing/javac/kotlin/KmProperty;", "getKotlinMetadata", "()Landroidx/room/compiler/processing/javac/kotlin/KmProperty;", "kotlinMetadata$delegate", "kotlinType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getKotlinType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "isAbstract", "", "isFinal", "isPrivate", "isProtected", "isPublic", "isStatic", "isTransient", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacFieldElement extends JavacVariableElement implements XFieldElement, XHasModifiers {
    private final /* synthetic */ JavacHasModifiers $$delegate_0;
    private final Lazy enclosingElement$delegate;
    private final Lazy kotlinMetadata$delegate;

    public JavacFieldElement(final JavacProcessingEnv r5, final VariableElement r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        super(r5, r10);
        this.$$delegate_0 = new JavacHasModifiers((Element) r10);
        this.kotlinMetadata$delegate = LazyKt.lazy(new JavacFieldElement$kotlinMetadata$2(this));
        this.enclosingElement$delegate = LazyKt.lazy(new JavacFieldElement$enclosingElement$2(r10, r5));
    }

    private final KmProperty getKotlinMetadata() {
        return (KmProperty) this.kotlinMetadata$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XMemberContainer getClosestMemberContainer() {
        return getClosestMemberContainer();
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.javac.JavacVariableElement
    public KmType getKotlinType() {
        KmProperty r5 = getKotlinMetadata();
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getType();
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

    @Override // androidx.room.compiler.processing.XElement
    public JavacTypeElement getClosestMemberContainer() {
        return getEnclosingElement();
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
