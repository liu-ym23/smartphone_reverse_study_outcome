package com.bytedance.android.livesdk.feedback.service;

import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdk.feedback.utils.FeedbackMonitor;
import com.bytedance.android.livesdk.message.model.o4;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ RoomLightFeedbackConfig a;
    public final /* synthetic */ o4 b;
    public final /* synthetic */ Long c;

    public h(RoomLightFeedbackConfig r1, o4 r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r6) {
        Long r7 = (Long) r6;
        int r8 = FeedbackMonitor.a;
        FeedbackMonitor.Monitor r9 = new FeedbackMonitor.Monitor();
        Intrinsics.checkNotNullParameter("RoomLightFeedbackConfig", "page");
        r9.a = "RoomLightFeedbackConfig";
        r9.c("收到问卷消息，请求问卷数据");
        r9.a("roomId", Long.valueOf(this.a.d.b));
        r9.d();
        this.a.b.add(((IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class)).getLiveRoomFeedbackCard(this.b.questionnaireId, this.c.longValue()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this), g.a));
    }
}
