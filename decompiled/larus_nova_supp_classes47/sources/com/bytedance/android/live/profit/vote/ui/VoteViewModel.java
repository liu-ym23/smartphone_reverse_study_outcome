package com.bytedance.android.live.profit.vote.ui;

import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.l;
import com.bytedance.revenue.platform.api.core.rx.n;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VoteViewModel implements o {
    public static final long h = 0;
    public static final /* synthetic */ int i = 0;
    public final CompositeDisposable a;
    public final CompositeDisposable b;
    public final CompositeDisposable c;
    public final n<com.bytedance.android.live.profit.vote.model.b> d;
    public final n e;
    public final com.bytedance.android.live.profit.vote.model.f f;
    public final com.bytedance.android.live.profit.vote.f g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ VoteViewModel a;

        public b(VoteViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            sh6.b r6 = (sh6.b) r5;
            this.a.b.clear();
            VoteViewModel r0 = this.a;
            com.bytedance.android.live.profit.vote.b r1 = (com.bytedance.android.live.profit.vote.b) sh6.c.b(r6);
            r0.getClass();
            int r2 = v.a;
            v.a("VoteViewModel", "vote changed to " + r1);
            if (r1 != null) goto L6;
            r0.d.a(com.bytedance.android.live.profit.vote.model.b.c.a);
        L10:
            Object r7 = sh6.c.b(r6);
            if (r7 == null) goto L14;
            com.bytedance.android.live.profit.vote.model.c r8 = (com.bytedance.android.live.profit.vote.model.c) r7;
            com.bytedance.revenue.platform.api.core.rx.f.a(PropertyOwnersKt.c(r8.a).subscribe(new i(r8, this)), this.a.b);
            return;
        L14:
            return;
        L6:
            if (VoteUtilsKt.h(r1) == false) goto L10;
            if (VoteUtilsKt.g() == false) goto L10;
            LinkedHashMap r3 = new LinkedHashMap();
            com.bytedance.android.live.profit.vote.f r4 = r0.g;
            r4.c(r3);
            r4.a(r3);
            r4.d(r3);
            VoteUtilsKt.i(r3);
            mz0.n r9 = new mz0.n();
            Map<String, String> r10 = r9.a;
            Intrinsics.checkNotNullParameter(r10, "map");
            Intrinsics.checkNotNullParameter(r3, "map");
            r10.putAll(r3);
            m r12 = new m();
            r12.b(LogCommon.ROOM);
            ((ArrayList) r9.b).addAll(r12.a);
            cy0.e.a.getClass();
            cy0.j r13 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r14);
            ((mz0.i) ((f80.a) r14)).w3("livesdk_ksong_poll_start", r9.a, r9.b);
            goto L10
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.ui.VoteViewModel$onStart$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/vote/model/b;", "p1", "", "invoke", "(Lcom/bytedance/android/live/profit/vote/model/b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<com.bytedance.android.live.profit.vote.model.b, Unit> {
        public AnonymousClass2(VoteViewModel r8) {
            super(1, r8, VoteViewModel.class, "onIconStateChanged", "onIconStateChanged(Lcom/bytedance/android/live/profit/vote/model/IconState;)V", 0);
        }

        public final void invoke(com.bytedance.android.live.profit.vote.model.b r20) {
            Intrinsics.checkNotNullParameter(r20, "p1");
            VoteViewModel r2 = (VoteViewModel) ((CallableReference) this).receiver;
            r2.c.clear();
            int r3 = v.a;
            v.a("VoteViewModel", "icon state changed to " + r20);
            if ((r20 instanceof com.bytedance.android.live.profit.vote.model.b.d) == false) goto L9;
            com.bytedance.android.live.profit.vote.model.b.d r0 = (com.bytedance.android.live.profit.vote.model.b.d) r20;
            com.bytedance.android.live.profit.vote.b r4 = r0.a;
            long r5 = r4.a();
            if (r5 >= 0) goto L7;
            r5 = 0;
        L7:
            long r12 = r5 % 1000;
            l r6 = l.a;
            int r7 = p.a;
            Scheduler r18 = Schedulers.computation();
            TimeUnit r8 = TimeUnit.MILLISECONDS;
            com.bytedance.revenue.platform.api.core.rx.f.a(Observable.interval(0, 1000, r8, r18).delay(r12, r8, Schedulers.computation(), false).startWith(0L).observeOn(AndroidSchedulers.mainThread()).map(new j(r4)).subscribe(new k(r2, r0, r4)), r2.c);
            return;
        L9:
            if ((r20 instanceof com.bytedance.android.live.profit.vote.model.b.a) == false) goto L12;
            l r9 = l.a;
            long r10 = VoteViewModel.h * ((long) WebcastRedirectException.UNKNOWN);
            int r13 = p.a;
            com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(r10, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(r2, r20)), r2.c);
            return;
        L12:
            if ((r20 instanceof com.bytedance.android.live.profit.vote.model.b.C0056b) == false) goto L41;
            l r14 = l.a;
            long r15 = ((long) WebcastRedirectException.UNKNOWN) * 5;
            int r16 = p.a;
            com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(r15, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r2)), r2.c);
            com.bytedance.android.live.profit.vote.model.b.C0056b r1 = (com.bytedance.android.live.profit.vote.model.b.C0056b) r20;
            if (VoteUtilsKt.h(r1.a) == true) goto L16;
            return;
        L16:
            if (VoteUtilsKt.g() == false) goto L43;
            LinkedHashMap r17 = new LinkedHashMap();
            com.bytedance.android.live.profit.vote.f r19 = r2.g;
            r19.c(r17);
            r19.a(r17);
            r19.d(r17);
            VoteUtilsKt.i(r17);
            Object r22 = r1.a.getItems().d;
            if (((List) r22).size() < 2) goto L20;
            boolean r23 = true;
        L21:
            if (r23 == true) goto L24;
            r22 = null;
        L24:
            List r24 = (List) r22;
            if (r24 == null) goto L37;
            com.bytedance.android.live.profit.vote.g r25 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r24, 0);
            com.bytedance.android.live.profit.vote.g r26 = (com.bytedance.android.live.profit.vote.g) ListProtector.get(r24, 1);
            int r27 = f.b[VoteUtilsKt.a(r25, r26).ordinal()];
            if (r27 == 1) goto L35;
            if (r27 != 2) goto L30;
            String r28 = "negative";
        L36:
            r17.put("poll_result", r28);
            r17.put("positive_score", String.valueOf(r26.a));
            r17.put("negative_score", String.valueOf(r25.a));
            r17.put("score", String.valueOf(r26.a) + String.valueOf(r25.a));
            goto L37
        L30:
            if (r27 != 3) goto L33;
            r28 = "positive";
            goto L36
        L33:
            throw new NoWhenBranchMatchedException();
        L35:
            r28 = "equal";
        L37:
            mz0.n r29 = new mz0.n();
            Map<String, String> r30 = r29.a;
            Intrinsics.checkNotNullParameter(r30, "map");
            Intrinsics.checkNotNullParameter(r17, "map");
            r30.putAll(r17);
            m r32 = new m();
            r32.b(LogCommon.ROOM);
            ((ArrayList) r29.b).addAll(r32.a);
            cy0.e.a.getClass();
            cy0.j r33 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r34 = com.bytedance.android.scope.m.b(r33).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
            Intrinsics.checkNotNull(r34);
            ((mz0.i) ((f80.a) r34)).w3("livesdk_ksong_poll_end", r29.a, r29.b);
            return;
        L20:
            r23 = false;
            goto L21
        L43:
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((com.bytedance.android.live.profit.vote.model.b) r1);
            return Unit.INSTANCE;
        }
    }

    static {
        h = 9;
    }

    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(PropertyOwnersKt.c(this.f.a).subscribe(new b(this)), this.a);
        n<com.bytedance.android.live.profit.vote.model.b> r0 = this.d;
        final AnonymousClass2 r1 = new AnonymousClass2(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.subscribe(new c(r1)), this.a);
    }

    public final void onStop() {
        this.a.dispose();
        this.b.dispose();
        this.c.dispose();
        this.d.onComplete();
    }

    public VoteViewModel(com.bytedance.android.live.profit.vote.model.f r2, com.bytedance.android.live.profit.vote.f r3) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        Intrinsics.checkNotNullParameter(r3, "etHelper");
        this.f = r2;
        this.g = r3;
        this.a = new CompositeDisposable();
        this.b = new CompositeDisposable();
        this.c = new CompositeDisposable();
        n<com.bytedance.android.live.profit.vote.model.b> r4 = PropertyOwnersKt.b(com.bytedance.android.live.profit.vote.model.b.c.a);
        this.d = r4;
        this.e = r4;
    }
}
