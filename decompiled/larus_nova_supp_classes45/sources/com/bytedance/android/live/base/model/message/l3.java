package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000e\u001a\u00020\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001a\u0010\u0011\u001a\u00020\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\bR\u001a\u0010\u0017\u001a\u00020\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0015\u0010\bR\u001a\u0010\u001a\u001a\u00020\u00068&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0018\u0010\bR\u001a\u0010\u001f\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010 8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\n\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/base/model/message/l3;", "Lvh7/c;", "", "getUserIdString", "()Ljava/lang/String;", "userIdString", "", "getSilverMicrophoneNum", "()I", "getSilverMicrophoneNum$annotations", "()V", "silverMicrophoneNum", "getGoldenMicrophoneNum", "getGoldenMicrophoneNum$annotations", "goldenMicrophoneNum", "getCurrentTaskMicrophoneType", "getCurrentTaskMicrophoneType$annotations", "currentTaskMicrophoneType", "getCurrentScore", "getCurrentScore$annotations", "currentScore", "getNeedScoreToNext", "getNeedScoreToNext$annotations", "needScoreToNext", "getOrderSingStage", "getOrderSingStage$annotations", "orderSingStage", "", "getCurrentRoundMicCount", "()J", "getCurrentRoundMicCount$annotations", "currentRoundMicCount", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getTitleSponsor", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setTitleSponsor", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getTitleSponsor$annotations", "titleSponsor", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface l3 extends vh7.c<l3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "current_round_mic_count")
    long getCurrentRoundMicCount();

    @FieldName(name = "current_score")
    int getCurrentScore();

    @FieldName(name = "current_task_microphone_type")
    int getCurrentTaskMicrophoneType();

    @FieldName(name = "golden_microphone_num")
    int getGoldenMicrophoneNum();

    @FieldName(name = "need_score_to_next")
    int getNeedScoreToNext();

    @FieldName(name = "order_sing_stage")
    int getOrderSingStage();

    @FieldName(name = "silver_microphone_num")
    int getSilverMicrophoneNum();

    @FieldName(name = "title_sponsor")
    IBaseUser getTitleSponsor();

    String getUserIdString();

    @FieldName(name = "title_sponsor#setter")
    void setTitleSponsor(IBaseUser r1);
}
