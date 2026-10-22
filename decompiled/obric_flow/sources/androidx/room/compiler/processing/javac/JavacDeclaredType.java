package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import java.util.List;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0014R%\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacDeclaredType;", "Landroidx/room/compiler/processing/javac/JavacType;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "typeMirror", "Ljavax/lang/model/type/DeclaredType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/DeclaredType;)V", "kotlinType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/DeclaredType;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "nullability", "Landroidx/room/compiler/processing/XNullability;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/DeclaredType;Landroidx/room/compiler/processing/XNullability;)V", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/DeclaredType;Landroidx/room/compiler/processing/XNullability;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "equalityItems", "", "", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems$delegate", "Lkotlin/Lazy;", "getKotlinType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "typeArguments", "", "getTypeArguments", "()Ljava/util/List;", "typeArguments$delegate", "getTypeMirror", "()Ljavax/lang/model/type/DeclaredType;", "copyWithNullability", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacDeclaredType extends JavacType {
    private final Lazy equalityItems$delegate;
    private final KmType kotlinType;
    private final Lazy typeArguments$delegate;
    private final DeclaredType typeMirror;

    private JavacDeclaredType(final JavacProcessingEnv r5, DeclaredType r10, XNullability r11, KmType r12) {
        super(r5, (TypeMirror) r10, r11);
        this.typeMirror = r10;
        this.kotlinType = r12;
        this.equalityItems$delegate = LazyKt.lazy(new JavacDeclaredType$equalityItems$2(this));
        this.typeArguments$delegate = LazyKt.lazy(new JavacDeclaredType$typeArguments$2(this, r5));
    }

    @Override // androidx.room.compiler.processing.javac.JavacType
    public /* bridge */ /* synthetic */ JavacType copyWithNullability(XNullability r5) {
        return copyWithNullability(r5);
    }

    @Override // androidx.room.compiler.processing.XEquality
    public Object[] getEqualityItems() {
        return (Object[]) this.equalityItems$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.javac.JavacType
    public KmType getKotlinType() {
        return this.kotlinType;
    }

    @Override // androidx.room.compiler.processing.XType
    public List<JavacType> getTypeArguments() {
        return (List) this.typeArguments$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.javac.JavacType
    /* JADX INFO: renamed from: getTypeMirror */
    public /* bridge */ /* synthetic */ TypeMirror mo55getTypeMirror() {
        return getTypeMirror();
    }

    @Override // androidx.room.compiler.processing.javac.JavacType
    public JavacDeclaredType copyWithNullability(XNullability r5) {
        Intrinsics.checkNotNullParameter(r5, "nullability");
        return new JavacDeclaredType(getEnv$room_compiler_processing(), getTypeMirror(), r5, getKotlinType());
    }

    public DeclaredType getTypeMirror() {
        return this.typeMirror;
    }

    public JavacDeclaredType(JavacProcessingEnv r5, DeclaredType r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "typeMirror");
        this(r5, r10, null, null);
    }

    public JavacDeclaredType(JavacProcessingEnv r5, DeclaredType r10, KmType r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "typeMirror");
        Intrinsics.checkNotNullParameter(r11, "kotlinType");
        this(r5, r10, KmTypeExtKt.getNullability(r11), r11);
    }

    public JavacDeclaredType(JavacProcessingEnv r5, DeclaredType r10, XNullability r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "typeMirror");
        Intrinsics.checkNotNullParameter(r11, "nullability");
        this(r5, r10, r11, null);
    }
}
