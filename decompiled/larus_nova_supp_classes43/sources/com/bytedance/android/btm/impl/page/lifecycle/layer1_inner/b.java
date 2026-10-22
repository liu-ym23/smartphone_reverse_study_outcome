package com.bytedance.android.btm.impl.page.lifecycle.layer1_inner;

import android.app.Activity;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.model.h;
import com.bytedance.android.btm.impl.setting.BtmSetting;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends BaseBackResumer {
    public static final b e = null;

    static {
        e = new b();
    }

    public b() {
        super(ResumeFuncOrigin.Background, 1029, 1028);
    }

    @Override // com.bytedance.android.btm.impl.page.lifecycle.layer1_inner.BaseBackResumer
    public final void e(Activity r10, h r11) {
        if (BtmSetting.d.c().b().o() != 1) goto L6;
        super.e(r10, r11);
        return;
    L6:
        if (h(r10, r11) == false) goto L8;
        return;
    L8:
        if (i(r11) == false) goto L10;
        return;
    L10:
        if (j(r10, r11) == true) goto L17;
        c(r10, "");
        return;
    }
}
