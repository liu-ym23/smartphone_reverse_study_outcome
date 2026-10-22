package com.bytedance.android.live.effect.sticker.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.utils.t6;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerSlideTabItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSlideTabItemView extends LinearLayout {
    public StickerSlideTabItemView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StickerSlideTabItemView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public StickerSlideTabItemView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        setOrientation(0);
        setGravity(1);
        SimpleDraweeView r7 = new SimpleDraweeView(r4);
        r7.setId(2131374718);
        int r0 = (int) t6.a(r4, 13.0f);
        int r1 = (int) t6.a(r4, 3.0f);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(r0, r0);
        r2.gravity = 1;
        r2.rightMargin = r1;
        r7.setVisibility(8);
        addView(r7, r2);
        TextView r8 = new TextView(r4);
        r8.setId(2131388367);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(-2, -2);
        r9.gravity = 17;
        addView(r8, r9);
        View r11 = new View(r4);
        r11.setId(2131388015);
        int r12 = (int) t6.a(r4, 6.0f);
        int r3 = (int) t6.a(r4, 9.0f);
        int r13 = (int) t6.a(r4, 5.0f);
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(r12, r12);
        r14.topMargin = r3;
        r14.rightMargin = r13;
        addView(r11, r14);
    }

    public /* synthetic */ StickerSlideTabItemView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
