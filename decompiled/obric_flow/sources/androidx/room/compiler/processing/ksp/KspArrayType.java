package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.codegen.XTypeName;
import androidx.room.compiler.processing.XArrayType;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.a0;
import il.p;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0004\u001e\u001d\u001f B#\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00018&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0001\u0002!\"¨\u0006#"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspArrayType;", "Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/XArrayType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/p;", "ksType", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "jvmTypeResolver", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/p;Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)V", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "resolveJTypeName", "()Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "resolveKTypeName", "()Lcom/squareup/kotlinpoet/a0;", "boxed", "()Landroidx/room/compiler/processing/ksp/KspArrayType;", "getComponentType", "()Landroidx/room/compiler/processing/ksp/KspType;", "componentType", "", "Landroidx/room/compiler/processing/XType;", "getTypeArguments", "()Ljava/util/List;", "typeArguments", "Companion", "BoxedArray", "Factory", "PrimitiveArray", "Landroidx/room/compiler/processing/ksp/KspArrayType$BoxedArray;", "Landroidx/room/compiler/processing/ksp/KspArrayType$PrimitiveArray;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KspArrayType extends KspType implements XArrayType {
    public static final Companion Companion = null;
    public static final String KOTLIN_ARRAY_Q_NAME = "kotlin.Array";

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u001b\u0010\u001b\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspArrayType$BoxedArray;", "Landroidx/room/compiler/processing/ksp/KspArrayType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/p;", "ksType", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "jvmTypeResolver", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/p;Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)V", "Landroidx/room/compiler/codegen/XTypeName;", "asTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "Landroidx/room/compiler/processing/XNullability;", "nullability", "copyWithNullability", "(Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/processing/ksp/KspArrayType$BoxedArray;", "Landroidx/room/compiler/processing/ksp/KspType;", "copyWithJvmTypeResolver", "(Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)Landroidx/room/compiler/processing/ksp/KspType;", "xTypeName$delegate", "Lkotlin/Lazy;", "getXTypeName", "xTypeName", "componentType$delegate", "getComponentType", "()Landroidx/room/compiler/processing/ksp/KspType;", "componentType", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class BoxedArray extends KspArrayType {
        private final Lazy componentType$delegate;
        private final Lazy xTypeName$delegate;

        public BoxedArray(final KspProcessingEnv r5, final p r10, KspJvmTypeResolver r11) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "ksType");
            super(r5, r10, r11, null);
            this.xTypeName$delegate = LazyKt.lazy(new KspArrayType$BoxedArray$xTypeName$2(this));
            this.componentType$delegate = LazyKt.lazy(new KspArrayType$BoxedArray$componentType$2(r10, r5));
        }

        private final XTypeName getXTypeName() {
            return (XTypeName) this.xTypeName$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
        public XTypeName asTypeName() {
            return getXTypeName();
        }

        @Override // androidx.room.compiler.processing.ksp.KspType
        public KspType copyWithJvmTypeResolver(KspJvmTypeResolver r5) {
            Intrinsics.checkNotNullParameter(r5, "jvmTypeResolver");
            KspProcessingEnv r10 = getEnv();
            getKsType();
            return new BoxedArray(r10, null, r5);
        }

        @Override // androidx.room.compiler.processing.ksp.KspType
        public /* bridge */ /* synthetic */ KspType copyWithNullability(XNullability r5) {
            return copyWithNullability(r5);
        }

        @Override // androidx.room.compiler.processing.XArrayType
        public /* bridge */ /* synthetic */ XType getComponentType() {
            return getComponentType();
        }

        @Override // androidx.room.compiler.processing.ksp.KspType
        public BoxedArray copyWithNullability(XNullability r5) {
            Intrinsics.checkNotNullParameter(r5, "nullability");
            KspProcessingEnv r10 = getEnv();
            getKsType();
            KSTypeExtKt.withNullability(null, r5);
            return new BoxedArray(r10, null, getJvmTypeResolver());
        }

        @Override // androidx.room.compiler.processing.ksp.KspArrayType, androidx.room.compiler.processing.XArrayType
        public KspType getComponentType() {
            return (KspType) this.componentType$delegate.getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspArrayType$Companion;", "", "()V", "KOTLIN_ARRAY_Q_NAME", "", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R,\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00150\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspArrayType$Factory;", "", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;)V", "Landroidx/room/compiler/processing/ksp/KspType;", "componentType", "Landroidx/room/compiler/processing/ksp/KspArrayType;", "createWithComponentType", "(Landroidx/room/compiler/processing/ksp/KspType;)Landroidx/room/compiler/processing/ksp/KspArrayType;", "Lil/p;", "ksType", "createIfArray", "(Lil/p;)Landroidx/room/compiler/processing/ksp/KspArrayType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "", "", "Landroidx/room/compiler/processing/ksp/KspPrimitiveType;", "builtInArrays", "Ljava/util/Map;", "", "reverseBuiltInArrayLookup", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory {
        private final Map<String, KspPrimitiveType> builtInArrays;
        private final KspProcessingEnv env;
        private final Map<p, Map.Entry<String, KspPrimitiveType>> reverseBuiltInArrayLookup;

        public Factory(KspProcessingEnv r5) {
            Intrinsics.checkNotNullParameter(r5, "env");
            this.env = r5;
            r5.getResolver();
            throw null;
        }

        public final KspArrayType createIfArray(p r5) {
            Intrinsics.checkNotNullParameter(r5, "ksType");
            r5.getDeclaration();
            throw null;
        }

        public final KspArrayType createWithComponentType(KspType r5) {
            Intrinsics.checkNotNullParameter(r5, "componentType");
            if (r5.getNullability() != XNullability.NONNULL) goto L8;
            Map<p, Map.Entry<String, KspPrimitiveType>> r10 = this.reverseBuiltInArrayLookup;
            r5.getKsType();
            Map.Entry<String, KspPrimitiveType> r11 = r10.get(null);
            if (r11 == null) goto L8;
            KspProcessingEnv r12 = this.env;
            r12.getResolver();
            ResolverExtKt.requireType(null, r11.getKey());
            return new PrimitiveArray(r12, null, null, r11.getValue());
        L8:
            this.env.getResolver();
            throw null;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspArrayType$PrimitiveArray;", "Landroidx/room/compiler/processing/ksp/KspArrayType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/p;", "ksType", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "jvmTypeResolver", "Landroidx/room/compiler/processing/ksp/KspType;", "componentType", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/p;Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;Landroidx/room/compiler/processing/ksp/KspType;)V", "Landroidx/room/compiler/codegen/XTypeName;", "asTypeName", "()Landroidx/room/compiler/codegen/XTypeName;", "Landroidx/room/compiler/processing/XNullability;", "nullability", "copyWithNullability", "(Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/processing/ksp/KspArrayType$PrimitiveArray;", "copyWithJvmTypeResolver", "(Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspType;", "getComponentType", "()Landroidx/room/compiler/processing/ksp/KspType;", "xTypeName$delegate", "Lkotlin/Lazy;", "getXTypeName", "xTypeName", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PrimitiveArray extends KspArrayType {
        private final KspType componentType;
        private final Lazy xTypeName$delegate;

        public PrimitiveArray(final KspProcessingEnv r5, final p r10, KspJvmTypeResolver r11, KspType r12) {
            Intrinsics.checkNotNullParameter(r5, "env");
            Intrinsics.checkNotNullParameter(r10, "ksType");
            Intrinsics.checkNotNullParameter(r12, "componentType");
            super(r5, r10, r11, null);
            this.componentType = r12;
            this.xTypeName$delegate = LazyKt.lazy(new KspArrayType$PrimitiveArray$xTypeName$2(this, r10, r5));
        }

        private final XTypeName getXTypeName() {
            return (XTypeName) this.xTypeName$delegate.getValue();
        }

        @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
        public XTypeName asTypeName() {
            return getXTypeName();
        }

        @Override // androidx.room.compiler.processing.ksp.KspType
        public KspType copyWithJvmTypeResolver(KspJvmTypeResolver r5) {
            Intrinsics.checkNotNullParameter(r5, "jvmTypeResolver");
            KspProcessingEnv r10 = getEnv();
            getKsType();
            return new PrimitiveArray(r10, null, r5, getComponentType());
        }

        @Override // androidx.room.compiler.processing.ksp.KspType
        public /* bridge */ /* synthetic */ KspType copyWithNullability(XNullability r5) {
            return copyWithNullability(r5);
        }

        @Override // androidx.room.compiler.processing.XArrayType
        public /* bridge */ /* synthetic */ XType getComponentType() {
            return getComponentType();
        }

        @Override // androidx.room.compiler.processing.ksp.KspType
        public PrimitiveArray copyWithNullability(XNullability r5) {
            Intrinsics.checkNotNullParameter(r5, "nullability");
            KspProcessingEnv r10 = getEnv();
            getKsType();
            KSTypeExtKt.withNullability(null, r5);
            KspType r11 = getComponentType();
            return new PrimitiveArray(r10, null, getJvmTypeResolver(), r11);
        }

        @Override // androidx.room.compiler.processing.ksp.KspArrayType, androidx.room.compiler.processing.XArrayType
        public KspType getComponentType() {
            return this.componentType;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ KspArrayType(KspProcessingEnv r5, p r10, KspJvmTypeResolver r11, DefaultConstructorMarker r12) {
        this(r5, r10, r11);
    }

    @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
    public KspArrayType boxed() {
        return this;
    }

    @Override // androidx.room.compiler.processing.XArrayType
    public abstract KspType getComponentType();

    @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
    public List<XType> getTypeArguments() {
        return CollectionsKt.emptyList();
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public x resolveJTypeName() {
        return asTypeName().getJava$room_compiler_processing();
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public a0 resolveKTypeName() {
        return asTypeName().getKotlin$room_compiler_processing();
    }

    private KspArrayType(KspProcessingEnv r5, p r10, KspJvmTypeResolver r11) {
        super(r5, r10, r11);
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XType boxed() {
        return boxed();
    }

    @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ KspType boxed() {
        return boxed();
    }
}
