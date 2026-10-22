package vw0;

import com.bytedance.android.live.recharge.panel.aio.RechargeCommonParamsSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(RechargeCommonParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lvw0/g;", "Lvh7/j;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.recharge.panel.RechargeCommonParams")
public interface g extends j<g> {

    @JsonAdapter(RechargeCommonParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "cj_sdk_version#setter")
    void F6(String r1);

    @FieldName(name = "room_type#setter")
    void N4(String r1);

    @FieldName(name = "pay_scene#setter")
    void T6(String r1);

    @FieldName(name = "charge_reason#setter")
    void U6(String r1);

    @FieldName(name = "bio_type#setter")
    void Z7(String r1);

    @FieldName(name = "charge_scene#setter")
    void n8(String r1);

    @FieldName(name = "live_type#setter")
    void setLiveType(String r1);
}
