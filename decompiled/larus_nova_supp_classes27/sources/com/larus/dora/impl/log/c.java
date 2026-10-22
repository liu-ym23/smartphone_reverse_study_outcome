package com.larus.dora.impl.log;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kj4.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import t19.s;
import t39.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ u d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ c(boolean r1, boolean r2, int r3, u r4, boolean r5, boolean r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke() {
        boolean r0 = this.a;
        boolean r1 = this.b;
        int r7 = this.c;
        u r2 = this.d;
        boolean r3 = this.e;
        boolean r4 = this.f;
        boolean r5 = this.g;
        DoraLogManager r6 = DoraLogManager.a;
        if (r6.r() == false) goto L14;
        if (r0 == true) goto L8;
        if (r1 == true) goto L8;
        s.a.g(AppHost.a.getApplication(), 2131904029, false);
    L8:
        if (DoraLogManager.t == true) goto L32;
        if (r0 == false) goto L32;
        g49.d.d("DoraLogManager", "isDownloading by manual");
        u r8 = DoraLogManager.n;
        if (r8 == null) goto L32;
        r8.a(true, "", "", false, r7);
    L32:
        return Unit.INSTANCE;
    L14:
        PolarisFileWrapper r9 = new PolarisFileWrapper(r6.p());
        if (r9.exists() == true) goto L17;
        r9.mkdirs();
    L17:
        DoraLogManager.t = r0;
        if (r0 == false) goto L21;
        r2 = null;
    L21:
        DoraLogManager.f = r2;
        if (r3 == false) goto L25;
        DoraLogManager.w = true;
    L25:
        if (DoraAdapterExtKt.h(a.g()) != null) goto L27;
        DoraLogManager.t(r6, false, "no connected device", null, r7, 12);
        return Unit.INSTANCE;
    L27:
        r6.B(true);
        DoraLogManager.u = 0;
        DoraLogManager.v = r7;
        if (r4 == true) goto L30;
        AtomicBoolean[] r10 = DoraLogManager.c;
        r10[0].set(false);
        r10[1].set(false);
    L30:
        g49.d.d("DoraLogManager", "getLogInfo 1");
        DoraLogManager.z(new f(r5));
        return Unit.INSTANCE;
    }
}
