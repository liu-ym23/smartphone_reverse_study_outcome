package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdkapi.feedback.event.FeedbackSendGiftEvent;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends fx1.d {
    public final TriggerId d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((FeedbackSendGiftEvent) r3) == null) goto L6;
            this.a.d("on action：送礼", new Pair[0]);
            ALogger.d(this.a.a, "on action：送礼");
            f r4 = this.a;
            r4.getClass();
            r4.e(fx1.c.f(5));
            return;
        }
    }

    public f() {
        this.d = TriggerId.SEND_GIFT;
    }

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        c(xs2.b.a().b(FeedbackSendGiftEvent.class).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this)));
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }
}
