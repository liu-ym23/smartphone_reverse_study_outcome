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
import cn.nubia.neopush.commons.Constant;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001a\u0010\u000eJ\u0015\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0013¢\u0006\u0004\b \u0010\u0016J\r\u0010!\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputView;", "Lcom/obric/oui/forms/OInputView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getContentViewRes", "()I", "", "getText", "()Ljava/lang/String;", "limit", "", "setLimitCount", "(I)V", "", Constant.ClientMessageType.SHOW, "setShowAreaCode", "(Z)V", "s", "setAreaCode", "(Ljava/lang/String;)V", "getAreaCode", "Landroid/view/View$OnClickListener;", "listener", "setAreaClickListener", "(Landroid/view/View$OnClickListener;)V", "enableArrow", "setEnableArrowIcon", "getEnableArrowIcon", "()Z", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public final class OPhoneInputView extends OInputView {
    public int g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f13314h0;
    public boolean i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f13315j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f13316k0;
    public final LinearLayout l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final TextView f13317m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final ImageView f13318n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f13319o0;

    @JvmOverloads
    public OPhoneInputView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final String getAreaCode() {
        return this.f13316k0;
    }

    @Override // com.obric.oui.forms.OInputView
    public int getContentViewRes() {
        return R$layout.o_phone_input_view_layout;
    }

    public final boolean getEnableArrowIcon() {
        return this.f13319o0;
    }

    @Override // com.obric.oui.forms.OInputView
    public String getText() {
        if (this.f13314h0 == false) goto L13;
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

    @Override // com.obric.oui.forms.OInputView
    public final void o(Editable r11) {
        if (y() == false) goto L57;
        setLimitCountValue(11);
        if (r11 != null) goto L7;
        r11 = getVInput().getText();
    L7:
        if (r11 != null) goto L10;
    L55:
        this.f13314h0 = true;
        this.g0 = getLimitCount();
    L70:
        Editable r12 = getVInput().getText();
        if (r12 != null) goto L73;
        String r13 = null;
    L74:
        x(r13);
        return;
    L73:
        r13 = r12.toString();
        goto L74
    L10:
        if (this.i0 == true) goto L55;
        String r5 = r11.toString();
        StringBuilder r10 = new StringBuilder();
        int r14 = r5.length();
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L18;
        char r16 = r5.charAt(r15);
        if (Character.isDigit(r16) == false) goto L17;
        r10.append(r16);
    L17:
        r15 = r15 + 1;
        goto L13
    L18:
        String r17 = r10.toString();
        StringBuilder r18 = new StringBuilder();
        int r19 = 0;
        int r20 = 0;
    L20:
        if (r19 >= r17.length()) goto L29;
        int r21 = r20 + 1;
        r18.append(r17.charAt(r19));
        if (r20 == 2) goto L26;
        if (r20 == 6) goto L26;
    L28:
        r19 = r19 + 1;
        r20 = r21;
    L26:
        if (r20 == StringsKt.getLastIndex(r17)) goto L28;
        r18.append(' ');
        goto L28
    L29:
        String r22 = r18.toString();
        if (Intrinsics.areEqual(r22, r5) == true) goto L55;
        this.i0 = true;
        r11.replace(0, r11.length(), r22);
        if (this.f13314h0 == true) goto L76;
    L54:
        this.i0 = false;
        goto L55
    L76:
        Iterator r110 = CollectionsKt.listOf(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L52
    L37:
        if (r110.hasNext() == false) goto L54;
        int r23 = ((Number) r110.next()).intValue();     // Catch: Exception -> L52
        int r24 = r23 + 1;     // Catch: Exception -> L52
        if (r5.length() < r23) goto L37;
        if (r22.length() < r23) goto L37;
        if (r5.charAt(r23) == ' ') goto L37;
        if (r22.charAt(r23) != ' ') goto L37;
        if (getVInput().getSelectionStart() != r24) goto L37;
        if (getVInput().getSelectionEnd() != r24) goto L37;
        getVInput().setSelection(r23 + 2);     // Catch: Exception -> L52
    L52:
        e = move-exception;
        ps.a.g("OInputView", Intrinsics.stringPlus("Failed to move cursor when formating: ", e.getMessage()));
        goto L54
    L57:
        if (this.f13314h0 == false) goto L70;
        if (r11 != null) goto L60;
        r11 = getVInput().getText();
    L60:
        if (r11 != null) goto L63;
    L69:
        this.f13314h0 = false;
        setLimitCountValue(this.g0);
        goto L70
    L63:
        if (this.i0 == true) goto L69;
        String r25 = r11.toString();
        String r26 = StringsKt.F(r25, " ", "");
        if (Intrinsics.areEqual(r26, r25) == true) goto L69;
        this.i0 = true;
        r11.replace(0, r11.length(), r26);
        this.i0 = false;
        goto L69
    }

    @Override // com.obric.oui.forms.OInputView
    public final int p(CharSequence r5) {
        int r10 = 0;
        if (r5 != null) goto L6;
        return 0;
    L6:
        if (this.f13314h0 == false) goto L8;
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
        if (y() == true) goto L11;
        return r5.length();
    }

    public final void setAreaClickListener(View.OnClickListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.l0.setOnClickListener(r5);
    }

    public final void setAreaCode(String r5) {
        if (r5 == null) goto L19;
        String r10 = this.f13316k0;
        if (r10 != null) goto L6;
    L8:
        this.f13316k0 = r5;
        this.f13317m0.setText(r5);
        o(getVInput().getText());
        Editable r11 = getVInput().getText();
        if (r11 != null) goto L11;
        int r12 = 0;
    L17:
        getVInput().setSelection(r12);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        ps.a.g("OInputView", Intrinsics.stringPlus("Failed to move cursor to end: ", e.getMessage()));
        return;
    L11:
        r12 = r11.length();
        goto L17
    L6:
        if (StringsKt.m(r10, r5) == false) goto L8;
        return;
    }

    public final void setEnableArrowIcon(boolean r5) {
        if (this.f13319o0 != r5) goto L5;
        return;
    L5:
        this.f13319o0 = r5;
        ImageView r10 = this.f13318n0;
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

    @Override // com.obric.oui.forms.OInputView
    public void setLimitCount(int r5) {
        this.g0 = r5;
        if (this.f13314h0 == false) goto L5;
        r5 = 11;
    L5:
        super.setLimitCount(r5);
    }

    public final void setShowAreaCode(boolean r5) {
        if (getInputType() == 3) goto L6;
        return;
    L6:
        if (this.f13315j0 != r5) goto L8;
        return;
    L8:
        this.f13315j0 = r5;
        com.lynx.tasm.utils.d.x(this.l0, r5);
        o(getVInput().getText());
    }

    public final boolean y() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.f13315j0 == false) goto L13;
        String r5 = this.f13316k0;
        if (r5 != null) goto L9;
        String r10 = null;
    L11:
        if (Intrinsics.areEqual(r10, "+86") == false) goto L13;
        return true;
    L9:
        r10 = StringsKt.trim(r5).toString();
        goto L11
    }

    @JvmOverloads
    public OPhoneInputView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OPhoneInputView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OPhoneInputView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.g0 = -1;
        this.f13319o0 = true;
        this.g0 = getLimitCount();
        this.l0 = (LinearLayout) findViewById(R$id.o_input_area_code_container);
        this.f13317m0 = (TextView) findViewById(R$id.o_input_area_code_text);
        this.f13318n0 = (ImageView) findViewById(R$id.o_input_area_code_arrow);
        TypedArray r12 = r5.getTheme().obtainStyledAttributes(r10, R$styleable.OPhoneInputView, r11, 0);
        setShowAreaCode(r12.getBoolean(R$styleable.OPhoneInputView_oui_showAreaCode, false));
        setAreaCode(r12.getString(R$styleable.OPhoneInputView_oui_areaCode));
        r12.recycle();
    }
}
