package d11;

import com.bytedance.android.live.revenuelink.connect.params.ServerCancelParamsSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(ServerCancelParamsSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Ld11/i;", "Lvh7/j;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.api.linkmic.CancelParams")
public interface i extends vh7.j<i> {

    @JsonAdapter(ServerCancelParamsSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "request_source#setter")
    void J2(String r1);

    @FieldName(name = "to_room_id#setter")
    void f(long r1);

    @FieldName(name = "sec_to_user_id#setter")
    void g(String r1);

    @FieldName(name = "cancel_type")
    int getCancelType();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "request_source")
    String getRequestSource();

    @FieldName(name = "scene")
    long getScene();

    @FieldName(name = "to_open_id")
    String getToOpenId();

    @FieldName(name = "to_room_id")
    long getToRoomId();

    @FieldName(name = "sec_to_user_id")
    String l();

    @FieldName(name = "cancel_type#setter")
    void n0(int r1);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r1);

    @FieldName(name = "scene#setter")
    void setScene(long r1);

    @FieldName(name = "to_open_id#setter")
    void setToOpenId(String r1);
}
