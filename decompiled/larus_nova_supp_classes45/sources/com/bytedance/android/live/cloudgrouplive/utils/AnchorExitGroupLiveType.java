package com.bytedance.android.live.cloudgrouplive.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/utils/AnchorExitGroupLiveType;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "SELF_EXIT", "CLOSE_LIVE", "KICK_OUT", "HOST_END", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AnchorExitGroupLiveType extends Enum<AnchorExitGroupLiveType> {
    public static final AnchorExitGroupLiveType CLOSE_LIVE = null;
    public static final AnchorExitGroupLiveType HOST_END = null;
    public static final AnchorExitGroupLiveType KICK_OUT = null;
    public static final AnchorExitGroupLiveType SELF_EXIT = null;
    public static final /* synthetic */ AnchorExitGroupLiveType[] a = null;
    private final String des;

    static {
        AnchorExitGroupLiveType r1 = new AnchorExitGroupLiveType("SELF_EXIT", 0, "sure");
        SELF_EXIT = r1;
        AnchorExitGroupLiveType r2 = new AnchorExitGroupLiveType("CLOSE_LIVE", 1, "over");
        CLOSE_LIVE = r2;
        AnchorExitGroupLiveType r3 = new AnchorExitGroupLiveType("KICK_OUT", 2, "remove");
        KICK_OUT = r3;
        AnchorExitGroupLiveType r4 = new AnchorExitGroupLiveType("HOST_END", 3, "end");
        HOST_END = r4;
        a = new AnchorExitGroupLiveType[]{r1, r2, r3, r4};
    }

    public static AnchorExitGroupLiveType valueOf(String r1) {
        return (AnchorExitGroupLiveType) a.a(AnchorExitGroupLiveType.class, r1);
    }

    public static AnchorExitGroupLiveType[] values() {
        return (AnchorExitGroupLiveType[]) a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public AnchorExitGroupLiveType(String r1, int r2, String r3) {
        super(r1, r2);
        this.des = r3;
    }
}
