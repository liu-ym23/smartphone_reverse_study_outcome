package com.bytedance.android.livesdk.commonpop;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.room.IRoomService;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.live.base.model.push.b a;
    public final /* synthetic */ Context b;

    public e(com.bytedance.android.live.base.model.push.b r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        k.n(IRoomService.class).actionHandler().handle(this.b, this.a.getScheme());
    }
}
