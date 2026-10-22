package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends FeedCardComponent<Object, TextView> {
    public final float c;

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        TextView r0 = new TextView(getContext());
        r0.setTextSize(0, this.c);
        r0.setSingleLine();
        r0.setEllipsize(TextUtils.TruncateAt.END);
        r0.setGravity(16);
        return r0;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.gravity = 16;
        return r0;
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = zz7.b.h(r2, 14);
    }
}
