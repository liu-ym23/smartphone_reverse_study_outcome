package m7;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.BwdlDropActionFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import l7.f;
import l7.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile c f9292e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f9293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f9294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f9295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f9296d;

    public class a implements Comparator<b> {
        @Override // java.util.Comparator
        public final int compare(b r8, b r10) {
            return r8.f9286a - r10.f9286a;
        }
    }

    public c() {
        this.f9294b = false;
        this.f9295c = new CopyOnWriteArrayList();
        this.f9296d = new CopyOnWriteArrayList();
    }

    public static c c() {
        if (f9292e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9292e != null) goto L9;
        f9292e = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f9292e;
    }

    public static void e(JSONObject r8, ArrayList r10) {
        String r11 = r8.getString(BwdlDropActionFrame.HEADER);
        int r12 = r8.getInt("act_priority");
        if (r12 >= 0) goto L5;
        return;
    L5:
        JSONObject r13 = r8.getJSONObject("param");
        int r14 = r8.optInt("set_req_priority", r12);
        if (r14 != (-1)) goto L8;
        r14 = Integer.MAX_VALUE;
    L8:
        int r15 = b.f9285g;
        if (r11.equals("rm") == false) goto L28;
        d r16 = new d(r12);
        b.c(r13.optJSONArray("host_group"), r16.f9288c);
        b.c(r13.optJSONArray("equal_group"), r16.f9289d);
        b.c(r13.optJSONArray("prefix_group"), r16.f9290e);
        JSONArray r17 = r13.optJSONArray("pattern_group");
        HashSet r18 = r16.f9291f;
        if (r17 == null) goto L22;
        if (r18 == null) goto L22;
        int r19 = 0;
    L36:
        if (r19 >= r17.length()) goto L22;
        String r20 = r17.getString(r19);     // Catch: JSONException -> L33
        if (TextUtils.isEmpty(r20) == true) goto L21;
        r18.add(Pattern.compile(r20, 2));     // Catch: Throwable -> L32
    L21:
        r19 = r19 + 1;
    L22:
        JSONArray r21 = r13.optJSONArray("keep_list");
        ArrayList r22 = r16.f9297h;
        d.d(r21, r22);
        JSONArray r23 = r13.optJSONArray("remove_list");
        ArrayList r24 = r16.f9298i;
        d.d(r23, r24);
        if (r22.isEmpty() == false) goto L25;
    L27:
        r16.f9287b = r14;
    L29:
        if (r16 == null) goto L41;
        r10.add(r16);
        return;
    L41:
        return;
    L25:
        if (r24.isEmpty() == true) goto L27;
        r16.f9299j = true;
        goto L27
    L28:
        r16 = null;
        goto L29
    }

    public final boolean a(Request r12, LinkedHashMap r13) {
        ArrayList r8 = new ArrayList();
        r12.setQueryFilterPriority(0);
        Iterator r11 = this.f9295c.iterator();
        boolean r10 = false;
    L4:
        if (r11.hasNext() == false) goto L17;
        b r14 = (b) r11.next();
        r14.getClass();
        m7.a r15 = new m7.a();
        r15.f9283c = SystemClock.uptimeMillis();
        int r16 = r12.getQueryFilterPriority();
        int r17 = r14.f9286a;
        if (r16 <= r17) goto L8;
        boolean r18 = false;
    L9:
        if (r18 == true) goto L11;
        boolean r19 = false;
    L12:
        if (r19 == false) goto L14;
        r12.setQueryFilterPriority(r14.f9287b);
    L14:
        r15.f9281a = r19;
        r15.f9282b = r17;
        r15.f9284d = SystemClock.uptimeMillis();
        r8.add(r15);
        if (r19 == false) goto L4;
        r10 = true;
        goto L4
    L11:
        r19 = r14.a(r12, r13);
        goto L12
    L8:
        r18 = true;
        goto L9
    L17:
        Logger.d("c", "dispatchQueryMap hit: " + r10);
        if (r12.getMetrics() == null) goto L37;
        RetrofitMetrics r110 = r12.getMetrics();
        JSONArray r111 = new JSONArray();
        Iterator r20 = r8.iterator();
    L21:
        if (r20.hasNext() == false) goto L36;
        m7.a r21 = (m7.a) r20.next();
        JSONObject r22 = new JSONObject();     // Catch: JSONException -> L34
        r22.put("hit", r21.f9281a);     // Catch: JSONException -> L34
        r22.put("priority", r21.f9282b);     // Catch: JSONException -> L34
        long r23 = r21.f9283c;     // Catch: JSONException -> L34
        if (r23 < 0) goto L31;
        long r24 = r21.f9284d;     // Catch: JSONException -> L34
        if (r24 < 0) goto L31;
        if (r23 > r24) goto L31;
        long r25 = r24 - r23;     // Catch: JSONException -> L34
    L32:
        r22.put("consume", r25);     // Catch: JSONException -> L34
        r111.put(r22);     // Catch: JSONException -> L34
    L31:
        r25 = -1;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L36:
        Logger.d("c", "action info: " + r111.toString());
        r110.dispatchQueryActionInfo = r111;
    L37:
        return r10;
    }

    public final Request b(Request r8) {
        if (this.f9294b == true) goto L6;
        Logger.d("c", "Query filter engine is not enabled");
        return null;
    L6:
        String r10 = r8.getUrl();
        if (TextUtils.isEmpty(r10) == false) goto L39;
        return null;
    L39:
        LinkedHashMap r11 = new LinkedHashMap();     // Catch: Throwable -> L36
        Pair r12 = g.d(r10, r11);     // Catch: Throwable -> L36
        if (r11.isEmpty() == false) goto L13;
        return null;
    L13:
        if (a(r8, r11) == true) goto L15;
        return null;
    L15:
        f r13 = new f(((String) r12.first) + ((String) r12.second));     // Catch: Throwable -> L36
        if (r11.isEmpty() == true) goto L34;
        Iterator r14 = r11.entrySet().iterator();     // Catch: Throwable -> L36
    L19:
        if (r14.hasNext() == false) goto L34;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L36
        if (r15 == null) goto L19;
        if (r15.getKey() == null) goto L19;
        List r16 = (List) r15.getValue();     // Catch: Throwable -> L36
        if (r16 == null) goto L19;
        if (r16.isEmpty() == true) goto L19;
        Iterator r17 = r16.iterator();     // Catch: Throwable -> L36
    L32:
        if (r17.hasNext() == false) goto L19;
        r13.b((String) r15.getKey(), (String) r17.next());     // Catch: Throwable -> L36
    L34:
        Request.Builder r18 = r8.newBuilder();     // Catch: Throwable -> L36
        r18.url(r13.c());     // Catch: Throwable -> L36
        return r18.build();
    L36:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public final void d(String r8) {
        StringBuilder r10 = defpackage.b.h("onNetConfigChanged config: ", r8, " enabled: ");
        r10.append(this.f9294b);
        Logger.d("c", r10.toString());
        if (this.f9294b == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r8) == true) goto L15;
        f(r8);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public final synchronized void f(String r8) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(this.f9293a) == false) goto L6;
    L10:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L17
        JSONArray r11 = new JSONArray(r8);     // Catch: Throwable -> L17
        int r12 = 0;
    L12:
        if (r12 >= r11.length()) goto L14;
        e(r11.getJSONObject(r12), r10);     // Catch: Throwable -> L17
        r12 = r12 + 1;     // Catch: Throwable -> L17
        goto L12
    L14:
        Collections.sort(r10, new a());     // Catch: Throwable -> L17
        this.f9295c.clear();     // Catch: Throwable -> L17
        this.f9295c.addAll(r10);     // Catch: Throwable -> L17
        this.f9293a = r8;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L6:
        if (this.f9293a.equals(r8) == false) goto L10;
        Logger.d("c", "Config is same with local config, do not parse.");     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public final void g(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        CopyOnWriteArrayList r10 = this.f9296d;
        r10.clear();
        JSONArray r11 = new JSONArray(r8);     // Catch: JSONException -> L11
        int r12 = 0;
    L8:
        if (r12 >= r11.length()) goto L17;
        r10.add(r11.getString(r12));     // Catch: JSONException -> L11
        r12 = r12 + 1;
        goto L8
    L17:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }
}
