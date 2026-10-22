package kz1;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.l;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.android.livesdk.gift.platform.core.model.k;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.gift.util.b;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import pz1.e;
import vy0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends l {
    public final Context e;

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean o(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, n r7, k r8, k r9, l1 r10, com.bytedance.android.livesdk.gift.model.n r11, String r13, int r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r7, "showInfo");
        return false;
    }

    public a(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
        this.e = r3;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.f
    public final boolean A(AbsPanel<?> r1, int r2, int r3, IBaseUser r4, boolean r5, List<? extends IBaseUser> r6, boolean r7, n r8, k r9, k r10, l1 r11, com.bytedance.android.livesdk.gift.model.n r13, String r14, String r15, com.bytedance.android.livesdk.gift.platform.core.model.a r16) {
        Intrinsics.checkNotNullParameter(r4, "toUser");
        Intrinsics.checkNotNullParameter(r8, "showInfo");
        boolean r17 = false;
        if (r1 != null) goto L5;
    L25:
        boolean r18 = false;
    L26:
        if (r18 == false) goto L59;
        if (r1 == null) goto L29;
        Object r19 = r1.h;
    L31:
        if (r19 == null) goto L58;
        b1 r20 = ((l2) r19).getBanner();
        if (r20 != null) goto L35;
        return r18;
    L35:
        x0 r110 = new x0((String) nz1.a.R.getValue(null, nz1.a.a[42]));
        r110.b("title", r20.getTitle());
        r110.b("sub_title", r20.getText());
        py.k r111 = r20.getImage();
        if (r111 == null) goto L40;
        List r112 = r111.getUrls();
        if (r112 == null) goto L40;
        Integer r113 = Integer.valueOf(r112.size());
    L41:
        if (r113 == null) goto L48;
        py.k r114 = r20.getImage();
        Intrinsics.checkNotNull(r114);
        if (r114.getUrls().size() < 1) goto L48;
        py.k r21 = r20.getImage();
        Intrinsics.checkNotNull(r21);
        String r23 = (String) ListProtector.get(r21.getUrls(), 0);
        if (r23 != null) goto L47;
        r23 = BuildConfig.FLAVOR;
    L47:
        r110.b(sz1.a.KEY_LOCAL_ICON_BITMAP, r23);
    L48:
        T r24 = r1.h;
        if (r24 == 0) goto L56;
        r110.b("prop_id", String.valueOf(((l2) r24).getId()));
        T r25 = r1.h;
        if (r25 == 0) goto L54;
        r110.b("ref_id", ((l2) r25).getRefId());
        f.a(c.class).U0(this.e, r110.c(), null);
        goto L59
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L40:
        r113 = null;
        goto L41
    L58:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L29:
        r19 = null;
    L59:
        if (r1 != null) goto L61;
    L76:
        if (r17 == false) goto L78;
        b.f(new GiftStateMachineConfig.Event.h(0, 7));
    L78:
        return r18;
    L61:
        if ((r1 instanceof e) == false) goto L76;
        T r26 = ((e) r1).h;
        if (r26 == 0) goto L76;
        if ((r26 instanceof l2) == false) goto L76;
        l2 r27 = (l2) r26;
        if (r27.getPropType() != 1) goto L76;
        if (r27.getPropDefSubType() != 1) goto L76;
        if (r27.getBanner() == null) goto L76;
        r17 = ((Boolean) h.d0.getValue(null, h.a[54])).booleanValue();
        goto L76
    L5:
        if ((r1 instanceof e) == false) goto L25;
        e r28 = (e) r1;
        T r29 = r28.h;
        if (r29 == 0) goto L25;
        if ((r29 instanceof l2) == false) goto L25;
        l2 r30 = (l2) r29;
        if (r30.getPropType() != 1) goto L25;
        if (r30.getPropDefSubType() != 1) goto L25;
        if (r30.getBanner() == null) goto L25;
        l2 r31 = (l2) r28.h;
        if (r31 == null) goto L25;
        long r33 = r31.getId();
        com.bytedance.tools.kcp.spongepreference.runtime.a r34 = ay1.b.s0;
        KProperty[] r115 = ay1.b.a;
        HashMap r116 = (HashMap) r34.getValue(null, r115[84]);
        Boolean r117 = (Boolean) r116.get(Long.valueOf(r33));
        Boolean r118 = Boolean.TRUE;
        if (Intrinsics.areEqual(r117, r118) == true) goto L25;
        r116.put(Long.valueOf(r33), r118);
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r34.setValue(null, r115[84], r116);
        r18 = true;
        goto L26
    }
}
