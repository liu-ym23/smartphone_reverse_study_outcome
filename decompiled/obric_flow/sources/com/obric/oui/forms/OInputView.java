package com.obric.oui.forms;

import ai.j0;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001:\u0003wZTB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u000bJ\u0015\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0004\b\"\u0010 J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u001d¢\u0006\u0004\b$\u0010 J\u0017\u0010'\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u001d¢\u0006\u0004\b*\u0010 J\u0015\u0010+\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u001d¢\u0006\u0004\b+\u0010 J\u0015\u0010,\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u001d¢\u0006\u0004\b,\u0010 J\u0015\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0006¢\u0006\u0004\b.\u0010\u0013J\u0011\u0010/\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010%¢\u0006\u0004\b2\u0010(J\u0017\u00104\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010%¢\u0006\u0004\b4\u0010(J\u0015\u00106\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u001d¢\u0006\u0004\b6\u0010 J0\u0010=\u001a\u00020\u000e2!\u0010<\u001a\u001d\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u000e07¢\u0006\u0004\b=\u0010>J0\u0010?\u001a\u00020\u000e2!\u0010<\u001a\u001d\u0012\u0013\u0012\u001108¢\u0006\f\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020\u000e07¢\u0006\u0004\b?\u0010>J\u0015\u0010A\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u0006¢\u0006\u0004\bA\u0010\u0013J\u0017\u0010D\u001a\u00020\u000e2\b\u0010C\u001a\u0004\u0018\u00010B¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u0004\u0018\u00010B¢\u0006\u0004\bF\u0010GJ\u0015\u0010I\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u0006¢\u0006\u0004\bI\u0010\u0013J\u0017\u0010J\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u0006H\u0016¢\u0006\u0004\bJ\u0010\u0013J\r\u0010K\u001a\u00020\u0006¢\u0006\u0004\bK\u0010\u000bJ\u0015\u0010L\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u001d¢\u0006\u0004\bL\u0010 J\u0017\u0010N\u001a\u00020\u000e2\b\b\u0001\u0010M\u001a\u00020\u0006¢\u0006\u0004\bN\u0010\u0013J\u0015\u0010O\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\bO\u0010 J\u0017\u0010R\u001a\u00020\u000e2\b\u0010Q\u001a\u0004\u0018\u00010P¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u000e2\b\u0010Q\u001a\u0004\u0018\u00010T¢\u0006\u0004\bU\u0010VJ\u0017\u0010X\u001a\u00020\u000e2\b\u0010W\u001a\u0004\u0018\u00010%¢\u0006\u0004\bX\u0010(J\u0017\u0010Y\u001a\u00020\u000e2\b\u0010W\u001a\u0004\u0018\u00010%¢\u0006\u0004\bY\u0010(J\u0015\u0010\\\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020Z¢\u0006\u0004\b\\\u0010]J\u0011\u0010_\u001a\u0004\u0018\u00010^H\u0016¢\u0006\u0004\b_\u0010`J\u0019\u0010a\u001a\u00020\u000e2\b\u0010Q\u001a\u0004\u0018\u00010^H\u0016¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020\u000e2\b\u0010Q\u001a\u0004\u0018\u00010PH\u0016¢\u0006\u0004\bc\u0010SJ\u0015\u0010e\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020\u0006¢\u0006\u0004\be\u0010\u0013J\u0015\u0010g\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020\u001d¢\u0006\u0004\bg\u0010 J\u000f\u0010i\u001a\u00020hH\u0002¢\u0006\u0004\bi\u0010jR\u0017\u0010p\u001a\u00020k8\u0006¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\"\u0010v\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010 ¨\u0006x"}, d2 = {"Lcom/obric/oui/forms/OInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getContentViewRes", "()I", "Landroid/text/method/KeyListener;", "keyListener", "", "setKeyListener", "(Landroid/text/method/KeyListener;)V", "radius", "setRadius", "(I)V", "type", "setInputType", "getInputType", "Lcom/obric/oui/forms/d;", "commitCompletionListener", "setCommitCompletionListener", "(Lcom/obric/oui/forms/d;)V", "getCommitCompletionListener", "()Lcom/obric/oui/forms/d;", "", "enabled", "setEnabled", "(Z)V", "error", "setErrorState", "inScrollableView", "setIsInScrollableView", "", "label", "setLabel", "(Ljava/lang/String;)V", Constant.ClientMessageType.SHOW, "setShowLabel", "setShowLabelAnim", "setShowLabelIcon", "height", "setInputHeight", "getText", "()Ljava/lang/String;", MessageIndication.CONTENT_TYPE_TEXT, "setText", "hint", "setHint", "single", "setSingleLine", "Lkotlin/Function1;", "Landroid/widget/FrameLayout;", "Lkotlin/ParameterName;", "name", "parent", "creator", "setLeftView", "(Lkotlin/jvm/functions/Function1;)V", "setActionView", "max", "setMaxLines", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "(Landroid/text/TextUtils$TruncateAt;)V", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "limit", "setLimitCountValue", "setLimitCount", "getLimitCount", "setShowLimitIndicator", "mode", "setInputMode", "setComboInputEnabled", "Landroid/view/View$OnClickListener;", "l", "setOnComboArrowClickListener", "(Landroid/view/View$OnClickListener;)V", "Lcom/obric/oui/forms/l;", "setOnTextExceedLengthListener", "(Lcom/obric/oui/forms/l;)V", "tip", "setErrorTip", "setCommonTip", "Lcom/obric/oui/forms/k;", "listener", "setOnTextClearedListener", "(Lcom/obric/oui/forms/k;)V", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "setOnClickListener", "resId", "setBgResId", "hide", "setAlwaysHideEye", "", "getFakeInputOffsetY", "()F", "Lcom/obric/oui/forms/OEditText;", "J", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInput", "a0", "Z", "getAutoHideSoftInputWhenLoseFocus", "()Z", "setAutoHideSoftInputWhenLoseFocus", "autoHideSoftInputWhenLoseFocus", "LabelUIState", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ClickableViewAccessibility"})
public class OInputView extends ConstraintLayout {

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final /* synthetic */ int f13274f0 = 0;
    public int A;
    public String B;
    public String C;
    public final boolean D;
    public int E;
    public final OUIConstraintLayout F;
    public final LinearLayout G;
    public final OTextView H;
    public final ImageView I;
    public final OEditText J;
    public final FrameLayout K;
    public final FrameLayout L;
    public final View M;
    public final View N;
    public final View O;
    public final ImageView P;
    public final View Q;
    public final OTextView R;
    public final OTextView S;
    public final OTextView T;
    public final TextView U;
    public boolean V;
    public View.OnClickListener W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f13275a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f13276b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f13277c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public ValueAnimator f13278d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public ValueAnimator f13279e0;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f13281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextUtils.TruncateAt f13283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f13284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f13287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f13288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13289q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13290r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13291t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13292u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f13293v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f13294w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f13295x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f13296y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f13297z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/forms/OInputView$LabelUIState;", "", "REAL_LABEL_SHOW", "FAKE_LABEL_SHOW", "LABEL_NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum LabelUIState extends Enum<LabelUIState> {
        public static final LabelUIState FAKE_LABEL_SHOW = null;
        public static final LabelUIState LABEL_NONE = null;
        public static final LabelUIState REAL_LABEL_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LabelUIState[] f13298a = null;

        static {
            LabelUIState r5 = new LabelUIState("REAL_LABEL_SHOW", 0);
            REAL_LABEL_SHOW = r5;
            LabelUIState r10 = new LabelUIState("FAKE_LABEL_SHOW", 1);
            FAKE_LABEL_SHOW = r10;
            LabelUIState r11 = new LabelUIState("LABEL_NONE", 2);
            LABEL_NONE = r11;
            f13298a = new LabelUIState[]{r5, r10, r11};
        }

        public static LabelUIState valueOf(String r5) {
            return (LabelUIState) Enum.valueOf(LabelUIState.class, r5);
        }

        public static LabelUIState[] values() {
            return (LabelUIState[]) f13298a.clone();
        }
    }

    @JvmOverloads
    public OInputView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static final void e(final OInputView r13, boolean r14) {
        if (r13.f13291t == true) goto L6;
        return;
    L6:
        if (r13.s == true) goto L9;
        return;
    L9:
        if (r13.f13281i == false) goto L67;
        final TextView r5 = r13.U;
        if (r5 == null) goto L68;
        Editable r10 = r13.J.getText();
        if (r10 == null) goto L21;
        if (r10.length() == 0) goto L21;
        LabelUIState r11 = LabelUIState.REAL_LABEL_SHOW;
        Intrinsics.checkNotNull(r5);
        r13.w(r11, r5, Intrinsics.stringPlus("playLabelAnim, hasFocus: ", Boolean.valueOf(r14)));
        return;
    L21:
        if (r14 == false) goto L41;
        ValueAnimator r15 = r13.f13279e0;
        if (r15 == null) goto L26;
        r15.cancel();
    L26:
        ValueAnimator r16 = r13.f13279e0;
        if (r16 == null) goto L30;
        r16.removeAllUpdateListeners();
    L30:
        ValueAnimator r17 = r13.f13279e0;
        if (r17 == null) goto L34;
        r17.removeAllListeners();
    L34:
        ValueAnimator r18 = r13.f13278d0;
        if (r18 != null) goto L38;
    L40:
        final int r12 = ContextCompat.getColor(r13.getContext(), R$color.oui_text_3);
        final int r19 = ContextCompat.getColor(r13.getContext(), R$color.oui_text_4);
        final float r110 = r13.getFakeInputOffsetY();
        final float r20 = r13.q(r5);
        r5.setPivotX(0.0f);
        r5.setPivotY(-r110);
        ValueAnimator r21 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r21.setDuration(200);
        r21.setInterpolator(new DecelerateInterpolator());
        final int r111 = 1;
        r21.addUpdateListener(new i(r110, r13, r19, r12, r20, r5, r111));
        r21.addListener(new n(r13, r5, 1));
        r13.f13278d0 = r21;
        r21.start();
        ps.a.a("OInputView", "start label show anim");
        return;
    L38:
        if (r18.isRunning() != true) goto L40;
        ps.a.g("OInputView", "label show anim is running, do nothing");
        return;
    L41:
        ValueAnimator r112 = r13.f13278d0;
        if (r112 == null) goto L45;
        r112.cancel();
    L45:
        ValueAnimator r113 = r13.f13278d0;
        if (r113 == null) goto L49;
        r113.removeAllUpdateListeners();
    L49:
        ValueAnimator r114 = r13.f13278d0;
        if (r114 == null) goto L53;
        r114.removeAllListeners();
    L53:
        ValueAnimator r115 = r13.f13279e0;
        if (r115 != null) goto L57;
    L59:
        final int r22 = ContextCompat.getColor(r13.getContext(), R$color.oui_text_3);
        final int r23 = ContextCompat.getColor(r13.getContext(), R$color.oui_text_4);
        final float r116 = r13.getFakeInputOffsetY();
        final float r24 = r13.q(r5);
        r5.setPivotX(0.0f);
        r5.setPivotY(-r116);
        ValueAnimator r25 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r25.setDuration(200);
        r25.setInterpolator(new DecelerateInterpolator());
        final int r117 = 0;
        r25.addUpdateListener(new i(r116, r13, r22, r23, r24, r5, r117));
        r25.addListener(new n(r13, r5, 0));
        r13.f13279e0 = r25;
        r25.start();
        ps.a.a("OInputView", "start label hide anim");
        return;
    L57:
        if (r115.isRunning() != true) goto L59;
        ps.a.g("OInputView", "label hide anim is running, do nothing");
        return;
    L68:
        return;
    }

    private final float getFakeInputOffsetY() {
        LinearLayout r5 = this.G;
        if (r5.getHeight() > 0) goto L5;
    L7:
        ps.a.g("OInputView", "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + r5.getHeight() + ", height: " + getHeight());
        float r10 = com.lynx.tasm.utils.a.D(-11.0f, this);
    L8:
        ps.a.a("OInputView", Intrinsics.stringPlus("getFakeInputOffsetY, offsetY: ", Float.valueOf(r10)));
        return r10;
    L5:
        if (getHeight() <= 0) goto L7;
        r10 = ((r5.getHeight() / 2.0f) + r5.getY()) - (getHeight() / 2.0f);
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L36;
        if (this.f13286n == false) goto L36;
        float r5 = r10.getX();
        float r11 = r10.getY();
        int r12 = r10.getAction();
        if (r12 != 0) goto L8;
        this.f13284l = r11;
        goto L36
    L8:
        if (r12 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r12 != 2) goto L12;
        float r13 = this.f13285m;
        OEditText r14 = this.J;
        if (r5 <= r13) goto L20;
        if (r14.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.f13285m = r5;
        this.f13284l = r11;
    L20:
        if (r5 >= this.f13285m) goto L24;
        if (r14.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r11 >= this.f13284l) goto L28;
        if (r14.canScrollVertically(1) == true) goto L31;
    L28:
        if (r11 <= this.f13284l) goto L32;
        if (r14.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r12 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r10);
    }

    public final boolean getAutoHideSoftInputWhenLoseFocus() {
        return this.f13275a0;
    }

    public final d getCommitCompletionListener() {
        this.J.getCommitCompletionListener();
        return null;
    }

    public int getContentViewRes() {
        return R$layout.o_input_view_layout_vertical;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.J.getEllipsize();
    }

    public final int getInputType() {
        return this.A;
    }

    public final int getLimitCount() {
        return this.f13290r;
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.J.getOnFocusChangeListener();
    }

    public String getText() {
        Editable r5 = this.J.getText();
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.toString();
    }

    public final OEditText getVInput() {
        return this.J;
    }

    public final void n(String r5) {
        if (this.f13291t == true) goto L5;
        return;
    L5:
        TextView r10 = this.U;
        if (r10 != null) goto L8;
        return;
    L8:
        boolean r11 = this.s;
        OEditText r12 = this.J;
        if (r11 == true) goto L12;
        r12.setHint(this.f13297z);
        w(LabelUIState.LABEL_NONE, r10, j0.k("adjustInputViewAndLabel, ", r5, ", no label"));
        return;
    L12:
        if (this.f13281i == true) goto L14;
        r12.setHint(this.f13297z);
        w(LabelUIState.REAL_LABEL_SHOW, r10, j0.k("adjustInputViewAndLabel, ", r5, ", can not show label anim"));
        return;
    L14:
        r12.setHint("");
        r10.setText(this.f13293v);
        Editable r13 = r12.getText();
        if (r13 == null) goto L21;
        if (r13.length() == 0) goto L21;
        w(LabelUIState.REAL_LABEL_SHOW, r10, j0.k("adjustInputViewAndLabel, ", r5, ", can show label anim, vInput.text not empty"));
        return;
    L21:
        if (r12.hasFocus() == false) goto L23;
        w(LabelUIState.REAL_LABEL_SHOW, r10, j0.k("adjustInputViewAndLabel, ", r5, ", can show label anim, vInput.text empty, focused"));
        return;
    L23:
        w(LabelUIState.FAKE_LABEL_SHOW, r10, j0.k("adjustInputViewAndLabel, ", r5, ", can show label anim, vInput.text empty, not focused"));
    }

    public void o(Editable r5) {
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        if (r10 != null) goto L5;
    L13:
        if (r10 != null) goto L15;
    L22:
        return super.onInterceptTouchEvent(r10);
    L15:
        if (r10.getAction() == 1) goto L19;
        if (r10.getAction() != 3) goto L22;
    L19:
        if (this.V == false) goto L22;
        this.V = false;
        goto L22
    L5:
        if (r10.getAction() != 0) goto L13;
        float r5 = r10.getX();
        OEditText r11 = this.J;
        int r12 = r11.getLeft();
        int r13 = r11.getRight();
        if (r5 >= r12) goto L9;
    L12:
        this.V = false;
        goto L22
    L9:
        if (r5 > r13) goto L12;
        this.V = true;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L12;
        if (this.V == false) goto L12;
        MotionEvent r10 = MotionEvent.obtain(r5);
        OEditText r11 = this.J;
        r10.offsetLocation(-r11.getLeft(), -r11.getTop());
        boolean r12 = r11.dispatchTouchEvent(r10);
        r10.recycle();
        if (r5.getAction() != 1) goto L8;
    L9:
        this.V = false;
    L10:
        return r12;
    L8:
        if (r5.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r5);
    }

    public int p(CharSequence r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.length();
    }

    public final float q(TextView r5) {
        OTextView r10 = this.H;
        if (r10.getTextSize() > 0.0f) goto L5;
    L7:
        ps.a.g("OInputView", "getScaleRatio, use default scale, vTitle.textSize: " + r10.getTextSize() + ", vFakeInput.textSize: " + r5.getTextSize());
        float r11 = 0.857143f;
    L8:
        ps.a.a("OInputView", Intrinsics.stringPlus("getScaleRatio, scale: ", Float.valueOf(r11)));
        return r11;
    L5:
        if (r5.getTextSize() <= 0.0f) goto L7;
        r11 = r10.getTextSize() / r5.getTextSize();
        goto L8
    }

    public final boolean r() {
        int r5 = this.A & 4095;
        if (r5 != 129) goto L5;
        boolean r10 = true;
    L7:
        if (r5 != 225) goto L9;
        boolean r11 = true;
    L11:
        if (r5 != 18) goto L13;
        boolean r12 = true;
    L14:
        if (r10 == true) goto L18;
        if (r11 == true) goto L18;
        if (r12 == true) goto L18;
        return false;
    L18:
        return true;
    L13:
        r12 = false;
        goto L14
    L9:
        r11 = false;
        goto L11
    L5:
        r10 = false;
        goto L7
    }

    public final void s(boolean r5) {
        int r10 = this.f13276b0;
        OUIConstraintLayout r11 = this.F;
        if (r10 == 0) goto L7;
        r11.setBackgroundResource(r10);
        return;
    L7:
        if (this.f13295x == true) goto L9;
        int r12 = R$drawable.o_input_view_pressed_background;
    L15:
        r11.setBackgroundResource(r12);
        return;
    L9:
        if (r5 == false) goto L12;
        r12 = R$drawable.o_input_view_pressed_background;
        goto L15
    L12:
        if (this.J.hasFocus() == false) goto L14;
        r12 = R$drawable.o_input_view_focused_background;
        goto L15
    L14:
        r12 = R$drawable.o_input_view_normal_background;
        goto L15
    }

    public final void setActionView(Function1<? super FrameLayout, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "creator");
        FrameLayout r10 = this.L;
        r10.removeAllViews();
        r5.invoke(r10);
        if (r10.getChildCount() <= 0) goto L5;
        boolean r11 = true;
    L6:
        com.lynx.tasm.utils.d.x(r10, r11);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final void setAlwaysHideEye(boolean r5) {
        this.f13277c0 = r5;
        if (r5 == false) goto L6;
        com.lynx.tasm.utils.d.x(this.P, false);
        return;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r5) {
        this.f13275a0 = r5;
    }

    public final void setBgResId(int r5) {
        this.f13276b0 = r5;
        s(true);
    }

    public final void setComboInputEnabled(boolean r5) {
        this.g = r5;
        OEditText r10 = this.J;
        r10.setFocusable(r5);
        r10.setFocusableInTouchMode(r5);
        View.OnClickListener r11 = this.W;
        if (r11 == null) goto L7;
        getVInput().setOnClickListener(r11);
        return;
    }

    public final void setCommitCompletionListener(d r5) {
        Intrinsics.checkNotNullParameter(r5, "commitCompletionListener");
        this.J.setCommitCompletionListener(r5);
    }

    public final void setCommonTip(String r5) {
        this.C = r5;
        this.S.setText(r5);
    }

    public final void setEllipsize(TextUtils.TruncateAt r5) {
        this.f13283k = r5;
        this.J.setEllipsize(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        this.f13295x = r5;
        super.setEnabled(r5);
        Iterator<View> r10 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().setEnabled(r5);
        goto L4
    L6:
        OEditText r11 = this.J;
        r11.setEnabled(r5);
        t(r11.hasFocus());
        s(false);
    }

    public final void setErrorState(boolean r5) {
        this.f13294w = r5;
        t(this.J.hasFocus());
        s(false);
    }

    public final void setErrorTip(String r5) {
        this.B = r5;
        this.R.setText(r5);
    }

    public final void setHint(String r5) {
        this.f13297z = r5;
        this.J.setHint(r5);
        n("setHint");
    }

    public final void setInputHeight(int r5) {
        this.f13296y = Integer.valueOf(r5);
        OEditText r10 = this.J;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L7;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        ((ViewGroup.MarginLayoutParams) r12).height = r5;
        r10.setLayoutParams(r12);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setInputMode(int r10) {
        this.f13280h = r10;
        ImageView r5 = this.P;
        View r11 = this.N;
        View r12 = this.M;
        boolean r13 = false;
        View r14 = this.O;
        if (r10 == 0) goto L16;
        if (r10 != 1) goto L28;
        setSingleLine(true);
        com.lynx.tasm.utils.d.x(r14, true);
        if (r11.getVisibility() != 0) goto L10;
    L14:
        r13 = true;
    L15:
        com.lynx.tasm.utils.d.x(r12, r13);
        setComboInputEnabled(this.g);
        return;
    L10:
        if (r5.getVisibility() == 0) goto L14;
        if (r14.getVisibility() != 0) goto L15;
    L28:
        return;
    L16:
        com.lynx.tasm.utils.d.x(r14, false);
        if (r11.getVisibility() != 0) goto L20;
    L24:
        r13 = true;
    L25:
        com.lynx.tasm.utils.d.x(r12, r13);
        OEditText r15 = this.J;
        r15.setFocusable(true);
        r15.setFocusableInTouchMode(true);
        return;
    L20:
        if (r5.getVisibility() == 0) goto L24;
        if (r14.getVisibility() != 0) goto L25;
        goto L24
    }

    public final void setInputType(int r5) {
        if ((r5 & 1) == 0) goto L5;
    L11:
        this.A = r5;
        OEditText r10 = this.J;
        if (r5 != r10.getInputType()) goto L15;
        o(r10.getText());
        return;
    L15:
        r10.setInputType(this.A);
        v();
        o(r10.getText());
        return;
    L5:
        if ((r5 & 2) != 0) goto L11;
        if ((r5 & 3) != 0) goto L11;
        if ((r5 & 4) != 0) goto L11;
        r5 = r5 | 1;
        goto L11
    }

    public final void setIsInScrollableView(boolean r5) {
        this.f13286n = r5;
    }

    public final void setKeyListener(KeyListener r5) {
        this.J.setKeyListener(r5);
    }

    public final void setLabel(String r5) {
        this.f13293v = r5;
        this.H.setText(r5);
    }

    public final void setLeftView(Function1<? super FrameLayout, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "creator");
        FrameLayout r10 = this.K;
        r10.removeAllViews();
        r5.invoke(r10);
        if (r10.getChildCount() <= 0) goto L5;
        boolean r11 = true;
    L6:
        com.lynx.tasm.utils.d.x(r10, r11);
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void setLimitCount(int r5) {
        setLimitCountValue(r5);
        OEditText r10 = this.J;
        Editable r11 = r10.getText();
        if (r11 != null) goto L5;
        String r12 = null;
    L6:
        x(r12);
        o(r10.getText());
        return;
    L5:
        r12 = r11.toString();
        goto L6
    }

    public final void setLimitCountValue(int r5) {
        this.f13290r = r5;
    }

    public final void setMaxLines(int r5) {
        int r10 = 1;
        if (r5 >= 1) goto L5;
        r5 = Integer.MAX_VALUE;
    L5:
        this.f13282j = r5;
        if (this.f13281i == true) goto L9;
        r10 = r5;
    L9:
        this.J.setMaxLines(r10);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r5) {
        if (this.f13280h == 1) goto L5;
    L7:
        super.setOnClickListener(r5);
        return;
    L5:
        if (this.g == true) goto L7;
        this.O.setOnClickListener(r5);
        this.J.setOnClickListener(r5);
        goto L7
    }

    public final void setOnComboArrowClickListener(View.OnClickListener r5) {
        this.W = r5;
        this.O.setOnClickListener(r5);
        if (this.g == true) goto L9;
        View.OnClickListener r10 = this.W;
        if (r10 == null) goto L10;
        getVInput().setOnClickListener(r10);
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r5) {
        this.J.setOnFocusChangeListener(r5);
    }

    public final void setOnTextClearedListener(k r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
    }

    public final void setOnTextExceedLengthListener(l r5) {
    }

    public final void setRadius(int r5) {
        if (r5 != this.E) goto L5;
        return;
    L5:
        this.E = r5;
        this.F.setRadius(r5);
    }

    public final void setShowLabel(boolean r5) {
        this.s = r5;
        com.lynx.tasm.utils.d.x(this.G, r5);
        OEditText r10 = this.J;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L12;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        if (this.s == false) goto L8;
        int r13 = 16;
    L7:
        int r14 = com.lynx.tasm.utils.a.B(r13, this);
        r12.goneLeftMargin = r14;
        r12.goneStartMargin = r14;
        r10.setLayoutParams(r12);
        n("setShowLabel");
        return;
    L8:
        r13 = 12;
        goto L7
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setShowLabelAnim(boolean r5) {
        this.f13291t = r5;
        n("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r5) {
        this.f13292u = r5;
        com.lynx.tasm.utils.d.x(this.I, r5);
    }

    public final void setShowLimitIndicator(boolean r5) {
        this.f13289q = r5;
        Editable r10 = this.J.getText();
        if (r10 != null) goto L5;
        String r11 = null;
    L6:
        x(r11);
        return;
    L5:
        r11 = r10.toString();
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setSingleLine(boolean r15) {
        this.f13281i = r15;
        int r5 = getResources().getDimensionPixelSize(R$dimen.o_input_view_space_top_bottom);
        FrameLayout r10 = this.K;
        FrameLayout r11 = this.L;
        View r12 = this.M;
        View r13 = this.Q;
        ViewGroup.LayoutParams r14 = null;
        OEditText r16 = this.J;
        if (r15 == false) goto L40;
        com.lynx.tasm.utils.d.x(r13, false);
        r16.setMaxLines(1);
        r16.setSingleLine(true);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L39;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r17;
        ViewGroup.LayoutParams r19 = getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r19 = null;
    L9:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        if (r20 == null) goto L12;
        int r21 = r20.leftMargin;
    L13:
        ViewGroup.LayoutParams r110 = getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r14 = r110;
    L17:
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r14;
        if (r22 == null) goto L20;
        int r23 = r22.rightMargin;
    L21:
        r18.setMargins(r21, 0, r23, r5);
        r18.goneTopMargin = r5;
        if (this.s == false) goto L24;
        int r24 = com.lynx.tasm.utils.a.B(16, this);
    L25:
        r18.goneLeftMargin = r24;
        r18.goneStartMargin = r24;
        r16.setLayoutParams(r18);
        ViewGroup.LayoutParams r111 = r12.getLayoutParams();
        if (r111 == null) goto L37;
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r111;
        r112.topToTop = 0;
        r112.bottomToBottom = 0;
        r12.setLayoutParams(r112);
        ViewGroup.LayoutParams r113 = r11.getLayoutParams();
        if (r113 == null) goto L35;
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
        r114.topToTop = 0;
        r114.bottomToBottom = 0;
        r11.setLayoutParams(r114);
        ViewGroup.LayoutParams r115 = r10.getLayoutParams();
        if (r115 == null) goto L33;
        ConstraintLayout.LayoutParams r116 = (ConstraintLayout.LayoutParams) r115;
        r116.setMargins(com.lynx.tasm.utils.a.B(4, this), com.lynx.tasm.utils.a.B(4, this), 0, com.lynx.tasm.utils.a.B(4, this));
        r116.topToTop = 0;
        r116.bottomToBottom = 0;
        r10.setLayoutParams(r116);
    L89:
        n("setSingleLine");
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L37:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L24:
        r24 = com.lynx.tasm.utils.a.B(12, this);
        goto L25
    L20:
        r23 = 0;
        goto L21
    L12:
        r21 = 0;
        goto L13
    L39:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        com.lynx.tasm.utils.d.x(r13, this.f13288p);
        r16.setMaxLines(this.f13282j);
        r16.setSingleLine(false);
        r16.setPadding(getPaddingLeft(), com.lynx.tasm.utils.a.B(2, this), getPaddingRight(), getPaddingBottom());
        r16.setGravity(48);
        ViewGroup.LayoutParams r117 = r16.getLayoutParams();
        if (r117 == null) goto L98;
        ConstraintLayout.LayoutParams r118 = (ConstraintLayout.LayoutParams) r117;
        ViewGroup.LayoutParams r25 = getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == true) goto L45;
        r25 = null;
    L45:
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
        if (r26 == null) goto L48;
        int r27 = r26.leftMargin;
    L49:
        ViewGroup.LayoutParams r28 = getLayoutParams();
        if ((r28 instanceof ViewGroup.MarginLayoutParams) == true) goto L52;
        r28 = null;
    L52:
        ViewGroup.MarginLayoutParams r29 = (ViewGroup.MarginLayoutParams) r28;
        if (r29 == null) goto L55;
        int r30 = r29.rightMargin;
    L56:
        r118.setMargins(r27, 0, r30, com.lynx.tasm.utils.a.B(8, this));
        r118.goneTopMargin = com.lynx.tasm.utils.a.B(8, this);
        if (this.s == false) goto L59;
        int r31 = com.lynx.tasm.utils.a.B(16, this);
    L60:
        r118.goneLeftMargin = r31;
        r118.goneStartMargin = r31;
        r16.setLayoutParams(r118);
        ViewGroup.LayoutParams r119 = r12.getLayoutParams();
        if (r119 == null) goto L96;
        ConstraintLayout.LayoutParams r120 = (ConstraintLayout.LayoutParams) r119;
        r120.topToTop = 0;
        ViewGroup.LayoutParams r32 = getLayoutParams();
        if ((r32 instanceof ViewGroup.MarginLayoutParams) == true) goto L65;
        r32 = null;
    L65:
        ViewGroup.MarginLayoutParams r33 = (ViewGroup.MarginLayoutParams) r32;
        if (r33 == null) goto L68;
        int r34 = r33.leftMargin;
    L69:
        int r35 = com.lynx.tasm.utils.a.B(4, this);
        ViewGroup.LayoutParams r36 = getLayoutParams();
        if ((r36 instanceof ViewGroup.MarginLayoutParams) == true) goto L72;
        r36 = null;
    L72:
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r36;
        if (r37 == null) goto L75;
        int r38 = r37.rightMargin;
    L76:
        ViewGroup.LayoutParams r39 = getLayoutParams();
        if ((r39 instanceof ViewGroup.MarginLayoutParams) == false) goto L80;
        r14 = r39;
    L80:
        ViewGroup.MarginLayoutParams r40 = (ViewGroup.MarginLayoutParams) r14;
        if (r40 == null) goto L83;
        int r41 = r40.bottomMargin;
    L84:
        r120.setMargins(r34, r35, r38, r41);
        r120.bottomToBottom = -1;
        r12.setLayoutParams(r120);
        ViewGroup.LayoutParams r121 = r11.getLayoutParams();
        if (r121 == null) goto L94;
        ConstraintLayout.LayoutParams r122 = (ConstraintLayout.LayoutParams) r121;
        r122.topToTop = 0;
        r122.bottomToBottom = 0;
        r11.setLayoutParams(r122);
        ViewGroup.LayoutParams r123 = r10.getLayoutParams();
        if (r123 == null) goto L92;
        ConstraintLayout.LayoutParams r124 = (ConstraintLayout.LayoutParams) r123;
        r124.setMargins(com.lynx.tasm.utils.a.B(4, this), com.lynx.tasm.utils.a.B(4, this), 0, 0);
        r124.topToTop = 0;
        r124.bottomToBottom = -1;
        r10.setLayoutParams(r124);
        goto L89
    L92:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L94:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L83:
        r41 = 0;
        goto L84
    L75:
        r38 = 0;
        goto L76
    L68:
        r34 = 0;
        goto L69
    L96:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L59:
        r31 = com.lynx.tasm.utils.a.B(12, this);
        goto L60
    L55:
        r30 = 0;
        goto L56
    L48:
        r27 = 0;
        goto L49
    L98:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setText(String r5) {
        OEditText r10 = this.J;
        r10.setText(r5);
        n("setText");
        o(r10.getText());
    }

    public final void t(boolean r5) {
        int r10 = 0;
        if (this.f13295x == true) goto L5;
    L4:
        int r11 = com.lynx.tasm.utils.a.B(0, this);
    L10:
        OUIConstraintLayout r12 = this.F;
        r12.setBorderWidth(r11);
        if (this.f13295x == true) goto L14;
        r10 = com.lynx.tasm.utils.a.B(0, this);
    L18:
        if (r10 == 0) goto L21;
        r12.setBorderColor(ContextCompat.getColor(getContext(), r10));
        return;
    L21:
        return;
    L14:
        if (this.f13294w == false) goto L16;
        r10 = R$color.oui_functional_red_7;
        goto L18
    L16:
        if (r5 == false) goto L18;
        r10 = R$color.oui_basic_line_3;
        goto L18
    L5:
        if (r5 == false) goto L8;
        r11 = com.lynx.tasm.utils.a.B(2, this);
        goto L10
    L8:
        if (this.f13294w == false) goto L4;
        r11 = com.lynx.tasm.utils.a.C(this, 1.2d);
        goto L10
    }

    public final void u() {
        if (this.f13287o == true) goto L5;
        return;
    L5:
        boolean r5 = true;
        if (r() == false) goto L8;
    L19:
        boolean r10 = false;
    L20:
        View r11 = this.N;
        com.lynx.tasm.utils.d.x(r11, r10);
        ImageView r12 = this.P;
        if (r10 == false) goto L24;
        com.lynx.tasm.utils.d.x(r12, false);
    L24:
        if (r11.getVisibility() != 0) goto L27;
    L33:
        com.lynx.tasm.utils.d.x(this.M, r5);
        return;
    L27:
        if (r12.getVisibility() == 0) goto L33;
        if (this.O.getVisibility() == 0) goto L33;
        r5 = false;
        goto L33
    L8:
        if (this.f13280h != 0) goto L19;
        if (this.f13295x == false) goto L19;
        OEditText r13 = this.J;
        if (r13.hasFocus() == false) goto L19;
        Editable r14 = r13.getText();
        if (r14 == null) goto L19;
        if (r14.length() == 0) goto L19;
        r10 = true;
        goto L20
    }

    public final void v() {
        boolean r5 = true;
        if (r() == true) goto L5;
    L14:
        boolean r10 = false;
    L15:
        ImageView r11 = this.P;
        com.lynx.tasm.utils.d.x(r11, r10);
        View r12 = this.N;
        if (r10 == false) goto L19;
        com.lynx.tasm.utils.d.x(r12, false);
    L19:
        if (r12.getVisibility() != 0) goto L22;
    L28:
        com.lynx.tasm.utils.d.x(this.M, r5);
        return;
    L22:
        if (r11.getVisibility() == 0) goto L28;
        if (this.O.getVisibility() == 0) goto L28;
        r5 = false;
        goto L28
    L5:
        if (this.f13295x == false) goto L14;
        Editable r13 = this.J.getText();
        if (r13 == null) goto L14;
        if (r13.length() == 0) goto L14;
        if (this.f13277c0 == true) goto L14;
        r10 = true;
        goto L15
    }

    public final void w(LabelUIState r5, TextView r10, String r11) {
        ps.a.a("OInputView", "updateLabelUIState, state: " + r5 + ", scene: [" + r11 + ']');
        int r12 = m.f13343a[r5.ordinal()];
        OEditText r13 = this.J;
        LinearLayout r14 = this.G;
        if (r12 != 1) goto L5;
        r14.setVisibility(0);
        r10.setVisibility(8);
        r13.setAlpha(1.0f);
        return;
    L5:
        if (r12 != 2) goto L7;
        r14.setVisibility(4);
        r10.setVisibility(0);
        r13.setAlpha(0.0f);
        return;
    L7:
        if (r12 != 3) goto L15;
        r14.setVisibility(8);
        r10.setVisibility(8);
        r13.setAlpha(1.0f);
        return;
    }

    public final void x(String r10) {
        if (this.f13289q == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        OTextView r11 = this.T;
        com.lynx.tasm.utils.d.x(r11, r5);
        if (this.f13289q == true) goto L11;
        return;
    L11:
        if (this.f13290r <= 0) goto L18;
        int r12 = p(r10);
        SpannableString r13 = new SpannableString(getResources().getString(R$string.oui_form_counter, new Object[]{String.valueOf(r12), String.valueOf(this.f13290r)}));
        if (r12 <= this.f13290r) goto L15;
        r13.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R$color.oui_functional_red_7)), 0, String.valueOf(r12).length(), 18);
    L15:
        r11.setText(r13, TextView.BufferType.SPANNABLE);
        return;
    L18:
        return;
    L5:
        if (this.f13290r <= 0) goto L7;
        r5 = true;
        goto L8
    }

    @JvmOverloads
    public OInputView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OInputView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.oui.forms.OInputView$3, java.lang.Object, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.oui.forms.OInputView$4, java.lang.Object, kotlin.jvm.internal.Lambda] */
    @JvmOverloads
    public OInputView(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        int r5 = 1;
        this.g = true;
        this.f13281i = true;
        this.f13282j = Integer.MAX_VALUE;
        this.f13287o = true;
        this.f13288p = true;
        this.f13290r = -1;
        this.s = true;
        this.f13292u = true;
        this.f13295x = true;
        this.E = com.lynx.tasm.utils.a.B(10, this);
        TypedArray r14 = r11.getTheme().obtainStyledAttributes(r12, R$styleable.OInputView, r13, 0);
        this.f13286n = r14.getBoolean(R$styleable.OInputView_oui_inputInScrollableView, false);
        this.f13287o = r14.getBoolean(R$styleable.OInputView_oui_autoShowClear, true);
        this.f13288p = r14.getBoolean(R$styleable.OInputView_oui_showResizer, true);
        this.s = r14.getBoolean(R$styleable.OInputView_oui_showLabel, true);
        this.f13291t = r14.getBoolean(R$styleable.OInputView_oui_showLabelAnim, false);
        this.f13292u = r14.getBoolean(R$styleable.OInputView_oui_showLabelIcon, true);
        this.f13293v = r14.getString(R$styleable.OInputView_oui_inputLabel);
        this.B = r14.getString(R$styleable.OInputView_oui_errorTip);
        this.C = r14.getString(R$styleable.OInputView_oui_commonTip);
        boolean r15 = r14.getBoolean(R$styleable.OInputView_oui_showCommonTip, false);
        this.D = r15;
        this.E = r14.getDimensionPixelSize(R$styleable.OInputView_oui_inputBorderRadius, this.E);
        this.g = r14.getBoolean(R$styleable.OInputView_oui_comboInputEnabled, true);
        this.f13280h = r14.getInt(R$styleable.OInputView_oui_inputMode, 0);
        this.f13281i = r14.getBoolean(R$styleable.OInputView_oui_inputSingleLine, true);
        int r10 = r14.getDimensionPixelSize(R$styleable.OInputView_oui_inputHeight, 0);
        if (r10 <= 0) goto L5;
        this.f13296y = Integer.valueOf(r10);
    L5:
        this.f13290r = r14.getInt(R$styleable.OInputView_oui_limitCount, -1);
        this.f13289q = r14.getBoolean(R$styleable.OInputView_oui_showLimitIndicator, false);
        CharSequence r16 = r14.getText(R$styleable.OInputView_android_digits);
        this.f13297z = r14.getString(R$styleable.OInputView_android_hint);
        this.A = r14.getInt(R$styleable.OInputView_android_inputType, 0);
        String r17 = r14.getString(R$styleable.OInputView_android_text);
        this.f13295x = r14.getBoolean(R$styleable.OInputView_android_enabled, true);
        this.f13282j = r14.getInt(R$styleable.OInputView_android_maxLines, Integer.MAX_VALUE);
        r14.getInt(R$styleable.OInputView_android_orientation, 0);
        int r18 = r14.getInt(R$styleable.OInputView_android_gravity, 16);
        if (r14.hasValue(R$styleable.OInputView_android_ellipsize) == false) goto L21;
        int r19 = r14.getInt(R$styleable.OInputView_android_ellipsize, 0);
        if (r19 != 1) goto L10;
        TextUtils.TruncateAt r20 = TextUtils.TruncateAt.START;
    L20:
        this.f13283k = r20;
        goto L21
    L10:
        if (r19 != 2) goto L12;
        r20 = TextUtils.TruncateAt.MIDDLE;
        goto L20
    L12:
        if (r19 != 3) goto L14;
        r20 = TextUtils.TruncateAt.END;
        goto L20
    L14:
        if (r19 == 4) goto L16;
        r20 = null;
        goto L20
    L16:
        r20 = TextUtils.TruncateAt.MARQUEE;
    L21:
        r14.recycle();
        LayoutInflater.from(r11).inflate(getContentViewRes(), this);
        OUIConstraintLayout r110 = (OUIConstraintLayout) findViewById(R$id.o_input_border_container);
        this.F = r110;
        r110.setRadius(this.E);
        this.G = (LinearLayout) findViewById(R$id.o_input_title_container);
        this.H = (OTextView) findViewById(R$id.o_input_title);
        this.I = (ImageView) findViewById(R$id.o_input_title_icon);
        OEditText r111 = (OEditText) findViewById(R$id.o_input);
        this.J = r111;
        r111.setVerticalScrollBarEnabled(false);
        this.K = (FrameLayout) findViewById(R$id.o_input_left_view_container);
        this.L = (FrameLayout) findViewById(R$id.o_input_custom_action_container);
        this.M = findViewById(R$id.o_input_action_container);
        View r21 = findViewById(R$id.o_input_clear);
        this.N = r21;
        this.O = findViewById(R$id.o_input_combo_arrow);
        ImageView r22 = (ImageView) findViewById(R$id.o_input_eyes_slash);
        this.P = r22;
        this.Q = findViewById(R$id.o_input_resizer);
        OTextView r23 = (OTextView) findViewById(R$id.o_input_error_tip);
        this.R = r23;
        OTextView r24 = (OTextView) findViewById(R$id.o_input_common_tip);
        this.S = r24;
        this.T = (OTextView) findViewById(R$id.o_input_limit_indicator);
        this.U = (TextView) findViewById(R$id.o_input_view_fake_label);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        if (r16 == null) goto L27;
        r111.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r16)));
        int r25 = this.A;
        if (r25 == 0) goto L26;
        r5 = r25;
    L26:
        this.A = r5;
    L27:
        r111.setGravity(r18);
        Integer r26 = this.f13296y;
        if (r26 == null) goto L31;
        setInputHeight(r26.intValue());
    L31:
        ?? r27 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r27, "action");
        r111.f13245a.f13332a = r27;
        ?? r28 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r28, "action");
        r111.f13246b.f13334a = r28;
        Function4<CharSequence, Integer, Integer, Integer, Unit> r29 = new AnonymousClass5(this);
        Intrinsics.checkNotNullParameter(r29, "action");
        c r30 = r111.f13247c;
        r30.f13330b = r29;
        Function1<Editable, Unit> r31 = new AnonymousClass6(this);
        Intrinsics.checkNotNullParameter(r31, "action");
        r30.f13331c = r31;
        final int r32 = 0;
        r21.setOnClickListener(new j(this, r32));
        setCommonTip(this.C);
        com.lynx.tasm.utils.d.x(r24, r15);
        setErrorTip(this.B);
        com.lynx.tasm.utils.d.x(r23, false);
        setComboInputEnabled(this.g);
        setLabel(this.f13293v);
        setShowLabel(this.s);
        setShowLabelIcon(this.f13292u);
        setLimitCount(this.f13290r);
        setShowLimitIndicator(this.f13289q);
        setSingleLine(this.f13281i);
        setMaxLines(this.f13282j);
        setEllipsize(this.f13283k);
        setHint(this.f13297z);
        setText(r17);
        setInputMode(this.f13280h);
        setEnabled(this.f13295x);
        u();
        t(r111.hasFocus());
        int r112 = this.A;
        if (r112 == 0) goto L34;
        setInputType(r112);
    L34:
        v();
        final int r113 = 1;
        r22.setOnClickListener(new j(this, r113));
        final int r114 = 2;
        r110.setOnClickListener(new j(this, r114));
        n("init");
    }
}
