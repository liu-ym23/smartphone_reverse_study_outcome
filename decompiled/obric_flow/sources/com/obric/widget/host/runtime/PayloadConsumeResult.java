package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/widget/host/runtime/PayloadConsumeResult;", "", "payload", "Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;", "cacheHit", "", "reusedInFlight", "ready", "<init>", "(Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;ZZZ)V", "getPayload", "()Lcom/obric/widget/host/runtime/PrefetchedWidgetPayload;", "getCacheHit", "()Z", "getReusedInFlight", "getReady", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PayloadConsumeResult {
    private final boolean cacheHit;
    private final PrefetchedWidgetPayload payload;
    private final boolean ready;
    private final boolean reusedInFlight;

    public PayloadConsumeResult(PrefetchedWidgetPayload r5, boolean r10, boolean r11, boolean r12) {
        this.payload = r5;
        this.cacheHit = r10;
        this.reusedInFlight = r11;
        this.ready = r12;
    }

    public static /* synthetic */ PayloadConsumeResult copy$default(PayloadConsumeResult r5, PrefetchedWidgetPayload r10, boolean r11, boolean r12, boolean r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.payload;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.cacheHit;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.reusedInFlight;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.ready;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final PrefetchedWidgetPayload component1() {
        return this.payload;
    }

    public final boolean component2() {
        return this.cacheHit;
    }

    public final boolean component3() {
        return this.reusedInFlight;
    }

    public final boolean component4() {
        return this.ready;
    }

    public final PayloadConsumeResult copy(PrefetchedWidgetPayload r5, boolean r10, boolean r11, boolean r12) {
        return new PayloadConsumeResult(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PayloadConsumeResult) == true) goto L8;
        return false;
    L8:
        PayloadConsumeResult r10 = (PayloadConsumeResult) r5;
        if (Intrinsics.areEqual(this.payload, r10.payload) == true) goto L12;
        return false;
    L12:
        if (this.cacheHit == r10.cacheHit) goto L15;
        return false;
    L15:
        if (this.reusedInFlight == r10.reusedInFlight) goto L18;
        return false;
    L18:
        if (this.ready == r10.ready) goto L20;
        return false;
    L20:
        return true;
    }

    public final boolean getCacheHit() {
        return this.cacheHit;
    }

    public final PrefetchedWidgetPayload getPayload() {
        return this.payload;
    }

    public final boolean getReady() {
        return this.ready;
    }

    public final boolean getReusedInFlight() {
        return this.reusedInFlight;
    }

    public int hashCode() {
        PrefetchedWidgetPayload r5 = this.payload;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.d(r10 * 31, 31, this.cacheHit), 31, this.reusedInFlight);
        return Boolean.hashCode(this.ready) + r11;
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "PayloadConsumeResult(payload=" + this.payload + ", cacheHit=" + this.cacheHit + ", reusedInFlight=" + this.reusedInFlight + ", ready=" + this.ready + ")";
    }
}
