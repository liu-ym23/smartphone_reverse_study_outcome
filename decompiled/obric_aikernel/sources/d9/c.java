package d9;

import android.content.Context;
import android.util.Log;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.g;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f8518c;

    public static final class a implements SDKMonitor.o {
        a() {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.o
        public Map<String, String> getCommonParams() {
            if (c.b(c.f8516a) == false) goto L5;
            String r10 = NetConst.ENCRYPT_VERISON_CODE;
        L6:
            Pair[] r11 = new Pair[2];
            z8.a r12 = z8.c.f13804a.d();
            if (r12 == null) goto L10;
            String r13 = r12.a();
            if (r13 == null) goto L10;
        L11:
            r11[0] = TuplesKt.to("host_aid", r13);
            r11[1] = TuplesKt.to("oversea", r10);
            return MapsKt.mutableMapOf(r11);
        L10:
            r13 = "";
            goto L11
        L5:
            r10 = NetConst.NOT_ENCRYPT_VERISON_CODE;
            goto L6
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.o
        public String getSessionId() {
            return null;
        }
    }

    static {
        f8516a = new c();
        f8518c = "ones_sdk";
    }

    private c() {
    }

    public static /* synthetic */ void a() {
        l();
    }

    public static final /* synthetic */ boolean b(c r10) {
        return r10.j();
    }

    private final String c() {
        return "release";
    }

    private final String d() {
        if (j() == false) goto L5;
        return "https://mon.isnssdk.com/monitor/appmonitor/v2/settings";
    L5:
        return "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    }

    private final String e() {
        if (j() == false) goto L5;
        return "https://mon.isnssdk.com/monitor/collect/";
    L5:
        return "https://mon.snssdk.com/monitor/collect/";
    }

    private final String f() {
        j();
        return "568500";
    }

    private final int g() {
        return 1062945;
    }

    private final String h() {
        return "1.6.29-alpha.25";
    }

    private final boolean j() {
        z8.a r10 = z8.c.f13804a.d();
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.e();
    }

    private static final void l() {
        Thread.sleep(1000);
        f8516a.n("matrix_sdk_init_success", new JSONObject(), new JSONObject(), new JSONObject());
    }

    public final void i(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        g.d(f(), CollectionsKt.listOf(d()));
        g.e(f(), CollectionsKt.listOf(e()));
        String r11 = null;
        e9.b.b("SdkMonitorManager", "sdk aid " + f() + " , config url " + d() + " \n , reporturl " + e(), null, 4, null);
        JSONObject r12 = new JSONObject();
        z8.c r13 = z8.c.f13804a;
        z8.a r14 = r13.d();
        if (r14 == null) goto L5;
        String r15 = r14.f();
    L6:
        e9.b.b("SdkMonitorManager", "device_id = " + r15, null, 4, null);
        if (r15 != null) goto L9;
    L12:
        boolean r16 = true;
    L13:
        if (r16 == false) goto L16;
        f8517b = false;
        return;
    L16:
        r12.put("device_id", r15);
        r12.put("sdk_version", h());
        e9.b.b("SdkMonitorManager", "sdk version = " + h(), null, 4, null);
        z8.a r17 = r13.d();
        if (r17 == null) goto L19;
        String r18 = r17.a();
    L20:
        r12.put("host_aid", r18);
        z8.a r19 = r13.d();
        if (r19 == null) goto L23;
        r11 = r19.b();
    L23:
        r12.put("app_version", r11);
        r12.put("channel", c());
        g.c(r10, f(), r12, new a());
        f8517b = true;
        return;
    L19:
        r18 = null;
        goto L20
    L9:
        if (r15.length() == 0) goto L12;
        r16 = false;
        goto L13
    L5:
        r15 = null;
        goto L6
    }

    public final void k() {
        new Thread(b.f8515c).start();     // Catch: Exception -> L4
        return;
    }

    public final void m(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_CATEGORY);
        n(r10, r11, new JSONObject(), new JSONObject());
    }

    public final void n(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r12, EventBody.KEY_METRIC);
        Intrinsics.checkNotNullParameter(r13, "logExtr");
    L24:
        e = move-exception;
        e9.b.b("SdkMonitorManager", "event report exception " + Log.getStackTraceString(e), null, 4, null);
        return;
    L4:
        if (f8517b == true) goto L22;
        z8.c r14 = z8.c.f13804a;     // Catch: Exception -> L24
        z8.a r15 = r14.d();     // Catch: Exception -> L24
        if (r15 == null) goto L8;
        String r16 = r15.f();     // Catch: Exception -> L24
    L9:
        e9.b.b("SdkMonitorManager", "on event device_id = " + r16, null, 4, null);     // Catch: Exception -> L24
        if (r16 != null) goto L12;
    L15:
        boolean r17 = true;
    L16:
        if (r17 == false) goto L19;
        f8517b = false;     // Catch: Exception -> L24
        return;
    L19:
        Context r18 = r14.e();     // Catch: Exception -> L24
        if (r18 == null) goto L22;
        f8516a.i(r18);     // Catch: Exception -> L24
        goto L22
    L12:
        if (r16.length() == 0) goto L15;
        r17 = false;
        goto L16
    L8:
        r16 = null;
    L22:
        r11.put(Api.KEY_SDK_VERSION_CODE, g());     // Catch: Exception -> L24
        r11.put("sdk_name", f8518c);     // Catch: Exception -> L24
        e9.b.b("SdkMonitorManager", "event " + r10 + ", category: " + r11 + ", metric " + r12 + ", logExtr " + r13, null, 4, null);     // Catch: Exception -> L24
        g.b(f()).monitorEvent(r10, r11, r12, r13);     // Catch: Exception -> L24
    }
}
