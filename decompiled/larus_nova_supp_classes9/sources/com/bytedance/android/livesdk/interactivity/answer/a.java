package com.bytedance.android.livesdk.interactivity.answer;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import o42.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ HybridCard a;
    public final /* synthetic */ AnswerQuestionServiceWidget b;

    public a(HybridCard r1, AnswerQuestionServiceWidget r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        Unit r6 = (Unit) r5;
        if (this.b.b == this.a.getHeight()) goto L11;
        AnswerQuestionServiceWidget r7 = this.b;
        r7.b = this.a.getHeight();
        InteractionWidgetsPosContext r8 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this.b).dataCenter, 0, 2);
        if (r8 == null) goto L9;
        m r9 = r8.getAnswerQuestionContainerHeight();
        if (r9 == null) goto L9;
        r9.setValue(Integer.valueOf(this.b.b));
    L9:
        RxBusAbility.INSTANCE.getRxBus(((Widget) this.b).dataCenter).post(new c(false, true, "AnswerQuestionCardShow"));
        return;
    }
}
