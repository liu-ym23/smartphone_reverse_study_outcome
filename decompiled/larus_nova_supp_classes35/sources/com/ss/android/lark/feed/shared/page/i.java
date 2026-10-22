package com.ss.android.lark.feed.shared.page;

import android.content.DialogInterface;
import com.ss.android.lark.feed.shared.hitpoint.FeedHitPointNew;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements DialogInterface.OnClickListener {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        com.ss.android.lark.feed.shared.hitpoint.a.b(false);
        FeedHitPointNew.a(FeedHitPointNew.FeedDelayedPopupClickParam.ESC);
    }
}
