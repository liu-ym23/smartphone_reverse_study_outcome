package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ MediaMultiAnchorStartDialog a;

    public s(MediaMultiAnchorStartDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        Boolean r3 = (Boolean) r2;
        MediaMultiAnchorStartDialog r4 = this.a;
        int r0 = MediaMultiAnchorStartDialog.h;
        r4.U90();
        this.a.updateTitle();
    }
}
