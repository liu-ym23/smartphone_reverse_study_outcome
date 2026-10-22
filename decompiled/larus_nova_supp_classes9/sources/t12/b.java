package t12;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.model.d;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends l {
    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, n r7, k r8, k r9, l1 r10, com.bytedance.android.livesdk.gift.model.n r11, String r13, int r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r7, "showInfo");
        return false;
    }

    public b(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r20, int r21, int r23, IBaseUser r24, boolean r25, List<? extends IBaseUser> r26, boolean r27, n r28, k r29, k r210, l1 r30, com.bytedance.android.livesdk.gift.model.n r31, String r33, String r34, com.bytedance.android.livesdk.gift.platform.core.model.a r35) {
        Intrinsics.checkNotNullParameter(r24, "toUser");
        Intrinsics.checkNotNullParameter(r28, "showInfo");
        if (r20 != null) goto L5;
        return false;
    L5:
        if (r20.a != 18) goto L16;
        T r0 = r20.h;
        if (r0 == 0) goto L13;
        String r15 = ((l2) r0).getRefId();
        Context r1 = getContext();
        if (r1 == null) goto L17;
        d r14 = new d(true, "storage_prop", null, 0, false, 0, 0, null, null, null, null, null, r15, 16380);
        f.a(IRechargeService.class).showRechargeDialogFragment(r1, r14, null);
        return true;
    L17:
        return false;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L16:
        return false;
    }
}
