package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.divider.ODivider;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 º\u00012\u00020\u0001:\b»\u0001¼\u0001½\u0001¾\u0001B9\b\u0007\u0012\b\u0010´\u0001\u001a\u00030³\u0001\u0012\f\b\u0002\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u0001\u0012\t\b\u0002\u0010·\u0001\u001a\u00020\u0010\u0012\t\b\u0002\u0010®\u0001\u001a\u00020\u0010¢\u0006\u0006\b¸\u0001\u0010¹\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0014J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ&\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001eJ\u0010\u0010#\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010&\u001a\u00020\u0002J\u0006\u0010'\u001a\u00020\u0002J\u0006\u0010(\u001a\u00020\u0002J\u0006\u0010)\u001a\u00020\u0002J\u0010\u0010*\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010\u001aJ\u0006\u0010+\u001a\u00020\u0002J\u0006\u0010,\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020\u0002J\u0006\u0010.\u001a\u00020\u0002J\u0006\u0010/\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\u0002J\u0006\u00101\u001a\u00020\u0002J\u0006\u00102\u001a\u00020\u0002J\u0006\u00103\u001a\u00020\u0002J\u0006\u00104\u001a\u00020\u0002J\u0006\u00105\u001a\u00020\u0002J\u0006\u00106\u001a\u00020\u0002J\u0006\u00107\u001a\u00020\u0002J\u0006\u00108\u001a\u00020\u0002J\u0006\u00109\u001a\u00020\u0002J\u0006\u0010:\u001a\u00020\u0002J\u0006\u0010;\u001a\u00020\u0002J\u0006\u0010<\u001a\u00020\u0002J\u0006\u0010=\u001a\u00020\u0002J\u000e\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020>J@\u0010H\u001a\u00020\u000228\u0010G\u001a4\u0012\u0015\u0012\u0013\u0018\u00010B¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00020AJ\b\u0010J\u001a\u00020IH\u0016J\u000e\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020KJ)\u0010P\u001a\u00020\u00022!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00020NJ\u000e\u0010S\u001a\u00020\u00022\u0006\u0010R\u001a\u00020QJ\u0010\u0010V\u001a\u00020\u00022\b\u0010U\u001a\u0004\u0018\u00010TR\u0019\u0010X\u001a\u00020W8\u0006@\u0006¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0019\u0010]\u001a\u00020\\8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0019\u0010d\u001a\u00020c8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0019\u0010i\u001a\u00020h8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u0019\u0010n\u001a\u00020m8\u0006@\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010sR\u0016\u0010u\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0019\u0010x\u001a\u00020w8\u0006@\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u0019\u0010|\u001a\u00020\\8\u0006@\u0006¢\u0006\f\n\u0004\b|\u0010^\u001a\u0004\b}\u0010`R\u0019\u0010~\u001a\u00020w8\u0006@\u0006¢\u0006\f\n\u0004\b~\u0010y\u001a\u0004\b\u007f\u0010{R,\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u0087\u0001\u001a\u00020\\8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010^\u001a\u0005\b\u0088\u0001\u0010`R\u0019\u0010\u0089\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008b\u0001\u001a\u00020W8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010Y\u001a\u0005\b\u008c\u0001\u0010[R\u0019\u0010\u008d\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008a\u0001R\u001c\u0010\u008e\u0001\u001a\u00020m8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010o\u001a\u0005\b\u008f\u0001\u0010qR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010vR\u0019\u0010\u0090\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u008a\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u008a\u0001R,\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0082\u0001\u001a\u0006\b\u0093\u0001\u0010\u0084\u0001\"\u0006\b\u0094\u0001\u0010\u0086\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u008a\u0001R\u0018\u0010\u0096\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0096\u0001\u0010vR\u001c\u0010\u0097\u0001\u001a\u00020W8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010Y\u001a\u0005\b\u0098\u0001\u0010[R\u001c\u0010\u0099\u0001\u001a\u00020h8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0099\u0001\u0010j\u001a\u0005\b\u009a\u0001\u0010lR\u0019\u0010\u009b\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u008a\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u008a\u0001R\u001c\u0010\u009d\u0001\u001a\u00020W8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u009d\u0001\u0010Y\u001a\u0005\b\u009e\u0001\u0010[R\u0019\u0010\u009f\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010\u008a\u0001R\u001c\u0010 \u0001\u001a\u00020w8\u0006@\u0006¢\u0006\u000e\n\u0005\b \u0001\u0010y\u001a\u0005\b¡\u0001\u0010{R\u001b\u0010¢\u0001\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0019\u0010¤\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010\u008a\u0001R\u0019\u0010¥\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u008a\u0001R\u001f\u0010§\u0001\u001a\u00030¦\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010«\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082D¢\u0006\u0007\n\u0005\b«\u0001\u0010sR\u001c\u0010¬\u0001\u001a\u00020W8\u0006@\u0006¢\u0006\u000e\n\u0005\b¬\u0001\u0010Y\u001a\u0005\b\u00ad\u0001\u0010[R(\u0010®\u0001\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b®\u0001\u0010s\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001¨\u0006¿\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView;", "Lcom/obric/oui/forms/AbsOForm;", "", "refreshConfig", "showSoftInput", "hideSoftInput", "clear", "", "enable", "enableVerticalScrollBar", "enabled", "setEnabled", "onAttachedToWindow", "Landroid/graphics/drawable/Drawable;", "drawable", "setInputContainerBackground", "", "left", "top", "right", "bottom", "setInputContainerPadding", "mode", "Landroid/view/View$OnClickListener;", "clickListener", "setMode", "", "getText", "text", "setText", "Lcom/obric/oui/forms/OLineInputView$b;", "getConfig", "newConfig", "updateConfig", "flag", "setAutoHideClearWhenTextEmpty", "tips", "showErrorTips", "setInputViewNormal", "setInputViewActived", "setInputViewError", "hideErrorTips", "showInputTips", "hideInputTips", "showTitleIcon", "hideTitleIcon", "setSmallTitleIcon", "setMiddleTitleIcon", "showTitle", "hideTitle", "showClear", "hideClear", "showActionImage", "hideActionImage", "showPrefixView", "hidePrefixView", "showSuffixView", "hideSuffixView", "showDivider", "hideDivider", "showActionText", "hideActionText", "Landroid/view/View$OnFocusChangeListener;", "listener", "setEditTextOnFocusChangeListener", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, BaseSwitches.V, "hasFocus", "handler", "editTextOnFocusChangeListener", "Landroid/widget/EditText;", "getInterEditText", "Lcom/obric/oui/forms/OLineInputView$d;", "textExceedLengthListener", "setTextExceedLengthListener", "Lkotlin/Function1;", "s", "onTextExceedLengthListener", "Lcom/obric/oui/forms/OLineInputView$c;", "textClearedListener", "setTextClearedListener", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "Landroid/widget/TextView;", "tvInputTips", "Landroid/widget/TextView;", "getTvInputTips", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "ivClear", "Landroid/widget/ImageView;", "getIvClear", "()Landroid/widget/ImageView;", "config", "Lcom/obric/oui/forms/OLineInputView$b;", "Lcom/obric/oui/forms/OFormEditText;", "editText", "Lcom/obric/oui/forms/OFormEditText;", "getEditText", "()Lcom/obric/oui/forms/OFormEditText;", "Landroid/widget/RelativeLayout;", "suffixContainer", "Landroid/widget/RelativeLayout;", "getSuffixContainer", "()Landroid/widget/RelativeLayout;", "Landroid/widget/LinearLayout;", "ivActionContainer", "Landroid/widget/LinearLayout;", "getIvActionContainer", "()Landroid/widget/LinearLayout;", "titleDefaultIconSize", "I", "textGravity", "inputTips", "Ljava/lang/String;", "Landroid/view/ViewGroup;", "actionContainer", "Landroid/view/ViewGroup;", "getActionContainer", "()Landroid/view/ViewGroup;", "ivAction", "getIvAction", "titleContainer", "getTitleContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "activeBorderView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getActiveBorderView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setActiveBorderView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "ivTitleIcon", "getIvTitleIcon", "isErrorState", "Z", "tvCounter", "getTvCounter", "showTitleDefaultIcon", "ivClearContainer", "getIvClearContainer", "isShowTitle", "isShowErrorTips", "leftContainer", "getLeftContainer", "setLeftContainer", "isShowSuffix", "errorTips", "tvErrorTips", "getTvErrorTips", "prefixContainer", "getPrefixContainer", "isShowTitleIcon", "isShowActionImage", "tvAction", "getTvAction", "isShowInputTips", "inputContainer", "getInputContainer", "counterTextWatcher", "Landroid/text/TextWatcher;", "isShowActionText", "isShowPrefix", "Lcom/obric/oui/divider/ODivider;", "divider", "Lcom/obric/oui/divider/ODivider;", "getDivider", "()Lcom/obric/oui/divider/ODivider;", "DEFAULT_MAX_LINES", "tvTitle", "getTvTitle", "arrangeDirection", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "a", "b", "c", "d", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OLineInputView extends AbsOForm {
    public static final int ARRANGE_DIRECTION_HORIZONTAL = 1;
    public static final int ARRANGE_DIRECTION_VERTICAL = 0;
    public static final int ARRANGE_DIRECTION_VERTICAL_SINGEL_BOX = 2;
    public static final int CLICK_MODE = 3;
    public static final a Companion = null;
    public static final int INPUT_MODE = 2;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    private final int DEFAULT_MAX_LINES;
    private final ViewGroup actionContainer;
    private ConstraintLayout activeBorderView;
    private int arrangeDirection;
    private b config;
    private TextWatcher counterTextWatcher;
    private final ODivider divider;
    private final OFormEditText editText;
    private String errorTips;
    private final ViewGroup inputContainer;
    private String inputTips;
    private boolean isErrorState;
    private boolean isShowActionImage;
    private boolean isShowActionText;
    private boolean isShowErrorTips;
    private boolean isShowInputTips;
    private boolean isShowPrefix;
    private boolean isShowSuffix;
    private boolean isShowTitle;
    private boolean isShowTitleIcon;
    private final ImageView ivAction;
    private final LinearLayout ivActionContainer;
    private final ImageView ivClear;
    private final LinearLayout ivClearContainer;
    private final ImageView ivTitleIcon;
    private ConstraintLayout leftContainer;
    private final RelativeLayout prefixContainer;
    private boolean showTitleDefaultIcon;
    private final RelativeLayout suffixContainer;
    private String text;
    private int textGravity;
    private final ViewGroup titleContainer;
    private int titleDefaultIconSize;
    private final TextView tvAction;
    private final TextView tvCounter;
    private final TextView tvErrorTips;
    private final TextView tvInputTips;
    private final TextView tvTitle;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f6625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f6626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f6627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f6628e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private View f6629f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Integer f6630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f6631h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f6632i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private TextWatcher f6633j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private View.OnFocusChangeListener f6634k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f6635l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Drawable f6636m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private View.OnClickListener f6637n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private View.OnClickListener f6638o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private String f6639p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private Integer f6640q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private Integer f6641r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private Drawable f6642s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f6643t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private boolean f6644u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private boolean f6645v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private int f6646w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private boolean f6647x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private d f6648y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private c f6649z;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f6650a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f6651b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Drawable f6652c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f6653d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Integer f6654e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f6655f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private String f6656g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private View f6657h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private View f6658i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private boolean f6659j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private String f6660k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            private Integer f6661l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            private boolean f6662m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            private View.OnClickListener f6663n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            private Drawable f6664o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            private View.OnClickListener f6665p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            private TextWatcher f6666q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            private View.OnFocusChangeListener f6667r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            private Integer f6668s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            private boolean f6669t;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            private boolean f6670u;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            private boolean f6671v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            private int f6672w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            private boolean f6673x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            private d f6674y;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            private c f6675z;

            public a() {
                this(null, null, null, false, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, false, 0, false, null, null, 67108863, null);
            }

            public a(String r10, String r11, Drawable r12, boolean r13, Integer r14, boolean r15, String r16, View r17, View r18, boolean r19, String r110, Integer r111, boolean r112, View.OnClickListener r113, Drawable r114, View.OnClickListener r115, TextWatcher r20, View.OnFocusChangeListener r21, Integer r22, boolean r23, boolean r24, boolean r25, int r26, boolean r27, d r28, c r29) {
                Intrinsics.checkNotNullParameter(r10, "title");
                this.f6650a = r10;
                this.f6651b = r11;
                this.f6652c = r12;
                this.f6653d = r13;
                this.f6654e = r14;
                this.f6655f = r15;
                this.f6656g = r16;
                this.f6657h = r17;
                this.f6658i = r18;
                this.f6659j = r19;
                this.f6660k = r110;
                this.f6661l = r111;
                this.f6662m = r112;
                this.f6663n = r113;
                this.f6664o = r114;
                this.f6665p = r115;
                this.f6666q = r20;
                this.f6667r = r21;
                this.f6668s = r22;
                this.f6669t = r23;
                this.f6670u = r24;
                this.f6671v = r25;
                this.f6672w = r26;
                this.f6673x = r27;
                this.f6674y = r28;
                this.f6675z = r29;
            }

            public /* synthetic */ a(String r28, String r29, Drawable r30, boolean r31, Integer r32, boolean r33, String r34, View r35, View r36, boolean r37, String r38, Integer r39, boolean r40, View.OnClickListener r41, Drawable r42, View.OnClickListener r43, TextWatcher r44, View.OnFocusChangeListener r45, Integer r46, boolean r47, boolean r48, boolean r49, int r50, boolean r51, d r52, c r53, int r54, DefaultConstructorMarker r55) {
                if ((r54 & 1) == 0) goto L5;
                String r10 = "标题";
            L7:
                if ((r54 & 2) == 0) goto L9;
                String r11 = null;
            L11:
                if ((r54 & 4) == 0) goto L13;
                Drawable r12 = null;
            L15:
                if ((r54 & 8) == 0) goto L17;
                boolean r13 = false;
            L19:
                if ((r54 & 16) == 0) goto L21;
                Integer r14 = null;
            L23:
                if ((r54 & 32) == 0) goto L25;
                boolean r15 = false;
            L27:
                if ((r54 & 64) == 0) goto L29;
                String r16 = null;
            L31:
                if ((r54 & 128) == 0) goto L33;
                View r17 = null;
            L35:
                if ((r54 & 256) == 0) goto L37;
                View r18 = null;
            L39:
                if ((r54 & 512) == 0) goto L41;
                boolean r19 = true;
            L43:
                if ((r54 & 1024) == 0) goto L45;
                String r110 = null;
            L47:
                if ((r54 & 2048) == 0) goto L49;
                Integer r111 = null;
            L51:
                if ((r54 & 4096) == 0) goto L53;
                boolean r20 = false;
            L55:
                if ((r54 & 8192) == 0) goto L57;
                View.OnClickListener r21 = null;
            L59:
                if ((r54 & 16384) == 0) goto L61;
                Drawable r112 = null;
            L63:
                if ((r54 & 32768) == 0) goto L65;
                View.OnClickListener r113 = null;
            L67:
                if ((r54 & 65536) == 0) goto L69;
                TextWatcher r114 = null;
            L71:
                if ((r54 & 131072) == 0) goto L73;
                View.OnFocusChangeListener r115 = null;
            L75:
                if ((r54 & 262144) == 0) goto L77;
                Integer r116 = null;
            L79:
                if ((r54 & 524288) == 0) goto L81;
                boolean r22 = false;
            L83:
                if ((r54 & 1048576) == 0) goto L85;
                boolean r23 = false;
            L87:
                if ((r54 & 2097152) == 0) goto L89;
                boolean r24 = false;
            L91:
                if ((r54 & 4194304) == 0) goto L93;
                int r25 = 2;
            L95:
                if ((r54 & 8388608) == 0) goto L97;
                boolean r26 = true;
            L99:
                if ((r54 & 16777216) == 0) goto L101;
                d r27 = null;
            L103:
                if ((r54 & 33554432) == 0) goto L105;
                c r56 = null;
            L106:
                this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r112, r113, r114, r115, r116, r22, r23, r24, r25, r26, r27, r56);
                return;
            L105:
                r56 = r53;
                goto L106
            L101:
                r27 = r52;
                goto L103
            L97:
                r26 = r51;
                goto L99
            L93:
                r25 = r50;
                goto L95
            L89:
                r24 = r49;
                goto L91
            L85:
                r23 = r48;
                goto L87
            L81:
                r22 = r47;
                goto L83
            L77:
                r116 = r46;
                goto L79
            L73:
                r115 = r45;
                goto L75
            L69:
                r114 = r44;
                goto L71
            L65:
                r113 = r43;
                goto L67
            L61:
                r112 = r42;
                goto L63
            L57:
                r21 = r41;
                goto L59
            L53:
                r20 = r40;
                goto L55
            L49:
                r111 = r39;
                goto L51
            L45:
                r110 = r38;
                goto L47
            L41:
                r19 = r37;
                goto L43
            L37:
                r18 = r36;
                goto L39
            L33:
                r17 = r35;
                goto L35
            L29:
                r16 = r34;
                goto L31
            L25:
                r15 = r33;
                goto L27
            L21:
                r14 = r32;
                goto L23
            L17:
                r13 = r31;
                goto L19
            L13:
                r12 = r30;
                goto L15
            L9:
                r11 = r29;
                goto L11
            L5:
                r10 = r28;
                goto L7
            }

            public final b a() {
                String r10 = this.f6650a;
                String r11 = this.f6651b;
                Drawable r12 = this.f6652c;
                boolean r13 = this.f6653d;
                boolean r14 = this.f6655f;
                String r15 = this.f6656g;
                Integer r16 = this.f6654e;
                boolean r17 = this.f6659j;
                String r18 = this.f6660k;
                TextWatcher r19 = this.f6666q;
                View r20 = this.f6657h;
                View r21 = this.f6658i;
                boolean r110 = this.f6662m;
                View.OnClickListener r111 = this.f6663n;
                Drawable r112 = this.f6664o;
                View.OnClickListener r113 = this.f6665p;
                Integer r114 = this.f6661l;
                return new b(r10, r13, r14, r15, r20, r21, r16, r17, r18, r19, this.f6667r, r110, r112, r111, r113, r11, r114, this.f6668s, r12, this.f6669t, this.f6670u, this.f6671v, this.f6672w, this.f6673x, this.f6674y, this.f6675z, null);
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L4;
                return true;
            L4:
                if ((r10 instanceof a) == false) goto L58;
                a r11 = (a) r10;
                if (Intrinsics.areEqual(this.f6650a, r11.f6650a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f6651b, r11.f6651b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f6652c, r11.f6652c) == true) goto L12;
                return false;
            L12:
                if (this.f6653d == r11.f6653d) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.f6654e, r11.f6654e) == true) goto L16;
                return false;
            L16:
                if (this.f6655f == r11.f6655f) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f6656g, r11.f6656g) == true) goto L20;
                return false;
            L20:
                if (Intrinsics.areEqual(this.f6657h, r11.f6657h) == true) goto L22;
                return false;
            L22:
                if (Intrinsics.areEqual(this.f6658i, r11.f6658i) == true) goto L24;
                return false;
            L24:
                if (this.f6659j == r11.f6659j) goto L26;
                return false;
            L26:
                if (Intrinsics.areEqual(this.f6660k, r11.f6660k) == true) goto L28;
                return false;
            L28:
                if (Intrinsics.areEqual(this.f6661l, r11.f6661l) == true) goto L30;
                return false;
            L30:
                if (this.f6662m == r11.f6662m) goto L32;
                return false;
            L32:
                if (Intrinsics.areEqual(this.f6663n, r11.f6663n) == true) goto L34;
                return false;
            L34:
                if (Intrinsics.areEqual(this.f6664o, r11.f6664o) == true) goto L36;
                return false;
            L36:
                if (Intrinsics.areEqual(this.f6665p, r11.f6665p) == true) goto L38;
                return false;
            L38:
                if (Intrinsics.areEqual(this.f6666q, r11.f6666q) == true) goto L40;
                return false;
            L40:
                if (Intrinsics.areEqual(this.f6667r, r11.f6667r) == true) goto L42;
                return false;
            L42:
                if (Intrinsics.areEqual(this.f6668s, r11.f6668s) == true) goto L44;
                return false;
            L44:
                if (this.f6669t == r11.f6669t) goto L46;
                return false;
            L46:
                if (this.f6670u == r11.f6670u) goto L48;
                return false;
            L48:
                if (this.f6671v == r11.f6671v) goto L50;
                return false;
            L50:
                if (this.f6672w == r11.f6672w) goto L52;
                return false;
            L52:
                if (this.f6673x == r11.f6673x) goto L54;
                return false;
            L54:
                if (Intrinsics.areEqual(this.f6674y, r11.f6674y) == true) goto L56;
                return false;
            L56:
                if (Intrinsics.areEqual(this.f6675z, r11.f6675z) == true) goto L88;
                return false;
            L88:
                return true;
            L58:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v12, types: [int] */
            /* JADX WARN: Type inference failed for: r2v23, types: [int] */
            /* JADX WARN: Type inference failed for: r2v31, types: [int] */
            /* JADX WARN: Type inference failed for: r2v51, types: [int] */
            /* JADX WARN: Type inference failed for: r2v53, types: [int] */
            /* JADX WARN: Type inference failed for: r2v55, types: [int] */
            /* JADX WARN: Type inference failed for: r2v63 */
            /* JADX WARN: Type inference failed for: r2v64 */
            /* JADX WARN: Type inference failed for: r2v65 */
            /* JADX WARN: Type inference failed for: r2v7, types: [int] */
            /* JADX WARN: Type inference failed for: r2v72 */
            /* JADX WARN: Type inference failed for: r2v75 */
            /* JADX WARN: Type inference failed for: r2v79 */
            /* JADX WARN: Type inference failed for: r2v81 */
            /* JADX WARN: Type inference failed for: r2v84 */
            /* JADX WARN: Type inference failed for: r2v85 */
            /* JADX WARN: Type inference failed for: r2v86 */
            /* JADX WARN: Type inference failed for: r2v87 */
            /* JADX WARN: Type inference failed for: r2v88 */
            /* JADX WARN: Type inference failed for: r2v89 */
            /* JADX WARN: Type inference failed for: r2v90 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                String r10 = this.f6650a;
                int r11 = 0;
                if (r10 == null) goto L5;
                int r12 = r10.hashCode();
            L6:
                int r13 = r12 * 31;
                String r14 = this.f6651b;
                if (r14 == null) goto L9;
                int r15 = r14.hashCode();
            L10:
                int r16 = (r13 + r15) * 31;
                Drawable r17 = this.f6652c;
                if (r17 == null) goto L13;
                int r18 = r17.hashCode();
            L14:
                int r19 = (r16 + r18) * 31;
                boolean r20 = this.f6653d;
                ?? r21 = 1;
                ?? r22 = r20;
                if (r20 == false) goto L17;
                r22 = 1;
            L17:
                int r23 = (r19 + r22) * 31;
                Integer r24 = this.f6654e;
                if (r24 == null) goto L20;
                int r25 = r24.hashCode();
            L21:
                int r26 = (r23 + r25) * 31;
                boolean r27 = this.f6655f;
                ?? r28 = r27;
                if (r27 == false) goto L24;
                r28 = 1;
            L24:
                int r29 = (r26 + r28) * 31;
                String r30 = this.f6656g;
                if (r30 == null) goto L27;
                int r31 = r30.hashCode();
            L28:
                int r32 = (r29 + r31) * 31;
                View r33 = this.f6657h;
                if (r33 == null) goto L31;
                int r34 = r33.hashCode();
            L32:
                int r35 = (r32 + r34) * 31;
                View r36 = this.f6658i;
                if (r36 == null) goto L35;
                int r37 = r36.hashCode();
            L36:
                int r38 = (r35 + r37) * 31;
                boolean r39 = this.f6659j;
                ?? r40 = r39;
                if (r39 == false) goto L39;
                r40 = 1;
            L39:
                int r41 = (r38 + r40) * 31;
                String r42 = this.f6660k;
                if (r42 == null) goto L42;
                int r43 = r42.hashCode();
            L43:
                int r44 = (r41 + r43) * 31;
                Integer r45 = this.f6661l;
                if (r45 == null) goto L46;
                int r46 = r45.hashCode();
            L47:
                int r47 = (r44 + r46) * 31;
                boolean r48 = this.f6662m;
                ?? r49 = r48;
                if (r48 == false) goto L50;
                r49 = 1;
            L50:
                int r50 = (r47 + r49) * 31;
                View.OnClickListener r51 = this.f6663n;
                if (r51 == null) goto L53;
                int r52 = r51.hashCode();
            L54:
                int r53 = (r50 + r52) * 31;
                Drawable r54 = this.f6664o;
                if (r54 == null) goto L57;
                int r55 = r54.hashCode();
            L58:
                int r56 = (r53 + r55) * 31;
                View.OnClickListener r57 = this.f6665p;
                if (r57 == null) goto L61;
                int r58 = r57.hashCode();
            L62:
                int r59 = (r56 + r58) * 31;
                TextWatcher r60 = this.f6666q;
                if (r60 == null) goto L65;
                int r61 = r60.hashCode();
            L66:
                int r62 = (r59 + r61) * 31;
                View.OnFocusChangeListener r63 = this.f6667r;
                if (r63 == null) goto L69;
                int r64 = r63.hashCode();
            L70:
                int r65 = (r62 + r64) * 31;
                Integer r66 = this.f6668s;
                if (r66 == null) goto L73;
                int r67 = r66.hashCode();
            L74:
                int r68 = (r65 + r67) * 31;
                boolean r69 = this.f6669t;
                ?? r70 = r69;
                if (r69 == false) goto L77;
                r70 = 1;
            L77:
                int r71 = (r68 + r70) * 31;
                boolean r72 = this.f6670u;
                ?? r73 = r72;
                if (r72 == false) goto L80;
                r73 = 1;
            L80:
                int r74 = (r71 + r73) * 31;
                boolean r75 = this.f6671v;
                ?? r76 = r75;
                if (r75 == false) goto L83;
                r76 = 1;
            L83:
                int r77 = (((r74 + r76) * 31) + Integer.hashCode(this.f6672w)) * 31;
                boolean r78 = this.f6673x;
                if (r78 == true) goto L87;
                r21 = r78;
            L87:
                int r79 = (r77 + r21) * 31;
                d r80 = this.f6674y;
                if (r80 == null) goto L90;
                int r81 = r80.hashCode();
            L91:
                int r82 = (r79 + r81) * 31;
                c r83 = this.f6675z;
                if (r83 == null) goto L95;
                r11 = r83.hashCode();
            L95:
                return r82 + r11;
            L90:
                r81 = 0;
                goto L91
            L73:
                r67 = 0;
                goto L74
            L69:
                r64 = 0;
                goto L70
            L65:
                r61 = 0;
                goto L66
            L61:
                r58 = 0;
                goto L62
            L57:
                r55 = 0;
                goto L58
            L53:
                r52 = 0;
                goto L54
            L46:
                r46 = 0;
                goto L47
            L42:
                r43 = 0;
                goto L43
            L35:
                r37 = 0;
                goto L36
            L31:
                r34 = 0;
                goto L32
            L27:
                r31 = 0;
                goto L28
            L20:
                r25 = 0;
                goto L21
            L13:
                r18 = 0;
                goto L14
            L9:
                r15 = 0;
                goto L10
            L5:
                r12 = 0;
                goto L6
            }

            public String toString() {
                return "Builder(title=" + this.f6650a + ", inputTips=" + this.f6651b + ", titleIcon=" + this.f6652c + ", showCounter=" + this.f6653d + ", lengthLimit=" + this.f6654e + ", showClear=" + this.f6655f + ", hintText=" + this.f6656g + ", prefixView=" + this.f6657h + ", suffixView=" + this.f6658i + ", showDivider=" + this.f6659j + ", actionText=" + this.f6660k + ", actionTextColor=" + this.f6661l + ", actionTextClickable=" + this.f6662m + ", actionTextListener=" + this.f6663n + ", actionImageDrawable=" + this.f6664o + ", actionImageDrawableListener=" + this.f6665p + ", textWatcher=" + this.f6666q + ", editTextOnFocusChangeListener=" + this.f6667r + ", inputBoxHeight=" + this.f6668s + ", isInSearchBar=" + this.f6669t + ", autoHideClearWhenTextEmpty=" + this.f6670u + ", multiLine=" + this.f6671v + ", mode=" + this.f6672w + ", hideClearWhenNoFocus=" + this.f6673x + ", textExceedLengthListener=" + this.f6674y + ", textClearedListener=" + this.f6675z + ")";
            }
        }

        private b(String r10, boolean r11, boolean r12, String r13, View r14, View r15, Integer r16, boolean r17, String r18, TextWatcher r19, View.OnFocusChangeListener r110, boolean r111, Drawable r112, View.OnClickListener r113, View.OnClickListener r114, String r115, Integer r116, Integer r20, Drawable r21, boolean r22, boolean r23, boolean r24, int r25, boolean r26, d r27, c r28) {
            this.f6624a = r10;
            this.f6625b = r11;
            this.f6626c = r12;
            this.f6627d = r13;
            this.f6628e = r14;
            this.f6629f = r15;
            this.f6630g = r16;
            this.f6631h = r17;
            this.f6632i = r18;
            this.f6633j = r19;
            this.f6634k = r110;
            this.f6635l = r111;
            this.f6636m = r112;
            this.f6637n = r113;
            this.f6638o = r114;
            this.f6639p = r115;
            this.f6640q = r116;
            this.f6641r = r20;
            this.f6642s = r21;
            this.f6643t = r22;
            this.f6644u = r23;
            this.f6645v = r24;
            this.f6646w = r25;
            this.f6647x = r26;
            this.f6648y = r27;
            this.f6649z = r28;
        }

        public /* synthetic */ b(String r10, boolean r11, boolean r12, String r13, View r14, View r15, Integer r16, boolean r17, String r18, TextWatcher r19, View.OnFocusChangeListener r110, boolean r111, Drawable r112, View.OnClickListener r113, View.OnClickListener r114, String r115, Integer r116, Integer r117, Drawable r118, boolean r20, boolean r21, boolean r22, int r23, boolean r24, d r25, c r26, DefaultConstructorMarker r27) {
            this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r20, r21, r22, r23, r24, r25, r26);
        }

        public final void A(boolean r10) {
            this.f6644u = r10;
        }

        public final void B(String r10) {
            this.f6627d = r10;
        }

        public final void C(Integer r10) {
            this.f6641r = r10;
        }

        public final void D(String r10) {
            this.f6639p = r10;
        }

        public final void E(Integer r10) {
            this.f6630g = r10;
        }

        public final void F(boolean r10) {
            this.f6645v = r10;
        }

        public final void G(boolean r10) {
            this.f6626c = r10;
        }

        public final void H(boolean r10) {
            this.f6625b = r10;
        }

        public final void I(boolean r10) {
            this.f6631h = r10;
        }

        public final void J(c r10) {
            this.f6649z = r10;
        }

        public final void K(d r10) {
            this.f6648y = r10;
        }

        public final void L(TextWatcher r10) {
            this.f6633j = r10;
        }

        public final void M(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.f6624a = r10;
        }

        public final Drawable a() {
            return this.f6636m;
        }

        public final View.OnClickListener b() {
            return this.f6638o;
        }

        public final String c() {
            return this.f6632i;
        }

        public final boolean d() {
            return this.f6635l;
        }

        public final Integer e() {
            return this.f6640q;
        }

        public final View.OnClickListener f() {
            return this.f6637n;
        }

        public final boolean g() {
            return this.f6644u;
        }

        public final View.OnFocusChangeListener h() {
            return this.f6634k;
        }

        public final boolean i() {
            return this.f6647x;
        }

        public final String j() {
            return this.f6627d;
        }

        public final Integer k() {
            return this.f6641r;
        }

        public final String l() {
            return this.f6639p;
        }

        public final Drawable m() {
            return this.f6642s;
        }

        public final Integer n() {
            return this.f6630g;
        }

        public final int o() {
            return this.f6646w;
        }

        public final boolean p() {
            return this.f6645v;
        }

        public final View q() {
            return this.f6628e;
        }

        public final boolean r() {
            return this.f6626c;
        }

        public final boolean s() {
            return this.f6625b;
        }

        public final boolean t() {
            return this.f6631h;
        }

        public final View u() {
            return this.f6629f;
        }

        public final c v() {
            return this.f6649z;
        }

        public final d w() {
            return this.f6648y;
        }

        public final TextWatcher x() {
            return this.f6633j;
        }

        public final String y() {
            return this.f6624a;
        }

        public final boolean z() {
            return this.f6643t;
        }
    }

    public interface c {
        void a();

        void b();
    }

    public interface d {
        void a(String r10);
    }

    public static final class e implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2 f6676c;

        e(Function2 r10) {
            this.f6676c = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r10, boolean r11) {
            this.f6676c.invoke(r10, Boolean.valueOf(r11));
        }
    }

    public static final class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f6677a;

        f(Function1 r10) {
            this.f6677a = r10;
        }

        @Override // com.obric.oui.forms.OLineInputView.d
        public void a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "s");
            this.f6677a.invoke(r10);
        }
    }

    public static final class g implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OLineInputView f6678c;

        g(OLineInputView r10) {
            this.f6678c = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (OLineInputView.access$getConfig$p(this.f6678c).n() == null) goto L16;
            int r11 = 0;
            if (r10 == null) goto L7;
            int r12 = r10.length();
        L8:
            Integer r13 = OLineInputView.access$getConfig$p(this.f6678c).n();
            if (r13 == null) goto L11;
            r11 = r13.intValue();
        L11:
            if (r12 <= r11) goto L17;
            d r14 = OLineInputView.access$getConfig$p(this.f6678c).w();
            if (r14 == null) goto L18;
            r14.a(String.valueOf(r10));
            return;
        L18:
            return;
        L17:
            return;
        L7:
            r12 = 0;
            goto L8
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
            if (OLineInputView.access$getConfig$p(this.f6678c).n() == null) goto L27;
            Resources r14 = this.f6678c.getResources();
            int r15 = u8.j.oui_form_counter;
            Object[] r16 = new Object[2];
            if (r10 == null) goto L7;
            String r17 = String.valueOf(r10.length());
        L8:
            r16[0] = r17;
            r16[1] = String.valueOf(OLineInputView.access$getConfig$p(this.f6678c).n());
            String r18 = r14.getString(r15, r16);
            Intrinsics.checkNotNullExpressionValue(r18, "resources.getString(\n   …                        )");
            SpannableString r19 = new SpannableString(r18);
            if (r10 == null) goto L11;
            int r20 = r10.length();
        L12:
            Integer r21 = OLineInputView.access$getConfig$p(this.f6678c).n();
            if (r21 == null) goto L15;
            int r22 = r21.intValue();
        L16:
            if (r20 <= r22) goto L24;
            Context r23 = this.f6678c.getContext();
            int r24 = u8.c.Primary;
            ForegroundColorSpan r25 = new ForegroundColorSpan(ContextCompat.getColor(r23, r24));
            if (r10 == null) goto L22;
            String r26 = String.valueOf(r10.length());
            if (r26 == null) goto L22;
            int r27 = r26.length();
        L23:
            r19.setSpan(r25, 0, r27, 18);
            this.f6678c.getDivider().setBackgroundColor(ContextCompat.getColor(this.f6678c.getContext(), r24));
        L25:
            this.f6678c.getTvCounter().setText(r19, TextView.BufferType.SPANNABLE);
            return;
        L22:
            r27 = 0;
            goto L23
        L24:
            this.f6678c.getDivider().setStyle(0);
            goto L25
        L15:
            r22 = 0;
            goto L16
        L11:
            r20 = 0;
            goto L12
        L7:
            r17 = null;
            goto L8
        }
    }

    static final class h implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OLineInputView f6679c;

        h(OLineInputView r10) {
            this.f6679c = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r10, boolean r11) {
            OLineInputView r12 = this.f6679c;
            if (r11 == false) goto L5;
            OLineInputView.access$showSoftInput(r12);
            return;
        L5:
            OLineInputView.access$hideSoftInput(r12);
        }
    }

    static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OLineInputView f6680c;

        i(OLineInputView r10) {
            this.f6680c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            c r11 = OLineInputView.access$getConfig$p(this.f6680c).v();
            if (r11 == null) goto L5;
            r11.b();
        L5:
            this.f6680c.setText("");
            c r12 = OLineInputView.access$getConfig$p(this.f6680c).v();
            if (r12 == null) goto L9;
            r12.a();
            return;
        }
    }

    static final class j implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OLineInputView f6681c;

        j(OLineInputView r10) {
            this.f6681c = r10;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r10, boolean r11) {
            b r12 = OLineInputView.access$getConfig$p(this.f6681c);
            if (r11 == false) goto L12;
            if (r12.g() == true) goto L7;
        L9:
            this.f6681c.showClear();
        L10:
            OLineInputView.access$showSoftInput(this.f6681c);
            return;
        L7:
            if (TextUtils.isEmpty(this.f6681c.getText()) == false) goto L9;
            this.f6681c.hideClear();
            goto L10
        L12:
            if (r12.i() == false) goto L14;
        L15:
            this.f6681c.hideClear();
        L16:
            OLineInputView.access$hideSoftInput(this.f6681c);
            return;
        L14:
            if (TextUtils.isEmpty(this.f6681c.getText()) == false) goto L16;
            goto L15
        }
    }

    static final class k implements View.OnTouchListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OLineInputView f6682c;

        k(OLineInputView r10) {
            this.f6682c = r10;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r10, MotionEvent r11) {
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_EVENT);
            int r12 = r11.getActionMasked();
            if (r12 == 0) goto L21;
            if (r12 == 1) goto L10;
            if (r12 == 3) goto L10;
            return false;
        L10:
            if (OLineInputView.access$isErrorState$p(this.f6682c) == false) goto L14;
            ConstraintLayout r13 = this.f6682c.getActiveBorderView();
            if (r13 == null) goto L32;
            int r14 = u8.e.o_line_box_input_error_default_border;
        L25:
            r13.setBackgroundResource(r14);
            return false;
        L32:
            return false;
        L14:
            boolean r15 = this.f6682c.getEditText().hasFocus();
            r13 = this.f6682c.getActiveBorderView();
            if (r15 == false) goto L18;
            if (r13 == null) goto L34;
            r14 = u8.e.o_line_box_input_focused_default_border;
            goto L25
        L34:
            return false;
        L18:
            if (r13 == null) goto L35;
            r14 = u8.e.o_line_box_input_normal_default_border;
            goto L25
        L35:
            return false;
        L21:
            if (OLineInputView.access$isErrorState$p(this.f6682c) == false) goto L26;
            r13 = this.f6682c.getActiveBorderView();
            if (r13 == null) goto L36;
            r14 = u8.e.o_line_box_input_error_pressed_border;
            goto L25
        L36:
            return false;
        L26:
            boolean r16 = this.f6682c.getEditText().hasFocus();
            r13 = this.f6682c.getActiveBorderView();
            if (r16 == false) goto L30;
            if (r13 == null) goto L38;
            r14 = u8.e.o_line_box_input_focused_pressed_border;
            goto L25
        L38:
            return false;
        L30:
            if (r13 == null) goto L39;
            r14 = u8.e.o_line_box_input_normal_pressed_border;
            goto L25
        L39:
            return false;
        }
    }

    public static final class l implements TextWatcher {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OLineInputView f6683c;

        l(OLineInputView r10) {
            this.f6683c = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            if (r10 != null) goto L4;
        L7:
            boolean r11 = true;
        L8:
            OLineInputView r12 = this.f6683c;
            if (r11 == false) goto L11;
            r12.hideClear();
            return;
        L11:
            r12.showClear();
            return;
        L4:
            if (r10.length() == 0) goto L7;
            r11 = false;
            goto L8
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }
    }

    static {
        Companion = new a(null);
    }

    @JvmOverloads
    public OLineInputView(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OLineInputView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OLineInputView(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OLineInputView(Context r33, AttributeSet r34, int r35, int r36) {
        Intrinsics.checkNotNullParameter(r33, "context");
        super(r33, r34, r35);
        this.arrangeDirection = r36;
        this.config = new b.a(null, null, null, false, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, false, 0, false, null, null, 67108863, null).a();
        this.textGravity = 16;
        this.isShowTitle = true;
        this.DEFAULT_MAX_LINES = 20;
        this.errorTips = "";
        this.inputTips = "";
        TypedArray r10 = r33.getTheme().obtainStyledAttributes(r34, u8.l.OLineInputView, r35, 0);
        this.arrangeDirection = r10.getInt(u8.l.OLineInputView_oui_formArrangeDirection, 0);
        String r11 = r10.getString(u8.l.OLineInputView_oui_formTitle);
        b r12 = this.config;
        if (r11 != null) goto L6;
        r11 = "title";
    L6:
        r12.M(r11);
        boolean r13 = r10.getBoolean(u8.l.OLineInputView_oui_formShowClear, true);
        this.config.G(r13);
        String r14 = r10.getString(u8.l.OLineInputView_android_hint);
        this.config.B(r14);
        boolean r15 = r10.getBoolean(u8.l.OLineInputView_oui_formShowCounter, false);
        this.config.H(r15);
        int r16 = r10.getInt(u8.l.OLineInputView_oui_formLengthLimit, 0);
        if (r16 <= 0) goto L9;
        this.config.E(Integer.valueOf(r16));
    L9:
        int r17 = r10.getDimensionPixelSize(u8.l.OLineInputView_oui_formInputHeight, 0);
        if (r17 <= 0) goto L12;
        this.config.C(Integer.valueOf(r17));
    L12:
        this.config.F(r10.getBoolean(u8.l.OLineInputView_oui_formMultiLine, false));
        boolean r18 = r10.getBoolean(u8.l.OLineInputView_oui_formShowDivider, true);
        this.config.I(r18);
        String r19 = r10.getString(u8.l.OLineInputView_oui_formInputTips);
        this.config.D(r19);
        this.text = r10.getString(u8.l.OLineInputView_android_text);
        this.showTitleDefaultIcon = r10.getBoolean(u8.l.OLineInputView_oui_formShowTitleDefaultIcon, false);
        this.titleDefaultIconSize = r10.getInt(u8.l.OLineInputView_oui_formTitleDefaultIconSize, 0);
        this.textGravity = r10.getInt(u8.l.OLineInputView_android_gravity, 16);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        int r20 = this.arrangeDirection;
        if (r20 == 0) goto L20;
        if (r20 != 1) goto L16;
        int r21 = u8.h.o_form_line_input_horizontal;
    L21:
        LayoutInflater.from(r33).inflate(r21, this);
        View r22 = findViewById(u8.f.tv_title);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) r22;
        View r23 = findViewById(u8.f.et_input);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.et_input)");
        OFormEditText r24 = (OFormEditText) r23;
        this.editText = r24;
        View r25 = findViewById(u8.f.tv_error_tips);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.tv_error_tips)");
        this.tvErrorTips = (TextView) r25;
        View r26 = findViewById(u8.f.tv_counter);
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.tv_counter)");
        this.tvCounter = (TextView) r26;
        View r27 = findViewById(u8.f.tv_action);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.tv_action)");
        this.tvAction = (TextView) r27;
        View r28 = findViewById(u8.f.iv_clear);
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.iv_clear)");
        this.ivClear = (ImageView) r28;
        View r29 = findViewById(u8.f.iv_action);
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.iv_action)");
        this.ivAction = (ImageView) r29;
        View r30 = findViewById(u8.f.divider);
        Intrinsics.checkNotNullExpressionValue(r30, "findViewById(R.id.divider)");
        this.divider = (ODivider) r30;
        View r31 = findViewById(u8.f.iv_title_icon);
        Intrinsics.checkNotNullExpressionValue(r31, "findViewById(R.id.iv_title_icon)");
        this.ivTitleIcon = (ImageView) r31;
        View r32 = findViewById(u8.f.prefix_container);
        Intrinsics.checkNotNullExpressionValue(r32, "findViewById(R.id.prefix_container)");
        this.prefixContainer = (RelativeLayout) r32;
        View r37 = findViewById(u8.f.suffix_container);
        Intrinsics.checkNotNullExpressionValue(r37, "findViewById(R.id.suffix_container)");
        this.suffixContainer = (RelativeLayout) r37;
        View r38 = findViewById(u8.f.tv_input_tips);
        Intrinsics.checkNotNullExpressionValue(r38, "findViewById(R.id.tv_input_tips)");
        this.tvInputTips = (TextView) r38;
        View r39 = findViewById(u8.f.title_container);
        Intrinsics.checkNotNullExpressionValue(r39, "findViewById(R.id.title_container)");
        this.titleContainer = (ViewGroup) r39;
        View r40 = findViewById(u8.f.input_container);
        Intrinsics.checkNotNullExpressionValue(r40, "findViewById(R.id.input_container)");
        this.inputContainer = (ViewGroup) r40;
        this.leftContainer = (ConstraintLayout) findViewById(u8.f.left_container);
        View r41 = findViewById(u8.f.action_container);
        Intrinsics.checkNotNullExpressionValue(r41, "findViewById(R.id.action_container)");
        this.actionContainer = (ViewGroup) r41;
        this.activeBorderView = (ConstraintLayout) findViewById(u8.f.active_border_view);
        View r42 = findViewById(u8.f.iv_clear_container);
        Intrinsics.checkNotNullExpressionValue(r42, "findViewById(R.id.iv_clear_container)");
        this.ivClearContainer = (LinearLayout) r42;
        View r43 = findViewById(u8.f.iv_action_container);
        Intrinsics.checkNotNullExpressionValue(r43, "findViewById(R.id.iv_action_container)");
        this.ivActionContainer = (LinearLayout) r43;
        updateConfig(this.config);
        r24.setVerticalScrollBarEnabled(false);
        return;
    L16:
        if (r20 != 2) goto L20;
        r21 = u8.h.o_form_line_input_vertical_single_box;
    L20:
        r21 = u8.h.o_form_line_input_vertical;
        goto L21
    }

    public /* synthetic */ OLineInputView(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 1;
    L11:
        this(r10, r11, r12, r13);
    }

    public static final /* synthetic */ b access$getConfig$p(OLineInputView r10) {
        return r10.config;
    }

    public static final /* synthetic */ void access$hideSoftInput(OLineInputView r10) {
        r10.hideSoftInput();
    }

    public static final /* synthetic */ boolean access$isErrorState$p(OLineInputView r10) {
        return r10.isErrorState;
    }

    public static final /* synthetic */ void access$setConfig$p(OLineInputView r10, b r11) {
        r10.config = r11;
    }

    public static final /* synthetic */ void access$setErrorState$p(OLineInputView r10, boolean r11) {
        r10.isErrorState = r11;
    }

    public static final /* synthetic */ void access$showSoftInput(OLineInputView r10) {
        r10.showSoftInput();
    }

    private final void clear() {
        Iterator<WeakReference<TextWatcher>> r10 = getTextWatchers().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        WeakReference<TextWatcher> r11 = r10.next();
        this.editText.removeTextChangedListener(r11.get());
        goto L4
    }

    private final void hideSoftInput() {
        Object r10 = getContext().getSystemService("input_method");
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r10).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private final void refreshConfig() {
        String r10 = this.config.y();
        boolean r11 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L11;
        this.tvTitle.setText(this.config.y());
    L13:
        if (this.isShowTitle == false) goto L15;
        showTitle();
    L17:
        if (this.config.m() == null) goto L20;
        this.ivTitleIcon.setImageDrawable(this.config.m());
        this.isShowTitleIcon = true;
    L20:
        if (this.isShowTitleIcon == false) goto L22;
        showTitleIcon();
    L23:
        int r13 = this.titleDefaultIconSize;
        if (r13 == 0) goto L28;
        if (r13 != 1) goto L28;
        setMiddleTitleIcon();
    L30:
        if (this.config.g() == false) goto L33;
        l r14 = new l(this);
        getTextWatchers().add(new WeakReference(r14));
        this.editText.addTextChangedListener(r14);
    L33:
        if (this.config.s() == false) goto L38;
        if (this.config.n() == null) goto L38;
        this.counterTextWatcher = new g(this);
        ArrayList<WeakReference<TextWatcher>> r15 = getTextWatchers();
        TextWatcher r16 = this.counterTextWatcher;
        Intrinsics.checkNotNull(r16);
        r15.add(new WeakReference(r16));
        this.editText.addTextChangedListener(this.counterTextWatcher);
        com.obric.oui.common.util.k.h(this.tvCounter);
    L38:
        if (this.config.r() == true) goto L40;
        hideClear();
        this.editText.setOnFocusChangeListener(new h(this));
    L44:
        String r17 = this.config.j();
        if (r17 != null) goto L47;
    L50:
        boolean r18 = true;
    L51:
        if (r18 == true) goto L54;
        this.editText.setHint(this.config.j());
    L54:
        if (this.config.q() == null) goto L57;
        this.prefixContainer.removeAllViews();
        this.prefixContainer.addView(this.config.q(), new ConstraintLayout.LayoutParams(-2, -2));
        showPrefixView();
    L57:
        if (this.config.u() == null) goto L60;
        this.suffixContainer.removeAllViews();
        this.suffixContainer.addView(this.config.u(), new ConstraintLayout.LayoutParams(-2, -2));
        showSuffixView();
    L60:
        if (this.config.z() == false) goto L63;
        this.config.I(false);
    L63:
        if (this.config.t() == false) goto L65;
        showDivider();
    L66:
        String r19 = this.config.c();
        if (r19 != null) goto L69;
    L72:
        boolean r20 = true;
    L73:
        if (r20 == true) goto L85;
        this.tvAction.setText(this.config.c());
        if (this.config.e() == null) goto L77;
        TextView r21 = this.tvAction;
        Integer r22 = this.config.e();
        Intrinsics.checkNotNull(r22);
        int r23 = r22.intValue();
    L78:
        r21.setTextColor(r23);
        if (this.config.d() == true) goto L81;
    L83:
        showActionText();
        goto L85
    L81:
        if (this.config.f() == null) goto L83;
        this.tvAction.setOnClickListener(this.config.f());
        goto L83
    L77:
        r21 = this.tvAction;
        r23 = ContextCompat.getColor(getContext(), u8.c.TextPrimary);
    L85:
        if (this.config.x() == null) goto L88;
        ArrayList<WeakReference<TextWatcher>> r24 = getTextWatchers();
        TextWatcher r25 = this.config.x();
        Intrinsics.checkNotNull(r25);
        r24.add(new WeakReference(r25));
        this.editText.addTextChangedListener(this.config.x());
    L88:
        if (this.config.a() == null) goto L94;
        this.ivAction.setImageDrawable(this.config.a());
        if (this.config.b() == null) goto L92;
        this.ivAction.setOnClickListener(this.config.b());
    L92:
        showActionImage();
    L94:
        if (TextUtils.isEmpty(this.config.l()) == true) goto L97;
        String r26 = this.config.l();
        Intrinsics.checkNotNull(r26);
        showInputTips(r26);
    L97:
        if (this.config.k() == null) goto L100;
        ViewGroup r27 = this.inputContainer;
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        Objects.requireNonNull(r28, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r29 = (ConstraintLayout.LayoutParams) r28;
        Integer r30 = this.config.k();
        Intrinsics.checkNotNull(r30);
        int r31 = r30.intValue();
    L99:
        ((ViewGroup.MarginLayoutParams) r29).height = r31;
        r27.setLayoutParams(r29);
        if (this.config.p() == false) goto L112;
        OFormEditText r32 = this.editText;
        r32.setSingleLine(false);
        r32.setLines(this.DEFAULT_MAX_LINES);
    L113:
        String r33 = this.text;
        if (r33 != null) goto L116;
    L117:
        r11 = true;
    L118:
        if (r11 == true) goto L121;
        setText(this.text);
    L121:
        if (this.showTitleDefaultIcon == true) goto L123;
    L125:
        this.editText.setGravity(this.textGravity);
        if (this.config.h() == null) goto L129;
        View.OnFocusChangeListener r34 = this.config.h();
        Intrinsics.checkNotNull(r34);
        setEditTextOnFocusChangeListener(r34);
    L129:
        if (this.isShowTitle == false) goto L131;
        showTitle();
    L133:
        if (this.isShowErrorTips == false) goto L135;
        String r35 = this.errorTips;
        Intrinsics.checkNotNull(r35);
        showErrorTips(r35);
    L137:
        if (this.isShowInputTips == false) goto L139;
        String r36 = this.inputTips;
        Intrinsics.checkNotNull(r36);
        showInputTips(r36);
    L141:
        if (this.isShowPrefix == false) goto L143;
        showPrefixView();
    L145:
        if (this.isShowSuffix == false) goto L147;
        showSuffixView();
    L149:
        if (this.isShowActionText == false) goto L151;
        showActionText();
    L153:
        if (this.isShowActionImage == false) goto L155;
        showActionImage();
    L156:
        setMode$default(this, this.config.o(), null, 2, null);
        return;
    L155:
        hideActionImage();
        goto L156
    L151:
        hideActionText();
        goto L153
    L147:
        hideSuffixView();
        goto L149
    L143:
        hidePrefixView();
        goto L145
    L139:
        hideInputTips();
        goto L141
    L135:
        hideErrorTips();
        goto L137
    L131:
        hideTitle();
        goto L133
    L123:
        if (this.config.m() != null) goto L125;
        showTitleIcon();
        goto L125
    L116:
        if (r33.length() != 0) goto L118;
    L112:
        this.editText.setSingleLine(true);
        goto L113
    L100:
        r27 = this.inputContainer;
        ViewGroup.LayoutParams r37 = r27.getLayoutParams();
        Objects.requireNonNull(r37, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        r29 = (ConstraintLayout.LayoutParams) r37;
        if (this.arrangeDirection == 1) goto L105;
        float r38 = 40;
    L103:
        Resources r39 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r39, "Resources.getSystem()");
        r31 = MathKt.roundToInt(TypedValue.applyDimension(1, r38, r39.getDisplayMetrics()));
        goto L99
    L105:
        if (this.config.z() == false) goto L107;
        int r40 = 36;
    L108:
        r38 = r40;
        goto L103
    L107:
        r40 = 52;
        goto L108
    L69:
        if (r19.length() == 0) goto L72;
        r20 = false;
        goto L73
    L65:
        hideDivider();
        goto L66
    L47:
        if (r17.length() == 0) goto L50;
        r18 = false;
        goto L51
    L40:
        this.ivClear.setOnClickListener(new i(this));
        if (TextUtils.isEmpty(this.editText.getText()) == false) goto L43;
        com.obric.oui.common.util.k.f(this.ivClear);
        com.obric.oui.common.util.k.f(this.ivClearContainer);
    L43:
        this.editText.setOnFocusChangeListener(new j(this));
        this.editText.setOnTouchListener(new k(this));
    L28:
        setSmallTitleIcon();
        goto L30
    L22:
        hideTitleIcon();
        goto L23
    L15:
        hideTitle();
        goto L17
    L11:
        this.isShowTitle = false;
        goto L13
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r12 = false;
        goto L9
    }

    public static /* synthetic */ void setAutoHideClearWhenTextEmpty$default(OLineInputView r10, boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = true;
    L5:
        r10.setAutoHideClearWhenTextEmpty(r11);
    }

    public static /* synthetic */ void setMode$default(OLineInputView r10, int r11, View.OnClickListener r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.setMode(r11, r12);
    }

    private final void showSoftInput() {
        Object r10 = getContext().getSystemService("input_method");
        Objects.requireNonNull(r10, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r10).showSoftInput(this, 0);
    }

    public final void editTextOnFocusChangeListener(Function2<? super View, ? super Boolean, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "handler");
        setEditTextOnFocusChangeListener(new e(r10));
    }

    public final void enableVerticalScrollBar(boolean r10) {
        this.editText.setVerticalScrollBarEnabled(r10);
    }

    public final ViewGroup getActionContainer() {
        return this.actionContainer;
    }

    public final ConstraintLayout getActiveBorderView() {
        return this.activeBorderView;
    }

    public final int getArrangeDirection() {
        return this.arrangeDirection;
    }

    public final b getConfig() {
        return this.config;
    }

    public final ODivider getDivider() {
        return this.divider;
    }

    public final OFormEditText getEditText() {
        return this.editText;
    }

    public final ViewGroup getInputContainer() {
        return this.inputContainer;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.editText;
    }

    public final ImageView getIvAction() {
        return this.ivAction;
    }

    public final LinearLayout getIvActionContainer() {
        return this.ivActionContainer;
    }

    public final ImageView getIvClear() {
        return this.ivClear;
    }

    public final LinearLayout getIvClearContainer() {
        return this.ivClearContainer;
    }

    public final ImageView getIvTitleIcon() {
        return this.ivTitleIcon;
    }

    public final ConstraintLayout getLeftContainer() {
        return this.leftContainer;
    }

    public final RelativeLayout getPrefixContainer() {
        return this.prefixContainer;
    }

    public final RelativeLayout getSuffixContainer() {
        return this.suffixContainer;
    }

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final ViewGroup getTitleContainer() {
        return this.titleContainer;
    }

    public final TextView getTvAction() {
        return this.tvAction;
    }

    public final TextView getTvCounter() {
        return this.tvCounter;
    }

    public final TextView getTvErrorTips() {
        return this.tvErrorTips;
    }

    public final TextView getTvInputTips() {
        return this.tvInputTips;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final void hideActionImage() {
        if (this.ivAction.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        com.obric.oui.common.util.k.f(this.ivAction);
    L8:
        this.isShowActionImage = false;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void hideActionText() {
        com.obric.oui.common.util.k.f(this.tvAction);
        this.isShowActionText = false;
    }

    public final void hideClear() {
        com.obric.oui.common.util.k.f(this.ivClearContainer);
        com.obric.oui.common.util.k.f(this.ivClear);
        this.config.G(false);
    }

    public final void hideDivider() {
        com.obric.oui.common.util.k.f(this.divider);
        this.config.I(false);
    }

    public final void hideErrorTips() {
        com.obric.oui.common.util.k.f(this.tvErrorTips);
        this.divider.setStyle(0);
        CharSequence r10 = this.tvInputTips.getText();
        Intrinsics.checkNotNullExpressionValue(r10, "tvInputTips.text");
        if (r10.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        showInputTips(this.tvInputTips.getText().toString());
    L8:
        this.isShowErrorTips = false;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void hideInputTips() {
        com.obric.oui.common.util.k.f(this.tvInputTips);
        this.isShowInputTips = false;
    }

    public final void hidePrefixView() {
        com.obric.oui.common.util.k.f(this.prefixContainer);
        this.isShowPrefix = false;
    }

    public final void hideSuffixView() {
        com.obric.oui.common.util.k.f(this.suffixContainer);
        this.isShowSuffix = false;
    }

    public final void hideTitle() {
        com.obric.oui.common.util.k.f(this.tvTitle);
        if (this.ivTitleIcon.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        com.obric.oui.common.util.k.f(this.titleContainer);
    L8:
        this.isShowTitle = false;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void hideTitleIcon() {
        com.obric.oui.common.util.k.f(this.ivTitleIcon);
        if (this.tvTitle.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
    L9:
        com.obric.oui.common.util.k.f(this.titleContainer);
    L10:
        this.isShowTitleIcon = false;
        return;
    L8:
        if (TextUtils.isEmpty(this.tvTitle.getText()) == false) goto L10;
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        float r10 = 44;
        Resources r11 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r11, "Resources.getSystem()");
        int r12 = MathKt.roundToInt(TypedValue.applyDimension(1, r10, r11.getDisplayMetrics()));
        ViewGroup r13 = this.actionContainer;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        com.obric.oui.common.util.k.a(r13, MathKt.roundToInt(TypedValue.applyDimension(1, r10, r14.getDisplayMetrics())));
        com.obric.oui.common.util.k.d(this.actionContainer, r12, r12, new View[]{this.tvAction, this.ivAction});
    }

    public final void onTextExceedLengthListener(Function1<? super String, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "handler");
        this.config.K(new f(r10));
    }

    public final void setActiveBorderView(ConstraintLayout r10) {
        this.activeBorderView = r10;
    }

    public final void setArrangeDirection(int r10) {
        this.arrangeDirection = r10;
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r10) {
        b r11 = getConfig();
        r11.A(r10);
        Unit r12 = Unit.INSTANCE;
        updateConfig(r11);
    }

    public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.editText.setOnFocusChangeListener(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        this.editText.setEnabled(r10);
        super.setEnabled(r10);
    }

    public final void setInputContainerBackground(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "drawable");
        this.inputContainer.setBackground(r10);
    }

    public final void setInputContainerPadding(int r10, int r11, int r12, int r13) {
        this.inputContainer.setPadding(r10, r11, r12, r13);
    }

    public final void setInputViewActived() {
        this.isErrorState = false;
        int r10 = u8.e.o_line_box_input_focused_border_selector;
        Drawable r11 = ContextCompat.getDrawable(getContext(), r10);
        ConstraintLayout r12 = this.activeBorderView;
        if (r12 == null) goto L6;
        r12.setBackground(r11);
        return;
    }

    public final void setInputViewError() {
        this.isErrorState = true;
        int r10 = u8.e.o_line_box_input_error_border_selector;
        Drawable r11 = ContextCompat.getDrawable(getContext(), r10);
        ConstraintLayout r12 = this.activeBorderView;
        if (r12 == null) goto L6;
        r12.setBackground(r11);
        return;
    }

    public final void setInputViewNormal() {
        this.isErrorState = false;
        int r10 = u8.e.o_line_box_input_normal_border_selector;
        Drawable r11 = ContextCompat.getDrawable(getContext(), r10);
        ConstraintLayout r12 = this.activeBorderView;
        if (r12 == null) goto L6;
        r12.setBackground(r11);
        return;
    }

    public final void setLeftContainer(ConstraintLayout r10) {
        this.leftContainer = r10;
    }

    public final void setMiddleTitleIcon() {
        ViewGroup.LayoutParams r10 = this.ivTitleIcon.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r10, "ivTitleIcon.getLayoutParams()");
        float r11 = 16;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        r10.width = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        r10.height = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r13.getDisplayMetrics()));
        this.ivTitleIcon.setLayoutParams(r10);
    }

    public final void setMode(int r10, View.OnClickListener r11) {
        if (r10 != 2) goto L5;
        this.editText.setFocusable(true);
        this.editText.setFocusableInTouchMode(true);
        OFormEditText r12 = this.editText;
        r11 = null;
    L11:
        r12.setOnClickListener(r11);
        setOnClickListener(r11);
        return;
    L5:
        if (r10 != 3) goto L14;
        this.editText.setFocusable(false);
        this.editText.setFocusableInTouchMode(false);
        r12 = this.editText;
        if (r11 != null) goto L11;
        r12.setOnClickListener(this.config.b());
        setOnClickListener(this.config.b());
        return;
    }

    public final void setSmallTitleIcon() {
        ViewGroup.LayoutParams r10 = this.ivTitleIcon.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r10, "ivTitleIcon.getLayoutParams()");
        float r11 = 10;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        r10.width = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        r10.height = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r13.getDisplayMetrics()));
        this.ivTitleIcon.setLayoutParams(r10);
    }

    public final void setText(String r10) {
        if (r10 == null) goto L7;
        this.editText.setText(r10);
        TextWatcher r11 = this.counterTextWatcher;
        if (r11 == null) goto L8;
        r11.onTextChanged(r10, 0, 0, r10.length());
        return;
    L8:
        return;
    }

    public final void setTextClearedListener(c r10) {
        Intrinsics.checkNotNullParameter(r10, "textClearedListener");
        this.config.J(r10);
    }

    public final void setTextExceedLengthListener(d r10) {
        Intrinsics.checkNotNullParameter(r10, "textExceedLengthListener");
        this.config.K(r10);
    }

    public final void setTextWatcher(TextWatcher r10) {
        this.config.L(r10);
        refreshConfig();
    }

    public final void showActionImage() {
        if (this.ivAction.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        com.obric.oui.common.util.k.h(this.ivAction);
    L8:
        this.isShowActionImage = true;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void showActionText() {
        com.obric.oui.common.util.k.h(this.tvAction);
        this.isShowActionText = true;
    }

    public final void showClear() {
        com.obric.oui.common.util.k.h(this.ivClearContainer);
        com.obric.oui.common.util.k.h(this.ivClear);
        this.config.G(false);
    }

    public final void showDivider() {
        com.obric.oui.common.util.k.h(this.divider);
        this.config.I(true);
    }

    public final void showErrorTips(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.obric.oui.common.util.k.h(this.tvErrorTips);
        this.tvErrorTips.setText(r10);
        this.divider.setBackgroundColor(ContextCompat.getColor(getContext(), u8.c.Primary));
        if (com.obric.oui.common.util.k.e(this.tvInputTips) == false) goto L7;
        hideInputTips();
    L7:
        this.isShowErrorTips = true;
        this.errorTips = r10;
    }

    public final void showInputTips(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.tvInputTips.setText(r10);
        com.obric.oui.common.util.k.h(this.tvInputTips);
        if (this.tvErrorTips.getVisibility() != 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L10;
        hideErrorTips();
    L10:
        this.isShowInputTips = true;
        this.inputTips = r10;
        return;
    L7:
        r11 = false;
        goto L8
    }

    public final void showPrefixView() {
        com.obric.oui.common.util.k.h(this.prefixContainer);
        this.isShowPrefix = true;
    }

    public final void showSuffixView() {
        com.obric.oui.common.util.k.h(this.suffixContainer);
        this.isShowSuffix = true;
    }

    public final void showTitle() {
        com.obric.oui.common.util.k.h(this.tvTitle);
        if (this.titleContainer.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        com.obric.oui.common.util.k.h(this.titleContainer);
    L8:
        this.isShowTitle = true;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void showTitleIcon() {
        if (this.titleContainer.getVisibility() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        com.obric.oui.common.util.k.h(this.titleContainer);
    L8:
        com.obric.oui.common.util.k.h(this.ivTitleIcon);
        this.isShowTitleIcon = true;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void updateConfig(b r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        this.config = r10;
        clear();
        refreshConfig();
    }
}
