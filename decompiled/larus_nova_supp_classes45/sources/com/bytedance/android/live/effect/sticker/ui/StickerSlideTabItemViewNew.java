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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/StickerSlideTabItemViewNew;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StickerSlideTabItemViewNew extends LinearLayout {
    public StickerSlideTabItemViewNew(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StickerSlideTabItemViewNew(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public StickerSlideTabItemViewNew(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        setOrientation(0);
        setGravity(1);
        LinearLayout r8 = new LinearLayout(r5);
        r8.setId(2131388008);
        SimpleDraweeView r0 = new SimpleDraweeView(r5);
        r0.setId(2131374718);
        int r1 = (int) t6.a(r5, 13.0f);
        int r2 = (int) t6.a(r5, 3.0f);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(r1, r1);
        r3.gravity = 1;
        r3.rightMargin = r2;
        r0.setVisibility(8);
        r8.addView(r0, r3);
        TextView r9 = new TextView(r5);
        r9.setId(2131388367);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        r4.gravity = 17;
        r8.addView(r9, r4);
        View r11 = new View(r5);
        r11.setId(2131388015);
        int r12 = (int) t6.a(r5, 6.0f);
        int r13 = (int) t6.a(r5, 9.0f);
        int r14 = (int) t6.a(r5, 5.0f);
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(r12, r12);
        r15.topMargin = r13;
        r15.rightMargin = r14;
        r8.addView(r11, r15);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -1);
        r16.gravity = 16;
        addView(r8, r16);
    }

    public /* synthetic */ StickerSlideTabItemViewNew(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
