package com.ss.android.lark.inline.ai.creationai.operates;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fJ\f\u0010\u0012\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/MenuIcon;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Landroidx/appcompat/widget/AppCompatImageView;", "setIcon", "", "iconRes", "", "setIconColor", "colorRes", "dp", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class MenuIcon extends FrameLayout {
    public final AppCompatImageView a;

    public static final class a {
    }

    static {
    }

    public MenuIcon(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MenuIcon(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final void setIcon(String r2) {
        Context r0 = getContext();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        int r3 = n.n(r0, r2);
        this.a.setImageResource(r3);
    }

    public final void setIconColor(String r3) {
        Context r0 = getContext();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        int r4 = n.i(r0, r3);
        int r5 = ContextCompat.getColor(getContext(), r4);
        this.a.setColorFilter(r5, PorterDuff.Mode.SRC_IN);
    }

    public MenuIcon(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        AppCompatImageView r7 = new AppCompatImageView(r4);
        r7.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r7.setAdjustViewBounds(true);
        r7.setPadding(a(2), a(2), a(2), a(2));
        this.a = r7;
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(a(20) + (a(2) * 2), a(20) + (a(2) * 2));
        r8.gravity = 17;
        Unit r9 = Unit.INSTANCE;
        addView(r7, r8);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    }

    public /* synthetic */ MenuIcon(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
