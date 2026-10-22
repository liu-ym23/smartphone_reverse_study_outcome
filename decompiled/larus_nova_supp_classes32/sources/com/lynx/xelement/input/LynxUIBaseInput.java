package com.lynx.xelement.input;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.n;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.recording.LynxFrameRecorder;
import com.lynx.tasm.utils.ColorUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001HJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0013H\u0017J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0013H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0013H\u0007J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0017J\u0012\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\"\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\rH\u0007J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\rH\u0007J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\rH\u0007J\u0012\u0010'\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u000fH\u0007J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\rH\u0017J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000fH\u0007J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u0013H\u0007J\u0010\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0013H\u0017J\u0012\u00101\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00102\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00104\u001a\u00020\u00062\b\u00103\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u00105\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\tH\u0007J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\tH\u0007J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\tH\u0007J\u0010\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\tH\u0007J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001c\u0010C\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010AH\u0007J\u001c\u0010D\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010AH\u0007J\u001c\u0010E\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010AH\u0007J\u001c\u0010F\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010AH\u0007J\u001c\u0010G\u001a\u00020\u00062\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010AH\u0007¨\u0006I"}, d2 = {"Lcom/lynx/xelement/input/LynxUIBaseInput;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/lynx/xelement/input/LynxEditTextView;", "Lcom/lynx/tasm/behavior/n$f;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "setPlaceholder", "setDefaultValue", NameKeys.UnloadStrategy_No_Strategy, "setConfirmEnter", "setAvoidKeyboard", "setHoldKeyboard", "Lf6a/a;", "setAvoidKeyboardSpacing", NameKeys.UnloadStrategy_No_Strategy, "size", "setPlaceholderTextSize", "setXPlaceholderTextSize", NameKeys.UnloadStrategy_No_Strategy, "fontWeightNumerical", "setFontWeight", "(Ljava/lang/Integer;)V", "weight", "setPlaceholderTextWeight", "setXPlaceholderTextWeight", "fontStyle", "setFontStyle", "setPlaceholderFontStyle", "setXPlaceholderFontStyle", "fontFamily", "setFontFamily", "fontFamilyName", "setPlaceholderFontFamily", "setXPlaceholderFontFamily", "color", "setFontColor", "setPlaceholderColor", "setXPlaceholderColor", "setCursorColor", "lineHeight", "setLineHeight", "lineSpacing", "setLineSpacing", "setLetterSpacing", "align", "setTextAlign", "direction", "setLynxDirection", "setConfirmType", "setInputType", "maxLength", "setMaxLength", "setInputFilter", "disabled", "setDisable", "isReadOnly", "setIsReadOnly", "isShowSoftInputOnFocus", "setShowSoftInputOnFocus", "isFullscreenMode", "setKeyBoardFullscreenMode", "setSoftInputMode", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "setValue", "getValue", "setSelectionRange", "focus", "blur", "a", "Input_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIBaseInput extends LynxUI<LynxEditTextView> implements n.f {
    public static final /* synthetic */ int z = 0;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public float e;
    public int f;
    public int g;
    public String h;
    public String i;
    public String j;
    public float k;
    public int l;
    public String m;
    public boolean n;
    public float o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final g u;
    public InputFilter.LengthFilter v;
    public final f w;
    public int x;
    public boolean y;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.Int.ordinal()] = 1;
            r0[ReadableType.Long.ordinal()] = 2;
            r0[ReadableType.Number.ordinal()] = 3;
            r0[ReadableType.String.ordinal()] = 4;
            a = r0;
        }
    }

    public static final class c implements LynxEditText.c {
        public final /* synthetic */ LynxUIBaseInput a;

        public c(LynxUIBaseInput r1) {
            this.a = r1;
        }

        @Override // com.lynx.xelement.input.LynxEditText.c
        public final void a(int r4) {
            LynxBaseUI r0 = this.a.getParentBaseUI();
        L3:
            if (r0 == null) goto L14;
            if (Intrinsics.areEqual(r0.getTagName(), "x-overlay-ng") == true) goto L10;
            if (Intrinsics.areEqual(r0.getTagName(), "overlay") == true) goto L10;
            r0 = r0.getParentBaseUI();
        L10:
            Window r1 = r0.getWindow();
            if (r1 == null) goto L21;
            r1.setSoftInputMode(r4);
            return;
        L21:
            return;
        L14:
            Window r2 = this.a.getWindow();
            if (r2 == null) goto L22;
            r2.setSoftInputMode(r4);
            return;
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ LynxUIBaseInput a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public d(LynxUIBaseInput r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r9) {
            LynxUIBaseInput r0 = this.a;
            if (r0.a == false) goto L5;
            return;
        L5:
            r0.P();
            LynxUIBaseInput r1 = this.a;
            if (r1.q == false) goto L9;
            return;
        L9:
            if (LynxUIBaseInput.N(r1) == null) goto L34;
            if (r9 == null) goto L35;
            LynxUIBaseInput r2 = this.a;
            if (((LynxEditTextView) LynxUIBaseInput.N(r2)).isFocused() == false) goto L14;
            int r3 = ((LynxEditTextView) LynxUIBaseInput.N(r2)).getSelectionStart();
        L16:
            if (((LynxEditTextView) LynxUIBaseInput.N(r2)).isFocused() == false) goto L18;
            int r4 = ((LynxEditTextView) LynxUIBaseInput.N(r2)).getSelectionEnd();
        L19:
            LynxUIBaseInput.O(r2, r9.toString(), r3, r4);
            EventEmitter r5 = r2.getLynxContext().getEventEmitter();
            m7a.a r6 = new m7a.a(r2.getSign(), "input");
            r6.a("value", r9.toString());
            r6.a("selectionStart", Integer.valueOf(r3));
            r6.a("selectionEnd", Integer.valueOf(r4));
            LynxEditTextView r7 = (LynxEditTextView) LynxUIBaseInput.N(r2);
            Boolean r8 = null;
            if (r7 != null) goto L22;
        L32:
            r6.a("isComposing", r8);
            r5.sendCustomEvent(r6);
            return;
        L22:
            if (r7.c == true) goto L24;
            LLog.w("LynxEditText", "InputConnection has not been initialized yet ");
            com.lynx.xelement.input.a r10 = null;
        L25:
            if (r10 == null) goto L32;
            int r11 = com.lynx.xelement.input.a.a;
            Intrinsics.checkNotNullParameter(r9, "text");
            int r12 = BaseInputConnection.getComposingSpanStart(r9);
            int r13 = BaseInputConnection.getComposingSpanEnd(r9);
            if (r12 == (-1)) goto L30;
            if (r13 == (-1)) goto L30;
            boolean r14 = true;
        L31:
            r8 = Boolean.valueOf(r14);
        L30:
            r14 = false;
            goto L31
        L24:
            r10 = r7.b;
            goto L25
        L18:
            r4 = -1;
            goto L19
        L14:
            r3 = -1;
            goto L16
        L35:
            return;
        }
    }

    public static final class e implements LynxEditTextView.a {
        public final /* synthetic */ LynxUIBaseInput a;

        public e(LynxUIBaseInput r1) {
            this.a = r1;
        }

        @Override // com.lynx.xelement.input.LynxEditTextView.a
        public final void a(int r5, int r6) {
            LynxUIBaseInput r0 = this.a;
            if (r0.q == false) goto L5;
            return;
        L5:
            EventEmitter r1 = r0.getLynxContext().getEventEmitter();
            m7a.a r2 = new m7a.a(this.a.getSign(), "selection");
            r2.a("selectionStart", Integer.valueOf(r5));
            r2.a("selectionEnd", Integer.valueOf(r6));
            r1.sendCustomEvent(r2);
        }
    }

    public static final class f implements InputFilter {
        public final /* synthetic */ LynxUIBaseInput a;

        public f(LynxUIBaseInput r1) {
            this.a = r1;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r2, int r3, int r4, Spanned r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, "source");
            Intrinsics.checkNotNullParameter(r5, "dest");
            String r8 = this.a.m;
            if (r8 == null) goto L16;
            StringBuilder r9 = new StringBuilder(NameKeys.UnloadStrategy_No_Strategy);
            int r10 = 0;
        L6:
            if (r10 >= r2.length()) goto L12;
            char r11 = r2.charAt(r10);
            String r12 = String.valueOf(r11);
            if (new Regex(r8).matches(r12) == false) goto L10;
            r9.append(r11);
        L10:
            r10 = r10 + 1;
            goto L6
        L12:
            return r9.toString();
        L16:
            return r2;
        }
    }

    public static final class g implements InputFilter {
        public final /* synthetic */ LynxUIBaseInput a;

        public g(LynxUIBaseInput r1) {
            this.a = r1;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r1, int r2, int r3, Spanned r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r1, "source");
            LynxUIBaseInput r7 = this.a;
            if (r7.b == true) goto L5;
            return null;
        L5:
            if (r7.q == true) goto L10;
            if (r4 != null) goto L8;
            return null;
        L8:
            return r4.subSequence(r5, r6);
        L10:
            return null;
        }
    }

    static {
    }

    public void P() {
    }

    public int R() {
        return 0;
    }

    public boolean W() {
        return false;
    }

    @LynxProp(defaultFloat = 0.0f, name = "line-height")
    public final void setLineHeight(float r1) {
    }

    public final void U() {
        LynxView r0 = this.mContext.getLynxView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.p == true) goto L7;
        r0.getKeyboardEvent().l.put(this, this);
        this.p = true;
    L7:
        r0.getKeyboardEvent().d();
    }

    @Override // com.lynx.tasm.behavior.n.f
    public final void f() {
        ((LynxEditTextView) this.mView).post(new com.lynx.xelement.input.b(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final boolean isFocusable() {
        return ((LynxEditTextView) this.mView).isFocusable();
    }

    public final void V() {
        Object r0 = getLynxContext().getSystemService("input_method");
        if (r0 == null) goto L7;
        ((InputMethodManager) r0).hideSoftInputFromWindow(((LynxEditTextView) this.mView).getWindowToken(), 0);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X() {
        EventEmitter r0 = getLynxContext().getEventEmitter();
        m7a.a r1 = new m7a.a(getSign(), "confirm");
        Editable r2 = ((LynxEditTextView) this.mView).getText();
        if (r2 == null) goto L5;
        String r3 = r2.toString();
    L6:
        r1.a("value", r3);
        r0.sendCustomEvent(r1);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final boolean Z() {
        Object r0 = getLynxContext().getSystemService("input_method");
        if (r0 == null) goto L7;
        return ((InputMethodManager) r0).showSoftInput(this.mView, 1, null);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        ((LynxEditTextView) this.mView).setWidth(getWidth());
        ((LynxEditTextView) this.mView).setHeight(getHeight());
        ((LynxEditTextView) this.mView).setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        LynxView r4 = this.mContext.getLynxView();
        if (r4 == null) goto L26;
        n r0 = r4.getKeyboardEvent();
        View r3 = this.mView;
        boolean r5 = this.n;
        float r6 = this.o;
        n.e r1 = r0.m;
        n.d r2 = r1.o(this, r3, r4, r5, r6);
        n.d r7 = r1.j();
        if (r2 == null) goto L27;
        if (r7 != null) goto L8;
        return;
    L8:
        if (r7.b(this) == false) goto L29;
        r1.q(r2);
        boolean r8 = false;
        if (r1.k == false) goto L12;
    L24:
        r1.v(r8);
        return;
    L12:
        if (Build.VERSION.SDK_INT >= 30) goto L14;
    L16:
        boolean r9 = false;
    L17:
        if (r9 == true) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == true) goto L24;
        r8 = true;
        goto L24
    L19:
        if (r1.n == 0) goto L21;
        r10 = true;
        goto L22
    L14:
        if (r1.g == null) goto L16;
        r9 = true;
        goto L17
    L29:
        return;
    L27:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        this.r = true;
    }

    public static void M(final LynxUIBaseInput r9) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        LynxView r0 = r9.mContext.getLynxView();
        if (r0 == null) goto L54;
        n r1 = r0.getKeyboardEvent();
        Runnable r2 = new com.lynx.xelement.input.f(r9);
        n.e r3 = r1.m;
        n.d r4 = r3.j();
        boolean r5 = true;
        if (r4 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L12;
    L17:
        View r7 = r3.e;
        if (r7 != null) goto L20;
        n.d r8 = null;
    L21:
        int r10 = Build.VERSION.SDK_INT;
        if (r10 >= 30) goto L24;
    L26:
        boolean r11 = false;
    L27:
        if (r11 == false) goto L33;
        r3.q(r8);
        r3.r(r9);
        r3.n = 2;
        r3.o = 0;
        r3.p = new WeakReference(r8);
        if (r3.k == false) goto L31;
        long r12 = n.e.k(null);
    L32:
        r3.p(r12);
        r2.run();
        return;
    L31:
        r12 = 64;
        goto L32
    L33:
        r3.i = 0;
        if (r8 == null) goto L36;
        r3.b(r8);
    L52:
        r3.r(r9);
        r2.run();
        return;
    L36:
        r3.q(null);
        if (r3.k == true) goto L50;
        if (r10 >= 30) goto L40;
    L42:
        boolean r13 = false;
    L43:
        if (r13 == true) goto L45;
    L47:
        boolean r14 = false;
    L48:
        if (r14 == true) goto L50;
    L51:
        r3.l(r5);
        goto L52
    L45:
        if (r3.n == 0) goto L47;
        r14 = true;
        goto L48
    L40:
        if (r3.g == null) goto L42;
        r13 = true;
    L50:
        r5 = false;
        goto L51
    L24:
        if (r3.g == null) goto L26;
        r11 = true;
        goto L27
    L20:
        r8 = r3.i(r7.findFocus());
        goto L21
    L12:
        if (r3.c.get() != r9) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == true) goto L17;
        return;
    L14:
        r15 = false;
        goto L15
    L7:
        if (r4.b(r9) == false) goto L9;
        r6 = true;
        goto L10
    }

    public static final /* synthetic */ View N(LynxUIBaseInput r0) {
        return r0.mView;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.EditText, com.lynx.xelement.input.LynxEditText, com.lynx.xelement.input.LynxEditTextView] */
    public LynxEditTextView Q(Context r8) {
        LynxContext r5 = this.mContext;
        if (r5 == null) goto L5;
        DisplayMetrics r6 = r5.getScreenMetrics();
    L6:
        this.mFontSize = com.lynx.tasm.utils.n.c("14px", 0.0f, 0.0f, 0.0f, 0.0f, r6);
        Intrinsics.checkNotNull(r8);
        final ?? r0 = new LynxEditTextView(r8);
        r0.setOnFocusChangeListener(new com.lynx.xelement.input.d(this, r0));
        r0.setOnAttachedToWindowListener(new c(this));
        r0.setBackground(null);
        r0.setImeOptions(1);
        r0.addTextChangedListener(new d(this));
        r0.setOnSelectionChangeListener(new e(this));
        r0.setHint(NameKeys.UnloadStrategy_No_Strategy);
        r0.setFocusableInTouchMode(true);
        return r0;
    L5:
        r6 = null;
        goto L6
    }

    public final void S(Callback r4) {
        ((LynxEditTextView) this.mView).clearFocus();
        if (this.y == true) goto L5;
        V();
    L5:
        if (r4 == null) goto L8;
        r4.invoke(new Object[]{0});
        return;
    }

    public final void T(Callback r5) {
        if (this.y == true) goto L6;
        U();
    L6:
        if (((LynxEditTextView) this.mView).requestFocus() == true) goto L8;
        if (r5 == null) goto L27;
        r5.invoke(new Object[]{1, "fail to focus"});
        return;
    L27:
        return;
    L8:
        if (this.y == false) goto L13;
        V();
        if (r5 == null) goto L21;
        r5.invoke(new Object[]{0});
        return;
    L21:
        return;
    L13:
        if (Z() == false) goto L16;
        if (r5 == null) goto L23;
        r5.invoke(new Object[]{0});
        return;
    L23:
        return;
    L16:
        if (r5 == null) goto L25;
        r5.invoke(new Object[]{1, "fail to show keyboard"});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(String r4) {
        if (r4 != null) goto L4;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L4:
        Editable r0 = ((LynxEditTextView) this.mView).getText();
        if (r0 != null) goto L7;
        ((LynxEditTextView) this.mView).setText(r4);
        return;
    L7:
        r0.replace(0, r0.length(), r4);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void afterPropsUpdated(x0 r13) {
        super.afterPropsUpdated(r13);
        if (this.h == null) goto L5;
        Typeface r14 = com.lynx.tasm.behavior.shadow.text.g.d(getLynxContext(), this.h, this.f);
    L6:
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r14 != null) goto L12;
        FontFaceManager r15 = FontFaceManager.g.a;
        LynxContext r2 = getLynxContext();
        String r3 = this.h;
        if (r3 != null) goto L11;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        r14 = r15.g(r2, r3, this.f, null);
    L12:
        if (r14 != null) goto L14;
        r14 = Typeface.create(((LynxEditTextView) this.mView).getTypeface(), this.f);
    L14:
        int r4 = Build.VERSION.SDK_INT;
        boolean r5 = true;
        if (r4 < 29) goto L24;
        if (r14 == null) goto L24;
        int r7 = r14.getWeight();
        int r8 = this.c;
        if (r7 == r8) goto L24;
        if (this.f != 2) goto L22;
        boolean r9 = true;
    L23:
        r14 = Typeface.create(r14, r8, r9);
        goto L24
    L22:
        r9 = false;
    L24:
        ((LynxEditTextView) this.mView).setTypeface(r14);
        ((LynxEditTextView) this.mView).setTextSize(0, this.mFontSize);
        if (this.j != null) goto L27;
        ((LynxEditTextView) this.mView).setHint(NameKeys.UnloadStrategy_No_Strategy);
    L65:
        LynxView r10 = this.mContext.getLynxView();
        if (r10 == null) goto L97;
        if (this.n == false) goto L97;
        n r16 = r10.getKeyboardEvent();
        View r6 = this.mView;
        boolean r11 = this.n;
        float r12 = this.o;
        n.e r17 = r16.m;
        n.d r18 = r17.o(this, r6, r10, r11, r12);
        if (r18 == null) goto L97;
        n.d r19 = r17.j();
        if (r19 == null) goto L94;
        if (r19.b(this) == false) goto L94;
        r17.q(r18);
        if (r17.k == false) goto L79;
    L91:
        r5 = false;
    L92:
        r17.v(r5);
        goto L97
    L79:
        if (r4 >= 30) goto L81;
    L83:
        boolean r20 = false;
    L84:
        if (r20 == true) goto L86;
    L88:
        boolean r21 = false;
    L89:
        if (r21 == true) goto L91;
    L86:
        if (r17.n == 0) goto L88;
        r21 = true;
        goto L89
    L81:
        if (r17.g == null) goto L83;
        r20 = true;
    L94:
        if (r6.isFocused() == false) goto L97;
        r17.b(r18);
    L97:
        if (r4 >= 28) goto L99;
        return;
    L99:
        if (Float.valueOf(this.e).equals(Float.valueOf(-1.0f)) == true) goto L103;
        int r110 = ((LynxEditTextView) this.mView).getPaint().getFontMetricsInt(null);
        ((LynxEditTextView) this.mView).setLineHeight(Math.max(r110, ((int) this.e) + r110));
        return;
    L103:
        return;
    L27:
        int r111 = this.d;
        if (r111 != Integer.MIN_VALUE) goto L30;
        r111 = this.c;
    L30:
        int r22 = this.g;
        if (r22 != Integer.MIN_VALUE) goto L33;
        r22 = this.f;
    L33:
        String r23 = this.i;
        if (r23 != null) goto L36;
        r23 = this.h;
    L36:
        float r24 = this.k;
        if (r24 != Float.MIN_VALUE) goto L39;
        boolean r112 = true;
    L40:
        if (r112 == false) goto L42;
        r24 = this.mFontSize;
    L42:
        if (r23 == null) goto L44;
        Typeface r113 = com.lynx.tasm.behavior.shadow.text.g.d(getLynxContext(), r23, r22);
    L45:
        if (r113 != null) goto L51;
        FontFaceManager r114 = FontFaceManager.g.a;
        LynxContext r115 = getLynxContext();
        if (r23 == null) goto L50;
        r1 = r23;
    L50:
        r113 = r114.g(r115, r1, r22, null);
    L51:
        if (r113 != null) goto L53;
        r113 = Typeface.create(((LynxEditTextView) this.mView).getTypeface(), r22);
    L53:
        if (r4 < 29) goto L61;
        if (r113 == null) goto L61;
        if (r113.getWeight() == r111) goto L61;
        if (r22 != 2) goto L59;
        boolean r25 = true;
    L60:
        r113 = Typeface.create(r113, r111, r25);
        goto L61
    L59:
        r25 = false;
    L61:
        SpannableString r116 = new SpannableString(this.j);
        int r26 = r116.length();
        r116.setSpan(new AbsoluteSizeSpan((int) r24, false), 0, r26, 33);
        if (r113 == null) goto L64;
        r116.setSpan(new z6a.i(r113), 0, r26, 33);
    L64:
        ((LynxEditTextView) this.mView).setHint(r116);
        ((LynxEditTextView) this.mView).setHintTextColor(this.l);
        goto L65
    L44:
        r113 = null;
        goto L45
    L39:
        r112 = false;
        goto L40
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return Q(r1);
    }

    @Override // com.lynx.tasm.behavior.n.f
    public final void g(int r9) {
        if (((LynxEditTextView) this.mView).isFocused() == false) goto L29;
        LynxView r4 = this.mContext.getLynxView();
        if (r4 == null) goto L27;
        n r0 = r4.getKeyboardEvent();
        View r7 = this.mView;
        boolean r5 = this.n;
        float r6 = this.o;
        n.e r1 = r0.m;
        n.d r2 = r1.o(this, r7, r4, r5, r6);
        if (r2 == null) goto L27;
        n.d r3 = r1.j();
        if (r7.isFocused() == true) goto L15;
        if (r3 == null) goto L27;
        if (r3.b(this) == false) goto L27;
    L15:
        if (Build.VERSION.SDK_INT >= 30) goto L17;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == false) goto L26;
        r1.q(r2);
        r1.r(r2.a.get());
        r1.n = 1;
        r1.o = r9;
        r1.p = new WeakReference(r2);
        if (r1.k == false) goto L24;
        long r10 = n.e.k(null);
    L25:
        r1.p(r10);
        goto L27
    L24:
        r10 = 64;
        goto L25
    L26:
        r1.i = r9;
        r1.b(r2);
        goto L27
    L17:
        if (r1.g == null) goto L19;
        r8 = true;
    L27:
        EventEmitter r11 = getLynxContext().getEventEmitter();
        m7a.a r12 = new m7a.a(getSign(), "keyboardheightchange");
        r12.a("height", Integer.valueOf(r9));
        r11.sendCustomEvent(r12);
        return;
    }

    @LynxProp(name = "avoid-keyboard")
    public final void setAvoidKeyboard(boolean r1) {
        this.n = r1;
    }

    @LynxProp(name = "avoid-keyboard-spacing")
    public final void setAvoidKeyboardSpacing(f6a.a r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        if (r10.getType() != ReadableType.String) goto L5;
        this.o = com.lynx.tasm.utils.n.b(r10.asString(), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().getScreenMetrics());
        return;
    L5:
        this.o = 0.0f;
    }

    @LynxProp(name = "confirm-enter")
    public final void setConfirmEnter(boolean r1) {
        this.s = r1;
    }

    @LynxProp(name = "confirm-type")
    public final void setConfirmType(String r4) {
        if (W() == false) goto L6;
        this.a = true;
        ((LynxEditTextView) this.mView).setSingleLine(false);
        ((LynxEditTextView) this.mView).setInputType(1);
        ((LynxEditTextView) this.mView).setHorizontallyScrolling(false);
        AppCompatEditText r0 = this.mView;
        ((LynxEditTextView) r0).setMaxLines(((LynxEditTextView) r0).getMaxLines());
        this.a = false;
    L6:
        if (r4 != null) goto L9;
        r4 = "done";
    L9:
        switch(r4.hashCode()) {
            case -906336856: goto L28;
            case 3304: goto L24;
            case 3089282: goto L20;
            case 3377907: goto L16;
            case 3526536: goto L12;
            default: goto L36;
        };
    L36:
        return;
    L12:
        if (r4.equals("send") == false) goto L37;
        ((LynxEditTextView) this.mView).setImeOptions(4);
        return;
    L37:
        return;
    L16:
        if (r4.equals("next") == false) goto L38;
        ((LynxEditTextView) this.mView).setImeOptions(5);
        return;
    L38:
        return;
    L20:
        if (r4.equals("done") == false) goto L39;
        ((LynxEditTextView) this.mView).setImeOptions(6);
        return;
    L39:
        return;
    L24:
        if (r4.equals("go") == false) goto L40;
        ((LynxEditTextView) this.mView).setImeOptions(2);
        return;
    L40:
        return;
    L28:
        if (r4.equals("search") == false) goto L41;
        ((LynxEditTextView) this.mView).setImeOptions(3);
        return;
    }

    @LynxProp(name = "caret-color")
    public final void setCursorColor(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L10;
        Drawable r0 = ((LynxEditTextView) this.mView).getTextCursorDrawable();
        if (r0 == null) goto L11;
        r0.setTint(ColorUtils.b(r3));
        ((LynxEditTextView) this.mView).setTextCursorDrawable(r0);
        return;
    L11:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "default-value")
    public final void setDefaultValue(String r2) {
        if (this.r == false) goto L5;
        return;
    L5:
        if (r2 != null) goto L7;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        Editable r0 = ((LynxEditTextView) this.mView).getText();
        if (r0 == null) goto L10;
        String r1 = r0.toString();
    L12:
        if (Intrinsics.areEqual(r1, r2) == false) goto L14;
        return;
    L14:
        this.q = true;
        Y(r2);
        this.q = false;
        return;
    L10:
        r1 = null;
        goto L12
    }

    @LynxProp(defaultBoolean = false, name = "disabled")
    public final void setDisable(boolean r3) {
        ((LynxEditTextView) this.mView).setEnabled(!r3);
        ((LynxEditTextView) this.mView).setFocusable(!r3);
        ((LynxEditTextView) this.mView).setFocusableInTouchMode(!r3);
        this.userInteractionEnabled = !r3;
    }

    @LynxProp(defaultInt = -16777216, name = "color")
    public final void setFontColor(f6a.a r3) {
        Intrinsics.checkNotNullParameter(r3, "color");
        ReadableType r0 = r3.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
    L14:
        ((LynxEditTextView) this.mView).setTextColor(r3.asInt());
        return;
    L9:
        if (r1 == 2) goto L14;
        if (r1 != 4) goto L17;
        ((LynxEditTextView) this.mView).setTextColor(ColorUtils.b(r3.asString()));
        return;
    L17:
        return;
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    @LynxProp(name = "font-family")
    public void setFontFamily(String r1) {
        if (r1 == null) goto L5;
        this.h = r1;
        return;
    }

    @LynxProp(defaultInt = 0, name = "font-style")
    public void setFontStyle(int r4) {
        int r0 = 0;
        if (r4 != 0) goto L5;
    L9:
        this.f = r0;
        return;
    L5:
        if (r4 == 1) goto L8;
        if (r4 != 2) goto L9;
    L8:
        r0 = 2;
        goto L9
    }

    @LynxProp(defaultInt = 0, name = "font-weight")
    public final void setFontWeight(Integer r2) {
        if (r2 == null) goto L12;
        int r3 = r2.intValue();
        if (r3 != 0) goto L6;
        int r4 = 400;
    L10:
        this.c = r4;
        return;
    L6:
        if (r3 == 1) goto L8;
        r4 = (r3 - 1) * 100;
        goto L10
    L8:
        r4 = 700;
        goto L10
    }

    @LynxProp(name = "hold-keyboard")
    public final void setHoldKeyboard(boolean r1) {
        this.t = r1;
    }

    @LynxProp(name = "input-filter")
    public final void setInputFilter(String r1) {
        this.m = r1;
    }

    @LynxProp(name = "type")
    public final void setInputType(String r7) {
        int r0 = ((LynxEditTextView) this.mView).getImeOptions();
        this.a = true;
        if (r7 != null) goto L5;
        String r3 = "text";
    L7:
        switch(r3.hashCode()) {
            case -1034364087: goto L30;
            case 114715: goto L26;
            case 3556653: goto L22;
            case 95582509: goto L18;
            case 96619420: goto L14;
            case 1216985755: goto L10;
            default: goto L33;
        };
    L33:
        int r1 = ((LynxEditTextView) this.mView).getSelectionStart();
        if (Intrinsics.areEqual(r7, "password") == true) goto L36;
        ((LynxEditTextView) this.mView).setTransformationMethod(SingleLineTransformationMethod.getInstance());
    L37:
        ((LynxEditTextView) this.mView).setSelection(r1);
        AppCompatEditText r8 = this.mView;
        ((LynxEditTextView) r8).setInputType(((LynxEditTextView) r8).getInputType() | 524288);
        if (W() == false) goto L40;
        ((LynxEditTextView) this.mView).setSingleLine(false);
        ((LynxEditTextView) this.mView).setImeOptions(r0);
    L40:
        this.a = false;
        return;
    L36:
        ((LynxEditTextView) this.mView).setTransformationMethod(PasswordTransformationMethod.getInstance());
        goto L37
    L10:
        if (r3.equals("password") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(LynxTouchEvent.kPseudoStateFocusTransition);
        goto L33
    L14:
        if (r3.equals("email") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(32);
        goto L33
    L18:
        if (r3.equals("digit") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(8194);
        goto L33
    L22:
        if (r3.equals("text") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(1);
        goto L33
    L26:
        if (r3.equals("tel") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(3);
        goto L33
    L30:
        if (r3.equals("number") == false) goto L33;
        ((LynxEditTextView) this.mView).setInputType(2);
        goto L33
    L5:
        r3 = r7;
        goto L7
    }

    @LynxProp(defaultBoolean = false, name = "readonly")
    public final void setIsReadOnly(boolean r1) {
        this.b = r1;
    }

    @LynxProp(defaultBoolean = true, name = "android-fullscreen-mode")
    public final void setKeyBoardFullscreenMode(boolean r3) {
        if (r3 == true) goto L4;
        AppCompatEditText r4 = this.mView;
        ((LynxEditTextView) r4).setImeOptions((((LynxEditTextView) r4).getImeOptions() | 33554432) | 268435456);
        return;
    L4:
        AppCompatEditText r5 = this.mView;
        ((LynxEditTextView) r5).setImeOptions((((LynxEditTextView) r5).getImeOptions() & (-33554433)) & (-268435457));
    }

    @LynxProp(defaultFloat = 0.0f, name = "letter-spacing")
    public final void setLetterSpacing(float r3) {
        if (((LynxEditTextView) this.mView).getTextSize() != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        AppCompatEditText r1 = this.mView;
        ((LynxEditTextView) r1).setLetterSpacing(r3 / ((LynxEditTextView) r1).getTextSize());
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @LynxProp(name = "line-spacing")
    public void setLineSpacing(f6a.a r10) {
        Intrinsics.checkNotNullParameter(r10, "lineSpacing");
        if (r10.getType() != ReadableType.String) goto L6;
        this.e = com.lynx.tasm.utils.n.b(r10.asString(), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().getScreenMetrics());
        return;
    L6:
        if (r10.getType() != ReadableType.Number) goto L8;
    L9:
        this.e = com.lynx.tasm.utils.i.a(r10.asDouble());
        return;
    L8:
        if (r10.getType() == ReadableType.Int) goto L9;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(defaultInt = 3, name = "direction")
    public void setLynxDirection(int r2) {
        this.mLynxDirection = r2;
        if (r2 != 0) goto L5;
        ((LynxEditTextView) this.mView).setTextDirection(5);
        return;
    L5:
        if (r2 != 2) goto L7;
        ((LynxEditTextView) this.mView).setTextDirection(4);
        return;
    L7:
        if (r2 != 3) goto L15;
        ((LynxEditTextView) this.mView).setTextDirection(3);
        return;
    }

    @LynxProp(name = "maxlength")
    public final void setMaxLength(f6a.a r3) {
        if (r3 == null) goto L4;
        ReadableType r0 = r3.getType();
    L5:
        if (r0 != null) goto L7;
        int r1 = -1;
    L9:
        if (r1 != 1) goto L11;
    L18:
        this.v = new InputFilter.LengthFilter(r3.asInt());
        return;
    L11:
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L21;
        this.v = new InputFilter.LengthFilter(CastIntegerProtector.parseInt(r3.asString()));
        return;
    L21:
        return;
    L7:
        r1 = b.a[r0.ordinal()];
        goto L9
    L4:
        r0 = null;
        goto L5
    }

    @LynxProp(name = "placeholder")
    public final void setPlaceholder(String r1) {
        this.j = r1;
    }

    @LynxProp(name = "placeholder-color")
    public final void setPlaceholderColor(f6a.a r3) {
        Intrinsics.checkNotNullParameter(r3, "color");
        ReadableType r0 = r3.getType();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L9;
    L14:
        int r4 = r3.asInt();
    L15:
        this.l = r4;
        return;
    L9:
        if (r1 == 2) goto L14;
        if (r1 == 4) goto L13;
        r4 = ColorUtils.b("#3c433c");
        goto L15
    L13:
        r4 = ColorUtils.b(r3.asString());
        goto L15
    L5:
        r1 = b.a[r0.ordinal()];
        goto L7
    }

    @LynxProp(name = "placeholder-font-family")
    public final void setPlaceholderFontFamily(String r1) {
        this.i = r1;
    }

    @LynxProp(name = "placeholder-font-style")
    public final void setPlaceholderFontStyle(int r3) {
        if (r3 == 0) goto L7;
        int r1 = 2;
        if (r3 == 1) goto L8;
        if (r3 == 2) goto L8;
        r1 = Integer.MIN_VALUE;
    L8:
        this.g = r1;
        return;
    L7:
        r1 = 0;
        goto L8
    }

    @LynxProp(defaultFloat = Float.MIN_VALUE, name = "placeholder-font-size")
    public final void setPlaceholderTextSize(float r1) {
        this.k = r1;
    }

    @LynxProp(name = "placeholder-font-weight")
    public final void setPlaceholderTextWeight(f6a.a r7) {
        int r0 = Integer.MIN_VALUE;
        if (r7 != null) goto L5;
        this.d = Integer.MIN_VALUE;
        return;
    L5:
        ReadableType r1 = r7.getType();
        if (r1 != null) goto L8;
        int r2 = -1;
    L9:
        int r3 = 700;
        if (r2 != 1) goto L12;
    L25:
        int r4 = r7.asInt();
        if (r4 == 0) goto L29;
        if (r4 == 1) goto L30;
        r3 = (r7.asInt() - 1) * 100;
    L30:
        this.d = r3;
        return;
    L29:
        r3 = 400;
        goto L30
    L12:
        if (r2 == 2) goto L25;
        if (r2 == 3) goto L25;
        if (r2 == 4) goto L19;
        this.d = Integer.MIN_VALUE;
        return;
    L19:
        if (r7.asString().equals("bold") == false) goto L22;
        r0 = 700;
    L24:
        this.d = r0;
        return;
    L22:
        if (r7.asString().equals("normal") == false) goto L24;
        r0 = 400;
        goto L24
    L8:
        r2 = b.a[r1.ordinal()];
        goto L9
    }

    @LynxProp(defaultBoolean = true, name = "show-soft-input-on-focus")
    public final void setShowSoftInputOnFocus(boolean r4) {
        Activity r0 = com.lynx.tasm.utils.a.getActivity(getLynxContext());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 == true) goto L7;
        this.y = true;
        this.x = r0.getWindow().getAttributes().softInputMode & 15;
        int r5 = (r0.getWindow().getAttributes().softInputMode ^ 15) | 3;
        r0.getWindow().setSoftInputMode(r5);
        ((LynxEditTextView) this.mView).setShowSoftInputOnFocus(false);
        return;
    L7:
        this.y = false;
        int r6 = (r0.getWindow().getAttributes().softInputMode ^ 15) | this.x;
        r0.getWindow().setSoftInputMode(r6);
        ((LynxEditTextView) this.mView).setShowSoftInputOnFocus(true);
        if (((LynxEditTextView) this.mView).isFocused() == false) goto L13;
        U();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "android-set-soft-input-mode")
    public final void setSoftInputMode(String r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        int r1 = 0;
        if (Intrinsics.areEqual("unspecified", r3) == false) goto L6;
    L14:
        ((LynxEditTextView) this.mView).d = r1;
        return;
    L6:
        if (Intrinsics.areEqual("nothing", r3) == false) goto L9;
        r1 = 48;
        goto L14
    L9:
        if (Intrinsics.areEqual("pan", r3) == false) goto L12;
        r1 = 32;
        goto L14
    L12:
        if (Intrinsics.areEqual("resize", r3) == false) goto L14;
        r1 = 16;
        goto L14
    }

    @LynxProp(defaultInt = 0, name = "text-align")
    public final void setTextAlign(int r3) {
        int r0 = R();
        if (r3 != 0) goto L5;
        ((LynxEditTextView) this.mView).setGravity(r0 | 3);
        return;
    L5:
        if (r3 != 1) goto L7;
        ((LynxEditTextView) this.mView).setGravity(r0 | 1);
        return;
    L7:
        if (r3 != 2) goto L15;
        ((LynxEditTextView) this.mView).setGravity(r0 | 5);
        return;
    }

    @LynxProp(name = "-x-placeholder-color")
    public final void setXPlaceholderColor(f6a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "color");
        setPlaceholderColor(r2);
    }

    @LynxProp(name = "-x-placeholder-font-family")
    public final void setXPlaceholderFontFamily(String r1) {
        setPlaceholderFontFamily(r1);
    }

    @LynxProp(name = "-x-placeholder-font-style")
    public final void setXPlaceholderFontStyle(int r1) {
        setPlaceholderFontStyle(r1);
    }

    @LynxProp(defaultFloat = Float.MIN_VALUE, name = "-x-placeholder-font-size")
    public final void setXPlaceholderTextSize(float r1) {
        setPlaceholderTextSize(r1);
    }

    @LynxProp(name = "-x-placeholder-font-weight")
    public final void setXPlaceholderTextWeight(f6a.a r1) {
        setPlaceholderTextWeight(r1);
    }

    public LynxUIBaseInput(LynxContext r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = 400;
        this.d = Integer.MIN_VALUE;
        this.e = -1.0f;
        this.g = Integer.MIN_VALUE;
        this.k = Float.MIN_VALUE;
        this.l = ColorUtils.b("#3c433c4c");
        this.u = new g(this);
        this.v = new InputFilter.LengthFilter(Integer.MAX_VALUE);
        this.w = new f(this);
    }

    @LynxUIMethod
    public final void blur(ReadableMap r2, final Callback r3) {
        if (getView().getMHasDrawn() == false) goto L5;
        S(r3);
        return;
    L5:
        ((LynxEditTextView) this.mView).post(new com.lynx.xelement.input.c(this, r3));
    }

    @LynxUIMethod
    public final void focus(ReadableMap r2, final Callback r3) {
        if (getView().getMHasDrawn() == false) goto L5;
        T(r3);
        return;
    L5:
        ((LynxEditTextView) this.mView).post(new com.lynx.xelement.input.e(this, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public final void getValue(ReadableMap r8, Callback r9) {
        Editable r10 = ((LynxEditTextView) this.mView).getText();
        int r0 = -1;
        if (r10 == null) goto L16;
        LynxEditTextView r3 = (LynxEditTextView) this.mView;
        if (r3.c == true) goto L7;
        LLog.w("LynxEditText", "InputConnection has not been initialized yet ");
        com.lynx.xelement.input.a r4 = null;
    L8:
        if (r4 == null) goto L16;
        int r5 = com.lynx.xelement.input.a.a;
        Intrinsics.checkNotNullParameter(r10, "text");
        int r6 = BaseInputConnection.getComposingSpanStart(r10);
        int r11 = BaseInputConnection.getComposingSpanEnd(r10);
        if (r6 == (-1)) goto L13;
        if (r11 == (-1)) goto L13;
        boolean r12 = true;
    L14:
        if (r12 != true) goto L16;
        boolean r13 = true;
    L17:
        JavaOnlyMap r7 = new JavaOnlyMap();
        if (((LynxEditTextView) this.mView).getText() == null) goto L20;
        String r14 = String.valueOf(((LynxEditTextView) this.mView).getText());
    L22:
        if (((LynxEditTextView) this.mView).isFocused() == false) goto L24;
        int r15 = ((LynxEditTextView) this.mView).getSelectionStart();
    L26:
        if (((LynxEditTextView) this.mView).isFocused() == false) goto L28;
        r0 = ((LynxEditTextView) this.mView).getSelectionEnd();
    L28:
        r7.put("value", r14);
        r7.put("selectionStart", Integer.valueOf(r15));
        r7.put("selectionEnd", Integer.valueOf(r0));
        r7.put("isComposing", Boolean.valueOf(r13));
        if (r9 == null) goto L32;
        r9.invoke(new Object[]{0, r7});
        return;
    L32:
        return;
    L24:
        r15 = -1;
        goto L26
    L20:
        r14 = NameKeys.UnloadStrategy_No_Strategy;
    L13:
        r12 = false;
        goto L14
    L7:
        r4 = r3.b;
    L16:
        r13 = false;
        goto L17
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public final void onFocusChanged(boolean r1, boolean r2) {
        if (r2 == true) goto L14;
        if (r1 == false) goto L11;
        if (this.y == true) goto L7;
        U();
    L7:
        ((LynxEditTextView) this.mView).requestFocus();
        if (this.y == true) goto L15;
        Z();
        return;
    L15:
        return;
    L11:
        if (this.t == true) goto L17;
        ((LynxEditTextView) this.mView).clearFocus();
        V();
        return;
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public final void setSelectionRange(ReadableMap r9, Callback r10) {
        if (r9 != null) goto L8;
        if (r10 == null) goto L32;
        r10.invoke(new Object[]{4, "Param is not a map."});
        return;
    L32:
        return;
    L8:
        if (r9.hasKey("selectionStart") == false) goto L10;
        int r4 = r9.getInt("selectionStart");
    L12:
        if (r9.hasKey("selectionEnd") == false) goto L14;
        int r11 = r9.getInt("selectionEnd");
    L16:
        if (((LynxEditTextView) this.mView).getText() == null) goto L18;
        Editable r5 = ((LynxEditTextView) this.mView).getText();
        Intrinsics.checkNotNull(r5);
        int r6 = r5.length();
    L19:
        if (r6 == (-1)) goto L29;
        if (r4 > r6) goto L29;
        if (r11 > r6) goto L29;
        if (r4 < 0) goto L29;
        if (r11 < 0) goto L29;
        ((LynxEditTextView) this.mView).setSelection(r4, r11);
        if (r10 == null) goto L33;
        r10.invoke(new Object[]{0, "Success."});
        return;
    L33:
        return;
    L29:
        if (r10 == null) goto L34;
        r10.invoke(new Object[]{4, "Range does not meet expectations."});
        return;
    L34:
        return;
    L18:
        r6 = -1;
        goto L19
    L14:
        r11 = -1;
        goto L16
    L10:
        r4 = -1;
        goto L12
    }

    @LynxUIMethod
    public final void setValue(ReadableMap r7, Callback r8) {
        if (r7 != null) goto L8;
        if (r8 == null) goto L21;
        r8.invoke(new Object[]{4, "Param is not a map."});
        return;
    L21:
        return;
    L8:
        if (r7.hasKey("value") == false) goto L10;
        String r2 = r7.getString("value");
    L12:
        if (r7.hasKey("cursor") == false) goto L14;
        int r9 = r7.getInt("cursor");
    L15:
        Y(r2);
        if (r9 == (-1)) goto L18;
        ((LynxEditTextView) this.mView).setSelection(r9);
    L18:
        if (r8 == null) goto L22;
        r8.invoke(new Object[]{0});
        return;
    L22:
        return;
    L14:
        r9 = -1;
        goto L15
    L10:
        r2 = NameKeys.UnloadStrategy_No_Strategy;
        goto L12
    }

    public static final void O(LynxUIBaseInput r7, String r8, int r9, int r10) {
        int r2 = r7.mContext.getInstanceId();
        LynxFrameRecorder r1 = LynxFrameRecorder.k;
        if (r1.k(r2) == false) goto L7;
        r1.o(r2, r7.getSign(), r8, r9, r10);
        return;
    }
}
