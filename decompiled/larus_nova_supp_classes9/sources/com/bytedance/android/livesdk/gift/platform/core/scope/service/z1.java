package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftListRepo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(int r28, IRoom r29, boolean r30, int r31, long r33, IBaseUser r34, String r35) {
        Intrinsics.checkNotNullParameter(r29, "room");
        Intrinsics.checkNotNullParameter(r34, "toUser");
        if (r28 == 17) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r5 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.m(r34);
        String r8 = BuildConfig.FLAVOR;
        if (r5 == false) goto L22;
        if (r1 == true) goto L12;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0.c(r29.getId(), r34.getIdString(), 4, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r34));
    L12:
        long r3 = r29.getId();
        long r9 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r34);
        if (r29.getOwner() == null) goto L15;
        IBaseUser r2 = r29.getOwner();
        Intrinsics.checkNotNull(r2);
        String r13 = com.bytedance.android.live.base.model.user.o.a(r2);
    L16:
        Intrinsics.checkNotNullParameter(r34, "$this$secUidExt");
        String r14 = r34.getCastSecUid();
        n01.a r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r4 == null) goto L19;
        IEpisode r15 = r4.jf();
    L20:
        GiftListRepo.k(null, r3, r9, r31, r28, r30, r13, r14, r15, 0, (int) r29.getRoomLayout(), null, Long.valueOf(r33), null, 0, r35, null, false, 223232);
    L41:
        r34.getIdString();
        return;
    L19:
        r15 = null;
        goto L20
    L15:
        r13 = BuildConfig.FLAVOR;
        goto L16
    L22:
        if (r29.getOwner() == null) goto L24;
        IBaseUser r6 = r29.getOwner();
        Intrinsics.checkNotNull(r6);
        String r16 = com.bytedance.android.live.base.model.user.o.a(r6);
    L26:
        if (CollectionsKt.listOf(new Integer[]{512, 1024}).contains(Integer.valueOf(r31)) == true) goto L36;
        if (r1 == true) goto L36;
        long r17 = r29.getId();
        if (com.bytedance.android.livesdk.gift.platform.business.i.g() == false) goto L31;
        r8 = String.valueOf(r34.getUserId());
    L33:
        String r18 = r8;
    L35:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.w0.c(r17, r18, r31, r29.getId());
        goto L36
    L31:
        String r7 = r29.getAnchorId();
        if (r7 == null) goto L33;
        r18 = r7;
    L36:
        long r10 = r29.getId();
        long r11 = r29.getId();
        Intrinsics.checkNotNullParameter(r34, "$this$secUidExt");
        String r19 = r34.getCastSecUid();
        n01.a r20 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        if (r20 == null) goto L39;
        IEpisode r110 = r20.jf();
    L40:
        GiftListRepo.k(null, r10, r11, r31, r28, r30, r16, r19, r110, 0, (int) r29.getRoomLayout(), null, Long.valueOf(r33), null, 0, r35, null, false, 223232);
        goto L41
    L39:
        r110 = null;
        goto L40
    L24:
        r16 = BuildConfig.FLAVOR;
        goto L26
    L5:
        if (TextUtils.isEmpty(r35) == true) goto L7;
        r1 = true;
        goto L8
    }
}
