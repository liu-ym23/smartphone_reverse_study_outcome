package h6;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.anniex.base.service.f;
import com.bytedance.apm.j;
import com.bytedance.salamander.anniex.b0;
import com.lynx.tasm.ui.image.h;
import com.lynx.tasm.ui.image.v;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;
import z6.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements pj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f17283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f17284b;

    public a() {
        this.f17283a = new LinkedList();
    }

    public static void h(String r5, String r10, JSONObject r11, boolean r12, boolean r13) {
        if (j.f3887a == false) goto L5;
        Log.d("BaseDataPipeline", f.o(new String[]{"type:" + r5 + " isSaveUnSampleLog:" + r13 + "isSampled:" + r12 + " log:" + r11}));
    L5:
        if (r12 == false) goto L29;
        JSONArray r14 = null;
        if (r11 != null) goto L60;
        JSONObject r15 = null;
    L13:
        if (TextUtils.equals(r5, "tracing") == false) goto L25;
        if ("batch_tracing".equals(r10) == false) goto L23;
        if (r15 == null) goto L22;
        JSONArray r16 = r15.optJSONArray("wrapper_array_data");
        if (r16 == null) goto L22;
        r14 = r16;
    L22:
        j7.a r17 = new j7.a(2);
        r17.f18266b = r14;
        h7.a.c(r17);
    L32:
        if (r6.a.f21694b == null) goto L34;
    L44:
        r6.a r18 = r6.a.f21694b;
        r18.getClass();
        boolean r19 = j.f3887a;
        CopyOnWriteArraySet r20 = (CopyOnWriteArraySet) r18.f21695a;
        if (r19 == false) goto L48;
        io.reactivex.exceptions.a.m("LogObserver", "logObserverList:" + r20.size());
    L48:
        if (r20.size() == 0) goto L52;
        z6.b.f23409a.e(new jm.a(r18, r5, r10, r11));
    L52:
        if (TextUtils.equals(r5, "ui_action") == false) goto L62;
        al.a r21 = (al.a) k6.a.j().f18623a;
        LinkedList r22 = (LinkedList) r21.f314b;
        if (r22.size() <= r21.f313a) goto L56;
        r22.removeFirst();
    L56:
        r22.addLast(r11);
        return;
    L62:
        return;
    L34:
        monitor-enter(r6.a.class);
    L38:
        th = move-exception;
        throw th;
    L36:
        if (r6.a.f21694b != null) goto L40;
        r6.a r23 = new r6.a();     // Catch: Throwable -> L38
        r23.f21695a = new CopyOnWriteArraySet();     // Catch: Throwable -> L38
        r6.a.f21694b = r23;     // Catch: Throwable -> L38
    L40:
        monitor-exit(r6.a.class);     // Catch: Throwable -> L38
        goto L44
    L23:
        j7.a r24 = new j7.a(2);
        JSONArray r25 = new JSONArray();
        r25.put(r15);
        r24.f18266b = r25;
        h7.a.c(r24);
        goto L32
    L25:
        if (TextUtils.equals(r5, "common_log") == false) goto L27;
        j7.b r26 = new j7.b(r10, r15);
        b0 r27 = h7.a.f17285a;
        p7.a.a(r26);
        goto L32
    L27:
        j7.b r28 = new j7.b(r5, r15);
        b0 r29 = h7.a.f17285a;
        p7.a.a(r28);
        goto L32
    L60:
        r15 = new JSONObject(r11.toString());     // Catch: Throwable -> L11
    L11:
        r15 = r11;
        goto L13
    L29:
        if (j.f3887a == false) goto L32;
        l6.a.a(r5, r11);
        goto L32
    }

    public boolean a(b r5) {
        return true;
    }

    public final void b(b r5) {
        e r10 = z6.b.f23409a;
        if (r10.c() == true) goto L5;
        r10.d(new v(8, this, r5));
        return;
    L5:
        f(r5);
    }

    public abstract void c(b r5);

    @Override // pj.a
    public void d(JSONObject r5, boolean r10) {
    }

    @Override // pj.a
    public final void e() {
        this.f17284b = true;
        z6.b.f23409a.d(new h(this, 19));
    }

    public final void f(b r5) {
        if (a(r5) == true) goto L5;
        return;
    L5:
        g(r5);
        if (this.f17284b == false) goto L8;
        c(r5);
        return;
    L8:
        LinkedList r10 = this.f17283a;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (this.f17283a.size() > 1000) goto L23;
    L17:
        this.f17283a.add(r5);     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L23:
        ((b) this.f17283a.poll()).c().toString();     // Catch: Throwable -> L15 Exception -> L22
        goto L17
    }

    public void g(b r5) {
    }
}
