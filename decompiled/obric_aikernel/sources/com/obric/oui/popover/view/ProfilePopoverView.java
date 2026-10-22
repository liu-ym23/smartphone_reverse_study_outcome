package com.obric.oui.popover.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/popover/view/ProfilePopoverView;", "Lcom/obric/oui/popover/view/LinkPopoverView;", "Landroid/view/View$OnClickListener;", "listener", "", "setAvatarClickListener", "", "resId", "setLeftIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfilePopoverView extends LinkPopoverView {
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ProfilePopoverView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public ProfilePopoverView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ImageView r12 = getIvIcon();
        ViewGroup.LayoutParams r13 = getIvIcon().getLayoutParams();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
        float r15 = 24;
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        r14.height = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r16.getDisplayMetrics()));
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        r14.width = MathKt.roundToInt(TypedValue.applyDimension(1, r15, r17.getDisplayMetrics()));
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        r14.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, 4, r18.getDisplayMetrics())));
        Unit r19 = Unit.INSTANCE;
        r12.setLayoutParams(r14);
        getIvIcon().setImageTintList(null);
    }

    public /* synthetic */ ProfilePopoverView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final void setAvatarClickListener(View.OnClickListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        getIvIcon().setOnClickListener(r10);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(int r10) {
        float r11 = 12;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));
        float r14 = 9;
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        int r16 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics()));
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        int r18 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r17.getDisplayMetrics()));
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        setPadding(r13, r16, r18, MathKt.roundToInt(TypedValue.applyDimension(1, r14, r19.getDisplayMetrics())));
        super.setLeftIcon(r10);
    }

    @Override // com.obric.oui.popover.view.LinkPopoverView
    public void setLeftIcon(Drawable r10) {
        float r11 = 12;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));
        float r14 = 9;
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        int r16 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics()));
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        int r18 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r17.getDisplayMetrics()));
        Resources r19 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r19, "Resources.getSystem()");
        setPadding(r13, r16, r18, MathKt.roundToInt(TypedValue.applyDimension(1, r14, r19.getDisplayMetrics())));
        super.setLeftIcon(r10);
    }
}
