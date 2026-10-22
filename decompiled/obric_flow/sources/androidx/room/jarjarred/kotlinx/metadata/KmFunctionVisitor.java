package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J5\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0017¢\u0006\u0004\b\u0013\u0010\u0012J%\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010&¨\u0006'"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/j;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "id", "Landroidx/room/jarjarred/kotlinx/metadata/KmVariance;", "variance", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "visitTypeParameter", "(ILjava/lang/String;ILandroidx/room/jarjarred/kotlinx/metadata/KmVariance;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitReceiverParameterType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitContextReceiverType", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitValueParameter", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitReturnType", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "visitVersionRequirement", "()Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "visitContract", "()Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmFunctionVisitor {
    private final KmFunctionVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmFunctionVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @ExperimentalContextReceivers
    public KmTypeVisitor visitContextReceiverType(int r5) {
        KmFunctionVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitContextReceiverType(r5);
    }

    public KmContractVisitor visitContract() {
        KmFunctionVisitor r5 = this.delegate;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.visitContract();
    }

    public void visitEnd() {
        KmFunctionVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public KmFunctionExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        KmFunctionVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitExtensions(r5);
    }

    public KmTypeVisitor visitReceiverParameterType(int r5) {
        KmFunctionVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitReceiverParameterType(r5);
    }

    public KmTypeVisitor visitReturnType(int r5) {
        KmFunctionVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitReturnType(r5);
    }

    public KmTypeParameterVisitor visitTypeParameter(int r5, String r10, int r11, KmVariance r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r12, "variance");
        KmFunctionVisitor r13 = this.delegate;
        if (r13 != null) goto L7;
        return null;
    L7:
        return r13.visitTypeParameter(r5, r10, r11, r12);
    }

    public KmValueParameterVisitor visitValueParameter(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmFunctionVisitor r11 = this.delegate;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.visitValueParameter(r5, r10);
    }

    public KmVersionRequirementVisitor visitVersionRequirement() {
        KmFunctionVisitor r5 = this.delegate;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.visitVersionRequirement();
    }

    @JvmOverloads
    public KmFunctionVisitor(KmFunctionVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmFunctionVisitor(KmFunctionVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
