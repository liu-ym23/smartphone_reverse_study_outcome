package com.ss.android.lark.feed.export.feedviewcontainer;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/export/feedviewcontainer/FeedViewType$HeaderView;", "Lcom/ss/android/lark/feed/export/feedviewcontainer/FeedViewType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "EVENT", "NETWORK_NOTICE", "APP_CHECK", "PUSH_NOTICE", "UG_TOP_BANNER", "RETURN_TO_LAST_TENANT", "SHORTCUT", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedViewType$HeaderView extends Enum<FeedViewType$HeaderView> {
    public static final FeedViewType$HeaderView APP_CHECK = null;
    public static final FeedViewType$HeaderView EVENT = null;
    public static final FeedViewType$HeaderView NETWORK_NOTICE = null;
    public static final FeedViewType$HeaderView PUSH_NOTICE = null;
    public static final FeedViewType$HeaderView RETURN_TO_LAST_TENANT = null;
    public static final FeedViewType$HeaderView SHORTCUT = null;
    public static final FeedViewType$HeaderView UG_TOP_BANNER = null;
    public static final /* synthetic */ FeedViewType$HeaderView[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedViewType$HeaderView> getEntries() {
        return b;
    }

    static {
        FeedViewType$HeaderView r0 = new FeedViewType$HeaderView("EVENT", 0);
        EVENT = r0;
        FeedViewType$HeaderView r1 = new FeedViewType$HeaderView("NETWORK_NOTICE", 1);
        NETWORK_NOTICE = r1;
        FeedViewType$HeaderView r3 = new FeedViewType$HeaderView("APP_CHECK", 2);
        APP_CHECK = r3;
        FeedViewType$HeaderView r5 = new FeedViewType$HeaderView("PUSH_NOTICE", 3);
        PUSH_NOTICE = r5;
        FeedViewType$HeaderView r7 = new FeedViewType$HeaderView("UG_TOP_BANNER", 4);
        UG_TOP_BANNER = r7;
        FeedViewType$HeaderView r9 = new FeedViewType$HeaderView("RETURN_TO_LAST_TENANT", 5);
        RETURN_TO_LAST_TENANT = r9;
        FeedViewType$HeaderView r11 = new FeedViewType$HeaderView("SHORTCUT", 6);
        SHORTCUT = r11;
        FeedViewType$HeaderView[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static FeedViewType$HeaderView[] values() {
        return (FeedViewType$HeaderView[]) a.clone();
    }

    public static FeedViewType$HeaderView valueOf(String r1) {
        return (FeedViewType$HeaderView) a.a(FeedViewType$HeaderView.class, r1);
    }

    public FeedViewType$HeaderView(String r1, int r2) {
        super(r1, r2);
    }
}
