package i8;

import com.bytedance.common.wschannel.model.SocketState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void a();

    void b();

    void b(String r5, JSONObject r10);

    void c(WsChannelMsg r5, boolean r10);

    void d(SocketState r5);

    void e(b r5, int r10, JSONObject r11);

    void f(int r5, byte[] r10);
}
