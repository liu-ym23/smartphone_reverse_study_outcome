package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\b2\n\u0010\r\u001a\u00060\u0005j\u0002`\u00062\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainerVisitor;", "", "delegate", "<init>", "(Lk5/d;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "visitFunction", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "getterFlags", "setterFlags", "Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "visitProperty", "(ILjava/lang/String;II)Landroidx/room/jarjarred/kotlinx/metadata/KmPropertyVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "visitTypeAlias", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeAliasVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainerExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainerExtensionVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmDeclarationContainerVisitor;", "getDelegate", "()Lk5/d;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmDeclarationContainerVisitor {
    private final KmDeclarationContainerVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmDeclarationContainerVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public KmDeclarationContainerVisitor getDelegate() {
        return this.delegate;
    }

    public abstract KmDeclarationContainerExtensionVisitor visitExtensions(KmExtensionType r5);

    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmDeclarationContainerVisitor r11 = getDelegate();
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.visitFunction(r5, r10);
    }

    public KmPropertyVisitor visitProperty(int r5, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmDeclarationContainerVisitor r13 = getDelegate();
        if (r13 != null) goto L7;
        return null;
    L7:
        return r13.visitProperty(r5, r10, r11, r12);
    }

    public KmTypeAliasVisitor visitTypeAlias(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmDeclarationContainerVisitor r11 = getDelegate();
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.visitTypeAlias(r5, r10);
    }

    @JvmOverloads
    public KmDeclarationContainerVisitor(KmDeclarationContainerVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmDeclarationContainerVisitor(KmDeclarationContainerVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
