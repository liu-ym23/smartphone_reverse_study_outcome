package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.c;
import u8.k;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/button/OButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "Landroid/widget/TextView;", "getTitleView", "", "text", "", "setTitle", "", "textRes", "Lcom/obric/oui/text/OBaseTextView;", "w", "Lcom/obric/oui/text/OBaseTextView;", "getTextView", "()Lcom/obric/oui/text/OBaseTextView;", "setTextView", "(Lcom/obric/oui/text/OBaseTextView;)V", "textView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OButtonFloating extends OShadowFrame {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OBaseTextView f6262w;

    @JvmOverloads
    public OButtonFloating(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OButtonFloating(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OButtonFloating(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OButtonFloating(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13);
    }

    public /* synthetic */ OButtonFloating(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    public final OBaseTextView getTextView() {
        OBaseTextView r10 = this.f6262w;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        return r10;
    }

    public final TextView getTitleView() {
        OBaseTextView r10 = this.f6262w;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        return r10;
    }

    @Override // com.obric.oui.button.OShadowFrame
    public void j(Context r10, FrameLayout r11, AttributeSet r12, TypedArray r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "contentView");
        if (r13 != null) goto L5;
        return;
    L5:
        CharSequence r14 = r13.getText(l.OShadowFrame_oui_widgetText);
        int r15 = r13.getResourceId(l.OShadowFrame_oui_widgetTextStyle, k.Button_2_Medium);
        int r16 = r13.getColor(l.OShadowFrame_oui_widgetTextColor, getResources().getColor(c.oui_basic_text_1, null));
        OBaseTextView r17 = new OBaseTextView(r10, null, 0, 6, null);
        r17.setTextAppearance(r15);
        r17.setTextColor(r16);
        r17.setText(r14);
        r17.setSingleLine();
        r17.setIncludeFontPadding(false);
        r17.setGravity(17);
        Unit r18 = Unit.INSTANCE;
        this.f6262w = r17;
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
        r19.gravity = 17;
        r11.addView(r17, r19);
    }

    @Override // com.obric.oui.button.OShadowFrame
    protected void n(boolean r10) {
        super.n(r10);
        OBaseTextView r11 = this.f6262w;
        if (r10 == false) goto L7;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L6:
        float r12 = 1.0f;
    L10:
        r11.setAlpha(r12);
        return;
    L7:
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L9:
        r12 = 0.3f;
        goto L10
    }

    public final void setTextView(OBaseTextView r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f6262w = r10;
    }

    public final void setTitle(@StringRes int r10) {
        OBaseTextView r11 = this.f6262w;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        r11.setText(r10);
    }

    public final void setTitle(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        OBaseTextView r11 = this.f6262w;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        r11.setText(r10);
    }
}
