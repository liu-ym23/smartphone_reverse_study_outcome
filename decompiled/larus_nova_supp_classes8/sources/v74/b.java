package v74;

import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import m74.a;
import org.json.JSONObject;
import r74.f;
import r74.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ c c;

    public final void a() {
        a.a("[dt] device_register success, start parseDTraitInfo......");
        String r2 = "";
        String r4 = this.a.optString("dtrait_pk1", "");
        String r5 = this.a.optString("dtrait_pk2", "");
        String r6 = this.a.optString("dtrait_pk1_version", "");
        String r7 = this.a.optString("dtrait_pk2_version", "");
        String r8 = this.a.optString("dtrait_token", "");
        int r0 = this.a.optInt("dtrait_version", -1000);
        boolean r1 = this.a.optBoolean("bind_dtrait", false);
        w74.b r12 = new w74.b(r4, r5, r6, r7, r8, String.valueOf(r0), r1);
        if (r1 == false) goto L5;
        m74.b r3 = this.c.a;
        JSONObject r9 = this.b;
        g r10 = r3.c;
        r10.getClass();
        ((Executor) o74.a.b.b(new Object[0])).execute(new f(r10, r9));
        a.a("[dt] start bindDTrait......");
    L5:
        g r11 = this.c.a.c;
        r11.f = r12;
        a r13 = ((s74.a) r11).c;
        Map r14 = r12.a();
        r13.b.lock();
        HashMap r15 = (HashMap) r14;     // Catch: Throwable -> L24
        if (r15.isEmpty() == true) goto L10;
        ((HashMap) r13.d).putAll(r15);     // Catch: Throwable -> L24
        r13.a = true;     // Catch: Throwable -> L24
        r13.c.signalAll();     // Catch: Throwable -> L24
        a.a("[dt] updateMemoryCacheBySync# update mem map success, wake up the waiting thread......");     // Catch: Throwable -> L24
    L10:
        r13.b.unlock();
        a r16 = ((s74.a) r11).c;
        Map r17 = r12.a();
        r16.getClass();
        Iterator r18 = ((HashMap) r17).entrySet().iterator();     // Catch: Throwable -> L17
    L13:
        if (r18.hasNext() == false) goto L15;
        Map.Entry r19 = (Map.Entry) r18.next();     // Catch: Throwable -> L17
        r16.f.putString((String) r19.getKey(), (String) r19.getValue());     // Catch: Throwable -> L17
        goto L13
    L15:
        r16.f.commit();     // Catch: Throwable -> L17
    L19:
        DTraitLogLevel r20 = DTraitLogLevel.DEBUG;
        Object[] r21 = new Object[1];
        if (r11.f == null) goto L22;
        r2 = r11.f.toString();
    L22:
        r21[0] = r2;
        y74.a.c(r20, "[device]", "cacheDTraitInfo ", String.format("cDt# update dtraitInfo success from server: %s", r21), null);
        return;
    L17:
        th = move-exception;
        y74.a.c(DTraitLogLevel.ERROR, "[device]", "cacheDTraitInfo ", String.format("updateDiskCache# write error: %s", new Object[]{th.getMessage()}), th);
    L24:
        th = move-exception;
        r13.b.unlock();
        throw th;
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

    public b(c r1, JSONObject r2, JSONObject r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
