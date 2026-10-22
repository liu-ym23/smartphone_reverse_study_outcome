package com.bytedance.android.bcm.impl.monitor;

import com.bytedance.android.btm.api.model.k;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ JSONObject a;

    /* JADX INFO: renamed from: com.bytedance.android.bcm.impl.monitor.a$a, reason: collision with other inner class name */
    public static final class RunnableC0105a implements Runnable {
        public final /* synthetic */ a a;

        public RunnableC0105a(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k r0 = new k("bcm_report", this.a.a);     // Catch: Throwable -> L4
            com.bytedance.android.btm.impl.b.e.a().onEventV3(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public a(JSONObject r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.btm.impl.thread.b.e.b(new RunnableC0105a(this), false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
