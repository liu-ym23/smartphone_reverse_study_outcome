package com.bytedance.android.livesdk.interactivity.comment.record.view;

import com.bytedance.android.livesdk.interactivity.comment.record.event.HighlightRecordEvent;
import com.bytedance.android.livesdk.interactivity.comment.record.viewmodel.HighlightRecordContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LiveHighlightRecordTetris a;

    public e(LiveHighlightRecordTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        HighlightRecordEvent r5 = (HighlightRecordEvent) r4;
        LiveHighlightRecordTetris r0 = this.a;
        r0.getClass();
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.getType() != HighlightRecordEvent.Type.START) goto L11;
        HighlightRecordContext r6 = r0.V();
        if (r6 == null) goto L14;
        r6.reqRecord(true);
        return;
    L14:
        return;
    L11:
        if (r5.getType() != HighlightRecordEvent.Type.STOP) goto L16;
        LiveHighlightRecordTetris.StopType r7 = LiveHighlightRecordTetris.StopType.OverTime;
        r0.Z();
        return;
    }
}
