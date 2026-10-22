package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import android.content.Context;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKInviteContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkMatchInvitedFragment;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.s1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t extends x31.f {
    public Disposable d;
    public final InteractDialogPKInviteContract$View e;
    public final s1 f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ t a;

        public a(t r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            this.a.e.ba0(-1);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ t a;

        public b(t r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.e.ba0(6);
            Context r0 = this.a.e.getContext();
            ExceptionUtils.handleException(r0, (Throwable) r3);
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ int a;

        public c(int r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "sec");
            return Long.valueOf(((long) this.a) - r6.longValue());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ t a;

        public d(t r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.e.ca0((int) ((Long) r4).longValue());
        }
    }

    @Override // x31.f
    public final void f() {
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // x31.f
    public final void h(int r6) {
        this.d = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.SECONDS).take(((long) r6) + 1).map(new c(r6)).observeOn(AndroidSchedulers.mainThread()).as(this.c.S90())).subscribe(new d(this));
    }

    public t(InteractPkMatchInvitedFragment r2, s1 r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "message");
        super(r2);
        this.e = r2;
        this.f = r3;
    }

    @Override // x31.f
    public final void g(int r39, long r40, long r42, IBaseUser r44) {
        long r5 = this.f.getFromRoomId();
        int r7 = this.f.getInviteType();
        int r8 = this.f.getMatchType();
        s1 r1 = this.f;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "$this$fromUid");
        String r9 = r1.get_fromUid();
    L6:
        s1 r2 = this.f;
        if (r2 == null) goto L15;
        IBattleLinkerInviteMessageExtra r3 = r2.getBattleExtra();
        if (r3 == null) goto L15;
        IRoom r4 = r3.getInviteRoom();
        if (r4 == null) goto L15;
        IBaseUser r6 = r4.getOwner();
        if (r6 == null) goto L15;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r10 = r6.getCastSecUid();
    L16:
        s1 r12 = this.f;
        if (r12 == null) goto L21;
        IBattleLinkerInviteMessageExtra r13 = r12.getBattleExtra();
        if (r13 == null) goto L21;
        IRoom r14 = r13.getInviteRoom();
    L22:
        int r15 = BizType.PK.ordinal();
        String r16 = com.bytedance.android.live.core.utils.s1.B(2131919437);
        int r17 = l51.a.j();
        String r26 = this.f.getBattleAttachedInfo();
        String r18 = this.f.getClientInfo();
        if (r18 != null) goto L25;
        r18 = "";
    L25:
        d11.d r19 = new d11.d(1, r42, r5, r7, r8, r9, r10, r14, r15, r16, r17, null, 0, 0, null, 0, null, null, null, r26, 0, 0, 0, null, r18, null, null, null, 519567360);
        com.bytedance.android.live.revlink.impl.pk.service.b r20 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r20 == null) goto L31;
        com.bytedance.android.live.revenuelink.connect.n r22 = r20.getLinkOutManagerFn();
        if (r22 == null) goto L32;
        r22.d(r19, null);
        return;
    L32:
        return;
    L31:
        return;
    L21:
        r14 = null;
    L15:
        r10 = null;
        goto L16
    L5:
        r9 = null;
        goto L6
    }

    @Override // x31.f
    public final void e(long r10, long r12, String r14, long r15, String r17, String r18) {
        r31.a r2 = r31.b.a(r31.a.a);
        long r3 = 2;
        if (r14 != null) goto L5;
        String r7 = "";
    L6:
        s1 r5 = this.f;
        if (r5 == null) goto L12;
        String r6 = r5.getClientInfo();
        if (r6 == null) goto L12;
        String r8 = r6;
    L13:
        Observable<ExtraResponse<Object, Extra>> r1 = r2.o(r3, r12, r7, r8);
        if (r1 == null) goto L21;
        Observable r4 = r1.compose(RxUtil.rxSchedulerHelper());
        if (r4 == null) goto L22;
        ObservableSubscribeProxy r9 = (ObservableSubscribeProxy) r4.as(this.c.S90());
        if (r9 == null) goto L23;
        r9.subscribe(new a(this), new b(this));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L12:
        r8 = "";
        goto L13
    L5:
        r7 = r14;
        goto L6
    }
}
