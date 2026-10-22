package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ LiveHighlightRecordGuideDialog a;

    public k(LiveHighlightRecordGuideDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.B().openPreviewDialog();
    }
}
