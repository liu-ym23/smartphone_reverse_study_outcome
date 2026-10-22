package com.bytedance.android.livesdk.feedback.condition.observer;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.feedback.api.IFeedbackApi;
import com.bytedance.android.livesdk.message.model.o4;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveRoomFeedbackConditionObserver a;
    public final /* synthetic */ o4 b;

    public c(LiveRoomFeedbackConditionObserver r1, o4 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Integer r6 = (Integer) r5;
        ((IFeedbackApi) com.bytedance.android.live.network.c.b().e(IFeedbackApi.class)).getLiveRoomFeedbackCard(this.b.questionnaireId, z.o(this.a.getDataCenter()).getRoomId()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a);
    }
}
