package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/n;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitUpperBound", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterExtensionVisitor;", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeParameterVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmTypeParameterVisitor {
    private final KmTypeParameterVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmTypeParameterVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void visitEnd() {
        KmTypeParameterVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public KmTypeParameterExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        KmTypeParameterVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitExtensions(r5);
    }

    public KmTypeVisitor visitUpperBound(int r5) {
        KmTypeParameterVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitUpperBound(r5);
    }

    @JvmOverloads
    public KmTypeParameterVisitor(KmTypeParameterVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmTypeParameterVisitor(KmTypeParameterVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
