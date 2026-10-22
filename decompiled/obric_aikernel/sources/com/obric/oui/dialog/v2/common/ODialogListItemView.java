package com.obric.oui.dialog.v2.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.c;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020\u001c8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"¨\u00066"}, d2 = {"Lcom/obric/oui/dialog/v2/common/ODialogListItemView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "", "str", "", "setTitle", "setSubtitle", "Landroid/view/View;", "view", "setTrailingView", "Landroid/graphics/drawable/Drawable;", "drawable", "setTrailingImageView", "", "selected", "setSelected", "Landroid/widget/TextView;", "o", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "titleView", "p", "getSubtitleView", "setSubtitleView", "subtitleView", "Landroid/widget/FrameLayout;", "n", "Landroid/widget/FrameLayout;", "getTrailingContainer", "()Landroid/widget/FrameLayout;", "setTrailingContainer", "(Landroid/widget/FrameLayout;)V", "trailingContainer", "Lcom/obric/oui/layout/OUILinearLayout;", "l", "Lcom/obric/oui/layout/OUILinearLayout;", "getListItemRoot", "()Lcom/obric/oui/layout/OUILinearLayout;", "setListItemRoot", "(Lcom/obric/oui/layout/OUILinearLayout;)V", "listItemRoot", "m", "getLeadingContainer", "setLeadingContainer", "leadingContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class ODialogListItemView extends OUIFrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OUILinearLayout f6515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f6516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public FrameLayout f6517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f6518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f6519p;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f6520c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ODialogListItemView f6521g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f6522h;

        public a(View r10, ODialogListItemView r11, boolean r12) {
            this.f6520c = r10;
            this.f6521g = r11;
            this.f6522h = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f6522h == false) goto L5;
            ODialogListItemView r10 = this.f6521g;
            int r11 = r10.getListItemRoot().getPaddingLeft();
            Resources r12 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
            r10.updateBottomDivider(r11, 0, MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.6d, r12.getDisplayMetrics())), this.f6521g.getResources().getColor(c.oui_line_2));
            return;
        L5:
            ODialogListItemView r13 = this.f6521g;
            r13.updateBottomDivider(r13.getListItemRoot().getPaddingLeft(), 0, 0, c.oui_line_2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ODialogListItemView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public ODialogListItemView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, 0, null, 12, null);
        c(r10);
    }

    public /* synthetic */ ODialogListItemView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    private final void c(Context r10) {
        LayoutInflater.from(r10).inflate(h.o_dialog_listitem_view, this);
        View r11 = findViewById(f.list_item_root);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.list_item_root)");
        OUILinearLayout r12 = (OUILinearLayout) r11;
        this.f6515l = r12;
        da.c r13 = da.c.f8520a;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listItemRoot");
    L5:
        if (r12 != null) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L10;
        r12.setChangeAlphaWhenPress(false);
    L10:
        View r14 = findViewById(f.list_item_title);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.list_item_title)");
        this.f6518o = (TextView) r14;
        View r15 = findViewById(f.list_item_subtitle);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.list_item_subtitle)");
        this.f6519p = (TextView) r15;
        View r16 = findViewById(f.list_leading_element);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.list_leading_element)");
        this.f6516m = (FrameLayout) r16;
        View r17 = findViewById(f.list_trailing_element);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.list_trailing_element)");
        this.f6517n = (FrameLayout) r17;
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 12, r18.getDisplayMetrics())));
        setChangeAlphaWhenDisable(false);
    }

    private final void d(ViewGroup r10, View r11, ViewGroup.LayoutParams r12) {
        if (r11 == null) goto L12;
        if (r10 == null) goto L5;
        k.h(r10);
    L5:
        if (r10 == null) goto L7;
        r10.removeAllViews();
    L7:
        if (r12 != null) goto L10;
        if (r10 == null) goto L15;
        r10.addView(r11);
        return;
    L15:
        return;
    L10:
        if (r10 == null) goto L17;
        r10.addView(r11, r12);
        return;
    L17:
        return;
    L12:
        if (r10 == null) goto L19;
        k.f(r10);
        return;
    }

    private final void g(TextView r10, CharSequence r11) {
        if (r11 != null) goto L4;
    L7:
        boolean r12 = true;
    L8:
        if (r12 == false) goto L10;
        k.f(r10);
        return;
    L10:
        r10.setText(r11);
        k.h(r10);
        return;
    L4:
        if (r11.length() == 0) goto L7;
        r12 = false;
        goto L8
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_EVENT);
        if (isEnabled() == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r10);
    }

    public final void e(View r10, ViewGroup.LayoutParams r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "layoutParams");
        FrameLayout r12 = this.f6517n;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trailingContainer");
    L5:
        d(r12, r10, r11);
    }

    public final void f(boolean r10) {
        Intrinsics.checkExpressionValueIsNotNull(OneShotPreDrawListener.add(this, new a(this, this, r10)), "OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final FrameLayout getLeadingContainer() {
        FrameLayout r10 = this.f6516m;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("leadingContainer");
    L5:
        return r10;
    }

    public final OUILinearLayout getListItemRoot() {
        OUILinearLayout r10 = this.f6515l;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listItemRoot");
    L5:
        return r10;
    }

    public final TextView getSubtitleView() {
        TextView r10 = this.f6519p;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
    L5:
        return r10;
    }

    public final TextView getTitleView() {
        TextView r10 = this.f6518o;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L5:
        return r10;
    }

    public final FrameLayout getTrailingContainer() {
        FrameLayout r10 = this.f6517n;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trailingContainer");
    L5:
        return r10;
    }

    public final void setLeadingContainer(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6516m = r10;
    }

    public final void setListItemRoot(OUILinearLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6515l = r10;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        getAlphaHelper().onSelectedChanged(this, r10);
    }

    public final void setSubtitle(CharSequence r10) {
        TextView r11 = this.f6519p;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleView");
    L5:
        g(r11, r10);
    }

    public final void setSubtitleView(TextView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6519p = r10;
    }

    public final void setTitle(CharSequence r10) {
        TextView r11 = this.f6518o;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L5:
        g(r11, r10);
    }

    public final void setTitleView(TextView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6518o = r10;
    }

    public final void setTrailingContainer(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6517n = r10;
    }

    public final void setTrailingImageView(Drawable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        ImageView r11 = new ImageView(getContext());
        r11.setImageDrawable(r10);
        Unit r12 = Unit.INSTANCE;
        setTrailingView(r11);
    }

    public final void setTrailingView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 17;
        ViewGroup r12 = this.f6517n;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("trailingContainer");
    L5:
        d(r12, r10, r11);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, o9.b
    public boolean shouldUpdateDividerColorOnPress() {
        return true;
    }
}
