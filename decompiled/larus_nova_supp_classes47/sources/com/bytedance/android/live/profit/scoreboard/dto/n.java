package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0014\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\fR\u001a\u0010\u0017\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0015\u0010\fR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/n;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "", "getMiniAppId", "()Ljava/lang/String;", "getMiniAppId$annotations", "()V", "miniAppId", "", "getRoundId", "()J", "getRoundId$annotations", "roundId", "getUpdateTime", "getUpdateTime$annotations", "updateTime", "getStartTime", "getStartTime$annotations", "startTime", "getExpectFinishTime", "getExpectFinishTime$annotations", "expectFinishTime", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/i;", "getPlayers", "()Ljava/util/List;", "getPlayers$annotations", "players", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n extends vh7.c<n>, yh6.c {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    /* synthetic */ m0 getCommonData();

    @FieldName(name = "expect_finish_time")
    long getExpectFinishTime();

    @FieldName(name = "mini_app_id")
    String getMiniAppId();

    @FieldName(name = "players")
    List<i> getPlayers();

    @FieldName(name = "round_id")
    long getRoundId();

    @FieldName(name = "start_time")
    long getStartTime();

    @FieldName(name = "update_time")
    long getUpdateTime();

    /* synthetic */ void setCommonData(m0 r1);
}
