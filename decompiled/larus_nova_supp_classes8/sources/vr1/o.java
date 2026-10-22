package vr1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSLinkedRoomNode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface o {
    String a(Object r1, String r2);

    void c(DataCenter r1);

    void d(Class<?> r1, Map<String, String> r2);

    Map<String, String> f(VSLinkedRoomNode r1);

    Map<String, String> g(DataCenter r1);

    JSONObject getPlayerStatsLog();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> h(DataCenter r1);

    boolean i(Object r1);

    com.bytedance.android.livesdk.log.filter.o j(Class r1);

    Map<String, String> k(IRoom r1);

    void n(DataCenter r1, String r2, Map<String, String> r3);

    boolean o(Object r1, String r2);

    void q(DataCenter r1, String r2, Map<String, String> r3);

    void s(String r1, Map<String, String> r2, String r3, String r4, String r5);

    void sendLog(String r1, Map<String, String> r2, Object... r3);

    void w(DataCenter r1, int r2, long r3);
}
