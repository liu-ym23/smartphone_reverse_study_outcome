package com.bytedance.android.live.profit.fansclub;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FansClubEntranceParams {
    public final Page a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final Entrance f;
    public final boolean g;
    public final String h;
    public final String i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/FansClubEntranceParams$Entrance;", "", "Unspecified", "UserInfoFansClubWidget", "SubscribeEmojiPanel", "PersonalProfile", "UserInfoEcomFansClubWidget", "PkFullFeedView", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Entrance extends Enum<Entrance> {
        public static final Entrance PersonalProfile = null;
        public static final Entrance PkFullFeedView = null;
        public static final Entrance SubscribeEmojiPanel = null;
        public static final Entrance Unspecified = null;
        public static final Entrance UserInfoEcomFansClubWidget = null;
        public static final Entrance UserInfoFansClubWidget = null;
        public static final /* synthetic */ Entrance[] a = null;

        static {
            Entrance r1 = new Entrance("Unspecified", 0);
            Unspecified = r1;
            Entrance r2 = new Entrance("UserInfoFansClubWidget", 1);
            UserInfoFansClubWidget = r2;
            Entrance r3 = new Entrance("SubscribeEmojiPanel", 2);
            SubscribeEmojiPanel = r3;
            Entrance r4 = new Entrance("PersonalProfile", 3);
            PersonalProfile = r4;
            Entrance r5 = new Entrance("UserInfoEcomFansClubWidget", 4);
            UserInfoEcomFansClubWidget = r5;
            Entrance r6 = new Entrance("PkFullFeedView", 5);
            PkFullFeedView = r6;
            a = new Entrance[]{r1, r2, r3, r4, r5, r6};
        }

        public static Entrance valueOf(String r1) {
            return (Entrance) r27.a.a(Entrance.class, r1);
        }

        public static Entrance[] values() {
            return (Entrance[]) a.clone();
        }

        public Entrance(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/FansClubEntranceParams$Page;", "", "Default", "VIP", "FansClub", "FansGroup", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Page extends Enum<Page> {
        public static final Page Default = null;
        public static final Page FansClub = null;
        public static final Page FansGroup = null;
        public static final Page VIP = null;
        public static final /* synthetic */ Page[] a = null;

        static {
            Page r1 = new Page("Default", 0);
            Default = r1;
            Page r2 = new Page("VIP", 1);
            VIP = r2;
            Page r3 = new Page("FansClub", 2);
            FansClub = r3;
            Page r4 = new Page("FansGroup", 3);
            FansGroup = r4;
            a = new Page[]{r1, r2, r3, r4};
        }

        public static Page valueOf(String r1) {
            return (Page) r27.a.a(Page.class, r1);
        }

        public static Page[] values() {
            return (Page[]) a.clone();
        }

        public Page(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ FansClubEntranceParams(Page r14, boolean r15, String r16, String r17, Entrance r18, boolean r19, String r20, int r22) {
        if ((r22 & 2) == 0) goto L5;
        boolean r5 = false;
    L7:
        if ((r22 & 4) == 0) goto L9;
        String r6 = "";
    L11:
        if ((r22 & 8) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r22 & 16) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r22 & 32) == 0) goto L21;
        Entrance r9 = Entrance.Unspecified;
    L23:
        if ((r22 & 64) == 0) goto L25;
        boolean r10 = false;
    L27:
        if ((r22 & 128) == 0) goto L29;
        String r12 = "";
    L31:
        if ((r22 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L33;
        String r13 = null;
    L34:
        this(r14, r5, r6, r7, r8, r9, r10, r12, r13);
        return;
    L33:
        r13 = r20;
        goto L34
    L29:
        r12 = null;
        goto L31
    L25:
        r10 = r19;
        goto L27
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = r17;
        goto L15
    L9:
        r6 = r16;
        goto L11
    L5:
        r5 = r15;
        goto L7
    }

    public FansClubEntranceParams(Page r2, boolean r3, String r4, String r5, String r6, Entrance r7, boolean r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "page");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Intrinsics.checkNotNullParameter(r5, "eventModule");
        Intrinsics.checkNotNullParameter(r6, "actionType");
        Intrinsics.checkNotNullParameter(r7, "entrance");
        Intrinsics.checkNotNullParameter(r9, "joinActionFrom");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
