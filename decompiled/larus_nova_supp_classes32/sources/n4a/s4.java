package n4a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.assistant.AutoEndConversationTime;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s4 {
    public final Object a;
    public final Context b;
    public AMapLocationClient c;
    public final WebView d;
    public String e;
    public AMapLocationClientOption f;
    public volatile boolean g;
    public final a h;

    public class a implements AMapLocationListener {
        public final /* synthetic */ s4 a;

        public a(s4 r1) {
            this.a = r1;
        }

        public final void onLocationChanged(AMapLocation r20) {
            ArrayList r0 = new ArrayList();
            Object[] r10 = {r20};
            f06.b r12 = new f06.b();
            g06.a r1 = (g06.a) ApiHookConfig.b.get(101329);
            if (r1 == null) goto L5;
            f06.a[] r2 = r1.i;
        L6:
            f06.a[] r8 = r2;
            int r7 = r8.length;
            int r6 = 0;
        L8:
            if (r6 >= r7) goto L15;
            f06.a r5 = r8[r6];
            int r16 = r6;
            int r17 = r7;
            f06.a[] r18 = r8;
            f06.d r3 = r5.preInvoke(101329, "com/loc/i$a", "onLocationChanged", this, r10, "void", r12);     // Catch: Exception -> L39
            if (r3.a == true) goto L17;
            r0.add(r5);     // Catch: Exception -> L39
        L17:
            if (r3.a == false) goto L20;
            return;
        L20:
            if (this.a.g == false) goto L48;
            s4 r4 = this.a;
            JSONObject r9 = new JSONObject();
            String r11 = "errorInfo";
            if (r20 != null) goto L26;
            r9.put("errorCode", -1);     // Catch: Throwable -> L38
            String r13 = "unknownError";
        L29:
            r9.put(r11, r13);     // Catch: Throwable -> L38
            goto L30
        L26:
            if (r20.getErrorCode() != 0) goto L28;
            r9.put("errorCode", 0);     // Catch: Throwable -> L38
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L38
            r14.put("x", r20.getLongitude());     // Catch: Throwable -> L38
            r14.put("y", r20.getLatitude());     // Catch: Throwable -> L38
            r14.put("precision", r20.getAccuracy());     // Catch: Throwable -> L38
            r14.put("type", r20.getLocationType());     // Catch: Throwable -> L38
            r14.put("country", r20.getCountry());     // Catch: Throwable -> L38
            r14.put("province", r20.getProvince());     // Catch: Throwable -> L38
            r14.put("city", r20.getCity());     // Catch: Throwable -> L38
            r14.put("cityCode", r20.getCityCode());     // Catch: Throwable -> L38
            r14.put("district", r20.getDistrict());     // Catch: Throwable -> L38
            r14.put("adCode", r20.getAdCode());     // Catch: Throwable -> L38
            r14.put("street", r20.getStreet());     // Catch: Throwable -> L38
            r14.put("streetNum", r20.getStreetNum());     // Catch: Throwable -> L38
            r14.put("floor", r20.getFloor());     // Catch: Throwable -> L38
            r14.put("address", r20.getAddress());     // Catch: Throwable -> L38
            r9.put("result", r14);     // Catch: Throwable -> L38
            goto L30
        L28:
            r9.put("errorCode", r20.getErrorCode());     // Catch: Throwable -> L38
            r9.put("errorInfo", r20.getErrorInfo());     // Catch: Throwable -> L38
            r11 = "locationDetail";
            r13 = r20.getLocationDetail();     // Catch: Throwable -> L38
        L30:
            String r15 = r9.toString();
            r4.getClass();
            WebView r19 = r4.d;     // Catch: Throwable -> L35
            if (r19 == null) goto L49;
            r19.evaluateJavascript("javascript:" + r4.e + "('" + r15 + "')", new r4());     // Catch: Throwable -> L35
            return;
        L49:
            return;
        L35:
            th = move-exception;
            c4.g(th, "H5LocationClient", "callbackJs()");
            return;
        L48:
            return;
        L14:
            r6 = r16 + 1;
            r7 = r17;
            r8 = r18;
            goto L8
        L15:
            r3 = new f06.d(false, null);
            goto L17
        L5:
            r2 = ApiHookConfig.d;
            goto L6
        }
    }

    public s4(Context r3, WebView r4) {
        this.a = new Object();
        this.c = null;
        this.d = null;
        this.e = "AMap.Geolocation.cbk";
        this.f = null;
        this.g = false;
        this.h = null;
        this.b = r3.getApplicationContext();
        this.d = r4;
        this.h = new a(this);
    }

    public final void a(String r10) {
        if (this.f != null) goto L5;
        this.f = new AMapLocationClientOption();
    L5:
        int r0 = 5;
        long r1 = AutoEndConversationTime.AFTER_30_SECONDS;
        boolean r3 = true;
        JSONObject r5 = new JSONObject(r10);     // Catch: Throwable -> L19
        r1 = r5.optLong("to", AutoEndConversationTime.AFTER_30_SECONDS);     // Catch: Throwable -> L19
        if (r5.optInt("useGPS", 1) != 1) goto L9;
        boolean r11 = true;
    L41:
        if (r5.optInt("watch", 0) != 1) goto L13;
        boolean r6 = true;
    L43:
        r0 = r5.optInt("interval", 5);     // Catch: Throwable -> L34
        String r7 = r5.optString("callback", null);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r7) == true) goto L17;
    L16:
        this.e = r7;     // Catch: Throwable -> L34
        goto L37
    L17:
        r7 = "AMap.Geolocation.cbk";
    L37:
        this.f.setHttpTimeOut(r1);     // Catch: Throwable -> L35
        if (r11 == false) goto L25;
        AMapLocationClientOption r12 = this.f;     // Catch: Throwable -> L35
        AMapLocationClientOption.AMapLocationMode r2 = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;     // Catch: Throwable -> L35
    L24:
        r12.setLocationMode(r2);     // Catch: Throwable -> L35
        AMapLocationClientOption r13 = this.f;     // Catch: Throwable -> L35
        if (r6 == false) goto L30;
        r3 = false;
    L30:
        r13.setOnceLocation(r3);     // Catch: Throwable -> L35
        if (r6 == false) goto L45;
        this.f.setInterval(r0 * 1000);     // Catch: Throwable -> L35
        return;
    L45:
        return;
    L25:
        r12 = this.f;     // Catch: Throwable -> L35
        r2 = AMapLocationClientOption.AMapLocationMode.Battery_Saving;     // Catch: Throwable -> L35
    L46:
        return;
    L13:
        r6 = false;
    L20:
        r6 = false;
        goto L37
    L9:
        r11 = false;
    L19:
        r11 = false;
        goto L20
    }

    public final void b() {
        Object r0 = this.a;
        monitor-enter(r0);
        this.g = false;     // Catch: Throwable -> L11
        AMapLocationClient r1 = this.c;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r1.unRegisterLocationListener(this.h);     // Catch: Throwable -> L11
        this.c.stopLocation();     // Catch: Throwable -> L11
        this.c.onDestroy();     // Catch: Throwable -> L11
        this.c = null;     // Catch: Throwable -> L11
    L8:
        this.f = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @JavascriptInterface
    public final void getLocation(String r3) {
        Object r0 = this.a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.g == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        a(r3);     // Catch: Throwable -> L13
        AMapLocationClient r4 = this.c;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.setLocationOption(this.f);     // Catch: Throwable -> L13
        this.c.stopLocation();     // Catch: Throwable -> L13
        this.c.startLocation();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    @JavascriptInterface
    public final void stopLocation() {
        if (this.g == true) goto L5;
        return;
    L5:
        AMapLocationClient r0 = this.c;
        if (r0 == null) goto L9;
        r0.stopLocation();
        return;
    }
}
