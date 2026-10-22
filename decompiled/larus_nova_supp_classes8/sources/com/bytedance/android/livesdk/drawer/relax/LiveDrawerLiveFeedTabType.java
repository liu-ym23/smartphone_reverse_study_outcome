package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerLiveFeedTabType;", "", "", "value", "J", "getValue", "()J", "Recommend", "Follow", "City", "Goods", "Selected", "Sold", "Game", "Chat", "Voice", "Music", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerLiveFeedTabType extends Enum<LiveDrawerLiveFeedTabType> {
    public static final LiveDrawerLiveFeedTabType Chat = null;
    public static final LiveDrawerLiveFeedTabType City = null;
    public static final LiveDrawerLiveFeedTabType Follow = null;
    public static final LiveDrawerLiveFeedTabType Game = null;
    public static final LiveDrawerLiveFeedTabType Goods = null;
    public static final LiveDrawerLiveFeedTabType Music = null;
    public static final LiveDrawerLiveFeedTabType Recommend = null;
    public static final LiveDrawerLiveFeedTabType Selected = null;
    public static final LiveDrawerLiveFeedTabType Sold = null;
    public static final LiveDrawerLiveFeedTabType Voice = null;
    public static final /* synthetic */ LiveDrawerLiveFeedTabType[] a = null;
    private final long value;

    public static LiveDrawerLiveFeedTabType valueOf(String r1) {
        return (LiveDrawerLiveFeedTabType) r27.a.a(LiveDrawerLiveFeedTabType.class, r1);
    }

    public static LiveDrawerLiveFeedTabType[] values() {
        return (LiveDrawerLiveFeedTabType[]) a.clone();
    }

    static {
        LiveDrawerLiveFeedTabType r1 = new LiveDrawerLiveFeedTabType("Recommend", 0, 1);
        Recommend = r1;
        LiveDrawerLiveFeedTabType r2 = new LiveDrawerLiveFeedTabType("Follow", 1, 2);
        Follow = r2;
        LiveDrawerLiveFeedTabType r3 = new LiveDrawerLiveFeedTabType("City", 2, 3);
        City = r3;
        LiveDrawerLiveFeedTabType r4 = new LiveDrawerLiveFeedTabType("Goods", 3, 4);
        Goods = r4;
        LiveDrawerLiveFeedTabType r5 = new LiveDrawerLiveFeedTabType("Selected", 4, 5);
        Selected = r5;
        LiveDrawerLiveFeedTabType r6 = new LiveDrawerLiveFeedTabType("Sold", 5, 11);
        Sold = r6;
        LiveDrawerLiveFeedTabType r7 = new LiveDrawerLiveFeedTabType("Game", 6, 12);
        Game = r7;
        LiveDrawerLiveFeedTabType r8 = new LiveDrawerLiveFeedTabType("Chat", 7, 13);
        Chat = r8;
        LiveDrawerLiveFeedTabType r9 = new LiveDrawerLiveFeedTabType("Voice", 8, 14);
        Voice = r9;
        LiveDrawerLiveFeedTabType r10 = new LiveDrawerLiveFeedTabType("Music", 9, 15);
        Music = r10;
        a = new LiveDrawerLiveFeedTabType[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerLiveFeedTabType(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
