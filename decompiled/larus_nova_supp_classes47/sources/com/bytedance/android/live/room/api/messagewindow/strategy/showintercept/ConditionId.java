package com.bytedance.android.live.room.api.messagewindow.strategy.showintercept;

import com.bytedance.android.live.schema.api.WebcastRedirectException;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/strategy/showintercept/ConditionId;", "", "", "value", "I", "getValue", "()I", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "CARD_SHOW_INTERVAL_TIME_LIMIT", "EXIT_CARD_TIMES_LIMIT", "ALREADY_FOLLOWED_NOT_DISPLAY", "SAME_ANCHOR_NOT_DISPLAY", "ANCHOR_EXIT_MIC_NOT_DISPLAY", "PRELOADING_RESULT_LIMIT", "SCREEN_ORIENTATION_LIMIT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ConditionId extends Enum<ConditionId> {
    public static final ConditionId ALREADY_FOLLOWED_NOT_DISPLAY = null;
    public static final ConditionId ANCHOR_EXIT_MIC_NOT_DISPLAY = null;
    public static final ConditionId CARD_SHOW_INTERVAL_TIME_LIMIT = null;
    public static final ConditionId EXIT_CARD_TIMES_LIMIT = null;
    public static final ConditionId PRELOADING_RESULT_LIMIT = null;
    public static final ConditionId SAME_ANCHOR_NOT_DISPLAY = null;
    public static final ConditionId SCREEN_ORIENTATION_LIMIT = null;
    public static final /* synthetic */ ConditionId[] a = null;
    private final String desc;
    private final int value;

    static {
        ConditionId r1 = new ConditionId("CARD_SHOW_INTERVAL_TIME_LIMIT", 0, 1, "相同类型卡片展示间隔Ns");
        CARD_SHOW_INTERVAL_TIME_LIMIT = r1;
        ConditionId r2 = new ConditionId("EXIT_CARD_TIMES_LIMIT", 1, 2, "卡片被关闭N次后不再触发展示");
        EXIT_CARD_TIMES_LIMIT = r2;
        ConditionId r3 = new ConditionId("ALREADY_FOLLOWED_NOT_DISPLAY", 2, WebcastRedirectException.MISS_REDIRECT_RULE, "观众已关注的主播不展示");
        ALREADY_FOLLOWED_NOT_DISPLAY = r3;
        ConditionId r4 = new ConditionId("SAME_ANCHOR_NOT_DISPLAY", 3, WebcastRedirectException.WRONG_SHORT_SCHEMA, "同一个主播直播间（上麦期间）仅展示一次卡片");
        SAME_ANCHOR_NOT_DISPLAY = r4;
        ConditionId r5 = new ConditionId("ANCHOR_EXIT_MIC_NOT_DISPLAY", 4, WebcastRedirectException.ERROR_CONFIG_SOURCE, "主播关注卡片仅出在主播自己直播间内：下麦后不再触发");
        ANCHOR_EXIT_MIC_NOT_DISPLAY = r5;
        ConditionId r6 = new ConditionId("PRELOADING_RESULT_LIMIT", 5, 9998, "预加载状态限制，需等待预加载状态完成才能展示");
        PRELOADING_RESULT_LIMIT = r6;
        ConditionId r7 = new ConditionId("SCREEN_ORIENTATION_LIMIT", 6, 9999, "屏幕状态限制");
        SCREEN_ORIENTATION_LIMIT = r7;
        a = new ConditionId[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static ConditionId valueOf(String r1) {
        return (ConditionId) a.a(ConditionId.class, r1);
    }

    public static ConditionId[] values() {
        return (ConditionId[]) a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public ConditionId(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.desc = r4;
    }
}
