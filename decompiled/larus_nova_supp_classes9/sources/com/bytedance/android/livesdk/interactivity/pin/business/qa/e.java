package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnLongClickListener {
    public final /* synthetic */ HighlightItem.a a;

    public e(HighlightItem.a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        g42.i.a(new j42.e(this.a));
        return true;
    }
}
