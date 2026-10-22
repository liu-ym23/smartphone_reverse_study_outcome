package com.obric.oui.dialog.v2.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lynx.tasm.utils.a;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.common.style.i;
import com.obric.oui.dialog.v2.selection.OSelectionItemView;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010-\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020.8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010B\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010<\u001a\u0004\bA\u0010>¨\u0006C"}, d2 = {"Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "str", "", "setTitle", "(Ljava/lang/CharSequence;)V", "setSubtitle", "Landroid/view/View;", "view", "setTrailingView", "(Landroid/view/View;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImageView", "(Landroid/graphics/drawable/Drawable;)V", "", "selected", "setSelected", "(Z)V", "Lcom/obric/oui/layout/OUILinearLayout;", "h", "Lcom/obric/oui/layout/OUILinearLayout;", "getListItemRoot", "()Lcom/obric/oui/layout/OUILinearLayout;", "setListItemRoot", "(Lcom/obric/oui/layout/OUILinearLayout;)V", "listItemRoot", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "getLeadingContainer", "()Landroid/widget/FrameLayout;", "setLeadingContainer", "(Landroid/widget/FrameLayout;)V", "leadingContainer", "j", "getTrailingContainer", "setTrailingContainer", "trailingContainer", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "titleView", "l", "getSubtitleView", "setSubtitleView", "subtitleView", "", "m", "Lkotlin/Lazy;", "getLineColor", "()I", "lineColor", "n", "getLineHeight", "lineHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ODialogListItemView extends OUIFrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OUILinearLayout f13173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f13174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f13175j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f13176k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f13177l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f13178m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f13179n;

    @JvmOverloads
    public ODialogListItemView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null);
    }

    private final int getLineColor() {
        return ((Number) this.f13178m.getValue()).intValue();
    }

    private final int getLineHeight() {
        return ((Number) this.f13179n.getValue()).intValue();
    }

    public static final void n(OSelectionItemView r5) {
        int r10 = r5.getListItemRoot().getPaddingLeft();
        int r11 = r5.getLeadingContainer().getMeasuredWidth() + r10;
        int r12 = r5.getLineHeight();
        int r13 = r5.getLineColor();
        i r14 = r5.f13532b;
        r14.f12493l = r11;
        r14.f12494m = 0;
        r14.f12495n = r13;
        r14.f12492k = r12;
        r14.v();
    }

    public static void o(FrameLayout r5, View r10, ViewGroup.LayoutParams r11) {
        if (r10 == null) goto L12;
        if (r5 == null) goto L6;
        d.t(r5);
    L6:
        if (r5 == null) goto L9;
        r5.removeAllViews();
    L9:
        if (r5 == null) goto L17;
        r5.addView(r10, r11);
        return;
    L17:
        return;
    L12:
        if (r5 == null) goto L18;
        d.s(r5);
        return;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r5);
    }

    public final FrameLayout getLeadingContainer() {
        FrameLayout r5 = this.f13174i;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("leadingContainer");
        return null;
    }

    public final OUILinearLayout getListItemRoot() {
        OUILinearLayout r5 = this.f13173h;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("listItemRoot");
        return null;
    }

    public final TextView getSubtitleView() {
        TextView r5 = this.f13177l;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
        return null;
    }

    public final TextView getTitleView() {
        TextView r5 = this.f13176k;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        return null;
    }

    public final FrameLayout getTrailingContainer() {
        FrameLayout r5 = this.f13175j;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("trailingContainer");
        return null;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, com.obric.oui.common.style.b
    public final boolean k() {
        return true;
    }

    public final void setLeadingContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13174i = r5;
    }

    public final void setListItemRoot(OUILinearLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13173h = r5;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r5) {
        super.setSelected(r5);
        getAlphaHelper().h(this, r5);
    }

    public final void setSubtitle(CharSequence r5) {
        TextView r10 = getSubtitleView();
        if (r5 != null) goto L5;
    L8:
        d.s(r10);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r10.setText(r5);
        d.t(r10);
    }

    public final void setSubtitleView(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13177l = r5;
    }

    public final void setTitle(CharSequence r5) {
        TextView r10 = getTitleView();
        if (r5 != null) goto L5;
    L8:
        d.s(r10);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r10.setText(r5);
        d.t(r10);
    }

    public final void setTitleView(TextView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13176k = r5;
    }

    public final void setTrailingContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f13175j = r5;
    }

    public final void setTrailingImageView(Drawable r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        ImageView r10 = new ImageView(getContext());
        r10.setImageDrawable(r5);
        setTrailingView(r10);
    }

    public final void setTrailingView(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 17;
        o(getTrailingContainer(), r5, r10);
    }

    @JvmOverloads
    public ODialogListItemView(final Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, 0, 12);
        this.f13178m = LazyKt.lazy(new ODialogListItemView$lineColor$2(r5));
        this.f13179n = LazyKt.lazy(new ODialogListItemView$lineHeight$2(this));
        LayoutInflater.from(r5).inflate(R$layout.o_dialog_listitem_view, this);
        setListItemRoot((OUILinearLayout) findViewById(R$id.list_item_root));
        OUILinearLayout r11 = getListItemRoot();
        if (r11 != null) goto L5;
        r11 = null;
    L5:
        if (r11 == null) goto L8;
        r11.setChangeAlphaWhenPress(false);
    L8:
        setTitleView((TextView) findViewById(R$id.list_item_title));
        setSubtitleView((TextView) findViewById(R$id.list_item_subtitle));
        setLeadingContainer((FrameLayout) findViewById(R$id.list_leading_element));
        setTrailingContainer((FrameLayout) findViewById(R$id.list_trailing_element));
        setRadius(a.B(12, this));
        setChangeAlphaWhenDisable(false);
    }
}
