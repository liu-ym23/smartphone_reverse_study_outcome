package com.ss.android.lark.feed.cardcomponent.title.specialfocus;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.ss.android.lark.feed.export.feedcard.FeedCardComponent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SpecialFocusComponent extends FeedCardComponent<Object, AppCompatImageView> {
    public final Lazy c;

    @Override // com.ss.android.lark.feed.export.feedcard.FeedCardComponent
    public final View a() {
        return new AppCompatImageView(getContext());
    }

    public SpecialFocusComponent(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = LazyKt.lazy(new SpecialFocusComponent$specialFocusDrawable$2(r2));
    }
}
