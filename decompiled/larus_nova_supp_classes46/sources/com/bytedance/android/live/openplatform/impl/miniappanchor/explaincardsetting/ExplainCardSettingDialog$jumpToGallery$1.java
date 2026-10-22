package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.app.ProgressDialog;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.impl.base.utils.ImageUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ExplainCardSettingDialog$jumpToGallery$1 implements com.bytedance.android.live.openplatform.impl.base.utils.e {
    public final /* synthetic */ ExplainCardSettingDialog a;

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.e
    public final void onCanceled() {
    }

    public ExplainCardSettingDialog$jumpToGallery$1(ExplainCardSettingDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.utils.e
    public final void a(String r5) {
        if (r5 != null) goto L7;
        f2.b(2131921101, 0);
        return;
    L7:
        if (((ProgressDialog) this.a.g.getValue()).isShowing() == true) goto L13;
        ProgressDialog r1 = (ProgressDialog) this.a.g.getValue();
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r1);
        goto L13
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    L13:
        int r2 = ImageUtils.a;
        ImageUtils.b(this.a, r5, new ExplainCardSettingDialog$jumpToGallery$1$onPicked$1(this), new ExplainCardSettingDialog$jumpToGallery$1$onPicked$2(this), false);
    }
}
