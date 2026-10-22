package com.obric.assistant.settings.autogui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.lisitem.OCardListItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y0 extends LinearLayout {
    public final OCardListItem a;
    public final TextView b;

    public y0(Context r4, OCardListItem r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "cardItem");
        super(r4);
        this.a = r5;
        View r6 = LayoutInflater.from(r4).inflate(2131561637, this, false);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) r6;
        this.b = r7;
        setOrientation(1);
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        addView(r5);
        addView(r7);
    }
}
