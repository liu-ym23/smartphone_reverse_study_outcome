package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ TeamPkItemView a;

    public t(TeamPkItemView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        HSImageView r5 = this.a.g;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("imageChangeTeam");
    L6:
        if (r5.isSelected() == true) goto L24;
        TextView r6 = this.a.h;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tvChangeTeam");
    L11:
        if (r6.isSelected() == true) goto L25;
        TeamPkItemView r7 = this.a;
        a r2 = r7.i;
        if (r2 != null) goto L16;
        return;
    L16:
        HSImageView r8 = r7.g;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("imageChangeTeam");
    L19:
        r8.setSelected(true);
        TextView r9 = this.a.h;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tvChangeTeam");
    L22:
        r9.setSelected(true);
        r2.n50();
        return;
    L25:
        return;
    }
}
