package com.bytedance.android.live.base.model.message;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.data.InteractionPluginGamePlusContainerData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/base/model/message/IInteractionPluginContainerDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/l1;", "", "<set-?>", "miniAppId$delegate", "Ljava/lang/Object;", "getMiniAppId", "()Ljava/lang/String;", "setMiniAppId", "(Ljava/lang/String;)V", "miniAppId", "payload$delegate", "getPayload", "setPayload", "payload", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IInteractionPluginContainerDataFlexImpl extends FlexModelBase<l1> implements l1, vh7.h {

    @SerializedName("mini_app_id")
    protected String _$$miniAppId;

    @SerializedName("task_data")
    protected String _$$payload;

    public IInteractionPluginContainerDataFlexImpl() {
        super(l1.class);
    }

    public IInteractionPluginContainerDataFlexImpl(am3.g r6) {
        super(l1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$miniAppId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this._$$payload = am3.h.c(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.base.model.message.l1
    public final String getMiniAppId() {
        return this._$$miniAppId;
    }

    @Override // com.bytedance.android.live.base.model.message.l1
    public final String getPayload() {
        return this._$$payload;
    }

    @Override // com.bytedance.android.live.base.model.message.l1
    public final void setMiniAppId(String r1) {
        this._$$miniAppId = r1;
    }

    @Override // com.bytedance.android.live.base.model.message.l1
    public final void setPayload(String r1) {
        this._$$payload = r1;
    }
}
