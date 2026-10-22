package com.obric.update.impl.v2.handler;

import android.app.Application;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.obric.update.impl.v2.i;
import com.obric.update.impl.v2.j;
import com.obric.update.impl.v2.o;
import java.io.File;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import yhc.i0;
import yhc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public final o a;
    public final Function1<Integer, Unit> b;
    public final Function3<Integer, Integer, Boolean, Unit> c;
    public final Function2<Boolean, Boolean, Unit> d;
    public volatile boolean e;
    public final Object f;
    public final h g;

    public static final class a {
    }

    static {
    }

    public final v a() {
        v.a r0 = new v.a();
        r0.b = new ObricInitHandler$createAppCommonContext$1();
        r0.e = new b();
        r0.f = new c();
        this.a.b.getClass();
        StringBuilder r1 = new StringBuilder();
        AppHost.Companion r2 = AppHost.a;
        r1.append(r2.getApplication().getPackageName());
        r1.append(".obric.update");
        r0.c = r1.toString();
        i0 r3 = new i0();
        r3.b = true;
        r0.d = r3;
        r0.k = IApplog.a.getDeviceId();
        r0.a = 2131248292;
        r0.p = true;
        r0.g = true;
        r0.q = false;
        r0.i = true;
        r0.h = false;
        Application r4 = r2.getApplication();
        String r5 = null;
        File r6 = (File) ArraysKt.firstOrNull(ContextCompat.getExternalFilesDirs(r4, null));
        if (r6 == null) goto L8;
        String r7 = new PolarisFileWrapper(r6, "update").getAbsolutePath();
        if (r7 == null) goto L8;
        r5 = r7;
    L15:
        r0.o = r5;
        r0.n = new d(this);
        String r8 = "";
        RomInfo r9 = t9a.b.b().b();     // Catch: Exception -> L21
        String r10 = r9.b();     // Catch: Exception -> L21
        String r11 = r9.getDeviceBrand();     // Catch: Exception -> L21
        String r12 = r9.a();     // Catch: Exception -> L21
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        FLogger.a.i("ObricInitHandler", "buildObricUpdateQuery,romVersion=" + r10 + ",brand=" + r11 + ",outerSdkVersion=0,externalDid=" + r12);     // Catch: Exception -> L21
        r8 = "&rom_version=" + Uri.encode(r10) + "&outer_sdk_version=" + Uri.encode("0") + "&device_brand=" + Uri.encode(r11) + "&external_did=" + Uri.encode(r12);     // Catch: Exception -> L21
    L23:
        r0.m = r8;
        return new v(r0);
    L21:
        e = move-exception;
        FLogger.a.i("ObricInitHandler", "buildObricUpdateQuery fail, " + e);
    L8:
        File r13 = r4.getExternalCacheDir();
        if (r13 != null) goto L13;
        r13 = r4.getFilesDir();
        if (r13 != null) goto L13;
        r13 = r4.getCacheDir();
    L13:
        if (r13 == null) goto L15;
        r5 = new PolarisFileWrapper(r13, "update").getAbsolutePath();
        goto L15
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.obric.update.impl.v2.handler.a] */
    public final void b() {
        if (this.e == false) goto L5;
        return;
    L5:
        Object r1 = this.f;
        monitor-enter(r1);
        FLogger r2 = FLogger.a;     // Catch: Throwable -> L9 Exception -> L11
        r2.i("ObricInitHandler", "initSDK start");     // Catch: Throwable -> L9 Exception -> L11
        v r3 = a();     // Catch: Throwable -> L9 Exception -> L11
        com.obric.update.impl.v2.gateway.f r4 = this.a.a;     // Catch: Throwable -> L9 Exception -> L11
        ObricInitHandler$createAppCommonContext$1 r5 = new ObricInitHandler$createAppCommonContext$1();     // Catch: Throwable -> L9 Exception -> L11
        g r6 = new g();     // Catch: Throwable -> L9 Exception -> L11
        ?? r7 = new com.obric.update.impl.v2.handler.a();     // Catch: Throwable -> L9 Exception -> L11
        h r8 = this.g;     // Catch: Throwable -> L9 Exception -> L11
        r4.getClass();     // Catch: Throwable -> L9 Exception -> L11
        com.obric.update.impl.v2.gateway.f.a(r5, r3, r6, r7, r8);     // Catch: Throwable -> L9 Exception -> L11
        this.e = true;     // Catch: Throwable -> L9 Exception -> L11
        r2.i("ObricInitHandler", "initSDK success");     // Catch: Throwable -> L9 Exception -> L11
    L13:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r1);
        return;
    L11:
        e = move-exception;
        FLogger.a.e("ObricInitHandler", "initSDK error: " + e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public f(o r2, com.obric.update.impl.v2.h r3, i r4, j r5) {
        Intrinsics.checkNotNullParameter(r2, "gateways");
        Intrinsics.checkNotNullParameter(r3, "onStatus");
        Intrinsics.checkNotNullParameter(r4, "onProgress");
        Intrinsics.checkNotNullParameter(r5, "onDownloadResult");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = new Object();
        this.g = new h(this);
    }
}
