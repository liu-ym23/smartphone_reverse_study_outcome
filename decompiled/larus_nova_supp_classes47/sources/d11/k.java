package d11;

import com.bytedance.android.live.revenuelink.connect.params.ServerPermitParamsSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(ServerPermitParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Ld11/k;", "Lvh7/j;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.api.linkmic.PermitParams")
public interface k extends vh7.j<k> {

    @JsonAdapter(ServerPermitParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "sec_apply_user_id#setter")
    void D6(String r1);

    @FieldName(name = "apply_open_id")
    String Z0();

    @FieldName(name = "permit_status")
    long Z3();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "scene")
    long getScene();

    @FieldName(name = "sec_apply_user_id")
    String j7();

    @FieldName(name = "apply_open_id#setter")
    void k4(String r1);

    @FieldName(name = "permit_status#setter")
    void l7(long r1);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r1);

    @FieldName(name = "room_id#setter")
    void setRoomId(long r1);

    @FieldName(name = "scene#setter")
    void setScene(long r1);
}
