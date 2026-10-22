package com.bytedance.applog.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g extends Thread implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.applog.log.b<g> f1630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, List<c>> f1631b;
    private int c;
    private final LinkedList<b> d;
    private Handler e;

    public interface a {
        Object a();
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f1632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f1633b;

        b(String r1, Object r2) {
            this.f1632a = r1;
            this.f1633b = r2;
        }
    }

    public interface c {
        void a(Object r1);
    }

    static {
        f1630a = new AnonymousClass1();
    }

    public g() {
        this.f1631b = new ConcurrentHashMap();
        this.c = 1000;
        this.d = new LinkedList();
        start();
    }

    private void a(b r2) {
        Handler r0 = this.e;
        if (r0 == null) goto L5;
        r0.sendMessage(r0.obtainMessage(1, r2));
        return;
    L5:
        b(r2);
    }

    private void b(b r9) {
        List r8 = (List) ZeusTransformUtils.preCheckCast(this.f1631b.get(r9.f1632a), List.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        HashSet r1 = new HashSet();
        byte[] r3 = null;
    L41:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if ("applog_event_upload_eid".equals(r9.f1632a) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r9.f1633b, JSONObject.class) == false) goto L17;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r9.f1633b, JSONObject.class, "com.obric.memorydata.plugin")).has("$$EVENT_LOCAL_IDS") == false) goto L17;
        Object r0 = ((JSONObject) ZeusTransformUtils.preCheckCast(r9.f1633b, JSONObject.class, "com.obric.memorydata.plugin")).opt("$$EVENT_LOCAL_IDS");     // Catch: Throwable -> L41
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == false) goto L25;
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L41
    L25:
        Iterator r10 = r8.iterator();     // Catch: Throwable -> L41
    L26:
        if (r10.hasNext() == false) goto L54;
        c r2 = (c) ZeusTransformUtils.preCheckCast(r10.next(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        if (ZeusTransformUtils.instanceOf(r9.f1633b, JSONObject.class) == false) goto L39;
        JSONObject r4 = new JSONObject(r9.f1633b.toString());     // Catch: JSONException -> L37 Throwable -> L41
    L31:
        if (r1.isEmpty() == true) goto L33;
        r4.put("$$EVENT_LOCAL_IDS", r1);     // Catch: JSONException -> L37 Throwable -> L41
    L33:
        if (r3 == null) goto L35;
        r4.put("responseByte", r3);     // Catch: JSONException -> L37 Throwable -> L41
    L35:
        r2.a(r4);     // Catch: JSONException -> L37 Throwable -> L41
    L37:
        Object r5 = r9.f1633b;     // Catch: Throwable -> L41
    L38:
        r2.a(r5);     // Catch: Throwable -> L41
        goto L26
    L39:
        r5 = r9.f1633b;     // Catch: Throwable -> L41
        goto L38
    L54:
        return;
    L17:
        if ("applog_do_request_end".equals(r9.f1632a) == false) goto L25;
        if (ZeusTransformUtils.instanceOf(r9.f1633b, JSONObject.class) == false) goto L25;
        if (((JSONObject) ZeusTransformUtils.preCheckCast(r9.f1633b, JSONObject.class, "com.obric.memorydata.plugin")).has("responseByte") == false) goto L25;
        Object r6 = ((JSONObject) ZeusTransformUtils.preCheckCast(r9.f1633b, JSONObject.class, "com.obric.memorydata.plugin")).opt("responseByte");     // Catch: Throwable -> L41
        if ((r6 instanceof byte[]) == false) goto L25;
        r3 = (byte[]) ZeusTransformUtils.preCheckCast(((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r6, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")).clone(), byte[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        goto L25
    }

    private void c(b r4) {
        LinkedList<b> r0 = this.d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.d.size() < this.c) goto L7;
        this.d.poll();     // Catch: Throwable -> L10
    L7:
        this.d.add(r4);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public void a(String r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L11;
        if (r5 == null) goto L13;
        b r0 = new b(r3, r5.a());
        if (this.f1631b.containsKey(r3) == true) goto L9;
        c(r0);
        return;
    L9:
        a(r0);
        return;
    L13:
        return;
    }

    public void a(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        b r0 = new b(r2, r3);
        if (this.f1631b.containsKey(r2) == true) goto L8;
        c(r0);
        return;
    L8:
        a(r0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r4) {
        if (r4.what != 1) goto L5;
        b((b) ZeusTransformUtils.preCheckCast(r4.obj, b.class, "com.obric.memorydata.plugin"));
    L5:
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.e = new Handler(this);
        Looper.loop();
    }
}
