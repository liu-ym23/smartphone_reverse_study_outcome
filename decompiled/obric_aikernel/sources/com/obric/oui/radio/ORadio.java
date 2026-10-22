package com.obric.oui.radio;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.common.util.k;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.e;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "use OCheckBox")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/radio/ORadio;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "", "applyStyle", "onAttachedToWindow", "", "checked", "setChecked", "", "text", "Landroid/widget/TextView$BufferType;", WsConstants.KEY_CONNECTION_TYPE, "setText", "", "style", "setStyle", "I", "alwaysLight", "Z", "adaptForCSR", "isFitOld", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class ORadio extends AppCompatRadioButton {
    private boolean adaptForCSR;
    private boolean alwaysLight;
    private boolean isFitOld;
    private int style;

    @JvmOverloads
    public ORadio(Context r10) {
        this(r10, null, 0, false, 14, null);
    }

    @JvmOverloads
    public ORadio(Context r10, AttributeSet r11) {
        this(r10, r11, 0, false, 12, null);
    }

    @JvmOverloads
    public ORadio(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, false, 8, null);
    }

    @JvmOverloads
    public ORadio(Context r10, AttributeSet r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.isFitOld = r13;
        this.adaptForCSR = true;
        if (r11 == null) goto L6;
        TypedArray r14 = r10.obtainStyledAttributes(r11, l.ORadio, r12, 0);
        Intrinsics.checkNotNullExpressionValue(r14, "context.obtainStyledAttr….ORadio, defStyleAttr, 0)");
        this.isFitOld = r14.getBoolean(l.ORadio_oui_fitOld, this.isFitOld);
        this.style = r14.getInt(l.ORadio_oui_radioStyle, 0);
        this.adaptForCSR = r14.getBoolean(l.ORadio_oui_adapt_for_csr, true);
        this.alwaysLight = r14.getBoolean(l.ORadio_oui_radioAlwaysLight, false);
        r14.recycle();
    L6:
        if (this.isFitOld == true) goto L8;
        applyStyle();
        return;
    L8:
        setClickable(true);
    }

    public /* synthetic */ ORadio(Context r10, AttributeSet r11, int r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = false;
    L11:
        this(r10, r11, r12, r13);
    }

    private final void applyStyle() {
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.style != 1) goto L10;
        int r10 = e.o_ic_radio_tick_checked;
    L8:
        setButtonDrawable(r10);
        setChecked(isChecked());
        return;
    L10:
        if (this.alwaysLight == false) goto L12;
        r10 = e.o_radio_round_always_light;
        goto L8
    L12:
        r10 = e.o_radio_round;
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.adaptForCSR == false) goto L9;
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        k.a(this, MathKt.roundToInt(TypedValue.applyDimension(1, 44, r10.getDisplayMetrics())));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        super.setChecked(r10);
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.style != 1) goto L12;
        if (r10 == false) goto L9;
        int r11 = 0;
    L10:
        setVisibility(r11);
        return;
    L9:
        r11 = 4;
        goto L10
    }

    public final void setStyle(int r10) {
        if (this.isFitOld == false) goto L5;
        return;
    L5:
        this.style = r10;
        applyStyle();
    }

    @Override // android.widget.TextView
    @Deprecated(message = "Use OTextView individually", replaceWith = @ReplaceWith(expression = "OTextView", imports = {}))
    public void setText(CharSequence r10, TextView.BufferType r11) {
        super.setText(r10, r11);
    }
}
