package com.bytedance.android.livesdk.commerce;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.utils.V3Utils;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ LiveGoodsDialogFragment.e a;
    public final /* synthetic */ d b;

    public f(LiveGoodsDialogFragment.e r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        String r5 = V3Utils.TYPE.access$000(V3Utils.TYPE.CLICK);
        HashMap r0 = new HashMap();
        r0.put("event_type", r5);
        r0.put("event_belong", "");
        r0.put("event_page", "");
        r0.put("room_id", String.valueOf(this.a.a.e));
        r0.put("anchor_id", String.valueOf(this.a.a.d));
        r0.put("commodity_id", this.b.e());
        TTLiveSDKContext.getHostService().f().logV3("hotsoonlive_commodity_click", r0);
        TTLiveSDKContext.getHostService().a().handleSchema(this.a.a.getActivity(), this.b.b(), new Bundle());
    }
}
