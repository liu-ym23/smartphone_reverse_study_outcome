package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.widget.Button;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ MiniGameFeaturePanelDialog a;

    public a(MiniGameFeaturePanelDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L7;
        Button r3 = (Button) this.a.T90(2131387051);
        if (r3 == null) goto L11;
        r3.setVisibility(0);
        return;
    L11:
        return;
    L7:
        Button r4 = (Button) this.a.T90(2131387051);
        if (r4 == null) goto L13;
        r4.setVisibility(8);
        return;
    }
}
