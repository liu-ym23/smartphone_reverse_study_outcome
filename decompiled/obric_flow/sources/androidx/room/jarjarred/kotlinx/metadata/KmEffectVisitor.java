package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/h;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "visitConstructorArgument", "()Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "visitConclusionOfConditionalEffect", "", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmEffectVisitor {
    private final KmEffectVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmEffectVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public KmEffectExpressionVisitor visitConclusionOfConditionalEffect() {
        KmEffectVisitor r5 = this.delegate;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.visitConclusionOfConditionalEffect();
    }

    public KmEffectExpressionVisitor visitConstructorArgument() {
        KmEffectVisitor r5 = this.delegate;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.visitConstructorArgument();
    }

    public void visitEnd() {
        KmEffectVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    @JvmOverloads
    public KmEffectVisitor(KmEffectVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmEffectVisitor(KmEffectVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
