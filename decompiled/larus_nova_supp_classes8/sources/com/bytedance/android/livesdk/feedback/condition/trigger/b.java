package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends fx1.d {
    public final TriggerId d;
    public final DataCenter e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            if (r4 == null) goto L6;
            r4.longValue();
            this.a.d("on action：点赞", new Pair[0]);
            ALogger.d(this.a.a, "on action：点赞");
            b r5 = this.a;
            r5.getClass();
            r5.e(fx1.c.f(6));
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.feedback.condition.trigger.b$b, reason: collision with other inner class name */
    public static final class C0316b<T> implements Consumer {
        public final /* synthetic */ n a;
        public final /* synthetic */ b b;

        public C0316b(n r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r1) {
            sh6.b r2 = (sh6.b) r1;
            this.b.g();
        }
    }

    public final void g() {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = this.e;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        if (r2 == null) goto L14;
        m r3 = r2.getDiggTime();
        if (r3 == null) goto L15;
        Observable r4 = r3.a();
        if (r4 == null) goto L16;
        Observable r5 = r4.compose(RxUtil.rxSchedulerHelper());
        if (r5 == null) goto L17;
        Disposable r6 = r5.subscribe(new a(this));
        if (r6 == null) goto L18;
        c(r6);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.e, 0, 2);
        if (r0 == null) goto L11;
        n r1 = r0.getInteractionDataPrepared();
        if (r1 != null) goto L7;
        return;
    L7:
        if (((Room) r1.getValue()) == null) goto L9;
        g();
        return;
    L9:
        c(r1.a().subscribe(new C0316b(r1, this)));
        Unit r2 = Unit.INSTANCE;
        return;
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }

    public b(DataCenter r1) {
        this.e = r1;
        this.d = TriggerId.DIGG;
    }
}
