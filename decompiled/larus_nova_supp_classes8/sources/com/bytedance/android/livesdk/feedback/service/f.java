package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.live.base.model.feedback.FeedbackCard;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.feedback.LightFeedbackDataManager;
import com.bytedance.android.livesdk.feedback.light.help.FeedbackIntervalHelper;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ h a;

    public f(h r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        FeedbackCard r8 = ((com.bytedance.android.live.base.model.feedback.a.a) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r7)).data).feedbackCard;
        if (r8 == null) goto L19;
        int r0 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r1 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r1.a = "RoomLightFeedbackConfig";
        r1.c("获取到问卷数据，判断问卷是否走展示流程");
        r1.b(new Pair[]{TuplesKt.to("roomId", Long.valueOf(this.a.a.d.b)), TuplesKt.to("feedbackInfo", JsonUtil.toJSONString(r8))});
        r1.d();
        r8.feedbackType = r8.inflowFeedbackType;
        LightFeedbackDataManager.Companion.getClass();
        LightFeedbackDataManager r2 = LightFeedbackDataManager.a.a();
        if (r2 == null) goto L7;
        r2.saveLiveRoomFeedback(this.a.c.longValue(), r8);
    L7:
        h r9 = this.a;
        FeedbackCard r10 = r9.a.e(r9.c.longValue());
        if (r10 != null) goto L10;
    L17:
        FeedbackMonitor.Monitor r11 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r11.a = "RoomLightFeedbackConfig";
        r11.c("tag:" + this.a.a.getClass().getSimpleName() + " 对该问卷类型不感兴趣，不展示问卷");
        r11.d();
        Unit r12 = Unit.INSTANCE;
        return;
    L10:
        if ((!FeedbackIntervalHelper.b(r10)) == true) goto L13;
        r10 = null;
    L13:
        if (r10 == null) goto L17;
        FeedbackMonitor.Monitor r13 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r13.a = "RoomLightFeedbackConfig";
        r13.c("问卷开始走展示流程");
        r13.d();
        FeedbackCommonObserver r14 = (FeedbackCommonObserver) this.a.a.a.getValue();
        if (r14 == null) goto L20;
        r14.startFeedbackObserve();
        return;
    L20:
        return;
    }
}
