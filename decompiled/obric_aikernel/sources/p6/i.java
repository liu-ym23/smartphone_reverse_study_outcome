package p6;

import com.bytedance.apm.util.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i extends o6.a implements v6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f12345b;

    public i() {
        this.f12345b = null;
    }

    @Override // v6.a
    public List<String> a() {
        ArrayList r10 = new ArrayList();
        File r11 = this.f12345b;
        if (r11 == null) goto L5;
        r10.add(r11.getAbsolutePath());
    L5:
        return r10;
    }

    @Override // o6.a
    public String f() {
        return "net_flow";
    }

    @Override // o6.a
    public boolean g(n6.a r20) {
        JSONObject r10 = new JSONObject(r20.c());
        if (e(r10, r20) == false) goto L5;
        return true;
    L5:
        long r11 = r10.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000);
        long r12 = r10.optLong("fetch_end_time", System.currentTimeMillis() / 1000);
        long r13 = r11 * 1000;
        long r14 = 1000 * r12;
        long r15 = z.c(k6.a.k().i(), r13, r14, 1);
        long r16 = z.c(k6.a.k().i(), r13, r14, 0);
        JSONObject r17 = new JSONObject();
        r17.put("netStatsWifi", r15);     // Catch: JSONException -> L8
        r17.put("netStatsMobile", r16);     // Catch: JSONException -> L8
        r17.put("netStatsTotal", r16 + r15);     // Catch: JSONException -> L8
    L10:
        File r18 = r6.d.a(k6.a.k().i(), r17);
        if (r18 != null) goto L14;
        k("网络流量信息文件生成失败", r20);
        return true;
    L14:
        this.f12345b = r18;
        u6.a.c(new w6.a("json", 0, false, r20.b(), this, null));
        return true;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
