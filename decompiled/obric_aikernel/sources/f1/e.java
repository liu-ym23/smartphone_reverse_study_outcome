package f1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
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
public final class e extends Thread implements Handler.Callback {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static f1.a<e> f8791i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<d>> f8792c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinkedList<c> f8793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f8794h;

    static class a extends f1.a<e> {
        a() {
        }

        @Override // f1.a
        protected /* bridge */ /* synthetic */ e a(Object[] r10) {
            return c(r10);
        }

        protected e c(Object... r10) {
            return new e();
        }
    }

    public interface b {
        Object a();
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f8796b;

        c(String r10, Object r11) {
            this.f8795a = r10;
            this.f8796b = r11;
        }
    }

    public interface d {
        void a(Object r10);
    }

    static {
        f8791i = new a();
    }

    public e() {
        this.f8792c = new ConcurrentHashMap();
        this.f8793g = new LinkedList();
        start();
    }

    private void a(c r10) {
        LinkedList<c> r11 = this.f8793g;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f8793g.size() < 100) goto L7;
        this.f8793g.poll();     // Catch: Throwable -> L10
    L7:
        this.f8793g.add(r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
    }

    private void b(c r10) {
        Handler r11 = this.f8794h;
        if (r11 == null) goto L5;
        r11.sendMessage(r11.obtainMessage(1, r10));
        return;
    L5:
        e(r10);
    }

    private void e(c r10) {
        List<d> r11 = this.f8792c.get(r10.f8795a);
        if (r11 != null) goto L5;
        return;
    L5:
        HashSet r12 = new HashSet();
        byte[] r13 = null;
    L40:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if ("applog_event_upload_eid".equals(r10.f8795a) == false) goto L17;
        Object r14 = r10.f8796b;     // Catch: Throwable -> L40
        if ((r14 instanceof JSONObject) == false) goto L17;
        if (((JSONObject) r14).has("$$EVENT_LOCAL_IDS") == false) goto L17;
        Object r15 = ((JSONObject) r10.f8796b).opt("$$EVENT_LOCAL_IDS");     // Catch: Throwable -> L40
        if ((r15 instanceof Collection) == false) goto L25;
        r12.addAll((Collection) r15);     // Catch: Throwable -> L40
    L25:
        Iterator<d> r16 = r11.iterator();     // Catch: Throwable -> L40
    L26:
        if (r16.hasNext() == false) goto L53;
        d r17 = r16.next();     // Catch: Throwable -> L40
        Object r18 = r10.f8796b;     // Catch: Throwable -> L40
        if ((r18 instanceof JSONObject) == false) goto L38;
        JSONObject r19 = new JSONObject(r10.f8796b.toString());     // Catch: JSONException -> L37 Throwable -> L40
    L31:
        if (r12.isEmpty() == true) goto L33;
        r19.put("$$EVENT_LOCAL_IDS", r12);     // Catch: JSONException -> L37 Throwable -> L40
    L33:
        if (r13 == null) goto L35;
        r19.put("responseByte", r13);     // Catch: JSONException -> L37 Throwable -> L40
    L35:
        r17.a(r19);     // Catch: JSONException -> L37 Throwable -> L40
    L37:
        r18 = r10.f8796b;     // Catch: Throwable -> L40
    L38:
        r17.a(r18);     // Catch: Throwable -> L40
        goto L26
    L53:
        return;
    L17:
        if ("applog_do_request_end".equals(r10.f8795a) == false) goto L25;
        Object r20 = r10.f8796b;     // Catch: Throwable -> L40
        if ((r20 instanceof JSONObject) == false) goto L25;
        if (((JSONObject) r20).has("responseByte") == false) goto L25;
        Object r21 = ((JSONObject) r10.f8796b).opt("responseByte");     // Catch: Throwable -> L40
        if ((r21 instanceof byte[]) == false) goto L25;
        r13 = (byte[]) ((byte[]) r21).clone();     // Catch: Throwable -> L40
        goto L25
    }

    public void c(String r10, b r11) {
        if (TextUtils.isEmpty(r10) == true) goto L11;
        if (r11 == null) goto L13;
        c r12 = new c(r10, r11.a());
        if (this.f8792c.containsKey(r10) == true) goto L9;
        a(r12);
        return;
    L9:
        b(r12);
        return;
    L13:
        return;
    }

    public void d(String r10, Object r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        c r12 = new c(r10, r11);
        if (this.f8792c.containsKey(r10) == true) goto L8;
        a(r12);
        return;
    L8:
        b(r12);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        if (r10.what != 1) goto L5;
        e((c) r10.obj);
    L5:
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        Looper.prepare();
        this.f8794h = new Handler(this);
        Looper.loop();
    }
}
