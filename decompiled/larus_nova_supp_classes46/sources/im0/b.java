package im0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.messagewindow.framework.process.card.DetachContainerPs;
import com.bytedance.android.live.messagewindow.framework.process.card.NotifyCardShowPs;
import com.bytedance.android.live.messagewindow.framework.process.card.TransitionAnimPs;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends im0.a {
    public final com.bytedance.android.live.messagewindow.framework.process.a e;
    public final com.bytedance.android.live.messagewindow.framework.schedule.a f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.messagewindow.framework.process.card.a a;
        public final /* synthetic */ b b;

        public a(com.bytedance.android.live.messagewindow.framework.process.card.a r1, b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            if (((com.bytedance.android.live.messagewindow.framework.process.card.a.c) r4).a != 2) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L16;
            i r6 = this.b.e.b.monitor();
            String r0 = "卡片 " + this.b.e.c.j + " 销毁失败，失败节点为: " + this.a.b().name();
            if (r6 == null) goto L11;
            CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
            r1.c(r0);
            Unit r2 = Unit.INSTANCE;
            r6.d(r1.b());
        L11:
            com.bytedance.android.live.room.api.messagewindow.monitor.f r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_dismiss_action_interrupt");
            r7.a(this.b.e.c.j);
            r7.b(r0);
            i r3 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r3 == null) goto L14;
            r3.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r7));
        L14:
            this.b.a(3);
            return;
        L16:
            return;
        L5:
            r5 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: im0.b$b, reason: collision with other inner class name */
    public static final class C0223b<T> implements SingleOnSubscribe {
        public final /* synthetic */ b a;

        public C0223b(b r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Unit> r4) {
            Intrinsics.checkNotNullParameter(r4, "it");
            i r5 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
            if (r5 == null) goto L7;
            com.bytedance.android.live.room.api.messagewindow.monitor.c r0 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_msg_card_request_dismiss");
            r0.b("card_id", this.a.e.c.j);
            Unit r1 = Unit.INSTANCE;
            r5.b(r0.a());
            return;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();
        r1.c("—————— 卡片 " + this.e.c.j + " 处理销毁流程 ——————");
        Unit r2 = Unit.INSTANCE;
        r0.d(r1.b());
    L6:
        com.bytedance.android.live.messagewindow.framework.process.a r3 = this.e;
        r3.getClass();
        Intrinsics.checkNotNullParameter(this, "action");
        r3.a = this;
        List r4 = CollectionsKt.mutableListOf(new com.bytedance.android.live.messagewindow.framework.process.card.a[]{new com.bytedance.android.live.messagewindow.framework.process.card.c(), new TransitionAnimPs(false), new DetachContainerPs()});
        if (this.f.e == false) goto L9;
        r4.add(new NotifyCardShowPs());
    L9:
        r4.add(new com.bytedance.android.live.messagewindow.framework.process.card.d());
        r4.add(new com.bytedance.android.live.messagewindow.framework.process.card.e());
        Iterator r5 = r4.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        com.bytedance.android.live.messagewindow.framework.process.card.a r6 = (com.bytedance.android.live.messagewindow.framework.process.card.a) r5.next();
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(r6.c).subscribe(new a(r6, this)), this.d);
        goto L11
    L13:
        Single.create(new C0223b(this)).subscribeOn(Schedulers.io()).subscribe();
        com.bytedance.android.live.room.api.messagewindow.monitor.f r7 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_dismiss_action_start");
        r7.a(this.e.c.j);
        i r8 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r8 == null) goto L16;
        r8.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r7));
    L16:
        new hm0.b(this.e, r4).a(this.e);
    }

    public b(com.bytedance.android.live.messagewindow.framework.process.a r2, com.bytedance.android.live.messagewindow.framework.schedule.a r3) {
        Intrinsics.checkNotNullParameter(r2, "session");
        Intrinsics.checkNotNullParameter(r3, "params");
        super(j71.a.a.b);
        this.e = r2;
        this.f = r3;
    }
}
