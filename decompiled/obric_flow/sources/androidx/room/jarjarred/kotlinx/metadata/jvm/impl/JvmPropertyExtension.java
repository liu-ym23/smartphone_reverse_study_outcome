package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmPropertyExtension;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmFieldSignature;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMethodSignature;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPropertyExtensionVisitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R&\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\"\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R$\u0010'\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R$\u0010*\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!¨\u0006-"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmPropertyExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmPropertyExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmPropertyExtension;", "<init>", "()V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "jvmFlags", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;", "fieldSignature", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "getterSignature", "setterSignature", "", "visit", "(ILandroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;)V", "signature", "visitSyntheticMethodForAnnotations", "(Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;)V", "visitSyntheticMethodForDelegate", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;", "visitor", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyExtensionVisitor;)V", "I", "getJvmFlags", "()I", "setJvmFlags", "(I)V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmFieldSignature;", "getFieldSignature", "()Ljava/lang/Object;", "setFieldSignature", "(Ljava/lang/Object;)V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "getGetterSignature", "setGetterSignature", "getSetterSignature", "setSetterSignature", "syntheticMethodForAnnotations", "getSyntheticMethodForAnnotations", "setSyntheticMethodForAnnotations", "syntheticMethodForDelegate", "getSyntheticMethodForDelegate", "setSyntheticMethodForDelegate", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmPropertyExtension extends JvmPropertyExtensionVisitor implements KmPropertyExtension {
    private JvmFieldSignature fieldSignature;
    private JvmMethodSignature getterSignature;
    private int jvmFlags;
    private JvmMethodSignature setterSignature;
    private JvmMethodSignature syntheticMethodForAnnotations;
    private JvmMethodSignature syntheticMethodForDelegate;

    public JvmPropertyExtension() {
        super(null, 1, null);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmExtension
    public /* bridge */ /* synthetic */ void accept(KmExtensionVisitor r5) {
        accept((KmPropertyExtensionVisitor) r5);
    }

    public final JvmFieldSignature getFieldSignature() {
        return this.fieldSignature;
    }

    public final JvmMethodSignature getGetterSignature() {
        return this.getterSignature;
    }

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final JvmMethodSignature getSetterSignature() {
        return this.setterSignature;
    }

    public final JvmMethodSignature getSyntheticMethodForAnnotations() {
        return this.syntheticMethodForAnnotations;
    }

    public final JvmMethodSignature getSyntheticMethodForDelegate() {
        return this.syntheticMethodForDelegate;
    }

    public final void setFieldSignature(JvmFieldSignature r5) {
        this.fieldSignature = r5;
    }

    public final void setGetterSignature(JvmMethodSignature r5) {
        this.getterSignature = r5;
    }

    public final void setJvmFlags(int r5) {
        this.jvmFlags = r5;
    }

    public final void setSetterSignature(JvmMethodSignature r5) {
        this.setterSignature = r5;
    }

    public final void setSyntheticMethodForAnnotations(JvmMethodSignature r5) {
        this.syntheticMethodForAnnotations = r5;
    }

    public final void setSyntheticMethodForDelegate(JvmMethodSignature r5) {
        this.syntheticMethodForDelegate = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPropertyExtensionVisitor
    public void visit(int r5, JvmFieldSignature r10, JvmMethodSignature r11, JvmMethodSignature r12) {
        this.jvmFlags = r5;
        this.fieldSignature = r10;
        this.getterSignature = r11;
        this.setterSignature = r12;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPropertyExtensionVisitor
    public void visitSyntheticMethodForAnnotations(JvmMethodSignature r5) {
        this.syntheticMethodForAnnotations = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPropertyExtensionVisitor
    public void visitSyntheticMethodForDelegate(JvmMethodSignature r5) {
        this.syntheticMethodForDelegate = r5;
    }

    public void accept(KmPropertyExtensionVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        if ((r5 instanceof JvmPropertyExtensionVisitor) == false) goto L7;
        JvmPropertyExtensionVisitor r10 = (JvmPropertyExtensionVisitor) r5;
        r10.visit(this.jvmFlags, this.fieldSignature, this.getterSignature, this.setterSignature);
        r10.visitSyntheticMethodForAnnotations(this.syntheticMethodForAnnotations);
        r10.visitSyntheticMethodForDelegate(this.syntheticMethodForDelegate);
        r10.visitEnd();
        return;
    L7:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
