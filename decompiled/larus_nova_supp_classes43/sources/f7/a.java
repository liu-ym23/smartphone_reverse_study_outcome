package f7;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ com.bytedance.android.annie.bridge.method.audio.a a;
    public final /* synthetic */ int b;

    public a(com.bytedance.android.annie.bridge.method.audio.a r1, int r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSBridgeManager r0 = this.a.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.sendJSEvent("networkStatusChange", new JSONObject().put("quality", this.b));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
