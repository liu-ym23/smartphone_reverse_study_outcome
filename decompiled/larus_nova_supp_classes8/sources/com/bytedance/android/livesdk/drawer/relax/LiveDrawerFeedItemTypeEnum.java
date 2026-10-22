package com.bytedance.android.livesdk.drawer.relax;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b!\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/relax/LiveDrawerFeedItemTypeEnum;", "", "", "value", "J", "getValue", "()J", "TypeUnknown", "TypeLiveRoom", "TypeFollowRoom", "TypeAdData", "TypeSmallLive", "TypeBigLive", "TypeBanner", "TypeRankRound", "TypeCategory", "TypeScheduledLive", "TypeTab", "TypePlaceHolder", "TypeUserLiveRecord", "TypeNotice", "TypeVSLive", "TypeVSFirstLive", "TypeVSRecord", "TypeToBLive", "TypeToBFollowTop", "TypeReserveProgram", "TypeInterestExploreCard", "TypeFeedbackCard", "TypeAntiAddictionCard", "TypeOperationBanner", "TypeOperationCard", "TypeAnnouncement", "TypePaidLiveCard", "TypeMultiCamera", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveDrawerFeedItemTypeEnum extends Enum<LiveDrawerFeedItemTypeEnum> {
    public static final LiveDrawerFeedItemTypeEnum TypeAdData = null;
    public static final LiveDrawerFeedItemTypeEnum TypeAnnouncement = null;
    public static final LiveDrawerFeedItemTypeEnum TypeAntiAddictionCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypeBanner = null;
    public static final LiveDrawerFeedItemTypeEnum TypeBigLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeCategory = null;
    public static final LiveDrawerFeedItemTypeEnum TypeFeedbackCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypeFollowRoom = null;
    public static final LiveDrawerFeedItemTypeEnum TypeInterestExploreCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypeLiveRoom = null;
    public static final LiveDrawerFeedItemTypeEnum TypeMultiCamera = null;
    public static final LiveDrawerFeedItemTypeEnum TypeNotice = null;
    public static final LiveDrawerFeedItemTypeEnum TypeOperationBanner = null;
    public static final LiveDrawerFeedItemTypeEnum TypeOperationCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypePaidLiveCard = null;
    public static final LiveDrawerFeedItemTypeEnum TypePlaceHolder = null;
    public static final LiveDrawerFeedItemTypeEnum TypeRankRound = null;
    public static final LiveDrawerFeedItemTypeEnum TypeReserveProgram = null;
    public static final LiveDrawerFeedItemTypeEnum TypeScheduledLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeSmallLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeTab = null;
    public static final LiveDrawerFeedItemTypeEnum TypeToBFollowTop = null;
    public static final LiveDrawerFeedItemTypeEnum TypeToBLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeUnknown = null;
    public static final LiveDrawerFeedItemTypeEnum TypeUserLiveRecord = null;
    public static final LiveDrawerFeedItemTypeEnum TypeVSFirstLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeVSLive = null;
    public static final LiveDrawerFeedItemTypeEnum TypeVSRecord = null;
    public static final /* synthetic */ LiveDrawerFeedItemTypeEnum[] a = null;
    private final long value;

    public static LiveDrawerFeedItemTypeEnum valueOf(String r1) {
        return (LiveDrawerFeedItemTypeEnum) r27.a.a(LiveDrawerFeedItemTypeEnum.class, r1);
    }

    public static LiveDrawerFeedItemTypeEnum[] values() {
        return (LiveDrawerFeedItemTypeEnum[]) a.clone();
    }

    static {
        LiveDrawerFeedItemTypeEnum r1 = new LiveDrawerFeedItemTypeEnum("TypeUnknown", 0, 0);
        TypeUnknown = r1;
        LiveDrawerFeedItemTypeEnum r2 = new LiveDrawerFeedItemTypeEnum("TypeLiveRoom", 1, 1);
        TypeLiveRoom = r2;
        LiveDrawerFeedItemTypeEnum r3 = new LiveDrawerFeedItemTypeEnum("TypeFollowRoom", 2, 2);
        TypeFollowRoom = r3;
        LiveDrawerFeedItemTypeEnum r4 = new LiveDrawerFeedItemTypeEnum("TypeAdData", 3, 3);
        TypeAdData = r4;
        LiveDrawerFeedItemTypeEnum r5 = new LiveDrawerFeedItemTypeEnum("TypeSmallLive", 4, 4);
        TypeSmallLive = r5;
        LiveDrawerFeedItemTypeEnum r6 = new LiveDrawerFeedItemTypeEnum("TypeBigLive", 5, 5);
        TypeBigLive = r6;
        LiveDrawerFeedItemTypeEnum r7 = new LiveDrawerFeedItemTypeEnum("TypeBanner", 6, 6);
        TypeBanner = r7;
        LiveDrawerFeedItemTypeEnum r8 = new LiveDrawerFeedItemTypeEnum("TypeRankRound", 7, 7);
        TypeRankRound = r8;
        LiveDrawerFeedItemTypeEnum r9 = new LiveDrawerFeedItemTypeEnum("TypeCategory", 8, 8);
        TypeCategory = r9;
        LiveDrawerFeedItemTypeEnum r10 = new LiveDrawerFeedItemTypeEnum("TypeScheduledLive", 9, 9);
        TypeScheduledLive = r10;
        LiveDrawerFeedItemTypeEnum r11 = new LiveDrawerFeedItemTypeEnum("TypeTab", 10, 10);
        TypeTab = r11;
        LiveDrawerFeedItemTypeEnum r12 = new LiveDrawerFeedItemTypeEnum("TypePlaceHolder", 11, 11);
        TypePlaceHolder = r12;
        LiveDrawerFeedItemTypeEnum r13 = new LiveDrawerFeedItemTypeEnum("TypeUserLiveRecord", 12, 12);
        TypeUserLiveRecord = r13;
        LiveDrawerFeedItemTypeEnum r14 = new LiveDrawerFeedItemTypeEnum("TypeNotice", 13, 13);
        TypeNotice = r14;
        LiveDrawerFeedItemTypeEnum r15 = new LiveDrawerFeedItemTypeEnum("TypeVSLive", 14, 14);
        TypeVSLive = r15;
        LiveDrawerFeedItemTypeEnum r16 = new LiveDrawerFeedItemTypeEnum("TypeVSFirstLive", 15, 15);
        TypeVSFirstLive = r16;
        LiveDrawerFeedItemTypeEnum r17 = new LiveDrawerFeedItemTypeEnum("TypeVSRecord", 16, 16);
        TypeVSRecord = r17;
        LiveDrawerFeedItemTypeEnum r18 = new LiveDrawerFeedItemTypeEnum("TypeToBLive", 17, 17);
        TypeToBLive = r18;
        LiveDrawerFeedItemTypeEnum r19 = new LiveDrawerFeedItemTypeEnum("TypeToBFollowTop", 18, 18);
        TypeToBFollowTop = r19;
        LiveDrawerFeedItemTypeEnum r20 = new LiveDrawerFeedItemTypeEnum("TypeReserveProgram", 19, 19);
        TypeReserveProgram = r20;
        LiveDrawerFeedItemTypeEnum r21 = new LiveDrawerFeedItemTypeEnum("TypeInterestExploreCard", 20, 20);
        TypeInterestExploreCard = r21;
        LiveDrawerFeedItemTypeEnum r22 = new LiveDrawerFeedItemTypeEnum("TypeFeedbackCard", 21, 21);
        TypeFeedbackCard = r22;
        LiveDrawerFeedItemTypeEnum r23 = new LiveDrawerFeedItemTypeEnum("TypeAntiAddictionCard", 22, 22);
        TypeAntiAddictionCard = r23;
        LiveDrawerFeedItemTypeEnum r24 = new LiveDrawerFeedItemTypeEnum("TypeOperationBanner", 23, 23);
        TypeOperationBanner = r24;
        LiveDrawerFeedItemTypeEnum r25 = new LiveDrawerFeedItemTypeEnum("TypeOperationCard", 24, 24);
        TypeOperationCard = r25;
        LiveDrawerFeedItemTypeEnum r26 = new LiveDrawerFeedItemTypeEnum("TypeAnnouncement", 25, 25);
        TypeAnnouncement = r26;
        LiveDrawerFeedItemTypeEnum r27 = new LiveDrawerFeedItemTypeEnum("TypePaidLiveCard", 26, 26);
        TypePaidLiveCard = r27;
        LiveDrawerFeedItemTypeEnum r28 = new LiveDrawerFeedItemTypeEnum("TypeMultiCamera", 27, 27);
        TypeMultiCamera = r28;
        a = new LiveDrawerFeedItemTypeEnum[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28};
    }

    public final long getValue() {
        return this.value;
    }

    public LiveDrawerFeedItemTypeEnum(String r1, int r2, long r3) {
        super(r1, r2);
        this.value = r3;
    }
}
