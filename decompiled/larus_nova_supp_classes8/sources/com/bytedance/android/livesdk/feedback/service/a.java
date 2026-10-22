package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feedback.FeedbackManager;
import com.bytedance.android.livesdk.feedback.LiveFeedbackService;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ c a;

    public a(c r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        FeedbackCard r7 = ((com.bytedance.android.live.base.model.feedback.a.a) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r6)).data).feedbackCard;
        if (r7 == null) goto L30;
        FeedItem r0 = new FeedItem();
        r0.feedbackCard = r7;
        RoomContext.a r1 = RoomContext.Companion;
        DataCenter r2 = this.a.a.getDataCenter();
        long r3 = this.a.a.getFeedbackSession().b;
        r1.getClass();
        RoomContext r4 = RoomContext.a.a(r2, r3);
        LiveFeedbackService r5 = null;
        if (r4 == null) goto L9;
        m r8 = r4.getRoom();
        if (r8 == null) goto L9;
        Room r9 = (Room) r8.getValue();
    L10:
        r0.setRoom(r9);
        r0.getRoom().mFeedbackCard = r7;
        r0.type = 21;
        FeedbackManager.Companion.getClass();
        FeedbackManager r10 = FeedbackManager.b.a();
        if (r10 == null) goto L13;
        r10.saveRoomFeedback(z.o(this.a.a.getDataCenter()).getRoomId(), r0);
    L13:
        Integer r11 = r7.inflowFeedbackType;
        if (r11 != null) goto L17;
    L18:
        if (r11 != null) goto L21;
    L23:
        LiveFeedbackService r12 = k.f(ILiveFeedbackService.class);
        if ((r12 instanceof LiveFeedbackService) == false) goto L27;
        r5 = r12;
    L27:
        LiveFeedbackService r13 = r5;
        if (r13 == null) goto L30;
        r13.setCacheInnerFeedbackCard(r7);
        goto L30
    L21:
        if (r11.intValue() != 2) goto L23;
    L22:
        this.a.a.startFeedbackObserve();
        goto L23
    L17:
        if (r11.intValue() == 1) goto L22;
    L9:
        r9 = null;
    L30:
        FeedbackWithMessageService r14 = this.a.a;
        r14.getClass();
        Intrinsics.checkNotNullParameter("on action：receive live room feedback msg", "msg");
        int r15 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r16 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("FeedbackWithMessageService", "page");
        r16.a = "FeedbackWithMessageService";
        r16.c("on action：receive live room feedback msg");
        r16.a("roomId", Long.valueOf(r14.getFeedbackSession().b));
        FeedbackCard r17 = r14.getFeedbackCard();
        if (r17 == null) goto L34;
        Object r18 = r17.feedbackType;
        if (r18 == null) goto L34;
    L35:
        r16.a("feedback_type", r18);
        r16.d();
        return;
    L34:
        r18 = "-1";
        goto L35
    }
}
