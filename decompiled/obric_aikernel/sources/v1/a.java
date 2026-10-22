package v1;

import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    void a(WsChannelMsg r10, boolean r11);

    void b(ServiceConnectEvent r10);

    void c();

    void d(IWsChannelClient r10, int r11, JSONObject r12);

    void e();

    void f(int r10, byte[] r11);

    void g(int r10, WsChannelMsg r11);

    void h(IWsChannelClient r10, SocketState r11);
}
