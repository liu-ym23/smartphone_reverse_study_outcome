package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseMVIDataStore<a> implements com.bytedance.android.scope.o {
    public final com.bytedance.android.live.profit.fansclub.o e;
    public final CompositeDisposable f;
    public final com.bytedance.android.livesdk.gift.configmodel.r g;
    public final u1 h;
    public final OpenDialogService i;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f j;
    public final yz0.k k;

    public final void onStart() {
    }

    public final JsonObject k() {
        LinkedHashMap r0 = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L55
        IRoom r2 = this.k.getRoom();     // Catch: Throwable -> L55
        com.bytedance.android.live.profit.fansclub.o r3 = this.e;     // Catch: Throwable -> L55
        if (r3 == null) goto L7;
        r0.put("fans_club_status", Integer.valueOf(r3.R2()));     // Catch: Throwable -> L55
    L7:
        com.bytedance.android.live.profit.fansclub.o r4 = this.e;     // Catch: Throwable -> L55
        if (r4 == null) goto L18;
        com.bytedance.live.datacontext.m r5 = r4.getProfile();     // Catch: Throwable -> L55
        if (r5 == null) goto L18;
        com.bytedance.android.live.profit.fansclub.g r6 = (com.bytedance.android.live.profit.fansclub.g) r5.getValue();     // Catch: Throwable -> L55
        if (r6 == null) goto L18;
        com.bytedance.android.live.profit.fansclub.b r7 = r6.a;     // Catch: Throwable -> L55
        if (r7 == null) goto L16;
        int r8 = r7.b;     // Catch: Throwable -> L55
    L17:
        r0.put("fans_club_status", Integer.valueOf(r8));     // Catch: Throwable -> L55
        goto L18
    L16:
        r8 = 0;
    L18:
        com.bytedance.android.live.profit.fansclub.o r9 = this.e;     // Catch: Throwable -> L55
        if (r9 == null) goto L29;
        com.bytedance.live.datacontext.m r10 = r9.getProfile();     // Catch: Throwable -> L55
        if (r10 == null) goto L29;
        com.bytedance.android.live.profit.fansclub.g r11 = (com.bytedance.android.live.profit.fansclub.g) r10.getValue();     // Catch: Throwable -> L55
        if (r11 == null) goto L29;
        com.bytedance.android.live.profit.fansclub.b r13 = r11.a;     // Catch: Throwable -> L55
        if (r13 == null) goto L27;
        int r14 = r13.b;     // Catch: Throwable -> L55
    L28:
        r0.put("fans_club_level", Integer.valueOf(r14));     // Catch: Throwable -> L55
        goto L29
    L27:
        r14 = 0;
    L29:
        IBaseUser r15 = r2.getOwner();     // Catch: Throwable -> L55
        if (r15 == null) goto L38;
        py.k r16 = r15.getAvatarThumbKt();     // Catch: Throwable -> L55
        if (r16 == null) goto L38;
        List r17 = r16.getUrls();     // Catch: Throwable -> L55
        if (r17 == null) goto L38;
        String r18 = (String) CollectionsKt.getOrNull(r17, 0);     // Catch: Throwable -> L55
        if (r18 == null) goto L38;
        r0.put("avatar_url", r18);     // Catch: Throwable -> L55
    L38:
        IRoomAuthStatus r19 = r2.getRoomAuthStatus();     // Catch: Throwable -> L55
        String r20 = "1";
        if (r19 != null) goto L42;
    L44:
        Object r21 = "0";
    L45:
        r0.put("is_shop_fans", r21);     // Catch: Throwable -> L55
        GiftContext r23 = com.bytedance.android.livesdk.gift.util.b.b();     // Catch: Throwable -> L55
        if (r23 == null) goto L52;
        com.bytedance.live.datacontext.m<Boolean> r24 = r23.isVS();     // Catch: Throwable -> L55
        if (r24 == null) goto L52;
        if (((Boolean) r24.getValue()).booleanValue() != true) goto L52;
    L53:
        Result.constructor-impl(r0.put("is_vs", r20));     // Catch: Throwable -> L55
    L58:
        return GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r0).getAsJsonObject();
    L52:
        r20 = "0";
        goto L53
    L42:
        if (r19.isShopFansClubMode() != true) goto L44;
        r21 = "1";
    L55:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    }

    public final void onStop() {
        this.f.clear();
    }

    public a(u1 r2, OpenDialogService r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r4, yz0.k r5) {
        Intrinsics.checkNotNullParameter(r2, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r3, "openDialogService");
        Intrinsics.checkNotNullParameter(r4, "giftPanelReceiverService");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.e = yt0.c.c();
        this.f = new CompositeDisposable();
        this.g = (com.bytedance.android.livesdk.gift.configmodel.r) nz1.a.p.getValue(null, nz1.a.a[14]);
    }
}
