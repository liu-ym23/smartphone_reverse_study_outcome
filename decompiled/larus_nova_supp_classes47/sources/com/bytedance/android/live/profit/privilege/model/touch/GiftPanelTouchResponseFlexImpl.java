package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.privilege.GiftPanelTouchResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R)\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelTouchResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/g;", "Lcom/bytedance/android/live/profit/privilege/model/touch/RechargeButtonTouchFlexImpl;", "rechargeButtonTouch$delegate", "Ljava/lang/Object;", "getRechargeButtonTouch", "()Lcom/bytedance/android/live/profit/privilege/model/touch/RechargeButtonTouchFlexImpl;", "rechargeButtonTouch", "", "", "extra$delegate", "getExtra", "()Ljava/util/Map;", "extra", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftPanelTouchResponseFlexImpl extends FlexModelBase<g> implements g, vh7.h {

    @SerializedName("extra")
    protected Map<String, String> _$$extra;

    @SerializedName("recharge_button_touch")
    protected RechargeButtonTouchFlexImpl _$$rechargeButtonTouch;

    public GiftPanelTouchResponseFlexImpl() {
        super(g.class);
    }

    public GiftPanelTouchResponseFlexImpl(am3.g r12) {
        super(g.class);
        this._$$extra = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L28;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        this._$$rechargeButtonTouch = new RechargeButtonTouchFlexImpl(r12);
        goto L3
    L8:
        if (r2 != 250) goto L9;
        long r6 = r12.c();
        String r3 = null;
        String r7 = null;
    L11:
        int r8 = r12.f();
        if (r8 == (-1)) goto L19;
        if (r8 != 1) goto L15;
        r3 = am3.h.c(r12);
        goto L11
    L15:
        if (r8 != 2) goto L16;
        r7 = am3.h.c(r12);
        goto L11
    L16:
        am3.h.e(r12);
        goto L11
    L19:
        r12.d(r6);
        Map<String, String> r4 = this._$$extra;
        if (r3 == null) goto L26;
        if (r7 == null) goto L24;
        r4.put(r3, r7);
        goto L3
    L24:
        throw new IllegalStateException("Value must not be null");
    L26:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r5, r12);
        goto L3
    L28:
        r12.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.g
    public /* bridge */ /* synthetic */ l getRechargeButtonTouch() {
        return getRechargeButtonTouch();
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.g
    public final Map<String, String> getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.g
    public final RechargeButtonTouchFlexImpl getRechargeButtonTouch() {
        return this._$$rechargeButtonTouch;
    }
}
