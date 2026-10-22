package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.a.b;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0006\u0010!\u001a\u00020\fJ\n\u0010\"\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010#\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\nJ\u000e\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\fJ\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0007H\u0016J\u000e\u0010-\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\fJ\b\u0010/\u001a\u00020\fH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputView;", "Lcom/obric/oui/forms/OInputView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "areaCode", "", "enableArrowIcon", "", "isChinesePhoneNumber", "isTextFormating", "originLimitCount", "showAreaCode", "vAreaCodeContainer", "Landroid/widget/LinearLayout;", "vAreaCodeText", "Landroid/widget/TextView;", "vArrowIcon", "Landroid/widget/ImageView;", "doAfterTextStateChange", "", "editable", "Landroid/text/Editable;", "formatChinesePhoneNumber", "getAreaCode", "getConstraintLength", "s", "", "getContentViewRes", "getEnableArrowIcon", "getText", "moveCursorToEnd", "resetFromChinesePhoneNumber", "setAreaClickListener", "listener", "Landroid/view/View$OnClickListener;", "setAreaCode", "setEnableArrowIcon", "enableArrow", "setLimitCount", "limit", "setShowAreaCode", "show", "shouldApplyChinaMainlandConstraint", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputView$Companion;", "", "()V", "CHINA_AREA_CODE", "", "CHINA_COUNT_LIMIT", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public OPhoneInputView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPhoneInputView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OPhoneInputView(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r7);
        this.originLimitCount = -1;
        this.enableArrowIcon = true;
        this.originLimitCount = getLimitCount();
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_container, OaidModel.KEY_ID, "o_input_area_code_container"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.o_input_area_code_container)");
        this.vAreaCodeContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r0, LinearLayout.class, "com.obric.memorydata.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_text, OaidModel.KEY_ID, "o_input_area_code_text"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.o_input_area_code_text)");
        this.vAreaCodeText = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_arrow, OaidModel.KEY_ID, "o_input_area_code_arrow"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.o_input_area_code_arrow)");
        this.vArrowIcon = (ImageView) ZeusTransformUtils.preCheckCast(r2, ImageView.class, "com.obric.memorydata.plugin");
        TypedArray r10 = r8.getTheme().obtainStyledAttributes(r9, R.styleable.OPhoneInputView, r7, 0);
        setShowAreaCode(r10.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OPhoneInputView_oui_showAreaCode, "styleable", "OPhoneInputView_oui_showAreaCode"), false));
        setAreaCode(r10.getString(ZeusTransformUtils.mapRes(R.styleable.OPhoneInputView_oui_areaCode, "styleable", "OPhoneInputView_oui_areaCode")));
        r10.recycle();
    }

    public /* synthetic */ OPhoneInputView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void formatChinesePhoneNumber(Editable r13) {
        Editable r14 = (Editable) ZeusTransformUtils.wrapperContextForParams(r13, Editable.class, "com.obric.memorydata.plugin");
        if (this.isTextFormating == false) goto L5;
        return;
    L5:
        String r0 = r14.toString();
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        Appendable r3 = (Appendable) ZeusTransformUtils.preCheckCast(new StringBuilder(), Appendable.class, "com.obric.memorydata.plugin");
        int r4 = r2.length();
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L11;
        char r7 = r2.charAt(r6);
        if (Character.isDigit(r7) == false) goto L10;
        r3.append(r7);
    L10:
        r6 = r6 + 1;
        goto L6
    L11:
        String r5 = ((StringBuilder) ZeusTransformUtils.preCheckCast(r3, StringBuilder.class, "com.obric.memorydata.plugin")).toString();
        Intrinsics.checkNotNullExpressionValue(r5, "filterTo(StringBuilder(), predicate).toString()");
        StringBuilder r8 = new StringBuilder();
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r10 = 0;
        int r11 = 0;
    L13:
        if (r10 >= r9.length()) goto L22;
        int r12 = r11 + 1;
        r8.append(r9.charAt(r10));
        if (r11 == 2) goto L19;
        if (r11 == 6) goto L19;
    L21:
        r10 = r10 + 1;
        r11 = r12;
    L19:
        if (r11 == StringsKt.getLastIndex((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) goto L21;
        r8.append(' ');
        goto L21
    L22:
        String r15 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
        if (Intrinsics.areEqual(r15, r0) == false) goto L25;
        return;
    L25:
        this.isTextFormating = true;
        r14.replace(0, r14.length(), (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
        if (this.isChinesePhoneNumber == true) goto L48;
    L46:
        this.isTextFormating = false;
        return;
    L48:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Integer[]{3, 8}), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L44
    L29:
        if (r16.hasNext() == false) goto L46;
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r16.next(), Number.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Exception -> L44
        int r18 = r17 + 1;     // Catch: Exception -> L44
        if (r0.length() < r17) goto L29;
        if (r15.length() < r17) goto L29;
        if (r0.charAt(r17) == ' ') goto L29;
        if (r15.charAt(r17) != ' ') goto L29;
        if (getVInput().getSelectionStart() != r18) goto L29;
        if (getVInput().getSelectionEnd() != r18) goto L29;
        getVInput().setSelection(r18 + 1);     // Catch: Exception -> L44
    L44:
        e = move-exception;
        b.d(OInputView.TAG, Intrinsics.stringPlus("Failed to move cursor when formating: ", e.getMessage()));
        goto L46
    }

    private final void moveCursorToEnd() {
        Editable r0 = getVInput().getText();
        if (r0 != null) goto L5;
        int r1 = 0;
    L11:
        getVInput().setSelection(r1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        b.d(OInputView.TAG, Intrinsics.stringPlus("Failed to move cursor to end: ", e.getMessage()));
        return;
    L5:
        r1 = r0.length();
        goto L11
    }

    private final void resetFromChinesePhoneNumber(Editable r9) {
        Editable r10 = (Editable) ZeusTransformUtils.wrapperContextForParams(r9, Editable.class, "com.obric.memorydata.plugin");
        if (this.isTextFormating == false) goto L5;
        return;
    L5:
        String r0 = r10.toString();
        String r2 = StringsKt.replace$default(r0, " ", "", false, 4, null);
        if (Intrinsics.areEqual(r2, r0) == false) goto L8;
        return;
    L8:
        this.isTextFormating = true;
        r10.replace(0, r10.length(), (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        this.isTextFormating = false;
    }

    private final boolean shouldApplyChinaMainlandConstraint() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.showAreaCode == false) goto L13;
        String r2 = this.areaCode;
        if (r2 != null) goto L9;
        String r3 = null;
    L11:
        if (Intrinsics.areEqual(r3, CHINA_AREA_CODE) == false) goto L13;
        return true;
    L9:
        r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        goto L11
    }

    @Override // com.obric.oui.forms.OInputView
    public void doAfterTextStateChange(Editable r3) {
        Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
        if (shouldApplyChinaMainlandConstraint() == false) goto L12;
        setLimitCountValue(11);
        if (r4 != null) goto L7;
        r4 = getVInput().getText();
    L7:
        if (r4 == null) goto L10;
        formatChinesePhoneNumber(r4);
    L10:
        this.isChinesePhoneNumber = true;
        this.originLimitCount = getLimitCount();
    L19:
        Editable r5 = getVInput().getText();
        if (r5 != null) goto L22;
        String r6 = null;
    L23:
        updateLimitIndicator(r6);
        return;
    L22:
        r6 = r5.toString();
        goto L23
    L12:
        if (this.isChinesePhoneNumber == false) goto L19;
        if (r4 != null) goto L15;
        r4 = getVInput().getText();
    L15:
        if (r4 == null) goto L18;
        resetFromChinesePhoneNumber(r4);
    L18:
        this.isChinesePhoneNumber = false;
        setLimitCountValue(this.originLimitCount);
        goto L19
    }

    public final String getAreaCode() {
        return this.areaCode;
    }

    @Override // com.obric.oui.forms.OInputView
    public int getConstraintLength(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (this.isChinesePhoneNumber == false) goto L8;
    L11:
        int r2 = 0;
    L13:
        if (r0 >= r4.length()) goto L22;
        if (Character.isDigit(r4.charAt(r0)) == false) goto L17;
        r2 = r2 + 1;
    L17:
        r0 = r0 + 1;
        goto L13
    L22:
        return r2;
    L8:
        if (shouldApplyChinaMainlandConstraint() == true) goto L11;
        return r4.length();
    }

    @Override // com.obric.oui.forms.OInputView
    public int getContentViewRes() {
        return ZeusTransformUtils.mapRes(R.layout.o_phone_input_view_layout, "layout", "o_phone_input_view_layout");
    }

    public final boolean getEnableArrowIcon() {
        return this.enableArrowIcon;
    }

    @Override // com.obric.oui.forms.OInputView
    public String getText() {
        if (this.isChinesePhoneNumber == false) goto L13;
        Editable r7 = getVInput().getText();
        if (r7 == null) goto L14;
        String r1 = r7.toString();
        if (r1 != null) goto L11;
        return null;
    L11:
        return StringsKt.replace$default(r1, " ", "", false, 4, null);
    L14:
        return null;
    L13:
        return super.getText();
    }

    public final void setAreaClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.vAreaCodeContainer.setOnClickListener(r4);
    }

    public final void setAreaCode(String r5) {
        if (r5 == null) goto L10;
        String r0 = this.areaCode;
        if (r0 != null) goto L6;
    L8:
        this.areaCode = r5;
        this.vAreaCodeText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        doAfterTextStateChange(getVInput().getText());
        moveCursorToEnd();
        return;
    L6:
        if (StringsKt.equals$default(r0, r5, false, 2, null) == false) goto L8;
        return;
    }

    public final void setEnableArrowIcon(boolean r2) {
        if (this.enableArrowIcon != r2) goto L5;
        return;
    L5:
        this.enableArrowIcon = r2;
        ImageView r1 = this.vArrowIcon;
        if (r1 == null) goto L12;
        if (r2 == false) goto L9;
        float r3 = 1.0f;
    L10:
        r1.setAlpha(r3);
        return;
    L9:
        r3 = 0.3f;
        goto L10
    }

    @Override // com.obric.oui.forms.OInputView
    public void setLimitCount(int r2) {
        this.originLimitCount = r2;
        if (this.isChinesePhoneNumber == false) goto L5;
        r2 = 11;
    L5:
        super.setLimitCount(r2);
    }

    public final void setShowAreaCode(boolean r4) {
        if (getInputType() == 3) goto L6;
        return;
    L6:
        if (this.showAreaCode != r4) goto L8;
        return;
    L8:
        this.showAreaCode = r4;
        o.a((View) ZeusTransformUtils.preCheckCast(this.vAreaCodeContainer, View.class, "com.obric.memorydata.plugin"), r4);
        doAfterTextStateChange(getVInput().getText());
    }
}
