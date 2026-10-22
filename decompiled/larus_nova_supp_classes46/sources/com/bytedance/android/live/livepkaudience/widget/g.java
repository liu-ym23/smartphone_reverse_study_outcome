package com.bytedance.android.live.livepkaudience.widget;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.nd1;
import com.bytedance.ies.sdk.widgets.Widget;
import dl0.m;
import hh1.v0;
import java.util.ArrayList;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements rj0.a {
    public final /* synthetic */ h a;

    @Override // rj0.a
    public final boolean a() {
        return true;
    }

    @Override // rj0.a
    public final boolean b() {
        return false;
    }

    @Override // rj0.a
    public final void c() {
    }

    @Override // rj0.a
    public final String getCancelText() {
        return "";
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return "";
    }

    @Override // rj0.a
    public final vc0.a getSurfaceView() {
        m00.g r0 = this.a.a.Lq();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (((Boolean) nd1.a.getValue()).booleanValue() == true) goto L7;
    L9:
        com.bytedance.android.live.pushstream.d r2 = r0.getLiveStream();
        if (r2 == null) goto L13;
        r2.f1("pk audience open beauty dialog", new uv0.a(LiveRequestSourceRole.Business, "LinkPkInteractAudienceGuestWidget.getSurfaceView", null));
    L13:
        return new vc0.a(r0);
    L7:
        if (this.a.a.Nq() == 0) goto L9;
        r0.k();
        goto L9
    }

    @Override // rj0.a
    public final void onCancel() {
        m00.g r0 = this.a.a.y;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        LinkPkInteractAudienceGuestWidget.Jq(this.a.a);
        LinkPkInteractAudienceGuestWidget r1 = this.a.a;
        r1.getClass();
        ArrayList r2 = new ArrayList();
        Context r3 = ((Widget) r1).context;
        if (r3 != null) goto L8;
        r3 = s1.getContext();
    L8:
        OperateType r6 = OperateType.APPLY;
        r2.add(new qh0.f.b(r3, r6, 2));
        Context r4 = ((Widget) r1).context;
        if (r4 != null) goto L11;
        r4 = s1.getContext();
    L11:
        r2.add(new qh0.f.h(r4, r6, 2, 1, r1.a, k.n(IUserService.class).user().n(), null, null, LinkPkInteractAudienceGuestWidget$cancelOpenCamera$1.INSTANCE, 960));
        qh0.f.a(r2).a(new c());
    }

    @Override // rj0.a
    public final void onConfirm() {
        com.bytedance.android.live.livepkaudience.vm.a r0 = this.a.b;
        if (r0 == null) goto L5;
        r0.onSuccess();
    L5:
        m00.g r1 = this.a.a.y;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        LinkPkInteractAudienceGuestWidget.Jq(this.a.a);
        v0 r2 = this.a.a.x;
        if ((r2 instanceof m00.g) == true) goto L11;
        r2 = null;
    L11:
        m00.g r3 = (m00.g) r2;
        if (r3 == null) goto L14;
        r3.r();
    L14:
        m.B(m.a, "check_link_permission_success");
    }

    public g(h r1) {
        this.a = r1;
    }
}
