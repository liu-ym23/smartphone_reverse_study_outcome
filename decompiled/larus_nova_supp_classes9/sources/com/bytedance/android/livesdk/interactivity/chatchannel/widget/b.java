package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements PopupWindow.OnDismissListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Map c;

    public b(HSImageView r1, View r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        View r0 = this.a.getRootView();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L22;
        r1.removeView(this.b);
        int r2 = r1.getChildCount();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L16;
        View r4 = r1.getChildAt(r3);
        if (r4 == null) goto L15;
        Integer r5 = (Integer) this.c.get(r4);
        if (r5 == null) goto L15;
        r4.setImportantForAccessibility(r5.intValue());
    L15:
        r3 = r3 + 1;
        goto L8
    L16:
        this.c.clear();
        return;
    }
}
