package com.bytedance.android.live.revlink.impl.control.launchcontext;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/launchcontext/PkAnchorLaunchType;", "", "RECEIVE_REPLY", "REPLY_SUCCESS", "REPLY_SUCCESS_ADVANCE", "SWITCH_FROM_LINK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkAnchorLaunchType extends Enum<PkAnchorLaunchType> {
    public static final PkAnchorLaunchType RECEIVE_REPLY = null;
    public static final PkAnchorLaunchType REPLY_SUCCESS = null;
    public static final PkAnchorLaunchType REPLY_SUCCESS_ADVANCE = null;
    public static final PkAnchorLaunchType SWITCH_FROM_LINK = null;
    public static final /* synthetic */ PkAnchorLaunchType[] a = null;

    static {
        PkAnchorLaunchType r1 = new PkAnchorLaunchType("RECEIVE_REPLY", 0);
        RECEIVE_REPLY = r1;
        PkAnchorLaunchType r2 = new PkAnchorLaunchType("REPLY_SUCCESS", 1);
        REPLY_SUCCESS = r2;
        PkAnchorLaunchType r3 = new PkAnchorLaunchType("REPLY_SUCCESS_ADVANCE", 2);
        REPLY_SUCCESS_ADVANCE = r3;
        PkAnchorLaunchType r4 = new PkAnchorLaunchType("SWITCH_FROM_LINK", 3);
        SWITCH_FROM_LINK = r4;
        a = new PkAnchorLaunchType[]{r1, r2, r3, r4};
    }

    public static PkAnchorLaunchType valueOf(String r1) {
        return (PkAnchorLaunchType) r27.a.a(PkAnchorLaunchType.class, r1);
    }

    public static PkAnchorLaunchType[] values() {
        return (PkAnchorLaunchType[]) a.clone();
    }

    public PkAnchorLaunchType(String r1, int r2) {
        super(r1, r2);
    }
}
