package com.obric.matrix.platform.sdk.ones.account;

import android.content.ContentProviderClient;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends d implements a9.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f5848c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f5849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Map<String, String> f5850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Set<a9.c> f5851f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Handler f5852g;

    static {
        f5848c = new i();
        f5851f = new CopyOnWriteArraySet();
        new Handler(Looper.getMainLooper());
        HandlerThread r10 = new HandlerThread("OAccountManager");
        r10.start();
        f5852g = new Handler(r10.getLooper());
    }

    private i() {
    }

    public static /* synthetic */ void f() {
        g();
    }

    private static final void g() {
        f5848c.c();
    }

    @Override // a9.b
    public void A(boolean r10) {
        e();
        if (r10 == false) goto L5;
        d(h.f5847c);
        return;
    L5:
        c();
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, a9.c
    public void a() {
        super.a();
        c();
        Set<a9.c> r10 = f5851f;
        monitor-enter(r10);
        Iterator<a9.c> r11 = r10.iterator();     // Catch: Throwable -> L11
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().a();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r10);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, a9.c
    public void b(int r10) {
        super.b(r10);
        c();
        Set<a9.c> r11 = f5851f;
        monitor-enter(r11);
        Iterator<a9.c> r12 = r11.iterator();     // Catch: Throwable -> L11
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().b(r10);     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r11);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d, a9.c
    public void c() {
        super.c();
        h();
        i();
        Set<a9.c> r10 = f5851f;
        monitor-enter(r10);
        Iterator<a9.c> r11 = r10.iterator();     // Catch: Throwable -> L11
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().c();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r10);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.d
    protected void d(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "runnable");
        f5852g.post(r10);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00ef: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:31:0x00ef */
    public synchronized void h() {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L4:
        ContentProviderClient r10 = null;
        Boolean r11 = null;
        ContentProviderClient r12 = AppGlobals.f5799a.c().getContentResolver().acquireUnstableContentProviderClient("com.obric.common.account.provider");     // Catch: Throwable -> L17 Exception -> L19
        if (r12 != null) goto L38;
        Bundle r13 = null;
    L11:
        if (r13 == null) goto L13;
        f5849d = b.a(new a(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null), r13);     // Catch: Exception -> L8 Throwable -> L30
    L14:
        if (r12 == null) goto L24;
    L15:
        r12.close();     // Catch: Throwable -> L35
    L24:
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L35
        r14.append("updateAccountInfo loginState: ");     // Catch: Throwable -> L35
        a r15 = f5849d;     // Catch: Throwable -> L35
        if (r15 == null) goto L27;
        r11 = Boolean.valueOf(r15.a());     // Catch: Throwable -> L35
    L27:
        r14.append(r11);     // Catch: Throwable -> L35
        b9.a.f("AccountSDK_OAccountManager", r14.toString());     // Catch: Throwable -> L35
        monitor-exit(this);
        return;
    L13:
        f5849d = new a(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);     // Catch: Exception -> L8 Throwable -> L30
        b9.a.d("AccountSDK_OAccountManager", "updateAccountInfo getAccountInfo: result is null");     // Catch: Exception -> L8 Throwable -> L30
        goto L14
    L38:
        r13 = r12.call("com.obric.common.account.provider", "getAccountInfo", null, null);     // Catch: Exception -> L8 Throwable -> L30
    L8:
        e = e;
    L21:
        f5849d = new a(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);     // Catch: Throwable -> L30
        b9.a.f540a.e("AccountSDK_OAccountManager", "updateAccountInfo getAccountInfo err: " + e, e);     // Catch: Throwable -> L30
        if (r12 == null) goto L24;
    L30:
        th = th;
        r10 = r2;
    L32:
        if (r10 == null) goto L34;
        r10.close();     // Catch: Throwable -> L35
    L34:
        throw th;     // Catch: Throwable -> L35
    L19:
        e = e;
        r12 = null;
    L17:
        th = th;
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public synchronized void i() {
        monitor-enter(this);
        ContentProviderClient r10 = AppGlobals.f5799a.c();     // Catch: Throwable -> L38
        Integer r11 = null;
        ContentProviderClient r12 = r10.getContentResolver().acquireUnstableContentProviderClient("com.obric.common.account.provider");     // Catch: Throwable -> L21 Exception -> L23
        if (r12 != null) goto L42;
        Bundle r13 = null;
    L11:
        if (r13 == null) goto L17;
        Serializable r14 = r13.getSerializable("tokenMap");     // Catch: Exception -> L8 Throwable -> L34
        if (r14 == null) goto L16;
        f5850e = (Map) r14;     // Catch: Exception -> L8 Throwable -> L34
    L18:
        if (r12 == null) goto L28;
    L19:
        r12.close();     // Catch: Throwable -> L38
    L28:
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L38
        r15.append("updateXttTokenMap: ");     // Catch: Throwable -> L38
        Map<String, String> r16 = f5850e;     // Catch: Throwable -> L38
        if (r16 == null) goto L31;
        r11 = Integer.valueOf(r16.size());     // Catch: Throwable -> L38
    L31:
        r15.append(r11);     // Catch: Throwable -> L38
        b9.a.c("AccountSDK_OAccountManager", r15.toString());     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");     // Catch: Exception -> L8 Throwable -> L34
    L17:
        f5850e = new HashMap();     // Catch: Exception -> L8 Throwable -> L34
        b9.a.h("AccountSDK_OAccountManager", "getXttTokenMap: result is null");     // Catch: Exception -> L8 Throwable -> L34
        goto L18
    L42:
        r13 = r12.call("com.obric.common.account.provider", "getTokenMap", null, null);     // Catch: Exception -> L8 Throwable -> L34
    L8:
        e = e;
    L25:
        f5850e = new HashMap();     // Catch: Throwable -> L34
        b9.a.f540a.e("AccountSDK_OAccountManager", "getXttTokenMap: ", e);     // Catch: Throwable -> L34
        if (r12 == null) goto L28;
    L34:
        Throwable th = th;
    L35:
        if (r10 == 0) goto L37;
        r10.close();     // Catch: Throwable -> L38
    L37:
        throw th;     // Catch: Throwable -> L38
    L23:
        e = e;
        r12 = null;
    L21:
        th = move-exception;
        th = th;
        r10 = 0;
    L38:
        th = move-exception;
        throw th;
    }

    public synchronized Map<String, String> j() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (f5850e != null) goto L6;
        i();     // Catch: Throwable -> L9
    L6:
        Map<String, String> r10 = f5850e;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r10;
    }
}
