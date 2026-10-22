package com.bytedance.android.live.livepkaudience.dialog;

import android.text.TextUtils;
import android.widget.Button;
import com.bytedance.android.live.livepkaudience.view.PkWithAudienceFeedbackView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements PkWithAudienceFeedbackView.a {
    public final /* synthetic */ PkWithAudienceFeedbackDialog a;

    @Override // com.bytedance.android.live.livepkaudience.view.PkWithAudienceFeedbackView.a
    public final void a() {
        PkWithAudienceFeedbackDialog r0 = this.a;
        int r1 = PkWithAudienceFeedbackDialog.m;
        r0.W90();
        if (TextUtils.isEmpty(((PkWithAudienceFeedbackView) this.a.S90(2131372320)).getSelectedTag()) == false) goto L7;
        Button r2 = (Button) this.a.S90(2131389780);
        if (r2 == null) goto L11;
        r2.setAlpha(0.34f);
        return;
    L11:
        return;
    L7:
        Button r3 = (Button) this.a.S90(2131389780);
        if (r3 == null) goto L13;
        r3.setAlpha(1.0f);
        return;
    }

    public s(PkWithAudienceFeedbackDialog r1) {
        this.a = r1;
    }
}
