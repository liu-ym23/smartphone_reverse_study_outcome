package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdk.message.model.f7;
import com.bytedance.android.livesdk.message.model.h7;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class FansClubIMDataSource implements Disposable {
    public final CompositeDisposable a;
    public final PublishSubject<com.bytedance.android.live.profit.fansclub.c> b;
    public final PublishSubject c;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.fansclub.transfer.FansClubIMDataSource$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(FansClubIMDataSource r8) {
            super(1, r8, FansClubIMDataSource.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            FansClubIMDataSource.b((FansClubIMDataSource) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.fansclub.transfer.FansClubIMDataSource$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(FansClubIMDataSource r8) {
            super(1, r8, FansClubIMDataSource.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            FansClubIMDataSource.b((FansClubIMDataSource) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public final class b implements Consumer {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final void dispose() {
        this.a.dispose();
    }

    public final boolean isDisposed() {
        return this.a.isDisposed();
    }

    public FansClubIMDataSource(yz0.l r7) {
        Intrinsics.checkNotNullParameter(r7, "roomMessageService");
        CompositeDisposable r0 = new CompositeDisposable();
        this.a = r0;
        PublishSubject<com.bytedance.android.live.profit.fansclub.c> r1 = PublishSubject.create();
        this.b = r1;
        this.c = r1;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(yz0.h.a.a(r7, com.bytedance.android.live.revenue.common.message.b.p, false, 6).subscribe(new b(new AnonymousClass1(this))), r0);
        RxUtilKt.c(yz0.h.a.a(r7, com.bytedance.android.live.revenue.common.message.b.q, false, 6).subscribe(new b(new AnonymousClass2(this))), r0);
    }

    public static final void b(FansClubIMDataSource r2, yh6.c r3) {
        r2.getClass();
    L28:
        th = move-exception;
        int r4 = v.a;
        v.c("FansClubIMDataSource", th);
        return;
    L4:
        if ((r3 instanceof h7) == false) goto L25;
        int r0 = ((h7) r3).getAction();     // Catch: Throwable -> L28
        if (r0 != 1) goto L8;
        PublishSubject<com.bytedance.android.live.profit.fansclub.c> r5 = r2.b;     // Catch: Throwable -> L28
        IBaseUser r6 = ((h7) r3).getUser();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L28
        r5.onNext(new com.bytedance.android.live.profit.fansclub.c.e(r6));     // Catch: Throwable -> L28
    L31:
        return;
    L8:
        if (r0 != 2) goto L10;
        PublishSubject<com.bytedance.android.live.profit.fansclub.c> r7 = r2.b;     // Catch: Throwable -> L28
        IBaseUser r1 = ((h7) r3).getUser();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L28
        r7.onNext(new com.bytedance.android.live.profit.fansclub.c.C0019c(r1, ((h7) r3).getLeftDiamond()));     // Catch: Throwable -> L28
        goto L31
    L10:
        if (r0 != 4) goto L12;
        PublishSubject<com.bytedance.android.live.profit.fansclub.c> r8 = r2.b;     // Catch: Throwable -> L28
        IBaseUser r9 = ((h7) r3).getUser();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L28
        r8.onNext(new com.bytedance.android.live.profit.fansclub.c.h(r9));     // Catch: Throwable -> L28
        goto L31
    L12:
        if (r0 != 5) goto L14;
        PublishSubject<com.bytedance.android.live.profit.fansclub.c> r10 = r2.b;     // Catch: Throwable -> L28
        IBaseUser r12 = ((h7) r3).getUser();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L28
        r10.onNext(new com.bytedance.android.live.profit.fansclub.c.g(r12));     // Catch: Throwable -> L28
        goto L31
    L14:
        if (r0 != 6) goto L16;
        PublishSubject<com.bytedance.android.live.profit.fansclub.c> r13 = r2.b;     // Catch: Throwable -> L28
        IBaseUser r14 = ((h7) r3).getUser();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L28
        r13.onNext(new com.bytedance.android.live.profit.fansclub.c.f(r14));     // Catch: Throwable -> L28
        goto L31
    L16:
        if (r0 != 7) goto L31;
        PublishSubject<com.bytedance.android.live.profit.fansclub.c> r15 = r2.b;     // Catch: Throwable -> L28
        IBaseUser r16 = ((h7) r3).getUser();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L28
        r15.onNext(new com.bytedance.android.live.profit.fansclub.c.d(r16, ((h7) r3).getLeftDiamond()));     // Catch: Throwable -> L28
        goto L31
    L25:
        if ((r3 instanceof f7) == false) goto L31;
        r2.b.onNext(new com.bytedance.android.live.profit.fansclub.c.a(((f7) r3).getUser(), ((f7) r3).getAction()));     // Catch: Throwable -> L28
        goto L31
    }
}
