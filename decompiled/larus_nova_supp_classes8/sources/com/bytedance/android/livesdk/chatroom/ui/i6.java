package com.bytedance.android.livesdk.chatroom.ui;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/i6;", "", "", "countDown", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "setCountDown", "(Ljava/lang/Long;)V", "", "score", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setScore", "(Ljava/lang/String;)V", "totalRewardContent", "c", "setTotalRewardContent", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i6 {

    @SerializedName("count_down")
    private Long countDown;

    @SerializedName("score")
    private String score;

    @SerializedName("total_reward_content")
    private String totalRewardContent;

    public i6() {
        this.countDown = 18000L;
        this.score = "500金币";
        this.totalRewardContent = "";
    }

    public final Long a() {
        return this.countDown;
    }

    public final String b() {
        return this.score;
    }

    public final String c() {
        return this.totalRewardContent;
    }
}
