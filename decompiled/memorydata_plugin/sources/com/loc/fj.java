package com.loc;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    AMapLocationClientOption f5543b;
    a c;
    private com.amap.api.location.a d;
    private WebView e;
    private String f;
    private volatile boolean g;

    class a implements com.amap.api.location.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ fj f5547a;

        @Override // com.amap.api.location.b
        public final void onLocationChanged(AMapLocation r2) {
            if (fj.c(this.f5547a) == false) goto L6;
            fj.a(this.f5547a, fj.a(r2));
            return;
        }
    }

    static /* synthetic */ String a(AMapLocation r0) {
        return b(r0);
    }

    static /* synthetic */ String a(fj r0) {
        return r0.f;
    }

    static /* synthetic */ void a(fj r0, String r1) {
        r0.b(r1);
    }

    private void a(String r10) {
        if (this.f5543b != null) goto L5;
        this.f5543b = new AMapLocationClientOption();
    L5:
        int r0 = 5;
        long r1 = 30000;
        boolean r3 = true;
        JSONObject r5 = new JSONObject(r10);     // Catch: Throwable -> L20
        r1 = r5.optLong(TypedValues.TransitionType.S_TO, 30000);     // Catch: Throwable -> L20
        if (r5.optInt("useGPS", 1) != 1) goto L9;
        boolean r11 = true;
    L38:
        if (r5.optInt("watch", 0) != 1) goto L13;
        boolean r6 = true;
    L42:
        r0 = r5.optInt("interval", 5);     // Catch: Throwable -> L34
        String r7 = r5.optString("callback", null);     // Catch: Throwable -> L34
        if (TextUtils.isEmpty(r7) == true) goto L17;
    L16:
        this.f = r7;     // Catch: Throwable -> L34
        goto L36
    L17:
        r7 = "AMap.Geolocation.cbk";
    L36:
        this.f5543b.setHttpTimeOut(r1);     // Catch: Throwable -> L35
        if (r11 == false) goto L25;
        AMapLocationClientOption r12 = this.f5543b;     // Catch: Throwable -> L35
        AMapLocationClientOption.AMapLocationMode r2 = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;     // Catch: Throwable -> L35
    L24:
        r12.setLocationMode(r2);     // Catch: Throwable -> L35
        AMapLocationClientOption r13 = this.f5543b;     // Catch: Throwable -> L35
        if (r6 == false) goto L30;
        r3 = false;
    L30:
        r13.setOnceLocation(r3);     // Catch: Throwable -> L35
        if (r6 == false) goto L44;
        this.f5543b.setInterval(r0 * 1000);     // Catch: Throwable -> L35
        return;
    L44:
        return;
    L25:
        r12 = this.f5543b;     // Catch: Throwable -> L35
        r2 = AMapLocationClientOption.AMapLocationMode.Battery_Saving;     // Catch: Throwable -> L35
    L45:
        return;
    L13:
        r6 = false;
    L19:
        r6 = false;
        goto L36
    L9:
        r11 = false;
    L20:
        r11 = false;
        r6 = false;
        goto L36
    }

    static /* synthetic */ WebView b(fj r0) {
        return r0.e;
    }

    private static String b(AMapLocation r5) {
        JSONObject r0 = new JSONObject();
        String r1 = "errorInfo";
        if (r5 != null) goto L8;
        r0.put("errorCode", -1);     // Catch: Throwable -> L14
        String r6 = "unknownError";
    L6:
        r0.put(r1, r6);     // Catch: Throwable -> L14
        goto L13
    L8:
        if (r5.getErrorCode() != 0) goto L10;
        r0.put("errorCode", 0);     // Catch: Throwable -> L14
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L14
        r2.put("x", r5.getLongitude());     // Catch: Throwable -> L14
        r2.put("y", r5.getLatitude());     // Catch: Throwable -> L14
        r2.put("precision", r5.getAccuracy());     // Catch: Throwable -> L14
        r2.put("type", r5.getLocationType());     // Catch: Throwable -> L14
        r2.put("country", r5.getCountry());     // Catch: Throwable -> L14
        r2.put("province", r5.getProvince());     // Catch: Throwable -> L14
        r2.put("city", r5.getCity());     // Catch: Throwable -> L14
        r2.put("cityCode", r5.getCityCode());     // Catch: Throwable -> L14
        r2.put("district", r5.getDistrict());     // Catch: Throwable -> L14
        r2.put("adCode", r5.getAdCode());     // Catch: Throwable -> L14
        r2.put("street", r5.getStreet());     // Catch: Throwable -> L14
        r2.put("streetNum", r5.getStreetNum());     // Catch: Throwable -> L14
        r2.put("floor", r5.getFloor());     // Catch: Throwable -> L14
        r2.put(MemoryKeyInfoEntity.KEY_ADDRESS, r5.getAddress());     // Catch: Throwable -> L14
        r0.put("result", r2);     // Catch: Throwable -> L14
        goto L13
    L10:
        r0.put("errorCode", r5.getErrorCode());     // Catch: Throwable -> L14
        r0.put("errorInfo", r5.getErrorInfo());     // Catch: Throwable -> L14
        r1 = "locationDetail";
        r6 = r5.getLocationDetail();     // Catch: Throwable -> L14
    L13:
        return r0.toString();
    }

    private void b(final String r4) {
    L10:
        th = move-exception;
        ev.a(th, "H5LocationClient", "callbackJs()");
        return;
    L3:
        if (this.e != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L8;
        this.e.evaluateJavascript("javascript:" + this.f + "('" + r4 + "')", new AnonymousClass1(this));     // Catch: Throwable -> L10
        return;
    L8:
        this.e.post(new AnonymousClass2(this, r4));     // Catch: Throwable -> L10
    }

    static /* synthetic */ boolean c(fj r0) {
        return r0.g;
    }

    public final void a() {
        Object r0 = this.f5542a;
        monitor-enter(r0);
        this.g = false;     // Catch: Throwable -> L11
        com.amap.api.location.a r1 = this.d;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        r1.b(this.c);     // Catch: Throwable -> L11
        this.d.b();     // Catch: Throwable -> L11
        this.d.d();     // Catch: Throwable -> L11
        this.d = null;     // Catch: Throwable -> L11
    L8:
        this.f5543b = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @JavascriptInterface
    public final void getLocation(String r3) {
        Object r0 = this.f5542a;
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
        com.amap.api.location.a r4 = this.d;     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.a(this.f5543b);     // Catch: Throwable -> L13
        this.d.b();     // Catch: Throwable -> L13
        this.d.a();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    @JavascriptInterface
    public final void stopLocation() {
        if (this.g == true) goto L5;
        return;
    L5:
        com.amap.api.location.a r1 = this.d;
        if (r1 == null) goto L9;
        r1.b();
        return;
    }
}
