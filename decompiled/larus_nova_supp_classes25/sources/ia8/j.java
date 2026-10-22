package ia8;

import com.google.gson.Gson;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ DoraEvent a;

    public /* synthetic */ j(DoraEvent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraEvent r0 = this.a;
        FLogger r4 = FLogger.a;     // Catch: Exception -> L63
        r4.i("【DoraTracer】", "real start process " + r0.getMessage());     // Catch: Exception -> L63
        String r3 = m.d;     // Catch: Exception -> L63
        if (r3 == null) goto L72;
        z98.k r11 = new z98.k(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r0.ordinal()), Integer.valueOf(r0.getType()), r0.getMessage(), r0.getExtra());     // Catch: Exception -> L63
        com.bytedance.frameworks.baselib.network.http.util.g r5 = m.c;     // Catch: Exception -> L63
        JSONArray r6 = (JSONArray) r5.b(r3);     // Catch: Exception -> L63
        if (r6 == null) goto L8;
        r6.put(((Gson) m.a.getValue()).toJson(r11));     // Catch: Exception -> L63
    L8:
        AppHost.Companion r7 = AppHost.a;     // Catch: Exception -> L63
        if (r7.isTestChannel() == false) goto L11;
    L12:
        String r8 = ((Gson) m.a.getValue()).toJson(r5.b(r3));     // Catch: Exception -> L63
        if (r8 != null) goto L15;
    L17:
        r4.i("【DoraTracer】", "taskId:" + r3 + ", jsonString is null");     // Catch: Exception -> L63
    L19:
        if (r0 != DoraEvent.SessionStop) goto L73;
        JSONArray r1 = (JSONArray) r5.b(m.d);     // Catch: Exception -> L63
        if (r1 == null) goto L74;
        final JSONArray r2 = new JSONArray();     // Catch: Exception -> L63
        int r9 = r1.length();     // Catch: Exception -> L63
        int r10 = 0;
    L23:
        if (r10 >= r9) goto L61;
        String r12 = r1.optString(r10);     // Catch: Exception -> L63
        if (r12 == null) goto L60;
        z98.k r13 = (z98.k) ((Gson) m.a.getValue()).fromJson(r12, z98.k.class);     // Catch: Exception -> L63
        if (r13 == null) goto L60;
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L63
        Integer r15 = r13.c;     // Catch: Exception -> L63
        if (r15 == null) goto L37;
        if (r15.intValue() != 4) goto L37;
        r14.put("from", "Doubao");     // Catch: Exception -> L63
        r14.put("to", "Doubao");     // Catch: Exception -> L63
    L59:
        r14.put("time", m.i.format(r13.a));     // Catch: Exception -> L63
        r14.put("event", r13.d);     // Catch: Exception -> L63
        r14.put("extra", r13.e);     // Catch: Exception -> L63
        r2.put(r14);     // Catch: Exception -> L63
    L37:
        if (r15 != null) goto L40;
    L42:
        if (r15 != null) goto L45;
    L49:
        if (r15 != null) goto L52;
    L54:
        if (r15 == null) goto L59;
        if (r15.intValue() != 0) goto L59;
        r14.put("from", "Dora");     // Catch: Exception -> L63
        r14.put("to", "Doubao");     // Catch: Exception -> L63
        goto L59
    L52:
        if (r15.intValue() != 1) goto L54;
        r14.put("from", "Doubao");     // Catch: Exception -> L63
        r14.put("to", "Dora");     // Catch: Exception -> L63
        goto L59
    L45:
        if (r15.intValue() != 2) goto L49;
        r14.put("from", "Speech");     // Catch: Exception -> L63
        r14.put("to", "Doubao");     // Catch: Exception -> L63
        goto L59
    L40:
        if (r15.intValue() != 3) goto L42;
        r14.put("from", "Doubao");     // Catch: Exception -> L63
        r14.put("to", "Speech");     // Catch: Exception -> L63
    L60:
        r10 = r10 + 1;     // Catch: Exception -> L63
        goto L23
    L61:
        final String r16 = m.f;     // Catch: Exception -> L63
        final String r17 = m.d;     // Catch: Exception -> L63
        l0.b(new k(r16, r17, r2));     // Catch: Exception -> L63
        m.c.e(r3);     // Catch: Exception -> L63
        return;
    L74:
        return;
    L73:
        return;
    L15:
        if (Intrinsics.areEqual(r8, "null") == true) goto L17;
        m.b.storeStringJustDisk(r3, r8);     // Catch: Exception -> L63
        goto L19
    L11:
        if (Intrinsics.areEqual(r7.getBuildChannel(), "inhouse") == false) goto L19;
    L72:
        return;
    L63:
        e = move-exception;
        FLogger.a.e("【DoraTracer】", e.getMessage());
    }
}
