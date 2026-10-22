package r74;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;
import x74.c;
import y74.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ c d;

    public final void a() {
        JSONObject r2 = new JSONObject();
        this.a.putOpt("encrypted_dtrait", this.d.h);     // Catch: Exception -> L7
        this.a.putOpt("device_type", Build.MODEL);     // Catch: Exception -> L7
        this.a.putOpt("device_platform", "android");     // Catch: Exception -> L7
        r2.putOpt("header", d.b(this.a));     // Catch: Exception -> L7
        r2.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));     // Catch: Exception -> L7
        r2.putOpt("data", this.b);     // Catch: Exception -> L7
        r2.putOpt("version", CastIntegerProtector.valueOf(((s74.a) this.d).d.f));     // Catch: Exception -> L7
        if (Logger.debug() == false) goto L9;
        StringBuilder r3 = new StringBuilder("[dt] [collectLoader] LoaderManager#statsCollect request body.headers: ");     // Catch: Exception -> L7
        this.d.getClass();     // Catch: Exception -> L7
        r3.append(this.a);     // Catch: Exception -> L7
        Logger.d(r3.toString());     // Catch: Exception -> L7
    L9:
        Context r1 = ((s74.a) this.d).b;
        JSONObject r4 = c.b(r2, this.c);
        p74.b r5 = ((s74.a) this.d).d;
        r5.getClass();
    L21:
        e = move-exception;
        m74.a.b("[dt] updateSpLoaderConfig# error " + e.getMessage());
        return;
    L11:
        if (r4.optString("message", "").equals("ok") == true) goto L13;
        m74.a.a("[dt] parseDTraitConfig# error response.message not equals ok");     // Catch: Exception -> L21
        boolean r6 = false;
    L14:
        if (r6 == false) goto L27;
        String r0 = r4.optString("data");     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r0) == false) goto L19;
        m74.a.a("[dt] updateSpLoaderConfig# error response.data is null");     // Catch: Exception -> L21
        return;
    L19:
        r5.d(r0);     // Catch: Exception -> L21
        r5.a(r0);     // Catch: Exception -> L21
        m74.a.a("[dt] updateSpLoaderConfig# updateMemCacheAndRisk success");     // Catch: Exception -> L21
        return;
    L27:
        return;
    L13:
        r6 = true;
    L7:
        e = move-exception;
        StringBuilder r7 = new StringBuilder("[dt] [collectLoader] LoaderManager#parse json error: ");
        this.d.getClass();
        r7.append(e.getMessage());
        Logger.d(r7.toString());
        goto L9
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

    public b(c r1, JSONObject r2, JSONObject r3, boolean r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
