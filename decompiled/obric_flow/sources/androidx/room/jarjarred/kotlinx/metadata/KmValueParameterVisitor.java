package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/o;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitVarargElementType", "Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterExtensionVisitor;", "visitExtensions", "(Landroidx/room/jarjarred/kotlinx/metadata/KmExtensionType;)Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterExtensionVisitor;", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmValueParameterVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmValueParameterVisitor {
    private final KmValueParameterVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmValueParameterVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void visitEnd() {
        KmValueParameterVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public KmValueParameterExtensionVisitor visitExtensions(KmExtensionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        KmValueParameterVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitExtensions(r5);
    }

    public KmTypeVisitor visitType(int r5) {
        KmValueParameterVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitType(r5);
    }

    public KmTypeVisitor visitVarargElementType(int r5) {
        KmValueParameterVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitVarargElementType(r5);
    }

    @JvmOverloads
    public KmValueParameterVisitor(KmValueParameterVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmValueParameterVisitor(KmValueParameterVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
