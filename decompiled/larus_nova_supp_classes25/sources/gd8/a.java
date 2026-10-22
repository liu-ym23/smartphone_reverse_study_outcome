package gd8;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.nita.api.NitaSchdulerType;
import com.larus.bmhome.utils.c;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a extends com.bytedance.nita.api.a {

    /* JADX INFO: renamed from: gd8.a$a, reason: collision with other inner class name */
    public static final class C0077a {
    }

    public static final class b implements com.bytedance.nita.view.b {
        public b() {
        }

        public final View c(Context r3, ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "parent");
            v19.f.a(r3.getTheme());
            View r6 = LayoutInflater.from(r3).inflate(r5, r4, false);     // Catch: Throwable -> L5
            Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L5
            return r6;
        L5:
            th = move-exception;
            FLogger.a.e("ActionBarNormalHolderNitaView", "msg=" + th.getMessage());
            JSONObject r7 = new JSONObject();
            r7.put("tag", "action_bar_normal_holder_nita");
            r7.put("err_msg", String.valueOf(th.getMessage()));
            o.a.reportEvent("nita_preload_monitor", r7);
            c.a("nita_preload_monitor", r7, true);
            return new View(r3);
        }
    }

    static {
    }

    public final int[] b() {
        return new int[]{2131561884};
    }

    public final void e(View r2, Activity r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "activity");
    }

    public final String h() {
        return "action_bar_normal_holder_nita";
    }

    public final int theme() {
        return 2131953682;
    }

    public final com.bytedance.nita.view.b c() {
        return new b();
    }

    public a() {
    }

    public final NitaSchdulerType a() {
        return NitaSchdulerType.AT_ONCE;
    }
}
