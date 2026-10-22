package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import com.google.devtools.ksp.symbol.Origin;
import com.google.devtools.ksp.symbol.Variance;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.a0;
import il.b;
import il.j;
import il.q;
import il.r;
import il.s;
import il.v;
import il.w;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001:\u0001*B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010)\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspTypeArgumentType;", "Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/r;", "typeParam", "Lil/q;", "typeArg", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "jvmTypeResolver", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/r;Lil/q;Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)V", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "resolveJTypeName", "()Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "resolveKTypeName", "()Lcom/squareup/kotlinpoet/a0;", "boxed", "()Landroidx/room/compiler/processing/ksp/KspTypeArgumentType;", "Landroidx/room/compiler/processing/XType;", "extendsBound", "()Landroidx/room/compiler/processing/XType;", "Landroidx/room/compiler/processing/XNullability;", "nullability", "copyWithNullability", "(Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/processing/ksp/KspTypeArgumentType;", "copyWithJvmTypeResolver", "(Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)Landroidx/room/compiler/processing/ksp/KspType;", "Lil/r;", "getTypeParam", "()Lil/r;", "Lil/q;", "getTypeArg", "()Lil/q;", "_extendsBound$delegate", "Lkotlin/Lazy;", "get_extendsBound", "()Landroidx/room/compiler/processing/ksp/KspType;", "_extendsBound", "DelegatingTypeArg", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspTypeArgumentType extends KspType {
    private final Lazy _extendsBound$delegate;
    private final q typeArg;
    private final r typeParam;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J8\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspTypeArgumentType$DelegatingTypeArg;", "Lil/q;", "original", "Lil/s;", "type", "<init>", "(Lil/q;Lil/s;)V", "D", "R", "Lil/v;", "visitor", "data", "accept", "(Lil/v;Ljava/lang/Object;)Ljava/lang/Object;", "Lil/q;", "getOriginal", "()Lil/q;", "Lil/s;", "getType", "()Lil/s;", "Lkotlin/sequences/Sequence;", "Lil/b;", "getAnnotations", "()Lkotlin/sequences/Sequence;", "annotations", "Lil/w;", "getLocation", "()Lil/w;", "location", "Lcom/google/devtools/ksp/symbol/Origin;", "getOrigin", "()Lcom/google/devtools/ksp/symbol/Origin;", "origin", "Lil/j;", "getParent", "()Lil/j;", "parent", "Lcom/google/devtools/ksp/symbol/Variance;", "getVariance", "()Lcom/google/devtools/ksp/symbol/Variance;", "variance", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DelegatingTypeArg implements q {
        private final q original;
        private final s type;

        public DelegatingTypeArg(q r5, s r10) {
            Intrinsics.checkNotNullParameter(r5, "original");
            Intrinsics.checkNotNullParameter(r10, "type");
            this.original = r5;
            this.type = r10;
        }

        @Override // il.j
        public <D, R> R accept(v r5, D r10) {
            Intrinsics.checkNotNullParameter(r5, "visitor");
            return (R) this.original.accept(r5, r10);
        }

        @Override // il.a
        public Sequence<b> getAnnotations() {
            return this.original.getAnnotations();
        }

        @Override // il.j
        public w getLocation() {
            return this.original.getLocation();
        }

        @Override // il.j
        public Origin getOrigin() {
            return this.original.getOrigin();
        }

        public final q getOriginal() {
            return this.original;
        }

        @Override // il.j
        public j getParent() {
            return this.original.getParent();
        }

        @Override // il.q
        public s getType() {
            return this.type;
        }

        @Override // il.q
        public Variance getVariance() {
            return this.original.getVariance();
        }
    }

    public KspTypeArgumentType(final KspProcessingEnv r5, r r10, q r11, KspJvmTypeResolver r12) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "typeParam");
        Intrinsics.checkNotNullParameter(r11, "typeArg");
        KSTypeExtKt.requireType(r11);
        super(r5, null, r12);
        this.typeArg = r11;
        this._extendsBound$delegate = LazyKt.lazy(new KspTypeArgumentType$_extendsBound$2(r5, this));
    }

    private final KspType get_extendsBound() {
        return (KspType) this._extendsBound$delegate.getValue();
    }

    @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
    public KspTypeArgumentType boxed() {
        return this;
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public KspType copyWithJvmTypeResolver(KspJvmTypeResolver r5) {
        Intrinsics.checkNotNullParameter(r5, "jvmTypeResolver");
        return new KspTypeArgumentType(getEnv(), null, this.typeArg, r5);
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public /* bridge */ /* synthetic */ KspType copyWithNullability(XNullability r5) {
        return copyWithNullability(r5);
    }

    @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
    public XType extendsBound() {
        return get_extendsBound();
    }

    public final q getTypeArg() {
        return this.typeArg;
    }

    public final r getTypeParam() {
        return null;
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public x resolveJTypeName() {
        q r5 = this.typeArg;
        getEnv().getResolver();
        return KSTypeJavaPoetExtKt.asJTypeName(r5, null);
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public a0 resolveKTypeName() {
        q r5 = this.typeArg;
        getEnv().getResolver();
        return KSTypeKotlinPoetExtKt.asKTypeName(r5, null);
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XType boxed() {
        return boxed();
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public KspTypeArgumentType copyWithNullability(XNullability r10) {
        Intrinsics.checkNotNullParameter(r10, "nullability");
        KspProcessingEnv r5 = getEnv();
        q r11 = this.typeArg;
        getKsType();
        KSTypeExtKt.withNullability(null, r10);
        return new KspTypeArgumentType(r5, null, new DelegatingTypeArg(r11, KSTypeReferenceExtKt.createTypeReference(null)), getJvmTypeResolver());
    }

    @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ KspType boxed() {
        return boxed();
    }
}
