package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import zg1.r2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends fx1.c<Object> {
    public final TriggerId d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((r2) r3) == null) goto L6;
            this.a.d("on action：举报", new Pair[0]);
            ALogger.d(this.a.a, "on action：举报");
            this.a.e(null);
            return;
        }
    }

    public e() {
        this.d = TriggerId.REPORT;
    }

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        c(xs2.b.a().b(r2.class).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this)));
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }
}
