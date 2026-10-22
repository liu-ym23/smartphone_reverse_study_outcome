package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/p;)V", "", "major", "minor", "patch", "", "visitVersion", "(III)V", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVersionKind;", "kind", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementLevel;", "level", "errorCode", "", "message", "visit", "(Lkotlinx/metadata/KmVersionRequirementVersionKind;Lkotlinx/metadata/KmVersionRequirementLevel;Ljava/lang/Integer;Ljava/lang/String;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmVersionRequirementVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmVersionRequirementVisitor {
    private final KmVersionRequirementVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmVersionRequirementVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void visit(KmVersionRequirementVersionKind r5, KmVersionRequirementLevel r10, Integer r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "kind");
        Intrinsics.checkNotNullParameter(r10, "level");
        KmVersionRequirementVisitor r13 = this.delegate;
        if (r13 == null) goto L6;
        r13.visit(r5, r10, r11, r12);
        return;
    }

    public void visitEnd() {
        KmVersionRequirementVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public void visitVersion(int r5, int r10, int r11) {
        KmVersionRequirementVisitor r12 = this.delegate;
        if (r12 == null) goto L6;
        r12.visitVersion(r5, r10, r11);
        return;
    }

    @JvmOverloads
    public KmVersionRequirementVisitor(KmVersionRequirementVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmVersionRequirementVisitor(KmVersionRequirementVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
