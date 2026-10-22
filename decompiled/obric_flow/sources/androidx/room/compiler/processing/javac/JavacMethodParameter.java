package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XElement;
import androidx.room.compiler.processing.XExecutableElement;
import androidx.room.compiler.processing.XExecutableParameterElement;
import androidx.room.compiler.processing.XMemberContainer;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import androidx.room.compiler.processing.javac.kotlin.KmValueParameter;
import androidx.room.compiler.processing.util.NamingUtilsKt;
import javax.lang.model.element.VariableElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001c¨\u0006+"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacMethodParameter;", "Landroidx/room/compiler/processing/javac/JavacVariableElement;", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "enclosingElement", "Landroidx/room/compiler/processing/javac/JavacExecutableElement;", "element", "Ljavax/lang/model/element/VariableElement;", "kotlinMetadataFactory", "Lkotlin/Function0;", "Landroidx/room/compiler/processing/javac/kotlin/KmValueParameter;", "argIndex", "", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/javac/JavacExecutableElement;Ljavax/lang/model/element/VariableElement;Lkotlin/jvm/functions/Function0;I)V", "getArgIndex", "()I", "closestMemberContainer", "Landroidx/room/compiler/processing/XMemberContainer;", "getClosestMemberContainer", "()Landroidx/room/compiler/processing/XMemberContainer;", "closestMemberContainer$delegate", "Lkotlin/Lazy;", "getEnclosingElement", "()Landroidx/room/compiler/processing/javac/JavacExecutableElement;", "fallbackLocationText", "", "getFallbackLocationText", "()Ljava/lang/String;", "hasDefaultValue", "", "getHasDefaultValue", "()Z", "kotlinMetadata", "getKotlinMetadata", "()Landroidx/room/compiler/processing/javac/kotlin/KmValueParameter;", "kotlinMetadata$delegate", "kotlinType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "getKotlinType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "name", "getName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacMethodParameter extends JavacVariableElement implements XExecutableParameterElement {
    private final int argIndex;
    private final Lazy closestMemberContainer$delegate;
    private final JavacExecutableElement enclosingElement;
    private final Lazy kotlinMetadata$delegate;

    public JavacMethodParameter(JavacProcessingEnv r5, JavacExecutableElement r10, VariableElement r11, final Function0<KmValueParameter> r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "enclosingElement");
        Intrinsics.checkNotNullParameter(r11, "element");
        Intrinsics.checkNotNullParameter(r12, "kotlinMetadataFactory");
        super(r5, r11);
        this.enclosingElement = r10;
        this.argIndex = r13;
        this.kotlinMetadata$delegate = LazyKt.lazy(new JavacMethodParameter$kotlinMetadata$2(r12));
        this.closestMemberContainer$delegate = LazyKt.lazy(new JavacMethodParameter$closestMemberContainer$2(this));
    }

    private final KmValueParameter getKotlinMetadata() {
        return (KmValueParameter) this.kotlinMetadata$delegate.getValue();
    }

    public final int getArgIndex() {
        return this.argIndex;
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
        if ((getEnclosingElement() instanceof JavacMethodElement) == false) goto L10;
        if (((JavacMethodElement) getEnclosingElement()).isSuspendFunction() == false) goto L10;
        if (this != CollectionsKt.last(getEnclosingElement().getParameters())) goto L10;
        return "return type of " + getEnclosingElement().getFallbackLocationText();
    L10:
        return getName() + " in " + getEnclosingElement().getFallbackLocationText();
    }

    @Override // androidx.room.compiler.processing.XExecutableParameterElement
    public boolean getHasDefaultValue() {
        KmValueParameter r5 = getKotlinMetadata();
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.hasDefault();
    }

    @Override // androidx.room.compiler.processing.javac.JavacVariableElement
    public KmType getKotlinType() {
        KmValueParameter r5 = getKotlinMetadata();
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getType();
    }

    @Override // androidx.room.compiler.processing.javac.JavacVariableElement, androidx.room.compiler.processing.XElement
    public String getName() {
        KmValueParameter r5 = getKotlinMetadata();
        if (r5 == null) goto L6;
        String r10 = r5.getName();
        if (r10 == null) goto L6;
    L8:
        return NamingUtilsKt.sanitizeAsJavaParameterName(r10, this.argIndex);
    L6:
        r10 = super.getName();
        goto L8
    }

    @Override // androidx.room.compiler.processing.XElement
    public /* bridge */ /* synthetic */ XExecutableElement getEnclosingElement() {
        return getEnclosingElement();
    }

    @Override // androidx.room.compiler.processing.XElement
    public JavacExecutableElement getEnclosingElement() {
        return this.enclosingElement;
    }
}
