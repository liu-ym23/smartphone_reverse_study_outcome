package n4a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c4 {
    public static String a = "5.3";
    public static final String[] b = null;
    public static String c;
    public static String d;
    public static final String[] e = null;
    public static String f;
    public static String g;
    public static String h;
    public static HashMap<String, String> i;
    public static e5 j;

    static {
        b = new String[]{"5.1"};
        c = "http://apilocate.amap.com/mobile/binary";
        d = "http://dualstack-a.apilocate.amap.com/mobile/binary";
        e = new String[]{"com.amap.api.location", "com.loc", "com.amap.api.fence"};
        f = null;
        g = null;
        h = null;
        j = null;
    }

    public static Bundle a(AMapLocationClientOption r3) {
        Bundle r0 = new Bundle();
        if (r3 != null) goto L10;
        r3 = new AMapLocationClientOption();
    L10:
        r0.putParcelable("opt", r3);     // Catch: Throwable -> L7
    L9:
        return r0;
    L7:
        th = move-exception;
        g(th, "CoreUtil", "getOptionBundle");
        goto L9
    }

    public static AMapLocationClientOption b(Bundle r3) {
        AMapLocationClientOption r0 = new AMapLocationClientOption();
        if (r3 != null) goto L10;
        return r0;
    L10:
        r3.setClassLoader(AMapLocationClientOption.class.getClassLoader());     // Catch: Throwable -> L7
        return r3.getParcelable("opt");
    L7:
        th = move-exception;
        g(th, "CoreUtil", "getOptionFromBundle");
        return r0;
    }

    public static void d(AMapLocation r5, AMapLocation r6) {
        r5.setCountry(r6.getCountry());     // Catch: Throwable -> L8
        r5.setRoad(r6.getRoad());     // Catch: Throwable -> L8
        r5.setPoiName(r6.getPoiName());     // Catch: Throwable -> L8
        r5.setStreet(r6.getStreet());     // Catch: Throwable -> L8
        r5.setNumber(r6.getStreetNum());     // Catch: Throwable -> L8
        String r0 = r6.getCityCode();     // Catch: Throwable -> L8
        String r1 = r6.getAdCode();     // Catch: Throwable -> L8
        r5.setCityCode(r0);     // Catch: Throwable -> L8
        r5.setAdCode(r1);     // Catch: Throwable -> L8
        r5.setCity(r6.getCity());     // Catch: Throwable -> L8
        r5.setDistrict(r6.getDistrict());     // Catch: Throwable -> L8
        r5.setProvince(r6.getProvince());     // Catch: Throwable -> L8
        r5.setAoiName(r6.getAoiName());     // Catch: Throwable -> L8
        r5.setAddress(r6.getAddress());     // Catch: Throwable -> L8
        r5.setDescription(r6.getDescription());     // Catch: Throwable -> L8
        if (r5.getExtras() == null) goto L6;
        r5.getExtras().putString("citycode", r6.getCityCode());     // Catch: Throwable -> L8
        r5.getExtras().putString("desc", r6.getExtras().getString("desc"));     // Catch: Throwable -> L8
        r5.getExtras().putString("adcode", r6.getAdCode());     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        Bundle r2 = new Bundle();     // Catch: Throwable -> L8
        r2.putString("citycode", r6.getCityCode());     // Catch: Throwable -> L8
        r2.putString("desc", r6.getExtras().getString("desc"));     // Catch: Throwable -> L8
        r2.putString("adcode", r6.getAdCode());     // Catch: Throwable -> L8
        r5.setExtras(r2);     // Catch: Throwable -> L8
    }

    public static void e(AMapLocation r12, JSONObject r13) {
        double r4 = r13.optDouble("lat", r12.getLatitude());     // Catch: Throwable -> L25
        double r6 = r13.optDouble("lon", r12.getLongitude());     // Catch: Throwable -> L25
        r12.setProvider(r13.optString("provider", r12.getProvider()));     // Catch: Throwable -> L25
        r12.setLatitude(r4);     // Catch: Throwable -> L25
        r12.setLongitude(r6);     // Catch: Throwable -> L25
        r12.setAltitude(r13.optDouble("altitude", r12.getAltitude()));     // Catch: Throwable -> L25
        String r8 = r13.optString("accuracy");     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r8) == true) goto L31;
        r12.setAccuracy(CastFloatProtector.parseFloat(r8));     // Catch: Throwable -> L28
    L31:
        String r9 = r13.optString("speed");     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r9) == true) goto L33;
        r12.setSpeed(CastFloatProtector.parseFloat(r9));     // Catch: Throwable -> L29
    L33:
        String r10 = r13.optString("bearing");     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r10) == true) goto L13;
        r12.setBearing(CastFloatProtector.parseFloat(r10));     // Catch: Throwable -> L30
    L13:
        r12.setAdCode(r13.optString("adcode", r12.getAdCode()));     // Catch: Throwable -> L25
        r12.setCityCode(r13.optString("citycode", r12.getCityCode()));     // Catch: Throwable -> L25
        r12.setAddress(r13.optString("address", r12.getAddress()));     // Catch: Throwable -> L25
        String r11 = r13.optString("desc", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L25
        r12.setCountry(r13.optString("country", r12.getCountry()));     // Catch: Throwable -> L25
        r12.setProvince(r13.optString("province", r12.getProvince()));     // Catch: Throwable -> L25
        r12.setCity(r13.optString("city", r12.getCity()));     // Catch: Throwable -> L25
        r12.setDistrict(r13.optString("district", r12.getDistrict()));     // Catch: Throwable -> L25
        r12.setRoad(r13.optString("road", r12.getRoad()));     // Catch: Throwable -> L25
        r12.setStreet(r13.optString("street", r12.getStreet()));     // Catch: Throwable -> L25
        r12.setNumber(r13.optString("number", r12.getStreetNum()));     // Catch: Throwable -> L25
        r12.setPoiName(r13.optString("poiname", r12.getPoiName()));     // Catch: Throwable -> L25
        r12.setAoiName(r13.optString("aoiname", r12.getAoiName()));     // Catch: Throwable -> L25
        r12.setErrorCode(r13.optInt("errorCode", r12.getErrorCode()));     // Catch: Throwable -> L25
        r12.setErrorInfo(r13.optString("errorInfo", r12.getErrorInfo()));     // Catch: Throwable -> L25
        r12.setLocationType(r13.optInt("locationType", r12.getLocationType()));     // Catch: Throwable -> L25
        r12.setLocationDetail(r13.optString("locationDetail", r12.getLocationDetail()));     // Catch: Throwable -> L25
        r12.setTime(r13.optLong("time", r12.getTime()));     // Catch: Throwable -> L25
        boolean r14 = r13.optBoolean("isOffset", r12.isOffset());     // Catch: Throwable -> L25
        r12.setOffset(r14);     // Catch: Throwable -> L25
        r12.setBuildingId(r13.optString("poiid", r12.getBuildingId()));     // Catch: Throwable -> L25
        r12.setFloor(r13.optString("floor", r12.getFloor()));     // Catch: Throwable -> L25
        r12.setDescription(r13.optString("description", r12.getDescription()));     // Catch: Throwable -> L25
        if (r13.has("coordType") == false) goto L18;
        String r15 = r13.optString("coordType", "GCJ02");     // Catch: Throwable -> L25
    L22:
        r12.setCoordType(r15);     // Catch: Throwable -> L25
    L23:
        Bundle r16 = new Bundle();     // Catch: Throwable -> L25
        r16.putString("citycode", r12.getCityCode());     // Catch: Throwable -> L25
        r16.putString("desc", r11.toString());     // Catch: Throwable -> L25
        r16.putString("adcode", r12.getAdCode());     // Catch: Throwable -> L25
        r12.setExtras(r16);     // Catch: Throwable -> L25
        return;
    L18:
        if (h(r4, r6) == false) goto L21;
        if (r14 == false) goto L21;
        r12.setCoordType("GCJ02");     // Catch: Throwable -> L25
    L21:
        r15 = "WGS84";
    L25:
        th = move-exception;
        g(th, "CoreUtil", "transformLocation");
    }

    public static void g(Throwable r1, String r2, String r3) {
        if ("reportError".equals(r3) == false) goto L6;
        return;
    L6:
        if ((r1 instanceof com.loc.l) == false) goto L11;
        return;
    L11:
        r.f(r1, r2, r3);     // Catch: Throwable -> L10
        return;
    }

    public static boolean h(double r4, double r6) {
        int r7 = (int) ((r6 - 73.0d) / 0.5d);
        int r5 = (int) ((r4 - 3.5d) / 0.5d);
        if (r5 >= 0) goto L5;
    L19:
        return false;
    L5:
        if (r5 >= 101) goto L19;
        if (r7 < 0) goto L19;
        if (r7 >= 124) goto L19;
        if ("00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((r5 * 124) + r7) != '1') goto L15;
        return true;
    L15:
        return false;
    L16:
        th = move-exception;
        g(th, "CoreUtil", "isChina");
        return true;
    }

    public static boolean i(double r6, double r8, double r10, double r12, double r14, double r16) {
        if (Math.abs(((r10 - r6) * (r16 - r8)) - ((r14 - r6) * (r12 - r8))) < 1.0E-9d) goto L5;
    L9:
        return false;
    L5:
        if (((r6 - r10) * (r6 - r14)) > 0.0d) goto L9;
        if (((r8 - r12) * (r8 - r16)) > 0.0d) goto L9;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean j(DPoint r33, List<DPoint> r34) {
        double r13 = r33.getLongitude();
        double r15 = r33.getLatitude();
        double r17 = r33.getLatitude();
        if (((DPoint) ListProtector.get(r34, 0)).equals(ListProtector.get(r34, r34.size() - 1)) == true) goto L5;
        r34.add(ListProtector.get(r34, 0));
    L5:
        int r1 = 0;
        int r19 = 0;
    L7:
        if (r1 >= (r34.size() - 1)) goto L39;
        double r21 = ((DPoint) ListProtector.get(r34, r1)).getLongitude();
        double r23 = ((DPoint) ListProtector.get(r34, r1)).getLatitude();
        int r12 = r1 + 1;
        double r25 = ((DPoint) ListProtector.get(r34, r12)).getLongitude();
        double r27 = ((DPoint) ListProtector.get(r34, r12)).getLatitude();
        if (i(r13, r15, r21, r23, r25, r27) == true) goto L10;
        double r31 = r27 - r23;
        if (Math.abs(r31) < 1.0E-9d) goto L37;
        if (i(r21, r23, r13, r15, 180.0d, r17) == false) goto L19;
        if (r23 <= r27) goto L37;
    L36:
        r19 = r19 + 1;
        goto L37
    L19:
        if (i(r25, r27, r13, r15, 180.0d, r17) == true) goto L21;
        double r26 = r25 - r21;
        double r2 = r17 - r15;
        double r5 = 180.0d - r13;
        double r3 = (r26 * r2) - (r31 * r5);
        if (r3 == 0.0d) goto L34;
        double r24 = r23 - r15;
        double r22 = r21 - r13;
        double r6 = ((r5 * r24) - (r2 * r22)) / r3;
        double r28 = ((r24 * r26) - (r22 * r31)) / r3;
        if (r6 < 0.0d) goto L34;
        if (r6 > 1.0d) goto L34;
        if (r28 < 0.0d) goto L34;
        if (r28 > 1.0d) goto L34;
        boolean r11 = true;
    L35:
        if (r11 == false) goto L37;
    L34:
        r11 = false;
        goto L35
    L21:
        if (r27 > r23) goto L36;
    L37:
        r1 = r12;
        goto L7
    L10:
        return true;
    L39:
        if ((r19 % 2) == 0) goto L41;
        return true;
    L41:
        return false;
    }

    public static void l() {
    L7:
        th = move-exception;
        g(th, "CoreUtil", "initUrlHash");
        return;
    L3:
        if (i != null) goto L5;
        i = new HashMap(16);     // Catch: Throwable -> L7
    L5:
        i.clear();     // Catch: Throwable -> L7
        i.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");     // Catch: Throwable -> L7
        i.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");     // Catch: Throwable -> L7
        i.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");     // Catch: Throwable -> L7
    }

    public static e5 k() {
    L7:
        th = move-exception;
        g(th, "CoreUtil", "getSDKInfo");
    L10:
        return j;
    L4:
        if (j != null) goto L10;
        e5.a r1 = new e5.a("loc", "6.4.8", "AMAP_Location_SDK_Android 6.4.8");     // Catch: Throwable -> L7
        r1.e = (String[]) ((String[]) e.clone()).clone();     // Catch: Throwable -> L7
        r1.b = "6.4.8";     // Catch: Throwable -> L7
        j = r1.a();     // Catch: Throwable -> L7
        goto L10
    }

    public static void c(Context r3) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            boolean r0 = n4a.f5.m(r3)     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto Lb
            java.lang.String r3 = "http://abroad.apilocate.amap.com/mobile/binary"
            n4a.c4.c = r3     // Catch: java.lang.Throwable -> L46
            return
        Lb:
            l()     // Catch: java.lang.Throwable -> L46
            java.lang.String r3 = n4a.v4.g(r3)     // Catch: java.lang.Throwable -> L46
            char[] r0 = n4a.t3.a     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L41
            int r0 = r3.length()     // Catch: java.lang.Throwable -> L39
            if (r0 != 0) goto L1d
            goto L41
        L1d:
            java.lang.String r0 = "SHA1"
            java.lang.String r0 = n4a.t3.a(r0, r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r1 = "MD5"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L39
            r2.<init>()     // Catch: java.lang.Throwable -> L39
            r2.append(r0)     // Catch: java.lang.Throwable -> L39
            r2.append(r3)     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = r2.toString()     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = n4a.t3.a(r1, r3)     // Catch: java.lang.Throwable -> L39
            goto L42
        L39:
            r3 = move-exception
            java.lang.String r0 = "Encrypt"
            java.lang.String r1 = "generatorKey"
            g(r3, r0, r1)     // Catch: java.lang.Throwable -> L46
        L41:
            r3 = 0
        L42:
            f(r3)     // Catch: java.lang.Throwable -> L46
            return
        L46:
            r3 = move-exception
            java.lang.String r0 = "CoreUtil"
            java.lang.String r1 = "checkUrl"
            g(r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n4a.c4.c(android.content.Context):void");
    }

    public static void f(String r6) {
        if (r6 == null) goto L41;
    L32:
        th = move-exception;
        g(th, "CoreUtil", "checkUrl");
        return;
    L4:
        if (r6.length() == 0) goto L42;
        HashMap<String, String> r0 = i;     // Catch: Throwable -> L32
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.containsKey(r6) == true) goto L12;
        return;
    L12:
        String r1 = i.get(r6);     // Catch: Throwable -> L32
        if (r1 != null) goto L15;
    L24:
        String r2 = null;
    L25:
        if (r2 != null) goto L27;
        return;
    L27:
        if (r2.length() > 0) goto L29;
        return;
    L29:
        if (r2.contains("http:") == false) goto L40;
        c = r2;     // Catch: Throwable -> L32
        return;
    L40:
        return;
    L15:
        if (r1.length() <= 0) goto L24;
        int r3 = 0;
        if (r1.length() >= 2) goto L19;
        byte[] r4 = new byte[0];     // Catch: Throwable -> L32
    L23:
        r2 = new String(t3.e(r4, r6), "utf-8");     // Catch: Throwable -> L32
        goto L25
    L19:
        String r5 = r1.toLowerCase(Locale.US);     // Catch: Throwable -> L32
        int r7 = r5.length() / 2;     // Catch: Throwable -> L32
        byte[] r8 = new byte[r7];     // Catch: Throwable -> L32
    L20:
        if (r3 >= r7) goto L22;
        int r9 = r3 * 2;     // Catch: Throwable -> L32
        r8[r3] = (byte) (CastIntegerProtector.parseInt(r5.substring(r9, r9 + 2), 16) & 255);     // Catch: Throwable -> L32
        r3 = r3 + 1;     // Catch: Throwable -> L32
        goto L20
    L22:
        r4 = r8;
        goto L23
    L42:
        return;
    }
}
