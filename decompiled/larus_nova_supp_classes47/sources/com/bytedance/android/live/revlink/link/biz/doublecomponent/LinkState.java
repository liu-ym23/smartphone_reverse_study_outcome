package com.bytedance.android.live.revlink.link.biz.doublecomponent;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/revlink/link/biz/doublecomponent/LinkState;", "", "DISABLED", "SELF_JOIN", "SELF_JOIN_SUCCEED", "TURN_ON_ENGINE", "TURN_ON_ENGINE_SUCCEED", "CONNECTION_SUCCEED", "FINISH", "FINISH_SUCCEED", "FINISH_FAILED", "TURN_OFF_ENGINE", "TURN_OFF_ENGINE_SUCCEED", "UNLOADED", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkState extends Enum<LinkState> {
    public static final LinkState CONNECTION_SUCCEED = null;
    public static final LinkState DISABLED = null;
    public static final LinkState FINISH = null;
    public static final LinkState FINISH_FAILED = null;
    public static final LinkState FINISH_SUCCEED = null;
    public static final LinkState SELF_JOIN = null;
    public static final LinkState SELF_JOIN_SUCCEED = null;
    public static final LinkState TURN_OFF_ENGINE = null;
    public static final LinkState TURN_OFF_ENGINE_SUCCEED = null;
    public static final LinkState TURN_ON_ENGINE = null;
    public static final LinkState TURN_ON_ENGINE_SUCCEED = null;
    public static final LinkState UNLOADED = null;
    public static final /* synthetic */ LinkState[] a = null;

    static {
        LinkState r1 = new LinkState("DISABLED", 0);
        DISABLED = r1;
        LinkState r2 = new LinkState("SELF_JOIN", 1);
        SELF_JOIN = r2;
        LinkState r3 = new LinkState("SELF_JOIN_SUCCEED", 2);
        SELF_JOIN_SUCCEED = r3;
        LinkState r4 = new LinkState("TURN_ON_ENGINE", 3);
        TURN_ON_ENGINE = r4;
        LinkState r5 = new LinkState("TURN_ON_ENGINE_SUCCEED", 4);
        TURN_ON_ENGINE_SUCCEED = r5;
        LinkState r6 = new LinkState("CONNECTION_SUCCEED", 5);
        CONNECTION_SUCCEED = r6;
        LinkState r7 = new LinkState("FINISH", 6);
        FINISH = r7;
        LinkState r8 = new LinkState("FINISH_SUCCEED", 7);
        FINISH_SUCCEED = r8;
        LinkState r9 = new LinkState("FINISH_FAILED", 8);
        FINISH_FAILED = r9;
        LinkState r10 = new LinkState("TURN_OFF_ENGINE", 9);
        TURN_OFF_ENGINE = r10;
        LinkState r12 = new LinkState("TURN_OFF_ENGINE_SUCCEED", 10);
        TURN_OFF_ENGINE_SUCCEED = r12;
        LinkState r13 = new LinkState("UNLOADED", 11);
        UNLOADED = r13;
        a = new LinkState[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13};
    }

    public static LinkState valueOf(String r1) {
        return (LinkState) r27.a.a(LinkState.class, r1);
    }

    public static LinkState[] values() {
        return (LinkState[]) a.clone();
    }

    public LinkState(String r1, int r2) {
        super(r1, r2);
    }
}
