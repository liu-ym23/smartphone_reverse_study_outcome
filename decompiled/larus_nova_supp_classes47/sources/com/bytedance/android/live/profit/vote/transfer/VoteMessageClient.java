package com.bytedance.android.live.profit.vote.transfer;

import com.bytedance.android.live.profit.vote.VoteUtilsKt;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.livesdk.message.model.s7;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VoteMessageClient implements o {
    public static final /* synthetic */ int e = 0;
    public final CompositeDisposable a;
    public final PublishSubject<s7> b;
    public final PublishSubject c;
    public final yz0.f d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.transfer.VoteMessageClient$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/s7;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/message/model/s7;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<s7, Unit> {
        public AnonymousClass1(VoteMessageClient r8) {
            super(1, r8, VoteMessageClient.class, "onMessage", "onMessage(Lcom/bytedance/android/livesdk/message/model/IGiftVoteMessage;)V", 0);
        }

        public final void invoke(s7 r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            VoteMessageClient r0 = (VoteMessageClient) ((CallableReference) this).receiver;
            int r1 = VoteMessageClient.e;
            r0.getClass();
            int r2 = v.a;
            v.a("VoteMessageClient", VoteUtilsKt.c(r4));
            r0.b.onNext(r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((s7) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final void onStart() {
        yz0.f r0 = this.d;
        com.bytedance.android.live.revenue.common.message.a r1 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r2 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r1, "$this$GIFT_VOTE_MESSAGE");
        Observable r3 = yz0.h.a.a(r0, (yh6.b) CommonMessageTypeKt.R.getValue(), false, 6);
        final AnonymousClass1 r4 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r3.subscribe(new b(r4)), this.a);
    }

    public final void onStop() {
        this.a.dispose();
        this.b.onComplete();
    }

    public VoteMessageClient(yz0.f r2) {
        Intrinsics.checkNotNullParameter(r2, "roomMessageService");
        this.d = r2;
        this.a = new CompositeDisposable();
        int r3 = com.bytedance.revenue.platform.api.core.rx.o.a;
        PublishSubject<s7> r4 = PublishSubject.create();
        this.b = r4;
        this.c = r4;
    }
}
