package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/button/OButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "Landroid/widget/TextView;", "getTitleView", "", "text", "", "setTitle", "", "textRes", "Lcom/obric/oui/text/OBaseTextView;", "D", "Lcom/obric/oui/text/OBaseTextView;", "getTextView", "()Lcom/obric/oui/text/OBaseTextView;", "setTextView", "(Lcom/obric/oui/text/OBaseTextView;)V", "textView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OButtonFloating extends OShadowFrame {
    public OBaseTextView D;

    public OButtonFloating(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public OButtonFloating(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public OButtonFloating(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final OBaseTextView getTextView() {
        OBaseTextView r0 = this.D;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        return null;
    }

    public final TextView getTitleView() {
        return getTextView();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void d(int r1) {
        super.d(r1);
    }

    public final void setTextView(OBaseTextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.D = r2;
    }

    public final void setTitle(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        getTextView().setText(r2);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void t(boolean r2) {
        super.t(r2);
        if (r2 == false) goto L5;
        getTextView().setAlpha(1.0f);
        return;
    L5:
        getTextView().setAlpha(0.3f);
    }

    public final void setTitle(int r2) {
        getTextView().setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.oui.button.OShadowFrame
    public final void k(Context r9, OUIFrameLayout r10, TypedArray r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "contentView");
        CharSequence r1 = r11.getText(17);
        int r2 = r11.getResourceId(19, 2131951950);
        int r3 = r11.getColor(18, getResources().getColor(2131104350, null));
        OBaseTextView r4 = new OBaseTextView(r9, null, 6, 0);
        r4.setTextAppearance(r2);
        r4.setTextColor(r3);
        r4.setText(r1);
        r4.setSingleLine();
        r4.setIncludeFontPadding(false);
        r4.setGravity(17);
        setTextView(r4);
        View r5 = getTextView();
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-2, -2);
        r6.gravity = 17;
        Unit r0 = Unit.INSTANCE;
        r10.addView(r5, r6);
        if (getMaterialApplied() == false) goto L6;
        l(r9, r11);
        return;
    }

    public OButtonFloating(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
    }
}
