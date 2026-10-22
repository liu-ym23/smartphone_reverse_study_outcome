package com.lynx.xelement.input;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ies.xelement.input.b;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.a1;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.n;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.behavior.w0;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.fontface.f;
import com.lynx.tasm.fontface.g;
import com.lynx.tasm.r;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.k;
import i.a;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import po.e;
import po.h;
import po.i;
import zm.g0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u0010J\u0019\u0010\u001c\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u001c\u0010\u0010J\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0016H\u0007¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0016H\u0007¢\u0006\u0004\b!\u0010\u001fJ\u0019\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0017¢\u0006\u0004\b#\u0010\bJ\u0019\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b%\u0010\bJ\u0019\u0010&\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b&\u0010\bJ\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000eH\u0007¢\u0006\u0004\b(\u0010\u0010J\u0017\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000eH\u0007¢\u0006\u0004\b)\u0010\u0010J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000eH\u0007¢\u0006\u0004\b*\u0010\u0010J\u0019\u0010+\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b+\u0010\bJ\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0011H\u0007¢\u0006\u0004\b-\u0010\u0014J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000eH\u0017¢\u0006\u0004\b/\u0010\u0010J\u0017\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0007¢\u0006\u0004\b0\u0010\u0014J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0016H\u0007¢\u0006\u0004\b2\u0010\u001fJ\u0017\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u0016H\u0017¢\u0006\u0004\b4\u0010\u001fJ\u0019\u00105\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b5\u0010\bJ\u0019\u00106\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b6\u0010\bJ\u0019\u00108\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b8\u0010\u0010J\u0019\u00109\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b9\u0010\bJ\u0017\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\tH\u0007¢\u0006\u0004\b;\u0010\u000bJ\u0017\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\tH\u0007¢\u0006\u0004\b=\u0010\u000bJ\u0017\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\tH\u0007¢\u0006\u0004\b?\u0010\u000bJ\u0017\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\tH\u0007¢\u0006\u0004\bA\u0010\u000bJ\u0017\u0010B\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\bB\u0010\bJ#\u0010G\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0007¢\u0006\u0004\bG\u0010HJ#\u0010I\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0007¢\u0006\u0004\bI\u0010HJ#\u0010J\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0007¢\u0006\u0004\bJ\u0010HJ#\u0010K\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0007¢\u0006\u0004\bK\u0010HJ#\u0010L\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010EH\u0007¢\u0006\u0004\bL\u0010H¨\u0006M"}, d2 = {"Lcom/lynx/xelement/input/LynxUIBaseInput;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/lynx/xelement/input/LynxEditTextView;", "Lcom/lynx/tasm/behavior/n;", "", "value", "", "setPlaceholder", "(Ljava/lang/String;)V", "", "setConfirmEnter", "(Z)V", "setAvoidKeyboard", "setHoldKeyboard", "Lpm/a;", "setAvoidKeyboardSpacing", "(Lpm/a;)V", "", "size", "setPlaceholderTextSize", "(F)V", "setXPlaceholderTextSize", "", "fontWeightNumerical", "setFontWeight", "(Ljava/lang/Integer;)V", "weight", "setPlaceholderTextWeight", "setXPlaceholderTextWeight", "fontStyle", "setFontStyle", "(I)V", "setPlaceholderFontStyle", "setXPlaceholderFontStyle", "fontFamily", "setFontFamily", "fontFamilyName", "setPlaceholderFontFamily", "setXPlaceholderFontFamily", "color", "setFontColor", "setPlaceholderColor", "setXPlaceholderColor", "setCursorColor", "lineHeight", "setLineHeight", "lineSpacing", "setLineSpacing", "setLetterSpacing", OpenPageMethod.KEY_ALIGN, "setTextAlign", "direction", "setLynxDirection", "setConfirmType", "setInputType", "maxLength", "setMaxLength", "setInputFilter", "disabled", "setDisable", "isReadOnly", "setIsReadOnly", "isShowSoftInputOnFocus", "setShowSoftInputOnFocus", "isFullscreenMode", "setKeyBoardFullscreenMode", "setSoftInputMode", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "setValue", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "getValue", "setSelectionRange", "focus", "blur", "Input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxUIBaseInput extends LynxUI<LynxEditTextView> implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11200c;
    public float d;
    public int e;
    public int f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f11203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f11205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f11206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f11208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f11209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f11210q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11211r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final i f11212t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public InputFilter.LengthFilter f11213u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i f11214v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f11215w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f11216x;

    public LynxUIBaseInput(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f11199b = 400;
        this.f11200c = Integer.MIN_VALUE;
        this.d = -1.0f;
        this.f = Integer.MIN_VALUE;
        this.f11203j = Float.MIN_VALUE;
        this.f11204k = ColorUtils.b("#3c433c4c");
        this.f11212t = new i(this, 1);
        this.f11213u = new InputFilter.LengthFilter(Integer.MAX_VALUE);
        this.f11214v = new i(this, 0);
    }

    public static final /* synthetic */ View b(LynxUIBaseInput r5) {
        return r5.mView;
    }

    public static final void c(LynxUIBaseInput r5, LynxEditTextView r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$this_apply");
        String r12 = null;
        if (r11 == true) goto L5;
    L11:
        r r13 = r5.getLynxContext().g;
        int r14 = r5.getSign();
        if (r11 == false) goto L14;
        String r15 = "focus";
    L15:
        com.lynx.animax.i r16 = new com.lynx.animax.i(r14, r15);
        Editable r17 = r10.getText();
        if (r17 == null) goto L18;
        r12 = r17.toString();
    L18:
        r16.a("value", r12);
        r13.b(r16);
        if (r11 == false) goto L45;
        LynxBaseUI r18 = r5.getParentBaseUI();
        LynxContext r19 = r5.getLynxContext();
        if (r19.f10140h != null) goto L31;
        UIBody.UIBodyView r20 = r19.l();
        if (r20 == null) goto L31;
        com.lynx.tasm.behavior.i r21 = r20.getLynxUIRendererInternal();
        if (r21 == null) goto L31;
        if ((r21 instanceof LynxUIRenderer) == false) goto L31;
        ((LynxUIRenderer) r21).b();
    L31:
        if (r18 == null) goto L38;
        if (Intrinsics.areEqual(r18.getTagName(), "x-overlay-ng") == true) goto L34;
        r18 = r18.getParentBaseUI();
        goto L31
    L34:
        a1 r22 = r18.getTouchEventDispatcher();
        if (r22 == null) goto L38;
        r22.g = r5;
    L38:
        a1 r23 = r5.getLynxContext().f10140h;
        if (r23 == null) goto L46;
        r23.g = r5;
        return;
    L46:
        return;
    L45:
        return;
    L14:
        r15 = "blur";
        goto L15
    L5:
        if (r5.f11216x == true) goto L11;
        Object r24 = r5.getLynxContext().getSystemService("input_method");
        if (r24 == null) goto L10;
        ((InputMethodManager) r24).showSoftInput(r5.mView, 1, null);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void afterPropsUpdated(y0 r11) {
        super.afterPropsUpdated(r11);
        if (this.g == null) goto L5;
        Typeface r12 = g0.c(getLynxContext(), this.g, this.e);
    L6:
        String r5 = "";
        if (r12 != null) goto L12;
        g r13 = f.f10866a;
        LynxContext r10 = getLynxContext();
        String r14 = this.g;
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        r12 = r13.a(r10, r14, this.e, null);
    L12:
        if (r12 != null) goto L14;
        r12 = Typeface.create(((LynxEditTextView) this.mView).getTypeface(), this.e);
    L14:
        boolean r15 = true;
        if (r12 == null) goto L23;
        int r16 = r12.getWeight();
        int r17 = this.f11199b;
        if (r16 == r17) goto L23;
        if (this.e != 2) goto L21;
        boolean r18 = true;
    L22:
        r12 = Typeface.create(r12, r17, r18);
        goto L23
    L21:
        r18 = false;
    L23:
        ((LynxEditTextView) this.mView).setTypeface(r12);
        ((LynxEditTextView) this.mView).setTextSize(0, this.mFontSize);
        if (this.f11202i != null) goto L26;
        ((LynxEditTextView) this.mView).setHint("");
    L61:
        if (Float.valueOf(this.d).equals(Float.valueOf(-1.0f)) == true) goto L64;
        int r19 = ((LynxEditTextView) this.mView).getPaint().getFontMetricsInt(null);
        ((LynxEditTextView) this.mView).setLineHeight(Math.max(r19, ((int) this.d) + r19));
        return;
    L64:
        return;
    L26:
        int r110 = this.f11200c;
        if (r110 != Integer.MIN_VALUE) goto L29;
        r110 = this.f11199b;
    L29:
        int r20 = this.f;
        if (r20 != Integer.MIN_VALUE) goto L32;
        r20 = this.e;
    L32:
        String r21 = this.f11201h;
        if (r21 != null) goto L35;
        r21 = this.g;
    L35:
        float r22 = this.f11203j;
        if (r22 != Float.MIN_VALUE) goto L38;
        r22 = this.mFontSize;
    L38:
        if (r21 == null) goto L40;
        Typeface r23 = g0.c(getLynxContext(), r21, r20);
    L41:
        if (r23 != null) goto L47;
        g r24 = f.f10866a;
        LynxContext r25 = getLynxContext();
        if (r21 == null) goto L46;
        r5 = r21;
    L46:
        r23 = r24.a(r25, r5, r20, null);
    L47:
        if (r23 != null) goto L49;
        r23 = Typeface.create(((LynxEditTextView) this.mView).getTypeface(), r20);
    L49:
        if (r23 != null) goto L51;
    L56:
        SpannableString r111 = new SpannableString(this.f11202i);
        int r26 = r111.length();
        r111.setSpan(new AbsoluteSizeSpan((int) r22, false), 0, r26, 33);
        if (r23 == null) goto L59;
        r111.setSpan(new zm.i(r23), 0, r26, 33);
    L59:
        ((LynxEditTextView) this.mView).setHint(r111);
        ((LynxEditTextView) this.mView).setHintTextColor(this.f11204k);
        goto L61
    L51:
        if (r23.getWeight() == r110) goto L56;
        if (r20 == 2) goto L55;
        r15 = false;
    L55:
        r23 = Typeface.create(r23, r110, r15);
        goto L56
    L40:
        r23 = null;
        goto L41
    L5:
        r12 = null;
        goto L6
    }

    @f0
    public final void blur(ReadableMap r5, Callback r10) {
        ((LynxEditTextView) this.mView).clearFocus();
        if (this.f11216x == true) goto L9;
        Object r11 = getLynxContext().getSystemService("input_method");
        if (r11 == null) goto L8;
        ((InputMethodManager) r11).hideSoftInputFromWindow(((LynxEditTextView) this.mView).getWindowToken(), 0);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L9:
        if (r10 == null) goto L12;
        r10.invoke(new Object[]{0});
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r5) {
        return l(r5);
    }

    @f0
    public final void focus(ReadableMap r10, Callback r11) {
        if (((LynxEditTextView) this.mView).requestFocus() == true) goto L5;
        if (r11 == null) goto L29;
        r11.invoke(new Object[]{1, "fail to focus"});
        return;
    L29:
        return;
    L5:
        if (this.f11216x == false) goto L12;
        Object r12 = getLynxContext().getSystemService("input_method");
        if (r12 == null) goto L11;
        ((InputMethodManager) r12).hideSoftInputFromWindow(((LynxEditTextView) this.mView).getWindowToken(), 0);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L12:
        Object r13 = getLynxContext().getSystemService("input_method");
        if (r13 == null) goto L23;
        if (((InputMethodManager) r13).showSoftInput(this.mView, 1, null) == false) goto L19;
        if (r11 == null) goto L27;
        r11.invoke(new Object[]{0});
        return;
    L27:
        return;
    L19:
        if (r11 == null) goto L28;
        r11.invoke(new Object[]{1, "fail to show keyboard"});
        return;
    L28:
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @f0
    public final void getValue(ReadableMap r10, Callback r11) {
        Editable r12 = ((LynxEditTextView) this.mView).getText();
        int r5 = -1;
        if (r12 == null) goto L16;
        LynxEditTextView r13 = (LynxEditTextView) this.mView;
        if (r13.f11196c == true) goto L7;
        LynxLog.b(3, "LynxEditText", "InputConnection has not been initialized yet ");
        e r14 = null;
    L8:
        if (r14 == null) goto L16;
        int r15 = e.f21376a;
        Intrinsics.checkNotNullParameter(r12, MessageIndication.CONTENT_TYPE_TEXT);
        int r16 = BaseInputConnection.getComposingSpanStart(r12);
        int r17 = BaseInputConnection.getComposingSpanEnd(r12);
        boolean r18 = true;
        if (r16 == (-1)) goto L13;
        if (r17 == (-1)) goto L13;
        boolean r19 = true;
    L14:
        if (r19 != true) goto L16;
    L17:
        JavaOnlyMap r20 = new JavaOnlyMap();
        if (((LynxEditTextView) this.mView).getText() == null) goto L20;
        String r21 = String.valueOf(((LynxEditTextView) this.mView).getText());
    L22:
        if (((LynxEditTextView) this.mView).isFocused() == false) goto L24;
        int r22 = ((LynxEditTextView) this.mView).getSelectionStart();
    L26:
        if (((LynxEditTextView) this.mView).isFocused() == false) goto L28;
        r5 = ((LynxEditTextView) this.mView).getSelectionEnd();
    L28:
        r20.put("value", r21);
        r20.put("selectionStart", Integer.valueOf(r22));
        r20.put("selectionEnd", Integer.valueOf(r5));
        r20.put("isComposing", Boolean.valueOf(r18));
        if (r11 == null) goto L32;
        r11.invoke(new Object[]{0, r20});
        return;
    L32:
        return;
    L24:
        r22 = -1;
        goto L26
    L20:
        r21 = "";
    L13:
        r19 = false;
        goto L14
    L7:
        r14 = r13.f11195b;
    L16:
        r18 = false;
        goto L17
    }

    public final float i(boolean r10) {
        if (this.f11206m == true) goto L5;
    L36:
        return 0.0f;
    L5:
        if (this.mContext.k() == null) goto L36;
        int r5 = 0;
        if (r10 == false) goto L31;
        if (((LynxEditTextView) this.mView).isFocused() == false) goto L36;
        RectF r11 = a.o(this, new RectF(0.0f, 0.0f, getWidth(), getHeight()));
        Activity r12 = kk.a.c(this.mContext);
        if (r12 == null) goto L16;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L16;
        View r14 = r13.getDecorView();
    L17:
        if (r14 == null) goto L29;
        ViewGroup r15 = (ViewGroup) r14;
        View r16 = r15.getChildAt(0);
        int r17 = r15.getHeight();
        if (r16 == null) goto L21;
        r5 = r17 - r16.getHeight();
    L21:
        float r18 = (this.f11207n - (this.mContext.k().getTranslationY() + ((r17 - r5) - r11.bottom))) + this.f11208o;
        if (this.f11210q == 0.0f) goto L24;
        this.mContext.k().animate().translationY(-r18).setDuration(300).start();
        goto L36
    L24:
        if (r18 <= 0.0f) goto L36;
        this.mContext.k().animate().translationY(-r18).setDuration(300).start();
        return r18;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L16:
        r14 = null;
        goto L17
    L31:
        if (this.f11209p == false) goto L36;
        this.f11209p = false;
        if (this.f11210q == 0.0f) goto L36;
        this.mContext.k().animate().translationY(0.0f).setDuration(300).start();
        goto L36
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final boolean isFocusable() {
        return ((LynxEditTextView) this.mView).isFocusable();
    }

    public final void j(int r5) {
        if (((LynxEditTextView) this.mView).isFocused() == false) goto L6;
        this.f11207n = r5;
        this.f11210q = i(true);
        r r10 = getLynxContext().g;
        com.lynx.animax.i r11 = new com.lynx.animax.i(getSign(), "keyboardheightchange");
        r11.a("height", Integer.valueOf(r5));
        r10.b(r11);
        return;
    }

    public void k(int r5) {
        StaticLayout r10 = io.reactivex.exceptions.a.a(((LynxEditTextView) this.mView).getHint(), (EditText) this.mView, Integer.MAX_VALUE);
        LynxContext r11 = getLynxContext();
        int r12 = getSign();
        w0 r13 = (w0) r11.f10151t.get();
        if (r13 == null) goto L5;
        ShadowNode r14 = (ShadowNode) ((SparseArray) r13.g.f10812a).get(r12);
    L6:
        if (r14 != null) goto L8;
        return;
    L8:
        if ((r14 instanceof LynxUIBaseInputShadowNode) == false) goto L14;
        LynxUIBaseInputShadowNode r15 = (LynxUIBaseInputShadowNode) r14;
        int r16 = RangesKt.coerceAtLeast(r10.getHeight(), r5);
        if (r16 == r15.Z) goto L15;
        r15.Z = r16;
        r15.e = false;
        r15.n();
        r15.f10334a.i(r15.f10335b);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r14 = null;
        goto L6
    }

    public LynxEditTextView l(Context r10) {
        LynxContext r5 = this.mContext;
        if (r5 == null) goto L5;
        DisplayMetrics r11 = r5.f10152u;
    L6:
        this.mFontSize = k.c("14px", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r11);
        Intrinsics.checkNotNull(r10);
        LynxEditTextView r12 = new LynxEditTextView(r10);
        r12.setOnFocusChangeListener(new b(this, r12, 1));
        r12.setOnAttachedToWindowListener(new po.g(this));
        r12.setBackground(null);
        r12.setImeOptions(1);
        r12.addTextChangedListener(new com.bytedance.ies.xelement.input.f(this, 5));
        r12.setOnSelectionChangeListener(new h(this));
        LynxView r13 = this.mContext.k();
        if (r13 == null) goto L9;
        r13.getKeyboardEvent().c();
        r13.getKeyboardEvent().f10309l.put(this, this);
    L9:
        r12.setHint("");
        r12.setFocusableInTouchMode(true);
        return r12;
    L5:
        r11 = null;
        goto L6
    }

    public void m() {
    }

    public int n() {
        return 0;
    }

    public boolean o() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final void onFocusChanged(boolean r5, boolean r10) {
        if (r10 == false) goto L4;
        return;
    L4:
        if (r5 == false) goto L14;
        ((LynxEditTextView) this.mView).requestFocus();
        if (this.f11216x == true) goto L22;
        Object r11 = getLynxContext().getSystemService("input_method");
        if (r11 == null) goto L12;
        ((InputMethodManager) r11).showSoftInput(this.mView, 1, null);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L22:
        return;
    L14:
        if (this.s == true) goto L23;
        this.f11209p = true;
        ((LynxEditTextView) this.mView).clearFocus();
        Object r12 = getLynxContext().getSystemService("input_method");
        if (r12 == null) goto L20;
        ((InputMethodManager) r12).hideSoftInputFromWindow(((LynxEditTextView) this.mView).getWindowToken(), 0);
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        ((LynxEditTextView) this.mView).setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        float r5 = this.f11210q;
        this.f11210q = i(((LynxEditTextView) this.mView).isFocused()) + r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        k(io.reactivex.exceptions.a.a(String.valueOf(((LynxEditTextView) this.mView).getText()), (EditText) this.mView, Integer.MAX_VALUE).getHeight());
    }

    @c0(name = "avoid-keyboard")
    public final void setAvoidKeyboard(boolean r5) {
        this.f11206m = r5;
    }

    @c0(name = "avoid-keyboard-spacing")
    public final void setAvoidKeyboardSpacing(pm.a r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        if (r10.getType() != ReadableType.String) goto L6;
        this.f11208o = k.c(r10.asString(), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().f10152u);
        return;
    L6:
        this.f11208o = 0.0f;
    }

    @c0(name = "confirm-enter")
    public final void setConfirmEnter(boolean r5) {
        this.f11211r = r5;
    }

    @c0(name = "confirm-type")
    public final void setConfirmType(String r5) {
        if (o() == false) goto L6;
        ((LynxEditTextView) this.mView).setSingleLine(false);
        ((LynxEditTextView) this.mView).setInputType(1);
        ((LynxEditTextView) this.mView).setHorizontallyScrolling(false);
        LynxEditTextView r10 = (LynxEditTextView) this.mView;
        r10.setMaxLines(r10.getMaxLines());
    L6:
        if (r5 != null) goto L9;
        r5 = "done";
    L9:
        switch(r5.hashCode()) {
            case -906336856: goto L32;
            case 3304: goto L27;
            case 3089282: goto L22;
            case 3377907: goto L17;
            case 3526536: goto L12;
            default: goto L36;
        };
    L36:
        return;
    L12:
        if (r5.equals("send") == false) goto L37;
        ((LynxEditTextView) this.mView).setImeOptions(4);
        return;
    L37:
        return;
    L17:
        if (r5.equals("next") == false) goto L38;
        ((LynxEditTextView) this.mView).setImeOptions(5);
        return;
    L38:
        return;
    L22:
        if (r5.equals("done") == false) goto L39;
        ((LynxEditTextView) this.mView).setImeOptions(6);
        return;
    L39:
        return;
    L27:
        if (r5.equals("go") == false) goto L40;
        ((LynxEditTextView) this.mView).setImeOptions(2);
        return;
    L40:
        return;
    L32:
        if (r5.equals("search") == true) goto L34;
        return;
    L34:
        ((LynxEditTextView) this.mView).setImeOptions(3);
    }

    @c0(name = "caret-color")
    public final void setCursorColor(String r5) {
        if (r5 == null) goto L7;
        Drawable r10 = ((LynxEditTextView) this.mView).getTextCursorDrawable();
        if (r10 == null) goto L8;
        r10.setTint(ColorUtils.b(r5));
        ((LynxEditTextView) this.mView).setTextCursorDrawable(r10);
        return;
    L8:
        return;
    }

    @c0(defaultBoolean = false, name = "disabled")
    public final void setDisable(boolean r5) {
        boolean r10 = !r5;
        ((LynxEditTextView) this.mView).setEnabled(r10);
        ((LynxEditTextView) this.mView).setFocusable(r10);
        ((LynxEditTextView) this.mView).setFocusableInTouchMode(r10);
        this.userInteractionEnabled = r10;
    }

    @c0(defaultInt = ViewCompat.MEASURED_STATE_MASK, name = "color")
    public final void setFontColor(pm.a r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        ReadableType r10 = r5.getType();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 != 1) goto L9;
    L15:
        ((LynxEditTextView) this.mView).setTextColor(r5.asInt());
        return;
    L9:
        if (r11 == 2) goto L15;
        if (r11 == 4) goto L13;
        return;
    L13:
        ((LynxEditTextView) this.mView).setTextColor(ColorUtils.b(r5.asString()));
        return;
    L5:
        r11 = po.f.f21377a[r10.ordinal()];
        goto L7
    }

    @c0(name = "font-family")
    public void setFontFamily(String r5) {
        if (r5 == null) goto L5;
        this.g = r5;
        return;
    }

    @c0(defaultInt = 0, name = "font-style")
    public void setFontStyle(int r5) {
        if (r5 == 0) goto L6;
        int r10 = 2;
        if (r5 == 1) goto L7;
        if (r5 != 2) goto L6;
    L7:
        this.e = r10;
        return;
    L6:
        r10 = 0;
        goto L7
    }

    @c0(defaultInt = 0, name = "font-weight")
    public final void setFontWeight(Integer r5) {
        if (r5 == null) goto L12;
        int r10 = r5.intValue();
        if (r10 != 0) goto L6;
        int r11 = 400;
    L10:
        this.f11199b = r11;
        return;
    L6:
        if (r10 == 1) goto L8;
        r11 = (r10 - 1) * 100;
        goto L10
    L8:
        r11 = 700;
        goto L10
    }

    @c0(name = "hold-keyboard")
    public final void setHoldKeyboard(boolean r5) {
        this.s = r5;
    }

    @c0(name = "input-filter")
    public final void setInputFilter(String r5) {
        this.f11205l = r5;
    }

    @c0(name = "type")
    public final void setInputType(String r10) {
        int r5 = ((LynxEditTextView) this.mView).getImeOptions();
        if (r10 != null) goto L5;
        String r11 = MessageIndication.CONTENT_TYPE_TEXT;
    L7:
        switch(r11.hashCode()) {
            case -1034364087: goto L30;
            case 114715: goto L26;
            case 3556653: goto L22;
            case 95582509: goto L18;
            case 96619420: goto L14;
            case 1216985755: goto L10;
            default: goto L33;
        };
    L33:
        int r12 = ((LynxEditTextView) this.mView).getSelectionStart();
        if (Intrinsics.areEqual(r10, "password") == true) goto L36;
        ((LynxEditTextView) this.mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());
    L37:
        ((LynxEditTextView) this.mView).setSelection(r12);
        LynxEditTextView r13 = (LynxEditTextView) this.mView;
        r13.setInputType(r13.getInputType() | 524288);
        if (o() == false) goto L41;
        ((LynxEditTextView) this.mView).setSingleLine(false);
        ((LynxEditTextView) this.mView).setImeOptions(r5);
        return;
    L41:
        return;
    L36:
        ((LynxEditTextView) this.mView).setTransformationMethod(PasswordTransformationMethod.getInstance());
        goto L37
    L10:
        if (r11.equals("password") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(128);
        goto L33
    L14:
        if (r11.equals(NotificationCompat.CATEGORY_EMAIL) == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(32);
        goto L33
    L18:
        if (r11.equals("digit") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(8194);
        goto L33
    L22:
        if (r11.equals(MessageIndication.CONTENT_TYPE_TEXT) == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(1);
        goto L33
    L26:
        if (r11.equals("tel") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(3);
        goto L33
    L30:
        if (r11.equals("number") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(2);
        goto L33
    L5:
        r11 = r10;
        goto L7
    }

    @c0(defaultBoolean = false, name = "readonly")
    public final void setIsReadOnly(boolean r5) {
        this.f11198a = r5;
    }

    @c0(defaultBoolean = true, name = "android-fullscreen-mode")
    public final void setKeyBoardFullscreenMode(boolean r5) {
        if (r5 == true) goto L5;
        LynxEditTextView r10 = (LynxEditTextView) this.mView;
        r10.setImeOptions(r10.getImeOptions() | 301989888);
        return;
    L5:
        LynxEditTextView r11 = (LynxEditTextView) this.mView;
        r11.setImeOptions(r11.getImeOptions() & (-301989889));
    }

    @c0(defaultFloat = 0.0f, name = "letter-spacing")
    public final void setLetterSpacing(float r5) {
        if (((LynxEditTextView) this.mView).getTextSize() != 0.0f) goto L5;
        return;
    L5:
        LynxEditTextView r10 = (LynxEditTextView) this.mView;
        r10.setLetterSpacing(r5 / r10.getTextSize());
    }

    @c0(defaultFloat = 0.0f, name = "line-height")
    public final void setLineHeight(float r5) {
    }

    @c0(name = "line-spacing")
    public void setLineSpacing(pm.a r10) {
        Intrinsics.checkNotNullParameter(r10, "lineSpacing");
        if (r10.getType() != ReadableType.String) goto L7;
        this.d = k.c(r10.asString(), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().f10152u);
        return;
    L7:
        if (r10.getType() != ReadableType.Number) goto L9;
    L12:
        this.d = com.lynx.tasm.utils.g.a((float) r10.asDouble(), 0.0f);
        return;
    L9:
        if (r10.getType() == ReadableType.Int) goto L12;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @c0(defaultInt = 3, name = "direction")
    public void setLynxDirection(int r5) {
        this.mLynxDirection = r5;
        if (r5 != 0) goto L5;
        ((LynxEditTextView) this.mView).setTextDirection(5);
        return;
    L5:
        if (r5 != 2) goto L7;
        ((LynxEditTextView) this.mView).setTextDirection(4);
        return;
    L7:
        if (r5 == 3) goto L9;
        return;
    L9:
        ((LynxEditTextView) this.mView).setTextDirection(3);
    }

    @c0(name = "maxlength")
    public final void setMaxLength(pm.a r5) {
        if (r5 == null) goto L4;
        ReadableType r10 = r5.getType();
    L5:
        if (r10 != null) goto L7;
        int r11 = -1;
    L9:
        if (r11 != 1) goto L11;
    L19:
        this.f11213u = new InputFilter.LengthFilter(r5.asInt());
        return;
    L11:
        if (r11 == 2) goto L19;
        if (r11 == 3) goto L19;
        if (r11 == 4) goto L17;
        return;
    L17:
        this.f11213u = new InputFilter.LengthFilter(Integer.parseInt(r5.asString()));
        return;
    L7:
        r11 = po.f.f21377a[r10.ordinal()];
        goto L9
    L4:
        r10 = null;
        goto L5
    }

    @c0(name = "placeholder")
    public final void setPlaceholder(String r5) {
        this.f11202i = r5;
    }

    @c0(name = "placeholder-color")
    public final void setPlaceholderColor(pm.a r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        ReadableType r10 = r5.getType();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 != 1) goto L9;
    L14:
        int r12 = r5.asInt();
    L15:
        this.f11204k = r12;
        return;
    L9:
        if (r11 == 2) goto L14;
        if (r11 == 4) goto L13;
        r12 = ColorUtils.b("#3c433c");
        goto L15
    L13:
        r12 = ColorUtils.b(r5.asString());
        goto L15
    L5:
        r11 = po.f.f21377a[r10.ordinal()];
        goto L7
    }

    @c0(name = "placeholder-font-family")
    public final void setPlaceholderFontFamily(String r5) {
        this.f11201h = r5;
    }

    @c0(name = "placeholder-font-style")
    public final void setPlaceholderFontStyle(int r5) {
        if (r5 == 0) goto L7;
        int r10 = 2;
        if (r5 == 1) goto L8;
        if (r5 == 2) goto L8;
        r10 = Integer.MIN_VALUE;
    L8:
        this.f = r10;
        return;
    L7:
        r10 = 0;
        goto L8
    }

    @c0(defaultFloat = FloatCompanionObject.MIN_VALUE, name = "placeholder-font-size")
    public final void setPlaceholderTextSize(float r5) {
        this.f11203j = r5;
    }

    @c0(name = "placeholder-font-weight")
    public final void setPlaceholderTextWeight(pm.a r10) {
        int r5 = Integer.MIN_VALUE;
        if (r10 != null) goto L6;
        this.f11200c = Integer.MIN_VALUE;
        return;
    L6:
        ReadableType r11 = r10.getType();
        if (r11 != null) goto L9;
        int r12 = -1;
    L10:
        int r13 = 400;
        if (r12 != 1) goto L13;
    L28:
        int r14 = r10.asInt();
        if (r14 == 0) goto L33;
        if (r14 == 1) goto L32;
        r13 = (r10.asInt() - 1) * 100;
        goto L33
    L32:
        r13 = 700;
    L33:
        this.f11200c = r13;
        return;
    L13:
        if (r12 == 2) goto L28;
        if (r12 == 3) goto L28;
        if (r12 == 4) goto L21;
        this.f11200c = Integer.MIN_VALUE;
        return;
    L21:
        if (r10.asString().equals("bold") == false) goto L24;
        r5 = 700;
    L26:
        this.f11200c = r5;
        return;
    L24:
        if (r10.asString().equals("normal") == false) goto L26;
        r5 = 400;
        goto L26
    L9:
        r12 = po.f.f21377a[r11.ordinal()];
        goto L10
    }

    @f0
    public final void setSelectionRange(ReadableMap r10, Callback r11) {
        if (r10 != null) goto L8;
        if (r11 == null) goto L32;
        r11.invoke(new Object[]{4, "Param is not a map."});
        return;
    L32:
        return;
    L8:
        if (r10.hasKey("selectionStart") == false) goto L10;
        int r5 = r10.getInt("selectionStart");
    L12:
        if (r10.hasKey("selectionEnd") == false) goto L14;
        int r12 = r10.getInt("selectionEnd");
    L16:
        if (((LynxEditTextView) this.mView).getText() == null) goto L18;
        Editable r13 = ((LynxEditTextView) this.mView).getText();
        Intrinsics.checkNotNull(r13);
        int r14 = r13.length();
    L19:
        if (r14 == (-1)) goto L29;
        if (r5 > r14) goto L29;
        if (r12 > r14) goto L29;
        if (r5 < 0) goto L29;
        if (r12 < 0) goto L29;
        ((LynxEditTextView) this.mView).setSelection(r5, r12);
        if (r11 == null) goto L33;
        r11.invoke(new Object[]{0, "Success."});
        return;
    L33:
        return;
    L29:
        if (r11 == null) goto L34;
        r11.invoke(new Object[]{4, "Range does not meet expectations."});
        return;
    L34:
        return;
    L18:
        r14 = -1;
        goto L19
    L14:
        r12 = -1;
        goto L16
    L10:
        r5 = -1;
        goto L12
    }

    @c0(defaultBoolean = true, name = "show-soft-input-on-focus")
    public final void setShowSoftInputOnFocus(boolean r5) {
        Activity r10 = kk.a.c(getLynxContext());
        if (r10 != null) goto L5;
        return;
    L5:
        if (r5 == true) goto L8;
        this.f11216x = true;
        this.f11215w = r10.getWindow().getAttributes().softInputMode & 15;
        int r11 = (r10.getWindow().getAttributes().softInputMode ^ 15) | 3;
        r10.getWindow().setSoftInputMode(r11);
        ((LynxEditTextView) this.mView).setShowSoftInputOnFocus(false);
        return;
    L8:
        this.f11216x = false;
        int r12 = (r10.getWindow().getAttributes().softInputMode ^ 15) | this.f11215w;
        r10.getWindow().setSoftInputMode(r12);
        ((LynxEditTextView) this.mView).setShowSoftInputOnFocus(true);
    }

    @c0(name = "android-set-soft-input-mode")
    public final void setSoftInputMode(String r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        int r10 = 0;
        if (Intrinsics.areEqual("unspecified", r5) == false) goto L6;
    L14:
        ((LynxEditTextView) this.mView).d = r10;
        return;
    L6:
        if (Intrinsics.areEqual("nothing", r5) == false) goto L9;
        r10 = 48;
        goto L14
    L9:
        if (Intrinsics.areEqual("pan", r5) == false) goto L12;
        r10 = 32;
        goto L14
    L12:
        if (Intrinsics.areEqual("resize", r5) == false) goto L14;
        r10 = 16;
        goto L14
    }

    @c0(defaultInt = 0, name = "text-align")
    public final void setTextAlign(int r5) {
        int r10 = n();
        if (r5 != 0) goto L5;
        ((LynxEditTextView) this.mView).setGravity(r10 | 3);
        return;
    L5:
        if (r5 != 1) goto L7;
        ((LynxEditTextView) this.mView).setGravity(r10 | 1);
        return;
    L7:
        if (r5 == 2) goto L9;
        return;
    L9:
        ((LynxEditTextView) this.mView).setGravity(r10 | 5);
    }

    @f0
    public final void setValue(ReadableMap r10, Callback r11) {
        if (r10 != null) goto L7;
        if (r11 == null) goto L23;
        r11.invoke(new Object[]{4, "Param is not a map."});
        return;
    L23:
        return;
    L7:
        if (r10.hasKey("value") == false) goto L9;
        String r5 = r10.getString("value");
    L11:
        if (r10.hasKey("cursor") == false) goto L13;
        int r12 = r10.getInt("cursor");
    L15:
        if (((LynxEditTextView) this.mView).getText() != null) goto L17;
        ((LynxEditTextView) this.mView).setText(r5);
    L18:
        if (r12 == (-1)) goto L20;
        ((LynxEditTextView) this.mView).setSelection(r12);
    L20:
        if (r11 == null) goto L24;
        r11.invoke(new Object[]{0});
        return;
    L24:
        return;
    L17:
        Editable r13 = ((LynxEditTextView) this.mView).getText();
        Intrinsics.checkNotNull(r13);
        Editable r14 = ((LynxEditTextView) this.mView).getText();
        Intrinsics.checkNotNull(r14);
        r13.replace(0, r14.length(), r5);
        goto L18
    L13:
        r12 = -1;
        goto L15
    L9:
        r5 = "";
        goto L11
    }

    @c0(name = "-x-placeholder-color")
    public final void setXPlaceholderColor(pm.a r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        setPlaceholderColor(r5);
    }

    @c0(name = "-x-placeholder-font-family")
    public final void setXPlaceholderFontFamily(String r5) {
        setPlaceholderFontFamily(r5);
    }

    @c0(name = "-x-placeholder-font-style")
    public final void setXPlaceholderFontStyle(int r5) {
        setPlaceholderFontStyle(r5);
    }

    @c0(defaultFloat = FloatCompanionObject.MIN_VALUE, name = "-x-placeholder-font-size")
    public final void setXPlaceholderTextSize(float r5) {
        setPlaceholderTextSize(r5);
    }

    @c0(name = "-x-placeholder-font-weight")
    public final void setXPlaceholderTextWeight(pm.a r5) {
        setPlaceholderTextWeight(r5);
    }
}
