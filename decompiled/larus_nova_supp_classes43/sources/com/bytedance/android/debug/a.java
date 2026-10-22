package com.bytedance.android.debug;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ DebugAssetsListAdapter a;
    public final /* synthetic */ int b;

    public a(DebugAssetsListAdapter r1, int r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        List<com.bytedance.android.live.core.resources.e> r11 = this.a.b;
        if (r11 == null) goto L10;
        com.bytedance.android.live.core.resources.e r12 = (com.bytedance.android.live.core.resources.e) ListProtector.get(r11, this.b);
        if (r12 == null) goto L11;
        DebugAssetsListAdapter.a r0 = this.a.c;
        if (r0 == null) goto L12;
        r0.a(r12);
        return;
    L12:
        return;
    L11:
        return;
    }
}
