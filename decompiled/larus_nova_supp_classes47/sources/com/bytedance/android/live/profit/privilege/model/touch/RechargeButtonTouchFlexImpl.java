package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.privilege.RechargeButtonTouch")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/RechargeButtonTouchFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/l;", "Lcom/bytedance/android/live/base/model/message/a5;", "buttonText", "Lcom/bytedance/android/live/base/model/message/a5;", "getButtonText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setButtonText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "", "schema$delegate", "Ljava/lang/Object;", "getSchema", "()Ljava/lang/String;", "schema", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeButtonTouchFlexImpl extends FlexModelBase<l> implements l, vh7.h {

    @SerializedName("schema")
    protected String _$$schema;

    @SerializedName("button_text")
    protected a5 buttonText;

    public RechargeButtonTouchFlexImpl() {
        super(l.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    public RechargeButtonTouchFlexImpl(am3.g r6) {
        super(l.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this.buttonText = vh7.f.a(r6, a5.class);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$schema = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.l
    public a5 getButtonText() {
        return this.buttonText;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.l
    public final String getSchema() {
        return this._$$schema;
    }

    public void setButtonText(a5 r1) {
        this.buttonText = r1;
    }
}
