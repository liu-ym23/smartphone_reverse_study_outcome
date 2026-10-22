package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.record.event.HighlightRecordEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u0 implements View.OnClickListener {
    public final /* synthetic */ MarkHighlightController a;

    public u0(MarkHighlightController r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        xs2.b r4 = xs2.b.a();
        int r0 = HighlightRecordEvent.b;
        HighlightRecordEvent r1 = new HighlightRecordEvent();
        r1.a = HighlightRecordEvent.Type.START;
        r4.post(r1);
        this.a.b.J();
    }
}
