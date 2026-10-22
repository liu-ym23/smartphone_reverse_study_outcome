package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.privilege.model.touch.PrivilegeEntranceInfo;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.android.livesdk.revenue.text.RevRenderConfig;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ GiftMVIDetailView a;

    public e(GiftMVIDetailView r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        TouchPositionData r8 = (TouchPositionData) r7;
        a5 r0 = null;
        if (r8 == null) goto L31;
        PrivilegeEntranceInfo r9 = r8.getPrivilegeEntranceInfo();
        if (r9 == null) goto L31;
        String r1 = r9.getPanelUrl();
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L14:
        if ((!r2) == true) goto L17;
        r9 = null;
    L17:
        if (r9 == null) goto L31;
        GiftMVIDetailView r3 = this.a;
        r3.A = r9;
        if (r9.getAwardTips() == null) goto L21;
        ur2.a r4 = vh6.c.b(ur2.a.class);
        a5 r10 = r9.getAwardTips();
        Intrinsics.checkNotNull(r10);
        r4.a4(r10, RevRenderConfig.SyncDecodeContext, new o(r3));
        return;
    L21:
        com.bytedance.android.live.profit.privilege.model.touch.c r5 = r9.getDynamicInfo();
        if (r5 == null) goto L24;
        r0 = r5.b;
    L24:
        if (r0 == null) goto L30;
        com.bytedance.android.live.profit.privilege.model.touch.c r11 = r9.getDynamicInfo();
        Intrinsics.checkNotNull(r11);
        PrivilegeEntranceInfo r6 = r3.A;
        if (r6 != null) goto L28;
        return;
    L28:
        if (r11.b == null) goto L35;
        ur2.a r13 = vh6.c.b(ur2.a.class);
        a5 r14 = r11.b;
        Intrinsics.checkNotNull(r14);
        r13.a4(r14, RevRenderConfig.SyncDecodeContext, new n(r6, r3, r11));
        return;
    L35:
        return;
    L30:
        r3.B(r9.getPanelDetail(), r9.getBubbleText());
        return;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
    L31:
        GiftMVIDetailView r15 = this.a;
        r15.A = null;
        r15.y();
    }
}
