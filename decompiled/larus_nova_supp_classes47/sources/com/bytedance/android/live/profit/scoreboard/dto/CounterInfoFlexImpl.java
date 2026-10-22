package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.open.api.CounterInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b$\u0010%R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0014\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001b\u0010\u0017\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u001bR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\rR\u001b\u0010#\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/CounterInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/scoreboard/dto/d;", "", "counterId$delegate", "Ljava/lang/Object;", "getCounterId", "()J", "counterId", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/CounterPlayerFlexImpl;", "players$delegate", "getPlayers", "()Ljava/util/List;", "players", "startTime$delegate", "getStartTime", "startTime", "expectFinishTime$delegate", "getExpectFinishTime", "expectFinishTime", "actualFinishTime$delegate", "getActualFinishTime", "actualFinishTime", "Lcom/bytedance/android/live/profit/scoreboard/dto/CounterRuleFlexImpl;", "rule$delegate", "getRule", "()Lcom/bytedance/android/live/profit/scoreboard/dto/CounterRuleFlexImpl;", "rule", "Lcom/bytedance/android/live/profit/scoreboard/dto/CounterContributorFlexImpl;", "topContributors$delegate", "getTopContributors", "topContributors", "updateTime$delegate", "getUpdateTime", "updateTime", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CounterInfoFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("actual_finish_time")
    protected long _$$actualFinishTime;

    @SerializedName("counter_id")
    protected long _$$counterId;

    @SerializedName("expect_finish_time")
    protected long _$$expectFinishTime;

    @SerializedName("players")
    protected List<CounterPlayerFlexImpl> _$$players;

    @SerializedName("rule")
    protected CounterRuleFlexImpl _$$rule;

    @SerializedName("start_time")
    protected long _$$startTime;

    @SerializedName("top_contributors")
    protected List<CounterContributorFlexImpl> _$$topContributors;

    @SerializedName("update_time")
    protected long _$$updateTime;

    public CounterInfoFlexImpl() {
        super(d.class);
        this._$$players = $defaultValue_players$();
        this._$$topContributors = $defaultValue_topContributors$();
    }

    public final List<CounterPlayerFlexImpl> $defaultValue_players$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<CounterContributorFlexImpl> $defaultValue_topContributors$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public /* bridge */ /* synthetic */ f getRule() {
        return getRule();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public final long getActualFinishTime() {
        return this._$$actualFinishTime;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public final long getCounterId() {
        return this._$$counterId;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public final long getExpectFinishTime() {
        return this._$$expectFinishTime;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public final List<CounterPlayerFlexImpl> getPlayers() {
        return this._$$players;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public final long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public final List<CounterContributorFlexImpl> getTopContributors() {
        return this._$$topContributors;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public final long getUpdateTime() {
        return this._$$updateTime;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.d
    public final CounterRuleFlexImpl getRule() {
        return this._$$rule;
    }

    public CounterInfoFlexImpl(am3.g r5) {
        super(d.class);
        this._$$players = new ArrayList();
        this._$$topContributors = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L17;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$updateTime = r5.j();
        goto L3
    L9:
        List r4 = this._$$topContributors;
        vh7.h r6 = new CounterContributorFlexImpl(r5);
    L15:
        r4.add(r6);
        goto L3
    L10:
        this._$$rule = new CounterRuleFlexImpl(r5);
        goto L3
    L11:
        this._$$actualFinishTime = r5.j();
        goto L3
    L12:
        this._$$expectFinishTime = r5.j();
        goto L3
    L13:
        this._$$startTime = r5.j();
        goto L3
    L14:
        r4 = this._$$players;
        r6 = new CounterPlayerFlexImpl(r5);
        goto L15
    L16:
        this._$$counterId = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L17:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$players.isEmpty() == false) goto L21;
        this._$$players = $defaultValue_players$();
    L21:
        if (this._$$topContributors.isEmpty() == false) goto L43;
        this._$$topContributors = $defaultValue_topContributors$();
        return;
    }
}
