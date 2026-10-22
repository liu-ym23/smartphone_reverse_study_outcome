package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ LiveHashtagWidget a;

    public z(LiveHashtagWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        f2.b(2131915799, 0);
        LiveHashtagWidget.wq(this.a);
    }
}
