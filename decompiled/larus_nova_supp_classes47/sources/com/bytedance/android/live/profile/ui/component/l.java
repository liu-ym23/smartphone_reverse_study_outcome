package com.bytedance.android.live.profile.ui.component;

import android.view.View;
import com.bytedance.android.live.base.model.user.ActionConfig;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ ProfileDynamicOperateComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ActionConfig c;
    public final /* synthetic */ String d;

    public l(ProfileDynamicOperateComponent r1, String r2, ActionConfig r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        String r10 = this.b;
        if (r10 == null) goto L8;
        com.bytedance.android.live.profile.profilecontext.a r0 = this.a.C.b();
        String r1 = this.c.title;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r0.recordBusinessClick(r10, MapsKt.mapOf(TuplesKt.to("analyze_text", r1)));
    L8:
        ProfileDynamicOperateComponent r2 = this.a;
        String r3 = this.c.getClickSchema();
        ActionConfig r12 = this.c;
        ProfileDynamicOperateComponent.a(r2, r3, r12.enable, r12.tips, r12.actionType);
        this.a.C.a().getLogUseCaseForUi().k(this.d);
    }
}
