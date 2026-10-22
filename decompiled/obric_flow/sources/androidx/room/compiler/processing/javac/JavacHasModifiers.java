package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XHasModifiers;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacHasModifiers;", "Landroidx/room/compiler/processing/XHasModifiers;", "element", "Ljavax/lang/model/element/Element;", "(Ljavax/lang/model/element/Element;)V", "isAbstract", "", "isFinal", "isPrivate", "isProtected", "isPublic", "isStatic", "isTransient", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacHasModifiers implements XHasModifiers {
    private final Element element;

    public JavacHasModifiers(Element r5) {
        Intrinsics.checkNotNullParameter(r5, "element");
        this.element = r5;
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isAbstract() {
        return this.element.getModifiers().contains(Modifier.ABSTRACT);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isFinal() {
        return this.element.getModifiers().contains(Modifier.FINAL);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPrivate() {
        return this.element.getModifiers().contains(Modifier.PRIVATE);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isProtected() {
        return this.element.getModifiers().contains(Modifier.PROTECTED);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isPublic() {
        return this.element.getModifiers().contains(Modifier.PUBLIC);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isStatic() {
        return this.element.getModifiers().contains(Modifier.STATIC);
    }

    @Override // androidx.room.compiler.processing.XHasModifiers
    public boolean isTransient() {
        return this.element.getModifiers().contains(Modifier.TRANSIENT);
    }
}
