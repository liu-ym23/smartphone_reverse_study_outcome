package com.bytedance.ies.bullet.core;

import ai.j0;
import com.bytedance.ies.bullet.service.base.YieldError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ies.bullet.core.kit.bridge.d f5272c;
    public e d;

    public a() {
        this.f5270a = new LinkedHashMap();
        this.f5271b = new ArrayList();
    }

    public final String a() {
        e r5 = this.d;
        if (r5 == null) goto L8;
        String r10 = r5.f;
        if (r10 == null) goto L10;
        return r10;
    L10:
        return "default_bid";
    L8:
        return "default_bid";
    }

    public final void b(final pb.a r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeService");
        LinkedHashMap r5 = cd.a.f1171a;
        e r11 = this.d;
        if (r11 == null) goto L5;
        String r12 = r11.getSessionId();
    L6:
        rb.b r13 = cd.a.a(r12);
        e r14 = this.d;
        ((com.ivy.ivykit.plugin.impl.jsb.c) r10).getClass();
        Intrinsics.checkNotNullParameter(r13, "providerFactory");
        List r15 = CollectionsKt.emptyList();
        Function1<rb.b, List<? extends com.bytedance.ies.bullet.core.kit.bridge.b>> r16 = new BaseEngineGlobalConfig$createOrMergeBridgeRegistry$1(r10);
        Intrinsics.checkNotNullParameter(r13, "providerFactory");     // Catch: YieldError -> L20
    L8:
        com.bytedance.ies.bullet.core.kit.bridge.d r17 = new com.bytedance.ies.bullet.core.kit.bridge.d(r14, r15, r16, r13);
        com.bytedance.ies.bullet.core.kit.bridge.d r18 = this.f5272c;
        if (r18 != null) goto L11;
        this.f5272c = r17;
        return;
    L11:
        Intrinsics.checkNotNullParameter(r17, "otherRegistry");
        Iterator r19 = r17.d.entrySet().iterator();
    L13:
        if (r19.hasNext() == false) goto L18;
        Map.Entry r20 = (Map.Entry) r19.next();
        LinkedHashMap r21 = r18.d;
        if (r21.containsKey(r20.getKey()) == true) goto L16;
        r21.put(r20.getKey(), r20.getValue());
        goto L13
    L16:
        j0.A(r21.get(r20.getKey()));
        goto L13
    L18:
        ((List) r18.f.getValue()).add(new com.bytedance.ies.bullet.core.kit.bridge.a(r17));
        return;
    L5:
        r12 = null;
        goto L6
    }

    public void c() {
        if (this.f5270a.isEmpty() == true) goto L5;
        this.f5270a.clear();
    L5:
        LinkedHashMap r5 = this.f5270a;
        r5.put("bullet_version", "9.0.0");
        r5.put("bulletVersion", "9.0.0");
        e r10 = this.d;
        String r11 = "";
        if (r10 == null) goto L9;
        String r12 = r10.getSessionId();
        if (r12 == null) goto L9;
    L10:
        r5.put("containerID", r12);
        e r13 = this.d;
        if (r13 == null) goto L15;
        com.bytedance.ies.bullet.service.monitor.b r14 = r13.f5293c;
        if (r14 == null) goto L15;
        LinkedHashMap r15 = r14.b();
    L16:
        r5.putAll(r15);
        e r16 = this.d;
        if (r16 == null) goto L24;
        ad.a r17 = r16.f5303q;
        if (r17 == null) goto L24;
        String r18 = r17.a();
        if (r18 == null) goto L24;
        r11 = r18;
    L24:
        r5.put("resolvedUrl", r11);
        ((com.bytedance.android.anniex.base.depend.b) com.bytedance.android.anniex.base.depend.a.f3113b.getValue()).getClass();
        r5.put("isPreInstallApp", 0);
        return;
    L15:
        r15 = new LinkedHashMap();
    L9:
        r12 = "";
        goto L10
    }
}
