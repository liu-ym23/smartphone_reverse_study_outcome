package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.net.nsd.NsdManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.MdnsServiceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.startDiscoveryService")
public final class z6 extends l<d7, LiveStartDiscoveryServiceResultModel> {
    public final CompositeDisposable a;
    public final boolean b;
    public final CompositeDisposable c;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        this.a.clear();
        super.onDestroy();
    }

    public z6() {
        this.a = new CompositeDisposable();
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.b = r0;
        this.c = new CompositeDisposable();
        return;
    L5:
        if (((Boolean) com.bytedance.android.livesdk.h1.a.getValue()).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final void invoke(Object r11, CallContext r12) {
        d7 r13 = (d7) r11;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        String r1 = r13.b();
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        finishWithFailure();
        return;
    L11:
        String r3 = r13.a();
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        String r4 = r13.b();
        Integer r14 = r13.c();
        if (r14 == null) goto L17;
        long r5 = r14.intValue();
    L18:
        MdnsServiceManager r15 = MdnsServiceManager.c;
        Intrinsics.checkNotNull(r4);
        Context r6 = r12.getContext();
        a7 r7 = new a7(this, r12, r3);
        Intrinsics.checkNotNullParameter(r3, "serviceName");
        Intrinsics.checkNotNullParameter(r4, "serviceType");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ConcurrentHashMap r0 = MdnsServiceManager.a;
        if (((Pair) r0.get(r4)) == null) goto L21;
        r15.c(r6, r4);
    L21:
        ConcurrentHashMap r16 = MdnsServiceManager.b;
        if (r16.containsKey(r4) == true) goto L24;
        r16.put(r4, new MdnsServiceManager.d());
    L24:
        Object r17 = r6.getSystemService("servicediscovery");
        if ((r17 instanceof NsdManager) == true) goto L27;
        r17 = null;
    L27:
        NsdManager r18 = (NsdManager) r17;
        if (r18 != null) goto L30;
        r7.f("get nsdManager failed");
    L41:
        this.a.add(Observable.timer(r5, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new b7(this, r12, r4), c7.a));
        return;
    L30:
        ALogger.i("MdnsServiceManager", "startDiscovery  manager = " + r18);
        com.bytedance.android.livesdk.utils.x4 r8 = new com.bytedance.android.livesdk.utils.x4(r7, r4, r3, r18);
        r18.discoverServices(r4, 1, r8);     // Catch: Throwable -> L33
        r0.put(r4, new Pair(Observable.timer(r5, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.utils.v4(r6, r4), com.bytedance.android.livesdk.utils.w4.a), new com.bytedance.android.livesdk.utils.y4(r18, r8)));
    L33:
        th = move-exception;
        String r9 = th.getMessage();
        if (r9 != null) goto L37;
        r9 = "invoke discoverServices exception";
    L37:
        r7.f(r9);
        MdnsServiceManager.d r19 = (MdnsServiceManager.d) MdnsServiceManager.b.get(r4);
        if (r19 == null) goto L40;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r19.a = r9;
    L40:
        MdnsServiceManager.b(r4, r6);
        ALogger.e("MdnsServiceManager", th);
        goto L41
    L17:
        r5 = 60000;
        goto L18
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }
}
