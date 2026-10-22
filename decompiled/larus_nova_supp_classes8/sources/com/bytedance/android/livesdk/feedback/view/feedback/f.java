package com.bytedance.android.livesdk.feedback.view.feedback;

import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ RoomQuestionFeedback a;

    public f(RoomQuestionFeedback r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == true) goto L10;
        HSImageView r3 = this.a.d;
        if (r3 == null) goto L9;
        r3.setVisibility(0);
        return;
    L9:
        return;
    }
}
