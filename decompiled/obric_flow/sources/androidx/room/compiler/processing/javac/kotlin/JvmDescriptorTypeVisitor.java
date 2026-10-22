package androidx.room.compiler.processing.javac.kotlin;

import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.UnionType;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.AbstractTypeVisitor8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010!J\u001d\u0010\"\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020#2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010$J\u001d\u0010%\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020&2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010'J\u001d\u0010(\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010*¨\u0006+"}, d2 = {"Landroidx/room/compiler/processing/javac/kotlin/JvmDescriptorTypeVisitor;", "Ljavax/lang/model/util/AbstractTypeVisitor8;", "", "", "()V", "visitArray", "t", "Ljavax/lang/model/type/ArrayType;", "u", "(Ljavax/lang/model/type/ArrayType;Lkotlin/Unit;)Ljava/lang/String;", "visitDeclared", "Ljavax/lang/model/type/DeclaredType;", "(Ljavax/lang/model/type/DeclaredType;Lkotlin/Unit;)Ljava/lang/String;", "visitError", "Ljavax/lang/model/type/ErrorType;", "(Ljavax/lang/model/type/ErrorType;Lkotlin/Unit;)Ljava/lang/String;", "visitExecutable", "Ljavax/lang/model/type/ExecutableType;", "(Ljavax/lang/model/type/ExecutableType;Lkotlin/Unit;)Ljava/lang/String;", "visitIntersection", "Ljavax/lang/model/type/IntersectionType;", "(Ljavax/lang/model/type/IntersectionType;Lkotlin/Unit;)Ljava/lang/String;", "visitNoType", "Ljavax/lang/model/type/NoType;", "(Ljavax/lang/model/type/NoType;Lkotlin/Unit;)Ljava/lang/String;", "visitNull", "Ljavax/lang/model/type/NullType;", "(Ljavax/lang/model/type/NullType;Lkotlin/Unit;)Ljava/lang/String;", "visitPrimitive", "Ljavax/lang/model/type/PrimitiveType;", "(Ljavax/lang/model/type/PrimitiveType;Lkotlin/Unit;)Ljava/lang/String;", "visitTypeVariable", "Ljavax/lang/model/type/TypeVariable;", "(Ljavax/lang/model/type/TypeVariable;Lkotlin/Unit;)Ljava/lang/String;", "visitUnion", "Ljavax/lang/model/type/UnionType;", "(Ljavax/lang/model/type/UnionType;Lkotlin/Unit;)Ljava/lang/String;", "visitUnknown", "Ljavax/lang/model/type/TypeMirror;", "(Ljavax/lang/model/type/TypeMirror;Lkotlin/Unit;)Ljava/lang/String;", "visitWildcard", "Ljavax/lang/model/type/WildcardType;", "(Ljavax/lang/model/type/WildcardType;Lkotlin/Unit;)Ljava/lang/String;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmDescriptorTypeVisitor extends AbstractTypeVisitor8<String, Unit> {
    public static final JvmDescriptorTypeVisitor INSTANCE = null;

    static {
        INSTANCE = new JvmDescriptorTypeVisitor();
    }

    private JvmDescriptorTypeVisitor() {
    }

    public /* bridge */ /* synthetic */ Object visitArray(ArrayType r5, Object r10) {
        return visitArray(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitDeclared(DeclaredType r5, Object r10) {
        return visitDeclared(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitError(ErrorType r5, Object r10) {
        return visitError(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitExecutable(ExecutableType r5, Object r10) {
        return visitExecutable(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitIntersection(IntersectionType r5, Object r10) {
        return visitIntersection(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitNoType(NoType r5, Object r10) {
        return visitNoType(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitNull(NullType r5, Object r10) {
        return visitNull(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitPrimitive(PrimitiveType r5, Object r10) {
        return visitPrimitive(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitTypeVariable(TypeVariable r5, Object r10) {
        return visitTypeVariable(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitUnion(UnionType r5, Object r10) {
        return visitUnion(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitUnknown(TypeMirror r5, Object r10) {
        return visitUnknown(r5, (Unit) r10);
    }

    public /* bridge */ /* synthetic */ Object visitWildcard(WildcardType r5, Object r10) {
        return visitWildcard(r5, (Unit) r10);
    }

    public String visitArray(ArrayType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return JvmDescriptorUtilsKt.descriptor(r5);
    }

    public String visitDeclared(DeclaredType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return JvmDescriptorUtilsKt.getDescriptor(r5);
    }

    public String visitError(ErrorType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        throw new TypeNotPresentException(r5.toString(), null);
    }

    public String visitExecutable(ExecutableType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return JvmDescriptorUtilsKt.descriptor(r5);
    }

    public String visitIntersection(IntersectionType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return JvmDescriptorUtilsKt.descriptor(r5);
    }

    public String visitNoType(NoType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return JvmDescriptorUtilsKt.getDescriptor(r5);
    }

    public String visitNull(NullType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return visitUnknown((TypeMirror) r5, r10);
    }

    public String visitPrimitive(PrimitiveType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return JvmDescriptorUtilsKt.getDescriptor(r5);
    }

    public String visitTypeVariable(TypeVariable r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return JvmDescriptorUtilsKt.descriptor(r5);
    }

    public String visitUnion(UnionType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return visitUnknown((TypeMirror) r5, r10);
    }

    public String visitUnknown(TypeMirror r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        throw new IllegalStateException(("Unsupported type " + r5).toString());
    }

    public String visitWildcard(WildcardType r5, Unit r10) {
        Intrinsics.checkNotNullParameter(r5, "t");
        Intrinsics.checkNotNullParameter(r10, "u");
        return JvmDescriptorUtilsKt.descriptor(r5);
    }
}
