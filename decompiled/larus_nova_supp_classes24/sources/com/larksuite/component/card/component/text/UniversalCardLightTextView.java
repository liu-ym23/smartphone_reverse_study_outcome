package com.larksuite.component.card.component.text;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.util.AttributeSet;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0015"}, d2 = {"Lcom/larksuite/component/card/component/text/UniversalCardLightTextView;", "Lcom/ss/android/lark/widget/light/LKUILightTextView;", "Lcom/ss/android/lark/widget/card/ICardSpanListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDetachedFromWindow", "", "onDrawableInvalidated", "setLayout", "layout", "Landroid/text/Layout;", "cancelAnimations", "setListeners", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardLightTextView extends LKUILightTextView implements ybc.b {
    public final void B() {
        CharSequence r0 = getContentText();
        if ((r0 instanceof Spanned) == true) goto L5;
        return;
    L5:
        Spanned r1 = (Spanned) r0;
        int r3 = 0;
        ybc.a[] r2 = (ybc.a[]) r1.getSpans(0, r1.length(), ybc.a.class);
        Intrinsics.checkNotNull(r2);
        int r4 = r2.length;
    L6:
        if (r3 >= r4) goto L8;
        r2[r3].cancelAnimation();
        r3 = r3 + 1;
        goto L6
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    public final void h() {
        invalidate();
    }

    public UniversalCardLightTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    private final void setListeners(Layout r4) {
        CharSequence r5 = r4.getText();
        if ((r5 instanceof Spannable) == true) goto L5;
        return;
    L5:
        int r2 = 0;
        ybc.a[] r6 = (ybc.a[]) ((Spannable) r5).getSpans(0, r5.length(), ybc.a.class);
        Intrinsics.checkNotNull(r6);
        int r0 = r6.length;
    L6:
        if (r2 >= r0) goto L8;
        r6[r2].a(this);
        r2 = r2 + 1;
        goto L6
    }

    public final void setLayout(Layout r2) {
        Intrinsics.checkNotNullParameter(r2, "layout");
        if (Intrinsics.areEqual(r2, getLayout()) == false) goto L5;
        return;
    L5:
        B();
        setListeners(r2);
        setContentLayout(r2);
    }

    public UniversalCardLightTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
    }

    public UniversalCardLightTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
    }
}
