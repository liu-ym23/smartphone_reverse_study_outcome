package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.preview;

import com.bytedance.android.livehostapi.business.depend.openplatform.dux.DuxPopupNoticeConfig;
import com.bytedance.android.livehostapi.business.depend.openplatform.dux.ILiveDuxPopupNotice;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements DuxPopupNoticeConfig.HideCallback {
    public b() {
    }

    public final /* synthetic */ void beforeHide(ILiveDuxPopupNotice r1, int r2) {
        DuxPopupNoticeConfig.HideCallback.-CC.$default$beforeHide(this, r1, r2);
    }

    public final void onHide(ILiveDuxPopupNotice r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "obj");
        int r4 = qo0.a.a;
        qo0.a.c("PreviewShelfManagementActivity", "on explain notice hide, reason: " + r3);
        int r5 = xq0.a.a;
        e r6 = com.bytedance.android.livesdk.sharedpref.b.G3;
        f.d(r6, Integer.valueOf(((Integer) r6.getValue()).intValue() + 1));
    }
}
