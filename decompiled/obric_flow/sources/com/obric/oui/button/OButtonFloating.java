package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/button/OButtonFloating;", "Lcom/obric/oui/button/OShadowFrame;", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setTitle", "(Ljava/lang/CharSequence;)V", "", "textRes", "(I)V", "Lcom/obric/oui/text/OBaseTextView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/obric/oui/text/OBaseTextView;", "getTextView", "()Lcom/obric/oui/text/OBaseTextView;", "setTextView", "(Lcom/obric/oui/text/OBaseTextView;)V", "textView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OButtonFloating extends OShadowFrame {
    public OBaseTextView A;

    @JvmOverloads
    public OButtonFloating(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    public final OBaseTextView getTextView() {
        OBaseTextView r5 = this.A;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        return null;
    }

    public final TextView getTitleView() {
        return getTextView();
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void p(Context r10, OUIFrameLayout r11, TypedArray r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "contentView");
        CharSequence r5 = r12.getText(R$styleable.OShadowFrame_oui_widgetText);
        int r13 = r12.getResourceId(R$styleable.OShadowFrame_oui_widgetTextStyle, R$style.Button_2_Medium);
        int r14 = r12.getColor(R$styleable.OShadowFrame_oui_widgetTextColor, getResources().getColor(R$color.oui_basic_text_1, null));
        OBaseTextView r15 = new OBaseTextView(r10, null, 6, 0);
        r15.setTextAppearance(r13);
        r15.setTextColor(r14);
        r15.setText(r5);
        r15.setSingleLine();
        r15.setIncludeFontPadding(false);
        r15.setGravity(17);
        setTextView(r15);
        View r16 = getTextView();
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);
        r17.gravity = 17;
        Unit r18 = Unit.INSTANCE;
        r11.addView(r16, r17);
        if (getMaterialApplied() == false) goto L6;
        q(r10, r12);
        return;
    }

    public final void setTextView(OBaseTextView r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.A = r5;
    }

    public final void setTitle(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        getTextView().setText(r5);
    }

    @Override // com.obric.oui.button.OShadowFrame
    public final void u(boolean r5) {
        super.u(r5);
        if (r5 == false) goto L5;
        getTextView().setAlpha(1.0f);
        return;
    L5:
        getTextView().setAlpha(0.3f);
    }

    @JvmOverloads
    public OButtonFloating(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    public final void setTitle(@StringRes int r5) {
        getTextView().setText(r5);
    }

    @JvmOverloads
    public OButtonFloating(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OButtonFloating(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11, 0);
    }
}
