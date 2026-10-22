package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.JavaPoetExtKt;
import androidx.room.compiler.processing.XEquality;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XRawType;
import androidx.room.compiler.processing.XType;
import androidx.room.compiler.processing.XTypeElement;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.a0;
import il.p;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH$¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H$¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u001b\u0010!\u001a\u00020\u00172\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030 H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b#\u0010\u0019J\u0011\u0010$\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010&H\u0096\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u001cH\u0016¢\u0006\u0004\b,\u0010\u001eJ\u000f\u0010-\u001a\u00020\u0000H&¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020/¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00002\u0006\u00105\u001a\u000204H$¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u0000¢\u0006\u0004\b8\u0010.J\r\u00109\u001a\u00020\u0000¢\u0006\u0004\b9\u0010.R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010=\u001a\u0004\b>\u0010?R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\b\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020C8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u001b\u0010K\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010E\u001a\u0004\bJ\u0010\u0011R\u001b\u0010N\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010E\u001a\u0004\bM\u0010\rR\u001d\u0010Q\u001a\u0004\u0018\u00010\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010E\u001a\u0004\bP\u0010.R\u001b\u00105\u001a\u0002048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u0010E\u001a\u0004\bS\u0010TR!\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00010U8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bV\u0010E\u001a\u0004\bW\u0010XR\u001d\u0010^\u001a\u0004\u0018\u00010Z8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b[\u0010E\u001a\u0004\b\\\u0010]R'\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00010U8VX\u0096\u0084\u0002¢\u0006\u0012\n\u0004\b_\u0010E\u0012\u0004\ba\u0010b\u001a\u0004\b`\u0010XR%\u0010h\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010&0d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\be\u0010E\u001a\u0004\bf\u0010gR\u0014\u0010j\u001a\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bi\u0010.¨\u0006k"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/XType;", "Landroidx/room/compiler/processing/XEquality;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/p;", "ksType", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "jvmTypeResolver", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/p;Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)V", "Landroidx/room/compiler/codegen/XTypeName;", "asTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "resolveJTypeName", "()Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "resolveKTypeName", "()Lcom/squareup/kotlinpoet/a0;", "other", "", "isAssignableFrom", "(Landroidx/room/compiler/processing/XType;)Z", "isError", "()Z", "", "defaultValue", "()Ljava/lang/String;", "isNone", "Lkotlin/reflect/KClass;", "isTypeOf", "(Lkotlin/reflect/KClass;)Z", "isSameType", "extendsBound", "()Landroidx/room/compiler/processing/XType;", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "boxed", "()Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "withJvmTypeResolver", "(Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;)Landroidx/room/compiler/processing/ksp/KspType;", "copyWithJvmTypeResolver", "(Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/XNullability;", "nullability", "copyWithNullability", "(Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/processing/ksp/KspType;", "makeNullable", "makeNonNullable", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "getEnv", "()Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "Lil/p;", "getKsType", "()Lil/p;", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "getJvmTypeResolver", "()Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "Landroidx/room/compiler/processing/ksp/KspRawType;", "rawType$delegate", "Lkotlin/Lazy;", "getRawType", "()Landroidx/room/compiler/processing/ksp/KspRawType;", "rawType", "typeName$delegate", "getTypeName", "typeName", "xTypeName$delegate", "getXTypeName", "xTypeName", "jvmWildcardType$delegate", "getJvmWildcardType", "jvmWildcardType", "nullability$delegate", "getNullability", "()Landroidx/room/compiler/processing/XNullability;", "", "superTypes$delegate", "getSuperTypes", "()Ljava/util/List;", "superTypes", "Landroidx/room/compiler/processing/ksp/KspTypeElement;", "typeElement$delegate", "getTypeElement", "()Landroidx/room/compiler/processing/ksp/KspTypeElement;", "typeElement", "typeArguments$delegate", "getTypeArguments", "getTypeArguments$annotations", "()V", "typeArguments", "", "equalityItems$delegate", "getEqualityItems", "()[Ljava/lang/Object;", "equalityItems", "getJvmWildcardTypeOrSelf$room_compiler_processing", "jvmWildcardTypeOrSelf", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspType implements XType, XEquality {
    private final KspProcessingEnv env;
    private final Lazy equalityItems$delegate;
    private final KspJvmTypeResolver jvmTypeResolver;
    private final Lazy jvmWildcardType$delegate;
    private final p ksType;
    private final Lazy nullability$delegate;
    private final Lazy rawType$delegate;
    private final Lazy superTypes$delegate;
    private final Lazy typeArguments$delegate;
    private final Lazy typeElement$delegate;
    private final Lazy typeName$delegate;
    private final Lazy xTypeName$delegate;

    public KspType(KspProcessingEnv r5, p r10, KspJvmTypeResolver r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "ksType");
        this.env = r5;
        this.jvmTypeResolver = r11;
        this.rawType$delegate = LazyKt.lazy(new KspType$rawType$2(this));
        this.typeName$delegate = LazyKt.lazy(new KspType$typeName$2(this));
        this.xTypeName$delegate = LazyKt.lazy(new KspType$xTypeName$2(this));
        this.jvmWildcardType$delegate = LazyKt.lazy(new KspType$jvmWildcardType$2(this));
        this.nullability$delegate = LazyKt.lazy(new KspType$nullability$2(this));
        this.superTypes$delegate = LazyKt.lazy(new KspType$superTypes$2(this));
        this.typeElement$delegate = LazyKt.lazy(new KspType$typeElement$2(this));
        this.typeArguments$delegate = LazyKt.lazy(new KspType$typeArguments$2(this));
        this.equalityItems$delegate = LazyKt.lazy(new KspType$equalityItems$2(this));
    }

    public static final /* synthetic */ KspType access$getJvmWildcardType(KspType r5) {
        return r5.getJvmWildcardType();
    }

    public static final /* synthetic */ XTypeName access$getXTypeName(KspType r5) {
        return r5.getXTypeName();
    }

    private final KspType getJvmWildcardType() {
        return (KspType) this.jvmWildcardType$delegate.getValue();
    }

    public static /* synthetic */ void getTypeArguments$annotations() {
    }

    private final XTypeName getXTypeName() {
        return (XTypeName) this.xTypeName$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public XTypeName asTypeName() {
        return getXTypeName();
    }

    @Override // androidx.room.compiler.processing.XType
    public abstract KspType boxed();

    public abstract KspType copyWithJvmTypeResolver(KspJvmTypeResolver r5);

    public abstract KspType copyWithNullability(XNullability r5);

    @Override // androidx.room.compiler.processing.XType
    public String defaultValue() {
        throw null;
    }

    public boolean equals(Object r5) {
        return XEquality.Companion.equals(this, r5);
    }

    @Override // androidx.room.compiler.processing.XType
    public XType extendsBound() {
        return null;
    }

    public final KspProcessingEnv getEnv() {
        return this.env;
    }

    @Override // androidx.room.compiler.processing.XEquality
    public Object[] getEqualityItems() {
        return (Object[]) this.equalityItems$delegate.getValue();
    }

    public final KspJvmTypeResolver getJvmTypeResolver() {
        return this.jvmTypeResolver;
    }

    public final KspType getJvmWildcardTypeOrSelf$room_compiler_processing() {
        KspType r5 = getJvmWildcardType();
        if (r5 != null) goto L6;
        return this;
    L6:
        return r5;
    }

    public final p getKsType() {
        return null;
    }

    @Override // androidx.room.compiler.processing.XType
    public XNullability getNullability() {
        return (XNullability) this.nullability$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XRawType getRawType() {
        return getRawType();
    }

    @Override // androidx.room.compiler.processing.XType
    public List<XType> getSuperTypes() {
        return (List) this.superTypes$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public List<XType> getTypeArguments() {
        return (List) this.typeArguments$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XTypeElement getTypeElement() {
        return getTypeElement();
    }

    @Override // androidx.room.compiler.processing.XType
    public final x getTypeName() {
        return (x) this.typeName$delegate.getValue();
    }

    public int hashCode() {
        return XEquality.Companion.hashCode(getEqualityItems());
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isAssignableFrom(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof KspType) == false) goto L5;
        ((KspType) r5).getClass();
        throw null;
    L5:
        throw new IllegalStateException("Check failed.");
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isError() {
        throw null;
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isNone() {
        return false;
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isSameType(XType r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if ((r5 instanceof KspType) == false) goto L14;
        XNullability r10 = getNullability();
        XNullability r11 = XNullability.UNKNOWN;
        if (r10 == r11) goto L12;
        if (r5.getNullability() == r11) goto L12;
        ((KspType) r5).getClass();
        return Intrinsics.areEqual(null, null);
    L12:
        return Intrinsics.areEqual(asTypeName().getJava$room_compiler_processing(), r5.asTypeName().getJava$room_compiler_processing());
    L14:
        throw new IllegalStateException("Check failed.");
    }

    @Override // androidx.room.compiler.processing.XType
    public boolean isTypeOf(KClass<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        if (Intrinsics.areEqual(JavaPoetExtKt.tryBox(getRawType().getTypeName()).toString(), JvmClassMappingKt.getJavaClass(r5).getCanonicalName()) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(JavaPoetExtKt.tryUnbox(getRawType().getTypeName()).toString(), JvmClassMappingKt.getJavaClass(r5).getCanonicalName()) == true) goto L8;
        return false;
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XType makeNonNullable() {
        return makeNonNullable();
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XType makeNullable() {
        return makeNullable();
    }

    public abstract x resolveJTypeName();

    public abstract a0 resolveKTypeName();

    public String toString() {
        throw null;
    }

    public final KspType withJvmTypeResolver(KspJvmTypeResolutionScope r5) {
        Intrinsics.checkNotNullParameter(r5, "jvmTypeResolver");
        return copyWithJvmTypeResolver(new KspJvmTypeResolver(r5, this));
    }

    @Override // androidx.room.compiler.processing.XType
    public KspRawType getRawType() {
        return (KspRawType) this.rawType$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public KspTypeElement getTypeElement() {
        return (KspTypeElement) this.typeElement$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.XType
    public final KspType makeNonNullable() {
        XNullability r5 = getNullability();
        XNullability r10 = XNullability.NONNULL;
        if (r5 != r10) goto L6;
        return this;
    L6:
        return copyWithNullability(r10);
    }

    @Override // androidx.room.compiler.processing.XType
    public final KspType makeNullable() {
        XNullability r5 = getNullability();
        XNullability r10 = XNullability.NULLABLE;
        if (r5 != r10) goto L6;
        return this;
    L6:
        return copyWithNullability(r10);
    }
}
