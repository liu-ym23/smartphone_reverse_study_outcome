package com.bytedance.android.livesdk.interactivity.comment.record.view;

import android.content.Context;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.LiveHighlightRecordGuideDialog;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.RecordGuideContext;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.n;
import com.bytedance.android.livesdk.interactivity.comment.record.viewmodel.HighlightRecordContext;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ LiveHighlightRecordTetris a;

    public b(LiveHighlightRecordTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r10) {
        Boolean r11 = (Boolean) r10;
        HighlightRecordContext r13 = this.a.V();
        if (r13 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r14 = r13.getRecordResponse();
        if (r14 == null) goto L26;
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r3 = r14.a();
        if (r3 == null) goto L27;
        LiveHighlightRecordTetris r15 = this.a;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.b r0 = r15.x;
        if (r0 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.d r1 = r0.a;
        if (r1 == null) goto L15;
        RecordGuideContext r2 = r1.B();
        if (r2 == null) goto L15;
        r2.release();
    L15:
        r15.x = null;
        Context r4 = r15.K().getContext();
        DataCenter r5 = r15.K().h;
        HighlightRecordContext r6 = r15.V();
        if (r6 == null) goto L18;
        long r7 = r6.getStartRecordTimeMs();
    L19:
        HighlightRecordContext r8 = r15.V();
        if (r8 == null) goto L22;
        long r9 = r8.getEndRecordTimeMs();
    L23:
        n r16 = new n(r4, r5, r3, r7, r9);
        int r17 = LiveHighlightRecordGuideDialog.L;
        Intrinsics.checkNotNullParameter(r16, "info");
        RecordGuideContext r18 = new RecordGuideContext(r16.getContext(), r16);
        LiveHighlightRecordGuideDialog r19 = new LiveHighlightRecordGuideDialog(r16.getContext(), r16);
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r19.K = r18;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.b r20 = new com.bytedance.android.livesdk.interactivity.comment.record.guide.b(r19);
        r20.a.show();
        r15.x = r20;
        return;
    L22:
        r9 = p6.b();
        goto L23
    L18:
        r7 = p6.b();
        goto L19
    L27:
        return;
    L26:
        return;
    }
}
