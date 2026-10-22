package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.net.nsd.NsdServiceInfo;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.MdnsServiceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a7 implements MdnsServiceManager.b {
    public final /* synthetic */ z6 a;
    public final /* synthetic */ CallContext b;
    public final /* synthetic */ String c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ a7 a;
        public final /* synthetic */ String b;

        public a(a7 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L5
            JSONObject r0 = new JSONObject();     // Catch: Throwable -> L5
            r0.put("ping", "test");     // Catch: Throwable -> L5
            r0.put("name", this.a.c);     // Catch: Throwable -> L5
            r0.put("type", this.b);     // Catch: Throwable -> L5
            r0.put("port", 123);     // Catch: Throwable -> L5
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
            r1.put("ticket", "abcdefg");     // Catch: Throwable -> L5
            r1.put("uid", 709);     // Catch: Throwable -> L5
            r0.put("extra", r1.toString());     // Catch: Throwable -> L5
            r8.put("data", r0);     // Catch: Throwable -> L5
            r8.put("code", 1);     // Catch: Throwable -> L5
            r8.put("bizCode", 0);     // Catch: Throwable -> L5
            this.a.b.b("onServiceInfoChange", r8);     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final void c(String r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        HashMap r1 = new HashMap();     // Catch: Throwable -> L4
        r1.put("bizCode", 2);     // Catch: Throwable -> L4
        r1.put("code", 1);     // Catch: Throwable -> L4
        this.b.b("onServiceInfoChange", r1);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        this.a.c.clear();
        ALogger.i("DiscoverServicesMethod", "onStopped " + r4);
        return;
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void d(String r5) {
        this.a.finishWithSuccess();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        HashMap r1 = new HashMap();     // Catch: Throwable -> L5
        r1.put("bizCode", 1);     // Catch: Throwable -> L5
        r1.put("code", 1);     // Catch: Throwable -> L5
        this.b.b("onServiceInfoChange", r1);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        ALogger.i("DiscoverServicesMethod", "onStarted " + r5);
        z6 r2 = this.a;
        if (r2.b == false) goto L13;
        r2.c.add(Observable.interval(5, TimeUnit.SECONDS).subscribe(new a(this, r5)));
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        ALogger.i("DiscoverServicesMethod", "startFailed:" + r4);
        z6 r0 = this.a;
        LiveStartDiscoveryServiceResultModel r1 = new LiveStartDiscoveryServiceResultModel();
        r1.b(LiveStartDiscoveryServiceResultModel.Code.Failed);
        r1.a(0);
        r1.c(r4);
        Unit r2 = Unit.INSTANCE;
        r0.finishWithResult(r1);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        HashMap r5 = new HashMap();     // Catch: Throwable -> L5
        r5.put("code", 1);     // Catch: Throwable -> L5
        r5.put("bizCode", -1);     // Catch: Throwable -> L5
        r5.put("message", r4);     // Catch: Throwable -> L5
        this.b.b("onServiceInfoChange", r5);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void e(NsdServiceInfo r12, MdnsServiceManager.a r13) {
        ALogger.i("DiscoverServicesMethod", "onServiceResolved serviceInfo:" + r12);
        if (r13 != null) goto L59;
        if (r12 == null) goto L60;
        InetAddress r14 = r12.getHost();
        if (r14 == null) goto L8;
        String r15 = r14.getHostName();
    L9:
        int r3 = r12.getPort();
        if (r15 != null) goto L12;
        return;
    L12:
        if (StringsKt.startsWith$default(r15, "/", false, 2, null) == false) goto L48;
        r15 = r15.substring(1);
    L48:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L45
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L45
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L45
        String r9 = r12.getServiceName();     // Catch: Throwable -> L45
        String r11 = "";
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        r7.put("serviceName", r9);     // Catch: Throwable -> L45
        String r16 = r12.getServiceType();     // Catch: Throwable -> L45
        if (r16 == null) goto L22;
        r11 = r16;
    L22:
        r7.put("serviceType", r11);     // Catch: Throwable -> L45
        r7.put("host", r15);     // Catch: Throwable -> L45
        r7.put("port", r3);     // Catch: Throwable -> L45
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L45
        StringBuilder r6 = new StringBuilder("onServiceResolved attributes:");     // Catch: Throwable -> L45
        Map<String, byte[]> r0 = r12.getAttributes();     // Catch: Throwable -> L45
        if (r0 == null) goto L25;
        Integer r1 = Integer.valueOf(r0.size());     // Catch: Throwable -> L45
    L26:
        r6.append(r1);     // Catch: Throwable -> L45
        ALogger.i("DiscoverServicesMethod", r6.toString());     // Catch: Throwable -> L45
        Map<String, byte[]> r18 = r12.getAttributes();     // Catch: Throwable -> L45
        if (r18 == null) goto L43;
        Iterator<Map.Entry<String, byte[]>> r19 = r18.entrySet().iterator();     // Catch: Throwable -> L45
    L30:
        if (r19.hasNext() == false) goto L43;
        Map.Entry<String, byte[]> r2 = r19.next();     // Catch: Throwable -> L45
        String r8 = r2.getKey();     // Catch: Throwable -> L45
        byte[] r21 = r2.getValue();     // Catch: Throwable -> L45
        if (r8 != null) goto L34;
    L37:
        boolean r22 = true;
    L38:
        if (r22 == true) goto L30;
        if (r21 == null) goto L41;
        r17.put(r8, new String(r21, Charsets.UTF_8));     // Catch: Throwable -> L45
        goto L30
    L41:
        r17.put(r8, null);     // Catch: Throwable -> L45
        goto L30
    L34:
        if (StringsKt.isBlank(r8) == true) goto L37;
        r22 = false;
    L43:
        r7.put("extra", r17.toString());     // Catch: Throwable -> L45
        r5.put("data", r7);     // Catch: Throwable -> L45
        r5.put("code", 1);     // Catch: Throwable -> L45
        r5.put("bizCode", 0);     // Catch: Throwable -> L45
        this.b.b("onServiceInfoChange", r5);     // Catch: Throwable -> L45
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L45
        return;
    L25:
        r1 = null;
    L45:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L8:
        r15 = null;
        goto L9
    L60:
        return;
    }

    public a7(z6 r1, CallContext r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
