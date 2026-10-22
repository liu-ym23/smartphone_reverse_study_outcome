package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.platform.business.ai.GiftAsyncSortManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.util.GiftImageLoader;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftInRoomService implements ca0.g {
    public final CompositeDisposable a;
    public Pair<GiftContext, ? extends Disposable> b;
    public final OpenDialogService c;
    public final GiftReceiverRepoService d;
    public final a1 e;

    public static final class a<T> implements Consumer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void accept(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            jc1.k.n(IRechargeService.class).rechargeCenter().sync(com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL);
            GiftListRepo.g(3);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            if (r11 == null) goto L8;
            StackTraceElement[] r0 = r11.getStackTrace();
            if (r0 == null) goto L8;
            String r13 = ArraysKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null);
            if (r13 == null) goto L8;
        L9:
            jy0.b.a("login log", r13);
            return;
        L8:
            r13 = BuildConfig.FLAVOR;
            goto L9
        }
    }

    public final void j8() {
        this.d.E();
        a1 r0 = this.e;
        r0.b = r0.a().intValue();
        z0 r1 = new z0(r0);
        r0.c.observe("data_link_state", r1, true);
        r0.a.add(new y0(r0, r1));
    }

    public final void onStart() {
        IGiftService r0 = jc1.k.f(IGiftService.class);
        if (r0 == null) goto L5;
        r0.registerInRoomService(this);
    L5:
        GiftImageLoader.k.getClass();
        GiftImageLoader.j = ((Number) com.bytedance.android.livesdk.gift.platform.core.h.U.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[45])).intValue();
        GiftAsyncSortManager r1 = (GiftAsyncSortManager) GiftAsyncSortManager.e.getValue();
        r1.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L8;
    L10:
        this.b = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        boolean r2 = com.bytedance.android.livesdk.gift.platform.core.utils.f0.a;
        com.bytedance.android.livesdk.gift.platform.core.utils.f0.a = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.b.s.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[17])).booleanValue();
        return;
    L8:
        if (r1.c.a() == false) goto L10;
        r1.b = true;
        com.bytedance.android.live.core.utils.i0.c().postDelayed(r1.d, r1.c.c());
        vh6.c.b(rq2.a.class).tc(new com.bytedance.android.livesdk.gift.platform.business.ai.a());
        goto L10
    }

    public final void onStop() {
        IGiftService r0 = jc1.k.f(IGiftService.class);
        if (r0 == null) goto L5;
        r0.unRegisterInRoomService();
    L5:
        GiftAsyncSortManager r1 = (GiftAsyncSortManager) GiftAsyncSortManager.e.getValue();
        r1.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h() == false) goto L8;
    L10:
        this.a.dispose();
        Pair<GiftContext, ? extends Disposable> r2 = this.b;
        if (r2 == null) goto L16;
        Disposable r3 = (Disposable) r2.getSecond();
        if (r3 == null) goto L17;
        r3.dispose();
        return;
    L17:
        return;
    L16:
        return;
    L8:
        if (r1.c.a() == false) goto L10;
        r1.b = false;
        com.bytedance.android.live.core.utils.i0.c().removeCallbacks(r1.d);
        vh6.c.b(rq2.a.class).removeGiftAsyncSortCallback();
        r1.a.clear();
        goto L10
    }

    public final void syncMultiAnchorList() {
        GiftReceiverRepoService r0 = this.d;
        r0.Y(r0.c(r0.p.getMultiAnchorService().j()), 3);
        r0.I();
    }

    public final void a(final int r7) {
        final Bundle r0 = new Bundle();
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = "live_detail";
        com.bytedance.android.livesdk.gift.platform.business.g r2 = com.bytedance.android.livesdk.gift.util.b.c(false);
        if (r2 == null) goto L8;
        Context r3 = r2.getContext();
        if (r3 == null) goto L9;
        this.a.add(com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).z4(r3, new GiftInRoomService$login$$inlined$let$lambda$1(this, r1, r7, r0)).subscribe(a.a, b.a));
        return;
    L9:
        return;
    }

    public final void openGroupLiveDialog(String r13) {
        Intrinsics.checkNotNullParameter(r13, "source");
        OpenDialogService r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r13, "source");
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.k() == true) goto L5;
        ToastUtil.a(2131917203, 0);
        return;
    L5:
        GiftReceiverRepoService r14 = r1.k;
        IRoomBase r2 = r14.k.getRoom();
        if (IRoomKt_androidKt.getRoomAuthStatusIsEnableGift(r2) == true) goto L8;
        return;
    L8:
        if (IRoomKt_androidKt.isMediaRoom(r2) == true) goto L20;
        tz0.b r3 = tz0.b.a;
        uz0.c r4 = new uz0.c();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "$this$beforeConfigureRequest");
        Map r5 = ((uz0.a) r4).b;
        Intrinsics.checkNotNullParameter(r5, "queriesMap");
        String r6 = r2.getIdStr();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r6 == null) goto L13;
        r5.put("room_id", r6);
    L13:
        Integer r7 = 4;
        String r8 = r7.toString();
        Intrinsics.checkNotNullParameter("source", "$this$setTo");
        if (r8 == null) goto L16;
        r5.put("source", r8);
    L16:
        Intrinsics.checkNotNullParameter(r4, "$this$afterConfigureRequest");
        Observable r0 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/group_show_users/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.gift.model.z0.class)), Extra.class, ((uz0.a) r4).d, ((uz0.a) r4).a, ((uz0.a) r4).b, ((uz0.a) r4).c);
        int r9 = com.bytedance.revenue.platform.api.core.rx.p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r0.observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.r(r14), com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.s.a), r14.a);
        return;
    }

    public GiftInRoomService(OpenDialogService r2, GiftReceiverRepoService r3, a1 r4) {
        Intrinsics.checkNotNullParameter(r2, "dialogService");
        Intrinsics.checkNotNullParameter(r3, "receiverRepoService");
        Intrinsics.checkNotNullParameter(r4, "giftlinkModeBroadcastService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new CompositeDisposable();
    }
}
