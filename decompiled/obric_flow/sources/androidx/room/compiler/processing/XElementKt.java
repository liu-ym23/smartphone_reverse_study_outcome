package androidx.room.compiler.processing;

import androidx.room.compiler.processing.javac.JavacElement;
import androidx.room.compiler.processing.ksp.KSAnnotatedExtKt;
import androidx.room.compiler.processing.ksp.KspElement;
import androidx.room.compiler.processing.ksp.KspMemberContainer;
import androidx.room.compiler.processing.ksp.synthetic.KspSyntheticPropertyMethodElement;
import javax.lang.model.element.Element;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0001\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0002\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0003\u001a\u001b\u0010\n\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0004\u001a\u001b\u0010\f\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0005\u001a\u001b\u0010\u000e\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0000\u001a\u0004\u0010\u0000(\u0006\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0002H\u0000ò\u0001\u001c\n\u00020\u0003\n\u00020\u0005\n\u00020\u0007\n\u00020\t\n\u00020\u000b\n\u00020\r\n\u00020\u000f¨\u0006\u0012"}, d2 = {"isConstructor", "", "Landroidx/room/compiler/processing/XElement;", "Landroidx/room/compiler/processing/XConstructorElement;", "isEnum", "Landroidx/room/compiler/processing/XEnumTypeElement;", "isField", "Landroidx/room/compiler/processing/XFieldElement;", "isMethod", "Landroidx/room/compiler/processing/XMethodElement;", "isMethodParameter", "Landroidx/room/compiler/processing/XExecutableParameterElement;", "isTypeElement", "Landroidx/room/compiler/processing/XTypeElement;", "isVariableElement", "Landroidx/room/compiler/processing/XVariableElement;", "originatingElementForPoet", "Ljavax/lang/model/element/Element;", "room-compiler-processing"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XElementKt {
    public static final boolean isConstructor(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XConstructorElement;
    }

    public static final boolean isEnum(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XEnumTypeElement;
    }

    public static final boolean isField(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XFieldElement;
    }

    public static final boolean isMethod(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XMethodElement;
    }

    public static final boolean isMethodParameter(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XExecutableParameterElement;
    }

    public static final boolean isTypeElement(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XTypeElement;
    }

    public static final boolean isVariableElement(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5 instanceof XVariableElement;
    }

    public static final Element originatingElementForPoet(XElement r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof JavacElement) == false) goto L6;
        return ((JavacElement) r5).getElement();
    L6:
        if ((r5 instanceof KspElement) == false) goto L9;
        return KSAnnotatedExtKt.wrapAsOriginatingElement(((KspElement) r5).getDeclaration());
    L9:
        if ((r5 instanceof KspSyntheticPropertyMethodElement) == false) goto L12;
        ((KspSyntheticPropertyMethodElement) r5).getField().getDeclaration();
        return KSAnnotatedExtKt.wrapAsOriginatingElement(null);
    L12:
        if ((r5 instanceof KspMemberContainer) == false) goto L16;
        ((KspMemberContainer) r5).getDeclaration();
        Element r10 = (Element) null;
        return null;
    L16:
        throw new IllegalStateException(("Originating element is not implemented for " + r5.getClass()).toString());
    }
}
