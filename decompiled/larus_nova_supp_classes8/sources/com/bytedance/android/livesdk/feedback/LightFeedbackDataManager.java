package com.bytedance.android.livesdk.feedback;

import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.config.a31;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016J3\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J3\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016J3\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000bH\u0016J3\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000bH\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/LightFeedbackDataManager;", "Lcom/bytedance/android/livesdk/feedback/FeedbackManager;", "", "roomId", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "getLiveRoomFeedback", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "getRoomFeedback", "feedItem", "", "saveRoomFeedback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", LiveEndPageData.TAG_NAME, "insertAction", "insertRoomFeedback", "removeAction", "removeRoomFeedback", "feedbackCard", "insertLiveRoomFeedback", "removeLiveRoomFeedback", "<init>", "()V", "Companion", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LightFeedbackDataManager extends FeedbackManager {
    public static final a Companion = null;
    public static final String TAG_LIGHT = "LightLiveFeedBackManager";

    public static final class a {
        public static LightFeedbackDataManager a() {
            DataContext r0 = d.d(LightFeedbackDataManager.TAG_LIGHT);
            if ((r0 instanceof LightFeedbackDataManager) == true) goto L6;
            r0 = null;
        L6:
            return (LightFeedbackDataManager) r0;
        }

        public a() {
        }

        public static void b(Fragment r1) {
            Intrinsics.checkNotNullParameter(r1, "fragment");
            d.c(d.b(r1, null).a(LightFeedbackDataManager.class), LightFeedbackDataManager.TAG_LIGHT);
        }
    }

    static {
        Companion = new a();
    }

    public LightFeedbackDataManager() {
    }

    @Override // com.bytedance.android.livesdk.feedback.FeedbackManager, dx1.b
    public FeedbackCard getLiveRoomFeedback(long r3) {
        FeedbackCard r0 = getLiveRoomFeedback().get(Long.valueOf(r3));
        if (r0 != null) goto L13;
        Map<Long, FeedItem> r1 = getRoomFeedback();
        if (r1 == null) goto L11;
        FeedItem r4 = r1.get(Long.valueOf(r3));
        if (r4 == null) goto L11;
        Room r5 = r4.getRoom();
        if (r5 == null) goto L11;
        return r5.mFeedbackCard;
    L11:
        return null;
    L13:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feedback.FeedbackManager, dx1.b
    public FeedItem getRoomFeedback(long r4) {
        FeedItem r0 = getRoomFeedback().get(Long.valueOf(r4));
        if (r0 != null) goto L12;
        FeedbackCard r1 = getLiveRoomFeedback().get(Long.valueOf(r4));
        if (r1 == null) goto L10;
        FeedItem r2 = new FeedItem();
        r2.feedbackCard = r1;
        Room r3 = r1.room;
        if (r3 != null) goto L9;
        r3 = new Room();
        r3.mFeedbackCard = r1;
        r3.id = r4;
        Unit r5 = Unit.INSTANCE;
    L9:
        r2.setRoom(r3);
        getRoomFeedback().put(Long.valueOf(r4), r2);
        return r2;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.feedback.FeedbackManager, dx1.b
    public void insertLiveRoomFeedback(long r5, Function1<? super FeedbackCard, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "insertAction");
        FeedbackCard r0 = getLiveRoomFeedback().get(Long.valueOf(r5));
        if (r0 == null) goto L6;
        int r1 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r2 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LightFeedbackDataManager", "page");
        r2.a = "LightFeedbackDataManager";
        r2.c("insertLiveRoomFeedback");
        r2.a("roomId", Long.valueOf(r5));
        r2.a("feedback", JsonUtil.toJSONString(r0));
        r2.d();
        r7.invoke(r0);
        return;
    }

    @Override // com.bytedance.android.livesdk.feedback.FeedbackManager, dx1.b
    public void insertRoomFeedback(long r5, Function1<? super FeedItem, Unit> r7) {
        Intrinsics.checkNotNullParameter(r7, "insertAction");
        FeedItem r0 = getRoomFeedback().get(Long.valueOf(r5));
        if (r0 == null) goto L10;
        int r1 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r2 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LightFeedbackDataManager", "page");
        r2.a = "LightFeedbackDataManager";
        r2.c("insertRoomFeedback");
        r2.a("roomId", Long.valueOf(r5));
        Room r6 = r0.getRoom();
        if (r6 == null) goto L7;
        FeedbackCard r8 = r6.mFeedbackCard;
    L8:
        r2.a("feedback", JsonUtil.toJSONString(r8));
        r2.d();
        r7.invoke(r0);
        return;
    L7:
        r8 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.feedback.FeedbackManager, dx1.b
    public void removeLiveRoomFeedback(long r3, Function1<? super FeedbackCard, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "removeAction");
        FeedbackCard r0 = getLiveRoomFeedback().remove(Long.valueOf(r3));
        if (r0 != null) goto L5;
        return;
    L5:
        if (a31.a.getValue().booleanValue() == false) goto L7;
        getRoomFeedback().remove(Long.valueOf(r3));
    L7:
        r5.invoke(r0);
    }

    @Override // com.bytedance.android.livesdk.feedback.FeedbackManager, dx1.b
    public void removeRoomFeedback(long r3, Function1<? super FeedItem, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "removeAction");
        FeedItem r0 = getRoomFeedback().remove(Long.valueOf(r3));
        if (r0 != null) goto L5;
        return;
    L5:
        if (a31.a.getValue().booleanValue() == false) goto L7;
        getLiveRoomFeedback().remove(Long.valueOf(r3));
    L7:
        r5.invoke(r0);
    }

    @Override // com.bytedance.android.livesdk.feedback.FeedbackManager, dx1.b
    public void saveRoomFeedback(long r4, FeedItem r6) {
        Intrinsics.checkNotNullParameter(r6, "feedItem");
        if (getRoomFeedback().get(Long.valueOf(r4)) != null) goto L10;
        getRoomFeedback().put(Long.valueOf(r4), r6);
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("LightFeedbackDataManager", "page");
        r1.a = "LightFeedbackDataManager";
        r1.c("saveRoomFeedback");
        r1.a("roomId", Long.valueOf(r4));
        Room r5 = r6.getRoom();
        if (r5 == null) goto L7;
        FeedbackCard r7 = r5.mFeedbackCard;
    L8:
        r1.a("feedback", JsonUtil.toJSONString(r7));
        r1.d();
        Unit r8 = Unit.INSTANCE;
        return;
    L7:
        r7 = null;
        goto L8
    }
}
