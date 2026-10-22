package com.bytedance.android.live.profit.vote.ui;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.vote.LiveVoteConfig;
import com.bytedance.android.live.profit.vote.l;
import com.bytedance.android.live.profit.vote.model.VoteConfig;
import com.bytedance.android.live.profit.vote.transfer.VoteMessageClient;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.livesdk.message.model.s7;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class VotePanelHandler implements o {
    public static final /* synthetic */ int f = 0;
    public final com.bytedance.android.live.profit.vote.model.f a;
    public final VoteMessageClient b;
    public final yz0.g c;
    public final er2.a d;
    public final com.bytedance.android.live.profit.vote.f e;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r3) {
            s7 r4 = (s7) r3;
            Intrinsics.checkNotNullParameter(r4, Constants.OperatorKey.MSG);
            return new JSONObject(GsonProtectorUtils.toJson(l97.a.a, r4));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ zy0.d a;

        public c(zy0.d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            JSONObject r4 = (JSONObject) r3;
            xy0.a<?> r0 = this.a.g();
            if (r0 == null) goto L6;
            r0.sendJsEvent("H5_commonMessage", r4);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r4) {
            cy0.e.a.getClass();
            cy0.j r0 = cy0.e.a.a;
            m.e.getClass();
            Object r1 = m.b(r0).a(Reflection.getOrCreateKotlinClass(jy0.a.class));
            Intrinsics.checkNotNull(r1);
            ((jy0.a) ((f80.a) r1)).M3("VotePanelHandler", String.valueOf(((Throwable) r4).getMessage()), null);
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    private final Context getContext() {
        return this.c.getContext();
    }

    public final void a(Long r4) {
        boolean r2 = false;
        if (this.c.isAnchor() == false) goto L16;
        int r0 = VoteConfig.a;
        LiveVoteConfig r1 = l.a();
        if (r1 == null) goto L9;
        Integer r3 = r1.u8();
        if (r3 == null) goto L9;
        int r5 = r3.intValue();
    L10:
        if (r5 < 1) goto L12;
        r2 = true;
    L12:
        if (r2 == false) goto L14;
        String r6 = VoteConfig.b();
    L19:
        c(r6, true, r4);
        return;
    L14:
        r6 = VoteConfig.a();
    L9:
        r5 = 0;
        goto L10
    L16:
        if (VoteConfig.d(false) == false) goto L18;
        r6 = VoteConfig.b();
        goto L19
    L18:
        r6 = VoteConfig.a();
        goto L19
    }

    public final void c(String r8, boolean r9, Long r10) {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r0);
        IBaseUser r2 = ((com.bytedance.live.kmp.core.c) r0).b();
        x0 r3 = new x0(r8);
        x0 r12 = r3.d("url");
        r12.b("room_id", this.c.mo444getRoom().getIdStr());
        IBaseUser r4 = this.c.mo444getRoom().getOwnerKt();
        String r5 = "";
        if (r4 == null) goto L6;
        String r6 = r4.getIdString();
        if (r6 == null) goto L6;
    L7:
        r12.b("anchor_id", r6);
        if (r2 == null) goto L13;
        String r7 = r2.getIdString();
        if (r7 == null) goto L13;
        r5 = r7;
    L13:
        r12.b("user_id", r5);
        com.bytedance.android.live.profit.vote.model.c r13 = (com.bytedance.android.live.profit.vote.model.c) PropertyOwnersKt.a(this.a.a);
        if (r13 == null) goto L16;
        r12.b("vote_id", String.valueOf(r13.d));
        r12.b("vote_type", String.valueOf(r13.e));
    L16:
        if (r10 == null) goto L18;
        r12.b("vote_type", String.valueOf(r10.longValue()));
    L18:
        Object r14 = m.b(r1).b(er2.b.class);
        Intrinsics.checkNotNull(r14);
        iq2.h r15 = ((com.bytedance.live.kmp.core.c) r14).getKtvRoomInfo();
        if (r15 == null) goto L25;
        iq2.f r16 = r15.c();
        if (r16 == null) goto L25;
        Intrinsics.checkNotNullParameter(r16, "$this$singer");
        iq2.g r17 = r16.b();
        if (r17 == null) goto L25;
        iq2.c r18 = r17.a();
    L26:
        if (r18 == null) goto L28;
        boolean r19 = true;
    L29:
        String r20 = DataType.TRUE;
        String r22 = DataType.FALSE;
        if (r19 == false) goto L32;
        String r110 = DataType.TRUE;
    L33:
        r12.b("has_singer", r110);
        if (this.d.q() == false) goto L36;
        String r111 = DataType.TRUE;
    L37:
        r12.b("is_ktv_room", r111);
        if (r2 != null) goto L40;
    L44:
        r12.b("is_admin", r22);
        ILiveMode r112 = IRoomKt_androidKt.getStreamType(this.c.mo444getRoom());
        int r23 = h1.a;
        r12.b("live_type", i1.a(r112));
        Uri r24 = r3.c();
        Object r113 = m.b(r1).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r113);
        HybridDialogImpl r114 = ((vy0.b) ((f80.a) r113)).U0(getContext(), r24, null);
        if (r114 != null) goto L48;
        int r25 = v.a;
        v.b("VotePanelHandler", "failed to create dialog for uri " + r24, null);
        return;
    L48:
        xy0.a<?> r26 = r114.g();
        if (r26 == null) goto L51;
        r26.registerMethod("getKTVCurrentSong", new com.bytedance.android.live.profit.vote.transfer.g());
    L51:
        if (r9 == false) goto L54;
        int r27 = com.bytedance.revenue.platform.api.core.rx.o.a;
        final PublishSubject r28 = PublishSubject.create();
        Observable r29 = this.b.c.takeUntil(r28);
        int r30 = p.a;
        r29.subscribeOn(Schedulers.computation()).map(b.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r114), d.a);
        r114.j0(new VotePanelHandler$openPanel$5(r28));
        return;
    L54:
        return;
    L40:
        if (com.bytedance.android.live.base.model.user.o.b(r2) == true) goto L43;
        r20 = DataType.FALSE;
    L43:
        r22 = r20;
        goto L44
    L36:
        r111 = DataType.FALSE;
        goto L37
    L32:
        r110 = DataType.FALSE;
        goto L33
    L28:
        r19 = false;
    L25:
        r18 = null;
    L6:
        r6 = "";
        goto L7
    }

    public VotePanelHandler(com.bytedance.android.live.profit.vote.model.f r2, VoteMessageClient r3, yz0.g r4, er2.a r5, com.bytedance.android.live.profit.vote.f r6) {
        Intrinsics.checkNotNullParameter(r2, "voteRepository");
        Intrinsics.checkNotNullParameter(r3, "voteMessageClient");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        Intrinsics.checkNotNullParameter(r5, "ktvRoomService");
        Intrinsics.checkNotNullParameter(r6, "etHelper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
