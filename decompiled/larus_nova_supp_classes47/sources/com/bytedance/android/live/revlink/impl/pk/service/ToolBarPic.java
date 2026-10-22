package com.bytedance.android.live.revlink.impl.pk.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/service/ToolBarPic;", "", "NONE", "PK_CLOSE_BROADCAST_OLD", "PK_CLOSE_BROADCAST", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ToolBarPic extends Enum<ToolBarPic> {
    public static final ToolBarPic NONE = null;
    public static final ToolBarPic PK_CLOSE_BROADCAST = null;
    public static final ToolBarPic PK_CLOSE_BROADCAST_OLD = null;
    public static final /* synthetic */ ToolBarPic[] a = null;

    static {
        ToolBarPic r1 = new ToolBarPic("NONE", 0);
        NONE = r1;
        ToolBarPic r2 = new ToolBarPic("PK_CLOSE_BROADCAST_OLD", 1);
        PK_CLOSE_BROADCAST_OLD = r2;
        ToolBarPic r3 = new ToolBarPic("PK_CLOSE_BROADCAST", 2);
        PK_CLOSE_BROADCAST = r3;
        a = new ToolBarPic[]{r1, r2, r3};
    }

    public static ToolBarPic valueOf(String r1) {
        return (ToolBarPic) r27.a.a(ToolBarPic.class, r1);
    }

    public static ToolBarPic[] values() {
        return (ToolBarPic[]) a.clone();
    }

    public ToolBarPic(String r1, int r2) {
        super(r1, r2);
    }
}
