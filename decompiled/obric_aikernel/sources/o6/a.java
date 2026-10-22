package o6;

import androidx.work.WorkRequest;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.NetworkUtils;
import e0.e;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f11500a;

    static {
        f11500a = new ConcurrentHashMap();
    }

    public a() {
    }

    private boolean c(n6.a r10) {
        String r11 = r10.b();
        if (f11500a.containsKey(r11) == false) goto L8;
        long r12 = f11500a.get(r11).longValue();
        if ((System.currentTimeMillis() - r12) >= WorkRequest.MIN_BACKOFF_MILLIS) goto L8;
        return false;
    L8:
        f11500a.put(r11, Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    private void h(n6.a r10) {
        w6.b r11 = new w6.b(0, false, r10.b(), null);
        r11.h(3);
        r11.i("当前云控指令已被sdk禁用");
        u6.a.d(r11);
    }

    @Override // o6.b
    public synchronized boolean b(n6.a r10) {
        monitor-enter(this);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (f().equals(r10.e()) == true) goto L36;
        monitor-exit(this);
        return false;
    L36:
    L28:
        e = move-exception;
        k(e.getMessage(), r10);     // Catch: Throwable -> L32
        return false;
    L24:
        e = move-exception;
        k(String.format("系统错误：%s", new Object[]{com.monitor.cloudmessage.utils.a.a(e)}), r10);     // Catch: Throwable -> L32
        return false;
    L10:
        if (i() == false) goto L15;
        h(r10);     // Catch: Exception -> L24 CloudMessageException -> L28 Throwable -> L32
        monitor-exit(this);
        return true;
    L15:
        if (c(r10) == true) goto L17;
    L21:
        e.b("cloudmessage", new String[]{"checkCmdInterval false: ignored for now."});     // Catch: Exception -> L24 CloudMessageException -> L28 Throwable -> L32
        monitor-exit(this);
        return false;
    L17:
        if (d(r10) == false) goto L21;
        e.b("cloudmessage", new String[]{"start handle message:" + r10});     // Catch: Exception -> L24 CloudMessageException -> L28 Throwable -> L32
        boolean r11 = g(r10);     // Catch: Exception -> L24 CloudMessageException -> L28 Throwable -> L32
        monitor-exit(this);
        return r11;
    }

    protected boolean d(n6.a r10) {
        if (t6.b.b().d(r10.b()) == true) goto L5;
        return true;
    L5:
        if (NetworkUtils.l(k6.a.k().i()) == true) goto L10;
        t6.a.c("产物超过阈值，等待WiFi环境执行", r10);
        return false;
    L10:
        return true;
    }

    protected boolean e(JSONObject r10, n6.a r11) {
        if (r10.optBoolean("wifiOnly", false) == true) goto L5;
    L8:
        return false;
    L5:
        if (NetworkUtils.l(k6.a.k().i()) == true) goto L8;
        w6.b r12 = new w6.b(0, false, r11.b(), null);
        r12.h(0);
        r12.i("4G环境下不执行指令");
        u6.a.d(r12);
        return true;
    }

    public abstract String f();

    public abstract boolean g(n6.a r10);

    protected boolean i() {
        if (k6.a.g() == null) goto L11;
        String[] r10 = k6.a.g();
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        if (f().equals(r10[r12]) == true) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    protected void j(String r10, HashMap<String, String> r11, n6.a r12) {
        w6.b r13 = new w6.b(0, false, r12.b(), r11);
        r13.h(3);
        r13.i(r10);
        u6.a.d(r13);
    }

    protected void k(String r10, n6.a r11) {
        w6.b r12 = new w6.b(0, false, r11.b(), null);
        r12.h(3);
        r12.i(r10);
        u6.a.d(r12);
    }

    protected void l(n6.a r10) {
        w6.b r11 = new w6.b(0, false, r10.b(), null);
        r11.h(2);
        u6.a.d(r11);
    }
}
