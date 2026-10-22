package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XConstructorType;
import javax.lang.model.type.ExecutableType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacConstructorType;", "Landroidx/room/compiler/processing/javac/JavacExecutableType;", "Landroidx/room/compiler/processing/XConstructorType;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Landroidx/room/compiler/processing/javac/JavacConstructorElement;", "executableType", "Ljavax/lang/model/type/ExecutableType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/javac/JavacConstructorElement;Ljavax/lang/model/type/ExecutableType;)V", "getElement", "()Landroidx/room/compiler/processing/javac/JavacConstructorElement;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacConstructorType extends JavacExecutableType implements XConstructorType {
    private final JavacConstructorElement element;

    public JavacConstructorType(JavacProcessingEnv r5, JavacConstructorElement r10, ExecutableType r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "executableType");
        super(r5, r10, r11);
        this.element = r10;
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableType
    public /* bridge */ /* synthetic */ JavacExecutableElement getElement() {
        return getElement();
    }

    @Override // androidx.room.compiler.processing.javac.JavacExecutableType
    public JavacConstructorElement getElement() {
        return this.element;
    }
}
