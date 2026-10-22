package com.bytedance.android.live.effect.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.sticker.ui.MarqueeTextView;
import com.bytedance.android.livesdk.utils.t6;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/common/LiveCommonStickerItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCommonStickerItemView extends RelativeLayout {
    public LiveCommonStickerItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveCommonStickerItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public LiveCommonStickerItemView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        View r14 = new View(r11);
        r14.setId(2131385784);
        int r15 = (int) t6.a(r11, 58.0f);
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(r15, r15);
        r0.topMargin = s1.f(5.0f);
        r0.addRule(10);
        r0.addRule(14);
        r14.setBackgroundResource(2131250461);
        r14.setVisibility(4);
        addView(r14, r0);
        SimpleDraweeView r1 = new SimpleDraweeView(r11);
        r1.setId(2131374931);
        r1.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        t6.a(r11, 8.0f);
        int r4 = (int) t6.a(r11, 48.0f);
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(r4, r4);
        r5.addRule(14);
        r5.addRule(6);
        r5.topMargin = s1.f(10.0f);
        addView(r1, r5);
        ImageView r2 = new ImageView(r11);
        r2.setId(2131370173);
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(-2, -2);
        r6.addRule(8, r14.getId());
        r6.addRule(7, r14.getId());
        r2.setBackgroundResource(2131250496);
        addView(r2, r6);
        ProgressBar r3 = new ProgressBar(r11);
        r3.setId(2131378977);
        int r7 = (int) t6.a(r11, 15.0f);
        RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(r7, r7);
        r8.addRule(14);
        r8.addRule(6);
        r8.topMargin = s1.f(26.5f);
        r3.setVisibility(4);
        addView(r3, r8);
        AppCompatTextView r9 = new MarqueeTextView(r11, null, 6, 0);
        r9.setId(2131388772);
        r9.setTextColor(s1.h(2131103395));
        r9.setTextSize(2, 11.0f);
        r9.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        r9.setSingleLine();
        r9.setMaxEms(5);
        r9.setFocusableInTouchMode(true);
        r9.setHorizontalFadingEdgeEnabled(true);
        r9.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams r16 = new RelativeLayout.LayoutParams(-2, -2);
        r16.addRule(14);
        r16.addRule(3, r14.getId());
        r16.topMargin = s1.f(2.0f);
        r16.bottomMargin = s1.f(3.0f);
        addView(r9, r16);
        View r17 = new View(r11);
        r17.setId(2131374741);
        int r18 = (int) t6.a(r11, 60.0f);
        RelativeLayout.LayoutParams r19 = new RelativeLayout.LayoutParams(r18, r18);
        r19.topMargin = s1.f(5.0f);
        r19.addRule(10);
        r19.addRule(14);
        r17.setBackgroundColor(s1.h(2131107416));
        r17.setVisibility(4);
        addView(r17, r19);
    }

    public /* synthetic */ LiveCommonStickerItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
