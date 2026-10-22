package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/SendGiftSourceValue;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "FastGift", "GiftDialog", "Guide", "JsbPage", "RedPacketGiftGuide", "Schema", "Comment", "MessageBoard", "UnKnow", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SendGiftSourceValue extends Enum<SendGiftSourceValue> {
    public static final SendGiftSourceValue Comment = null;
    public static final SendGiftSourceValue FastGift = null;
    public static final SendGiftSourceValue GiftDialog = null;
    public static final SendGiftSourceValue Guide = null;
    public static final SendGiftSourceValue JsbPage = null;
    public static final SendGiftSourceValue MessageBoard = null;
    public static final SendGiftSourceValue RedPacketGiftGuide = null;
    public static final SendGiftSourceValue Schema = null;
    public static final SendGiftSourceValue UnKnow = null;
    public static final /* synthetic */ SendGiftSourceValue[] a = null;
    private final int value;

    public static SendGiftSourceValue valueOf(String r1) {
        return (SendGiftSourceValue) r27.a.a(SendGiftSourceValue.class, r1);
    }

    public static SendGiftSourceValue[] values() {
        return (SendGiftSourceValue[]) a.clone();
    }

    static {
        SendGiftSourceValue r1 = new SendGiftSourceValue("FastGift", 0, 1);
        FastGift = r1;
        SendGiftSourceValue r2 = new SendGiftSourceValue("GiftDialog", 1, 2);
        GiftDialog = r2;
        SendGiftSourceValue r3 = new SendGiftSourceValue("Guide", 2, 3);
        Guide = r3;
        SendGiftSourceValue r4 = new SendGiftSourceValue("JsbPage", 3, 4);
        JsbPage = r4;
        SendGiftSourceValue r5 = new SendGiftSourceValue("RedPacketGiftGuide", 4, 5);
        RedPacketGiftGuide = r5;
        SendGiftSourceValue r6 = new SendGiftSourceValue("Schema", 5, 6);
        Schema = r6;
        SendGiftSourceValue r7 = new SendGiftSourceValue("Comment", 6, 7);
        Comment = r7;
        SendGiftSourceValue r8 = new SendGiftSourceValue("MessageBoard", 7, 8);
        MessageBoard = r8;
        SendGiftSourceValue r9 = new SendGiftSourceValue("UnKnow", 8, 0);
        UnKnow = r9;
        a = new SendGiftSourceValue[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public final int getValue() {
        return this.value;
    }

    public SendGiftSourceValue(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
