package com.bytedance.android.live.revlink.impl.multianchor.connect;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.service.RingDrawable;
import com.bytedance.android.live.revlink.impl.pk.service.ToolBarPic;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.g1;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.f6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.n6;
import com.bytedance.android.livesdk.link.model.n9;
import com.bytedance.android.livesdk.link.model.o6;
import com.bytedance.android.livesdk.link.model.o9;
import com.bytedance.android.livesdk.link.model.p6;
import com.bytedance.android.livesdk.link.model.x5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiAnchorRelinkService implements com.bytedance.android.scope.o, RelinkBackendService.b {
    public static final String k = null;
    public p a;
    public RelinkDataContext b;
    public RelinkBackendService c;
    public List<String> d;
    public final CompositeDisposable e;
    public Disposable f;
    public Disposable g;
    public zy0.d h;
    public final i11.b i;
    public final com.bytedance.android.live.revlink.impl.multianchor.scope.c j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MultiAnchorRelinkService a;

        public b(MultiAnchorRelinkService r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            final MultiAnchorRelinkService r0 = this.a;
            r0.getClass();
            i6 r12 = ((i6) r10).castTo(i6.class);
            if (y.c() == true) goto L5;
            jy0.b.c("ttlive_anchor_link_relink", "receive relink invite but not multi anchor", null, 4);
            return;
        L5:
            String r5 = "";
            if ((r0.k() instanceof n.c) == true) goto L23;
            jy0.b.c("ttlive_anchor_link_relink", "auto reject relink invite when " + r0.k(), null, 4);
            IBattleLinkerInviteMessageExtra r1 = j6.a(r12);
            if (r1 == null) goto L10;
            int r7 = (int) r1.getMatchType();
        L11:
            IBattleLinkerInviteMessageExtra r2 = j6.a(r12);
            if (r2 == null) goto L14;
            int r8 = (int) r2.getInviteType();
        L15:
            o6 r13 = r12.getSwitchChannelInviteContent();
            if (r13 == null) goto L62;
            g1 r14 = r13.getInviteContent();
            if (r14 == null) goto L63;
            g1 r3 = r14;
            Intrinsics.checkNotNullParameter(r3, "$this$fromUid");
            String r4 = r3.get_fromUid();
            if (r4 != null) goto L22;
            r4 = "";
        L22:
            r0.s(4, r4, r14.getFromRoomId(), r14.getToJoinChannelId(), r7, r8);
            return;
        L63:
            return;
        L62:
            return;
        L14:
            r8 = 21;
            goto L15
        L10:
            r7 = 21;
            goto L11
        L23:
            r0.w(new n.a(r12));
            b51.b r6 = b51.b.c0;
            r6.getClass();
            ReadOnlyProperty r9 = b51.b.M;
            KProperty[] r15 = b51.b.a;
            if (((Boolean) r9.getValue(r6, r15[37])).booleanValue() == false) goto L59;
            o6 r16 = r12.getSwitchChannelInviteContent();
            if (r16 == null) goto L65;
            e6 r17 = r16.getInviteContent();
            if (r17 == null) goto L66;
            com.bytedance.android.livesdk.link.model.p r18 = r17.getInviteUser();
            List r19 = f6.a(r17);
            String r20 = (String) b51.b.N.getValue(r6, r15[38]);
            if (TextUtils.isEmpty(r20) == true) goto L67;
            final x0 r22 = new x0(r20);
            x0 r23 = r22.d("url");
            IRoom r24 = r0.getRoom();
            if (r24 == null) goto L34;
            Long r25 = Long.valueOf(r24.getRoomId());
        L35:
            r23.b("room_id", String.valueOf(r25));
            r23.b("business_type", r41.b.a());
            r23.b("group", r41.b.a());
            r23.b("panel_type", "invited");
            if (r18 == null) goto L41;
            IBaseUser r26 = r18.getUser();
            if (r26 == null) goto L41;
            String r27 = r26.getIdString();
            if (r27 == null) goto L41;
        L42:
            r23.b("inviter_id", r27);
            if (r19 == null) goto L52;
            com.bytedance.android.livesdk.link.model.p r110 = (com.bytedance.android.livesdk.link.model.p) CollectionsKt.firstOrNull(r19);
            if (r110 == null) goto L52;
            IBaseUser r111 = r110.getUser();
            if (r111 == null) goto L52;
            String r112 = r111.getIdString();
            if (r112 == null) goto L52;
            r5 = r112;
        L52:
            r23.b("other_invitee_id", r5);
            yz0.g r113 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
            if (r113 == null) goto L68;
            Context r114 = r113.getContext();
            if (r114 == null) goto L69;
            cy0.e.a.getClass();
            cy0.j r28 = cy0.e.a.a;
            com.bytedance.android.scope.m.e.getClass();
            Object r29 = com.bytedance.android.scope.m.b(r28).a(Reflection.getOrCreateKotlinClass(vy0.c.class));
            Intrinsics.checkNotNull(r29);
            HybridDialogImpl r115 = ((vy0.b) ((f80.a) r29)).U0(r114, r22.c(), null);
            r0.h = r115;
            if (r115 == null) goto L70;
            r115.j0(new MultiAnchorRelinkService$onReceiveSwitchChannelInvite$$inlined$let$lambda$1(r22, r0));
            return;
        L70:
            return;
        L69:
            return;
        L68:
            return;
        L41:
            r27 = "";
            goto L42
        L34:
            r25 = null;
            goto L35
        L67:
            return;
        L66:
            return;
        L65:
            return;
        L59:
            r0.j.d(r12);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MultiAnchorRelinkService a;

        public c(MultiAnchorRelinkService r1) {
            this.a = r1;
        }

        public final void accept(Object r14) {
            MultiAnchorRelinkService r0 = this.a;
            r0.getClass();
            i6 r15 = ((i6) r14).castTo(i6.class);
            p6 r1 = r15.getSwitchChannelReplyContent();
            if (r1 == null) goto L30;
            k6 r2 = r1.getReplyContent();
            if (r2 != null) goto L8;
            return;
        L8:
            if (y.c() == true) goto L10;
            jy0.b.c("ttlive_anchor_link_relink", "receive relink reply but not multi anchor", null, 4);
            return;
        L10:
            boolean r6 = false;
            f2.c(r2.getToast(), 0);
            List<String> r3 = r0.d;
            String r7 = r2.getFromUid();
            if (r3 == null) goto L29;
            TypeIntrinsics.asMutableCollection(r3).remove(r7);
            if (r0.d.isEmpty() == false) goto L15;
            r0.j("receiveReply", true);
        L17:
            if (((int) r2.getReplyStatus()) != 1) goto L32;
            b7 r4 = r2.getMultiChannelInfo();
            if (r4 != null) goto L21;
            return;
        L21:
            if (r2.getVersion() >= r0.a.a) goto L23;
            r6 = true;
        L23:
            if (r6 == false) goto L25;
            jy0.b.c("ttlive_anchor_link_relink", "relink reply version " + r2.getVersion() + " lower than current " + r0.a, null, 4);
            return;
        L25:
            r0.a = new p(r2.getVersion(), Long.valueOf(r15.getMessageId3()));
            com.bytedance.android.live.revlink.impl.multianchor.service.b r16 = com.bytedance.android.live.revlink.impl.global.b.w();
            if (r16 == null) goto L35;
            r16.onReceiveSwitchChannelReply(r4);
            return;
        L35:
            return;
        L32:
            return;
        L15:
            jy0.b.d("ttlive_anchor_link_relink", r2.getFromUid() + " replied, inviteeList=" + r0.d);
            goto L17
        L29:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiAnchorRelinkService a;

        public d(MultiAnchorRelinkService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            MultiAnchorRelinkService r0 = this.a;
            r0.getClass();
            n6 r4 = ((i6) r3).castTo(i6.class).getSwitchChannelCancelContent();
            if (r4 == null) goto L7;
            x5 r5 = r4.getCancelContent();
            if (r5 == null) goto L7;
            f2.c(r5.getToast(), 0);
        L7:
            r0.j.c();
            r0.w(n.c.a);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MultiAnchorRelinkService a;

        public e(MultiAnchorRelinkService r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            o9 r6 = (o9) r5;
            MultiAnchorRelinkService r0 = this.a;
            r0.j("relinkSuccess", false);
            RelinkDataContext r1 = r0.b;
            if (r1 == null) goto L5;
            r1.setRelinkSuccessTimestamp(SystemClock.uptimeMillis());
        L5:
            r0.a = new p(r6.getVersion(), null);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MultiAnchorRelinkService a;

        public f(MultiAnchorRelinkService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            zg1.d r4 = (zg1.d) sh6.c.b((sh6.b) r3);
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.a != 7) goto L7;
            boolean r5 = true;
        L8:
            if (r5 != true) goto L17;
            this.a.j("linkFinish", true);
            RelinkDataContext r6 = this.a.b;
            if (r6 == null) goto L12;
            r6.setRelinkSuccessTimestamp(0);
        L12:
            RelinkDataContext r7 = this.a.b;
            if (r7 == null) goto L18;
            r7.clearEventParams();
            return;
        L18:
            return;
        L17:
            return;
        L7:
            r5 = false;
            goto L8
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ Ref.LongRef a;

        public g(Ref.LongRef r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Long r6 = (Long) r5;
            long r0 = this.a.element - 1;
            if (r0 >= 0) goto L11;
            com.bytedance.android.live.revlink.impl.pk.service.i r7 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r7 == null) goto L7;
            r7.setText("");
        L7:
            com.bytedance.android.live.revlink.impl.pk.service.i r8 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r8 == null) goto L10;
            r8.Z2(MultiAnchorRelinkService.k);
        L10:
            r0 = 0;
        L17:
            this.a.element = r0;
            return;
        L11:
            com.bytedance.android.live.revlink.impl.pk.service.i r9 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r9 == null) goto L14;
            r9.setText(String.valueOf(r0));
        L14:
            com.bytedance.android.live.revlink.impl.pk.service.i r10 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r10 == null) goto L17;
            r10.i3();
            goto L17
        }
    }

    static {
        k = "https://" + k0.a + "/obj/live-android/ttlive_anim_pk_random_point.webp";
    }

    public final IRoom getRoom() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.revenue.room.a r1 = r0.getRoomContext();
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        return (IRoom) r2.getValue();
    L9:
        return null;
    }

    public final n k() {
        RelinkDataContext r0 = this.b;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<n> r1 = r0.getRelinkState();
        if (r1 == null) goto L9;
        n r2 = (n) r1.getValue();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return n.c.a;
    }

    public final void onStart() {
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiAnchorRelinkService$onStart$pair$1.INSTANCE);
        RelinkDataContext r1 = (RelinkDataContext) r0.getFirst();
        this.b = r1;
        if (r1 == null) goto L5;
        com.bytedance.live.datacontext.b.a(r1, Reflection.getOrCreateKotlinClass(RelinkDataContext.class));
    L5:
        this.e.add((Disposable) r0.getSecond());
        this.c = new RelinkBackendService(this, (RelinkDataContext) r0.getFirst());
        RelinkDataContext r2 = this.b;
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.k<i6> r3 = r2.getReceiveSwitchChannelInvite();
        if (r3 == null) goto L14;
        PublishSubject r4 = r3.onEvent();
        if (r4 == null) goto L14;
        Disposable r5 = r4.subscribe(new b(this));
        if (r5 == null) goto L14;
        RxUtilKt.c(r5, this.e);
    L14:
        RelinkDataContext r6 = this.b;
        if (r6 == null) goto L23;
        com.bytedance.live.datacontext.k<i6> r7 = r6.getReceiveSwitchChannelReply();
        if (r7 == null) goto L23;
        PublishSubject r8 = r7.onEvent();
        if (r8 == null) goto L23;
        Disposable r9 = r8.subscribe(new c(this));
        if (r9 == null) goto L23;
        RxUtilKt.c(r9, this.e);
    L23:
        RelinkDataContext r10 = this.b;
        if (r10 == null) goto L32;
        com.bytedance.live.datacontext.k<i6> r12 = r10.getReceiveSwitchChannelCancel();
        if (r12 == null) goto L32;
        PublishSubject r13 = r12.onEvent();
        if (r13 == null) goto L32;
        Disposable r14 = r13.subscribe(new d(this));
        if (r14 == null) goto L32;
        RxUtilKt.c(r14, this.e);
    L32:
        RelinkDataContext r15 = this.b;
        if (r15 == null) goto L41;
        com.bytedance.live.datacontext.k<o9> r16 = r15.getRelinkSwitchSuccess();
        if (r16 == null) goto L41;
        PublishSubject r17 = r16.onEvent();
        if (r17 == null) goto L41;
        Disposable r18 = r17.subscribe(new e(this));
        if (r18 == null) goto L41;
        RxUtilKt.c(r18, this.e);
    L41:
        ld.a r19 = ld.d.a();
        if (r19 == null) goto L51;
        NextLiveData r20 = r19.so();
        if (r20 == null) goto L52;
        Observable r22 = ld.c.a(r20);
        if (r22 == null) goto L53;
        Disposable r23 = r22.subscribe(new f(this));
        if (r23 == null) goto L54;
        RxUtilKt.c(r23, this.e);
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    }

    public final void onStop() {
        this.e.dispose();
        Disposable r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.g;
        if (r1 == null) goto L9;
        r1.dispose();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkBackendService.b
    public final void a(d11.p r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        int r3 = r2.a;
        if (r3 != 4) goto L6;
        return;
    L6:
        if (r3 == 1) goto L9;
        w(n.c.a);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkBackendService.b
    public final void d(d11.n r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        j("cancelSuccess", true);
    }

    public final void o(boolean r4) {
        RelinkDataContext r0 = this.b;
        String r1 = "";
        if (r0 == null) goto L9;
        d31.d r2 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r2 == null) goto L7;
        String r3 = r2.s();
    L8:
        r0.setRoomStatus(r3);
        goto L9
    L7:
        r3 = "";
    L9:
        RelinkDataContext r5 = this.b;
        if (r5 == null) goto L15;
        d31.d r6 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r6 == null) goto L14;
        r1 = r6.f();
    L14:
        r5.setInviteMode(r1);
    L15:
        RelinkDataContext r7 = this.b;
        if (r7 == null) goto L22;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r8 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r8 == null) goto L20;
        Map<String, String> r9 = r8.getServerEventTrackingInfo();
    L21:
        r7.setPkEventTrackingInfo(r9);
        goto L22
    L20:
        r9 = null;
    L22:
        RelinkDataContext r10 = this.b;
        if (r10 == null) goto L26;
        r10.setRelinkInviter(r4);
        return;
    }

    public final List<String> q(boolean r3) {
        if (r3 == false) goto L12;
        n r4 = k();
        if ((r4 instanceof n.b) == true) goto L6;
        r4 = null;
    L6:
        n.b r5 = (n.b) r4;
        if (r5 == null) goto L13;
        d11.o r6 = r5.a;
        if (r6 != null) goto L15;
        return null;
    L15:
        return r6.a;
    L13:
        return null;
    L12:
        return CollectionsKt.toList(this.d);
    }

    public final void w(n r5) {
        StringBuilder r0 = new StringBuilder("relinkState ");
        RelinkDataContext r1 = this.b;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m<n> r2 = r1.getRelinkState();
        if (r2 == null) goto L7;
        n r3 = (n) r2.getValue();
    L8:
        r0.append(r3);
        r0.append(" -> ");
        r0.append(r5);
        jy0.b.f("ttlive_anchor_link_relink", r0.toString(), null, 4);
        RelinkDataContext r4 = this.b;
        if (r4 == null) goto L14;
        com.bytedance.live.datacontext.m<n> r6 = r4.getRelinkState();
        if (r6 == null) goto L15;
        r6.setValue(r5);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public MultiAnchorRelinkService(i11.b r3, com.bytedance.android.live.revlink.impl.multianchor.scope.c r4) {
        Intrinsics.checkNotNullParameter(r4, "linkDialogService");
        this.i = r3;
        this.j = r4;
        this.a = new p(0, 0L);
        this.d = new ArrayList();
        this.e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkBackendService.b
    public final void c(d11.o r5, n9 r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.isFailure() == false) goto L9;
        f2.c(r6.getToast(), 0);
        return;
    L9:
        w(new n.b(r5));
        this.d = CollectionsKt.toMutableList(r5.a);
        Ref.LongRef r0 = new Ref.LongRef();
        r0.element = r6.getWaitSec();
        Disposable r7 = this.f;
        if (r7 == null) goto L12;
        r7.dispose();
    L12:
        TimeUnit r8 = TimeUnit.SECONDS;
        this.f = du2.a.d(1, r8).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(r0));
        com.bytedance.android.live.revlink.impl.pk.service.i r1 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r1 == null) goto L15;
        r1.P2(RingDrawable.ttlive_ic_pk_random_normal_circle);
    L15:
        List<String> r2 = r5.a;
        IBaseUser r3 = null;
        if ((!r2.isEmpty()) == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L31;
        String r4 = (String) CollectionsKt.first(r2);
        if (r4 == null) goto L31;
        i11.b r9 = this.i;
        if (r9 == null) goto L27;
        com.bytedance.android.livesdk.link.model.p r10 = r9.getGuestInfo(r4, null);
        if (r10 == null) goto L27;
        r3 = r10.getUser();
    L27:
        if (r3 == null) goto L31;
        com.bytedance.android.live.revlink.impl.pk.service.i r12 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r12 == null) goto L31;
        r12.e3(r3.getAvatarThumbKt());
    L31:
        Disposable r13 = this.g;
        if (r13 == null) goto L34;
        r13.dispose();
    L34:
        y41.f r14 = y41.f.N;
        r14.getClass();
        this.g = Observable.timer(((Number) y41.f.C.getValue(r14, y41.f.a[27])).longValue(), r8).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this, r5));
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkBackendService.b
    public final void f(d11.n r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        com.bytedance.android.live.revenue.common.k.e(com.bytedance.live.kmp.util.c.a.getContext(), r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkBackendService.b
    public final void g(d11.o r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        com.bytedance.android.live.revenue.common.k.e(com.bytedance.live.kmp.util.c.a.getContext(), r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.connect.RelinkBackendService.b
    public final void h(d11.p r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        com.bytedance.android.live.revenue.common.k.e(com.bytedance.live.kmp.util.c.a.getContext(), r3);
        if (r2.a == 1) goto L6;
        w(n.c.a);
        return;
    }

    public final void i(Integer r12, Integer r13) {
        RelinkBackendService r0 = this.c;
        if (r0 == null) goto L23;
        List<String> r1 = q(true);
        if (r1 != null) goto L7;
        r1 = CollectionsKt.emptyList();
    L7:
        List<String> r2 = r1;
        IRoom r3 = getRoom();
        long r4 = 0;
        if (r3 == null) goto L10;
        long r5 = r3.getId();
    L11:
        LinkCrossRoomDataHolder r6 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r6 == null) goto L14;
        r4 = r6.c();
    L14:
        long r7 = r4;
        if (r12 == null) goto L17;
        int r14 = r12.intValue();
    L18:
        if (r13 == null) goto L20;
        int r15 = r13.intValue();
    L21:
        r0.switchChannelCancel(new d11.n(r2, r5, r7, r14, r15, ""));
        return;
    L20:
        r15 = 0;
        goto L21
    L17:
        r14 = 0;
        goto L18
    L10:
        r5 = 0;
        goto L11
    }

    public final void j(String r4, boolean r5) {
        jy0.b.f("ttlive_anchor_link_relink", "clearRelinkStatus source=".concat(r4), null, 4);
        Disposable r6 = this.f;
        if (r6 == null) goto L5;
        r6.dispose();
    L5:
        Disposable r7 = this.g;
        if (r7 == null) goto L8;
        r7.dispose();
    L8:
        com.bytedance.android.live.revlink.impl.pk.service.i r8 = com.bytedance.android.live.revlink.impl.global.b.h0();
        boolean r0 = true;
        if (r8 == null) goto L12;
        r8.n3(!y.c());
    L12:
        if (y.c() == false) goto L26;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r9 = com.bytedance.android.live.revlink.impl.global.b.m();
        if (r9 != null) goto L16;
    L18:
        r0 = false;
    L19:
        if (r0 == false) goto L23;
        com.bytedance.android.live.revlink.impl.pk.service.i r10 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r10 == null) goto L26;
        r10.S2(ToolBarPic.PK_CLOSE_BROADCAST);
        goto L26
    L23:
        com.bytedance.android.live.revlink.impl.pk.service.i r12 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r12 == null) goto L26;
        r12.onMultiAnchorStateChange(2);
        goto L26
    L16:
        if (r9.g() != true) goto L18;
    L26:
        if (r5 == false) goto L28;
        this.d.clear();
    L28:
        w(n.c.a);
    }

    public final void n(List<String> r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "inviteAnchorIds");
        RelinkBackendService r0 = this.c;
        if (r0 == null) goto L13;
        LinkCrossRoomDataHolder r1 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r1 == null) goto L7;
        long r5 = r1.c();
    L8:
        IRoom r2 = getRoom();
        if (r2 == null) goto L11;
        long r7 = r2.getId();
    L12:
        r0.switchChannelInvite(new d11.o(r12, r13, r14, r5, r7));
        goto L13
    L11:
        r7 = 0;
        goto L12
    L7:
        r5 = 0;
    L13:
        o(true);
    }

    public final void s(int r17, String r18, long r19, long r22, int r23, int r24) {
        Intrinsics.checkNotNullParameter(r18, "fromAnchorId");
        RelinkBackendService r1 = this.c;
        if (r1 == null) goto L14;
        IRoom r2 = getRoom();
        if (r2 == null) goto L7;
        long r7 = r2.getId();
    L8:
        LinkCrossRoomDataHolder r3 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r3 == null) goto L11;
        long r9 = r3.c();
    L12:
        r1.switchChannelReply(new d11.p(r17, r18, r19, r7, r9, r22, r23, r24));
        goto L14
    L11:
        r9 = 0;
        goto L12
    L7:
        r7 = 0;
    L14:
        if (r17 != 1) goto L17;
        o(false);
        return;
    }
}
