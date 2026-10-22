package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmConstructorExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmConstructorExtension;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmConstructorExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMethodSignature;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmConstructorExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmConstructorExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmConstructorExtension;", "<init>", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "signature", "", "visit", "(Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;", "visitor", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;)V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "getSignature", "()Ljava/lang/Object;", "setSignature", "(Ljava/lang/Object;)V", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmConstructorExtension extends JvmConstructorExtensionVisitor implements KmConstructorExtension {
    private JvmMethodSignature signature;

    public JvmConstructorExtension() {
        super(null, 1, null);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmExtension
    public /* bridge */ /* synthetic */ void accept(KmExtensionVisitor r5) {
        accept((KmConstructorExtensionVisitor) r5);
    }

    public final JvmMethodSignature getSignature() {
        return this.signature;
    }

    public final void setSignature(JvmMethodSignature r5) {
        this.signature = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmConstructorExtensionVisitor
    public void visit(JvmMethodSignature r5) {
        this.signature = r5;
    }

    public void accept(KmConstructorExtensionVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        if ((r5 instanceof JvmConstructorExtensionVisitor) == false) goto L7;
        ((JvmConstructorExtensionVisitor) r5).visit(this.signature);
        return;
    L7:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
