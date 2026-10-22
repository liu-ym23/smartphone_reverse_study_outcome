package r74;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import org.json.JSONObject;
import x74.c;
import y74.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ c b;

    public final void a() {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        this.a.putOpt("device_type", Build.MODEL);     // Catch: Exception -> L13
        this.a.putOpt("device_platform", "android");     // Catch: Exception -> L13
        r0.putOpt("header", d.b(this.a));     // Catch: Exception -> L13
        String r2 = ((s74.a) this.b).c.a("d_data");     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r1.putOpt("message", "ok");     // Catch: Exception -> L13
        r1.putOpt("data", r2);     // Catch: Exception -> L13
        this.b.getClass();     // Catch: Exception -> L13
        m74.a.a("[dt] [collectLoader] get config from cache.");     // Catch: Exception -> L13
    L7:
        ((s74.a) this.b).d.c(r1);     // Catch: Exception -> L13
        c r3 = this.b;     // Catch: Exception -> L13
        HashMap r4 = (HashMap) ((s74.a) r3).d.d;     // Catch: Exception -> L13
        if (r4.isEmpty() == false) goto L10;
        m74.a.a("[dt] [collectLoader] parseCollectorByConfig# config map is empty");     // Catch: Exception -> L13
    L11:
        this.b.e();     // Catch: Exception -> L13
        c r5 = this.b;     // Catch: Exception -> L13
        c.d(r5, this.a, ((s74.a) r5).e);     // Catch: Exception -> L13
        return;
    L10:
        r3.a(r4);     // Catch: Exception -> L13
        goto L11
    L6:
        c r6 = this.b;     // Catch: Exception -> L13
        Context r7 = ((s74.a) r6).b;     // Catch: Exception -> L13
        r1 = c.b(r0, ((s74.a) r6).e);     // Catch: Exception -> L13
        this.b.getClass();     // Catch: Exception -> L13
        m74.a.a("[dt] [collectLoader] get config from server.");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        StringBuilder r8 = new StringBuilder("[dt] [collectLoader] handleCollect#error ");
        this.b.getClass();
        r8.append(e.getMessage());
        m74.a.b(r8.toString());
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

    public a(c r1, JSONObject r2) {
        this.b = r1;
        this.a = r2;
    }
}
