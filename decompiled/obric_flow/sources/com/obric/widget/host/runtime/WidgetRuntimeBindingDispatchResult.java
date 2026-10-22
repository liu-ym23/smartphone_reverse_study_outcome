package com.obric.widget.host.runtime;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRuntimeBindingDispatchResult;", "", "snapshot", "Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "queued", "", "skippedReason", "", "<init>", "(Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;ZLjava/lang/String;)V", "getSnapshot", "()Lcom/obric/widget/host/runtime/WidgetRuntimeBindingSnapshot;", "getQueued", "()Z", "getSkippedReason", "()Ljava/lang/String;", "instanceId", "", "getInstanceId", "()Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRuntimeBindingDispatchResult {
    private final boolean queued;
    private final String skippedReason;
    private final WidgetRuntimeBindingSnapshot snapshot;

    public WidgetRuntimeBindingDispatchResult(WidgetRuntimeBindingSnapshot r5, boolean r10, String r11) {
        this.snapshot = r5;
        this.queued = r10;
        this.skippedReason = r11;
    }

    public static /* synthetic */ WidgetRuntimeBindingDispatchResult copy$default(WidgetRuntimeBindingDispatchResult r5, WidgetRuntimeBindingSnapshot r10, boolean r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.snapshot;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.queued;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.skippedReason;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final WidgetRuntimeBindingSnapshot component1() {
        return this.snapshot;
    }

    public final boolean component2() {
        return this.queued;
    }

    public final String component3() {
        return this.skippedReason;
    }

    public final WidgetRuntimeBindingDispatchResult copy(WidgetRuntimeBindingSnapshot r5, boolean r10, String r11) {
        return new WidgetRuntimeBindingDispatchResult(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetRuntimeBindingDispatchResult) == true) goto L8;
        return false;
    L8:
        WidgetRuntimeBindingDispatchResult r10 = (WidgetRuntimeBindingDispatchResult) r5;
        if (Intrinsics.areEqual(this.snapshot, r10.snapshot) == true) goto L12;
        return false;
    L12:
        if (this.queued == r10.queued) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.skippedReason, r10.skippedReason) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Integer getInstanceId() {
        WidgetRuntimeBindingSnapshot r5 = this.snapshot;
        if (r5 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r5.getInstanceId());
    }

    public final boolean getQueued() {
        return this.queued;
    }

    public final String getSkippedReason() {
        return this.skippedReason;
    }

    public final WidgetRuntimeBindingSnapshot getSnapshot() {
        return this.snapshot;
    }

    public int hashCode() {
        WidgetRuntimeBindingSnapshot r5 = this.snapshot;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.d(r11 * 31, 31, this.queued);
        String r13 = this.skippedReason;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return r12 + r10;
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        WidgetRuntimeBindingSnapshot r5 = this.snapshot;
        boolean r10 = this.queued;
        String r11 = this.skippedReason;
        StringBuilder r12 = new StringBuilder("WidgetRuntimeBindingDispatchResult(snapshot=");
        r12.append(r5);
        r12.append(", queued=");
        r12.append(r10);
        r12.append(", skippedReason=");
        return j0.q(r12, r11, ")");
    }

    public /* synthetic */ WidgetRuntimeBindingDispatchResult(WidgetRuntimeBindingSnapshot r5, boolean r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        this(r5, r10, r11);
    }
}
