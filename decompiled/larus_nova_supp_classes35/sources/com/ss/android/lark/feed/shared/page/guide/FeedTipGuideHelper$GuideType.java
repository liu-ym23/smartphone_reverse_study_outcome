package com.ss.android.lark.feed.shared.page.guide;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum FeedTipGuideHelper$GuideType extends Enum<FeedTipGuideHelper$GuideType> {
    public static final FeedTipGuideHelper$GuideType AT_ALL = null;
    public static final FeedTipGuideHelper$GuideType AT_USER = null;
    public static final FeedTipGuideHelper$GuideType BADGE_STYLE = null;
    public static final /* synthetic */ FeedTipGuideHelper$GuideType[] a = null;
    private int value;

    static {
        FeedTipGuideHelper$GuideType r0 = new FeedTipGuideHelper$GuideType("AT_USER", 0, 0);
        AT_USER = r0;
        FeedTipGuideHelper$GuideType r1 = new FeedTipGuideHelper$GuideType("AT_ALL", 1, 1);
        AT_ALL = r1;
        FeedTipGuideHelper$GuideType r3 = new FeedTipGuideHelper$GuideType("BADGE_STYLE", 2, 2);
        BADGE_STYLE = r3;
        a = new FeedTipGuideHelper$GuideType[]{r0, r1, r3};
    }

    public static FeedTipGuideHelper$GuideType[] values() {
        return (FeedTipGuideHelper$GuideType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static FeedTipGuideHelper$GuideType forNumber(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return BADGE_STYLE;
    L12:
        return AT_ALL;
    L14:
        return AT_USER;
    }

    public static FeedTipGuideHelper$GuideType valueOf(String r1) {
        return (FeedTipGuideHelper$GuideType) r27.a.a(FeedTipGuideHelper$GuideType.class, r1);
    }

    public static FeedTipGuideHelper$GuideType valueOf(int r0) {
        return forNumber(r0);
    }

    public FeedTipGuideHelper$GuideType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
