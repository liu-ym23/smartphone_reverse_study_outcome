package com.bytedance.android.livesdk.dislike;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
final enum FeedShareActionType extends Enum<FeedShareActionType> {
    public static final FeedShareActionType AFTER_DISLIKE = null;
    public static final FeedShareActionType AFTER_FOLLOW = null;
    public static final FeedShareActionType AFTER_REPORT = null;
    public static final FeedShareActionType UNSUPPORT = null;
    public static final /* synthetic */ FeedShareActionType[] a = null;
    public int value;

    static {
        FeedShareActionType r0 = new FeedShareActionType("UNSUPPORT", 0, 0);
        UNSUPPORT = r0;
        FeedShareActionType r1 = new FeedShareActionType("AFTER_DISLIKE", 1, 1);
        AFTER_DISLIKE = r1;
        FeedShareActionType r3 = new FeedShareActionType("AFTER_FOLLOW", 2, 2);
        AFTER_FOLLOW = r3;
        FeedShareActionType r5 = new FeedShareActionType("AFTER_REPORT", 3, 3);
        AFTER_REPORT = r5;
        a = new FeedShareActionType[]{r0, r1, r3, r5};
    }

    public static FeedShareActionType[] values() {
        return (FeedShareActionType[]) a.clone();
    }

    public static FeedShareActionType valueOf(String r1) {
        return (FeedShareActionType) r27.a.a(FeedShareActionType.class, r1);
    }

    public FeedShareActionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
