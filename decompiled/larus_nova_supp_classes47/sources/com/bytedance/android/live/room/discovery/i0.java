package com.bytedance.android.live.room.discovery;

import android.content.DialogInterface;
import android.net.Uri;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveSceneWidget a;
    public final /* synthetic */ b1 b;

    public i0(LiveSceneWidget r1, b1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        this.a.wq("live");
        ita.l r5 = new ita.l(this.b.getSchemaUrl());
        r5.c("title", this.b.getTitle());
        Uri r6 = UriProtector.parse(r5.d());
        jc1.k.n(ILiveActionHandler.class).handle(((Widget) this.a).context, r6);
        r3.dismiss();
    }
}
