package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e4 extends LinearLayout {
    public final LinearLayout a;

    public e4(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        setOrientation(1);
        View r5 = LayoutInflater.from(r4).inflate(2131562660, null);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout r6 = (LinearLayout) r5;
        this.a = r6;
        Resources r1 = AppHost.a.getApplication().getResources();
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).widthPixels, -2);
        if (r6 == null) goto L5;
        r6.setLayoutParams(r0);
    L5:
        addView(r6);
    }

    public final void setRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        r3.setTag("search_video_single_row");
        ViewParent r0 = r3.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        r1.removeView(r3);
    L8:
        LinearLayout r2 = this.a;
        if (r2 == null) goto L12;
        r2.addView(r3);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setSearchHeaderText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "string");
        TextView r0 = (TextView) findViewById(2131385497);
        if (r0 == null) goto L6;
        r0.setText(r2);
        return;
    }
}
