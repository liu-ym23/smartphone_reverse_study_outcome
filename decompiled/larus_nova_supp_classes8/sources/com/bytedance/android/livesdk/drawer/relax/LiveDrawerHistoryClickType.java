package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerHistoryClickType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "WATCHLIVE", "PERSONALDETAIL", "FOLLOW", "UNFOLLOW", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerHistoryClickType extends Enum<LiveDrawerHistoryClickType> {
    public static final LiveDrawerHistoryClickType FOLLOW = null;
    public static final LiveDrawerHistoryClickType PERSONALDETAIL = null;
    public static final LiveDrawerHistoryClickType UNFOLLOW = null;
    public static final LiveDrawerHistoryClickType WATCHLIVE = null;
    public static final /* synthetic */ LiveDrawerHistoryClickType[] a = null;
    private final String value;

    static {
        LiveDrawerHistoryClickType r1 = new LiveDrawerHistoryClickType("WATCHLIVE", 0, "watch_live");
        WATCHLIVE = r1;
        LiveDrawerHistoryClickType r2 = new LiveDrawerHistoryClickType("PERSONALDETAIL", 1, "personal_detail");
        PERSONALDETAIL = r2;
        LiveDrawerHistoryClickType r3 = new LiveDrawerHistoryClickType("FOLLOW", 2, "follow");
        FOLLOW = r3;
        LiveDrawerHistoryClickType r4 = new LiveDrawerHistoryClickType("UNFOLLOW", 3, "unfollow");
        UNFOLLOW = r4;
        a = new LiveDrawerHistoryClickType[]{r1, r2, r3, r4};
    }

    public static LiveDrawerHistoryClickType valueOf(String r1) {
        return (LiveDrawerHistoryClickType) r27.a.a(LiveDrawerHistoryClickType.class, r1);
    }

    public static LiveDrawerHistoryClickType[] values() {
        return (LiveDrawerHistoryClickType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public LiveDrawerHistoryClickType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
