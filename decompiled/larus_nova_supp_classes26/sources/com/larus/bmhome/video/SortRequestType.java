package com.larus.bmhome.video;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/video/SortRequestType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "PreLoad", "UserClickEnterPage", "UserSlideEnterPage", "LandingEnterPage", "UserLoadMore", "UserPullRefresh", "UserClickTabRefresh", "AutoRefresh", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SortRequestType extends Enum<SortRequestType> {
    public static final SortRequestType AutoRefresh = null;
    public static final a Companion = null;
    public static final SortRequestType LandingEnterPage = null;
    public static final SortRequestType PreLoad = null;
    public static final SortRequestType Unknown = null;
    public static final SortRequestType UserClickEnterPage = null;
    public static final SortRequestType UserClickTabRefresh = null;
    public static final SortRequestType UserLoadMore = null;
    public static final SortRequestType UserPullRefresh = null;
    public static final SortRequestType UserSlideEnterPage = null;
    public static final /* synthetic */ SortRequestType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<SortRequestType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.bmhome.video.SortRequestType$a] */
    static {
        SortRequestType r0 = new SortRequestType("Unknown", 0, 0);
        Unknown = r0;
        SortRequestType r1 = new SortRequestType("PreLoad", 1, 1);
        PreLoad = r1;
        SortRequestType r3 = new SortRequestType("UserClickEnterPage", 2, 2);
        UserClickEnterPage = r3;
        SortRequestType r5 = new SortRequestType("UserSlideEnterPage", 3, 3);
        UserSlideEnterPage = r5;
        SortRequestType r7 = new SortRequestType("LandingEnterPage", 4, 4);
        LandingEnterPage = r7;
        SortRequestType r9 = new SortRequestType("UserLoadMore", 5, 5);
        UserLoadMore = r9;
        SortRequestType r11 = new SortRequestType("UserPullRefresh", 6, 6);
        UserPullRefresh = r11;
        SortRequestType r13 = new SortRequestType("UserClickTabRefresh", 7, 7);
        UserClickTabRefresh = r13;
        SortRequestType r15 = new SortRequestType("AutoRefresh", 8, 8);
        AutoRefresh = r15;
        SortRequestType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
        Companion = new a();
    }

    public static SortRequestType[] values() {
        return (SortRequestType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SortRequestType valueOf(String r1) {
        return (SortRequestType) r27.a.a(SortRequestType.class, r1);
    }

    public SortRequestType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
