package com.ss.android.lark.inline.ai.creationai.operates;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.badge.UDBadge;
import com.larksuite.component.universe_design.badge.UDBadgeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import h18.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001bJ\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0019J\u0010\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u001bJ\u0015\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u0019J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0007J\u000e\u00101\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0007J\u0010\u00102\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001bJ\u0018\u00103\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\u0019J\u001a\u00105\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u0019J&\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007J&\u0010=\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u0007J\u0006\u0010@\u001a\u00020\u0011J\u0006\u0010A\u001a\u00020\u0015J&\u0010B\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007J\f\u0010C\u001a\u00020\u0007*\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/ss/android/lark/inline/ai/creationai/operates/NormalItem;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "view", "Landroid/view/View;", "bgView", "Landroid/widget/LinearLayout;", "leftIconContainer", "Landroid/widget/FrameLayout;", "leftIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "leftBadge", "Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "leftEmojiText", "Landroid/widget/TextView;", "leftLabel", "textTv", "setIcon", "", "iconRes", "", "setEmojiContent", "", "text", "setIconColor", "colorRes", "setLeftIconVisible", "visible", "setEmojiVisible", "setLeftLabelVisible", "setTextVisible", "setText", "content", "setBadge", "num", "(Ljava/lang/Integer;)V", "setTextBold", "isBold", "setTextMaxLines", "maxLines", "setTextSize", "size", "setEmojiSize", "setTextColor", "setIconSize", "isCenter", "setRoundBackground", "isRound", "isSelected", "setBgViewPadding", "left", "top", "right", "bottom", "setIconPadding", "setViewHeight", "height", "getLeftIconView", "getEmojiView", "setViewPadding", "dp", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class NormalItem extends RelativeLayout {
    public static final /* synthetic */ int i = 0;
    public final View a;
    public final LinearLayout b;
    public final FrameLayout c;
    public final AppCompatImageView d;
    public final UDBadgeView e;
    public final TextView f;
    public final View g;
    public final TextView h;

    public NormalItem(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NormalItem(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final TextView getEmojiView() {
        return this.f;
    }

    public final AppCompatImageView getLeftIconView() {
        return this.d;
    }

    public final int a(int r3) {
        Resources r0 = getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public final void c(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        int r3 = n.n(getContext(), "ud_icon_abbreviation_outlined");
        this.d.setImageResource(r3);
        return;
    L11:
        int r4 = n.o(getContext(), r2);
        if (r4 == 0) goto L15;
        this.d.setImageResource(r4);
        return;
    L15:
        return;
    L4:
        if (r2.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void setBadge(Integer r3) {
        if (r3 != null) goto L7;
        this.e.setVisibility(8);
        return;
    L7:
        if (r3.intValue() <= 0) goto L9;
        this.e.setVisibility(0);
        this.e.setText(String.valueOf(RangesKt.coerceAtMost(r3.intValue(), 99)));
        this.e.a();
        return;
    L9:
        this.e.setVisibility(8);
    }

    public final void setEmojiContent(String r3) {
        this.d.setVisibility(8);
        this.f.setVisibility(0);
        this.f.setText(r3);
    }

    public final void setEmojiSize(int r2) {
        this.f.setTextSize(r2);
    }

    public final void setEmojiVisible(boolean r2) {
        TextView r0 = this.f;
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
        this.d.setColorFilter(r5, PorterDuff.Mode.SRC_IN);
    }

    public final void setLeftIconVisible(boolean r2) {
        AppCompatImageView r0 = this.d;
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
        View r0 = this.g;
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
        this.h.setText(r2);
    }

    public final void setTextBold(boolean r3) {
        TextView r0 = this.h;
        int r1 = e.a;
        r0.setTypeface(e.b(getContext(), r3 ? 1 : 0));
    }

    public final void setTextColor(String r2) {
        Context r0 = getContext();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        int r3 = n.j(r0, r2);
        int r4 = ContextCompat.getColor(getContext(), r3);
        this.h.setTextColor(r4);
    }

    public final void setTextMaxLines(int r2) {
        this.h.setMaxLines(r2);
    }

    public final void setTextSize(int r2) {
        this.h.setTextSize(r2);
    }

    public final void setTextVisible(boolean r2) {
        TextView r0 = this.h;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setViewHeight(int r2) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        r0.height = a(r2);
    }

    public final void d(int r4, boolean r5) {
        AppCompatImageView r0 = this.d;
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(a(r4), a(r4));
        if (r5 == false) goto L5;
        r1.gravity = 17;
    L5:
        r0.setLayoutParams(r1);
    }

    public NormalItem(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131563334, this, true);
        this.a = findViewById(2131375888);
        this.b = (LinearLayout) findViewById(2131364152);
        this.c = (FrameLayout) findViewById(2131374809);
        this.d = findViewById(2131374769);
        UDBadgeView r5 = findViewById(2131363846);
        this.e = r5;
        this.f = (TextView) findViewById(2131371551);
        this.g = findViewById(2131377108);
        this.h = (TextView) findViewById(2131367861);
        r5.setBadgeType(UDBadge.BadgeType.TEXT);
        r5.setTextMaxLength(2);
        r5.setVisibility(8);
    }

    public /* synthetic */ NormalItem(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(int r2, int r3, int r4, int r5) {
        this.b.setPadding(a(r2), a(r3), a(r4), a(r5));
    }
}
