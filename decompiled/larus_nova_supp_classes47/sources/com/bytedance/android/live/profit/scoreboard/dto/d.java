package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\b8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u000bR\u001e\u0010#\u001a\u00060\u0002j\u0002` 8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/d;", "Lvh7/c;", "", "getCounterId", "()J", "getCounterId$annotations", "()V", "counterId", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/e;", "getPlayers", "()Ljava/util/List;", "getPlayers$annotations", "players", "getStartTime", "getStartTime$annotations", "startTime", "getExpectFinishTime", "getExpectFinishTime$annotations", "expectFinishTime", "getActualFinishTime", "getActualFinishTime$annotations", "actualFinishTime", "Lcom/bytedance/android/live/profit/scoreboard/dto/f;", "getRule", "()Lcom/bytedance/android/live/profit/scoreboard/dto/f;", "getRule$annotations", "rule", "Lcom/bytedance/android/live/profit/scoreboard/dto/b;", "getTopContributors", "getTopContributors$annotations", "topContributors", "Lcom/bytedance/android/livesdk/utils/TimestampSec;", "getUpdateTime", "getUpdateTime$annotations", "updateTime", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "actual_finish_time")
    long getActualFinishTime();

    @FieldName(name = "counter_id")
    long getCounterId();

    @FieldName(name = "expect_finish_time")
    long getExpectFinishTime();

    @FieldName(name = "players")
    List<e> getPlayers();

    @FieldName(name = "rule")
    f getRule();

    @FieldName(name = "start_time")
    long getStartTime();

    @FieldName(name = "top_contributors")
    List<b> getTopContributors();

    @FieldName(name = "update_time")
    long getUpdateTime();
}
