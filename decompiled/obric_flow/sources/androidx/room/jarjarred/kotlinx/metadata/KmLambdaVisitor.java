package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmLambdaVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/b;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "", "name", "Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "visitFunction", "(ILjava/lang/String;)Landroidx/room/jarjarred/kotlinx/metadata/KmFunctionVisitor;", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmLambdaVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmLambdaVisitor {
    private final KmLambdaVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmLambdaVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void visitEnd() {
        KmLambdaVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public KmFunctionVisitor visitFunction(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        KmLambdaVisitor r11 = this.delegate;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.visitFunction(r5, r10);
    }

    @JvmOverloads
    public KmLambdaVisitor(KmLambdaVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmLambdaVisitor(KmLambdaVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
