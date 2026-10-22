package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.JavaPoetExtKt;
import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.a0;
import il.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00060\nj\u0002`\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspPrimitiveType;", "Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/p;", "ksType", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "jvmTypeResolver", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/p;Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)V", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "resolveJTypeName", "()Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "resolveKTypeName", "()Lcom/squareup/kotlinpoet/a0;", "boxed", "()Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/XNullability;", "nullability", "copyWithNullability", "(Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/processing/ksp/KspType;", "copyWithJvmTypeResolver", "(Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)Landroidx/room/compiler/processing/ksp/KspType;", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspPrimitiveType extends KspType {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r5 = new int[XNullability.values().length];
            r5[XNullability.NONNULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r5[XNullability.NULLABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r5;
        }
    }

    public KspPrimitiveType(KspProcessingEnv r5, p r10, KspJvmTypeResolver r11) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "ksType");
        super(r5, r10, r11);
    }

    @Override // androidx.room.compiler.processing.XType
    public /* bridge */ /* synthetic */ XType boxed() {
        return boxed();
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public KspType copyWithJvmTypeResolver(KspJvmTypeResolver r5) {
        Intrinsics.checkNotNullParameter(r5, "jvmTypeResolver");
        KspProcessingEnv r10 = getEnv();
        getKsType();
        return new KspPrimitiveType(r10, null, r5);
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public KspType copyWithNullability(XNullability r5) {
        Intrinsics.checkNotNullParameter(r5, "nullability");
        int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r10 != 1) goto L5;
        return this;
    L5:
        if (r10 != 2) goto L8;
        return boxed().makeNullable();
    L8:
        throw new IllegalStateException("cannot set nullability to unknown in KSP");
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public x resolveJTypeName() {
        getKsType();
        getEnv().getResolver();
        return JavaPoetExtKt.tryUnbox(KSTypeJavaPoetExtKt.asJTypeName(null, null));
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public a0 resolveKTypeName() {
        getKsType();
        getEnv().getResolver();
        return KSTypeKotlinPoetExtKt.asKTypeName(null, null);
    }

    @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
    public KspType boxed() {
        KspProcessingEnv r5 = getEnv();
        getKsType();
        return r5.wrap(null, false);
    }
}
