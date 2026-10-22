package com.bytedance.android.livesdk.feedback.view.feedback;

import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Observer {
    public final /* synthetic */ RoomQuestionFeedback a;

    public g(RoomQuestionFeedback r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        String r3 = (String) r2;
        HSImageView r4 = this.a.d;
        if (r4 == null) goto L6;
        r4.setVisibility(0);
        return;
    }
}
