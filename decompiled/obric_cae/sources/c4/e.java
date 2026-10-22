package c4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e extends Thread implements Handler.Callback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f3331o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f3332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3333b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedList<c> f3334m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Handler f3335n;

    public static class a extends c4.b {
        public a() {
            super(0);
        }

        @Override // c4.b
        public final Object a(Object[] r8) {
            return new e();
        }
    }

    public interface b {
        JSONObject a();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f3337b;

        public c(Object r8, String r10) {
            this.f3336a = r10;
            this.f3337b = r8;
        }
    }

    public interface d {
        void a();
    }

    static {
        f3331o = new a();
    }

    public e() {
        this.f3332a = new ConcurrentHashMap();
        this.f3333b = 1000;
        this.f3334m = new LinkedList();
        start();
    }

    public final void a(Object r8, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        c r11 = new c(r8, r10);
        if (this.f3332a.containsKey(r10) == true) goto L18;
        LinkedList<c> r12 = this.f3334m;
        monitor-enter(r12);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.f3334m.size() < this.f3333b) goto L12;
        this.f3334m.poll();     // Catch: Throwable -> L15
    L12:
        this.f3334m.add(r11);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L18:
        Handler r13 = this.f3335n;
        if (r13 == null) goto L21;
        r13.sendMessage(r13.obtainMessage(1, r11));
        return;
    L21:
        c(r11);
    }

    public final void b(String r8, b r10) {
        if (TextUtils.isEmpty(r8) == true) goto L24;
        c r11 = new c(r10.a(), r8);
        if (this.f3332a.containsKey(r8) == true) goto L17;
        LinkedList<c> r12 = this.f3334m;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (this.f3334m.size() < this.f3333b) goto L11;
        this.f3334m.poll();     // Catch: Throwable -> L14
    L11:
        this.f3334m.add(r11);     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
        return;
    L17:
        Handler r13 = this.f3335n;
        if (r13 == null) goto L20;
        r13.sendMessage(r13.obtainMessage(1, r11));
        return;
    L20:
        c(r11);
        return;
    }

    public final void c(c r8) {
        ConcurrentHashMap r10 = this.f3332a;
        String r11 = r8.f3336a;
        List r12 = (List) r10.get(r11);
        if (r12 != null) goto L5;
        return;
    L5:
        HashSet r13 = new HashSet();
        boolean r14 = "applog_event_upload_eid".equals(r11);     // Catch: Throwable -> L40
        Object r15 = r8.f3337b;
        if (r14 == false) goto L17;
        if ((r15 instanceof JSONObject) == false) goto L17;
        if (((JSONObject) r15).has("$$EVENT_LOCAL_IDS") == false) goto L17;
        Object r16 = ((JSONObject) r15).opt("$$EVENT_LOCAL_IDS");     // Catch: Throwable -> L40
        if ((r16 instanceof Collection) == false) goto L25;
        r13.addAll((Collection) r16);     // Catch: Throwable -> L40
    L25:
        byte[] r17 = null;
    L26:
        Iterator r18 = r12.iterator();     // Catch: Throwable -> L40
    L27:
        if (r18.hasNext() == false) goto L54;
        d r19 = (d) r18.next();     // Catch: Throwable -> L40
        if ((r15 instanceof JSONObject) == false) goto L38;
        JSONObject r20 = new JSONObject(r15.toString());     // Catch: JSONException -> L43 Throwable -> L40
        if (r13.isEmpty() == true) goto L34;
        r20.put("$$EVENT_LOCAL_IDS", r13);     // Catch: JSONException -> L43 Throwable -> L40
    L34:
        if (r17 == null) goto L36;
        r20.put("responseByte", r17);     // Catch: JSONException -> L43 Throwable -> L40
    L36:
        r19.a();     // Catch: JSONException -> L43 Throwable -> L40
    L38:
        r19.a();     // Catch: Throwable -> L40
        goto L27
    L54:
        return;
    L17:
        if ("applog_do_request_end".equals(r11) == false) goto L25;
        if ((r15 instanceof JSONObject) == false) goto L25;
        if (((JSONObject) r15).has("responseByte") == false) goto L25;
        Object r21 = ((JSONObject) r15).opt("responseByte");     // Catch: Throwable -> L40
        if ((r21 instanceof byte[]) == false) goto L25;
        r17 = (byte[]) ((byte[]) r21).clone();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        if (r8.what != 1) goto L5;
        c((c) r8.obj);
    L5:
        return true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        Looper.prepare();
        this.f3335n = new Handler(this);
        Looper.loop();
    }
}
