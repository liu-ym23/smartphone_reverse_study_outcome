package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/f;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "visitValueParameter", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "visitVersionRequirement", "()Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorExtensionVisitor;", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstructorVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmConstructorVisitor {
    private final KmConstructorVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmConstructorVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void visitEnd() {
        KmConstructorVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public KmConstructorExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        KmConstructorVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitExtensions(r5);
    }

    public KmValueParameterVisitor visitValueParameter(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmConstructorVisitor r11 = this.delegate;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.visitValueParameter(r5, r10);
    }

    public KmVersionRequirementVisitor visitVersionRequirement() {
        KmConstructorVisitor r5 = this.delegate;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.visitVersionRequirement();
    }

    @JvmOverloads
    public KmConstructorVisitor(KmConstructorVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmConstructorVisitor(KmConstructorVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
