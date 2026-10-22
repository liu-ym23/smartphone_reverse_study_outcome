package com.larus.profile.impl.relaxedit.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import com.larus.platform.model.HandsfreeExperimentConfig;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.utils.ColorUtils;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ks9.c;
import ks9.d;
import ks9.e;
import ks9.f;
import ks9.g;
import ks9.h;
import ks9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001RB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u001dH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0016J\u0012\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0012\u0010)\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0012\u0010*\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010+H\u0007J\u0012\u0010,\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\nH\u0007J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\nH\u0007J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\nH\u0007J\u0012\u00100\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0012\u00101\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007J\u0010\u00102\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020+H\u0007J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020+H\u0007J\u0012\u00104\u001a\u00020\u001d2\b\u00105\u001a\u0004\u0018\u00010(H\u0016J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u000fH\u0007J\u001c\u00108\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u001c\u0010<\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u001c\u0010=\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u001c\u0010>\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\u001c\u0010?\u001a\u00020\u001d2\b\u0010\u0005\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0007J\b\u0010@\u001a\u00020\u001dH\u0002J\u0012\u0010A\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\u0012\u0010C\u001a\u00020\u001d2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0018\u0010F\u001a\u00020\u001d2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u000fH\u0002J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020(H\u0002J\u0012\u0010K\u001a\u00020\u001d2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010L\u001a\u00020\u001d2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0017\u0010M\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020+H\u0002¢\u0006\u0002\u0010NJ\u0012\u0010O\u001a\u00020\n2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010P\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\u000fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/profile/impl/relaxedit/input/LynxUIInputLit;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larus/profile/impl/relaxedit/input/LynxLitEditText;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "params", "", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "suppressInputEvent", "", "defaultValueConsumed", "readOnly", "disabled", "maxLength", "", "maxLengthFilter", "Landroid/text/InputFilter$LengthFilter;", "inputRegexFilter", "Landroid/text/InputFilter;", "readOnlyFilter", "showSoftInputOnFocus", "lastPaddingLeft", "lastPaddingTop", "lastPaddingRight", "lastPaddingBottom", "createView", "Landroid/content/Context;", "afterPropsUpdated", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "onNodeReady", "onLayoutUpdated", "isFocusable", "onFocusChanged", "hasFocus", "isFocusTransition", "setDefaultValue", "value", "", "setPlaceholder", "setMaxLength", "Lcom/lynx/react/bridge/Dynamic;", "setInputFilter", "setReadOnly", "setDisabled", "setShowSoftInputOnFocus", "setConfirmType", "setInputType", "setTextColor", "setPlaceholderColor", "setCaretColor", "caretColor", "setTextAlign", "align", "setValue", "Lcom/lynx/react/bridge/ReadableMap;", "callback", "Lcom/lynx/react/bridge/Callback;", "getValue", "setSelectionRange", "focus", "blur", "applyInteractionState", "replaceText", "applyTextFilters", "emitInputEvent", "text", "Landroid/text/Editable;", "emitSelectionEvent", "selectionStart", "selectionEnd", "emitValueEvent", "name", "doFocus", "doBlur", "parseColor", "(Lcom/lynx/react/bridge/Dynamic;)Ljava/lang/Integer;", "hasComposingText", "isConfirmAction", "actionId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LynxUIInputLit extends LynxUI<ks9.a> {
    public static final /* synthetic */ int n = 0;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;
    public InputFilter.LengthFilter f;
    public h g;
    public final c h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.String.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ReadableType.Long.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ReadableType.Number.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final void N() {
        ks9.a r0 = (ks9.a) ((LynxUI) this).mView;
        h r1 = this.g;
        if (r1 == null) goto L5;
        InputFilter[] r5 = {this.h, r1, this.f};
    L6:
        r0.setFilters(r5);
        return;
    L5:
        r5 = new InputFilter[]{this.h, this.f};
        goto L6
    }

    public final boolean isFocusable() {
        return ((ks9.a) ((LynxUI) this).mView).isFocusable();
    }

    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r0 = ((LynxBaseUI) this).mPaddingLeft + ((LynxBaseUI) this).mBorderLeftWidth;
        int r1 = ((LynxBaseUI) this).mPaddingTop + ((LynxBaseUI) this).mBorderTopWidth;
        int r2 = ((LynxBaseUI) this).mPaddingRight + ((LynxBaseUI) this).mBorderRightWidth;
        int r3 = ((LynxBaseUI) this).mPaddingBottom + ((LynxBaseUI) this).mBorderBottomWidth;
        if (r0 == this.j) goto L5;
    L10:
        this.j = r0;
        this.k = r1;
        this.l = r2;
        this.m = r3;
        ((ks9.a) ((LynxUI) this).mView).setPadding(r0, r1, r2, r3);
        return;
    L5:
        if (r1 != this.k) goto L10;
        if (r2 != this.l) goto L10;
        if (r3 != this.m) goto L10;
    }

    public final void onNodeReady() {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.onNodeReady();
        this.b = true;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [ks9.c] */
    public LynxUIInputLit(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, null);
        this.e = Integer.MAX_VALUE;
        this.f = new InputFilter.LengthFilter(Integer.MAX_VALUE);
        this.h = new c(this);
        this.i = true;
        this.j = Integer.MIN_VALUE;
        this.k = Integer.MIN_VALUE;
        this.l = Integer.MIN_VALUE;
        this.m = Integer.MIN_VALUE;
    }

    public static Integer R(f6a.a r2) {
        ReadableType r0 = r2.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L19;
        if (r1 == 4) goto L19;
        return null;
    L19:
        return Integer.valueOf(r2.asInt());
    L17:
        return Integer.valueOf(ColorUtils.b(r2.asString()));
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    public final void O(Callback r6) {
        if (((ks9.a) ((LynxUI) this).mView).isFocused() == true) goto L7;
        if (r6 == null) goto L11;
        r6.invoke(new Object[]{0});
        return;
    L11:
        return;
    L7:
        ((ks9.a) ((LynxUI) this).mView).clearFocus();
        Object r0 = getLynxContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r0).hideSoftInputFromWindow(((ks9.a) ((LynxUI) this).mView).getWindowToken(), 0);
        if (r6 == null) goto L12;
        r6.invoke(new Object[]{0});
        return;
    }

    public final void P(Callback r8) {
        if (((ks9.a) ((LynxUI) this).mView).requestFocus() == true) goto L7;
        if (r8 == null) goto L20;
        r8.invoke(new Object[]{1, "fail to focus"});
        return;
    L20:
        return;
    L7:
        Object r0 = getLynxContext().getSystemService("input_method");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r1 = (InputMethodManager) r0;
        if (this.i == true) goto L14;
        r1.hideSoftInputFromWindow(((ks9.a) ((LynxUI) this).mView).getWindowToken(), 0);
        if (r8 == null) goto L21;
        r8.invoke(new Object[]{0});
        return;
    L21:
        return;
    L14:
        if (r1.showSoftInput(((LynxUI) this).mView, 1) == false) goto L17;
        if (r8 == null) goto L22;
        r8.invoke(new Object[]{0});
        return;
    L22:
        return;
    L17:
        if (r8 == null) goto L24;
        r8.invoke(new Object[]{1, "fail to show keyboard"});
        return;
    }

    public final void Q(String r4) {
        EventEmitter r0 = getLynxContext().getEventEmitter();
        m7a.a r1 = new m7a.a(getSign(), r4);
        Editable r5 = ((ks9.a) ((LynxUI) this).mView).getText();
        if (r5 == null) goto L5;
        String r6 = r5.toString();
    L6:
        if (r6 != null) goto L8;
        r6 = "";
    L8:
        r1.a("value", r6);
        r0.sendCustomEvent(r1);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void S(String r4) {
        if (r4 != null) goto L4;
        r4 = "";
    L4:
        Editable r0 = ((ks9.a) ((LynxUI) this).mView).getText();
        if (r0 != null) goto L7;
        ((ks9.a) ((LynxUI) this).mView).setText(r4);
        return;
    L7:
        r0.replace(0, r0.length(), r4);
    }

    public final void afterPropsUpdated(x0 r3) {
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.afterPropsUpdated(r3);
        float r4 = ((ks9.a) ((LynxUI) this).mView).getTextSize();
        float r0 = ((LynxBaseUI) this).mFontSize;
        if (r4 != r0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L9;
        ((ks9.a) ((LynxUI) this).mView).setTextSize(0, r0);
        return;
    L9:
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final View createView(Context r5) {
        if (r5 == null) goto L7;
        ks9.a r6 = new ks9.a(new ContextThemeWrapper(r5, 2131952486));
        r6.setLines(1);
        r6.setSingleLine(true);
        r6.setHorizontallyScrolling(true);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setGravity(16);
        r6.setPadding(0, 0, 0, 0);
        r6.setImeOptions(1);
        r6.setFocusableInTouchMode(true);
        r6.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        r6.addTextChangedListener(new i(this));
        r6.setOnFocusChangeListener(new d(this));
        r6.setOnSelectionChangedListener(new e(this));
        r6.setOnEditorActionListener(new f(this));
        return r6;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setCaretColor(String r3) {
        if (Build.VERSION.SDK_INT < 29) goto L10;
        if (r3 == null) goto L12;
        Drawable r0 = ((ks9.a) ((LynxUI) this).mView).getTextCursorDrawable();
        if (r0 == null) goto L11;
        r0.setTint(ColorUtils.b(r3));
        ((ks9.a) ((LynxUI) this).mView).setTextCursorDrawable(r0);
        return;
    L11:
        return;
    L12:
        return;
    }

    @LynxProp(name = "confirm-type")
    public final void setConfirmType(String r4) {
        ks9.a r0 = (ks9.a) ((LynxUI) this).mView;
        if (r4 != null) goto L5;
        r4 = "done";
    L5:
        int r1 = r4.hashCode();
        if (r1 == (-906336856)) goto L27;
        if (r1 == 3304) goto L23;
        if (r1 == 3377907) goto L19;
        if (r1 == 3526536) goto L15;
    L28:
        int r5 = 6;
    L30:
        r0.setImeOptions(r5);
        return;
    L15:
        if (r4.equals(HandsfreeExperimentConfig.ASR_END_SEND) == false) goto L28;
        r5 = 4;
        goto L30
    L19:
        if (r4.equals("next") == false) goto L28;
        r5 = 5;
        goto L30
    L23:
        if (r4.equals("go") == false) goto L28;
        r5 = 2;
        goto L30
    L27:
        if (r4.equals("search") == false) goto L28;
        r5 = 3;
        goto L30
    }

    @LynxProp(name = "default-value")
    public final void setDefaultValue(String r2) {
        if (this.b == false) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        Editable r0 = ((ks9.a) ((LynxUI) this).mView).getText();
        if (r0 == null) goto L10;
        String r1 = r0.toString();
    L12:
        if (Intrinsics.areEqual(r1, r2) == false) goto L14;
        return;
    L14:
        this.a = true;
        S(r2);     // Catch: Throwable -> L18
        this.a = false;
        return;
    L18:
        th = move-exception;
        this.a = false;
        throw th;
    L10:
        r1 = null;
        goto L12
    }

    @LynxProp(defaultBoolean = false, name = "disabled")
    public final void setDisabled(boolean r2) {
        this.d = r2;
        ((ks9.a) ((LynxUI) this).mView).setEnabled(!r2);
        ((ks9.a) ((LynxUI) this).mView).setFocusable(!this.d);
        ((ks9.a) ((LynxUI) this).mView).setFocusableInTouchMode(!this.d);
        ((LynxBaseUI) this).userInteractionEnabled = !this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [ks9.h] */
    @LynxProp(name = "input-filter")
    public final void setInputFilter(String r3) {
        h r0 = 0;
        if (r3 != null) goto L5;
    L20:
        final Regex r4 = null;
    L21:
        if (r4 == null) goto L23;
        r0 = new h(r4);
    L23:
        this.g = r0;
        N();
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r3 = null;
    L11:
        if (r3 == null) goto L20;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        Object r5 = Result.constructor-impl(new Regex(r3));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r5) == false) goto L19;
        r5 = null;
    L19:
        r4 = (Regex) r5;
    L14:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L7:
        r1 = false;
        goto L8
    }

    @LynxProp(name = "type")
    public final void setInputType(String r4) {
        int r0 = RangesKt.coerceAtLeast(((ks9.a) ((LynxUI) this).mView).getSelectionStart(), 0);
        this.a = true;
        if (r4 != null) goto L39;
        r4 = "text";
    L39:
    L36:
        th = move-exception;
        this.a = false;
        throw th;
    L6:
        switch(r4.hashCode()) {
            case -1034364087: goto L25;
            case 114715: goto L21;
            case 95582509: goto L17;
            case 96619420: goto L13;
            case 1216985755: goto L9;
            default: goto L28;
        };     // Catch: Throwable -> L36
    L28:
        ((ks9.a) ((LynxUI) this).mView).setInputType(524289);     // Catch: Throwable -> L36
        ((ks9.a) ((LynxUI) this).mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
    L29:
        View r5 = ((LynxUI) this).mView;     // Catch: Throwable -> L36
        ks9.a r2 = (ks9.a) r5;     // Catch: Throwable -> L36
        Editable r6 = ((ks9.a) r5).getText();     // Catch: Throwable -> L36
        if (r6 == null) goto L32;
        int r7 = r6.length();     // Catch: Throwable -> L36
    L33:
        r2.setSelection(RangesKt.coerceAtMost(r0, r7));     // Catch: Throwable -> L36
        this.a = false;
        return;
    L32:
        r7 = 0;
        goto L33
    L9:
        if (r4.equals("password") == false) goto L28;
        ((ks9.a) ((LynxUI) this).mView).setInputType(129);     // Catch: Throwable -> L36
        ((ks9.a) ((LynxUI) this).mView).setTransformationMethod(PasswordTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    L13:
        if (r4.equals("email") == false) goto L28;
        ((ks9.a) ((LynxUI) this).mView).setInputType(33);     // Catch: Throwable -> L36
        ((ks9.a) ((LynxUI) this).mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    L17:
        if (r4.equals("digit") == false) goto L28;
        ((ks9.a) ((LynxUI) this).mView).setInputType(8194);     // Catch: Throwable -> L36
        ((ks9.a) ((LynxUI) this).mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    L21:
        if (r4.equals("tel") == false) goto L28;
        ((ks9.a) ((LynxUI) this).mView).setInputType(3);     // Catch: Throwable -> L36
        ((ks9.a) ((LynxUI) this).mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    L25:
        if (r4.equals("number") == false) goto L28;
        ((ks9.a) ((LynxUI) this).mView).setInputType(2);     // Catch: Throwable -> L36
        ((ks9.a) ((LynxUI) this).mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());     // Catch: Throwable -> L36
        goto L29
    }

    @LynxProp(name = "maxlength")
    public final void setMaxLength(f6a.a r4) {
        int r0 = Integer.MAX_VALUE;
        if (r4 != null) goto L5;
        int r5 = Integer.MAX_VALUE;
    L22:
        if (r5 < 0) goto L26;
        r0 = r5;
    L26:
        if (r0 != this.e) goto L28;
        return;
    L28:
        this.e = r0;
        this.f = new InputFilter.LengthFilter(r0);
        N();
        return;
    L5:
        ReadableType r1 = r4.getType();
        if (r1 != null) goto L8;
        int r2 = -1;
    L10:
        if (r2 != 1) goto L12;
        Integer r6 = StringsKt.toIntOrNull(r4.asString());
    L20:
        if (r6 == null) goto L30;
        r5 = r6.intValue();
        goto L22
    L30:
        return;
    L12:
        if (r2 != 2) goto L14;
    L18:
        r6 = Integer.valueOf(r4.asInt());
        goto L20
    L14:
        if (r2 == 3) goto L18;
        if (r2 == 4) goto L18;
        r6 = null;
        goto L20
    L8:
        r2 = b.a[r1.ordinal()];
        goto L10
    }

    @LynxProp(name = "placeholder")
    public final void setPlaceholder(String r2) {
        ks9.a r0 = (ks9.a) ((LynxUI) this).mView;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.setHint(r2);
    }

    @LynxProp(name = "placeholder-color")
    public final void setPlaceholderColor(f6a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Integer r3 = R(r2);
        if (r3 == null) goto L6;
        ((ks9.a) ((LynxUI) this).mView).setHintTextColor(r3.intValue());
        return;
    }

    @LynxProp(defaultBoolean = false, name = "readonly")
    public final void setReadOnly(boolean r1) {
        this.c = r1;
        N();
    }

    @LynxProp(defaultBoolean = true, name = "show-soft-input-on-focus")
    public final void setShowSoftInputOnFocus(boolean r2) {
        this.i = r2;
        ((ks9.a) ((LynxUI) this).mView).setShowSoftInputOnFocus(r2);
    }

    @LynxProp(defaultInt = 0, name = "text-align")
    public final void setTextAlign(int r3) {
        ks9.a r0 = (ks9.a) ((LynxUI) this).mView;
        if (r3 != 1) goto L5;
        int r4 = 17;
    L9:
        r0.setGravity(r4);
        return;
    L5:
        if (r3 == 2) goto L7;
        r4 = 8388627;
        goto L9
    L7:
        r4 = 8388629;
        goto L9
    }

    @LynxProp(defaultInt = -16777216, name = "color")
    public final void setTextColor(f6a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        Integer r3 = R(r2);
        if (r3 == null) goto L6;
        ((ks9.a) ((LynxUI) this).mView).setTextColor(r3.intValue());
        return;
    }

    public static final void M(LynxUIInputLit r6, Editable r7) {
        r6.getClass();
        if (r7 == null) goto L5;
        String r0 = r7.toString();
    L6:
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        boolean r1 = ((ks9.a) ((LynxUI) r6).mView).isFocused();
        EventEmitter r2 = r6.getLynxContext().getEventEmitter();
        m7a.a r3 = new m7a.a(r6.getSign(), "input");
        r3.a("value", r0);
        int r4 = -1;
        if (r1 == false) goto L11;
        int r5 = ((ks9.a) ((LynxUI) r6).mView).getSelectionStart();
    L12:
        r3.a("selectionStart", Integer.valueOf(r5));
        if (r1 == false) goto L15;
        r4 = ((ks9.a) ((LynxUI) r6).mView).getSelectionEnd();
    L15:
        r3.a("selectionEnd", Integer.valueOf(r4));
        if (r7 != null) goto L18;
    L22:
        boolean r8 = false;
    L23:
        r3.a("isComposing", Boolean.valueOf(r8));
        r2.sendCustomEvent(r3);
        return;
    L18:
        if (BaseInputConnection.getComposingSpanStart(r7) < 0) goto L22;
        if (BaseInputConnection.getComposingSpanEnd(r7) < 0) goto L22;
        r8 = true;
        goto L23
    L11:
        r5 = -1;
        goto L12
    L5:
        r0 = null;
        goto L6
    }

    @LynxUIMethod
    public final void blur(ReadableMap r2, final Callback r3) {
        if (((ks9.a) ((LynxUI) this).mView).getHasDrawn() == false) goto L5;
        O(r3);
        return;
    L5:
        ((ks9.a) ((LynxUI) this).mView).post(new ks9.b(this, r3));
    }

    @LynxUIMethod
    public final void focus(ReadableMap r2, final Callback r3) {
        if (((ks9.a) ((LynxUI) this).mView).getHasDrawn() == false) goto L5;
        P(r3);
        return;
    L5:
        ((ks9.a) ((LynxUI) this).mView).post(new g(this, r3));
    }

    @LynxUIMethod
    public final void getValue(ReadableMap r8, Callback r9) {
        Editable r10 = ((ks9.a) ((LynxUI) this).mView).getText();
        boolean r0 = ((ks9.a) ((LynxUI) this).mView).isFocused();
        if (r9 == null) goto L26;
        Object[] r1 = new Object[2];
        boolean r2 = false;
        r1[0] = 0;
        JavaOnlyMap r3 = new JavaOnlyMap();
        if (r10 == null) goto L7;
        String r4 = r10.toString();
    L8:
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        r3.putString("value", r4);
        int r5 = -1;
        if (r0 == false) goto L13;
        int r6 = ((ks9.a) ((LynxUI) this).mView).getSelectionStart();
    L14:
        r3.putInt("selectionStart", r6);
        if (r0 == false) goto L17;
        r5 = ((ks9.a) ((LynxUI) this).mView).getSelectionEnd();
    L17:
        r3.putInt("selectionEnd", r5);
        if (r10 != null) goto L20;
    L24:
        r3.putBoolean("isComposing", r2);
        Unit r11 = Unit.INSTANCE;
        r1[1] = r3;
        r9.invoke(r1);
        return;
    L20:
        if (BaseInputConnection.getComposingSpanStart(r10) < 0) goto L24;
        if (BaseInputConnection.getComposingSpanEnd(r10) < 0) goto L24;
        r2 = true;
        goto L24
    L13:
        r6 = -1;
        goto L14
    L7:
        r4 = null;
        goto L8
    }

    public final void onFocusChanged(boolean r1, boolean r2) {
        if (r2 == false) goto L5;
        return;
    L5:
        if (r1 == false) goto L7;
        P(null);
        return;
    L7:
        O(null);
    }

    @LynxUIMethod
    public final void setSelectionRange(ReadableMap r8, Callback r9) {
        if (r8 != null) goto L5;
    L31:
        if (r9 == null) goto L36;
        r9.invoke(new Object[]{4, "Range is missing."});
        return;
    L36:
        return;
    L5:
        if (r8.hasKey("selectionStart") == false) goto L31;
        if (r8.hasKey("selectionEnd") == false) goto L31;
        int r4 = r8.getInt("selectionStart");
        int r10 = r8.getInt("selectionEnd");
        Editable r5 = ((ks9.a) ((LynxUI) this).mView).getText();
        if (r5 == null) goto L12;
        int r6 = r5.length();
    L13:
        if (r4 < 0) goto L16;
        if (r4 > r6) goto L16;
        boolean r7 = true;
    L17:
        if (r7 == false) goto L28;
        if (r10 < 0) goto L21;
        if (r10 > r6) goto L21;
        boolean r11 = true;
    L22:
        if (r11 == false) goto L28;
        ((ks9.a) ((LynxUI) this).mView).setSelection(r4, r10);
        if (r9 == null) goto L34;
        r9.invoke(new Object[]{0});
        return;
    L34:
        return;
    L21:
        r11 = false;
    L28:
        if (r9 == null) goto L35;
        r9.invoke(new Object[]{4, "Range does not meet expectations."});
        return;
    L35:
        return;
    L16:
        r7 = false;
        goto L17
    L12:
        r6 = 0;
        goto L13
    }

    @LynxUIMethod
    public final void setValue(ReadableMap r5, Callback r6) {
        if (r5 != null) goto L7;
        if (r6 == null) goto L40;
        r6.invoke(new Object[]{4, "Param is not a map."});
        return;
    L40:
        return;
    L7:
        this.a = true;
    L35:
        th = move-exception;
        this.a = false;
        throw th;
    L9:
        if (r5.hasKey("value") == false) goto L11;
        String r0 = r5.getString("value");     // Catch: Throwable -> L35
    L12:
        S(r0);     // Catch: Throwable -> L35
        this.a = false;
        String r1 = "cursor";
        if (r5.hasKey("cursor") == true) goto L20;
        r1 = "index";
        if (r5.hasKey("index") == true) goto L20;
        r1 = null;
    L20:
        if (r1 == null) goto L32;
        int r7 = r5.getInt(r1);
        if (r7 < 0) goto L29;
        Editable r2 = ((ks9.a) ((LynxUI) this).mView).getText();
        if (r2 == null) goto L26;
        int r3 = r2.length();
    L27:
        if (r7 > r3) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L32;
        ((ks9.a) ((LynxUI) this).mView).setSelection(r7);
        goto L32
    L26:
        r3 = 0;
    L29:
        r4 = false;
    L32:
        if (r6 == null) goto L41;
        r6.invoke(new Object[]{0});
        return;
    L41:
        return;
    L11:
        r0 = "";
        goto L12
    }
}
