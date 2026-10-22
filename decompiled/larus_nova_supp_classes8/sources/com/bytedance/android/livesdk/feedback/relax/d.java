package com.bytedance.android.livesdk.feedback.relax;

import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.livesdk.config.v4;
import com.bytedance.android.livesdk.feedback.room.RoomFeedbackContext;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LiveLightFeedbackRelaxWidget a;

    public d(LiveLightFeedbackRelaxWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Integer r6 = (Integer) r5;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.intValue() != (-1)) goto L52;
        LiveLightFeedbackRelaxWidget r7 = this.a;
        com.bytedance.android.livesdk.feedback.light.context.a r0 = r7.a;
        if (r0 == null) goto L44;
        com.bytedance.live.datacontext.n<? extends FeedItem> r1 = r0.getShowRoomFeedback();
        if (r1 == null) goto L44;
        FeedItem r2 = (FeedItem) r1.getValue();
        if (r2 == null) goto L44;
        Room r3 = r2.getRoom();
        if (r3 == null) goto L44;
        FeedbackCard r4 = r3.mFeedbackCard;
        if (r4 == null) goto L44;
        com.bytedance.android.live.base.b r8 = v4.a.getValue();
        Long r9 = r4.feedbackId;
        if (r9 == null) goto L20;
        long r10 = r9.longValue();
    L22:
        if (r8.b(r10) == false) goto L36;
        com.bytedance.android.livesdk.feedback.light.context.a r11 = r7.a;
        if (r11 == null) goto L36;
        com.bytedance.live.datacontext.n<? extends FeedItem> r12 = r11.getShowRoomFeedback();
        if (r12 == null) goto L36;
        FeedItem r13 = (FeedItem) r12.getValue();
        if (r13 == null) goto L36;
        Intrinsics.checkNotNullParameter(r13, "feedItem");
        r13.needLogWhenRemove = true;
        RoomFeedbackContext.Companion.getClass();
        RoomFeedbackContext r14 = RoomFeedbackContext.a.a();
        if (r14 == null) goto L36;
        com.bytedance.live.datacontext.n<? extends ILiveRoomPlayFragment.LiveRoomListener> r15 = r14.getRoomListener();
        if (r15 == null) goto L36;
        ILiveRoomPlayFragment.LiveRoomListener r16 = (ILiveRoomPlayFragment.LiveRoomListener) r15.getValue();
        if (r16 == null) goto L36;
        r16.removeFeedItem(r13);
    L36:
        int r17 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r18 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LiveLightFeedbackWidget", "page");
        r18.a = "LiveLightFeedbackWidget";
        r18.c("scrollToTargetRoomByDirection");
        Object r19 = r4.feedbackId;
        Object r20 = "-1";
        if (r19 != null) goto L39;
        r19 = "-1";
    L39:
        r18.a("feedback_id", r19);
        Integer r21 = r4.feedbackType;
        if (r21 == null) goto L43;
        r20 = r21;
    L43:
        r18.a("feedback_type", r20);
        r18.d();
        return;
    L20:
        r10 = -1;
    L44:
        RoomFeedbackContext.Companion.getClass();
        RoomFeedbackContext r22 = RoomFeedbackContext.a.a();
        if (r22 == null) goto L54;
        com.bytedance.live.datacontext.n<? extends ILiveRoomPlayFragment.LiveRoomListener> r23 = r22.getRoomListener();
        if (r23 == null) goto L55;
        ILiveRoomPlayFragment.LiveRoomListener r24 = (ILiveRoomPlayFragment.LiveRoomListener) r23.getValue();
        if (r24 == null) goto L56;
        r24.playNext(false);
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    }
}
