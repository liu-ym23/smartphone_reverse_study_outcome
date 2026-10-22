package com.bytedance.android.live.revlink.link.core.layoutstatus;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements com.bytedance.android.live.revlink.link.biz.service.c, c<Map<String, ? extends i>> {
    public final boolean a;
    public final String b;
    public final com.bytedance.android.live.revlink.link.infra.rtcbiz.b c;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a d;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.d;
    }

    public j(com.bytedance.android.live.revlink.link.infra.rtcbiz.b r2, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r3) {
        Intrinsics.checkNotNullParameter(r2, "rtcDataContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.c = r2;
        this.d = r3;
        this.a = !y41.a.c.a();
        this.b = "MainBackupStreamSnapShot";
    }
}
