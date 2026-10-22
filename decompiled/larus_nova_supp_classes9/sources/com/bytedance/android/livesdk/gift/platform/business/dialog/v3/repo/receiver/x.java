package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.IGroupLiveService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements com.bytedance.android.scope.o {
    public String a;
    public final Map<String, String> b;
    public final GiftReceiverRepoService c;
    public final com.bytedance.kmp.livesdk.gift.platform.service.d d;
    public final yz0.g e;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final IBaseUser a() {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r0 = com.bytedance.android.scope.m.b(r1).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r0);
        String r2 = ((com.bytedance.live.kmp.core.c) r0).getCurrentUserId();
        String r3 = this.a;
        if (r3.length() <= 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        if (r3 != null) goto L15;
        IGroupLiveService r5 = (IGroupLiveService) jc1.k.f(IGroupLiveService.class);
        if (r5 == null) goto L14;
        r3 = r5.getAnchorIdBeforeJump();
        goto L15
    L14:
        r3 = null;
    L15:
        if (r3 != null) goto L17;
        r3 = BuildConfig.FLAVOR;
    L17:
        Iterator<T> r6 = this.c.k().a.iterator();
    L19:
        if (r6.hasNext() == false) goto L28;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((IBaseUser) r7).getIdString(), r3) == true) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L19;
    L29:
        IBaseUser r9 = (IBaseUser) r7;
        IGroupLiveService r10 = (IGroupLiveService) jc1.k.f(IGroupLiveService.class);
        if (r10 == null) goto L32;
        String r11 = r10.getAnchorIdBeforeJump();
    L34:
        if (Intrinsics.areEqual(r3, r11) == false) goto L36;
        this.b.put("group_live_to_user_st", "throw");
    L36:
        if (r9 != null) goto L50;
        StringBuilder r13 = new StringBuilder("use default receiver anchor ");
        IBaseUser r14 = this.e.getRoom().getOwnerKt();
        if (r14 != null) goto L40;
        r14 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L40:
        r13.append(r14.getIdString());
        jy0.b.c("GiftRecommendReceiverService", r13.toString(), null, 4);
        this.b.put("to_user_st", "to_anchor");
        IBaseUser r15 = this.e.getRoom().getOwnerKt();
        if (r15 != null) goto L44;
        r15 = (IBaseUser) vh7.f.c(IBaseUser.class);
    L44:
        return r15;
    L50:
        return r9;
    L32:
        r11 = null;
        goto L34
    L23:
        if ((!Intrinsics.areEqual(r3, r2)) == false) goto L25;
        r8 = true;
        goto L26
    L28:
        r7 = null;
        goto L29
    L5:
        r4 = false;
        goto L7
    }

    public final void onStop() {
        this.a = BuildConfig.FLAVOR;
    }

    public x(GiftReceiverRepoService r2, com.bytedance.kmp.livesdk.gift.platform.service.d r3, yz0.g r4) {
        Intrinsics.checkNotNullParameter(r2, "giftReceiverRepoService");
        Intrinsics.checkNotNullParameter(r3, "giftLogService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = BuildConfig.FLAVOR;
        this.b = new LinkedHashMap();
    }

    public final void c(String r4, String r5, Map<String, String> r6, Map<String, String> r7) {
        Intrinsics.checkNotNullParameter(r4, "targetUid");
        Intrinsics.checkNotNullParameter(r5, "reason");
        this.a = r4;
        jy0.b.c("GiftRecommendReceiverService", "receiver add success, newReceiver: " + r4 + ", reason: " + r5, null, 4);
        this.d.getClass();
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        LinkedHashMap r8 = new LinkedHashMap();
        if (r6 == null) goto L5;
        r8.putAll(r6);
    L5:
        r8.put("to_user_id", r4);
        IRoomBase r9 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        String r0 = "anchor";
        if (r9 == null) goto L13;
        String r10 = IRoomKtKt.getAnchorIdStr(r9);
        if (r10 == null) goto L13;
        if (Intrinsics.areEqual(r10, r4) == true) goto L13;
        r0 = "guest";
    L13:
        r8.put("to_user_type", r0);
        mz0.n r11 = new mz0.n();
        Map r13 = r11.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r13.putAll(r8);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.PAGE_SOURCE_LOG);
        r14.b(LogCommon.ROOM);
        ((ArrayList) r11.b).addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((f80.a) r16).w3("livesdk_gift_show_send_recommend", r11.a, r11.b);
        if (r7 == null) goto L17;
        this.b.putAll(r7);
        return;
    }
}
