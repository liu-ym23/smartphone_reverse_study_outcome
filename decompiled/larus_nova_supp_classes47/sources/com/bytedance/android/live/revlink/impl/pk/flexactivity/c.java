package com.bytedance.android.live.revlink.impl.pk.flexactivity;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.m2;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;
import x31.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements l {
    public final /* synthetic */ d a;
    public final /* synthetic */ com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c b;

    @Override // x31.l
    public final boolean isRequesting(IRoom r1) {
        return false;
    }

    @Override // x31.l
    public final void onCancel(IRoom r1) {
    }

    public c(d r1, com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // x31.l
    public final void onInvite(IRoom r29, int r30, IRivalExtraInfo r32, int r33, m2 r34, List r35, int r36, int r37, String r38, HashMap r39, Boolean r310) {
        r310.booleanValue();
        Intrinsics.checkNotNullParameter(r39, "logMap");
        com.bytedance.android.live.revlink.impl.pk.dialog.fragment.c r1 = this.b;
        if (r1 != null) goto L5;
    L9:
        IPKLinkBizDataService r2 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r2 == null) goto L36;
        long r3 = r29.getId();
        IBaseUser r5 = r29.getOwner();
        if (r5 == null) goto L15;
        String r6 = iz.a.a(r5);
        if (r6 == null) goto L15;
    L16:
        IBaseUser r7 = r29.getOwner();
        if (r7 == null) goto L20;
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        String r8 = r7.getCastSecUid();
        if (r8 == null) goto L20;
    L21:
        String r12 = s1.getContext().getString(2131919635);
        IBattleConfigSetting r15 = f.c(IBattleConfigSetting.class);
        r15.setActivityId(this.a.a);
        Unit r9 = Unit.INSTANCE;
        if (r34 == null) goto L27;
        String r10 = r34.getBattleAttachedInfo();
        if (r10 == null) goto L27;
        String r16 = r10;
    L28:
        e21.b r20 = com.bytedance.android.live.revlink.impl.global.b.h();
        if (r20 == null) goto L31;
        v3 r4 = e21.b.b(r20, com.bytedance.android.live.revlink.impl.pk.utils.l.g.c, null, r38, String.valueOf(r37 + 1), null, null, 112);
    L32:
        String r311 = r6;
        String r312 = r8;
        IPKLinkBizDataService.b.b(r2, r29, r3, r311, r312, 0, r30, new com.bytedance.android.live.revlink.impl.mergepk.pkdouble.f(null, r12, 0, null, 0, r15, r16, 0, 0, r4, null, null, 6973));
        return;
    L31:
        r4 = null;
    L27:
        r16 = "";
    L20:
        r8 = "";
    L15:
        r6 = "";
        goto L16
    L36:
        return;
    L5:
        if (r1.vr() != true) goto L9;
        ToastUtil.a(2131921457, 0);
        LiveFullLinkPKMonitor r13 = com.bytedance.android.live.revlink.impl.global.b.q();
        if (r13 == null) goto L34;
        r13.k("sub_tab_select");
        return;
    }
}
