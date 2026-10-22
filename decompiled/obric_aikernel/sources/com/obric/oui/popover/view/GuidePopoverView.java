package com.obric.oui.popover.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/popover/view/GuidePopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "", "charSequence", "", "setStatusText", "setGuideText", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTvStatus", "()Landroid/widget/TextView;", "tvStatus", "g", "getTvGuide", "tvGuide", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class GuidePopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f7178c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f7179g;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public GuidePopoverView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public GuidePopoverView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        LinearLayout.inflate(r10, h.o_popover_guide_view, this);
        setOrientation(0);
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        int r13 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r12.getDisplayMetrics()));
        setPadding(r13, r13, r13, r13);
        setBackground(ContextCompat.getDrawable(r10, e.o_popover_view_bg));
        View r14 = findViewById(f.tv_status_text);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.tv_status_text)");
        this.f7178c = (TextView) r14;
        View r15 = findViewById(f.tv_guide_text);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.tv_guide_text)");
        this.f7179g = (TextView) r15;
    }

    public /* synthetic */ GuidePopoverView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final TextView getTvGuide() {
        return this.f7179g;
    }

    public final TextView getTvStatus() {
        return this.f7178c;
    }

    public final void setGuideText(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "charSequence");
        this.f7179g.setText(r10);
    }

    public final void setStatusText(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "charSequence");
        this.f7178c.setText(r10);
    }
}
