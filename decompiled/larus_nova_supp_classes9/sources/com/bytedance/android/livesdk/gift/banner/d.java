package com.bytedance.android.livesdk.gift.banner;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import cy0.e;
import cy0.j;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import mz0.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends l {
    public boolean e;

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, n r7, k r8, k r9, l1 r10, com.bytedance.android.livesdk.gift.model.n r11, String r13, int r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r7, "showInfo");
        return false;
    }

    public d(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }

    public static final void I(d r8, AbsPanel r9, l2 r10, String r11, boolean r13) {
        IRoom r0 = (IRoom) r8.b.get("data_room", null);
        HashMap r1 = new HashMap();
        if (r10.getCount() > 0) goto L7;
        r1.put("has_popularity_card", Boolean.FALSE);
        b1 r2 = r10.getBanner();
        if (r2 == null) goto L13;
        r2.setHeight(306);
    L13:
        b1 r3 = r10.getBanner();
        if (r3 == null) goto L16;
        r3.setWidth(280);
    L16:
        b1 r4 = r10.getBanner();
        if (r4 == null) goto L19;
        r4.setActionType(2);
    L19:
        r1.put("count", 1);
        if (r0 == null) goto L22;
        long r5 = r0.getId();
    L23:
        r1.put("room_id", Long.valueOf(r5));
        r1.put("prop_def_id", Long.valueOf(r9.c()));
        if (r0 == null) goto L27;
        Object r6 = r0.getAnchorId();
        if (r6 == null) goto L27;
    L28:
        r1.put("to_uid", r6);
        r1.put("is_aweme_free_gift", 0);
        String r14 = r9.a();
        String r7 = BuildConfig.FLAVOR;
        if (r14 != null) goto L31;
        r14 = BuildConfig.FLAVOR;
    L31:
        r1.put("describe", r14);
        r1.put("next_expire", Long.valueOf(r10.getNextExpire()));
        if (r11 != null) goto L34;
        r11 = BuildConfig.FLAVOR;
    L34:
        r1.put("city_code", r11);
        r1.put("has_options", Boolean.valueOf(r13));
        if (r8.getContext() == null) goto L39;
        b1 r15 = r10.getBanner();
        if (r15 == null) goto L39;
        int r16 = BannerGiftHelperKt.a;
        BannerGiftHelperKt.a(r8.getContext(), r15, r1);
    L39:
        int r17 = r10.getCount();
        String r18 = r10.getDescription();
        if (r0 == null) goto L42;
        long r19 = r0.getId();
    L43:
        HashMap r110 = new HashMap();
        r110.put("cards_left", String.valueOf(r17));
        if (r18 == null) goto L47;
        r7 = r18;
    L47:
        r110.put("cards_time", r7);
        r110.put("room_id", String.valueOf(r19));
        mz0.n r20 = new mz0.n();
        Map r21 = r20.a;
        Intrinsics.checkNotNullParameter(r21, "map");
        Intrinsics.checkNotNullParameter(r110, "map");
        r21.putAll(r110);
        e.a.getClass();
        j r23 = e.a.a;
        m.e.getClass();
        Object r24 = m.b(r23).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r24);
        ((f80.a) r24).w3("popular_card_click", r20.a, r20.b);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        return;
    L42:
        r19 = 0;
    L27:
        r6 = 0;
        goto L28
    L22:
        r5 = 0;
        goto L23
    L7:
        r1.put("has_popularity_card", Boolean.TRUE);
        b1 r25 = r10.getBanner();
        if (r25 == null) goto L13;
        if (r13 == false) goto L11;
        int r26 = 444;
    L12:
        r25.setHeight(r26);
        goto L13
    L11:
        r26 = 373;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, boolean r7, n r8, k r9, k r10, l1 r11, com.bytedance.android.livesdk.gift.model.n r13, String r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r8, "showInfo");
        if ((r1 instanceof pz1.e) == false) goto L27;
        T r17 = ((pz1.e) r1).h;
        if ((r17 instanceof l2) == false) goto L27;
        l2 r18 = (l2) r17;
        if (r18 == null) goto L30;
        if (r18.getPropType() != 4) goto L27;
        if (r18.getBanner() == null) goto L27;
        wh6.b r19 = vh6.c.b(wh6.a.class).getCurrentLocation();
        if (r19 == null) goto L18;
        String r20 = r19.a;
    L19:
        TextUtils.isEmpty(r20);
        if (this.e == true) goto L32;
        this.e = true;
        tz0.b r21 = tz0.b.a;
        uz0.c r23 = new uz0.c();
        r21.getClass();
        Intrinsics.checkNotNullParameter(r23, "$this$beforeConfigureRequest");
        if (r20 != null) goto L25;
        String r24 = BuildConfig.FLAVOR;
    L26:
        r23.query("city_code", r24);
        r23.a(qx0.a.a);
        Intrinsics.checkNotNullParameter(r23, "$this$afterConfigureRequest");
        f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/anchor/popular/status/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.livesdk.rank.model.e.class)), Extra.class, ((uz0.a) r23).d, ((uz0.a) r23).a, ((uz0.a) r23).b, ((uz0.a) r23).c).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new b(this, r1, r18, r20), new c(this, r1, r18, r20));
        return true;
    L25:
        r24 = r20;
        goto L26
    L32:
        return true;
    L18:
        r20 = null;
        goto L19
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L27:
        return false;
    }
}
