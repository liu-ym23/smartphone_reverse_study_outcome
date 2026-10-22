package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f extends TextView implements e {
    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.e
    public void setColor(int r1) {
        setTextColor(r1);
    }

    public f(Context r2, CharSequence r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "content");
        super(r2);
        setGravity(16);
        setTypeface(Typeface.DEFAULT_BOLD);
        setText(r3);
    }
}
