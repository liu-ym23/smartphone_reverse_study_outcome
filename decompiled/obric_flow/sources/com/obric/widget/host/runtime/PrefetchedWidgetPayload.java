package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;", "", "payload", "", "source", "requestDurationMs", "", "fetchedAtElapsed", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getPayload", "()Ljava/lang/String;", "getSource", "getRequestDurationMs", "()J", "getFetchedAtElapsed", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PrefetchedWidgetPayload {
    private final long fetchedAtElapsed;
    private final String payload;
    private final long requestDurationMs;
    private final String source;

    public PrefetchedWidgetPayload(String r5, String r10, long r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        this.payload = r5;
        this.source = r10;
        this.requestDurationMs = r11;
        this.fetchedAtElapsed = r12;
    }

    public static /* synthetic */ PrefetchedWidgetPayload copy$default(PrefetchedWidgetPayload r5, String r10, String r11, long r12, long r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.payload;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r11 = r5.source;
    L8:
        String r16 = r11;
        if ((r14 & 4) == 0) goto L11;
        r12 = r5.requestDurationMs;
    L11:
        long r17 = r12;
        if ((r14 & 8) == 0) goto L14;
        r13 = r5.fetchedAtElapsed;
    L14:
        String r18 = r10;
        return r5.copy(r18, r16, r17, r13);
    }

    public final String component1() {
        return this.payload;
    }

    public final String component2() {
        return this.source;
    }

    public final long component3() {
        return this.requestDurationMs;
    }

    public final long component4() {
        return this.fetchedAtElapsed;
    }

    public final PrefetchedWidgetPayload copy(String r10, String r11, long r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "source");
        return new PrefetchedWidgetPayload(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PrefetchedWidgetPayload) == true) goto L8;
        return false;
    L8:
        PrefetchedWidgetPayload r11 = (PrefetchedWidgetPayload) r10;
        if (Intrinsics.areEqual(this.payload, r11.payload) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.source, r11.source) == true) goto L15;
        return false;
    L15:
        if (this.requestDurationMs == r11.requestDurationMs) goto L18;
        return false;
    L18:
        if (this.fetchedAtElapsed == r11.fetchedAtElapsed) goto L20;
        return false;
    L20:
        return true;
    }

    public final long getFetchedAtElapsed() {
        return this.fetchedAtElapsed;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final long getRequestDurationMs() {
        return this.requestDurationMs;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        String r5 = this.payload;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.constraintlayout.motion.widget.a.c(r10 * 31, 31, this.source), this.requestDurationMs, 31);
        return Long.hashCode(this.fetchedAtElapsed) + r11;
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public String toString() {
        String r5 = this.payload;
        String r10 = this.source;
        long r11 = this.requestDurationMs;
        long r12 = this.fetchedAtElapsed;
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.y("PrefetchedWidgetPayload(payload=", r5, ", source=", r10, ", requestDurationMs=");
        r13.append(r11);
        r13.append(", fetchedAtElapsed=");
        r13.append(r12);
        r13.append(")");
        return r13.toString();
    }
}
