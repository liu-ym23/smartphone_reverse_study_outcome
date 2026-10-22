package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements PopupWindow.OnDismissListener {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.a.b.onDismiss();
    }
}
