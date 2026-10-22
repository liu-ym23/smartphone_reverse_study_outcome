package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/g;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectInvocationKind;", "invocationKind", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "visitEffect", "(Landroidx/room/jarjarred/kotlinx/metadata/KmEffectType;Landroidx/room/jarjarred/kotlinx/metadata/KmEffectInvocationKind;)Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmContractVisitor {
    private final KmContractVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmContractVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public KmEffectVisitor visitEffect(KmEffectType r5, KmEffectInvocationKind r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        KmContractVisitor r11 = this.delegate;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.visitEffect(r5, r10);
    }

    public void visitEnd() {
        KmContractVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    @JvmOverloads
    public KmContractVisitor(KmContractVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmContractVisitor(KmContractVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
