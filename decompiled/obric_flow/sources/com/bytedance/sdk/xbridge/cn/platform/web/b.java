package com.bytedance.sdk.xbridge.cn.platform.web;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.sdk.xbridge.cn.auth.j;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthPriority;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.bytedance.sdk.xbridge.cn.protocol.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f7409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SSWebView f7410k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j f7411l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final rb.b f7412m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f7413n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList f7414o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f7415p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f7416q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Boolean f7417r;

    public b(Context r5, String r10, SSWebView r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "containerID");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r12, "namespace");
        super(r5, r10);
        this.f7409j = r10;
        this.f7410k = r11;
        j r13 = new j();
        this.f7411l = r13;
        this.f7412m = cd.a.a(r10);
        d(new com.bytedance.sdk.xbridge.cn.auth.c(r13), AuthPriority.f7443b);
        this.f7413n = new d(r10, r11, this, r12);
        this.f7414o = new CopyOnWriteArrayList();
        this.f7415p = LazyKt.lazy(WebBDXBridge$bridgeHandler$2.f7382a);
        this.f7417r = Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final com.bytedance.sdk.xbridge.cn.protocol.f a() {
        return new m.b(7);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final IDLXBridgeMethod.XBridgeThreadType b(bj.a r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        if (Intrinsics.areEqual(this.f7417r, Boolean.FALSE) == true) goto L9;
        ArrayList r10 = this.f7416q;
        if (r10 != null) goto L8;
        return null;
    L8:
        return com.bytedance.sdk.xbridge.cn.optimize.b.a(r10, r5);
    L9:
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final void e(bj.a r5, li.c r10) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r10, "authResult");
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final com.bytedance.sdk.xbridge.cn.protocol.d k() {
        return (a) this.f7415p.getValue();
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.c
    public final void q() {
        this.f7413n.d();
        Iterator r5 = this.f7414o.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((e) r5.next()).e = true;
        goto L4
    L6:
        this.f7414o.clear();
    }

    public final void s(ArrayList r11) {
        Intrinsics.checkNotNullParameter(r11, "blockJsbCallListenerList");
        int r5 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        com.bytedance.ies.bullet.base.utils.logger.a.g("WebBDXBridge", "set custom block jsb call authenticator, listener: " + CollectionsKt.q(r11, ",", null, null, 0, null, WebBDXBridge$setCustomBlockJsbCallAuthenticator$1.f7383a, 30), null, 12);
        d(new com.bytedance.sdk.xbridge.cn.auth.c(this.f7412m, r11), AuthPriority.f7442a);
    }
}
