package com.obric.matrix.platform.sdk.ones.account;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g extends d {
    public static final g c = null;
    public static volatile com.obric.matrix.platform.sdk.ones.account.a d;
    public static volatile Map<String, String> e;
    public static final Set<cka.a> f = null;
    public static final a g = null;
    public static final Set<cka.a> h = null;
    public static final Set<cka.a> i = null;
    public static final Handler j = null;

    public static final class a extends i {
        @Override // com.obric.matrix.platform.sdk.ones.account.i
        public final void a() {
            super.a();
            Set<cka.a> r0 = g.h;
            monitor-enter(r0);
            Iterator r1 = ((CopyOnWriteArraySet) r0).iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L8;
            ((cka.a) r1.next()).a();     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.i
        public final void b() {
            super.b();
            Set<cka.a> r0 = g.h;
            monitor-enter(r0);
            Iterator r1 = ((CopyOnWriteArraySet) r0).iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L8;
            ((cka.a) r1.next()).b();     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.i
        public final void c(int r4) {
            super.c(r4);
            Set<cka.a> r0 = g.h;
            monitor-enter(r0);
            Iterator r1 = ((CopyOnWriteArraySet) r0).iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L8;
            ((cka.a) r1.next()).c(r4);     // Catch: Throwable -> L11
            goto L6
        L8:
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.matrix.platform.sdk.ones.account.i
        public final void d(Runnable r2) {
            Intrinsics.checkNotNullParameter(r2, "runnable");
            g.j.post(r2);
        }
    }

    static {
        c = new g();
        f = new CopyOnWriteArraySet();
        g = new a();
        h = new CopyOnWriteArraySet();
        i = new CopyOnWriteArraySet();
        new Handler(Looper.getMainLooper());
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("OAccountManager");
        ThreadMethodProxy.start(r0);
        j = new Handler(r0.getLooper());
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d
    public final void a() {
        dka.a.a("AccountSDK_AccountStatusListener", "onAccountLogin");
        b();
        Set<cka.a> r0 = f;
        monitor-enter(r0);
        Iterator r1 = ((CopyOnWriteArraySet) r0).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((cka.a) r1.next()).a();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d
    public final void b() {
        dka.a.a("AccountSDK_AccountStatusListener", "onAccountInfoUpdate");
        f();
        g();
        Set<cka.a> r0 = f;
        monitor-enter(r0);
        Iterator r1 = ((CopyOnWriteArraySet) r0).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((cka.a) r1.next()).b();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e() {
        IntentFilter r7 = new IntentFilter();
        r7.addAction("obric.intent.action.account.LOGIN");
        r7.addAction("obric.intent.action.account.LOGOUT");
        r7.addAction("obric.intent.action.account.ACCOUNT_INFO_UPDATE");
        if (Build.VERSION.SDK_INT < 33) goto L25;
        Context r13 = this.a;
        d.a r14 = this.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L111;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L111:
    L20:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L24;
        ReceiverRegisterCrashOptimizer.registerReceiver(r14, r7, null, null, 2);
    L53:
        a r0 = g;
        r0.getClass();
        IntentFilter r15 = new IntentFilter();
        r15.addAction("obric.intent.action.account.SECURE_LOGIN");
        r15.addAction("obric.intent.action.account.SECURE_LOGOUT");
        r15.addAction("obric.intent.action.account.SECURE_ACCOUNT_INFO_UPDATE");
        if (Build.VERSION.SDK_INT < 33) goto L76;
        Context r12 = r0.a;
        i.a r1 = r0.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L105;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L105:
    L71:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L75;
        ReceiverRegisterCrashOptimizer.registerReceiver(r1, r15, "com.obric.account.permission.ACCOUNT_STATUS", null, 2);
    L97:
        b();
        return;
    L75:
        throw e;
    L59:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L61;
    L69:
        r12.registerReceiver(r1, r15, "com.obric.account.permission.ACCOUNT_STATUS", null, 2);     // Catch: Exception -> L71
    L104:
        goto L97
    L61:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r15) == false) goto L69;
        int r2 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r1, r15, 2, "com.obric.account.permission.ACCOUNT_STATUS", null, 5, r12).result;     // Catch: Exception -> L71
        if (r2 == 1) goto L68;
        if (r2 == 2) goto L67;
        if (r2 == 3) goto L104;
        r12.registerReceiver(r1, r15, "com.obric.account.permission.ACCOUNT_STATUS", null, 2);     // Catch: Exception -> L71
        goto L104
    L67:
        new Intent();     // Catch: Exception -> L71
        goto L104
    L68:
        r12.registerReceiver(r1, r15, "com.obric.account.permission.ACCOUNT_STATUS", null, 2);     // Catch: Exception -> L71
        goto L104
    L76:
        Context r16 = r0.a;
        i.a r3 = r0.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L102;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L102:
    L90:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L99;
        ReceiverRegisterCrashOptimizer.registerReceiver(r3, r15, "com.obric.account.permission.ACCOUNT_STATUS", null);
        goto L97
    L99:
        throw e;
    L80:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L82;
    L92:
        r16.registerReceiver(r3, r15, "com.obric.account.permission.ACCOUNT_STATUS", null);     // Catch: Exception -> L90
    L101:
        goto L97
    L82:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r15) == false) goto L92;
        int r4 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r3, r15, 0, "com.obric.account.permission.ACCOUNT_STATUS", null, 4, r16).result;     // Catch: Exception -> L90
        if (r4 == 1) goto L89;
        if (r4 == 2) goto L88;
        if (r4 == 3) goto L101;
        r16.registerReceiver(r3, r15, "com.obric.account.permission.ACCOUNT_STATUS", null);     // Catch: Exception -> L90
        goto L101
    L88:
        new Intent();     // Catch: Exception -> L90
        goto L101
    L89:
        r16.registerReceiver(r3, r15, "com.obric.account.permission.ACCOUNT_STATUS", null);     // Catch: Exception -> L90
        goto L101
    L24:
        throw e;
    L8:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L10;
    L18:
        r13.registerReceiver(r14, r7, null, null, 2);     // Catch: Exception -> L20
    L110:
        goto L53
    L10:
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r7) == false) goto L18;
        int r5 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r14, r7, 2, null, null, 5, r13).result;     // Catch: Exception -> L20
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 == 3) goto L110;
        r13.registerReceiver(r14, r7, null, null, 2);     // Catch: Exception -> L20
        goto L110
    L16:
        new Intent();     // Catch: Exception -> L20
        goto L110
    L17:
        r13.registerReceiver(r14, r7, null, null, 2);     // Catch: Exception -> L20
        goto L110
    L25:
        Context r17 = this.a;
        d.a r18 = this.b;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L108;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L108:
    L49:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L100;
        ReceiverRegisterCrashOptimizer.registerReceiver(r18, r7);
        goto L53
    L100:
        throw e;
    L29:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L40;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r7) == false) goto L40;
        int r6 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r18, r7, 0, null, null, 2, r17).result;     // Catch: Exception -> L49
        if (r6 == 1) goto L38;
        if (r6 == 2) goto L37;
        if (r6 == 3) goto L107;
        r17.registerReceiver(r18, r7);     // Catch: Exception -> L49
    L107:
        goto L53
    L37:
        new Intent();     // Catch: Exception -> L49
        goto L107
    L38:
        r17.registerReceiver(r18, r7);     // Catch: Exception -> L49
    L40:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L43;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L49
        r17.registerReceiver(r18, r7, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L49
        goto L107
    L43:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L45;
    L47:
        r17.registerReceiver(r18, r7);     // Catch: Exception -> L49
        goto L107
    L45:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r7) == false) goto L47;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L49
        ContextCompat.registerReceiver(r17, r18, r7, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L49
        goto L107
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void f() {
        monitor-enter(this);
        Context r2 = AppGlobals.a();     // Catch: Throwable -> L35
        ContentProviderClient r4 = 0;
        Boolean r5 = null;
        ContentProviderClient r3 = d(r2.getContentResolver());     // Catch: Throwable -> L17 Exception -> L19
        if (r3 != null) goto L38;
        Bundle r6 = null;
    L12:
        if (r6 == null) goto L14;
        com.obric.matrix.platform.sdk.ones.account.a r7 = new com.obric.matrix.platform.sdk.ones.account.a(0);     // Catch: Exception -> L9 Throwable -> L30
        b.a(r7, r6);     // Catch: Exception -> L9 Throwable -> L30
        d = r7;     // Catch: Exception -> L9 Throwable -> L30
    L15:
        if (r3 != null) goto L23;
    L24:
        StringBuilder r8 = new StringBuilder("updateAccountInfo loginState: ");     // Catch: Throwable -> L35
        com.obric.matrix.platform.sdk.ones.account.a r0 = d;     // Catch: Throwable -> L35
        if (r0 == null) goto L27;
        r5 = Boolean.valueOf(r0.a);     // Catch: Throwable -> L35
    L27:
        r8.append(r5);     // Catch: Throwable -> L35
        dka.a.c("AccountSDK_OAccountManager", r8.toString());     // Catch: Throwable -> L35
        monitor-exit(this);
        return;
    L23:
        r3.close();     // Catch: Throwable -> L35
        goto L24
    L14:
        d = new com.obric.matrix.platform.sdk.ones.account.a(0);     // Catch: Exception -> L9 Throwable -> L30
        dka.a.b("AccountSDK_OAccountManager", "updateAccountInfo getAccountInfo: result is null");     // Catch: Exception -> L9 Throwable -> L30
        goto L15
    L38:
        r6 = r3.call("com.obric.common.account.provider", "getAccountInfo", null, null);     // Catch: Exception -> L9 Throwable -> L30
    L9:
        Exception e2 = e;
    L21:
        d = new com.obric.matrix.platform.sdk.ones.account.a(0);     // Catch: Throwable -> L30
        dka.a.a.e("AccountSDK_OAccountManager", "updateAccountInfo getAccountInfo err: " + e2, e2);     // Catch: Throwable -> L30
        if (r3 == null) goto L24;
    L30:
        th = th;
        r4 = r2;
    L32:
        if (r4 == 0) goto L34;
        r4.close();     // Catch: Throwable -> L35
    L34:
        throw th;     // Catch: Throwable -> L35
    L19:
        e = move-exception;
        e2 = e;
        r3 = null;
    L17:
        th = th;
    L35:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void g() {
        monitor-enter(this);
        Context r1 = AppGlobals.a();     // Catch: Throwable -> L39
        ContentProviderClient r2 = 0;
        Integer r3 = null;
        ContentProviderClient r4 = d(r1.getContentResolver());     // Catch: Throwable -> L21 Exception -> L23
        if (r4 != null) goto L43;
        Bundle r5 = null;
    L12:
        if (r5 == null) goto L18;
        Serializable r6 = r5.getSerializable("tokenMap");     // Catch: Exception -> L9 Throwable -> L34
        if (r6 == null) goto L17;
        e = (Map) r6;     // Catch: Exception -> L9 Throwable -> L34
    L19:
        if (r4 != null) goto L27;
    L28:
        StringBuilder r7 = new StringBuilder("updateXttTokenMap: ");     // Catch: Throwable -> L39
        Map<String, String> r0 = e;     // Catch: Throwable -> L39
        if (r0 == null) goto L31;
        r3 = Integer.valueOf(r0.size());     // Catch: Throwable -> L39
    L31:
        r7.append(r3);     // Catch: Throwable -> L39
        dka.a.a("AccountSDK_OAccountManager", r7.toString());     // Catch: Throwable -> L39
        monitor-exit(this);
        return;
    L27:
        r4.close();     // Catch: Throwable -> L39
        goto L28
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L9 Throwable -> L34
    L18:
        e = new HashMap();     // Catch: Exception -> L9 Throwable -> L34
        dka.a.f("AccountSDK_OAccountManager", "getXttTokenMap: result is null");     // Catch: Exception -> L9 Throwable -> L34
        goto L19
    L43:
        r5 = r4.call("com.obric.common.account.provider", "getTokenMap", null, null);     // Catch: Exception -> L9 Throwable -> L34
    L9:
        Exception e2 = e;
    L25:
        e = new HashMap();     // Catch: Throwable -> L34
        dka.a.a.e("AccountSDK_OAccountManager", "getXttTokenMap: ", e2);     // Catch: Throwable -> L34
        if (r4 == null) goto L28;
    L34:
        th = th;
        r2 = r1;
    L36:
        if (r2 == 0) goto L38;
        r2.close();     // Catch: Throwable -> L39
    L38:
        throw th;     // Catch: Throwable -> L39
    L23:
        e = move-exception;
        e2 = e;
        r4 = null;
    L21:
        th = th;
    L39:
        th = move-exception;
        throw th;
    }

    public g() {
    }

    public static ContentProviderClient d(ContentResolver r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {"com.obric.common.account.provider"};
        f06.b r12 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r9 = r3;
        int r8 = r9.length;
        int r7 = 0;
    L8:
        if (r7 >= r8) goto L15;
        f06.a r6 = r9[r7];
        int r16 = r7;
        int r17 = r8;
        f06.a[] r18 = r9;
        f06.d r4 = r6.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r19, r1, "android.content.ContentProviderClient", r12);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r6);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r19.acquireUnstableContentProviderClient("com.obric.common.account.provider");
    L14:
        r7 = r16 + 1;
        r8 = r17;
        r9 = r18;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d
    public final void c(int r4) {
        dka.a.a("AccountSDK_AccountStatusListener", "onAccountLogout logoutScene = " + r4);
        b();
        Set<cka.a> r0 = f;
        monitor-enter(r0);
        Iterator r1 = ((CopyOnWriteArraySet) r0).iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((cka.a) r1.next()).c(r4);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
