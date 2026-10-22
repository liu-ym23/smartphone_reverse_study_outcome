package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/SendGiftSource;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "sourceName", "Ljava/lang/String;", "getSourceName", "()Ljava/lang/String;", "FastGift", "GiftDialog", "Guide", "JsbPage", "RedPacketGiftGuide", "Schema", "Comment", "MessageBoard", "Format", "UnKnow", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SendGiftSource extends Enum<SendGiftSource> {
    public static final SendGiftSource Comment = null;
    public static final SendGiftSource FastGift = null;
    public static final SendGiftSource Format = null;
    public static final SendGiftSource GiftDialog = null;
    public static final SendGiftSource Guide = null;
    public static final SendGiftSource JsbPage = null;
    public static final SendGiftSource MessageBoard = null;
    public static final SendGiftSource RedPacketGiftGuide = null;
    public static final SendGiftSource Schema = null;
    public static final SendGiftSource UnKnow = null;
    public static final /* synthetic */ SendGiftSource[] a = null;
    private final String sourceName;

    public static SendGiftSource valueOf(String r1) {
        return (SendGiftSource) r27.a.a(SendGiftSource.class, r1);
    }

    public static SendGiftSource[] values() {
        return (SendGiftSource[]) a.clone();
    }

    static {
        SendGiftSource r1 = new SendGiftSource("FastGift", 0, "convenient");
        FastGift = r1;
        SendGiftSource r2 = new SendGiftSource("GiftDialog", 1, "giftDialog");
        GiftDialog = r2;
        SendGiftSource r3 = new SendGiftSource("Guide", 2, "guide");
        Guide = r3;
        SendGiftSource r4 = new SendGiftSource("JsbPage", 3, "jsbPage");
        JsbPage = r4;
        SendGiftSource r5 = new SendGiftSource("RedPacketGiftGuide", 4, "redPacketGiftGuide");
        RedPacketGiftGuide = r5;
        SendGiftSource r6 = new SendGiftSource("Schema", 5, "schema");
        Schema = r6;
        SendGiftSource r7 = new SendGiftSource("Comment", 6, "comment");
        Comment = r7;
        SendGiftSource r8 = new SendGiftSource("MessageBoard", 7, "messageBoard");
        MessageBoard = r8;
        SendGiftSource r9 = new SendGiftSource("Format", 8, "format");
        Format = r9;
        SendGiftSource r10 = new SendGiftSource("UnKnow", 9, "unKnow");
        UnKnow = r10;
        a = new SendGiftSource[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final String getSourceName() {
        return this.sourceName;
    }

    public SendGiftSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.sourceName = r3;
    }
}
