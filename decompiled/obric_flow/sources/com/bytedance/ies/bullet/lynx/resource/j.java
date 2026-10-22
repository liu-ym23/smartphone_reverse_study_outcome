package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import android.text.TextUtils;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ko.r;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends dn.a implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f5773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5775c;
    public final com.bytedance.ies.bullet.lynx.resource.forest.h d;

    public j(com.bytedance.ies.bullet.ui.common.loader.c r5) {
        Intrinsics.checkNotNullParameter(r5, "token");
        this.f5773a = new WeakReference(r5);
        this.f5774b = u8.a.t(this, r5);
        this.f5775c = "forest_sync_load";
        this.d = new com.bytedance.ies.bullet.lynx.resource.forest.h(u8.a.e(this, r5), u8.a.p(this, r5), r5);
    }

    @Override // dn.a
    public final void N(r r10, final go.a r11) {
        if (this.f5774b == false) goto L6;
        this.d.N(r10, r11);
        return;
    L6:
        String r5 = (String) r10.f18728b;
        Map r12 = null;
        if (TextUtils.isEmpty(r5) == false) goto L10;
        r5 = null;
    L10:
        if (r5 == null) goto L24;
        ConcurrentHashMap r13 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        WeakReference r14 = this.f5773a;
        if (r14 == null) goto L16;
        rc.f r15 = (rc.f) r14.get();
        if (r15 == null) goto L16;
        String r16 = r15.getBid();
    L17:
        com.bytedance.ies.bullet.kit.resourceloader.h r17 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r16);
        wc.g r18 = new wc.g("");
        final LynxResourceRequest$LynxResourceType r19 = (LynxResourceRequest$LynxResourceType) r10.f18729c;
        String r20 = u8.a.f(r19);
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r18.f22840i = r20;
        if (r14 == null) goto L22;
        rc.f r21 = (rc.f) r14.get();
        if (r21 == null) goto L22;
        r12 = r21.getAllDependency();
    L22:
        r18.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r12);
        Unit r22 = Unit.INSTANCE;
        r17.a(r5, r18, new DefaultTemplateResourceProvider$fetchSSRData$2$2(r11), new DefaultTemplateResourceProvider$fetchSSRData$2$3(r11, r19));
        return;
    L16:
        r16 = null;
        goto L17
    }

    @Override // dn.a
    public final void O(r r10, final go.a r11) {
        String r5 = (String) r10.f18728b;
        final String r12 = Uri.parse(r5).getQueryParameter(this.f5775c);
        if (r12 != null) goto L6;
        r12 = "0";
    L6:
        if (this.f5774b == false) goto L9;
        this.d.O(r10, r11);
        return;
    L9:
        Map r13 = null;
        if (TextUtils.isEmpty(r5) == false) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L27;
        ConcurrentHashMap r14 = com.bytedance.ies.bullet.kit.resourceloader.g.f5451a;
        WeakReference r15 = this.f5773a;
        if (r15 == null) goto L19;
        rc.f r16 = (rc.f) r15.get();
        if (r16 == null) goto L19;
        String r17 = r16.getBid();
    L20:
        com.bytedance.ies.bullet.kit.resourceloader.h r18 = com.bytedance.ies.bullet.kit.resourceloader.g.a(r17);
        wc.g r19 = new wc.g("");
        final LynxResourceRequest$LynxResourceType r20 = (LynxResourceRequest$LynxResourceType) r10.f18729c;
        String r21 = u8.a.f(r20);
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r19.f22840i = r21;
        if (r15 == null) goto L25;
        rc.f r22 = (rc.f) r15.get();
        if (r22 == null) goto L25;
        r13 = r22.getAllDependency();
    L25:
        r19.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r13);
        Unit r23 = Unit.INSTANCE;
        r18.a(r5, r19, new DefaultTemplateResourceProvider$fetchTemplate$2$2(r12, r20, r11), new DefaultTemplateResourceProvider$fetchTemplate$2$3(r11, r20));
        return;
    L19:
        r17 = null;
        goto L20
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String forestDownloadEngine(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.c(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean hasGeckoModelInfo(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.n(r5);
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final String sessionID(com.bytedance.ies.bullet.core.e r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return r5.getSessionId();
    }

    @Override // com.bytedance.ies.bullet.forest.e
    public final boolean useForest(com.bytedance.ies.bullet.core.e r5) {
        return u8.a.q(r5);
    }
}
