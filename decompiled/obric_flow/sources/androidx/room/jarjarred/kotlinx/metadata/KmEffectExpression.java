package androidx.room.jarjarred.kotlinx.metadata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\b2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017R&\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010\u000eR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b)\u0010&\"\u0004\b+\u0010\u000eR\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00000,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020\u00000,8\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100¨\u00063"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpression;", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "<init>", "()V", "", "Landroidx/room/jarjarred/kotlinx/metadata/Flags;", "flags", "parameterIndex", "", "visit", "(ILjava/lang/Integer;)V", "", "value", "visitConstantValue", "(Ljava/lang/Object;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitIsInstanceType", "(I)Landroidx/room/jarjarred/kotlinx/metadata/KmTypeVisitor;", "visitAndArgument", "()Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;", "visitOrArgument", "visitor", "accept", "(Landroidx/room/jarjarred/kotlinx/metadata/KmEffectExpressionVisitor;)V", "I", "getFlags", "()I", "setFlags", "(I)V", "Ljava/lang/Integer;", "getParameterIndex", "()Ljava/lang/Integer;", "setParameterIndex", "(Ljava/lang/Integer;)V", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstantValue;", "constantValue", "Landroidx/room/jarjarred/kotlinx/metadata/KmConstantValue;", "getConstantValue", "()Ljava/lang/Object;", "setConstantValue", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "isInstanceType", "Landroidx/room/jarjarred/kotlinx/metadata/KmType;", "setInstanceType", "", "andArguments", "Ljava/util/List;", "getAndArguments", "()Ljava/util/List;", "orArguments", "getOrArguments", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmEffectExpression extends KmEffectExpressionVisitor {
    private final List<KmEffectExpression> andArguments;
    private KmConstantValue constantValue;
    private int flags;
    private KmType isInstanceType;
    private final List<KmEffectExpression> orArguments;
    private Integer parameterIndex;

    public KmEffectExpression() {
        super(null, 1, null);
        this.flags = FlagsKt.flagsOf(new Flag[0]);
        this.andArguments = new ArrayList(0);
        this.orArguments = new ArrayList(0);
    }

    public final void accept(KmEffectExpressionVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        r5.visit(this.flags, this.parameterIndex);
        KmConstantValue r10 = this.constantValue;
        if (r10 == null) goto L5;
        r5.visitConstantValue(r10.getValue());
    L5:
        KmType r11 = this.isInstanceType;
        if (r11 == null) goto L10;
        KmTypeVisitor r12 = r5.visitIsInstanceType(r11.getFlags());
        if (r12 == null) goto L10;
        r11.accept(r12);
    L10:
        Iterator<T> r13 = this.andArguments.iterator();
    L12:
        if (r13.hasNext() == false) goto L16;
        KmEffectExpression r14 = (KmEffectExpression) r13.next();
        KmEffectExpressionVisitor r15 = r5.visitAndArgument();
        if (r15 == null) goto L12;
        r14.accept(r15);
        goto L12
    L16:
        Iterator<T> r16 = this.orArguments.iterator();
    L18:
        if (r16.hasNext() == false) goto L22;
        KmEffectExpression r17 = (KmEffectExpression) r16.next();
        KmEffectExpressionVisitor r18 = r5.visitOrArgument();
        if (r18 == null) goto L18;
        r17.accept(r18);
        goto L18
    L22:
        r5.visitEnd();
    }

    public final List<KmEffectExpression> getAndArguments() {
        return this.andArguments;
    }

    public final KmConstantValue getConstantValue() {
        return this.constantValue;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final List<KmEffectExpression> getOrArguments() {
        return this.orArguments;
    }

    public final Integer getParameterIndex() {
        return this.parameterIndex;
    }

    public final KmType isInstanceType() {
        return this.isInstanceType;
    }

    public final void setConstantValue(KmConstantValue r5) {
        this.constantValue = r5;
    }

    public final void setFlags(int r5) {
        this.flags = r5;
    }

    public final void setInstanceType(KmType r5) {
        this.isInstanceType = r5;
    }

    public final void setParameterIndex(Integer r5) {
        this.parameterIndex = r5;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
    public void visit(int r5, Integer r10) {
        this.flags = r5;
        this.parameterIndex = r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
    public KmEffectExpressionVisitor visitAndArgument() {
        return (KmEffectExpressionVisitor) NodesKt.addTo(new KmEffectExpression(), this.andArguments);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
    public void visitConstantValue(Object r5) {
        this.constantValue = new KmConstantValue(r5);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
    public KmTypeVisitor visitIsInstanceType(int r5) {
        KmType r10 = new KmType(r5);
        this.isInstanceType = r10;
        return r10;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmEffectExpressionVisitor
    public KmEffectExpressionVisitor visitOrArgument() {
        return (KmEffectExpressionVisitor) NodesKt.addTo(new KmEffectExpression(), this.orArguments);
    }
}
