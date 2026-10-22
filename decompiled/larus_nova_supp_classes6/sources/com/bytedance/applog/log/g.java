package com.bytedance.applog.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class g extends PthreadThreadV2 implements Handler.Callback {
    public static final a z = null;
    public final Map<String, List<d>> v;
    public final int w;
    public final LinkedList<c> x;
    public Handler y;

    public static class a extends b<g> {
        public a() {
        }

        public final Object a(Object[] r1) {
            return new g();
        }
    }

    static {
        z = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g() {
        super("/log/EventBus");
        this.v = new ConcurrentHashMap();
        this.w = 1000;
        this.x = new LinkedList();
        ThreadMethodProxy.start(this);
    }

    public final void run() {
        super.run();     // Catch: Throwable -> L4
        Looper.prepare();     // Catch: Throwable -> L4
        this.y = new Handler(this);     // Catch: Throwable -> L4
        Looper.loop();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void f(c r9) {
        Map<String, List<d>> r0 = this.v;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        List r2 = (List) r1.get(r9.a);
        if (r2 != null) goto L5;
        return;
    L5:
        HashSet r3 = new HashSet();
    L41:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if ("applog_event_upload_eid".equals(r9.a) == false) goto L17;
        Object r4 = r9.b;     // Catch: Throwable -> L41
        if ((r4 instanceof JSONObject) == false) goto L17;
        if (((JSONObject) r4).has("$$EVENT_LOCAL_IDS") == false) goto L17;
        Object r5 = ((JSONObject) r9.b).opt("$$EVENT_LOCAL_IDS");     // Catch: Throwable -> L41
        if ((r5 instanceof Collection) == false) goto L25;
        r3.addAll((Collection) r5);     // Catch: Throwable -> L41
    L25:
        byte[] r6 = null;
    L26:
        Iterator r7 = r2.iterator();     // Catch: Throwable -> L41
    L27:
        if (r7.hasNext() == false) goto L55;
        d r8 = (d) r7.next();     // Catch: Throwable -> L41
        if ((r9.b instanceof JSONObject) == false) goto L39;
        JSONObject r10 = new JSONObject(r9.b.toString());     // Catch: JSONException -> L38 Throwable -> L41
    L32:
        if (r3.isEmpty() == true) goto L34;
        r10.put("$$EVENT_LOCAL_IDS", r3);     // Catch: JSONException -> L38 Throwable -> L41
    L34:
        if (r6 == null) goto L36;
        r10.put("responseByte", r6);     // Catch: JSONException -> L38 Throwable -> L41
    L36:
        r8.a();     // Catch: JSONException -> L38 Throwable -> L41
    L38:
        r8.a();     // Catch: Throwable -> L41
        goto L27
    L39:
        r8.a();     // Catch: Throwable -> L41
        goto L27
    L55:
        return;
    L17:
        if ("applog_do_request_end".equals(r9.a) == false) goto L25;
        Object r11 = r9.b;     // Catch: Throwable -> L41
        if ((r11 instanceof JSONObject) == false) goto L25;
        if (((JSONObject) r11).has("responseByte") == false) goto L25;
        Object r12 = ((JSONObject) r9.b).opt("responseByte");     // Catch: Throwable -> L41
        if ((r12 instanceof byte[]) == false) goto L25;
        r6 = (byte[]) ((byte[]) r12).clone();     // Catch: Throwable -> L41
        goto L26
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r3) {
        if (r3.what != 1) goto L5;
        f((c) r3.obj);
    L5:
        return true;
    }

    public final void a(String r3, b r4) {
        if (TextUtils.isEmpty(r3) == true) goto L24;
        c r0 = new c(r3, r4.fetch());
        if (((ConcurrentHashMap) this.v).containsKey(r3) == true) goto L17;
        LinkedList<c> r5 = this.x;
        monitor-enter(r5);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.x.size() < this.w) goto L11;
        this.x.poll();     // Catch: Throwable -> L14
    L11:
        this.x.add(r0);     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        return;
    L17:
        Handler r6 = this.y;
        if (r6 == null) goto L20;
        r6.sendMessage(r6.obtainMessage(1, r0));
        return;
    L20:
        f(r0);
        return;
    }

    public final void e(String r3, Object r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        c r0 = new c(r3, r4);
        if (((ConcurrentHashMap) this.v).containsKey(r3) == true) goto L18;
        LinkedList<c> r5 = this.x;
        monitor-enter(r5);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.x.size() < this.w) goto L12;
        this.x.poll();     // Catch: Throwable -> L15
    L12:
        this.x.add(r0);     // Catch: Throwable -> L15
        monitor-exit(r5);     // Catch: Throwable -> L15
        return;
    L18:
        Handler r6 = this.y;
        if (r6 == null) goto L21;
        r6.sendMessage(r6.obtainMessage(1, r0));
        return;
    L21:
        f(r0);
    }
}
