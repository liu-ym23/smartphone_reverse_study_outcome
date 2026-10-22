package d00;

import android.os.Handler;
import com.bytedance.android.live.broadcast.api.monitor.game.GameLiveModule;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.config.ay;
import com.bytedance.android.livesdk.config.hi1;
import com.bytedance.android.livesdk.config.n6;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public static final n6 a = null;
    public static final String b = null;
    public static final String c = null;
    public static final d d = null;
    public static final HashMap<String, hi1> e = null;
    public static PthreadHandlerThreadV2 f;
    public static Handler g;
    public static final C0222a h = null;

    /* JADX INFO: renamed from: d00.a$a, reason: collision with other inner class name */
    public static final class C0222a {
        public C0222a() {
        }
    }

    public a() {
    }

    @GameLiveModule
    public abstract String c();

    static {
        h = new C0222a();
        n6 r0 = (n6) ay.a.getValue();
        a = r0;
        b = "webcast_client_game_live";
        c = "anchor_screen_shot";
        d = new d(0);
        e = new HashMap();
        List r1 = r0.b();
        if (r1 == null) goto L10;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        hi1 r3 = (hi1) r2.next();
        HashMap<String, hi1> r4 = e;
        if (r4 == null) goto L6;
        hi1 r5 = r4.put(r3.b(), r3);
        goto L6
    L16:
        return;
    }

    public static c b() {
        d r0 = d;
        r0.getClass();
        JSONObject r1 = new JSONObject();
        BaseMonitor.add(r1, "live_source", r0.c);
        BaseMonitor.add(r1, "retry_state", r0.d);
        BaseMonitor.add(r1, "reconnect_state", r0.e);
        BaseMonitor.add(r1, "push_duration", d.a(r0.f));
        BaseMonitor.add(r1, "webcast_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        BaseMonitor.add(r1, "saved_state_from_fragment", r0.h);
        BaseMonitor.add(r1, "saved_state_from_activity", r0.i);
        JSONObject r2 = new JSONObject();
        BaseMonitor.add(r2, "enter_fragment_duration", d.a(r0.g));
        return new c(r1, r2, 2);
    }

    public final hi1 a() {
        boolean r0 = a.a();
        HashMap<String, hi1> r1 = e;
        if (r1 == null) goto L5;
        hi1 r2 = r1.get(c());
    L6:
        if (r2 == null) goto L10;
        boolean r4 = true;
        if (r2.a() != true) goto L10;
    L11:
        if (r0 == false) goto L15;
        if (r4 == false) goto L15;
        return r2;
    L15:
        return null;
    L10:
        r4 = false;
        goto L11
    L5:
        r2 = null;
        goto L6
    }
}
