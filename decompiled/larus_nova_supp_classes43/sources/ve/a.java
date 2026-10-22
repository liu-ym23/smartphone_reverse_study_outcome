package ve;

import com.bytedance.android.ec.adapter.api.message.model.TraceTimeMetric;
import com.bytedance.android.ec.adapter.api.message.model.UpdatedCartInfo;
import com.bytedance.android.livesdkapi.message.ExternalBaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageType;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@ProtoMessage("webcast.im.LiveShoppingMessage")
public class a extends ExternalBaseMessage implements ce.a {

    @SerializedName("commerce_authority_change_toast")
    public String commerceAuthorityChangeToast;

    @SerializedName("ecom_notice")
    public String ecomNotice;

    @SerializedName("msg_type")
    public int msgType;

    @SerializedName("target_open_id")
    public List<String> targetOpenIds;

    @SerializedName("trace_time_metric")
    public TraceTimeMetric traceTimeMetric;

    @SerializedName("update_type")
    public int updateType;

    @SerializedName("updated_cart_info")
    public UpdatedCartInfo updatedCartInfo;

    public final int getIntType() {
        return 1002;
    }

    @Override // ce.a
    public final List<String> getSecTargetUid() {
        return null;
    }

    public a() {
        this.msgType = 0;
    }

    @Override // ce.a
    public final long getMessageId2() {
        return getMessageId();
    }

    @Override // ce.a
    public final String A() {
        return this.commerceAuthorityChangeToast;
    }

    @Override // ce.a
    public final TraceTimeMetric d() {
        return this.traceTimeMetric;
    }

    @Override // ce.a
    public final String getEcomNotice() {
        return this.ecomNotice;
    }

    public final ExternalMessageType getExternalMessageType() {
        return ExternalMessageType.EXTERNAL_SHOPPING;
    }

    @Override // ce.a
    public final int getMsgType() {
        return this.msgType;
    }

    @Override // ce.a
    public final List<String> getTargetUid() {
        return this.targetOpenIds;
    }

    @Override // ce.a
    public final UpdatedCartInfo w() {
        return this.updatedCartInfo;
    }
}
