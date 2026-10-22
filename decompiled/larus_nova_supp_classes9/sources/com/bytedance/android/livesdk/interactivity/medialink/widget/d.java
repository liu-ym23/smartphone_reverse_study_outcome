package com.bytedance.android.livesdk.interactivity.medialink.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements DialogInterface.OnDismissListener {
    public final /* synthetic */ MediaLinkControlWidget a;

    public d(MediaLinkControlWidget r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        this.a.j = null;
    }
}
