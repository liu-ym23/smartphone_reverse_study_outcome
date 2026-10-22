package com.bytedance.android.livesdk.feedback.view.feedback;

import android.view.View;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.feedback.FeedbackContext;
import com.bytedance.android.livesdk.feedback.view.preview.SmallCardReplaceViewGroup;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ SmallCardPreviewFeedback a;

    public h(SmallCardPreviewFeedback r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        SmallCardReplaceViewGroup r7 = this.a.a;
        if (r7 == null) goto L5;
        r7.c();
    L5:
        this.a.d();
        SmallCardPreviewFeedback r8 = this.a;
        r8.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        FeedbackContext.a r1 = FeedbackContext.Companion;
        int r2 = r8.hashCode();
        r1.getClass();
        FeedbackContext r3 = FeedbackContext.a.a(r2);
        String r4 = "";
        if (r3 == null) goto L9;
        String r5 = r3.getEnterFromMerge();
        if (r5 == null) goto L9;
    L10:
        r0.put("enter_from_merge", r5);
        FeedbackContext r9 = FeedbackContext.a.a(r8.hashCode());
        if (r9 == null) goto L14;
        String r10 = r9.getEnterMethod();
        if (r10 == null) goto L14;
    L15:
        r0.put("enter_method", r10);
        FeedbackCard r11 = r8.k;
        if (r11 == null) goto L21;
        Room r12 = r11.room;
        if (r12 == null) goto L21;
        String r13 = String.valueOf(r12.id);
        if (r13 == null) goto L21;
    L22:
        r0.put("room_id", r13);
        FeedbackCard r14 = r8.k;
        if (r14 == null) goto L30;
        Room r15 = r14.room;
        if (r15 == null) goto L30;
        User r16 = r15.getOwner();
        if (r16 == null) goto L30;
        String r17 = r16.getIdString();
        if (r17 == null) goto L30;
    L31:
        r0.put("anchor_id", r17);
        FeedbackContext r18 = FeedbackContext.a.a(r8.hashCode());
        if (r18 == null) goto L35;
        String r19 = r18.getReqId();
        if (r19 == null) goto L35;
    L36:
        r0.put("request_id", r19);
        FeedbackCard r20 = r8.k;
        if (r20 == null) goto L42;
        Long r21 = r20.feedbackId;
        if (r21 == null) goto L42;
        String r22 = String.valueOf(r21.longValue());
        if (r22 == null) goto L42;
    L43:
        r0.put("feedback_id", r22);
        FeedbackCard r23 = r8.k;
        if (r23 == null) goto L49;
        Integer r24 = r23.getIndex();
        if (r24 == null) goto L49;
        String r25 = String.valueOf(r24.intValue());
        if (r25 == null) goto L49;
    L50:
        r0.put("draw_order", r25);
        r0.put("flow_type", "internal_flow");
        FeedbackCard r26 = r8.k;
        if (r26 == null) goto L56;
        String r27 = r26.getLogInfo();
        if (r27 == null) goto L56;
        r4 = r27;
    L56:
        r0.put("question_text", r4);
        r0.put("card_type", "small_card");
        r0.put("question_type", "multiple");
        r0.put("button_type", "change");
        u.l().sendLog("livesdk_live_feedback_card_click", r0, new Object[0]);
        return;
    L49:
        r25 = "";
    L42:
        r22 = "";
    L35:
        r19 = "";
    L30:
        r17 = "";
    L21:
        r13 = "";
    L14:
        r10 = "";
    L9:
        r5 = "";
        goto L10
    }
}
