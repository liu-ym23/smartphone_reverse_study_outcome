package x02;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.d0;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.NetworkUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends d0 {
    public j() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.model.d0, com.bytedance.android.livesdk.gift.platform.core.model.s
    public final y b(com.bytedance.android.livesdk.gift.platform.core.model.t r6, List<? extends com.bytedance.android.livesdk.gift.platform.core.model.r> r7, Function1<? super y, Unit> r8) {
        Intrinsics.checkNotNullParameter(r6, "info");
        Intrinsics.checkNotNullParameter(r7, "listener");
        Intrinsics.checkNotNullParameter(r8, "nextPlugin");
        b0 r9 = r6.i();
        IRoom r10 = r6.i().H;
        if (r10 != null) goto L5;
        int r11 = 411;
    L84:
        if (r11 == 0) goto L88;
        return new y.c.a.e(r11, BuildConfig.FLAVOR);
    L88:
        return y.d.c;
    L5:
        boolean r13 = r9.r;
        if (r13 == true) goto L9;
    L11:
        int r1 = 0;
    L12:
        if (r1 == 0) goto L14;
        r11 = r1;
        goto L84
    L14:
        if (r13 == true) goto L80;
        long r2 = r9.b;
        GiftManagerKt.z.getClass();
        if (GiftManagerKt.z(r2) == false) goto L21;
        int r14 = x12.b.a();
        gq2.b r3 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        r3.l();
        boolean r15 = r3.d(r14, 8);
        boolean r4 = true;
        if ((!r15) == true) goto L21;
    L22:
        if (r4 == false) goto L38;
        h2 r16 = jc1.k.n(IGiftService.class).findLiteGiftById(r9.b);
        if (r16 == null) goto L34;
        com.bytedance.android.live.core.resources.e r17 = jc1.k.n(IGiftService.class).getAssets("effects", r16.getPrimaryEffectId());
        if (r17 == null) goto L34;
        com.bytedance.android.live.core.resources.f r18 = r17.castToOrNull(com.bytedance.android.live.core.resources.f.class);
        if (r18 == null) goto L34;
        String r19 = r18.getLokiExtra();
        if (r19 == null) goto L34;
        boolean r20 = Intrinsics.areEqual(g02.a.b(r19).getGiftType(), "sticker");
    L35:
        if (r20 == true) goto L38;
        ToastUtil.a(2131918770, 0);
        r11 = 402;
    L81:
        if (r11 != 0) goto L84;
        r11 = 0;
    L34:
        r20 = false;
    L38:
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == true) goto L41;
        ToastUtil.a(2131916005, 0);
        r11 = 403;
        goto L81
    L41:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene() != 10) goto L43;
        int r21 = ToastUtil.a;
        ToastUtil.b(s1.B(2131911887), 0);
        r11 = 404;
        goto L81
    L43:
        String r5 = null;
        Object r23 = null;
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L54;
        i12.e r24 = i12.o.b();
        if (r24 == null) goto L48;
        r23 = com.bytedance.android.scope.m.e.d(r24, GiftInRoomService.class);
    L48:
        GiftInRoomService r25 = (GiftInRoomService) r23;
        if (r25 == null) goto L51;
        r25.a(1001);
    L52:
        r11 = 405;
        goto L81
    L51:
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.k(1001));
        goto L52
    L54:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).interceptOperation("gift") == false) goto L57;
        r11 = 406;
        goto L81
    L57:
        if (vh6.c.b(wh6.a.class).isNeedProtectUnderage() == false) goto L60;
        ToastUtil.a(2131919796, 0);
        r11 = 407;
        goto L81
    L60:
        if (r10.getRoomAuthStatus() == null) goto L78;
        if (r10.getRoomAuthStatus().getEnableGift() == true) goto L78;
        if (r10.getRoomAuthStatus().getOffReason() == null) goto L75;
        IRoomAuthStatus.IOffReason r26 = r10.getRoomAuthStatus().getOffReason();
        if (r26 == null) goto L68;
        String r27 = r26.getGift();
    L70:
        if (TextUtils.isEmpty(r27) == true) goto L75;
        int r28 = ToastUtil.a;
        IRoomAuthStatus.IOffReason r29 = r10.getRoomAuthStatus().getOffReason();
        if (r29 == null) goto L74;
        r5 = r29.getGift();
    L74:
        ToastUtil.b(r5, 0);
    L76:
        r11 = 408;
        goto L81
    L68:
        r27 = null;
    L75:
        ToastUtil.a(2131916225, 0);
    L78:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.a(r9.g(), r9.w) == false) goto L80;
        ToastUtil.a(2131915261, 0);
        m02.a.a();
        r11 = 410;
    L21:
        r4 = false;
    L80:
        r11 = 0;
        goto L81
    L9:
        if (r9.v == false) goto L11;
        r1 = 401;
        goto L12
    }
}
