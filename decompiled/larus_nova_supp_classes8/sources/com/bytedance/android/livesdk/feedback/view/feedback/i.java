package com.bytedance.android.livesdk.feedback.view.feedback;

import android.view.View;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.base.model.feedback.Option;
import com.bytedance.android.live.base.model.feedback.Question;
import com.bytedance.android.live.base.model.feedback.RoomCardStruct;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ SmallCardPreviewFeedback a;

    public i(SmallCardPreviewFeedback r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r22) {
        SmallCardPreviewFeedback r1 = this.a;
        FeedbackCard r2 = r1.k;
        if (r2 == null) goto L49;
        Question r3 = r1.l;
        if (r3 == null) goto L9;
        String r4 = r3.questionKey;
        if (r4 == null) goto L9;
    L10:
        String r11 = r4.concat("-1");
        List r5 = r2.getLikedRooms();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L19;
        Room r7 = ((RoomCardStruct) r6.next()).room;
        if (r7 == null) goto L17;
        String r8 = r7.getIdStr();
        if (r8 == null) goto L17;
    L18:
        r12.add(r8);
    L17:
        r8 = "";
        goto L18
    L19:
        String r15 = CollectionsKt.joinToString$default(r12, ",", null, null, 0, null, null, 62, null);
        IFeedbackApi r9 = (IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class);
        FeedbackCard r10 = r1.k;
        if (r10 == null) goto L24;
        Long r13 = r10.feedbackId;
        if (r13 == null) goto L24;
        long r14 = r13.longValue();
    L25:
        long r16 = r14;
        String r17 = r1.r.getReqId();
        if (r17 != null) goto L28;
        String r18 = "";
    L29:
        String r19 = r1.r.getEnterFromMerge();
        if (r19 != null) goto L32;
        String r110 = "";
    L33:
        String r20 = r1.r.getEnterMethod();
        if (r20 != null) goto L36;
        String r111 = "";
    L37:
        String r21 = r1.r.getReqId();
        if (r21 != null) goto L40;
        String r112 = "";
    L41:
        ILiveFeedbackService r23 = (ILiveFeedbackService) r1.p.getValue();
        if (r23 == null) goto L47;
        String r24 = r23.getRecentRoomIds();
        if (r24 == null) goto L47;
        String r113 = r24;
    L48:
        r1.o = r9.feedbackRequest(r16, 0, r11, r18, r110, r111, r15, r112, r113).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(j.a, k.a);
    L47:
        r113 = "";
        goto L48
    L40:
        r112 = r21;
        goto L41
    L36:
        r111 = r20;
        goto L37
    L32:
        r110 = r19;
        goto L33
    L28:
        r18 = r17;
    L24:
        r14 = 0;
    L9:
        r4 = "";
    L49:
        this.a.s.invoke();
        Question r25 = this.a.l;
        if (r25 == null) goto L62;
        List r26 = r25.options;
        if (r26 == null) goto L62;
        if ((!r26.isEmpty()) == true) goto L57;
        r26 = null;
    L57:
        if (r26 == null) goto L62;
        Option r27 = (Option) ListProtector.get(r26, 0);
        if (r27 == null) goto L62;
        String r28 = r27.toastText;
        if (r28 == null) goto L62;
    L63:
        f2.c(r28, 0);
        return;
    L62:
        r28 = s1.B(2131919107);
        goto L63
    }
}
