package com.ss.android.lark.feed.app.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/feed/app/tablayout/RefactoredCurrentGroupIndicator;", "Lcom/ss/android/lark/feed/app/tablayout/RefactoredFeedTabLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "childTextView", "Landroid/widget/TextView;", "onFinishInflate", BuildConfig.FLAVOR, "setText", SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, BuildConfig.FLAVOR, "feed-tab-layout_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RefactoredCurrentGroupIndicator extends RefactoredFeedTabLayout {
    public TextView w;

    @Override // com.ss.android.lark.feed.app.tablayout.RefactoredFeedTabLayout, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r0 = getChildAt(0);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.widget.TextView");
        TextView r1 = (TextView) r0;
        int r2 = ContextCompat.getColor(r1.getContext(), 2131102427);
        r1.setCompoundDrawablesRelative(null, null, UDIconUtils.getIconDrawable(r1.getContext(), 2131254119, r2, new UDDimension.a(zz7.b.g(r1.getContext(), 12))), null);
        r1.setCompoundDrawablePadding(UIUtils.dp2px(r1.getContext(), 8.0f));
        this.w = r1;
    }

    public RefactoredCurrentGroupIndicator(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setText(CharSequence r2) {
        TextView r0 = this.w;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("childTextView");
        r0 = null;
    L5:
        r0.setText(r2);
    }

    public RefactoredCurrentGroupIndicator(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
