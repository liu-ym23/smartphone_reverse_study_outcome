package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ HighlightItem.c a;

    public c(HighlightItem.c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        g42.i.a(new e42.b(this.a));
        return true;
    }
}
