package ia8;

import com.google.gson.Gson;
import com.larus.avlink.api.model.DoraEvent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Runnable {
    public final /* synthetic */ DoraEvent a;

    public /* synthetic */ l(DoraEvent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraEvent r0 = this.a;
        FLogger.a.i("【DoraTracer】", "real start process " + r0.getMessage());
        String r1 = m.d;     // Catch: Exception -> L14
        if (r1 == null) goto L19;
        z98.k r2 = new z98.k(Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r0.ordinal()), Integer.valueOf(r0.getType()), r0.getMessage(), r0.getExtra());     // Catch: Exception -> L14
        com.bytedance.frameworks.baselib.network.http.util.g r3 = m.c;     // Catch: Exception -> L14
        JSONArray r4 = (JSONArray) r3.b(r1);     // Catch: Exception -> L14
        if (r4 == null) goto L8;
        r4.put(((Gson) m.a.getValue()).toJson(r2));     // Catch: Exception -> L14
    L8:
        AppHost.Companion r5 = AppHost.a;     // Catch: Exception -> L14
        if (r5.isTestChannel() == false) goto L11;
    L12:
        m.b.storeStringJustDisk(r1, ((Gson) m.a.getValue()).toJson(r3.b(r1)));     // Catch: Exception -> L14
        return;
    L11:
        if (Intrinsics.areEqual(r5.getBuildChannel(), "inhouse") == true) goto L12;
        return;
    L19:
        return;
    L14:
        e = move-exception;
        FLogger.a.e("【DoraTracer】", e.getMessage());
    }
}
