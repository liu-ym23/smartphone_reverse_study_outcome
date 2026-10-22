package com.bytedance.android.live.messagewindow.framework.schedule;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.room.api.messagewindow.schedule.ScheduleParams;
import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import com.bytedance.live.datacontext.DataContext;
import im0.c;
import im0.d;
import im0.e;
import im0.f;
import im0.g;
import io.reactivex.disposables.Disposable;
import java.util.LinkedList;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import y61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J3\u0010\u0010\u001a\u00020\u0007\"\u0010\b\u0000\u0010\f*\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\r¢\u0006\u0002\b\u000eH\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/schedule/CardActionScheduler;", "Lcom/bytedance/live/datacontext/DataContext;", "Li71/a;", "Lcom/bytedance/android/live/messagewindow/framework/schedule/a;", "params", "Lim0/a;", "action", "", "doAction", "doNextAction", "Lcom/bytedance/android/live/room/api/messagewindow/schedule/ScheduleParams;", "Lv61/c;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "paramsInit", "execute", "Ljava/util/LinkedList;", "actionQueue", "Ljava/util/LinkedList;", "curAction", "Lim0/a;", "com/bytedance/android/live/messagewindow/framework/schedule/CardActionScheduler$a", "actionFactory", "Lcom/bytedance/android/live/messagewindow/framework/schedule/CardActionScheduler$a;", "Ly61/b;", "cardContext", "Ly61/b;", "<init>", "(Ly61/b;)V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardActionScheduler extends DataContext implements i71.a {
    private final a actionFactory;
    private final LinkedList<im0.a> actionQueue;
    private final b cardContext;
    private im0.a curAction;

    public static final class a {
        public final /* synthetic */ CardActionScheduler a;

        public a(CardActionScheduler r1) {
            this.a = r1;
        }

        public final im0.a a(com.bytedance.android.live.messagewindow.framework.schedule.a r5) {
            Intrinsics.checkNotNullParameter(r5, "params");
            v61.a r0 = ((ScheduleParams) r5).c;
            if (r0 != null) goto L9;
            IllegalStateException r1 = new IllegalStateException("the ScheduleParams's msgWindow is null");
            i r2 = CardActionScheduler.access$getCardContext$p(this.a).monitor();
            if (r2 == null) goto L27;
            CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();
            r3.c("create card action fail, the card is null");
            r3.a("cmd", ((ScheduleParams) r5).a);
            Intrinsics.checkNotNullParameter(r1, "tr");
            r3.a = r1;
            Unit r6 = Unit.INSTANCE;
            r2.d(r3.b());
            throw r1;
        L27:
            throw r1;
        L9:
            r0.h = ((ScheduleParams) r5).d;
            j71.a r4 = ((ScheduleParams) r5).a;
            if ((r4 instanceof j71.a.d) == false) goto L13;
            int r7 = com.bytedance.android.live.messagewindow.framework.process.a.d;
            return new e(com.bytedance.android.live.messagewindow.framework.process.a.C0130a.a(CardActionScheduler.access$getCardContext$p(this.a), r0));
        L13:
            if ((r4 instanceof j71.a.f) == false) goto L16;
            int r8 = com.bytedance.android.live.messagewindow.framework.process.a.d;
            return new f(com.bytedance.android.live.messagewindow.framework.process.a.C0130a.a(CardActionScheduler.access$getCardContext$p(this.a), r0));
        L16:
            if ((r4 instanceof j71.a.b) == false) goto L20;
            int r9 = com.bytedance.android.live.messagewindow.framework.process.a.d;
            im0.a r10 = new d(com.bytedance.android.live.messagewindow.framework.process.a.C0130a.a(CardActionScheduler.access$getCardContext$p(this.a), r0), r5);
        L30:
            return r10;
        L20:
            if ((r4 instanceof j71.a.a) == false) goto L23;
            int r11 = com.bytedance.android.live.messagewindow.framework.process.a.d;
            r10 = new im0.b(com.bytedance.android.live.messagewindow.framework.process.a.C0130a.a(CardActionScheduler.access$getCardContext$p(this.a), r0), r5);
            goto L30
        L23:
            if ((r4 instanceof j71.a.e) == false) goto L26;
            int r12 = com.bytedance.android.live.messagewindow.framework.process.a.d;
            r10 = new g(com.bytedance.android.live.messagewindow.framework.process.a.C0130a.a(CardActionScheduler.access$getCardContext$p(this.a), r0), r5.f);
            goto L30
        L26:
            return new c(r5);
        }
    }

    private final synchronized void doNextAction() {
        monitor-enter(this);
        im0.a r0 = this.actionQueue.poll();     // Catch: Throwable -> L24
        this.curAction = r0;     // Catch: Throwable -> L24
        if (r0 == null) goto L22;
        r0.a(2);     // Catch: Throwable -> L24
        r0.run();     // Catch: Throwable -> L8 Exception -> L10
    L17:
        doNextAction();     // Catch: Throwable -> L24
        goto L22
    L8:
        th = move-exception;
        doNextAction();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L10:
        e = move-exception;
        i r2 = this.cardContext.monitor();     // Catch: Throwable -> L8
        if (r2 == null) goto L16;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();     // Catch: Throwable -> L8
        r3.c("CardActionScheduler doNextAction error");     // Catch: Throwable -> L8
        r3.a("cardAction", r0);     // Catch: Throwable -> L8
        r3.a("cmd", r0.c);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(e, "tr");     // Catch: Throwable -> L8
        r3.a = e;     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r2.d(r3.b());     // Catch: Throwable -> L8
    L16:
        if (v.a() == false) goto L17;
        throw e;     // Catch: Throwable -> L8
    L22:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public CardActionScheduler(b r2) {
        Intrinsics.checkNotNullParameter(r2, "cardContext");
        this.cardContext = r2;
        this.actionQueue = new LinkedList();
        this.actionFactory = new a(this);
    }

    public static final /* synthetic */ b access$getCardContext$p(CardActionScheduler r0) {
        return r0.cardContext;
    }

    public synchronized <T extends ScheduleParams<? extends v61.c>> void execute(Function1<? super T, Unit> r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "paramsInit");     // Catch: Throwable -> L37
        if (v71.a.a() == true) goto L12;
        i r6 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();     // Catch: Throwable -> L37
        if (r6 == null) goto L9;
        CardAlogParamsBuilder r0 = new CardAlogParamsBuilder();     // Catch: Throwable -> L37
        r0.c("卡片管控框架开关未开启，无法处理！");     // Catch: Throwable -> L37
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L37
        r6.d(r0.b());     // Catch: Throwable -> L37
    L9:
        monitor-exit(this);
        return;
    L12:
        Function1 r7 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 1);     // Catch: Throwable -> L37
        final com.bytedance.android.live.messagewindow.framework.schedule.a r2 = new com.bytedance.android.live.messagewindow.framework.schedule.a();     // Catch: Throwable -> L37
        r7.invoke(r2);     // Catch: Throwable -> L37
        if (((ScheduleParams) r2).c != null) goto L23;
        i r8 = this.cardContext.monitor();     // Catch: Throwable -> L37
        if (r8 == null) goto L18;
        CardAlogParamsBuilder r3 = new CardAlogParamsBuilder();     // Catch: Throwable -> L37
        r3.c("can't not execute card action because the card is null");     // Catch: Throwable -> L37
        r3.a("cmd", ((ScheduleParams) r2).a);     // Catch: Throwable -> L37
        IllegalStateException r4 = new IllegalStateException("card is null");     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r4, "tr");     // Catch: Throwable -> L37
        r3.a = r4;     // Catch: Throwable -> L37
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L37
        r8.d(r3.b());     // Catch: Throwable -> L37
    L18:
        com.bytedance.android.live.room.api.messagewindow.monitor.f r10 = com.bytedance.android.live.room.api.messagewindow.monitor.d.b("card_action_scheduler_fail_by_null_card");     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter("the card is null", "info");     // Catch: Throwable -> L37
        r10.c = "the card is null";     // Catch: Throwable -> L37
        i r11 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();     // Catch: Throwable -> L37
        if (r11 == null) goto L21;
        r11.e(new com.bytedance.android.live.room.api.messagewindow.monitor.e(r10));     // Catch: Throwable -> L37
    L21:
        monitor-exit(this);
        return;
    L23:
        final im0.a r12 = this.actionFactory.a(r2);     // Catch: Throwable -> L37
        IMiddlewareMsgWindowService r13 = k.f(IMiddlewareMsgWindowService.class);     // Catch: Throwable -> L37
        if (r13 != null) goto L26;
    L34:
        doAction(r2, r12);     // Catch: Throwable -> L37
    L35:
        monitor-exit(this);
        return;
    L26:
        if (r13.getCardContainerOptConfig() != true) goto L34;
        v61.a r14 = ((ScheduleParams) r2).c;     // Catch: Throwable -> L37
        if (r14 == null) goto L35;
        MsgWindowPosition r15 = r14.getPosition();     // Catch: Throwable -> L37
        if (r15 == null) goto L35;
        Disposable r16 = this.cardContext.useContainer(r15, new CardActionScheduler$execute$$inlined$also$lambda$1(r2, r12, this));     // Catch: Throwable -> L37
        if (r16 == null) goto L35;
        RxUtilKt.c(r16, this.cardContext.getContainerCd());     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    private final synchronized void doAction(com.bytedance.android.live.messagewindow.framework.schedule.a r5, im0.a r6) {
        monitor-enter(this);
        i r0 = this.cardContext.monitor();     // Catch: Throwable -> L19
        if (r0 == null) goto L7;
        CardAlogParamsBuilder r1 = new CardAlogParamsBuilder();     // Catch: Throwable -> L19
        r1.c("CardActionScheduler doAction start");     // Catch: Throwable -> L19
        r1.a("cardAction", r6);     // Catch: Throwable -> L19
        r1.a("cmd", r6.c);     // Catch: Throwable -> L19
        r1.a("enqueue mode", r6.c);     // Catch: Throwable -> L19
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r0.d(r1.b());     // Catch: Throwable -> L19
    L7:
        ScheduleParams.Enqueue r7 = ((ScheduleParams) r5).b;     // Catch: Throwable -> L19
        if (r7 != ScheduleParams.Enqueue.Immediately) goto L11;
        r6.a(2);     // Catch: Throwable -> L19
        r6.run();     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L11:
        if (r7 != ScheduleParams.Enqueue.Head) goto L13;
        this.actionQueue.offerFirst(r6);     // Catch: Throwable -> L19
    L15:
        if (this.curAction != null) goto L17;
        doNextAction();     // Catch: Throwable -> L19
        goto L17
    L13:
        this.actionQueue.offer(r6);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$doAction(CardActionScheduler r0, com.bytedance.android.live.messagewindow.framework.schedule.a r1, im0.a r2) {
        r0.doAction(r1, r2);
    }
}
