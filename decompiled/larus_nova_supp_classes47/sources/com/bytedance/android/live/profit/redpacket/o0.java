package com.bytedance.android.live.profit.redpacket;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001e\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010'\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001a\u0010)\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001a\u0010+\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006R\u001a\u0010-\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006R\u001a\u0010/\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R\u001c\u00102\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001a\u00107\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0004\u001a\u0004\b7\u0010\u0006R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006¨\u0006<"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/o0;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "boxStatus", "I", "getBoxStatus", "()I", "type", "getType", "coinCount", "getCoinCount", "Lcom/bytedance/android/live/profit/redpacket/j1;", "sender", "Lcom/bytedance/android/live/profit/redpacket/j1;", "getSender", "()Lcom/bytedance/android/live/profit/redpacket/j1;", "", "Lcom/bytedance/android/live/profit/redpacket/a;", "descriptionList", "Ljava/util/List;", "getDescriptionList", "()Ljava/util/List;", "activityId", "getActivityId", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "businessType", "J", "getBusinessType", "()J", "countDown", "getCountDown", "waitDuration", "getWaitDuration", "sendTime", "getSendTime", "displayDuration", "getDisplayDuration", "availableTime", "getAvailableTime", "expireTime", "getExpireTime", "joinFrozenDuration", "getJoinFrozenDuration", "Lcom/bytedance/android/livesdk/chatroom/model/n1$e;", "receiveResult", "Lcom/bytedance/android/livesdk/chatroom/model/n1$e;", "getReceiveResult", "()Lcom/bytedance/android/livesdk/chatroom/model/n1$e;", "isShowResult", "isShowSurpriseResult", "detail", "getDetail", "bizExtra", "getBizExtra", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o0 {

    @SerializedName("activity_id")
    private final String activityId;

    @SerializedName("available_time")
    private final String availableTime;

    @SerializedName("biz_extra")
    private final String bizExtra;

    @SerializedName("box_status")
    private final int boxStatus;

    @SerializedName("business_type")
    private final long businessType;

    @SerializedName("coin_count")
    private final int coinCount;

    @SerializedName("count_down")
    private final String countDown;

    @SerializedName("description_list")
    private final List<a> descriptionList;

    @SerializedName("detail")
    private final String detail;

    @SerializedName("display_duration")
    private final String displayDuration;

    @SerializedName("expire_time")
    private final String expireTime;

    @SerializedName("box_id")
    private final String id;

    @SerializedName("is_show_result")
    private final String isShowResult;

    @SerializedName("is_show_surprise_result")
    private final String isShowSurpriseResult;

    @SerializedName("join_frozen_duration")
    private final String joinFrozenDuration;

    @SerializedName("receive_result")
    private final com.bytedance.android.livesdk.chatroom.model.n1.e receiveResult;

    @SerializedName("send_time")
    private final String sendTime;

    @SerializedName("sender")
    private final j1 sender;

    @SerializedName("box_type")
    private final int type;

    @SerializedName("delay_time")
    private final String waitDuration;

    public final int getType() {
        return this.type;
    }

    public o0(String r16, int r17, int r18, int r19, j1 r20, List<a> r22, String r23, long r24, String r25, String r26, String r27, String r28, String r29, String r30, String r32, com.bytedance.android.livesdk.chatroom.model.n1.e r33, String r34, String r35, String r36, String r37) {
        Intrinsics.checkNotNullParameter(r16, "id");
        Intrinsics.checkNotNullParameter(r20, "sender");
        Intrinsics.checkNotNullParameter(r22, "descriptionList");
        Intrinsics.checkNotNullParameter(r23, "activityId");
        Intrinsics.checkNotNullParameter(r25, "countDown");
        Intrinsics.checkNotNullParameter(r26, "waitDuration");
        Intrinsics.checkNotNullParameter(r27, "sendTime");
        Intrinsics.checkNotNullParameter(r28, "displayDuration");
        Intrinsics.checkNotNullParameter(r29, "availableTime");
        Intrinsics.checkNotNullParameter(r30, "expireTime");
        Intrinsics.checkNotNullParameter(r32, "joinFrozenDuration");
        Intrinsics.checkNotNullParameter(r34, "isShowResult");
        Intrinsics.checkNotNullParameter(r35, "isShowSurpriseResult");
        this.id = r16;
        this.boxStatus = r17;
        this.type = r18;
        this.coinCount = r19;
        this.sender = r20;
        this.descriptionList = r22;
        this.activityId = r23;
        this.businessType = r24;
        this.countDown = r25;
        this.waitDuration = r26;
        this.sendTime = r27;
        this.displayDuration = r28;
        this.availableTime = r29;
        this.expireTime = r30;
        this.joinFrozenDuration = r32;
        this.receiveResult = r33;
        this.isShowResult = r34;
        this.isShowSurpriseResult = r35;
        this.detail = r36;
        this.bizExtra = r37;
    }
}
