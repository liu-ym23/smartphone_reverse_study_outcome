package com.ss.android.lark.conditional.access.auth.v2;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class v implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ d b;

    public v(String r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        com.ss.android.lark.storage.kv.repo.a r0 = y.b;
        if (r0 == null) goto L17;
        String r1 = this.a;
        d r2 = this.b;
        if (r0.a(r1, d.class) == false) goto L8;
        r0.putJSONObject(r1, r2);
        return;
    L8:
        String r3 = "index_" + y.d;
        if (r0.a(r3, String.class) == false) goto L13;
        String r4 = r0.getString(r3, null);
        if (r4 == null) goto L13;
        r0.remove(r4);
    L13:
        r0.putJSONObject(r1, r2);
        r0.putString(r3, r1);
        y.d = (y.d + 1) % y.e;
        y.f = Math.min(y.f + 1, y.e);
        r0.putInt("IM_FILE_READ_HEAD", y.d);
        r0.putInt("IM_FILE_READ_COUNT", y.f);
        if ((y.f % 100) != 0) goto L18;
        FileAuthMonitor.UpdateTrigger[] r5 = FileAuthMonitor.a;
        FileAuthMonitor.k("PointKey_IM_MSG_FILE_READ", y.f);
        return;
    L18:
        return;
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
}
