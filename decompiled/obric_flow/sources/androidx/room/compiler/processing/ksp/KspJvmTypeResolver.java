package androidx.room.compiler.processing.ksp;

import androidx.room.compiler.processing.XType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Landroidx/room/compiler/processing/ksp/KspJvmTypeResolver;", "", "scope", "Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "delegate", "Landroidx/room/compiler/processing/ksp/KspType;", "(Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;Landroidx/room/compiler/processing/ksp/KspType;)V", "getDelegate", "()Landroidx/room/compiler/processing/ksp/KspType;", "getScope", "()Landroidx/room/compiler/processing/ksp/KspJvmTypeResolutionScope;", "resolveJvmType", "env", "Landroidx/room/compiler/processing/ksp/KspProcessingEnv;", "resolveJvmType$room_compiler_processing", "room-compiler-processing"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KspJvmTypeResolver {
    private final KspType delegate;
    private final KspJvmTypeResolutionScope scope;

    public KspJvmTypeResolver(KspJvmTypeResolutionScope r5, KspType r10) {
        Intrinsics.checkNotNullParameter(r5, "scope");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.scope = r5;
        this.delegate = r10;
    }

    public final KspType getDelegate() {
        return this.delegate;
    }

    public final KspJvmTypeResolutionScope getScope() {
        return this.scope;
    }

    public final KspType resolveJvmType$room_compiler_processing(KspProcessingEnv r5) {
        Intrinsics.checkNotNullParameter(r5, "env");
        if (this.scope.getNeedsWildcardResolution() == true) goto L7;
        return this.delegate;
    L7:
        if (this.scope.getSuppressesWildcards() == false) goto L9;
        KSTypeVarianceResolver.WildcardMode r10 = KSTypeVarianceResolver.WildcardMode.SUPPRESSED;
    L10:
        XType r11 = this.scope.findDeclarationType();
        if ((r11 instanceof KspType) == false) goto L13;
        KspType r12 = (KspType) r11;
    L14:
        this.delegate.getKsType();
        if (Intrinsics.areEqual(r12, this.delegate) == true) goto L21;
        if (r12 == null) goto L21;
        KspType r13 = r12.getJvmWildcardTypeOrSelf$room_compiler_processing();
        if (r13 == null) goto L21;
        r13.getKsType();
    L21:
        r5.resolveWildcards(null, r10, null);
        return r5.wrap(null, this.delegate instanceof KspPrimitiveType);
    L13:
        r12 = null;
        goto L14
    L9:
        r10 = KSTypeVarianceResolver.WildcardMode.PREFERRED;
        goto L10
    }
}
