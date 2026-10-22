package androidx.room.jarjarred.kotlinx.metadata.jvm.impl;

import androidx.room.jarjarred.kotlinx.metadata.KmAnnotation;
import androidx.room.jarjarred.kotlinx.metadata.KmExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmTypeParameterExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmTypeParameterExtension;
import androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeParameterExtensionVisitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/impl/JvmTypeParameterExtension;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmTypeParameterExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/impl/extensions/KmTypeParameterExtension;", "()V", "annotations", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmAnnotation;", "getAnnotations", "()Ljava/util/List;", "accept", "", "visitor", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterExtensionVisitor;", "visitAnnotation", "annotation", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmTypeParameterExtension extends JvmTypeParameterExtensionVisitor implements KmTypeParameterExtension {
    private final List<KmAnnotation> annotations;

    public JvmTypeParameterExtension() {
        super(null, 1, null);
        this.annotations = new ArrayList();
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.impl.extensions.KmExtension
    public /* bridge */ /* synthetic */ void accept(KmExtensionVisitor r5) {
        accept((KmTypeParameterExtensionVisitor) r5);
    }

    public final List<KmAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmTypeParameterExtensionVisitor
    public void visitAnnotation(KmAnnotation r5) {
        Intrinsics.checkNotNullParameter(r5, "annotation");
        this.annotations.add(r5);
    }

    public void accept(KmTypeParameterExtensionVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        if ((r5 instanceof JvmTypeParameterExtensionVisitor) == false) goto L11;
        JvmTypeParameterExtensionVisitor r10 = (JvmTypeParameterExtensionVisitor) r5;
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
