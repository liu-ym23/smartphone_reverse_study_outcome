package com.ss.android.lark.chat.cot.detail.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\f\u0010\u0016\u001a\u00020\u0007*\u00020\u0017H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/widget/MultiIconFoldButton;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconContainer", "Landroid/widget/FrameLayout;", "textView", "Landroid/widget/TextView;", "setText", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "setIcons", "icons", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/cot/detail/widget/FoldIconConfig;", "dp", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiIconFoldButton extends LinearLayout {
    public final FrameLayout a;
    public final TextView b;

    public static final class a {
    }

    static {
    }

    public MultiIconFoldButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MultiIconFoldButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.view.View, android.widget.ImageView, androidx.appcompat.widget.AppCompatImageView, com.ss.android.lark.chat.cot.detail.widget.FoldCircleImageView] */
    public final void setIcons(List<c> r15) {
        Intrinsics.checkNotNullParameter(r15, "icons");
        this.a.removeAllViews();
        if (r15.isEmpty() == false) goto L6;
        this.a.setVisibility(8);
        return;
    L6:
        this.a.setVisibility(0);
        Iterator r0 = CollectionsKt.take(r15, 3).iterator();
        int r3 = 0;
    L7:
        boolean r5 = true;
        if (r0.hasNext() == false) goto L37;
        Object r4 = r0.next();
        int r8 = r3 + 1;
        if (r3 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        c r6 = (c) r4;
        FrameLayout r9 = this.a;
        Integer r12 = null;
        ?? r10 = new FoldCircleImageView(getContext(), null);
        if (r15.size() == 1) goto L15;
        boolean r11 = true;
    L16:
        r10.h = r11;
        int r13 = r6.b;
        r10.setPadding(r13, r13, r13, r13);
        Integer r14 = r6.d;
        if (r14 == null) goto L19;
        int r16 = r14.intValue();
    L20:
        r10.f = r16;
        r10.g = UIUtils.getColor(r10.getContext(), r10.f);
        Drawable r17 = UIUtils.getDrawable(r10.getContext(), r6.a);
        if (r17 == null) goto L23;
        Drawable r18 = r17.mutate();
    L24:
        Integer r7 = r6.c;
        if (r7 == null) goto L36;
        if (r7.intValue() > 0) goto L30;
        r5 = false;
    L30:
        if (r5 == false) goto L32;
        r12 = r7;
    L32:
        if (r12 == null) goto L36;
        int r19 = r12.intValue();
        if (r18 == null) goto L36;
        r18.setColorFilter(UIUtils.getColor(r10.getContext(), r19), PorterDuff.Mode.SRC_IN);
    L36:
        r10.setImageDrawable(r18);
        r10.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(UIUtils.dp2px(getContext(), 14.0f), UIUtils.dp2px(getContext(), 14.0f));
        r20.leftMargin = r3 * UIUtils.dp2px(getContext(), 12.0f);
        r20.gravity = 16;
        Unit r21 = Unit.INSTANCE;
        r9.addView(r10, r20);
        r3 = r8;
        goto L7
    L23:
        r18 = null;
        goto L24
    L19:
        r16 = 2131100549;
        goto L20
    L15:
        r11 = false;
        goto L16
    L37:
        FrameLayout r1 = this.a;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.width = UIUtils.dp2px(getContext(), 14.0f) + ((Math.min(r15.size(), 3) - 1) * UIUtils.dp2px(getContext(), 12.0f));
        r1.setLayoutParams(r2);
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.b.setText(r2);
    }

    public MultiIconFoldButton(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        FrameLayout r8 = new FrameLayout(r5);
        this.a = r8;
        TextView r9 = new TextView(r5);
        this.b = r9;
        setOrientation(0);
        setGravity(16);
        setMinimumHeight(UIUtils.dp2px(r5, 26.0f));
        setPadding(UIUtils.dp2px(r5, 8.0f), 0, UIUtils.dp2px(r5, 8.0f), 0);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(0);
        r2.setCornerRadius(UIUtils.dp2px(r5, 100.0f));
        r2.setColor(UIUtils.getColor(r5, 2131100549));
        setBackground(r2);
        r8.setVisibility(8);
        addView(r8, new LinearLayout.LayoutParams(-2, UIUtils.dp2px(r5, 14.0f)));
        r9.setGravity(16);
        r9.setMinHeight(UIUtils.dp2px(r5, 20.0f));
        r9.setTextSize(12.0f);
        r9.setMaxLines(1);
        r9.setEllipsize(TextUtils.TruncateAt.END);
        r9.setTextColor(UIUtils.getColor(r5, 2131106607));
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.setMarginStart(UIUtils.dp2px(r5, 4.0f));
        Unit r11 = Unit.INSTANCE;
        addView(r9, r10);
    }

    public /* synthetic */ MultiIconFoldButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
