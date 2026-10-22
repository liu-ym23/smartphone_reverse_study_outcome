package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.livesdk.widget.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ExplainCardSettingDialog a;

    public d(ExplainCardSettingDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r6v7, types: [android.app.Activity, android.content.Context, com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting.ExplainCardSettingDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        ExplainCardSettingDialog r7 = this.a;
        int r0 = ExplainCardSettingDialog.k;
        if (r7.z1().isShowReplaceDialog() == false) goto L18;
        ?? r8 = this.a;
        r8.getClass();
        x0.b r1 = new x0.b(r8, 7);
        r1.j(1, r8.getString(2131920421), new l(r8));
        r1.j(0, r8.getString(2131920422), m.a);
        r1.k(0, true);
        r1.setCornerRadius(16.0f);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r2 = AnchorMiniAppDataContext.a.a();
        if (r2 == null) goto L16;
        com.bytedance.live.datacontext.n<ShelfInfo> r3 = r2.m618getShelfInfo();
        if (r3 == null) goto L16;
        ShelfInfo r4 = (ShelfInfo) r3.getValue();
        if (r4 == null) goto L16;
        if (r4.e() != true) goto L16;
        if (r8.z1().isTalentMount() == true) goto L15;
        r1.m(2131921104);
        r1.l(2131921103);
    L17:
        r1.n();
        return;
    L15:
        r1.m(2131921104);
    L16:
        r1.m(2131920429);
        goto L17
    L18:
        ExplainCardSettingDialog r9 = this.a;
        r9.i = true;
        r9.z1().savePageData();
        this.a.finish();
    }
}
