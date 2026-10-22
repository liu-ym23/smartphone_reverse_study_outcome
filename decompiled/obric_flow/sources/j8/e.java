package j8;

import ai.j0;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import com.bytedance.common.wschannel.server.NetworkUtils$NetworkType;
import com.bytedance.ies.web.jsbridge2.p;
import g8.g;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.l0;
import okhttp3.n0;
import org.json.JSONObject;
import sj.k;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f18280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fn.c f18281c;
    public OkHttpClient d;
    public int e;
    public Request f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap f18282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakHandler f18283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.lynx.animax.player.b f18284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public l8.a f18285k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final q8.b f18286l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ug.d f18287m;

    public e(p r5) {
        this.e = 3;
        this.f18282h = new ConcurrentHashMap();
        WeakHandler r10 = new WeakHandler(Looper.myLooper(), this);
        this.f18283i = r10;
        this.f18280b = r5;
        this.f18279a = (Context) r5.f6303b;
        this.d = null;
        q8.b r11 = (q8.b) r5.e;
        this.f18286l = r11;
        if (r11 != null) goto L5;
        this.f18286l = new q8.b(new r9.c(15));
    L5:
        q8.b r12 = this.f18286l;
        r12.f21492a = new sg.a(this);
        r12.f21493b = r10;
        this.f18287m = new ug.d(new k(this, false), r10);
    }

    public final void a() {
        fn.c r5 = this.f18281c;
        if (r5 == null) goto L11;
        monitor-enter(r5);
        k8.a r10 = (k8.a) r5.f16949c;     // Catch: Throwable -> L8
        r10.f18625b = 0;     // Catch: Throwable -> L8
        r10.f18626c = 0;     // Catch: Throwable -> L8
        r5.d = null;     // Catch: Throwable -> L8
        r5.f16947a = 0;     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        this.f18283i.removeMessages(1);
    }

    public final synchronized void b(int r5) {
        monitor-enter(this);
        this.e = r5;     // Catch: Throwable -> L6
        String r10 = "";
        if (r5 != 1) goto L9;
        r10 = "connecting";
    L23:
        Logger.d("WsChannelSdk_ok", "current status is :".concat(r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L9:
        if (r5 != 2) goto L12;
        r10 = "connect failed";
        goto L23
    L12:
        if (r5 != 3) goto L15;
        r10 = "connection close ";
        goto L23
    L15:
        if (r5 != 4) goto L18;
        r10 = "connected";
        goto L23
    L18:
        if (r5 != 5) goto L21;
        r10 = "retry...";
        goto L23
    L21:
        if (r5 != 6) goto L23;
        r10 = "half-close status";
    L6:
        th = move-exception;
        throw th;
    }

    public final void c(Message r10) {
        if (r10 == null) goto L85;
        int r5 = r10.what;
        if (r5 != 1) goto L12;
        if (h() == true) goto L86;
        this.f18283i.removeMessages(1);
        this.f18283i.removeMessages(2);
        f((String) r10.obj);
        return;
    L86:
        return;
    L12:
        if (r5 != 2) goto L26;
        this.f18283i.removeMessages(2);     // Catch: Throwable -> L19
        this.f18283i.removeMessages(1);     // Catch: Throwable -> L19
        p r11 = this.f18280b;     // Catch: Throwable -> L19
        List r12 = (List) r10.obj;     // Catch: Throwable -> L19
        r11.f6304c = r12;     // Catch: Throwable -> L19
        this.g = false;     // Catch: Throwable -> L19
        fn.c r13 = new fn.c(r12, (k8.a) r11.d);     // Catch: Throwable -> L19
        this.f18281c = r13;     // Catch: Throwable -> L19
        monitor-enter(r13);     // Catch: Throwable -> L19
        k8.a r14 = (k8.a) r13.f16949c;     // Catch: Throwable -> L21
        r14.f18625b = 0;     // Catch: Throwable -> L21
        r14.f18626c = 0;     // Catch: Throwable -> L21
        r13.d = null;     // Catch: Throwable -> L21
        r13.f16947a = 0;     // Catch: Throwable -> L21
        monitor-exit(r13);     // Catch: Throwable -> L21
        this.f18283i.removeMessages(1);     // Catch: Throwable -> L19
        f(this.f18281c.f());     // Catch: Throwable -> L19
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L26:
        if (r5 != 3) goto L42;
        this.f18283i.removeMessages(2);
        this.f18283i.removeMessages(1);
        if (h() == true) goto L87;
        a();
        if (f8.b.j(this.f18279a) == true) goto L33;
        Logger.d("WsChannelSdk_ok", "network changed! but the network is not available，do not retry");
        return;
    L33:
        if (g() == false) goto L82;
        fn.c r15 = this.f18281c;
        if (r15 == null) goto L88;
        f(r15.f());
        return;
    L88:
        return;
    L82:
        return;
    L87:
        return;
    L42:
        if (r5 != 5) goto L65;
        if (((Boolean) r10.obj).booleanValue() == false) goto L46;
        AppState r16 = AppState.f3985a;
    L47:
        ug.d r17 = this.f18287m;
        WeakHandler r18 = (WeakHandler) r17.f;
        AtomicBoolean r19 = (AtomicBoolean) r17.f22358c;
        if (r19.get() == false) goto L50;
    L62:
        r17.f22357b = r16;
        this.f18286l.getClass();
        return;
    L50:
        if (((AppState) r17.f22357b) != AppState.f3986b) goto L62;
        if (r16 != AppState.f3985a) goto L62;
        Logger.d("WsChannelSdk_ok", "Switch the foreground in the background, send compensation ping");
    L60:
        e = move-exception;
        e.printStackTrace();
        goto L62
    L55:
        if (((l8.a) r17.d) == null) goto L62;
        r19.set(true);     // Catch: Exception -> L60
        jm.a r20 = (jm.a) r17.g;
        r18.removeCallbacks(r20);     // Catch: Exception -> L60
        r18.postDelayed(r20, 5000);     // Catch: Exception -> L60
        goto L62
    L46:
        r16 = AppState.f3986b;
        goto L47
    L65:
        if (r5 != 7) goto L84;
        this.f18283i.removeMessages(2);     // Catch: Throwable -> L70
        this.f18283i.removeMessages(1);     // Catch: Throwable -> L70
        p r21 = this.f18280b;     // Catch: Throwable -> L70
        List r22 = (List) r10.obj;     // Catch: Throwable -> L70
        r21.f6304c = r22;     // Catch: Throwable -> L70
        this.g = false;     // Catch: Throwable -> L70
        this.f18281c = new fn.c(r22, (k8.a) r21.d);     // Catch: Throwable -> L70
        a();     // Catch: Throwable -> L70
        if (g() == false) goto L72;
        f(this.f18281c.f());     // Catch: Throwable -> L70
        return;
    L72:
        return;
    L70:
        th = move-exception;
        th.printStackTrace();
        return;
    L84:
        return;
    }

    public final void d(String r15) {
        if (this.d != null) goto L5;
        l0 r5 = new l0();
        r5.b(Collections.singletonList(Protocol.HTTP_1_1));
        this.d = new OkHttpClient(r5);
    L5:
        ConcurrentHashMap r10 = this.f18282h;
        boolean r11 = TextUtils.isEmpty(r15);
        Context r12 = this.f18279a;
        String r13 = "";
        if (r11 == true) goto L68;
        if (r10 == null) goto L68;
        String r14 = androidx.room.jarjarred.org.antlr.runtime.a.q(String.valueOf(r10.get(WsConstants.KEY_FPID)), String.valueOf(r10.get(WsConstants.KEY_APP_KEY)), String.valueOf(r10.get(WsConstants.KEY_DEVICE_ID)), WsConstants.SALT);
        int r16 = 0;
        if (TextUtils.isEmpty(r14) == false) goto L95;
    L11:
        String r17 = "";
    L23:
        String r18 = r17.toLowerCase();
        Uri.Builder r19 = Uri.parse(r15).buildUpon();
        Iterator r20 = r10.entrySet().iterator();
    L25:
        if (r20.hasNext() == false) goto L43;
        Map.Entry r21 = (Map.Entry) r20.next();
        if (r21 == null) goto L25;
        if (TextUtils.isEmpty((CharSequence) r21.getKey()) == true) goto L25;
        if (r21.getValue() != null) goto L34;
        String r110 = "";
    L35:
        String r22 = (String) r21.getKey();
        if (com.bytedance.common.utility.b.a(WsConstants.KEY_APP_KEY, r22) == true) goto L25;
        if (com.bytedance.common.utility.b.a(r22, "extra") == true) goto L25;
        if (com.bytedance.common.utility.b.a("app_version", r22) == true) goto L41;
        r19.appendQueryParameter(r22, r110);
        goto L25
    L41:
        r19.appendQueryParameter("version_code", r110);
        goto L25
    L34:
        r110 = r21.getValue().toString();
        goto L35
    L43:
        String r23 = (String) r10.get("extra");
        if (com.bytedance.common.utility.b.b(r23) == true) goto L53;
        String[] r24 = r23.split("&");
        int r25 = r24.length;
        int r26 = 0;
    L46:
        if (r26 >= r25) goto L53;
        String r27 = r24[r26];
        if (TextUtils.isEmpty(r27) == true) goto L52;
        String[] r28 = r27.split("=");
        if (r28.length != 2) goto L52;
        r19.appendQueryParameter(r28[0], Uri.decode(r28[1]));
    L52:
        r26 = r26 + 1;
    L53:
        r19.appendQueryParameter("access_key", r18);
        NetworkUtils$NetworkType r29 = f8.b.a(r12);
        if (r29 != NetworkUtils$NetworkType.f4014a) goto L57;
    L66:
        r19.appendQueryParameter("ne", String.valueOf(r16));
        r13 = r19.build().toString();
        goto L68
    L57:
        if (r29 != NetworkUtils$NetworkType.e) goto L60;
        r16 = 1;
        goto L66
    L60:
        if (r29 != NetworkUtils$NetworkType.f4016c) goto L63;
        r16 = 2;
        goto L66
    L63:
        if (r29 != NetworkUtils$NetworkType.d) goto L65;
        r16 = 3;
        goto L66
    L65:
        r16 = 4;
        goto L66
    L95:
        byte[] r30 = MessageDigest.getInstance("MD5").digest(r14.getBytes());     // Catch: NoSuchAlgorithmException -> L17
        StringBuilder r31 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L17
        int r32 = r30.length;     // Catch: NoSuchAlgorithmException -> L17
        int r111 = 0;
    L13:
        if (r111 >= r32) goto L20;
        String r112 = Integer.toHexString(r30[r111] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L17
        if (r112.length() != 1) goto L19;
        r112 = "0" + r112;     // Catch: NoSuchAlgorithmException -> L17
    L19:
        r31.append(r112);     // Catch: NoSuchAlgorithmException -> L17
        r111 = r111 + 1;     // Catch: NoSuchAlgorithmException -> L17
        goto L13
    L20:
        r17 = r31.toString();     // Catch: NoSuchAlgorithmException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L68:
        if (com.bytedance.common.utility.b.b(r13) == false) goto L71;
        Logger.e("WsChannelSdk_ok", "url is empty,cancel connect");
        return;
    L71:
        l8.a r113 = this.f18285k;
        if (r113 != null) goto L93;
    L75:
        Logger.d("WsChannelSdk_ok", td.d.b("try tu open socket:", r13));
        Request r114 = this.f;
        if (r114 != null) goto L78;
    L79:
        n0 r115 = new n0();
        r115.a("Sec-Websocket-Protocol", "pbbp");
        r115.g(r13);
        this.f = r115.b();
    L80:
        b(1);
        ((c5.a) g.d(r12).f17073b).a(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
        l8.a r33 = new l8.a(this.f, new Random());
        this.f18285k = r33;
        r33.b(this.d);
        this.f18287m.d = this.f18285k;
        com.lynx.animax.player.b r116 = this.f18284j;
        if (r116 == null) goto L118;
        IWsChannelClient r117 = (IWsChannelClient) r116.f9657b;
        if (r117 == null) goto L119;
        JSONObject r118 = new JSONObject();
        r118.put("type", 1);     // Catch: Exception -> L87
        r118.put("state", 1);     // Catch: Exception -> L87
        r118.put("url", r13);     // Catch: Exception -> L87
        r118.put(WsConstants.KEY_CHANNEL_TYPE, 2);     // Catch: Exception -> L87
        r117.onConnection(r118);     // Catch: Exception -> L87
        return;
    L87:
        e = move-exception;
        e.printStackTrace();
        return;
    L119:
        return;
    L118:
        return;
    L78:
        if (r13.equals(r114.url().f20644j) == true) goto L80;
    L93:
        r113.a(1000, "normal close");     // Catch: Throwable -> L90
        goto L75
    }

    public final void e(String r5, int r10, String r11) {
        b(2);
        fn.c r12 = this.f18281c;
        if (r12 == null) goto L11;
        monitor-enter(r12);
        k8.a r13 = (k8.a) r12.f16949c;     // Catch: Throwable -> L8
        r13.f18625b = 0;     // Catch: Throwable -> L8
        r13.f18626c = 0;     // Catch: Throwable -> L8
        r12.d = null;     // Catch: Throwable -> L8
        r12.f16947a = 0;     // Catch: Throwable -> L8
        monitor-exit(r12);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        com.lynx.animax.player.b r14 = this.f18284j;
        if (r14 == null) goto L17;
        r14.h(r5, r10, r11);
        return;
    }

    public final void f(String r5) {
        if (f8.b.j(this.f18279a) == true) goto L6;
        e(r5, 1, "network error");
        return;
    L6:
        monitor-enter(this);
        int r10 = this.e;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        if (r10 == 4) goto L26;
        if (r10 == 1) goto L27;
        d(r5);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        com.lynx.animax.player.b r11 = this.f18284j;
        if (r11 == null) goto L28;
        r11.h(r5, 4, Log.getStackTraceString(th));
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final boolean g() {
        monitor-enter(this);
        int r5 = this.e;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r5 != 3) goto L8;
    L22:
        return true;
    L8:
        if (r5 == 2) goto L22;
        if (r5 == 5) goto L22;
        q8.b r10 = this.f18286l;
        r10.getClass();
        Logger.d("WsChannelSdk_ok", "disconnected，stop to send ping");
        r10.f21493b.removeCallbacks(r10.d);
        r10.f21493b.removeCallbacks(r10.e);
        r10.f21494c.set(false);
        l8.a r11 = this.f18285k;
        if (r11 == null) goto L22;
        Message r12 = this.f18283i.obtainMessage(6, r11);
        this.f18283i.sendMessageDelayed(r12, 1000);
        if (r5 != 4) goto L18;
        this.f18285k.a(1000, "normal close");
        b(6);
        return false;
    L18:
        this.f18285k.d.cancel();
        b(3);
        if (r5 == 1) goto L21;
        return true;
    L21:
        return false;
    L23:
        th = move-exception;
        throw th;
    }

    public final boolean h() {
        monitor-enter(this);
        int r5 = this.e;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r5 != 4) goto L9;
        return true;
    L9:
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public final void i() {
        Request r5 = this.f;
        if (r5 == null) goto L7;
        com.lynx.animax.player.b r10 = this.f18284j;
        if (r10 == null) goto L7;
        r10.h(r5.url().f20644j, 3, "heatbeat timeout");
    L7:
        fn.c r11 = this.f18281c;
        monitor-enter(r11);
        String r12 = r11.f();     // Catch: Throwable -> L41
        k8.a r13 = (k8.a) r11.f16949c;     // Catch: Throwable -> L41
        if (r13.f18626c < 4) goto L79;
    L18:
        long r14 = -1;
    L20:
        if (r14 == (-1)) goto L22;
        r13.f18626c++;     // Catch: Throwable -> L41
    L22:
        if (r14 != (-1)) goto L25;
        r14 = -1;
    L25:
        if (r14 != (-1)) goto L45;
        k8.a r15 = (k8.a) r11.f16949c;     // Catch: Throwable -> L41
        r15.f18625b = 0;     // Catch: Throwable -> L41
        r15.f18626c = 0;     // Catch: Throwable -> L41
        monitor-enter(r11);     // Catch: Throwable -> L41
        int r16 = r11.f16947a + 1;     // Catch: Throwable -> L33
        r11.f16947a = r16;     // Catch: Throwable -> L33
        if (((ArrayList) r11.f16948b).size() <= r16) goto L35;
        r12 = (String) ((ArrayList) r11.f16948b).get(r16);     // Catch: Throwable -> L33
        r11.d = r12;     // Catch: Throwable -> L33
        monitor-exit(r11);     // Catch: Throwable -> L41
    L38:
        if (TextUtils.isEmpty(r12) == true) goto L45;
        ((k8.a) r11.f16949c).getClass();     // Catch: Throwable -> L41
        r14 = (long) ((Math.random() * 4500.0d) + 500.0d);
        goto L45
    L35:
        r12 = "";
        monitor-exit(r11);     // Catch: Throwable -> L41
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L45:
        Pair r17 = new Pair(r12, Long.valueOf(r14));     // Catch: Throwable -> L41
        monitor-exit(r11);
        this.f18283i.removeMessages(2);
        this.f18283i.removeMessages(1);
        this.f18283i.removeMessages(3);
        this.f18283i.removeMessages(5);
        fn.c r18 = this.f18281c;
        if (r18 == null) goto L56;
        monitor-enter(r18);
        k8.a r19 = (k8.a) r18.f16949c;     // Catch: Throwable -> L53
        r19.f18625b = 0;     // Catch: Throwable -> L53
        r19.f18626c = 0;     // Catch: Throwable -> L53
        r18.d = null;     // Catch: Throwable -> L53
        r18.f16947a = 0;     // Catch: Throwable -> L53
        monitor-exit(r18);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L56:
        this.f18283i.removeMessages(1);
        g();
        l8.a r20 = this.f18285k;
        if (r20 != null) goto L76;
    L60:
        String r21 = (String) r17.first;
        WeakHandler r22 = this.f18283i;
        r22.removeMessages(1);
        if (f8.b.j(this.f18279a) == true) goto L64;
        e(r21, 1, "network error");
        Logger.d("WsChannelSdk_ok", "network not available，cancel retry");
        return;
    L64:
        if (this.g == false) goto L67;
        Logger.d("WsChannelSdk_ok", "close manually");
        return;
    L67:
        if (com.bytedance.common.utility.b.b(r21) == false) goto L69;
        Logger.d("WsChannelSdk_ok", "retry finished ---> interval: 0 , url :" + r21);
        Logger.d("WsChannelSdk_ok", "retry finished，waiting the next time to reconnect");
        Bundle r23 = new Bundle();
        r23.putString("method", "tryReconnect");
        r23.putLong("interval", 0);
        e(r21, 2, "retry failed");
        r21 = this.f18281c.f();
    L70:
        StringBuilder r24 = new StringBuilder("the next time to reconnect is ");
        r24.append(DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis())));
        Logger.d("WsChannelSdk_ok", r24.toString());
        Message r25 = new Message();
        r25.what = 1;
        r25.obj = r21;
        r22.sendMessageDelayed(r25, 0);
        return;
    L69:
        b(5);
        goto L70
    L76:
        r20.a(1000, "normal close");     // Catch: Throwable -> L74
        goto L60
    L79:
        NetworkInfo r26 = ((ConnectivityManager) ((Context) r13.d).getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L75 Throwable -> L41
        if (r26 == null) goto L18;
        if (r26.isAvailable() == false) goto L18;
        int r27 = r13.f18625b + 1;     // Catch: Throwable -> L41
        r13.f18625b = r27;     // Catch: Throwable -> L41
        r14 = (long) j0.B(Math.random(), 10.0d, 1000.0d, Math.min(((long) (1 << r27)) * 5000, 120000));
    L41:
        th = move-exception;
        throw th;
    }
}
