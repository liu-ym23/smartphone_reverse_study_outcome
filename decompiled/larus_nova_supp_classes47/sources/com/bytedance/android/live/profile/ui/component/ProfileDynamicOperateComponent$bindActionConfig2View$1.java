package com.bytedance.android.live.profile.ui.component;

import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.ActionConfig;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfileDynamicOperateComponent$bindActionConfig2View$1 implements View.OnClickListener {
    public final /* synthetic */ ProfileDynamicOperateComponent a;
    public final /* synthetic */ ActionConfig b;
    public final /* synthetic */ View c;
    public final /* synthetic */ HSImageView d;
    public final /* synthetic */ Space e;
    public final /* synthetic */ TextView f;
    public final /* synthetic */ int g;

    public ProfileDynamicOperateComponent$bindActionConfig2View$1(ProfileDynamicOperateComponent r1, ActionConfig r2, View r3, HSImageView r4, Space r5, TextView r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        String r10 = this.b.actionName;
        if (r10 == null) goto L5;
        this.a.C.b().recordBusinessClick(r10, null);
    L5:
        ProfileDynamicOperateComponent r2 = this.a;
        String r3 = this.b.getClickSchema();
        ActionConfig r12 = this.b;
        boolean r13 = ProfileDynamicOperateComponent.a(r2, r3, r12.enable, r12.tips, r12.actionType);
        final Function0<Unit> r0 = new ProfileDynamicOperateComponent$bindActionConfig2View$1$successAction$1(this);
        ActionConfig r1 = this.b;
        long r4 = r1.actionType;
        if (r4 != ActionConfig.TYPE_INVITE_ADVENTURE) goto L9;
        this.a.C.a().getLogUseCaseForUi().i();
    L23:
        if (r13 == false) goto L26;
        r0.invoke();
        return;
    L26:
        return;
    L9:
        if (r4 != ActionConfig.TYPE_CHECK_ADVENTURE) goto L12;
        this.a.C.a().getLogUseCaseForUi().h();
        goto L23
    L12:
        if (r4 != ActionConfig.TYPE_LINK) goto L15;
        this.a.C.a().getLogUseCaseForUi().m("click");
        goto L23
    L15:
        if (r4 != ActionConfig.TYPE_GUEST_LINK_INVITE) goto L18;
        this.a.C.a().getLogUseCaseForUi().j();
        goto L23
    L18:
        if (r4 != ActionConfig.TYPE_SECRET_CHAT) goto L21;
        ProfileDynamicOperateComponent.h(this.a);
        goto L23
    L21:
        if (r4 != ActionConfig.TYPE_HEART) goto L23;
        ProfileDynamicOperateComponent.c(this.a, r1, new AnonymousClass2(r0));
        r13 = false;
        goto L23
    }
}
