package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.google.android.material.card.MaterialCardView;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.text.OTextView;
import com.obric.oui.widget.VerticalFadeFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bP\b\u0017\u0018\u0000 \u0087\u00012\u00020\u0001:\u0004\u0087\u0001\u0088\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00105\u001a\u000206H\u0002J\u0012\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0006\u0010:\u001a\u000206J\u0012\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010=\u001a\u0004\u0018\u00010$J\b\u0010>\u001a\u0004\u0018\u00010$J\b\u0010?\u001a\u0004\u0018\u00010\u0013J\u0006\u0010@\u001a\u00020\fJ\b\u0010A\u001a\u0004\u0018\u00010\u0011J\u0006\u0010B\u001a\u00020\u0007J\b\u0010C\u001a\u0004\u0018\u00010\u0011J\u0006\u0010D\u001a\u00020\u0007J\u0006\u0010E\u001a\u00020\u0007J\n\u0010F\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010G\u001a\u0004\u0018\u00010\u0011J\u0006\u0010H\u001a\u00020\u0007J\u0006\u0010I\u001a\u000206J\b\u0010J\u001a\u000206H\u0002J\u0012\u0010K\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u0007H\u0002J\u0012\u0010L\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u0007H\u0002J\u0006\u0010M\u001a\u00020\nJ\u0010\u0010N\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0012\u0010O\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010P\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010Q\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010R\u001a\u0004\u0018\u00010\u00132\u0006\u0010S\u001a\u00020\u0007H\u0002J\b\u0010T\u001a\u000206H\u0002J\b\u0010U\u001a\u000206H\u0002J\u0012\u0010V\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u0007H\u0002J\u0012\u0010W\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u0007H\u0002J\u000e\u0010X\u001a\u0002062\u0006\u0010Y\u001a\u00020\nJ\u000e\u0010Z\u001a\u0002062\u0006\u0010[\u001a\u00020\u0007J\u0010\u0010\\\u001a\u0002062\u0006\u0010[\u001a\u00020\u0007H\u0016J\u0010\u0010]\u001a\u0002062\u0006\u0010^\u001a\u00020\u0007H\u0016J\u0010\u0010_\u001a\u0002062\b\u0010`\u001a\u0004\u0018\u00010\u0013J\u0010\u0010a\u001a\u0002062\u0006\u0010b\u001a\u00020\nH\u0016J\u000e\u0010c\u001a\u0002062\u0006\u0010d\u001a\u00020\fJ\u0010\u0010e\u001a\u0002062\b\u0010f\u001a\u0004\u0018\u00010\u0011J\u000e\u0010g\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u0007J\u0010\u0010h\u001a\u0002062\b\u0010i\u001a\u0004\u0018\u00010\u0011J\u0010\u0010j\u001a\u0002062\u0006\u0010k\u001a\u00020\u0007H\u0016J\u000e\u0010l\u001a\u0002062\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010m\u001a\u0002062\u0006\u0010n\u001a\u00020\u0007J\u0010\u0010o\u001a\u0002062\b\u0010p\u001a\u0004\u0018\u00010\u0011J\u000e\u0010q\u001a\u0002062\u0006\u0010r\u001a\u00020\nJ\u0010\u0010s\u001a\u0002062\b\u0010t\u001a\u0004\u0018\u00010\u0011J\u0010\u0010u\u001a\u0002062\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u000e\u0010\u001b\u001a\u0002062\u0006\u0010v\u001a\u00020\nJ\u000e\u0010w\u001a\u0002062\u0006\u0010v\u001a\u00020\nJ\u0010\u0010x\u001a\u0002062\u0006\u0010v\u001a\u00020\nH\u0016J\u000e\u0010y\u001a\u0002062\u0006\u0010v\u001a\u00020\nJ\u000e\u0010\u001c\u001a\u0002062\u0006\u0010v\u001a\u00020\nJ\u000e\u0010z\u001a\u0002062\u0006\u0010{\u001a\u00020\nJ\u000e\u0010|\u001a\u0002062\u0006\u0010v\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u0002062\u0006\u0010v\u001a\u00020\nJ\u0006\u0010}\u001a\u000206J\u000e\u0010~\u001a\u0002062\u0006\u0010v\u001a\u00020\nJ\b\u0010\u007f\u001a\u000206H\u0002J\t\u0010\u0080\u0001\u001a\u000206H\u0002J\t\u0010\u0081\u0001\u001a\u000206H\u0002J\t\u0010\u0082\u0001\u001a\u000206H\u0002J\u0007\u0010\u0083\u0001\u001a\u000206J\u0011\u0010\u0084\u0001\u001a\u0002062\u0006\u0010n\u001a\u00020\u0007H\u0002J\t\u0010\u0085\u0001\u001a\u000206H\u0002J\t\u0010\u0086\u0001\u001a\u000206H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0089\u0001"}, d2 = {"Lcom/obric/oui/forms/OInputLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoChangeWithLimit", "", "customFadeLength", "", "customMaxHeight", "customMaxLines", "customMinHeight", "digits", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "inputType", "isErrorState", "isInAutoChanging", "limitCount", "limitStateChangeListener", "Lcom/obric/oui/forms/OInputLayout$LimitStateChangeObserver;", "overLimit", "showClear", "showEyes", "showLimit", "type", "vClear", "Landroid/widget/ImageView;", "vCustomEnd", "vCustomStart", "vDivider", "Landroid/view/View;", "vEditContainer", "Landroid/widget/LinearLayout;", "vEyes", "vHelperContainer", "vInput", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInputContainer", "vInputFadeContainer", "Lcom/obric/oui/widget/VerticalFadeFrameLayout;", "vLabel", "Lcom/obric/oui/text/OTextView;", "vLimitMulti", "vLimitSingle", "vTip", "applyFadeLength", "", "doAfterTextStateChange", "editable", "Landroid/text/Editable;", "enableUpdateCursorDrawable", "getConstraintLength", "s", "getCustomEnd", "getCustomStart", "getEllipsize", "getFadeLength", "getHint", "getInputType", "getLabel", "getLimitCount", "getMaxLines", "getText", "getTip", "getType", "hideSoftInput", "initInput", "isExpandedMultiLineType", "isMultiLineType", "isPasswordMode", "isPasswordOrNumType", "isSingleLineType", "isSupportedType", "parseAttributes", "parseEllipsize", EventBody.KEY_VALUE, "refreshInputFade", "resetInputContainerCorner", "resolveInputMaxHeight", "resolveInputMinHeight", "setAutoChangeWithLimit", "auto", "setCustomEnd", "resId", "setCustomStart", "setDefaultCustomStart", "defaultStart", "setEllipsize", "where", "setEnabled", "enabled", "setFadeLength", "lengthPx", "setHint", "hint", "setInputType", "setLabel", AnnotatedPrivateKey.LABEL, "setLimitCount", CommonConsts.COUNT_TYPE, "setLimitStateChangeListener", "setMaxLines", "lines", "setText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "setTextState", "isError", "setTip", "tip", "setType", "show", "showCustomEnd", "showCustomStart", "showDivider", "showInputBackground", "showBg", "showLabel", "showSoftInput", "showTip", "updateClear", "updateEyes", "updateHelperContainerVis", "updateInputTypeForMultiLine", "updateLimit", "updateMaxLines", "updatePadding", "updateTextWithOverLimit", "Companion", "LimitStateChangeObserver", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInputLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13863a = null;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private b E;
    private boolean F;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13864b;
    private int c;
    private int d;
    private int e;
    private float f;
    private TextUtils.TruncateAt g;
    private final LinearLayout h;
    private final LinearLayout i;
    private final VerticalFadeFrameLayout j;
    private final FrameLayout k;
    private final FrameLayout l;
    private final OTextView m;
    private final OEditText n;
    private CharSequence o;
    private int p;
    private final ImageView q;
    private boolean r;
    private final ImageView s;
    private boolean t;
    private final FrameLayout u;
    private final View v;
    private final OTextView w;
    private final OTextView x;
    private final OTextView y;
    private int z;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/forms/OInputLayout$Companion;", "", "()V", "DEFAULT_START_AREA_CODE", "", "TAG", "", "TYPE_COMPACT_MULTI", "TYPE_MULTI", "TYPE_SINGLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputLayout$LimitStateChangeObserver;", "", "onLimitStateChange", "", "over", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a(boolean r1);
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/forms/OInputLayout$resetInputContainerCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputLayout f13865a;

        c(OInputLayout r1) {
            this.f13865a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), h.a((View) ZeusTransformUtils.preCheckCast(this.f13865a, View.class, "com.obric.memorydata.plugin"), 16));
        }
    }

    static {
        f13863a = new a(null);
    }

    public OInputLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OInputLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OInputLayout(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r11);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1.0f;
        this.p = 131073;
        this.z = -1;
        View r14 = ZeusTransformUtils.inflate(LayoutInflater.from(r12), ZeusTransformUtils.mapRes(R.layout.o_input_view_layout, "layout", "o_input_view_layout"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r14, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout r15 = (FrameLayout) ZeusTransformUtils.preCheckCast(r14, FrameLayout.class, "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.input_container, OaidModel.KEY_ID, "input_container"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.input_container)");
        LinearLayout r17 = (LinearLayout) ZeusTransformUtils.preCheckCast(r16, LinearLayout.class, "com.obric.memorydata.plugin");
        this.h = r17;
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.edit_container, OaidModel.KEY_ID, "edit_container"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.edit_container)");
        this.i = (LinearLayout) ZeusTransformUtils.preCheckCast(r2, LinearLayout.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.input_fade_container, OaidModel.KEY_ID, "input_fade_container"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.input_fade_container)");
        this.j = (VerticalFadeFrameLayout) ZeusTransformUtils.preCheckCast(r3, VerticalFadeFrameLayout.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.helper_container, OaidModel.KEY_ID, "helper_container"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.helper_container)");
        this.k = (FrameLayout) ZeusTransformUtils.preCheckCast(r4, FrameLayout.class, "com.obric.memorydata.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_start_container, OaidModel.KEY_ID, "custom_start_container"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.custom_start_container)");
        this.l = (FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.memorydata.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.label, OaidModel.KEY_ID, AnnotatedPrivateKey.LABEL));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.label)");
        this.m = (OTextView) ZeusTransformUtils.preCheckCast(r6, OTextView.class, "com.obric.memorydata.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.input, OaidModel.KEY_ID, "input"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.input)");
        OEditText r8 = (OEditText) ZeusTransformUtils.preCheckCast(r7, OEditText.class, "com.obric.memorydata.plugin");
        this.n = r8;
        if (this.f13864b != 0) goto L5;
        int r18 = (int) h.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 22.0f);
    L6:
        r8.setMinimumHeight(r18);
        if (this.f13864b != 0) goto L9;
        View r19 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r20 = 66;
    L10:
        r8.setMaxHeight(h.a(r19, r20));
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.custom_end_container, OaidModel.KEY_ID, "custom_end_container"));
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.custom_end_container)");
        this.u = (FrameLayout) ZeusTransformUtils.preCheckCast(r21, FrameLayout.class, "com.obric.memorydata.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.input_divider, OaidModel.KEY_ID, "input_divider"));
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.input_divider)");
        this.v = r22;
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.clear, OaidModel.KEY_ID, "clear"));
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.clear)");
        ImageView r24 = (ImageView) ZeusTransformUtils.preCheckCast(r23, ImageView.class, "com.obric.memorydata.plugin");
        this.q = r24;
        View r25 = findViewById(ZeusTransformUtils.mapRes(R.id.eyes, OaidModel.KEY_ID, "eyes"));
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.eyes)");
        ImageView r26 = (ImageView) ZeusTransformUtils.preCheckCast(r25, ImageView.class, "com.obric.memorydata.plugin");
        this.s = r26;
        View r27 = findViewById(ZeusTransformUtils.mapRes(R.id.tip, OaidModel.KEY_ID, "tip"));
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.tip)");
        this.w = (OTextView) ZeusTransformUtils.preCheckCast(r27, OTextView.class, "com.obric.memorydata.plugin");
        View r28 = findViewById(ZeusTransformUtils.mapRes(R.id.limit_single, OaidModel.KEY_ID, "limit_single"));
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.limit_single)");
        this.x = (OTextView) ZeusTransformUtils.preCheckCast(r28, OTextView.class, "com.obric.memorydata.plugin");
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.limit_multi, OaidModel.KEY_ID, "limit_multi"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(R.id.limit_multi)");
        this.y = (OTextView) ZeusTransformUtils.preCheckCast(r0, OTextView.class, "com.obric.memorydata.plugin");
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        r8.setFocusable(true);
        r8.setFocusableInTouchMode(true);
        if (r13 == null) goto L14;
        a(r13, r11);
    L14:
        n();
        h();
        r24.setOnClickListener(new $$Lambda$OInputLayout$4wcupJwLTjGX1c5jOGUA69yyw2Y(this));
        r26.setOnClickListener(new $$Lambda$OInputLayout$Vw6U9dc88tlq2i4QdJwlvy0lff0(this));
        r17.setOnClickListener(new $$Lambda$OInputLayout$LIwAhTCEKujpBbRemug2ALypWs(this));
        g();
        return;
    L9:
        r19 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r20 = 240;
        goto L10
    L5:
        r18 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 120);
        goto L6
    }

    public /* synthetic */ OInputLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final void a(AttributeSet r6, int r7) {
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        TypedArray r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(r8, R.styleable.OInputLayout, r7, 0);
        this.c = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_minHeight, "styleable", "OInputLayout_oinput_minHeight"), this.c);
        this.d = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_maxHeight, "styleable", "OInputLayout_oinput_maxHeight"), this.d);
        this.f = r9.getDimension(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_fadeLength, "styleable", "OInputLayout_oinput_fadeLength"), this.f);
        setType(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_type, "styleable", "OInputLayout_oinput_type"), 0));
        a(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showInputBackground, "styleable", "OInputLayout_oinput_showInputBackground"), false));
        setCustomStart(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_customStart, "styleable", "OInputLayout_oinput_customStart"), 0));
        b(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showCustomStart, "styleable", "OInputLayout_oinput_showCustomStart"), false));
        setLabel((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_label, "styleable", "OInputLayout_oinput_label")), CharSequence.class, "com.obric.memorydata.plugin"));
        c(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showLabel, "styleable", "OInputLayout_oinput_showLabel"), false));
        setText((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_text, "styleable", "OInputLayout_oinput_text")), CharSequence.class, "com.obric.memorydata.plugin"));
        setHint((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_hint, "styleable", "OInputLayout_oinput_hint")), CharSequence.class, "com.obric.memorydata.plugin"));
        this.o = r9.getText(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_digits, "styleable", "OInputLayout_android_digits"));
        this.p = r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_inputType, "styleable", "OInputLayout_android_inputType"), this.p);
        setMaxLines(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_maxLines, "styleable", "OInputLayout_android_maxLines"), -1));
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_ellipsize, "styleable", "OInputLayout_android_ellipsize")) == false) goto L5;
        setEllipsize(h(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_android_ellipsize, "styleable", "OInputLayout_android_ellipsize"), 0)));
    L5:
        setCustomEnd(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_customEnd, "styleable", "OInputLayout_oinput_customEnd"), 0));
        d(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showCustomEnd, "styleable", "OInputLayout_oinput_showCustomEnd"), false));
        this.r = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showClear, "styleable", "OInputLayout_oinput_showClear"), false);
        this.t = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showEyes, "styleable", "OInputLayout_oinput_showEyes"), false);
        setTip((CharSequence) ZeusTransformUtils.preCheckCast(r9.getString(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_tip, "styleable", "OInputLayout_oinput_tip")), CharSequence.class, "com.obric.memorydata.plugin"));
        f(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showTip, "styleable", "OInputLayout_oinput_showTip"), false));
        setLimitCount(r9.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_limitCount, "styleable", "OInputLayout_oinput_limitCount"), -1));
        g(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_showLimit, "styleable", "OInputLayout_oinput_showLimit"), false));
        setAutoChangeWithLimit(r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputLayout_oinput_autoChangeWithLimit, "styleable", "OInputLayout_oinput_autoChangeWithLimit"), false));
    }

    private static final void a(OInputLayout r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        r2.j();
    }

    private final boolean a(int r2) {
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L6;
        return true;
    L6:
        if (r2 == 2) goto L12;
        return false;
    L12:
        return true;
    L10:
        return true;
    }

    public static final /* synthetic */ boolean a(OInputLayout r0) {
        return r0.C;
    }

    static /* synthetic */ boolean a(OInputLayout r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.f13864b;
    L7:
        return r0.b(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isSingleLineType");
    }

    public static final /* synthetic */ void b(OInputLayout r0) {
        r0.j();
    }

    private static final void b(OInputLayout r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        int r0 = 0;
        if ((r5.n.getInputType() & 4080) != 144) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == false) goto L9;
        r5.s.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_input_view_eyes_close, "drawable", "o_input_view_eyes_close"));
        r5.i();
    L11:
        if (r5.n.hasFocus() == false) goto L18;
        OEditText r8 = r5.n;
        Editable r9 = r8.getText();
        if (r9 == null) goto L16;
        r0 = r9.length();
    L16:
        r8.setSelection(r0);
        return;
    L18:
        return;
    L9:
        r5.s.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_input_view_eyes_open, "drawable", "o_input_view_eyes_open"));
        r5.n.setInputType((r5.n.getInputType() & (-4081)) | 144);
        goto L11
    L5:
        r7 = false;
        goto L7
    }

    private final boolean b(int r1) {
        if (r1 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    static /* synthetic */ boolean b(OInputLayout r0, int r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = r0.f13864b;
    L7:
        return r0.c(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isMultiLineType");
    }

    public static final /* synthetic */ void c(OInputLayout r0) {
        r0.k();
    }

    private static final void c(OInputLayout r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.n.requestFocus();
        if (r1.n.hasFocus() == false) goto L8;
        if (r1.n.isCursorVisible() == true) goto L8;
        r1.n.setCursorVisible(true);
    L8:
        if (r1.n.hasFocus() == false) goto L14;
        Editable r3 = r1.n.getText();
        if (r3 != null) goto L12;
        int r4 = 0;
    L13:
        r1.n.setSelection(r4);
        goto L14
    L12:
        r4 = r3.length();
    L14:
        r1.a();
    }

    private final boolean c(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static final /* synthetic */ void d(OInputLayout r0) {
        r0.o();
    }

    private final boolean d(int r1) {
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final int e(int r4) {
        int r0 = this.c;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (b(r4) == false) goto L9;
    L12:
        return (int) h.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 22.0f);
    L9:
        if (d(r4) == false) goto L12;
        return h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 120);
    }

    private final int f(int r3) {
        int r0 = this.d;
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        if (b(r3) == false) goto L8;
        View r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r4 = 66;
    L10:
        return h.a(r2, r4);
    L8:
        r2 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r4 = 240;
        goto L10
    }

    private final void f() {
        boolean r1 = true;
        if (a(this, 0, 1, null) == true) goto L5;
        LinearLayout r2 = this.h;
        int r6 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        int r7 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        if (((View) ZeusTransformUtils.preCheckCast(this.k, View.class, "com.obric.memorydata.plugin")).getVisibility() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        int r3 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
    L23:
        r2.setPadding(r6, r7, 0, r3);
        this.m.setPadding(0, 0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), 0);
        this.n.setPadding(0, 0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), 0);
        this.n.setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        this.n.setScrollBarStyle(33554432);
        this.k.setPadding(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 6), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8));
        return;
    L22:
        r3 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        goto L23
    L5:
        if (((View) ZeusTransformUtils.preCheckCast(this.m, View.class, "com.obric.memorydata.plugin")).getVisibility() == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        int r4 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8.5d);
    L11:
        LinearLayout r5 = this.h;
        int r8 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        if (this.r == false) goto L14;
        int r9 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
    L15:
        r5.setPadding(r8, r4, r9, r4);
        this.m.setPadding(0, 0, 0, 0);
        this.n.setPadding(0, 0, 0, 0);
        this.n.setGravity(8388627);
        this.n.setScrollBarStyle(0);
        int r0 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 5);
        this.k.setPadding(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12), r0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8), r0);
        return;
    L14:
        r9 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        goto L15
    L10:
        r4 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 13);
        goto L11
    }

    private final void g() {
        this.h.setClipToOutline(true);
        this.h.setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new c(this), ViewOutlineProvider.class, "com.obric.memorydata.plugin"));
        this.h.invalidateOutline();
    }

    private final void g(int r3) {
        OEditText r0 = this.n;
        boolean r1 = true;
        if (r3 == 1) goto L6;
        r1 = false;
    L6:
        r0.setSingleLine(r1);
        this.n.setMaxLines(r3);
        i();
        o();
    }

    private final TextUtils.TruncateAt h(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    private final void h() {
        e();
        CharSequence r0 = this.o;
        if (r0 == null) goto L9;
        this.n.setKeyListener((KeyListener) ZeusTransformUtils.preCheckCast(DigitsKeyListener.getInstance(String.valueOf(r0)), KeyListener.class, "com.obric.memorydata.plugin"));
        int r1 = this.p;
        if (r1 != 0) goto L8;
        r1 = 1;
    L8:
        this.p = r1;
    L9:
        int r2 = this.p;
        if (r2 == 0) goto L12;
        setInputType(r2);
    L12:
        this.n.onFocusChange$OUI_standardRelease((Function1) ZeusTransformUtils.preCheckCast(new OInputLayout$initInput$1(this), Function1.class, "com.obric.memorydata.plugin"));
        this.n.onTextChanged$OUI_standardRelease((Function4) ZeusTransformUtils.preCheckCast(new OInputLayout$initInput$2(this), Function4.class, "com.obric.memorydata.plugin"));
        this.n.afterTextChanged$OUI_standardRelease((Function1) ZeusTransformUtils.preCheckCast(new OInputLayout$initInput$3(this), Function1.class, "com.obric.memorydata.plugin"));
    }

    private final void i() {
        boolean r1 = true;
        if (getMaxLines() != 1) goto L6;
        r1 = false;
    L6:
        int r0 = this.p;
        if (r1 == true) goto L9;
    L11:
        int r2 = r0 ^ 131072;
    L12:
        this.n.setInputType(r2);
        this.n.invalidate();
        o();
        return;
    L9:
        if (i(r0) == true) goto L11;
        r2 = r0 | 131072;
        goto L12
    }

    private final boolean i(int r5) {
        int r4 = r5 & 4095;
        if (r4 != 129) goto L5;
        boolean r1 = true;
    L7:
        if (r4 != 225) goto L9;
        boolean r2 = true;
    L11:
        if (r4 != 18) goto L13;
        boolean r6 = true;
    L14:
        if (r1 == true) goto L20;
        if (r2 == true) goto L21;
        if (r6 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r6 = false;
        goto L14
    L9:
        r2 = false;
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    private final void j() {
        ImageView r0 = this.q;
        int r1 = 0;
        boolean r2 = true;
        if (a(this, 0, 1, null) == true) goto L5;
    L14:
        r1 = 8;
    L15:
        r0.setVisibility(r1);
        f();
        return;
    L5:
        if (this.r == false) goto L14;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(this.n.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
    L12:
        if (r2 == true) goto L14;
    L9:
        if (r3.length() == 0) goto L12;
        r2 = false;
        goto L12
    }

    private final void k() {
        ImageView r0 = this.s;
        int r1 = 0;
        boolean r2 = true;
        if (a(this, 0, 1, null) == true) goto L5;
    L16:
        r1 = 8;
    L17:
        r0.setVisibility(r1);
        return;
    L5:
        if (this.t == false) goto L16;
        if (c() == false) goto L16;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(this.n.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L11;
    L14:
        if (r2 == true) goto L16;
    L11:
        if (r5.length() == 0) goto L14;
        r2 = false;
        goto L14
    }

    private final void l() {
        FrameLayout r0 = this.k;
        boolean r2 = true;
        int r4 = 0;
        if (((View) ZeusTransformUtils.preCheckCast(this.w, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L14:
        r0.setVisibility(r4);
        return;
    L8:
        if (((View) ZeusTransformUtils.preCheckCast(this.y, View.class, "com.obric.memorydata.plugin")).getVisibility() == 0) goto L11;
        r2 = false;
    L11:
        if (r2 == true) goto L14;
        r4 = 8;
        goto L14
    L5:
        r1 = false;
        goto L6
    }

    public static /* synthetic */ void lambda$4wcupJwLTjGX1c5jOGUA69yyw2Y(OInputLayout r0, View r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$LIwAhTC-EKujpBbRemug2ALypWs, reason: not valid java name */
    public static /* synthetic */ void m1296lambda$LIwAhTCEKujpBbRemug2ALypWs(OInputLayout r0, View r1) {
        c(r0, r1);
    }

    public static /* synthetic */ void lambda$Vw6U9dc88tlq2i4QdJwlvy0lff0(OInputLayout r0, View r1) {
        b(r0, r1);
    }

    private final void m() {
        if (this.D == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        setTextState(r0);
        return;
    L5:
        if (this.B == false) goto L7;
        r0 = true;
        goto L8
    }

    private final void n() {
        float r0 = this.f;
        if (r0 < 0.0f) goto L6;
        this.j.setFadeLength(r0);
        return;
    }

    private final void o() {
        this.j.a();
    }

    public int a(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.length();
    }

    public final void a() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.showSoftInput((View) ZeusTransformUtils.preCheckCast(this.n, View.class, "com.obric.memorydata.plugin"), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void a(Editable r2) {
        Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
    }

    public final void a(boolean r4) {
        LinearLayout r0 = this.h;
        if (r4 == false) goto L5;
        int r3 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_fill_list_item_card, TypedValues.Custom.S_COLOR, "oui_fill_list_item_card"));
    L6:
        r0.setBackgroundColor(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void b() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.hideSoftInputFromWindow(this.n.getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void b(boolean r4) {
        int r0 = 0;
        if (b(this, 0, 1, null) == false) goto L5;
        return;
    L5:
        int r1 = this.l.getChildCount();
        FrameLayout r3 = this.l;
        if (r1 == 0) goto L11;
        if (r4 == true) goto L10;
        r0 = 8;
    L10:
        r3.setVisibility(r0);
        return;
    L11:
        r3.setVisibility(8);
    }

    public final void c(boolean r4) {
        CharSequence r0 = getLabel();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        OTextView r3 = this.m;
        if (r4 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
    L17:
        f();
        return;
    L16:
        this.m.setVisibility(8);
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final boolean c() {
        return i(this.p);
    }

    public final void d() {
        if (this.z <= 0) goto L5;
        OTextView r0 = this.x;
        StringBuilder r2 = new StringBuilder();
        Editable r3 = this.n.getText();
        Intrinsics.checkNotNull(r3);
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2.append(a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))).append('/').append(this.z).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        OTextView r1 = this.y;
        StringBuilder r4 = new StringBuilder();
        Editable r5 = this.n.getText();
        Intrinsics.checkNotNull(r5);
        r1.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4.append(a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))).append('/').append(this.z).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
    L5:
        OTextView r6 = this.x;
        boolean r7 = false;
        int r8 = 8;
        if (a(this, 0, 1, null) == true) goto L8;
    L10:
        int r9 = 8;
    L11:
        r6.setVisibility(r9);
        OTextView r10 = this.y;
        if (b(this, 0, 1, null) == true) goto L14;
    L16:
        r10.setVisibility(r8);
        if (this.z <= 0) goto L29;
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(this.n.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L21;
    L24:
        boolean r12 = true;
    L25:
        if (r12 == true) goto L29;
        Editable r13 = this.n.getText();
        Intrinsics.checkNotNull(r13);
        if (a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) <= this.z) goto L29;
        r7 = true;
        goto L29
    L21:
        if (r11.length() == 0) goto L24;
        r12 = false;
    L29:
        boolean r14 = this.D;
        if (r7 == r14) goto L35;
        this.D = r7;
        b r15 = this.E;
        if (r15 == null) goto L36;
        r15.a(r7);
    L36:
        m();
        return;
    L35:
        if (r14 == true) goto L36;
        return;
    L14:
        if (this.A == false) goto L16;
        r8 = 0;
        goto L16
    L8:
        if (this.A == false) goto L10;
        r9 = 0;
        goto L11
    }

    public final void d(boolean r4) {
        int r0 = 0;
        if (b(this, 0, 1, null) == false) goto L5;
        return;
    L5:
        int r1 = this.u.getChildCount();
        FrameLayout r3 = this.u;
        if (r1 == 0) goto L11;
        if (r4 == true) goto L10;
        r0 = 8;
    L10:
        r3.setVisibility(r0);
        return;
    L11:
        r3.setVisibility(8);
    }

    public final void e() {
        Method r0 = TextView.class.getDeclaredMethod("enableUpdateCursorDrawable", new Class[0]);     // Catch: Exception -> L4
        Intrinsics.checkNotNullExpressionValue(r0, "TextView::class.java.get…orDrawable\"\n            )");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        r0.invoke(this.n, new Object[0]);     // Catch: Exception -> L4
        return;
    }

    public final void e(boolean r1) {
        this.r = r1;
        j();
    }

    public final void f(boolean r4) {
        CharSequence r0 = getTip();
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        OTextView r3 = this.w;
        if (r4 == true) goto L15;
        r1 = 8;
    L15:
        r3.setVisibility(r1);
    L17:
        l();
        return;
    L16:
        this.w.setVisibility(8);
        goto L17
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public final void g(boolean r2) {
        if (this.A != r2) goto L5;
        return;
    L5:
        this.A = r2;
        d();
        l();
    }

    public final View getCustomEnd() {
        if (this.u.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.u.getChildAt(0);
    }

    public final View getCustomStart() {
        if (this.l.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.l.getChildAt(0);
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.n.getEllipsize();
    }

    public final float getFadeLength() {
        return this.j.getFadeLength();
    }

    public final CharSequence getHint() {
        return this.n.getHint();
    }

    public final int getInputType() {
        return this.p;
    }

    public final CharSequence getLabel() {
        return this.m.getText();
    }

    public final int getLimitCount() {
        return this.z;
    }

    public final int getMaxLines() {
        return this.n.getMaxLines();
    }

    public CharSequence getText() {
        return (CharSequence) ZeusTransformUtils.preCheckCast(this.n.getText(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public final CharSequence getTip() {
        return this.w.getText();
    }

    public final int getType() {
        return this.f13864b;
    }

    public final OEditText getVInput() {
        return this.n;
    }

    public final void setAutoChangeWithLimit(boolean r1) {
        this.B = r1;
        m();
    }

    public final void setCustomEnd(int r4) {
        this.u.removeAllViews();
        if (r4 == 0) goto L9;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(this.u, ViewGroup.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setCustomStart(int r4) {
        this.l.removeAllViews();
        if (r4 == 0) goto L9;
        FrameLayout.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(this.l, ViewGroup.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public void setDefaultCustomStart(int r3) {
        this.l.removeAllViews();
        if (r3 != 0) goto L5;
        setCustomStart(ZeusTransformUtils.mapRes(R.layout.o_input_custom_start_area_code, "layout", "o_input_custom_start_area_code"));
        return;
    L5:
        b(false);
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.g = r1;
        this.n.setEllipsize(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        Iterator<View> r0 = ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.memorydata.plugin")).setEnabled(r5);
        goto L4
    L6:
        this.n.setEnabled(r5);
    }

    public final void setFadeLength(float r2) {
        float r3 = RangesKt.coerceAtLeast(r2, 0.0f);
        if (this.f != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.f = r3;
        n();
        o();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setHint(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.n.setHint(r4);
    }

    public final void setInputType(int r2) {
        if ((r2 & 1) != 0) goto L12;
        if ((r2 & 2) != 0) goto L12;
        if ((r2 & 3) != 0) goto L12;
        if ((r2 & 4) != 0) goto L12;
        r2 = r2 | 1;
    L12:
        if (this.p == r2) goto L14;
        this.p = r2;
    L14:
        i();
        k();
        a(this.n.getText());
    }

    public final void setLabel(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.m.setText(r4);
    }

    public void setLimitCount(int r2) {
        if (this.z != r2) goto L5;
        return;
    L5:
        this.z = r2;
        d();
        a(this.n.getText());
    }

    public final void setLimitStateChangeListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "limitStateChangeListener");
        this.E = r4;
    }

    public final void setMaxLines(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.e = r1;
        g(r1);
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.n.setText(r4);
        a(this.n.getText());
    }

    public final void setTextState(boolean r15) {
        if (this.C == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.C = true;
        int r1 = this.n.getSelectionStart();
        int r2 = this.n.getSelectionEnd();
        Editable r3 = this.n.getText();
        if (r3 == null) goto L49;
        int r7 = r3.length();     // Catch: Exception -> L46
        if (r15 == false) goto L10;
        int r8 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_red_2, TypedValues.Custom.S_COLOR, "oui_functional_red_2"));     // Catch: Exception -> L46
    L11:
        ErrorBackgroundSpan[] r9 = (ErrorBackgroundSpan[]) ZeusTransformUtils.preCheckCast(r3.getSpans(0, r7, ErrorBackgroundSpan.class), ErrorBackgroundSpan[].class, "com.obric.memorydata.plugin");     // Catch: Exception -> L46
        Intrinsics.checkNotNullExpressionValue(r9, "existingSpans");     // Catch: Exception -> L46
        int r10 = r9.length;     // Catch: Exception -> L46
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L20;
        ErrorBackgroundSpan r12 = r9[r11];     // Catch: Exception -> L46
        if (r12.getBackgroundColor() != r8) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == true) goto L21;
        r11 = r11 + 1;     // Catch: Exception -> L46
    L21:
        if (r12 != null) goto L23;
        r12 = new ErrorBackgroundSpan(r8);     // Catch: Exception -> L46
    L23:
        int r14 = r9.length;     // Catch: Exception -> L46
        int r16 = 0;
    L24:
        if (r16 >= r14) goto L26;
        r3.removeSpan(r9[r16]);     // Catch: Exception -> L46
        r16 = r16 + 1;     // Catch: Exception -> L46
        goto L24
    L26:
        r3.setSpan(r12, 0, r7, 33);     // Catch: Exception -> L46
        com.obric.oui.forms.a[] r4 = (com.obric.oui.forms.a[]) ZeusTransformUtils.preCheckCast(r3.getSpans(0, r7, com.obric.oui.forms.a.class), com.obric.oui.forms.a[].class, "com.obric.memorydata.plugin");     // Catch: Exception -> L46
        Intrinsics.checkNotNullExpressionValue(r4, "existingPasswordTransSpans");     // Catch: Exception -> L46
        int r17 = r4.length;     // Catch: Exception -> L46
        int r18 = 0;
    L27:
        if (r18 >= r17) goto L33;
        com.obric.oui.forms.a r19 = r4[r18];     // Catch: Exception -> L46
        if (r19 == null) goto L32;
        r19.a(r15);     // Catch: Exception -> L46
        r18 = r18 + 1;     // Catch: Exception -> L46
        goto L27
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.forms.OPasswordTransformationMethod");     // Catch: Exception -> L46
    L33:
        if (r1 < 0) goto L36;
        if (r1 > r7) goto L36;
        boolean r5 = true;
    L37:
        if (r5 == false) goto L44;
        if (r2 < 0) goto L41;
        if (r2 > r7) goto L41;
    L42:
        if (r0 == false) goto L44;
        this.n.setSelection(r1, r2);     // Catch: Exception -> L46
    L41:
        r0 = false;
    L44:
        this.n.setSelection(r1, r7);     // Catch: Exception -> L46
    L36:
        r5 = false;
        goto L37
    L16:
        r13 = false;
        goto L17
    L20:
        r12 = null;
        goto L21
    L10:
        r8 = 0;
    L46:
        e = move-exception;
        Log.e("OInputLayout", Intrinsics.stringPlus("Error setTextState: ", e));
    L49:
        if (this.F == r15) goto L57;
        this.F = r15;
        if (Build.VERSION.SDK_INT < 29) goto L57;
        OEditText r6 = this.n;
        if (r15 == false) goto L55;
        int r20 = R.drawable.o_input_cursor_red;
        String r21 = "o_input_cursor_red";
    L56:
        r6.setTextCursorDrawable(ZeusTransformUtils.mapRes(r20, "drawable", r21));
        goto L57
    L55:
        r20 = R.drawable.o_input_cursor_blue;
        r21 = "o_input_cursor_blue";
    L57:
        OTextView r22 = this.w;
        Resources r23 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        if (r15 == false) goto L60;
        int r24 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6");
    L61:
        r22.setTextColor(r23.getColor(r24));
        OTextView r25 = this.x;
        Resources r26 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        if (r15 == false) goto L64;
        int r27 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6");
    L65:
        r25.setTextColor(r26.getColor(r27));
        OTextView r28 = this.y;
        Resources r29 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin");
        if (r15 == false) goto L68;
        int r110 = ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, TypedValues.Custom.S_COLOR, "oui_functional_red_6");
    L69:
        r28.setTextColor(r29.getColor(r110));
        this.C = false;
        o();
        return;
    L68:
        r110 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, TypedValues.Custom.S_COLOR, "oui_basic_text_3b");
        goto L69
    L64:
        r27 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, TypedValues.Custom.S_COLOR, "oui_basic_text_3b");
        goto L65
    L60:
        r24 = ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, TypedValues.Custom.S_COLOR, "oui_basic_text_3b");
        goto L61
    }

    public final void setTip(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.w.setText(r4);
    }

    public void setType(int r3) {
        if (a(r3) == true) goto L5;
        return;
    L5:
        this.f13864b = r3;
        this.n.setMinimumHeight(e(r3));
        this.n.setMaxHeight(f(r3));
        int r0 = this.e;
        if (r0 == (-1)) goto L9;
    L12:
        g(r0);
        f();
        d();
        j();
        k();
        return;
    L9:
        if (b(r3) == false) goto L11;
        r0 = 1;
        goto L12
    L11:
        r0 = 12;
        goto L12
    }
}
