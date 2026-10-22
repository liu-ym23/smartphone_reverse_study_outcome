package com.bytedance.sdk.xbridge.cn.platform.lynx;

import ai.j0;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.lynx.tasm.LynxView;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.bytedance.sdk.xbridge.cn.protocol.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f7359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f7361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f7362m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7363n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final HashSet f7364o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f7365p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f7366q;

    public a(Context r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "containerID");
        super(r5, r10);
        this.f7359j = r10;
        this.f7360k = "";
        this.f7362m = LazyKt.lazy(LynxBDXBridge$bridgeHandler$2.f7358a);
        this.f7364o = new HashSet();
        this.f7366q = Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final com.bytedance.sdk.xbridge.cn.protocol.f a() {
        return new android.support.v4.media.c(this);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final IDLXBridgeMethod.XBridgeThreadType b(bj.a r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        if (Intrinsics.areEqual(this.f7366q, Boolean.FALSE) == true) goto L9;
        List r10 = this.f7365p;
        if (r10 != null) goto L8;
        return null;
    L8:
        return com.bytedance.sdk.xbridge.cn.optimize.b.a(r10, r5);
    L9:
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final boolean j(bj.a r5, com.bytedance.sdk.xbridge.cn.protocol.e r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "callback");
        Lazy r11 = this.f7362m;
        k r12 = (k) r11.getValue();
        String r13 = r5.d;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "namespace");
        r12.f7381b = r13;
        if (this.f7364o.contains(r5.d) == false) goto L6;
        r10.c(((k) r11.getValue()).c(r5, -4, j0.q(new StringBuilder("Namespace "), this.f7360k, " unknown.")));
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final com.bytedance.sdk.xbridge.cn.protocol.d k() {
        return (k) this.f7362m.getValue();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final boolean n() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final void q() {
        if (this.f7361l == null) goto L6;
        t().d();
        return;
    }

    public final void s(LynxView r5) {
        Intrinsics.checkNotNullParameter(r5, "lynxView");
        c r10 = new c(this, r5, this.f7359j, this.f7360k);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7361l = r10;
        c r11 = t();
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        this.f7456h = r11;
        r11.getClass();
        Intrinsics.checkNotNullParameter(kj.a.class, "clazz");
        r11.d.put(kj.a.class, new cj.c(this));
    }

    public final c t() {
        c r5 = this.f7361l;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("lynxBridgeContext");
        return null;
    }
}
