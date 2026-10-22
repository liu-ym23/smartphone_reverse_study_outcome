package com.bytedance.android.live.browser.jsbridge.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/BattleLaunchType;", "", "", "type", "I", "getType", "()I", "Invite", "Reply", "Open", "SwitchAndOpen", "BizInvite", "BizEnd", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleLaunchType extends Enum<BattleLaunchType> {
    public static final BattleLaunchType BizEnd = null;
    public static final BattleLaunchType BizInvite = null;
    public static final BattleLaunchType Invite = null;
    public static final BattleLaunchType Open = null;
    public static final BattleLaunchType Reply = null;
    public static final BattleLaunchType SwitchAndOpen = null;
    public static final /* synthetic */ BattleLaunchType[] a = null;
    private final int type;

    static {
        BattleLaunchType r2 = new BattleLaunchType("Invite", 0, 1);
        Invite = r2;
        BattleLaunchType r3 = new BattleLaunchType("Reply", 1, 2);
        Reply = r3;
        BattleLaunchType r4 = new BattleLaunchType("Open", 2, 3);
        Open = r4;
        BattleLaunchType r5 = new BattleLaunchType("SwitchAndOpen", 3, 4);
        SwitchAndOpen = r5;
        BattleLaunchType r6 = new BattleLaunchType("BizInvite", 4, 5);
        BizInvite = r6;
        BattleLaunchType r7 = new BattleLaunchType("BizEnd", 5, 6);
        BizEnd = r7;
        a = new BattleLaunchType[]{r2, r3, r4, r5, r6, r7};
    }

    public static BattleLaunchType valueOf(String r1) {
        return (BattleLaunchType) a.a(BattleLaunchType.class, r1);
    }

    public static BattleLaunchType[] values() {
        return (BattleLaunchType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public BattleLaunchType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
