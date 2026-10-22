package com.bytedance.android.live.room.discovery;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k0 implements View.OnClickListener {
    public final /* synthetic */ b1 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ LiveSceneWidget c;

    public k0(b1 r1, String r2, LiveSceneWidget r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        com.bytedance.android.livesdk.user.f r8 = jc1.k.n(IUserService.class).user();
        if (r8.isLogin() == false) goto L5;
    L8:
        LiveSceneWidget r9 = this.c;
        Context r0 = ((Widget) r9).context;
        b1 r2 = this.a;
        int r3 = r2.getActionType();
        if (r3 == 1) goto L18;
        if (r3 != 2) goto L13;
        ita.l r10 = new ita.l(r2.getSchemaUrl());
        r10.c("title", r2.getTitle());
        Uri r12 = UriProtector.parse(r10.d());
        jc1.k.n(ILiveActionHandler.class).handle(r0, r12);
    L30:
        this.c.xq("livesdk_activity_entrance_click", this.b);
        return;
    L13:
        if (r3 != 3) goto L30;
        IBrowserService r13 = jc1.k.n(IBrowserService.class);
        Intrinsics.checkNotNull(r0);
        r13.buildFullScreenWebPage(r0, r2.getSchemaUrl()).setTitle(r2.getTitle()).b();
        goto L30
    L18:
        if (((Boolean) ((Widget) r9).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L21;
        f2.b(2131911602, 0);
        goto L30
    L21:
        if (TTLiveSDK.hostService().user().hasLivePermission() == true) goto L23;
        f2.b(2131911632, 0);
        goto L30
    L23:
        r9.wq("null");
        x0.b r1 = new x0.b(((Widget) r9).context, 4);
        Context r4 = ((Widget) r9).context;
        if (r4 == null) goto L28;
        Resources r5 = r4.getResources();
        if (r5 == null) goto L28;
        String r6 = r5.getString(2131911630);
    L29:
        r1.a.d = r6;
        r1.i(0, 2131911621, new i0(r9, r2));
        r1.i(1, 2131915424, new j0(r9));
        r1.n();
    L28:
        r6 = null;
        goto L29
    L5:
        if (this.a.getActionType() != 1) goto L8;
        Context r14 = ((Widget) this.c).context;
        com.bytedance.android.livesdk.user.l.a r15 = new com.bytedance.android.livesdk.user.l.a();
        r15.a = s1.B(2131915990);
        r15.d = "live";
        r15.c = -1;
        r8.login(r14, new com.bytedance.android.livesdk.user.l(r15)).compose(this.c.getAutoUnbindTransformer()).subscribe(new com.bytedance.android.livesdk.user.h());
    }
}
