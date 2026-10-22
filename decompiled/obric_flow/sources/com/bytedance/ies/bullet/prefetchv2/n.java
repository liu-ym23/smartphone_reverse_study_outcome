package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f5867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rd.b f5868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5869c;
    public final /* synthetic */ ad.a d;
    public final /* synthetic */ String e;

    public n(Uri r5, rd.b r10, String r11, ad.a r12, String r13) {
        this.f5867a = r5;
        this.f5868b = r10;
        this.f5869c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Uri r5 = this.f5867a;
        ConcurrentHashMap r10 = yc.a.f23246a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L8
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        xc.g r12 = (xc.g) r11.a(xc.g.class);     // Catch: Throwable -> L8
        if (r12 == null) goto L10;
        boolean r13 = r12.b();     // Catch: Throwable -> L8
    L11:
        if (r13 == false) goto L14;
        boolean r14 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L8
        String r15 = "BulletOptimize PrefetchV2 disable by settings " + r13;     // Catch: Throwable -> L8
        LogLevel r16 = LogLevel.f5954b;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r15, "msg");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r16, "logLevel");     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter("", "subModule");     // Catch: Throwable -> L8
        com.bytedance.ies.bullet.service.base.b.d(r15, r16, "");     // Catch: Throwable -> L8
        return;
    L14:
        String r17 = "开始执行Prefetch: " + r5;     // Catch: Throwable -> L8
        if (r17 == null) goto L18;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XPrefetch", r17, null, 12);     // Catch: Throwable -> L8
    L18:
        ExecutorService r18 = o.f5870a;     // Catch: Throwable -> L8
        rd.b r19 = this.f5868b;     // Catch: Throwable -> L8
        String r20 = this.f5869c;
        if (r19 == null) goto L22;
        final r r21 = j.b(r19);     // Catch: Throwable -> L8
    L24:
        if (r21.f5873a == true) goto L29;
        String r22 = "未添加enable_prefetch参数，不发起预取请求: " + r5;     // Catch: Throwable -> L8
        if (r22 == null) goto L82;
        com.bytedance.ies.bullet.base.utils.logger.a.f("XPrefetch", r22);     // Catch: Throwable -> L8
        return;
    L82:
        return;
    L29:
        c.i(new PrefetchV2$prefetchBySchemaUriInternal$1$1(r21));     // Catch: Throwable -> L8
        String r23 = r21.f5874b;     // Catch: Throwable -> L8
        ad.a r24 = this.d;     // Catch: Throwable -> L8
        if (r24 == null) goto L32;
        String r25 = r24.a();     // Catch: Throwable -> L8
    L33:
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.URI_KEY);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r20, "bid");     // Catch: Throwable -> L8
        ConcurrentHashMap r26 = q.f5872a;     // Catch: Throwable -> L8
        if (r23 != null) goto L36;
    L43:
        final f r27 = c.b(r5, r20, r25);     // Catch: Throwable -> L8
        if (r27 == null) goto L83;
        ArrayList r28 = r27.f5847c;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r20, "<set-?>");     // Catch: Throwable -> L8
        r27.d = r20;     // Catch: Throwable -> L8
        String r29 = this.e;     // Catch: Throwable -> L8
        if (r29 == null) goto L55;
        ConcurrentHashMap r30 = l.f5865a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r29, "sessionId");     // Catch: Throwable -> L8
        ConcurrentHashMap r31 = l.f5865a;     // Catch: Throwable -> L8
        if (r31.size() <= 10) goto L51;
        com.bytedance.ies.bullet.base.utils.logger.a.f("XPrefetch", "Session 可能存在泄漏");     // Catch: Throwable -> L8
    L51:
        k r32 = (k) r31.get(r29);     // Catch: Throwable -> L8
        if (r32 != null) goto L54;
        r32 = new k();     // Catch: Throwable -> L8
    L54:
        r31.put(r29, r32);     // Catch: Throwable -> L8
    L55:
        c.i(new PrefetchV2$prefetchBySchemaUriInternal$1$4(r27));     // Catch: Throwable -> L8
        if (r28.isEmpty() == false) goto L59;
        com.bytedance.ies.bullet.base.utils.logger.a.d("XPrefetch", "Prefetch请求配置为空", null, 12);     // Catch: Throwable -> L8
        return;
    L59:
        Iterator r33 = r28.iterator();     // Catch: Throwable -> L8
    L61:
        if (r33.hasNext() == false) goto L84;
        final i r34 = (i) r33.next();     // Catch: Throwable -> L8
        final h r35 = c.c(r34, r21, r27);     // Catch: Throwable -> L8
        if (r35 != null) goto L64;
        c.l("PrefetchRequest生成失败, url: " + r34.f5855a);     // Catch: Throwable -> L8
        goto L61
    L64:
        Function0<Unit> r36 = new PrefetchV2$prefetchBySchemaUriInternal$1$startPrefetchRequest$1(r34, r35, r21, r27);     // Catch: Throwable -> L8
        if (r34.f5858h == true) goto L66;
        ExecutorService r37 = o.f5870a;     // Catch: Throwable -> L8
        r36.invoke();     // Catch: Throwable -> L8
        goto L61
    L66:
        r36.invoke();     // Catch: Throwable -> L8
        goto L61
    L84:
        return;
    L83:
        return;
    L36:
        if (r23.length() == 0) goto L43;
        if (q.f5872a.get(r23) == null) goto L43;
        throw new ClassCastException();     // Catch: Throwable -> L8
    L32:
        r25 = null;
        goto L33
    L22:
        r21 = j.a(r5, r20);     // Catch: Throwable -> L8
    L10:
        r13 = false;
    L8:
        th = move-exception;
        th.printStackTrace();
        c.l(th.getMessage());
    }
}
