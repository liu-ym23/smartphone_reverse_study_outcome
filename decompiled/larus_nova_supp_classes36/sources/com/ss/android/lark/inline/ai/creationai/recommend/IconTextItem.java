package com.ss.android.lark.inline.ai.creationai.recommend;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import h18.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\"\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0014J\u0010\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u0016J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0007J\u0010\u0010*\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016J\u000e\u0010+\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0007J\u001a\u0010,\u001a\u00020\u00182\b\b\u0002\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u0014J&\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J&\u00104\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J\u0006\u00105\u001a\u00020\u000bJ&\u00106\u001a\u00020\u00182\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J\u0006\u00107\u001a\u00020\rJ\n\u00108\u001a\u00020\u0007*\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/recommend/IconTextItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "leftEmojiText", "Landroid/widget/TextView;", "leftLabel", "Landroid/view/View;", "textTv", "bgView", "Landroid/widget/LinearLayout;", "setIcon", "", "iconRes", "", "setEmojiContent", "", "text", "setIconColor", "colorRes", "setLeftIconVisible", "visible", "setEmojiVisible", "setLeftLabelVisible", "setTextVisible", "setText", "content", "setTextBold", "isBold", "setTextMaxLines", "maxLines", "setTextSize", "size", "setEmojiSize", "setTextColor", "setIconSize", "setRoundBackground", "isRound", "isSelected", "setBgViewPadding", "left", "top", "right", "bottom", "setIconPadding", "getLeftIconView", "setViewPadding", "getEmojiView", "dp", "Companion", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class IconTextItem extends FrameLayout {
    public final AppCompatImageView a;
    public final TextView b;
    public final View c;
    public final TextView d;

    public static final class a {
    }

    static {
    }

    public IconTextItem(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IconTextItem(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final TextView getEmojiView() {
        return this.b;
    }

    public final AppCompatImageView getLeftIconView() {
        return this.a;
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final void setEmojiContent(String r3) {
        this.a.setVisibility(8);
        this.b.setText(r3);
    }

    public final void setEmojiSize(int r2) {
        this.b.setTextSize(r2);
    }

    public final void setEmojiVisible(boolean r2) {
        TextView r0 = this.b;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
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

    public final void setIconSize(int r4) {
        this.a.setLayoutParams(new LinearLayout.LayoutParams(a(r4), a(r4)));
    }

    public final void setLeftIconVisible(boolean r2) {
        AppCompatImageView r0 = this.a;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setLeftLabelVisible(boolean r2) {
        View r0 = this.c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setText(String r2) {
        this.d.setText(r2);
    }

    public final void setTextBold(boolean r3) {
        if (r3 == false) goto L4;
        TextView r4 = this.d;
        int r0 = e.a;
        r4.setTypeface(e.b(getContext(), 1));
        return;
    L4:
        TextView r5 = this.d;
        int r1 = e.a;
        r5.setTypeface(e.b(getContext(), 0));
    }

    public final void setTextColor(String r2) {
        Context r0 = getContext();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        int r3 = n.j(r0, r2);
        int r4 = ContextCompat.getColor(getContext(), r3);
        this.d.setTextColor(r4);
    }

    public final void setTextMaxLines(int r2) {
        this.d.setMaxLines(r2);
    }

    public final void setTextSize(int r2) {
        this.d.setTextSize(r2);
    }

    public final void setTextVisible(boolean r2) {
        TextView r0 = this.d;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public IconTextItem(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        LinearLayout r14 = new LinearLayout(r11);
        r14.setOrientation(0);
        r14.setGravity(16);
        AppCompatImageView r1 = new AppCompatImageView(r11);
        r1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r1.setAdjustViewBounds(true);
        this.a = r1;
        TextView r3 = new TextView(r11);
        r3.setVisibility(8);
        r3.setTextSize(14.0f);
        r3.setPadding(0, a(1), a(4), 0);
        this.b = r3;
        View r6 = new View(r11);
        r6.setBackground(ContextCompat.getDrawable(r11, n.j(r11, "icon_disabled")));
        r6.setVisibility(8);
        this.c = r6;
        TextView r7 = new TextView(r11);
        r7.setPadding(a(2), 0, 0, 0);
        r7.setTextColor(ContextCompat.getColor(r11, n.i(r11, "title_color")));
        r7.setTextSize(14.0f);
        r7.setEllipsize(TextUtils.TruncateAt.END);
        r7.setMaxLines(1);
        this.d = r7;
        addView(r14, new FrameLayout.LayoutParams(-1, -2));
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(a(2), a(16));
        r15.gravity = 16;
        r15.setMargins(a(8), 0, a(8), 0);
        Unit r16 = Unit.INSTANCE;
        r14.addView(r6, r15);
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);
        r17.gravity = 16;
        r14.addView(r1, r17);
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, -2);
        r18.gravity = 16;
        r14.addView(r3, r18);
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
        r19.gravity = 16;
        r14.addView(r7, r19);
        ViewGroup.LayoutParams r110 = new FrameLayout.LayoutParams(-1, -2);
        setPadding(a(20), a(12), a(20), a(12));
        setLayoutParams(r110);
    }

    public /* synthetic */ IconTextItem(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
