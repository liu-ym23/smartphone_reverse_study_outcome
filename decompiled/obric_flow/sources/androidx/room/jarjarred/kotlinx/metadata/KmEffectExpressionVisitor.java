package androidx.room.jarjarred.kotlinx.metadata;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\t2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "", "delegate", "<init>", "(Lkotlinx/metadata/impl/i;)V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "parameterIndex", "", "visit", "(ILjava/lang/Integer;)V", "value", "visitConstantValue", "(Ljava/lang/Object;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitIsInstanceType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitAndArgument", "()Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "visitOrArgument", "visitEnd", "()V", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class KmEffectExpressionVisitor {
    private final KmEffectExpressionVisitor delegate;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public KmEffectExpressionVisitor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void visit(int r5, Integer r10) {
        KmEffectExpressionVisitor r11 = this.delegate;
        if (r11 == null) goto L6;
        r11.visit(r5, r10);
        return;
    }

    public KmEffectExpressionVisitor visitAndArgument() {
        KmEffectExpressionVisitor r5 = this.delegate;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.visitAndArgument();
    }

    public void visitConstantValue(Object r5) {
        KmEffectExpressionVisitor r10 = this.delegate;
        if (r10 == null) goto L6;
        r10.visitConstantValue(r5);
        return;
    }

    public void visitEnd() {
        KmEffectExpressionVisitor r5 = this.delegate;
        if (r5 == null) goto L6;
        r5.visitEnd();
        return;
    }

    public KmTypeVisitor visitIsInstanceType(int r5) {
        KmEffectExpressionVisitor r10 = this.delegate;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.visitIsInstanceType(r5);
    }

    public KmEffectExpressionVisitor visitOrArgument() {
        KmEffectExpressionVisitor r5 = this.delegate;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.visitOrArgument();
    }

    @JvmOverloads
    public KmEffectExpressionVisitor(KmEffectExpressionVisitor r5) {
        this.delegate = r5;
    }

    public /* synthetic */ KmEffectExpressionVisitor(KmEffectExpressionVisitor r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }
}
