package z12;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.gift.platform.core.utils.u;
import com.bytedance.android.livesdk.gift.vs.tray.view.VSGiftTrayWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h12.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements g {
    public b() {
    }

    @Override // h12.g
    public final VSGiftTrayWidget a(DataCenter r4) {
        boolean r1 = false;
        if (v.a() == false) goto L8;
        if (((Boolean) y12.a.b.getValue(null, y12.a.a[0])).booleanValue() == false) goto L8;
        r1 = true;
    L8:
        if (u.n() == false) goto L12;
        if (r1 == false) goto L11;
        return null;
    L11:
        return new VSGiftTrayWidget();
    L12:
        return null;
    }
}
