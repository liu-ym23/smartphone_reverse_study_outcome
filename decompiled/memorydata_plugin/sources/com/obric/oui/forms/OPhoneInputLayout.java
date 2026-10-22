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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 22\u00020\u0001:\u00012B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\fJ\n\u0010 \u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\nJ\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0007H\u0016J\u000e\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\fJ\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\fH\u0002J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\fH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputLayout;", "Lcom/obric/oui/forms/OInputLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "areaCode", "", "enableArrowIcon", "", "isChinesePhoneNumber", "isTextFormating", "showAreaCode", "vAreaCodeContainer", "Landroid/widget/LinearLayout;", "vAreaCodeText", "Landroid/widget/TextView;", "vArrowIcon", "Landroid/widget/ImageView;", "doAfterTextStateChange", "", "editable", "Landroid/text/Editable;", "formatChinesePhoneNumber", "getAreaCode", "getConstraintLength", "s", "", "getEnableArrowIcon", "getText", "moveCursorToEnd", "resetFromChinesePhoneNumber", "setAreaClickListener", "listener", "Landroid/view/View$OnClickListener;", "setAreaCode", "setCustomStart", "resId", "setDefaultCustomStart", "defaultStart", "setEnableArrowIcon", "enableArrow", "setType", "type", "shouldApplyChinaMainlandConstraint", "showCustomStart", "show", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OPhoneInputLayout extends OInputLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13879b = null;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f;
    private final LinearLayout g;
    private final TextView h;
    private final ImageView i;
    private boolean j;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputLayout$Companion;", "", "()V", "CHINA_AREA_CODE", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13879b = new a(null);
    }

    public OPhoneInputLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPhoneInputLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OPhoneInputLayout(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r9);
        this.j = true;
        setType(0);
        setCustomStart(ZeusTransformUtils.mapRes(R.layout.o_input_custom_start_area_code, "layout", "o_input_custom_start_area_code"));
        b(true);
        setInputType(3);
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_container, OaidModel.KEY_ID, "o_input_area_code_container"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.o_input_area_code_container)");
        this.g = (LinearLayout) ZeusTransformUtils.preCheckCast(r0, LinearLayout.class, "com.obric.memorydata.plugin");
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_text, OaidModel.KEY_ID, "o_input_area_code_text"));
        Intrinsics.checkNotNullExpressionValue(r1, "findViewById(R.id.o_input_area_code_text)");
        this.h = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.memorydata.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_area_code_arrow, OaidModel.KEY_ID, "o_input_area_code_arrow"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.o_input_area_code_arrow)");
        this.i = (ImageView) ZeusTransformUtils.preCheckCast(r2, ImageView.class, "com.obric.memorydata.plugin");
        TypedArray r12 = r10.getTheme().obtainStyledAttributes(r11, R.styleable.OPhoneInputLayout, r9, 0);
        setAreaCode(r12.getString(ZeusTransformUtils.mapRes(R.styleable.OPhoneInputLayout_oinput_areaCode, "styleable", "OPhoneInputLayout_oinput_areaCode")));
        r12.recycle();
    }

    public /* synthetic */ OPhoneInputLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final void b(Editable r13) {
        Editable r14 = (Editable) ZeusTransformUtils.wrapperContextForParams(r13, Editable.class, "com.obric.memorydata.plugin");
        if (this.d == false) goto L5;
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
        this.d = true;
        r14.replace(0, r14.length(), (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
        if (this.c == true) goto L48;
    L46:
        this.d = false;
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
        b.d("OInputLayout", Intrinsics.stringPlus("Failed to move cursor when formating: ", e.getMessage()));
        goto L46
    }

    private final void c(Editable r9) {
        Editable r10 = (Editable) ZeusTransformUtils.wrapperContextForParams(r9, Editable.class, "com.obric.memorydata.plugin");
        if (this.d == false) goto L5;
        return;
    L5:
        String r0 = r10.toString();
        String r2 = StringsKt.replace$default(r0, " ", "", false, 4, null);
        if (Intrinsics.areEqual(r2, r0) == false) goto L8;
        return;
    L8:
        this.d = true;
        r10.replace(0, r10.length(), (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        this.d = false;
    }

    private final boolean f() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.e == false) goto L13;
        String r2 = this.f;
        if (r2 != null) goto L9;
        String r3 = null;
    L11:
        if (Intrinsics.areEqual(r3, "+86") == false) goto L13;
        return true;
    L9:
        r3 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        goto L11
    }

    private final void g() {
        Editable r0 = getVInput().getText();
        if (r0 != null) goto L5;
        int r1 = 0;
    L11:
        getVInput().setSelection(r1);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        b.d("OInputLayout", Intrinsics.stringPlus("Failed to move cursor to end: ", e.getMessage()));
        return;
    L5:
        r1 = r0.length();
        goto L11
    }

    @Override // com.obric.oui.forms.OInputLayout
    public int a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (this.c == false) goto L8;
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
        if (f() == true) goto L11;
        return r4.length();
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void a(Editable r3) {
        Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
        if (f() == false) goto L12;
        if (r4 != null) goto L6;
        r4 = getVInput().getText();
    L6:
        if (r4 == null) goto L9;
        b(r4);
    L9:
        boolean r5 = true;
    L10:
        this.c = r5;
        return;
    L12:
        if (this.c == false) goto L20;
        if (r4 != null) goto L15;
        r4 = getVInput().getText();
    L15:
        if (r4 == null) goto L18;
        c(r4);
    L18:
        r5 = false;
        goto L10
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void b(boolean r2) {
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        super.b(r2);
        a(getVInput().getText());
    }

    public final String getAreaCode() {
        return this.f;
    }

    public final boolean getEnableArrowIcon() {
        return this.j;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public CharSequence getText() {
        if (this.c == false) goto L14;
        Editable r7 = getVInput().getText();
        String r0 = null;
        if (r7 == null) goto L12;
        String r1 = r7.toString();
        if (r1 == null) goto L12;
        r0 = StringsKt.replace$default(r1, " ", "", false, 4, null);
    L12:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
    L14:
        return super.getText();
    }

    public final void setAreaClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.g.setOnClickListener(r4);
    }

    public final void setAreaCode(String r5) {
        if (r5 == null) goto L10;
        String r0 = this.f;
        if (r0 != null) goto L6;
    L8:
        this.f = r5;
        this.h.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        a(getVInput().getText());
        g();
        return;
    L6:
        if (StringsKt.equals$default(r0, r5, false, 2, null) == false) goto L8;
        return;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setCustomStart(int r3) {
        super.setCustomStart(ZeusTransformUtils.mapRes(R.layout.o_input_custom_start_area_code, "layout", "o_input_custom_start_area_code"));
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setDefaultCustomStart(int r3) {
        super.setCustomStart(ZeusTransformUtils.mapRes(R.layout.o_input_custom_start_area_code, "layout", "o_input_custom_start_area_code"));
    }

    public final void setEnableArrowIcon(boolean r2) {
        if (this.j != r2) goto L5;
        return;
    L5:
        this.j = r2;
        ImageView r1 = this.i;
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

    @Override // com.obric.oui.forms.OInputLayout
    public void setType(int r1) {
        if (r1 == 0) goto L4;
        return;
    L4:
        super.setType(r1);
    }
}
