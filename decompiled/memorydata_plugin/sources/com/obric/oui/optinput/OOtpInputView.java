package com.obric.oui.optinput;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001f*\u0001!\u0018\u0000 \u008e\u00012\u00020\u0001:\b\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0006\u0010@\u001a\u00020>J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020\fH\u0002J\u0015\u0010C\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bFJ\b\u0010G\u001a\u00020\fH\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020\u0007J\r\u0010L\u001a\u00020\fH\u0000¢\u0006\u0002\bMJ\b\u0010N\u001a\u00020>H\u0002J\b\u0010O\u001a\u00020\fH\u0002J\u0006\u0010P\u001a\u00020\fJ\b\u0010Q\u001a\u00020>H\u0002J\b\u0010R\u001a\u00020>H\u0002J\b\u0010S\u001a\u00020>H\u0014J\b\u0010T\u001a\u00020\fH\u0016J\u0012\u0010U\u001a\u00020>2\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J\u0010\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020>H\u0014J\u0010\u0010]\u001a\u00020>2\u0006\u0010^\u001a\u00020_H\u0014J\"\u0010`\u001a\u00020>2\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\u00072\b\u0010c\u001a\u0004\u0018\u00010dH\u0014J\u0018\u0010e\u001a\u00020\f2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020hH\u0016J0\u0010i\u001a\u00020>2\u0006\u0010j\u001a\u00020\f2\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0014J\u0018\u0010o\u001a\u00020>2\u0006\u0010p\u001a\u00020\u00072\u0006\u0010q\u001a\u00020\u0007H\u0014J\u0010\u0010r\u001a\u00020\f2\u0006\u0010g\u001a\u00020sH\u0016J\b\u0010t\u001a\u00020\fH\u0016J\b\u0010u\u001a\u00020>H\u0002J\b\u0010v\u001a\u00020>H\u0002J\u0010\u0010w\u001a\u00020>2\b\b\u0001\u0010x\u001a\u00020\u0007J\u000e\u0010y\u001a\u00020>2\u0006\u0010z\u001a\u00020\nJ\u000e\u0010{\u001a\u00020>2\u0006\u0010z\u001a\u00020\nJ\u0010\u0010|\u001a\u00020>2\b\b\u0001\u0010x\u001a\u00020\u0007J\u000e\u0010}\u001a\u00020>2\u0006\u0010z\u001a\u00020\nJ\u0010\u0010~\u001a\u00020>2\b\u0010\u007f\u001a\u0004\u0018\u00010JJ\u000f\u0010\u0080\u0001\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0007J\u0011\u0010\u0081\u0001\u001a\u00020>2\b\b\u0001\u0010x\u001a\u00020\u0007J\u0010\u0010\u0082\u0001\u001a\u00020>2\u0007\u0010\u0083\u0001\u001a\u00020\fJ\u0010\u0010\u0084\u0001\u001a\u00020>2\u0007\u0010\u0085\u0001\u001a\u00020\fJ\u0011\u0010\u0086\u0001\u001a\u00020>2\b\b\u0001\u0010x\u001a\u00020\u0007J\u0010\u0010\u0087\u0001\u001a\u00020>2\u0007\u0010\u0088\u0001\u001a\u00020\nJ\t\u0010\u0089\u0001\u001a\u00020\fH\u0002J\t\u0010\u008a\u0001\u001a\u00020>H\u0002J\t\u0010\u008b\u0001\u001a\u00020>H\u0002J\t\u0010\u008c\u0001\u001a\u00020>H\u0002J\t\u0010\u008d\u0001\u001a\u00020>H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0012\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0092\u0001"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "actualCellSpacing", "", "blinkStarted", "", "boxPaintFill", "Landroid/graphics/Paint;", "boxPaintStroke", "cellBackgroundColor", "cellCenterY", "cellCornerRadius", "cellHeight", "cellRect", "Landroid/graphics/RectF;", "cellSpacing", "cellStrokeColor", "cellStrokeWidth", "cellWidth", "cellsStartX", "cellsTop", "codeChars", "", "codeLength", "cursorBlinkOn", "cursorBlinkRunnable", "com/obric/oui/optinput/OOtpInputView$cursorBlinkRunnable$1", "Lcom/obric/oui/optinput/OOtpInputView$cursorBlinkRunnable$1;", "cursorColor", "cursorHalfWidth", "cursorPaint", "cursorVisible", "inputIndex", "onCodeChangeListener", "Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "getOnCodeChangeListener", "()Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "setOnCodeChangeListener", "(Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;)V", "onCodeCompleteListener", "Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "getOnCodeCompleteListener", "()Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "setOnCodeCompleteListener", "(Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;)V", "oneCharArray", "passwordCircleRadius", "passwordMode", "textCenterYOffset", "textColor", "textFontMetrics", "Landroid/graphics/Paint$FontMetrics;", "textPaint", "textSizePx", "applyCodeLengthFromAttribute", "", XSDatatype.FACET_LENGTH, "clear", "clearInternal", "silence", "commitTextFromIme", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "commitTextFromIme$OUI_standardRelease", "deleteLastChar", "findFirstEmptyIndex", "getCode", "", "getCodeLength", "handleDeleteFromIme", "handleDeleteFromIme$OUI_standardRelease", "hideKeyboard", "isCodeComplete", "isPasswordMode", "notifyCodeChanged", "notifyCodeComplete", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "Landroid/graphics/Rect;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "Landroid/view/MotionEvent;", "performClick", "refreshDimensionCache", "restartInput", "setCellBackgroundColor", TypedValues.Custom.S_COLOR, "setCellCornerRadius", "px", "setCellSpacing", "setCellStrokeColor", "setCellStrokeWidth", "setCode", "code", "setCodeLength", "setCursorColor", "setCursorVisible", "visible", "setPasswordMode", "enabled", "setTextColor", "setTextSizeSp", "sp", "shouldDrawCursor", "showKeyboard", "startBlink", "stopBlink", "updateTextMetrics", "Companion", "OnCodeChangeListener", "OnCodeCompleteListener", "OtpInputConnection", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OOtpInputView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14028a = null;
    private float A;
    private float B;
    private float C;
    private float D;
    private boolean E;
    private boolean F;
    private final e G;
    private c H;
    private b I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14029b;
    private char[] c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private int k;
    private int l;
    private float m;
    private int n;
    private boolean o;
    private boolean p;
    private final Paint q;
    private final Paint r;
    private final Paint s;
    private final Paint t;
    private final RectF u;
    private final Paint.FontMetrics v;
    private float w;
    private final char[] x;
    private float y;
    private float z;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$Companion;", "", "()V", "CIRCLE_RADIUS", "", "CURSOR_HEIGHT_FACTOR", "CURSOR_WIDTH", "DEFAULT_BLINK_INTERVAL", "", "DEFAULT_CELL_HEIGHT_DP", "DEFAULT_CELL_RADIUS_DP", "DEFAULT_CELL_SPACING_DP", "DEFAULT_CELL_STROKE_DP", "DEFAULT_CELL_WIDTH_DP", "DEFAULT_CODE_LENGTH", "", "DEFAULT_TEXT_SIZE_SP", "EMPTY_CHAR", "", "MAX_CODE_LENGTH", "MIN_CODE_LENGTH", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$OnCodeChangeListener;", "", "onCodeChange", "", "code", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(String r1);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$OnCodeCompleteListener;", "", "onCodeComplete", "", "code", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(String r1);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/optinput/OOtpInputView$OtpInputConnection;", "Landroid/view/inputmethod/BaseInputConnection;", "view", "Lcom/obric/oui/optinput/OOtpInputView;", "(Lcom/obric/oui/optinput/OOtpInputView;)V", "commitText", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "newCursorPosition", "", "deleteSurroundingText", "beforeLength", "afterLength", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class d extends BaseInputConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OOtpInputView f14030a;

        public d(OOtpInputView r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            super((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"), false);
            this.f14030a = r3;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence r2, int r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            if (r0 == false) goto L11;
            return true;
        L11:
            this.f14030a.a(r4);
            return true;
        L5:
            if (r4.length() == 0) goto L8;
            r0 = false;
            goto L9
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int r2, int r3) {
            if (this.f14030a.a() == false) goto L6;
            return true;
        L6:
            return super.deleteSurroundingText(r2, r3);
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            if (r4.getAction() != 0) goto L14;
            if (r4.getKeyCode() == 67) goto L7;
            char r0 = (char) r4.getUnicodeChar();
            if (Character.isDigit(r0) == false) goto L14;
            this.f14030a.a((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r0), CharSequence.class, "com.obric.memorydata.plugin"));
            return true;
        L7:
            if (this.f14030a.a() == false) goto L14;
            return true;
        L14:
            return super.sendKeyEvent(r4);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/oui/optinput/OOtpInputView$cursorBlinkRunnable$1", "Ljava/lang/Runnable;", "run", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OOtpInputView f14031a;

        e(OOtpInputView r1) {
            this.f14031a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OOtpInputView.a(this.f14031a) == true) goto L5;
            return;
        L5:
            OOtpInputView r0 = this.f14031a;
            OOtpInputView.a(r0, !OOtpInputView.b(r0));
            this.f14031a.invalidate();
            this.f14031a.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), 500);
        }
    }

    static {
        f14028a = new a(null);
    }

    public OOtpInputView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OOtpInputView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OOtpInputView(Context r11, AttributeSet r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r15, r13);
        this.f14029b = 6;
        this.c = new char[6];
        Paint r3 = new Paint(1);
        this.q = r3;
        Paint r5 = new Paint(1);
        this.r = r5;
        Paint r6 = new Paint(1);
        this.s = r6;
        Paint r7 = new Paint(1);
        this.t = r7;
        this.u = new RectF();
        this.v = new Paint.FontMetrics();
        this.x = new char[1];
        this.E = true;
        this.G = new e(this);
        b();
        this.e = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 42.0f);
        this.f = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 48.0f);
        this.g = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12.0f);
        this.h = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 10.0f);
        this.i = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1.0f);
        this.m = h.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 20.0f);
        this.j = ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.oui_advanced_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_advanced_fill_list_item_card"));
        this.k = ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.oui_advanced_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_advanced_fill_list_item_card"));
        this.l = ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.oui_basic_text_1, TypedValues.Custom.S_COLOR, "oui_basic_text_1"));
        this.n = ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(R.color.oui_functional_blue_6, TypedValues.Custom.S_COLOR, "oui_functional_blue_6"));
        this.o = false;
        this.p = true;
        if (r15 == null) goto L10;
        TypedArray r16 = r14.obtainStyledAttributes(r15, R.styleable.OOtpInputView, r13, 0);
        Intrinsics.checkNotNullExpressionValue(r16, "context.obtainStyledAttr…putView, defStyleAttr, 0)");
        a(r16.getInt(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCodeLength, "styleable", "OOtpInputView_o_otpCodeLength"), 6));     // Catch: Throwable -> L7
        this.e = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellWidth, "styleable", "OOtpInputView_o_otpCellWidth"), this.e);     // Catch: Throwable -> L7
        this.f = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellHeight, "styleable", "OOtpInputView_o_otpCellHeight"), this.f);     // Catch: Throwable -> L7
        this.g = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellSpacing, "styleable", "OOtpInputView_o_otpCellSpacing"), this.g);     // Catch: Throwable -> L7
        this.h = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellCornerRadius, "styleable", "OOtpInputView_o_otpCellCornerRadius"), this.h);     // Catch: Throwable -> L7
        this.i = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellStrokeWidth, "styleable", "OOtpInputView_o_otpCellStrokeWidth"), this.i);     // Catch: Throwable -> L7
        this.j = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellBackgroundColor, "styleable", "OOtpInputView_o_otpCellBackgroundColor"), this.j);     // Catch: Throwable -> L7
        this.k = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCellStrokeColor, "styleable", "OOtpInputView_o_otpCellStrokeColor"), this.k);     // Catch: Throwable -> L7
        this.l = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpTextColor, "styleable", "OOtpInputView_o_otpTextColor"), this.l);     // Catch: Throwable -> L7
        this.m = r16.getDimension(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpTextSize, "styleable", "OOtpInputView_o_otpTextSize"), this.m);     // Catch: Throwable -> L7
        this.n = r16.getColor(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCursorColor, "styleable", "OOtpInputView_o_otpCursorColor"), this.n);     // Catch: Throwable -> L7
        this.o = r16.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpPasswordMode, "styleable", "OOtpInputView_o_otpPasswordMode"), this.o);     // Catch: Throwable -> L7
        this.p = r16.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OOtpInputView_o_otpCursorVisible, "styleable", "OOtpInputView_o_otpCursorVisible"), this.p);     // Catch: Throwable -> L7
        r16.recycle();
    L7:
        th = move-exception;
        r16.recycle();
        throw th;
    L10:
        setFocusable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        r3.setStyle(Paint.Style.FILL);
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(this.i);
        r6.setColor(this.l);
        r6.setTextSize(this.m);
        r6.setTextAlign(Paint.Align.CENTER);
        if (Build.VERSION.SDK_INT < 28) goto L13;
        Typeface r17 = Typeface.create(Typeface.DEFAULT, 400, false);
    L14:
        r6.setTypeface(r17);
        r7.setColor(this.n);
        r7.setStyle(Paint.Style.FILL);
        d();
        return;
    L13:
        r17 = Typeface.create(Typeface.DEFAULT, 0);
        goto L14
    }

    public /* synthetic */ OOtpInputView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final void a(int r3) {
        int r4 = RangesKt.coerceIn(r3, 1, 6);
        if (r4 != this.f14029b) goto L5;
        return;
    L5:
        this.f14029b = r4;
        this.c = new char[r4];
        this.d = 0;
    }

    public static final /* synthetic */ void a(OOtpInputView r0, boolean r1) {
        r0.E = r1;
    }

    private final void a(boolean r6) {
        int r0 = this.f14029b;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        this.c[r2] = 0;
        r2 = r2 + 1;
        goto L3
    L5:
        this.d = 0;
        if (r6 == true) goto L10;
        h();
        invalidate();
        return;
    }

    public static final /* synthetic */ boolean a(OOtpInputView r0) {
        return r0.F;
    }

    private final void b() {
        this.C = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4.0f);
        this.D = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1.0f);
    }

    public static final /* synthetic */ boolean b(OOtpInputView r0) {
        return r0.E;
    }

    private final boolean c() {
        if (isFocused() == true) goto L5;
    L15:
        return false;
    L5:
        if (this.p == false) goto L15;
        if (this.E == true) goto L11;
        return false;
    L11:
        if (this.d < this.f14029b) goto L13;
        return false;
    L13:
        return true;
    }

    private final void d() {
        this.s.getFontMetrics(this.v);
        this.w = -((this.v.ascent + this.v.descent) / 2.0f);
    }

    private final boolean e() {
        int r0 = this.d;
        if (r0 > 0) goto L5;
        return false;
    L5:
        int r1 = RangesKt.coerceAtLeast(r0 - 1, 0);
        char[] r3 = this.c;
        if (r3[r1] != 0) goto L18;
        if (r1 < 0) goto L16;
    L8:
        int r4 = r1 - 1;
        char[] r5 = this.c;
        if (r5[r1] != 0) goto L10;
        if (r4 < 0) goto L16;
        r1 = r4;
        goto L8
    L10:
        r5[r1] = 0;
    L11:
        this.d = r1;
        return true;
    L16:
        this.d = 0;
        return false;
    L18:
        r3[r1] = 0;
        goto L11
    }

    private final boolean f() {
        if (this.d < this.f14029b) goto L5;
        return true;
    L5:
        return false;
    }

    private final void g() {
        c r0 = this.H;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(getCode());
    }

    private final void h() {
        b r0 = this.I;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(getCode());
    }

    private final int i() {
        int r0 = this.f14029b;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r2 = r1 + 1;
        if (this.c[r1] == 0) goto L6;
        r1 = r2;
        goto L3
    L6:
        return r1;
    L9:
        return this.f14029b;
    }

    private final void j() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.restartInput((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void k() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.showSoftInput((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void l() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void m() {
        if (this.F == false) goto L5;
        return;
    L5:
        this.F = true;
        this.E = true;
        removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.G, Runnable.class, "com.obric.memorydata.plugin"));
        postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this.G, Runnable.class, "com.obric.memorydata.plugin"), 500);
    }

    private final void n() {
        this.F = false;
        removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.G, Runnable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        if (f() == false) goto L5;
        return;
    L5:
        int r0 = 0;
        boolean r1 = true;
        boolean r2 = false;
    L7:
        if (r0 >= r8.length()) goto L18;
        char r3 = r8.charAt(r0);
        r0 = r0 + 1;
        if (Character.isDigit(r3) == false) goto L7;
        int r4 = this.d;
        int r5 = this.f14029b;
        if (r4 >= r5) goto L18;
        this.c[r4] = r3;
        int r6 = r4 + 1;
        this.d = r6;
        if (r6 >= r5) goto L19;
        r2 = true;
    L19:
        if (r1 == false) goto L31;
        h();
        invalidate();
        if (f() == false) goto L32;
        g();
        return;
    L32:
        return;
    L31:
        return;
    L18:
        r1 = r2;
        goto L19
    }

    public final boolean a() {
        boolean r0 = e();
        if (r0 == false) goto L5;
        h();
        invalidate();
    L5:
        return r0;
    }

    public final String getCode() {
        StringBuilder r0 = new StringBuilder(this.f14029b);
        int r1 = this.f14029b;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L7;
        int r3 = r2 + 1;
        char r4 = this.c[r2];
        if (r4 == 0) goto L7;
        r0.append(r4);
        r2 = r3;
    L7:
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "builder.toString()");
        return r5;
    }

    public final int getCodeLength() {
        return this.f14029b;
    }

    public final b getOnCodeChangeListener() {
        return this.I;
    }

    public final c getOnCodeCompleteListener() {
        return this.H;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isFocusable() == false) goto L10;
        if (isFocusableInTouchMode() == false) goto L10;
        if (isInEditMode() == true) goto L10;
        requestFocus();
        k();
    L10:
        if (hasFocus() == true) goto L12;
        return;
    L12:
        if (this.p == false) goto L16;
        m();
        return;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        b();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "outAttrs");
        if (this.o == false) goto L5;
        int r0 = 16;
    L6:
        r2.inputType = r0 | 2;
        r2.imeOptions = 268435462;
        r2.initialSelStart = this.d;
        r2.initialSelEnd = this.d;
        return (InputConnection) ZeusTransformUtils.preCheckCast(new d(this), InputConnection.class, "com.obric.memorydata.plugin");
    L5:
        r0 = 0;
        goto L6
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n();
    }

    @Override // android.view.View
    public void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        this.q.setColor(this.j);
        this.r.setColor(this.k);
        int r0 = this.f14029b;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L16;
        int r4 = r2 + 1;
        float r5 = this.y;
        float r7 = this.e;
        float r6 = r5 + (r2 * (this.B + r7));
        float r8 = this.z;
        float r9 = this.f + r8;
        this.u.set(r6, r8, r7 + r6, r9);
        RectF r10 = this.u;
        float r11 = this.h;
        r13.drawRoundRect(r10, r11, r11, this.q);
        float r12 = this.i;
        if (r12 <= 0.0f) goto L8;
        float r14 = r12 / 2.0f;
        float r3 = RangesKt.coerceAtLeast(this.h - r14, 0.0f);
        this.u.inset(r14, r14);
        r13.drawRoundRect(this.u, r3, r3, this.r);
        float r15 = -r14;
        this.u.inset(r15, r15);
    L8:
        char r16 = this.c[r2];
        if (r16 == 0) goto L14;
        float r17 = this.u.centerX();
        if (this.o == false) goto L13;
        r13.drawCircle(r17, this.A, this.C, this.s);
        goto L14
    L13:
        char[] r18 = this.x;
        r18[0] = r16;
        r13.drawText(r18, 0, 1, r17, this.A + this.w, this.s);
    L14:
        r2 = r4;
        goto L4
    L16:
        if (c() == false) goto L23;
        int r1 = RangesKt.coerceIn(this.d, 0, this.f14029b - 1);
        float r19 = this.y;
        float r20 = this.e;
        float r21 = r19 + (r1 * (this.B + r20));
        float r22 = (r21 + (r20 + r21)) / 2.0f;
        float r23 = this.f * 0.375f;
        float r24 = this.A;
        float r25 = r23 / 2.0f;
        float r26 = r24 - r25;
        float r27 = r24 + r25;
        float r28 = this.D;
        r13.drawRect(r22 - r28, r26, r22 + r28, r27, this.t);
        return;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r1, int r2, Rect r3) {
        super.onFocusChanged(r1, r2, r3);
        if (r1 == true) goto L5;
        n();
        l();
    L9:
        invalidate();
        return;
    L5:
        if (this.p == false) goto L7;
        m();
    L7:
        k();
        goto L9
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r5, KeyEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (r5 == 67) goto L5;
    L7:
        int r2 = 7;
        if (r5 >= 7) goto L10;
    L13:
        r2 = 144;
        if (r5 < 144) goto L19;
        if (r5 > 153) goto L19;
    L11:
        a((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf((char) ((r5 - r2) + 48)), CharSequence.class, "com.obric.memorydata.plugin"));
        return true;
    L19:
        return super.onKeyDown(r5, r6);
    L10:
        if (r5 > 16) goto L13;
    L5:
        if (a() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        super.onLayout(r4, r5, r6, r7, r8);
        int r9 = ((r7 - r5) - getPaddingLeft()) - getPaddingRight();
        int r10 = ((r8 - r6) - getPaddingTop()) - getPaddingBottom();
        float r11 = this.g;
        float r12 = this.e;
        int r13 = this.f14029b;
        float r14 = r9;
        if (((r13 * r12) + ((r13 - 1) * r11)) <= r14) goto L8;
        if (r13 <= 1) goto L8;
        r11 = (r14 - (r13 * r12)) / (r13 - 1);
        if (r11 >= 0.0f) goto L8;
        r11 = 0.0f;
    L8:
        this.B = r11;
        this.y = getPaddingLeft() + ((r14 - ((r12 * r13) + (r11 * (r13 - 1)))) / 2.0f);
        float r15 = getPaddingTop();
        float r16 = this.f;
        float r17 = r15 + ((r10 - r16) / 2.0f);
        this.z = r17;
        this.A = r17 + (r16 / 2.0f);
    }

    @Override // android.view.View
    public void onMeasure(int r4, int r5) {
        float r0 = this.e;
        int r1 = this.f14029b;
        setMeasuredDimension(View.resolveSize((int) ((getPaddingLeft() + getPaddingRight()) + ((r0 * r1) + (this.g * (r1 - 1)))), r4), View.resolveSize((int) ((getPaddingTop() + getPaddingBottom()) + this.f), r5));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
        performClick();
        return true;
    L6:
        return super.onTouchEvent(r3);
    L9:
        requestFocus();
        k();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public final void setCellBackgroundColor(int r2) {
        if (this.j != r2) goto L5;
        return;
    L5:
        this.j = r2;
        invalidate();
    }

    public final void setCellCornerRadius(float r2) {
        if (this.h != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.h = r2;
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCellSpacing(float r2) {
        if (this.g != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.g = r2;
        requestLayout();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCellStrokeColor(int r2) {
        if (this.k != r2) goto L5;
        return;
    L5:
        this.k = r2;
        invalidate();
    }

    public final void setCellStrokeWidth(float r2) {
        if (this.i != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.i = r2;
        this.r.setStrokeWidth(r2);
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCode(String r5) {
        boolean r0 = true;
        a(true);
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        if (r0 == false) goto L11;
        invalidate();
        return;
    L11:
        int r3 = 0;
    L13:
        if (r2 >= r5.length()) goto L21;
        char r4 = r5.charAt(r2);
        r2 = r2 + 1;
        if (Character.isDigit(r4) == false) goto L13;
        if (r3 >= this.f14029b) goto L21;
        this.c[r3] = r4;
        r3 = r3 + 1;
    L21:
        this.d = r3;
        h();
        invalidate();
        if (f() == false) goto L31;
        g();
        return;
    L31:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r0 = false;
        goto L8
    }

    public final void setCodeLength(int r6) {
        int r7 = RangesKt.coerceIn(r6, 1, 6);
        if (r7 != this.f14029b) goto L5;
        return;
    L5:
        this.f14029b = r7;
        char[] r0 = this.c;
        this.c = new char[r7];
        int r8 = Math.min(r0.length, r7);
        int r1 = 0;
    L6:
        if (r1 >= r8) goto L8;
        this.c[r1] = r0[r1];
        r1 = r1 + 1;
        goto L6
    L8:
        this.d = i();
        requestLayout();
        invalidate();
    }

    public final void setCursorColor(int r2) {
        if (this.n != r2) goto L5;
        return;
    L5:
        this.n = r2;
        this.t.setColor(r2);
        invalidate();
    }

    public final void setCursorVisible(boolean r2) {
        if (this.p != r2) goto L5;
        return;
    L5:
        this.p = r2;
        if (r2 == true) goto L9;
        n();
    L11:
        invalidate();
        return;
    L9:
        if (hasFocus() == false) goto L11;
        m();
        goto L11
    }

    public final void setOnCodeChangeListener(b r3) {
        this.I = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
    }

    public final void setOnCodeCompleteListener(c r3) {
        this.H = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public final void setPasswordMode(boolean r2) {
        if (this.o != r2) goto L5;
        return;
    L5:
        this.o = r2;
        invalidate();
        j();
    }

    public final void setTextColor(int r2) {
        if (this.l != r2) goto L5;
        return;
    L5:
        this.l = r2;
        this.s.setColor(r2);
        invalidate();
    }

    public final void setTextSizeSp(float r3) {
        float r4 = h.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r3);
        if (this.m != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.m = r4;
        this.s.setTextSize(r4);
        d();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }
}
