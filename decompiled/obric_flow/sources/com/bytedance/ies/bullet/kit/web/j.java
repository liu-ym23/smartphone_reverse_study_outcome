package com.bytedance.ies.bullet.kit.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends com.bytedance.ies.bullet.core.a {
    public com.ivy.ivykit.plugin.impl.web.i e;
    public final ArrayList f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f5533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f5534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.ivy.ivykit.plugin.impl.web.b f5535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.lynx.animax.player.b f5536k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f5537l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f5538m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f5539n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f5540o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LinkedHashMap f5541p;

    public j() {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.f5533h = new ArrayList();
        this.f5534i = new ArrayList();
        this.f5537l = new ArrayList();
        this.f5538m = new ArrayList();
        this.f5539n = new ArrayList();
        this.f5540o = new ArrayList();
        this.f5541p = new LinkedHashMap();
    }

    @Override // com.bytedance.ies.bullet.core.a
    public final void c() {
        super.c();
        LinkedHashMap r5 = cd.a.f1171a;
        com.bytedance.ies.bullet.core.e r10 = this.d;
        if (r10 == null) goto L5;
        String r11 = r10.getSessionId();
    L6:
        rb.b r12 = cd.a.a(r11);
        Iterator r13 = this.f.iterator();
    L8:
        if (r13.hasNext() == false) goto L11;
        ((com.ivy.ivykit.plugin.impl.web.i) r13.next()).getClass();
        Intrinsics.checkNotNullParameter(r12, "providerFactory");
        Intrinsics.checkNotNullParameter(r12, "providerFactory");
        goto L8
    L11:
        if (this.e == null) goto L15;
        Intrinsics.checkNotNullParameter(r12, "providerFactory");
        Intrinsics.checkNotNullParameter(r12, "providerFactory");
        return;
    L15:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void d(com.bytedance.ies.bullet.core.e r5, List r10) {
        Intrinsics.checkNotNullParameter(r5, "bulletContext");
        Intrinsics.checkNotNullParameter(r10, "packageNames");
        Intrinsics.checkNotNullParameter(r5, "bulletContext");
        Intrinsics.checkNotNullParameter(r10, "packageNames");
        this.d = r5;
        if (r5.C != true) goto L13;
        tc.c r11 = tc.c.f22119c;
        this.e = (com.ivy.ivykit.plugin.impl.web.i) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.web.i.class, a());
        Iterator r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L12;
        String r13 = (String) r12.next();
        tc.c r14 = tc.c.f22119c;
        com.ivy.ivykit.plugin.impl.web.i r15 = (com.ivy.ivykit.plugin.impl.web.i) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.web.i.class, r13);
        if (r15 == null) goto L6;
        if (Intrinsics.areEqual(r15.f22117a, a()) == true) goto L6;
        this.f.add(r15);
        goto L6
    L12:
        return;
    L13:
        tc.c r16 = tc.c.f22119c;
        this.e = (com.ivy.ivykit.plugin.impl.web.i) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.web.i.class, a());
        Iterator r17 = r10.iterator();
    L15:
        if (r17.hasNext() == false) goto L21;
        String r18 = (String) r17.next();
        tc.c r19 = tc.c.f22119c;
        com.ivy.ivykit.plugin.impl.web.i r20 = (com.ivy.ivykit.plugin.impl.web.i) tc.c.f22119c.a(com.ivy.ivykit.plugin.impl.web.i.class, r18);
        if (r20 == null) goto L15;
        if (Intrinsics.areEqual(r20.f22117a, a()) == true) goto L15;
        this.f.add(r20);
        goto L15
    L21:
        LinkedHashMap r21 = cd.a.f1171a;
        final rb.b r22 = cd.a.a(r5.getSessionId());
        Function1<com.ivy.ivykit.plugin.impl.web.i, Unit> r23 = new WebEngineGlobalConfig$config$handler$1(r22, this);
        Iterator r24 = this.f.iterator();
    L23:
        if (r24.hasNext() == false) goto L26;
        com.ivy.ivykit.plugin.impl.web.i r25 = (com.ivy.ivykit.plugin.impl.web.i) r24.next();
        r25.getClass();
        Intrinsics.checkNotNullParameter(r22, "providerFactory");
        r23.invoke(r25);
        goto L23
    L26:
        if (this.e == null) goto L28;
        Intrinsics.checkNotNullParameter(r22, "providerFactory");
    L28:
        com.ivy.ivykit.plugin.impl.web.i r26 = this.e;
        if (r26 == null) goto L31;
        r23.invoke(r26);
    L31:
        hc.c r27 = (hc.c) r22.a(hc.c.class);
        if (r27 == null) goto L34;
        this.g.add(r27);
    L34:
        hc.b r28 = (hc.b) r22.a(hc.b.class);
        if (r28 == null) goto L37;
        this.f5533h.add(r28);
    L37:
        Function1<com.ivy.ivykit.plugin.impl.web.i, Unit> r29 = new WebEngineGlobalConfig$config$settingsHandler$1(this, r22);
        Iterator r30 = this.f.iterator();
    L39:
        if (r30.hasNext() == false) goto L41;
        r29.invoke((com.ivy.ivykit.plugin.impl.web.i) r30.next());
        goto L39
    L41:
        com.ivy.ivykit.plugin.impl.web.i r31 = this.e;
        if (r31 == null) goto L44;
        r29.invoke(r31);
    L44:
        r5.f5301o = this.f5272c;
        r5.f5300n.clear();
        ArrayList r32 = this.f5271b;
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r5.f5300n = r32;
    }
}
