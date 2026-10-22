package com.bytedance.android.livesdk.feedback;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdk.feedback.room.RoomFeedbackContext;
import com.bytedance.android.livesdk.feedback.service.d;
import com.bytedance.android.livesdk.feedback.service.e;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/LiveRoomFeedbackWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomFeedbackWidget extends LiveRecyclableWidget {
    public Disposable a;
    public com.bytedance.android.livesdk.feedback.room.a b;
    public ILiveRoomPlayFragment.LiveRoomListener c;
    public final Lazy d;
    public final RoomSession e;

    public final void onInit(Object[] r1) {
    }

    public final void onLoad(Object[] r1) {
    }

    public final void onUnload() {
        Iterator r0 = ((List) this.d.getValue()).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        d r1 = (d) r0.next();
        e r2 = r1.a();
        if (r2 == null) goto L8;
        r2.reset();
    L8:
        r1.onLeaveRoom();
        goto L4
    L9:
        Disposable r3 = this.a;
        if (r3 == null) goto L12;
        r3.dispose();
    L12:
        this.a = null;
        this.c = null;
    }

    public final void wq() {
        Pair r0 = com.bytedance.live.datacontext.d.a(LiveRoomFeedbackWidget$onStartRoom$1.INSTANCE);
        com.bytedance.live.datacontext.d.c((DataContext) r0.getFirst(), RoomFeedbackContext.TAG);
        this.b = (com.bytedance.android.livesdk.feedback.room.a) r0.getFirst();
        this.a = (Disposable) r0.getSecond();
        com.bytedance.android.livesdk.feedback.room.a r1 = this.b;
        if (r1 == null) goto L7;
        ILiveRoomPlayFragment.LiveRoomListener r2 = this.c;
        if (r2 == null) goto L7;
        r1.updateRoomListener(r2);
    L7:
        Iterator r3 = ((List) this.d.getValue()).iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        d r4 = (d) r3.next();
        r4.c();
        e r5 = r4.a();
        if (r5 == null) goto L9;
        r5.startFeedbackObserve();
        goto L9
    }

    public LiveRoomFeedbackWidget(RoomSession r2) {
        Intrinsics.checkNotNullParameter(r2, "roomSession");
        this.e = r2;
        this.d = LazyKt.lazy(new LiveRoomFeedbackWidget$mFeedbackConfigs$2(this));
    }
}
