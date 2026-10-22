package cz1;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.OpenDialogService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u0;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import jy0.b;
import kotlin.jvm.internal.Intrinsics;
import yt0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends l implements o {
    public final u0 e;
    public final OpenDialogService f;

    /* JADX INFO: renamed from: cz1.a$a, reason: collision with other inner class name */
    public static final class C0223a {
    }

    static {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final void s() {
    }

    public final void onStart() {
        b.a("LivePet/GiftPlugin", "register plugin");
        u0 r0 = this.e;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "plugin");
        r0.i(this, F(), r0.g);
    }

    public a(Context r2, DataCenter r3, u0 r4, OpenDialogService r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "giftInternalScopeService");
        Intrinsics.checkNotNullParameter(r5, "openDialogService");
        super(r3, r2);
        this.e = r4;
        this.f = r5;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, boolean r7, n r8, k r9, k r10, l1 r11, com.bytedance.android.livesdk.gift.model.n r13, String r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r8, "showInfo");
        if (r1 == null) goto L5;
        Long r17 = Long.valueOf(r1.c());
    L6:
        boolean r18 = false;
        if (r17 != null) goto L10;
        b.f("LivePet/GiftPlugin", "gift id is null", null, 4);
        return false;
    L10:
        com.bytedance.android.live.profit.livepet.b r19 = c.e();
        if (r19 != null) goto L13;
    L15:
        if (r18 == false) goto L17;
        b.a("LivePet/GiftPlugin", "intercepted gift_id = " + r17);
        this.f.a("live_pet_special_gift");
    L18:
        return r18;
    L17:
        b.a("LivePet/GiftPlugin", "not intercepted gift_id = " + r17);
        goto L18
    L13:
        if (r19.G3(r17.longValue()) != true) goto L15;
        r18 = true;
        goto L15
    L5:
        r17 = null;
        goto L6
    }
}
