package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPackageExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmProperty;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmPackageExtension;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmPackageExtensionVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J4\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\n2\n\u0010\u0019\u001a\u00060\u0016j\u0002`\u00172\n\u0010\u001a\u001a\u00060\u0016j\u0002`\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\nH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmPackageExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmPackageExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmPackageExtension;", "()V", "localDelegatedProperties", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmProperty;", "getLocalDelegatedProperties", "()Ljava/util/List;", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "setModuleName", "(Ljava/lang/String;)V", "accept", "", "visitor", "Landroidx/room/jarjarred/kotlinx/metadata/KmPackageExtensionVisitor;", "visitLocalDelegatedProperty", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "flags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "name", "getterFlags", "setterFlags", "visitModuleName", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmPackageExtension extends JvmPackageExtensionVisitor implements KmPackageExtension {
    private final List<KmProperty> localDelegatedProperties;
    private String moduleName;

    public JvmPackageExtension() {
        super(null, 1, null);
        this.localDelegatedProperties = new ArrayList(0);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmExtension
    public /* bridge */ /* synthetic */ void accept(KmExtensionVisitor r5) {
        accept((KmPackageExtensionVisitor) r5);
    }

    public final List<KmProperty> getLocalDelegatedProperties() {
        return this.localDelegatedProperties;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public final void setModuleName(String r5) {
        this.moduleName = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmDeclarationContainerExtensionVisitor
    public KmPropertyVisitor visitLocalDelegatedProperty(int r5, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmProperty r13 = new KmProperty(r5, r10, r11, r12);
        this.localDelegatedProperties.add(r13);
        return r13;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmDeclarationContainerExtensionVisitor
    public void visitModuleName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.moduleName = r5;
    }

    public void accept(KmPackageExtensionVisitor r10) {
        Intrinsics.checkNotNullParameter(r10, "visitor");
        if ((r10 instanceof JvmPackageExtensionVisitor) == false) goto L16;
        Iterator<T> r5 = this.localDelegatedProperties.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        KmProperty r11 = (KmProperty) r5.next();
        KmPropertyVisitor r12 = ((JvmPackageExtensionVisitor) r10).visitLocalDelegatedProperty(r11.getFlags(), r11.getName(), r11.getGetterFlags(), r11.getSetterFlags());
        if (r12 == null) goto L6;
        r11.accept(r12);
        goto L6
    L10:
        String r13 = this.moduleName;
        if (r13 == null) goto L13;
        ((JvmPackageExtensionVisitor) r10).visitModuleName(r13);
    L13:
        ((JvmPackageExtensionVisitor) r10).visitEnd();
        return;
    L16:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
