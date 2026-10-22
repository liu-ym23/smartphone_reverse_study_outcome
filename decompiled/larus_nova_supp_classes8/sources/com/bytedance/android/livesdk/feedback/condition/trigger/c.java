package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends fx1.d {
    public final TriggerId d;
    public final String e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            IFollowPair r5 = (IFollowPair) r4;
            if (r5 == null) goto L5;
            Integer r6 = Integer.valueOf(r5.getFollowStatus());
        L7:
            if (r6 != null) goto L10;
        L12:
            if (r6 != null) goto L15;
        L17:
            if (r6 != null) goto L20;
            return;
        L20:
            if (r6.intValue() != 0) goto L24;
            this.a.d("on action：取关", new Pair[0]);
            ALogger.d(this.a.a, "on action：取关");
            c r7 = this.a;
            r7.getClass();
            r7.e(fx1.c.f(3));
            return;
        L24:
            return;
        L15:
            if (r6.intValue() != 2) goto L17;
        L16:
            this.a.d("on action：关注", new Pair[0]);
            ALogger.d(this.a.a, "on action：关注");
            c r8 = this.a;
            r8.getClass();
            r8.e(fx1.c.f(1));
            return;
        L10:
            if (r6.intValue() != 1) goto L12;
        L5:
            r6 = null;
            goto L7
        }
    }

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        c(k.n(IUserService.class).user().u0(this.e).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this)));
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "roomOwnerId");
        this.e = r2;
        this.d = TriggerId.FOLLOW;
    }
}
