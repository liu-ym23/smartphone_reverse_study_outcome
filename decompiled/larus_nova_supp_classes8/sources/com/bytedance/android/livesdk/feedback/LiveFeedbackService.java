package com.bytedance.android.livesdk.feedback;

import android.content.Context;
import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.MaxSizeList;
import com.bytedance.android.livesdk.config.nv;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.feedback.IFeedbackCallback;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackService;
import com.bytedance.android.livesdkapi.feedback.ILiveFeedbackView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u000fJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J!\u0010\u001f\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\rH\u0016J\u0017\u0010$\u001a\u00020\u001a2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u0007H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/LiveFeedbackService;", "Lcom/bytedance/android/livesdkapi/feedback/ILiveFeedbackService;", "()V", "cacheInnerFeedbackCard", "Lcom/bytedance/android/live/base/model/feedback/FeedbackCard;", "cacheReadRoomInfo", "Lcom/bytedance/android/live/core/utils/MaxSizeList;", "", "roomFeedbackCache", "", "getRoomFeedbackCache", "()Ljava/util/Map;", "clearPreviewRoomShowCache", "", "roomId", "(Ljava/lang/Long;)V", "clearRoomFeedbackInfo", "createFeedbackView", "Lcom/bytedance/android/livesdkapi/feedback/ILiveFeedbackView;", "context", "Landroid/content/Context;", "callback", "Lcom/bytedance/android/livesdkapi/feedback/IFeedbackCallback;", "style", "", "enableFeedbackCardPay", "", "getCacheInnerFeedbackCard", "getFeedbackShowTime", "getRecentRoomIds", "", "hitPreviewRoomShowCache", "feedbackInt", "(Ljava/lang/Long;Ljava/lang/Long;)Z", "isFeedbackCardCanShowInPreview", "resetFeedbackCardCanShowInPreview", "roomEnableFeedbackView", "(Ljava/lang/Long;)Z", "saveRecentRoomId", "setCacheInnerFeedbackCard", "cacheInnerFeedback", "updateFeedbackShowTime", "time", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeedbackService implements ILiveFeedbackService {
    private FeedbackCard cacheInnerFeedbackCard;
    private final MaxSizeList<Long> cacheReadRoomInfo;
    private final Map<Long, Long> roomFeedbackCache;

    public boolean enableFeedbackCardPay() {
        Boolean r0 = nv.a.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public long getFeedbackShowTime() {
        return ((Number) com.bytedance.android.livesdk.sharedpref.b.U2.getValue()).longValue();
    }

    public String getRecentRoomIds() {
        if (this.cacheReadRoomInfo.isEmpty() == false) goto L6;
        return "";
    L6:
        return CollectionsKt.joinToString$default(this.cacheReadRoomInfo, ",", null, null, 0, null, null, 62, null);
    }

    public boolean isFeedbackCardCanShowInPreview() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.W2.getValue()).booleanValue();
    }

    public void resetFeedbackCardCanShowInPreview() {
        e r0 = com.bytedance.android.livesdk.sharedpref.b.W2;
        Boolean r1 = Boolean.FALSE;
        r0.getClass();
        f.d(r0, r1);
    }

    public LiveFeedbackService() {
        this.roomFeedbackCache = new LinkedHashMap();
        this.cacheReadRoomInfo = new MaxSizeList(10);
    }

    public FeedbackCard getCacheInnerFeedbackCard() {
        return this.cacheInnerFeedbackCard;
    }

    public final Map<Long, Long> getRoomFeedbackCache() {
        return this.roomFeedbackCache;
    }

    public void clearPreviewRoomShowCache(Long r2) {
        Map<Long, Long> r0 = this.roomFeedbackCache;
        if (r0 == null) goto L7;
        TypeIntrinsics.asMutableMap(r0).remove(r2);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public void clearRoomFeedbackInfo(Long r2) {
        e r3 = com.bytedance.android.livesdk.sharedpref.b.R2;
        LongSparseArray r0 = new LongSparseArray();
        r3.getClass();
        f.d(r3, r0);
    }

    public boolean roomEnableFeedbackView(Long r5) {
        if (r5 == null) goto L10;
        r5.longValue();
        LongSparseArray r1 = (LongSparseArray) com.bytedance.android.livesdk.sharedpref.b.R2.getValue();
        if (r1 == null) goto L11;
        Boolean r6 = (Boolean) r1.get(r5.longValue());
        if (r6 != null) goto L9;
        return false;
    L9:
        return r6.booleanValue();
    L11:
        return false;
    L10:
        return false;
    }

    public void saveRecentRoomId(long r3) {
        if (this.cacheReadRoomInfo.contains(Long.valueOf(r3)) == true) goto L6;
        this.cacheReadRoomInfo.add(Long.valueOf(r3));
        return;
    }

    public void setCacheInnerFeedbackCard(FeedbackCard r2) {
        Intrinsics.checkNotNullParameter(r2, "cacheInnerFeedback");
        this.cacheInnerFeedbackCard = r2;
    }

    public void updateFeedbackShowTime(long r2) {
        e r0 = com.bytedance.android.livesdk.sharedpref.b.U2;
        Long r3 = Long.valueOf(r2);
        r0.getClass();
        f.d(r0, r3);
    }

    public boolean hitPreviewRoomShowCache(Long r5, Long r6) {
        if (r5 == null) goto L13;
        r5.longValue();
        Long r7 = this.roomFeedbackCache.get(r5);
        if (r7 == null) goto L14;
        long r1 = r7.longValue();
        if (r6 != null) goto L10;
        return false;
    L10:
        if (r1 != r6.longValue()) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L13:
        return false;
    }

    public ILiveFeedbackView createFeedbackView(Context r2, IFeedbackCallback r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        return new a(r2, r3, r4);
    }
}
