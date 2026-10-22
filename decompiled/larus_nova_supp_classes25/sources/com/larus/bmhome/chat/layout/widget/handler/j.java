package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j implements pw8.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ f b;

    public final void a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        TextView r5 = new TextView(this.a);
        f r0 = this.b;
        FLogger.a.d(r0.b, "[biz_deep_search] mindMapData Empty Holder...");
        r5.setTextSize(20.0f);
        r5.setText("Empty Holder...");
    }

    public j(Context r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(int r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "currentViewGroup");
    }
}
