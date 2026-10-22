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
@ProtoMessage("webcast.open.api.CounterConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/CounterConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/scoreboard/dto/a;", "", "", "durationChoices$delegate", "Ljava/lang/Object;", "getDurationChoices", "()Ljava/util/List;", "durationChoices", "Lcom/bytedance/android/live/profit/scoreboard/dto/CounterRuleFlexImpl;", "rules$delegate", "getRules", "rules", "Lcom/bytedance/android/live/profit/scoreboard/dto/LinkmicInfoFlexImpl;", "linkmicInfo$delegate", "getLinkmicInfo", "()Lcom/bytedance/android/live/profit/scoreboard/dto/LinkmicInfoFlexImpl;", "linkmicInfo", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CounterConfigFlexImpl extends FlexModelBase<a> implements a, vh7.h {

    @SerializedName("duration_choices")
    protected List<Long> _$$durationChoices;

    @SerializedName("linkmic_info")
    protected LinkmicInfoFlexImpl _$$linkmicInfo;

    @SerializedName("rules")
    protected List<CounterRuleFlexImpl> _$$rules;

    public CounterConfigFlexImpl() {
        super(a.class);
        this._$$durationChoices = $defaultValue_durationChoices$();
        this._$$rules = $defaultValue_rules$();
    }

    public final List<Long> $defaultValue_durationChoices$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<CounterRuleFlexImpl> $defaultValue_rules$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.a
    public /* bridge */ /* synthetic */ p getLinkmicInfo() {
        return getLinkmicInfo();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.a
    public final List<Long> getDurationChoices() {
        return this._$$durationChoices;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.a
    public final List<CounterRuleFlexImpl> getRules() {
        return this._$$rules;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.a
    public final LinkmicInfoFlexImpl getLinkmicInfo() {
        return this._$$linkmicInfo;
    }

    public CounterConfigFlexImpl(am3.g r6) {
        super(a.class);
        this._$$durationChoices = new ArrayList();
        this._$$rules = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L16;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L10;
        List r4 = this._$$rules;
        Object r5 = new CounterRuleFlexImpl(r6);
    L15:
        r4.add(r5);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$linkmicInfo = new LinkmicInfoFlexImpl(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L14:
        r4 = this._$$durationChoices;
        r5 = Long.valueOf(r6.j());
        goto L15
    L16:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$durationChoices.isEmpty() == false) goto L20;
        this._$$durationChoices = $defaultValue_durationChoices$();
    L20:
        if (this._$$rules.isEmpty() == false) goto L33;
        this._$$rules = $defaultValue_rules$();
        return;
    }
}
