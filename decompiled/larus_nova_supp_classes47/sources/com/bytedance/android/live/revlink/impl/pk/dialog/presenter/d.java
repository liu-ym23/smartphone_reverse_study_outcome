package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKInviteContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKBeInviteFragment;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends x31.f {
    public Disposable d;
    public final IBattleLinkerInviteMessageExtra e;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ int a;

        public a(int r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            long r0 = ((Number) r5).longValue();
            return Long.valueOf(((long) this.a) - r0);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            long r0 = ((Number) r3).longValue();
            ((InteractDialogPKInviteContract$View) this.a.c).ca0((int) r0);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            d r0 = this.a;
            r0.d((Throwable) r2);
        }
    }

    @Override // x31.f
    public final void f() {
        Disposable r0 = this.d;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.dispose();
        return;
    }

    @Override // x31.f
    public final void h(int r6) {
        this.d = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.SECONDS).take(r6 + 1).map(new a(r6)).observeOn(AndroidSchedulers.mainThread()).as(this.c.S90())).subscribe(new b(this), new c(this));
    }

    public d(InteractPKBeInviteFragment r1, IBattleLinkerInviteMessageExtra r2) {
        super(r1);
        this.e = r2;
    }

    @Override // x31.f
    public final void g(int r24, long r25, long r27, IBaseUser r29) {
        Intrinsics.checkNotNullParameter(r29, "user");
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L23;
        com.bytedance.android.live.revlink.impl.pk.service.b r2 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r2);
        if (r2.getLinkOutManagerFn() == null) goto L23;
        d11.a r3 = new d11.a(0, 0, 0, null, false, false, false, null, 0, null, null, null, 4095);
        IBattleLinkerInviteMessageExtra r4 = this.e;
        if (r4 == null) goto L9;
        r3.i = r4.getSwitchPlayMode();
    L9:
        com.bytedance.android.live.revlink.impl.pk.service.b r5 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r5);
        com.bytedance.android.live.revenuelink.connect.n r15 = r5.getLinkOutManagerFn();
        if (r15 == null) goto L23;
        int r6 = BizType.PK.ordinal();
        w31.c r7 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r7 == null) goto L14;
        String r8 = r7.c();
    L15:
        if (r8 == null) goto L20;
        w31.c r9 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r9 == null) goto L19;
        String r10 = r9.c();
    L21:
        String r22 = r10;
    L22:
        Intrinsics.checkNotNullParameter(r29, "$this$secUidExt");
        r15.h(new d11.g(7, r6, r25, r27, r24, r22, r29.getCastSecUid(), null, null, r3, null, "", null, null, 12288), null);
        goto L23
    L19:
        r22 = null;
        goto L22
    L20:
        r10 = iz.a.a(r29);
        goto L21
    L14:
        r8 = null;
    L23:
        ((InteractDialogPKInviteContract$View) this.c).ba0(r24);
    }

    @Override // x31.f
    public final void e(long r15, long r17, String r19, long r20, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r19, "toUserId");
        Intrinsics.checkNotNullParameter(r22, "secToUid");
        Intrinsics.checkNotNullParameter(r23, "reqSrc");
        int r0 = 0;
        long r1 = 0;
        w31.c r3 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r3 == null) goto L6;
        r0 = r3.a();
    L6:
        if (r0 <= 0) goto L12;
        LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r2 == null) goto L10;
        long r4 = r2.f();
    L11:
        r1 = r4;
        String r5 = r19;
    L13:
        HashMap r6 = new HashMap();
        r6.put("pk_description", "routine");
        r6.put("pk_activity_type", "");
        r6.put("match_type", "single");
        if (com.bytedance.android.live.revlink.impl.global.b.M() == null) goto L18;
        com.bytedance.android.live.revlink.impl.pk.service.a r7 = com.bytedance.android.live.revlink.impl.global.b.M();
        Intrinsics.checkNotNull(r7);
        if (r7.d() == null) goto L18;
        com.bytedance.android.live.revlink.impl.pk.service.a r8 = com.bytedance.android.live.revlink.impl.global.b.M();
        Intrinsics.checkNotNull(r8);
        h0 r9 = r8.d();
        Intrinsics.checkNotNull(r9);
        r9.a(r6);
    L18:
        mz0.n r10 = new mz0.n();
        Map<String, String> r12 = r10.a;
        Intrinsics.checkNotNullParameter(r12, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r12.putAll(r6);
        mz0.m r13 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r14 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r14, "linkInfoLog");
        r14.f(r5);
        r14.c(r1);
        ((ArrayList) r13.a).add(r14.a);
        LinkCrossRoomDataHolder.a r16 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r13);
        r13.b(LogCommon.ROOM);
        ((ArrayList) r10.b).addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r24 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r24);
        ((mz0.i) ((f80.a) r24)).w3("match_cancel_click", r10.a, r10.b);
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L29;
        com.bytedance.android.live.revlink.impl.pk.service.b r25 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r25 == null) goto L23;
        com.bytedance.android.live.revenuelink.connect.n r26 = r25.getLinkOutManagerFn();
    L24:
        if (r26 == null) goto L30;
        com.bytedance.android.live.revlink.impl.pk.service.b r27 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r27);
        com.bytedance.android.live.revenuelink.connect.n r28 = r27.getLinkOutManagerFn();
        if (r28 == null) goto L31;
        r28.e(new d11.c(1, r15, r20, r19, r22, 0, r23, ""), null);
        return;
    L31:
        return;
    L30:
        return;
    L23:
        r26 = null;
        goto L24
    L29:
        return;
    L10:
        r4 = 0;
        goto L11
    L12:
        r5 = null;
        goto L13
    }
}
