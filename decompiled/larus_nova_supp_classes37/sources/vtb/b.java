package vtb;

import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Runnable {
    public final /* synthetic */ c.a a;

    public final void a() {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L20
        r1.put("latency", Float.valueOf(this.a.B.longValue()));     // Catch: Exception -> L20
        r1.put("load_message", this.a.f.longValue() - this.a.e.longValue());     // Catch: Exception -> L20
        r1.put("load_net_message", this.a.h.longValue() - this.a.g.longValue());     // Catch: Exception -> L20
        r1.put("first_render", this.a.d.longValue() - this.a.c.longValue());     // Catch: Exception -> L20
        this.a.getClass();     // Catch: Exception -> L20
        r1.put("loading", 0);     // Catch: Exception -> L20
        r1.put("sdk_cost", this.a.q);     // Catch: Exception -> L20
        r1.put("client_data_cost", this.a.s);     // Catch: Exception -> L20
        c.a r3 = this.a;     // Catch: Exception -> L20
        r1.put("client_render_cost", r3.x - r3.w);     // Catch: Exception -> L20
        if (this.a.i.longValue() <= 0) goto L7;
        r1.put("client_getLauncherInfo_cost", this.a.i);     // Catch: Exception -> L20
    L7:
        if (this.a.j.longValue() <= 0) goto L10;
        r1.put("client_openChatActivity_cost", this.a.j);     // Catch: Exception -> L20
    L10:
        if (this.a.k.longValue() <= 0) goto L12;
        r1.put("client_initview_cost", this.a.k);     // Catch: Exception -> L20
    L12:
        this.a.getClass();     // Catch: Exception -> L20
        long r2 = this.a.t;     // Catch: Exception -> L20
        if (r2 <= 0) goto L15;
        r1.put("message_delay_cost", r2);     // Catch: Exception -> L20
    L15:
        long r4 = this.a.u;     // Catch: Exception -> L20
        if (r4 <= 0) goto L18;
        r1.put("message_wait_cost", r4);     // Catch: Exception -> L20
    L18:
        r1.put("load_message_from_net_cost", this.a.l);     // Catch: Exception -> L20
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L20
        r5.put("source_type", this.a.F.value);     // Catch: Exception -> L20
        r5.put("chat_type", this.a.G.value);     // Catch: Exception -> L20
        r5.put("is_first_start", this.a.m);     // Catch: Exception -> L20
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L20
        r6.put("chat_id", this.a.p);     // Catch: Exception -> L20
        r6.put("context_id", this.a.o);     // Catch: Exception -> L20
        r6.put("section.latency", this.a.a + fyb.a.COMMA + this.a.b);     // Catch: Exception -> L20
        r6.put("section.load_message", this.a.e + fyb.a.COMMA + this.a.f);     // Catch: Exception -> L20
        r6.put("section.load_net_message", this.a.g + fyb.a.COMMA + this.a.h);     // Catch: Exception -> L20
        r6.put("context_id.load_net_message", this.a.o);     // Catch: Exception -> L20
        r6.put("section.first_render", this.a.c + fyb.a.COMMA + this.a.d);     // Catch: Exception -> L20
        r6.put("section.client_render_cost", this.a.w + fyb.a.COMMA + this.a.x);     // Catch: Exception -> L20
        MonitorUtils.monitorEvent("chat_load_time", r5, r1, r6);     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(c.a r1) {
        this.a = r1;
    }
}
