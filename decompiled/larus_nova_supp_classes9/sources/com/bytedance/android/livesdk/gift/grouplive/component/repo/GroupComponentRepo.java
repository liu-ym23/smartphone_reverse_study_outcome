package com.bytedance.android.livesdk.gift.grouplive.component.repo;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentDataStore;
import com.bytedance.android.livesdk.gift.model.v0;
import com.bytedance.android.livesdk.message.model.t5;
import com.bytedance.android.livesdk.message.model.t7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.n;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import iy0.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;
import yz0.h;
import yz0.k;
import yz0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GroupComponentRepo implements o {
    public final CompositeDisposable a;
    public long b;
    public boolean c;
    public final k d;
    public final GroupComponentDataStore e;
    public final com.bytedance.android.livesdk.revenue.room.a f;
    public final l g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ GroupComponentRepo a;

        public a(GroupComponentRepo r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            t7 r8 = (t7) r7;
            m0 r0 = r8.getCommonData();
            if (r0 == null) goto L5;
            long r1 = r0.getCreateTime();
        L6:
            GroupComponentRepo r2 = this.a;
            if (r2.b >= r1) goto L10;
            r2.b = r1;
            List r9 = r8.getGroupContainerList();
            List<ty1.b> r10 = GroupComponentRepo.a(this.a, r9, r1);
            this.a.e.S(r10);
            return;
        L10:
            return;
        L5:
            r1 = 0;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ GroupComponentRepo a;

        public b(GroupComponentRepo r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            t7 r8 = (t7) r7;
            m0 r0 = r8.getCommonData();
            if (r0 == null) goto L5;
            long r1 = r0.getCreateTime();
        L6:
            GroupComponentRepo r2 = this.a;
            if (r2.b >= r1) goto L10;
            r2.b = r1;
            List r9 = r8.getGroupContainerList();
            List<ty1.b> r10 = GroupComponentRepo.a(this.a, r9, r1);
            this.a.e.S(r10);
            return;
        L10:
            return;
        L5:
            r1 = 0;
            goto L6
        }
    }

    public static final class c implements vlc.l {
        public final /* synthetic */ GroupComponentRepo a;

        public c(GroupComponentRepo r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r7) {
            jy0.b.c("GroupLiveRts Old", "get rtc meesage " + r7.getMessageId(), null, 4);
            if ((r7 instanceof t5) == false) goto L12;
            t5 r8 = (t5) r7;
            m0 r0 = r8.getCommonData();
            if (r0 == null) goto L7;
            long r1 = r0.getCreateTime();
        L8:
            GroupComponentRepo r2 = this.a;
            if (r2.b >= r1) goto L13;
            r2.b = r1;
            this.a.e.S(GroupComponentRepo.a(this.a, r8.getGroupContainerList(), r1));
            return;
        L13:
            return;
        L7:
            r1 = 0;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ GroupComponentRepo a;

        public d(GroupComponentRepo r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            sh6.b r2 = (sh6.b) r1;
            this.a.c();
        }
    }

    public final void c() {
        if (((Boolean) qy1.a.b.getValue(null, qy1.a.a[0])).booleanValue() == false) goto L6;
        d(true);
        return;
    L6:
        if (e.b(this.d.getRoom()) == false) goto L15;
        tz0.b r0 = tz0.b.a;
        uz0.c r1 = new uz0.c();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "$this$beforeConfigureRequest");
        Map r2 = ((uz0.a) r1).b;
        Intrinsics.checkNotNullParameter(r2, "queriesMap");
        String r3 = Long.valueOf(this.d.getRoom().getId()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r3 == null) goto L10;
        r2.put("room_id", r3);
    L10:
        String r4 = this.d.getRoom().getAnchorId();
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");
        if (r4 == null) goto L13;
        r2.put("anchor_id", r4);
    L13:
        Intrinsics.checkNotNullParameter(r1, "$this$afterConfigureRequest");
        Disposable r5 = f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/anchor/group_live/get_container/", TypesJVMKt.getJavaType(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(v0.class)))), Extra.class, ((uz0.a) r1).d, ((uz0.a) r1).a, ((uz0.a) r1).b, ((uz0.a) r1).c).subscribeOn(Schedulers.io()).map(new com.bytedance.android.livesdk.gift.grouplive.component.repo.a(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.grouplive.component.repo.b(this), com.bytedance.android.livesdk.gift.grouplive.component.repo.c.a);
        this.a.add(r5);
        d(false);
        return;
    L15:
        if (e.b(this.d.getRoom()) == true) goto L20;
        d(true);
        return;
    }

    public final void onStart() {
        n r0 = this.f.getInteractionDataPrepared();
        if (((IRoom) r0.getValue()) == null) goto L5;
        c();
        return;
    L5:
        Disposable r1 = r0.a().subscribe(new d(this));
        if (r1 == null) goto L10;
        RxUtilKt.c(r1, this.a);
        return;
    }

    public final void onStop() {
        this.a.clear();
    }

    public final void d(boolean r6) {
        jy0.b.c("GroupLiveRts Old", "handleMessage isGroupLive: " + e.b(this.d.getRoom()) + " GROUP_LIVE_CONTAINER_RTS: " + qy1.a.a(), null, 4);
        if (e.b(this.d.getRoom()) == false) goto L7;
        if (qy1.a.a() == false) goto L7;
        return;
    L7:
        if (((Boolean) qy1.a.h.getValue(null, qy1.a.a[6])).booleanValue() == true) goto L9;
    L11:
        l r0 = this.g;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(h.a.a(r0, com.bytedance.android.live.revenue.common.message.b.P, r6, 4).subscribe(new b(this)), this.a);
    L13:
        if (((Boolean) this.f.isAnchor().getValue()).booleanValue() == false) goto L17;
        final c r7 = new c(this);
        this.f.getRtcRoomInfo().a(new GroupComponentRepo$handleMessage$3(this, r7));
        return;
    L17:
        return;
    L9:
        if (((Boolean) this.f.isAnchor().getValue()).booleanValue() == true) goto L11;
        l r1 = this.g;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        RxUtilKt.c(r1.Dm(com.bytedance.android.live.revenue.common.message.b.P, r6).subscribe(new a(this)), this.a);
        goto L13
    }

    public static final List a(GroupComponentRepo r16, List r17, long r18) {
        r16.getClass();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r17.iterator();
    L4:
        if (r2.hasNext() == false) goto L24;
        v0 r3 = (v0) r2.next();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        ty1.a r4 = (ty1.a) GsonHelper.get().fromJson(r3.getPositionJson(), ty1.a.class);     // Catch: Throwable -> L18
        if (r4 == null) goto L15;
        ty1.c r5 = r4.a();     // Catch: Throwable -> L18
        if (r5 == null) goto L16;
        float r6 = r4.c() / r4.d();     // Catch: Throwable -> L18
        ty1.c r7 = r4.a();     // Catch: Throwable -> L18
        if (r7 == null) goto L13;
        float r8 = r7.a;     // Catch: Throwable -> L18
    L14:
        r5.a = r6 * r8;     // Catch: Throwable -> L18
        goto L16
    L13:
        r8 = 1.0f;
    L16:
        Object r9 = Result.constructor-impl(r4);     // Catch: Throwable -> L18
    L20:
        ty1.a r10 = new ty1.a();
        if (Result.isFailure-impl(r9) == false) goto L23;
        r9 = r10;
    L23:
        r1.add(new ty1.b(r3.getType(), r3.getPriority(), r3.getContainerPayload(), (ty1.a) r9, r3.getUrl(), r3.getFoldUrl(), r3.getHorizontalUrl(), r3.getCanAdjustPosition(), r18));
        goto L4
    L15:
        r4 = new ty1.a();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L24:
        return r1;
    }

    public GroupComponentRepo(k r2, GroupComponentDataStore r3, com.bytedance.android.livesdk.revenue.room.a r4, l r5) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "dataStore");
        Intrinsics.checkNotNullParameter(r4, "roomContext");
        Intrinsics.checkNotNullParameter(r5, "roomMessageService");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.a = new CompositeDisposable();
        this.b = -1;
    }
}
