package com.bytedance.pia.core.tracing;

import com.bytedance.apm.ApmAgent;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f7103b;

    public /* synthetic */ a(b r5, int r10) {
        this.f7102a = r10;
        this.f7103b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f7102a) {
            case 0: goto L10;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        b r10 = this.f7103b;
        if (r10.f7111j == 3) goto L29;
        r10.f7111j = 7;
        return;
    L29:
        return;
    L8:
        this.f7103b.f7111j = 3;
        return;
    L10:
        b r11 = this.f7103b;
        JSONObject r5 = new JSONObject();     // Catch: JSONException -> L15
        r5.put("url", r11.f7110i);     // Catch: JSONException -> L15
        r5.put("pia_mode", r11.f7109h);     // Catch: JSONException -> L15
        r5.put("pia_version", r11.g);     // Catch: JSONException -> L15
        r5.put("st_prefetch", r11.f7111j);     // Catch: JSONException -> L15
        r5.put("st_nsr", r11.f7113l);     // Catch: JSONException -> L15
        r5.put("st_snapshot", r11.f7112k);     // Catch: JSONException -> L15
        r5.put("st_ssr", r11.f7114m);     // Catch: JSONException -> L15
        r5.put("st_preload_html", r11.f7115n);     // Catch: JSONException -> L15
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L15
        Iterator r13 = r11.f7116o.entrySet().iterator();     // Catch: JSONException -> L15
    L13:
        if (r13.hasNext() == false) goto L17;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: JSONException -> L15
        r12.put("dr_" + ((String) r14.getKey()), CollectionsKt.averageOfLong((Iterable) r14.getValue()));     // Catch: JSONException -> L15
        goto L13
    L17:
        Iterator r15 = r11.f7117p.entrySet().iterator();     // Catch: JSONException -> L15
    L19:
        if (r15.hasNext() == false) goto L21;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: JSONException -> L15
        r5.put((String) r16.getKey(), r16.getValue());     // Catch: JSONException -> L15
        goto L19
    L21:
        ApmAgent.monitorEvent("pia_online_monitor", r5, r12, null);     // Catch: JSONException -> L15
        JSONObject r17 = new JSONObject();     // Catch: JSONException -> L15
        i.g(r17, r5);     // Catch: JSONException -> L15
        i.g(r17, r12);     // Catch: JSONException -> L15
        j.C("PIA_REPORT: " + r17, null);     // Catch: JSONException -> L15
        return;
    L15:
        e = move-exception;
        j.x("pia online metrics report error", e);
    }
}
