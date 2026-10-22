package com.bytedance.android.live.liveinteract.videotalk.adapter;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.multilink.base.model.c0;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AdjustGuestPositionListAdapter a;
    public final /* synthetic */ int b;

    public a(AdjustGuestPositionListAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (((c0) ListProtector.get(this.a.c, this.b)).getEnable() == false) goto L8;
        b r4 = this.a.e;
        if (r4 == null) goto L7;
        r4.onItemClick(this.b);
    L7:
        AdjustGuestPositionListAdapter r5 = this.a;
        int r0 = this.b;
        r5.d = r0;
        r5.f = (c0) ListProtector.get(r5.c, r0);
        this.a.notifyDataSetChanged();
        return;
    L8:
        f2.b(2131918719, 0);
    }
}
