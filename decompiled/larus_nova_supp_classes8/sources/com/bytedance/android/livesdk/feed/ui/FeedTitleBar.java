package com.bytedance.android.livesdk.feed.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/feed/ui/FeedTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setBackOnClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedTitleBar extends ConstraintLayout {
    public FeedTitleBar(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FeedTitleBar(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setBackOnClickListener(View.OnClickListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        findViewById(2131372259).setOnClickListener(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeedTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        ViewGroup.inflate(getContext(), 2131567665, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(String r4, Drawable r5, boolean r6) {
        if (r4 != null) goto L5;
    L10:
        View r7 = findViewById(2131372259);
        if (r6 == true) goto L13;
        UtilityKotlinExtentionsKt.z(r7, false);
        return;
    L13:
        UtilityKotlinExtentionsKt.z(r7, true);
        if (r5 == null) goto L18;
        r7.setBackground(r5);
        return;
    L18:
        return;
    L5:
        if (r4.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 != true) goto L10;
        ((TextView) findViewById(2131372257)).setText(r4);
        goto L10
    L7:
        r2 = false;
        goto L8
    }

    public /* synthetic */ FeedTitleBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
