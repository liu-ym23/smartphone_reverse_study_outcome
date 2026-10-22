package com.bytedance.ies.bullet.core;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.kit.bridge.IBridge3Registry;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.bytedance.ies.bullet.service.base.m {
    public Uri A;
    public boolean B;
    public boolean C;
    public boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f5292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ies.bullet.service.monitor.b f5293c;
    public k d;
    public volatile rd.b e;
    public String f;
    public rd.e g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f5294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Scenes f5295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Components f5296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Uri f5297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.ies.bullet.service.base.h f5298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public n f5299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f5300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.ies.bullet.core.kit.bridge.d f5301o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IBridge3Registry f5302p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile ad.a f5303q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public rc.e f5304r;
    public final Lazy s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ai.p f5305t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f5306u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c5.a f5307v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f5308w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final l f5309x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final t9.a f5310y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final sj.e f5311z;

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public e() {
        boolean r5 = false;
        this.f5292b = LazyKt.lazy(new BulletContext$logContext$2(this));
        this.f5293c = (com.bytedance.ies.bullet.service.monitor.b) com.bytedance.ies.bullet.service.monitor.c.f6038a.invoke();
        this.d = new k("");
        this.f = "default_bid";
        rd.b r10 = this.e;
        if (r10 != null) goto L5;
        Lazy r11 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r12 = av.i.e();
        String r13 = this.f;
        Uri r14 = Uri.EMPTY;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r14, "url");
        r10 = r12.a(r13, r14, false);
    L5:
        this.g = new rd.e(r10);
        this.f5295i = Scenes.f;
        this.f5296j = Components.e;
        this.f5300n = new ArrayList();
        this.s = LazyKt.lazy(new BulletContext$iBulletAbility$2(this));
        this.f5305t = new ai.p(4);
        this.f5306u = new j();
        this.f5307v = new c5.a(2, r5);
        this.f5308w = new c();
        this.f5309x = new l();
        Intrinsics.checkNotNullParameter(this, "mContext");
        this.f5310y = new t9.a();
        this.f5311z = new sj.e();
        Lazy r15 = com.bytedance.ies.bullet.secure.f.f5904c;
        wn.h.e().getClass();
    }

    public final String getSessionId() {
        String r5 = this.f5291a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("sessionId");
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.base.m
    public final void release() {
        this.f5299m = null;
        this.f5300n.clear();
        this.f5306u.f5320b = null;
        this.f5307v.getClass();
        this.f5304r = null;
        this.f5298l = null;
        this.f5294h = null;
        this.f5301o = null;
        this.f5302p = null;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public e(String r10) {
        boolean r5 = false;
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        this.f5292b = LazyKt.lazy(new BulletContext$logContext$2(this));
        this.f5293c = (com.bytedance.ies.bullet.service.monitor.b) com.bytedance.ies.bullet.service.monitor.c.f6038a.invoke();
        this.d = new k("");
        this.f = "default_bid";
        rd.b r11 = this.e;
        if (r11 != null) goto L5;
        Lazy r12 = com.bytedance.ies.bullet.service.sdk.d.e;
        com.bytedance.ies.bullet.service.sdk.d r13 = av.i.e();
        String r14 = this.f;
        Uri r15 = Uri.EMPTY;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r15, "url");
        r11 = r13.a(r14, r15, false);
    L5:
        this.g = new rd.e(r11);
        this.f5295i = Scenes.f;
        this.f5296j = Components.e;
        this.f5300n = new ArrayList();
        this.s = LazyKt.lazy(new BulletContext$iBulletAbility$2(this));
        this.f5305t = new ai.p(4);
        this.f5306u = new j();
        this.f5307v = new c5.a(2, r5);
        this.f5308w = new c();
        this.f5309x = new l();
        Intrinsics.checkNotNullParameter(this, "mContext");
        this.f5310y = new t9.a();
        this.f5311z = new sj.e();
        Lazy r16 = com.bytedance.ies.bullet.secure.f.f5904c;
        wn.h.e().getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f5291a = r10;
    }
}
