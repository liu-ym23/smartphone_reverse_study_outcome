package com.ss.android.lark.picker.base.statistics;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.fg.PickerFgUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.i;
import z5c.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0011J\u001c\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0011H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/picker/base/statistics/PickerTracker;", "", "biz", "", "scene", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBiz", "()Ljava/lang/String;", "getScene", "hasTrackRecommendRender", "", "trackShow", "", "trackDestroy", "trackClickItem", "action", "Lcom/ss/android/lark/statistics/extensions/IParam;", "source", "trackSearch", "duration", "", "trackRecommendRender", "dataDuration", "uiDuration", "type", "track", "eventName", "eventParams", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerTracker {
    private static final Companion Companion = null;
    private static final String TAG = "PickerTracker";
    private final String biz;
    private boolean hasTrackRecommendRender;
    private final String scene;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/statistics/PickerTracker$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void trackDestroy() {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC03211(this));
    }

    public final void trackShow() {
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC03241(this));
    }

    public final String getBiz() {
        return this.biz;
    }

    public final String getScene() {
        return this.scene;
    }

    public PickerTracker(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "biz");
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.biz = r2;
        this.scene = r3;
    }

    public static final /* synthetic */ void access$setHasTrackRecommendRender$p(PickerTracker r0, boolean r1) {
        r0.hasTrackRecommendRender = r1;
    }

    private final void track(String r3, d r4) {
        if (PickerFgUtils.INSTANCE.isClosePickerTracker() == false) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        d r5 = d.b.b(i.c.a(this.biz), z2.k.a(this.scene));
    L8:
        Log.i(TAG, "eventName: " + r3 + "\neventParams: biz -- " + this.biz + ", scene -- " + this.scene);
        Statistics.sendEvent(r3, r5.toJson());
        return;
    L7:
        r5 = r4.plus(i.c.a(this.biz)).plus(z2.k.a(this.scene));
        goto L8
    }

    public final void trackClickItem(final d r3, final d r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "source");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AnonymousClass1(this, r3, r4));
    }

    public final void trackSearch(final d r3, final long r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC03231(this, r3, r4));
    }

    public static final /* synthetic */ void access$track(PickerTracker r0, String r1, d r2) {
        r0.track(r1, r2);
    }

    public final void trackRecommendRender(final long r10, final long r12, final d r14) {
        Intrinsics.checkNotNullParameter(r14, "type");
        if (this.hasTrackRecommendRender == false) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC03221(this, r10, r12, r14));
    }

    public static /* synthetic */ void track$default(PickerTracker r0, String r1, d r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.track(r1, r2);
    }

    public static /* synthetic */ void trackSearch$default(PickerTracker r0, d r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.trackSearch(r1, r2);
    }
}
