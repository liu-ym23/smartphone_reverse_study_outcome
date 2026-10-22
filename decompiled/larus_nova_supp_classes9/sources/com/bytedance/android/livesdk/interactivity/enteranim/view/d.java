package com.bytedance.android.livesdk.interactivity.enteranim.view;

import ak6.g;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.UserDslBadgeUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements UserDslBadgeUtils.a {
    public final /* synthetic */ BaseEnterView a;

    public d(BaseEnterView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.utils.UserDslBadgeUtils.a
    public final void a(g r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "rendResult");
        NoMoreSpaceTextView r0 = this.a.b;
        if (r0 == null) goto L5;
        r0.setText(r2.a);
    L5:
        NoMoreSpaceTextView r4 = this.a.b;
        if (r4 == null) goto L8;
        r4.setAlwaysInvalidate(r3);
    L8:
        this.a.invalidate();
        BaseEnterView r5 = this.a;
        e r6 = r5.g;
        if (r6 == null) goto L12;
        ((UserEnterLevelView) r6).e(r5);
        return;
    }
}
