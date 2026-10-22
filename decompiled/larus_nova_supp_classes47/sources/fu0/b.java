package fu0;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.profit.fansclub.widget.entrance.data.i;
import com.bytedance.android.live.profit.fansclub.widget.entrance.facade.EntranceMVIFacade;
import com.bytedance.android.live.revenue.core.util.g;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import cy0.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final i a(DataCenter r2) {
        f r3 = c(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (i) m.e.d(r3, i.class);
    }

    public static final EntranceMVIFacade b(DataCenter r3) {
        f r4 = c(r3);
        if (r4 == null) goto L8;
        m r1 = m.e;
        a r5 = r1.a(r4, a.class);
        if (r5 != null) goto L7;
        return null;
    L7:
        return (EntranceMVIFacade) r1.d(r5, EntranceMVIFacade.class);
    L8:
        return null;
    }

    public static final f c(DataCenter r2) {
        if (r2 == null) goto L6;
        Boolean r0 = (Boolean) r2.get("data_is_anchor", Boolean.FALSE);
        if (r0 == null) goto L6;
        boolean r1 = r0.booleanValue();
    L8:
        if (MultiRoomConfig.INSTANCE.enableRev(Boolean.valueOf(r1)) == false) goto L19;
        if (r2 == null) goto L26;
        IAbilityCenter r3 = a0.a(r2);
        if (r3 == null) goto L27;
        int r4 = g.a;
        Intrinsics.checkNotNullParameter(r3, "abilityCenter");
        g.a r5 = (g.a) r3.getAbility(g.a.class);
        if (r5 == null) goto L15;
        com.bytedance.android.live.revenue.core.a r6 = r5.a;
    L16:
        if (r6 != null) goto L18;
        return null;
    L18:
        return r6.getScope();
    L15:
        r6 = null;
        goto L16
    L27:
        return null;
    L26:
        return null;
    L19:
        com.bytedance.android.live.revenue.core.b r7 = j.C0.a();
        if ((r7 instanceof com.bytedance.android.live.revenue.core.a) == true) goto L22;
        r7 = null;
    L22:
        com.bytedance.android.live.revenue.core.a r8 = (com.bytedance.android.live.revenue.core.a) r7;
        if (r8 != null) goto L25;
        return null;
    L25:
        return r8.getScope();
    L6:
        r1 = false;
        goto L8
    }
}
