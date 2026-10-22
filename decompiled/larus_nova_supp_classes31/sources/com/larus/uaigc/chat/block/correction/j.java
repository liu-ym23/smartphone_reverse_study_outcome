package com.larus.uaigc.chat.block.correction;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ CorrectionImageView a;

    public /* synthetic */ j(CorrectionImageView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CorrectionImageView r0 = this.a;
        SimpleDraweeView r1 = r0.a;
        if (r1 == null) goto L5;
        r1.setAlpha(1.0f);
    L5:
        ShimmerTextView r2 = r0.f;
        if (r2 == null) goto L8;
        r2.x();
    L8:
        ConstraintLayout r3 = r0.d;
        if (r3 == null) goto L12;
        e1.o(r3);
        return;
    }
}
