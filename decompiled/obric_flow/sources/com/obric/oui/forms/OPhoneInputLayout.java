package com.obric.oui.forms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputLayout;", "Lcom/obric/oui/forms/OInputLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "type", "", "setType", "(I)V", "resId", "setCustomStart", "defaultStart", "setDefaultCustomStart", "", "getText", "()Ljava/lang/CharSequence;", "", "s", "setAreaCode", "(Ljava/lang/String;)V", "getAreaCode", "()Ljava/lang/String;", "Landroid/view/View$OnClickListener;", "listener", "setAreaClickListener", "(Landroid/view/View$OnClickListener;)V", "", "enableArrow", "setEnableArrowIcon", "(Z)V", "getEnableArrowIcon", "()Z", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class OPhoneInputLayout extends OInputLayout {
    public boolean B;
    public boolean C;
    public boolean D;
    public String E;
    public final LinearLayout F;
    public final TextView G;
    public final ImageView H;
    public boolean I;

    @JvmOverloads
    public OPhoneInputLayout(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public final void a(Editable r11) {
        if (k() == false) goto L56;
        if (r11 != null) goto L6;
        r11 = getVInput().getText();
    L6:
        if (r11 != null) goto L9;
    L54:
        this.B = true;
        return;
    L9:
        if (this.C == true) goto L54;
        String r5 = r11.toString();
        StringBuilder r10 = new StringBuilder();
        int r12 = r5.length();
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L17;
        char r14 = r5.charAt(r13);
        if (Character.isDigit(r14) == false) goto L16;
        r10.append(r14);
    L16:
        r13 = r13 + 1;
        goto L12
    L17:
        String r15 = r10.toString();
        StringBuilder r16 = new StringBuilder();
        int r17 = 0;
        int r18 = 0;
    L19:
        if (r17 >= r15.length()) goto L28;
        int r19 = r18 + 1;
        r16.append(r15.charAt(r17));
        if (r18 == 2) goto L25;
        if (r18 == 6) goto L25;
    L27:
        r17 = r17 + 1;
        r18 = r19;
    L25:
        if (r18 == StringsKt.getLastIndex(r15)) goto L27;
        r16.append(' ');
        goto L27
    L28:
        String r20 = r16.toString();
        if (Intrinsics.areEqual(r20, r5) == true) goto L54;
        this.C = true;
        r11.replace(0, r11.length(), r20);
        if (this.B == true) goto L70;
    L53:
        this.C = false;
        goto L54
    L70:
        Iterator r110 = CollectionsKt.listOf(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L51
    L36:
        if (r110.hasNext() == false) goto L53;
        int r21 = ((Number) r110.next()).intValue();     // Catch: Exception -> L51
        int r22 = r21 + 1;     // Catch: Exception -> L51
        if (r5.length() < r21) goto L36;
        if (r20.length() < r21) goto L36;
        if (r5.charAt(r21) == ' ') goto L36;
        if (r20.charAt(r21) != ' ') goto L36;
        if (getVInput().getSelectionStart() != r22) goto L36;
        if (getVInput().getSelectionEnd() != r22) goto L36;
        getVInput().setSelection(r21 + 2);     // Catch: Exception -> L51
    L51:
        e = move-exception;
        ps.a.g("OInputLayout", Intrinsics.stringPlus("Failed to move cursor when formating: ", e.getMessage()));
        goto L53
    L56:
        if (this.B == false) goto L95;
        if (r11 != null) goto L59;
        r11 = getVInput().getText();
    L59:
        if (r11 != null) goto L62;
    L68:
        this.B = false;
        return;
    L62:
        if (this.C == true) goto L68;
        String r23 = r11.toString();
        String r24 = StringsKt.F(r23, " ", "");
        if (Intrinsics.areEqual(r24, r23) == true) goto L68;
        this.C = true;
        r11.replace(0, r11.length(), r24);
        this.C = false;
        goto L68
    }

    @Override // com.obric.oui.forms.OInputLayout
    public final int b(Editable r5) {
        int r10 = 0;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (this.B == false) goto L8;
    L11:
        int r11 = 0;
    L13:
        if (r10 >= r5.length()) goto L22;
        if (Character.isDigit(r5.charAt(r10)) == false) goto L17;
        r11 = r11 + 1;
    L17:
        r10 = r10 + 1;
        goto L13
    L22:
        return r11;
    L8:
        if (k() == true) goto L11;
        return r5.length();
    }

    @Override // com.obric.oui.forms.OInputLayout
    public final void d(boolean r5) {
        if (this.D != r5) goto L5;
        return;
    L5:
        this.D = r5;
        super.d(r5);
        a(getVInput().getText());
    }

    public final String getAreaCode() {
        return this.E;
    }

    public final boolean getEnableArrowIcon() {
        return this.I;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public CharSequence getText() {
        if (this.B == false) goto L13;
        Editable r5 = getVInput().getText();
        if (r5 == null) goto L14;
        String r10 = r5.toString();
        if (r10 != null) goto L11;
        return null;
    L11:
        return StringsKt.F(r10, " ", "");
    L14:
        return null;
    L13:
        return super.getText();
    }

    public final boolean k() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.D == false) goto L13;
        String r5 = this.E;
        if (r5 != null) goto L9;
        String r10 = null;
    L11:
        if (Intrinsics.areEqual(r10, "+86") == false) goto L13;
        return true;
    L9:
        r10 = StringsKt.trim(r5).toString();
        goto L11
    }

    public final void setAreaClickListener(View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.F.setOnClickListener(r5);
    }

    public final void setAreaCode(String r5) {
        if (r5 == null) goto L19;
        String r10 = this.E;
        if (r10 != null) goto L6;
    L8:
        this.E = r5;
        this.G.setText(r5);
        a(getVInput().getText());
        Editable r11 = getVInput().getText();
        if (r11 != null) goto L11;
        int r12 = 0;
    L17:
        getVInput().setSelection(r12);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        ps.a.g("OInputLayout", Intrinsics.stringPlus("Failed to move cursor to end: ", e.getMessage()));
        return;
    L11:
        r12 = r11.length();
        goto L17
    L6:
        if (StringsKt.m(r10, r5) == false) goto L8;
        return;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setCustomStart(int r5) {
        super.setCustomStart(R$layout.o_input_custom_start_area_code);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setDefaultCustomStart(int r5) {
        super.setCustomStart(R$layout.o_input_custom_start_area_code);
    }

    public final void setEnableArrowIcon(boolean r5) {
        if (this.I != r5) goto L5;
        return;
    L5:
        this.I = r5;
        ImageView r10 = this.H;
        if (r10 == null) goto L12;
        if (r5 == false) goto L9;
        float r11 = 1.0f;
    L10:
        r10.setAlpha(r11);
        return;
    L9:
        r11 = 0.3f;
        goto L10
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setType(int r5) {
        if (r5 == 0) goto L4;
        return;
    L4:
        super.setType(r5);
    }

    @JvmOverloads
    public OPhoneInputLayout(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OPhoneInputLayout(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OPhoneInputLayout(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.I = true;
        setType(0);
        setCustomStart(R$layout.o_input_custom_start_area_code);
        d(true);
        setInputType(3);
        this.F = (LinearLayout) findViewById(R$id.o_input_area_code_container);
        this.G = (TextView) findViewById(R$id.o_input_area_code_text);
        this.H = (ImageView) findViewById(R$id.o_input_area_code_arrow);
        TypedArray r12 = r5.getTheme().obtainStyledAttributes(r10, R$styleable.OPhoneInputLayout, r11, 0);
        setAreaCode(r12.getString(R$styleable.OPhoneInputLayout_oinput_areaCode));
        r12.recycle();
    }
}
