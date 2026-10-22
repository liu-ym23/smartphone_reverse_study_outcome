package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import com.bytedance.android.livesdk.link.model.IBattleUserInfo;
import com.bytedance.android.livesdk.link.model.f2;
import com.bytedance.android.livesdk.link.model.k0;
import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileClickPos;
import com.bytedance.android.livesdk.revenue.service.datacenter.UserProfileReportType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ NewPkRecordViewHolder a;
    public final /* synthetic */ f2 b;

    public f(NewPkRecordViewHolder r1, f2 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        NewPkRecordViewHolder r10 = this.a;
        IBattleUserInfo r0 = this.b.getBattleUserInfo();
        if (r0 == null) goto L7;
        k0 r1 = r0.getUserInfo();
        if (r1 == null) goto L7;
        String r2 = r1.getUserId();
    L8:
        String r3 = r2;
        r10.getClass();
        wq2.f r4 = ma1.a.a();
        if (r4 == null) goto L12;
        wq2.f.a.a(r4, r3, UserProfileClickPos.POSITION_PK_HISTORY_RECORD, "pk", UserProfileReportType.DATA_TYPE_CARD_PK_ANCHOR, 1, 64);
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    }
}
