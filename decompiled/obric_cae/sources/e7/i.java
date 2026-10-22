package e7;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f7194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHandler f7195d;

    public i(String r8, d r10, WeakHandler r11) {
        this.f7192a = i.class.getSimpleName();
        this.f7193b = r8;
        this.f7194c = r10;
        this.f7195d = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Void call() {
        d r8 = this.f7194c;
        String r10 = this.f7192a;
        String r11 = this.f7193b;
        long r12 = System.currentTimeMillis();
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        InetAddress[] r15 = InetAddress.getAllByName(r11);     // Catch: UnknownHostException -> L19
        int r16 = r15.length;     // Catch: UnknownHostException -> L19
        int r17 = 0;
    L4:
        if (r17 >= r16) goto L13;
        InetAddress r18 = r15[r17];     // Catch: UnknownHostException -> L19
        if ((r18 instanceof Inet4Address) == false) goto L9;
        r13.add(r18.getHostAddress());     // Catch: UnknownHostException -> L19
    L12:
        r17 = r17 + 1;     // Catch: UnknownHostException -> L19
        goto L4
    L9:
        if ((r18 instanceof Inet6Address) == false) goto L11;
        r14.add(r18.getHostAddress());     // Catch: UnknownHostException -> L19
        goto L12
    L11:
        Logger.d(r10, "local dns server returned a invalid address: " + r18.getHostAddress());     // Catch: UnknownHostException -> L19
        goto L12
    L13:
        Logger.d(r10, "local dns resolved success for host: " + r11);     // Catch: UnknownHostException -> L19
        if (r13.size() <= 0) goto L16;
    L17:
        r8.c(r11, new a(this.f7193b, System.currentTimeMillis(), r13, r14, e.g().f7174q.get()));     // Catch: UnknownHostException -> L19
    L22:
        if (e.g().f7169b.get() == true) goto L35;
        Message r19 = Message.obtain();
        r19.obj = this;
        r19.what = 1;
        Bundle r20 = new Bundle();
        r20.putString("localdns_completed_host", r11);
        r19.setData(r20);
        this.f7195d.sendMessage(r19);
        Logger.d(r10, "send message to collect result handler for host : " + r11);
        long r21 = System.currentTimeMillis() - r12;
        JSONObject r110 = new JSONObject();     // Catch: JSONException -> L33
        r110.put("host", r11);     // Catch: JSONException -> L33
        if (r13.size() == 0) goto L28;
    L30:
        r110.put("status", "succeed");     // Catch: JSONException -> L33
        ArrayList r22 = new ArrayList();     // Catch: JSONException -> L33
        r22.addAll(r14);     // Catch: JSONException -> L33
        r22.addAll(r13);     // Catch: JSONException -> L33
        Object r23 = r22;
    L31:
        r110.put("result", r23);     // Catch: JSONException -> L33
        r110.put("rtt", r21);     // Catch: JSONException -> L33
        Logger.d(r10, r110.toString());     // Catch: JSONException -> L33
        goto L35
    L28:
        if (r14.size() != 0) goto L30;
        r110.put("status", "failed");     // Catch: JSONException -> L33
        r23 = "";
    L33:
        e = move-exception;
        e.printStackTrace();
    L35:
        r8.s(r11);
        return null;
    L16:
        if (r14.size() <= 0) goto L22;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }
}
