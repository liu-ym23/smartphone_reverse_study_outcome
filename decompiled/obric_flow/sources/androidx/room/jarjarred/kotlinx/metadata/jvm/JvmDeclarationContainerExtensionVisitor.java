package androidx.room.jarjarred.kotlinx.metadata.jvm;

import androidx.room.jarjarred.kotlinx.metadata.KmDeclarationContainerExtensionVisitor;
import androidx.room.jarjarred.kotlinx.metadata.KmPropertyVisitor;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J=\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2\n\u0010\n\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmDeclarationContainerExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainerExtensionVisitor;", "delegate", "<init>", "(Ljava/lang/Object;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "getterFlags", "setterFlags", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "visitLocalDelegatedProperty", "(ILjava/lang/String;II)Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "", "visitModuleName", "(Ljava/lang/String;)V", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmDeclarationContainerExtensionVisitor;", "getDelegate", "()Ljava/lang/Object;", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class JvmDeclarationContainerExtensionVisitor implements KmDeclarationContainerExtensionVisitor {
    private final JvmDeclarationContainerExtensionVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public JvmDeclarationContainerExtensionVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public JvmDeclarationContainerExtensionVisitor getDelegate() {
        return this.delegate;
    }

    public KmPropertyVisitor visitLocalDelegatedProperty(int r5, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        JvmDeclarationContainerExtensionVisitor r13 = getDelegate();
        if (r13 != null) goto L7;
        return null;
    L7:
        return r13.visitLocalDelegatedProperty(r5, r10, r11, r12);
    }

    public void visitModuleName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        JvmDeclarationContainerExtensionVisitor r10 = getDelegate();
        if (r10 == null) goto L6;
        r10.visitModuleName(r5);
        return;
    }

    @JvmOverloads
    public JvmDeclarationContainerExtensionVisitor(JvmDeclarationContainerExtensionVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ JvmDeclarationContainerExtensionVisitor(JvmDeclarationContainerExtensionVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
