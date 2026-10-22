package t12;

import android.content.Context;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.g;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.t0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.SelectedStatus;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends l {
    public a(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean x(AbsPanel<?> r4, SelectedStatus r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r5, "selectedStatus");
        String r7 = null;
        if (r4 == null) goto L5;
        Object r0 = r4.h;
    L6:
        boolean r1 = false;
        if ((r0 instanceof h1) == false) goto L32;
        if (r4 == null) goto L10;
        Object r8 = r4.h;
    L11:
        if (r8 == null) goto L31;
        h1 r9 = (h1) r8;
        if (r9.getBizType() != 2) goto L32;
        t0 r10 = r9.getGoodsBizItem();
        if (r10 == null) goto L19;
        g r11 = r10.b();
        if (r11 == null) goto L19;
        r7 = r11.a();
    L19:
        Context r13 = getContext();
        if (r13 != null) goto L22;
    L29:
        return true;
    L22:
        if (StringUtils.isEmpty(r7) == true) goto L29;
        if (r5 != SelectedStatus.LOCATE) goto L26;
        r1 = true;
    L26:
        if (r7 == null) goto L29;
        if (r1 == true) goto L29;
        f.a(zz0.g.class).S2(r13, r7);
        goto L29
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IGift");
    L10:
        r8 = null;
    L32:
        return false;
    L5:
        r0 = null;
        goto L6
    }
}
