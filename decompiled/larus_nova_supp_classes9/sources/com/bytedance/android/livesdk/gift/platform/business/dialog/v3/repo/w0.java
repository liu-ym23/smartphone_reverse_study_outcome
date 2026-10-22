package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import android.os.SystemClock;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.f3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w0 {
    public static final /* synthetic */ int a = 0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ long c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;

        public a(long r1, Ref.BooleanRef r3, long r4, String r6, int r7, long r8) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }

        public final void accept(Object r13) {
            ExtraResponse r14 = (ExtraResponse) r13;
            List<l2> r0 = ((f3) r14.data).a();
            long r1 = System.currentTimeMillis();
            long r3 = r14.extra.now;
            Iterator<l2> r5 = r0.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            r5.next().setNowTimeDiff((r3 - r1) / 1000);
            goto L4
        L6:
            int r2 = Integer.valueOf(r0.size()).intValue();
            i12.e r4 = i12.o.b();
            if (r4 == null) goto L9;
            Object r6 = com.bytedance.android.scope.m.e.d(r4, PropListService.class);
        L10:
            PropListService r7 = (PropListService) r6;
            if (r7 == null) goto L13;
            r7.i(r0);
        L13:
            com.bytedance.android.livesdk.gift.platform.core.giftlist.i r8 = (com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class);
            ArrayList r9 = new ArrayList();
            Iterator<T> r10 = r0.iterator();
        L15:
            if (r10.hasNext() == false) goto L19;
            h1 r11 = ((l2) r10.next()).getGift();
            if (r11 == null) goto L15;
            r9.add(r11);
            goto L15
        L19:
            ArrayList r15 = new ArrayList();
            Iterator r16 = r9.iterator();
        L21:
            if (r16.hasNext() == false) goto L28;
            Object r17 = r16.next();
            if (((h1) r17).getId() <= 0) goto L25;
            boolean r18 = true;
        L26:
            if (r18 == false) goto L21;
            r15.add(r17);
            goto L21
        L25:
            r18 = false;
            goto L26
        L28:
            r8.F(r15);
            com.bytedance.android.livesdk.gift.platform.core.c0.j(SystemClock.uptimeMillis() - this.a, r2, this.b.element);
            if (this.b.element == false) goto L43;
            int r19 = w0.a;
            w0.a(this.c, this.d, this.e, this.f, (f3) r14.data, null, 32);
            return;
        L43:
            return;
        L9:
            r6 = null;
            goto L10
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;

        public b(Ref.BooleanRef r1, long r2, String r4, int r5, long r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void accept(Object r10) {
            Throwable r7 = (Throwable) r10;
            Intrinsics.checkNotNullParameter(r7, "error");
            if ((r7 instanceof Exception) == false) goto L11;
            i12.e r11 = i12.o.b();
            if (r11 == null) goto L7;
            Object r13 = com.bytedance.android.scope.m.e.d(r11, PropListService.class);
        L8:
            PropListService r14 = (PropListService) r13;
            if (r14 == null) goto L11;
            r14.i(new ArrayList());
            goto L11
        L7:
            r13 = null;
        L11:
            com.bytedance.android.livesdk.gift.platform.core.c0.i(r7.getMessage(), com.bytedance.android.live.revenue.common.r0.a(r7), Boolean.valueOf(this.a.element));
            if (this.a.element == false) goto L15;
            int r15 = w0.a;
            w0.a(this.b, this.c, this.d, this.e, null, r7, 16);
            return;
        }
    }

    public static final class c implements Action {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void run() {
        }
    }

    public w0() {
    }

    static {
    }

    @JvmStatic
    public static final void b(long r7) {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L8;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L8;
        String r2 = r1.getAnchorId();
        if (r2 == null) goto L8;
    L9:
        c(r7, r2, 1, r7);
        return;
    L8:
        r2 = BuildConfig.FLAVOR;
        goto L9
    }

    @JvmStatic
    public static final void c(long r26, String r28, int r29, long r30) {
        Intrinsics.checkNotNullParameter(r28, "toUserId");
        long r1 = SystemClock.uptimeMillis();
        com.bytedance.android.livesdk.revenue.service.message.f r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.message.f.class);
        Object r3 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.revenue.message.m r2 = r0.get();
    L6:
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        boolean r5 = false;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.o0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[65])).booleanValue() == false) goto L10;
        if (r2 == null) goto L10;
        boolean r4 = true;
    L11:
        r11.element = r4;
        if (r4 == false) goto L14;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("room_id", String.valueOf(r26));
        r6.put("prop_scene", String.valueOf(r29));
        r6.put("to_room_id", String.valueOf(r30));
        r6.put("to_openid", r28);
        com.bytedance.android.live.revenue.core.util.f.a(bd6.c.class).s2("/webcast/props/mine/", r6);
        Intrinsics.checkNotNull(r2);
        Observable r7 = r2.syncPropList(r6);
    L61:
        r7.compose(RxUtil.rxSchedulerHelper()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r1, r11, r26, r28, r29, r30), new b(r11, r26, r28, r29, r30), c.a);
        return;
    L14:
        i12.e r8 = i12.o.b();
        if (r8 == null) goto L17;
        Object r9 = com.bytedance.android.scope.m.e.d(r8, GiftReceiverRepoService.class);
    L18:
        GiftReceiverRepoService r10 = (GiftReceiverRepoService) r9;
        if (r10 == null) goto L21;
        IBaseUser r13 = GiftReceiverRepoService.g(r10, null, r28, 1);
    L22:
        if (r13 == null) goto L24;
        boolean r14 = true;
    L25:
        i12.e r15 = i12.o.b();
        if (r15 == null) goto L28;
        r3 = com.bytedance.android.scope.m.e.d(r15, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L28:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r16 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r3;
        if (r16 != null) goto L31;
    L33:
        String r17 = BuildConfig.FLAVOR;
        if (r14 == true) goto L36;
        long r18 = r30;
        long r19 = r26;
    L45:
        tz0.b r20 = tz0.b.a;
        uz0.c r21 = new uz0.c();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r21, "$this$beforeConfigureRequest");
        Map r23 = ((uz0.a) r21).b;
        Intrinsics.checkNotNullParameter(r23, "queriesMap");
        String r24 = Long.valueOf(r19).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r24 == null) goto L48;
        r23.put("room_id", r24);
    L48:
        String r25 = Integer.valueOf(r29).toString();
        Intrinsics.checkNotNullParameter("prop_scene", "$this$setTo");
        if (r25 == null) goto L51;
        r23.put("prop_scene", r25);
    L51:
        String r27 = Long.valueOf(r18).toString();
        Intrinsics.checkNotNullParameter("to_room_id", "$this$setTo");
        if (r27 == null) goto L54;
        r23.put("to_room_id", r27);
    L54:
        Intrinsics.checkNotNullParameter("video_linkmic_room_id", "$this$setTo");
        if (r17 == null) goto L57;
        r23.put("video_linkmic_room_id", r17);
    L57:
        Intrinsics.checkNotNullParameter("to_openid", "$this$setTo");
        if (r28 == null) goto L60;
        r23.put("to_openid", r28);
    L60:
        Intrinsics.checkNotNullParameter(r21, "$this$afterConfigureRequest");
        r7 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/props/mine/", TypesJVMKt.getJavaType(Reflection.typeOf(f3.class)), Extra.class, ((uz0.a) r21).d, ((uz0.a) r21).a, ((uz0.a) r21).b, ((uz0.a) r21).c);
        goto L61
    L36:
        if (r5 == false) goto L38;
        jy0.b.d("NewVideoLinkAnchor", "syncPropList change isAllMicScene=true " + r26 + " ");
        r19 = r26;
    L43:
        r18 = r19;
        goto L45
    L38:
        r17 = String.valueOf(r26);
        if (r13 == null) goto L41;
        r19 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r13);
    L42:
        jy0.b.d("NewVideoLinkAnchor", "syncPropList change isAllMicScene=false " + r19 + ' ' + r17);
        goto L43
    L41:
        r19 = r26;
        goto L42
    L31:
        if (r16.j() != true) goto L33;
        r5 = true;
        goto L33
    L24:
        r14 = false;
        goto L25
    L21:
        r13 = null;
        goto L22
    L17:
        r9 = null;
    L10:
        r4 = false;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static void a(long r4, String r6, int r7, long r8, f3 r10, Throwable r11, int r13) {
        if ((r13 & 16) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 32) == 0) goto L9;
        r11 = null;
    L9:
        if (r11 == null) goto L11;
        jy0.b.a("PropListRepo", "syncPropListFailed, roomId = " + r4 + ", toUserId = " + r6 + ", scene = " + r7 + ", toRoomId = " + r8 + ", throwable.msg = " + com.bytedance.android.live.revenue.common.q0.a(r11) + ", throwable.errorcode = " + com.bytedance.android.live.revenue.common.r0.a(r11));
        return;
    L11:
        if (r10 == null) goto L15;
        jy0.b.a("PropListRepo", "syncPropListSuccess, roomId = " + r4 + ", toUserId = " + r6 + ", scene = " + r7 + ", toRoomId = " + r8 + ", propListResult=" + GsonProtectorUtils.toJson(GsonHelper.get(), r10));
        return;
    }
}
