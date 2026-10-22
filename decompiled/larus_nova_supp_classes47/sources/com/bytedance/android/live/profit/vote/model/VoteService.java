package com.bytedance.android.live.profit.vote.model;

import com.bytedance.android.live.profit.vote.VoteState;
import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.profit.vote.backend.VoteBackendProcessor;
import com.bytedance.android.live.profit.vote.transfer.VoteMessageClient;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.live.revenue.common.l0;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdk.message.model.s7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.revenue.platform.api.core.rx.n;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VoteService implements o {
    public static final /* synthetic */ int h = 0;
    public final CompositeDisposable a;
    public long b;
    public final Set<Long> c;
    public final VoteMessageClient d;
    public final com.bytedance.android.live.profit.vote.transfer.c e;
    public final f f;
    public final g g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VoteService a;

        public b(VoteService r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            VoteService r0 = this.a;
            VoteService.a(r0, (com.bytedance.android.live.profit.vote.model.a) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            ((jy0.a) com.bytedance.android.live.revenue.core.util.f.a(jy0.a.class)).M3("VoteService", ((Throwable) r4).toString(), null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.model.VoteService$onStart$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/s7;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/message/model/s7;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<s7, Unit> {
        public AnonymousClass3(VoteService r8) {
            super(1, r8, VoteService.class, "onVoteMessage", "onVoteMessage(Lcom/bytedance/android/livesdk/message/model/IGiftVoteMessage;)V", 0);
        }

        public final void invoke(final s7 r14) {
            Intrinsics.checkNotNullParameter(r14, "p1");
            final VoteService r0 = (VoteService) ((CallableReference) this).receiver;
            int r1 = VoteService.h;
            r0.getClass();
            if (r14.getCurrentTime() >= r0.b) goto L6;
            int r2 = v.a;
            v.e("VoteService", "drop out-dated message " + VoteUtilsKt.c(r14));
            return;
        L6:
            if (r0.c.contains(Long.valueOf(r14.getVoteId())) == false) goto L8;
            int r3 = v.a;
            v.e("VoteService", "drop finished message " + VoteUtilsKt.c(r14));
            return;
        L8:
            Intrinsics.checkNotNullParameter(r14, "$this$isKtvVote");
            if (r14.getVoteType() != VoteType.Ktv.getValue()) goto L11;
            boolean r4 = true;
        L12:
            if (r4 == false) goto L16;
            int r5 = VoteConfig.a;
            if (VoteConfig.d(r0.g.isAnchor()) == true) goto L16;
            int r15 = v.a;
            v.a("VoteService", "ktv vote is not visible to current user");
            return;
        L16:
            long r6 = r14.getMsgType();
            if (r6 != VoteMessageType.Create.getValue()) goto L19;
        L42:
            com.bytedance.android.live.profit.vote.model.c r7 = r0.f();
            if (r7 != null) goto L45;
        L47:
            if (r7 == null) goto L49;
            int r8 = v.a;
            v.e("VoteService", "force finish previous vote " + r7);
            r0.d(r7);
        L49:
            VoteState r12 = VoteState.RESUMED;
            Intrinsics.checkNotNullParameter(r14, "$this$toEntity");
            Intrinsics.checkNotNullParameter(r12, "state");
            r0.c(new com.bytedance.android.live.profit.vote.model.c(r14.getVoteId(), r14.getVoteType(), r12, e.a(r14.getResults())), r14.getCurrentTime(), r14.getFinishTime());
        L50:
            r0.b = r14.getCurrentTime();
            return;
        L45:
            if (r7.d != r14.getVoteId()) goto L47;
            int r9 = v.a;
            v.e("VoteService", "UPDATE vote=" + r7);
            r7.b.a(e.a(r14.getResults()));
            goto L50
        L19:
            if (r6 == VoteMessageType.Update.getValue()) goto L42;
            if (r6 != VoteMessageType.Pause.getValue()) goto L29;
            int r10 = v.a;
            v.e("VoteService", "PAUSE vote=" + r0.f());
            long r13 = r14.getVoteId();
            VoteService$onVoteMessage$1 r16 = VoteService$onVoteMessage$1.INSTANCE;
            com.bytedance.android.live.profit.vote.model.c r17 = r0.f();
            if (r17 == null) goto L50;
            if (r17.d != r13) goto L50;
            r16.invoke(r17);
            goto L50
        L29:
            if (r6 != VoteMessageType.Resume.getValue()) goto L36;
            int r18 = v.a;
            v.e("VoteService", "RESUME vote=" + r0.f());
            long r19 = r14.getVoteId();
            Function1<com.bytedance.android.live.profit.vote.model.c, Unit> r20 = new VoteService$onVoteMessage$2(r0, r14);
            com.bytedance.android.live.profit.vote.model.c r22 = r0.f();
            if (r22 == null) goto L50;
            if (r22.d != r19) goto L50;
            r20.invoke(r22);
            goto L50
        L36:
            if (r6 != VoteMessageType.Finish.getValue()) goto L50;
            int r23 = v.a;
            v.e("VoteService", "FINISH vote=" + r0.f());
            long r24 = r14.getVoteId();
            Function1<com.bytedance.android.live.profit.vote.model.c, Unit> r25 = new VoteService$onVoteMessage$3(r0, r14);
            com.bytedance.android.live.profit.vote.model.c r26 = r0.f();
            if (r26 == null) goto L50;
            if (r26.d != r24) goto L50;
            r25.invoke(r26);
            goto L50
        L11:
            r4 = false;
            goto L12
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((s7) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final com.bytedance.android.live.profit.vote.model.c f() {
        return (com.bytedance.android.live.profit.vote.model.c) PropertyOwnersKt.a(this.f.a);
    }

    public final void onStart() {
        int r0 = v.a;
        v.e("VoteService", "start");
        int r1 = VoteBackendProcessor.a;
        if (l0.a("vote") == false) goto L5;
        VoteBackendProcessor.a(IRoomKtKt.getId(this.g.mo444getRoom()), new VoteService$runWithBackendData$1(this), new VoteService$runWithBackendData$2(this), this.a);
    L6:
        PublishSubject r2 = this.d.c;
        final AnonymousClass3 r3 = new AnonymousClass3(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r2.subscribe(new d(r3)), this.a);
        return;
    L5:
        com.bytedance.revenue.platform.api.core.rx.f.a(this.e.a().subscribe(new b(this), c.a), this.a);
        goto L6
    }

    public final void onStop() {
        int r0 = v.a;
        v.e("VoteService", "stop");
        this.a.dispose();
    }

    public final void d(com.bytedance.android.live.profit.vote.model.c r4) {
        int r0 = v.a;
        v.e("VoteService", "finishVote vote=" + r4);
        n<VoteState> r1 = r4.a;
        VoteState r2 = (VoteState) r1.d;
        if (r2 != VoteState.RESUMED) goto L5;
    L6:
        r1.a(VoteState.FINISHED);
    L7:
        this.c.add(Long.valueOf(r4.d));
        return;
    L5:
        if (r2 != VoteState.PAUSED) goto L7;
        goto L6
    }

    public static final void a(VoteService r15, com.bytedance.android.live.profit.vote.model.a r16) {
        com.bytedance.android.live.profit.vote.model.c r1 = (com.bytedance.android.live.profit.vote.model.c) PropertyOwnersKt.a(r15.f.a);
        if (r1 == null) goto L5;
        boolean r2 = com.bytedance.android.live.profit.vote.d.a(r1);
    L6:
        if (r2 == true) goto L35;
        Intrinsics.checkNotNullParameter(r16, "$this$toEntity");
        VoteState.a r3 = VoteState.Companion;
        long r4 = r16.getStatus();
        r3.getClass();
        VoteState r5 = VoteState.RESUMED;
        if (r4 == r5.getCode()) goto L16;
        r5 = VoteState.PAUSED;
        if (r4 == r5.getCode()) goto L16;
        r5 = VoteState.FINISHED;
        if (r4 == r5.getCode()) goto L16;
        VoteState r13 = null;
    L18:
        if (r13 != null) goto L20;
        com.bytedance.android.live.profit.vote.model.c r6 = null;
    L25:
        if (r6 == null) goto L36;
        int r7 = v.a;
        v.a("VoteService", VoteUtilsKt.b(r16));
        if (VoteUtilsKt.h(r6) == false) goto L32;
        int r8 = VoteConfig.a;
        if (VoteConfig.d(r15.g.isAnchor()) == true) goto L32;
        v.a("VoteService", "ktv vote is not visible to current user");
        return;
    L32:
        r15.c(r6, r16.getCurrentTime(), r16.getFinishTime());
        return;
    L36:
        return;
    L20:
        String r9 = r16.getVoteId();
        if (r9 == null) goto L23;
        long r10 = CastLongProtector.parseLong(r9);
    L24:
        r6 = new com.bytedance.android.live.profit.vote.model.c(r10, r16.getVoteType(), r13, e.a(r16.getVoteItems()));
        goto L25
    L23:
        r10 = 0;
    L16:
        r13 = r5;
        goto L18
    L35:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void c(com.bytedance.android.live.profit.vote.model.c r8, long r9, long r12) {
        com.bytedance.android.live.profit.vote.model.d r4 = r8.c;
        r4.getClass();
        long r0 = (1000 * r12) - (r9 * 1000);
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        r4.a = com.bytedance.android.live.profit.vote.model.d.c();
        r4.b = com.bytedance.android.live.profit.vote.model.d.d;
        r4.c = com.bytedance.android.live.profit.vote.model.d.c() + r0;
        n<VoteState> r1 = r8.a;
        VoteState r2 = VoteState.RESUMED;
        r1.a(r2);
        if (r8.a() > 0) goto L13;
        n<VoteState> r3 = r8.a;
        VoteState r5 = (VoteState) r3.d;
        if (r5 != r2) goto L10;
    L11:
        r3.a(VoteState.FINISHED);
    L12:
        int r6 = v.a;
        v.e("VoteService", "assignVote force finish vote " + r9 + '/' + r12);
        goto L13
    L10:
        if (r5 != VoteState.PAUSED) goto L12;
    L13:
        int r10 = v.a;
        v.e("VoteService", "assignVote vote=" + r8);
        n r13 = this.f.a;
        Intrinsics.checkNotNullParameter(r13, "$this$valueNullable");
        r13.a(sh6.c.a(r8));
    }

    public VoteService(VoteMessageClient r2, com.bytedance.android.live.profit.vote.transfer.c r3, f r4, g r5) {
        Intrinsics.checkNotNullParameter(r2, "messageClient");
        Intrinsics.checkNotNullParameter(r3, "apiClient");
        Intrinsics.checkNotNullParameter(r4, "repo");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new CompositeDisposable();
        this.b = 0;
        this.c = new LinkedHashSet();
    }
}
