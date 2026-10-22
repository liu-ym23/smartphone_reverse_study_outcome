package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.view.View;
import com.bytedance.dux.radio.DuxRadio;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ TabPopoverFilterMenuView b;

    public a(int r1, TabPopoverFilterMenuView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        TabPopoverFilterMenuView r5 = this.b;
        int r0 = this.a;
        Iterator r6 = ((LinkedHashMap) r5.k).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) r6.next();
        int r2 = ((Number) r1.getKey()).intValue();
        DuxRadio r3 = (DuxRadio) r1.getValue();
        if (r0 != r2) goto L8;
        boolean r7 = true;
    L9:
        r3.setChecked(r7);
        goto L4
    L8:
        r7 = false;
        goto L9
    }
}
