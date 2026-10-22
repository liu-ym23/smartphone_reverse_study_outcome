package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static yb2.a a(@Nullable DataCenter r6) {
        yb2.a r0 = w.a();
        r0.a = InteractivityOpt.b(2131108470, new a());
        gd0.n r1 = jc1.k.f(gd0.n.class);
        boolean r2 = false;
        if (r6 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        if (r1 != null) goto L10;
    L12:
        if (r7 == true) goto L14;
        if (r2 == true) goto L14;
    L15:
        return r0;
    L14:
        r0.k = true;
        goto L15
    L10:
        if (r1.isAudienceLinkEngineOn() == false) goto L12;
        r2 = true;
        goto L12
    L5:
        if (((Boolean) r6.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L7;
        r7 = true;
        goto L8
    }

    public static void b(TextView r1, va.a r2, DataCenter r3) {
        if (r1 == null) goto L13;
        a5 r4 = r2.getText();
        if (r4 == null) goto L7;
        String r0 = r4.getDefaultPattern();
    L8:
        if (r0 == null) goto L10;
        r1.setText(sb2.a.g(r0, r4, a(r3)).a);
        return;
    L10:
        Logger.e("I18N_MESSAGE", "pattern is null");
        return;
    L7:
        r0 = null;
        goto L8
    }
}
