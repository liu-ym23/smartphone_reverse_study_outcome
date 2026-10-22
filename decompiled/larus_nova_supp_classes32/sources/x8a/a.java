package x8a;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Iterator;
import org.json.JSONObject;
import ps3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ c b;

    public final void a() {
        c r0 = this.b;
        String r1 = this.a;
        if (TextUtils.isEmpty(r1) == false) goto L26;
    L14:
        z8a.a r2 = null;
    L15:
        r0.getClass();
        if (d.j() == false) goto L18;
        b.a(new String[]{"handleCloudMessageInternal cloudMessage=" + r2});
    L18:
        if (r2 == null) goto L25;
        Iterator r3 = r0.b.iterator();
    L22:
        if (r3.hasNext() == false) goto L31;
        if (((a9a.b) r3.next()).b(r2) == false) goto L22;
        return;
    L31:
        return;
    L25:
        return;
    L26:
        r2 = new z8a.a();     // Catch: Exception -> L10
        JSONObject r4 = new JSONObject(r1);     // Catch: Exception -> L10
        r2.c = r4.optString("command_id");     // Catch: Exception -> L10
        r2.b = r4.optString("type");     // Catch: Exception -> L10
        String r5 = r4.optString(LynxResourceModule.PARAMS_KEY);     // Catch: Exception -> L10
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r6 = new JSONObject(r5);     // Catch: Exception -> L10
    L8:
        r2.a = r5;     // Catch: Exception -> L10
        r2.d = r6;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        if (d.j() == false) goto L14;
        b.a(new String[]{"Parse CloudMessage Error."});
        Log.getStackTraceString(e);
        goto L14
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

    public a(c r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
