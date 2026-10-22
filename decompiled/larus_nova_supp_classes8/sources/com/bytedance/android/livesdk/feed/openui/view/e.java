package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ LiveListBlock a;
    public final /* synthetic */ Context b;

    public e(LiveListBlock r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        k.n(IHostAction.class).startFeed(this.b, GsonProtectorUtils.toJson(LiveGsonHelper.get(), this.a.g));
    }
}
