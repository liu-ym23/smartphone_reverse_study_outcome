package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/MultiLinkPanelLifecycle;", "", "UNKONWN", "SHOW", "HIDE", "UPDATE", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkPanelLifecycle extends Enum<MultiLinkPanelLifecycle> {
    public static final MultiLinkPanelLifecycle HIDE = null;
    public static final MultiLinkPanelLifecycle SHOW = null;
    public static final MultiLinkPanelLifecycle UNKONWN = null;
    public static final MultiLinkPanelLifecycle UPDATE = null;
    public static final /* synthetic */ MultiLinkPanelLifecycle[] a = null;

    static {
        MultiLinkPanelLifecycle r1 = new MultiLinkPanelLifecycle("UNKONWN", 0);
        UNKONWN = r1;
        MultiLinkPanelLifecycle r2 = new MultiLinkPanelLifecycle("SHOW", 1);
        SHOW = r2;
        MultiLinkPanelLifecycle r3 = new MultiLinkPanelLifecycle("HIDE", 2);
        HIDE = r3;
        MultiLinkPanelLifecycle r4 = new MultiLinkPanelLifecycle("UPDATE", 3);
        UPDATE = r4;
        a = new MultiLinkPanelLifecycle[]{r1, r2, r3, r4};
    }

    public static MultiLinkPanelLifecycle valueOf(String r1) {
        return (MultiLinkPanelLifecycle) a.a(MultiLinkPanelLifecycle.class, r1);
    }

    public static MultiLinkPanelLifecycle[] values() {
        return (MultiLinkPanelLifecycle[]) a.clone();
    }

    public MultiLinkPanelLifecycle(String r1, int r2) {
        super(r1, r2);
    }
}
