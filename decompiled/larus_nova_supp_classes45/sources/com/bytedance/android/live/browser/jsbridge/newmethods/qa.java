package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class qa implements ylc.c {
    public final /* synthetic */ wa a;
    public final /* synthetic */ String b;
    public final /* synthetic */ CallContext c;

    public static final class a implements Runnable {
        public final /* synthetic */ qa a;
        public final /* synthetic */ com.ss.ugc.live.sdk.message.wrsc.data.a b;

        public a(qa r1, com.ss.ugc.live.sdk.message.wrsc.data.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            qa r0 = this.a;     // Catch: Throwable -> L4
            wa.j(r0.a, this.b, r0.c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onClear() {
    }

    public final void a(com.ss.ugc.live.sdk.message.wrsc.data.a r5) {
        Intrinsics.checkNotNullParameter(r5, "roomDataSync");
        ALogger.i(this.a.a, "wrds key: " + this.b + " notify update, version: " + r5.a + ", bizLogId: " + r5.c + ", key: " + r5.g);
        if (this.a.f.getEnableWRDSMethodSampling() == true) goto L5;
    L7:
        Schedulers.io().scheduleDirect(new a(this, r5));
        return;
    L5:
        if (this.a.f.getEnableWRDSMethodSamplingKey().contains(r5.g) == false) goto L7;
        this.a.d.onNext(r5);
    }

    public qa(wa r1, String r2, CallContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
