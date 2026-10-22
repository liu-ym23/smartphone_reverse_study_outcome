package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/message/w1;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/h;", "getAdventurePlayModeInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/h;", "adventurePlayModeInfo", "", "getDuration", "()J", "duration", "getPairCount", "pairCount", "getAudienceJoinCount", "audienceJoinCount", "getOperatorId", "operatorId", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w1 extends vh7.c<w1> {
    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "play_mode_info")
    com.bytedance.android.livesdk.chatroom.model.interact.h getAdventurePlayModeInfo();

    @FieldName(name = "audience_join")
    long getAudienceJoinCount();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "operator_id")
    long getOperatorId();

    @FieldName(name = "pair_count")
    long getPairCount();
}
