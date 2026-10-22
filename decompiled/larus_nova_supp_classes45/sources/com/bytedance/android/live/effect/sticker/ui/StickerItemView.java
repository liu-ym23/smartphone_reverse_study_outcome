package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.t6;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerItemView extends RelativeLayout {
    public StickerItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StickerItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public StickerItemView(Context r17, AttributeSet r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r19);
        View r2 = new View(r17);
        r2.setId(2131385784);
        int r3 = (int) t6.a(r17, 58.0f);
        RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(r3, r3);
        r4.topMargin = s1.f(5.0f);
        r4.addRule(10);
        r4.addRule(14);
        r2.setBackgroundResource(2131250424);
        r2.setVisibility(4);
        addView(r2, r4);
        ImageView r5 = new ImageView(r17);
        r5.setId(2131374931);
        t6.a(r17, 8.0f);
        int r8 = (int) t6.a(r17, 54.0f);
        RelativeLayout.LayoutParams r9 = new RelativeLayout.LayoutParams(r8, r8);
        r9.addRule(14);
        r9.addRule(6);
        r9.topMargin = s1.f(7.0f);
        r5.setImageResource(2131250484);
        addView(r5, r9);
        View r11 = new View(r17);
        r11.setId(2131370082);
        int r12 = (int) t6.a(r17, 6.0f);
        RelativeLayout.LayoutParams r13 = new RelativeLayout.LayoutParams(r12, r12);
        r13.addRule(6, r5.getId());
        r13.addRule(7, r5.getId());
        r11.setBackgroundResource(2131250462);
        r11.setVisibility(4);
        addView(r11, r13);
        ImageView r14 = new ImageView(r17);
        r14.setId(2131370173);
        RelativeLayout.LayoutParams r15 = new RelativeLayout.LayoutParams(-2, -2);
        r15.addRule(8, r5.getId());
        r15.addRule(7, r5.getId());
        r14.setBackgroundResource(2131250496);
        addView(r14, r15);
        ProgressBar r16 = new ProgressBar(r17);
        r16.setId(2131378977);
        int r110 = (int) t6.a(r17, 15.0f);
        RelativeLayout.LayoutParams r111 = new RelativeLayout.LayoutParams(r110, r110);
        r111.addRule(14);
        r111.addRule(6);
        r111.topMargin = s1.f(26.5f);
        r16.setVisibility(4);
        addView(r16, r111);
        AppCompatTextView r21 = new MarqueeTextView(r17, null, 6, 0);
        r21.setId(2131388772);
        r21.setTextColor(s1.h(2131103395));
        r21.setTextSize(2, 10.0f);
        r21.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r21.setSingleLine();
        r21.setMaxEms(5);
        r21.setFocusableInTouchMode(true);
        r21.setHorizontalFadingEdgeEnabled(true);
        r21.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(-2, -2);
        r6.addRule(14);
        r6.addRule(3, r5.getId());
        r6.topMargin = s1.f(2.0f);
        r6.bottomMargin = s1.f(3.0f);
        addView(r21, r6);
        AppCompatTextView r7 = new MarqueeTextView(r17, null, 6, 0);
        r7.setId(2131387347);
        r7.setTextColor(s1.h(2131107414));
        r7.setTextSize(2, 8.0f);
        r7.setWidth(s1.f(39.0f));
        r7.setHeight(s1.f(14.0f));
        r7.setGravity(17);
        r7.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r7.setBackgroundResource(2131250426);
        r7.setText("主播在用");
        r7.setVisibility(8);
        r7.setSingleLine();
        r7.setMaxEms(5);
        r7.setFocusableInTouchMode(true);
        r7.setHorizontalFadingEdgeEnabled(true);
        RelativeLayout.LayoutParams r22 = new RelativeLayout.LayoutParams(-2, -2);
        r22.addRule(6, r5.getId());
        r22.addRule(7, r5.getId());
        r22.topMargin = s1.f(3.0f);
        r22.rightMargin = s1.f(3.0f);
        addView(r7, r22);
        View r23 = new View(r17);
        r23.setId(2131374741);
        int r1 = (int) t6.a(r17, 60.0f);
        RelativeLayout.LayoutParams r24 = new RelativeLayout.LayoutParams(r1, r1);
        r24.topMargin = s1.f(5.0f);
        r24.addRule(10);
        r24.addRule(14);
        r23.setBackgroundColor(s1.h(2131107416));
        r23.setVisibility(4);
        addView(r23, r24);
    }

    public /* synthetic */ StickerItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
