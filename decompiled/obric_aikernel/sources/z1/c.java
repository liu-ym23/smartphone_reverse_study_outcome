package z1;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, d> f13753b;

    public interface a {
        void a(WsChannelMsg r10, boolean r11);

        void b(com.bytedance.common.wschannel.event.a r10, JSONObject r11);

        void c(WsChannelMsg r10);

        void d(ServiceConnectEvent r10);

        void e(int r10, ConnectionState r11, boolean r12);

        void f(String r10, boolean r11);
    }

    public c(@NonNull a r10) {
        super(r10);
        HashMap r11 = new HashMap();
        r11.put(WsConstants.RECEIVE_CONNECTION_ACTION, new e(r10));
        r11.put(WsConstants.SYNC_CONNECT_STATE, new j(r10));
        r11.put(WsConstants.RECEIVE_PROGRESS_ACTION, new g(r10));
        r11.put(WsConstants.RECEIVE_PAYLOAD_ACTION, new f(r10));
        r11.put(WsConstants.SEND_PAYLOAD_ACTION, new i(r10));
        r11.put(WsConstants.RECEIVE_SERVICE_ACTION, new h(r10));
        this.f13753b = Collections.unmodifiableMap(r11);
    }

    @Override // z1.d
    public void a(Intent r10, com.bytedance.common.wschannel.model.a r11) {
        d r12 = this.f13753b.get(r10.getAction());     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        r12.a(r10, r11);     // Catch: Throwable -> L8
    L14:
    L11:
        if (Logger.debug() == false) goto L17;
        Logger.d("AbsWsClientService", "count = " + r10.getIntExtra(WsConstants.MSG_COUNT, -1));
        return;
    L17:
        return;
    L6:
        Logger.e("error action!");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Logger.e("AbsWsClientService", th.toString());
        goto L11
    }
}
