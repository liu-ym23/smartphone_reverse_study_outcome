package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XNullability;
import androidx.room.compiler.processing.XType;
import com.squareup.javapoet.x;
import com.squareup.kotlinpoet.a0;
import com.squareup.kotlinpoet.b0;
import il.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0007\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspVoidType;", "Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "env", "Lil/p;", "ksType", "", "boxed", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "jvmTypeResolver", "<init>", "(Landroidx/room/compiler/processing/ksp/KspProcessingEnv;Lil/p;ZLandroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)V", "Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/javapoet/JTypeName;", "resolveJTypeName", "()Lcom/squareup/javapoet/x;", "Lcom/squareup/kotlinpoet/a0;", "Lcom/squareup/kotlinpoet/javapoet/KTypeName;", "resolveKTypeName", "()Lcom/squareup/kotlinpoet/a0;", "()Landroidx/room/compiler/processing/ksp/KspType;", "Landroidx/room/compiler/processing/XNullability;", "nullability", "copyWithNullability", "(Landroidx/room/compiler/processing/XNullability;)Landroidx/room/compiler/processing/ksp/KspType;", "copyWithJvmTypeResolver", "(Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;)Landroidx/room/compiler/processing/ksp/KspType;", "Z", "getBoxed", "()Z", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspVoidType extends KspType {
    private final boolean boxed;

    public KspVoidType(KspProcessingEnv r5, p r10, boolean r11, KspJvmTypeResolver r12) {
        Intrinsics.checkNotNullParameter(r5, "env");
        Intrinsics.checkNotNullParameter(r10, "ksType");
        super(r5, r10, r12);
        this.boxed = r11;
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
        return new KspVoidType(r10, null, this.boxed, r5);
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public KspType copyWithNullability(XNullability r5) {
        Intrinsics.checkNotNullParameter(r5, "nullability");
        KspProcessingEnv r10 = getEnv();
        getKsType();
        KSTypeExtKt.withNullability(null, r5);
        if (this.boxed == false) goto L5;
    L8:
        boolean r11 = true;
    L10:
        return new KspVoidType(r10, null, r11, getJvmTypeResolver());
    L5:
        if (r5 == XNullability.NULLABLE) goto L8;
        r11 = false;
        goto L10
    }

    public final boolean getBoxed() {
        return this.boxed;
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public x resolveJTypeName() {
        if (this.boxed == true) goto L9;
        if (getNullability() == XNullability.NULLABLE) goto L9;
        return x.d;
    L9:
        return x.d.b();
    }

    @Override // androidx.room.compiler.processing.ksp.KspType
    public a0 resolveKTypeName() {
        return b0.f15082c;
    }

    @Override // androidx.room.compiler.processing.ksp.KspType, androidx.room.compiler.processing.XType
    public KspType boxed() {
        if (this.boxed == true) goto L7;
        KspProcessingEnv r5 = getEnv();
        getKsType();
        return new KspVoidType(r5, null, true, getJvmTypeResolver());
    L7:
        return this;
    }
}
