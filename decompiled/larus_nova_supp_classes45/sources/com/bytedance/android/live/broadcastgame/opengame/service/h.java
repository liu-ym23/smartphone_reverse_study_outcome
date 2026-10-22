package com.bytedance.android.live.broadcastgame.opengame.service;

import android.content.DialogInterface;
import com.bytedance.android.live.broadcastgame.opengame.dialog.OpenGameReportDialogV1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements DialogInterface.OnDismissListener {
    public final /* synthetic */ OpenGameReportDialogV1 a;
    public final /* synthetic */ ReportService b;

    public h(OpenGameReportDialogV1 r1, ReportService r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        if (this.a.a != 0) goto L6;
        this.b.e.k.g(null);
        return;
    }
}
