package com.bytedance.android.live.effect.beauty.presets;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveBeautyPresetsFragment a;

    public l(LiveBeautyPresetsFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        LiveBeautyPresetsFragment r4 = this.a;
        int r0 = LiveBeautyPresetsFragment.C;
        r4.T90().getClass();
        LiveBeautyPresetsHelper.n("onResetClick:click cancel");
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }
}
