package com.bytedance.android.livesdk.chatroom.widget;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.livesdk.message.model.jb;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements View.OnClickListener {
    public final /* synthetic */ FansRankListAnimationWidget a;
    public final /* synthetic */ jb b;

    public a0(FansRankListAnimationWidget r1, jb r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (TextUtils.isEmpty(this.b.getScheme()) == true) goto L8;
        ILiveService r4 = TTLiveService.getLiveService();
        if (r4 == null) goto L9;
        r4.handleSchema(((Widget) this.a).context, UriProtector.parse(this.b.getScheme()));
        return;
    L9:
        return;
    }
}
