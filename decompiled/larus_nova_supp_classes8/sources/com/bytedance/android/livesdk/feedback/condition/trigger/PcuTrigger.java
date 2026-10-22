package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/PcuTrigger;", "Lcom/bytedance/android/livesdk/feedback/condition/trigger/base/FeedbackMsgTrigger;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PcuTrigger extends FeedbackMsgTrigger {
    public final TriggerId f;
    public final List<Integer> g;
    public final List<String> h;
    public final long i;

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final List<String> g() {
        return this.h;
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final List<Integer> h() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.feedback.condition.trigger.base.FeedbackMsgTrigger
    public final void i(tlc.d r7) {
        Intrinsics.checkNotNullParameter(r7, "msg");
        if ((r7 instanceof mk) == true) goto L5;
        r7 = null;
    L5:
        mk r8 = (mk) r7;
        if (r8 == null) goto L13;
        d("on PcuTrigger receive msg, displayType:" + r8.getDisplayType() + ", displayValue: " + r8.getDisplayValue() + ", pcuThreshold:" + this.i, new Pair[0]);
        int r0 = (int) r8.getDisplayType();
        RoomViewStats.Companion.getClass();
        if (r0 == RoomViewStats.access$getDisplayTypePCU$cp()) goto L10;
        return;
    L10:
        if (r8.getDisplayValue() < this.i) goto L15;
        ALogger.d(this.a, "on action：pcu");
        e(null);
        return;
    L15:
        return;
    }

    public PcuTrigger(DataCenter r1, long r2) {
        super(r1);
        this.i = r2;
        this.f = TriggerId.Pcu;
        this.g = CollectionsKt.emptyList();
        this.h = CollectionsKt.listOf("WebcastRoomStatsMessage");
    }
}
