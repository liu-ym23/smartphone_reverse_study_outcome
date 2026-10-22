package androidx.room.jarjarred.kotlinx.metadata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmEffect;", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectType;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectInvocationKind;", "invocationKind", "<init>", "(Lkotlinx/metadata/KmEffectType;Lkotlinx/metadata/KmEffectInvocationKind;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "visitConstructorArgument", "()Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "visitConclusionOfConditionalEffect", "visitor", "", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectType;", "getType", "()Lkotlinx/metadata/KmEffectType;", "setType", "(Lkotlinx/metadata/KmEffectType;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectInvocationKind;", "getInvocationKind", "()Lkotlinx/metadata/KmEffectInvocationKind;", "setInvocationKind", "(Lkotlinx/metadata/KmEffectInvocationKind;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpression;", "constructorArguments", "Ljava/util/List;", "getConstructorArguments", "()Ljava/util/List;", "conclusion", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpression;", "getConclusion", "()Ljava/lang/Object;", "setConclusion", "(Ljava/lang/Object;)V", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmEffect extends KmEffectVisitor {
    private KmEffectExpression conclusion;
    private final List<KmEffectExpression> constructorArguments;
    private KmEffectInvocationKind invocationKind;
    private KmEffectType type;

    public KmEffect(KmEffectType r5, KmEffectInvocationKind r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        super(null, 1, null);
        this.type = r5;
        this.invocationKind = r10;
        this.constructorArguments = new ArrayList(1);
    }

    public final void accept(KmEffectVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        Iterator<T> r10 = this.constructorArguments.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        KmEffectExpression r11 = (KmEffectExpression) r10.next();
        KmEffectExpressionVisitor r12 = r5.visitConstructorArgument();
        if (r12 == null) goto L4;
        r11.accept(r12);
        goto L4
    L8:
        KmEffectExpression r13 = this.conclusion;
        if (r13 == null) goto L13;
        KmEffectExpressionVisitor r14 = r5.visitConclusionOfConditionalEffect();
        if (r14 == null) goto L13;
        r13.accept(r14);
    L13:
        r5.visitEnd();
    }

    public final KmEffectExpression getConclusion() {
        return this.conclusion;
    }

    public final List<KmEffectExpression> getConstructorArguments() {
        return this.constructorArguments;
    }

    public final KmEffectInvocationKind getInvocationKind() {
        return this.invocationKind;
    }

    public final KmEffectType getType() {
        return this.type;
    }

    public final void setConclusion(KmEffectExpression r5) {
        this.conclusion = r5;
    }

    public final void setInvocationKind(KmEffectInvocationKind r5) {
        this.invocationKind = r5;
    }

    public final void setType(KmEffectType r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.type = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectVisitor
    public KmEffectExpressionVisitor visitConclusionOfConditionalEffect() {
        KmEffectExpression r5 = new KmEffectExpression();
        this.conclusion = r5;
        return r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectVisitor
    public KmEffectExpressionVisitor visitConstructorArgument() {
        return (KmEffectExpressionVisitor) NodesKt.addTo(new KmEffectExpression(), this.constructorArguments);
    }
}
