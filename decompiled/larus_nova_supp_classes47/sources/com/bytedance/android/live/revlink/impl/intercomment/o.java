package com.bytedance.android.live.revlink.impl.intercomment;

import android.text.TextUtils;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o implements InteractCommentInviteDialog.a {
    public final /* synthetic */ InteractCommentWidget a;

    @Override // com.bytedance.android.live.revlink.impl.intercomment.InteractCommentInviteDialog.a
    public final void a() {
        InteractCommentWidget r0 = this.a;
        int r1 = InteractCommentWidget.n;
        r0.getClass();
        String r2 = s41.b.c.a().b();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        zz0.h.b(((Widget) r0).context, r2);
    L5:
        this.a.h.c(true);
    }

    public o(InteractCommentWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.intercomment.InteractCommentInviteDialog.a
    public final void b(boolean r4) {
        InteractCommentWidget r0 = this.a;
        if (r0.e == false) goto L5;
        r0.h.d(true, r4);
    L5:
        l51.a.J.setValue(null, l51.a.a[36], Boolean.valueOf(!r4));
        InteractCommentDataContext r5 = this.a.a;
        if (r5 == null) goto L9;
        r5.invite();
        return;
    }
}
