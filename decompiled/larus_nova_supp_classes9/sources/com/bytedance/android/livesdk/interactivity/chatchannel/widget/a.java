package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements yo2.e.a {
    public final /* synthetic */ View a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ View c;

    public a(HSImageView r1, Map r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(View r5, yo2.e r6) {
        View r7 = this.a.getRootView();
        if ((r7 instanceof ViewGroup) == true) goto L5;
        r7 = null;
    L5:
        ViewGroup r8 = (ViewGroup) r7;
        if (r8 == null) goto L19;
        int r9 = r8.getChildCount();
        int r0 = 0;
    L8:
        if (r0 >= r9) goto L14;
        View r1 = r8.getChildAt(r0);
        if (r1 == null) goto L13;
        this.b.put(r1, Integer.valueOf(r1.getImportantForAccessibility()));
        r1.setImportantForAccessibility(4);
    L13:
        r0 = r0 + 1;
        goto L8
    L14:
        r8.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
        return;
    }
}
