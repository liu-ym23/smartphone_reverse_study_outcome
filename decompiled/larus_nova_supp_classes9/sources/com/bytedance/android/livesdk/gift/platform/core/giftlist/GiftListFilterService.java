package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.configmodel.v1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.business.effect.delete.ResourceRecordService;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftListFilterService implements dy0.c, com.bytedance.android.scope.o {
    public final yz0.k a;
    public final boolean b;
    public boolean c;
    public final Lazy d;
    public int e;
    public final List<Long> f;
    public final v1 g;
    public IRoom h;
    public final AssetsService i;
    public final ResourceRecordService j;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean a(h1 r10) {
        com.bytedance.android.live.core.resources.e r0 = this.i.G1(r10.getPrimaryEffectId());
        int r4 = 4;
        if (r10.getType() != 4) goto L28;
        if (((Boolean) this.d.getValue()).booleanValue() == false) goto L7;
        boolean r1 = this.c;
    L8:
        if (r1 == false) goto L28;
        if (this.i.g1(r10.getPrimaryEffectId()) == true) goto L28;
        if (r10.getGiftSource() == 1) goto L28;
        int r2 = r10.getType();
        if (r0 == null) goto L16;
        int r3 = r0.getResourceType();
    L18:
        if (h(r2, r3, r10.getId()) == false) goto L20;
    L26:
        return true;
    L20:
        if (this.b == true) goto L26;
        if (((ArrayList) this.f).contains(Long.valueOf(r10.getPrimaryEffectId())) == true) goto L25;
        ((ArrayList) this.f).add(Long.valueOf(r10.getPrimaryEffectId()));
    L25:
        return false;
    L16:
        r3 = 0;
        goto L18
    L7:
        r1 = g02.a.e();
    L28:
        if (this.b == false) goto L32;
        r10.setFreeDisplay(true);
        return true;
    L32:
        if (r10.getType() != 2) goto L34;
    L41:
        Iterator<Long> r5 = r10.getAssetIds().iterator();
    L43:
        if (r5.hasNext() == false) goto L59;
        long r6 = r5.next().longValue();
        com.bytedance.android.live.core.resources.e r7 = this.i.G1(r6);
        if (r7 != null) goto L47;
    L51:
        List<Long> r8 = r10.getOptionalAssetIds();
        if (r8 == null) goto L57;
        if (r8.contains(Long.valueOf(r6)) == true) goto L43;
    L57:
        if (this.i.g1(r6) == true) goto L43;
        boolean r9 = false;
    L60:
        if (r9 == true) goto L79;
        int r11 = r10.getType();
        if (r0 == null) goto L65;
        r4 = r0.getResourceType();
    L65:
        if (h(r11, r4, r10.getId()) == false) goto L68;
        r10.setFreeDisplay(true);
        return true;
    L68:
        Iterator<Long> r13 = r10.getAssetIds().iterator();
    L70:
        if (r13.hasNext() == false) goto L77;
        long r14 = r13.next().longValue();
        String r15 = this.i.D1(r14);
        if (r15 == null) goto L70;
        this.j.x(r15, true, r14);
        if (((ArrayList) this.f).contains(Long.valueOf(r14)) == true) goto L70;
        ((ArrayList) this.f).add(Long.valueOf(r14));
        goto L70
    L77:
        this.e++;
        return false;
    L79:
        return true;
    L47:
        if (r7.getDownloadType() != 3) goto L51;
        jy0.b.a("GiftListFilterHelper", "打开礼物面板直接展示懒下载礼物，资源id：" + r6);
        if (this.i.g1(r6) == true) goto L59;
        r10.setFreeDisplay(true);
    L59:
        r9 = true;
        goto L60
    L34:
        if (r10.getType() == 8) goto L41;
        if (r10.getType() == 11) goto L41;
        if (r10.getType() == 13) goto L41;
        if (r10.getType() != 15) goto L79;
        goto L41
    }

    public final boolean f(h1 r9) {
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d.g.getClass();
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.d.f == true) goto L5;
    L7:
        yz0.k r0 = this.a;
        if (r0 == null) goto L10;
        IRoom r1 = r0.getRoom();
    L11:
        if (r1 != null) goto L49;
        AssetsService r2 = this.i;
        Intrinsics.checkNotNullParameter(r9, "$this$isValidEffectGift");
        Intrinsics.checkNotNullParameter(r2, "assetsService");
        if (r9.getType() != 2) goto L15;
    L20:
        GiftPanelBizBoostUtils.E.getClass();
        boolean r3 = GiftPanelBizBoostUtils.e();
        Iterator<Long> r10 = r9.getAssetIds().iterator();
    L22:
        if (r10.hasNext() == false) goto L37;
        long r6 = r10.next().longValue();
        if (r3 == false) goto L26;
        AssetsService r4 = r2;
    L28:
        if (r4.g1(r6) == false) goto L37;
        if (r3 == false) goto L32;
        com.bytedance.android.live.core.resources.e r5 = r2.G1(r6);
    L33:
        if (r5 == null) goto L22;
        if (r5.getResourceType() != 8) goto L22;
        boolean r11 = true;
    L38:
        if (r11 == false) goto L50;
        return false;
    L50:
        return true;
    L32:
        r5 = ((AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class)).G1(r6);
        goto L33
    L26:
        r4 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
    L37:
        r11 = false;
        goto L38
    L15:
        if (r9.getType() == 8) goto L20;
        if (r9.getType() == 11) goto L20;
        if (r9.getType() != 13) goto L37;
    L49:
        return true;
    L10:
        r1 = null;
        goto L11
    L5:
        if (this.h == null) goto L7;
        return true;
    }

    public GiftListFilterService(AssetsService r2, ResourceRecordService r3) {
        Intrinsics.checkNotNullParameter(r2, "assetsService");
        Intrinsics.checkNotNullParameter(r3, "resourceRecordService");
        this.i = r2;
        this.j = r3;
        yz0.k r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        this.a = r4;
        boolean r5 = AssetsUtils.b;
        if (r4 == null) goto L5;
        boolean r6 = r4.isAnchor();
    L6:
        this.b = AssetsUtils.b(r6);
        this.d = LazyKt.lazy(GiftListFilterService$newListOpt$2.INSTANCE);
        this.f = new ArrayList();
        this.g = com.bytedance.android.livesdk.gift.platform.business.i.m();
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final boolean g(h1 r4, ReceiverType r5) {
        if (r4 != null) goto L6;
        return true;
    L6:
        if (r5 == null) goto L13;
        int r6 = c.a[r5.ordinal()];
        if (r6 == 1) goto L24;
        if (r6 != 2) goto L13;
    L24:
        if (r4.isDisplayedOnPanel() == true) goto L26;
    L30:
        return false;
    L26:
        if (f(r4) == false) goto L30;
        if (a(r4) == false) goto L30;
        return true;
    L13:
        if (r4.isDisplayedOnPanel() == true) goto L15;
    L21:
        return false;
    L15:
        if (f(r4) == false) goto L21;
        if (a(r4) == false) goto L21;
        if (r4.isForLinkMic() == false) goto L21;
        return true;
    }

    public final boolean h(int r4, int r5, long r6) {
        if (this.g.getEnable() == true) goto L5;
        return false;
    L5:
        List<Long> r0 = this.g.f2();
        if (r0 == null) goto L11;
        if (r0.contains(Long.valueOf(r6)) != true) goto L11;
        return false;
    L11:
        if (this.g.s3().contains(Integer.valueOf(r4)) == false) goto L14;
        return false;
    L14:
        if (this.g.z5().contains(Integer.valueOf(r5)) == false) goto L16;
        return false;
    L16:
        return true;
    }
}
