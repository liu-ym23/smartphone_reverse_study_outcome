package com.ss.android.lark.feed.export.feedcard.action;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionEvent;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "LONG_CLICK", "LEFT_SWIPE", "RIGHT_SWIPE_SHORT", "RIGHT_SWIPE_LONG", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedActionEvent extends Enum<FeedActionEvent> {
    public static final FeedActionEvent LEFT_SWIPE = null;
    public static final FeedActionEvent LONG_CLICK = null;
    public static final FeedActionEvent RIGHT_SWIPE_LONG = null;
    public static final FeedActionEvent RIGHT_SWIPE_SHORT = null;
    public static final /* synthetic */ FeedActionEvent[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedActionEvent> getEntries() {
        return b;
    }

    static {
        FeedActionEvent r0 = new FeedActionEvent("LONG_CLICK", 0);
        LONG_CLICK = r0;
        FeedActionEvent r1 = new FeedActionEvent("LEFT_SWIPE", 1);
        LEFT_SWIPE = r1;
        FeedActionEvent r3 = new FeedActionEvent("RIGHT_SWIPE_SHORT", 2);
        RIGHT_SWIPE_SHORT = r3;
        FeedActionEvent r5 = new FeedActionEvent("RIGHT_SWIPE_LONG", 3);
        RIGHT_SWIPE_LONG = r5;
        FeedActionEvent[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static FeedActionEvent[] values() {
        return (FeedActionEvent[]) a.clone();
    }

    public static FeedActionEvent valueOf(String r1) {
        return (FeedActionEvent) a.a(FeedActionEvent.class, r1);
    }

    public FeedActionEvent(String r1, int r2) {
        super(r1, r2);
    }
}
