package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeQuickShotAndRecordBaseWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LandscapeQuickShotAndRecordBaseWidget extends LiveRecyclableWidget {
    public LandscapeQuickShotAndRecordBaseWidget() {
    }

    public static void wq(boolean r2) {
        Float r0 = Float.valueOf(15.0f);
        if (r2 == false) goto L5;
        Object r3 = pm1.h.d.c(vr1.r.class);
        Intrinsics.checkNotNull(r3);
        vr1.r.a.a((vr1.r) r3, Float.valueOf(36.0f), r0);
        return;
    L5:
        Object r4 = pm1.h.d.c(vr1.r.class);
        Intrinsics.checkNotNull(r4);
        vr1.r.a.a((vr1.r) r4, Float.valueOf(0.0f), r0);
    }
}
