package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetSnapshotQueryResult;", "", "snapshot", "Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "queryDurationMs", "", "errorWithoutPayload", "", "<init>", "(Lcom/obric/widget/host/runtime/WidgetDataSnapshot;JZ)V", "getSnapshot", "()Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "getQueryDurationMs", "()J", "getErrorWithoutPayload", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetSnapshotQueryResult {
    private final boolean errorWithoutPayload;
    private final long queryDurationMs;
    private final WidgetDataSnapshot snapshot;

    public WidgetSnapshotQueryResult(WidgetDataSnapshot r5, long r10, boolean r11) {
        this.snapshot = r5;
        this.queryDurationMs = r10;
        this.errorWithoutPayload = r11;
    }

    public static /* synthetic */ WidgetSnapshotQueryResult copy$default(WidgetSnapshotQueryResult r5, WidgetDataSnapshot r10, long r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.snapshot;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.queryDurationMs;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.errorWithoutPayload;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final WidgetDataSnapshot component1() {
        return this.snapshot;
    }

    public final long component2() {
        return this.queryDurationMs;
    }

    public final boolean component3() {
        return this.errorWithoutPayload;
    }

    public final WidgetSnapshotQueryResult copy(WidgetDataSnapshot r5, long r10, boolean r11) {
        return new WidgetSnapshotQueryResult(r5, r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetSnapshotQueryResult) == true) goto L8;
        return false;
    L8:
        WidgetSnapshotQueryResult r11 = (WidgetSnapshotQueryResult) r10;
        if (Intrinsics.areEqual(this.snapshot, r11.snapshot) == true) goto L12;
        return false;
    L12:
        if (this.queryDurationMs == r11.queryDurationMs) goto L15;
        return false;
    L15:
        if (this.errorWithoutPayload == r11.errorWithoutPayload) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean getErrorWithoutPayload() {
        return this.errorWithoutPayload;
    }

    public final long getQueryDurationMs() {
        return this.queryDurationMs;
    }

    public final WidgetDataSnapshot getSnapshot() {
        return this.snapshot;
    }

    public int hashCode() {
        WidgetDataSnapshot r5 = this.snapshot;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.e(r10 * 31, this.queryDurationMs, 31);
        return Boolean.hashCode(this.errorWithoutPayload) + r11;
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "WidgetSnapshotQueryResult(snapshot=" + this.snapshot + ", queryDurationMs=" + this.queryDurationMs + ", errorWithoutPayload=" + this.errorWithoutPayload + ")";
    }
}
