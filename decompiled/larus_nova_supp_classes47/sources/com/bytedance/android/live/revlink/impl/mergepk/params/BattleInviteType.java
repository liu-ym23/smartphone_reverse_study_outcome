package com.bytedance.android.live.revlink.impl.mergepk.params;

import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/params/BattleInviteType;", "", "", "type", "I", "getType", "()I", "UNKNOWN", "AGAIN", "MULTIPLE_MATCHES3", "MULTIPLE_AGAIN", "NORMAL_ACTIVITY", "MULTIPLE_ACTIVITY", "CHANGE_MULTI_PK_MODE", "OPEN_GAME_CHANGE_PK_MODE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BattleInviteType extends Enum<BattleInviteType> {
    public static final BattleInviteType AGAIN = null;
    public static final BattleInviteType CHANGE_MULTI_PK_MODE = null;

    @Deprecated(message = "")
    public static final BattleInviteType MULTIPLE_ACTIVITY = null;
    public static final BattleInviteType MULTIPLE_AGAIN = null;

    @Deprecated(message = "三局两胜已下线")
    public static final BattleInviteType MULTIPLE_MATCHES3 = null;

    @Deprecated(message = "")
    public static final BattleInviteType NORMAL_ACTIVITY = null;
    public static final BattleInviteType OPEN_GAME_CHANGE_PK_MODE = null;
    public static final BattleInviteType UNKNOWN = null;
    public static final /* synthetic */ BattleInviteType[] a = null;
    private final int type;

    public static BattleInviteType valueOf(String r1) {
        return (BattleInviteType) a.a(BattleInviteType.class, r1);
    }

    public static BattleInviteType[] values() {
        return (BattleInviteType[]) a.clone();
    }

    static {
        BattleInviteType r1 = new BattleInviteType("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        BattleInviteType r2 = new BattleInviteType("AGAIN", 1, 1);
        AGAIN = r2;
        BattleInviteType r3 = new BattleInviteType("MULTIPLE_MATCHES3", 2, 2);
        MULTIPLE_MATCHES3 = r3;
        BattleInviteType r4 = new BattleInviteType("MULTIPLE_AGAIN", 3, 3);
        MULTIPLE_AGAIN = r4;
        BattleInviteType r5 = new BattleInviteType("NORMAL_ACTIVITY", 4, 4);
        NORMAL_ACTIVITY = r5;
        BattleInviteType r6 = new BattleInviteType("MULTIPLE_ACTIVITY", 5, 5);
        MULTIPLE_ACTIVITY = r6;
        BattleInviteType r7 = new BattleInviteType("CHANGE_MULTI_PK_MODE", 6, 6);
        CHANGE_MULTI_PK_MODE = r7;
        BattleInviteType r8 = new BattleInviteType("OPEN_GAME_CHANGE_PK_MODE", 7, 7);
        OPEN_GAME_CHANGE_PK_MODE = r8;
        a = new BattleInviteType[]{r1, r2, r3, r4, r5, r6, r7, r8};
    }

    public final int getType() {
        return this.type;
    }

    public BattleInviteType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
