package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profit.redpacket.api.LuckyBoxApi;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "resp");
            Object r4 = r3.data;
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r5) {
            ExtraResponse r6 = (ExtraResponse) r5;
            Intrinsics.checkNotNullParameter(r6, "listResp");
            Iterable r7 = (Iterable) r6.data;
            ArrayList r0 = new ArrayList();
            Iterator<T> r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L11;
            T r1 = r8.next();
            boolean r3 = true;
            if (((com.bytedance.android.live.profit.redpacket.model.b) r1).getBoxStatus() != 1) goto L9;
            r3 = false;
        L9:
            if (r3 == false) goto L4;
            r0.add(r1);
            goto L4
        L11:
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator r2 = r0.iterator();
        L13:
            if (r2.hasNext() == false) goto L15;
            r9.add(h.c((com.bytedance.android.live.profit.redpacket.model.b) r2.next()));
            goto L13
        L15:
            return r9;
        }
    }

    static {
    }

    public static Single a(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        int r0 = LuckyBoxApi.a;
        r2.getRoomId();
        return RxUtilKt.h(Observable.just(new com.bytedance.android.live.network.response.d.b(Unit.INSTANCE, new Extra())).map(a.a)).singleOrError();
    }

    public static Single b(long r10) {
        int r0 = LuckyBoxApi.a;
        tz0.b r1 = tz0.b.a;
        uz0.c r2 = new uz0.c();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "$this$beforeConfigureRequest");
        r2.query("room_id", String.valueOf(r10));
        Intrinsics.checkNotNullParameter(r2, "$this$afterConfigureRequest");
        return RxUtilKt.h(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/luckybox/box/list/", TypesJVMKt.getJavaType(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(com.bytedance.android.live.profit.redpacket.model.b.class)))), Extra.class, r2.d, r2.a, r2.b, r2.c)).map(b.a).singleOrError();
    }

    public static n0 c(com.bytedance.android.live.profit.redpacket.model.b r30) {
        Intrinsics.checkNotNullParameter(r30, "$this$toRedPacketInfo");
        com.bytedance.android.live.revenue.common.u0 r0 = x0.d();
        com.bytedance.android.live.revenue.common.u0 r12 = x0.e();
        com.bytedance.android.live.revenue.common.u0 r1 = com.bytedance.android.live.revenue.common.u0.f;
        com.bytedance.android.live.revenue.common.u0 r4 = new com.bytedance.android.live.revenue.common.u0(r30.getSendTime());
        com.bytedance.android.live.revenue.common.u0 r5 = com.bytedance.android.live.revenue.common.u0.a.a(r30.getDelayTime());
        com.bytedance.android.live.revenue.common.u0 r2 = r4.c(r5);
        com.bytedance.android.live.revenue.common.u0 r3 = r2.c(com.bytedance.android.live.revenue.common.u0.a.a(r30.getDisplayDuration()));
        String r6 = r30.getBoxIdStr();
        int r7 = r30.getBoxStatus();
        com.bytedance.android.live.revenue.common.u0 r8 = r0.c(r2.b(r12));
        com.bytedance.android.live.revenue.common.u0 r9 = r0.c(r3.b(r12));
        IBaseUser r10 = r30.getUser();
        if (r10 != null) goto L5;
        r10 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L5:
        IBaseUser r13 = r10;
        r30.getPriority();
        int r14 = r30.getBoxType();
        long r20 = r30.getBusinessType();
        int r15 = (int) r30.getDiamondCount();
        List<com.bytedance.android.live.profit.redpacket.model.c> r16 = r30.getDescriptionList();
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator<T> r18 = r16.iterator();
    L7:
        if (r18.hasNext() == false) goto L9;
        com.bytedance.android.live.profit.redpacket.model.c r19 = (com.bytedance.android.live.profit.redpacket.model.c) r18.next();
        r17.add(new m(r19.getImage(), r19.getText(), r19.getGiftId(), r19.getNumber()));
        goto L7
    L9:
        n0 r22 = new n0(r6, r7, r4, r5, r8, r9, r13, r14, r20, r15, r17, RedPacketDataSource.API, r30.isRiskyOwner(), r30.getActivityId(), r30.getJoinFrozenDuration(), r30.getBizExtra(), r30);
        Map<String, Long> r23 = r22.a;
        r23.put("local_time", Long.valueOf(r0.a));
        r23.put("server_time", Long.valueOf(r12.a));
        r22.b = r22.e;
        return r22;
    }
}
