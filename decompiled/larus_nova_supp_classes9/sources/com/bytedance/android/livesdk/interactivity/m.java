package com.bytedance.android.livesdk.interactivity;

import android.view.View;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ LeftAvatarWidget a;
    public final /* synthetic */ com.bytedance.android.live.base.model.user.e b;

    public m(LeftAvatarWidget r1, com.bytedance.android.live.base.model.user.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        String r6 = this.b.getSchema();
        if (r6 != null) goto L5;
        return;
    L5:
        if (r2.a(r6) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L14;
        LeftAvatarWidget r0 = this.a;
        com.bytedance.android.live.base.model.user.e r1 = this.b;
        int r2 = LeftAvatarWidget.n;
        r0.Bq("click", r1, "number");
        IBaseLiveActionHandler r3 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r3 == null) goto L15;
        r3.handle(((Widget) this.a).context, r6);
        return;
    L15:
        return;
    }
}
