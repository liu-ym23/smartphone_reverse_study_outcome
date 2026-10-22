package com.bytedance.android.livesdk.gift.platform.business.dialog.v2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelTraceService;
import com.bytedance.android.livesdk.gift.platform.core.utils.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import i12.e;
import i12.m;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import py.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public static final String a(IBaseUser r8) {
        Intrinsics.checkNotNullParameter(r8, "$this$getRoomId");
        IRoom r0 = x.a();
        o r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getIdStr();
    L6:
        Intrinsics.checkNotNullParameter(r8, "$this$liveRoomIdStrExt");
        Intrinsics.checkNotNullParameter(r8, "$this$ownRoomExt");
        p r3 = r8.getOwnRoom();
        if (r3 == null) goto L9;
        List r4 = r3.getRoomIdStrList();
    L10:
        boolean r5 = true;
        if (r4 != null) goto L13;
    L15:
        String r6 = null;
    L16:
        if (r6 != null) goto L22;
        Intrinsics.checkNotNullParameter(r8, "$this$ownRoomExt");
        p r7 = r8.getOwnRoom();
        if (r7 == null) goto L21;
        r6 = String.valueOf(r7.getId());
        if (r6 != null) goto L22;
    L21:
        r6 = BuildConfig.FLAVOR;
    L22:
        jy0.b.d("KmpLiveInternalHelper", "IBaseUser.getRoomId currentRoomId= " + r2 + ", userRoomId=" + r6);
        if (b(r8) == false) goto L35;
        i12.d r9 = m.e2.a();
        if (r9 == null) goto L27;
        com.bytedance.android.scope.m.e.getClass();
        r1 = (o) com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(GiftPanelTraceService.class));
    L27:
        GiftPanelTraceService r10 = (GiftPanelTraceService) r1;
        if (r10 == null) goto L30;
        r10.d("getRoomId: from anchor");
    L30:
        jy0.b.d("KmpLiveInternalHelper", "IBaseUser.getRoomId from anchor");
        if (r2 == null) goto L33;
        return r2;
    L33:
        return r6;
    L35:
        if (r6.length() <= 0) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == false) goto L47;
        i12.d r13 = m.e2.a();
        if (r13 == null) goto L42;
        com.bytedance.android.scope.m.e.getClass();
        r1 = (o) com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(GiftPanelTraceService.class));
    L42:
        GiftPanelTraceService r14 = (GiftPanelTraceService) r1;
        if (r14 == null) goto L45;
        r14.d("getRoomId: from user roomId");
    L45:
        jy0.b.d("KmpLiveInternalHelper", "IBaseUser.getRoomId from user roomId");
        return r6;
    L47:
        Intrinsics.checkNotNullParameter(r8, "receiver");
        e r15 = i12.o.b();
        if (r15 == null) goto L50;
        com.bytedance.android.scope.m.e.getClass();
        o r16 = (o) com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(GiftReceiverRepoService.class));
    L51:
        GiftReceiverRepoService r17 = (GiftReceiverRepoService) r16;
        if (r17 == null) goto L54;
        boolean r18 = r17.K(r8, 4);
    L55:
        if (r18 == true) goto L57;
    L59:
        r5 = false;
    L60:
        if (r5 == true) goto L71;
        i12.d r19 = m.e2.a();
        if (r19 == null) goto L64;
        com.bytedance.android.scope.m.e.getClass();
        r1 = (o) com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(GiftPanelTraceService.class));
    L64:
        GiftPanelTraceService r20 = (GiftPanelTraceService) r1;
        if (r20 == null) goto L67;
        r20.d("getRoomId: not pk anchor, currentRoomId");
    L67:
        jy0.b.d("KmpLiveInternalHelper", "IBaseUser.getRoomId not pk anchor, currentRoomId");
        if (r2 == null) goto L70;
        return r2;
    L70:
        return r6;
    L71:
        return r6;
    L57:
        if (b(r8) == true) goto L59;
    L54:
        r18 = false;
        goto L55
    L50:
        r16 = null;
        goto L51
    L37:
        r11 = false;
        goto L38
    L13:
        if ((!r4.isEmpty()) != true) goto L15;
        r6 = (String) ListProtector.get(r4, 0);
        goto L16
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static final boolean b(IBaseUser r4) {
        IRoom r0 = x.a();
        if (r4 == null) goto L5;
        String r5 = r4.getIdString();
    L6:
        if (r0 == null) goto L8;
        String r1 = IRoomKt_androidKt.getAnchorId(r0);
    L10:
        return StringsKt.equals$default(r5, r1, false, 2, null);
    L8:
        r1 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
