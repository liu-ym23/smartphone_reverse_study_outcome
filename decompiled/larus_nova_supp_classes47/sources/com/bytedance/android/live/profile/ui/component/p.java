package com.bytedance.android.live.profile.ui.component;

import android.graphics.PointF;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.ActionConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ ProfileDynamicOperateComponent a;
    public final /* synthetic */ ActionConfig b;

    public p(ProfileDynamicOperateComponent r1, ActionConfig r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (this.a.C.a().needPerformHapticFeedback() == false) goto L6;
        if (r7 == null) goto L6;
        r7.performHapticFeedback(1, 2);
    L6:
        String r8 = this.b.actionName;
        if (r8 == null) goto L9;
        this.a.C.b().recordBusinessClick(r8, null);
    L9:
        ProfileDynamicOperateComponent r9 = this.a;
        r9.C.a().digg(r9.C.getHostFragment().getContext(), this.b.extraInfo);
        FrameLayout r2 = r9.m();
        if (r2 == null) goto L12;
        int r3 = r2.getWidth();
    L13:
        float r4 = r3 / 2;
        FrameLayout r5 = r9.m();
        if (r5 == null) goto L16;
        int r6 = r5.getHeight();
    L17:
        PointF r0 = new PointF(r4, (r6 - (ProfileDynamicOperateComponent.H / 2)) - ProfileDynamicOperateComponent.I);
        v32.b r10 = r9.p;
        if (r10 == null) goto L21;
        r10.b(r0, false);
        return;
    L21:
        return;
    L16:
        r6 = 0;
        goto L17
    L12:
        r3 = 0;
        goto L13
    }
}
