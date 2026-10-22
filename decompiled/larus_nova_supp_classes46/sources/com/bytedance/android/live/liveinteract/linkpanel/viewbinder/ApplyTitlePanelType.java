package com.bytedance.android.live.liveinteract.linkpanel.viewbinder;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewbinder/ApplyTitlePanelType;", "", "UNKNOWN", "GUEST_APPLY", "ANCHOR_APPLY", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ApplyTitlePanelType extends Enum<ApplyTitlePanelType> {
    public static final ApplyTitlePanelType ANCHOR_APPLY = null;
    public static final ApplyTitlePanelType GUEST_APPLY = null;
    public static final ApplyTitlePanelType UNKNOWN = null;
    public static final /* synthetic */ ApplyTitlePanelType[] a = null;

    static {
        ApplyTitlePanelType r1 = new ApplyTitlePanelType("UNKNOWN", 0);
        UNKNOWN = r1;
        ApplyTitlePanelType r2 = new ApplyTitlePanelType("GUEST_APPLY", 1);
        GUEST_APPLY = r2;
        ApplyTitlePanelType r3 = new ApplyTitlePanelType("ANCHOR_APPLY", 2);
        ANCHOR_APPLY = r3;
        a = new ApplyTitlePanelType[]{r1, r2, r3};
    }

    public static ApplyTitlePanelType valueOf(String r1) {
        return (ApplyTitlePanelType) r27.a.a(ApplyTitlePanelType.class, r1);
    }

    public static ApplyTitlePanelType[] values() {
        return (ApplyTitlePanelType[]) a.clone();
    }

    public ApplyTitlePanelType(String r1, int r2) {
        super(r1, r2);
    }
}
