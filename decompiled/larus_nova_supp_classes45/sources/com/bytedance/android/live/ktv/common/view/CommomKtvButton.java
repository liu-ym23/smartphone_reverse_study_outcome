package com.bytedance.android.live.ktv.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\r\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/CommomKtvButton;", "Landroid/widget/TextView;", "", "corner", "", "setCorner", "", "parseColor", "setBgColor", "a", "I", "getBASE_PADDING", "()I", "BASE_PADDING", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommomKtvButton extends TextView {
    public final int a;

    public final int getBASE_PADDING() {
        return this.a;
    }

    public CommomKtvButton(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setBgColor(int r3) {
        Drawable r0 = getBackground();
        if ((r0 instanceof GradientDrawable) == true) goto L5;
        r0 = null;
    L5:
        GradientDrawable r1 = (GradientDrawable) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setColor(r3);
    }

    public final void setCorner(float r3) {
        Drawable r0 = getBackground();
        if ((r0 instanceof GradientDrawable) == true) goto L5;
        r0 = null;
    L5:
        GradientDrawable r1 = (GradientDrawable) r0;
        if (r1 == null) goto L9;
        r1.setCornerRadius(r3);
        return;
    }

    public CommomKtvButton(Context r2, AttributeSet r3) {
        super(r2, r3);
        int r4 = s1.f(5.0f);
        this.a = r4;
        setBackgroundResource(2131249289);
        setPadding(r4 * 3, r4, r4 * 3, r4);
        setGravity(17);
        setTextColor(-1);
    }
}
