package gd8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.nita.view.b;
import com.larus.bmhome.utils.c;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l$b implements b {
    public String a;

    public l$b() {
        this.a = "";
    }

    public final View c(Context r3, ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "parent");
        v19.f.a(r3.getTheme());
        if (r5 != (-1)) goto L10;
        this.a = "MAIN_TAB_VIEW";     // Catch: Throwable -> L12
        Function1 r6 = l.d;     // Catch: Throwable -> L12
        if (r6 == null) goto L9;
        View r7 = (View) r6.invoke(r3);     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        return r7;
    L9:
        return new View(r3);
    L10:
        this.a = "else";     // Catch: Throwable -> L12
        return LayoutInflater.from(r3).inflate(r5, r4, false);
    L12:
        th = move-exception;
        FLogger.a.e("MainPageTabNitaView", " msg=" + th.getMessage());
        JSONObject r8 = new JSONObject();
        r8.put("tag", "main_page_tab_view");
        r8.put("err_msg", String.valueOf(th.getMessage()));
        r8.put("err_view", this.a);
        o.a.reportEvent("nita_preload_monitor", r8);
        c.a("nita_preload_monitor", r8, true);
        return new View(r3);
    }
}
