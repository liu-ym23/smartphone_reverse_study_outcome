package mb0;

import com.bytedance.android.live.ktv.common.util.MusicInfoError;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c {

    public static final class a {
        public static /* synthetic */ void c(c r1, String r2, long r3) {
            r1.i(r2, r3, MapsKt.emptyMap());
        }

        public static /* synthetic */ void a(c r6, LinkMonitorData r7, long r8, Throwable r11) {
            r6.a(r7, r8, r11, new JSONObject());
        }

        public static /* synthetic */ void b(c r6, LinkMonitorData r7, long r8, String r11) {
            r6.j(r7, r8, r11, new JSONObject());
        }
    }

    void a(LinkMonitorData r1, long r2, Throwable r4, JSONObject r5);

    void b(String r1, MusicPanel r2, HashMap<String, String> r3);

    void c(long r1, String r3, int r4, String r5);

    void d(MusicPanel r1, String r2, String r3, long r4);

    void e(MusicPanel r1);

    void f(MusicPanel r1, String r2, String r3, int r4, String r5);

    void g(long r1, String r3, long r4);

    void h(KtvMusic r1, MusicInfoError r2);

    void i(String r1, long r2, Map<String, String> r4);

    void j(LinkMonitorData r1, long r2, String r4, JSONObject r5);

    void k(String r1);
}
