package n4a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.em;
import com.loc.es;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z3 {
    public final StringBuilder a;
    public AMapLocationClientOption b;

    public z3() {
        this.a = new StringBuilder();
        this.b = new AMapLocationClientOption();
    }

    public static String d(String r1) {
        if ("[]".equals(r1) == false) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r1;
    }

    public final es a(String r14) {
        es r10 = new es();     // Catch: Throwable -> L30
        JSONObject r15 = new JSONObject(r14).optJSONObject("regeocode");     // Catch: Throwable -> L30
        JSONObject r1 = r15.optJSONObject("addressComponent");     // Catch: Throwable -> L30
        r10.setCountry(d(r1.optString("country")));     // Catch: Throwable -> L30
        String r3 = d(r1.optString("province"));     // Catch: Throwable -> L30
        r10.setProvince(r3);     // Catch: Throwable -> L30
        String r2 = d(r1.optString("citycode"));     // Catch: Throwable -> L30
        r10.setCityCode(r2);     // Catch: Throwable -> L30
        String r4 = r1.optString("city");     // Catch: Throwable -> L30
        if (r2.endsWith("010") == false) goto L6;
    L13:
        if (r3 != null) goto L15;
    L18:
        if (TextUtils.isEmpty(r4) == false) goto L20;
        r10.setCity(r3);     // Catch: Throwable -> L30
        r4 = r3;
    L20:
        String r5 = d(r1.optString("district"));     // Catch: Throwable -> L30
        r10.setDistrict(r5);     // Catch: Throwable -> L30
        String r9 = d(r1.optString("adcode"));     // Catch: Throwable -> L30
        r10.setAdCode(r9);     // Catch: Throwable -> L30
        JSONObject r6 = r1.optJSONObject("streetNumber");     // Catch: Throwable -> L30
        String r7 = d(r6.optString("street"));     // Catch: Throwable -> L30
        r10.setStreet(r7);     // Catch: Throwable -> L30
        r10.setRoad(r7);     // Catch: Throwable -> L30
        String r8 = d(r6.optString("number"));     // Catch: Throwable -> L30
        r10.setNumber(r8);     // Catch: Throwable -> L30
        JSONArray r11 = r15.optJSONArray("pois");     // Catch: Throwable -> L30
        if (r11.length() <= 0) goto L24;
        String r12 = d(JSONArrayProtectorUtils.getJSONObject(r11, 0).optString(EasyGoDbTable.Server.NAME));     // Catch: Throwable -> L30
        r10.setPoiName(r12);     // Catch: Throwable -> L30
        String r13 = r12;
    L25:
        JSONArray r16 = r15.optJSONArray("aois");     // Catch: Throwable -> L30
        if (r16.length() <= 0) goto L28;
        r10.setAoiName(d(JSONArrayProtectorUtils.getJSONObject(r16, 0).optString(EasyGoDbTable.Server.NAME)));     // Catch: Throwable -> L30
    L28:
        c(r10, r3, r4, r5, r7, r8, r13, r9);     // Catch: Throwable -> L30
        return r10;
    L24:
        r13 = null;
        goto L25
    L15:
        if (r3.length() <= 0) goto L18;
        r10.setCity(r3);     // Catch: Throwable -> L30
        r4 = r3;
        goto L18
    L6:
        if (r2.endsWith("021") == true) goto L13;
        if (r2.endsWith("022") == true) goto L13;
        if (r2.endsWith("023") == true) goto L13;
        r4 = d(r4);     // Catch: Throwable -> L30
        r10.setCity(r4);     // Catch: Throwable -> L30
    L30:
        return null;
    }

    public final es b(String r20, Context r21, l0 r22, em r23) {
        es r7 = new es();
        r7.setErrorCode(7);
        StringBuffer r8 = new StringBuffer();
        r8.append("#SHA1AndPackage#");     // Catch: Throwable -> L27
        r8.append(v4.f(r21));     // Catch: Throwable -> L27
        String r10 = (String) ListProtector.get(r22.b.get("gsid"), 0);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r10) == true) goto L6;
        r8.append("#gsid#");     // Catch: Throwable -> L27
        r8.append(r10);     // Catch: Throwable -> L27
    L6:
        String r11 = r22.c;     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r11) == true) goto L32;
        r8.append("#csid#".concat(String.valueOf(r11)));     // Catch: Throwable -> L27
    L32:
        JSONObject r12 = new JSONObject(r20);     // Catch: Throwable -> L21
        if (r12.has("status") == true) goto L13;
    L14:
        r23.h = "#0702";     // Catch: Throwable -> L21
        StringBuilder r13 = this.a;     // Catch: Throwable -> L21
        r13.append("json is error:");     // Catch: Throwable -> L21
        r13.append(r20);     // Catch: Throwable -> L21
        r13.append(r8);     // Catch: Throwable -> L21
        r13.append("#0702");     // Catch: Throwable -> L21
    L15:
        String r0 = JSONObjectProtectorUtils.getString(r12, "status");     // Catch: Throwable -> L21
        String r15 = JSONObjectProtectorUtils.getString(r12, "info");     // Catch: Throwable -> L21
        String r18 = JSONObjectProtectorUtils.getString(r12, "infocode");     // Catch: Throwable -> L21
        if ("0".equals(r0) == false) goto L23;
        r23.h = "#0701";     // Catch: Throwable -> L21
        StringBuilder r1 = this.a;     // Catch: Throwable -> L21
        r1.append("auth fail:");     // Catch: Throwable -> L21
        r1.append(r15);     // Catch: Throwable -> L21
        r1.append(r8);     // Catch: Throwable -> L21
        r1.append("#0701");     // Catch: Throwable -> L21
        String r2 = r22.d;     // Catch: Throwable -> L21
        List<r0> r3 = h4.g;     // Catch: Throwable -> L21
        r.d(c4.k(), "/mobile/binary", r15, r2, NameKeys.UnloadStrategy_No_Strategy, r18);     // Catch: Throwable -> L20
    L23:
        r7.setLocationDetail(this.a.toString());
        if (this.a.length() <= 0) goto L26;
        StringBuilder r4 = this.a;
        r4.delete(0, r4.length());
    L26:
        return r7;
    L13:
        if (r12.has("info") == true) goto L15;
    L21:
        th = move-exception;
        r23.h = "#0703";
        StringBuilder r5 = this.a;
        r5.append("json exception error:");
        r5.append(th.getMessage());
        r5.append(r8);
        r5.append("#0703");
        c4.g(th, "parser", "paseAuthFailurJson");
        goto L23
    }

    public final void c(es r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12) {
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(r6) == true) goto L6;
        r0.append(r6);
        r0.append(" ");
    L6:
        if (TextUtils.isEmpty(r7) == true) goto L18;
        if (this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) goto L13;
        if (r7.equals(r6) == true) goto L18;
    L16:
        r0.append(r7);
        r0.append(" ");
        goto L18
    L13:
        if (r6.contains("市") == false) goto L16;
        if (r6.equals(r7) == false) goto L16;
    L18:
        if (TextUtils.isEmpty(r8) == true) goto L21;
        r0.append(r8);
        r0.append(" ");
    L21:
        if (TextUtils.isEmpty(r9) == true) goto L24;
        r0.append(r9);
        r0.append(" ");
    L24:
        if (TextUtils.isEmpty(r10) == true) goto L27;
        r0.append(r10);
        r0.append(" ");
    L27:
        if (TextUtils.isEmpty(r11) == false) goto L29;
    L35:
        Bundle r13 = new Bundle();
        r13.putString("citycode", r5.getCityCode());
        r13.putString("desc", r0.toString());
        r13.putString("adcode", r5.getAdCode());
        r5.setExtras(r13);
        r5.J = r0.toString();
        String r14 = r5.getAdCode();
        if (r14 != null) goto L38;
    L42:
        String r15 = r0.toString();
    L43:
        r5.setAddress(r15);
        return;
    L38:
        if (r14.trim().length() <= 0) goto L42;
        if (this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) goto L42;
        r15 = r0.toString().replace(" ", NameKeys.UnloadStrategy_No_Strategy);
        goto L43
    L29:
        if (TextUtils.isEmpty(r12) == false) goto L31;
    L33:
        r0.append("Near ".concat(String.valueOf(r11)));
        String r16 = "Near ".concat(String.valueOf(r11));
    L34:
        r5.setDescription(r16);
        goto L35
    L31:
        if (this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) goto L33;
        r0.append("靠近");
        r0.append(r11);
        r0.append(" ");
        r16 = "在" + r11 + "附近";
        goto L34
    }
}
