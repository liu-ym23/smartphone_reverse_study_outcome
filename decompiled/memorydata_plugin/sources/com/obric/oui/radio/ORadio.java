package com.obric.oui.radio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use OCheckBox")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007J\u001c\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/oui/radio/ORadio;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "isFitOld", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "adaptForCSR", "alwaysLight", "style", "applyStyle", "", "onAttachedToWindow", "setChecked", "checked", "setStyle", "setText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "type", "Landroid/widget/TextView$BufferType;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ORadio extends AppCompatRadioButton {
    private boolean adaptForCSR;
    private boolean alwaysLight;
    private boolean isFitOld;
    private int style;

    public ORadio(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, false, 14, null);
    }

    public ORadio(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, false, 12, null);
    }

    public ORadio(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, false, 8, null);
    }

    public ORadio(Context r3, AttributeSet r4, int r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r5);
        this.isFitOld = r6;
        this.adaptForCSR = true;
        if (r8 == null) goto L6;
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.ORadio, r5, 0);
        Intrinsics.checkNotNullExpressionValue(r9, "context.obtainStyledAttr….ORadio, defStyleAttr, 0)");
        this.isFitOld = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ORadio_oui_fitOld, "styleable", "ORadio_oui_fitOld"), this.isFitOld);
        this.style = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.ORadio_oui_radioStyle, "styleable", "ORadio_oui_radioStyle"), 0);
        this.adaptForCSR = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ORadio_oui_adapt_for_csr, "styleable", "ORadio_oui_adapt_for_csr"), true);
        this.alwaysLight = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ORadio_oui_radioAlwaysLight, "styleable", "ORadio_oui_radioAlwaysLight"), false);
        r9.recycle();
    L6:
        if (this.isFitOld == true) goto L8;
        applyStyle();
        return;
    L8:
        setClickable(true);
    }

    public /* synthetic */ ORadio(Context r2, AttributeSet r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = false;
    L11:
        this(r8, r9, r4, r5);
    }

    private final void applyStyle() {
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.style != 1) goto L10;
        int r0 = R.drawable.o_ic_radio_tick_checked;
        String r1 = "o_ic_radio_tick_checked";
    L8:
        setButtonDrawable(ZeusTransformUtils.mapRes(r0, "drawable", r1));
        setChecked(isChecked());
        return;
    L10:
        if (this.alwaysLight == false) goto L12;
        r0 = R.drawable.o_radio_round_always_light;
        r1 = "o_radio_round_always_light";
        goto L8
    L12:
        r0 = R.drawable.o_radio_round;
        r1 = "o_radio_round";
        goto L8
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.adaptForCSR == false) goto L9;
        o.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 44));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        super.setChecked(r3);
        if (this.isFitOld == false) goto L6;
        return;
    L6:
        if (this.style != 1) goto L12;
        if (r3 == false) goto L9;
        int r4 = 0;
    L10:
        setVisibility(r4);
        return;
    L9:
        r4 = 4;
        goto L10
    }

    public final void setStyle(int r2) {
        if (this.isFitOld == false) goto L5;
        return;
    L5:
        this.style = r2;
        applyStyle();
    }

    @Override // android.widget.TextView
    @Deprecated(message = "Use OTextView individually", replaceWith = @ReplaceWith(expression = "OTextView", imports = {}))
    public void setText(CharSequence r3, TextView.BufferType r4) {
        super.setText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4);
    }
}
