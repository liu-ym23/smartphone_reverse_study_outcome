package com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.bdlocation.BuildConfig;
import gz1.c;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a extends pz1.a<h1> {
    @Override // pz1.a
    public final void k() {
    }

    @Override // pz1.a
    public final String l() {
        return BuildConfig.FLAVOR;
    }

    @Override // pz1.a
    public final boolean o() {
        return false;
    }

    @Override // pz1.a
    public final boolean p() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String a() {
        return ((h1) this.h).getDescribe();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final long c() {
        return ((h1) this.h).getId();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k d() {
        return ((h1) this.h).getImage();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k e() {
        return ((h1) this.h).getLeftLogo();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public String f() {
        return ((h1) this.h).getName();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final boolean i() {
        k0 r0 = ((h1) this.h).getGiftPreviewInfo();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (((h1) this.h).getType() != 1) goto L11;
        return false;
    L11:
        if (((h1) this.h).getType() != 5) goto L13;
        return false;
    L13:
        if (((h1) this.h).getType() != 10) goto L15;
        return false;
    L15:
        if (((h1) this.h).getType() == 12) goto L22;
        if (r1 == true) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L5:
        if (r0.getLockStatus() == k0.UNLOCKED) goto L7;
        r1 = true;
        goto L9
    }

    @Override // pz1.a
    public final long j() {
        return ((h1) this.h).getDiamondCount();
    }

    @Override // pz1.a
    public final boolean m() {
        return !((h1) this.h).getGiftGroupList().isEmpty();
    }

    @Override // pz1.a
    public final boolean n() {
        return ((h1) this.h).isSupportLongPressCombo();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k g() {
        if (s.a() != null) goto L5;
        return null;
    L5:
        n r0 = s.a().I(Long.valueOf(c()));
        if (r0 == null) goto L9;
        this.f = AbsPanel.GiftPanelIconSource.DIY_CARD;
        return r0.getIconImg();
    L9:
        return null;
    }

    public final void q() {
        if (s.a() != null) goto L5;
        return;
    L5:
        n r0 = s.a().I(Long.valueOf(c()));
        if (r0 == null) goto L9;
        this.f = AbsPanel.GiftPanelIconSource.DIY_CARD;
        this.b = c.g(r0);
        this.g = r0.getConfigId();
        this.c = r0.getCardName();
        return;
    }

    public a(h1 r2) {
        super(1, r2);
        if (u.r() == false) goto L6;
        q();
        return;
    }

    public a(h1 r1, int r2) {
        super(5, r1);
        if (u.r() == false) goto L6;
        q();
        return;
    }
}
