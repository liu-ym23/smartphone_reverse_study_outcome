package u1b;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonReport;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.di.d;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.q;
import com.ss.android.lark.officesdk.utils.net.NetworkType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import ntb.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final boolean a = false;

    static {
        int r0 = d.a;
        if ((d.a.a().getApplicationInfo().flags & 2) == 0) goto L7;
        boolean r1 = true;
    L8:
        a = r1;
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static void b(String r2, JSONObject r3) {
        if (a == false) goto L5;
        j.a(ChameleonReport.TAG, "trackEventExt, eventName = " + r2 + " param is " + r3);
    L5:
        if (r3 == null) goto L10;
        int r0 = q.a;
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        DependencyContainer r1 = DependencyContainer.a;
        u r4 = DependencyContainer.a(u.class, null);
        if (r4 == null) goto L11;
        r4.sendEvent(r2, r3);
        return;
    L11:
        return;
    }

    public static void a(String r5, String r6, long r7, boolean r9, String r10) {
        JSONObject r2 = new JSONObject();
        int r3 = d.a;
        NetworkType r4 = twb.a.a(d.a.a());
        r2.put("duration_ms", r7);     // Catch: JSONException -> L15
        if (r5 != null) goto L7;
        r5 = BuildConfig.FLAVOR;
    L7:
        r2.put(ChameleonOpenTracker.ParamKey.APP_NAME, r5);     // Catch: JSONException -> L15
        r2.put("is_success", r9);     // Catch: JSONException -> L15
        if (r10 != null) goto L10;
        r10 = BuildConfig.FLAVOR;
    L10:
        r2.put(ChameleonOpenTracker.ParamKey.ERRORMSG, r10);     // Catch: JSONException -> L15
        if (r6 != null) goto L13;
        r6 = BuildConfig.FLAVOR;
    L13:
        r2.put("channel", r6);     // Catch: JSONException -> L15
        r2.put("downloader", "gecko");     // Catch: JSONException -> L15
        r2.put("network_status", r4);     // Catch: JSONException -> L15
        j.a(ChameleonReport.TAG, "reportChameleonDownload, params = " + r2);     // Catch: JSONException -> L15
    L17:
        b("Chameleon_gecko_download_duration_dev", r2);
        return;
    L15:
        e = move-exception;
        j.c(ChameleonReport.TAG, "reportChameleonDownload failed", e);
        goto L17
    }
}
