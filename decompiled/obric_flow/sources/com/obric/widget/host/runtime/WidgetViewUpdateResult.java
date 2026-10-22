package com.obric.widget.host.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetViewUpdateResult;", "", "handled", "", "success", "payloadLength", "", "remoteUpdateDurationMs", "", "viewUpdateDurationMs", "<init>", "(ZZIJJ)V", "getHandled", "()Z", "getSuccess", "getPayloadLength", "()I", "getRemoteUpdateDurationMs", "()J", "getViewUpdateDurationMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetViewUpdateResult {
    private final boolean handled;
    private final int payloadLength;
    private final long remoteUpdateDurationMs;
    private final boolean success;
    private final long viewUpdateDurationMs;

    public WidgetViewUpdateResult(boolean r5, boolean r10, int r11, long r12, long r13) {
        this.handled = r5;
        this.success = r10;
        this.payloadLength = r11;
        this.remoteUpdateDurationMs = r12;
        this.viewUpdateDurationMs = r13;
    }

    public static /* synthetic */ WidgetViewUpdateResult copy$default(WidgetViewUpdateResult r5, boolean r10, boolean r11, int r12, long r13, long r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = r5.handled;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = r5.success;
    L8:
        boolean r17 = r11;
        if ((r15 & 4) == 0) goto L11;
        r12 = r5.payloadLength;
    L11:
        int r18 = r12;
        if ((r15 & 8) == 0) goto L14;
        r13 = r5.remoteUpdateDurationMs;
    L14:
        long r19 = r13;
        if ((r15 & 16) == 0) goto L17;
        r14 = r5.viewUpdateDurationMs;
    L17:
        boolean r20 = r10;
        return r5.copy(r20, r17, r18, r19, r14);
    }

    public final boolean component1() {
        return this.handled;
    }

    public final boolean component2() {
        return this.success;
    }

    public final int component3() {
        return this.payloadLength;
    }

    public final long component4() {
        return this.remoteUpdateDurationMs;
    }

    public final long component5() {
        return this.viewUpdateDurationMs;
    }

    public final WidgetViewUpdateResult copy(boolean r10, boolean r11, int r12, long r13, long r14) {
        return new WidgetViewUpdateResult(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetViewUpdateResult) == true) goto L8;
        return false;
    L8:
        WidgetViewUpdateResult r11 = (WidgetViewUpdateResult) r10;
        if (this.handled == r11.handled) goto L12;
        return false;
    L12:
        if (this.success == r11.success) goto L15;
        return false;
    L15:
        if (this.payloadLength == r11.payloadLength) goto L18;
        return false;
    L18:
        if (this.remoteUpdateDurationMs == r11.remoteUpdateDurationMs) goto L21;
        return false;
    L21:
        if (this.viewUpdateDurationMs == r11.viewUpdateDurationMs) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean getHandled() {
        return this.handled;
    }

    public final int getPayloadLength() {
        return this.payloadLength;
    }

    public final long getRemoteUpdateDurationMs() {
        return this.remoteUpdateDurationMs;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final long getViewUpdateDurationMs() {
        return this.viewUpdateDurationMs;
    }

    public int hashCode() {
        int r5 = androidx.room.jarjarred.org.antlr.runtime.a.d(Boolean.hashCode(this.handled) * 31, 31, this.success);
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.c(this.payloadLength, r5, 31), this.remoteUpdateDurationMs, 31);
        return Long.hashCode(this.viewUpdateDurationMs) + r10;
    }

    public String toString() {
        return "WidgetViewUpdateResult(handled=" + this.handled + ", success=" + this.success + ", payloadLength=" + this.payloadLength + ", remoteUpdateDurationMs=" + this.remoteUpdateDurationMs + ", viewUpdateDurationMs=" + this.viewUpdateDurationMs + ")";
    }
}
