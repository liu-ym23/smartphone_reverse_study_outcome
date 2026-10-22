package androidx.compose.runtime;

import ai.j0;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/OffsetApplier;", "N", "Landroidx/compose/runtime/Applier;", "applier", "offset", "", "(Landroidx/compose/runtime/Applier;I)V", "current", "getCurrent", "()Ljava/lang/Object;", "nesting", "clear", "", Constant.ClientMessageType.DOWN, "node", "(Ljava/lang/Object;)V", "insertBottomUp", "index", "instance", "(ILjava/lang/Object;)V", "insertTopDown", "move", "from", "to", "count", "remove", "up", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nApplier.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Applier.kt\nandroidx/compose/runtime/OffsetApplier\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,288:1\n4548#2,5:289\n4548#2,5:294\n*S KotlinDebug\n*F\n+ 1 Applier.kt\nandroidx/compose/runtime/OffsetApplier\n*L\n263#1:289,5\n286#1:294,5\n*E\n"})
public final class OffsetApplier<N> implements Applier<N> {
    private final Applier<N> applier;
    private int nesting;
    private final int offset;

    public OffsetApplier(Applier<N> r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "applier");
        this.applier = r5;
        this.offset = r10;
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        throw j0.z("Clear is not valid on OffsetApplier");
    }

    @Override // androidx.compose.runtime.Applier
    public void down(N r5) {
        this.nesting++;
        this.applier.down(r5);
    }

    @Override // androidx.compose.runtime.Applier
    public N getCurrent() {
        return this.applier.getCurrent();
    }

    @Override // androidx.compose.runtime.Applier
    public void insertBottomUp(int r5, N r10) {
        Applier<N> r11 = this.applier;
        if (this.nesting != 0) goto L5;
        int r12 = this.offset;
    L6:
        r11.insertBottomUp(r5 + r12, r10);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // androidx.compose.runtime.Applier
    public void insertTopDown(int r5, N r10) {
        Applier<N> r11 = this.applier;
        if (this.nesting != 0) goto L5;
        int r12 = this.offset;
    L6:
        r11.insertTopDown(r5 + r12, r10);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // androidx.compose.runtime.Applier
    public void move(int r5, int r10, int r11) {
        if (this.nesting != 0) goto L5;
        int r12 = this.offset;
    L6:
        this.applier.move(r5 + r12, r10 + r12, r11);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // androidx.compose.runtime.Applier
    public void remove(int r5, int r10) {
        Applier<N> r11 = this.applier;
        if (this.nesting != 0) goto L5;
        int r12 = this.offset;
    L6:
        r11.remove(r5 + r12, r10);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // androidx.compose.runtime.Applier
    public void up() {
        int r5 = this.nesting;
        if (r5 <= 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        this.nesting = r5 - 1;
        this.applier.up();
        return;
    L10:
        throw j0.z("OffsetApplier up called with no corresponding down");
    L5:
        r10 = false;
        goto L6
    }
}
