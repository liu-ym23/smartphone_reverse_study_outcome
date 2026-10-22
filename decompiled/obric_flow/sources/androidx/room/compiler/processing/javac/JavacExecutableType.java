package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XExecutableType;
import androidx.room.compiler.processing.XType;
import java.util.List;
import javax.lang.model.type.ExecutableType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001H\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013¨\u0006\""}, d2 = {"Landroidx/room/compiler/processing/javac/JavacExecutableType;", "Landroidx/room/compiler/processing/XExecutableType;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "element", "Landroidx/room/compiler/processing/javac/JavacExecutableElement;", "executableType", "Ljavax/lang/model/type/ExecutableType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Landroidx/room/compiler/processing/javac/JavacExecutableElement;Ljavax/lang/model/type/ExecutableType;)V", "getElement", "()Landroidx/room/compiler/processing/javac/JavacExecutableElement;", "getEnv", "()Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "getExecutableType", "()Ljavax/lang/model/type/ExecutableType;", "parameterTypes", "", "Landroidx/room/compiler/processing/javac/JavacType;", "getParameterTypes", "()Ljava/util/List;", "parameterTypes$delegate", "Lkotlin/Lazy;", "thrownTypes", "Landroidx/room/compiler/processing/XType;", "getThrownTypes", "equals", "", "other", "", "hashCode", "", "isSameType", "toString", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JavacExecutableType implements XExecutableType {
    private final JavacExecutableElement element;
    private final JavacProcessingEnv env;
    private final ExecutableType executableType;
    private final Lazy parameterTypes$delegate;

    public JavacExecutableType(JavacProcessingEnv r5, JavacExecutableElement r10, ExecutableType r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "element");
        Intrinsics.checkNotNullParameter(r11, "executableType");
        this.env = r5;
        this.element = r10;
        this.executableType = r11;
        this.parameterTypes$delegate = LazyKt.lazy(new JavacExecutableType$parameterTypes$2(this));
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof JavacExecutableType) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.executableType, ((JavacExecutableType) r5).executableType);
    }

    public JavacExecutableElement getElement() {
        return this.element;
    }

    public final JavacProcessingEnv getEnv() {
        return this.env;
    }

    public final ExecutableType getExecutableType() {
        return this.executableType;
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public List<JavacType> getParameterTypes() {
        return (List) this.parameterTypes$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public List<XType> getThrownTypes() {
        return getElement().getThrownTypes();
    }

    public int hashCode() {
        return this.executableType.hashCode();
    }

    @Override // androidx.room.compiler.processing.XExecutableType
    public boolean isSameType(XExecutableType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof JavacExecutableType) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.env.getTypeUtils().isSameType(this.executableType, ((JavacExecutableType) r5).executableType) == false) goto L7;
        return true;
    }

    public String toString() {
        return this.executableType.toString();
    }
}
