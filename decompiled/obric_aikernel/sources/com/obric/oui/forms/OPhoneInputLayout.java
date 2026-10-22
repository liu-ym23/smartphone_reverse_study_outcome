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
import com.bytedance.common.wschannel.WsConstants;
import ea.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputLayout;", "Lcom/obric/oui/forms/OInputLayout;", "", WsConstants.KEY_CONNECTION_TYPE, "", "setType", "resId", "setCustomStart", "defaultStart", "setDefaultCustomStart", "", "getText", "", "s", "setAreaCode", "getAreaCode", "Landroid/view/View$OnClickListener;", "listener", "setAreaClickListener", "", "enableArrow", "setEnableArrowIcon", "getEnableArrowIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"ClickableViewAccessibility"})
public class OPhoneInputLayout extends OInputLayout {
    private boolean E;
    private boolean F;
    private boolean G;
    private String H;
    private final LinearLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final TextView f6684J;
    private final ImageView K;
    private boolean L;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OPhoneInputLayout(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OPhoneInputLayout(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OPhoneInputLayout(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.L = true;
        setType(0);
        setCustomStart(h.o_input_custom_start_area_code);
        r(true);
        setInputType(3);
        View r13 = findViewById(f.o_input_area_code_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.o_input_area_code_container)");
        this.I = (LinearLayout) r13;
        View r14 = findViewById(f.o_input_area_code_text);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.o_input_area_code_text)");
        this.f6684J = (TextView) r14;
        View r15 = findViewById(f.o_input_area_code_arrow);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.o_input_area_code_arrow)");
        this.K = (ImageView) r15;
        TypedArray r16 = r10.getTheme().obtainStyledAttributes(r11, l.OPhoneInputLayout, r12, 0);
        setAreaCode(r16.getString(l.OPhoneInputLayout_oinput_areaCode));
        r16.recycle();
    }

    public /* synthetic */ OPhoneInputLayout(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void F(Editable r11) {
        if (this.F == false) goto L5;
        return;
    L5:
        String r10 = r11.toString();
        StringBuilder r12 = new StringBuilder();
        int r13 = r10.length();
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L11;
        int r15 = r14 + 1;
        char r16 = r10.charAt(r14);
        if (Character.isDigit(r16) == false) goto L10;
        r12.append(r16);
    L10:
        r14 = r15;
        goto L6
    L11:
        String r17 = r12.toString();
        Intrinsics.checkNotNullExpressionValue(r17, "filterTo(StringBuilder(), predicate).toString()");
        StringBuilder r18 = new StringBuilder();
        int r19 = 0;
        int r20 = 0;
    L13:
        if (r19 >= r17.length()) goto L22;
        char r21 = r17.charAt(r19);
        r19 = r19 + 1;
        int r22 = r20 + 1;
        r18.append(r21);
        if (r20 == 2) goto L19;
        if (r20 == 6) goto L19;
    L21:
        r20 = r22;
    L19:
        if (r20 == StringsKt.getLastIndex(r17)) goto L21;
        r18.append(' ');
        goto L21
    L22:
        String r23 = r18.toString();
        Intrinsics.checkNotNullExpressionValue(r23, "StringBuilder().apply(builderAction).toString()");
        if (Intrinsics.areEqual(r23, r10) == false) goto L25;
        return;
    L25:
        this.F = true;
        r11.replace(0, r11.length(), r23);
        if (this.E == true) goto L48;
    L46:
        this.F = false;
        return;
    L48:
        Iterator r110 = CollectionsKt.listOf(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L44
    L29:
        if (r110.hasNext() == false) goto L46;
        int r24 = ((Number) r110.next()).intValue();     // Catch: Exception -> L44
        int r25 = r24 + 1;     // Catch: Exception -> L44
        if (r10.length() < r24) goto L29;
        if (r23.length() < r24) goto L29;
        if (r10.charAt(r24) == ' ') goto L29;
        if (r23.charAt(r24) != ' ') goto L29;
        if (getVInput().getSelectionStart() != r25) goto L29;
        if (getVInput().getSelectionEnd() != r25) goto L29;
        getVInput().setSelection(r25 + 1);     // Catch: Exception -> L44
    L44:
        e = move-exception;
        b.j("OInputLayout", "Failed to move cursor when formating: " + e.getMessage());
        goto L46
    }

    private final void G() {
        Editable r10 = getVInput().getText();
        if (r10 == null) goto L5;
        int r11 = r10.length();
    L11:
        getVInput().setSelection(r11);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        b.j("OInputLayout", "Failed to move cursor to end: " + e.getMessage());
        return;
    L5:
        r11 = 0;
        goto L11
    }

    private final void H(Editable r10) {
        if (this.F == false) goto L5;
        return;
    L5:
        String r11 = r10.toString();
        String r12 = StringsKt.replace$default(r11, " ", "", false, 4, null);
        if (Intrinsics.areEqual(r12, r11) == false) goto L8;
        return;
    L8:
        this.F = true;
        r10.replace(0, r10.length(), r12);
        this.F = false;
    }

    private final boolean I() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.G == false) goto L13;
        String r10 = this.H;
        if (r10 == null) goto L9;
        String r11 = StringsKt.trim(r10).toString();
    L11:
        if (Intrinsics.areEqual(r11, "+86") == false) goto L13;
        return true;
    L9:
        r11 = null;
        goto L11
    }

    public final String getAreaCode() {
        return this.H;
    }

    public final boolean getEnableArrowIcon() {
        return this.L;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public CharSequence getText() {
        if (this.E == false) goto L12;
        Editable r10 = getVInput().getText();
        if (r10 == null) goto L9;
        String r11 = r10.toString();
        if (r11 == null) goto L9;
        return StringsKt.replace$default(r11, " ", "", false, 4, null);
    L9:
        return null;
    L12:
        return super.getText();
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void h(Editable r10) {
        if (I() == false) goto L12;
        if (r10 != null) goto L7;
        r10 = getVInput().getText();
    L7:
        if (r10 == null) goto L9;
        F(r10);
    L9:
        boolean r11 = true;
    L10:
        this.E = r11;
        return;
    L12:
        if (this.E == false) goto L20;
        if (r10 != null) goto L16;
        r10 = getVInput().getText();
    L16:
        if (r10 == null) goto L18;
        H(r10);
    L18:
        r11 = false;
        goto L10
    }

    @Override // com.obric.oui.forms.OInputLayout
    public int j(CharSequence r10) {
        int r11 = 0;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (this.E == false) goto L8;
    L11:
        int r12 = 0;
    L13:
        if (r11 >= r10.length()) goto L23;
        char r13 = r10.charAt(r11);
        r11 = r11 + 1;
        if (Character.isDigit(r13) == false) goto L13;
        r12 = r12 + 1;
        goto L13
    L23:
        return r12;
    L8:
        if (I() == true) goto L11;
        return r10.length();
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void r(boolean r10) {
        if (this.G != r10) goto L5;
        return;
    L5:
        this.G = r10;
        super.r(r10);
        h(getVInput().getText());
    }

    public final void setAreaClickListener(View.OnClickListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.I.setOnClickListener(r10);
    }

    public final void setAreaCode(String r10) {
        if (r10 == null) goto L10;
        String r11 = this.H;
        if (r11 != null) goto L6;
    L8:
        this.H = r10;
        this.f6684J.setText(r10);
        h(getVInput().getText());
        G();
        return;
    L6:
        if (StringsKt.equals$default(r11, r10, false, 2, null) == false) goto L8;
        return;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setCustomStart(int r10) {
        super.setCustomStart(h.o_input_custom_start_area_code);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setDefaultCustomStart(int r10) {
        super.setCustomStart(h.o_input_custom_start_area_code);
    }

    public final void setEnableArrowIcon(boolean r10) {
        if (this.L != r10) goto L5;
        return;
    L5:
        this.L = r10;
        ImageView r11 = this.K;
        if (r11 == null) goto L12;
        if (r10 == false) goto L9;
        float r12 = 1.0f;
    L10:
        r11.setAlpha(r12);
        return;
    L9:
        r12 = 0.3f;
        goto L10
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setType(int r10) {
        if (r10 == 0) goto L4;
        return;
    L4:
        super.setType(r10);
    }
}
