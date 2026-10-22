package com.bytedance.android.livesdk.feedback;

import android.os.Bundle;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.feedback.Condition;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00018B\u0007¢\u0006\u0004\b5\u00106J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J3\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J3\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u001a\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R&\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\t\u0010!R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010!R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u001e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b.\u0010 \u001a\u0004\b\u000e\u0010!R&\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u001e8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b/\u0010 \u001a\u0004\b\u001d\u0010!R\u001a\u00101\u001a\u0002008\u0004X\u0084\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/FeedbackManager;", "Lcom/bytedance/live/datacontext/DataContext;", "Ldx1/b;", "", "roomId", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "feedItem", "", "saveRoomFeedback", "getRoomFeedback", "Landroid/os/Bundle;", "bundle", "savePreviewFeedback", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "getPreviewFeedback", "removePreviewFeedback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", LiveEndPageData.TAG_NAME, "insertAction", "insertRoomFeedback", "removeAction", "removeRoomFeedback", "onReadFeedback", "", "unreadExtra", "saveUnReadFeedback", "feedbackCard", "saveLiveRoomFeedback", "getLiveRoomFeedback", "", "roomFeedback", "Ljava/util/Map;", "()Ljava/util/Map;", "", "unReadFeedback", "Ljava/util/List;", "getUnReadFeedback", "()Ljava/util/List;", "cacheFeedback", "getCacheFeedback", "Ljava/lang/String;", "getUnreadExtra", "()Ljava/lang/String;", "setUnreadExtra", "(Ljava/lang/String;)V", "previewFeedback", "liveRoomFeedback", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "getCd", "()Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "Companion", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FeedbackManager extends DataContext implements dx1.b {
    public static final b Companion = null;
    private static final int FEEDBACK_TYPE = 21;
    public static final String TAG = "LiveFeedBackManager";
    private final Map<Long, FeedItem> cacheFeedback;
    private final CompositeDisposable cd;
    private final Map<Long, FeedbackCard> liveRoomFeedback;
    private final Map<Long, FeedbackCard> previewFeedback;
    private final Map<Long, FeedItem> roomFeedback;
    private final List<Long> unReadFeedback;
    private String unreadExtra;

    public static final class a implements Action {
        public final /* synthetic */ FeedbackManager a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.FeedbackManager$a$a, reason: collision with other inner class name */
        public static final class C0312a<T> implements Consumer {
            public static final C0312a a = null;

            static {
                a = new C0312a();
            }

            public C0312a() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Response r2 = (Response) r1;
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        public a(FeedbackManager r1) {
            this.a = r1;
        }

        public final void run() {
            if ((!this.a.getUnReadFeedback().isEmpty()) == false) goto L8;
            IFeedbackApi r0 = (IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class);
            String r1 = this.a.getUnreadExtra();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            r0.feedbackUnreadRequest(r1, CollectionsKt.joinToString$default(this.a.getUnReadFeedback(), ",", null, null, 0, null, null, 62, null)).compose(RxUtil.rxSchedulerHelper()).subscribe(C0312a.a, b.a);
        L8:
            this.a.getCd().dispose();
        }
    }

    public static final class b {
        public static FeedbackManager a() {
            DataContext r0 = d.d(FeedbackManager.TAG);
            if ((r0 instanceof FeedbackManager) == true) goto L6;
            r0 = null;
        L6:
            return (FeedbackManager) r0;
        }

        public b() {
        }

        public static boolean b(FeedItem r1) {
            if (r1 != null) goto L4;
        L6:
            return false;
        L4:
            if (r1.type != FeedbackManager.FEEDBACK_TYPE) goto L6;
            return true;
        }
    }

    static {
        Companion = new b();
    }

    @Override // dx1.b
    public void insertLiveRoomFeedback(long r1, Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "insertAction");
    }

    @Override // dx1.b
    public void removeLiveRoomFeedback(long r1, Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "removeAction");
    }

    public FeedbackManager() {
        this.roomFeedback = new LinkedHashMap();
        this.unReadFeedback = new ArrayList();
        this.cacheFeedback = new LinkedHashMap();
        this.previewFeedback = new LinkedHashMap();
        this.liveRoomFeedback = new LinkedHashMap();
        CompositeDisposable r0 = new CompositeDisposable();
        this.cd = r0;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r0);
    }

    public final Map<Long, FeedItem> getCacheFeedback() {
        return this.cacheFeedback;
    }

    public final CompositeDisposable getCd() {
        return this.cd;
    }

    public final Map<Long, FeedbackCard> getLiveRoomFeedback() {
        return this.liveRoomFeedback;
    }

    public final Map<Long, FeedbackCard> getPreviewFeedback() {
        return this.previewFeedback;
    }

    public final Map<Long, FeedItem> getRoomFeedback() {
        return this.roomFeedback;
    }

    public final List<Long> getUnReadFeedback() {
        return this.unReadFeedback;
    }

    public final String getUnreadExtra() {
        return this.unreadExtra;
    }

    @Override // dx1.b
    public FeedbackCard getLiveRoomFeedback(long r2) {
        return this.liveRoomFeedback.get(Long.valueOf(r2));
    }

    @Override // dx1.b
    public FeedbackCard getPreviewFeedback(long r2) {
        return this.previewFeedback.get(Long.valueOf(r2));
    }

    @Override // dx1.b
    public FeedItem getRoomFeedback(long r2) {
        return this.roomFeedback.get(Long.valueOf(r2));
    }

    @Override // dx1.b
    public void onReadFeedback(FeedItem r4) {
        if (r4 == null) goto L14;
        FeedbackCard r5 = r4.feedbackCard;
        if (r5 == null) goto L15;
        Long r6 = r5.feedbackId;
        if (r6 == null) goto L16;
        long r0 = r6.longValue();
        if (this.unReadFeedback.contains(Long.valueOf(r0)) == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L17;
        long r1 = r6.longValue();
        this.unReadFeedback.remove(Long.valueOf(r1));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // dx1.b
    public void removePreviewFeedback(long r2) {
        this.previewFeedback.remove(Long.valueOf(r2));
    }

    public final void setUnreadExtra(String r1) {
        this.unreadExtra = r1;
    }

    @Override // dx1.b
    public void insertRoomFeedback(long r3, Function1<? super FeedItem, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "insertAction");
        FeedItem r0 = this.roomFeedback.get(Long.valueOf(r3));
        if (r0 == null) goto L5;
        r5.invoke(r0);
        this.cacheFeedback.put(Long.valueOf(r3), r0);
    L5:
        this.roomFeedback.remove(Long.valueOf(r3));
    }

    @Override // dx1.b
    public void removeRoomFeedback(long r3, Function1<? super FeedItem, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "removeAction");
        FeedItem r0 = this.cacheFeedback.get(Long.valueOf(r3));
        if (r0 == null) goto L5;
        r5.invoke(r0);
    L5:
        this.cacheFeedback.remove(Long.valueOf(r3));
    }

    @Override // dx1.b
    public void saveLiveRoomFeedback(long r2, FeedbackCard r4) {
        Intrinsics.checkNotNullParameter(r4, "feedbackCard");
        this.liveRoomFeedback.put(Long.valueOf(r2), r4);
    }

    @Override // dx1.b
    public void savePreviewFeedback(long r5, Bundle r7) {
        String r0 = null;
        if (r7 == null) goto L5;
        r0 = r7.getString("live_preview_feedback_data", null);
    L5:
        if (r0 == null) goto L34;
        FeedbackCard r8 = (FeedbackCard) GsonHelper.get().fromJson(r0, FeedbackCard.class);     // Catch: Exception -> L30
        if (r8 == null) goto L35;
        r8.setFromPreview(true);     // Catch: Exception -> L30
        Condition r1 = r8.condition;     // Catch: Exception -> L30
        if (r1 == null) goto L15;
        List r2 = r1.actionIds;     // Catch: Exception -> L30
        if (r2 == null) goto L15;
        if (r2.contains(99L) != true) goto L15;
        this.previewFeedback.put(Long.valueOf(r5), r8);     // Catch: Exception -> L30
        return;
    L15:
        FeedItem r3 = new FeedItem();     // Catch: Exception -> L30
        Integer r4 = r8.feedbackType;     // Catch: Exception -> L30
        if (r4 != null) goto L19;
    L20:
        Integer r6 = r8.feedbackType;     // Catch: Exception -> L30
        if (r6 != null) goto L24;
    L26:
        Room r9 = new Room();     // Catch: Exception -> L30
        r9.mFeedbackCard = r8;     // Catch: Exception -> L30
        r9.id = r5;     // Catch: Exception -> L30
        Unit r10 = Unit.INSTANCE;     // Catch: Exception -> L30
        r3.setRoom(r9);     // Catch: Exception -> L30
        r3.type = 1;     // Catch: Exception -> L30
    L28:
        saveRoomFeedback(r5, r3);     // Catch: Exception -> L30
        Unit r11 = Unit.INSTANCE;     // Catch: Exception -> L30
        return;
    L24:
        if (r6.intValue() != 2) goto L26;
    L27:
        r3.feedbackCard = r8;     // Catch: Exception -> L30
        r3.type = FEEDBACK_TYPE;     // Catch: Exception -> L30
        goto L28
    L19:
        if (r4.intValue() == 1) goto L27;
    L35:
        return;
    L30:
        e = move-exception;
        ALogger.e("FeedbackManager", "parse preview feedback data fail", e);
        Unit r12 = Unit.INSTANCE;
        return;
    }

    @Override // dx1.b
    public void saveRoomFeedback(long r2, FeedItem r4) {
        Intrinsics.checkNotNullParameter(r4, "feedItem");
        this.roomFeedback.put(Long.valueOf(r2), r4);
    }

    @Override // dx1.b
    public void saveUnReadFeedback(FeedItem r3, String r4) {
        if (r3 == null) goto L8;
        FeedbackCard r5 = r3.feedbackCard;
        if (r5 == null) goto L8;
        Long r6 = r5.feedbackId;
        if (r6 == null) goto L8;
        long r0 = r6.longValue();
        this.unReadFeedback.add(Long.valueOf(r0));
    L8:
        this.unreadExtra = r4;
    }
}
