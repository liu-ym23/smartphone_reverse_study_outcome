package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements SingleOnSubscribe {
    public final /* synthetic */ d a;

    public f(d r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        HashMap<String, d.a> r11 = this.a.a;
        monitor-enter(r11);
        this.a.a.clear();     // Catch: Throwable -> L25
        HashMap r0 = (HashMap) ay1.b.t0.getValue(null, ay1.b.a[86]);     // Catch: Throwable -> L25
        if ((!r0.isEmpty()) == false) goto L22;
        Iterator r1 = r0.entrySet().iterator();     // Catch: Throwable -> L25
        boolean r2 = false;
    L8:
        if (r1.hasNext() == false) goto L19;
        Map.Entry r3 = (Map.Entry) r1.next();     // Catch: Throwable -> L25
        String r4 = (String) r3.getKey();     // Catch: Throwable -> L25
        com.bytedance.android.livesdk.gift.configmodel.g1 r5 = com.bytedance.android.livesdk.gift.platform.business.effect.a.c().get(r4);     // Catch: Throwable -> L25
        if (r5 == null) goto L8;
        d.a r6 = new d.a(r5.b());     // Catch: Throwable -> L25
        r6.a = r5.a();     // Catch: Throwable -> L25
        Iterator r7 = ((LinkedHashMap) r3.getValue()).entrySet().iterator();     // Catch: Throwable -> L25
    L13:
        if (r7.hasNext() == false) goto L18;
        Map.Entry r8 = (Map.Entry) r7.next();     // Catch: Throwable -> L25
        if (new PolarisFileWrapper((String) ((Pair) r8.getValue()).getSecond()).exists() == true) goto L16;
        r2 = true;
        goto L13
    L16:
        r6.put(r8.getKey(), r8.getValue());     // Catch: Throwable -> L25
        goto L13
    L18:
        this.a.a.put(r4, r6);     // Catch: Throwable -> L25
        goto L8
    L19:
        this.a.c("readFromDisk");     // Catch: Throwable -> L25
        if (r2 == false) goto L22;
        d.a(this.a);     // Catch: Throwable -> L25
    L22:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r11);
        return;
    L25:
        th = move-exception;
        throw th;
    }
}
