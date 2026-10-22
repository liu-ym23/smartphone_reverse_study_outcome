package com.bytedance.android.anniex.lite;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegateProvider;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactory;
import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.TraceEvent;
import i36.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final b a = null;
    public static final LruCache<String, ra.a> b = null;

    public b() {
    }

    static {
        a = new b();
        b = new LruCache(5);
    }

    public static ra.a a(String r33, Uri r34, String r35, TemplateData r36) {
        Intrinsics.checkNotNullParameter(r33, "bid");
        Intrinsics.checkNotNullParameter(r34, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r35, "sessionId");
        Map<String, d> r10 = MonitorManager.a;
        MonitorManager.s(r33, r35, null);
        ra.b r11 = ra.b.B.c(r34);
        Intrinsics.checkNotNullParameter(r33, "bid");
        Intrinsics.checkNotNullParameter(r34, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        boolean r32 = true;
        if (h.u0() == false) goto L51;
        Map r12 = x26.a.a;
        g r13 = (g) x26.a.a(g.class);
        if (r13 == null) goto L11;
        e r14 = (e) r13.n0(e.class);
        if (r14 == null) goto L11;
        Boolean r15 = r14.h1();
        if (r15 == null) goto L11;
        boolean r16 = r15.booleanValue();
    L12:
        if (r16 == false) goto L51;
        ArrayList r17 = new ArrayList();
        m16.b r18 = new m16.b();
        r18.d(Uri.class, r34);
        s26.d r19 = s26.d.c;
        v16.b r20 = s26.d.c.d(r33, v16.b.class);
        if (r20 == null) goto L18;
        List r21 = r20.m(r18);
        if (r21 == null) goto L18;
    L19:
        r17.addAll(CollectionsKt.filterNotNull(r21));
        g r22 = (g) x26.a.a(g.class);
        if (r22 == null) goto L26;
        e r23 = (e) r22.n0(e.class);
        if (r23 == null) goto L26;
        Boolean r24 = r23.l1();
        if (r24 == null) goto L26;
        boolean r25 = r24.booleanValue();
    L27:
        if (r25 == false) goto L36;
        AnnieXServiceCenter.a.getClass();
        IAnnieXLitePageDelegateProvider r26 = (IAnnieXLitePageDelegateProvider) AnnieXServiceCenter.d(r33, IAnnieXLitePageDelegateProvider.class);
        if (r26 == null) goto L33;
        na.b r27 = r26.y0();
        if (r27 == null) goto L33;
        List r28 = r27.g();
    L34:
        if (r28 == null) goto L36;
        r17.addAll(r28);
    L33:
        r28 = null;
    L36:
        ArrayList r29 = new ArrayList();
        Iterator r30 = r17.iterator();
    L38:
        if (r30.hasNext() == false) goto L49;
        Object r31 = r30.next();
        if ((r31 instanceof com.lynx.tasm.behavior.a) == false) goto L43;
        com.lynx.tasm.behavior.a r37 = (com.lynx.tasm.behavior.a) r31;
    L46:
        if (r37 == null) goto L38;
        r29.add(r37);
        goto L38
    L43:
        if ((r31 instanceof p46.c) == false) goto L45;
        int r38 = i26.a.a;
        p46.c r39 = (p46.c) r31;
        r39.getClass();
        r37 = new LynxBehaviorFactory.createLynxBehavior.1(r39);
        goto L46
    L45:
        r37 = null;
        goto L46
    L49:
        if ((!r29.isEmpty()) == false) goto L51;
    L52:
        if (r29 != null) goto L54;
        List r210 = CollectionsKt.emptyList();
    L55:
        ra.b r40 = ra.b.b(r11, false, null, null, null, 0, 0, 0.0f, false, false, null, false, r210, null, false, false, false, null, false, 0.0f, 16769023);
        if (h.Y() == false) goto L58;
        r40.y = r11.y;
        r40.z = r11.z;
    L58:
        s26.d r41 = s26.d.c;
        v16.a r42 = s26.d.c.d(r33, v16.b.class);
        if ((r42 instanceof v16.a) == false) goto L61;
        v16.a r43 = r42;
    L63:
        if (h.u0() == true) goto L66;
        r43 = null;
    L66:
        if (r43 == null) goto L68;
        Intrinsics.checkNotNullParameter(r34.toString(), com.bytedance.android.ec.core.event.a.KEY_URL);
    L68:
        a r44 = a.a;
        monitor-enter(r44);
        Intrinsics.checkNotNullParameter(r35, "sessionId");     // Catch: Throwable -> L103
        LruCache<String, Map<String, Object>> r45 = a.c;     // Catch: Throwable -> L103
        Map<String, ? extends Object> r46 = r45.get(r35);     // Catch: Throwable -> L103
        if (r46 == null) goto L73;
        r45.remove(r35);     // Catch: Throwable -> L103
    L73:
        monitor-exit(r44);
        if (r43 == null) goto L76;
        Intrinsics.checkNotNullParameter(r34.toString(), com.bytedance.android.ec.core.event.a.KEY_URL);
    L76:
        Map r47 = x26.a.a;
        g r48 = (g) x26.a.a(g.class);
        if (r48 == null) goto L83;
        e r49 = (e) r48.n0(e.class);
        if (r49 == null) goto L83;
        Boolean r50 = r49.j();
        if (r50 == null) goto L83;
        boolean r51 = r50.booleanValue();
    L84:
        if (r51 == false) goto L90;
        String r52 = UriProtector.getQueryParameter(r34, "enable_forest_preload");
        if (Intrinsics.areEqual(r52, "0") == false) goto L88;
    L89:
        boolean r53 = false;
    L91:
        ra.a r0 = new com.bytedance.android.anniex.api.d(r33, null, r40, 10).f(r34, r35, r53, r36, r46, false, "annieXCard", true, null);
        g r1 = (g) x26.a.a(g.class);
        if (r1 == null) goto L98;
        e r54 = (e) r1.n0(e.class);
        if (r54 == null) goto L98;
        Boolean r55 = r54.e1();
        if (r55 == null) goto L98;
        r32 = r55.booleanValue();
    L98:
        if (r32 == true) goto L100;
    L101:
        b.put(r35, r0);
    L102:
        return r0;
    L100:
        if (r0.h != null) goto L102;
    L88:
        if (Intrinsics.areEqual(r52, "false") == true) goto L89;
    L90:
        r53 = true;
    L83:
        r51 = true;
    L103:
        th = move-exception;
        throw th;
    L61:
        r43 = null;
        goto L63
    L54:
        r210 = r29;
    L26:
        r25 = true;
    L18:
        r21 = CollectionsKt.emptyList();
    L11:
        r16 = true;
    L51:
        r29 = null;
        goto L52
    }

    public static ra.a b(String r10, Uri r11, String r12, TemplateData r13) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        TraceEvent.beginSection("AnnieXLynxModelBuilder:preBuild");
        a.getClass();     // Catch: Throwable -> L15
        ra.a r1 = b.get(r12);     // Catch: Throwable -> L15
        if (r1 == null) goto L9;
        TemplateData r14 = r1.d;     // Catch: Throwable -> L15
        if (r14 == null) goto L9;
        r14.put("isFromModel", Boolean.TRUE);     // Catch: Throwable -> L15
    L9:
        if (r1 != null) goto L13;
        r1 = a(r10, r11, r12, r13);     // Catch: Throwable -> L15
        TemplateData r15 = r1.d;     // Catch: Throwable -> L15
        if (r15 == null) goto L13;
        r15.put("isFromModel", Boolean.FALSE);     // Catch: Throwable -> L15
    L13:
        TraceEvent.endSection("AnnieXLynxModelBuilder:preBuild");
        return r1;
    L15:
        th = move-exception;
        TraceEvent.endSection("AnnieXLynxModelBuilder:preBuild");
        throw th;
    }
}
