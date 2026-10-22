package com.ss.android.lark.feed.export.feedcard;

import android.view.View;
import com.ss.android.lark.feed.app.entity.UIFeedCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface h {
    a a(View r1);

    void b(View r1, UIFeedCard r2, c r3, d r4);

    void c();

    void onViewAttachedToWindow();

    void onViewDetachedFromWindow();

    void onViewRecycled();
}
