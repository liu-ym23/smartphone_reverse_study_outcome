package ku0;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.ILiveWrappedRtcService;
import java.util.ArrayList;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import nu0.l;
import org.json.JSONObject;
import zf2.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public boolean a;
    public final b b;
    public final Context c;
    public final ku0.a d;
    public final ku0.b e;

    public static final class a {
    }

    public static final class b extends ag2.a {
        public b() {
        }
    }

    /* JADX INFO: renamed from: ku0.c$c, reason: collision with other inner class name */
    public static final class C0262c extends ag2.c {
        public C0262c() {
        }
    }

    static {
    }

    public final void b() {
        ALogger.i("ProfitRTCEngine", "rtc leaveRoom");
        ILiveWrappedRtcService.Companion.getClass();
        ILiveWrappedRtcService.a.a().destroyRTCEngine();
    }

    public final boolean a(lu0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L6
        d60.b.a(r5, "rtc.device_id", k.n(IMiddleWareHostContext.class).getServerDeviceId());     // Catch: Exception -> L6
        d60.b.a(r5, "rtc.audio_mode_strategy", new JSONObject("{\"Default\":1,\"ChatRoom\":1,\"GameStreaming\":1,\"Chorus\":1}"));     // Catch: Exception -> L6
        ALogger.i("ProfitRTCEngine", "createRTCVideo");     // Catch: Exception -> L6
        q r6 = new q();     // Catch: Exception -> L6
        r6.a = this.c;     // Catch: Exception -> L6
        ILiveWrappedRtcService.Companion.getClass();     // Catch: Exception -> L6
        ILiveWrappedRtcService.a.a().createRTCEngine(r6, this.b);     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        ALogger.i("ProfitRTCEngine", e.getMessage());
        return false;
    }

    public c(Context r2, ku0.a r3, ku0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        new ArrayList();
        new ArrayList();
        iu0.a r5 = (iu0.a) l.c.getValue(null, l.a[1]);
        this.b = new b();
        new C0262c();
    }
}
