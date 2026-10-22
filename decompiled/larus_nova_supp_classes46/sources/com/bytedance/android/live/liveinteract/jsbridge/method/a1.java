package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a1 implements OnWRDSDataUpdateListener {
    public ylc.c a;
    public final /* synthetic */ b1 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ CallContext d;

    public static final class a implements Runnable {
        public final /* synthetic */ a1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Object c;

        public a(a1 r1, String r2, Object r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            a1 r0 = this.a;
            b1 r1 = r0.b;
            String r2 = this.b;
            Object r3 = this.c;
            CallContext r4 = r0.d;
            r1.getClass();
            JSONObject r5 = new JSONObject();     // Catch: Exception -> L5
            r5.put("sync_data", GsonHelper.getLynxWorkaround().toJson(r3));     // Catch: Exception -> L5
            r5.put("class_name", com.bytedance.android.live.browser.jsbridge.d.a(r2));     // Catch: Exception -> L5
            ALogger.i(r1.a, "sendJsEvent roomDataSync " + r3 + ", json " + r5);     // Catch: Exception -> L5
            r4.b("H5_wrds", r5);     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            ALogger.e(r1.a, "sendJsEvent error!", e);
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

    public final ylc.c getDataSyncListener() {
        return this.a;
    }

    public final void setDataSyncListener(ylc.c r1) {
        this.a = r1;
    }

    public final void onWRDSDataUpdate(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "syncKey");
        ALogger.i(this.b.a, "wrds key: " + this.c + " notify update, syncKey: " + r4 + ", value: " + r5);
        Function2<String, Object, Unit> r0 = this.b.f;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(r4, r5);
    L5:
        Schedulers.io().scheduleDirect(new a(this, r4, r5));
    }

    public a1(b1 r1, String r2, CallContext r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }
}
