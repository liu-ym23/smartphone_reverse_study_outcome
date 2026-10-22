package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.widget.Button;
import com.bytedance.android.livesdk.utils.r2;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ MiniGameFeaturePanelDialog a;

    public c(MiniGameFeaturePanelDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        yq0.e r4 = (yq0.e) r3;
        if (r4.a() == true) goto L5;
    L9:
        Button r5 = (Button) this.a.T90(2131379204);
        if (r5 == null) goto L15;
        r5.setVisibility(8);
        return;
    L15:
        return;
    L5:
        if (r2.a(r4.d()) == false) goto L9;
        Button r6 = (Button) this.a.T90(2131379204);
        if (r6 == null) goto L13;
        r6.setVisibility(0);
        return;
    }
}
