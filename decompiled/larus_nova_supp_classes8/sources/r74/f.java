package r74;

import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import x74.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ g b;

    public final void a() {
        g.b r2 = (g.b) ((ConcurrentHashMap) this.b.m).get("dtrait_pk1");
        if (r2 != null) goto L5;
    L27:
        this.b.getClass();     // Catch: Exception -> L11
        m74.a.a("[dt] [factorLoader] bindDt# start wait bindDTrait.....");     // Catch: Exception -> L11
        this.b.o.await();     // Catch: Exception -> L11
        g.b r3 = (g.b) ((ConcurrentHashMap) this.b.m).get("dtrait_pk1");     // Catch: Exception -> L11
        m74.a.a("[dt] bindDt# thread has awake......");     // Catch: Exception -> L9
    L18:
        r2 = r3;
    L19:
        if (r2 != null) goto L21;
        return;
    L21:
        JSONObject r4 = new JSONObject();
        r4.putOpt("device_id", this.a.optString("device_id"));     // Catch: Exception -> L24
        r4.putOpt("encrypted_dtrait", r2.a);     // Catch: Exception -> L24
        c.a(r4, ((s74.a) this.b).e);     // Catch: Exception -> L24
        y74.a.c(DTraitLogLevel.DEBUG, "[device]", "bind_dtrait", "bindDt# success, request body: " + r4, null);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        StringBuilder r1 = new StringBuilder("[dt] [factorLoader] bindDt# parse json error: ");
        this.b.getClass();
        r1.append(e.getMessage());
        m74.a.b(r1.toString());
        return;
    L9:
        Exception e = e;
    L13:
        DTraitLogLevel r6 = DTraitLogLevel.ERROR;
        StringBuilder r7 = new StringBuilder("bindDt# error: encrypt drait has null? ");
        if (r3 != null) goto L16;
        boolean r8 = true;
    L17:
        r7.append(r8);
        y74.a.c(r6, "[device]", "bind_dtrait", r7.toString(), e);
        goto L18
    L16:
        r8 = false;
    L11:
        e = move-exception;
        r3 = r2;
        e = e;
        goto L13
    L5:
        if (TextUtils.isEmpty(r2.a) == false) goto L19;
        goto L19
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

    public f(g r1, JSONObject r2) {
        this.b = r1;
        this.a = r2;
    }
}
