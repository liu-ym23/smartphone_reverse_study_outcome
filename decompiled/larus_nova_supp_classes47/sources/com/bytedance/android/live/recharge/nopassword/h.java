package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.model.NoPasswordFansConfigType;
import com.bytedance.android.live.recharge.panel.RechargeBizScene;
import com.bytedance.android.live.recharge.utils.ChargeScene;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.gift.platform.core.model.v;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.RandomKt;
import kotlin.ranges.LongRange;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements b, o {
    public final CompositeDisposable a;
    public final e b;
    public final f c;
    public final m d;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r6) {
            ExtraResponse r7 = (ExtraResponse) r6;
            Intrinsics.checkNotNullParameter(r7, "it");
            com.bytedance.android.live.recharge.platform.model.c r8 = (com.bytedance.android.live.recharge.platform.model.c) r7.data;
            Intrinsics.checkNotNullParameter(r8, "$this$toLocalData");
            List<com.bytedance.android.live.recharge.platform.model.h> r1 = r8.getSignInfos();
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L7;
            com.bytedance.android.live.recharge.platform.model.h r4 = (com.bytedance.android.live.recharge.platform.model.h) r3.next();
            Intrinsics.checkNotNullParameter(r4, "$this$toLocalData");
            r2.add(new com.bytedance.android.live.recharge.platform.model.e(r4.getPayShowChannel()));
            goto L4
        L7:
            return new com.bytedance.android.live.recharge.platform.model.f(r2, r8.getRenderDataInfo(), r8.getType());
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.a.clear();
    }

    @Override // com.bytedance.android.live.recharge.nopassword.b
    public final void p0() {
        this.d.getClass();
        c r0 = d.a;
        boolean r4 = false;
        if (r0.d == false) goto L13;
        long r5 = ((Number) com.bytedance.android.live.recharge.utils.i.b.getValue(null, com.bytedance.android.live.recharge.utils.i.a[0])).longValue();
        com.bytedance.live.kmp.util.c r1 = com.bytedance.live.kmp.util.c.a;
        if ((System.currentTimeMillis() - r5) <= 86400000) goto L8;
        boolean r7 = true;
    L10:
        if (r5 == 0) goto L12;
        if (r7 == false) goto L13;
    L12:
        r4 = true;
        goto L13
    L8:
        r7 = false;
    L13:
        if (r4 == true) goto L15;
        return;
    L15:
        com.bytedance.revenue.platform.api.core.rx.l r2 = com.bytedance.revenue.platform.api.core.rx.l.a;
        this.d.getClass();
        com.bytedance.live.kmp.util.c r3 = com.bytedance.live.kmp.util.c.a;
        long r6 = RandomKt.nextLong(RandomKt.Random(System.currentTimeMillis()), new LongRange(0, r0.e)) * ((long) WebcastRedirectException.UNKNOWN);
        int r8 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(r6, TimeUnit.MILLISECONDS, Schedulers.computation()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this)), this.a);
    }

    public h() {
        this.a = new CompositeDisposable();
        this.b = new e();
        this.c = new f(new l());
        this.d = new m();
    }

    @Override // com.bytedance.android.live.recharge.nopassword.b
    public final NoPasswordScene B1(com.bytedance.android.live.recharge.model.d r9) {
        Intrinsics.checkNotNullParameter(r9, "params");
        f r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "params");
        boolean r2 = true;
        if (g.b() == false) goto L20;
        if (Intrinsics.areEqual(ChargeScene.GIFT_NO_BALANCE.getValue(), r9.h) == false) goto L16;
        com.bytedance.android.live.recharge.model.b r0 = r9.j;
        if (r0 == null) goto L9;
        int r4 = r0.f;
    L10:
        if (r4 <= 0) goto L16;
        if (r0 == null) goto L13;
        v r3 = r0.h;
    L14:
        if (r3 == null) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L20;
        return NoPasswordScene.SCENE_PK;
    L13:
        r3 = null;
        goto L14
    L9:
        r4 = 0;
    L16:
        r5 = false;
    L20:
        if (g.c(r9) == false) goto L31;
        r1.a.getClass();
        c r6 = d.a;
        if (r6.f.getType() != NoPasswordFansConfigType.TYPE_PAY_AND_JOIN.getValue()) goto L24;
    L27:
        boolean r7 = true;
    L28:
        if (r7 == false) goto L31;
        return NoPasswordScene.SCENE_FANS_CLUB_JOIN;
    L24:
        if (r6.f.getType() == NoPasswordFansConfigType.TYPE_AUTO_SEND_PANEL_LIGHT_BOARD.getValue()) goto L27;
        r7 = false;
    L31:
        if (g.a(r9) == false) goto L47;
        com.bytedance.android.live.recharge.model.b r10 = r9.j;
        if (r10 == null) goto L35;
        long r8 = r10.e;
    L36:
        r1.a.getClass();
        c r12 = d.a;
        if (r12.f.getType() == NoPasswordFansConfigType.TYPE_AUTO_SEND_PANEL_LIGHT_BOARD.getValue()) goto L39;
    L43:
        r2 = false;
    L44:
        if (r2 == false) goto L47;
        return NoPasswordScene.SCENE_FANS_CLUB_SEND_GIFT;
    L39:
        if (r8 <= 0) goto L43;
        if (r12.f.getGiftIds().contains(Long.valueOf(r8)) == false) goto L43;
    L35:
        r8 = 0;
    L47:
        return NoPasswordScene.SCENE_UNKNOWN;
    }

    @Override // com.bytedance.android.live.recharge.nopassword.b
    public final void T0(com.bytedance.android.live.recharge.model.d r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(r3, "params");
    }

    @Override // com.bytedance.android.live.recharge.nopassword.b
    public final Single<com.bytedance.android.live.recharge.platform.model.f> b0(long r12, RechargeBizScene r14) {
        Intrinsics.checkNotNullParameter(r14, "bizScene");
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.live.revenue.core.util.j.a r1 = com.bytedance.android.live.revenue.core.util.j.C0;
        com.bytedance.android.livesdk.revenue.service.room.c r2 = com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        String r3 = "";
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.revenue.room.a r4 = r2.getRoomContext();
        if (r4 == null) goto L12;
        IRoomBase r5 = r4.getCommonRoom();
        if (r5 == null) goto L12;
        IBaseUser r6 = r5.getOwnerKt();
        if (r6 == null) goto L12;
        String r7 = r6.getIdString();
        if (r7 == null) goto L12;
    L13:
        r0.put("anchor_id", r7);
        com.bytedance.android.livesdk.revenue.service.room.c r8 = com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r8 == null) goto L23;
        com.bytedance.android.livesdk.revenue.room.a r9 = r8.getRoomContext();
        if (r9 == null) goto L23;
        IRoomBase r10 = r9.getCommonRoom();
        if (r10 == null) goto L23;
        String r13 = r10.getIdStr();
        if (r13 == null) goto L23;
        r3 = r13;
    L23:
        r0.put("room_id", r3);
        tz0.b r15 = tz0.b.a;
        uz0.c r16 = new uz0.c();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "$this$beforeConfigureRequest");
        Map<String, String> r17 = r16.b;
        Intrinsics.checkNotNullParameter(r17, "queriesMap");
        String r18 = Integer.valueOf(r14.getScene()).toString();
        Intrinsics.checkNotNullParameter("scene", "$this$setTo");
        if (r18 == null) goto L26;
        r17.put("scene", r18);
    L26:
        String r19 = Long.valueOf(r12).toString();
        Intrinsics.checkNotNullParameter("amount", "$this$setTo");
        if (r19 == null) goto L29;
        r17.put("amount", r19);
    L29:
        String r110 = GsonProtectorUtils.toJson(l97.a.a, r0);
        Intrinsics.checkNotNullParameter("extra", "$this$setTo");
        if (r110 == null) goto L32;
        r17.put("extra", r110);
    L32:
        x.a(r16, false);
        Intrinsics.checkNotNullParameter(r16, "$this$afterConfigureRequest");
        return ((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/wallet_diamond_api/diamond_buy_panel_sign_info/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.platform.model.c.class)), Extra.class, r16.d, r16.a, r16.b, r16.c).map(a.a).singleOrError();
    L12:
        r7 = "";
        goto L13
    }
}
