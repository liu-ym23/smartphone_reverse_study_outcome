package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.divider.ODivider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0003\u0011!\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0006J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u0010<\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0017\u0010?\u001a\u0002018\u0006¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u00105R\u0017\u0010B\u001a\u0002018\u0006¢\u0006\f\n\u0004\b@\u00103\u001a\u0004\bA\u00105R\u0017\u0010E\u001a\u0002018\u0006¢\u0006\f\n\u0004\bC\u00103\u001a\u0004\bD\u00105R\u0017\u0010K\u001a\u00020F8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0017\u0010Q\u001a\u00020L8\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010T\u001a\u00020F8\u0006¢\u0006\f\n\u0004\bR\u0010H\u001a\u0004\bS\u0010JR\u0017\u0010W\u001a\u00020L8\u0006¢\u0006\f\n\u0004\bU\u0010N\u001a\u0004\bV\u0010PR\u0017\u0010]\u001a\u00020X8\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0017\u0010c\u001a\u00020^8\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0017\u0010f\u001a\u00020^8\u0006¢\u0006\f\n\u0004\bd\u0010`\u001a\u0004\be\u0010bR\u0017\u0010i\u001a\u00020F8\u0006¢\u0006\f\n\u0004\bg\u0010H\u001a\u0004\bh\u0010JR\u0017\u0010l\u001a\u0002018\u0006¢\u0006\f\n\u0004\bj\u00103\u001a\u0004\bk\u00105R\u0017\u0010r\u001a\u00020m8\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0017\u0010u\u001a\u00020m8\u0006¢\u0006\f\n\u0004\bs\u0010o\u001a\u0004\bt\u0010qR\u0017\u0010x\u001a\u00020m8\u0006¢\u0006\f\n\u0004\bv\u0010o\u001a\u0004\bw\u0010qR%\u0010\u0080\u0001\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR(\u0010\u0084\u0001\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010{\u001a\u0005\b\u0082\u0001\u0010}\"\u0005\b\u0083\u0001\u0010\u007f¨\u0006\u0085\u0001"}, d2 = {"Lcom/obric/oui/forms/OLineInputView;", "Lcom/obric/oui/forms/AbsOForm;", "", "enabled", "", "setEnabled", "(Z)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setInputContainerBackground", "(Landroid/graphics/drawable/Drawable;)V", "", "getText", "()Ljava/lang/String;", MessageIndication.CONTENT_TYPE_TEXT, "setText", "(Ljava/lang/String;)V", "Lcom/obric/oui/forms/p;", "getConfig", "()Lcom/obric/oui/forms/p;", "flag", "setAutoHideClearWhenTextEmpty", "Landroid/view/View$OnFocusChangeListener;", "listener", "setEditTextOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Lcom/obric/oui/forms/r;", "textExceedLengthListener", "setTextExceedLengthListener", "(Lcom/obric/oui/forms/r;)V", "Lcom/obric/oui/forms/q;", "textClearedListener", "setTextClearedListener", "(Lcom/obric/oui/forms/q;)V", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "", "k", "I", "getArrangeDirection", "()I", "setArrangeDirection", "(I)V", "arrangeDirection", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", "Lcom/obric/oui/forms/OFormEditText;", "m", "Lcom/obric/oui/forms/OFormEditText;", "getEditText", "()Lcom/obric/oui/forms/OFormEditText;", "editText", "n", "getTvErrorTips", "tvErrorTips", "o", "getTvCounter", "tvCounter", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, "getTvAction", "tvAction", "Landroid/widget/ImageView;", "q", "Landroid/widget/ImageView;", "getIvClear", "()Landroid/widget/ImageView;", "ivClear", "Landroid/widget/LinearLayout;", "r", "Landroid/widget/LinearLayout;", "getIvClearContainer", "()Landroid/widget/LinearLayout;", "ivClearContainer", "s", "getIvAction", "ivAction", "t", "getIvActionContainer", "ivActionContainer", "Lcom/obric/oui/divider/ODivider;", "u", "Lcom/obric/oui/divider/ODivider;", "getDivider", "()Lcom/obric/oui/divider/ODivider;", "divider", "Landroid/widget/RelativeLayout;", "v", "Landroid/widget/RelativeLayout;", "getPrefixContainer", "()Landroid/widget/RelativeLayout;", "prefixContainer", "w", "getSuffixContainer", "suffixContainer", "x", "getIvTitleIcon", "ivTitleIcon", "y", "getTvInputTips", "tvInputTips", "Landroid/view/ViewGroup;", "z", "Landroid/view/ViewGroup;", "getTitleContainer", "()Landroid/view/ViewGroup;", "titleContainer", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getInputContainer", "inputContainer", "B", "getActionContainer", "actionContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "C", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getActiveBorderView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setActiveBorderView", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "activeBorderView", "D", "getLeftContainer", "setLeftContainer", "leftContainer", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OLineInputView extends AbsOForm {
    public static final /* synthetic */ int V = 0;
    public final ViewGroup A;
    public final ViewGroup B;
    public ConstraintLayout C;
    public ConstraintLayout D;
    public final String E;
    public p F;
    public s G;
    public final boolean H;
    public final int I;
    public final int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public final int S;
    public String T;
    public String U;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f13300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final OFormEditText f13301m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f13302n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f13303o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f13304p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f13305q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinearLayout f13306r;
    public final ImageView s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LinearLayout f13307t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ODivider f13308u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RelativeLayout f13309v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RelativeLayout f13310w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f13311x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TextView f13312y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ViewGroup f13313z;

    @JvmOverloads
    public OLineInputView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0, 14, 0);
    }

    public final void e() {
        com.lynx.tasm.utils.d.s(this.f13306r);
        com.lynx.tasm.utils.d.s(this.f13305q);
        this.F.f13351c = false;
    }

    public final ViewGroup getActionContainer() {
        return this.B;
    }

    public final ConstraintLayout getActiveBorderView() {
        return this.C;
    }

    public final int getArrangeDirection() {
        return this.f13299k;
    }

    public final p getConfig() {
        return this.F;
    }

    public final ODivider getDivider() {
        return this.f13308u;
    }

    public final OFormEditText getEditText() {
        return this.f13301m;
    }

    public final ViewGroup getInputContainer() {
        return this.A;
    }

    @Override // com.obric.oui.forms.AbsOForm
    public EditText getInterEditText() {
        return this.f13301m;
    }

    public final ImageView getIvAction() {
        return this.s;
    }

    public final LinearLayout getIvActionContainer() {
        return this.f13307t;
    }

    public final ImageView getIvClear() {
        return this.f13305q;
    }

    public final LinearLayout getIvClearContainer() {
        return this.f13306r;
    }

    public final ImageView getIvTitleIcon() {
        return this.f13311x;
    }

    public final ConstraintLayout getLeftContainer() {
        return this.D;
    }

    public final RelativeLayout getPrefixContainer() {
        return this.f13309v;
    }

    public final RelativeLayout getSuffixContainer() {
        return this.f13310w;
    }

    public final String getText() {
        return String.valueOf(this.f13301m.getText());
    }

    public final ViewGroup getTitleContainer() {
        return this.f13313z;
    }

    public final TextView getTvAction() {
        return this.f13304p;
    }

    public final TextView getTvCounter() {
        return this.f13303o;
    }

    public final TextView getTvErrorTips() {
        return this.f13302n;
    }

    public final TextView getTvInputTips() {
        return this.f13312y;
    }

    public final TextView getTvTitle() {
        return this.f13300l;
    }

    public final void n() {
        com.lynx.tasm.utils.d.s(this.f13302n);
        this.f13308u.setStyle(0);
        TextView r5 = this.f13312y;
        if (r5.getText().length() <= 0) goto L5;
        p(r5.getText().toString());
    L5:
        this.L = false;
    }

    public final void o() {
        String r5 = this.F.f13349a;
        TextView r10 = this.f13300l;
        if (r5 != null) goto L5;
    L8:
        this.K = false;
    L9:
        boolean r11 = this.K;
        ImageView r12 = this.f13311x;
        ViewGroup r13 = this.f13313z;
        if (r11 == false) goto L16;
        com.lynx.tasm.utils.d.t(r10);
        if (r13.getVisibility() == 0) goto L15;
        com.lynx.tasm.utils.d.t(r13);
    L15:
        this.K = true;
    L21:
        Drawable r14 = this.F.s;
        if (r14 == null) goto L25;
        r12.setImageDrawable(r14);
        this.R = true;
    L25:
        if (this.R == true) goto L27;
        com.lynx.tasm.utils.d.s(r12);
        if (r10.getVisibility() == 0) goto L34;
    L35:
        com.lynx.tasm.utils.d.s(r13);
    L36:
        this.R = false;
    L37:
        int r15 = this.I;
        if (r15 == 0) goto L42;
        if (r15 == 1) goto L41;
        ViewGroup.LayoutParams r16 = r12.getLayoutParams();
        r16.width = com.lynx.tasm.utils.a.B(10, this);
        r16.height = com.lynx.tasm.utils.a.B(10, this);
        r12.setLayoutParams(r16);
    L43:
        boolean r17 = this.F.f13364u;
        OFormEditText r18 = this.f13301m;
        if (r17 == false) goto L46;
        s r19 = new s(this, 1);
        getTextWatchers().add(new WeakReference(r19));
        r18.addTextChangedListener(r19);
    L46:
        p r20 = this.F;
        if (r20.f13350b == false) goto L52;
        if (r20.g == null) goto L52;
        this.G = new s(this, 0);
        ArrayList<WeakReference<TextWatcher>> r21 = getTextWatchers();
        s r22 = this.G;
        Intrinsics.checkNotNull(r22);
        r21.add(new WeakReference(r22));
        r18.addTextChangedListener(this.G);
        com.lynx.tasm.utils.d.t(this.f13303o);
    L52:
        if (this.F.f13351c == true) goto L54;
        e();
        final int r23 = 0;
        r18.setOnFocusChangeListener(new o(this, r23));
    L58:
        String r24 = this.F.d;
        if (r24 != null) goto L61;
    L64:
        View r25 = this.F.e;
        RelativeLayout r26 = this.f13309v;
        if (r25 == null) goto L67;
        r26.removeAllViews();
        r26.addView(this.F.e, new ConstraintLayout.LayoutParams(-2, -2));
        com.lynx.tasm.utils.d.t(r26);
        this.N = true;
    L67:
        View r27 = this.F.f;
        RelativeLayout r110 = this.f13310w;
        if (r27 == null) goto L70;
        r110.removeAllViews();
        r110.addView(this.F.f, new ConstraintLayout.LayoutParams(-2, -2));
        com.lynx.tasm.utils.d.t(r110);
        this.O = true;
    L70:
        p r28 = this.F;
        if (r28.f13363t == false) goto L73;
        r28.f13352h = false;
    L73:
        boolean r29 = r28.f13352h;
        ODivider r30 = this.f13308u;
        if (r29 == false) goto L76;
        com.lynx.tasm.utils.d.t(r30);
        this.F.f13352h = true;
    L77:
        String r31 = this.F.f13353i;
        TextView r111 = this.f13304p;
        if (r31 == null) goto L93;
        if (r31.length() == 0) goto L93;
        r111.setText(this.F.f13353i);
        Integer r32 = this.F.f13361q;
        if (r32 == null) goto L85;
        Intrinsics.checkNotNull(r32);
        r111.setTextColor(r32.intValue());
    L86:
        p r33 = this.F;
        if (r33.f13356l == false) goto L91;
        View.OnClickListener r34 = r33.f13358n;
        if (r34 == null) goto L91;
        r111.setOnClickListener(r34);
    L91:
        com.lynx.tasm.utils.d.t(r111);
        this.P = true;
        goto L93
    L85:
        r111.setTextColor(ContextCompat.getColor(getContext(), R$color.TextPrimary));
    L93:
        if (this.F.f13354j == null) goto L95;
        ArrayList<WeakReference<TextWatcher>> r35 = getTextWatchers();
        TextWatcher r112 = this.F.f13354j;
        Intrinsics.checkNotNull(r112);
        r35.add(new WeakReference(r112));
        r18.addTextChangedListener(this.F.f13354j);
    L95:
        Drawable r36 = this.F.f13357m;
        ImageView r113 = this.s;
        if (r36 == null) goto L106;
        r113.setImageDrawable(r36);
        View.OnClickListener r37 = this.F.f13359o;
        if (r37 == null) goto L101;
        r113.setOnClickListener(r37);
    L101:
        if (r113.getVisibility() == 0) goto L104;
        com.lynx.tasm.utils.d.t(r113);
    L104:
        this.Q = true;
    L106:
        if (TextUtils.isEmpty(this.F.f13360p) == true) goto L108;
        String r38 = this.F.f13360p;
        Intrinsics.checkNotNull(r38);
        p(r38);
    L108:
        Integer r39 = this.F.f13362r;
        ViewGroup r114 = this.A;
        if (r39 == null) goto L115;
        ViewGroup.LayoutParams r40 = r114.getLayoutParams();
        if (r40 == null) goto L114;
        ConstraintLayout.LayoutParams r41 = (ConstraintLayout.LayoutParams) r40;
        Integer r115 = this.F.f13362r;
        Intrinsics.checkNotNull(r115);
        ((ViewGroup.MarginLayoutParams) r41).height = r115.intValue();
        r114.setLayoutParams(r41);
    L129:
        if (this.F.f13365v == false) goto L131;
        r18.setSingleLine(false);
        r18.setLines(this.S);
    L132:
        String r42 = this.E;
        if (r42 == null) goto L139;
        if (r42.length() == 0) goto L139;
        setText(r42);
    L139:
        if (this.H == true) goto L141;
    L147:
        r18.setGravity(this.J);
        View.OnFocusChangeListener r43 = this.F.f13355k;
        if (r43 == null) goto L151;
        Intrinsics.checkNotNull(r43);
        setEditTextOnFocusChangeListener(r43);
    L151:
        if (this.K == false) goto L157;
        com.lynx.tasm.utils.d.t(r10);
        if (r13.getVisibility() == 0) goto L156;
        com.lynx.tasm.utils.d.t(r13);
    L156:
        this.K = true;
    L162:
        boolean r44 = this.L;
        TextView r45 = this.f13312y;
        if (r44 == false) goto L171;
        String r46 = this.T;
        Intrinsics.checkNotNull(r46);
        if (r46 == null) goto L173;
        TextView r47 = this.f13302n;
        com.lynx.tasm.utils.d.t(r47);
        r47.setText(r46);
        r30.setBackgroundColor(ContextCompat.getColor(getContext(), R$color.Primary));
        Intrinsics.checkNotNullParameter(r45, "<this>");
        if (r45.getVisibility() != 0) goto L170;
        com.lynx.tasm.utils.d.s(r45);
        this.M = false;
    L170:
        this.L = true;
        this.T = r46;
    L173:
        if (this.M == false) goto L175;
        String r48 = this.U;
        Intrinsics.checkNotNull(r48);
        p(r48);
    L177:
        if (this.N == false) goto L179;
        com.lynx.tasm.utils.d.t(r26);
        boolean r49 = true;
        this.N = true;
    L181:
        if (this.O == false) goto L183;
        com.lynx.tasm.utils.d.t(r110);
        this.O = r49;
    L185:
        if (this.P == false) goto L187;
        com.lynx.tasm.utils.d.t(r111);
        this.P = r49;
    L189:
        if (this.Q == false) goto L196;
        if (r113.getVisibility() == 0) goto L194;
        com.lynx.tasm.utils.d.t(r113);
    L194:
        this.Q = true;
    L199:
        int r50 = this.F.f13366w;
        if (r50 != 2) goto L202;
        r18.setFocusable(true);
        r18.setFocusableInTouchMode(true);
        r18.setOnClickListener(null);
        setOnClickListener(null);
        return;
    L202:
        if (r50 != 3) goto L210;
        r18.setFocusable(false);
        r18.setFocusableInTouchMode(false);
        r18.setOnClickListener(this.F.f13359o);
        setOnClickListener(this.F.f13359o);
        return;
    L210:
        return;
    L196:
        if (r113.getVisibility() != 0) goto L198;
        com.lynx.tasm.utils.d.s(r113);
    L198:
        this.Q = false;
        goto L199
    L187:
        com.lynx.tasm.utils.d.s(r111);
        this.P = false;
        goto L189
    L183:
        com.lynx.tasm.utils.d.s(r110);
        this.O = false;
        goto L185
    L179:
        r49 = true;
        com.lynx.tasm.utils.d.s(r26);
        this.N = false;
        goto L181
    L175:
        com.lynx.tasm.utils.d.s(r45);
        this.M = false;
        goto L177
    L171:
        n();
        goto L173
    L157:
        com.lynx.tasm.utils.d.s(r10);
        if (r12.getVisibility() == 0) goto L161;
        com.lynx.tasm.utils.d.s(r13);
    L161:
        this.K = false;
        goto L162
    L141:
        if (this.F.s != null) goto L147;
        if (r13.getVisibility() == 0) goto L146;
        com.lynx.tasm.utils.d.t(r13);
    L146:
        com.lynx.tasm.utils.d.t(r12);
        this.R = true;
        goto L147
    L131:
        r18.setSingleLine(true);
        goto L132
    L114:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L115:
        ViewGroup.LayoutParams r51 = r114.getLayoutParams();
        if (r51 == null) goto L208;
        ConstraintLayout.LayoutParams r52 = (ConstraintLayout.LayoutParams) r51;
        int r116 = getArrangeDirection();
        if (r116 == 1) goto L124;
        if (r116 == 2) goto L122;
        int r53 = com.lynx.tasm.utils.a.B(40, this);
    L127:
        ((ViewGroup.MarginLayoutParams) r52).height = r53;
        r114.setLayoutParams(r52);
        goto L129
    L122:
        r53 = com.lynx.tasm.utils.a.B(40, this);
        goto L127
    L124:
        if (this.F.f13363t == false) goto L126;
        r53 = com.lynx.tasm.utils.a.B(36, this);
        goto L127
    L126:
        r53 = com.lynx.tasm.utils.a.B(52, this);
        goto L127
    L208:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L76:
        com.lynx.tasm.utils.d.s(r30);
        this.F.f13352h = false;
        goto L77
    L61:
        if (r24.length() == 0) goto L64;
        r18.setHint(this.F.d);
        goto L64
    L54:
        ar.a r54 = new ar.a(this, 17);
        ImageView r55 = this.f13305q;
        r55.setOnClickListener(r54);
        if (TextUtils.isEmpty(r18.getText()) == false) goto L57;
        com.lynx.tasm.utils.d.s(r55);
        com.lynx.tasm.utils.d.s(this.f13306r);
    L57:
        final int r56 = 1;
        r18.setOnFocusChangeListener(new o(this, r56));
        r18.setOnTouchListener(new com.bytedance.ai.widget.contianer.a(this, 2));
        goto L58
    L41:
        ViewGroup.LayoutParams r57 = r12.getLayoutParams();
        r57.width = com.lynx.tasm.utils.a.B(16, this);
        r57.height = com.lynx.tasm.utils.a.B(16, this);
        r12.setLayoutParams(r57);
        goto L43
    L42:
        ViewGroup.LayoutParams r58 = r12.getLayoutParams();
        r58.width = com.lynx.tasm.utils.a.B(10, this);
        r58.height = com.lynx.tasm.utils.a.B(10, this);
        r12.setLayoutParams(r58);
        goto L43
    L34:
        if (TextUtils.isEmpty(r10.getText()) == false) goto L36;
    L27:
        if (r13.getVisibility() == 0) goto L30;
        com.lynx.tasm.utils.d.t(r13);
    L30:
        com.lynx.tasm.utils.d.t(r12);
        this.R = true;
        goto L37
    L16:
        com.lynx.tasm.utils.d.s(r10);
        if (r12.getVisibility() == 0) goto L20;
        com.lynx.tasm.utils.d.s(r13);
    L20:
        this.K = false;
        goto L21
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r10.setText(this.F.f13349a);
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int r5 = com.lynx.tasm.utils.a.B(44, this);
        int r10 = com.lynx.tasm.utils.a.B(44, this);
        ViewGroup r11 = this.B;
        com.lynx.tasm.utils.d.n(r10, r11);
        com.lynx.tasm.utils.d.p(r11, r5, r5, new View[]{this.f13304p, this.s});
    }

    public final void p(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        TextView r10 = this.f13312y;
        r10.setText(r5);
        com.lynx.tasm.utils.d.t(r10);
        if (this.f13302n.getVisibility() != 0) goto L7;
        n();
    L7:
        this.M = true;
        this.U = r5;
    }

    public final void q(p r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        this.F = r5;
        Iterator<WeakReference<TextWatcher>> r10 = getTextWatchers().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        TextWatcher r11 = r10.next().get();
        this.f13301m.removeTextChangedListener(r11);
        goto L4
    L6:
        o();
    }

    public final void setActiveBorderView(ConstraintLayout r5) {
        this.C = r5;
    }

    public final void setArrangeDirection(int r5) {
        this.f13299k = r5;
    }

    public final void setAutoHideClearWhenTextEmpty(boolean r5) {
        p r10 = getConfig();
        r10.f13364u = r5;
        q(r10);
    }

    public final void setEditTextOnFocusChangeListener(View.OnFocusChangeListener r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.f13301m.setOnFocusChangeListener(r5);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        this.f13301m.setEnabled(r5);
        super.setEnabled(r5);
    }

    public final void setInputContainerBackground(Drawable r5) {
        Intrinsics.checkNotNullParameter(r5, "drawable");
        this.A.setBackground(r5);
    }

    public final void setLeftContainer(ConstraintLayout r5) {
        this.D = r5;
    }

    public final void setText(String r5) {
        if (r5 == null) goto L8;
        this.f13301m.setText(r5);
        s r10 = this.G;
        if (r10 == null) goto L9;
        r10.onTextChanged(r5, 0, 0, r5.length());
        return;
    L9:
        return;
    }

    public final void setTextClearedListener(q r5) {
        Intrinsics.checkNotNullParameter(r5, "textClearedListener");
        this.F.getClass();
    }

    public final void setTextExceedLengthListener(r r5) {
        Intrinsics.checkNotNullParameter(r5, "textExceedLengthListener");
        this.F.getClass();
    }

    public final void setTextWatcher(TextWatcher r5) {
        this.F.f13354j = r5;
        o();
    }

    @JvmOverloads
    public OLineInputView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, 12, 0);
    }

    @JvmOverloads
    public OLineInputView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, 8, 0);
    }

    public OLineInputView(Context r10, AttributeSet r11, int r12, int r13, int r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f13299k = 1;
        String r15 = Constant.TITLE;
        Intrinsics.checkNotNullParameter("标题", Constant.TITLE);
        p r5 = new p();
        r5.f13349a = "标题";
        r5.f13350b = false;
        r5.f13351c = false;
        r5.d = null;
        r5.e = null;
        r5.f = null;
        r5.g = null;
        r5.f13352h = true;
        r5.f13353i = null;
        r5.f13354j = null;
        r5.f13355k = null;
        r5.f13356l = false;
        r5.f13357m = null;
        r5.f13358n = null;
        r5.f13359o = null;
        r5.f13360p = null;
        r5.f13361q = null;
        r5.f13362r = null;
        r5.s = null;
        r5.f13363t = false;
        r5.f13364u = false;
        r5.f13365v = false;
        r5.f13366w = 2;
        r5.f13367x = true;
        this.F = r5;
        this.J = 16;
        this.K = true;
        this.S = 20;
        this.T = "";
        this.U = "";
        TypedArray r16 = r10.getTheme().obtainStyledAttributes(r11, R$styleable.OLineInputView, r12, 0);
        setArrangeDirection(r16.getInt(R$styleable.OLineInputView_oui_formArrangeDirection, 0));
        String r17 = r16.getString(R$styleable.OLineInputView_oui_formTitle);
        p r18 = this.F;
        if (r17 == null) goto L12;
        r15 = r17;
    L12:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r18.f13349a = r15;
        this.F.f13351c = r16.getBoolean(R$styleable.OLineInputView_oui_formShowClear, true);
        this.F.d = r16.getString(R$styleable.OLineInputView_android_hint);
        this.F.f13350b = r16.getBoolean(R$styleable.OLineInputView_oui_formShowCounter, false);
        int r19 = r16.getInt(R$styleable.OLineInputView_oui_formLengthLimit, 0);
        if (r19 <= 0) goto L15;
        p r110 = this.F;
        r110.g = Integer.valueOf(r19);
    L15:
        int r20 = r16.getDimensionPixelSize(R$styleable.OLineInputView_oui_formInputHeight, 0);
        if (r20 <= 0) goto L18;
        p r111 = this.F;
        r111.f13362r = Integer.valueOf(r20);
    L18:
        p r21 = this.F;
        r21.f13365v = r16.getBoolean(R$styleable.OLineInputView_oui_formMultiLine, false);
        this.F.f13352h = r16.getBoolean(R$styleable.OLineInputView_oui_formShowDivider, true);
        this.F.f13360p = r16.getString(R$styleable.OLineInputView_oui_formInputTips);
        this.E = r16.getString(R$styleable.OLineInputView_android_text);
        this.H = r16.getBoolean(R$styleable.OLineInputView_oui_formShowTitleDefaultIcon, false);
        this.I = r16.getInt(R$styleable.OLineInputView_oui_formTitleDefaultIconSize, 0);
        this.J = r16.getInt(R$styleable.OLineInputView_android_gravity, 16);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        int r22 = this.f13299k;
        if (r22 == 0) goto L25;
        if (r22 == 1) goto L24;
        if (r22 == 2) goto L23;
        int r23 = R$layout.o_form_line_input_vertical;
    L26:
        LayoutInflater.from(r10).inflate(r23, this);
        this.f13300l = (TextView) findViewById(R$id.tv_title);
        OFormEditText r24 = (OFormEditText) findViewById(R$id.et_input);
        this.f13301m = r24;
        this.f13302n = (TextView) findViewById(R$id.tv_error_tips);
        this.f13303o = (TextView) findViewById(R$id.tv_counter);
        this.f13304p = (TextView) findViewById(R$id.tv_action);
        this.f13305q = (ImageView) findViewById(R$id.iv_clear);
        this.s = (ImageView) findViewById(R$id.iv_action);
        this.f13308u = (ODivider) findViewById(R$id.divider);
        this.f13311x = (ImageView) findViewById(R$id.iv_title_icon);
        this.f13309v = (RelativeLayout) findViewById(R$id.prefix_container);
        this.f13310w = (RelativeLayout) findViewById(R$id.suffix_container);
        this.f13312y = (TextView) findViewById(R$id.tv_input_tips);
        this.f13313z = (ViewGroup) findViewById(R$id.title_container);
        this.A = (ViewGroup) findViewById(R$id.input_container);
        this.D = (ConstraintLayout) findViewById(R$id.left_container);
        this.B = (ViewGroup) findViewById(R$id.action_container);
        this.C = (ConstraintLayout) findViewById(R$id.active_border_view);
        this.f13306r = (LinearLayout) findViewById(R$id.iv_clear_container);
        this.f13307t = (LinearLayout) findViewById(R$id.iv_action_container);
        q(this.F);
        r24.setVerticalScrollBarEnabled(false);
        return;
    L23:
        r23 = R$layout.o_form_line_input_vertical_single_box;
        goto L26
    L24:
        r23 = R$layout.o_form_line_input_horizontal;
        goto L26
    L25:
        r23 = R$layout.o_form_line_input_vertical;
        goto L26
    }
}
