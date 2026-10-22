package com.ss.android.lark.feed.shared.page.constant;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/constant/FeedConstants$FeedErrorCode;", BuildConfig.FLAVOR, "errorCode", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getErrorCode", "()I", "ERROR_OPERATION_TO_PENDING_DELETE_FEED", "ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedConstants$FeedErrorCode extends Enum<FeedConstants$FeedErrorCode> {
    public static final FeedConstants$FeedErrorCode ERROR_OPERATION_TO_PENDING_DELETE_FEED = null;
    public static final FeedConstants$FeedErrorCode ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE = null;
    public static final /* synthetic */ FeedConstants$FeedErrorCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int errorCode;

    public static EnumEntries<FeedConstants$FeedErrorCode> getEntries() {
        return b;
    }

    static {
        FeedConstants$FeedErrorCode r0 = new FeedConstants$FeedErrorCode("ERROR_OPERATION_TO_PENDING_DELETE_FEED", 0, 111001);
        ERROR_OPERATION_TO_PENDING_DELETE_FEED = r0;
        FeedConstants$FeedErrorCode r1 = new FeedConstants$FeedErrorCode("ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE", 1, 5067);
        ERROR_OPERATION_TO_PENDING_DELETE_FEED_SERVER_CODE = r1;
        FeedConstants$FeedErrorCode[] r2 = {r0, r1};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static FeedConstants$FeedErrorCode[] values() {
        return (FeedConstants$FeedErrorCode[]) a.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public static FeedConstants$FeedErrorCode valueOf(String r1) {
        return (FeedConstants$FeedErrorCode) a.a(FeedConstants$FeedErrorCode.class, r1);
    }

    public FeedConstants$FeedErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.errorCode = r3;
    }
}
