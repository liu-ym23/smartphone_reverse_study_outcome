package n4a;

import android.os.Bundle;
import android.os.SystemClock;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.lynx.serval.svg.SVGRenderEngine;
import com.miui.easygo.constant.EasyGoDbTable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w0 {
    public static long a;

    public w0() {
    }

    public static int a(String r16, List<GeoFence> r17, Bundle r18) {
        JSONObject r1 = new JSONObject(r16);     // Catch: Throwable -> L15
        int r2 = r1.optInt("status", 0);     // Catch: Throwable -> L15
        int r4 = r1.optInt("infocode", 0);     // Catch: Throwable -> L15
        if (r2 != 1) goto L20;
        JSONArray r3 = r1.optJSONArray("pois");     // Catch: Throwable -> L15
        if (r3 == null) goto L21;
        int r5 = 0;
    L8:
        if (r5 >= r3.length()) goto L22;
        GeoFence r6 = new GeoFence();     // Catch: Throwable -> L15
        PoiItem r7 = new PoiItem();     // Catch: Throwable -> L15
        JSONObject r8 = JSONArrayProtectorUtils.getJSONObject(r3, r5);     // Catch: Throwable -> L15
        r7.setPoiId(r8.optString("id"));     // Catch: Throwable -> L15
        r7.setPoiName(r8.optString(EasyGoDbTable.Server.NAME));     // Catch: Throwable -> L15
        r7.setPoiType(r8.optString("type"));     // Catch: Throwable -> L15
        r7.setTypeCode(r8.optString("typecode"));     // Catch: Throwable -> L15
        r7.setAddress(r8.optString("address"));     // Catch: Throwable -> L15
        String r9 = r8.optString("location");     // Catch: Throwable -> L15
        if (r9 == null) goto L13;
        String[] r10 = r9.split(",");     // Catch: Throwable -> L15
        r7.setLongitude(CastDoubleProtector.parseDouble(r10[0]));     // Catch: Throwable -> L15
        r7.setLatitude(CastDoubleProtector.parseDouble(r10[1]));     // Catch: Throwable -> L15
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L15
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L15
        DPoint r13 = new DPoint(r7.getLatitude(), r7.getLongitude());     // Catch: Throwable -> L15
        r12.add(r13);     // Catch: Throwable -> L15
        r11.add(r12);     // Catch: Throwable -> L15
        r6.setPointList(r11);     // Catch: Throwable -> L15
        r6.setCenter(r13);     // Catch: Throwable -> L15
    L13:
        r7.setTel(r8.optString("tel"));     // Catch: Throwable -> L15
        r7.setProvince(r8.optString("pname"));     // Catch: Throwable -> L15
        r7.setCity(r8.optString("cityname"));     // Catch: Throwable -> L15
        r7.setAdname(r8.optString("adname"));     // Catch: Throwable -> L15
        r6.setPoiItem(r7);     // Catch: Throwable -> L15
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L15
        r14.append(b());     // Catch: Throwable -> L15
        r6.setFenceId(r14.toString());     // Catch: Throwable -> L15
        r6.setCustomId(r18.getString("customId"));     // Catch: Throwable -> L15
        r6.setPendingIntentAction(r18.getString("pendingIntentAction"));     // Catch: Throwable -> L15
        r6.setType(2);     // Catch: Throwable -> L15
        r6.setRadius(r18.getFloat("fenceRadius"));     // Catch: Throwable -> L15
        r6.setExpiration(r18.getLong("expiration"));     // Catch: Throwable -> L15
        r6.setActivatesAction(r18.getInt("activatesAction", 1));     // Catch: Throwable -> L15
        ((ArrayList) r17).add(r6);     // Catch: Throwable -> L15
        r5 = r5 + 1;
        goto L8
    L22:
        return r4;
    L21:
        return r4;
    L20:
        return r4;
    L15:
        return 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List] */
    public static int d(String r32, List r33, Bundle r34) {
        JSONObject r1 = new JSONObject(r32);     // Catch: Throwable -> L37
        int r2 = r1.optInt("status", 0);     // Catch: Throwable -> L37
        int r4 = r1.optInt("infocode", 0);     // Catch: Throwable -> L37
        String r5 = r34.getString("customId");     // Catch: Throwable -> L37
        String r6 = r34.getString("pendingIntentAction");     // Catch: Throwable -> L37
        float r7 = r34.getFloat("fenceRadius");     // Catch: Throwable -> L37
        long r8 = r34.getLong("expiration");     // Catch: Throwable -> L37
        int r0 = r34.getInt("activatesAction", 1);     // Catch: Throwable -> L37
        if (r2 != 1) goto L50;
        JSONArray r3 = r1.optJSONArray("districts");     // Catch: Throwable -> L37
        if (r3 == null) goto L50;
        int r9 = 0;
    L8:
        if (r9 >= r3.length()) goto L50;
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L37
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L37
        GeoFence r13 = new GeoFence();     // Catch: Throwable -> L37
        JSONObject r14 = JSONArrayProtectorUtils.getJSONObject(r3, r9);     // Catch: Throwable -> L37
        String r15 = r14.optString("citycode");     // Catch: Throwable -> L37
        String r11 = r14.optString("adcode");     // Catch: Throwable -> L37
        String r16 = r14.optString(EasyGoDbTable.Server.NAME);     // Catch: Throwable -> L37
        JSONArray r35 = r3;
        String r17 = JSONObjectProtectorUtils.getString(r14, "center");     // Catch: Throwable -> L37
        int r18 = r4;
        DPoint r19 = new DPoint();     // Catch: Throwable -> L37
        int r110 = r9;
        String r20 = ",";
        if (r17 == null) goto L15;
        String[] r21 = r17.split(",");     // Catch: Throwable -> L37
        r19.setLatitude(CastDoubleProtector.parseDouble(r21[1]));     // Catch: Throwable -> L37
        r19.setLongitude(CastDoubleProtector.parseDouble(r21[0]));     // Catch: Throwable -> L37
        r13.setCenter(r19);     // Catch: Throwable -> L37
    L15:
        r13.setCustomId(r5);     // Catch: Throwable -> L37
        r13.setPendingIntentAction(r6);     // Catch: Throwable -> L37
        r13.setType(3);     // Catch: Throwable -> L37
        r13.setRadius(r7);     // Catch: Throwable -> L37
        r13.setExpiration(r8);     // Catch: Throwable -> L37
        r13.setActivatesAction(r0);     // Catch: Throwable -> L37
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L37
        r22.append(b());     // Catch: Throwable -> L37
        r13.setFenceId(r22.toString());     // Catch: Throwable -> L37
        String r23 = r14.optString(SVGRenderEngine.POLYLINE);     // Catch: Throwable -> L37
        if (r23 == null) goto L34;
        String[] r24 = r23.split("\\|");     // Catch: Throwable -> L37
        int r111 = r24.length;     // Catch: Throwable -> L37
        float r25 = Float.MIN_VALUE;
        int r112 = 0;
        float r113 = Float.MAX_VALUE;
    L18:
        String r26 = r5;
        if (r112 >= r111) goto L32;
        String r27 = r24[r112];     // Catch: Throwable -> L37
        String[] r28 = r24;
        DistrictItem r29 = new DistrictItem();     // Catch: Throwable -> L37
        String r210 = r6;
        ?? r30 = new ArrayList();     // Catch: Throwable -> L37
        r29.setCitycode(r15);     // Catch: Throwable -> L37
        r29.setAdcode(r11);     // Catch: Throwable -> L37
        String r211 = r11;
        String r31 = r16;
        r29.setDistrictName(r31);     // Catch: Throwable -> L37
        r16 = r31;
        String[] r36 = r27.split(";");     // Catch: Throwable -> L37
        float r212 = r7;
        int r37 = 0;
    L22:
        if (r37 >= r36.length) goto L28;
        String[] r38 = r36[r37].split(r20);     // Catch: Throwable -> L37
        String r213 = r20;
        String[] r214 = r36;
        if (r38.length <= 1) goto L27;
        r30.add(new DPoint(CastDoubleProtector.parseDouble(r38[1]), CastDoubleProtector.parseDouble(r38[0])));     // Catch: Throwable -> L37
    L27:
        r37 = r37 + 1;     // Catch: Throwable -> L37
        r111 = r111;
        r20 = r213;
        r36 = r214;
        r8 = r8;
        r112 = r112;
        goto L22
    L28:
        String r215 = r20;
        long r216 = r8;
        int r39 = r111;
        int r310 = r112;
        if (r30.size() <= 100.0f) goto L31;
        r30 = c(r30);     // Catch: Throwable -> L37
    L31:
        r12.add(r30);     // Catch: Throwable -> L37
        r29.setPolyline(r30);     // Catch: Throwable -> L37
        ArrayList r40 = r10;
        r40.add(r29);     // Catch: Throwable -> L37
        r25 = Math.max(r25, a.q(r19, r30));     // Catch: Throwable -> L37
        r113 = Math.min(r113, a.b(r19, r30));     // Catch: Throwable -> L37
        r112 = r310 + 1;     // Catch: Throwable -> L37
        r111 = r39;
        r10 = r40;
        r5 = r26;
        r24 = r28;
        r6 = r210;
        r11 = r211;
        r7 = r212;
        r20 = r215;
        r8 = r216;
        goto L18
    L32:
        String r217 = r6;
        float r218 = r7;
        long r219 = r8;
        r13.setMaxDis2Center(r25);     // Catch: Throwable -> L37
        r13.setMinDis2Center(r113);     // Catch: Throwable -> L37
        r13.setDistrictItemList(r10);     // Catch: Throwable -> L37
        r13.setPointList(r12);     // Catch: Throwable -> L37
        ((ArrayList) r33).add(r13);     // Catch: Throwable -> L37
    L35:
        r9 = r110 + 1;
        r3 = r35;
        r4 = r18;
        r0 = r0;
        r5 = r26;
        r6 = r217;
        r7 = r218;
        r8 = r219;
        goto L8
    L34:
        r26 = r5;
        r217 = r6;
        r218 = r7;
        r219 = r8;
    L50:
        return r4;
    L37:
        return 5;
    }

    public static synchronized long b() {
        monitor-enter(w0.class);
        long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        long r3 = a;     // Catch: Throwable -> L11
        if (r1 <= r3) goto L7;
        a = r1;     // Catch: Throwable -> L11
    L8:
        long r2 = a;     // Catch: Throwable -> L11
        monitor-exit(w0.class);
        return r2;
    L7:
        a = r3 + 1;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static List c(List r24) {
        if (r24 != null) goto L7;
        return null;
    L7:
        if (r24.size() > 2) goto L9;
        return r24;
    L9:
        ArrayList r1 = new ArrayList();
        DPoint r3 = (DPoint) ListProtector.get(r24, 0);
        int r5 = 1;
        DPoint r4 = (DPoint) ListProtector.get(r24, r24.size() - 1);
        double r6 = 0.0d;
        double r9 = 0.0d;
        int r8 = 1;
        int r11 = 0;
    L11:
        if (r8 >= (r24.size() - r5)) goto L32;
        DPoint r12 = (DPoint) ListProtector.get(r24, r8);
        double r13 = r12.getLongitude() - r3.getLongitude();
        double r15 = r12.getLatitude() - r3.getLatitude();
        double r17 = r4.getLongitude() - r3.getLongitude();
        double r19 = r4.getLatitude() - r3.getLatitude();
        double r14 = ((r13 * r17) + (r15 * r19)) / ((r17 * r17) + (r19 * r19));
        if (r3.getLongitude() == r4.getLongitude()) goto L15;
    L17:
        boolean r16 = false;
    L19:
        if (r14 < r6) goto L26;
        if (r16 == true) goto L26;
        if (r14 <= 1.0d) goto L25;
        double r18 = r4.getLongitude();
        double r110 = r4.getLatitude();
    L27:
        double r7 = r110;
    L28:
        DPoint r111 = r3;
        double r2 = j4.b(new DPoint(r12.getLatitude(), r12.getLongitude()), new DPoint(r7, r18));
        if (r2 <= r9) goto L31;
        r9 = r2;
        r11 = r8;
    L31:
        r8 = r8 + 1;
        r3 = r111;
        r5 = 1;
        r6 = 0.0d;
        goto L11
    L25:
        double r112 = r3.getLongitude() + (r17 * r14);
        double r113 = r3.getLatitude() + (r14 * r19);
        r18 = r112;
        r7 = r113;
    L26:
        r18 = r3.getLongitude();
        r110 = r3.getLatitude();
        goto L27
    L15:
        if (r3.getLatitude() != r4.getLatitude()) goto L17;
        r16 = true;
        goto L19
    L32:
        DPoint r114 = r3;
        if (r9 >= 100.0f) goto L36;
        r1.add(r114);
        r1.add(r4);
        return r1;
    L36:
        List r10 = c(r24.subList(0, r11 + 1));
        List r0 = c(r24.subList(r11, r24.size()));
        r1.addAll(r10);
        ListProtector.remove(r1, r1.size() - 1);
        r1.addAll(r0);
        return r1;
    }
}
