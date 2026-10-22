package androidx.room.compiler.processing.javac;

import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import java.util.List;
import javax.lang.model.type.TypeMirror;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0014R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/room/compiler/processing/javac/DefaultJavacType;", "Landroidx/room/compiler/processing/javac/JavacType;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "typeMirror", "Ljavax/lang/model/type/TypeMirror;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/TypeMirror;)V", "kotlinType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/TypeMirror;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "nullability", "Landroidx/room/compiler/processing/XNullability;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/TypeMirror;Landroidx/room/compiler/processing/XNullability;)V", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/TypeMirror;Landroidx/room/compiler/processing/XNullability;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "equalityItems", "", "getEqualityItems", "()[Ljavax/lang/model/type/TypeMirror;", "equalityItems$delegate", "Lkotlin/Lazy;", "getKotlinType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "typeArguments", "", "Landroidx/room/compiler/processing/XType;", "getTypeArguments", "()Ljava/util/List;", "copyWithNullability", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DefaultJavacType extends JavacType {
    private final Lazy equalityItems$delegate;
    private final KmType kotlinType;

    private DefaultJavacType(JavacProcessingEnv r5, final TypeMirror r10, XNullability r11, KmType r12) {
        super(r5, r10, r11);
        this.kotlinType = r12;
        this.equalityItems$delegate = LazyKt.lazy(new DefaultJavacType$equalityItems$2(r10));
    }

    @Override // androidx.room.compiler.processing.javac.JavacType
    public JavacType copyWithNullability(XNullability r5) {
        Intrinsics.checkNotNullParameter(r5, "nullability");
        return new DefaultJavacType(getEnv$room_compiler_processing(), mo55getTypeMirror(), r5, getKotlinType());
    }

    @Override // androidx.room.compiler.processing.XEquality
    public /* bridge */ /* synthetic */ Object[] getEqualityItems() {
        return getEqualityItems();
    }

    @Override // androidx.room.compiler.processing.javac.JavacType
    public KmType getKotlinType() {
        return this.kotlinType;
    }

    @Override // androidx.room.compiler.processing.XType
    public List<XType> getTypeArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.XEquality
    public TypeMirror[] getEqualityItems() {
        return (TypeMirror[]) this.equalityItems$delegate.getValue();
    }

    public DefaultJavacType(JavacProcessingEnv r5, TypeMirror r10) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "typeMirror");
        this(r5, r10, null, null);
    }

    public DefaultJavacType(JavacProcessingEnv r5, TypeMirror r10, KmType r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "typeMirror");
        Intrinsics.checkNotNullParameter(r11, "kotlinType");
        this(r5, r10, KmTypeExtKt.getNullability(r11), r11);
    }

    public DefaultJavacType(JavacProcessingEnv r5, TypeMirror r10, XNullability r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "typeMirror");
        Intrinsics.checkNotNullParameter(r11, "nullability");
        this(r5, r10, r11, null);
    }
}
