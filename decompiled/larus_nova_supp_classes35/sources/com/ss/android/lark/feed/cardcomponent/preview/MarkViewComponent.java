package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MarkViewComponent extends FeedCardComponent<Object, AppCompatImageView> {
    public final Lazy c;
    public final int d;

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        AppCompatImageView r0 = new AppCompatImageView(getContext());
        r0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return r0;
    }

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final ViewGroup.MarginLayoutParams b() {
        int r1 = this.d;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(r1, r1);
        r0.gravity = 16;
        r0.rightMargin = UIHelper.dp2px(4.0f);
        return r0;
    }

    public MarkViewComponent(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = LazyKt.lazy(new MarkViewComponent$rotateAnimation$2(r2));
        this.d = zz7.b.g(r2, 16);
    }
}
