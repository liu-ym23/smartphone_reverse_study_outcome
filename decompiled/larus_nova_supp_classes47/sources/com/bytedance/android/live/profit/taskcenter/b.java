package com.bytedance.android.live.profit.taskcenter;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b extends DialogInterface.OnDismissListener {
    @Override // android.content.DialogInterface.OnDismissListener
    void onDismiss(DialogInterface r1);

    void readyToShow();

    void showing(DialogInterface r1);

    void waiting();
}
