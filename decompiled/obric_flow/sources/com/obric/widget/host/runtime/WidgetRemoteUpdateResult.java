package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetRemoteUpdateResult;", "", "payload", "", "updateDurationMs", "", "<init>", "(Ljava/lang/String;J)V", "getPayload", "()Ljava/lang/String;", "getUpdateDurationMs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetRemoteUpdateResult {
    private final String payload;
    private final long updateDurationMs;

    public WidgetRemoteUpdateResult(String r5, long r10) {
        this.payload = r5;
        this.updateDurationMs = r10;
    }

    public static /* synthetic */ WidgetRemoteUpdateResult copy$default(WidgetRemoteUpdateResult r5, String r10, long r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.payload;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.updateDurationMs;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.payload;
    }

    public final long component2() {
        return this.updateDurationMs;
    }

    public final WidgetRemoteUpdateResult copy(String r5, long r10) {
        return new WidgetRemoteUpdateResult(r5, r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetRemoteUpdateResult) == true) goto L8;
        return false;
    L8:
        WidgetRemoteUpdateResult r11 = (WidgetRemoteUpdateResult) r10;
        if (Intrinsics.areEqual(this.payload, r11.payload) == true) goto L12;
        return false;
    L12:
        if (this.updateDurationMs == r11.updateDurationMs) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final long getUpdateDurationMs() {
        return this.updateDurationMs;
    }

    public int hashCode() {
        String r5 = this.payload;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = Long.hashCode(this.updateDurationMs);
        return r11 + (r10 * 31);
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "WidgetRemoteUpdateResult(payload=" + this.payload + ", updateDurationMs=" + this.updateDurationMs + ")";
    }
}
