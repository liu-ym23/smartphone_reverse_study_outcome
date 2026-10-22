package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.platform.depend.IScanResultHandler;
import com.bytedance.android.livehostapi.platform.depend.QrScanResult;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class nb implements IScanResultHandler {
    public final /* synthetic */ ob a;
    public final /* synthetic */ w20.sd b;
    public final /* synthetic */ CallContext c;

    public static final class a implements Runnable {
        public final /* synthetic */ nb a;
        public final /* synthetic */ JSONObject b;

        public a(nb r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.finishWithResult(this.b);     // Catch: Throwable -> L4
            ALogger.i("ScanCodeMethod", "finishWithResult： " + this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final String getMobLoadingPage() {
        return "live_ScanCodeMethod";
    }

    public final boolean handleResult(QrScanResult r5) {
        if (r5 != null) goto L6;
        this.a.finishWithFailure();
        return false;
    L6:
        if (Intrinsics.areEqual(this.b.b(), Boolean.TRUE) == false) goto L8;
        r5.getExtraParam().putBoolean("disable_bridge_auto_jump", true);
    L8:
        JSONObject r0 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r2.put("result", r5.getResult());
        r0.put("data", r2);
        r0.put("code", 1);
        View r6 = this.c.d;
        if (r6 == null) goto L11;
        r6.post(new a(this, r0));
    L11:
        return true;
    }

    public nb(ob r1, w20.sd r2, CallContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
