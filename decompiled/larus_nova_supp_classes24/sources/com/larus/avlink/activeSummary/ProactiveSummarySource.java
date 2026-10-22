package com.larus.avlink.activeSummary;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/activeSummary/ProactiveSummarySource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "IM_FRONTIER", "IM_FRONTIER_CACHE", "SSE_FRONTIER", "SSE_FRONTIER_CACHE", "PUSH", "PUSH_CACHE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ProactiveSummarySource extends Enum<ProactiveSummarySource> {
    public static final ProactiveSummarySource IM_FRONTIER = null;
    public static final ProactiveSummarySource IM_FRONTIER_CACHE = null;
    public static final ProactiveSummarySource PUSH = null;
    public static final ProactiveSummarySource PUSH_CACHE = null;
    public static final ProactiveSummarySource SSE_FRONTIER = null;
    public static final ProactiveSummarySource SSE_FRONTIER_CACHE = null;
    public static final ProactiveSummarySource UNKNOWN = null;
    public static final /* synthetic */ ProactiveSummarySource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<ProactiveSummarySource> getEntries() {
        return b;
    }

    static {
        ProactiveSummarySource r0 = new ProactiveSummarySource("UNKNOWN", 0, "unknown");
        UNKNOWN = r0;
        ProactiveSummarySource r1 = new ProactiveSummarySource("IM_FRONTIER", 1, "im_frontier");
        IM_FRONTIER = r1;
        ProactiveSummarySource r2 = new ProactiveSummarySource("IM_FRONTIER_CACHE", 2, "im_frontier_cache");
        IM_FRONTIER_CACHE = r2;
        ProactiveSummarySource r4 = new ProactiveSummarySource("SSE_FRONTIER", 3, "sse_frontier");
        SSE_FRONTIER = r4;
        ProactiveSummarySource r6 = new ProactiveSummarySource("SSE_FRONTIER_CACHE", 4, "sse_frontier_cache");
        SSE_FRONTIER_CACHE = r6;
        ProactiveSummarySource r8 = new ProactiveSummarySource("PUSH", 5, "push");
        PUSH = r8;
        ProactiveSummarySource r10 = new ProactiveSummarySource("PUSH_CACHE", 6, "push_cache");
        PUSH_CACHE = r10;
        ProactiveSummarySource[] r12 = {r0, r1, r2, r4, r6, r8, r10};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static ProactiveSummarySource[] values() {
        return (ProactiveSummarySource[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ProactiveSummarySource valueOf(String r1) {
        return (ProactiveSummarySource) r27.a.a(ProactiveSummarySource.class, r1);
    }

    public ProactiveSummarySource(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
