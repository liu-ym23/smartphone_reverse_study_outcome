package com.bytedance.android.live.revlink.impl.jsb;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/jsb/DynamicMultiAnchorEvent;", "", "Unknown", "Mute", "WindowClick", "InterComment", "NeedExtraView", "MultiWindowClick", "MuteAiIconClick", "CellularEnhanced", "Enlarge", "KickOut", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum DynamicMultiAnchorEvent extends Enum<DynamicMultiAnchorEvent> {
    public static final DynamicMultiAnchorEvent CellularEnhanced = null;
    public static final DynamicMultiAnchorEvent Enlarge = null;
    public static final DynamicMultiAnchorEvent InterComment = null;
    public static final DynamicMultiAnchorEvent KickOut = null;
    public static final DynamicMultiAnchorEvent MultiWindowClick = null;
    public static final DynamicMultiAnchorEvent Mute = null;
    public static final DynamicMultiAnchorEvent MuteAiIconClick = null;
    public static final DynamicMultiAnchorEvent NeedExtraView = null;
    public static final DynamicMultiAnchorEvent Unknown = null;
    public static final DynamicMultiAnchorEvent WindowClick = null;
    public static final /* synthetic */ DynamicMultiAnchorEvent[] a = null;

    static {
        DynamicMultiAnchorEvent r1 = new DynamicMultiAnchorEvent("Unknown", 0);
        Unknown = r1;
        DynamicMultiAnchorEvent r2 = new DynamicMultiAnchorEvent("Mute", 1);
        Mute = r2;
        DynamicMultiAnchorEvent r3 = new DynamicMultiAnchorEvent("WindowClick", 2);
        WindowClick = r3;
        DynamicMultiAnchorEvent r4 = new DynamicMultiAnchorEvent("InterComment", 3);
        InterComment = r4;
        DynamicMultiAnchorEvent r5 = new DynamicMultiAnchorEvent("NeedExtraView", 4);
        NeedExtraView = r5;
        DynamicMultiAnchorEvent r6 = new DynamicMultiAnchorEvent("MultiWindowClick", 5);
        MultiWindowClick = r6;
        DynamicMultiAnchorEvent r7 = new DynamicMultiAnchorEvent("MuteAiIconClick", 6);
        MuteAiIconClick = r7;
        DynamicMultiAnchorEvent r8 = new DynamicMultiAnchorEvent("CellularEnhanced", 7);
        CellularEnhanced = r8;
        DynamicMultiAnchorEvent r9 = new DynamicMultiAnchorEvent("Enlarge", 8);
        Enlarge = r9;
        DynamicMultiAnchorEvent r10 = new DynamicMultiAnchorEvent("KickOut", 9);
        KickOut = r10;
        a = new DynamicMultiAnchorEvent[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public static DynamicMultiAnchorEvent valueOf(String r1) {
        return (DynamicMultiAnchorEvent) r27.a.a(DynamicMultiAnchorEvent.class, r1);
    }

    public static DynamicMultiAnchorEvent[] values() {
        return (DynamicMultiAnchorEvent[]) a.clone();
    }

    public DynamicMultiAnchorEvent(String r1, int r2) {
        super(r1, r2);
    }
}
