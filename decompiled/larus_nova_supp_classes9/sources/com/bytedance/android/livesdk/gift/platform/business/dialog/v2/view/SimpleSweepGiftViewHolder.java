package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.q3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import i12.e;
import i12.o;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import py.k;
import qz1.u;
import qz1.v;
import rz1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/SimpleSweepGiftViewHolder;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/SimpleGiftViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class SimpleSweepGiftViewHolder extends SimpleGiftViewHolder {
    public final CompositeDisposable e;

    public abstract b V3();

    public abstract GiftIconMaskView W3();

    public final boolean Y3() {
        AbsPanel r1 = this.b;
        V3().b();
        this.e.clear();
        if (r1 != null) goto L5;
    L99:
        return false;
    L5:
        if (r1.h() == true) goto L99;
        long r3 = r1.c();
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L24;
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        Intrinsics.checkNotNull(r5);
        if (r5.getLastSendGiftId() == null) goto L24;
        GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
        Intrinsics.checkNotNull(r6);
        if (r6.getLastSendGiftId().getValue() == null) goto L24;
        GiftContext r7 = com.bytedance.android.livesdk.gift.util.b.b();
        Intrinsics.checkNotNull(r7);
        long r9 = ((GiftContext.a) r7.getLastSendGiftId().getValue()).a;
        if (r9 == 0) goto L18;
    L20:
        if (r9 == 0) goto L24;
        if (r9 != r3) goto L24;
    L23:
        boolean r4 = true;
    L25:
        if (r4 == true) goto L99;
        T r8 = r1.h;
        if ((r8 instanceof h1) == true) goto L31;
        return false;
    L31:
        if (r8 == 0) goto L98;
        h1 r10 = (h1) r8;
        if (r10.getSweepLightCount() != 0) goto L35;
    L96:
        return false;
    L35:
        if (r10.isHasSweepLight() == true) goto L96;
        long r11 = r10.getId();
        com.bytedance.tools.kcp.spongepreference.runtime.a r13 = ay1.b.p;
        KProperty[] r14 = ay1.b.a;
        if (((HashSet) r13.getValue(null, r14[18])).contains(String.valueOf(r11)) == false) goto L40;
        return false;
    L40:
        T r15 = this.b.h;
        if ((r15 instanceof h1) == false) goto L71;
        if (r15 == 0) goto L70;
        h1 r16 = (h1) r15;
        e r17 = o.b();
        if (r17 == null) goto L46;
        Object r18 = m.e.d(r17, GiftExtraRepo.class);
    L47:
        GiftExtraRepo r19 = (GiftExtraRepo) r18;
        if (r19 == null) goto L50;
        g0 r20 = r19.q(r16.getId());
    L51:
        if (r20 == null) goto L71;
        k0 r110 = r16.getGiftPreviewInfo();
        if (r110 != null) goto L55;
    L57:
        boolean r111 = false;
    L59:
        if (r20.getSubscribeGiftPackInfo() == null) goto L65;
        q3 r112 = r20.getSubscribeGiftPackInfo();
        Intrinsics.checkNotNull(r112);
        if (r112.getRelatedGiftId() == 0) goto L65;
        if (r111 == false) goto L65;
    L68:
        boolean r21 = true;
    L72:
        if (r21 == false) goto L74;
        return false;
    L74:
        String r23 = ay1.b.l().get(String.valueOf(this.b.c()));
        if (r23 == null) goto L77;
        int r24 = CastIntegerProtector.parseInt(r23);
    L79:
        if (r24 < r10.getSweepLightCount()) goto L81;
        return false;
    L81:
        HashMap<String, String> r2 = ay1.b.l();
        r2.put(String.valueOf(this.b.c()), String.valueOf(r24 + 1));
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        ay1.b.q.setValue(null, r14[19], r2);
        T r25 = r1.h;
        if (r25 == 0) goto L95;
        ((h1) r25).setHasSweepLight(true);
        AbsPanel r26 = this.b;
        T r27 = r26.h;
        if ((r27 instanceof h1) == false) goto L91;
        if (r27 == 0) goto L90;
        h2 r28 = rz1.a.b(Long.valueOf(((h1) r27).getId()));
        if (r28 == null) goto L91;
        k r29 = r28.getImage();
    L92:
        a1.k(r29).compose(RxUtil.rxSchedulerHelper()).subscribe(new u(this), new v(this));
        return true;
    L90:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L91:
        r29 = r26.d();
        goto L92
    L95:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L77:
        r24 = 0;
    L65:
        if (r20.getGiftBuffInfos().isEmpty() == true) goto L71;
        if (ay1.b.j().contains(String.valueOf(r16.getId())) == false) goto L71;
    L55:
        if (r110.getLockStatus() != k0.UNLOCKED) goto L57;
        r111 = true;
        goto L59
    L50:
        r20 = null;
        goto L51
    L46:
        r18 = null;
        goto L47
    L70:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L71:
        r21 = false;
        goto L72
    L98:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L18:
        if (this.a != 0) goto L20;
    L24:
        r4 = false;
        goto L25
    }

    public SimpleSweepGiftViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.e = new CompositeDisposable();
    }

    public static void X3(long r5) {
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = ay1.b.p;
        KProperty[] r1 = ay1.b.a;
        HashSet r3 = (HashSet) r0.getValue(null, r1[18]);
        r3.add(String.valueOf(r5));
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.setValue(null, r1[18], r3);
    }
}
