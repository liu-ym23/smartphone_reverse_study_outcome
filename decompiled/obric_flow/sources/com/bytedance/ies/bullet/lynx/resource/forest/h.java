package com.bytedance.ies.bullet.lynx.resource.forest;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.w;
import com.bytedance.ies.bullet.forest.u;
import com.lynx.tasm.resourceprovider.LynxResourceRequest$LynxResourceType;
import ko.r;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends dn.a implements com.bytedance.ies.bullet.forest.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ies.bullet.ui.common.loader.c f5764c;

    public h(String r5, String r10, com.bytedance.ies.bullet.ui.common.loader.c r11) {
        Intrinsics.checkNotNullParameter(r5, "downloadEngine");
        this.f5762a = r5;
        this.f5763b = r10;
        this.f5764c = r11;
    }

    @Override // dn.a
    public final void N(r r10, final go.a r11) {
        String r5 = (String) r10.f18728b;
        if (TextUtils.isEmpty(r5) == true) goto L5;
    L4:
        String r12 = r5;
        if (r12 == null) goto L12;
        zm.c r13 = com.bytedance.ies.bullet.forest.f.f5397a;
        wc.g r14 = new wc.g("");
        final LynxResourceRequest$LynxResourceType r15 = (LynxResourceRequest$LynxResourceType) r10.f18729c;
        String r16 = u8.a.f(r15);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r14.f22840i = r16;
        com.bytedance.ies.bullet.ui.common.loader.c r17 = this.f5764c;
        if (r17 == null) goto L10;
        r14.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r17.getAllDependency());
    L10:
        Scene r18 = u8.a.l(r15);
        Function1<w, Unit> r19 = new ForestTemplateResourceProvider$fetchSSRData$2$2(r11, r15);
        com.bytedance.ies.bullet.forest.f.e(r12, this.f5762a, r18, this.f5763b, r14, null, r19, 193);
        return;
    L12:
        return;
    L5:
        r5 = null;
        goto L4
    }

    @Override // dn.a
    public final void O(r r14, final go.a r15) {
        String r5 = (String) r14.f18728b;
        final String r10 = Uri.parse(r5).getQueryParameter("forest_sync_load");
        if (r10 != null) goto L6;
        r10 = "0";
    L6:
        if (TextUtils.isEmpty(r5) == true) goto L8;
        String r11 = r5;
    L9:
        if (r11 == null) goto L15;
        zm.c r12 = com.bytedance.ies.bullet.forest.f.f5397a;
        wc.g r13 = new wc.g("");
        final LynxResourceRequest$LynxResourceType r16 = (LynxResourceRequest$LynxResourceType) r14.f18729c;
        String r17 = u8.a.f(r16);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r13.f22840i = r17;
        com.bytedance.ies.bullet.ui.common.loader.c r18 = this.f5764c;
        if (r18 == null) goto L13;
        r13.f22846o = com.bytedance.ies.bullet.base.utils.b.e(r18.getAllDependency());
    L13:
        com.bytedance.ies.bullet.forest.f.d(r11, this.f5762a, u8.a.l(r16), this.f5763b, r13, new u(null, 3), null, new ForestTemplateResourceProvider$fetchTemplate$2$2(r16, r10, r15, this), 321);
        return;
    L15:
        return;
    L8:
        r11 = null;
        goto L9
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
