package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmClassExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmProperty;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmClassExtension;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmClassExtensionVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0014\u0010\u001f\u001a\u00020\u001a2\n\u0010 \u001a\u00060\u000bj\u0002`\fH\u0016J4\u0010!\u001a\u00020\"2\n\u0010 \u001a\u00060\u000bj\u0002`\f2\u0006\u0010#\u001a\u00020\u00052\n\u0010$\u001a\u00060\u000bj\u0002`\f2\n\u0010%\u001a\u00060\u000bj\u0002`\fH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00060\u000bj\u0002`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006'"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmClassExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmClassExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmClassExtension;", "()V", "anonymousObjectOriginName", "", "getAnonymousObjectOriginName", "()Ljava/lang/String;", "setAnonymousObjectOriginName", "(Ljava/lang/String;)V", "jvmFlags", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "getJvmFlags", "()I", "setJvmFlags", "(I)V", "localDelegatedProperties", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmProperty;", "getLocalDelegatedProperties", "()Ljava/util/List;", "moduleName", "getModuleName", "setModuleName", "accept", "", "visitor", "Landroidx/room/jarjarred/kotlinx/metadata/KmClassExtensionVisitor;", "visitAnonymousObjectOriginName", "internalName", "visitJvmFlags", "flags", "visitLocalDelegatedProperty", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "name", "getterFlags", "setterFlags", "visitModuleName", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmClassExtension extends JvmClassExtensionVisitor implements KmClassExtension {
    private String anonymousObjectOriginName;
    private int jvmFlags;
    private final List<KmProperty> localDelegatedProperties;
    private String moduleName;

    public JvmClassExtension() {
        super(null, 1, null);
        this.localDelegatedProperties = new ArrayList(0);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmExtension
    public /* bridge */ /* synthetic */ void accept(KmExtensionVisitor r5) {
        accept((KmClassExtensionVisitor) r5);
    }

    public final String getAnonymousObjectOriginName() {
        return this.anonymousObjectOriginName;
    }

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final List<KmProperty> getLocalDelegatedProperties() {
        return this.localDelegatedProperties;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public final void setAnonymousObjectOriginName(String r5) {
        this.anonymousObjectOriginName = r5;
    }

    public final void setJvmFlags(int r5) {
        this.jvmFlags = r5;
    }

    public final void setModuleName(String r5) {
        this.moduleName = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmClassExtensionVisitor
    public void visitAnonymousObjectOriginName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "internalName");
        this.anonymousObjectOriginName = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmClassExtensionVisitor
    public void visitJvmFlags(int r5) {
        this.jvmFlags = r5;
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

    public void accept(KmClassExtensionVisitor r10) {
        Intrinsics.checkNotNullParameter(r10, "visitor");
        if ((r10 instanceof JvmClassExtensionVisitor) == false) goto L25;
        Iterator<T> r5 = this.localDelegatedProperties.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        KmProperty r11 = (KmProperty) r5.next();
        KmPropertyVisitor r12 = ((JvmClassExtensionVisitor) r10).visitLocalDelegatedProperty(r11.getFlags(), r11.getName(), r11.getGetterFlags(), r11.getSetterFlags());
        if (r12 == null) goto L6;
        r11.accept(r12);
        goto L6
    L10:
        String r13 = this.moduleName;
        if (r13 == null) goto L13;
        ((JvmClassExtensionVisitor) r10).visitModuleName(r13);
    L13:
        String r14 = this.anonymousObjectOriginName;
        if (r14 == null) goto L16;
        ((JvmClassExtensionVisitor) r10).visitAnonymousObjectOriginName(r14);
    L16:
        Integer r15 = Integer.valueOf(this.jvmFlags);
        if (r15.intValue() != 0) goto L20;
        r15 = null;
    L20:
        if (r15 == null) goto L22;
        ((JvmClassExtensionVisitor) r10).visitJvmFlags(r15.intValue());
    L22:
        ((JvmClassExtensionVisitor) r10).visitEnd();
        return;
    L25:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
