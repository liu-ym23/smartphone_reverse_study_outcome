package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeExtension;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeExtensionVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmTypeExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmTypeExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeExtension;", "()V", "annotations", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "getAnnotations", "()Ljava/util/List;", "isRaw", "", "()Z", "setRaw", "(Z)V", "accept", "", "visitor", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeExtensionVisitor;", "visit", "visitAnnotation", "annotation", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmTypeExtension extends JvmTypeExtensionVisitor implements KmTypeExtension {
    private final List<KmAnnotation> annotations;
    private boolean isRaw;

    public JvmTypeExtension() {
        super(null, 1, null);
        this.annotations = new ArrayList();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmExtension
    public /* bridge */ /* synthetic */ void accept(KmExtensionVisitor r5) {
        accept((KmTypeExtensionVisitor) r5);
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    public final boolean isRaw() {
        return this.isRaw;
    }

    public final void setRaw(boolean r5) {
        this.isRaw = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeExtensionVisitor
    public void visit(boolean r5) {
        this.isRaw = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeExtensionVisitor
    public void visitAnnotation(KmAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        this.annotations.add(r5);
    }

    public void accept(KmTypeExtensionVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        if ((r5 instanceof JvmTypeExtensionVisitor) == false) goto L11;
        JvmTypeExtensionVisitor r10 = (JvmTypeExtensionVisitor) r5;
        r10.visit(this.isRaw);
        Iterator<T> r11 = this.annotations.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.visitAnnotation((KmAnnotation) r11.next());
        goto L6
    L8:
        r10.visitEnd();
        return;
    L11:
        throw new IllegalArgumentException("Failed requirement.");
    }
}
