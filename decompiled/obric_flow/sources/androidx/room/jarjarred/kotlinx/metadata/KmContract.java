package androidx.room.jarjarred.kotlinx.metadata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmContract;", "Landroidx/room/jarjarred/kotlinx/metadata/KmContractVisitor;", "()V", "effects", "", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffect;", "getEffects", "()Ljava/util/List;", "accept", "", "visitor", "visitEffect", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectVisitor;", "type", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectType;", "invocationKind", "Landroidx/room/jarjarred/kotlinx/metadata/KmEffectInvocationKind;", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmContract extends KmContractVisitor {
    private final List<KmEffect> effects;

    public KmContract() {
        super(null, 1, null);
        this.effects = new ArrayList(1);
    }

    public final void accept(KmContractVisitor r5) {
        Intrinsics.checkNotNullParameter(r5, "visitor");
        Iterator<T> r10 = this.effects.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        KmEffect r11 = (KmEffect) r10.next();
        KmEffectVisitor r12 = r5.visitEffect(r11.getType(), r11.getInvocationKind());
        if (r12 == null) goto L4;
        r11.accept(r12);
        goto L4
    L8:
        r5.visitEnd();
    }

    public final List<KmEffect> getEffects() {
        return this.effects;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.KmContractVisitor
    public KmEffectVisitor visitEffect(KmEffectType r5, KmEffectInvocationKind r10) {
        Intrinsics.checkNotNullParameter(r5, "type");
        return (KmEffectVisitor) NodesKt.addTo(new KmEffect(r5, r10), this.effects);
    }
}
