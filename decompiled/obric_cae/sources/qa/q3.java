package qa;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.loc.em;
import com.loc.es;
import com.obric.cae.location.database.StarCellDbManager;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class q3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f10952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AMapLocationClientOption f10953b;

    public q3() {
        this.f10952a = new StringBuilder();
        this.f10953b = new AMapLocationClientOption();
    }

    public static String d(String r8) {
        if ("[]".equals(r8) == false) goto L6;
        return "";
    L6:
        return r8;
    }

    public final es a(String r14) {
        es r10 = new es();     // Catch: Throwable -> L30
        JSONObject r15 = new JSONObject(r14).optJSONObject("regeocode");     // Catch: Throwable -> L30
        JSONObject r8 = r15.optJSONObject("addressComponent");     // Catch: Throwable -> L30
        r10.f3641r = d(r8.optString("country"));     // Catch: Throwable -> L30
        String r11 = d(r8.optString("province"));     // Catch: Throwable -> L30
        r10.f3634a = r11;     // Catch: Throwable -> L30
        String r12 = d(r8.optString("citycode"));     // Catch: Throwable -> L30
        r10.f3637n = r12;     // Catch: Throwable -> L30
        String r13 = r8.optString("city");     // Catch: Throwable -> L30
        if (r12.endsWith("010") == false) goto L6;
    L13:
        if (r11 != null) goto L15;
    L18:
        if (TextUtils.isEmpty(r13) == false) goto L20;
        r10.f3635b = r11;     // Catch: Throwable -> L30
        r13 = r11;
    L20:
        String r16 = d(r8.optString("district"));     // Catch: Throwable -> L30
        r10.f3636m = r16;     // Catch: Throwable -> L30
        String r17 = d(r8.optString("adcode"));     // Catch: Throwable -> L30
        r10.f3638o = r17;     // Catch: Throwable -> L30
        JSONObject r18 = r8.optJSONObject("streetNumber");     // Catch: Throwable -> L30
        String r19 = d(r18.optString("street"));     // Catch: Throwable -> L30
        r10.f3643t = r19;     // Catch: Throwable -> L30
        r10.f3642s = r19;     // Catch: Throwable -> L30
        String r20 = d(r18.optString("number"));     // Catch: Throwable -> L30
        r10.f3644u = r20;     // Catch: Throwable -> L30
        JSONArray r21 = r15.optJSONArray(StarCellDbManager.CellInfoEntry.POIS);     // Catch: Throwable -> L30
        if (r21.length() <= 0) goto L24;
        String r22 = d(r21.getJSONObject(0).optString(QesdkUtils.TAGS.JSON_TAG_NAME));     // Catch: Throwable -> L30
        r10.f3640q = r22;     // Catch: Throwable -> L30
        String r110 = r22;
    L25:
        JSONArray r111 = r15.optJSONArray(StarCellDbManager.CellInfoEntry.AOIS);     // Catch: Throwable -> L30
        if (r111.length() <= 0) goto L28;
        r10.I = d(r111.getJSONObject(0).optString(QesdkUtils.TAGS.JSON_TAG_NAME));     // Catch: Throwable -> L30
    L28:
        c(r10, r11, r13, r16, r19, r20, r110, r17);     // Catch: Throwable -> L30
        return r10;
    L24:
        r110 = null;
        goto L25
    L15:
        if (r11.length() <= 0) goto L18;
        r10.f3635b = r11;     // Catch: Throwable -> L30
        r13 = r11;
        goto L18
    L6:
        if (r12.endsWith("021") == true) goto L13;
        if (r12.endsWith("022") == true) goto L13;
        if (r12.endsWith("023") == true) goto L13;
        r13 = d(r13);     // Catch: Throwable -> L30
        r10.f3635b = r13;     // Catch: Throwable -> L30
    L30:
        return null;
    }

    public final es b(String r20, Context r21, n0 r22, em r23) {
        StringBuilder r8 = this.f10952a;
        es r10 = new es();
        r10.v(7);
        StringBuffer r11 = new StringBuffer();
        r11.append("#SHA1AndPackage#");     // Catch: Throwable -> L26
        r11.append(h4.f(r21));     // Catch: Throwable -> L26
        String r12 = r22.f10843b.get("gsid").get(0);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r12) == true) goto L6;
        r11.append("#gsid#");     // Catch: Throwable -> L26
        r11.append(r12);     // Catch: Throwable -> L26
    L6:
        String r13 = r22.f10844c;     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r13) == true) goto L30;
        r11.append("#csid#".concat(String.valueOf(r13)));     // Catch: Throwable -> L26
    L30:
        JSONObject r14 = new JSONObject(r20);     // Catch: Throwable -> L20
        if (r14.has("status") == true) goto L13;
    L14:
        r23.f5204r = "#0702";     // Catch: Throwable -> L20
        r8.append("json is error:");     // Catch: Throwable -> L20
        r8.append(r20);     // Catch: Throwable -> L20
        r8.append(r11);     // Catch: Throwable -> L20
        r8.append("#0702");     // Catch: Throwable -> L20
    L15:
        String r15 = r14.getString("status");     // Catch: Throwable -> L20
        String r16 = r14.getString(LocationMonitorConst.INFO);     // Catch: Throwable -> L20
        String r18 = r14.getString("infocode");     // Catch: Throwable -> L20
        if ("0".equals(r15) == false) goto L22;
        r23.f5204r = "#0701";     // Catch: Throwable -> L20
        r8.append("auth fail:");     // Catch: Throwable -> L20
        r8.append(r16);     // Catch: Throwable -> L20
        r8.append(r11);     // Catch: Throwable -> L20
        r8.append("#0701");     // Catch: Throwable -> L20
        String r17 = r22.f10845d;     // Catch: Throwable -> L20
        ArrayList r19 = w3.f11182g;     // Catch: Throwable -> L20
        q.d(t3.j(), "/mobile/binary", r16, r17, "", r18);     // Catch: Throwable -> L27
    L22:
        r10.f3648y = r8.toString();
        if (r8.length() <= 0) goto L25;
        r8.delete(0, r8.length());
    L25:
        return r10;
    L13:
        if (r14.has(LocationMonitorConst.INFO) == true) goto L15;
    L20:
        th = move-exception;
        r23.f5204r = "#0703";
        r8.append("json exception error:");
        r8.append(th.getMessage());
        r8.append(r11);
        r8.append("#0703");
        t3.g("parser", "paseAuthFailurJson", th);
        goto L22
    }

    public final void c(es r8, String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
        StringBuilder r17 = new StringBuilder();
        if (TextUtils.isEmpty(r10) == true) goto L6;
        r17.append(r10);
        r17.append(" ");
    L6:
        if (TextUtils.isEmpty(r11) == true) goto L18;
        if (this.f10953b.B != AMapLocationClientOption.e.f3675b) goto L13;
        if (r11.equals(r10) == true) goto L18;
    L16:
        r17.append(r11);
        r17.append(" ");
        goto L18
    L13:
        if (r10.contains("市") == false) goto L16;
        if (r10.equals(r11) == false) goto L16;
    L18:
        if (TextUtils.isEmpty(r12) == true) goto L21;
        r17.append(r12);
        r17.append(" ");
    L21:
        if (TextUtils.isEmpty(r13) == true) goto L24;
        r17.append(r13);
        r17.append(" ");
    L24:
        if (TextUtils.isEmpty(r14) == true) goto L27;
        r17.append(r14);
        r17.append(" ");
    L27:
        if (TextUtils.isEmpty(r15) == false) goto L29;
    L35:
        Bundle r18 = new Bundle();
        r18.putString("citycode", r8.f3637n);
        r18.putString("desc", r17.toString());
        r18.putString("adcode", r8.f3638o);
        r8.setExtras(r18);
        r8.T = r17.toString();
        String r19 = r8.f3638o;
        if (r19 != null) goto L38;
    L42:
        String r20 = r17.toString();
    L43:
        r8.f3639p = r20;
        return;
    L38:
        if (r19.trim().length() <= 0) goto L42;
        if (this.f10953b.B == AMapLocationClientOption.e.f3675b) goto L42;
        r20 = r17.toString().replace(" ", "");
        goto L43
    L29:
        if (TextUtils.isEmpty(r16) == false) goto L31;
    L33:
        r17.append("Near ".concat(String.valueOf(r15)));
        String r21 = "Near ".concat(String.valueOf(r15));
    L34:
        r8.L = r21;
        goto L35
    L31:
        if (this.f10953b.B == AMapLocationClientOption.e.f3675b) goto L33;
        r17.append("靠近");
        r17.append(r15);
        r17.append(" ");
        r21 = android.aimedia.a.i(new StringBuilder("在"), r15, "附近");
        goto L34
    }
}
