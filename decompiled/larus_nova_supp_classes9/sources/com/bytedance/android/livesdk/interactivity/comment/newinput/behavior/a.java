package com.bytedance.android.livesdk.interactivity.comment.newinput.behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputFunctionEnum;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends c {
    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c
    public final int c() {
        return 2131567038;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void k(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2) {
        Intrinsics.checkNotNullParameter(r2, "bridges");
        super.k(r2);
        k22.a.b("live_comment_panel");
    }

    public a(InputFunctionEnum r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "symbol");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3, null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a
    public final void t(View r3, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "bridges");
        super.t(r3, r4);
        String r5 = null;
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j<k22.b> r1 = r0.getAiCloneManager();
        if (r1 == null) goto L12;
        k22.b r2 = (k22.b) r1.getValue();
        if (r2 == null) goto L12;
        AICloneConvItem r6 = r2.a();
        if (r6 == null) goto L11;
        r5 = r6.getSchema();
    L11:
        r2.b(r5, "live_comment_panel");
    L12:
        r4.J();
    }
}
