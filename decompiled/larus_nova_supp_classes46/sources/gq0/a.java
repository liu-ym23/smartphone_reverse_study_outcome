package gq0;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import is2.b;
import jc1.k;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements b {
    public a() {
    }

    public final /* synthetic */ boolean a() {
        return false;
    }

    public final /* synthetic */ boolean c() {
        return false;
    }

    public final void d() {
    }

    public final /* synthetic */ boolean f() {
        return false;
    }

    public final String getPath() {
        return "backend_microapp_shelf_info_request";
    }

    public final boolean enable() {
        return ((wc1) de0.a.getValue()).o();
    }

    public final Class<tq0.a> getModelClass() {
        return tq0.a.class;
    }

    public final JSONObject g(Bundle r4, is2.a r5) {
        JSONObject r6 = new JSONObject();
        BaseMonitor.add(r6, "open", true);
        BaseMonitor.add(r6, "biz_data_type", 2);
        JSONObject r0 = new JSONObject();
        if (r4 == null) goto L6;
        String r7 = r4.getString("live.intent.extra.REQUEST_ID");
        if (r7 == null) goto L6;
    L7:
        BaseMonitor.add(r0, "req_id", r7);
        Unit r8 = Unit.INSTANCE;
        BaseMonitor.add(r6, "client_extra", r0.toString());
        IHostContext r9 = k.f(IHostContext.class);
        if (r9 != null) goto L10;
    L12:
        return r6;
    L10:
        if (r9.isOpSandboxDevMode() != true) goto L12;
        BaseMonitor.add(r6, "rpc-persist-sandbox", "1");
    L6:
        r7 = "";
        goto L7
    }
}
