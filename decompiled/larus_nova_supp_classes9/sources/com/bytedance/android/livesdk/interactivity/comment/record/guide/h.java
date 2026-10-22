package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements DialogInterface.OnCancelListener {
    public final /* synthetic */ LiveHighlightRecordGuideDialog a;

    public h(LiveHighlightRecordGuideDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r1) {
        if (this.a.B().isPublishLoading() == true) goto L6;
        this.a.B().release();
        return;
    }
}
