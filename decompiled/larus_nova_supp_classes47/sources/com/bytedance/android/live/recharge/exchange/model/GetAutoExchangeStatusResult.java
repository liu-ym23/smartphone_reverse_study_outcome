package com.bytedance.android.live.recharge.exchange.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/model/GetAutoExchangeStatusResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/exchange/model/f;", "", "switchStatus", "I", "getSwitchStatus", "()I", "setSwitchStatus", "(I)V", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetAutoExchangeStatusResult extends FlexModelBase<f> implements f, vh7.h {

    @SerializedName("status")
    protected int switchStatus;

    public GetAutoExchangeStatusResult() {
        super(f.class);
        this.switchStatus = AutoExchangeStatus.UnSync.getValue();
    }

    @Override // com.bytedance.android.live.recharge.exchange.model.f
    public int getSwitchStatus() {
        return this.switchStatus;
    }

    public GetAutoExchangeStatusResult(am3.g r7) {
        super(f.class);
        boolean r0 = false;
        setThreadSafe(false);
        long r1 = r7.c();
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L9;
        am3.g.a r4 = decodeExtensionFields(r3, r7);
        if (r3 != 1) goto L7;
        this.switchStatus = r7.i();
        r0 = r0 | true;
        goto L3
    L7:
        am3.h.d(r4, r7);
        goto L3
    L9:
        r7.d(r1);
        setThreadSafe(true);
        if ((r0 & true) == true) goto L19;
        this.switchStatus = AutoExchangeStatus.UnSync.getValue();
        return;
    }

    public void setSwitchStatus(int r1) {
        this.switchStatus = r1;
    }
}
