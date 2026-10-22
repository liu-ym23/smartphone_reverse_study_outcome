package com.obric.oui.popover.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.k;
import com.obric.oui.popover.PopoverLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.e;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006 "}, d2 = {"Lcom/obric/oui/popover/view/LinkPopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "", "resId", "", "setLeftIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "", "charSequence", "setTips", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "getTvTips", "()Landroid/widget/TextView;", "tvTips", "Landroid/widget/ImageView;", "h", "Landroid/widget/ImageView;", "getIvArrow", "()Landroid/widget/ImageView;", "ivArrow", "c", "getIvIcon", "ivIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class LinkPopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageView f7180c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f7181g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f7182h;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public LinkPopoverView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public LinkPopoverView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        LinearLayout.inflate(r10, h.o_popover_link_view, this);
        setOrientation(0);
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r12.getDisplayMetrics()));
        setPadding(r13, r13, r13, r13);
        setBackground(ContextCompat.getDrawable(r10, e.o_popover_view_bg));
        View r14 = findViewById(f.iv_icon);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.iv_icon)");
        this.f7180c = (ImageView) r14;
        View r15 = findViewById(f.tv_tips);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.tv_tips)");
        this.f7181g = (TextView) r15;
        View r16 = findViewById(f.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.iv_arrow)");
        this.f7182h = (ImageView) r16;
    }

    public /* synthetic */ LinkPopoverView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final ImageView getIvArrow() {
        return this.f7182h;
    }

    public final ImageView getIvIcon() {
        return this.f7180c;
    }

    public final TextView getTvTips() {
        return this.f7181g;
    }

    public void setLeftIcon(@DrawableRes int r10) {
        this.f7180c.setImageResource(r10);
        k.h(this.f7180c);
    }

    public void setLeftIcon(Drawable r10) {
        this.f7180c.setImageDrawable(r10);
        k.h(this.f7180c);
    }

    public final void setTips(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "charSequence");
        this.f7181g.setText(r10);
    }
}
