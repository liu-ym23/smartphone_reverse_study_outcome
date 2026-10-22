package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.FansclubParticipateIncentive")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/transfer/IParticipateIncentiveFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/fansclub/transfer/o;", "", "goldCoinsCount$delegate", "Ljava/lang/Object;", "getGoldCoinsCount", "()J", "goldCoinsCount", "", "awardUnit$delegate", "getAwardUnit", "()Ljava/lang/String;", "awardUnit", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IParticipateIncentiveFlexImpl extends FlexModelBase<o> implements o, vh7.h {

    @SerializedName("award_unit")
    protected String _$$awardUnit;

    @SerializedName("gold_coins_count")
    protected long _$$goldCoinsCount;

    public IParticipateIncentiveFlexImpl() {
        super(o.class);
        this._$$goldCoinsCount = $defaultValue_goldCoinsCount$();
    }

    public final long $defaultValue_goldCoinsCount$() {
        return 0;
    }

    @Override // com.bytedance.android.live.profit.fansclub.transfer.o
    public final String getAwardUnit() {
        return this._$$awardUnit;
    }

    @Override // com.bytedance.android.live.profit.fansclub.transfer.o
    public final long getGoldCoinsCount() {
        return this._$$goldCoinsCount;
    }

    public IParticipateIncentiveFlexImpl(am3.g r7) {
        super(o.class);
        boolean r0 = false;
        setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L12;
        am3.g.a r4 = decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L8;
        this._$$goldCoinsCount = r7.j();
        r0 = r0 | true;
        goto L3
    L8:
        if (r3 != 2) goto L9;
        this._$$awardUnit = am3.h.c(r7);
        goto L3
    L9:
        am3.h.d(r4, r7);
        goto L3
    L12:
        r7.d(r1);
        setThreadSafe(true);
        if ((r0 & true) == true) goto L25;
        this._$$goldCoinsCount = $defaultValue_goldCoinsCount$();
        return;
    }
}
