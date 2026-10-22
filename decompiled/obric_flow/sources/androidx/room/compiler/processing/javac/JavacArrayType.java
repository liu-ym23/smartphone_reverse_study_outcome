package androidx.room.compiler.processing.javac;

import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.javac.kotlin.KmType;
import java.util.List;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.TypeMirror;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000eB5\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\b\u0010)\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u001b\u0010\u0010\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0016\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Landroidx/room/compiler/processing/javac/JavacArrayType;", "Landroidx/room/compiler/processing/javac/JavacType;", "Landroidx/room/compiler/processing/XArrayType;", "env", "Landroidx/room/compiler/processing/javac/JavacProcessingEnv;", "typeMirror", "Ljavax/lang/model/type/ArrayType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/ArrayType;)V", "kotlinType", "Landroidx/room/compiler/processing/javac/kotlin/KmType;", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/ArrayType;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "nullability", "Landroidx/room/compiler/processing/XNullability;", "knownComponentNullability", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/ArrayType;Landroidx/room/compiler/processing/XNullability;Landroidx/room/compiler/processing/XNullability;)V", "(Landroidx/room/compiler/processing/javac/JavacProcessingEnv;Ljavax/lang/model/type/ArrayType;Landroidx/room/compiler/processing/XNullability;Landroidx/room/compiler/processing/XNullability;Landroidx/room/compiler/processing/javac/kotlin/KmType;)V", "componentType", "Landroidx/room/compiler/processing/XType;", "getComponentType", "()Landroidx/room/compiler/processing/XType;", "componentType$delegate", "Lkotlin/Lazy;", "equalityItems", "", "", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems$delegate", "getKotlinType", "()Landroidx/room/compiler/processing/javac/kotlin/KmType;", "typeArguments", "", "getTypeArguments", "()Ljava/util/List;", "getTypeMirror", "()Ljavax/lang/model/type/ArrayType;", "xTypeName", "Landroidx/room/compiler/codegen/XTypeName;", "getXTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "xTypeName$delegate", "asTypeName", "copyWithNullability", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JavacArrayType extends JavacType implements XArrayType {
    private final Lazy componentType$delegate;
    private final Lazy equalityItems$delegate;
    private final XNullability knownComponentNullability;
    private final KmType kotlinType;
    private final ArrayType typeMirror;
    private final Lazy xTypeName$delegate;

    private JavacArrayType(final JavacProcessingEnv r5, ArrayType r10, XNullability r11, XNullability r12, KmType r13) {
        super(r5, (TypeMirror) r10, r11);
        this.typeMirror = r10;
        this.knownComponentNullability = r12;
        this.kotlinType = r13;
        this.equalityItems$delegate = LazyKt.lazy(new JavacArrayType$equalityItems$2(this));
        this.xTypeName$delegate = LazyKt.lazy(new JavacArrayType$xTypeName$2(this));
        this.componentType$delegate = LazyKt.lazy(new JavacArrayType$componentType$2(this, r5));
    }

    public static final /* synthetic */ XNullability access$getKnownComponentNullability$p(JavacArrayType r5) {
        return r5.knownComponentNullability;
    }

    private final XTypeName getXTypeName() {
        return (XTypeName) this.xTypeName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.javac.JavacType, androidx.room.compiler.processing.XType
    public XTypeName asTypeName() {
        return getXTypeName();
    }

    @Override // androidx.room.compiler.processing.javac.JavacType
    public JavacType copyWithNullability(XNullability r10) {
        Intrinsics.checkNotNullParameter(r10, "nullability");
        return new JavacArrayType(getEnv$room_compiler_processing(), getTypeMirror(), r10, this.knownComponentNullability, getKotlinType());
    }

    @Override // androidx.room.compiler.processing.XArrayType
    public XType getComponentType() {
        return (XType) this.componentType$delegate.getValue();
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
    public List<XType> getTypeArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.javac.JavacType
    /* JADX INFO: renamed from: getTypeMirror, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ TypeMirror mo55getTypeMirror() {
        return getTypeMirror();
    }

    public ArrayType getTypeMirror() {
        return this.typeMirror;
    }

    public JavacArrayType(JavacProcessingEnv r10, ArrayType r11) {
        Intrinsics.checkNotNullParameter(r10, "env");
        Intrinsics.checkNotNullParameter(r11, "typeMirror");
        this(r10, r11, null, null, null);
    }

    public JavacArrayType(JavacProcessingEnv r10, ArrayType r11, KmType r12) {
        Intrinsics.checkNotNullParameter(r10, "env");
        Intrinsics.checkNotNullParameter(r11, "typeMirror");
        Intrinsics.checkNotNullParameter(r12, "kotlinType");
        XNullability r5 = KmTypeExtKt.getNullability(r12);
        KmType r13 = (KmType) CollectionsKt.firstOrNull(r12.getTypeArguments());
        if (r13 == null) goto L6;
        XNullability r14 = KmTypeExtKt.getNullability(r13);
    L7:
        this(r10, r11, r5, r14, r12);
        return;
    L6:
        r14 = null;
        goto L7
    }

    public JavacArrayType(JavacProcessingEnv r10, ArrayType r11, XNullability r12, XNullability r13) {
        Intrinsics.checkNotNullParameter(r10, "env");
        Intrinsics.checkNotNullParameter(r11, "typeMirror");
        Intrinsics.checkNotNullParameter(r12, "nullability");
        this(r10, r11, r12, r13, null);
    }
}
