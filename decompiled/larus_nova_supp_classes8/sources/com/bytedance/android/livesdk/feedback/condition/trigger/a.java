package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.event.z;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends fx1.d {
    public final TriggerId d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.condition.trigger.a$a, reason: collision with other inner class name */
    public static final class C0315a<T> implements Consumer {
        public final /* synthetic */ a a;

        public C0315a(a r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((z) r3) == null) goto L6;
            this.a.d("on action：评论", new Pair[0]);
            ALogger.d(this.a.a, "on action：评论");
            a r4 = this.a;
            r4.getClass();
            r4.e(fx1.c.f(4));
            return;
        }
    }

    public a() {
        this.d = TriggerId.COMMENT;
    }

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        c(xs2.b.a().b(z.class).compose(RxUtil.rxSchedulerHelper()).subscribe(new C0315a(this)));
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }
}
