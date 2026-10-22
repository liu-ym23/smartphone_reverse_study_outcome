package u02;

import android.view.ViewGroup;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.k;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftLabelTextView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveSendGiftAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.f0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemListData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ItemStatus;
import com.bytedance.common.utility.StringUtils;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import qz1.s;
import vz1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends f0 {
    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.f0
    public final void G(vz1.e r11) {
        Intrinsics.checkNotNullParameter(r11, "dialogIconModel");
        this.e0.setText(((BaseMVIListItem) this).j.getContext().getString(2131919154, new Object[]{Integer.valueOf(r11.g.b)}));
        this.e0.setVisibility(0);
        this.z.setVisibility(0);
        if (StringUtils.isEmpty(r11.g.j) == false) goto L5;
        GiftLabelTextView r0 = this.z;
        h r1 = r11.g;
        long r3 = r1.d;
        long r6 = r1.e;
        r0.getClass();
        long r8 = u0.g.a;
        r0.z(r3 * r8, r6 * r8);
    L6:
        long r2 = r11.g.d;
        if (r2 > 0) goto L9;
        this.z.setBackground(s1.m(2131249167));
    L15:
        this.u.setText(r11.g.i);
        s().e(r11.g.i);
        h r13 = r11.g;
        if (r13.b > 0) goto L18;
    L27:
        this.A.setAlpha(this.l);
        this.e0.setAlpha(this.l);
        s r14 = s();
        if (r14.a == false) goto L33;
        LiveSendGiftAnimationView r4 = r14.b;
        if (r4 == null) goto L32;
        r4.setLockStatus(true);
    L32:
        r14.k = true;
        return;
    L33:
        r14.k = true;
        return;
    L18:
        if (r13.h == true) goto L27;
        this.A.setAlpha(this.m);
        this.e0.setAlpha(this.m);
        s r15 = s();
        if (r15.a == false) goto L26;
        LiveSendGiftAnimationView r5 = r15.b;
        if (r5 == null) goto L25;
        r5.setLockStatus(false);
    L25:
        r15.k = false;
        return;
    L26:
        r15.k = false;
        return;
    L9:
        if ((r2 - ((System.currentTimeMillis() / 1000) + r11.g.e)) >= TimeUnit.DAYS.toSeconds(1)) goto L12;
        this.z.setBackground(s1.m(2131249167));
        goto L15
    L12:
        if (((Boolean) nz1.a.K.getValue(null, nz1.a.a[35])).booleanValue() == false) goto L15;
        this.z.setBackground(s1.m(2131249170));
        goto L15
    L5:
        this.z.setText(r11.g.j);
        goto L6
    }

    public e(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2, r3, -1);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.f0, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.BasePanelViewHolderItem
    public final void v(k<ItemListData> r4, ItemListData r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$handleUIDiff");
        Intrinsics.checkNotNullParameter(r5, "state");
        r0<ItemListData, vz1.e> r0 = r5.getItemData();
        Object r1 = r4.c.a(r0);
        if (r1 == null) goto L5;
        r4.b.a.invoke(r0);
        G((vz1.e) r1);
    L5:
        r0<ItemListData, ItemStatus> r6 = r5.getItemStatus();
        Object r2 = r4.c.a(r6);
        if (r2 == null) goto L9;
        r4.b.a.invoke(r6);
        F((ItemStatus) r2);
        return;
    }

    public e(ViewGroup r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        super(r2, r3, r4);
    }
}
