package com.bytedance.ai.applet.app.foundation.performance;

import android.content.Context;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements com.bytedance.ai.applet.app.foundation.w {
    public final String a;
    public final String b;
    public final Object c;
    public final ArrayDeque<f> d;
    public final Map<Long, k> e;
    public int f;
    public Long g;
    public boolean h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    public final List<f> c() {
        Object r0 = this.c;
        monitor-enter(r0);
        List<f> r1 = CollectionsKt.toList(this.d);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        Object r0 = this.c;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L7;
        List r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L14
    L8:
        monitor-exit(r0);
        Iterator r10 = r1.iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        k r11 = (k) r10.next();
        r11.getClass();
        k.d(r11, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "applet_destroyed", 2);
        goto L11
    L13:
        return;
    L7:
        this.i = true;     // Catch: Throwable -> L14
        this.g = null;     // Catch: Throwable -> L14
        r1 = CollectionsKt.toList(((LinkedHashMap) this.e).values());     // Catch: Throwable -> L14
        ((LinkedHashMap) this.e).clear();     // Catch: Throwable -> L14
        this.d.clear();     // Catch: Throwable -> L14
        goto L8
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public final r b(p r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        r r0 = new r(this, r10);
        Object r11 = this.c;
        monitor-enter(r11);
        this.e.put(Long.valueOf(r0.c), r0);     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r11);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<f> e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "entryType");
        Object r0 = this.c;
        monitor-enter(r0);
        ArrayDeque<f> r1 = this.d;     // Catch: Throwable -> L13
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<f> r12 = r1.iterator();     // Catch: Throwable -> L13
    L6:
        if (r12.hasNext() == false) goto L11;
        f r13 = r12.next();     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(r13.a().getEntryType().getValue(), r10) == false) goto L6;
        r11.add(r13);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r0);
        return r11;
    L13:
        th = move-exception;
        throw th;
    }

    public final r f(long r10) {
        if (r10 <= 0) goto L5;
        boolean r0 = true;
    L6:
        r r1 = null;
        if (r0 == true) goto L9;
        return null;
    L9:
        Object r11 = this.c;
        monitor-enter(r11);
        Map<Long, k> r12 = this.e;     // Catch: Throwable -> L16
        LinkedHashMap r13 = (LinkedHashMap) r12;     // Catch: Throwable -> L16
        Object r14 = r13.get(Long.valueOf(r10));     // Catch: Throwable -> L16
        if ((r14 instanceof r) == false) goto L14;
        r1 = (r) r14;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r11);
        return r1;
    L16:
        th = move-exception;
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final void j(f r10) {
        Intrinsics.checkNotNullParameter(r10, "entry");
        com.bytedance.ai.applet.base.log.b r0 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletPerformance", "record entry: " + r10);
        if (r10.e() == true) goto L6;
        k("record", "invalid entry: " + r10);
        return;
    L6:
        List r11 = CollectionsKt.listOf(r10);
        Intrinsics.checkNotNullParameter(r11, "entries");
        ?? r1 = new ArrayList();
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        Object r13 = r12.next();
        if (((f) r13).e() == false) goto L8;
        r1.add(r13);
        goto L8
    L12:
        int r14 = r11.size() - r1.size();
        if (r14 <= 0) goto L16;
        k("recordAll", "discarded " + r14 + " invalid entries");
    L16:
        if (r1.isEmpty() == true) goto L62;
        Object r15 = this.c;
        monitor-enter(r15);
    L46:
        th = move-exception;
        throw th;
    L21:
        if (this.i == true) goto L29;
        Iterator r16 = r1.iterator();     // Catch: Throwable -> L46
    L24:
        if (r16.hasNext() == false) goto L30;
        this.d.addLast((f) r16.next());     // Catch: Throwable -> L46
    L27:
        if (this.d.size() <= this.f) goto L24;
        this.d.removeFirst();     // Catch: Throwable -> L46
    L30:
        monitor-exit(r15);
        if (r1.isEmpty() == false) goto L49;
        com.bytedance.ai.applet.base.log.a.b("AppletPerformance", "publishPerformanceEntries: empty entries", null);
        return;
    L49:
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L40
        JsonObject r18 = new JsonObject();     // Catch: Throwable -> L40
        Gson r19 = com.bytedance.ai.applet.base.gson.c.a();     // Catch: Throwable -> L40
        Iterable r20 = (Iterable) r1;     // Catch: Throwable -> L40
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));     // Catch: Throwable -> L40
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L40
    L36:
        if (r22.hasNext() == false) goto L38;
        r21.add(e4.a.b((f) r22.next()));     // Catch: Throwable -> L40
        goto L36
    L38:
        r18.add("entries", r19.toJsonTree(r21));     // Catch: Throwable -> L40
        com.bytedance.ai.applet.base.log.b r23 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L40
        com.bytedance.ai.applet.base.log.a.c("AppletPerformance", "publishPerformanceEntries: " + r18);     // Catch: Throwable -> L40
        l3.a r24 = new l3.a("doubao.onPerformanceEntries", r18, 4);     // Catch: Throwable -> L40
        r24.d = this.a;     // Catch: Throwable -> L40
        l3.d.c(r24);     // Catch: Throwable -> L40
        Object r25 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        Throwable r26 = Result.exceptionOrNull-impl(r25);
        if (r26 == null) goto L61;
        k("publishPerformanceEntries", "failed to publish " + r1.size() + " entries: " + r26.getMessage());
        return;
    L61:
        return;
    L40:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L29:
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L46
        goto L30
    }

    public final boolean l(long r10) {
        boolean r1 = false;
        if (h.a(r10) == true) goto L6;
        k("startAppLaunch", "invalid startTime: " + r10);
        return false;
    L6:
        Object r0 = this.c;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.i == false) goto L11;
    L17:
        monitor-exit(r0);
        if (r1 == true) goto L20;
        k("startAppLaunch", "launch already started, completed, or destroyed");
    L20:
        return r1;
    L11:
        if (this.h == true) goto L17;
        if (this.g != null) goto L17;
        this.g = Long.valueOf(r10);     // Catch: Throwable -> L21
        r1 = true;
        goto L17
    }

    public c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r11, BdpAwemeConstant.KEY_APP_NAME);
        this.a = r10;
        this.b = r11;
        this.c = new Object();
        this.d = new ArrayDeque();
        this.e = new LinkedHashMap();
        this.f = 30;
    }

    public static void k(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "operation");
        Intrinsics.checkNotNullParameter(r11, "reason");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L5
        com.bytedance.ai.applet.base.log.a.b("AppletPerformance", r10 + " ignored: " + r11, null);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void i(k r10, e r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        Object r0 = this.c;
        monitor-enter(r0);
        this.e.remove(Long.valueOf(r10.c), r10);     // Catch: Throwable -> L9
        monitor-exit(r0);
        if (r11 == null) goto L14;
        Intrinsics.checkNotNullParameter(r11, "event");
        Map<String, Object> r12 = r11.c();
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletPerformance", "reportAnalyticsEvent: " + r12);
        AtomicBoolean r13 = com.bytedance.ai.monitor.b.a;
        com.bytedance.ai.monitor.b.d(r11.b(), new d(r12));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
