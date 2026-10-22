package com.obric.oui.radio;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.lynx.tasm.utils.a;
import com.lynx.tasm.utils.d;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "use OCheckBox")
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/radio/ORadio;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "", "checked", "", "setChecked", "(Z)V", "", "style", "setStyle", "(I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ORadio extends AppCompatRadioButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f14266c;
    public int d;

    @JvmOverloads
    public ORadio(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    public final void a() {
        if (this.f14264a == false) goto L6;
        return;
    L6:
        if (this.d != 1) goto L9;
        setButtonDrawable(R$drawable.o_ic_radio_tick_checked);
    L13:
        setChecked(isChecked());
        return;
    L9:
        if (this.f14265b == false) goto L11;
        int r5 = R$drawable.o_radio_round_always_light;
    L12:
        setButtonDrawable(r5);
        goto L13
    L11:
        r5 = R$drawable.o_radio_round;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f14264a == false) goto L6;
        return;
    L6:
        if (this.f14266c == false) goto L9;
        d.n(a.B(44, this), this);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r5) {
        super.setChecked(r5);
        if (this.f14264a == false) goto L6;
        return;
    L6:
        if (this.d != 1) goto L12;
        if (r5 == false) goto L9;
        int r10 = 0;
    L10:
        setVisibility(r10);
        return;
    L9:
        r10 = 4;
        goto L10
    }

    public final void setStyle(int r5) {
        if (this.f14264a == false) goto L5;
        return;
    L5:
        this.d = r5;
        a();
    }

    @JvmOverloads
    public ORadio(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public ORadio(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public ORadio(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14264a = false;
        this.f14266c = true;
        if (r10 == null) goto L12;
        TypedArray r13 = r5.obtainStyledAttributes(r10, R$styleable.ORadio, r11, 0);
        this.f14264a = r13.getBoolean(R$styleable.ORadio_oui_fitOld, false);
        this.d = r13.getInt(R$styleable.ORadio_oui_radioStyle, 0);
        this.f14266c = r13.getBoolean(R$styleable.ORadio_oui_adapt_for_csr, true);
        this.f14265b = r13.getBoolean(R$styleable.ORadio_oui_radioAlwaysLight, false);
        r13.recycle();
    L12:
        if (this.f14264a == true) goto L14;
        a();
        return;
    L14:
        setClickable(true);
    }
}
