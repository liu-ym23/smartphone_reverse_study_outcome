package com.bytedance.android.live.profit.vip;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.livesdk.message.model.ub;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VipDataService implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public Disposable b;
    public final long c;
    public final yz0.g d;
    public final p e;
    public final yz0.f f;
    public final lv0.a g;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vip.VipDataService$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass1(VipDataService r8) {
            super(1, r8, VipDataService.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        public final void invoke(yh6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "p1");
            VipDataService r0 = (VipDataService) ((CallableReference) this).receiver;
            r0.getClass();
            if ((r3 instanceof ub) == false) goto L6;
            r0.e.d("im");
            lv0.a r4 = r0.g;
            r4.getClass();
            Intrinsics.checkNotNullParameter("update_vip_info", "reason");
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).p8(r4.a.getDataCenter());
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yh6.c) r1);
            return Unit.INSTANCE;
        }
    }

    public final void onStart() {
        if (this.d.getUser().getIdString().length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.e.d("enter");
    L9:
        yz0.f r1 = this.f;
        com.bytedance.android.live.revenue.common.message.a r2 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r3 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r2, "$this$SUBSCRIBE_INFO");
        Observable r4 = yz0.h.a.a(r1, (yh6.b) CommonMessageTypeKt.a0.getValue(), false, 6);
        final AnonymousClass1 r5 = new AnonymousClass1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r4.subscribe(new a(r5)), this.a);
        String r6 = this.d.getUser().getIdString();
        IBaseUser r7 = this.d.mo444getRoom().getOwnerKt();
        if (r7 == null) goto L12;
        String r8 = r7.getIdString();
    L14:
        if (Intrinsics.areEqual(r8, r6) == false) goto L17;
        return;
    L17:
        if (IRoomKt_androidKt.isPaidSubscribeRoom(this.d.mo444getRoom()) == false) goto L30;
        Disposable r9 = this.b;
        if (r9 != null) goto L22;
    L27:
        com.bytedance.revenue.platform.api.core.rx.l r10 = com.bytedance.revenue.platform.api.core.rx.l.a;
        long r12 = this.c;
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        this.b = Observable.interval(0, r12, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), k.a);
        return;
    L22:
        if (r9.isDisposed() == true) goto L27;
        Disposable r14 = this.b;
        if (r14 == null) goto L26;
        r14.dispose();
    L26:
        this.b = null;
        goto L27
    L30:
        return;
    L12:
        r8 = null;
        goto L14
    L8:
        com.bytedance.revenue.platform.api.core.rx.f.a(this.d.L0().subscribe(new i(this)), this.a);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public final void onStop() {
        this.a.dispose();
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L12;
        Disposable r1 = this.b;
        if (r1 == null) goto L9;
        r1.dispose();
    L9:
        this.b = null;
        return;
    }

    public VipDataService(yz0.g r2, p r3, yz0.f r4, lv0.a r5) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "repository");
        Intrinsics.checkNotNullParameter(r4, "messageService");
        Intrinsics.checkNotNullParameter(r5, "vipFuncService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new CompositeDisposable();
        this.c = 5;
    }
}
