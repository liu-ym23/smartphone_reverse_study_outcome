package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends LinearLayout implements e {
    public final ImageView a;
    public final TextView b;

    public final ImageView getIcon() {
        return this.a;
    }

    public final TextView getText() {
        return this.b;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.e
    public void setColor(int r3) {
        this.b.setTextColor(r3);
        this.a.getDrawable().setColorFilter(r3, PorterDuff.Mode.SRC_IN);
    }

    public g(Context r2, ImageView r3, TextView r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "icon");
        Intrinsics.checkNotNullParameter(r4, "text");
        super(r2);
        this.a = r3;
        this.b = r4;
        setGravity(16);
        setOrientation(0);
        addView(r4);
        addView(r3);
    }
}
