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
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.loc.o;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 K2\u00020\u0001:\u0002KLB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\u0006\u00105\u001a\u00020\u0010J\b\u00106\u001a\u000207H\u0016J\u0006\u00108\u001a\u00020$J\u0006\u00109\u001a\u000203J\u0006\u0010:\u001a\u000203J\b\u0010;\u001a\u000203H\u0002J\u0006\u0010<\u001a\u000203J\u0006\u0010=\u001a\u000203J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u0002032\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020\u0012J\u000e\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020$J\u0006\u0010F\u001a\u000203J\b\u0010G\u001a\u000203H\u0002J\u0006\u0010H\u001a\u000203J\u0006\u0010I\u001a\u000203J\u000e\u0010J\u001a\u0002032\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0011\u00100\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-¨\u0006M"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView;", "Lcom/obric/oui/forms/AbsOForm;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "arrangeDirection", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "DEFAULT_MAX_LINES", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "config", "Lcom/obric/oui/forms/OBoxInputView$Config;", "counterTextWatcher", "Landroid/text/TextWatcher;", "editText", "Landroidx/appcompat/widget/AppCompatEditText;", "getEditText", "()Landroidx/appcompat/widget/AppCompatEditText;", "inputContainer", "Landroid/view/ViewGroup;", "getInputContainer", "()Landroid/view/ViewGroup;", "ivTitleIcon", "Landroid/widget/ImageView;", "getIvTitleIcon", "()Landroid/widget/ImageView;", "prefixContainer", "getPrefixContainer", "showTitleDefaultIcon", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "textGravity", "titleContainer", "getTitleContainer", "setTitleContainer", "(Landroid/view/ViewGroup;)V", "tvCounter", "Landroid/widget/TextView;", "getTvCounter", "()Landroid/widget/TextView;", "tvErrorTips", "getTvErrorTips", "tvTitle", "getTvTitle", "adjustHeight", "", "clear", "getConfig", "getInterEditText", "Landroid/widget/EditText;", "getText", "hideErrorTips", "hidePrefixView", "hideSoftInput", "hideTitle", "hideTitleIcon", "setPrefixView", "view", "Landroid/view/View;", "setText", "setTextWatcher", "textWatcher", "showErrorTips", "tips", "showPrefixView", "showSoftInput", "showTitle", "showTitleIcon", "updateConfig", "Companion", "Config", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBoxInputView extends AbsOForm {
    public static final int ARRANGE_DIRECTION_HORIZONTAL = 1;
    public static final int ARRANGE_DIRECTION_VERTICAL = 0;
    public static final a Companion = null;
    private static final int DEFAULT_INPUT_BOX_HEIGHT_DP = 0;
    private static final int DEFAULT_LINES = 6;
    private final int DEFAULT_MAX_LINES;
    private int arrangeDirection;
    private b config;
    private TextWatcher counterTextWatcher;
    private final AppCompatEditText editText;
    private final ViewGroup inputContainer;
    private final ImageView ivTitleIcon;
    private final ViewGroup prefixContainer;
    private boolean showTitleDefaultIcon;
    private String text;
    private int textGravity;
    private ViewGroup titleContainer;
    private final TextView tvCounter;
    private final TextView tvErrorTips;
    private final TextView tvTitle;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView$Companion;", "", "()V", "ARRANGE_DIRECTION_HORIZONTAL", "", "ARRANGE_DIRECTION_VERTICAL", "DEFAULT_INPUT_BOX_HEIGHT_DP", "DEFAULT_LINES", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\u0018\u00002\u00020\u0001:\u0001AB\u0081\u0001\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000e\u00109\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0012J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u000bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0003J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0005R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001b¨\u0006B"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView$Config;", "", "showTitle", "", "title", "", "showCounter", "lengthLimit", "", "hintText", "prefixView", "Landroid/view/View;", "textWatcher", "Landroid/text/TextWatcher;", "inputBoxHeight", "inputBoxMaxHeight", "autoAdjustHeight", "ivTitleIcon", "Landroid/graphics/drawable/Drawable;", "(ZLjava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Landroid/view/View;Landroid/text/TextWatcher;IIZLandroid/graphics/drawable/Drawable;)V", "getAutoAdjustHeight", "()Z", "setAutoAdjustHeight", "(Z)V", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "getInputBoxHeight", "()I", "setInputBoxHeight", "(I)V", "getInputBoxMaxHeight", "setInputBoxMaxHeight", "getIvTitleIcon", "()Landroid/graphics/drawable/Drawable;", "setIvTitleIcon", "(Landroid/graphics/drawable/Drawable;)V", "getLengthLimit", "()Ljava/lang/Integer;", "setLengthLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPrefixView", "()Landroid/view/View;", "setPrefixView", "(Landroid/view/View;)V", "getShowCounter", "setShowCounter", "getShowTitle", "setShowTitle", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "getTitle", "setTitle", "enableAdjustHeight", "str", o.g, "drawable", "len", "view", "show", "watcher", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f13850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f13851b;
        private boolean c;
        private Integer d;
        private String e;
        private View f;
        private TextWatcher g;
        private int h;
        private int i;
        private boolean j;
        private Drawable k;

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0006\u00109\u001a\u00020:J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\t\u0010E\u001a\u00020\bHÆ\u0003J\u0088\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u0010GJ\u000e\u0010H\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\u0013\u0010I\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\bHÖ\u0001J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0012J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\u000bJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0003J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\rJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0005J\t\u0010S\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0015\"\u0004\b0\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001b¨\u0006T"}, d2 = {"Lcom/obric/oui/forms/OBoxInputView$Config$Builder;", "", "showTitle", "", "title", "", "showCounter", "lengthLimit", "", "hintText", "prefixView", "Landroid/view/View;", "textWatcher", "Landroid/text/TextWatcher;", "inputBoxHeight", "inputBoxMaxHeight", "autoAdjustHeight", "ivTitleIcon", "Landroid/graphics/drawable/Drawable;", "(ZLjava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Landroid/view/View;Landroid/text/TextWatcher;IIZLandroid/graphics/drawable/Drawable;)V", "getAutoAdjustHeight", "()Z", "setAutoAdjustHeight", "(Z)V", "getHintText", "()Ljava/lang/String;", "setHintText", "(Ljava/lang/String;)V", "getInputBoxHeight", "()I", "setInputBoxHeight", "(I)V", "getInputBoxMaxHeight", "setInputBoxMaxHeight", "getIvTitleIcon", "()Landroid/graphics/drawable/Drawable;", "setIvTitleIcon", "(Landroid/graphics/drawable/Drawable;)V", "getLengthLimit", "()Ljava/lang/Integer;", "setLengthLimit", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPrefixView", "()Landroid/view/View;", "setPrefixView", "(Landroid/view/View;)V", "getShowCounter", "setShowCounter", "getShowTitle", "setShowTitle", "getTextWatcher", "()Landroid/text/TextWatcher;", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "getTitle", "setTitle", "build", "Lcom/obric/oui/forms/OBoxInputView$Config;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Landroid/view/View;Landroid/text/TextWatcher;IIZLandroid/graphics/drawable/Drawable;)Lcom/obric/oui/forms/OBoxInputView$Config$Builder;", "enableAdjustHeight", "equals", "other", "hashCode", "str", o.g, "drawable", "len", "view", "show", "watcher", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f13852a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f13853b;
            private boolean c;
            private Integer d;
            private String e;
            private View f;
            private TextWatcher g;
            private int h;
            private int i;
            private boolean j;
            private Drawable k;

            public a() {
                this(false, null, false, null, null, null, null, 0, 0, false, null, 2047, null);
            }

            public a(boolean r3, String r4, boolean r5, Integer r6, String r7, View r8, TextWatcher r9, int r10, int r11, boolean r12, Drawable r13) {
                TextWatcher r14 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r9, TextWatcher.class, "com.obric.memorydata.plugin");
                this.f13852a = r3;
                this.f13853b = r4;
                this.c = r5;
                this.d = r6;
                this.e = r7;
                this.f = r8;
                this.g = r14;
                this.h = r10;
                this.i = r11;
                this.j = r12;
                this.k = r13;
            }

            public /* synthetic */ a(boolean r14, String r15, boolean r16, Integer r17, String r18, View r19, TextWatcher r20, int r21, int r22, boolean r23, Drawable r24, int r25, DefaultConstructorMarker r26) {
                TextWatcher r1 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r20, TextWatcher.class, "com.obric.memorydata.plugin");
                boolean r3 = false;
                if ((r25 & 1) == 0) goto L5;
                boolean r2 = false;
            L6:
                Drawable r5 = null;
                if ((r25 & 2) == 0) goto L9;
                String r4 = null;
            L11:
                if ((r25 & 4) == 0) goto L13;
                boolean r6 = false;
            L15:
                if ((r25 & 8) == 0) goto L17;
                Integer r7 = null;
            L19:
                if ((r25 & 16) == 0) goto L21;
                String r8 = null;
            L23:
                if ((r25 & 32) == 0) goto L25;
                View r9 = null;
            L27:
                if ((r25 & 64) == 0) goto L30;
                r1 = null;
            L30:
                if ((r25 & 128) == 0) goto L32;
                int r10 = OBoxInputView.access$getDEFAULT_INPUT_BOX_HEIGHT_DP$cp();
            L34:
                if ((r25 & 256) == 0) goto L36;
                int r11 = Integer.MAX_VALUE;
            L38:
                if ((r25 & 512) != 0) goto L42;
                r3 = r23;
            L42:
                if ((r25 & 1024) != 0) goto L45;
                r5 = r24;
            L45:
                this(r2, r4, r6, r7, r8, r9, r1, r10, r11, r3, r5);
                return;
            L36:
                r11 = r22;
                goto L38
            L32:
                r10 = r21;
                goto L34
            L25:
                r9 = r19;
                goto L27
            L21:
                r8 = r18;
                goto L23
            L17:
                r7 = r17;
                goto L19
            L13:
                r6 = r16;
                goto L15
            L9:
                r4 = r15;
                goto L11
            L5:
                r2 = r14;
                goto L6
            }

            public final b a() {
                boolean r1 = this.f13852a;
                String r2 = this.f13853b;
                boolean r3 = this.c;
                String r5 = this.e;
                Integer r4 = this.d;
                TextWatcher r7 = this.g;
                return new b(r1, r2, r3, r4, r5, this.f, r7, this.h, this.i, this.j, this.k, null);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
                return false;
            L8:
                a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
                if (this.f13852a == r6.f13852a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f13853b, r6.f13853b) == true) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
                return false;
            L27:
                if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
                return false;
            L30:
                if (this.h == r6.h) goto L33;
                return false;
            L33:
                if (this.i == r6.i) goto L36;
                return false;
            L36:
                if (this.j == r6.j) goto L39;
                return false;
            L39:
                if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
                return false;
            L41:
                return true;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r2v26 */
            /* JADX WARN: Type inference failed for: r2v28 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            public int hashCode() {
                boolean r0 = this.f13852a;
                ?? r1 = 1;
                ?? r2 = r0;
                if (r0 == false) goto L5;
                r2 = 1;
            L5:
                int r3 = r2 * 31;
                String r4 = this.f13853b;
                int r5 = 0;
                if (r4 != null) goto L8;
                int r6 = 0;
            L9:
                int r7 = (r3 + r6) * 31;
                boolean r8 = this.c;
                ?? r9 = r8;
                if (r8 == false) goto L12;
                r9 = 1;
            L12:
                int r10 = (r7 + r9) * 31;
                Integer r11 = this.d;
                if (r11 != null) goto L15;
                int r12 = 0;
            L16:
                int r13 = (r10 + r12) * 31;
                String r14 = this.e;
                if (r14 != null) goto L19;
                int r15 = 0;
            L20:
                int r16 = (r13 + r15) * 31;
                View r17 = this.f;
                if (r17 != null) goto L23;
                int r18 = 0;
            L24:
                int r19 = (r16 + r18) * 31;
                TextWatcher r20 = this.g;
                if (r20 != null) goto L27;
                int r21 = 0;
            L28:
                int r22 = (((((r19 + r21) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31;
                boolean r23 = this.j;
                if (r23 == true) goto L32;
                r1 = r23;
            L32:
                int r24 = (r22 + r1) * 31;
                Drawable r25 = this.k;
                if (r25 == null) goto L37;
                r5 = r25.hashCode();
            L37:
                return r24 + r5;
            L27:
                r21 = r20.hashCode();
                goto L28
            L23:
                r18 = r17.hashCode();
                goto L24
            L19:
                r15 = r14.hashCode();
                goto L20
            L15:
                r12 = r11.hashCode();
                goto L16
            L8:
                r6 = r4.hashCode();
                goto L9
            }

            public String toString() {
                StringBuilder r0 = new StringBuilder();
                r0.append("Builder(showTitle=").append(this.f13852a).append(", title=").append(this.f13853b).append(", showCounter=").append(this.c).append(", lengthLimit=").append(this.d).append(", hintText=").append(this.e).append(", prefixView=").append(this.f).append(", textWatcher=").append(this.g).append(", inputBoxHeight=").append(this.h).append(", inputBoxMaxHeight=").append(this.i).append(", autoAdjustHeight=").append(this.j).append(", ivTitleIcon=").append(this.k).append(')');
                return r0.toString();
            }
        }

        private b(boolean r3, String r4, boolean r5, Integer r6, String r7, View r8, TextWatcher r9, int r10, int r11, boolean r12, Drawable r13) {
            TextWatcher r14 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r9, TextWatcher.class, "com.obric.memorydata.plugin");
            this.f13850a = r3;
            this.f13851b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r14;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
        }

        public /* synthetic */ b(boolean r14, String r15, boolean r16, Integer r17, String r18, View r19, TextWatcher r20, int r21, int r22, boolean r23, Drawable r24, DefaultConstructorMarker r25) {
            this(r14, r15, r16, r17, r18, r19, (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r20, TextWatcher.class, "com.obric.memorydata.plugin"), r21, r22, r23, r24);
        }

        public final void a(int r1) {
            this.h = r1;
        }

        public final void a(Integer r1) {
            this.d = r1;
        }

        public final void a(String r1) {
            this.f13851b = r1;
        }

        public final void a(boolean r1) {
            this.f13850a = r1;
        }

        public final boolean a() {
            return this.f13850a;
        }

        public final String b() {
            return this.f13851b;
        }

        public final void b(int r1) {
            this.i = r1;
        }

        public final void b(String r1) {
            this.e = r1;
        }

        public final void b(boolean r1) {
            this.c = r1;
        }

        public final void c(boolean r1) {
            this.j = r1;
        }

        public final boolean c() {
            return this.c;
        }

        public final Integer d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final View f() {
            return this.f;
        }

        public final TextWatcher g() {
            return this.g;
        }

        public final int h() {
            return this.h;
        }

        public final int i() {
            return this.i;
        }

        public final boolean j() {
            return this.j;
        }

        public final Drawable k() {
            return this.k;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/obric/oui/forms/OBoxInputView$updateConfig$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBoxInputView f13854a;

        c(OBoxInputView r1) {
            this.f13854a = r1;
        }

        private static final void a(OBoxInputView r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            OBoxInputView.access$adjustHeight(r1);
        }

        public static /* synthetic */ void lambda$119RE5TNhv3ZEVykJJYOme2ThtE(OBoxInputView r0) {
            a(r0);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Intrinsics.checkNotNullParameter((Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin"), "s");
            AppCompatEditText r4 = this.f13854a.getEditText();
            final OBoxInputView r2 = this.f13854a;
            r4.post(new $$Lambda$OBoxInputView$c$119RE5TNhv3ZEVykJJYOme2ThtE(r2));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter((CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin"), "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter((CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin"), "s");
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/obric/oui/forms/OBoxInputView$updateConfig$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f13855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OBoxInputView f13856b;

        d(b r1, OBoxInputView r2) {
            this.f13855a = r1;
            this.f13856b = r2;
        }

        private static final void a(OBoxInputView r1) {
            Intrinsics.checkNotNullParameter(r1, "this$0");
            OBoxInputView.access$adjustHeight(r1);
        }

        public static /* synthetic */ void lambda$UVhKDfQSmphvDbhP8dudwvtTAro(OBoxInputView r0) {
            a(r0);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r3) {
            Editable r4 = (Editable) ZeusTransformUtils.wrapperContextForParams(r3, Editable.class, "com.obric.memorydata.plugin");
            if (this.f13855a.j() == false) goto L6;
            AppCompatEditText r5 = this.f13856b.getEditText();
            final OBoxInputView r2 = this.f13856b;
            r5.post(new $$Lambda$OBoxInputView$d$UVhKDfQSmphvDbhP8dudwvtTAro(r2));
            return;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r6, int r7, int r8, int r9) {
            CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
            if (this.f13855a.d() == null) goto L24;
            Resources r11 = ZeusTransformUtils.getResources(this.f13856b, "com.obric.memorydata.plugin");
            int r12 = ZeusTransformUtils.mapRes(R.string.oui_form_counter, TypedValues.Custom.S_STRING, "oui_form_counter");
            Object[] r0 = new Object[2];
            if (r10 != null) goto L7;
            String r1 = null;
        L8:
            r0[0] = r1;
            r0[1] = String.valueOf(this.f13855a.d());
            String r13 = r11.getString(r12, r0);
            Intrinsics.checkNotNullExpressionValue(r13, "resources.getString(\n   …                        )");
            SpannableString r14 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"));
            if (r10 != null) goto L11;
            int r15 = 0;
        L12:
            Integer r2 = this.f13855a.d();
            Intrinsics.checkNotNull(r2);
            if (r15 <= r2.intValue()) goto L22;
            ForegroundColorSpan r16 = new ForegroundColorSpan(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13856b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.Primary, TypedValues.Custom.S_COLOR, "Primary")));
            if (r10 != null) goto L17;
        L16:
            int r17 = 0;
        L21:
            r14.setSpan(r16, 0, r17, 18);
            goto L22
        L17:
            String r18 = Integer.valueOf(r10.length()).toString();
            if (r18 == null) goto L16;
            r17 = r18.length();
        L22:
            this.f13856b.getTvCounter().setText((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.SPANNABLE);
            return;
        L11:
            r15 = Integer.valueOf(r10.length()).intValue();
            goto L12
        L7:
            r1 = Integer.valueOf(r10.length()).toString();
            goto L8
        }
    }

    static {
        Companion = new a(null);
        DEFAULT_INPUT_BOX_HEIGHT_DP = 144;
    }

    public OBoxInputView(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OBoxInputView(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OBoxInputView(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OBoxInputView(Context r21, AttributeSet r22, int r23, int r24) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r22, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r4, r23);
        this.arrangeDirection = r24;
        this.config = new b.a(false, null, false, null, null, null, null, 0, 0, false, null, 2047, null).a();
        this.textGravity = 48;
        this.DEFAULT_MAX_LINES = 20;
        TypedArray r5 = r2.getTheme().obtainStyledAttributes(r4, R.styleable.OBoxInputView, 0, 0);
        setArrangeDirection(r5.getInt(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formArrangeDirection, "styleable", "OBoxInputView_oui_formArrangeDirection"), 1));     // Catch: Throwable -> L23
        this.config.b(r5.getString(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_android_hint, "styleable", "OBoxInputView_android_hint")));     // Catch: Throwable -> L23
        this.config.b(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formShowCounter, "styleable", "OBoxInputView_oui_formShowCounter"), false));     // Catch: Throwable -> L23
        int r7 = r5.getInt(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formLengthLimit, "styleable", "OBoxInputView_oui_formLengthLimit"), 0);     // Catch: Throwable -> L23
        if (r7 <= 0) goto L6;
        this.config.a(Integer.valueOf(r7));     // Catch: Throwable -> L23
    L6:
        String r8 = r5.getString(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formTitle, "styleable", "OBoxInputView_oui_formTitle"));     // Catch: Throwable -> L23
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r10 != null) goto L9;
    L12:
        boolean r11 = true;
    L13:
        if (r11 == true) goto L15;
        this.config.a(r8);     // Catch: Throwable -> L23
        this.config.a(true);     // Catch: Throwable -> L23
    L16:
        this.config.a(r5.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formInputHeight, "styleable", "OBoxInputView_oui_formInputHeight"), h.a(r2, DEFAULT_INPUT_BOX_HEIGHT_DP)));     // Catch: Throwable -> L23
        this.config.b(r5.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formInputMaxHeight, "styleable", "OBoxInputView_oui_formInputMaxHeight"), Integer.MAX_VALUE));     // Catch: Throwable -> L23
        this.text = r5.getString(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_android_text, "styleable", "OBoxInputView_android_text"));     // Catch: Throwable -> L23
        this.showTitleDefaultIcon = r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formShowTitleDefaultIcon, "styleable", "OBoxInputView_oui_formShowTitleDefaultIcon"), false);     // Catch: Throwable -> L23
        this.config.c(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_oui_formAutoAdjustHeight, "styleable", "OBoxInputView_oui_formAutoAdjustHeight"), false));     // Catch: Throwable -> L23
        this.textGravity = r5.getInt(ZeusTransformUtils.mapRes(R.styleable.OBoxInputView_android_gravity, "styleable", "OBoxInputView_android_gravity"), 48);     // Catch: Throwable -> L23
        r5.recycle();
        if (this.arrangeDirection != 1) goto L20;
        int r1 = R.layout.o_form_box_horizontal;
        String r6 = "o_form_box_horizontal";
    L21:
        ZeusTransformUtils.inflate(LayoutInflater.from(r2), ZeusTransformUtils.mapRes(r1, "layout", r6), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.memorydata.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.iv_title_icon, OaidModel.KEY_ID, "iv_title_icon"));
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.iv_title_icon)");
        this.ivTitleIcon = (ImageView) ZeusTransformUtils.preCheckCast(r9, ImageView.class, "com.obric.memorydata.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.prefix_container, OaidModel.KEY_ID, "prefix_container"));
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.prefix_container)");
        this.prefixContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.memorydata.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.edittext, OaidModel.KEY_ID, "edittext"));
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.edittext)");
        AppCompatEditText r14 = (AppCompatEditText) ZeusTransformUtils.preCheckCast(r13, AppCompatEditText.class, "com.obric.memorydata.plugin");
        this.editText = r14;
        View r15 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_counter, OaidModel.KEY_ID, "tv_counter"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.tv_counter)");
        this.tvCounter = (TextView) ZeusTransformUtils.preCheckCast(r15, TextView.class, "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_error_tips, OaidModel.KEY_ID, "tv_error_tips"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.tv_error_tips)");
        this.tvErrorTips = (TextView) ZeusTransformUtils.preCheckCast(r16, TextView.class, "com.obric.memorydata.plugin");
        r14.setOnFocusChangeListener(new $$Lambda$OBoxInputView$e6T8ItmLzs2AXx2sVyao7yHD5o(this));
        View r17 = findViewById(ZeusTransformUtils.mapRes(R.id.input_container, OaidModel.KEY_ID, "input_container"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.input_container)");
        this.inputContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r17, ViewGroup.class, "com.obric.memorydata.plugin");
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.title_container, OaidModel.KEY_ID, "title_container"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.title_container)");
        this.titleContainer = (ViewGroup) ZeusTransformUtils.preCheckCast(r18, ViewGroup.class, "com.obric.memorydata.plugin");
        updateConfig(this.config);
        r14.setLines(20);
        r14.setSingleLine(false);
        return;
    L20:
        r1 = R.layout.o_form_box_vertical;
        r6 = "o_form_box_vertical";
        goto L21
    L15:
        this.config.a("标题");     // Catch: Throwable -> L23
        goto L16
    L9:
        if (r10.length() == 0) goto L12;
        r11 = false;
    L23:
        th = move-exception;
        r5.recycle();
        throw th;
    }

    public /* synthetic */ OBoxInputView(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
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

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final void m1294_init_$lambda1(OBoxInputView r0, View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r2 == false) goto L5;
        r0.showSoftInput();
        return;
    L5:
        r0.hideSoftInput();
    }

    public static final /* synthetic */ void access$adjustHeight(OBoxInputView r0) {
        r0.adjustHeight();
    }

    public static final /* synthetic */ int access$getDEFAULT_INPUT_BOX_HEIGHT_DP$cp() {
        return DEFAULT_INPUT_BOX_HEIGHT_DP;
    }

    private final void adjustHeight() {
        int r0 = this.editText.getLineCount();
        int r1 = this.editText.getLineHeight();
        int r2 = this.editText.getHeight();
        int r3 = this.inputContainer.getHeight();
        int r4 = ((r0 * r1) + r3) - r2;
        if (r4 >= this.config.h()) goto L5;
    L8:
        ViewGroup.LayoutParams r5 = this.inputContainer.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(r5, "inputContainer.getLayoutParams()");
        r5.height = r3;
        this.inputContainer.setLayoutParams(r5);
        return;
    L5:
        if (r4 >= this.config.i()) goto L8;
        r3 = r4;
        goto L8
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

    /* JADX INFO: renamed from: lambda$e6-T8ItmLzs2AXx2sVyao7yHD5o, reason: not valid java name */
    public static /* synthetic */ void m1295lambda$e6T8ItmLzs2AXx2sVyao7yHD5o(OBoxInputView r0, View r1, boolean r2) {
        m1294_init_$lambda1(r0, r1, r2);
    }

    private final void setPrefixView(View r4) {
        if (r4 == null) goto L5;
        this.prefixContainer.removeAllViews();
        this.prefixContainer.addView(r4, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ConstraintLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return;
    }

    private final void showSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin")).showSoftInput((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
    }

    public final int getArrangeDirection() {
        return this.arrangeDirection;
    }

    public final b getConfig() {
        return this.config;
    }

    public final AppCompatEditText getEditText() {
        return this.editText;
    }

    public final ViewGroup getInputContainer() {
        return this.inputContainer;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return (EditText) ZeusTransformUtils.preCheckCast(this.editText, EditText.class, "com.obric.memorydata.plugin");
    }

    public final ImageView getIvTitleIcon() {
        return this.ivTitleIcon;
    }

    public final ViewGroup getPrefixContainer() {
        return this.prefixContainer;
    }

    public final String getText() {
        return String.valueOf(this.editText.getText());
    }

    public final ViewGroup getTitleContainer() {
        return this.titleContainer;
    }

    public final TextView getTvCounter() {
        return this.tvCounter;
    }

    public final TextView getTvErrorTips() {
        return this.tvErrorTips;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public final void hideErrorTips() {
        this.tvErrorTips.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.memorydata.plugin"));
    }

    public final void hidePrefixView() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.prefixContainer, View.class, "com.obric.memorydata.plugin"));
    }

    public final void hideTitle() {
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.memorydata.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.ivTitleIcon, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        com.obric.oui.common.util.o.b((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin"));
    L8:
        this.config.a(false);
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
        return;
    L8:
        if (TextUtils.isEmpty(this.tvTitle.getText()) == true) goto L9;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setArrangeDirection(int r1) {
        this.arrangeDirection = r1;
    }

    public final void setText(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L15;
        this.editText.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"));
        TextWatcher r4 = this.counterTextWatcher;
        if (r4 == null) goto L16;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5);
        r4.onTextChanged(r2, 0, 0, r5.length());
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void setTextWatcher(TextWatcher r3) {
        TextWatcher r4 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r3, TextWatcher.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "textWatcher");
        clear();
        getTextWatchers().add(new WeakReference(r4));
        this.editText.addTextChangedListener(r4);
    }

    public final void setTitleContainer(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.titleContainer = r2;
    }

    public final void showErrorTips(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tips");
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.tvErrorTips, View.class, "com.obric.memorydata.plugin"));
        this.tvErrorTips.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void showPrefixView() {
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.prefixContainer, View.class, "com.obric.memorydata.plugin"));
    }

    public final void showTitle() {
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.tvTitle, View.class, "com.obric.memorydata.plugin"));
        if (((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.titleContainer, View.class, "com.obric.memorydata.plugin"));
    L8:
        this.config.a(true);
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
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void updateConfig(b r8) {
        Intrinsics.checkNotNullParameter(r8, "config");
        this.config = r8;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.b(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        this.tvTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r8.b(), CharSequence.class, "com.obric.memorydata.plugin"));
    L12:
        if (r8.a() == false) goto L14;
        showTitle();
    L16:
        if (r8.f() == null) goto L19;
        View r3 = r8.f();
        Intrinsics.checkNotNull(r3);
        setPrefixView(r3);
    L19:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r8.e(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L22;
        this.editText.setHint((CharSequence) ZeusTransformUtils.preCheckCast(r8.e(), CharSequence.class, "com.obric.memorydata.plugin"));
    L22:
        if (r8.j() == false) goto L25;
        this.editText.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new c(this), TextWatcher.class, "com.obric.memorydata.plugin"));
    L25:
        if (r8.c() == true) goto L27;
    L33:
        r8.h();
        if (r8.h() <= 0) goto L37;
        View r4 = (View) ZeusTransformUtils.preCheckCast(this.inputContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        Objects.requireNonNull(r5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r6 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).height = r8.h();
        r4.setLayoutParams(r6);
    L37:
        if (r8.g() == null) goto L40;
        TextWatcher r7 = r8.g();
        Intrinsics.checkNotNull(r7);
        setTextWatcher(r7);
    L40:
        if (r8.k() == null) goto L43;
        this.ivTitleIcon.setImageDrawable(r8.k());
    L43:
        if (this.showTitleDefaultIcon == true) goto L45;
    L47:
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(this.text, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L50;
    L53:
        if (r1 == true) goto L55;
        setText(this.text);
    L55:
        this.editText.setGravity(this.textGravity);
        return;
    L50:
        if (r9.length() == 0) goto L53;
        r1 = false;
        goto L53
    L45:
        if (r8.k() != null) goto L47;
        showTitleIcon();
        goto L47
    L27:
        if (r8.d() == null) goto L33;
        this.counterTextWatcher = (TextWatcher) ZeusTransformUtils.preCheckCast(new d(r8, this), TextWatcher.class, "com.obric.memorydata.plugin");
        ArrayList<WeakReference<TextWatcher>> r10 = getTextWatchers();
        TextWatcher r11 = this.counterTextWatcher;
        Intrinsics.checkNotNull(r11);
        r10.add(new WeakReference(r11));
        this.editText.addTextChangedListener(this.counterTextWatcher);
        TextWatcher r12 = this.counterTextWatcher;
        if (r12 == null) goto L32;
        r12.onTextChanged((CharSequence) ZeusTransformUtils.preCheckCast(this.editText.getText(), CharSequence.class, "com.obric.memorydata.plugin"), 0, 0, 0);
    L32:
        com.obric.oui.common.util.o.a((View) ZeusTransformUtils.preCheckCast(this.tvCounter, View.class, "com.obric.memorydata.plugin"));
        goto L33
    L14:
        hideTitle();
        goto L16
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }
}
