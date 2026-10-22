package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010-\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010#R\u0017\u00100\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b.\u0010!\u001a\u0004\b/\u0010#R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u0010<\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010?\u001a\u0002078\u0006¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;R\"\u0010D\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u00109\u001a\u0004\bA\u0010;\"\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView;", "Lcom/obric/oui/forms/AbsOForm;", "", "getText", "()Ljava/lang/String;", MessageIndication.CONTENT_TYPE_TEXT, "", "setText", "(Ljava/lang/String;)V", "Lcom/obric/oui/forms/a;", "getConfig", "()Lcom/obric/oui/forms/a;", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Landroid/view/View;", "view", "setPrefixView", "(Landroid/view/View;)V", "", "k", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "arrangeDirection", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Landroidx/appcompat/widget/AppCompatEditText;", "m", "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "editText", "n", "getTvErrorTips", "tvErrorTips", "o", "getTvCounter", "tvCounter", "Landroid/widget/ImageView;", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "Landroid/widget/ImageView;", "getIvTitleIcon", "()Landroid/widget/ImageView;", "ivTitleIcon", "Landroid/view/ViewGroup;", "q", "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "inputContainer", "r", "getPrefixContainer", "prefixContainer", "s", "getTitleContainer", "setTitleContainer", "(Landroid/view/ViewGroup;)V", "titleContainer", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBoxInputView extends AbsOForm {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f13234v = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13235k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f13236l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AppCompatEditText f13237m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f13238n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f13239o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f13240p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ViewGroup f13241q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ViewGroup f13242r;
    public ViewGroup s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a f13243t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f13244u;

    @JvmOverloads
    public OBoxInputView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0, 14, 0);
    }

    public static final void e(OBoxInputView r5) {
        AppCompatEditText r10 = r5.f13237m;
        int r11 = r10.getLineCount();
        int r12 = r10.getLineHeight();
        int r13 = r10.getHeight();
        ViewGroup r14 = r5.f13241q;
        int r15 = r14.getHeight();
        int r16 = ((r11 * r12) + r15) - r13;
        a r17 = r5.f13243t;
        if (r16 >= r17.f13323h) goto L5;
    L8:
        ViewGroup.LayoutParams r18 = r14.getLayoutParams();
        r18.height = r15;
        r14.setLayoutParams(r18);
        return;
    L5:
        if (r16 >= r17.f13324i) goto L8;
        r15 = r16;
        goto L8
    }

    private final void setPrefixView(View r5) {
        if (r5 == null) goto L5;
        ViewGroup r10 = this.f13242r;
        r10.removeAllViews();
        r10.addView(r5, new ConstraintLayout.LayoutParams(-2, -2));
        return;
    }

    public final int getArrangeDirection() {
        return this.f13235k;
    }

    public final a getConfig() {
        return this.f13243t;
    }

    public final AppCompatEditText getEditText() {
        return this.f13237m;
    }

    public final ViewGroup getInputContainer() {
        return this.f13241q;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.f13237m;
    }

    public final ImageView getIvTitleIcon() {
        return this.f13240p;
    }

    public final ViewGroup getPrefixContainer() {
        return this.f13242r;
    }

    public final String getText() {
        return String.valueOf(this.f13237m.getText());
    }

    public final ViewGroup getTitleContainer() {
        return this.s;
    }

    public final TextView getTvCounter() {
        return this.f13239o;
    }

    public final TextView getTvErrorTips() {
        return this.f13238n;
    }

    public final TextView getTvTitle() {
        return this.f13236l;
    }

    public final void setArrangeDirection(int r5) {
        this.f13235k = r5;
    }

    public final void setText(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() == 0) goto L12;
        this.f13237m.setText(r5);
        c r10 = this.f13244u;
        if (r10 == null) goto L13;
        Intrinsics.checkNotNull(r5);
        r10.onTextChanged(r5, 0, 0, r5.length());
        return;
    L13:
        return;
    }

    public final void setTextWatcher(TextWatcher r5) {
        Intrinsics.checkNotNullParameter(r5, "textWatcher");
        Iterator<WeakReference<TextWatcher>> r10 = getTextWatchers().iterator();
    L3:
        boolean r11 = r10.hasNext();
        AppCompatEditText r12 = this.f13237m;
        if (r11 == false) goto L6;
        r12.removeTextChangedListener(r10.next().get());
        goto L3
    L6:
        getTextWatchers().add(new WeakReference(r5));
        r12.addTextChangedListener(r5);
    }

    public final void setTitleContainer(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.s = r5;
    }

    @JvmOverloads
    public OBoxInputView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, 12, 0);
    }

    @JvmOverloads
    public OBoxInputView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, 8, 0);
    }

    public OBoxInputView(Context r10, AttributeSet r11, int r12, int r13, int r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f13235k = 1;
        a r15 = new a();
        r15.f13320a = false;
        r15.f13321b = null;
        r15.f13322c = false;
        r15.d = null;
        r15.e = null;
        r15.f = null;
        r15.g = null;
        r15.f13323h = 144;
        r15.f13324i = Integer.MAX_VALUE;
        r15.f13325j = false;
        r15.f13326k = null;
        this.f13243t = r15;
        TypedArray r16 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OBoxInputView, 0, 0);
        setArrangeDirection(r16.getInt(R$styleable.OBoxInputView_oui_formArrangeDirection, 1));     // Catch: Throwable -> L12
        this.f13243t.e = r16.getString(R$styleable.OBoxInputView_android_hint);     // Catch: Throwable -> L12
        this.f13243t.f13322c = r16.getBoolean(R$styleable.OBoxInputView_oui_formShowCounter, false);     // Catch: Throwable -> L12
        int r17 = r16.getInt(R$styleable.OBoxInputView_oui_formLengthLimit, 0);     // Catch: Throwable -> L12
        if (r17 <= 0) goto L14;
        a r5 = this.f13243t;     // Catch: Throwable -> L12
        r5.d = Integer.valueOf(r17);     // Catch: Throwable -> L12
    L14:
        String r18 = r16.getString(R$styleable.OBoxInputView_oui_formTitle);     // Catch: Throwable -> L12
        if (r18 != null) goto L17;
    L20:
        this.f13243t.f13321b = "标题";     // Catch: Throwable -> L12
    L21:
        a r19 = this.f13243t;     // Catch: Throwable -> L12
        r19.f13323h = r16.getDimensionPixelSize(R$styleable.OBoxInputView_oui_formInputHeight, com.lynx.tasm.utils.a.p(144, r10));     // Catch: Throwable -> L12
        a r110 = this.f13243t;     // Catch: Throwable -> L12
        r110.f13324i = r16.getDimensionPixelSize(R$styleable.OBoxInputView_oui_formInputMaxHeight, Integer.MAX_VALUE);     // Catch: Throwable -> L12
        String r111 = r16.getString(R$styleable.OBoxInputView_android_text);     // Catch: Throwable -> L12
        boolean r20 = r16.getBoolean(R$styleable.OBoxInputView_oui_formShowTitleDefaultIcon, false);     // Catch: Throwable -> L12
        a r21 = this.f13243t;     // Catch: Throwable -> L12
        r21.f13325j = r16.getBoolean(R$styleable.OBoxInputView_oui_formAutoAdjustHeight, false);     // Catch: Throwable -> L12
        int r22 = r16.getInt(R$styleable.OBoxInputView_android_gravity, 48);     // Catch: Throwable -> L12
        r16.recycle();
        if (this.f13235k != 1) goto L25;
        int r23 = R$layout.o_form_box_horizontal;
    L26:
        LayoutInflater.from(r10).inflate(r23, this);
        TextView r24 = (TextView) findViewById(R$id.tv_title);
        this.f13236l = r24;
        ImageView r25 = (ImageView) findViewById(R$id.iv_title_icon);
        this.f13240p = r25;
        this.f13242r = (ViewGroup) findViewById(R$id.prefix_container);
        AppCompatEditText r26 = (AppCompatEditText) findViewById(R$id.edittext);
        this.f13237m = r26;
        TextView r27 = (TextView) findViewById(R$id.tv_counter);
        this.f13239o = r27;
        this.f13238n = (TextView) findViewById(R$id.tv_error_tips);
        r26.setOnFocusChangeListener(new com.bytedance.ai.model.widgets.h(this, 4));
        ViewGroup r28 = (ViewGroup) findViewById(R$id.input_container);
        this.f13241q = r28;
        this.s = (ViewGroup) findViewById(R$id.title_container);
        a r29 = this.f13243t;
        Intrinsics.checkNotNullParameter(r29, "config");
        this.f13243t = r29;
        String r30 = r29.f13321b;
        if (r30 == null) goto L33;
        if (StringsKt.isBlank(r30) == true) goto L33;
        r24.setText(r29.f13321b);
    L33:
        if (r29.f13320a == false) goto L39;
        com.lynx.tasm.utils.d.t(r24);
        if (this.s.getVisibility() == 0) goto L38;
        com.lynx.tasm.utils.d.t(this.s);
    L38:
        this.f13243t.f13320a = true;
    L44:
        View r31 = r29.f;
        if (r31 == null) goto L48;
        Intrinsics.checkNotNull(r31);
        setPrefixView(r31);
    L48:
        if (TextUtils.isEmpty(r29.e) == true) goto L51;
        r26.setHint(r29.e);
    L51:
        if (r29.f13325j == false) goto L54;
        r26.addTextChangedListener(new com.bytedance.ies.xelement.input.f(this, 3));
    L54:
        if (r29.f13322c == false) goto L63;
        if (r29.d == null) goto L63;
        this.f13244u = new c(r29, this);
        ArrayList<WeakReference<TextWatcher>> r32 = getTextWatchers();
        c r33 = this.f13244u;
        Intrinsics.checkNotNull(r33);
        r32.add(new WeakReference(r33));
        r26.addTextChangedListener(this.f13244u);
        c r34 = this.f13244u;
        if (r34 == null) goto L61;
        r34.onTextChanged(r26.getText(), 0, 0, 0);
    L61:
        com.lynx.tasm.utils.d.t(r27);
    L63:
        if (r29.f13323h <= 0) goto L69;
        ViewGroup.LayoutParams r35 = r28.getLayoutParams();
        if (r35 == null) goto L68;
        ConstraintLayout.LayoutParams r36 = (ConstraintLayout.LayoutParams) r35;
        ((ViewGroup.MarginLayoutParams) r36).height = r29.f13323h;
        r28.setLayoutParams(r36);
        goto L69
    L68:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L69:
        TextWatcher r37 = r29.g;
        if (r37 == null) goto L72;
        Intrinsics.checkNotNull(r37);
        setTextWatcher(r37);
    L72:
        Drawable r38 = r29.f13326k;
        if (r38 == null) goto L75;
        r25.setImageDrawable(r38);
    L75:
        if (r20 == false) goto L82;
        if (r38 != null) goto L82;
        if (this.s.getVisibility() == 0) goto L81;
        com.lynx.tasm.utils.d.t(this.s);
    L81:
        com.lynx.tasm.utils.d.t(r25);
    L82:
        if (r111 != null) goto L84;
    L87:
        r26.setGravity(r22);
        r26.setLines(20);
        r26.setSingleLine(false);
        return;
    L84:
        if (r111.length() == 0) goto L87;
        setText(r111);
        goto L87
    L39:
        com.lynx.tasm.utils.d.s(r24);
        if (r25.getVisibility() == 0) goto L43;
        com.lynx.tasm.utils.d.s(this.s);
    L43:
        this.f13243t.f13320a = false;
        goto L44
    L25:
        r23 = R$layout.o_form_box_vertical;
        goto L26
    L17:
        if (r18.length() == 0) goto L20;
        a r39 = this.f13243t;     // Catch: Throwable -> L12
        r39.f13321b = r18;     // Catch: Throwable -> L12
        r39.f13320a = true;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r16.recycle();
        throw th;
    }
}
