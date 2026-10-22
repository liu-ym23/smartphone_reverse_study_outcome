package com.ss.android.lark.feed.export.feedcard.action;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "START", "SUCCESS", "ERROR", "END", "feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedActionStatus extends Enum<FeedActionStatus> {
    public static final FeedActionStatus END = null;
    public static final FeedActionStatus ERROR = null;
    public static final FeedActionStatus START = null;
    public static final FeedActionStatus SUCCESS = null;
    public static final /* synthetic */ FeedActionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<FeedActionStatus> getEntries() {
        return b;
    }

    static {
        FeedActionStatus r0 = new FeedActionStatus("START", 0);
        START = r0;
        FeedActionStatus r1 = new FeedActionStatus("SUCCESS", 1);
        SUCCESS = r1;
        FeedActionStatus r3 = new FeedActionStatus("ERROR", 2);
        ERROR = r3;
        FeedActionStatus r5 = new FeedActionStatus("END", 3);
        END = r5;
        FeedActionStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static FeedActionStatus[] values() {
        return (FeedActionStatus[]) a.clone();
    }

    public static FeedActionStatus valueOf(String r1) {
        return (FeedActionStatus) a.a(FeedActionStatus.class, r1);
    }

    public FeedActionStatus(String r1, int r2) {
        super(r1, r2);
    }
}
