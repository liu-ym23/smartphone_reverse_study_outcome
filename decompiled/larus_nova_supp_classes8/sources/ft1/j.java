package ft1;

import android.app.Activity;
import com.bytedance.android.livesdk.config.mm;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.keva.Keva;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    public static final String f = null;
    public static final String g = null;
    public static final long h = 0;
    public final Keva a;
    public String b;
    public long c;
    public final Activity d;
    public final RoomBaseSession e;

    public static final class a {
    }

    static {
        int r0 = b.a;
        f = "LiveCrashTagRecorder";
        g = "fastboot";
        h = mm.a.getValue().a();
    }

    public final Activity getContext() {
        return this.d;
    }

    public static void a(int r4) {
        j0 r0 = j0.l();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("reason", String.valueOf(r4));
        Unit r5 = Unit.INSTANCE;
        r0.sendLog("livesdk_recover_cancel_when_crash", r1, new Object[]{Room.class});
    }

    public j(Activity r2, RoomBaseSession r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "roomSession");
        this.d = r2;
        this.e = r3;
        this.a = Keva.getRepo(g, 1);
        this.b = "";
        this.c = System.currentTimeMillis();
    }
}
