package androidx.activity;

import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.z0;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.MultiInstanceInvalidationClient;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation_impl.shake.BDShakeCollectService;
import com.bytedance.bdlocation_impl.shake.ShakeUploadCallback;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.obric.cae.cldReport.CldUtil;
import com.obric.cae.libs.softap.CaeSoftApRequestCallback;
import com.obric.cae.location.geofence.StarGeoCallback;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.location.report.StarLocationReportBase;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetTracker;
import com.obric.cae.smartNetwork.netPolicy.NetPolicyMetric;
import com.obric.cae.smartNfc.ReverseChargingNfcController;
import com.obric.cae.smartNfc.event.ForceFwEvent;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.mediaaware.AudioAwareInfoManger;
import com.obric.cae.utils.AIKernelJavaBridge;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f475b;

    public /* synthetic */ d(Object r8, int r10) {
        this.f474a = r10;
        this.f475b = r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v30, types: [a7.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // java.lang.Runnable
    public final void run() {
        boolean r8 = false;
        HttpURLConnection r10 = null;
        HttpURLConnection r11 = null;
        HttpURLConnection r12 = null;
        r12 = null;
        switch(this.f474a) {
            case 0: goto L209;
            case 1: goto L211;
            case 2: goto L207;
            case 3: goto L205;
            case 4: goto L203;
            case 5: goto L201;
            case 6: goto L190;
            case 7: goto L166;
            case 8: goto L164;
            case 9: goto L162;
            case 10: goto L160;
            case 11: goto L158;
            case 12: goto L42;
            case 13: goto L40;
            case 14: goto L211;
            case 15: goto L31;
            case 16: goto L29;
            case 17: goto L27;
            case 18: goto L25;
            case 19: goto L23;
            case 20: goto L21;
            case 21: goto L19;
            case 22: goto L17;
            case 23: goto L15;
            case 24: goto L13;
            case 25: goto L11;
            case 26: goto L9;
            case 27: goto L7;
            case 28: goto L5;
            default: goto L211;
        };
    L5:
        AudioAwareInfoManger.i((AudioAwareInfoManger) this.f475b);
        return;
    L7:
        NearElevator.c((NearElevator) this.f475b);
        return;
    L9:
        ForceFwEvent.a((ForceFwEvent) this.f475b);
        return;
    L11:
        ReverseChargingNfcController.a((ReverseChargingNfcController) this.f475b);
        return;
    L13:
        NetPolicyMetric.b((NetPolicyMetric) this.f475b);
        return;
    L15:
        L4NetTracker.a((L4NetTracker) this.f475b);
        return;
    L17:
        StarLocationReportBase.a((StarLocationReportBase) this.f475b);
        return;
    L19:
        StarPoiManager.a((StarPoiManager) this.f475b);
        return;
    L21:
        StarGeofenceManager.c((StarGeofenceManager) this.f475b);
        return;
    L23:
        StarGeoCallback.b((StarGeoCallback) this.f475b);
        return;
    L25:
        ((CaeSoftApRequestCallback) this.f475b).onSuccess();
        return;
    L27:
        CldUtil.a((String) this.f475b);
        return;
    L29:
        ((com.google.android.material.timepicker.c) this.f475b).s();
        return;
    L31:
        SideSheetBehavior.b r15 = (SideSheetBehavior.b) this.f475b;
        r15.f4941b = false;
        SideSheetBehavior r13 = r15.f4943d;
        o0.c r14 = r13.f4924i;
        if (r14 == null) goto L37;
        if (r14.g() == false) goto L37;
        r15.a(r15.f4940a);
        return;
    L37:
        if (r13.f4923h != 2) goto L247;
        r13.z(r15.f4940a);
        return;
    L247:
        return;
    L40:
        x8.i r16 = (x8.i) this.f475b;
        r16.getClass();
        r16.c(y6.a.EnumC0198a.f14007q);
        return;
    L42:
        ?? r17 = (a7.b) this.f475b;
        HandlerThread r18 = a7.b.F;
        r17.getClass();
        long r19 = SystemClock.uptimeMillis();
        ?? r20 = r17.f71v;     // Catch: IOException -> L128
        monitor-enter(r20);     // Catch: IOException -> L128
    L120:
        th = th;
        HttpURLConnection r21 = r12;
        Object r22 = r12;
        ?? r23 = r20;
    L217:
        monitor-exit(r23);     // Catch: Throwable -> L126
        throw th;     // Catch: IOException -> L124
    L124:
        e = e;
        ?? r24 = r22;
        r10 = r21;
    L130:
        Object r25 = r17.f71v;
        monitor-enter(r25);
        if (r10 == null) goto L137;
        r10.disconnect();     // Catch: Throwable -> L155
        if (r17.f73x == null) goto L137;
        r17.f75z.add(new a7.b.a(r10.getURL().getHost(), r17.c(e, r24, r10)));     // Catch: Throwable -> L155
        r17.f73x.remove(r10);     // Catch: Throwable -> L155
    L155:
        th = move-exception;
        throw th;
    L137:
        if (r17.f75z.size() < r17.f70u.size()) goto L219;
        r17.A.countDown();     // Catch: Throwable -> L155
    L153:
        monitor-exit(r25);     // Catch: Throwable -> L155
        return;
    L219:
        Class r26 = a7.b.G;     // Catch: Throwable -> L148
        if (r26 == null) goto L151;
        if (r26.isInstance(e) == false) goto L151;
        int r27 = ((Integer) Reflect.on(e).call("getCronetInternalErrorCode").get()).intValue();     // Catch: Throwable -> L148
        Logger.d("b", "cronet error code: " + r27);     // Catch: Throwable -> L148
        if (a7.f.c().b(r27, r17.f69t) == false) goto L151;
        r17.A.countDown();     // Catch: Throwable -> L148
    L151:
        if ((SystemClock.uptimeMillis() - r19) >= (r17.C * 1000)) goto L153;
        Message r28 = Message.obtain();     // Catch: Throwable -> L155
        r28.what = 1;     // Catch: Throwable -> L155
        r28.obj = r17;     // Catch: Throwable -> L155
        r17.B.sendMessage(r28);     // Catch: Throwable -> L155
    L148:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L155
    L126:
        th = th;
        goto L217
    L46:
        if (r17.f72w.get() < r17.f70u.size()) goto L48;
    L117:
        r17.B.removeCallbacksAndMessages(null);     // Catch: Throwable -> L120
        r20 = r20;
        monitor-exit(r20);     // Catch: Throwable -> L120
    L237:
        return;
    L48:
        if (r17.f74y != null) goto L117;
        if (r17.A.getCount() == 0) goto L117;
        String r29 = (String) r17.f70u.get(r17.f72w.get());     // Catch: Throwable -> L120
        Logger.d("b", "ConstructURLConnection and execute index: " + r17.f72w.get() + " url: " + r29);     // Catch: Throwable -> L115
        r11 = a7.i.c(r29, r17.f64o, r17.f67r, r17.f61b);     // Catch: Throwable -> L115
        r11.setRequestProperty("x-tt-bp-rs", "1");     // Catch: Throwable -> L115
        r11.setRequestProperty("transaction-id", r17.f68s);     // Catch: Throwable -> L115
        r17.f72w.incrementAndGet();     // Catch: Throwable -> L115
        CopyOnWriteArrayList r30 = r17.f73x;     // Catch: Throwable -> L115
        if (r30 == null) goto L56;
        r30.add(r11);     // Catch: Throwable -> L115
    L56:
        monitor-exit(r20);     // Catch: Throwable -> L115
        Request r31 = r17.f64o;     // Catch: IOException -> L62
        if (r31 == null) goto L65;
        TypedOutput r32 = r31.getBody();     // Catch: IOException -> L62
        if (r32 == null) goto L64;
        r32.writeTo(r11.getOutputStream());     // Catch: IOException -> L62
    L64:
        w6.e.d r33 = w6.e.f13020a;     // Catch: IOException -> L62
        int r34 = r11.getResponseCode();     // Catch: IOException -> L62
    L66:
        String r35 = r11.getHeaderField("tt-api-source-5xx");     // Catch: IOException -> L62
        String r36 = r17.f69t;     // Catch: IOException -> L62
        if (r34 < 200) goto L70;
        if (r34 >= 300) goto L70;
        ?? r37 = r35;
    L87:
        if (r8 == true) goto L101;
        Object r38 = r17.f71v;     // Catch: IOException -> L62
        monitor-enter(r38);     // Catch: IOException -> L62
    L98:
        th = move-exception;
        throw th;     // Catch: IOException -> L62
    L91:
        if (r17.f74y != null) goto L93;
        r17.f74y = r11;     // Catch: Throwable -> L98
        r17.f65p = r29;     // Catch: Throwable -> L98
        r17.A.countDown();     // Catch: Throwable -> L98
    L96:
        monitor-exit(r38);     // Catch: Throwable -> L98
        r12 = r11;
        r20 = r37;
        goto L237
    L93:
        r11.disconnect();     // Catch: Throwable -> L98
        CopyOnWriteArrayList r39 = r17.f73x;     // Catch: Throwable -> L98
        if (r39 == null) goto L96;
        r39.remove(r11);     // Catch: Throwable -> L98
        goto L96
    L101:
        String r40 = r11.getResponseMessage();     // Catch: IOException -> L62
        int r110 = r17.f64o.getMaxLength();     // Catch: Throwable -> L108
        InputStream r41 = r11.getInputStream();     // Catch: Exception -> L105 Throwable -> L108
    L104:
        InputStream r111 = r41;
        String r112 = a7.i.i("Content-Type", r11);     // Catch: Throwable -> L108
        r11.getHeaderFields();     // Catch: Throwable -> L108
        a7.i.q(false, r110, r111, r112, r29, r17.f60a);     // Catch: Throwable -> L108
    L114:
        throw new b7.b(r34, r40);     // Catch: IOException -> L62
    L105:
        r41 = r11.getErrorStream();     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        th.printStackTrace();     // Catch: IOException -> L62
        StringBuilder r42 = new StringBuilder("reason = ");     // Catch: IOException -> L62
        if (r40 != null) goto L112;
        r40 = "";
    L112:
        r42.append(r40);     // Catch: IOException -> L62
        r42.append("  exception = ");     // Catch: IOException -> L62
        r42.append(th.getMessage());     // Catch: IOException -> L62
        r40 = r42.toString();     // Catch: IOException -> L62
    L70:
        if (r35 == null) goto L74;
        boolean r43 = r35.equals("1");     // Catch: IOException -> L62
        if (r43 == false) goto L74;
        r37 = r43;
    L74:
        if (r34 >= 300) goto L76;
    L83:
        boolean r44 = a7.f.c().b(r34, r36);     // Catch: IOException -> L62
        if (r44 == false) goto L86;
        r37 = r44;
        goto L87
    L86:
        r8 = true;
        r37 = r44;
        goto L87
    L76:
        if (r34 >= 600) goto L83;
        if (a7.f.c().f95b <= 0) goto L80;
        boolean r45 = true;
    L81:
        if (r45 == true) goto L83;
        r37 = r45;
        goto L87
    L80:
        r45 = false;
        goto L81
    L65:
        r34 = -1;
    L62:
        e = e;
        r10 = r11;
        r24 = r29;
    L115:
        th = th;
        r21 = r11;
        r22 = r29;
        r23 = r20;
    L128:
        e = e;
        r24 = 0;
        goto L130
    L158:
        BDShakeCollectService.b((ShakeUploadCallback) this.f475b);
        return;
    L160:
        LocationCache.getInstance().performLocationChangeNotificationIfNeed((BDLocation) this.f475b);
        return;
    L162:
        defpackage.b.l(this.f475b);
        he.i.f(null, "this$0");
        throw null;
    L164:
        androidx.work.impl.background.systemalarm.c.b((androidx.work.impl.background.systemalarm.c) this.f475b);
        return;
    L166:
        androidx.room.v r113 = (androidx.room.v) this.f475b;
        int r46 = androidx.room.v.f2701v;
        he.i.f(r113, "this$0");
        if (r113.f2709s.compareAndSet(false, true) == false) goto L169;
        androidx.room.i r47 = r113.f2702l.getInvalidationTracker();
        androidx.room.u r48 = r113.f2706p;
        r47.getClass();
        he.i.f(r48, "observer");
        r47.b(new androidx.room.i.e(r47, r48));
    L169:
        AtomicBoolean r49 = r113.f2708r;
        boolean r50 = r49.compareAndSet(false, true);
        AtomicBoolean r51 = r113.f2707q;
        if (r50 == false) goto L185;
        boolean r52 = false;
        Object r53 = null;
    L225:
    L182:
        th = move-exception;
        r49.set(false);
        throw th;
    L173:
        if (r51.compareAndSet(true, false) == false) goto L179;
        r53 = r113.f2705o.call();     // Catch: Exception -> L176 Throwable -> L182
        r52 = true;
        goto L225
    L176:
        e = move-exception;
        throw new RuntimeException("Exception while computing database live data.", e);     // Catch: Throwable -> L182
    L179:
        if (r52 == false) goto L181;
        r113.g(r53);     // Catch: Throwable -> L182
    L181:
        r49.set(false);
        boolean r54 = r52;
    L186:
        if (r54 == false) goto L189;
        if (r51.get() == true) goto L169;
        return;
    L189:
        return;
    L185:
        r54 = false;
        goto L186
    L190:
        MultiInstanceInvalidationClient r114 = (MultiInstanceInvalidationClient) this.f475b;
        he.i.f(r114, "this$0");
        IMultiInstanceInvalidationService r55 = r114.f2586g;     // Catch: RemoteException -> L198
        if (r55 == null) goto L250;
        r114.f2584e = r55.F1(r114.f2587h, r114.f2580a);     // Catch: RemoteException -> L198
        androidx.room.i r56 = r114.f2581b;     // Catch: RemoteException -> L198
        androidx.room.i.c r115 = r114.f2585f;     // Catch: RemoteException -> L198
        if (r115 == null) goto L196;
        r56.b(r115);     // Catch: RemoteException -> L198
        return;
    L196:
        he.i.j("observer");     // Catch: RemoteException -> L198
        throw null;     // Catch: RemoteException -> L198
    L250:
        return;
    L198:
        e = move-exception;
        Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
        return;
    L201:
        defpackage.b.l(this.f475b);
        androidx.room.a.a();
        throw null;
    L203:
        ((androidx.emoji2.text.l.b) this.f475b).c();
        return;
    L205:
        ((z0) this.f475b).b(false);
        return;
    L207:
        ((Toolbar) this.f475b).l();
        return;
    L209:
        ((ComponentActivity) this.f475b).invalidateMenu();
        return;
    L211:
        AIKernelJavaBridge.a((ge.l) this.f475b);
    }
}
