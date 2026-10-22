package com.bytedance.android.livesdk.interactivity.comment.newinput;

import android.widget.EditText;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements QuickCommentView.a {
    public final /* synthetic */ OGCFixedInputDialog a;

    public q(OGCFixedInputDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView.a
    public final void a(QuickCommentView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a.dismissInputDialog();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.business.quickcomment.QuickCommentView.a
    public final void b(IQuickCommentShowWord r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        OGCFixedInputDialog r0 = this.a;
        r0.C = true;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = r0.g;
        if (r1 == null) goto L7;
        EditText r2 = r1.a;
        if (r2 == null) goto L7;
        r2.setText(r3.getContent());
    L7:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4 = this.a.g;
        if (r4 == null) goto L10;
        r4.p0();
    L10:
        OGCFixedInputDialog r5 = this.a;
        r5.C = false;
        r5.dismissInputDialog();
    }
}
