package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.livepkaudience.widget.LinkPkInteractAudienceGuestWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements qh0.d<rh0.a> {
    public final /* synthetic */ BasePkInteractGuestWidget a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ LinkApplyType e;
    public final /* synthetic */ String f;

    @Override // qh0.d
    public final void b(BaseCheckException r2) {
        Intrinsics.checkNotNullParameter(r2, "exception");
        dl0.m.a.getClass();
        dl0.m.v(r2);
    }

    @Override // qh0.d
    public final void onResult(rh0.a r7) {
        int r1 = this.b;
        if (r1 != 1) goto L9;
        com.bytedance.android.live.livepkaudience.service.d.x0.getClass();
        com.bytedance.android.live.livepkaudience.service.d r8 = com.bytedance.android.live.livepkaudience.service.d.a.a();
        if (r8 == null) goto L7;
        m00.g r9 = r8.go();
    L8:
        this.a.Cq(this.b, new a(this, r9));
        return;
    L7:
        r9 = null;
        goto L8
    L9:
        q r0 = this.a.b;
        if (r0 == null) goto L12;
        q.b(r0, r1, this.c, this.d, this.e, this.f);
    L12:
        dl0.m.B(dl0.m.a, "check_link_permission_success");
    }

    public b(LinkPkInteractAudienceGuestWidget r1, int r2, int r3, LinkApplyType r4, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = -1;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
