package com.ss.android.lark.flow.chat.titlebar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/view/BadgeBackView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "badgeView", "Lcom/ss/android/lark/flow/chat/titlebar/view/BadgeBackView$BadgeView;", "badgeMarginToIconStart", "setBadgeMarginToIconStart", "", "marginPx", "setIconResId", "res", "updateBadgeCount", "count", "BadgeView", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class BadgeBackView extends ConstraintLayout {
    public final AppCompatImageView a;
    public final BadgeView b;
    public int c;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0007J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eH\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/flow/chat/titlebar/view/BadgeBackView$BadgeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "count", "minSize", "paddingHorizontal", "textSize", "", "bgPaint", "Landroid/graphics/Paint;", "textPaint", "fontMetrics", "Landroid/graphics/Paint$FontMetrics;", "updateBadge", "", "setBadgeBackgroundColor", "color", "setBadgeTextColor", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class BadgeView extends View {
        public int a;
        public final int b;
        public final int c;
        public final Paint d;
        public final Paint e;
        public final Paint.FontMetrics f;

        public BadgeView(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            AttributeSet r2 = null;
            this(r4, r2, 6, 0);
        }

        public BadgeView(Context r3, AttributeSet r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this(r3, r4, 4, 0);
        }

        @Override // android.view.View
        public final void onDraw(Canvas r13) {
            Intrinsics.checkNotNullParameter(r13, "canvas");
            super.onDraw(r13);
            if (this.a > 0) goto L5;
            return;
        L5:
            float r4 = getWidth();
            float r5 = getHeight();
            float r0 = 2;
            float r9 = r4 / r0;
            float r10 = r5 / r0;
            String r11 = String.valueOf(this.a);
            if (r11.length() != 1) goto L8;
            r13.drawCircle(r9, r10, Math.min(r4, r5) / r0, this.d);
        L9:
            this.e.getFontMetrics(this.f);
            Paint.FontMetrics r1 = this.f;
            r13.drawText(r11, r9, r10 - ((r1.bottom + r1.top) / r0), this.e);
            return;
        L8:
            r13.drawRoundRect(0.0f, 0.0f, r4, r5, r10, r10, this.d);
            goto L9
        }

        public final void setBadgeBackgroundColor(int r2) {
            this.d.setColor(r2);
            invalidate();
        }

        public final void setBadgeTextColor(int r2) {
            this.e.setColor(r2);
            invalidate();
        }

        @Override // android.view.View
        public final void onMeasure(int r5, int r6) {
            int r0 = this.a;
            if (r0 > 0) goto L6;
            setMeasuredDimension(0, 0);
            return;
        L6:
            String r1 = String.valueOf(r0);
            float r2 = this.e.measureText(r1);
            int r3 = this.b;
            if (r1.length() != 1) goto L9;
            int r4 = this.b;
        L10:
            setMeasuredDimension(View.resolveSize(r4, r5), View.resolveSize(r3, r6));
            return;
        L9:
            r4 = RangesKt.coerceAtLeast((int) (r2 + (this.c * 2)), this.b);
            goto L10
        }

        public BadgeView(Context r2, AttributeSet r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2, r3, r4);
            this.b = UIUtils.dp2px(r2, 18.0f);
            this.c = UIUtils.dp2px(r2, 6.0f);
            float r5 = UIUtils.sp2px(r2, 11.0f);
            Paint r6 = new Paint(1);
            r6.setColor(ColorProtector.parseColor("#FFFF3B30"));
            r6.setStyle(Paint.Style.FILL);
            this.d = r6;
            Paint r7 = new Paint(1);
            r7.setColor(-1);
            r7.setTextSize(r5);
            r7.setTypeface(Typeface.DEFAULT_BOLD);
            r7.setTextAlign(Paint.Align.CENTER);
            this.e = r7;
            this.f = new Paint.FontMetrics();
        }

        public /* synthetic */ BadgeView(Context r1, AttributeSet r2, int r3, int r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2, 0);
        }
    }

    public BadgeBackView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BadgeBackView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setBadgeMarginToIconStart(int r3) {
        this.c = r3;
        ConstraintLayout.LayoutParams r0 = this.b.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setMarginStart(r3);
        this.b.setLayoutParams(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIconResId(int r5) {
        this.a.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), r5, UIUtils.getColor(getContext(), 2131102040)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BadgeBackView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        AppCompatImageView r8 = new AppCompatImageView(r5);
        r8.setId(View.generateViewId());
        r8.setScaleType(ImageView.ScaleType.CENTER);
        this.a = r8;
        BadgeView r9 = new BadgeView(r5, null, 6, 0);
        r9.setId(View.generateViewId());
        this.b = r9;
        this.c = UIUtils.dp2px(r5, 28.0f);
        ConstraintLayout.LayoutParams r0 = new ConstraintLayout.LayoutParams(UIUtils.dp2px(r5, 44.0f), UIUtils.dp2px(r5, 44.0f));
        r0.startToStart = 0;
        r0.topToTop = 0;
        r0.bottomToBottom = 0;
        Unit r1 = Unit.INSTANCE;
        addView(r8, r0);
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(-2, -2);
        r2.startToStart = r8.getId();
        r2.topToTop = 0;
        r2.bottomToBottom = 0;
        r2.setMarginStart(this.c);
        r2.setMarginEnd(UIUtils.dp2px(r5, 6.0f));
        r2.endToEnd = 0;
        addView(r9, r2);
    }

    public /* synthetic */ BadgeBackView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
