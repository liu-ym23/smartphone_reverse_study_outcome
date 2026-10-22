package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmFunctionExtension;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmFunctionExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMethodSignature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\r¨\u0006\u001c"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmFunctionExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFunctionExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmFunctionExtension;", "<init>", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "signature", "", "visit", "(Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;)V", "", "internalName", "visitLambdaClassOriginName", "(Ljava/lang/String;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;", "visitor", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionExtensionVisitor;)V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "getSignature", "()Ljava/lang/Object;", "setSignature", "(Ljava/lang/Object;)V", "lambdaClassOriginName", "Ljava/lang/String;", "getLambdaClassOriginName", "()Ljava/lang/String;", "setLambdaClassOriginName", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmFunctionExtension extends JvmFunctionExtensionVisitor implements KmFunctionExtension {
    private String lambdaClassOriginName;
    private JvmMethodSignature signature;

    public JvmFunctionExtension() {
        super(null, 1, null);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmExtension
    public /* bridge */ /* synthetic */ void accept(KmExtensionVisitor r5) {
        accept((KmFunctionExtensionVisitor) r5);
    }

    public final String getLambdaClassOriginName() {
        return this.lambdaClassOriginName;
    }

    public final JvmMethodSignature getSignature() {
        return this.signature;
    }

    public final void setLambdaClassOriginName(String r5) {
        this.lambdaClassOriginName = r5;
    }

    public final void setSignature(JvmMethodSignature r5) {
        this.signature = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmFunctionExtensionVisitor
    public void visit(JvmMethodSignature r5) {
        this.signature = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmFunctionExtensionVisitor
    public void visitLambdaClassOriginName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "internalName");
        this.lambdaClassOriginName = r5;
    }

    public void accept(KmFunctionExtensionVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        if ((r5 instanceof JvmFunctionExtensionVisitor) == false) goto L10;
        JvmFunctionExtensionVisitor r10 = (JvmFunctionExtensionVisitor) r5;
        r10.visit(this.signature);
        String r11 = this.lambdaClassOriginName;
        if (r11 == null) goto L7;
        r10.visitLambdaClassOriginName(r11);
    L7:
        r10.visitEnd();
        return;
    L10:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
