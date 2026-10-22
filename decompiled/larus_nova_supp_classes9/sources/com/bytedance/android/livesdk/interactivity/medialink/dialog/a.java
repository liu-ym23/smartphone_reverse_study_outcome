package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.view.View;
import com.bytedance.android.livesdk.p8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ MediaAnchorInteractContainerFragment a;

    public a(MediaAnchorInteractContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        int r3 = MediaMultiAnchorStartDialog.h;
        p8.a(new MediaMultiAnchorStartDialog(), this.a.getContext());
        MediaAnchorInteractContainerFragment r4 = this.a;
        int r0 = MediaAnchorInteractContainerFragment.h;
        r4.d.dismiss();
    }
}
