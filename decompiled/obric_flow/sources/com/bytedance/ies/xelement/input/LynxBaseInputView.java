package com.bytedance.ies.xelement.input;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.utils.ColorUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zm.g0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003YZ[J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\f\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0017\u0010\u0007J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0019\u0010\u000bJ\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b\u001b\u0010\u0016J\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u0007J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001e\u0010\u000bJ\u0019\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b \u0010\u0016J\u0019\u0010!\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b!\u0010\u0007J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010\u000bJ\u0019\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0004\b&\u0010'J\u0019\u0010(\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b(\u0010\u0016J\u0019\u0010*\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b*\u0010\u0016J\u0019\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0004\b,\u0010\u0016J\u0019\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b.\u0010\u0007J\u0019\u0010/\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b/\u0010\u0007J\u0019\u00100\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b0\u0010\u0007J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000fH\u0007¢\u0006\u0004\b2\u0010\u0012J\u0017\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\bH\u0007¢\u0006\u0004\b4\u0010\u000bJ\u0017\u00106\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u000205H\u0007¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\bH\u0007¢\u0006\u0004\b9\u0010\u000bJ\u0017\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\bH\u0007¢\u0006\u0004\b;\u0010\u000bJ\u0019\u0010=\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b=\u0010>J\u0017\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\bH\u0007¢\u0006\u0004\b@\u0010\u000bJ\u0019\u0010A\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\bA\u0010\u0007J\u0017\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\bH\u0007¢\u0006\u0004\bC\u0010\u000bJ\u0017\u0010E\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\bH\u0007¢\u0006\u0004\bE\u0010\u000bJ\u0019\u0010G\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\bG\u0010\u0007J\u0019\u0010H\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\bH\u0010\u0007J\u0017\u0010I\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\bI\u0010\u0007J#\u0010M\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010$2\b\u0010L\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bM\u0010NJ#\u0010O\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010$2\b\u0010L\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bO\u0010NJ#\u0010P\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010$2\b\u0010L\u001a\u0004\u0018\u00010KH\u0017¢\u0006\u0004\bP\u0010NJ\u0019\u0010Q\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0004\bQ\u0010'J#\u0010R\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010$2\b\u0010L\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bR\u0010NJ#\u0010S\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010$2\b\u0010L\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bS\u0010NJ\u0019\u0010T\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bT\u0010UJ\u0019\u0010V\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bV\u0010UJ\u0019\u0010W\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bW\u0010UJ\u0019\u0010X\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0004\bX\u0010U¨\u0006\\"}, d2 = {"Lcom/bytedance/ies/xelement/input/LynxBaseInputView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/EditText;", "", "value", "", "setAdjustMode", "(Ljava/lang/String;)V", "", "isAutoFit", "setAutoFit", "(Z)V", "setBottomInset", "isSmartScroll", "setSmartScroll", "", "direction", "setLynxDirection", "(I)V", "Lpm/a;", "color", "setFontColor", "(Lpm/a;)V", "setCursorColor", "isFullscreenMode", "setKeyBoardFullscreenMode", "fontSize", "setFontTextSize", "setInputValue", "disabled", "setDisable", "maxLength", "setMaxLength", "setInputType", "isFocused", "setFocus", "Lcom/lynx/react/bridge/ReadableMap;", "map", "setPlaceHolderStyle", "(Lcom/lynx/react/bridge/ReadableMap;)V", "setPlaceholderColor", "size", "setPlaceholderTextSize", "weight", "setPlaceholderTextWeight", "fontFamilyName", "setPlaceholderFontFamily", "setPlaceholder", "setConfirmType", OpenPageMethod.KEY_ALIGN, "setTextAlign", "isShowSoftInputOnFocus", "setShowSoftInputOnFocus", "", "setLetterSpacing", "(F)V", "isAutoFillEnabled", "setIsAutoFillEnabled", "isReadOnly", "setIsReadOnly", "fontWeightNumerical", "setFontWeight", "(Ljava/lang/Integer;)V", "compatNumberType", "setCompatNumberType", "setFontFamily", "enableAutoFill", "setAutoFill", "hideKeyboard", "setBlurKeyboardHide", "colorStr", "setSelectionHandleColor", "setSelectionHighLightColor", "setSoftInputMode", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "setValue", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "addText", "sendDelEvent", "setInputFilter", "controlKeyBoard", "setSelectionRange", "select", "(Lcom/lynx/react/bridge/Callback;)V", "focus", "blur", "getSelection", "com/bytedance/ies/xelement/input/c", "mKeyBoardAction", "com/bytedance/ies/xelement/input/h", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxBaseInputView extends LynxUI<EditText> {
    public static final /* synthetic */ int L = 0;
    public boolean A;
    public int B;
    public e C;
    public boolean D;
    public boolean E;
    public int F;
    public int G;
    public final o H;
    public boolean I;
    public boolean J;
    public boolean K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LynxEditText f6402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6404c;
    public float d;
    public boolean e;
    public int f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f6406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f6408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f6409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f6410m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f6411n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f6412o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f6413p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6414q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f6415r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f6416t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f6417u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6418v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6419w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6420x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6421y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f6422z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/xelement/input/LynxBaseInputView$mKeyBoardAction;", "", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum mKeyBoardAction extends Enum<mKeyBoardAction> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ mKeyBoardAction[] f6423a = null;

        static {
            f6423a = new mKeyBoardAction[]{new mKeyBoardAction("SHOW", 0), new mKeyBoardAction("HIDE", 1), new mKeyBoardAction("KEEP", 2), new mKeyBoardAction("BLUR", 3)};
        }

        public mKeyBoardAction(String r5, int r10) {
            super(r5, r10);
        }

        public static mKeyBoardAction valueOf(String r5) {
            return (mKeyBoardAction) Enum.valueOf(mKeyBoardAction.class, r5);
        }

        public static mKeyBoardAction[] values() {
            return (mKeyBoardAction[]) f6423a.clone();
        }
    }

    public LynxBaseInputView(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.f6403b = 140;
        this.f6405h = 400;
        this.f6407j = 400;
        this.B = Integer.MAX_VALUE;
        this.F = 1;
        this.H = new o(this);
    }

    @f0
    public final void addText(ReadableMap r5, Callback r10) {
        if (r5 == null) goto L18;
        String r11 = r5.getString(MessageIndication.CONTENT_TYPE_TEXT);
        LynxEditText r12 = this.f6402a;
        LynxEditText r13 = null;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r12 = null;
    L7:
        Editable r14 = r12.getText();
        if (r14 == null) goto L14;
        LynxEditText r15 = this.f6402a;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L13:
        r14.insert(r13.getSelectionEnd(), r11);
        goto L14
    L12:
        r13 = r15;
    L14:
        if (r10 == null) goto L17;
        r10.invoke(new Object[]{0});
        return;
    L17:
        return;
    }

    public CharSequence b(CharSequence r5, int r10, int r11, Spanned r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r12, "dest");
        return r5;
    }

    @f0
    public final void blur(Callback r5) {
        LynxEditText r10 = this.f6402a;
        LynxEditText r11 = null;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L6:
        if (r10.isFocused() == false) goto L19;
        setFocus(false);
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L12:
        if (r11.isFocused() == true) goto L16;
        if (r5 == null) goto L22;
        r5.invoke(new Object[]{0, "Success to blur."});
        return;
    L22:
        return;
    L16:
        if (r5 == null) goto L23;
        r5.invoke(new Object[]{1, "Fail to blur."});
        return;
    L23:
        return;
    L10:
        r11 = r12;
        goto L12
    L19:
        if (r5 == null) goto L24;
        r5.invoke(new Object[]{1, "Target is not focused now."});
        return;
    }

    public void c(LynxEditText r5) {
        Intrinsics.checkNotNullParameter(r5, "editText");
    }

    @f0
    public final void controlKeyBoard(ReadableMap r10, Callback r11) {
        if (r10 == null) goto L39;
        int r12 = r10.getInt("action");
        if (r12 >= 0) goto L7;
    L34:
        if (r11 == null) goto L38;
        r11.invoke(new Object[]{4});
        return;
    L38:
        return;
    L7:
        if (r12 > (mKeyBoardAction.values().length - 1)) goto L34;
        LynxEditText r5 = this.f6402a;
        LynxEditText r13 = null;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L12:
        if (r5.requestFocus() == true) goto L14;
        LynxLog.b(4, "LynxBaseInputView", "requestFocus failed, input hasSize=" + n());
    L14:
        if (r12 != 0) goto L20;
        h r14 = new h(getLynxContext(), this);
        LynxEditText r15 = this.f6402a;
        if (r15 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L19:
        r13.post(r14);
    L31:
        if (r11 == null) goto L37;
        r11.invoke(new Object[]{0});
        return;
    L37:
        return;
    L18:
        r13 = r15;
        goto L19
    L20:
        if (r12 != 1) goto L23;
        o();
        goto L31
    L23:
        if (r12 == 2) goto L31;
        if (r12 != 3) goto L31;
        LynxEditText r16 = this.f6402a;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L30:
        r13.clearFocus();
        o();
        goto L31
    L29:
        r13 = r16;
        goto L30
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r5) {
        return k(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        o r5 = this.H;
        if (r5.d == null) goto L8;
        LynxEditText r10 = r5.e;
        com.lynx.tasm.behavior.o r11 = r5.f;
        r11.getClass();
        if (r11.e == null) goto L8;
        r11.f10308k.remove(r10);     // Catch: Exception -> L10
    L8:
        super.destroy();
    }

    @f0
    public final void focus(Callback r5) {
        setFocus(true);
        LynxEditText r10 = this.f6402a;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L6:
        if (r10.isFocused() == false) goto L10;
        if (r5 == null) goto L13;
        r5.invoke(new Object[]{0, "Success to focus."});
        return;
    L13:
        return;
    L10:
        if (r5 == null) goto L14;
        r5.invoke(new Object[]{1, "Fail to focus."});
        return;
    }

    @f0
    public final void getSelection(Callback r10) {
        LynxEditText r5 = this.f6402a;
        LynxEditText r11 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L6:
        if (r5.isFocused() == false) goto L18;
        JavaOnlyMap r12 = new JavaOnlyMap();
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L10:
        r12.putInt("selectionStart", r13.getSelectionStart());
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L14:
        r12.putInt("selectionEnd", r11.getSelectionEnd());
        if (r10 == null) goto L21;
        r10.invoke(new Object[]{0, r12});
        return;
    L21:
        return;
    L13:
        r11 = r14;
        goto L14
    L18:
        if (r10 == null) goto L22;
        r10.invoke(new Object[]{1, "Target is not focused now."});
        return;
    }

    public void i(LynxEditText r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "editText");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final boolean isFocusable() {
        LynxEditText r5 = this.f6402a;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L6:
        return r5.isFocusable();
    }

    public final void j(String r13, Integer r14, Callback r15) {
        LynxEditText r5 = this.f6402a;
        LynxEditText r10 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L5:
        boolean r11 = true;
        if (r5.getText() == null) goto L70;
        this.f6420x = true;
        UnderlineSpan[] r12 = new UnderlineSpan[0];
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList();
        ArrayList r18 = new ArrayList();
        LynxEditText r19 = this.f6402a;
        if (r19 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r19 = null;
    L11:
        if (Intrinsics.areEqual(r13, String.valueOf(r19.getText())) == false) goto L20;
        LynxEditText r20 = this.f6402a;
        if (r20 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r20 = null;
    L15:
        Editable r21 = r20.getText();
        Intrinsics.checkNotNull(r21);
        LynxEditText r22 = this.f6402a;
        if (r22 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r22 = null;
    L18:
        Editable r23 = r22.getText();
        Intrinsics.checkNotNull(r23);
        r12 = (UnderlineSpan[]) r21.getSpans(0, r23.length(), UnderlineSpan.class);
        if (r12.length == 0) goto L20;
        int r24 = r12.length;
        int r25 = 0;
    L22:
        if (r25 >= r24) goto L33;
        UnderlineSpan r110 = r12[r25];
        LynxEditText r111 = this.f6402a;
        if (r111 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r111 = null;
    L26:
        Editable r112 = r111.getText();
        Intrinsics.checkNotNull(r112);
        r16.add(Integer.valueOf(r112.getSpanStart(r110)));
        LynxEditText r113 = this.f6402a;
        if (r113 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r113 = null;
    L29:
        Editable r114 = r113.getText();
        Intrinsics.checkNotNull(r114);
        r17.add(Integer.valueOf(r114.getSpanEnd(r110)));
        LynxEditText r115 = this.f6402a;
        if (r115 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r115 = null;
    L32:
        Editable r116 = r115.getText();
        Intrinsics.checkNotNull(r116);
        r18.add(Integer.valueOf(r116.getSpanFlags(r110)));
        r25 = r25 + 1;
    L33:
        LynxEditText r26 = this.f6402a;
        if (r26 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r26 = null;
    L36:
        Editable r27 = r26.getText();
        Intrinsics.checkNotNull(r27);
        LynxEditText r28 = this.f6402a;
        if (r28 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r28 = null;
    L39:
        Editable r29 = r28.getText();
        Intrinsics.checkNotNull(r29);
        r27.replace(0, r29.length(), r13);
        if (r11 == true) goto L42;
    L53:
        this.f6420x = false;
        if (r14 != null) goto L56;
    L67:
        if (r15 == null) goto L79;
        r15.invoke(new Object[]{0, "Success."});
        return;
    L79:
        return;
    L56:
        if (r14.intValue() < 0) goto L67;
        int r117 = r14.intValue();
        LynxEditText r30 = this.f6402a;
        if (r30 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r30 = null;
    L60:
        Editable r31 = r30.getText();
        Intrinsics.checkNotNull(r31);
        if (r117 > r31.length()) goto L67;
        LynxEditText r118 = this.f6402a;
        if (r118 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L66:
        r10.setSelection(r14.intValue());
        goto L67
    L65:
        r10 = r118;
        goto L66
    L42:
        if (r12.length == 0) goto L53;
        int r119 = r12.length;
        int r32 = 0;
    L45:
        if (r32 >= r119) goto L53;
        LynxEditText r33 = this.f6402a;
        if (r33 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r33 = null;
    L49:
        l r34 = r33.a();
        if (r34 == null) goto L52;
        r34.setComposingRegion(((Number) r16.get(r32)).intValue(), ((Number) r17.get(r32)).intValue());
    L52:
        r32 = r32 + 1;
    L20:
        r11 = false;
        goto L33
    L70:
        if (r15 == null) goto L80;
        r15.invoke(new Object[]{1, "Input is not ready."});
        return;
    }

    public LynxEditText k(Context r12) {
        Intrinsics.checkNotNull(r12);
        LynxEditText r5 = new LynxEditText(r12);
        this.f6402a = r5;
        e r13 = new e(this);
        this.C = r13;
        int r10 = 1;
        int r11 = 0;
        r5.setFilters(new InputFilter[]{r13});
        r5.addTextChangedListener(new f(this, r11));
        r5.setOnFocusChangeListener(new b(this, r5, r11));
        r5.setOnAttachedToWindowListener(new g(this));
        r5.setBackground(null);
        r5.setImeOptions(1);
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r14 = null;
    L5:
        c(r14);
        LynxEditText r15 = this.f6402a;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r15 = null;
    L8:
        r15.setOnTouchListener(new com.bytedance.ai.widget.contianer.a(this, r10));
        float r16 = com.lynx.tasm.utils.k.c("14px", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, this.mContext.f10152u);
        this.mFontSize = r16;
        this.d = r16;
        LynxEditText r17 = this.f6402a;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r17 = null;
    L11:
        r17.setTextSize(0, this.mFontSize);
        LynxEditText r18 = this.f6402a;
        if (r18 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r18 = null;
    L14:
        r18.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        LynxEditText r19 = this.f6402a;
        if (r19 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r19 = null;
    L17:
        LynxEditText r20 = this.f6402a;
        if (r20 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r20 = null;
    L20:
        r19.setInputType(r20.getInputType() | 524288);
        LynxEditText r21 = this.f6402a;
        if (r21 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r21 = null;
    L23:
        r21.setFocusableInTouchMode(true);
        LynxEditText r22 = this.f6402a;
        if (r22 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r22 = null;
    L26:
        r22.setFallbackLineSpacing(true);
        LynxEditText r23 = this.f6402a;
        if (r23 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r23 = null;
    L29:
        r23.setCursorVisible(false);
        LynxEditText r110 = this.f6402a;
        if (r110 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        return null;
    L33:
        return r110;
    }

    public void l() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        super.layout();
        if (n() == true) goto L5;
        return;
    L5:
        if (this.J == false) goto L9;
        this.J = false;
        setFocus(true);
        return;
    }

    public int m() {
        return 0;
    }

    public final boolean n() {
        LynxEditText r5 = this.f6402a;
        LynxEditText r10 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L5:
        int r11 = r5.getBottom();
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r12 = null;
    L9:
        if (r11 <= r12.getTop()) goto L21;
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L13:
        int r14 = r13.getRight();
        LynxEditText r15 = this.f6402a;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L18:
        if (r14 <= r10.getLeft()) goto L23;
        return true;
    L23:
        return false;
    L16:
        r10 = r15;
        goto L18
    L21:
        return false;
    }

    public final void o() {
        Object r5 = getLynxContext().getSystemService("input_method");
        if (r5 == null) goto L10;
        InputMethodManager r10 = (InputMethodManager) r5;
        LynxEditText r11 = this.f6402a;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L7:
        r10.hideSoftInputFromWindow(r11.getWindowToken(), 0);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public final void onFocusChanged(boolean r5, boolean r10) {
        if (r10 == true) goto L4;
    L7:
        if (r5 == true) goto L9;
    L12:
        setFocus(false);
        return;
    L9:
        if (this.A == true) goto L12;
        setFocus(true);
        return;
    L4:
        if (this.D == true) goto L7;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r5 = this.mPaddingTop + this.mBorderTopWidth;
        int r10 = this.mPaddingBottom + this.mBorderBottomWidth;
        int r11 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r12 = this.mPaddingRight + this.mBorderRightWidth;
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L5:
        r13.setPadding(r11, r5, r12, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onListCellDisAppear(String r5, LynxBaseUI r10, boolean r11) {
        if (this.f6414q == false) goto L5;
        o();
    L5:
        super.onListCellDisAppear(r5, r10, r11);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        String r5 = this.f6413p;
        if (r5 == null) goto L6;
        Intrinsics.checkNotNull(r5);
        j(r5, null, null);
        this.f6413p = null;
    L6:
        if (this.f6411n == false) goto L9;
        p();
        this.f6411n = false;
    L9:
        if (this.f6412o == true) goto L11;
        return;
    L11:
        if (this.f6404c == null) goto L15;
        q();
        this.f6412o = false;
        return;
    }

    public void p() {
        int r5 = this.f6407j;
        if (r5 != 500) goto L5;
    L13:
        int r10 = 1;
    L14:
        LynxEditText r11 = null;
        if (this.f6408k == null) goto L21;
        Typeface r12 = g0.c(getLynxContext(), this.f6408k, r10);
        if (r12 != null) goto L23;
        LynxLog.b(2, "LynxBaseInputView", "font-face is not found in TypefaceCache");
        r12 = com.lynx.tasm.fontface.f.f10866a.a(getLynxContext(), this.f6408k, r10, new c(this, 0));
        if (r12 != null) goto L23;
        LynxLog.b(2, "LynxBaseInputView", "font-face is not loaded, use default font");
    L23:
        if (r12 != null) goto L30;
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L28:
        TextPaint r14 = r11.getPaint();
        r14.setTypeface(Typeface.create(r14.getTypeface(), this.f6407j, false));
        return;
    L27:
        r11 = r13;
        goto L28
    L30:
        LynxEditText r15 = this.f6402a;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L34:
        r11.setTypeface(Typeface.create(r12, r10));
        return;
    L33:
        r11 = r15;
        goto L34
    L21:
        r12 = null;
        goto L23
    L5:
        if (r5 == 600) goto L13;
        if (r5 == 700) goto L13;
        if (r5 == 800) goto L13;
        if (r5 == 900) goto L13;
        r10 = 0;
        goto L14
    }

    public void q() {
        if (this.f6404c == null) goto L50;
        int r5 = this.f6405h;
        if (r5 != 500) goto L8;
    L16:
        int r10 = 1;
    L17:
        LynxEditText r11 = null;
        if (this.f6410m == false) goto L20;
    L23:
        Typeface r12 = g0.c(getLynxContext(), this.f6409l, r10);
        if (r12 != null) goto L30;
        LynxLog.b(2, "LynxBaseInputView", "font-face is not found in TypefaceCache");
        Typeface r13 = com.lynx.tasm.fontface.f.f10866a.a(getLynxContext(), this.f6409l, r10, new c(this, 1));
        if (r13 != null) goto L28;
        LynxLog.b(2, "LynxBaseInputView", "font-face is not loaded, use default font");
    L28:
        r12 = r13;
    L30:
        if (r12 != null) goto L35;
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r14 = null;
    L34:
        r12 = Typeface.create(r14.getPaint().getTypeface(), this.f6405h, false);
    L35:
        SpannableString r15 = new SpannableString(this.f6404c);
        int r16 = r15.length();
        r15.setSpan(new AbsoluteSizeSpan((int) this.d, false), 0, r16, 33);
        if (r12 == null) goto L38;
        r15.setSpan(new zm.i(r12), 0, r16, 33);
    L38:
        LynxEditText r17 = this.f6402a;
        if (r17 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r17 = null;
    L41:
        r17.setHint(r15);
        if (this.g == false) goto L49;
        LynxEditText r18 = this.f6402a;
        if (r18 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L47:
        r11.setHintTextColor(this.f);
        this.g = false;
        return;
    L46:
        r11 = r18;
        goto L47
    L49:
        return;
    L20:
        if (this.f6408k != null) goto L23;
        r12 = null;
        goto L30
    L8:
        if (r5 == 600) goto L16;
        if (r5 == 700) goto L16;
        if (r5 == 800) goto L16;
        if (r5 == 900) goto L16;
        r10 = 0;
        goto L17
    }

    @f0
    public final void select(Callback r5) {
        LynxEditText r10 = this.f6402a;
        LynxEditText r11 = null;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L6:
        if (r10.getText() == null) goto L18;
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r12 = null;
    L10:
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L14:
        Editable r14 = r11.getText();
        Intrinsics.checkNotNull(r14);
        r12.setSelection(0, r14.length());
        if (r5 == null) goto L21;
        r5.invoke(new Object[]{0, "Success."});
        return;
    L21:
        return;
    L13:
        r11 = r13;
        goto L14
    L18:
        if (r5 == null) goto L22;
        r5.invoke(new Object[]{1, "Input is not ready."});
        return;
    }

    @f0
    public void sendDelEvent(ReadableMap r5, Callback r10) {
        if (r5 != null) goto L24;
        return;
    L24:
        int r11 = r5.getInt("action");     // Catch: Throwable -> L10
        if (r11 == 0) goto L12;
        if (r11 != 1) goto L18;
        ((EditText) this.mView).dispatchKeyEvent(new KeyEvent(0, 67));     // Catch: Throwable -> L10
    L18:
        if (r10 == null) goto L26;
        r10.invoke(new Object[]{0});     // Catch: Throwable -> L10
        return;
    L26:
        return;
    L12:
        int r12 = r5.getInt("length");     // Catch: Throwable -> L10
        LynxEditText r13 = this.f6402a;     // Catch: Throwable -> L10
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");     // Catch: Throwable -> L10
        r13 = null;
    L15:
        l r14 = r13.a();     // Catch: Throwable -> L10
        if (r14 == null) goto L18;
        r14.deleteSurroundingText(r12, 0);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (r10 == null) goto L27;
        r10.invoke(new Object[]{1, th});
        return;
    }

    @c0(name = "adjust-mode")
    public final void setAdjustMode(String r5) {
        if (r5 != null) goto L4;
        r5 = "end";
    L4:
        o r10 = this.H;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r5, "mode");
        r10.f6456i = r5;
    }

    @c0(defaultBoolean = false, name = "auto-fill")
    public final void setAutoFill(boolean r5) {
        LynxEditText r10 = null;
        if (r5 == true) goto L10;
        LynxEditText r11 = this.f6402a;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L8:
        r10.setImportantForAutofill(2);
        return;
    L7:
        r10 = r11;
        goto L8
    L10:
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L14:
        r10.setImportantForAutofill(1);
        return;
    L13:
        r10 = r12;
        goto L14
    }

    @c0(defaultBoolean = true, name = "auto-fit")
    public final void setAutoFit(boolean r5) {
        this.H.f6457j = r5;
    }

    @c0(defaultBoolean = false, name = "keyboard-hide-blur")
    public final void setBlurKeyboardHide(boolean r5) {
        this.E = r5;
    }

    @c0(name = "bottom-inset")
    public final void setBottomInset(String r10) {
        if (r10 != null) goto L4;
        r10 = "0px";
    L4:
        String r5 = r10;
        o r11 = this.H;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r5, "bottomInset");
        r11.f6458k = (int) com.lynx.tasm.utils.k.c(r5, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r11.f6454c.f10152u);
    }

    @c0(defaultBoolean = false, name = "compat-number-type")
    public final void setCompatNumberType(boolean r5) {
        this.K = r5;
        l();
    }

    @c0(name = "confirm-type")
    public final void setConfirmType(String r5) {
        if (r5 != null) goto L5;
        r5 = "done";
    L5:
        LynxEditText r10 = null;
        switch(r5.hashCode()) {
            case -906336856: goto L45;
            case 3304: goto L36;
            case 3089282: goto L27;
            case 3377907: goto L18;
            case 3526536: goto L9;
            default: goto L53;
        };
    L53:
        return;
    L9:
        if (r5.equals("send") == false) goto L54;
        LynxEditText r11 = this.f6402a;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L15:
        r10.setImeOptions(4);
        return;
    L14:
        r10 = r11;
        goto L15
    L54:
        return;
    L18:
        if (r5.equals("next") == false) goto L55;
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L24:
        r10.setImeOptions(5);
        return;
    L23:
        r10 = r12;
        goto L24
    L55:
        return;
    L27:
        if (r5.equals("done") == false) goto L56;
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L33:
        r10.setImeOptions(6);
        return;
    L32:
        r10 = r13;
        goto L33
    L56:
        return;
    L36:
        if (r5.equals("go") == false) goto L57;
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L42:
        r10.setImeOptions(2);
        return;
    L41:
        r10 = r14;
        goto L42
    L57:
        return;
    L45:
        if (r5.equals("search") == true) goto L47;
        return;
    L47:
        LynxEditText r15 = this.f6402a;
        if (r15 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L51:
        r10.setImeOptions(3);
        return;
    L50:
        r10 = r15;
        goto L51
    }

    @c0(name = "caret-color")
    public final void setCursorColor(String r10) {
        if (r10 == null) goto L45;
        LynxEditText r5 = this.f6402a;
        LynxEditText r11 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L8:
        int r12 = ColorUtils.b(r10);
        Field r13 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L11
        r13.setAccessible(true);     // Catch: Throwable -> L11
    L12:
        if (r13 != null) goto L42;
        Object r14 = null;
    L17:
        if (r14 != null) goto L19;
        r14 = r5;
    L19:
        if (r13 != null) goto L21;
        Class<?> r15 = TextView.class;
    L22:
        Field r16 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L14
        r16.setAccessible(true);     // Catch: Throwable -> L14
        Drawable r17 = getLynxContext().getDrawable(r16.getInt(r5));     // Catch: Throwable -> L14
        if (r17 == null) goto L29;
        r17.setTint(r12);     // Catch: Throwable -> L14
        Field r18 = r15.getDeclaredField("mDrawableForCursor");     // Catch: Throwable -> L14
        r18.setAccessible(true);     // Catch: Throwable -> L14
        r18.set(r14, r17);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
    L29:
        if (Intrinsics.areEqual(r10, "transparent") == false) goto L44;
        Field r19 = TextView.class.getDeclaredField("mTextSelectHandleRes");     // Catch: Throwable -> L36
        r19.setAccessible(true);     // Catch: Throwable -> L36
        LynxEditText r20 = this.f6402a;     // Catch: Throwable -> L36
        if (r20 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");     // Catch: Throwable -> L36
    L34:
        r19.setInt(r11, R.color.transparent);     // Catch: Throwable -> L36
        return;
    L33:
        r11 = r20;
    L36:
        LynxLog.b(3, "LynxBaseInputView", "Failed to set transparent text select handle");
        return;
    L44:
        return;
    L21:
        r15 = r14.getClass();     // Catch: Throwable -> L14
        goto L22
    L42:
        r14 = r13.get(r5);     // Catch: Throwable -> L14
    L11:
        r13 = null;
        goto L12
    }

    @c0(defaultBoolean = false, name = "disabled")
    public final void setDisable(boolean r5) {
        LynxEditText r10 = this.f6402a;
        LynxEditText r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L5:
        boolean r12 = !r5;
        r10.setEnabled(r12);
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L8:
        r13.setFocusable(r12);
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L12:
        r11.setFocusableInTouchMode(r12);
        return;
    L11:
        r11 = r14;
        goto L12
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map r5) {
        super.setEvents(r5);
        if (r5 == null) goto L6;
        this.f6417u = r5.containsKey("blur");
        this.f6418v = r5.containsKey("confirm");
        this.f6416t = r5.containsKey("focus");
        this.s = r5.containsKey("input");
        this.f6419w = r5.containsKey("length");
        return;
    }

    @c0(defaultBoolean = false, name = "focus")
    public final void setFocus(boolean r5) {
        if (n() == true) goto L7;
        if (r5 == false) goto L7;
        this.J = true;
        return;
    L7:
        LynxEditText r10 = null;
        if (r5 == false) goto L25;
        LynxEditText r11 = this.f6402a;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L13:
        if (r11.requestFocus() == true) goto L16;
        LynxLog.b(4, "LynxBaseInputView", "requestFocus failed, input hasSize=" + n());
    L16:
        if (this.D == false) goto L19;
        o();
        return;
    L19:
        h r12 = new h(getLynxContext(), this);
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L23:
        r10.post(r12);
        return;
    L22:
        r10 = r13;
        goto L23
    L25:
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r14 = null;
    L29:
        if (r14.isFocused() == false) goto L38;
        LynxEditText r15 = this.f6402a;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L34:
        r10.clearFocus();
        if (this.D == true) goto L39;
        o();
        return;
    L39:
        return;
    L33:
        r10 = r15;
        goto L34
    }

    @c0(defaultInt = ViewCompat.MEASURED_STATE_MASK, name = "color")
    public final void setFontColor(pm.a r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        ReadableType r10 = r5.getType();
        if (r10 != null) goto L5;
        int r11 = -1;
    L6:
        LynxEditText r12 = null;
        if (r11 != 1) goto L9;
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L22:
        r12.setTextColor(r5.asInt());
        return;
    L21:
        r12 = r13;
        goto L22
    L9:
        if (r11 == 2) goto L12;
        LynxLog.b(3, "LynxBaseInputView", "Not supported color type: " + r5.getType().name());
        return;
    L12:
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L16:
        r12.setTextColor(ColorUtils.b(r5.asString()));
        return;
    L15:
        r12 = r14;
        goto L16
    L5:
        r11 = d.f6437a[r10.ordinal()];
        goto L6
    }

    @c0(name = "font-family")
    public final void setFontFamily(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.f6408k = r5;
        if (this.f6410m == true) goto L7;
        this.f6409l = r5;
        this.f6412o = true;
    L7:
        this.f6411n = true;
    }

    @c0(name = "font-size")
    public final void setFontTextSize(pm.a r12) {
        LynxEditText r5 = null;
        if (r12 != null) goto L9;
        LynxContext r13 = this.mContext;
        if (r13 == null) goto L7;
        DisplayMetrics r10 = r13.f10152u;
    L8:
        this.mFontSize = com.lynx.tasm.utils.k.c("14px", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r10);
    L30:
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L34:
        r5.setTextSize(0, this.mFontSize);
        if (this.e == true) goto L38;
        this.d = this.mFontSize;
        this.f6412o = true;
        return;
    L38:
        return;
    L33:
        r5 = r14;
        goto L34
    L7:
        r10 = null;
        goto L8
    L9:
        ReadableType r11 = r12.getType();
        if (r11 != null) goto L12;
        int r15 = -1;
    L14:
        if (r15 != 2) goto L16;
        String r16 = r12.asString();
        LynxContext r17 = this.mContext;
        if (r17 == null) goto L25;
        DisplayMetrics r18 = r17.f10152u;
    L26:
        this.mFontSize = com.lynx.tasm.utils.k.c(r16, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r18);
        LynxEditText r19 = this.f6402a;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r19 = null;
    L29:
        r19.setTextSize(0, this.mFontSize);
        goto L30
    L25:
        r18 = null;
        goto L26
    L16:
        if (r15 != 3) goto L30;
        this.mFontSize = (float) r12.asDouble();
        LynxEditText r110 = this.f6402a;
        if (r110 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r110 = null;
    L21:
        r110.setTextSize(0, this.mFontSize);
        goto L30
    L12:
        r15 = d.f6437a[r11.ordinal()];
        goto L14
    }

    @c0(name = "font-weight")
    public final void setFontWeight(Integer r5) {
        int r10 = 400;
        if (r5 != null) goto L5;
        this.f6407j = 400;
    L12:
        if (this.f6406i == true) goto L14;
        this.f6405h = this.f6407j;
        this.f6412o = true;
    L14:
        this.f6411n = true;
        return;
    L5:
        int r11 = r5.intValue();
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        r10 = (r5.intValue() - 1) * 100;
        goto L10
    L9:
        r10 = 700;
    L10:
        this.f6407j = r10;
        goto L12
    }

    @f0
    public final void setInputFilter(ReadableMap r5) {
        if (r5 == null) goto L9;
        e r10 = this.C;
        if (r10 == null) goto L8;
        String r11 = r5.getString("pattern");
        Intrinsics.checkNotNullParameter(r11, "pattern");
        r10.f6439b = r11;
        return;
    L8:
        return;
    }

    @c0(name = "type")
    public final void setInputType(String r5) {
        if (r5 != null) goto L4;
        r5 = MessageIndication.CONTENT_TYPE_TEXT;
    L4:
        LynxEditText r10 = this.f6402a;
        LynxEditText r11 = null;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L7:
        i(r10, r5);
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r12 = null;
    L10:
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L13:
        r12.setInputType(r13.getInputType() | 524288);
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L17:
        this.F = r11.getInputType();
        return;
    L16:
        r11 = r14;
        goto L17
    }

    @c0(name = "value")
    public final void setInputValue(String r5) {
        if (r5 != null) goto L4;
        r5 = "";
    L4:
        LynxEditText r10 = this.f6402a;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L8:
        if (Intrinsics.areEqual(r5, String.valueOf(r10.getText())) == false) goto L10;
        return;
    L10:
        this.f6413p = r5;
    }

    @c0(defaultBoolean = false, name = "enableAutoFill")
    public final void setIsAutoFillEnabled(boolean r5) {
        this.I = r5;
        Activity r10 = kk.a.c(getLynxContext());
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.I == false) goto L8;
        r10.getWindow().getDecorView().setImportantForAutofill(1);
        return;
    L8:
        r10.getWindow().getDecorView().setImportantForAutofill(8);
    }

    @c0(defaultBoolean = false, name = "readonly")
    public final void setIsReadOnly(boolean r5) {
        LynxEditText r10 = this.f6402a;
        LynxEditText r11 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L5:
        boolean r12 = !r5;
        r10.setFocusable(r12);
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L9:
        r11.setFocusableInTouchMode(r12);
        return;
    L8:
        r11 = r13;
        goto L9
    }

    @c0(defaultBoolean = true, name = "fullscreen-mode")
    public final void setKeyBoardFullscreenMode(boolean r5) {
        LynxEditText r10 = null;
        if (r5 == true) goto L13;
        LynxEditText r11 = this.f6402a;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L7:
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L11:
        r11.setImeOptions(r10.getImeOptions() | 301989888);
        return;
    L10:
        r10 = r12;
        goto L11
    L13:
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L17:
        r10.setImeOptions(1);
        return;
    L16:
        r10 = r13;
        goto L17
    }

    @c0(defaultFloat = 0.0f, name = "letter-spacing")
    public final void setLetterSpacing(float r5) {
        LynxEditText r10 = this.f6402a;
        LynxEditText r11 = null;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L6:
        if (r10.getTextSize() != 0.0f) goto L9;
        LynxLog.b(3, "LynxBaseInputView", "Input's textSize is 0f.");
        return;
    L9:
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r12 = null;
    L12:
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L16:
        r12.setLetterSpacing(r5 / r11.getTextSize());
        return;
    L15:
        r11 = r13;
        goto L16
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @c0(defaultInt = 3, name = "direction")
    public void setLynxDirection(int r5) {
        this.mLynxDirection = r5;
        LynxEditText r10 = null;
        if (r5 != 0) goto L5;
        LynxEditText r11 = this.f6402a;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L25:
        r10.setTextDirection(5);
        return;
    L24:
        r10 = r11;
        goto L25
    L5:
        if (r5 != 2) goto L7;
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L19:
        r10.setTextDirection(4);
        return;
    L18:
        r10 = r12;
        goto L19
    L7:
        if (r5 == 3) goto L9;
        return;
    L9:
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L13:
        r10.setTextDirection(3);
        return;
    L12:
        r10 = r13;
        goto L13
    }

    @c0(name = "maxlength")
    public final void setMaxLength(pm.a r5) {
        if (r5 != null) goto L4;
        this.f6403b = 140;
    L20:
        if (this.f6403b >= 0) goto L22;
        this.f6403b = Integer.MAX_VALUE;
    L22:
        e r10 = this.C;
        if (r10 == null) goto L26;
        r10.f6438a = this.f6403b;
        return;
    L26:
        return;
    L4:
        ReadableType r11 = r5.getType();
        if (r11 != null) goto L7;
        int r12 = -1;
    L9:
        if (r12 != 1) goto L11;
    L18:
        this.f6403b = r5.asInt();
        goto L20
    L11:
        if (r12 != 2) goto L13;
        this.f6403b = Integer.parseInt(r5.asString());
        goto L20
    L13:
        if (r12 == 3) goto L18;
        if (r12 == 4) goto L18;
        LynxLog.b(3, "LynxBaseInputView", "Not supported length type: " + r5.getType().name());
        goto L20
    L7:
        r12 = d.f6437a[r11.ordinal()];
        goto L9
    }

    @c0(name = "placeholder-style")
    public final void setPlaceHolderStyle(ReadableMap r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.hasKey("color") == false) goto L10;
        pm.a r10 = r5.getDynamic("color");
        if (r10 == null) goto L10;
        setPlaceholderColor(r10);
    L10:
        if (r5.hasKey("font-size") == false) goto L15;
        pm.a r11 = r5.getDynamic("font-size");
        if (r11 == null) goto L15;
        setPlaceholderTextSize(r11);
    L15:
        if (r5.hasKey("font-weight") == false) goto L20;
        pm.a r12 = r5.getDynamic("font-weight");
        if (r12 == null) goto L20;
        setPlaceholderTextWeight(r12);
    L20:
        if (r5.hasKey("font-family") == false) goto L25;
        String r13 = r5.getString("font-family");
        if (r13 == null) goto L26;
        setPlaceholderFontFamily(r13);
        return;
    L26:
        return;
    }

    @c0(name = "placeholder")
    public final void setPlaceholder(String r5) {
        if (r5 != null) goto L4;
        r5 = null;
    L4:
        this.f6404c = r5;
        this.f6412o = true;
    }

    @c0(name = "placeholder-color")
    public final void setPlaceholderColor(pm.a r5) {
        if (r5 != null) goto L6;
        this.f = 0;
        this.g = false;
        return;
    L6:
        this.g = true;
        this.f6412o = true;
        ReadableType r10 = r5.getType();
        if (r10 != null) goto L9;
        int r11 = -1;
    L10:
        if (r11 != 1) goto L12;
    L19:
        this.f = r5.asInt();
        return;
    L12:
        if (r11 != 2) goto L14;
        this.f = ColorUtils.b(r5.asString());
        return;
    L14:
        if (r11 == 4) goto L19;
        LynxLog.b(3, "LynxBaseInputView", "Not supported color type: " + r5.getType().name());
        this.g = false;
        this.f6412o = false;
        return;
    L9:
        r11 = d.f6437a[r10.ordinal()];
        goto L10
    }

    @c0(name = "placeholder-font-family")
    public final void setPlaceholderFontFamily(String r5) {
        if (r5 != null) goto L8;
        this.f6410m = false;
        String r10 = this.f6408k;
        if (r10 == null) goto L7;
        this.f6409l = r10;
    L9:
        this.f6412o = true;
        return;
    L7:
        this.f6409l = null;
        goto L9
    L8:
        this.f6410m = true;
        this.f6409l = r5;
        goto L9
    }

    @c0(name = "placeholder-font-size")
    public final void setPlaceholderTextSize(pm.a r10) {
        if (r10 != null) goto L5;
        this.d = this.mFontSize;
        this.e = false;
    L25:
        this.f6412o = true;
        return;
    L5:
        this.e = true;
        ReadableType r5 = r10.getType();
        if (r5 != null) goto L8;
        int r11 = -1;
    L9:
        if (r11 != 1) goto L11;
    L24:
        this.d = (float) r10.asDouble();
        goto L25
    L11:
        if (r11 != 2) goto L13;
        String r12 = r10.asString();
        LynxContext r13 = this.mContext;
        if (r13 == null) goto L22;
        DisplayMetrics r14 = r13.f10152u;
    L23:
        this.d = com.lynx.tasm.utils.k.c(r12, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r14);
        goto L25
    L22:
        r14 = null;
        goto L23
    L13:
        if (r11 != 3) goto L15;
        this.d = (float) r10.asDouble();
        goto L25
    L15:
        if (r11 == 4) goto L24;
        LynxLog.b(3, "LynxBaseInputView", "Not supported placeholder-font-size type: " + r10.getType().name());
        this.e = false;
        this.d = this.mFontSize;
        goto L25
    L8:
        r11 = d.f6437a[r5.ordinal()];
        goto L9
    }

    @c0(name = "placeholder-font-weight")
    public final void setPlaceholderTextWeight(pm.a r10) {
        if (r10 != null) goto L5;
        this.f6405h = this.f6407j;
        this.f6406i = false;
    L30:
        this.f6412o = true;
        return;
    L5:
        this.f6406i = true;
        ReadableType r5 = r10.getType();
        if (r5 != null) goto L8;
        int r11 = -1;
    L9:
        int r12 = 400;
        if (r11 != 1) goto L12;
    L24:
        int r13 = r10.asInt();
        if (r13 == 0) goto L29;
        if (r13 == 1) goto L28;
        r12 = (r10.asInt() - 1) * 100;
        goto L29
    L28:
        r12 = 700;
    L29:
        this.f6405h = r12;
        goto L30
    L12:
        if (r11 == 2) goto L19;
        if (r11 == 3) goto L24;
        if (r11 == 4) goto L24;
        LynxLog.b(3, "LynxBaseInputView", "Not supported placeholder-font-weight type: " + r10.getType().name());
        this.f6406i = false;
        this.f6405h = this.f6407j;
        goto L30
    L19:
        if (r10.asString().equals("bold") == false) goto L22;
        this.f6405h = 700;
        goto L30
    L22:
        if (r10.asString().equals("normal") == false) goto L30;
        this.f6405h = 400;
        goto L30
    L8:
        r11 = d.f6437a[r5.ordinal()];
        goto L9
    }

    @c0(name = "android-selection-handle-color")
    public final void setSelectionHandleColor(String r10) {
        if (r10 == null) goto L41;
        int r11 = ColorUtils.b(r10);
        LynxEditText r5 = this.f6402a;
        LynxEditText r12 = null;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L7:
        Drawable r13 = r5.getTextSelectHandleLeft();
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r14 = null;
    L10:
        Drawable r15 = r14.getTextSelectHandleRight();
        LynxEditText r16 = this.f6402a;
        if (r16 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r16 = null;
    L13:
        Drawable r17 = r16.getTextSelectHandle();
        if (r13 == null) goto L17;
        r13.setColorFilter(new PorterDuffColorFilter(r11, PorterDuff.Mode.SRC_IN));
    L17:
        if (r13 == null) goto L22;
        LynxEditText r18 = this.f6402a;
        if (r18 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r18 = null;
    L21:
        r18.setTextSelectHandleLeft(r13);
    L22:
        if (r15 == null) goto L25;
        r15.setColorFilter(new PorterDuffColorFilter(r11, PorterDuff.Mode.SRC_IN));
    L25:
        if (r15 == null) goto L30;
        LynxEditText r19 = this.f6402a;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r19 = null;
    L29:
        r19.setTextSelectHandleRight(r15);
    L30:
        if (r17 == null) goto L33;
        r17.setColorFilter(new PorterDuffColorFilter(r11, PorterDuff.Mode.SRC_IN));
    L33:
        if (r17 == null) goto L40;
        LynxEditText r20 = this.f6402a;
        if (r20 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L38:
        r12.setTextSelectHandle(r17);
        return;
    L37:
        r12 = r20;
        goto L38
    L40:
        return;
    }

    @c0(name = "android-selection-highlight-color")
    public final void setSelectionHighLightColor(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        LynxEditText r10 = this.f6402a;
        if (r10 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L7:
        r10.setHighlightColor(ColorUtils.b(r5));
    }

    @f0
    public final void setSelectionRange(ReadableMap r10, Callback r11) {
        if (r10 != null) goto L8;
        if (r11 == null) goto L42;
        r11.invoke(new Object[]{4, "Param is not a map."});
        return;
    L42:
        return;
    L8:
        if (r10.hasKey("selectionStart") == false) goto L10;
        int r5 = r10.getInt("selectionStart");
    L12:
        if (r10.hasKey("selectionEnd") == false) goto L14;
        int r12 = r10.getInt("selectionEnd");
    L15:
        LynxEditText r13 = this.f6402a;
        LynxEditText r14 = null;
        if (r13 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L19:
        if (r13.getText() == null) goto L24;
        LynxEditText r15 = this.f6402a;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r15 = null;
    L23:
        Editable r16 = r15.getText();
        Intrinsics.checkNotNull(r16);
        int r17 = r16.length();
    L25:
        if (r17 == (-1)) goto L39;
        if (r5 > r17) goto L39;
        if (r12 > r17) goto L39;
        if (r5 < 0) goto L39;
        if (r12 < 0) goto L39;
        LynxEditText r18 = this.f6402a;
        if (r18 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L35:
        r14.setSelection(r5, r12);
        if (r11 == null) goto L43;
        r11.invoke(new Object[]{0, "Success."});
        return;
    L43:
        return;
    L34:
        r14 = r18;
    L39:
        if (r11 == null) goto L44;
        r11.invoke(new Object[]{4, "Range does not meet expectations."});
        return;
    L44:
        return;
    L24:
        r17 = -1;
        goto L25
    L14:
        r12 = -1;
        goto L15
    L10:
        r5 = -1;
        goto L12
    }

    @c0(defaultBoolean = true, name = "show-soft-input-onfocus")
    public final void setShowSoftInputOnFocus(boolean r10) {
        LynxEditText r5 = null;
        Method r11 = LynxEditText.class.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});     // Catch: Exception -> L6
        r11.setAccessible(true);     // Catch: Exception -> L26
    L7:
        Activity r12 = kk.a.c(getLynxContext());
        if (r12 != null) goto L10;
        return;
    L10:
        if (r10 == true) goto L18;
        this.D = true;
        this.G = r12.getWindow().getAttributes().softInputMode & 15;
        r12.getWindow().setSoftInputMode((r12.getWindow().getAttributes().softInputMode ^ 15) | 3);
        if (r11 == null) goto L32;
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L17:
        r11.invoke(r5, new Object[]{Boolean.FALSE});
        return;
    L16:
        r5 = r13;
        goto L17
    L32:
        return;
    L18:
        this.D = false;
        r12.getWindow().setSoftInputMode((r12.getWindow().getAttributes().softInputMode ^ 15) | this.G);
        if (r11 == null) goto L34;
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L24:
        r11.invoke(r5, new Object[]{Boolean.TRUE});
        return;
    L23:
        r5 = r14;
        goto L24
    L34:
        return;
    L6:
        r11 = null;
        goto L7
    }

    @c0(defaultBoolean = true, name = "smart-scroll")
    public final void setSmartScroll(boolean r5) {
        o r10 = this.H;
        com.lynx.tasm.behavior.o r11 = r10.f;
        if (r5 == false) goto L11;
        if (r11.d == false) goto L7;
        r10.c();
    L16:
        r10.f6459l = r5;
        return;
    L7:
        if (com.lynx.tasm.utils.j.j() == true) goto L16;
        m r12 = new m(r10, 0);
        com.lynx.tasm.utils.j.a().post(r12);
        goto L16
    L11:
        if (r10.d == null) goto L16;
        LynxEditText r13 = r10.e;
        r11.getClass();
        if (r11.e == null) goto L16;
        r11.f10308k.remove(r13);     // Catch: Exception -> L18
        goto L16
    }

    @c0(name = "android-set-soft-input-mode")
    public final void setSoftInputMode(String r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        int r10 = 0;
        if (Intrinsics.areEqual("unspecified", r5) == false) goto L6;
    L14:
        LynxEditText r11 = this.f6402a;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L17:
        r11.e = r10;
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
        int r10 = m();
        LynxEditText r11 = null;
        if (r5 != 0) goto L5;
        LynxEditText r12 = this.f6402a;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L25:
        r11.setGravity(r10 | 3);
        return;
    L24:
        r11 = r12;
        goto L25
    L5:
        if (r5 != 1) goto L7;
        LynxEditText r13 = this.f6402a;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L19:
        r11.setGravity(r10 | 1);
        return;
    L18:
        r11 = r13;
        goto L19
    L7:
        if (r5 == 2) goto L9;
        return;
    L9:
        LynxEditText r14 = this.f6402a;
        if (r14 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L13:
        r11.setGravity(r10 | 5);
        return;
    L12:
        r11 = r14;
        goto L13
    }

    @f0
    public final void setValue(ReadableMap r5, Callback r10) {
        if (r5 != null) goto L7;
        if (r10 == null) goto L16;
        r10.invoke(new Object[]{4, "Param is not a map."});
        return;
    L16:
        return;
    L7:
        if (r5.hasKey("value") == false) goto L9;
        String r11 = r5.getString("value");
    L11:
        if (r5.hasKey("index") == false) goto L13;
        Integer r12 = Integer.valueOf(r5.getInt("index"));
    L14:
        j(r11, r12, r10);
        return;
    L13:
        r12 = null;
        goto L14
    L9:
        r11 = "";
        goto L11
    }
}
