package com.ss.android.lark.feed.cardcomponent.titleright;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J(\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/titleright/TitleRightView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "textView", "Landroid/widget/TextView;", "flagView", "Landroidx/appcompat/widget/AppCompatImageView;", "setTextViewColorRes", BuildConfig.FLAVOR, "timeColorRes", BuildConfig.FLAVOR, "setTextViewTextSize", "textSize", "init", "createTimeOrStatusView", "createFlagView", "bind", "text", BuildConfig.FLAVOR, "flagDrawable", "Landroid/graphics/drawable/Drawable;", "status", "Lcom/ss/android/lark/feed/cardcomponent/titleright/TitleRightComponent$Status;", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleRightView extends ConstraintLayout {
    public static final int c = 0;
    public TextView a;
    public AppCompatImageView b;

    public static final class a {
    }

    static {
        c = UIHelper.dp2px(3.0f);
    }

    public TitleRightView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextViewColorRes(int r3) {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r0 = null;
    L5:
        r0.setTextColor(UDColorUtils.getColor(getContext(), r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextViewTextSize(int r3) {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r0 = null;
    L5:
        r0.setTextSize(0, b.h(getContext(), r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TitleRightView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, 0);
        TextView r6 = new TextView(r4);
        r6.setTextColor(UDColorUtils.getColor(r4, 2131106620));
        r6.setTextSize(0, b.h(r4, 14));
        this.a = r6;
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(-2, -2);
        r7.startToStart = 0;
        r7.endToEnd = 0;
        r7.topToTop = 0;
        r7.bottomToBottom = 0;
        TextView r1 = this.a;
        View r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r1 = null;
    L5:
        addView(r1, r7);
        AppCompatImageView r8 = new AppCompatImageView(r4);
        r8.setScaleType(ImageView.ScaleType.FIT_XY);
        this.b = r8;
        int r9 = b.g(r4, 12);
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(r9, r9);
        r10.startToStart = 0;
        r10.endToEnd = 0;
        r10.topToTop = 0;
        r10.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r10).bottomMargin = c;
        View r11 = this.b;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("flagView");
    L9:
        addView(r2, r10);
        return;
    L8:
        r2 = r11;
        goto L9
    }
}
