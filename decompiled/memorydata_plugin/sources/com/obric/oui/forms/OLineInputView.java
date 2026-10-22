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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.loc.o;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.divider.ODivider;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 ¬\u00012\u00020\u0001:\b¬\u0001\u00ad\u0001®\u0001¯\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010]\u001a\u00020^H\u0002J@\u0010_\u001a\u00020^28\u0010`\u001a4\u0012\u0015\u0012\u0013\u0018\u00010b¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(e\u0012\u0013\u0012\u00110+¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020^0aJ\u000e\u0010g\u001a\u00020^2\u0006\u0010h\u001a\u00020+J\u0006\u0010i\u001a\u00020\u001aJ\b\u0010j\u001a\u00020kH\u0016J\u0006\u0010l\u001a\u00020&J\u0006\u0010m\u001a\u00020^J\u0006\u0010n\u001a\u00020^J\u0006\u0010o\u001a\u00020^J\u0006\u0010p\u001a\u00020^J\u0006\u0010q\u001a\u00020^J\u0006\u0010r\u001a\u00020^J\u0006\u0010s\u001a\u00020^J\b\u0010t\u001a\u00020^H\u0002J\u0006\u0010u\u001a\u00020^J\u0006\u0010v\u001a\u00020^J\u0006\u0010w\u001a\u00020^J\b\u0010x\u001a\u00020^H\u0014J)\u0010y\u001a\u00020^2!\u0010`\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\bc\u0012\b\bd\u0012\u0004\b\b({\u0012\u0004\u0012\u00020^0zJ\b\u0010|\u001a\u00020^H\u0002J\u0010\u0010}\u001a\u00020^2\b\b\u0002\u0010~\u001a\u00020+J\u0010\u0010\u007f\u001a\u00020^2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\u0012\u0010\u0082\u0001\u001a\u00020^2\u0007\u0010\u0083\u0001\u001a\u00020+H\u0016J\u0011\u0010\u0084\u0001\u001a\u00020^2\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001J+\u0010\u0087\u0001\u001a\u00020^2\u0007\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u008b\u0001\u001a\u00020\u0007J\u0007\u0010\u008c\u0001\u001a\u00020^J\u0007\u0010\u008d\u0001\u001a\u00020^J\u0007\u0010\u008e\u0001\u001a\u00020^J\u0007\u0010\u008f\u0001\u001a\u00020^J\u001e\u0010\u0090\u0001\u001a\u00020^2\u0007\u0010\u0091\u0001\u001a\u00020\u00072\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u00020^J\u0011\u0010\u0095\u0001\u001a\u00020^2\b\u0010L\u001a\u0004\u0018\u00010&J\u0011\u0010\u0096\u0001\u001a\u00020^2\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001J\u0011\u0010\u0099\u0001\u001a\u00020^2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\u0012\u0010\u009c\u0001\u001a\u00020^2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u001cJ\u0007\u0010\u009e\u0001\u001a\u00020^J\u0007\u0010\u009f\u0001\u001a\u00020^J\u0007\u0010 \u0001\u001a\u00020^J\u0007\u0010¡\u0001\u001a\u00020^J\u0012\u0010¢\u0001\u001a\u00020^2\t\u0010£\u0001\u001a\u0004\u0018\u00010&J\u0012\u0010¤\u0001\u001a\u00020^2\t\u0010£\u0001\u001a\u0004\u0018\u00010&J\u0007\u0010¥\u0001\u001a\u00020^J\t\u0010¦\u0001\u001a\u00020^H\u0002J\u0007\u0010§\u0001\u001a\u00020^J\u0007\u0010¨\u0001\u001a\u00020^J\u0007\u0010©\u0001\u001a\u00020^J\u0010\u0010ª\u0001\u001a\u00020^2\u0007\u0010«\u0001\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000eR\u000e\u0010)\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010<\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b=\u00107R\u0011\u0010>\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b?\u0010;R\u0011\u0010@\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\bA\u00107R\u001c\u0010B\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0012\"\u0004\bD\u0010\u0014R\u0011\u0010E\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020F¢\u0006\b\n\u0000\u001a\u0004\bK\u0010HR\u0010\u0010L\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u000eR\u000e\u0010P\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Q\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bV\u0010TR\u0011\u0010W\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bX\u0010TR\u0011\u0010Y\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010TR\u0011\u0010[\u001a\u00020R¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010T¨\u0006°\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView;", "Lcom/obric/oui/forms/AbsOForm;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "arrangeDirection", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "DEFAULT_MAX_LINES", "actionContainer", "Landroid/view/ViewGroup;", "getActionContainer", "()Landroid/view/ViewGroup;", "activeBorderView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getActiveBorderView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setActiveBorderView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "config", "Lcom/obric/oui/forms/OLineInputView$Config;", "counterTextWatcher", "Landroid/text/TextWatcher;", "divider", "Lcom/obric/oui/divider/ODivider;", "getDivider", "()Lcom/obric/oui/divider/ODivider;", "editText", "Lcom/obric/oui/forms/OFormEditText;", "getEditText", "()Lcom/obric/oui/forms/OFormEditText;", "errorTips", "", "inputContainer", "getInputContainer", "inputTips", "isErrorState", "", "isShowActionImage", "isShowActionText", "isShowErrorTips", "isShowInputTips", "isShowPrefix", "isShowSuffix", "isShowTitle", "isShowTitleIcon", "ivAction", "Landroid/widget/ImageView;", "getIvAction", "()Landroid/widget/ImageView;", "ivActionContainer", "Landroid/widget/LinearLayout;", "getIvActionContainer", "()Landroid/widget/LinearLayout;", "ivClear", "getIvClear", "ivClearContainer", "getIvClearContainer", "ivTitleIcon", "getIvTitleIcon", "leftContainer", "getLeftContainer", "setLeftContainer", "prefixContainer", "Landroid/widget/RelativeLayout;", "getPrefixContainer", "()Landroid/widget/RelativeLayout;", "showTitleDefaultIcon", "suffixContainer", "getSuffixContainer", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "textGravity", "titleContainer", "getTitleContainer", "titleDefaultIconSize", "tvAction", "Landroid/widget/TextView;", "getTvAction", "()Landroid/widget/TextView;", "tvCounter", "getTvCounter", "tvErrorTips", "getTvErrorTips", "tvInputTips", "getTvInputTips", "tvTitle", "getTvTitle", "clear", "", "editTextOnFocusChangeListener", "handler", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, BaseSwitches.V, "hasFocus", "enableVerticalScrollBar", "enable", "getConfig", "getInterEditText", "Landroid/widget/EditText;", "getText", "hideActionImage", "hideActionText", "hideClear", "hideDivider", "hideErrorTips", "hideInputTips", "hidePrefixView", "hideSoftInput", "hideSuffixView", "hideTitle", "hideTitleIcon", "onAttachedToWindow", "onTextExceedLengthListener", "Lkotlin/Function1;", "s", "refreshConfig", "setAutoHideClearWhenTextEmpty", "flag", "setEditTextOnFocusChangeListener", "listener", "Landroid/view/View$OnFocusChangeListener;", "setEnabled", "enabled", "setInputContainerBackground", "drawable", "Landroid/graphics/drawable/Drawable;", "setInputContainerPadding", "left", "top", "right", "bottom", "setInputViewActived", "setInputViewError", "setInputViewNormal", "setMiddleTitleIcon", "setMode", "mode", "clickListener", "Landroid/view/View$OnClickListener;", "setSmallTitleIcon", "setText", "setTextClearedListener", "textClearedListener", "Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "setTextExceedLengthListener", "textExceedLengthListener", "Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "setTextWatcher", "textWatcher", "showActionImage", "showActionText", "showClear", "showDivider", "showErrorTips", "tips", "showInputTips", "showPrefixView", "showSoftInput", "showSuffixView", "showTitle", "showTitleIcon", "updateConfig", "newConfig", "Companion", "Config", "TextClearedListener", "TextExceedLengthListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$Companion;", "", "()V", "ARRANGE_DIRECTION_HORIZONTAL", "", "ARRANGE_DIRECTION_VERTICAL", "ARRANGE_DIRECTION_VERTICAL_SINGEL_BOX", "CLICK_MODE", "INPUT_MODE", "SIZE_MEDIUM", "SIZE_SMALL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b]\u0018\u00002\u00020\u0001:\u0002\u0081\u0001B«\u0002\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&J\u0016\u0010\u0014\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u00152\u0006\u0010r\u001a\u00020\u0017J3\u0010\u000e\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\u00052\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010vJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010w\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010x\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010z\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\fJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010}\u001a\u00020\tJ\u000e\u0010b\u001a\u00020\u00002\u0006\u0010}\u001a\u00020\tJ\u000e\u0010~\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u0015J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u007f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u007f\u001a\u00020\u0005J\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000f\u0010\u000f\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020\u0010J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010!\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00100\"\u0004\bG\u00102R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00100\"\u0004\bK\u00102R\u001a\u0010\u001d\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u00104\"\u0004\bL\u00106R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010(\"\u0004\bN\u0010*R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bO\u00108\"\u0004\bP\u0010:R\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00104\"\u0004\bV\u00106R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00106R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00104\"\u0004\b`\u00106R\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010X\"\u0004\bb\u0010ZR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00100\"\u0004\bp\u00102¨\u0006\u0082\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$Config;", "", "title", "", "showCounter", "", "showClear", "hintText", "prefixView", "Landroid/view/View;", "suffixView", "lengthLimit", "", "showDivider", "actionText", "textWatcher", "Landroid/text/TextWatcher;", "editTextOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "actionTextClickable", "actionImageDrawable", "Landroid/graphics/drawable/Drawable;", "actionTextListener", "Landroid/view/View$OnClickListener;", "actionImageDrawableListener", "inputTips", "actionTextColor", "inputBoxHeight", "ivTitleIcon", "isInSearchBar", "autoHideClearWhenTextEmpty", "multiLine", "mode", "hideClearWhenNoFocus", "textExceedLengthListener", "Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "textClearedListener", "Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "(Ljava/lang/String;ZZLjava/lang/String;Landroid/view/View;Landroid/view/View;Ljava/lang/Integer;ZLjava/lang/String;Landroid/text/TextWatcher;Landroid/view/View$OnFocusChangeListener;ZLandroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;ZZZIZLcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "getActionImageDrawable", "()Landroid/graphics/drawable/Drawable;", "setActionImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getActionImageDrawableListener", "()Landroid/view/View$OnClickListener;", "setActionImageDrawableListener", "(Landroid/view/View$OnClickListener;)V", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "getActionTextClickable", "()Z", "setActionTextClickable", "(Z)V", "getActionTextColor", "()Ljava/lang/Integer;", "setActionTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getActionTextListener", "setActionTextListener", "getAutoHideClearWhenTextEmpty", "setAutoHideClearWhenTextEmpty", "getEditTextOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setEditTextOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "getHideClearWhenNoFocus", "setHideClearWhenNoFocus", "getHintText", "setHintText", "getInputBoxHeight", "setInputBoxHeight", "getInputTips", "setInputTips", "setInSearchBar", "getIvTitleIcon", "setIvTitleIcon", "getLengthLimit", "setLengthLimit", "getMode", "()I", "setMode", "(I)V", "getMultiLine", "setMultiLine", "getPrefixView", "()Landroid/view/View;", "setPrefixView", "(Landroid/view/View;)V", "getShowClear", "setShowClear", "getShowCounter", "setShowCounter", "getShowDivider", "setShowDivider", "getSuffixView", "setSuffixView", "getTextClearedListener", "()Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "setTextClearedListener", "(Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "getTextExceedLengthListener", "()Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "setTextExceedLengthListener", "(Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;)V", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "getTitle", "setTitle", "drawable", "onClickListener", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "clickable", TypedValues.Custom.S_COLOR, "(Ljava/lang/String;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;)Lcom/obric/oui/forms/OLineInputView$Config;", "autoHide", "listener", "hide", o.g, "tips", "limit", "view", "setTitleIcon", "show", "watcher", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13872b;
        private boolean c;
        private String d;
        private View e;
        private View f;
        private Integer g;
        private boolean h;
        private String i;
        private TextWatcher j;
        private View.OnFocusChangeListener k;
        private boolean l;
        private Drawable m;
        private View.OnClickListener n;
        private View.OnClickListener o;
        private String p;
        private Integer q;
        private Integer r;
        private Drawable s;
        private boolean t;
        private boolean u;
        private boolean v;
        private int w;
        private boolean x;
        private d y;
        private c z;

        @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0018\u0002\n\u0002\b)\b\u0086\b\u0018\u00002\u00020\u0001B©\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u0012\b\b\u0002\u0010 \u001a\u00020\n\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&J\u0016\u0010\u0016\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020\u0015J3\u0010\u0011\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\b2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010vJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010w\u001a\u00020\bJ\u0006\u0010x\u001a\u00020yJ\t\u0010z\u001a\u00020\u0003HÆ\u0003J\t\u0010{\u001a\u00020\bHÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\t\u0010~\u001a\u00020\bHÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0088\u0001\u001a\u00020\bHÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010#HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010%HÆ\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\bHÆ\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u00108J\n\u0010\u0090\u0001\u001a\u00020\bHÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J´\u0002\u0010\u0094\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0013\u001a\u00020\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\n2\b\b\u0002\u0010!\u001a\u00020\b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%HÆ\u0001¢\u0006\u0003\u0010\u0095\u0001J\u000f\u0010\u001a\u001a\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\u001bJ\u0015\u0010\u0097\u0001\u001a\u00020\b2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0099\u0001\u001a\u00020\nHÖ\u0001J\u000f\u0010!\u001a\u00020\u00002\u0007\u0010\u009a\u0001\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010s\u001a\u00020\u0003J\u000f\u0010\u001c\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020\nJ\u000f\u0010\u0004\u001a\u00020\u00002\u0007\u0010\u009c\u0001\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\bJ\u000f\u0010\t\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\nJ\u000e\u0010T\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bJ\u000f\u0010W\u001a\u00020\u00002\u0007\u0010\u009e\u0001\u001a\u00020\u000eJ\u000f\u0010`\u001a\u00020\u00002\u0007\u0010\u009e\u0001\u001a\u00020\u000eJ\u000e\u0010p\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000f\u0010\u0007\u001a\u00020\u00002\u0007\u0010\u009f\u0001\u001a\u00020\bJ\u000f\u0010\u0010\u001a\u00020\u00002\u0007\u0010\u009f\u0001\u001a\u00020\bJ\u0010\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u000f\u0010\u0018\u001a\u00020\u00002\u0007\u0010 \u0001\u001a\u00020\u0019J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\n\u0010¡\u0001\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001a\u0010\u001e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010!\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00100\"\u0004\bG\u00102R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bH\u00108\"\u0004\bI\u0010:R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00100\"\u0004\bK\u00102R\u001a\u0010\u001d\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u00104\"\u0004\bL\u00106R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\bM\u00108\"\u0004\bN\u0010:R\u001a\u0010 \u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00104\"\u0004\bT\u00106R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00104\"\u0004\bZ\u00106R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00104\"\u0004\b\\\u00106R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00106R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010V\"\u0004\b`\u0010XR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00100\"\u0004\bn\u00102R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010(\"\u0004\bp\u0010*¨\u0006¢\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$Config$Builder;", "", "title", "", "inputTips", "titleIcon", "Landroid/graphics/drawable/Drawable;", "showCounter", "", "lengthLimit", "", "showClear", "hintText", "prefixView", "Landroid/view/View;", "suffixView", "showDivider", "actionText", "actionTextColor", "actionTextClickable", "actionTextListener", "Landroid/view/View$OnClickListener;", "actionImageDrawable", "actionImageDrawableListener", "textWatcher", "Landroid/text/TextWatcher;", "editTextOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "inputBoxHeight", "isInSearchBar", "autoHideClearWhenTextEmpty", "multiLine", "mode", "hideClearWhenNoFocus", "textExceedLengthListener", "Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "textClearedListener", "Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ZLjava/lang/Integer;ZLjava/lang/String;Landroid/view/View;Landroid/view/View;ZLjava/lang/String;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;Landroid/text/TextWatcher;Landroid/view/View$OnFocusChangeListener;Ljava/lang/Integer;ZZZIZLcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "getActionImageDrawable", "()Landroid/graphics/drawable/Drawable;", "setActionImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getActionImageDrawableListener", "()Landroid/view/View$OnClickListener;", "setActionImageDrawableListener", "(Landroid/view/View$OnClickListener;)V", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "getActionTextClickable", "()Z", "setActionTextClickable", "(Z)V", "getActionTextColor", "()Ljava/lang/Integer;", "setActionTextColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getActionTextListener", "setActionTextListener", "getAutoHideClearWhenTextEmpty", "setAutoHideClearWhenTextEmpty", "getEditTextOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setEditTextOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "getHideClearWhenNoFocus", "setHideClearWhenNoFocus", "getHintText", "setHintText", "getInputBoxHeight", "setInputBoxHeight", "getInputTips", "setInputTips", "setInSearchBar", "getLengthLimit", "setLengthLimit", "getMode", "()I", "setMode", "(I)V", "getMultiLine", "setMultiLine", "getPrefixView", "()Landroid/view/View;", "setPrefixView", "(Landroid/view/View;)V", "getShowClear", "setShowClear", "getShowCounter", "setShowCounter", "getShowDivider", "setShowDivider", "getSuffixView", "setSuffixView", "getTextClearedListener", "()Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "setTextClearedListener", "(Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)V", "getTextExceedLengthListener", "()Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "setTextExceedLengthListener", "(Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;)V", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "getTitle", "setTitle", "getTitleIcon", "setTitleIcon", "drawable", "onClickListener", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "clickable", TypedValues.Custom.S_COLOR, "(Ljava/lang/String;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;)Lcom/obric/oui/forms/OLineInputView$Config$Builder;", "autoHide", "build", "Lcom/obric/oui/forms/OLineInputView$Config;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ZLjava/lang/Integer;ZLjava/lang/String;Landroid/view/View;Landroid/view/View;ZLjava/lang/String;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;Landroid/text/TextWatcher;Landroid/view/View$OnFocusChangeListener;Ljava/lang/Integer;ZZZIZLcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;Lcom/obric/oui/forms/OLineInputView$TextClearedListener;)Lcom/obric/oui/forms/OLineInputView$Config$Builder;", "listener", "equals", "other", "hashCode", "hide", o.g, "tips", "limit", "view", "show", "watcher", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f13873a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f13874b;
            private Drawable c;
            private boolean d;
            private Integer e;
            private boolean f;
            private String g;
            private View h;
            private View i;
            private boolean j;
            private String k;
            private Integer l;
            private boolean m;
            private View.OnClickListener n;
            private Drawable o;
            private View.OnClickListener p;
            private TextWatcher q;
            private View.OnFocusChangeListener r;
            private Integer s;
            private boolean t;
            private boolean u;
            private boolean v;
            private int w;
            private boolean x;
            private d y;
            private c z;

            public a() {
                this(null, null, null, false, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, false, 0, false, null, null, 67108863, null);
            }

            public a(String r11, String r12, Drawable r13, boolean r14, Integer r15, boolean r16, String r17, View r18, View r19, boolean r20, String r21, Integer r22, boolean r23, View.OnClickListener r24, Drawable r25, View.OnClickListener r26, TextWatcher r27, View.OnFocusChangeListener r28, Integer r29, boolean r30, boolean r31, boolean r32, int r33, boolean r34, d r35, c r36) {
                View.OnClickListener r2 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r24, View.OnClickListener.class, "com.obric.memorydata.plugin");
                View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r26, View.OnClickListener.class, "com.obric.memorydata.plugin");
                TextWatcher r5 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r27, TextWatcher.class, "com.obric.memorydata.plugin");
                View.OnFocusChangeListener r6 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r28, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
                d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r35, d.class, "com.obric.memorydata.plugin");
                c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r36, c.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r11, "title");
                this.f13873a = r11;
                this.f13874b = r12;
                this.c = r13;
                this.d = r14;
                this.e = r15;
                this.f = r16;
                this.g = r17;
                this.h = r18;
                this.i = r19;
                this.j = r20;
                this.k = r21;
                this.l = r22;
                this.m = r23;
                this.n = r2;
                this.o = r25;
                this.p = r4;
                this.q = r5;
                this.r = r6;
                this.s = r29;
                this.t = r30;
                this.u = r31;
                this.v = r32;
                this.w = r33;
                this.x = r34;
                this.y = r7;
                this.z = r3;
            }

            public /* synthetic */ a(String r28, String r29, Drawable r30, boolean r31, Integer r32, boolean r33, String r34, View r35, View r36, boolean r37, String r38, Integer r39, boolean r40, View.OnClickListener r41, Drawable r42, View.OnClickListener r43, TextWatcher r44, View.OnFocusChangeListener r45, Integer r46, boolean r47, boolean r48, boolean r49, int r50, boolean r51, d r52, c r53, int r54, DefaultConstructorMarker r55) {
                View.OnClickListener r1 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r41, View.OnClickListener.class, "com.obric.memorydata.plugin");
                View.OnClickListener r3 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r43, View.OnClickListener.class, "com.obric.memorydata.plugin");
                TextWatcher r4 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r44, TextWatcher.class, "com.obric.memorydata.plugin");
                View.OnFocusChangeListener r5 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r45, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
                d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r52, d.class, "com.obric.memorydata.plugin");
                c r2 = (c) ZeusTransformUtils.wrapperContextForParams(r53, c.class, "com.obric.memorydata.plugin");
                if ((r54 & 1) == 0) goto L5;
                String r7 = "标题";
            L7:
                if ((r54 & 2) == 0) goto L9;
                String r8 = null;
            L11:
                if ((r54 & 4) == 0) goto L13;
                Drawable r10 = null;
            L15:
                if ((r54 & 8) == 0) goto L17;
                boolean r11 = false;
            L19:
                if ((r54 & 16) == 0) goto L21;
                Integer r13 = null;
            L23:
                if ((r54 & 32) == 0) goto L25;
                boolean r14 = false;
            L27:
                if ((r54 & 64) == 0) goto L29;
                String r15 = null;
            L31:
                if ((r54 & 128) == 0) goto L33;
                View r9 = null;
            L35:
                if ((r54 & 256) == 0) goto L37;
                View r12 = null;
            L38:
                boolean r16 = true;
                if ((r54 & 512) == 0) goto L41;
                boolean r17 = true;
            L43:
                if ((r54 & 1024) == 0) goto L45;
                String r18 = null;
            L47:
                if ((r54 & 2048) == 0) goto L49;
                Integer r19 = null;
            L51:
                if ((r54 & 4096) == 0) goto L53;
                boolean r20 = false;
            L55:
                if ((r54 & 8192) == 0) goto L57;
                View.OnClickListener r21 = null;
            L59:
                if ((r54 & 16384) == 0) goto L61;
                Drawable r22 = null;
            L63:
                if ((r54 & 32768) == 0) goto L65;
                View.OnClickListener r110 = null;
            L67:
                if ((r54 & 65536) == 0) goto L69;
                TextWatcher r111 = null;
            L71:
                if ((r54 & 131072) == 0) goto L73;
                View.OnFocusChangeListener r112 = null;
            L75:
                if ((r54 & 262144) == 0) goto L77;
                Integer r23 = null;
            L79:
                if ((r54 & 524288) == 0) goto L81;
                boolean r24 = false;
            L83:
                if ((r54 & 1048576) == 0) goto L85;
                boolean r25 = false;
            L87:
                if ((r54 & 2097152) == 0) goto L89;
                boolean r26 = false;
            L91:
                if ((r54 & 4194304) == 0) goto L93;
                int r27 = 2;
            L95:
                if ((r54 & 8388608) != 0) goto L99;
                r16 = r51;
            L99:
                if ((r54 & 16777216) == 0) goto L101;
                d r210 = null;
            L103:
                if ((r54 & 33554432) == 0) goto L105;
                c r0 = null;
            L106:
                this(r7, r8, r10, r11, r13, r14, r15, r9, r12, r17, r18, r19, r20, r21, r22, r110, r111, r112, r23, r24, r25, r26, r27, r16, r210, r0);
                return;
            L105:
                r0 = r2;
                goto L106
            L101:
                r210 = r6;
                goto L103
            L93:
                r27 = r50;
                goto L95
            L89:
                r26 = r49;
                goto L91
            L85:
                r25 = r48;
                goto L87
            L81:
                r24 = r47;
                goto L83
            L77:
                r23 = r46;
                goto L79
            L73:
                r112 = r5;
                goto L75
            L69:
                r111 = r4;
                goto L71
            L65:
                r110 = r3;
                goto L67
            L61:
                r22 = r42;
                goto L63
            L57:
                r21 = r1;
                goto L59
            L53:
                r20 = r40;
                goto L55
            L49:
                r19 = r39;
                goto L51
            L45:
                r18 = r38;
                goto L47
            L41:
                r17 = r37;
                goto L43
            L37:
                r12 = r36;
                goto L38
            L33:
                r9 = r35;
                goto L35
            L29:
                r15 = r34;
                goto L31
            L25:
                r14 = r33;
                goto L27
            L21:
                r13 = r32;
                goto L23
            L17:
                r11 = r31;
                goto L19
            L13:
                r10 = r30;
                goto L15
            L9:
                r8 = r29;
                goto L11
            L5:
                r7 = r28;
                goto L7
            }

            public final b a() {
                String r2 = this.f13873a;
                String r1 = this.f13874b;
                Drawable r3 = this.c;
                boolean r4 = this.d;
                boolean r5 = this.f;
                String r6 = this.g;
                Integer r8 = this.e;
                boolean r9 = this.j;
                String r10 = this.k;
                TextWatcher r11 = this.q;
                View r7 = this.h;
                View r12 = this.i;
                boolean r13 = this.m;
                View.OnClickListener r15 = this.n;
                Drawable r14 = this.o;
                View.OnClickListener r16 = this.p;
                Integer r17 = this.l;
                return new b(r2, r4, r5, r6, r7, r12, r8, r9, r10, r11, this.r, r13, r14, r15, r16, r1, r17, this.s, r3, this.t, this.u, this.v, this.w, this.x, this.y, this.z, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f13873a, r6.f13873a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f13874b, r6.f13874b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (this.d == r6.d) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
                return false;
            L24:
                if (this.f == r6.f) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
                return false;
            L30:
                if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
                return false;
            L33:
                if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
                return false;
            L36:
                if (this.j == r6.j) goto L39;
                return false;
            L39:
                if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
                return false;
            L42:
                if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
                return false;
            L45:
                if (this.m == r6.m) goto L48;
                return false;
            L48:
                if (Intrinsics.areEqual(this.n, r6.n) == true) goto L51;
                return false;
            L51:
                if (Intrinsics.areEqual(this.o, r6.o) == true) goto L54;
                return false;
            L54:
                if (Intrinsics.areEqual(this.p, r6.p) == true) goto L57;
                return false;
            L57:
                if (Intrinsics.areEqual(this.q, r6.q) == true) goto L60;
                return false;
            L60:
                if (Intrinsics.areEqual(this.r, r6.r) == true) goto L63;
                return false;
            L63:
                if (Intrinsics.areEqual(this.s, r6.s) == true) goto L66;
                return false;
            L66:
                if (this.t == r6.t) goto L69;
                return false;
            L69:
                if (this.u == r6.u) goto L72;
                return false;
            L72:
                if (this.v == r6.v) goto L75;
                return false;
            L75:
                if (this.w == r6.w) goto L78;
                return false;
            L78:
                if (this.x == r6.x) goto L81;
                return false;
            L81:
                if (Intrinsics.areEqual(this.y, r6.y) == true) goto L84;
                return false;
            L84:
                if (Intrinsics.areEqual(this.z, r6.z) == true) goto L86;
                return false;
            L86:
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v23, types: [int] */
            /* JADX WARN: Type inference failed for: r1v31, types: [int] */
            /* JADX WARN: Type inference failed for: r1v51, types: [int] */
            /* JADX WARN: Type inference failed for: r1v53, types: [int] */
            /* JADX WARN: Type inference failed for: r1v55, types: [int] */
            /* JADX WARN: Type inference failed for: r1v63 */
            /* JADX WARN: Type inference failed for: r1v64 */
            /* JADX WARN: Type inference failed for: r1v65 */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v72 */
            /* JADX WARN: Type inference failed for: r1v75 */
            /* JADX WARN: Type inference failed for: r1v79 */
            /* JADX WARN: Type inference failed for: r1v81 */
            /* JADX WARN: Type inference failed for: r1v84 */
            /* JADX WARN: Type inference failed for: r1v85 */
            /* JADX WARN: Type inference failed for: r1v86 */
            /* JADX WARN: Type inference failed for: r1v87 */
            /* JADX WARN: Type inference failed for: r1v88 */
            /* JADX WARN: Type inference failed for: r1v89 */
            /* JADX WARN: Type inference failed for: r1v90 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                int r0 = this.f13873a.hashCode() * 31;
                String r1 = this.f13874b;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Drawable r5 = this.c;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                boolean r8 = this.d;
                ?? r9 = 1;
                ?? r10 = r8;
                if (r8 == false) goto L13;
                r10 = 1;
            L13:
                int r11 = (r7 + r10) * 31;
                Integer r12 = this.e;
                if (r12 != null) goto L16;
                int r13 = 0;
            L17:
                int r14 = (r11 + r13) * 31;
                boolean r15 = this.f;
                ?? r16 = r15;
                if (r15 == false) goto L20;
                r16 = 1;
            L20:
                int r17 = (r14 + r16) * 31;
                String r18 = this.g;
                if (r18 != null) goto L23;
                int r19 = 0;
            L24:
                int r20 = (r17 + r19) * 31;
                View r21 = this.h;
                if (r21 != null) goto L27;
                int r22 = 0;
            L28:
                int r23 = (r20 + r22) * 31;
                View r24 = this.i;
                if (r24 != null) goto L31;
                int r25 = 0;
            L32:
                int r26 = (r23 + r25) * 31;
                boolean r27 = this.j;
                ?? r28 = r27;
                if (r27 == false) goto L35;
                r28 = 1;
            L35:
                int r29 = (r26 + r28) * 31;
                String r30 = this.k;
                if (r30 != null) goto L38;
                int r31 = 0;
            L39:
                int r32 = (r29 + r31) * 31;
                Integer r33 = this.l;
                if (r33 != null) goto L42;
                int r34 = 0;
            L43:
                int r35 = (r32 + r34) * 31;
                boolean r36 = this.m;
                ?? r37 = r36;
                if (r36 == false) goto L46;
                r37 = 1;
            L46:
                int r38 = (r35 + r37) * 31;
                View.OnClickListener r39 = this.n;
                if (r39 != null) goto L49;
                int r40 = 0;
            L50:
                int r41 = (r38 + r40) * 31;
                Drawable r42 = this.o;
                if (r42 != null) goto L53;
                int r43 = 0;
            L54:
                int r44 = (r41 + r43) * 31;
                View.OnClickListener r45 = this.p;
                if (r45 != null) goto L57;
                int r46 = 0;
            L58:
                int r47 = (r44 + r46) * 31;
                TextWatcher r48 = this.q;
                if (r48 != null) goto L61;
                int r49 = 0;
            L62:
                int r50 = (r47 + r49) * 31;
                View.OnFocusChangeListener r51 = this.r;
                if (r51 != null) goto L65;
                int r52 = 0;
            L66:
                int r53 = (r50 + r52) * 31;
                Integer r54 = this.s;
                if (r54 != null) goto L69;
                int r55 = 0;
            L70:
                int r56 = (r53 + r55) * 31;
                boolean r57 = this.t;
                ?? r58 = r57;
                if (r57 == false) goto L73;
                r58 = 1;
            L73:
                int r59 = (r56 + r58) * 31;
                boolean r60 = this.u;
                ?? r61 = r60;
                if (r60 == false) goto L76;
                r61 = 1;
            L76:
                int r62 = (r59 + r61) * 31;
                boolean r63 = this.v;
                ?? r64 = r63;
                if (r63 == false) goto L79;
                r64 = 1;
            L79:
                int r65 = (((r62 + r64) * 31) + Integer.hashCode(this.w)) * 31;
                boolean r66 = this.x;
                if (r66 == true) goto L83;
                r9 = r66;
            L83:
                int r67 = (r65 + r9) * 31;
                d r68 = this.y;
                if (r68 != null) goto L86;
                int r69 = 0;
            L87:
                int r70 = (r67 + r69) * 31;
                c r71 = this.z;
                if (r71 == null) goto L92;
                r2 = r71.hashCode();
            L92:
                return r70 + r2;
            L86:
                r69 = r68.hashCode();
                goto L87
            L69:
                r55 = r54.hashCode();
                goto L70
            L65:
                r52 = r51.hashCode();
                goto L66
            L61:
                r49 = r48.hashCode();
                goto L62
            L57:
                r46 = r45.hashCode();
                goto L58
            L53:
                r43 = r42.hashCode();
                goto L54
            L49:
                r40 = r39.hashCode();
                goto L50
            L42:
                r34 = r33.hashCode();
                goto L43
            L38:
                r31 = r30.hashCode();
                goto L39
            L31:
                r25 = r24.hashCode();
                goto L32
            L27:
                r22 = r21.hashCode();
                goto L28
            L23:
                r19 = r18.hashCode();
                goto L24
            L16:
                r13 = r12.hashCode();
                goto L17
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public String toString() {
                StringBuilder r0 = new StringBuilder();
                r0.append("Builder(title=").append(this.f13873a).append(", inputTips=").append(this.f13874b).append(", titleIcon=").append(this.c).append(", showCounter=").append(this.d).append(", lengthLimit=").append(this.e).append(", showClear=").append(this.f).append(", hintText=").append(this.g).append(", prefixView=").append(this.h).append(", suffixView=").append(this.i).append(", showDivider=").append(this.j).append(", actionText=").append(this.k).append(", actionTextColor=");
                r0.append(this.l).append(", actionTextClickable=").append(this.m).append(", actionTextListener=").append(this.n).append(", actionImageDrawable=").append(this.o).append(", actionImageDrawableListener=").append(this.p).append(", textWatcher=").append(this.q).append(", editTextOnFocusChangeListener=").append(this.r).append(", inputBoxHeight=").append(this.s).append(", isInSearchBar=").append(this.t).append(", autoHideClearWhenTextEmpty=").append(this.u).append(", multiLine=").append(this.v).append(", mode=").append(this.w);
                r0.append(", hideClearWhenNoFocus=").append(this.x).append(", textExceedLengthListener=").append(this.y).append(", textClearedListener=").append(this.z).append(')');
                return r0.toString();
            }
        }

        private b(String r10, boolean r11, boolean r12, String r13, View r14, View r15, Integer r16, boolean r17, String r18, TextWatcher r19, View.OnFocusChangeListener r20, boolean r21, Drawable r22, View.OnClickListener r23, View.OnClickListener r24, String r25, Integer r26, Integer r27, Drawable r28, boolean r29, boolean r30, boolean r31, int r32, boolean r33, d r34, c r35) {
            TextWatcher r1 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r19, TextWatcher.class, "com.obric.memorydata.plugin");
            View.OnFocusChangeListener r3 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r20, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
            View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r23, View.OnClickListener.class, "com.obric.memorydata.plugin");
            View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r24, View.OnClickListener.class, "com.obric.memorydata.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r34, d.class, "com.obric.memorydata.plugin");
            c r2 = (c) ZeusTransformUtils.wrapperContextForParams(r35, c.class, "com.obric.memorydata.plugin");
            this.f13871a = r10;
            this.f13872b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = r18;
            this.j = r1;
            this.k = r3;
            this.l = r21;
            this.m = r22;
            this.n = r4;
            this.o = r5;
            this.p = r25;
            this.q = r26;
            this.r = r27;
            this.s = r28;
            this.t = r29;
            this.u = r30;
            this.v = r31;
            this.w = r32;
            this.x = r33;
            this.y = r6;
            this.z = r2;
        }

        public /* synthetic */ b(String r28, boolean r29, boolean r30, String r31, View r32, View r33, Integer r34, boolean r35, String r36, TextWatcher r37, View.OnFocusChangeListener r38, boolean r39, Drawable r40, View.OnClickListener r41, View.OnClickListener r42, String r43, Integer r44, Integer r45, Drawable r46, boolean r47, boolean r48, boolean r49, int r50, boolean r51, d r52, c r53, DefaultConstructorMarker r54) {
            this(r28, r29, r30, r31, r32, r33, r34, r35, r36, (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r37, TextWatcher.class, "com.obric.memorydata.plugin"), (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r38, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin"), r39, r40, (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r41, View.OnClickListener.class, "com.obric.memorydata.plugin"), (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r42, View.OnClickListener.class, "com.obric.memorydata.plugin"), r43, r44, r45, r46, r47, r48, r49, r50, r51, (d) ZeusTransformUtils.wrapperContextForParams(r52, d.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r53, c.class, "com.obric.memorydata.plugin"));
        }

        public final String a() {
            return this.f13871a;
        }

        public final void a(TextWatcher r3) {
            this.j = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r3, TextWatcher.class, "com.obric.memorydata.plugin");
        }

        public final void a(c r3) {
            this.z = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        }

        public final void a(d r3) {
            this.y = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        }

        public final void a(Integer r1) {
            this.g = r1;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.f13871a = r2;
        }

        public final void a(boolean r1) {
            this.f13872b = r1;
        }

        public final void b(Integer r1) {
            this.r = r1;
        }

        public final void b(String r1) {
            this.d = r1;
        }

        public final void b(boolean r1) {
            this.c = r1;
        }

        public final boolean b() {
            return this.f13872b;
        }

        public final void c(String r1) {
            this.p = r1;
        }

        public final void c(boolean r1) {
            this.h = r1;
        }

        public final boolean c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final void d(boolean r1) {
            this.u = r1;
        }

        public final View e() {
            return this.e;
        }

        public final void e(boolean r1) {
            this.v = r1;
        }

        public final View f() {
            return this.f;
        }

        public final Integer g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public final String i() {
            return this.i;
        }

        public final TextWatcher j() {
            return this.j;
        }

        public final View.OnFocusChangeListener k() {
            return this.k;
        }

        public final boolean l() {
            return this.l;
        }

        public final Drawable m() {
            return this.m;
        }

        public final View.OnClickListener n() {
            return this.n;
        }

        public final View.OnClickListener o() {
            return this.o;
        }

        public final String p() {
            return this.p;
        }

        public final Integer q() {
            return this.q;
        }

        public final Integer r() {
            return this.r;
        }

        public final Drawable s() {
            return this.s;
        }

        public final boolean t() {
            return this.t;
        }

        public final boolean u() {
            return this.u;
        }

        public final boolean v() {
            return this.v;
        }

        public final int w() {
            return this.w;
        }

        public final boolean x() {
            return this.x;
        }

        public final d y() {
            return this.y;
        }

        public final c z() {
            return this.z;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$TextClearedListener;", "", "afterClear", "", "beforeClear", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a();

        void b();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "", "textExceedLength", "", "s", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
        void a(String r1);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/forms/OLineInputView$editTextOnFocusChangeListener$1", "Landroid/view/View$OnFocusChangeListener;", "onFocusChange", "", BaseSwitches.V, "Landroid/view/View;", "hasFocus", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<View, Boolean, Unit> f13875a;

        e(Function2<? super View, ? super Boolean, Unit> r3) {
            this.f13875a = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View r1, boolean r2) {
            this.f13875a.invoke(r1, Boolean.valueOf(r2));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/oui/forms/OLineInputView$onTextExceedLengthListener$1", "Lcom/obric/oui/forms/OLineInputView$TextExceedLengthListener;", "textExceedLength", "", "s", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f13876a;

        f(Function1<? super String, Unit> r3) {
            this.f13876a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.forms.OLineInputView.d
        public void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "s");
            this.f13876a.invoke(r2);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/obric/oui/forms/OLineInputView$refreshConfig$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OLineInputView f13877a;

        g(OLineInputView r1) {
            this.f13877a = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r4) {
            Editable r5 = (Editable) ZeusTransformUtils.wrapperContextForParams(r4, Editable.class, "com.obric.memorydata.plugin");
            if (OLineInputView.access$getConfig$p(this.f13877a).g() == null) goto L18;
            int r0 = 0;
            if (r5 != null) goto L7;
            int r1 = 0;
        L8:
            Integer r2 = OLineInputView.access$getConfig$p(this.f13877a).g();
            if (r2 == null) goto L12;
            r0 = r2.intValue();
        L12:
            if (r1 <= r0) goto L19;
            d r3 = OLineInputView.access$getConfig$p(this.f13877a).y();
            if (r3 == null) goto L20;
            r3.a(String.valueOf(r5));
            return;
        L20:
            return;
        L19:
            return;
        L7:
            r1 = r5.length();
            goto L8
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r6, int r7, int r8, int r9) {
            CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
            if (OLineInputView.access$getConfig$p(this.f13877a).g() == null) goto L28;
            Resources r11 = ZeusTransformUtils.getResources(this.f13877a, "com.obric.memorydata.plugin");
            int r12 = ZeusTransformUtils.mapRes(R.string.oui_form_counter, TypedValues.Custom.S_STRING, "oui_form_counter");
            Object[] r0 = new Object[2];
            if (r10 != null) goto L7;
            String r1 = null;
        L8:
            r0[0] = r1;
            r0[1] = String.valueOf(OLineInputView.access$getConfig$p(this.f13877a).g());
            String r13 = r11.getString(r12, r0);
            Intrinsics.checkNotNullExpressionValue(r13, "resources.getString(\n   …                        )");
            SpannableString r14 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
            if (r10 != null) goto L11;
            int r15 = 0;
        L12:
            Integer r2 = OLineInputView.access$getConfig$p(this.f13877a).g();
            if (r2 != null) goto L15;
            int r3 = 0;
        L16:
            if (r15 <= r3) goto L25;
            ForegroundColorSpan r16 = new ForegroundColorSpan(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13877a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.Primary, TypedValues.Custom.S_COLOR, "Primary")));
            if (r10 != null) goto L20;
        L19:
            int r17 = 0;
        L24:
            r14.setSpan(r16, 0, r17, 18);
            this.f13877a.getDivider().setBackgroundColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13877a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.Primary, TypedValues.Custom.S_COLOR, "Primary")));
        L26:
            this.f13877a.getTvCounter().setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.SPANNABLE);
            return;
        L20:
            String r18 = Integer.valueOf(r10.length()).toString();
            if (r18 == null) goto L19;
            r17 = r18.length();
            goto L24
        L25:
            this.f13877a.getDivider().setStyle(0);
            goto L26
        L15:
            r3 = r2.intValue();
            goto L16
        L11:
            r15 = Integer.valueOf(r10.length()).intValue();
            goto L12
        L7:
            r1 = Integer.valueOf(r10.length()).toString();
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/obric/oui/forms/OLineInputView$refreshConfig$clearWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OLineInputView f13878a;

        h(OLineInputView r1) {
            this.f13878a = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast((Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L5;
        L8:
            boolean r5 = true;
        L9:
            OLineInputView r2 = this.f13878a;
            if (r5 == false) goto L12;
            r2.hideClear();
            return;
        L12:
            r2.showClear();
            return;
        L5:
            if (r4.length() == 0) goto L8;
            r5 = false;
            goto L9
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new a(null);
    }

    public OLineInputView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OLineInputView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OLineInputView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OLineInputView(Context r36, AttributeSet r37, int r38, int r39) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r36, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r37, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r4, r38);
        this.arrangeDirection = r39;
        this.config = new b.a(null, null, null, false, null, false, null, null, null, false, null, null, false, null, null, null, null, null, null, false, false, false, 0, false, null, null, 67108863, null).a();
        this.textGravity = 16;
        this.isShowTitle = true;
        this.DEFAULT_MAX_LINES = 20;
        this.errorTips = "";
        this.inputTips = "";
        TypedArray r1 = r2.getTheme().obtainStyledAttributes(r4, R.styleable.OLineInputView, r38, 0);
        setArrangeDirection(r1.getInt(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formArrangeDirection, "styleable", "OLineInputView_oui_formArrangeDirection"), 0));
        String r5 = r1.getString(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formTitle, "styleable", "OLineInputView_oui_formTitle"));
        b r8 = this.config;
        if (r5 != null) goto L5;
        r5 = "title";
    L5:
        r8.a(r5);
        boolean r6 = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formShowClear, "styleable", "OLineInputView_oui_formShowClear"), true);
        this.config.b(r6);
        String r7 = r1.getString(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_android_hint, "styleable", "OLineInputView_android_hint"));
        this.config.b(r7);
        boolean r9 = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formShowCounter, "styleable", "OLineInputView_oui_formShowCounter"), false);
        this.config.a(r9);
        int r10 = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formLengthLimit, "styleable", "OLineInputView_oui_formLengthLimit"), 0);
        if (r10 <= 0) goto L8;
        this.config.a(Integer.valueOf(r10));
    L8:
        int r11 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formInputHeight, "styleable", "OLineInputView_oui_formInputHeight"), 0);
        if (r11 <= 0) goto L11;
        this.config.b(Integer.valueOf(r11));
    L11:
        this.config.e(r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formMultiLine, "styleable", "OLineInputView_oui_formMultiLine"), false));
        boolean r12 = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formShowDivider, "styleable", "OLineInputView_oui_formShowDivider"), true);
        this.config.c(r12);
        String r13 = r1.getString(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formInputTips, "styleable", "OLineInputView_oui_formInputTips"));
        this.config.c(r13);
        this.text = r1.getString(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_android_text, "styleable", "OLineInputView_android_text"));
        this.showTitleDefaultIcon = r1.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formShowTitleDefaultIcon, "styleable", "OLineInputView_oui_formShowTitleDefaultIcon"), false);
        this.titleDefaultIconSize = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_oui_formTitleDefaultIconSize, "styleable", "OLineInputView_oui_formTitleDefaultIconSize"), 0);
        this.textGravity = r1.getInt(ZeusTransformUtils.mapRes(R.styleable.OLineInputView_android_gravity, "styleable", "OLineInputView_android_gravity"), 16);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        int r3 = this.arrangeDirection;
        String r14 = "o_form_line_input_vertical";
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L15;
        int r15 = R.layout.o_form_line_input_horizontal;
        r14 = "o_form_line_input_horizontal";
    L20:
        int r16 = ZeusTransformUtils.mapRes(r15, "layout", r14);
        ZeusTransformUtils.inflate(LayoutInflater.from(r2), r16, (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r17, TextView.class, "com.obric.memorydata.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.et_input, OaidModel.KEY_ID, "et_input"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.et_input)");
        OFormEditText r19 = (OFormEditText) ZeusTransformUtils.preCheckCast(r18, OFormEditText.class, "com.obric.memorydata.plugin");
        this.editText = r19;
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_error_tips, OaidModel.KEY_ID, "tv_error_tips"));
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.tv_error_tips)");
        this.tvErrorTips = (TextView) ZeusTransformUtils.preCheckCast(r20, TextView.class, "com.obric.memorydata.plugin");
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_counter, OaidModel.KEY_ID, "tv_counter"));
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.tv_counter)");
        this.tvCounter = (TextView) ZeusTransformUtils.preCheckCast(r21, TextView.class, "com.obric.memorydata.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_action, OaidModel.KEY_ID, "tv_action"));
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.tv_action)");
        this.tvAction = (TextView) ZeusTransformUtils.preCheckCast(r22, TextView.class, "com.obric.memorydata.plugin");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_clear, OaidModel.KEY_ID, "iv_clear"));
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.iv_clear)");
        this.ivClear = (ImageView) ZeusTransformUtils.preCheckCast(r23, ImageView.class, "com.obric.memorydata.plugin");
        View r24 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_action, OaidModel.KEY_ID, "iv_action"));
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.iv_action)");
        this.ivAction = (ImageView) ZeusTransformUtils.preCheckCast(r24, ImageView.class, "com.obric.memorydata.plugin");
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.divider, OaidModel.KEY_ID, "divider"));
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.divider)");
        this.divider = (ODivider) ZeusTransformUtils.preCheckCast(r25, ODivider.class, "com.obric.memorydata.plugin");
        View r26 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_title_icon, OaidModel.KEY_ID, "iv_title_icon"));
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.iv_title_icon)");
        this.ivTitleIcon = (ImageView) ZeusTransformUtils.preCheckCast(r26, ImageView.class, "com.obric.memorydata.plugin");
        View r27 = findViewById(ZeusTransformUtils.mapRes(R.id.prefix_container, OaidModel.KEY_ID, "prefix_container"));
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.prefix_container)");
        this.prefixContainer = (RelativeLayout) ZeusTransformUtils.preCheckCast(r27, RelativeLayout.class, "com.obric.memorydata.plugin");
        View r28 = findViewById(ZeusTransformUtils.mapRes(R.id.suffix_container, OaidModel.KEY_ID, "suffix_container"));
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.suffix_container)");
        this.suffixContainer = (RelativeLayout) ZeusTransformUtils.preCheckCast(r28, RelativeLayout.class, "com.obric.memorydata.plugin");
        View r29 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_input_tips, OaidModel.KEY_ID, "tv_input_tips"));
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.tv_input_tips)");
        this.tvInputTips = (TextView) ZeusTransformUtils.preCheckCast(r29, TextView.class, "com.obric.memorydata.plugin");
        View r30 = findViewById(ZeusTransformUtils.mapRes(R.id.title_container, OaidModel.KEY_ID, "title_container"));
        Intrinsics.checkNotNullExpressionValue(r30, "findViewById(R.id.title_container)");
        this.titleContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r30, ViewGroup.class, "com.obric.memorydata.plugin");
        View r31 = findViewById(ZeusTransformUtils.mapRes(R.id.input_container, OaidModel.KEY_ID, "input_container"));
        Intrinsics.checkNotNullExpressionValue(r31, "findViewById(R.id.input_container)");
        this.inputContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r31, ViewGroup.class, "com.obric.memorydata.plugin");
        this.leftContainer = (ConstraintLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.left_container, OaidModel.KEY_ID, "left_container")), ConstraintLayout.class, "com.obric.memorydata.plugin");
        View r32 = findViewById(ZeusTransformUtils.mapRes(R.id.action_container, OaidModel.KEY_ID, "action_container"));
        Intrinsics.checkNotNullExpressionValue(r32, "findViewById(R.id.action_container)");
        this.actionContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r32, ViewGroup.class, "com.obric.memorydata.plugin");
        this.activeBorderView = (ConstraintLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.active_border_view, OaidModel.KEY_ID, "active_border_view")), ConstraintLayout.class, "com.obric.memorydata.plugin");
        View r33 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_clear_container, OaidModel.KEY_ID, "iv_clear_container"));
        Intrinsics.checkNotNullExpressionValue(r33, "findViewById(R.id.iv_clear_container)");
        this.ivClearContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r33, LinearLayout.class, "com.obric.memorydata.plugin");
        View r34 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_action_container, OaidModel.KEY_ID, "iv_action_container"));
        Intrinsics.checkNotNullExpressionValue(r34, "findViewById(R.id.iv_action_container)");
        this.ivActionContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r34, LinearLayout.class, "com.obric.memorydata.plugin");
        updateConfig(this.config);
        r19.setVerticalScrollBarEnabled(false);
        return;
    L15:
        if (r3 != 2) goto L19;
        r15 = R.layout.o_form_line_input_vertical_single_box;
        r14 = "o_form_line_input_vertical_single_box";
    L19:
        r15 = R.layout.o_form_line_input_vertical;
        goto L20
    }

    public /* synthetic */ OLineInputView(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 1;
    L11:
        this(r8, r9, r4, r5);
    }

    public static final /* synthetic */ b access$getConfig$p(OLineInputView r0) {
        return r0.config;
    }

    private final void clear() {
        Iterator<WeakReference<TextWatcher>> r0 = getTextWatchers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        WeakReference r1 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.next(), WeakReference.class, "com.obric.memorydata.plugin");
        this.editText.removeTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r1.get(), TextWatcher.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private final void hideSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public static /* synthetic */ void lambda$4FGNJEnZKHDngkEiL2piCrhLJpI(OLineInputView r0, View r1) {
        m1307refreshConfig$lambda2(r0, r1);
    }

    public static /* synthetic */ boolean lambda$8RigH74U3xT9icIwnXijfbekH3c(OLineInputView r0, View r1, MotionEvent r2) {
        return m1309refreshConfig$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$Ez1PWrKrk__6UZd2108x3zLwl9U(OLineInputView r0, View r1, boolean r2) {
        m1308refreshConfig$lambda3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$y-zJm8vU0gwNEWdcKLw7Tg-K6Ho, reason: not valid java name */
    public static /* synthetic */ void m1305lambda$yzJm8vU0gwNEWdcKLw7TgK6Ho(OLineInputView r0, View r1, boolean r2) {
        m1306refreshConfig$lambda1(r0, r1, r2);
    }

    private final void refreshConfig() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.config.a(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        this.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.config.a(), CharSequence.class, "com.obric.memorydata.plugin"));
    L13:
        if (this.isShowTitle == false) goto L15;
        showTitle();
    L17:
        if (this.config.s() == null) goto L20;
        this.ivTitleIcon.setImageDrawable(this.config.s());
        this.isShowTitleIcon = true;
    L20:
        if (this.isShowTitleIcon == false) goto L22;
        showTitleIcon();
    L23:
        int r3 = this.titleDefaultIconSize;
        if (r3 == 0) goto L28;
        if (r3 != 1) goto L28;
        setMiddleTitleIcon();
    L30:
        if (this.config.u() == false) goto L33;
        h r4 = new h(this);
        getTextWatchers().add(new WeakReference(r4));
        this.editText.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(r4, TextWatcher.class, "com.obric.memorydata.plugin"));
    L33:
        if (this.config.b() == false) goto L38;
        if (this.config.g() == null) goto L38;
        this.counterTextWatcher = (TextWatcher) ZeusTransformUtils.preCheckCast(new g(this), TextWatcher.class, "com.obric.memorydata.plugin");
        ArrayList<WeakReference<TextWatcher>> r5 = getTextWatchers();
        TextWatcher r6 = this.counterTextWatcher;
        Intrinsics.checkNotNull(r6);
        r5.add(new WeakReference(r6));
        this.editText.addTextChangedListener(this.counterTextWatcher);
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.tvCounter, View.class, "com.obric.memorydata.plugin"));
    L38:
        if (this.config.c() == true) goto L40;
        hideClear();
        this.editText.setOnFocusChangeListener(new $$Lambda$OLineInputView$yzJm8vU0gwNEWdcKLw7TgK6Ho(this));
    L44:
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(this.config.d(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L47;
    L50:
        boolean r8 = true;
    L51:
        if (r8 == true) goto L54;
        this.editText.setHint((CharSequence) ZeusTransformUtils.preCheckCast(this.config.d(), CharSequence.class, "com.obric.memorydata.plugin"));
    L54:
        if (this.config.e() == null) goto L57;
        this.prefixContainer.removeAllViews();
        this.prefixContainer.addView(this.config.e(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        showPrefixView();
    L57:
        if (this.config.f() == null) goto L60;
        this.suffixContainer.removeAllViews();
        this.suffixContainer.addView(this.config.f(), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        showSuffixView();
    L60:
        if (this.config.t() == false) goto L63;
        this.config.c(false);
    L63:
        if (this.config.h() == false) goto L65;
        showDivider();
    L66:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(this.config.i(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L69;
    L72:
        boolean r10 = true;
    L73:
        if (r10 == true) goto L85;
        this.tvAction.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.config.i(), CharSequence.class, "com.obric.memorydata.plugin"));
        if (this.config.q() == null) goto L77;
        TextView r11 = this.tvAction;
        Integer r12 = this.config.q();
        Intrinsics.checkNotNull(r12);
        int r13 = r12.intValue();
    L78:
        r11.setTextColor(r13);
        if (this.config.l() == true) goto L81;
    L83:
        showActionText();
        goto L85
    L81:
        if (this.config.n() == null) goto L83;
        this.tvAction.setOnClickListener(this.config.n());
        goto L83
    L77:
        r11 = this.tvAction;
        r13 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.TextPrimary, TypedValues.Custom.S_COLOR, "TextPrimary"));
    L85:
        if (this.config.j() == null) goto L88;
        ArrayList<WeakReference<TextWatcher>> r14 = getTextWatchers();
        TextWatcher r15 = this.config.j();
        Intrinsics.checkNotNull(r15);
        r14.add(new WeakReference(r15));
        this.editText.addTextChangedListener(this.config.j());
    L88:
        if (this.config.m() == null) goto L94;
        this.ivAction.setImageDrawable(this.config.m());
        if (this.config.o() == null) goto L92;
        this.ivAction.setOnClickListener(this.config.o());
    L92:
        showActionImage();
    L94:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.config.p(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L97;
        String r16 = this.config.p();
        Intrinsics.checkNotNull(r16);
        showInputTips(r16);
    L97:
        if (this.config.r() == null) goto L100;
        View r17 = (View) ZeusTransformUtils.preCheckCast(this.inputContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        Objects.requireNonNull(r18, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r19 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r18, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r20 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r19, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        Integer r21 = this.config.r();
        Intrinsics.checkNotNull(r21);
        int r22 = r21.intValue();
    L99:
        r20.height = r22;
        r17.setLayoutParams(r19);
        if (this.config.v() == false) goto L111;
        OFormEditText r23 = this.editText;
        r23.setSingleLine(false);
        r23.setLines(this.DEFAULT_MAX_LINES);
    L112:
        CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(this.text, CharSequence.class, "com.obric.memorydata.plugin");
        if (r24 != null) goto L115;
    L116:
        r1 = true;
    L117:
        if (r1 == true) goto L120;
        setText(this.text);
    L120:
        if (this.showTitleDefaultIcon == true) goto L122;
    L124:
        this.editText.setGravity(this.textGravity);
        if (this.config.k() == null) goto L128;
        View.OnFocusChangeListener r25 = this.config.k();
        Intrinsics.checkNotNull(r25);
        setEditTextOnFocusChangeListener(r25);
    L128:
        if (this.isShowTitle == false) goto L130;
        showTitle();
    L132:
        if (this.isShowErrorTips == false) goto L134;
        String r26 = this.errorTips;
        Intrinsics.checkNotNull(r26);
        showErrorTips(r26);
    L136:
        if (this.isShowInputTips == false) goto L138;
        String r27 = this.inputTips;
        Intrinsics.checkNotNull(r27);
        showInputTips(r27);
    L140:
        if (this.isShowPrefix == false) goto L142;
        showPrefixView();
    L144:
        if (this.isShowSuffix == false) goto L146;
        showSuffixView();
    L148:
        if (this.isShowActionText == false) goto L150;
        showActionText();
    L152:
        if (this.isShowActionImage == false) goto L154;
        showActionImage();
    L155:
        setMode$default(this, this.config.w(), null, 2, null);
        return;
    L154:
        hideActionImage();
        goto L155
    L150:
        hideActionText();
        goto L152
    L146:
        hideSuffixView();
        goto L148
    L142:
        hidePrefixView();
        goto L144
    L138:
        hideInputTips();
        goto L140
    L134:
        hideErrorTips();
        goto L136
    L130:
        hideTitle();
        goto L132
    L122:
        if (this.config.s() != null) goto L124;
        showTitleIcon();
        goto L124
    L115:
        if (r24.length() != 0) goto L117;
    L111:
        this.editText.setSingleLine(true);
        goto L112
    L100:
        r17 = (View) ZeusTransformUtils.preCheckCast(this.inputContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r28 = r17.getLayoutParams();
        Objects.requireNonNull(r28, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        r19 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r28, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        r20 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r19, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (getArrangeDirection() == 1) goto L105;
        int r29 = 40;
        View r30 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
    L103:
        r22 = com.obric.oui.common.util.h.a(r30, r29);
        goto L99
    L105:
        if (this.config.t() == false) goto L107;
        r30 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r29 = 36;
        goto L103
    L107:
        r30 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r29 = 52;
        goto L103
    L69:
        if (r9.length() == 0) goto L72;
        r10 = false;
        goto L73
    L65:
        hideDivider();
        goto L66
    L47:
        if (r7.length() == 0) goto L50;
        r8 = false;
        goto L51
    L40:
        this.ivClear.setOnClickListener(new $$Lambda$OLineInputView$4FGNJEnZKHDngkEiL2piCrhLJpI(this));
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(this.editText.getText(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L43;
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.ivClear, View.class, "com.obric.memorydata.plugin"));
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.ivClearContainer, View.class, "com.obric.memorydata.plugin"));
    L43:
        this.editText.setOnFocusChangeListener(new $$Lambda$OLineInputView$Ez1PWrKrk__6UZd2108x3zLwl9U(this));
        this.editText.setOnTouchListener(new $$Lambda$OLineInputView$8RigH74U3xT9icIwnXijfbekH3c(this));
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
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-1, reason: not valid java name */
    private static final void m1306refreshConfig$lambda1(OLineInputView r0, View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r2 == false) goto L5;
        r0.showSoftInput();
        return;
    L5:
        r0.hideSoftInput();
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-2, reason: not valid java name */
    private static final void m1307refreshConfig$lambda2(OLineInputView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        c r2 = r0.config.z();
        if (r2 == null) goto L6;
        r2.a();
    L6:
        r0.setText("");
        c r3 = r0.config.z();
        if (r3 == null) goto L11;
        r3.b();
        return;
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-3, reason: not valid java name */
    private static final void m1308refreshConfig$lambda3(OLineInputView r1, View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r3 == false) goto L12;
        if (r1.config.u() == true) goto L7;
    L9:
        r1.showClear();
    L10:
        r1.showSoftInput();
        return;
    L7:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r1.getText(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        r1.hideClear();
        goto L10
    L12:
        if (r1.config.x() == false) goto L14;
    L15:
        r1.hideClear();
    L16:
        r1.hideSoftInput();
        return;
    L14:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r1.getText(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L16;
        goto L15
    }

    /* JADX INFO: renamed from: refreshConfig$lambda-4, reason: not valid java name */
    private static final boolean m1309refreshConfig$lambda4(OLineInputView r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r3, "event");
        int r4 = r3.getActionMasked();
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L10;
        if (r4 == 3) goto L10;
        return false;
    L10:
        if (r1.isErrorState == false) goto L15;
        ConstraintLayout r5 = r1.activeBorderView;
        if (r5 == null) goto L41;
        int r6 = R.drawable.o_line_box_input_error_default_border;
        String r0 = "o_line_box_input_error_default_border";
    L29:
        r5.setBackgroundResource(ZeusTransformUtils.mapRes(r6, "drawable", r0));
        return false;
    L41:
        return false;
    L15:
        boolean r7 = r1.editText.hasFocus();
        r5 = r1.activeBorderView;
        if (r7 == false) goto L20;
        if (r5 == null) goto L42;
        r6 = R.drawable.o_line_box_input_focused_default_border;
        r0 = "o_line_box_input_focused_default_border";
        goto L29
    L42:
        return false;
    L20:
        if (r5 == null) goto L43;
        r6 = R.drawable.o_line_box_input_normal_default_border;
        r0 = "o_line_box_input_normal_default_border";
        goto L29
    L43:
        return false;
    L24:
        if (r1.isErrorState == false) goto L30;
        r5 = r1.activeBorderView;
        if (r5 == null) goto L44;
        r6 = R.drawable.o_line_box_input_error_pressed_border;
        r0 = "o_line_box_input_error_pressed_border";
        goto L29
    L44:
        return false;
    L30:
        boolean r8 = r1.editText.hasFocus();
        r5 = r1.activeBorderView;
        if (r8 == false) goto L35;
        if (r5 == null) goto L45;
        r6 = R.drawable.o_line_box_input_focused_pressed_border;
        r0 = "o_line_box_input_focused_pressed_border";
        goto L29
    L45:
        return false;
    L35:
        if (r5 == null) goto L46;
        r6 = R.drawable.o_line_box_input_normal_pressed_border;
        r0 = "o_line_box_input_normal_pressed_border";
        goto L29
    L46:
        return false;
    }

    public static /* synthetic */ void setAutoHideClearWhenTextEmpty$default(OLineInputView r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.setAutoHideClearWhenTextEmpty(r1);
    }

    public static /* synthetic */ void setMode$default(OLineInputView r1, int r2, View.OnClickListener r3, int r4, Object r5) {
        View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.setMode(r2, r6);
    }

    private final void showSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin")).showSoftInput((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
    }

    public final void editTextOnFocusChangeListener(Function2<? super View, ? super Boolean, Unit> r3) {
        Function2 r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handler");
        setEditTextOnFocusChangeListener((View.OnFocusChangeListener) ZeusTransformUtils.preCheckCast(new e(r4), View.OnFocusChangeListener.class, "com.obric.memorydata.plugin"));
    }

    public final void enableVerticalScrollBar(boolean r1) {
        this.editText.setVerticalScrollBarEnabled(r1);
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
        return (EditText) ZeusTransformUtils.preCheckCast(this.editText, EditText.class, "com.obric.memorydata.plugin");
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
        if (((View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.memorydata.plugin"));
    L8:
        this.isShowActionImage = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideActionText() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.tvAction, View.class, "com.obric.memorydata.plugin"));
        this.isShowActionText = false;
    }

    public final void hideClear() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.ivClearContainer, View.class, "com.obric.memorydata.plugin"));
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.ivClear, View.class, "com.obric.memorydata.plugin"));
        this.config.b(false);
    }

    public final void hideDivider() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.divider, View.class, "com.obric.memorydata.plugin"));
        this.config.c(false);
    }

    public final void hideErrorTips() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.memorydata.plugin"));
        this.divider.setStyle(0);
        CharSequence r0 = this.tvInputTips.getText();
        Intrinsics.checkNotNullExpressionValue(r0, "tvInputTips.text");
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        showInputTips(this.tvInputTips.getText().toString());
    L8:
        this.isShowErrorTips = false;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void hideInputTips() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.tvInputTips, View.class, "com.obric.memorydata.plugin"));
        this.isShowInputTips = false;
    }

    public final void hidePrefixView() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.prefixContainer, View.class, "com.obric.memorydata.plugin"));
        this.isShowPrefix = false;
    }

    public final void hideSuffixView() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.suffixContainer, View.class, "com.obric.memorydata.plugin"));
        this.isShowSuffix = false;
    }

    public final void hideTitle() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.memorydata.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.ivTitleIcon, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin"));
    L8:
        this.isShowTitle = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void hideTitleIcon() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.ivTitleIcon, View.class, "com.obric.memorydata.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L9:
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin"));
    L10:
        this.isShowTitleIcon = false;
        return;
    L8:
        if (TextUtils.isEmpty(this.tvTitle.getText()) == false) goto L10;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r0 = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 44);
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.actionContainer, View.class, "com.obric.memorydata.plugin"), com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 44));
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.actionContainer, View.class, "com.obric.memorydata.plugin"), r0, r0, new View[]{(View) ZeusTransformUtils.preCheckCast(this.tvAction, View.class, "com.obric.memorydata.plugin"), (View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.memorydata.plugin")});
    }

    public final void onTextExceedLengthListener(Function1<? super String, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "handler");
        this.config.a((d) ZeusTransformUtils.preCheckCast(new f(r4), d.class, "com.obric.memorydata.plugin"));
    }

    public final void setActiveBorderView(ConstraintLayout r1) {
        this.activeBorderView = r1;
    }

    public final void setArrangeDirection(int r1) {
        this.arrangeDirection = r1;
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r2) {
        b r0 = getConfig();
        r0.d(r2);
        updateConfig(r0);
    }

    public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.editText.setOnFocusChangeListener(r4);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        this.editText.setEnabled(r2);
        super.setEnabled(r2);
    }

    public final void setInputContainerBackground(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "drawable");
        this.inputContainer.setBackground(r2);
    }

    public final void setInputContainerPadding(int r1, int r2, int r3, int r4) {
        this.inputContainer.setPadding(r1, r2, r3, r4);
    }

    public final void setInputViewActived() {
        this.isErrorState = false;
        int r0 = ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_focused_border_selector, "drawable", "o_line_box_input_focused_border_selector");
        Drawable r1 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0);
        ConstraintLayout r4 = this.activeBorderView;
        if (r4 == null) goto L7;
        r4.setBackground(r1);
        return;
    }

    public final void setInputViewError() {
        this.isErrorState = true;
        int r0 = ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_error_border_selector, "drawable", "o_line_box_input_error_border_selector");
        Drawable r1 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0);
        ConstraintLayout r4 = this.activeBorderView;
        if (r4 == null) goto L7;
        r4.setBackground(r1);
        return;
    }

    public final void setInputViewNormal() {
        this.isErrorState = false;
        int r0 = ZeusTransformUtils.mapRes(R.drawable.o_line_box_input_normal_border_selector, "drawable", "o_line_box_input_normal_border_selector");
        Drawable r1 = ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r0);
        ConstraintLayout r4 = this.activeBorderView;
        if (r4 == null) goto L7;
        r4.setBackground(r1);
        return;
    }

    public final void setLeftContainer(ConstraintLayout r1) {
        this.leftContainer = r1;
    }

    public final void setMiddleTitleIcon() {
        ViewGroup.LayoutParams r0 = this.ivTitleIcon.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r0, "ivTitleIcon.getLayoutParams()");
        r0.width = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
        r0.height = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
        this.ivTitleIcon.setLayoutParams(r0);
    }

    public final void setMode(int r3, View.OnClickListener r4) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if (r3 != 2) goto L5;
        this.editText.setFocusable(true);
        this.editText.setFocusableInTouchMode(true);
        OFormEditText r6 = this.editText;
        r5 = null;
    L11:
        r6.setOnClickListener(r5);
        setOnClickListener(r5);
        return;
    L5:
        if (r3 != 3) goto L14;
        this.editText.setFocusable(false);
        this.editText.setFocusableInTouchMode(false);
        r6 = this.editText;
        if (r5 != null) goto L11;
        r6.setOnClickListener(this.config.o());
        setOnClickListener(this.config.o());
        return;
    }

    public final void setSmallTitleIcon() {
        ViewGroup.LayoutParams r0 = this.ivTitleIcon.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r0, "ivTitleIcon.getLayoutParams()");
        r0.width = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 10);
        r0.height = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 10);
        this.ivTitleIcon.setLayoutParams(r0);
    }

    public final void setText(String r4) {
        if (r4 == null) goto L8;
        this.editText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        TextWatcher r3 = this.counterTextWatcher;
        if (r3 == null) goto L9;
        r3.onTextChanged((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), 0, 0, r4.length());
        return;
    L9:
        return;
    }

    public final void setTextClearedListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "textClearedListener");
        this.config.a(r4);
    }

    public final void setTextExceedLengthListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "textExceedLengthListener");
        this.config.a(r4);
    }

    public final void setTextWatcher(TextWatcher r3) {
        TextWatcher r4 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r3, TextWatcher.class, "com.obric.memorydata.plugin");
        this.config.a(r4);
        refreshConfig();
    }

    public final void showActionImage() {
        if (((View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.ivAction, View.class, "com.obric.memorydata.plugin"));
    L8:
        this.isShowActionImage = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void showActionText() {
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.tvAction, View.class, "com.obric.memorydata.plugin"));
        this.isShowActionText = true;
    }

    public final void showClear() {
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.ivClearContainer, View.class, "com.obric.memorydata.plugin"));
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.ivClear, View.class, "com.obric.memorydata.plugin"));
        this.config.b(false);
    }

    public final void showDivider() {
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.divider, View.class, "com.obric.memorydata.plugin"));
        this.config.c(true);
    }

    public final void showErrorTips(String r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.memorydata.plugin"));
        this.tvErrorTips.setText((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
        this.divider.setBackgroundColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.Primary, TypedValues.Custom.S_COLOR, "Primary")));
        if (com.obric.oui.common.util.o.d((View) ZeusTransformUtils.preCheckCast(this.tvInputTips, View.class, "com.obric.memorydata.plugin")) == false) goto L7;
        hideInputTips();
    L7:
        this.isShowErrorTips = true;
        this.errorTips = r7;
    }

    public final void showInputTips(String r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.tvInputTips.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.tvInputTips, View.class, "com.obric.memorydata.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        hideErrorTips();
    L10:
        this.isShowInputTips = true;
        this.inputTips = r4;
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void showPrefixView() {
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.prefixContainer, View.class, "com.obric.memorydata.plugin"));
        this.isShowPrefix = true;
    }

    public final void showSuffixView() {
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.suffixContainer, View.class, "com.obric.memorydata.plugin"));
        this.isShowSuffix = true;
    }

    public final void showTitle() {
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.memorydata.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin"));
    L8:
        this.isShowTitle = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void showTitleIcon() {
        if (((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin"));
    L8:
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.ivTitleIcon, View.class, "com.obric.memorydata.plugin"));
        this.isShowTitleIcon = true;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void updateConfig(b r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        this.config = r2;
        clear();
        refreshConfig();
    }
}
