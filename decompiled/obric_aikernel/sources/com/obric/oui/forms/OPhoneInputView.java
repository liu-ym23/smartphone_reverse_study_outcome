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
import com.obric.oui.common.util.k;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 72\u00020\u0001:\u00018B'\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u00104\u001a\u00020\n¢\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00069"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputView;", "Lcom/obric/oui/forms/OInputView;", "", "shouldApplyChinaMainlandConstraint", "", "moveCursorToEnd", "Landroid/text/Editable;", "editable", "formatChinesePhoneNumber", "resetFromChinesePhoneNumber", "", "getContentViewRes", "", "getText", "limit", "setLimitCount", "show", "setShowAreaCode", "s", "setAreaCode", "getAreaCode", "Landroid/view/View$OnClickListener;", "listener", "setAreaClickListener", "", "getConstraintLength", "doAfterTextStateChange", "enableArrow", "setEnableArrowIcon", "getEnableArrowIcon", "isTextFormating", "Z", "showAreaCode", "isChinesePhoneNumber", "Landroid/widget/ImageView;", "vArrowIcon", "Landroid/widget/ImageView;", "enableArrowIcon", "Landroid/widget/TextView;", "vAreaCodeText", "Landroid/widget/TextView;", "areaCode", "Ljava/lang/String;", "originLimitCount", "I", "Landroid/widget/LinearLayout;", "vAreaCodeContainer", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"ClickableViewAccessibility"})
public final class OPhoneInputView extends OInputView {
    private static final String CHINA_AREA_CODE = "+86";
    private static final int CHINA_COUNT_LIMIT = 11;
    public static final a Companion = null;
    private String areaCode;
    private boolean enableArrowIcon;
    private boolean isChinesePhoneNumber;
    private boolean isTextFormating;
    private int originLimitCount;
    private boolean showAreaCode;
    private final LinearLayout vAreaCodeContainer;
    private final TextView vAreaCodeText;
    private final ImageView vArrowIcon;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    @JvmOverloads
    public OPhoneInputView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OPhoneInputView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OPhoneInputView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.originLimitCount = -1;
        this.enableArrowIcon = true;
        this.originLimitCount = getLimitCount();
        View r13 = findViewById(f.o_input_area_code_container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.o_input_area_code_container)");
        this.vAreaCodeContainer = (LinearLayout) r13;
        View r14 = findViewById(f.o_input_area_code_text);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.o_input_area_code_text)");
        this.vAreaCodeText = (TextView) r14;
        View r15 = findViewById(f.o_input_area_code_arrow);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.o_input_area_code_arrow)");
        this.vArrowIcon = (ImageView) r15;
        TypedArray r16 = r10.getTheme().obtainStyledAttributes(r11, l.OPhoneInputView, r12, 0);
        setShowAreaCode(r16.getBoolean(l.OPhoneInputView_oui_showAreaCode, false));
        setAreaCode(r16.getString(l.OPhoneInputView_oui_areaCode));
        r16.recycle();
    }

    public /* synthetic */ OPhoneInputView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void formatChinesePhoneNumber(Editable r11) {
        if (this.isTextFormating == false) goto L5;
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
        this.isTextFormating = true;
        r11.replace(0, r11.length(), r23);
        if (this.isChinesePhoneNumber == true) goto L48;
    L46:
        this.isTextFormating = false;
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
        b.j(OInputView.TAG, "Failed to move cursor when formating: " + e.getMessage());
        goto L46
    }

    private final void moveCursorToEnd() {
        Editable r10 = getVInput().getText();
        if (r10 == null) goto L5;
        int r11 = r10.length();
    L11:
        getVInput().setSelection(r11);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        b.j(OInputView.TAG, "Failed to move cursor to end: " + e.getMessage());
        return;
    L5:
        r11 = 0;
        goto L11
    }

    private final void resetFromChinesePhoneNumber(Editable r10) {
        if (this.isTextFormating == false) goto L5;
        return;
    L5:
        String r11 = r10.toString();
        String r12 = StringsKt.replace$default(r11, " ", "", false, 4, null);
        if (Intrinsics.areEqual(r12, r11) == false) goto L8;
        return;
    L8:
        this.isTextFormating = true;
        r10.replace(0, r10.length(), r12);
        this.isTextFormating = false;
    }

    private final boolean shouldApplyChinaMainlandConstraint() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.showAreaCode == false) goto L13;
        String r10 = this.areaCode;
        if (r10 == null) goto L9;
        String r11 = StringsKt.trim(r10).toString();
    L11:
        if (Intrinsics.areEqual(r11, CHINA_AREA_CODE) == false) goto L13;
        return true;
    L9:
        r11 = null;
        goto L11
    }

    @Override // com.obric.oui.forms.OInputView
    public void doAfterTextStateChange(Editable r10) {
        if (shouldApplyChinaMainlandConstraint() == false) goto L12;
        setLimitCountValue(11);
        if (r10 != null) goto L8;
        r10 = getVInput().getText();
    L8:
        if (r10 == null) goto L10;
        formatChinesePhoneNumber(r10);
    L10:
        this.isChinesePhoneNumber = true;
        this.originLimitCount = getLimitCount();
    L19:
        Editable r11 = getVInput().getText();
        if (r11 == null) goto L22;
        String r12 = r11.toString();
    L23:
        updateLimitIndicator(r12);
        return;
    L22:
        r12 = null;
        goto L23
    L12:
        if (this.isChinesePhoneNumber == false) goto L19;
        if (r10 != null) goto L16;
        r10 = getVInput().getText();
    L16:
        if (r10 == null) goto L18;
        resetFromChinesePhoneNumber(r10);
    L18:
        this.isChinesePhoneNumber = false;
        setLimitCountValue(this.originLimitCount);
        goto L19
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    @Override // com.obric.oui.forms.OInputView
    public int getConstraintLength(CharSequence r10) {
        int r11 = 0;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (this.isChinesePhoneNumber == false) goto L8;
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
        if (shouldApplyChinaMainlandConstraint() == true) goto L11;
        return r10.length();
    }

    @Override // com.obric.oui.forms.OInputView
    public int getContentViewRes() {
        return h.o_phone_input_view_layout;
    }

    public final boolean getEnableArrowIcon() {
        return this.enableArrowIcon;
    }

    @Override // com.obric.oui.forms.OInputView
    public String getText() {
        if (this.isChinesePhoneNumber == false) goto L12;
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

    public final void setAreaClickListener(View.OnClickListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.vAreaCodeContainer.setOnClickListener(r10);
    }

    public final void setAreaCode(String r10) {
        if (r10 == null) goto L10;
        String r11 = this.areaCode;
        if (r11 != null) goto L6;
    L8:
        this.areaCode = r10;
        this.vAreaCodeText.setText(r10);
        doAfterTextStateChange(getVInput().getText());
        moveCursorToEnd();
        return;
    L6:
        if (StringsKt.equals$default(r11, r10, false, 2, null) == false) goto L8;
        return;
    }

    public final void setEnableArrowIcon(boolean r10) {
        if (this.enableArrowIcon != r10) goto L5;
        return;
    L5:
        this.enableArrowIcon = r10;
        ImageView r11 = this.vArrowIcon;
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

    @Override // com.obric.oui.forms.OInputView
    public void setLimitCount(int r10) {
        this.originLimitCount = r10;
        if (this.isChinesePhoneNumber == false) goto L5;
        r10 = 11;
    L5:
        super.setLimitCount(r10);
    }

    public final void setShowAreaCode(boolean r10) {
        if (getInputType() == 3) goto L6;
        return;
    L6:
        if (this.showAreaCode != r10) goto L8;
        return;
    L8:
        this.showAreaCode = r10;
        k.k(this.vAreaCodeContainer, r10);
        doAfterTextStateChange(getVInput().getText());
    }
}
