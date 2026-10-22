package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.widget.TextView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ MiniGameFeaturePanelDialog a;

    public e(MiniGameFeaturePanelDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        yq0.d r6 = (yq0.d) r5;
        if (r6 == null) goto L14;
        TextView r0 = (TextView) this.a.T90(2131386383);
        if (r0 == null) goto L7;
        r0.setText(MiniGameFeaturePanelDialog.U90(this.a, r6.c()));
    L7:
        TextView r1 = (TextView) this.a.T90(2131366955);
        if (r1 == null) goto L10;
        r1.setText(MiniGameFeaturePanelDialog.U90(this.a, r6.a()));
    L10:
        TextView r2 = (TextView) this.a.T90(2131382431);
        if (r2 == null) goto L15;
        r2.setText(MiniGameFeaturePanelDialog.U90(this.a, r6.b()));
        return;
    L15:
        return;
    }
}
