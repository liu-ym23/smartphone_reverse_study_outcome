package com.bytedance.android.livesdk.gift.platform.business.dialog.v2;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.common.d0;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.gift.configmodel.j1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.i0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelTraceService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.p1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.r3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u3;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import i12.e;
import i12.o;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public static final j1 a = null;
    public static boolean b;

    public static final boolean h() {
        k r0 = f.d(j.C0.a(), k.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAnchor();
    }

    public static final boolean k() {
        k r0 = f.d(j.C0.a(), k.class);
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.isPortraitInteraction();
    }

    static {
        a = a0.e();
        b = ((Boolean) nz1.a.m.getValue(null, nz1.a.a[11])).booleanValue();
    }

    public static final ReceiverType d() {
        e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, i0.class);
    L6:
        i0 r2 = (i0) r1;
        if (r2 == null) goto L11;
        ReceiverType r3 = r2.a();
        if (r3 == null) goto L11;
        return r3;
    L11:
        return ReceiverType.Anchor;
    L5:
        r1 = null;
        goto L6
    }

    public static final Map<String, t> f() {
        e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, r3.class);
    L6:
        r3 r2 = (r3) r1;
        if (r2 == null) goto L11;
        Map<String, t> r3 = r2.a;
        if (r3 == null) goto L11;
        return r3;
    L11:
        return new HashMap();
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean g() {
        e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, r3.class);
    L6:
        r3 r2 = (r3) r1;
        if (r2 == null) goto L14;
        List<t> r3 = r2.b;
        if (r3 != null) goto L11;
        return false;
    L11:
        if (r3.isEmpty() == true) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ boolean b(String r1) {
        return a(r1, null);
    }

    public static final long e(IBaseUser r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$getRoomId");
        k r0 = f.d(j.C0.a(), k.class);
        Object r1 = null;
        if (r0 == null) goto L5;
        IRoom r2 = r0.getRoom();
    L6:
        if (r2 == null) goto L8;
        Long r3 = Long.valueOf(r2.getRoomId());
    L9:
        long r4 = r8.getLiveRoomId();
        jy0.b.d("LiveInternalHelper", "IBaseUser.getRoomId currentRoomId= " + r3 + ", userRoomId=" + r4);
        if (l(r8) == false) goto L22;
        i12.d r9 = i12.m.e2.a();
        if (r9 == null) goto L14;
        r1 = m.e.d(r9, GiftPanelTraceService.class);
    L14:
        GiftPanelTraceService r5 = (GiftPanelTraceService) r1;
        if (r5 == null) goto L17;
        r5.d("getRoomId: from anchor");
    L17:
        jy0.b.d("LiveInternalHelper", "IBaseUser.getRoomId from anchor");
        if (r3 != null) goto L20;
        return r4;
    L20:
        return r3.longValue();
    L22:
        if (r4 <= 0) goto L32;
        i12.d r10 = i12.m.e2.a();
        if (r10 == null) goto L26;
        r1 = m.e.d(r10, GiftPanelTraceService.class);
    L26:
        GiftPanelTraceService r6 = (GiftPanelTraceService) r1;
        if (r6 == null) goto L29;
        r6.d("getRoomId: from user roomId");
    L29:
        jy0.b.d("LiveInternalHelper", "IBaseUser.getRoomId from user roomId");
        return r4;
    L32:
        if (m(r8) == true) goto L43;
        i12.d r11 = i12.m.e2.a();
        if (r11 == null) goto L36;
        r1 = m.e.d(r11, GiftPanelTraceService.class);
    L36:
        GiftPanelTraceService r7 = (GiftPanelTraceService) r1;
        if (r7 == null) goto L39;
        r7.d("getRoomId: not pk anchor, currentRoomId");
    L39:
        jy0.b.d("LiveInternalHelper", "IBaseUser.getRoomId not pk anchor, currentRoomId");
        if (r3 != null) goto L42;
        return r4;
    L42:
        return r3.longValue();
    L43:
        jy0.b.d("LiveInternalHelper", "IBaseUser.getRoomId fallback logic");
        return r4;
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public static final boolean i(long r3) {
        AssetsService r0 = (AssetsService) f.a(AssetsService.class);
        com.bytedance.android.live.core.resources.e r4 = r0.G1(r3);
        if (r4 != null) goto L6;
        return true;
    L6:
        if (r4.getResourceType() != 5) goto L9;
        return true;
    L9:
        return r0.f0(r4);
    }

    public static final boolean j(DataCenter r5) {
        IRoom r0 = x.a();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r5 == null) goto L12;
        Boolean r6 = (Boolean) r5.get("data_is_portrait", Boolean.FALSE);
        if (r6 == null) goto L12;
        boolean r7 = r6.booleanValue();
    L13:
        if (r7 == false) goto L15;
    L17:
        return false;
    L15:
        if (d0.a(h(), r1) == false) goto L17;
        return true;
    L12:
        r7 = false;
        goto L13
    L5:
        if (r0.isMediaRoom() == false) goto L7;
        r1 = true;
        goto L8
    }

    public static final boolean l(IBaseUser r2) {
        IRoom r0 = x.a();
        String r1 = null;
        if (r2 == null) goto L5;
        String r3 = r2.getIdString();
    L6:
        if (r0 == null) goto L9;
        r1 = r0.getAnchorId();
    L9:
        return TextUtils.equals(r3, r1);
    L5:
        r3 = null;
        goto L6
    }

    public static final boolean m(IBaseUser r3) {
        Intrinsics.checkNotNullParameter(r3, "receiver");
        e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, GiftReceiverRepoService.class);
    L6:
        GiftReceiverRepoService r2 = (GiftReceiverRepoService) r1;
        if (r2 == null) goto L9;
        boolean r4 = r2.K(r3, 4);
    L10:
        if (r4 == true) goto L12;
        return false;
    L12:
        if (l(r3) == true) goto L16;
        return true;
    L16:
        return false;
    L9:
        r4 = false;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static final void n(p1 r4) {
        e r0 = o.b();
        if (r0 == null) goto L5;
        Object r1 = m.e.d(r0, r3.class);
    L6:
        r3 r2 = (r3) r1;
        if (r2 == null) goto L10;
        r2.d = null;
        r2.e = r4;
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final GiftTransaction p(b0 r5) {
        Intrinsics.checkNotNullParameter(r5, "giftParams");
        e r1 = o.b();
        if (r1 == null) goto L5;
        Object r2 = m.e.d(r1, r3.class);
    L6:
        r3 r3 = (r3) r2;
        if (r3 == null) goto L10;
        Intrinsics.checkNotNullParameter(r5, "giftParams");
        return r3.d(r5);
    L10:
        return null;
    L5:
        r2 = null;
        goto L6
    }

    public static final boolean a(String r6, List<? extends IBaseUser> r7) {
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        String r2 = null;
        if (a.W8() == true) goto L5;
        b = ((Boolean) nz1.a.m.getValue(null, nz1.a.a[11])).booleanValue();
    L5:
        boolean r3 = false;
        if (b == false) goto L31;
        e r1 = o.b();
        if (r1 == null) goto L10;
        Object r4 = m.e.d(r1, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a.class);
    L11:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r5 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a) r4;
        if (r5 != null) goto L14;
    L15:
        if (r7 != null) goto L17;
    L19:
        Intrinsics.checkNotNullParameter(r6, "toUserId");
        String r8 = f.a(l01.d.class).b().getIdString();
        k r0 = f.d(j.C0.a(), k.class);
        if (r6.length() <= 0) goto L22;
        r3 = true;
    L22:
        if (r3 == true) goto L32;
        if (r0 == null) goto L26;
        IRoom r9 = r0.getRoom();
    L27:
        if (r9 == null) goto L30;
        r2 = r9.getAnchorId();
    L30:
        return TextUtils.equals(r8, r2);
    L26:
        r9 = null;
        goto L27
    L32:
        return TextUtils.equals(r8, r6);
    L17:
        if ((!r7.isEmpty()) != true) goto L19;
    L14:
        if (r5.j() == true) goto L31;
    L10:
        r4 = null;
    L31:
        return false;
    }

    public static final Observable<ExtraResponse<p2, ? extends Extra>> o(b0 r19, int r20) {
        Intrinsics.checkNotNullParameter(r19, "giftParams");
        e r2 = o.b();
        if (r2 == null) goto L5;
        Object r3 = m.e.d(r2, r3.class);
    L6:
        r3 r15 = (r3) r3;
        if (r15 == null) goto L11;
        Intrinsics.checkNotNullParameter(r19, "giftParams");
        GiftTransaction r0 = r15.d(b0.b(r19, 0, null, 0, null, SendGiftStrategy.ONLY_SEND_ONCE, null, null, null, null, 0, 0, null, null, -16385, 8388607));
        r0.d(r20);
        Observable<ExtraResponse<p2, ? extends Extra>> r1 = r0.getObservable().doOnSubscribe(new u3(r0));
        if (r1 == null) goto L11;
        return r1;
    L11:
        return Observable.error(new IllegalStateException("giftContext is null"));
    L5:
        r3 = null;
        goto L6
    }

    public static boolean c(String r2, boolean r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        Intrinsics.checkNotNullParameter(r4, "currentUserId");
        boolean r1 = false;
        if (b == false) goto L13;
        if (r3 == false) goto L6;
        return false;
    L6:
        if (r2.length() <= 0) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        boolean r6 = TextUtils.equals(r4, r2);
    L12:
        return r6;
    L10:
        r6 = TextUtils.equals(r4, r5);
        goto L12
    L13:
        return false;
    }
}
