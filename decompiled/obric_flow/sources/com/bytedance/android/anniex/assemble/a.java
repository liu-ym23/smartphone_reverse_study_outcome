package com.bytedance.android.anniex.assemble;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.anniex.base.service.c;
import com.bytedance.android.anniex.container.popup.f;
import com.bytedance.android.anniex.utils.d;
import com.bytedance.android.anniex.utils.e;
import com.bytedance.ies.bullet.base.b;
import com.bytedance.ies.bullet.lynx.init.h;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3108a = null;

    static {
        f3108a = new a();
    }

    public static void b(Class r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(r5, "clazz");
        c.a(r5, r10);
    }

    public static boolean c(Context r13, Uri r14) {
        AnnieX$open$1 r5 = AnnieX$open$1.f3107a;
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "schema");
        Intrinsics.checkNotNullParameter(r5, "block");
        String r10 = r14.getQueryParameter("bid");
        if (r10 != null) goto L5;
        r10 = "default_bid";
    L5:
        b.a(r13);
        com.bytedance.ies.bullet.service.base.router.config.a r11 = new com.bytedance.ies.bullet.service.base.router.config.a();
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r11, "config");
        Intrinsics.checkNotNullParameter(r10, "bid");
        long r12 = System.currentTimeMillis();
        d r15 = new d();
        String r16 = e.b(r14);
        if (Intrinsics.areEqual(r16, "_popup") == false) goto L8;
        String r17 = m.f(r14, "popup_type_opt");
        Triple r18 = new Triple(Boolean.TRUE, r17, Boolean.valueOf(e.h(r17)));
    L16:
        ((Boolean) r18.component1()).getClass();
        String r19 = (String) r18.component2();
        Integer r110 = null;
        if (((Boolean) r18.component3()).booleanValue() == false) goto L23;
        m.f(r14, "__bullet_trident_call_id");
        String r20 = com.lynx.tasm.behavior.utils.d.b(r14, r11.f5997a);
        LinkedHashMap r111 = com.bytedance.android.anniex.monitor.c.f3335a;
        com.bytedance.android.anniex.monitor.c.j(r20, Long.valueOf(r12));
        Intrinsics.checkNotNullParameter(r20, "sessionId");
        Intrinsics.checkNotNullParameter(r14, "schema");
        Intrinsics.checkNotNullParameter("page", "viewType");
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(x3.e.class, "clazz");
        c.a(x3.e.class, r10);
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L23;
        throw null;
    L23:
        if (Intrinsics.areEqual(r10, "liveSaaS") == false) goto L26;
        Intrinsics.checkNotNullParameter(r10, "bid");
        Intrinsics.checkNotNullParameter(p3.b.class, "clazz");
        c.a(p3.b.class, r10);
    L26:
        if (Intrinsics.areEqual(r16, "_page") == false) goto L29;
        ld.b r21 = new ld.b();
        Intrinsics.checkNotNullParameter(r10, "bid");
        r21.f22117a = r10;
        rc.d r22 = r21;
    L32:
        int r23 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XRouter", "get annieX ui service", MapsKt.mapOf(TuplesKt.to("uiType", r16)), 8);
        ug.d r24 = new ug.d(10);
        Object r25 = r11.f5997a.get("bdx_act_request_code");
        if ((r25 instanceof Integer) == false) goto L35;
        r110 = (Integer) r25;
    L35:
        r24.f = r110;
        Unit r26 = Unit.INSTANCE;
        boolean r112 = r22.b(r13, r14, r24);
        com.bytedance.ies.bullet.base.utils.logger.a.g("XRouter", "AnnieXUIService show result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Boolean.valueOf(r112)), TuplesKt.to("scheme", r14.toString())}), 8);
        return r112;
    L29:
        if (Intrinsics.areEqual(r16, "_popup") == false) goto L31;
        f r27 = new f();
        Intrinsics.checkNotNullParameter(r10, "bid");
        r27.f22117a = r10;
        r22 = r27;
        goto L32
    L31:
        ld.b r28 = new ld.b();
        Intrinsics.checkNotNullParameter(r10, "bid");
        r28.f22117a = r10;
        r22 = r28;
        goto L32
    L8:
        String r29 = m.f(r14, "page_type_opt");
        r15.f3502a = r29;
        Boolean r113 = Boolean.FALSE;
        if (e.f(r15, r14) == false) goto L11;
    L14:
        boolean r30 = true;
    L15:
        r18 = new Triple(r113, r29, Boolean.valueOf(r30));
        goto L16
    L11:
        if (e.k(r15, r14) == true) goto L14;
        r30 = false;
        goto L15
    }

    public final void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        com.bytedance.ies.bullet.base.utils.logger.a.g("XInit", "call ensureLynxInitialized", null, 12);
        if (b.f5175a == true) goto L15;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (b.f5175a == true) goto L10;
        b.a(r5);     // Catch: Throwable -> L8
    L10:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(this);
    L15:
        tc.c r11 = tc.c.f22119c;
        com.bytedance.ies.bullet.lynx.d r12 = (com.bytedance.ies.bullet.lynx.d) fj.a.a(tc.c.f22119c, com.bytedance.ies.bullet.lynx.d.class, com.bytedance.ies.bullet.lynx.d.class);
        if (r12 == null) goto L23;
        com.bytedance.ies.bullet.base.utils.logger.a.g("XInit", "call initKit", null, 12);
        if (h.f5680b == true) goto L24;
        com.bytedance.ies.bullet.core.h r13 = com.bytedance.ies.bullet.core.h.g;
        r12.d(new rc.b(new rc.a(r13.f5316b, r13.f5315a)));
        return;
    L24:
        return;
    }
}
