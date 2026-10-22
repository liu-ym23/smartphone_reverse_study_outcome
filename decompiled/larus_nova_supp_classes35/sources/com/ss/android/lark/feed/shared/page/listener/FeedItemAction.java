package com.ss.android.lark.feed.shared.page.listener;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/listener/FeedItemAction;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "ADD_TO_TAG", "REMOVE_FROM_TAG", "CLEAR_UNREAD", "MARK_UNREAD", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedItemAction extends Enum<FeedItemAction> {
    public static final FeedItemAction ADD_TO_TAG = null;
    public static final FeedItemAction CLEAR_UNREAD = null;
    public static final FeedItemAction MARK_UNREAD = null;
    public static final FeedItemAction REMOVE_FROM_TAG = null;
    public static final FeedItemAction UNKNOWN = null;
    public static final /* synthetic */ FeedItemAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedItemAction> getEntries() {
        return b;
    }

    static {
        FeedItemAction r0 = new FeedItemAction("UNKNOWN", 0);
        UNKNOWN = r0;
        FeedItemAction r1 = new FeedItemAction("ADD_TO_TAG", 1);
        ADD_TO_TAG = r1;
        FeedItemAction r3 = new FeedItemAction("REMOVE_FROM_TAG", 2);
        REMOVE_FROM_TAG = r3;
        FeedItemAction r5 = new FeedItemAction("CLEAR_UNREAD", 3);
        CLEAR_UNREAD = r5;
        FeedItemAction r7 = new FeedItemAction("MARK_UNREAD", 4);
        MARK_UNREAD = r7;
        FeedItemAction[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static FeedItemAction[] values() {
        return (FeedItemAction[]) a.clone();
    }

    public static FeedItemAction valueOf(String r1) {
        return (FeedItemAction) a.a(FeedItemAction.class, r1);
    }

    public FeedItemAction(String r1, int r2) {
        super(r1, r2);
    }
}
