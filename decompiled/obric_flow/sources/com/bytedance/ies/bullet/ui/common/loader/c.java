package com.bytedance.ies.bullet.ui.common.loader;

import ai.j0;
import ai.p;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.bullet.core.j;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.core.u;
import com.bytedance.ies.bullet.kit.web.impl.i;
import com.bytedance.ies.bullet.kit.web.m;
import com.bytedance.ies.bullet.lynx.h;
import com.bytedance.ies.bullet.lynx.init.l;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.ui.image.f0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rc.e;
import rc.f;
import xc.d;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f6210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KitType f6211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6212c;
    public hb.a d;
    public boolean e;

    public c(e r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "bid");
        this.f6210a = r5;
        this.f6211b = KitType.f6011b;
        this.f6212c = r10;
    }

    public static KitType c(Uri r5) {
        String r10 = r5.getScheme();
        if (r10 == null) goto L27;
        int r11 = r10.hashCode();
        if (r11 == (-1772600516)) goto L22;
        if (r11 == 3213448) goto L17;
        if (r11 != 99617003) goto L27;
        if (r10.equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L27;
        return KitType.f6012c;
    L17:
        if (r10.equals("http") == false) goto L27;
        return KitType.f6012c;
    L22:
        if (r10.equals("lynxview") == false) goto L27;
        return KitType.d;
    L27:
        return KitType.f6011b;
    }

    @Override // rc.f
    public final rc.c a(Class r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        tc.c r10 = tc.c.f22119c;
        return tc.c.f22119c.a(r5, this.f6212c);
    }

    @Override // rc.f
    public final Object b(Class r5) {
        return f0.c(this, r5);
    }

    public final hb.a d(KitType r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "kitType");
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r12 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        boolean r13 = false;
        if (r12 == null) goto L7;
        d r14 = (d) r12.a(d.class);
        if (r14 == null) goto L7;
        boolean r15 = Intrinsics.areEqual(r14.t0(), Boolean.TRUE);
    L8:
        if (r15 == false) goto L14;
        hb.a r16 = this.d;
        if (r16 != null) goto L12;
    L17:
        m r17 = null;
        h r18 = null;
        r17 = null;
        if (r10 != KitType.d) goto L31;
        if (r11 == null) goto L31;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.lynx.d.class, "clazz");
        tc.c r19 = tc.c.f22119c;
        com.bytedance.ies.bullet.lynx.d r20 = (com.bytedance.ies.bullet.lynx.d) tc.c.f22119c.a(com.bytedance.ies.bullet.lynx.d.class, this.f6212c);
        if (r20 == null) goto L29;
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(this, "context");
        r20.f5627c = r11;
        Intrinsics.checkNotNullParameter(this, "context");
        String r110 = r20.f5627c;
        if (r110 == null) goto L28;
        Intrinsics.checkNotNull(r110);
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(r20, "kitService");
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        r18 = new h(r20, this);
        r18.f5638c = r110;
        Intrinsics.checkNotNullParameter(r20, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r20, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        com.bytedance.ies.bullet.lynx.impl.e r21 = new com.bytedance.ies.bullet.lynx.impl.e(r20, this);
        Lazy r22 = com.bytedance.ies.bullet.core.f.f5312b;
        com.bytedance.ies.bullet.core.f r23 = td.b.b();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        com.bytedance.ies.bullet.core.e r24 = (com.bytedance.ies.bullet.core.e) r23.f5313a.get(r110);
        r21.f = r24;
        if (r24 == null) goto L27;
        r13 = sk.a.g(r24);
    L27:
        r21.d = r13;
        Intrinsics.checkNotNullParameter(r18, "kitView");
        r21.f5656b = r18;
        r18.e = r21;
        r18.f = r21.f5658h;
        goto L29
    L28:
        r18 = new h(r20, this);
    L29:
        this.d = r18;
    L54:
        return this.d;
    L31:
        if (r10 != KitType.f6012c) goto L54;
        if (r11 == null) goto L49;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.webkit.c.class, "clazz");
        tc.c r25 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.webkit.c r26 = (com.bytedance.ies.bullet.service.webkit.c) tc.c.f22119c.a(com.bytedance.ies.bullet.service.webkit.c.class, this.f6212c);
        if (r26 == null) goto L52;
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(r26, "kitService");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        m r27 = new m(this, r26);
        r27.f5564b = r11;
        Intrinsics.checkNotNullParameter(this, "context");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        ug.e r28 = r26.f6155b;
        if (r28 == null) goto L39;
        Intrinsics.checkNotNullParameter(r26, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter(this, "context");
        i r111 = new com.ivy.ivykit.plugin.impl.applet.d(r26, (List) r28.f22361b);
    L48:
        r27.d = r111;
        r17 = r27;
        goto L52
    L39:
        Intrinsics.checkNotNullParameter(r26, "kitService");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        i r29 = new i(r26);
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L42
        Lazy r31 = com.bytedance.ies.bullet.core.f.f5312b;     // Catch: Throwable -> L42
        com.bytedance.ies.bullet.core.f r32 = td.b.b();     // Catch: Throwable -> L42
        r32.getClass();     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r11, "sessionId");     // Catch: Throwable -> L42
        com.bytedance.ies.bullet.core.e r33 = (com.bytedance.ies.bullet.core.e) r32.f5313a.get(r11);     // Catch: Throwable -> L42
        Intrinsics.checkNotNull(r33);     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r33, "<set-?>");     // Catch: Throwable -> L42
        r29.f5524c = r33;     // Catch: Throwable -> L42
        r29.f5526i = sk.a.g(r29.d());     // Catch: Throwable -> L42
        Object r34 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        Throwable r35 = Result.m127exceptionOrNullimpl(r34);
        if (r35 == null) goto L47;
        int r112 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("DefaultWebKitDelegate", "constructor failure:" + r35.getMessage(), null, 12);
    L47:
        r111 = r29;
    L42:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r34 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L52:
        this.d = r17;
        goto L54
    L49:
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.webkit.c.class, "clazz");
        tc.c r114 = tc.c.f22119c;
        com.bytedance.ies.bullet.service.webkit.c r36 = (com.bytedance.ies.bullet.service.webkit.c) tc.c.f22119c.a(com.bytedance.ies.bullet.service.webkit.c.class, this.f6212c);
        if (r36 == null) goto L52;
        Intrinsics.checkNotNullParameter(this, "context");
        r17 = new m(this, r36);
        goto L52
    L12:
        if (this.e == true) goto L17;
        return r16;
    L14:
        hb.a r37 = this.d;
        if (r37 == null) goto L17;
        return r37;
    L7:
        r15 = false;
        goto L8
    }

    public final void e(com.bytedance.ies.bullet.core.e r18, Uri r19, Bundle r20, n r21) {
        com.bytedance.ies.bullet.core.c r5 = r18.f5308w;
        com.bytedance.ies.bullet.core.h r10 = com.bytedance.ies.bullet.core.h.g;
        r5.d = r10.f5317c;
        r10.f5317c = false;
        this.f6211b = c(r19);
        Object r11 = new vd.a(r18.g.f21723a, "force_h5", null).f22372b;
        Boolean r12 = Boolean.TRUE;
        boolean r13 = Intrinsics.areEqual(r11, r12);
        KitType r14 = this.f6211b;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L11
        int r15 = r14.ordinal();     // Catch: Throwable -> L11
        if (r15 == 1) goto L13;
        if (r15 != 3) goto L51;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.lynx.d.class, "clazz");     // Catch: Throwable -> L11
        tc.c r17 = tc.c.f22119c;     // Catch: Throwable -> L11
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.lynx.d.class, this.f6212c) == null) goto L51;
    L15:
        int r22 = r14.ordinal();     // Catch: Throwable -> L11
        if (r22 != 1) goto L18;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.webkit.c.class, "clazz");     // Catch: Throwable -> L11
        com.bytedance.ies.bullet.service.webkit.c r23 = (com.bytedance.ies.bullet.service.webkit.c) tc.c.f22119c.a(com.bytedance.ies.bullet.service.webkit.c.class, this.f6212c);     // Catch: Throwable -> L11
        if (r23 != null) goto L45;
    L50:
        Unit r24 = null;
    L52:
        Result.m124constructorimpl(r24);     // Catch: Throwable -> L11
    L55:
        j r25 = r18.f5306u;
        KitType r26 = KitType.d;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.lynx.d.class, "clazz");
        tc.c r27 = tc.c.f22119c;
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.lynx.d.class, this.f6212c) == null) goto L58;
        boolean r28 = true;
    L59:
        r25.f5319a = r28;
        if (this.f6211b != KitType.f6011b) goto L64;
        boolean r29 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.e(r18.getSessionId(), j0.i(r19, "kitView create failed. reason: kitType is unknown. schema:"), "XView", LogLevel.d);
        r21.r(r19, new IllegalStateException(j0.i(r19, "container_error: No type matches the uri ")));
        return;
    L64:
        if (r18.f5308w.f != null) goto L66;
        ad.a r30 = new ad.a(r19);
        Intrinsics.checkNotNullParameter(r18.getSessionId(), "<set-?>");
        r18.f5303q = r30;
    L66:
        ((rc.a) this.f6210a).b(ad.a.class, r18.f5303q);
        LinkedHashMap r31 = cd.a.f1171a;
        rb.b r32 = cd.a.a(r18.getSessionId());
        ad.a r33 = r18.f5303q;
        Intrinsics.checkNotNullParameter(ad.a.class, "clazz");
        r32.b(ad.a.class, new rb.a(r33, 0));
        r18.f5293c.H();
        if (r13 == false) goto L69;
    L72:
        int r34 = this.f6211b.ordinal();
        if (r34 != 1) goto L75;
        vc.d r35 = null;
        hb.a r36 = d(KitType.f6012c, null);
        if ((r36 instanceof bd.a) == false) goto L82;
        bd.a r37 = (bd.a) r36;
    L83:
        if (r37 != null) goto L85;
        r21.r(r19, new Throwable("container_error: web kitInstance is null"));
    L87:
        if (this.f6211b != r26) goto L102;
        hb.a r38 = d(r26, r18.getSessionId());
        if ((r38 instanceof vc.d) == false) goto L91;
        vc.d r110 = (vc.d) r38;
    L92:
        if (r110 == null) goto L98;
        rb.b r39 = cd.a.a(r18.getSessionId());
        com.bytedance.ies.bullet.core.c r40 = r18.f5308w;
        if (r39.a(io.reactivex.exceptions.a.class) != null) goto L97;
        r40.getClass();
        ((h) r110).e(r19.toString(), new a(r21, r110, this, r18, r20), r18.getSessionId());
        return;
    L97:
        throw new ClassCastException();
    L98:
        boolean r41 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.e(r18.getSessionId(), j0.i(r19, "kitView create failed. reason: lynx not enable. schema:"), "XView", LogLevel.d);
        f(r18, r20, r19, r26, new Throwable(r26 + " not enable"), r21);
        return;
    L91:
        r110 = r35;
        goto L92
    L102:
        return;
    L85:
        ((m) r37).d(r19.toString(), new b(r21, r37), r18.getSessionId());
        goto L87
    L82:
        r37 = null;
        goto L83
    L75:
        if (r34 != 3) goto L104;
        f(r18, r20, r19, this.f6211b, new Throwable("fallback because force h5 = 1"), r21);
        return;
    L104:
        return;
    L69:
        if (this.f6211b == KitType.f6012c) goto L72;
        r35 = null;
        goto L87
    L58:
        r28 = false;
        goto L59
    L45:
        if (r23.f6156c.get() == true) goto L49;
        Intrinsics.checkNotNullParameter(this, "context");     // Catch: Throwable -> L11
        Application r42 = r10.f5316b;     // Catch: Throwable -> L11
        if (r42 == null) goto L49;
        r23.d(r42, r23.d);     // Catch: Throwable -> L11
    L49:
        r24 = Unit.INSTANCE;     // Catch: Throwable -> L11
        goto L52
    L18:
        if (r22 != 3) goto L49;
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.lynx.d.class, "clazz");     // Catch: Throwable -> L11
        com.bytedance.ies.bullet.lynx.d r43 = (com.bytedance.ies.bullet.lynx.d) tc.c.f22119c.a(com.bytedance.ies.bullet.lynx.d.class, this.f6212c);     // Catch: Throwable -> L11
        if (r43 == null) goto L50;
        if (com.bytedance.ies.bullet.lynx.init.h.f5680b == true) goto L25;
        r43.d(this);     // Catch: Throwable -> L11
    L25:
        rd.b r44 = r18.e;     // Catch: Throwable -> L11
        if (r44 == null) goto L50;
        if (Intrinsics.areEqual(new vd.a(r44, "enable_dynamic_v8", Boolean.FALSE).f22372b, r12) == false) goto L41;
        ConcurrentHashMap r45 = yc.a.f23246a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");     // Catch: Throwable -> L11
        xc.e r46 = (xc.e) yc.a.a(xc.e.class, "default_bid");     // Catch: Throwable -> L11
        if (r46 == null) goto L36;
        d r47 = (d) r46.a(d.class);     // Catch: Throwable -> L11
        if (r47 == null) goto L36;
        Boolean r48 = r47.N();     // Catch: Throwable -> L11
        if (r48 == null) goto L36;
        boolean r49 = r48.booleanValue();     // Catch: Throwable -> L11
    L37:
        if (r49 == false) goto L41;
        if (l.f5686a == true) goto L41;
        l.b(false);     // Catch: Throwable -> L11
    L36:
        r49 = true;
    L41:
        r24 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L51:
        boolean r50 = com.bytedance.ies.bullet.service.base.b.f5956a;     // Catch: Throwable -> L11
        com.bytedance.ies.bullet.service.base.b.f(r18.getSessionId(), "check engine init failed. kitType: " + r14, "XView", new Throwable(), LogLevel.d);     // Catch: Throwable -> L11
        r24 = Unit.INSTANCE;     // Catch: Throwable -> L11
        goto L52
    L13:
        Intrinsics.checkNotNullParameter(com.bytedance.ies.bullet.service.webkit.c.class, "clazz");     // Catch: Throwable -> L11
        tc.c r111 = tc.c.f22119c;     // Catch: Throwable -> L11
        if (tc.c.f22119c.a(com.bytedance.ies.bullet.service.webkit.c.class, this.f6212c) == null) goto L51;
    L11:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L55
    }

    public final void f(com.bytedance.ies.bullet.core.e r10, Bundle r11, Uri r12, KitType r13, Throwable r14, n r15) {
        String r5 = null;
        if (c(r12) != KitType.f6012c) goto L5;
        Uri r16 = null;
    L6:
        boolean r17 = com.bytedance.ies.bullet.service.base.b.f5956a;
        String r18 = r10.getSessionId();
        StringBuilder r19 = new StringBuilder("fallback triggered reason: ");
        if (r14 == null) goto L9;
        String r20 = r14.getMessage();
    L10:
        r19.append(r20);
        r19.append(". origin_url:");
        r19.append(r12);
        r19.append(", fallbackUri= ");
        r19.append(r16);
        com.bytedance.ies.bullet.service.base.b.e(r18, r19.toString(), "XView", LogLevel.f5955c);
        if (r16 == null) goto L18;
        StringBuilder r21 = new StringBuilder();
        r21.append(r13);
        r21.append(" load failed,message=");
        if (r14 == null) goto L15;
        r5 = r14.getMessage();
    L15:
        r21.append(r5);
        r15.q(r16, new Throwable(r21.toString()));
        this.e = true;
        e(r10, r16, r11, r15);
        String r22 = r10.getSessionId();
        r16.toString();
        Intrinsics.checkNotNullParameter(r22, "sessionId");
        return;
    L18:
        if (r14 == null) goto L21;
        String r23 = r14.getMessage();
        if (r23 == null) goto L21;
    L22:
        r15.r(r12, new Throwable("container_error: ".concat(r23)));
        return;
    L21:
        r23 = "fall back failed";
        goto L22
    L9:
        r20 = null;
        goto L10
    L5:
        r16 = (Uri) new vd.a(r10.g.f21723a, "fallback_url", 8).f22372b;
        goto L6
    }

    public final void g(com.bytedance.ies.bullet.core.e r10, Uri r11, Bundle r12, n r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.URI_KEY);
        Intrinsics.checkNotNullParameter(r13, "lifeCycle");
        ConcurrentHashMap r5 = u.f5365a;
        u.a(this.f6212c);
        LinkedHashMap r14 = cd.a.f1171a;
        rb.b r15 = cd.a.a(r10.getSessionId());
        ConcurrentHashMap r16 = mb.a.f20054a;
        mb.b r17 = mb.a.a(this.f6212c);
        r10.f = this.f6212c;
        Intrinsics.checkNotNullParameter(mb.b.class, "clazz");
        r15.b(mb.b.class, new rb.a(r17));
        if (r10.B == true) goto L5;
        r10.f5293c.j("lynx_install_dynamic_feature", new BulletContainerLoader$loadUri$1(this));
    L5:
        Uri r18 = (Uri) new vd.a(r10.g.f21723a, "url", 8).f22372b;
        Unit r19 = null;
        String r20 = null;
        List r21 = (List) new vd.a(r10.g.f21723a, "packages", null).f22372b;
        e r22 = r10.f5304r;
        if (r22 == null) goto L8;
        Intrinsics.checkNotNullParameter(r10.getSessionId(), WsConstants.KEY_SESSION_ID);
        rc.a r23 = (rc.a) r22;
        r23.b(wc.f.class, new wc.f(0));
    L8:
        if (r18 == null) goto L33;
        String r24 = (String) new vd.a(r10.g.f21723a, "prefix", null).f22372b;
        if (r24 != null) goto L12;
    L18:
        p r25 = r10.f5305t;
        if (r21 != null) goto L21;
        r21 = CollectionsKt.emptyList();
    L21:
        r25.f288c = r21;
        if (r10.B == true) goto L31;
        Intrinsics.checkNotNullParameter(uc.a.class, "clazz");
        tc.c r26 = tc.c.f22119c;
        if (tc.c.f22119c.a(uc.a.class, this.f6212c) == null) goto L31;
        Intrinsics.checkNotNullParameter(uc.a.class, "clazz");
        if (tc.c.f22119c.a(uc.a.class, this.f6212c) != null) goto L30;
    L32:
        r19 = Unit.INSTANCE;
        goto L33
    L30:
        throw new ClassCastException();
    L31:
        e(r10, r18, r12, r13);
        goto L32
    L12:
        if (TextUtils.isEmpty(r24) == true) goto L14;
        r20 = r24;
    L14:
        if (r20 == null) goto L18;
        e r27 = r10.f5304r;
        if (r27 == null) goto L18;
        rc.a r28 = (rc.a) r27;
        r28.b(wc.b.class, new wc.b(r20));
    L33:
        if (r19 != null) goto L36;
        r13.r(r11, new Throwable("container_error: uri parse failed"));
        return;
    }

    @Override // rc.f
    public final Map getAllDependency() {
        return ((rc.a) this.f6210a).a();
    }

    @Override // rc.f
    public final String getBid() {
        return this.f6212c;
    }

    @Override // rc.f
    public final e getServiceContext() {
        return this.f6210a;
    }
}
