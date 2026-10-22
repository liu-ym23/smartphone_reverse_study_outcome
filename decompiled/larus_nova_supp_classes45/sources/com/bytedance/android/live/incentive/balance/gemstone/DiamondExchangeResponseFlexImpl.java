package com.bytedance.android.live.incentive.balance.gemstone;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.wallet.DiamondExchangeResult.DiamondExchangeData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/gemstone/DiamondExchangeResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/incentive/balance/gemstone/a;", "", "orderId$delegate", "Ljava/lang/Object;", "getOrderId", "()Ljava/lang/String;", "orderId", "", "userType$delegate", "getUserType", "()I", "userType", "prompt$delegate", "getPrompt", "prompt", "promptBody$delegate", "getPromptBody", "promptBody", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DiamondExchangeResponseFlexImpl extends FlexModelBase<a> implements a, h {

    @SerializedName("order_id")
    protected String _$$orderId;

    @SerializedName("prompt")
    protected String _$$prompt;

    @SerializedName("prompt_body")
    protected String _$$promptBody;

    @SerializedName("user_type")
    protected int _$$userType;

    public DiamondExchangeResponseFlexImpl() {
        super(a.class);
        this._$$orderId = "";
        this._$$prompt = "";
        this._$$promptBody = "";
    }

    @Override // com.bytedance.android.live.incentive.balance.gemstone.a
    public final String getOrderId() {
        return this._$$orderId;
    }

    @Override // com.bytedance.android.live.incentive.balance.gemstone.a
    public final String getPrompt() {
        return this._$$prompt;
    }

    @Override // com.bytedance.android.live.incentive.balance.gemstone.a
    public final String getPromptBody() {
        return this._$$promptBody;
    }

    @Override // com.bytedance.android.live.incentive.balance.gemstone.a
    public final int getUserType() {
        return this._$$userType;
    }

    public DiamondExchangeResponseFlexImpl(g r6) {
        super(a.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$orderId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$userType = r6.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$prompt = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$promptBody = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$orderId != null) goto L22;
        this._$$orderId = "";
    L22:
        if (this._$$prompt != null) goto L25;
        this._$$prompt = "";
    L25:
        if (this._$$promptBody != null) goto L43;
        this._$$promptBody = "";
        return;
    }
}
