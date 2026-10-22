package pz1;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import java.util.HashSet;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends a<l2> {
    @Override // pz1.a
    public final void k() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String a() {
        return ((l2) this.h).getDescription();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k b() {
        return ((l2) this.h).getDiamondLabel();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final long c() {
        return ((l2) this.h).getId();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k d() {
        return ((l2) this.h).getIcon();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k e() {
        return ((l2) this.h).getLabelIcon();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String f() {
        return ((l2) this.h).getName();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final boolean i() {
        if (((l2) this.h).getGift() != null) goto L5;
        return true;
    L5:
        if (((l2) this.h).getGift().getType() != 1) goto L7;
    L9:
        return false;
    L7:
        if (((l2) this.h).getGift().getType() == 5) goto L9;
        return true;
    }

    @Override // pz1.a
    public final long j() {
        return ((l2) this.h).getDiamond();
    }

    @Override // pz1.a
    public final String l() {
        return ((l2) this.h).getManual();
    }

    @Override // pz1.a
    public final boolean m() {
        if (((l2) this.h).getGift() != null) goto L6;
        return false;
    L6:
        if (j0.a(((l2) this.h).getGift()) == false) goto L9;
        return false;
    L9:
        return !((l2) this.h).getGift().getGiftGroupList().isEmpty();
    }

    @Override // pz1.a
    public final boolean n() {
        if (((l2) this.h).getGift() != null) goto L6;
        return false;
    L6:
        return ((l2) this.h).getGift().getRepeat();
    }

    @Override // pz1.a
    public final boolean o() {
        return !((HashSet) ay1.b.n.getValue(null, ay1.b.a[16])).contains(String.valueOf(((l2) this.h).getId()));
    }

    @Override // pz1.a
    public final boolean p() {
        if (TextUtils.isEmpty(((l2) this.h).getManual()) == false) goto L5;
    L7:
        return false;
    L5:
        if (((HashSet) ay1.b.m.getValue(null, ay1.b.a[15])).contains(Long.valueOf(((l2) this.h).getId())) == true) goto L7;
        return true;
    }

    public e(l2 r6) {
        long r0 = r6.getPropType();
        if (r0 != 4) goto L6;
        int r1 = 9;
    L12:
        super(r1, r6);
        return;
    L6:
        if (r0 != 9) goto L9;
        r1 = 14;
        goto L12
    L9:
        if (r0 != 5) goto L11;
        r1 = 18;
        goto L12
    L11:
        r1 = 2;
        goto L12
    }
}
