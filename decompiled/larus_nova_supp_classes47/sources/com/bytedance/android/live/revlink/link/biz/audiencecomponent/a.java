package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.PkBaseDataContext;
import com.bytedance.android.live.revlink.link.biz.component.MultiPKContextHolder;
import com.bytedance.android.live.revlink.link.biz.service.i;
import com.bytedance.android.livesdk.link.model.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.live.revlink.link.biz.service.d {
    public final String a;
    public final d21.b b;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b c;
    public final String d;
    public final MultiPKContextHolder e;

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAudienceComponent";
    }

    public final void a() {
        d21.b r0 = this.b;
        p r1 = i.t(this).getGuestInfo(this.d, null);
        String r2 = "";
        if (r1 == null) goto L8;
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L8;
        String r4 = r3.getNickName();
        if (r4 == null) goto L8;
    L9:
        r0.getClass();
        String r5 = d21.b.a(r4);
        PkBaseDataContext r6 = this.e.c.getBasePKContext();
        p r7 = i.t(this).getGuestInfo(this.d, null);
        if (r7 == null) goto L16;
        String r8 = r7.getLinkMicIdStr();
        if (r8 == null) goto L16;
        r2 = r8;
    L16:
        if (r6.isInAudioPunish(r2) == false) goto L19;
        int r9 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r10 = com.bytedance.live.kmp.util.c.a;
        int r12 = w11.a.a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131921811, new Object[]{r5}), 0);
        return;
    L19:
        int r13 = ToastUtil.a;
        com.bytedance.live.kmp.util.c r14 = com.bytedance.live.kmp.util.c.a;
        int r15 = w11.a.a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(2131917486, new Object[]{r5}), 0);
        return;
    L8:
        r4 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.d, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b getContext() {
        return this.c;
    }

    public a(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r2, String r3, MultiPKContextHolder r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r4, "pkContextHolder");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = "AudienceWindowBizImpl";
        this.b = new d21.b();
    }
}
